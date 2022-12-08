package cen4010se1apiproject;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer cardID;
    Integer userID;
    String cardName;
    String cardNumber;

    // getters & setters
    public Integer getCardID() {return cardID;}
    public void setCardID(Integer cardID) {this.cardID = cardID;}
    public Integer getUserID() {return userID;}
    public void setUserID(Integer userID) {this.userID = userID;}
    public String getCardName() {return cardName;}
    public void setCardName(String cardName) {this.cardName = cardName;}
    public String getCardNumber() {return cardNumber;}
    public void setCardNumber(String cardNumber) {this.cardNumber = cardNumber;}
}
