package cen4010se1apiproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser (User user) {userRepository.save(user);}

    public User getByUserName (String username) {return userRepository.findByUserNameEquals(username);}
    public User getByUserID (Integer userID) {return userRepository.findByUserIDEquals(userID);}
}
