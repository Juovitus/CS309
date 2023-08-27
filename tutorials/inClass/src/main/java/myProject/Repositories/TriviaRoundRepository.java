package myProject.Repositories;


import myProject.Models.TriviaRound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Interface for TriviaRound
 * @author Thomas McCoy 
 *
 */
@Repository
public interface TriviaRoundRepository extends JpaRepository<TriviaRound, Integer> {

}
