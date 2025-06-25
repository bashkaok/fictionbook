package com.jisj.fb2.utils;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Static methods for DOM Document reading
 */
public class DocumentReader {
    /**
     * Reads the {@code Document} from specified file
     * @param file document file
     * @return new DOM {@code Document} object
     * @throws IOException If any IO errors occur.
     * @throws SAXException If any parse errors occur.
     * @throws IllegalArgumentException When file is null
     */
    public static Document read(Path file) throws IOException, SAXException {
        DocumentBuilder builder;
        Document document;
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = builder.parse(file.toFile());
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        return document;
    }
}
