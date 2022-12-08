package cen4010se1apiproject;

import javax.persistence.*;
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userID;
    private String userName;
    private String password;
    private String emailAddress;
    private String homeAddress;
    private Integer accessLevel;

    // setters & getters
    public Integer getUserID() {return userID;}
    public void setUserID(Integer userID) {this.userID = userID;}
    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getEmailAddress() {return emailAddress;}
    public void setEmailAddress(String emailAddress) {this.emailAddress = emailAddress;}
    public String getHomeAddress() {return homeAddress;}
    public void setHomeAddress(String homeAddress) {this.homeAddress = homeAddress;}
    public Integer getAccessLevel() {return accessLevel;}
    public void setAccessLevel(Integer accessLevel) {this.accessLevel = accessLevel;}
}