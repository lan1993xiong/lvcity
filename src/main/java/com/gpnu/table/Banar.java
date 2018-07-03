package com.gpnu.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "banar", catalog = "lvcitydb")

public class Banar implements java.io.Serializable {

	// Fields

	private Integer banarid;
	private String image;
	private Integer state;

	// Constructors

	/** default constructor */
	public Banar() {
	}

	/** minimal constructor */
	public Banar(String image) {
		this.image = image;
	}

	/** full constructor */
	public Banar(String image, Integer state) {
		this.image = image;
		this.state = state;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "banarid", unique = true, nullable = false)

	public Integer getBanarid() {
		return this.banarid;
	}

	public void setBanarid(Integer banarid) {
		this.banarid = banarid;
	}

	@Column(name = "image", nullable = false, length = 250)

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "state")

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}