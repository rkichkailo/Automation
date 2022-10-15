package com.academy.Ruslana_Kichkailo.homework4.entity;

import java.util.List;
import java.util.Objects;

public class Article {
    private String title;
    private String author;
    private String url;
    List <String> hotkeys;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getHotkeys() {
        return hotkeys;
    }

    public void setHotkeys(List<String> hotkeys) {
        this.hotkeys = hotkeys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title) && Objects.equals(author, article.author) && Objects.equals(url, article.url) && Objects.equals(hotkeys, article.hotkeys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, url, hotkeys);
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", hotkeys=" + hotkeys +
                '}';
    }
}
