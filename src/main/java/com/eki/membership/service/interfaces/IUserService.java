/**
 * 
 */
package com.eki.membership.service.interfaces;

import com.eki.membership.persistence.model.User;

/**
 * @author eckhard kirschning
 *
 */
public interface IUserService extends IService<User> {
	   User findByUserName(final String name) ;
}
