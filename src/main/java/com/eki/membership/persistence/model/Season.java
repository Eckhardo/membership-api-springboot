/**
 * 
 */
package com.eki.membership.persistence.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.eki.membership.persistence.interfaces.IDto;
import com.eki.membership.persistence.interfaces.IEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author eckhard kirschning
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SEASON")
public class Season   implements IEntity, IDto  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7467681945161675216L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(unique = true, nullable = false)
	private String season_name;

	@Column()
	private boolean is_active;
	
	@Column()
	@NotNull
	private int season_year;

	@Column()
	private LocalDate season_date;



	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
