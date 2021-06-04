/**
 * 
 */
package com.eki.membership.persistence.interfaces;

/**
 * @author eckha
 *
 */
public interface IByIdApi<T extends IWithId> {

	   T findOneById(final Long id);
}
