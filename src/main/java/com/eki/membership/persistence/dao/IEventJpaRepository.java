
package com.eki.membership.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.eki.membership.persistence.interfaces.IByIdApi;
import com.eki.membership.persistence.model.Event;
import com.eki.membership.persistence.model.User;

/**
 * @author eckhard kirschning
 *
 */
public interface IEventJpaRepository
		extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event>, IByIdApi<Event> {
	
	Event findByEventName(String eventName);
}
