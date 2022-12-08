package cen4010se1apiproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    // had to define this query, Spring throwing exceptions to default verbiage
    @Query("select a.bookRating from Rating a where a.bookid = ?1 order by a.bookRating desc ")
    List<Rating> getRatingByBookidAndOrderByBookRating (Integer bookid);

}