package com.softwify.libraryapp.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "textbook")
public class Textbook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private int authorId;
    private int isbn;
    private String editor;
    private Date publicationDate;

    public Textbook(int id, String title, int authorId, int isbn, String editor, Date publicationDate) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
        this.isbn = isbn;
        this.editor = editor;
        this.publicationDate = publicationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
}
