package com.academy.Ruslana_Kichkailo.homework4.entity;

import java.util.List;

public class Journal {

    private String title;
    private Contacts contacts;
    private List<Article> articles;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
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
