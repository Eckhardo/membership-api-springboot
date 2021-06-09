/**
 * 
 */
package com.eki.membership.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.eki.membership.persistence.interfaces.IByIdApi;
import com.eki.membership.persistence.model.User;


/**
 * @author eckhard kirschning
 *
 */
public interface IUserJpaRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>, IByIdApi<User>  {

    User findByUserName(String userName);
  
	
}
