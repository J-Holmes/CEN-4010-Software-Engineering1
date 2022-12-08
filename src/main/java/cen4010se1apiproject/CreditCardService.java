package cen4010se1apiproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditCardService {

    @Autowired CreditCardRepository creditCardRepository;

    public void addCard (CreditCard creditCard){creditCardRepository.save(creditCard);}

    public List<CreditCard> getAllForUser (User user) {
        return creditCardRepository.findCreditCardsByUserIDEquals(user.getUserID());
    }

}
