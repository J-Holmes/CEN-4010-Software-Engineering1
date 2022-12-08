package cen4010se1apiproject;

import javax.persistence.*;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookID;
    private String bookISBN;
    private String bookName;
    private String bookDescription;
    private String bookGenre;
    private String bookPublisher;
    private Integer bookYearPublish;
    private Integer bookCopiesSold;
    private Integer bookAuthorID;
    private Double bookPrice;
    private Double bookRating;
    private String authorName;

    // getters & setters
    public Integer getBookID() {return bookID;}
    public void setBookID(Integer bookID) {this.bookID = bookID;}
    public String getBookISBN() {return bookISBN;}
    public void setBookISBN(String bookISBN) {this.bookISBN = bookISBN;}
    public String getBookName() {return bookName;}
    public void setBookName(String bookName) {this.bookName = bookName;}
    public String getBookDescription() {return bookDescription;}
    public void setBookDescription(String bookDescription) {this.bookDescription = bookDescription;}
    public String getBookGenre() {return bookGenre;}
    public void setBookGenre(String bookGenre) {this.bookGenre = bookGenre;}
    public String getBookPublisher() {return bookPublisher;}
    public void setBookPublisher(String bookPublisher) {this.bookPublisher = bookPublisher;}
    public Integer getBookYearPublish() {return bookYearPublish;}
    public void setBookYearPublish(Integer bookYearPublish) {this.bookYearPublish = bookYearPublish;}
    public Integer getBookCopiesSold() {return bookCopiesSold;}
    public void setBookCopiesSold(Integer bookCopiesSold) {this.bookCopiesSold = bookCopiesSold;}
    public Integer getBookAuthorID() {return bookAuthorID;}
    public void setBookAuthorID(Integer bookAuthorID) {this.bookAuthorID = bookAuthorID;}
    public Double getBookPrice() {return bookPrice;}
    public void setBookPrice(Double bookPrice) {this.bookPrice = bookPrice;}
    public Double getBookRating() {return bookRating;}
    public void setBookRating(Double bookRating) {this.bookRating = bookRating;}
    public String getAuthorName() {return authorName;}
    public void setAuthorName(String authorName) {this.authorName = authorName;}
} // end class

