package com.academy.Ruslana_Kichkailo.homework4.parsers.stax;

import com.academy.Ruslana_Kichkailo.homework4.entity.Article;
import com.academy.Ruslana_Kichkailo.homework4.entity.Contacts;
import com.academy.Ruslana_Kichkailo.homework4.entity.Journal;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StaxParserDemo {

    private static final String XML_PATH = "journal.xml";
    private static Journal journal = null;
    private static Contacts contacts = null;
    private static Article currentArticle = null;
    private static List<Article> articles = null;
    private static List<String> hotkeys = null;
    private static String tagContent = null;

    private static void setJournalDataWithXMLStreamReader(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()){
            int event = reader.next();
            switch (event){
                case XMLStreamConstants.START_ELEMENT -> checkXMLStartElement(reader);
                case XMLStreamConstants.CHARACTERS -> tagContent = reader.getText().trim();
                case XMLStreamConstants.END_ELEMENT -> checkXMLEndElement(reader);
            }
        }
    }

    private static void checkXMLStartElement(XMLStreamReader reader){
        switch (reader.getLocalName()){
            case "journal" -> journal = new Journal();
            case "contacts" -> contacts = new Contacts();
            case "articles" -> articles = new ArrayList<>();
            case "article" -> {
                currentArticle = new Article();
                currentArticle.setId(reader.getAttributeValue(0));
                articles.add(currentArticle);
            }
            case "hotkeys" -> hotkeys = new ArrayList<>();
        }
    }

    private static void checkXMLEndElement(XMLStreamReader reader){
        switch (reader.getLocalName()){
            case "title" -> {
                if (isArticleNull()) {
                    journal.setTitle(tagContent);
                } else {
                    currentArticle.setTitle(tagContent);
                }
            }
            case "address" -> contacts.setAddress(tagContent);
            case "tel" -> contacts.setTel(tagContent);
            case "email" -> contacts.setEmail(tagContent);
            case "url" -> {
                if (isArticleNull()) {
                    contacts.setUrl(tagContent);
                } else {
                    currentArticle.setUrl(tagContent);
                }
            }
            case "contacts" -> journal.setContacts(contacts);
            case "author" -> currentArticle.setAuthor(tagContent);
            case "hotkey" -> hotkeys.add(tagContent);
            case "hotkeys" -> {
                currentArticle.setHotkeys(hotkeys);
                hotkeys = null;
            }
            case "article" -> currentArticle = null;
            case "articles" -> journal.setArticles(articles);
        }
    }

    private static boolean isArticleNull(){
        return currentArticle == null;
    }
    public static void main(String[] args) throws XMLStreamException {

        XMLStreamReader reader = StaxParserUtils.createXMLStreamReader(XML_PATH);
        setJournalDataWithXMLStreamReader(reader);
        System.out.println(journal);
    }
}
