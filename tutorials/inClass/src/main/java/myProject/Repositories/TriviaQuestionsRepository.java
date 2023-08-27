package myProject.Repositories;


import myProject.Models.TriviaQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Interface for TriviaQuestion
 * @author Thomas McCoy & Noah Hoss
 *
 */
@Repository
public interface TriviaQuestionsRepository extends JpaRepository<TriviaQuestion, Integer> {

}
