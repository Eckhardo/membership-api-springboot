/**
 * 
 */
package com.eki.membership.service.interfaces;

import com.eki.membership.persistence.model.Event;

/**
 * @author eckhard kirschning
 *
 */
public interface IEventService extends IService<Event> {
	Event findByEventName(String eventName);
}
