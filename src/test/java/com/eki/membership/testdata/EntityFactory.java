/**
 * 
 */
package com.eki.membership.testdata;

import java.time.LocalDate;

import com.eki.membership.persistence.model.Event;
import com.eki.membership.persistence.model.Event.EventBuilder;
import com.eki.membership.persistence.model.Season;
import com.eki.membership.persistence.model.Season.SeasonBuilder;
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
		builder.setUserName("Otto").setFirstName("Otto").setLastName("Bismarck").setCity("Hamburg")
				.setAddress("Luruper Weg 4");
		builder.setZip(20257).setAdmissionYear(2021).setAdmissionDate(LocalDate.now()).setMobil("0156234234");
		builder.setPhone("040 4913656").setEmail("otto@gmx.de").setIsActive(true).setIsAdmin(false);

		return builder.build();

	}

	public static Event createEvent() {

		EventBuilder builder = new Event.EventBuilder();
		builder.setEventName("Arbeitsdienst 1").setComment("Im Frühjahr").setEventShort("AD1");

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
}
