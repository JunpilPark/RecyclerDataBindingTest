package com.fasoo.digitalpage.recyclerdatabindingtest.model;

public class Movie {
    private String title;
    private String characters;
    private String summaryStory;
    private String imageUrl;

    public Movie(String title, String characters, String summaryStory, String imageUrl) {
        this.title = title;
        this.characters = characters;
        this.summaryStory = summaryStory;
        this.imageUrl = imageUrl;
    }

    public Movie(String title, String characters, String summaryStory) {
         this(title, characters, summaryStory, null);
    }

    public String getTitle() {
        return title;
    }

    public String getCharacters() {
        return characters;
    }

    public String getSummaryStory() {
        return summaryStory;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
