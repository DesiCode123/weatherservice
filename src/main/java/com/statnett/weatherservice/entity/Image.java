package com.statnett.weatherservice.entity;
/*
import jakarta.persistence.*;
*/
import java.time.LocalDateTime;

//@Entity
//@Table(name="Image")

public class Image {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)


    private String title;

    private String link;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }



    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public LocalDateTime getPubDate() {
        return pubDate;
    }

    public void setPubDate(LocalDateTime pubDate) {
        this.pubDate = pubDate;
    }

    private String category;

    private String guid;

    private LocalDateTime pubDate;
}
