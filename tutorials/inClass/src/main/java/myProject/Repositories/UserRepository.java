package myProject.Repositories;


import myProject.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
 * Interface of User
 * @author Thomas McCoy & Noah Hoss
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(nativeQuery = true, value = "select * from user where user_name = :user")
    Optional<User> FindUserByUserName(@Param("user") String username);
}