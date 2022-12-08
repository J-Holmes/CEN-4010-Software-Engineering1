package cen4010se1apiproject;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer cartItemID;
    Integer userID;
    Integer bookID;
    String bookName;

    public String getBookName() {return bookName;}
    public void setBookName(String bookName) {this.bookName = bookName;}
    public Integer getCartItemID() {return cartItemID;}
    public void setCartItemID(Integer cartItemID) {this.cartItemID = cartItemID;}
    public Integer getUserID() {return userID;}
    public void setUserID(Integer userID) {this.userID = userID;}
    public Integer getBookID() {return bookID;}
    public void setBookID(Integer bookID) {this.bookID = bookID;}
}