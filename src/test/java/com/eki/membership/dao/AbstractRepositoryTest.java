/**
 * 
 */
package com.eki.membership.dao;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.eki.membership.persistence.dao.IUserJpaRepository;
import com.eki.membership.persistence.interfaces.IEntity;
import com.eki.membership.spring.MembershipApp;

/**
 * @author eckha
 *
 *@ContextConfiguraion and all other Annotations are mandatory.
 *
 *
 */
@ContextConfiguration(classes=MembershipApp.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@Rollback(true)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestPropertySource(locations="classpath:application-test.properties")
	public abstract class AbstractRepositoryTest<T extends IEntity, ID> {

		@Test
		public void givenResourceExists_whenResourceIsSaved_thenNoExceptions() {
			// Given
			final T existingResource = createNewEntity();

			// When
			getApi().save(existingResource);
		}

		@Test
		public final void givenResourceExists_whenResourceIsDeleted_thenResourceNoLongerExists() {
			// Given
			final T existingResource = createNewEntity();
			 T savedResource=	getApi().save(existingResource);
			// When
			getApi().delete(savedResource);
			
			ID id= (ID)  savedResource.getId();

			// Then
		java.util.Optional<T> retrievedResource=	getApi().findById(id);
		Assert.assertFalse(retrievedResource.isPresent());
		}
		
		protected abstract T createNewEntity();

		protected abstract PagingAndSortingRepository<T,ID> getApi();
}
