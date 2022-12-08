package cen4010se1apiproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class RatingService {

    @Autowired RatingRepository ratingRepository;
    @Autowired BookRepository bookRepository;
    @Autowired BookService bookService;

    public void addRating (Rating rating) {
        Double newRating;
        Integer bookID = rating.getBookid();
        List<Rating> ratings = ratingRepository.getRatingByBookidAndOrderByBookRating(bookID);
        if (ratings.isEmpty()) {
            Book book = bookService.getByBookID(bookID);
            book.setBookRating(rating.getBookRating());
            bookRepository.updateRating(rating.getBookRating(),bookID);
        }
        else {
            int index;
            Double total = 0.0;
            for (index = 0; index <= ratings.size(); index++) {
                total = total + (ratings.get(index).getBookRating());
            }
            rating.setBookRating(total/ratings.size());
        } ratingRepository.save(rating);}

    public List<Rating> getRatingList (Book book) {
        return ratingRepository.getRatingByBookidAndOrderByBookRating(book.getBookID());
    }

}
