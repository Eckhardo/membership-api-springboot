/**
 * 
 */
package com.eki.membership.dao;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eki.membership.persistence.dao.IEventJpaRepository;
import com.eki.membership.persistence.model.Event;
import com.eki.membership.testdata.EntityFactory;


/**
 * @author eckhard kirschning
 *
 */

public class EventRepositoryTest extends AbstractRepositoryTest<Event, Long> {

	@Autowired
	private IEventJpaRepository eventRepository;

	@Test
	public void whenCreateNewEvent_thenEventCanBeRetrievedByName() {

		Event newEvent = createNewEntity();
		getApi().save(newEvent);

		Event retrieved = getApi().findByEventName(newEvent.getEventName());

		assertThat(retrieved.getEventName()).isEqualTo(newEvent.getEventName());

	}

	@Override
	protected Event createNewEntity() {
		return EntityFactory.createEvent();
	}

	@Override
	protected IEventJpaRepository getApi() {
		return eventRepository;
	}

}
