package com.eki.membership.persistence.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.eki.membership.persistence.interfaces.IDto;
import com.eki.membership.persistence.interfaces.IEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER")
public class User implements IEntity, IDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3380215493329272193L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false)
	private String user_name;

	@Column(unique = false, nullable = false)
	@Size(min = 2, max = 30)
	@NotNull
	private String first_name;

	@Column(unique = false, nullable = false)
	@Size(min = 2, max = 50)
	@NotNull
	private String last_name;

	@Column(unique = false, nullable = false)
	@NotNull
	private String city;

	@Column(unique = false, nullable = false)
	@NotNull
	private String address;

	@Column(unique = false, nullable = false)
	@NotNull
	private int zip;

	@Column()
	private String mobil;

	@Column()
	private String phone;

	@Email(message = "{user.email.invalid}")
	@NotEmpty(message = "Please enter email")
	private String email;

	@Column()
	@NotNull
	private int admission_year;

	@Column()
	private LocalDate admission_date;

	@Column()
	private boolean is_active;

	@Column()
	private boolean is_admin;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
