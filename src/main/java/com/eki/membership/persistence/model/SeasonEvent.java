/**
 * 
 */
package com.eki.membership.persistence.model;

import java.time.LocalDate;
import java.time.LocalTime;
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
@Table(name = "SEASON_EVENT")
public class SeasonEvent implements IEntity, IDto {

	private static final long serialVersionUID = 3789040492021606587L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(optional = false, cascade = CascadeType.PERSIST)
	Event event;

	@ManyToOne(optional = false, cascade = CascadeType.PERSIST)
	Season season;

	@Column()
	private boolean finished;

	@Column
	private String meetingPoint;
	@Column
	private String comments;

	@Column
	private LocalDate startingDate;
	@Column
	private LocalDate endingDate;

	@Column
	private LocalTime startingTime;
	@Column
	private LocalTime endingTime;

	// --------------- constructors--------------------------

	public SeasonEvent() {
		super();
	}


	public SeasonEvent(Event event, Season season, boolean finished, String meetingPoint, String comments,
			LocalDate startingDate, LocalDate endingDate, LocalTime startingTime, LocalTime endingTime) {
		super();
		this.event = event;
		this.season = season;
		this.finished = finished;
		this.meetingPoint = meetingPoint;
		this.comments = comments;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
		this.startingTime = startingTime;
		this.endingTime = endingTime;
	}
	//------ getter setter ----------------------------------		

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}


	public Event getEvent() {
		return event;
	}


	public void setEvent(Event event) {
		this.event = event;
	}


	public Season getSeason() {
		return season;
	}


	public void setSeason(Season season) {
		this.season = season;
	}


	public boolean isFinished() {
		return finished;
	}


	public void setFinished(boolean finished) {
		this.finished = finished;
	}


	public String getMeetingPoint() {
		return meetingPoint;
	}


	public void setMeetingPoint(String meetingPoint) {
		this.meetingPoint = meetingPoint;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public LocalDate getStartingDate() {
		return startingDate;
	}


	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}


	public LocalDate getEndingDate() {
		return endingDate;
	}


	public void setEndingDate(LocalDate endingDate) {
		this.endingDate = endingDate;
	}


	public LocalTime getStartingTime() {
		return startingTime;
	}


	public void setStartingTime(LocalTime startingTime) {
		this.startingTime = startingTime;
	}


	public LocalTime getEndingTime() {
		return endingTime;
	}


	public void setEndingTime(LocalTime endingTime) {
		this.endingTime = endingTime;
	}


	@Override
	public int hashCode() {
		return Objects.hash(comments, endingDate, endingTime, event, finished, id, meetingPoint, season, startingDate,
				startingTime);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeasonEvent other = (SeasonEvent) obj;
		return Objects.equals(comments, other.comments) && Objects.equals(endingDate, other.endingDate)
				&& Objects.equals(endingTime, other.endingTime) && Objects.equals(event, other.event)
				&& finished == other.finished && Objects.equals(id, other.id)
				&& Objects.equals(meetingPoint, other.meetingPoint) && Objects.equals(season, other.season)
				&& Objects.equals(startingDate, other.startingDate) && Objects.equals(startingTime, other.startingTime);
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SeasonEvent [event=");
		builder.append(event);
		builder.append(", season=");
		builder.append(season);
		builder.append(", finished=");
		builder.append(finished);
		builder.append(", meetingPoint=");
		builder.append(meetingPoint);
		builder.append(", startingDate=");
		builder.append(startingDate);
		builder.append(", endingDate=");
		builder.append(endingDate);
		builder.append("]");
		return builder.toString();
	}

	public static class SeasonEventBuilder {
		private Event event;
		private Season season;
		private boolean finished;
		private String meeting_pointt;
		private String comments;
		private LocalDate starting_date ;
		private LocalDate ending_date ;
		private LocalTime starting_time;
		private LocalTime ending_time;
		
		public SeasonEventBuilder setEvent(Event event) {
			this.event = event;
			return this;
		}
		public SeasonEventBuilder setSeason(Season season) {
			this.season = season;
			return this;
		}
		public SeasonEventBuilder setFinished(boolean finished) {
			this.finished = finished;
			return this;
		}
		public SeasonEventBuilder setMeeting_pointt(String meeting_pointt) {
			this.meeting_pointt = meeting_pointt;
			return this;
		}
		public SeasonEventBuilder setComments(String comments) {
			this.comments = comments;
			return this;
		}
		public SeasonEventBuilder setStarting_date(LocalDate starting_date) {
			this.starting_date = starting_date;
			return this;
		}
		public SeasonEventBuilder setEnding_date(LocalDate ending_date) {
			this.ending_date = ending_date;
			return this;
		}
		public SeasonEventBuilder setStarting_time(LocalTime starting_time) {
			this.starting_time = starting_time;
			return this;
		}
		public SeasonEventBuilder setEnding_time(LocalTime ending_time) {
			this.ending_time = ending_time;
			return this;
		}

		
		public SeasonEvent build() {
			return new SeasonEvent(event, season, finished, meeting_pointt, comments, starting_date, ending_date, starting_time, ending_time);
		}
		
	}
}
