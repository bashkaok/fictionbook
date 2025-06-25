package utils;

import com.jisj.fb2.utils.DocumentReader;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class DocumentReaderTest {
    private static final Path sourceFB2 = Path.of("src/test/resources/fb2test.fb2");

    @Test
    void read_from_file() throws IOException, SAXException {
        Document doc = DocumentReader.read(sourceFB2);
        assertNotNull(doc);
    }
}