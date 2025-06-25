package elements;

import com.jisj.fb2.elements.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import com.jisj.fb2.utils.DocumentReader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FictionBookTest {
    private static final Path sourceFB2 = Path.of("src/test/resources/fb2test.fb2");
    static FictionBook fb;

    @BeforeAll
    static void setUp() throws IOException, SAXException {
        Document doc = DocumentReader.read(sourceFB2);
        assertNotNull(doc);
        fb = new FictionBook(doc);
        assertNotNull(fb);
    }

    @Test
    void getDescription() {
        Description dsc = fb.getDescription();
        assertNotNull(dsc);
    }

    @Test
    void getBody() {
        List<BaseElement> body = fb.getBody();
        assertEquals(2, body.size());
    }

    @Test
    void getBinary() {
        List<BaseElement> binary = fb.getBinary();
        assertEquals(5, binary.size());
    }

    @Nested
    class TitleInfoTest {
        private static TitleInfo ti;

        @BeforeAll
        static void setUp() {
            ti = fb.getDescription().getTitleinfo();
            assertNotNull(ti);
        }

        @Test
        void getGenres() {
            assertEquals(2, ti.getGenres().size());
            assertEquals("sf", ti.getGenres().getFirst().getTextContent());
            assertEquals("computers", ti.getGenres().getLast().getTextContent());
            assertEquals("20", ti.getGenres().getLast().getMatch());
            Genre sf = ti.getGenres().getFirst();
            sf.setMatch(50);
            assertEquals("50", sf.getMatch());
        }

        @Test
        void getAuthors() {
            assertEquals(1, ti.getAuthors().size());
            Author a = ti.getAuthors().getFirst();
            assertEquals("Дмитрий", a.getFirstName());
            assertEquals("Петрович", a.getMiddleName());
            assertEquals("Грибов", a.getLastName());
            assertEquals("Grib", a.getNickname());
            assertEquals("http://www.gribuser.ru", a.getHomePage());
            assertEquals("grib@gribuser.ru", a.getEmail());
            assertEquals("123-456-789", a.getId());
        }

        @Test
        void getBookAttribs() {
            assertEquals("Тестовый ознакомительный документ FictionBook 2.1", ti.getBookTitle());
            assertEquals("2004", ti.getDate());
            assertEquals("ru", ti.getLang());
            assertEquals("en", ti.getSrcLang());
        }
    }

    @Nested
    class PublishInfoTest {
        private static PublishInfo pi;

        @BeforeAll
        static void setUp() {
            pi = fb.getDescription().getPublishInfo();
            assertNotNull(pi);
        }

    }



}