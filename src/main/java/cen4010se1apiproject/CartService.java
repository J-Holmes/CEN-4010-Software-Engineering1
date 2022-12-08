package cen4010se1apiproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired CartRepository cartRepository;

    public void addToCart (Cart cart) {cartRepository.save(cart);}

    public List<Book> getAllForUser (Integer userID) {
        return cartRepository.findByUserIDEquals(userID);
    }

}
