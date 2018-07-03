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
@Table(name = "foodtype", catalog = "lvcitydb")
public class Foodtype implements java.io.Serializable {

	// Fields

	private Integer ftid;
	private String ft;
	private Set<Food> foods = new HashSet<Food>(0);

	// Constructors

	/** default constructor */
	public Foodtype() {
	}

	/** minimal constructor */
	public Foodtype(String ft) {
		this.ft = ft;
	}

	/** full constructor */
	public Foodtype(String ft, Set<Food> foods) {
		this.ft = ft;
		this.foods = foods;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "ftid", unique = true, nullable = false)

	public Integer getFtid() {
		return this.ftid;
	}

	public void setFtid(Integer ftid) {
		this.ftid = ftid;
	}

	@Column(name = "ft", nullable = false, length = 50)

	public String getFt() {
		return this.ft;
	}

	public void setFt(String ft) {
		this.ft = ft;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "foodtype")

	public Set<Food> getFoods() {
		return this.foods;
	}

	public void setFoods(Set<Food> foods) {
		this.foods = foods;
	}

}