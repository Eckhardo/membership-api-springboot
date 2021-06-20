/**
 * 
 */
package com.eki.membership.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eki.membership.persistence.dao.IUserJpaRepository;
import com.eki.membership.persistence.model.User;
import com.eki.membership.service.interfaces.IUserService;

/**
 * @author eckhard kirschning
 *
 */
@Service
@Transactional
public class UserServiceImpl  extends AbstractService<User> implements IUserService {

	@Autowired
	private IUserJpaRepository dao;
	
	
	
    public UserServiceImpl() {
        super();
    }

     
    @Transactional(readOnly = true)
	@Override
    public User findByUserName(final String name) {
        return dao.findByUserName(name);
    }



	@Override
	protected IUserJpaRepository getDao() {
		return dao;
	}

	@Override
	protected JpaSpecificationExecutor<User> getSpecificationExecutor() {
		return dao;
	}

}
