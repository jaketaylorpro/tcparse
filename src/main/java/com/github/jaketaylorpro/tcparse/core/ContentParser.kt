package com.github.jaketaylorpro.tcparse.core

import org.apache.poi.xwpf.usermodel.IBodyElement

object ContentParser {
    fun parseContent(structuredTableOfContents: List<StructuredTableOfContentsRow>, bodyElements: List<IBodyElement>): List<StructuredContent> {
        throw NotImplementedError()
    }
}