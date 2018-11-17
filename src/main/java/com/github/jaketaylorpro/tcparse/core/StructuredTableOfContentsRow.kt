package com.github.jaketaylorpro.tcparse.core

data class StructuredTableOfContentsRow(val number:TableOfContentsNumber, val title:String, val pageNumber: Int?, val children:List<StructuredTableOfContentsRow>) {
}