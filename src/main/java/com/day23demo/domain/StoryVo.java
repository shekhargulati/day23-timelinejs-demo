package com.day23demo.domain;

public class StoryVo {

    private String image;
    private String text;
    private String title;
    
    public StoryVo() {
    }

    public StoryVo(String image, String text, String title) {
        super();
        this.image = image;
        this.text = text;
        this.title = title;
    }
    
    public String getImage() {
        return image;
    }
    
    public String getText() {
        return text;
    }
    
    public String getTitle() {
        return title;
    }
    
}
