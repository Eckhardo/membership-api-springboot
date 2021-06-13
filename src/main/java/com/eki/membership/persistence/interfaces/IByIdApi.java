/**
 * 
 */
package com.eki.membership.persistence.interfaces;

/**
 * @author eckhard kirschning
 *
 */
public interface IByIdApi<T extends IWithId> {

	T findOneById(final Long id);
}
