package myProject.Models;

import javax.persistence.*;
/**
 * 
 * @author Thomas McCoy
 *
 */
@Entity
public class TriviaRound {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column
	Integer roundNumber; // 1, 2, 3, etc.
	@Column
	Integer pointMultiplier; // could have multiple rounds with different point multipliers, e.g. 1.5x, 2.0x, 2.5x, etc. 
	@Column 
	Integer allowedParticipants; // number of allowed participants in a certain round. Perhaps eliminate lowest scoring participant every round? 
	@Column
	Integer numQuestions; // number of questions per round in case we want a round longer than another. 
	
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
	 * Getter for roundNumber
	 * @return roundNumber
	 */
	public Integer getRoundNumber() {
		return roundNumber;
	}
	/**
	 * Getter for pointMultiplier
	 * @return pointMultiplier
	 */
	public Integer getPointMultiplier() {
		return pointMultiplier;
	}
	/**
	 * Getter for allowedParticipants
	 * @return allowedParticipants
	 */
	public Integer getAllowedParticipants() {
		return allowedParticipants;
	}
	/**
	 * Getter for numQuestions
	 * @return numQuestions
	 */
	public Integer getNumQuestions() {
		return numQuestions;
	}
	/////////////////////////////////////////
	//               Setters               //
	/////////////////////////////////////////
	
	/**
	 * Setter for roundNumber
	 * @param roundNumber
	 */
	public void setRoundNumber(Integer roundNumber) {
		this.roundNumber = roundNumber;
	}
	/**
	 * Setter for pointMultiplier
	 * @param pointMultiplier
	 */
	public void setPointMultiplier (Integer pointMultiplier) {
		this.pointMultiplier = pointMultiplier;
	}
	/**
	 * Setter for allowedParticipants
	 * @param allowedParticipants
	 */
	public void setAllowedParticipants(Integer allowedParticipants) {
		this.allowedParticipants = allowedParticipants;
	}
	/**
	 * Setter for numQuestions
	 * @param numQuestions
	 */
	public void setNumQuestions(Integer numQuestions) {
		this.numQuestions = numQuestions;
	}
}
