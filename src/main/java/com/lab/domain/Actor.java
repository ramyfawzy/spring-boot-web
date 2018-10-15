/**
 * 
 */
package com.lab.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

/**
 * @author Ramy
 *
 */

@JsonIgnoreProperties({ "ignoreme1", "ignoreme2" })
public class Actor {

	@JsonProperty
	private String actorId;
	@JsonProperty
	private String firstName;
	@JsonProperty
	private String lastName;
	@JsonProperty
	private LocalDateTime lastUpdate;
	
	public Actor() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param actorId
	 * @param firstName
	 * @param lastName
	 * @param lastUpdate
	 */
	public Actor(String actorId, String firstName, String lastName,
			LocalDateTime lastUpdate) {
		this.actorId = actorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastUpdate = lastUpdate;
	}

	/**
	 * @return the actorId
	 */
	public String getActorId() {
		return actorId;
	}

	/**
	 * @param actorId the actorId to set
	 */
	public void setActorId(String actorId) {
		this.actorId = actorId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the lastUpdate
	 */
	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		 return MoreObjects.toStringHelper(Car.class)
			        .add("actorId", actorId)
			        .add("firstName", firstName)
			        .add("lastName", lastName)
			        .add("lastUpdate", lastUpdate)
			        .toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actorId == null) ? 0 : actorId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Actor)) {
			return false;
		}
		Actor other = (Actor) obj;
		if (actorId == null) {
			if (other.actorId != null) {
				return false;
			}
		}
		else if (!actorId.equals(other.actorId)) {
			return false;
		}
		return true;
	}
	
	
	
	

}
