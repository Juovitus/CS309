package myProject.Controllers;

import java.util.List;

import myProject.Models.Friend;
import myProject.Repositories.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * 
 * @author Thomas McCoy & Noah Hoss
 *	
 */
@RestController
public class FriendController {

	@Autowired
	FriendRepository friendRepo;

	/**
	 * lists friends
	 * @return all friends 
	 */
	@RequestMapping("/userId")
	List<Friend> findFriends() {
		return friendRepo.findAll();
	}
	/**
	 * creates a person
	 * @param p - a friend
	 * @return a friend
	 */
	@PostMapping("/userId")
	Friend createFriend(@RequestBody Friend p) {
		friendRepo.save(p);
		return p;
	}

}
