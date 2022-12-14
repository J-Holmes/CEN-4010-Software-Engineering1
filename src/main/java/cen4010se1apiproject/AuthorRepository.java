package cen4010se1apiproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Author getAuthorByAuthorIDEquals (Integer authorID);

    @Query("select a from Author a where a.authorFName = ?1 and a.authorLName = ?2")
    Author getAuthorByAuthorFNameEqualsAndAuthorLNameEquals (String authorfname, String authorlname);

}
