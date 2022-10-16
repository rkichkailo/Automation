package com.academy.Ruslana_Kichkailo.homework4.parsers.dom;

import com.academy.Ruslana_Kichkailo.homework4.entity.Article;
import com.academy.Ruslana_Kichkailo.homework4.entity.Contacts;
import com.academy.Ruslana_Kichkailo.homework4.entity.Journal;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DOMParserDemo {

    private static final String XML_PATH = "journal.xml";
    private static final Journal journal = new Journal();

    private static void setJournalDataWithXMLChildNodeValues(NodeList nodeList){
        DOMParserUtils.getNodeListStream(nodeList).forEach(node -> {
            if (node instanceof Element) {
                switch (node.getNodeName()) {
                    case "title" -> journal.setTitle(node.getTextContent());
                    case "contacts" -> journal.setContacts(setContactsWithXMLNodeValues(node));
                    case "articles" -> journal.setArticles(setArticlesWithXMLNodeValues(node));
                }
            }
        });
    }

    private static Contacts setContactsWithXMLNodeValues(Node node){
        Contacts contacts = new Contacts();
        NodeList childNodes = node.getChildNodes();
        DOMParserUtils.getNodeListStream(childNodes).forEach(childNode -> {
            if (childNode instanceof Element) {
                setContactsWithXMLChildNodeValues(contacts, childNode);
            }
        });
        return contacts;
    }

    private static void setContactsWithXMLChildNodeValues(Contacts contacts, Node node){
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        switch (node.getNodeName()) {
            case "address" -> contacts.setAddress(content);
            case "tel" -> contacts.setTel(content);
            case "email" -> contacts.setEmail(content);
            case "url" -> contacts.setUrl(content);
        }
    }

    private static List<Article> setArticlesWithXMLNodeValues(Node articlesNode){
        List <Article> articles = new ArrayList<>();
        NodeList articlesChildNodes = articlesNode.getChildNodes();
        DOMParserUtils.getNodeListStream(articlesChildNodes).forEach(node -> {
            if (node instanceof Element) {
                Article article = new Article();
                article.setId(node.getAttributes().
                        getNamedItem("ID").getNodeValue());

                NodeList childNodes = node.getChildNodes();
                DOMParserUtils.getNodeListStream(childNodes).forEach(childNode -> {
                    if (childNode instanceof Element) {
                        setArticleWithXMLChildNodeValues(article, childNode);
                    }
                });
                articles.add(article);
            }
        });
        return articles;
    }

    private static void setArticleWithXMLChildNodeValues(Article article, Node node) {
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        switch (node.getNodeName()) {
            case "title" -> article.setTitle(content);
            case "author" -> article.setAuthor(content);
            case "url" -> article.setUrl(content);
            case "hotkeys" -> article.setHotkeys(setHotkeysToArticleWithXMLChildNodeValues(node));
        }
    }

    private static List <String> setHotkeysToArticleWithXMLChildNodeValues(Node hotkeysNode){
        List <String> hotkeys = new ArrayList<>();
        NodeList hotkeysChildNodes = hotkeysNode.getChildNodes();
        DOMParserUtils.getNodeListStream(hotkeysChildNodes).forEach(node -> {
            if (node instanceof Element) {
                hotkeys.add(node.getTextContent());
            }
        });
        return hotkeys;
    }

    public static void main(String[] args) {
        Document document = DOMParserUtils.parseXMLDocument(XML_PATH);
        NodeList nodeList = DOMParserUtils.getNodeList(document);
        setJournalDataWithXMLChildNodeValues(nodeList);
        System.out.println(journal);
    }
}
