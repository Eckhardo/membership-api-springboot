/**
 * 
 */
package com.eki.membership.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.eki.membership.persistence.dao.IUserJpaRepository;
import com.eki.membership.persistence.model.User;
import com.eki.membership.testdata.EntityFactory;

/**
 * @author eckhard kirschning
 *
 */

public class UserRepositoryTest extends AbstractRepositoryTest<User, Long> {

	@Autowired
	private IUserJpaRepository userRepository;

	// write test cases here
	@Test
	public void whenFindByUserName_thenReturnUser() {
		User newUser = createNewEntity();
		newUser.setFirstName("Adolf");

		// given
		getApi().save(newUser);

		// when
		User found = getApi().findByUserName(newUser.getUserName());

		// then
		assertThat(found.getUserName()).isEqualTo(newUser.getUserName());

	}

	@Override
	protected User createNewEntity() {

		return EntityFactory.createUser();
	}

	@Override
	protected IUserJpaRepository getApi() {
		return userRepository;
	}
}