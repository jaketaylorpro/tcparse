package com.github.jaketaylorpro.tcparse.core

import com.github.jaketaylorpro.tcparse.core.identifier.PagedTableOfContentsIdentifier
import com.github.jaketaylorpro.tcparse.core.identifier.SimpleTableOfContentsIdentifier
import com.github.jaketaylorpro.tcparse.core.identifier.TextTableOfContentsIdentifier
import org.apache.poi.xwpf.usermodel.IBodyElement

object TableOfContentsSourceIdentifier {
    fun getTableOfContentsType(bodyElements: List<IBodyElement>): TableOfContentsSource {
        return SimpleTableOfContentsIdentifier.identify(bodyElements)
                ?: PagedTableOfContentsIdentifier.identify(bodyElements)
                ?: TextTableOfContentsIdentifier.identify(bodyElements)
                ?: TableOfContentsSource.None
    }
}