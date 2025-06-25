package com.jisj.fb2.elements;

import com.jisj.fb2.annotation.BookElement;
import com.jisj.fb2.annotation.ChildElement;
import org.w3c.dom.Element;


/**
 * &lt;document-info> element
 * @see <a href=http://fictionbook.org/index.php/%D0%AD%D0%BB%D0%B5%D0%BC%D0%B5%D0%BD%D1%82_document-info>FB2 &lt;document-info> element</a>
 */
@BookElement(tag = "document-info", children = {
        @ChildElement(tag = "author", order = 1),
        @ChildElement(tag = "id", order = 6),
        @ChildElement(tag = "version", order = 7)
})
public class DocumentInfo extends BaseElement {

    public DocumentInfo(Element element) {
        super(element);
    }

    public void setId(String id) {
        throw new UnsupportedOperationException();
//        createNodeIfNotExist(getSchemaElement("id"));
//        setTextContent(getSchemaElement("id"), id);
    }

    public String getId() {
        throw new UnsupportedOperationException();
//        return getTextContent("id");
    }
}
