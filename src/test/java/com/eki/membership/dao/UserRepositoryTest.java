/**
 * 
 */
package com.eki.membership.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.eki.membership.persistence.dao.IUserJpaRepository;
import com.eki.membership.persistence.model.User;
import com.eki.membership.persistence.model.User.UserBuilder;

/**
 * @author eckha
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
		userRepository.save(newUser);

		// when
		User found = userRepository.findByUserName(newUser.getUserName());

		// then
		assertThat(found.getUserName()).isEqualTo(newUser.getUserName());
	}

	@Override
	protected User createNewEntity() {
		UserBuilder builder = new User.UserBuilder();
		builder.setUserName("Otto").setFirstName("Otto").setLastName("Bismarck").setCity("Hamburg")
				.setAddress("Luruper Weg 4");
		builder.setZip(20257).setAdmissionYear(2021).setAdmissionDate(LocalDate.now()).setMobil("0156234234");
		builder.setPhone("040 4913656").setEmail("otto@gmx.de").setIsActive(true).setIsAdmin(false);

		return builder.build();

	}

	@Override
	protected IUserJpaRepository getApi() {
		return userRepository;
	}
}