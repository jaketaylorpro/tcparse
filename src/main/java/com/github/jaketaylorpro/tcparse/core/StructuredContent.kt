package com.github.jaketaylorpro.tcparse.core

import org.apache.poi.xwpf.usermodel.IBodyElement

data class StructuredContent(val tableOfContentsRow: StructuredTableOfContentsRow, val bodyElements: List<IBodyElement>, val pageNumber: Int?, val children:List<StructuredContent>) {
}