package cen4010se1apiproject;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ratingid;
    private Integer bookid;
    private Integer userid;
    private Double bookRating;
    private String comment;
    private Date dateStamp;

    // getters & setters
    public Integer getRatingid() {return ratingid;}
    public void setRatingid(Integer ratingid) {this.ratingid = ratingid;}
    public Integer getBookid() {return bookid;}
    public void setBookid(Integer bookid) {this.bookid = bookid;}
    public Integer getUserid() {return userid;}
    public void setUserid(Integer userid) {this.userid = userid;}
    public Double getBookRating() {return bookRating;}
    public void setBookRating(Double bookRating) {this.bookRating = bookRating;}
    public String getComment() {return comment;}
    public void setComment(String comment) {this.comment = comment;}
    public Date getDateStamp() {return dateStamp;}
    public void setDateStamp(Date dateStamp) {this.dateStamp = dateStamp;}
}