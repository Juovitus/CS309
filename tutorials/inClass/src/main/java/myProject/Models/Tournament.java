package myProject.Models;

import javax.persistence.*;
/**
 * 
 * @author Thomas McCoy
 * 
 */
@Entity
public class Tournament {
	/**
	 * Goal is to set up a tournament for users to compete against each other in each round of the bracket.
	 * Limits games to person vs person. 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@Column
	Integer pid; // participant id -- should reference a user -- shouldn't be the same a oid.
	@Column
	String participant; // name of the referenced user
	@Column 
	Integer oid; // opponent id -- should reference a user -- shouldn't be the same a pid 
	@Column
	String opponent; // name of the referenced opponent to the participant
	@Column
	Boolean isEliminated; // check if user has been eliminated - single elimination only tournament .
	@Column 
	Integer round; // defines what round the user is in, starts at round 0.
	
	// TODO Create relations for opponent and participant to user. 
	
/////////////////////////////////////////
//               Getters               //
/////////////////////////////////////////
	/**
	 * Getter for id
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Getter for pid
	 * @return pid
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * Getter for participant
	 * @return participant
	 */
	public String getParticipant() {
		return participant;
	}
	/**
	 * Getter for oid
	 * @return oid
	 */
	public Integer getOid() {
		return oid;
	}
	/**
	 * Getter for opponent
	 * @return opponent
	 */
	public String getOpponent() {
		return opponent;
	}
	/**
	 * Getter for isEliminated
	 * @return isEliminated
	 */
	public Boolean getIsEliminated() {
		return isEliminated;
	}
	/**
	 * Getter for round
	 * @return round
	 */
	public Integer getRound() {
		return round;
	}
	/////////////////////////////////////////
	//               Setters               //
	/////////////////////////////////////////
	
	/**
	 * Setter for participant
	 * @param participant
	 */
	public void setParticipant(String participant) {
		this.participant = participant;
	}
	/**
	 * Setter for isEliminated
	 * @param isEliminated
	 */
	public void setIsEliminated (Boolean isEliminated) {
		this.isEliminated = isEliminated;
	}
	/**
	 * Setter for round
	 * @param round
	 */
	public void setRound(Integer round) {
		this.round = round;
	}
}
