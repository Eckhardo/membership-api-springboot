/**
 * 
 */
package com.eki.membership.persistence.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.eki.membership.persistence.interfaces.IDto;
import com.eki.membership.persistence.interfaces.IEntity;

/**
 * @author eckhard kirschning
 *
 */


@Entity
@Table(name = "EVENT")
public class Event implements IEntity, IDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false)
	private String eventName;

	@Column(unique = true, nullable = false, length = 3)
	@Size(min = 2, max = 3)
	private String eventShort;

	@Column()
	private String comments;

	public Event() {
		super();
	}

	public Event(String eventName, @Size(min = 2, max = 3) String eventShort, String comments) {
		super();
		this.eventName = eventName;
		this.eventShort = eventShort;
		this.comments = comments;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventShort() {
		return eventShort;
	}

	public void setEventShort(String eventShort) {
		this.eventShort = eventShort;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comments, eventName, eventShort, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		return Objects.equals(comments, other.comments) && Objects.equals(eventName, other.eventName)
				&& Objects.equals(eventShort, other.eventShort) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Event [id=");
		builder.append(id);
		builder.append(", eventName=");
		builder.append(eventName);
		builder.append(", eventShort=");
		builder.append(eventShort);
		builder.append(", comments=");
		builder.append(comments);
		builder.append("]");
		return builder.toString();
	}

	public static class EventBuilder {

		private String event_name;
		private String event_short;
		private String comments;

		public EventBuilder setEventName(String eventName) {
			this.event_name = eventName;
			return this;
		}

		public EventBuilder setEventShort(String eventShort) {
			this.event_short = eventShort;
			return this;
		}

		public EventBuilder setComment(String comment) {
			this.comments = this.comments != null ? ", " + comment : comment;
			return this;
		}
		
		public Event build () {
			
			return new Event(event_name, event_short, comments);
			
		}
	}
}
