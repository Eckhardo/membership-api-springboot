/**
 * 
 */
package com.eki.membership.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.eki.membership.persistence.model.Event;
import com.eki.membership.persistence.model.User;
import com.eki.membership.service.interfaces.IEventService;
import com.eki.membership.service.interfaces.IService;
import com.eki.membership.testdata.EntityFactory;

/**
 * @author eckhard kirschning
 *
 */
public class EventServiceIntegrationTest extends AbstractServiceIntegrationTest<Event>{

	
	@Autowired
	
	private IEventService service;
	
	
	
	@Test
	public void whenResourceIsCreated_thenFindByUserName() {
		// Given
		Event event = persistNewEntity();
		// When
		Event foundResoucre = getApi().findByEventName(event.getEventName());
		// Then
		assertThat(foundResoucre.getEventName(), is(equalTo(event.getEventName())));
	}
	@Override
	protected void invalidate(Event invalidResource) {
	invalidResource.setEventName(null);
		
	}


	@Override
	protected void change(Event changedResource) {
		changedResource.setComments("No comment");
			
	}

	@Override
	protected Event createNewEntity() {
	
		return EntityFactory.createEvent();
	}

	
	@Override
	protected IEventService getApi() {
	return service;
	}

}
