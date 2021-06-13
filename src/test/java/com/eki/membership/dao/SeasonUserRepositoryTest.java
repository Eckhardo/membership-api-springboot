/**
 * 
 */
package com.eki.membership.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
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
	public void whenFindByUserName_thenReturnUser() {
		SeasonUser newSeasonUser = createNewEntity();

		// given
		SeasonUser user = getApi().save(newSeasonUser);

		// when
		List<SeasonUser> found = getApi().findAll();
		// then
		assertThat(found.get(0).getPositionRole()).isEqualTo(newSeasonUser.getPositionRole());

	}

	@Override
	protected SeasonUser createNewEntity() {

		List<User> users = userRepo.findAll();
		assertFalse(users.isEmpty());
		List<Season> seasons = seasonRepo.findAll();
		assertFalse(seasons.isEmpty());
		return EntityFactory.createSeasonUser(users.get(0), seasons.get(0));
	}

	@Override
	protected ISeasonUserJpaRepository getApi() {
		return repository;
	}
}
