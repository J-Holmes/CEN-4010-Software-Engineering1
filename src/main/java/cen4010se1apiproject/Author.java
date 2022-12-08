package cen4010se1apiproject;

import javax.persistence.*;

@Entity
@Table(name="author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer authorID;
    private String authorFName;
    private String authorLName;
    private String authorBio;
    private String authorPublisher;

    // setters & getters
    public Integer getAuthorID() {return authorID;}
    public void setAuthorID(Integer authorID) {this.authorID = authorID;}
    public String getAuthorFName() {return authorFName;}
    public void setAuthorFName(String authorFName) {this.authorFName = authorFName;}
    public String getAuthorLName() {return authorLName;}
    public void setAuthorLName(String authorLName) {this.authorLName = authorLName;}
    public String getAuthorBio() {return authorBio;}
    public void setAuthorBio(String authorBio) {this.authorBio = authorBio;}
    public String getAuthorPublisher() {return authorPublisher;}
    public void setAuthorPublisher(String authorPublisher) {this.authorPublisher = authorPublisher;}

} // end class

