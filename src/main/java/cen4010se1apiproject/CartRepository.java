package cen4010se1apiproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query("select c.bookID, c.bookName from Cart c where c.userID = ?1")
    List<Book> findByUserIDEquals (Integer userID);

}