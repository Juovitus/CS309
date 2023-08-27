package myProject.Models;

import myProject.Models.Friend;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;
/**
 * 
 * @author Thomas McCoy & Noah Hoss
 *
 */
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(unique = true)
	@NotEmpty
	public String userName;
	
	@Column
	@NotEmpty
	public String password;

	@Column(unique = true)
	@Email(message = "Email should be valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@NotEmpty(message = "Email cannot be empty")
	public String userEmail;

	//Trying to set up friend list
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Friend> friends = new HashSet<>();
	//TODO getter and setters for friends?
	/**
	 * Constructor
	 * @param userName
	 * @param password
	 * @param userEmail
	 */
	public User(String userName, String password, String userEmail){
		this.userName = userName;
		this.password = password;
		this.userEmail = userEmail;
	}
	/**
	 * Getter for id
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Setter for id 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * Getter for userName
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * Setter for userName
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * Getter for password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Setter for password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Getter for userEmail
	 * @return userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}
	/**
	 * Setter for userEmail
	 * @param userEmail
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}