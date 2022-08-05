package com.turing.book.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Book implements Serializable {

    private Integer bid;
    private String bname;
    private String author;
    private BigDecimal price;

    public Book() {
    }

    public Book(Integer bid, String bname, String author, BigDecimal price) {
        this.bid = bid;
        this.bname = bname;
        this.author = author;
        this.price = price;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
