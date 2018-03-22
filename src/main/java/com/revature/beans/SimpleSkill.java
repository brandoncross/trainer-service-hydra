package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Simple Skill.
 */
@Entity
@Table(name = "HYDRA_SKILL")
@Cacheable
public class SimpleSkill implements Serializable {
	private static final long serialVersionUID = -9222096298296205812L;

	@Id
	@Column(name = "SKILL_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SKILL_ID_SEQUENCE")
	@SequenceGenerator(name = "SKILL_ID_SEQUENCE", sequenceName = "SKILL_ID_SEQUENCE", initialValue = 1, allocationSize = 1)
	@JsonProperty(value = "skillId")
	private Integer skillId;

	@JsonProperty(value = "skillName")
	@Column(name = "SKILL_NAME")
	private String skillName;

	@JsonProperty(value = "active")
	@Column(name = "IS_ACTIVE", nullable = false)
	private Boolean active;

	/**
	 * Instantiates a new Skill.
	 */
	public SimpleSkill() {
		super();
	}

	/**
	 * Create new skill
	 * 
	 * @param skillName
	 * @param active
	 */
	public SimpleSkill(String skillName, Boolean active) {
		super();
		this.skillName = skillName;
		this.active = active;
	}

	public SimpleSkill(Skill skill) {
		super();
		this.skillId = skill.getSkillId();
		this.skillName = skill.getSkillName();
		this.active = skill.isActive();
	}

	/**
	 * Gets skill id.
	 *
	 * @return the skill id
	 */
	public Integer getSkillId() {
		return skillId;
	}

	/**
	 * Sets skill id.
	 *
	 * @param skillId
	 *            the skill id
	 */
	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	/**
	 * Gets skill name.
	 *
	 * @return the skill name
	 */
	public String getSkillName() {
		return skillName;
	}

	/**
	 * Sets skill name.
	 *
	 * @param skillName
	 *            the skill name
	 */
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((skillName == null) ? 0 : skillName.hashCode());
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
		SimpleSkill other = (SimpleSkill) obj;
		if (active != other.active)
			return false;
		if (skillName == null) {
			if (other.skillName != null)
				return false;
		} else if (!skillName.equals(other.skillName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return skillName;
	}

}
