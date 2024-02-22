package com.api.model;

import javax.persistence.*;

@Entity
@Table(name = "FileInfo")
public class FileInfo {
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
