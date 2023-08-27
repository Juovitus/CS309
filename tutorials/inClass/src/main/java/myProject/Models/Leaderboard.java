package myProject.Models;

import javax.persistence.*;
/**
 * 
 * @author Thomas McCoy & Noah Hoss
 *
 */
@Entity
public class Leaderboard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column
	String username;
	@Column
	Integer points;
	@Column 
	Integer rank;

	/**
	 * Getter for id
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Getter for username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Getter for points
	 * @return points
	 */
	public Integer getPoints() {
		return points;
	}
	/**
	 * Getter for rank
	 * @return rank
	 */
	public Integer getRank() {
		return rank;
	}
	/**
	 * Setter for username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * Setter for points
	 * @param points
	 */
	public void setPoints (Integer points) {
		this.points = points;
	}
	/**
	 * Setter for rank
	 * @param rank
	 */
	public void setRank(Integer rank) {
		this.rank = rank;
	}
}
