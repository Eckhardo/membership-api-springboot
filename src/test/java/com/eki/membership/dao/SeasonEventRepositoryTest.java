package com.eki.membership.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.eki.membership.persistence.dao.IEventJpaRepository;
import com.eki.membership.persistence.dao.ISeasonEventJpaRepository;
import com.eki.membership.persistence.dao.ISeasonJpaRepository;
import com.eki.membership.persistence.model.Event;
import com.eki.membership.persistence.model.Season;
import com.eki.membership.persistence.model.SeasonEvent;
import com.eki.membership.testdata.EntityFactory;


/**
 * @author eckhard kirschning
 *
 */

public class SeasonEventRepositoryTest extends AbstractRepositoryTest<SeasonEvent, Long> {

	@Autowired
	private ISeasonEventJpaRepository repository;

	@Autowired
	private IEventJpaRepository eventRepo;

	@Autowired
	private ISeasonJpaRepository seasonRepo;

	@Test
	public void whenFindBySeasonYear_thenReturnAllRegisteredEvents() {
		//given 
		
		// when
		List<Event> seasonEvents = getApi().findAllEventsBySeasonYear(2021);

		// then
		Assertions.assertEquals(seasonEvents.size(), 4);


	}

	@Override
	protected SeasonEvent createNewEntity() {

		List<Event> events = eventRepo.findAll();
		Assertions.assertFalse(events.isEmpty());
		List<Season> seasons = seasonRepo.findAll();
		Assertions.assertFalse(seasons.isEmpty());
		return EntityFactory.createSeasonEvent(events.get(0), seasons.get(0));
	}

	@Override
	protected ISeasonEventJpaRepository getApi() {
		return repository;
	}
}