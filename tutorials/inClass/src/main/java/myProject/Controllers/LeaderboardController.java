package myProject.Controllers;

import java.util.List;

import myProject.Models.Leaderboard;
import myProject.Repositories.LeaderboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * 
 * @author Thomas McCoy & Noah Hoss
 *
 */
@RestController
public class LeaderboardController {

	@Autowired
	LeaderboardRepository leaderboardRepo;

	/**
	 * lists all leaderboards with username found
	 * @return all on username
	 */
	@RequestMapping("/username")
	List<Leaderboard> findLeaderboard() {
		return leaderboardRepo.findAll();
	}
	/**
	 * creates a leaderboard
	 * @param p - a leaderboard
	 * @return the leaderboard
	 */
	@PostMapping("/username")
	Leaderboard createLeaderboard(@RequestBody Leaderboard p) {
		leaderboardRepo.save(p);
		return p;
	}

}
