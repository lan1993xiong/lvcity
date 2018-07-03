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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "articletype", catalog = "lvcitydb", uniqueConstraints = @UniqueConstraint(columnNames = "atype"))

public class Articletype implements java.io.Serializable {

	// Fields

	private Integer atid;
	private String atype;
	private Set<Article> articles = new HashSet<Article>(0);

	// Constructors

	/** default constructor */
	public Articletype() {
	}

	/** minimal constructor */
	public Articletype(String atype) {
		this.atype = atype;
	}

	/** full constructor */
	public Articletype(String atype, Set<Article> articles) {
		this.atype = atype;
		this.articles = articles;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "atid", unique = true, nullable = false)

	public Integer getAtid() {
		return this.atid;
	}

	public void setAtid(Integer atid) {
		this.atid = atid;
	}

	@Column(name = "atype", unique = true, nullable = false, length = 50)

	public String getAtype() {
		return this.atype;
	}

	public void setAtype(String atype) {
		this.atype = atype;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "articletype")

	public Set<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

}