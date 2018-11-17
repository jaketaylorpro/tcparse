package com.github.jaketaylorpro.tcparse.core.identifier

import com.github.jaketaylorpro.tcparse.core.TableOfContentsSource
import org.apache.poi.xwpf.usermodel.IBodyElement
import org.apache.poi.xwpf.usermodel.XWPFTable

object TextTableOfContentsIdentifier {
    fun identify(bodyElements: List<IBodyElement>): TableOfContentsSource.TextContents? {
        return null
    }
}