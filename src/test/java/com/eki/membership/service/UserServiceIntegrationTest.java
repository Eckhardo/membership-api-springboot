/**
 * 
 */
package com.eki.membership.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.eki.membership.persistence.model.User;
import com.eki.membership.service.interfaces.IUserService;
import com.eki.membership.testdata.EntityFactory;

/**
 * @author eckhard kirschning
 *
 */

public class UserServiceIntegrationTest extends AbstractServiceIntegrationTest<User> {

	@Autowired
	private IUserService userService;

	@Test
	public void whenResourceIsCreated_thenFindByUserName() {
		// Given
		User user = persistNewEntity();
		// When
		User foundResoucre = getApi().findByUserName(user.getUserName());
		// Then
		assertThat(foundResoucre.getUserName(), is(equalTo(user.getUserName())));
	}

	@Override
	protected void invalidate(User invalidResource) {
		invalidResource.setUserName(null);
	}

	@Override
	protected void change(User user) {
		user.setFirstName(generateRandomString());

	}

	@Override
	protected User createNewEntity() {
		return EntityFactory.createUser();
	}

	@Override
	protected IUserService getApi() {
		return userService;
	}

}
