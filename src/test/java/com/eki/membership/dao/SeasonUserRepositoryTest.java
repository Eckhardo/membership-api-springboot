/**
 * 
 */
package com.eki.membership.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.eki.membership.persistence.dao.ISeasonJpaRepository;
import com.eki.membership.persistence.dao.ISeasonUserJpaRepository;
import com.eki.membership.persistence.dao.IUserJpaRepository;
import com.eki.membership.persistence.model.Season;
import com.eki.membership.persistence.model.SeasonUser;
import com.eki.membership.persistence.model.User;
import com.eki.membership.testdata.EntityFactory;

/**
 * @author eckhard kirschning
 *
 */
@Transactional
public class SeasonUserRepositoryTest extends AbstractRepositoryTest<SeasonUser, Long> {

	@Autowired
	private ISeasonUserJpaRepository repository;

	@Autowired
	private IUserJpaRepository userRepo;

	@Autowired
	private ISeasonJpaRepository seasonRepo;

	@Test
	public void whenFindBySeasonYear_thenReturnAllRegisteredUsers() {
		// given
		List<User> seasonUsers = getApi().findAllUsersBySeasonYear(2021);

		// when
	
		// then
	Assertions.assertEquals(seasonUsers.size(), 4);

	}

	@Override
	protected SeasonUser createNewEntity() {

		List<User> users = userRepo.findAll();
		Assertions.assertFalse(users.isEmpty());
		List<Season> seasons = seasonRepo.findAll();
		Assertions.assertFalse(seasons.isEmpty());
		return EntityFactory.createSeasonUser(users.get(0), seasons.get(0));
	}

	@Override
	protected ISeasonUserJpaRepository getApi() {
		return repository;
	}
}
