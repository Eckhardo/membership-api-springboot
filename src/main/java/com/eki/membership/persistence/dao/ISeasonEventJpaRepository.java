/**
 * 
 */
package com.eki.membership.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eki.membership.persistence.interfaces.IByIdApi;
import com.eki.membership.persistence.model.Event;
import com.eki.membership.persistence.model.SeasonEvent;

/**
 * @author eckhard kirschning
 *
 */
public interface ISeasonEventJpaRepository
		extends JpaRepository<SeasonEvent, Long>, JpaSpecificationExecutor<SeasonEvent>, IByIdApi<SeasonEvent> {
	@Query("SELECT se.event from SeasonEvent as se where se.season.seasonYear = :year")
	List<Event> findAllEventsBySeasonYear(@Param("year") int year);

}
