package com.example.manageauthor.model;

public class Assignment {
    private int id;
    private int price;
    private int idPost;
    private int idAuthor;

    public Assignment() {
    }

    public Assignment(int id, int price, int idPost, int idAuthor) {
        this.id = id;
        this.price = price;
        this.idPost = idPost;
        this.idAuthor = idAuthor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
