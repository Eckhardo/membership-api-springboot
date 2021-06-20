/**
 * 
 */
package com.eki.membership.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eki.membership.persistence.dao.IEventJpaRepository;
import com.eki.membership.persistence.dao.IUserJpaRepository;
import com.eki.membership.persistence.model.Event;
import com.eki.membership.persistence.model.User;
import com.eki.membership.service.interfaces.IEventService;
/**
 * @author eckhard kirschning
 *
 */
@Service
@Transactional
public class EventServiceImpl  extends AbstractService<Event> implements IEventService {
	
	
	@Autowired
	private IEventJpaRepository dao;
	
	
	
    public EventServiceImpl() {
        super();
    }

     


	@Override
	public Event findByEventName(String eventName) {
		return getDao().findByEventName(eventName);
	}


	@Override
	protected IEventJpaRepository getDao() {
		return dao;
	}

	
	@Override
	protected JpaSpecificationExecutor<Event> getSpecificationExecutor() {
		return dao;
	}




}
