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
@Table(name = "scenic", catalog = "lvcitydb", uniqueConstraints = @UniqueConstraint(columnNames = "sname"))

public class Scenic implements java.io.Serializable {

	// Fields

	private Integer sid;
	private Article article;
	private Scenictype scenictype;
	private String sname;
	private String image;
	private String lx;
	

	// Constructors

	/** default constructor */
	public Scenic() {
	}

	/** minimal constructor */
	public Scenic(String sname, String image, String lx) {
		this.sname = sname;
		this.image = image;
		this.lx = lx;
	}

	/** full constructor */
	public Scenic(Article article, Scenictype scenictype, String sname, String image, String lx) {
		this.article = article;
		this.scenictype = scenictype;
		this.sname = sname;
		this.image = image;
		this.lx = lx;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "sid", unique = true, nullable = false)

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stid")

	public Scenictype getScenictype() {
		return this.scenictype;
	}

	public void setScenictype(Scenictype scenictype) {
		this.scenictype = scenictype;
	}

	@Column(name = "sname", unique = true, nullable = false, length = 50)

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Column(name = "image", nullable = false, length = 250)

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "lx", nullable = false, length = 10)

	public String getLx() {
		return this.lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}
	

}