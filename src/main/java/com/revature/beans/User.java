package com.revature.beans;

import java.util.List;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "USER")
@Cacheable
public class User {
	@Id
	@SequenceGenerator(name = "USER_ID", sequenceName = "USER_ID")
	@GeneratedValue(generator = "USER_ID", strategy = GenerationType.AUTO)
	private Integer userId;
	
	@NotEmpty
	@Column(name = "FIRST_NAME", nullable = false)
	@JsonProperty
	private String firstName;
	
	@NotEmpty
	@Column(name = "MIDDLE_NAME", nullable = false)
	@JsonProperty
	private String middleName;
	
	@NotEmpty
	@Column(name = "LAST_NAME", nullable = false)
	@JsonProperty
	private String lastName;

	@NotEmpty
	@Column(name = "TITLE", nullable = false)
	@JsonProperty
	private String title;

	@NotEmpty
	@Email
	@Column(name = "EMAIL", nullable = false, unique = true, updatable = true)
	@JsonProperty
	private String email;
	
	@NotEmpty
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	private String backupPassword;

	@Column(name = "ROLE", nullable = false)
	private Integer role;

	private String homePhone;

	private String mobilePhone;

	private String token;

	@ElementCollection(targetClass = Integer.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	@CollectionTable(name = "BATCH", joinColumns = @JoinColumn(name="t_id"))
	@Column(name="BATCH_ID")
	private Set<Integer> batches;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String firstName, String middleName, String lastName, String email, String password,
			String backupPassword, Integer role, String homePhone, String mobilePhone, String token, Integer userId,
			String title, Set<Integer> batches) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.backupPassword = backupPassword;
		this.role = role;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.token = token;
		this.userId = userId;
		this.title = title;
		this.batches = batches;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBackupPassword() {
		return backupPassword;
	}

	public void setBackupPassword(String backupPassword) {
		this.backupPassword = backupPassword;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Integer> getBatches() {
		return batches;
	}

	public void setBatches(Set<Integer> batches) {
		this.batches = batches;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((backupPassword == null) ? 0 : backupPassword.hashCode());
		result = prime * result + ((batches == null) ? 0 : batches.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((homePhone == null) ? 0 : homePhone.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + ((mobilePhone == null) ? 0 : mobilePhone.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
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
		if (backupPassword == null) {
			if (other.backupPassword != null)
				return false;
		} else if (!backupPassword.equals(other.backupPassword))
			return false;
		if (batches == null) {
			if (other.batches != null)
				return false;
		} else if (!batches.equals(other.batches))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (homePhone == null) {
			if (other.homePhone != null)
				return false;
		} else if (!homePhone.equals(other.homePhone))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (mobilePhone == null) {
			if (other.mobilePhone != null)
				return false;
		} else if (!mobilePhone.equals(other.mobilePhone))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", email="
				+ email + ", backupPassword=" + backupPassword + ", role=" + role + ", homePhone=" + homePhone
				+ ", mobilePhone=" + mobilePhone + ", token=" + token + ", userId=" + userId + ", title=" + title
				+ ", batches=" + batches + "]";
	}

}
