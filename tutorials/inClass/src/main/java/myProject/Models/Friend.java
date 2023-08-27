package myProject.Models;

import java.io.Serializable;
import javax.persistence.*;
/**
 * 
 * @author Thomas McCoy & Noah Hoss
 *
 */
@Entity
public class Friend {
	@EmbeddedId 
	private Key key = new Key();
	
	@ManyToOne
	@MapsId("userId")
	private User user;
	
	@ManyToOne
	@MapsId("friendId")
	private User friend;
	
	private boolean isActive;

	@Embeddable
	public static class Key implements Serializable {
		private Integer userId;
		private Integer friendId;
		/**
		 * Getter for userId
		 * @return userId
		 */
		public Integer getUserId() {
			return userId;
		}
		/**
		 * Setter for userId
		 * @param userId - userId to set to current user
		 */
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		/**
		 * Getter for friendId
		 * @return friendId
		 */
		public Integer getFriendId() {
			return friendId;
		}
		/**
		 * Setter for friendId
		 * @param friendId - friendId to set to current friend
		 */
		public void setFriendId(Integer friendId) {
			this.friendId = friendId;
		}
	}
	/**
	 * Getter for isActive
	 * @return isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * Setter for isActive
	 * @param isActive - check if friend is active
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
