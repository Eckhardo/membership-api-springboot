/**
 * 
 */
package com.eki.membership.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.eki.membership.persistence.interfaces.IEntity;
import com.eki.membership.spring.MembershipPersistenceJpaConfig;
import com.eki.membership.spring.StartupLoggingComponent;

/**
 * @author eckhard kirschning
 *
 * @ContextConfiguraion and all other Annotations are mandatory.
 *
 *
 */
@SpringBootTest(classes = { MembershipPersistenceJpaConfig.class, StartupLoggingComponent.class })
@Transactional
@AutoConfigureTestDatabase(replace = Replace.NONE)

@ActiveProfiles("test")
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
		T savedResource = getApi().save(existingResource);
		// When
		getApi().delete(savedResource);

		ID id = (ID) savedResource.getId();

		// Then
		java.util.Optional<T> retrievedResource = getApi().findById(id);
		Assertions.assertFalse(retrievedResource.isPresent());
	}

	protected abstract T createNewEntity();

	protected abstract PagingAndSortingRepository<T, ID> getApi();
}
