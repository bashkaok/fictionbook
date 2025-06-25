package com.jisj.fb2.elements;

import com.jisj.fb2.annotation.BookElement;
import com.jisj.fb2.annotation.ChildElement;
import org.w3c.dom.Element;

/**
 * The wrapper for &lt;description&gt; element
 *
 * @see <a href=http://fictionbook.org/index.php/%D0%AD%D0%BB%D0%B5%D0%BC%D0%B5%D0%BD%D1%82_description> Description element</a>
 */
@BookElement(tag = "description", children = {
        @ChildElement(tag = "title-info", order = 1),
        @ChildElement(tag = "src-title-info", order = 2, optional = true),
        @ChildElement(tag = "document-info", order = 3),
        @ChildElement(tag = "publish-info", order = 4, optional = true),
        @ChildElement(tag = "custom-info", order = 5, optional = true),
        @ChildElement(tag = "output", order = 6, optional = true)})

public class Description extends BaseElement{
    public Description(Element element) {
        super(element);
    }

    /**
     * Gets &lt;title-info&gt; element
     *
     * @return {@code TitleInfo} object | {@code null} if the element is absent
     */
    public TitleInfo getTitleinfo() {
        return getElementByTag("title-info")
                .map(TitleInfo::new)
                .orElseThrow(()-> new IllegalStateException("Element: <title-info> not found"));
    }

    /**
     * Gets &lt;publish-info&gt; element
     *
     * @return {@code PublishInfo} object | {@code null} if the element is absent
     */
    public PublishInfo getPublishInfo() {
        return getElementByTag("publish-info")
                .map(PublishInfo::new)
                .orElseThrow(()-> new IllegalStateException("Element: <publish-info> not found"));
    }
}
