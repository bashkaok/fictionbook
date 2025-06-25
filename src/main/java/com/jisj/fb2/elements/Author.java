package com.jisj.fb2.elements;

import com.jisj.fb2.annotation.BookElement;
import com.jisj.fb2.annotation.ChildElement;
import org.w3c.dom.Element;


/**
 * @see <a href="http://fictionbook.org/index.php/%D0%AD%D0%BB%D0%B5%D0%BC%D0%B5%D0%BD%D1%82_author">FB2 &lt;author></a>
 */
@BookElement(tag = "author", children = {
        @ChildElement(tag = "first-name", order = 1),
        @ChildElement(tag = "middle-name", optional = true, order = 2),
        @ChildElement(tag = "last-name", order = 3),
        @ChildElement(tag = "nickname", optional = true, order = 4),
        @ChildElement(tag = "home-page", order = 5),
        @ChildElement(tag = "email", order = 6),
        @ChildElement(tag = "id", order = 7, occurrence = "0..1")
})
public class Author extends BaseElement {

    public Author(Element element) {
        super(element);
    }

    /**
     * Gets text value of &lt;id&gt; element
     * @return text
     */
    public String getId() {
        return getTextContent("id");
    }

//    public void setId(String id) {
//        createNodeIfNotExist(getSchemaElement("id"));
//        setTextContent("id", id);
//    }

    public String getFirstName() {
        return getTextContent("first-name");
    }

//    public void setFirstName(String firstName) {
//        setTextContent("first-name", firstName);
//    }

    public String getMiddleName() {
        return getTextContent("middle-name");
    }

//    public void setMiddleName(String middleName) {
//        createNodeIfNotExist(getSchemaElement("middle-name"));
//        setTextContent("middle-name", middleName);
//    }

    public String getLastName() {
        return getTextContent("last-name");
    }

//    public void setLastName(String lastName) {
//        setTextContent("last-name", lastName);
//    }

    public String getNickname() {
        return getTextContent("nickname");
    }

//    public void setNickname(String nickname) {
//        createNodeIfNotExist(getSchemaElement("nickname"));
//        setTextContent("nickname", nickname);
//    }

    public String   getEmail() {
        return getTextContent("email");
    }

//    public void     setEmail(String email) {
//        createNodeIfNotExist(getSchemaElement("email"));
//        setTextContent("email", email);
//    }

    public String   getHomePage() {
        return getTextContent("home-page");
    }

//    public void     setHomePage(String homePage) {
//        createNodeIfNotExist(getSchemaElement("home-page"));
//        setTextContent("home-page", homePage);
//    }
}
