package com.jisj.fb2.utils;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Static methods for DOM objects
 */
public class DOMUtils {

    /**
     * Maps {@code NodeList} to {@code List<Element>}
     *
     * @param nodeList NodeList object
     * @return List of Element object
     */
    public static List<Element> toList(NodeList nodeList) {
        List<Element> result = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            result.add((Element) nodeList.item(i));
        }
        return result;
    }
}
