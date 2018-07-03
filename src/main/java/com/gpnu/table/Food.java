package com.gpnu.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gpnu.entity.Page;

@Entity
@Table(name = "food", catalog = "lvcitydb", uniqueConstraints = @UniqueConstraint(columnNames = "fname"))

public class Food implements java.io.Serializable {

	// Fields

	private Integer fid;
	private Foodtype foodtype;
	private Article article;
	private String fname;
	private String image;

	// Constructors

	/** default constructor */
	public Food() {
	}

	/** minimal constructor */
	public Food(String fname, String image) {
		this.fname = fname;
		this.image = image;
	}

	/** full constructor */
	public Food(Foodtype foodtype, Article article, String fname, String image) {
		this.foodtype = foodtype;
		this.article = article;
		this.fname = fname;
		this.image = image;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "fid", unique = true, nullable = false)

	public Integer getFid() {
		return this.fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ftid")

	public Foodtype getFoodtype() {
		return this.foodtype;
	}

	public void setFoodtype(Foodtype foodtype) {
		this.foodtype = foodtype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aid")

	public Article getArticle() {
		return this.article;
	}
    
	@JsonBackReference
	public void setArticle(Article article) {
		this.article = article;
	}

	@Column(name = "fname", unique = true, nullable = false, length = 50)

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	@Column(name = "image", nullable = false, length = 250)

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
    
	
}