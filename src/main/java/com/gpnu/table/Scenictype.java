package com.gpnu.table;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "scenictype", catalog = "lvcitydb")

public class Scenictype implements java.io.Serializable {

	// Fields

	private Integer stid;
	private String st;
	private Set<Scenic> scenics = new HashSet<Scenic>(0);

	// Constructors

	/** default constructor */
	public Scenictype() {
	}

	/** minimal constructor */
	public Scenictype(String st) {
		this.st = st;
	}

	/** full constructor */
	public Scenictype(String st, Set<Scenic> scenics) {
		this.st = st;
		this.scenics = scenics;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "stid", unique = true, nullable = false)

	public Integer getStid() {
		return this.stid;
	}

	public void setStid(Integer stid) {
		this.stid = stid;
	}

	@Column(name = "st", nullable = false, length = 50)

	public String getSt() {
		return this.st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "scenictype")

	public Set<Scenic> getScenics() {
		return this.scenics;
	}

	public void setScenics(Set<Scenic> scenics) {
		this.scenics = scenics;
	}

}