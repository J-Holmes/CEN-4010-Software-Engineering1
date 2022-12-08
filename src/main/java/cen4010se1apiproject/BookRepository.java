package cen4010se1apiproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // use Java JPA API to create database queries using Java instead of SQL
public interface BookRepository extends JpaRepository<Book, Integer> {

    // Book details features
    List<Book> findByBookAuthorIDIs(Integer book_authorid);
    Book findByBookISBNIs(String bookisbn);
    Book findByBookIDIs(Integer bookid);

    // Book browsing features
    List<Book> findByBookRatingGreaterThan(Double rating);
    List<Book> findByBookGenreIs(String genre);

    @Modifying
    @Query ("update Book b set b.bookRating = ?1 where b.bookID = ?2")
    void updateRating (Double bookRating, Integer bookid);


}