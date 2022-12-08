package cen4010se1apiproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.type.NullType;
import java.util.Date;
import java.util.List;

@RestController
public class Controller {

    @Autowired private AuthorService authorService;
    @Autowired private BookService bookService;
    @Autowired private RatingService ratingService;
    @Autowired private UserService userService;
    @Autowired private CreditCardService creditCardService;
    @Autowired private CartService cartService;

    /*************** TEST ENDPOINTS *************/
    @GetMapping("/")
    public String landingPage () {
        return "Florida International University // "
                + "CEN 4010 - Software Engineering 1 - API Project"; }

    @GetMapping("/test")
    public String testMessage () {return "The API test call was a success";}


    /*************** UTILITY ENDPOINTS *************/
    @GetMapping("/book/getbyid/{bookid}")
    public Book getByBookID(@PathVariable Integer bookid) {return bookService.getByBookID(bookid);}

    @GetMapping("/author/getall")
    public List<Author> getAllAuthors () {return authorService.getAllAuthors();}

    @GetMapping("/book/getall")
    public List<Book> getAllBooks () {return bookService.getAllBooks();}

    /***** BOOk BROWSING  *****/
    @GetMapping("/book/getbygenre/{genre}")
    public List<Book> getByGenre (@PathVariable String genre) {return bookService.getByGenre(genre);}
    // @GetMapping("/book/topsellers")
    // @GetMapping("/book/getbyrating")
    // @GetMapping("/book/getxnumber")

    /********* BOOK DETAILS  *********/

    /* An administrator must be able to create an author
    with first name, last name, biography and publisher */
    @PostMapping("/author/add")
    public String authorAdd (@RequestParam String author_bio, @RequestParam String authorfname,
                             @RequestParam String authorlname, @RequestParam String author_publisher) {
        Author author = new Author();
        author.setAuthorBio(author_bio);
        author.setAuthorFName(authorfname);
        author.setAuthorLName(authorlname);
        author.setAuthorPublisher(author_publisher);
        authorService.addAuthor(author);
        return ("added " + author);    }

    /* An administrator must be able to create a book with the book
    ISBN, book name, book description, price, author, genre,
    publisher, year published and copies sold. */
    @PostMapping("/book/add")
    public String bookAdd (@RequestParam String authorFName, @RequestParam String authorLName,
                           @RequestParam Integer copiesSold, @RequestParam String description, @RequestParam String genre,
                           @RequestParam String isbn, @RequestParam String name, @RequestParam Double price,
                           @RequestParam String publisher, @RequestParam Integer yearPublished) {
        int authorID = authorService.getIdByName(authorFName,authorLName);
        if (authorID == -1) {return "Author not found - Add author first";} // db normalization check
        Book book = new Book();
        book.setBookAuthorID(authorID);
        book.setBookCopiesSold(copiesSold);
        book.setBookDescription(description);
        book.setBookGenre(genre);
        book.setBookISBN(isbn);
        book.setBookName(name);
        book.setBookPrice(price);
        book.setBookPublisher(publisher);
        book.setBookYearPublish(yearPublished);
        book.setBookRating(0.0);
        try {
            bookService.addBook(book);
            return "added " + book;
        } catch (Exception e) {
            return "Error - Duplicate";
        }
    }

    /* Must be able to retrieve book details by the ISBN */
    @GetMapping("/book/getbyisbn/{bookisbn}")
    public Book getByISBN(@PathVariable String bookisbn) {return bookService.getByISBN(bookisbn);}

    /* Must be able to retrieve a list of books associate with an author */
    @GetMapping("/book/getbyauthor/{authorfname}/{authorlname}")
    public List<Book> getByAuthor(@PathVariable String authorfname, @PathVariable String authorlname) {
        return bookService.getByAuthor(authorfname,authorlname);    }

    /************** PROFILE MANAGEMENT **************/
    /*Create a User with username(email), password and optional fields (name, email address, home address)*/
    @PostMapping("/user/add")
    public String addUser (@RequestParam String email, @RequestParam String homeaddress,
                           @RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setEmailAddress(email);
        user.setHomeAddress(homeaddress);
        user.setUserName(username);
        user.setPassword(password);
        user.setAccessLevel(1); // to differentiate by user/admin if needed
        userService.addUser(user);
        return "added " + user;      }

    @GetMapping("/user/get/{username}")
    public User getByUserName (@PathVariable String userName) {return userService.getByUserName(userName);}

    // @PutMapping("/user/update/")

    /* Create Credit Card that belongs to a User */
    @PostMapping("/user/addcard/")
    public String addCard (@RequestParam Integer userID, @RequestParam String cardName,
                           @RequestParam String cardNumber) {
        CreditCard creditCard = new CreditCard();
        creditCard.setUserID(userID);
        creditCard.setCardName(cardName);
        creditCard.setCardNumber(cardNumber);
        creditCardService.addCard(creditCard);
        return "added " + creditCard;    }

    /* Retrieve a list of cards for that user */
    @GetMapping("/user/getcards/{username}")
    public List<CreditCard> getCards (String userName) {
        return creditCardService.getAllForUser(getByUserName(userName));
    }

    /********* SHOPPING CART MESSAGE *********/
    @PostMapping("/cart/add")
    public String addToCart (@RequestParam Integer userID, @RequestParam Integer bookID, @RequestParam String bookName) {
        Cart cart = new Cart();
        cart.setUserID(userID);
        cart.setBookID(bookID);
        cart.setBookName(bookName);
        cartService.addToCart(cart);
        return "added " + cart;    }
    // @GetMapping("/cart/get/{userid}")
    // @Put/DeleteMapping("/cart/deletebook/{bookid}")

    /********* BOOk RATING/COMMENTING MESSAGE *********/
    @PostMapping("/rating/add")
    public String addRating (@RequestParam Double bookrating, @RequestParam Integer bookid,
                             @RequestParam String comment, @RequestParam Integer userid) {
        Rating rating = new Rating();
        rating.setBookRating(bookrating);
        rating.setBookid(bookid);
        rating.setComment(comment);
        rating.setUserid(userid);
        rating.setDateStamp(new Date());
        ratingService.addRating(rating);
        return "added " + rating;    }
    // @GetMapping("/rating/getall")
    // @GetMapping("/rating/getforbook/{bookid}")
    // @GetMapping("/rating/getaverage/{bookid}")

    /********* WISH LIST MANAGEMENT MESSAGE *********/
    // @PostMapping("/wishlist/create/{userid}")
    // @PutMapping("/wishlist/addbook/{userid}")
    // @PutMapping("/wishlist/removebook/{userid}")
    // @GetMapping("/wishlist/getforuser/{userid}")

} // end class

