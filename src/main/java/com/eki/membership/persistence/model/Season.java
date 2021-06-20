/**
 * 
 */
package com.eki.membership.persistence.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.eki.membership.persistence.interfaces.IDto;
import com.eki.membership.persistence.interfaces.IEntity;

/**
 * @author eckhard kirschning
 *
 */

@Entity
@Table(name = "SEASON")
public class Season implements IEntity, IDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7467681945161675216L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	@Size(min = 2, max = 10)
	private String seasonName;

	@Column()
	private boolean isActive;

	@Column()
	@Size(min= 4, max=4)
	private int seasonYear;

	@Column()
	private LocalDate seasonDate;

	public Season() {
		super();
	}

	public Season(String seasonName, boolean isActive, @NotNull int seasonYear, LocalDate seasonDate) {
		super();
		this.seasonName = seasonName;
		this.isActive = isActive;
		this.seasonYear = seasonYear;
		this.seasonDate = seasonDate;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getSeasonName() {
		return seasonName;
	}

	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getSeasonYear() {
		return seasonYear;
	}

	public void setSeasonYear(int seasonYear) {
		this.seasonYear = seasonYear;
	}

	public LocalDate getSeasonDate() {
		return seasonDate;
	}

	public void setSeasonDate(LocalDate seasonDate) {
		this.seasonDate = seasonDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isActive, seasonDate, seasonName, seasonYear);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Season other = (Season) obj;
		return isActive == other.isActive && Objects.equals(seasonDate, other.seasonDate)
				&& Objects.equals(seasonName, other.seasonName) && seasonYear == other.seasonYear;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Season [seasonName=");
		builder.append(seasonName);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(", seasonYear=");
		builder.append(seasonYear);
		builder.append(", seasonDate=");
		builder.append(seasonDate);
		builder.append("]");
		return builder.toString();
	}

	public static class SeasonBuilder {
		private String season_name;
		private boolean is_active;
		private int season_year;
		private LocalDate season_date;

		public SeasonBuilder setName(String name) {
			this.season_name = name;
			return this;
		}

		public SeasonBuilder setYear(int year) {
			this.season_year = year;
			return this;
		}

		public SeasonBuilder setDate(LocalDate date) {
			this.season_date = date;
			return this;
		}

		public SeasonBuilder setIsActive(boolean isActive) {
			this.is_active = isActive;
			return this;
		}

		public Season build() {

			return new Season(season_name, is_active, season_year, season_date);
		}

	}
}
