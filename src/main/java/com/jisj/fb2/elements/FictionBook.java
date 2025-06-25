package com.jisj.fb2.elements;

import com.jisj.fb2.annotation.Attribute;
import com.jisj.fb2.annotation.BookElement;
import com.jisj.fb2.annotation.ChildElement;
import org.w3c.dom.Document;

import java.util.List;

/**
 * Root fiction book element
 *
 * @see <a href=http://fictionbook.org/index.php/%D0%AD%D0%BB%D0%B5%D0%BC%D0%B5%D0%BD%D1%82_FictionBook>FictionBook element</a>
 */
@BookElement(tag = "FictionBook", attr = {
        @Attribute(name = "xmlns", value = "http://www.gribuser.ru/xml/fictionbook/2.0"),
        @Attribute(name = "xmlns:xlink", value = "http://www.w3.org/1999/xlink")},
        children = {
                @ChildElement(tag = "stylesheet", order = 1, occurrence = "0..*"),
                @ChildElement(tag = "description", order = 2, occurrence = "1"),
                @ChildElement(tag = "body", order = 3, occurrence = "1..*"),
                @ChildElement(tag = "binary", order = 4, occurrence = "0..*")
        }
)
public class FictionBook extends BaseElement{

    /**
     * Creates wrapper for FictionBook DOM Document
     * @param document book Document
     */
    public FictionBook(Document document) {
        super(document.getDocumentElement());
    }

    /**
     * Gets &lt;description&gt; element
     *
     * @return {@code Description} object | {@code null} if the element is absent
     */
    public Description getDescription() {
        return getElementByTag("description")
                .map(Description::new)
                .orElseThrow(()-> new IllegalStateException("Element: <description> not found"));
    }

    /**
     * Gets the list of &lt;body&gt; element from FictionBook
     * @return list of Body objects
     */
    public List<BaseElement> getBody() {
        return getElementsByTag("body").stream()
                .map(BaseElement::new)//TODO replace by providerClass from annotation
                .toList();
    }

    /**
     * Gets the list of &lt;binary&gt; element from FictionBook
     * @return list of Binary objects
     */

    public List<BaseElement> getBinary() {
        return getElementsByTag("binary").stream()
                .map(BaseElement::new) //TODO replace by providerClass from annotation
                .toList();
    }
}
