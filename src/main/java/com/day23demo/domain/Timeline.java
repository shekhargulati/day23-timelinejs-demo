package com.day23demo.domain;

import java.util.List;


public class Timeline {

    private String headline ;
    private final String type = "default";
    private String text;
    private String startDate;
    
    private List<Story> date;
    
    public Timeline() {
        // TODO Auto-generated constructor stub
    }
    
    

    public Timeline(String headline, String text, String startDate, List<Story> story) {
        super();
        this.headline = headline;
        this.text = text;
        this.startDate = startDate;
        this.date = story;
    }



    public String getHeadline() {
        return headline;
    }

    public String getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public String getStartDate() {
        return startDate;
    }

    public List<Story> getDate() {
        return date;
    }
    
}
