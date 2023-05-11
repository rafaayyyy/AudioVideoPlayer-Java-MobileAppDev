package com.example.audiovideoplayer;

import java.io.Serializable;

public class VideoClass implements Serializable {
    Integer id;
    String name, url;

    public VideoClass() {
        this.id = null;
        this.name = null;
        this.url = null;
    }

    public VideoClass(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
