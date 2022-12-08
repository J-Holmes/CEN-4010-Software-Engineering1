package cen4010se1apiproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public void addAuthor(Author author) {authorRepository.save(author);}

    public List<Author> getAllAuthors() {return authorRepository.findAll();}

    public String getByID(Integer authorID) {
        String fName = authorRepository.getAuthorByAuthorIDEquals(authorID).getAuthorFName();
        String lName = authorRepository.getAuthorByAuthorIDEquals(authorID).getAuthorLName();
        return fName + " " + lName;
    }

    public Integer getIdByName (String fName, String lName) {
        try {
            int id = authorRepository.getAuthorByAuthorFNameEqualsAndAuthorLNameEquals(fName,lName).getAuthorID();
            if (id > 0) {return id;}
        } catch (Exception e) {
            System.out.println("Add author first");
        }
        return -1;
    }


} // end class
