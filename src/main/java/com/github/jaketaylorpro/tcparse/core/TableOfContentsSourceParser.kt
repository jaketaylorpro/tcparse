package com.github.jaketaylorpro.tcparse.core

import com.github.jaketaylorpro.tcparse.core.parser.PagedTableOfContentsParser
import com.github.jaketaylorpro.tcparse.core.parser.SimpleTableOfContentsParser
import com.github.jaketaylorpro.tcparse.core.parser.TextTableOfContentsParser

object TableOfContentsSourceParser {
    fun parseTableOfContents(tableOfContentsSource: TableOfContentsSource): List<StructuredTableOfContentsRow> {
        return when(tableOfContentsSource) {
            is TableOfContentsSource.None -> listOf()
            is TableOfContentsSource.SimpleTable -> SimpleTableOfContentsParser.parse(tableOfContentsSource)
            is TableOfContentsSource.PagedTables -> PagedTableOfContentsParser.parse(tableOfContentsSource)
            is TableOfContentsSource.TextContents -> TextTableOfContentsParser.parse(tableOfContentsSource)
        }
    }
}