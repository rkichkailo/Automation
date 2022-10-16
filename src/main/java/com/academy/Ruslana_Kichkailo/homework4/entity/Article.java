package com.academy.Ruslana_Kichkailo.homework4.entity;

import java.util.List;

public class Article {
    private String  id;
    private String title;
    private String author;
    private String url;
    List <String> hotkeys;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setHotkeys(List<String> hotkeys) {
        this.hotkeys = hotkeys;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", hotkeys=" + hotkeys +
                '}';
    }
}
