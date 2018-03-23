package com.revature.beans;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "TRAINER")
@Cacheable
public class BatchTrainer {
	
	@Id
	@SequenceGenerator(name = "TRAINER_ID_SEQ", sequenceName = "TRAINER_ID_SEQ")
	@GeneratedValue(generator = "TRAINER_ID_SEQ", strategy = GenerationType.AUTO)
	private int trainerId;

	@OneToOne(cascade = CascadeType.ALL)
	//@Column(name = "USER_ID")
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@NotEmpty
	private String title;

	public BatchTrainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BatchTrainer(int trainerId, User user, String title) {
		super();
		this.trainerId = trainerId;
		this.user = user;
		this.title = title;
	}

	@Override
	public String toString() {
		return "BatchTrainer [trainerId=" + trainerId + ", user=" + user + ", title=" + title + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + trainerId;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		BatchTrainer other = (BatchTrainer) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (trainerId != other.trainerId)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}