/**
 * 
 */
package com.eki.membership.persistence.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eki.membership.persistence.interfaces.IDto;
import com.eki.membership.persistence.interfaces.IEntity;

/**
 * @author eckhard kirschning
 *
 */
@Entity
@Table(name = "SEASON_USER")
public class SeasonUser implements IEntity, IDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1964632896591826597L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(optional = false, cascade = CascadeType.PERSIST)
	User user;

	@ManyToOne(optional = false, cascade = CascadeType.PERSIST)
	Season season;

	@Column
	private String positionRole;

	@Column()
	private boolean feesPaid;

	@Column
	private boolean isActive;

	@Override
	public Long getId() {
		return id;
	}
	// ---------------- constructors -------------------------

	public SeasonUser() {
		super();
	}

	public SeasonUser(User user, Season season, String positionRole, boolean feesPaid, boolean isActive) {
		super();
		this.user = user;
		this.season = season;
		this.positionRole = positionRole;
		this.feesPaid = feesPaid;
		this.isActive = isActive;
	}
	// ---------------- getter & setter -------------------------

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getPositionRole() {
		return positionRole;
	}

	public void setPositionRole(String positionRole) {
		this.positionRole = positionRole;
	}

	public boolean isFeesPaid() {
		return feesPaid;
	}

	public void setFeesPaid(boolean feesPaid) {
		this.feesPaid = feesPaid;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}
	// ---------------- overridden -------------------------

	@Override
	public int hashCode() {
		return Objects.hash(feesPaid, isActive, positionRole, season, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeasonUser other = (SeasonUser) obj;
		return feesPaid == other.feesPaid && isActive == other.isActive
				&& Objects.equals(positionRole, other.positionRole) && Objects.equals(season, other.season)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SeasonUser [user=");
		builder.append(user.getUserName());
		builder.append(", season=");
		builder.append(season.getSeasonName());
		builder.append(", positionRole=");
		builder.append(positionRole);
		builder.append(", feesPaid=");
		builder.append(feesPaid);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append("]");
		return builder.toString();
	}

	// ---------------- builder -------------------------

	public static class SeasonUserBuilder {

		private String position_role;
		private boolean is_active;
		private boolean fees_paid;
		private User user;
		private Season season;

		public SeasonUserBuilder setPositionRole(String positionRole) {
			this.position_role = positionRole;
			return this;
		}

		public SeasonUserBuilder setIsActive(boolean isActive) {
			this.is_active = isActive;
			return this;
		}

		public SeasonUserBuilder setIsFeesPaid(boolean feesPaid) {
			this.fees_paid = feesPaid;
			return this;
		}

		public SeasonUserBuilder setUser(User user) {
			this.user = user;
			return this;
		}

		public SeasonUserBuilder setSeason(Season season) {
			this.season = season;
			return this;
		}

		public SeasonUser build() {

			return new SeasonUser(user, season, position_role, fees_paid, is_active);
		}

	}

}
