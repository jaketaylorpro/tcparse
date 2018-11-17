package com.github.jaketaylorpro.tcparse.core

import org.apache.poi.xwpf.usermodel.XWPFParagraph
import org.apache.poi.xwpf.usermodel.XWPFTable

sealed class TableOfContentsSource {
    object None : TableOfContentsSource()
    data class SimpleTable(val tableElement: XWPFTable) : TableOfContentsSource()
    data class PagedTables(val tableElements: List<XWPFTable>) : TableOfContentsSource()
    data class TextContents(val paragraphs: List<XWPFParagraph>) : TableOfContentsSource()
}