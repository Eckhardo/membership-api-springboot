package com.eki.membership.persistence.model;

import java.time.LocalDate;
import java.util.Objects;

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


/**
 * @author eckhard kirschning
 *
 */


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
	private String userName;

	@Column(unique = false, nullable = false)
	@Size(min = 2, max = 30)
	@NotNull
	private String firstName;

	@Column(unique = false, nullable = false)
	@Size(min = 2, max = 50)
	@NotNull
	private String lastName;

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
	private int admissionYear;

	@Column()
	private LocalDate admissionDate;

	@Column()
	private boolean isActive;

	@Column()
	private boolean isAdmin;
	
	
	

	public User() {
		super();
	}

	public User(String user_name, @Size(min = 2, max = 30) @NotNull String first_name,
			@Size(min = 2, max = 50) @NotNull String last_name, @NotNull String city, @NotNull String address,
			@NotNull int zip, String mobil, String phone,
			@Email(message = "{user.email.invalid}") @NotEmpty(message = "Please enter email") String email,
			@NotNull int admission_year, LocalDate admission_date, boolean is_active, boolean is_admin) {
		super();

		this.userName = user_name;
		this.firstName = first_name;
		this.lastName = last_name;
		this.city = city;
		this.address = address;
		this.zip = zip;
		this.mobil = mobil;
		this.phone = phone;
		this.email = email;
		this.admissionYear = admission_year;
		this.admissionDate = admission_date;
		this.isActive = is_active;
		this.isAdmin = is_admin;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAdmissionYear() {
		return admissionYear;
	}

	public void setAdmissionYear(int admissionYear) {
		this.admissionYear = admissionYear;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, admissionDate, admissionYear, city, email, firstName, id, isActive, isAdmin,
				lastName, mobil, phone, userName, zip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(address, other.address) && Objects.equals(admissionDate, other.admissionDate)
				&& admissionYear == other.admissionYear && Objects.equals(city, other.city)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && isActive == other.isActive && isAdmin == other.isAdmin
				&& Objects.equals(lastName, other.lastName) && Objects.equals(mobil, other.mobil)
				&& Objects.equals(phone, other.phone) && Objects.equals(userName, other.userName) && zip == other.zip;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + userName + ", first_name=" + firstName + ", last_name=" + lastName
				+ ", city=" + city + ", address=" + address + ", zip=" + zip + ", mobil=" + mobil + ", phone=" + phone
				+ ", email=" + email + ", admission_year=" + admissionYear + ", admission_date=" + admissionDate
				+ ", is_active=" + isActive + ", is_admin=" + isAdmin + "]";
	}



	public static class UserBuilder {
		
	    private String user_name;
	    private String first_name;
	    private String last_name;
	    private String city;
	    private String address;
	    private int zip;
	    private String mobil;  
	    private String phone;
	    private String email;
	    private int admission_year;
	    private LocalDate admission_date;
	    private boolean is_active;
	    private boolean is_admin;
	    public UserBuilder setUserName(String user_name) {
	        this.user_name = user_name;
	        return this;
	    }
	    public UserBuilder setFirstName(String first_name) {
	        this.first_name = first_name;
	        return this;
	    }
	    public UserBuilder setLastName(String last_name) {
	        this.last_name = last_name;
	        return this;
	    }
	
	    
	    public UserBuilder setCity(String city) {
			this.city = city;
		    return this;
		}
		public UserBuilder setAddress(String address) {
			this.address = address;
		    return this;
		}
		public UserBuilder setZip(int zip) {
			this.zip = zip;
		    return this;
		}
		public UserBuilder setMobil(String mobil) {
			this.mobil = mobil;
		    return this;
		}
		public UserBuilder setPhone(String phone) {
			this.phone = phone;
		    return this;
		}
		public UserBuilder setEmail(String email) {
			this.email = email;
		    return this;
		}
		public UserBuilder setAdmissionYear(int admission_year) {
			this.admission_year = admission_year;
		    return this;
		}
		public UserBuilder setAdmissionDate(LocalDate admission_date) {
			this.admission_date = admission_date;
		    return this;
		}
		public UserBuilder setIsActive(boolean is_active) {
			this.is_active = is_active;
		    return this;
		}
		public UserBuilder setIsAdmin(boolean is_admin) {
			this.is_admin = is_admin;
		    return this;
		}
		public User build() {
	        return new User( user_name,  first_name,last_name, city, address, zip, mobil, phone, email,
	    			 admission_year, admission_date, is_active, is_admin);
	    }
	}
}
