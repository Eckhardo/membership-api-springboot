package com.eki.membership.service.interfaces;

import org.springframework.data.domain.Page;

import com.eki.membership.persistence.interfaces.IWithId;
import com.eki.membership.persistence.interfaces.IWithName;
/**
 * @author eckhard kirschning
 *
 */
public interface IService<T extends IWithId> extends IOperations<T> {

    Page<T> findAllPaginatedAndSortedRaw(final int page, final int size, final String sortBy, final String sortOrder);

    Page<T> findAllPaginatedRaw(final int page, final int size);

}
