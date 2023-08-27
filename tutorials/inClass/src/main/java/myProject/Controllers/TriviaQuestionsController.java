package myProject.Controllers;

import java.util.List;

import myProject.Models.TriviaQuestion;
import myProject.Repositories.TriviaQuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * 
 * @author Thomas McCoy & Noah Hoss
 *	
 */
@RestController
public class TriviaQuestionsController {

	@Autowired
	TriviaQuestionsRepository triviaQuestionsRepo;
	/**
	 * 
	 * @param id - question id
	 * @return a trivia question 
	 */
	@GetMapping("/triviaQuestions/{id}")
	TriviaQuestion getTriviaQuestion(@PathVariable Integer id) {
		return triviaQuestionsRepo.getById(id);
	}
	/**
	 * lists trivia questions 
	 * @return all questions  
	 */
	@RequestMapping("/triviaQuestions")
	List<TriviaQuestion> findAllTriviaQuestions() {
		return triviaQuestionsRepo.findAll();
	}
	/**
	 * creates a trivia question 
	 * @param p - a trivia question
	 * @return a trivia question 
	 */
	@PostMapping("/triviaQuestions")
	TriviaQuestion createQuestion(@RequestBody TriviaQuestion p) {
		triviaQuestionsRepo.save(p);
		return p;
	}

	//TODO Create updateTriviaQuestion in case of errors, etc.
	/**
	 * deletes a question
	 * @param id - id of the question
	 * @return id of the deleted question
	 */
	@DeleteMapping("/triviaQuestions/{id}")
	String deleteQuestion(@PathVariable Integer id) {
		triviaQuestionsRepo.deleteById(id);
		return "deleted " + id;
	}

}
