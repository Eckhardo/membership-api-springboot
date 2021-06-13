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
import com.eki.membership.persistence.model.SeasonUser;
import com.eki.membership.persistence.model.User;

/**
 * @author eckhard kirschning
 *
 */
public interface ISeasonUserJpaRepository
		extends JpaRepository<SeasonUser, Long>, JpaSpecificationExecutor<SeasonUser>, IByIdApi<SeasonUser> {
	@Query("SELECT su.user from SeasonUser as su where su.season.seasonYear = :year")
	List<User> findAllUsersBySeasonYear(@Param("year") int year);

}
