package myProject.Repositories;


import myProject.Models.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Interface for Friend
 * @author Thomas McCoy & Noah Hoss
 *
 */
@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {

}
