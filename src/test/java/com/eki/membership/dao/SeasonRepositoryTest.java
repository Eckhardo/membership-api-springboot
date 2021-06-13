/**
 * 
 */
package com.eki.membership.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.eki.membership.persistence.dao.ISeasonJpaRepository;
import com.eki.membership.persistence.model.Season;
import com.eki.membership.testdata.EntityFactory;

/**
 * @author eckhard kirschning
 *
 */
class SeasonRepositoryTest extends AbstractRepositoryTest<Season, Long> {

	@Autowired

	private ISeasonJpaRepository repository;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("set up....");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tear down....");
	}

	@Test
	void whenCreateNew_thenFindBySeasonNameIsSuccessfull() {

		Season newSeason = createNewEntity();
		// given
		getApi().save(newSeason);

		// when
		Season found = getApi().findBySeasonName(newSeason.getSeasonName());

		// then
		assertThat(found.getSeasonDate()).isEqualTo(newSeason.getSeasonDate());

	}

	@Override
	protected Season createNewEntity() {
		return EntityFactory.createSeason();
	}

	@Override
	protected ISeasonJpaRepository getApi() {
		return repository;
	}

}
