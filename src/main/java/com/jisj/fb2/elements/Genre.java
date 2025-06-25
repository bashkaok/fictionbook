package com.jisj.fb2.elements;

import com.jisj.fb2.annotation.Attribute;
import com.jisj.fb2.annotation.BookElement;
import org.w3c.dom.Element;

/**
 * @see <a href="http://fictionbook.org/index.php/%D0%AD%D0%BB%D0%B5%D0%BC%D0%B5%D0%BD%D1%82_genre">&lt;genre> element</a>
 */
@BookElement(tag = "genre", attr = @Attribute(name = "match"))
public class Genre extends BaseElement {
    public Genre(Element element) {
        super(element);
    }

    /**
     * Gets the value of match attribute
     *
     * @return string value of match. If match is empty - returns '100' (%)
     */
    public String getMatch() {
        return getElement().getAttribute("match").isEmpty() ? "100" : getElement().getAttribute("match");
    }

    /**
     * Sets the value of math attribute.
     *
     * @param match value from 1..100
     * @throws IllegalArgumentException when the value is not from 1..100
     */
    public void setMatch(int match) {
        if (match < 1 || match > 100)
            throw new IllegalArgumentException("Expected the value of 1..100");
        getElement().setAttribute("match", Integer.toString(match));
    }
}
