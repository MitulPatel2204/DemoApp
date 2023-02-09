package com.g10.demoapp.Pogo;

public class Productpogo {
    Integer id;
    String bookname,bookauthor,bookprice,image,totalrating;
    Float rating;

    public Productpogo(Integer id, Float rating, String totalrating, String bookname, String bookauthor, String bookprice, String image) {
        this.id = id;
        this.rating = rating;
        this.totalrating = totalrating;
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.bookprice = bookprice;
        this.image = image;
    }

    public Productpogo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getTotalrating() {
        return totalrating;
    }

    public void setTotalrating(String totalrating) {
        this.totalrating = totalrating;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public String getBookprice() {
        return bookprice;
    }

    public void setBookprice(String bookprice) {
        this.bookprice = bookprice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
