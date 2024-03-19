package com.mbala.librarymanagement.model;

public class Book {
    private String name;
    private int id;
    private String author;
    private String publication;
    private int edition;
    private String journer;
    private int availableCount;
    private int volume;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }
    public void setPublication(String publication) {
        this.publication = publication;
    }
    public String getPublication() {
        return publication;
    }
    public void setEdition(int edition) {
        this.edition = edition;
    }
    public int getEdition() {
        return edition;
    }
    public void setJourner(String journer) {
        this.journer = journer;
    }
    public String getJourner() {
        return journer;
    }
    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }
    public int getAvailableCount() {
        return availableCount;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }
    public int getVolume() {
        return volume;
    }
}
