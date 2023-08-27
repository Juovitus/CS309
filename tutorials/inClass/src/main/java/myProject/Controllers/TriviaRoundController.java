package myProject.Controllers;

import java.util.List;

import myProject.Models.TriviaRound;
import myProject.Repositories.TriviaRoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * 
 * @author Thomas McCoy
 *
 */
@RestController
public class TriviaRoundController {

	@Autowired
	TriviaRoundRepository triviaRoundRepo;

	/**
	 * lists results
	 * @return all on triviaRound
	 */
	@RequestMapping("/triviaRound/id")
	List<TriviaRound> findTriviaRound() {
		return triviaRoundRepo.findAll();
	}
	/**
	 * creates a triviaRound
	 * @param p - a triviaRound
	 * @return the triviaRound
	 */
	@PostMapping("/triviaRound/id")
	TriviaRound createTriviaRound(@RequestBody TriviaRound p) {
		triviaRoundRepo.save(p);
		return p;
	}

}
