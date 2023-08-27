package myProject.Controllers;

import java.util.List;

import myProject.Models.Tournament;
import myProject.Repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * 
 * @author Thomas McCoy
 *
 */
@RestController
public class TournamentController {

	@Autowired
	TournamentRepository tournament;

	/**
	 * lists results
	 * @return all on triviaRound
	 */
	@RequestMapping("/tournament/id")
	List<Tournament> findTournament() {
		return tournament.findAll();
	}
	/**
	 * creates a triviaRound
	 * @param p - a triviaRound
	 * @return the triviaRound
	 */
	@PostMapping("/tournament/id")
	Tournament createTriviaRound(@RequestBody Tournament p) {
		tournament.save(p);
		return p;
	}

}
