/**
 * 
 */
package com.eki.membership.testdata;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.time.LocalDate;
import java.time.LocalTime;

import com.eki.membership.persistence.model.Event;
import com.eki.membership.persistence.model.Event.EventBuilder;
import com.eki.membership.persistence.model.Season;
import com.eki.membership.persistence.model.Season.SeasonBuilder;
import com.eki.membership.persistence.model.SeasonEvent;
import com.eki.membership.persistence.model.SeasonEvent.SeasonEventBuilder;
import com.eki.membership.persistence.model.SeasonUser;
import com.eki.membership.persistence.model.SeasonUser.SeasonUserBuilder;
import com.eki.membership.persistence.model.User;
import com.eki.membership.persistence.model.User.UserBuilder;

/**
 * @author eckhard kirschning
 *
 */
public class EntityFactory {

	public static User createUser() {

		UserBuilder builder = new User.UserBuilder();
		builder.setUserName( randomAlphabetic(8)).setFirstName("Otto").setLastName("Bismarck").setCity("Hamburg")
				.setAddress("Luruper Weg 4");
		builder.setZip(20257).setAdmissionYear(2021).setAdmissionDate(LocalDate.now()).setMobil("0156234234");
		builder.setPhone("040 4913656").setEmail("otto@gmx.de").setIsActive(true).setIsAdmin(false);

		return builder.build();

	}

	public static Event createEvent() {

		EventBuilder builder = new Event.EventBuilder();
		builder.setEventName("Arbeitsdienst 3").setComment("ImHerbst").setEventShort("AD3");

		return builder.build();

	}

	public static Season createSeason() {
		SeasonBuilder builder = new Season.SeasonBuilder();
		builder.setName("Season 2023").setIsActive(false).setYear(2023).setDate(LocalDate.now());
		return builder.build();
	}

	public static SeasonUser createSeasonUser(User user, Season season) {
		SeasonUserBuilder builder = new SeasonUser.SeasonUserBuilder();
		builder.setIsActive(true).setIsFeesPaid(true).setPositionRole("Schriftführer").setUser(user).setSeason(season);
		;
		return builder.build();
	}

	public static SeasonEvent createSeasonEvent(Event event, Season season) {
	SeasonEventBuilder builder =new SeasonEvent.SeasonEventBuilder();
	builder.setEvent(event).setSeason(season).setFinished(false).setComments("No comment")
	.setStarting_date(LocalDate.now()).setEnding_date(LocalDate.now())
	.setStarting_time(LocalTime.of(8, 0)).setEnding_time(LocalTime.of(12, 0));
	return builder.build();
	}
}
