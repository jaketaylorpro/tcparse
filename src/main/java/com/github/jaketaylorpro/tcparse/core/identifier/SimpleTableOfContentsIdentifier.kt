package com.github.jaketaylorpro.tcparse.core.identifier

import com.github.jaketaylorpro.tcparse.core.TableOfContentsSource
import me.xdrop.fuzzywuzzy.FuzzySearch
import org.apache.poi.xwpf.usermodel.IBodyElement
import org.apache.poi.xwpf.usermodel.XWPFTable
import org.apache.poi.xwpf.usermodel.XWPFTableCell

object SimpleTableOfContentsIdentifier {
    fun identify(bodyElements: List<IBodyElement>): TableOfContentsSource.SimpleTable? {
        return bodyElements
                // get only tables
                .filterIsInstance<XWPFTable>()
                // get only tables that have more than one row with more than one column with text in it
                .filter { t -> t.rows.count { r -> r.tableCells.count { c -> getCellText(c).isNotBlank() } > 1 } > 1 }
                // score each table
                .mapIndexed { i, t -> t to score(t, i) }
                // return the table with the max score or null if none has > 20
                .filter { (t, score) -> score > 15 }
                .maxBy { (t, score) -> score }
                ?.first?.let { TableOfContentsSource.SimpleTable(it) }
    }

    private fun score(t: XWPFTable, i: Int): Int {
        return (10 / (i + 1)) + t.rows.count { r ->
            (r.tableCells.firstOrNull()?.let { getCellText(it) } ?: "").toLowerCase().let { text ->
                listOf("section", "article", "provision").any { keyword -> FuzzySearch.partialRatio(keyword, text) > 75 }
            }
        }
    }

    private fun getCellText(c: XWPFTableCell): String {
        return c.paragraphs.foldRight("") { p, acc -> acc + (p.paragraphText ?: "") }
    }
}