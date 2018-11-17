package com.github.jaketaylorpro.tcparse.core

import java.nio.file.Files
import java.nio.file.Paths
import kotlin.test.Test


class SimpleTableTest {
    @Test
    fun doc2() {
        val doc = Document(Files.newInputStream(Paths.get("src/test/examples/2.docx")))
                .load()
                .determineContents()
                .parseTableOfContents()
        doc.structuredTableOfContents

    }
}