package com.example.bookstore.bookDTO;

import javax.persistence.*;

@Entity
@Table(name = "tbl_Book")
public class BookStore {
    @Id
    @Column(name = "bookID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookID;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @Column(name = "author")
    private String author;

    @Column(name = "descriptions")
    private String descriptions;

    @Column(name = "price")
    private float price;

    @Column(name = "category")
    private String category;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "status")
    private String status;

    @Column(name = "import_date")
    private String date;

    public BookStore() {
    }

    public BookStore(String title, String image, String author, String descriptions, float price, String category, int quantity, String status, String date) {
        this.title = title;
        this.image = image;
        this.author = author;
        this.descriptions = descriptions;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.status = status;
        this.date = date;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
