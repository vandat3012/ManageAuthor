package com.example.manageauthor.model;

public class Assignment {
    private int id;
    private String dateStart;
    private String dateEnd;
    private String note;
    private int idPost;
    private int idAuthor;

    public Assignment() {
    }

    public Assignment(int id, String dateStart, String dateEnd, String note, int idPost, int idAuthor) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.note = note;
        this.idPost = idPost;
        this.idAuthor = idAuthor;
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

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }
}
