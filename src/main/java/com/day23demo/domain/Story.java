package com.day23demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stories")
public class Story {

    @Id
    private String id;
    private String url;
    private String headline;
    private String text;
    private String startDate;
    private Asset asset;

    public Story() {
        // TODO Auto-generated constructor stub
    }

    public Story(String url, String headline, String text, String startDate, Asset asset) {
        this.headline = headline;
        this.text = text;
        this.startDate = startDate;
        this.asset = asset;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
    
    public String getHeadline() {
        return headline;
    }

    public String getText() {
        return text;
    }

    public String getStartDate() {
        return startDate;
    }

    public Asset getAsset() {
        return asset;
    }

}