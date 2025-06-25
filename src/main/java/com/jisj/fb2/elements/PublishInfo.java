package com.jisj.fb2.elements;

import com.jisj.fb2.annotation.BookElement;
import org.w3c.dom.Element;


/**
 * The wrapper for &lt;publish-info&gt; element
 * @see <a href=http://fictionbook.org/index.php/%D0%AD%D0%BB%D0%B5%D0%BC%D0%B5%D0%BD%D1%82_publish-info>publish-info</a>
 */
@BookElement(tag = "publish-info")
public class PublishInfo extends BaseElement {

    private static final String TAG_BOOK_NAME   = "book-name";
    private static final String TAG_PUBLISHER   = "publisher";
    private static final String TAG_CITY        = "city";
    private static final String TAG_YEAR        = "year";
    private static final String TAG_ISBN        = "isbn";
    private static final String TAG_SEQUENCE    = "sequence";

    public PublishInfo(Element element) {
        super(element);
    }

    public String getBookName() {
        return getTextContent(TAG_BOOK_NAME);
    }

    public void setBookName(String bookName) {
        throw new RuntimeException("Not implemented");
    }

    public String getPublisher() {
        return getTextContent(TAG_PUBLISHER);
    }

    public void setPublisher(String publisher) {
        throw new RuntimeException("Not implemented");
    }

    public String getCity() {
        return getTextContent(TAG_CITY);
    }

    public void setCity(String city) {
        throw new RuntimeException("Not implemented");
    }

    public String getYear() {
        return getTextContent(TAG_YEAR);
    }

    public void setYear(String year) {
        throw new RuntimeException("Not implemented");
    }

    public String getISBN() {
        return getTextContent(TAG_ISBN);
    }

    public void setISBN(String isbn) {
        throw new RuntimeException("Not implemented");
    }

    public String getSequence() {
        return getTextContent(TAG_SEQUENCE);
    }

    public void setSequence(String sequence) {
        throw new RuntimeException("Not implemented");
    }

}
