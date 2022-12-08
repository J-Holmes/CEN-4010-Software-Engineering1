package cen4010se1apiproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserNameEquals (String username);
    User findByUserIDEquals (Integer userID);

}