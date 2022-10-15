package com.academy.Ruslana_Kichkailo.homework4.entity;

import java.util.List;
import java.util.Objects;

public class Journal {

    private String title;
    private List<String> contacts;
    private List<Article> articles;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getContacts() {
        return contacts;
    }

    public void setContacts(List<String> contacts) {
        this.contacts = contacts;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Journal journal = (Journal) o;
        return Objects.equals(title, journal.title) && Objects.equals(contacts, journal.contacts) && Objects.equals(articles, journal.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, contacts, articles);
    }

    @Override
    public String toString() {
        return "Journal{" +
                "title='" + title + '\'' +
                ", contacts=" + contacts +
                ", articles=" + articles +
                '}';
    }
}
