package com.whisky.henallux.whisky.model;

public class Translation {
    private String description;
    private Integer whisky;
    private String language;

    public Translation(){}

    public Integer getWhisky() { return whisky; }
    public String getDescription() { return description; }
    public String getLanguage() { return language; }

    public void setDescription(String description) { this.description = description; }
    public void setLanguage(String language) { this.language = language; }
    public void setWhisky(Integer whisky) { this.whisky = whisky; }
}
