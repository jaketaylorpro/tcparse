package com.github.jaketaylorpro.tcparse.core

import org.apache.poi.xwpf.usermodel.XWPFDocument
import java.io.InputStream

class Document(private val data: InputStream) {
    fun load() =
            LoadedDocument()
    inner class LoadedDocument internal constructor() {
        private val doc = data.use { XWPFDocument(it) }
        private val bodyElements = doc.bodyElements.toList()
        fun determineContents() =
                DeterminedLoadedDocument(
                        TableOfContentsSourceIdentifier.getTableOfContentsType(bodyElements))

        inner class DeterminedLoadedDocument internal constructor(val tableOfContentsSource: TableOfContentsSource) {
            fun parseTableOfContents() =
                    TableParsedDeterminedLoadedDocument(
                        TableOfContentsSourceParser.parseTableOfContents(tableOfContentsSource))

            inner class TableParsedDeterminedLoadedDocument internal constructor(val structuredTableOfContents: List<StructuredTableOfContentsRow>) {
                fun parseContent() =
                        FullyParsedDocument(
                                ContentParser.parseContent(structuredTableOfContents,bodyElements)
                        )
                inner class FullyParsedDocument internal constructor(val structuredContents: List<StructuredContent>) {

                }
            }
        }
    }
}