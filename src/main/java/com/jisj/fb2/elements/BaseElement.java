package com.jisj.fb2.elements;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.List;
import java.util.Optional;

import static com.jisj.fb2.utils.DOMUtils.toList;


/**
 * Base element - wrapper for DOM Element
 */
public class BaseElement {
    private final Element element;

    public BaseElement(Element element) {
        this.element = element;
    }

    /**
     * DOM Element
     *
     * @return current DOM top Element
     */
    public Element getElement() {
        return element;
    }


    /**
     * Finds the Element by tag name
     *
     * @param tag name of Element tag
     * @return found Element
     * @throws IllegalStateException when too many elements found
     */
    protected Optional<Element> getElementByTag(String tag) {
        NodeList found = getElement().getElementsByTagName(tag);
        if (found.getLength() > 1)
            throw new IllegalStateException("Too many elements: <" + tag + "> found in <" + getElement().getTagName() + ">");
        return found.getLength() == 0 ? Optional.empty() : Optional.of((Element) found.item(0));
    }

    /**
     * Finds the all occurrences of Element by tag name
     *
     * @param tag name of Element tag
     * @return found Element List
     */
    protected List<Element> getElementsByTag(String tag) {
        NodeList found = getElement().getElementsByTagName(tag);
        return toList(found);
    }

    /**
     * Wrapper for {@code Node.getTextContent()}
     *
     * @return Node text value
     */
    public String getTextContent() {
        return getElement().getTextContent();
    }

    /**
     * Gets the textContent for Element with tag
     *
     * @param tag name of tag
     * @return value of Element textContent | empty String if the specified tag is not found
     */
    protected String getTextContent(String tag) {
        return getElementByTag(tag)
                .map(Element::getTextContent)
                .orElse("");
    }

}
