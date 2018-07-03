package com.gpnu.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "team", catalog = "lvcitydb")

public class Team implements java.io.Serializable {

	// Fields

	private Integer teamid;
	private String content;

	// Constructors

	/** default constructor */
	public Team() {
	}

	/** full constructor */
	public Team(String content) {
		this.content = content;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "teamid", unique = true, nullable = false)

	public Integer getTeamid() {
		return this.teamid;
	}

	public void setTeamid(Integer teamid) {
		this.teamid = teamid;
	}

	@Column(name = "content", nullable = false, length = 65535)

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}