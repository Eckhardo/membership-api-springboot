/**
 * 
 */
package com.eki.membership.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.eki.membership.persistence.interfaces.IEntity;
import com.eki.membership.service.interfaces.IService;
import com.eki.membership.spring.MembershipPersistenceJpaConfig;
import com.eki.membership.spring.MembershipServiceConfig;
import com.eki.membership.spring.StartupLoggingComponent;

/**
 * @author eckhard kirschning
 *
 */
@SpringBootTest(classes = { MembershipPersistenceJpaConfig.class, MembershipServiceConfig.class,
		StartupLoggingComponent.class })

@AutoConfigureTestDatabase(replace = Replace.NONE)

@ActiveProfiles("test")
public abstract class AbstractServiceIntegrationTest<T extends IEntity> {

	@Test
	public void givenResourceExists_whenResourceIsRetrieved_thenNoExceptions() {
		// Given
		final T existingResource = persistNewEntity();

		// When
		T resource = getApi().findOne(existingResource.getId());

		// Then
		assertThat(resource, notNullValue());
	}

	@Test
	public final void givenResourceDoesNotExist_whenResourceIsRetrieved_thenNoResourceIsReceived() {
		// When
		final T resource = getApi().findOne(generateRandomLong());

		// Then
		assertThat(resource, is(nullValue()));
	}

	@Test
	public void givenResourceExists_whenResourceIsRetrieved_thenResourceIsRetrievedCorrectly() {
		// Given
		final T existingResource = persistNewEntity();

		// When
		final T retrievedResource = getApi().findOne(existingResource.getId());

		// Then
		assertThat(existingResource, is(equalTo(retrievedResource)));
	}


	public void whenNullResourceIsCreated_thenException() {
		getApi().create(null);
	}
	
	
    @Test
    public void whenResourceIsUpdatedWithFailedConstraints_thenException() {
        final T existingResource = persistNewEntity();
        invalidate(existingResource);
        
        Assertions.assertThrows(Exception.class, () -> {
        	 getApi().update(existingResource);
         }); 
    }

	@Test
	public void whenResourceIsCreated_thenNoExceptions() {
		persistNewEntity();
	}

	@Test
	public void whenResourceIsCreated_thenResourceIsRetrievable() {
		final T existingResource = persistNewEntity();

		T resource = getApi().findOne(existingResource.getId());
		assertThat(resource, is(notNullValue()));
	}

	@Test
	public void whenResourceIsCreated_thenSavedResourceIsEqualToOriginalResource() {
		final T originalResource = createNewEntity();
		final T savedResource = getApi().create(originalResource);

		assertThat(originalResource, is(equalTo(savedResource)));

	}

	@Test
	public void givenResourceExists_whenResourceIsUpdated_thenNoExceptions() {
		// Given
		final T existingResource = persistNewEntity();

		// When
		getApi().update(existingResource);
	}

	@Test
	/**/public final void givenResourceExists_whenResourceIsRetrievedByName_thenNoExceptions() {
		// Given
		final T existingResource = getApi().create(createNewEntity());

		// When
		getApi().findOne(existingResource.getId());
	}

	@Test
	/**/public final void givenResourceExists_whenResourceIsRetrievedByName_thenResourceIsFound() {
		// Given
		final T existingResource = getApi().create(createNewEntity());

		// When
		final T resourceByName = getApi().findOne(existingResource.getId());

		// Then
		assertThat(existingResource, is(notNullValue()));

	}

	@Test
	/**/public final void givenResourceExists_whenResourceIsRetrievedByName_thenFoundResourceIsCorrect() {
		// Given
		final T existingResource = getApi().create(createNewEntity());
		// When
		final T resourceByName = getApi().findOne(existingResource.getId());

		// Then
		assertThat(existingResource, equalTo(resourceByName));
	}

	protected long generateRandomLong() {
		Random rd = new Random();
		return rd.nextLong();
	}

	protected String generateRandomString() {
		return RandomStringUtils.randomAlphanumeric(10);

	}

	protected T persistNewEntity() {
		return getApi().create(createNewEntity());
	}

	protected abstract void invalidate(T invalidResource);

	protected abstract void change(T changedResource);

	protected abstract T createNewEntity();

	protected abstract IService<T> getApi();

}
