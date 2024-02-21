package com.example.manageauthor.model;

public class DTOAssignment {
    private int id;
    private String dateStart;
    private String dateEnd;
    private String note;
    private String namePost;
    private String nameAuthor;
    private int price;

    public DTOAssignment() {
    }

    public DTOAssignment(int id, String dateStart, String dateEnd, String note, String namePost, String nameAuthor, int price) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.note = note;
        this.namePost = namePost;
        this.nameAuthor = nameAuthor;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNamePost() {
        return namePost;
    }

    public void setNamePost(String namePost) {
        this.namePost = namePost;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
