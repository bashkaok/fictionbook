package com.jisj.fb2.elements;

import com.jisj.fb2.annotation.BookElement;
import com.jisj.fb2.annotation.ChildElement;
import org.w3c.dom.Element;

import java.util.List;

/**
 * &lt;title-info&gt; element
 *
 * @see <a href="http://fictionbook.org/index.php/%D0%AD%D0%BB%D0%B5%D0%BC%D0%B5%D0%BD%D1%82_title-info">FB2 &lt;title-info&gt; element</a>
 */
@BookElement(tag = "title-info", children = {
        @ChildElement(tag = "genre", order = 1, occurrence = "1..*", wrapperClass = Genre.class),
        @ChildElement(tag = "author", order = 2, occurrence = "1..*", wrapperClass = Author.class),
        @ChildElement(tag = "book-title", order = 3),
        @ChildElement(tag = "date", order = 6, occurrence = "0..1"),
        @ChildElement(tag = "lang", order = 8),
        @ChildElement(tag = "src-lang", order = 9, optional = true)
})
public class TitleInfo extends BaseElement {

    public TitleInfo(Element element) {
        super(element);
    }

    /**
     * Gets all &lt;genre> elements from &lt;title-info&gt;
     *
     * @return List of found {@code Genre} objects
     */
    public List<Genre> getGenres() {
        return getElementsByTag("genre").stream()
                .map(Genre::new)
                .toList();
    }

    /**
     * Gets all &lt;author&gt; elements from &lt;title-info&gt;
     *
     * @return List of found {@code Author} objects
     */
    public List<Author> getAuthors() {
        return getElementsByTag("author").stream()
                .map(Author::new)
                .toList();
    }

    /*
            public GenreElement addGenre(String genre) throws UniqueValueConstraint {
                if (isValueExist(TAG.GENRE, genre)){
                    throw new UniqueValueConstraint( TAG.GENRE, genre);
                }
                AbstractFBElement genreElement = (AbstractFBElement) BookBuilder.newBookBuilder(getNode().getOwnerDocument())
                        .createElement(GenreElement.class);
                genreElement.setTextContent(genre);
                insertChildBefore(TAG.AUTHOR, genreElement);
                return (GenreElement) genreElement;
            }

            public void removeGenre(String genre) throws FBException {
                Optional<GenreElement> foundGenre = getGenres().stream()
                        .filter(genreElement -> genreElement.getValue().equalsIgnoreCase(genre))
                        .findFirst();
                if (foundGenre.isPresent()) {
                    removeGenre(foundGenre.get());
                }
            }

            public void removeGenre(GenreElement genre) throws FBException {
                if (getGenres().size() <= 1) throw new FBException(getNodeName(), "Min count of <genre> element is 1");
                getNode().removeChild(genre.getNode());
                getChildren().remove(genre);
            }

            public void addAuthor(AuthorElement.AuthorRec author) {
                AuthorElement authorElement = (AuthorElement) BookBuilder.newBookBuilder(getNode().getOwnerDocument())
                        .createElement(AuthorElement.class);
                authorElement.setAuthor(author);
                super.insertChildBefore(TAG.BOOK_TITLE, authorElement);
            }

            public void removeAuthor(AuthorElement.AuthorRec author) throws FBException {
                Optional<AuthorElement> found = getAuthors().stream()
                        .filter(authorElement -> authorElement.getAuthor().equals(author))
                        .findFirst();
                if (found.isPresent()) {
                    removeAuthor(found.get());
                }
            }

            public void removeAuthor(AuthorElement author) throws FBException {
                if (getAuthors().size() <= 1) throw new FBException(getNodeName(), "Min count of <author> element is 1");
                getNode().removeChild(author.getNode());
                getChildren().remove(author);
            }
    */
    public String getBookTitle() {
        return getTextContent("book-title");
    }

    public String getDate() {
        return getTextContent("date");
    }

//        public void setBookTitle(String value) {
//            setTextContent(TAG.BOOK_TITLE, value);
//        }

    /**
     * Gets the book language
     * @return language
     */
    public String getLang() {
        return getTextContent("lang");
    }

    /**
     * Gets original book language
     * @return language
     */
    public String getSrcLang() {
        return getTextContent("src-lang");
    }


//        public void setLanguage(String value) {
//            setTextContent(TAG.LANG, value);
//        }
}
