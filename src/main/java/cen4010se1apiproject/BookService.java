package cen4010se1apiproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BookService {

    @Autowired private BookRepository bookRepository;
    @Autowired private AuthorRepository authorRepository;

    public List<Book> getAllBooks () {return bookRepository.findAll();}
    public List <Book> getByGenre (String genre) {return bookRepository.findByBookGenreIs(genre);}
    public Book getByISBN (String isbn) {return bookRepository.findByBookISBNIs(isbn);}
    public Book getByBookID (Integer bookid) {return bookRepository.findByBookIDIs(bookid);}
    public void addBook (Book book) {bookRepository.save(book);}
    public List<Book> getByAuthor (String authorfname, String authorlname) {
        Author author = authorRepository.getAuthorByAuthorFNameEqualsAndAuthorLNameEquals(authorfname, authorlname);
        return bookRepository.findByBookAuthorIDIs(author.getAuthorID());  }

    /*  Rating service branch can call this to update a book's rating. If the book has no ratings yet (rating = 0),
        then the book rating is changed from 0 to the new rating. If there is already a rating present for a book,
        then rating service will have to call a function to recalculate the average given the new rating then call
        this update function to post in the book database table.
     */
    public void updateRating (Double bookRating, Integer bookid) {
        bookRepository.updateRating(bookRating,bookid);
    }
    // public <List> Book getBestSellers ();
} // end class

