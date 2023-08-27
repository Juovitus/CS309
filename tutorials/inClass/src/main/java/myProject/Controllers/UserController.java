package myProject.Controllers;

import java.util.List;

import myProject.Models.User;
import myProject.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
/**
 * 
 * @author Noah Hoss & Thomas McCoy
 *
 */
@RestController
@Validated
public class UserController {

	@Autowired
	UserRepository userRepo;
	/**
	 * returns a user by id
	 * @param id - id of the user
	 * @return - the corresponding user
	 */
	@GetMapping("/users/{id}")
	User getUser(@PathVariable Integer id) {
		return userRepo.getById(id);
	}
	/**
	 * Gets a list of all users
	 * @return - the list of users 
	 */
	@RequestMapping("/users")
	List<User> findAllUsers() {
		return userRepo.findAll();
	}
	/**
	 * Creates a user
	 * @param p - a user
	 * @return - the created user
	 */
	@PostMapping(path = "/user", consumes = "application/x-www-form-urlencoded")
	User createUser(@Valid @RequestBody User p) {
		userRepo.save(p);
		return p;
	}
	//TODO update to no take second param & change 'oldUser' to something else
	/**
	 * Updates a user
	 * @param p - a user
	 * @param id - id of user 
	 * @return - updated user 
	 */
	@PutMapping("/user/{id}")
	User updateUser(@Valid @RequestBody User p, @PathVariable Integer id) {
		User oldUser = userRepo.getById(id);

		//Check if fields are null or empty, if they aren't then set field.
		if(p.userName != null && !p.userName.isEmpty()) {
			oldUser.setUserName(p.userName);
		}
		if(p.password != null && !p.password.isEmpty()) {
			oldUser.setPassword(p.password);
		}
			oldUser.setUserEmail(p.userEmail);

		userRepo.save(oldUser);
		return oldUser;
	}
	/**
	 * Deletes a user by id
	 * @param id - id of user 
	 * @return - id of deleted user 
	 */
	@DeleteMapping("/user/{id}")
	String deleteUser(@PathVariable Integer id) {
		userRepo.deleteById(id);
		return "deleted " + id;
	}

}
