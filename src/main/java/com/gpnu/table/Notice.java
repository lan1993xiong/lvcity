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

@Entity
@Table(name = "notice", catalog = "lvcitydb", uniqueConstraints = @UniqueConstraint(columnNames = "nname"))

public class Notice implements java.io.Serializable {

	// Fields

	private Integer nid;
	private Article article;
	private Noticetype noticetype;
	private String nname;
	// Constructors

	/** default constructor */
	public Notice() {
	}

	/** minimal constructor */
	public Notice(String nname) {
		this.nname = nname;
	}

	/** full constructor */
	public Notice(Article article, Noticetype noticetype, String nname) {
		this.article = article;
		this.noticetype = noticetype;
		this.nname = nname;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "nid", unique = true, nullable = false)

	public Integer getNid() {
		return this.nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aid")

	public Article getArticle() {
		return this.article;
	}
    
	
	public void setArticle(Article article) {
		this.article = article;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ntid")

	public Noticetype getNoticetype() {
		return this.noticetype;
	}

	public void setNoticetype(Noticetype noticetype) {
		this.noticetype = noticetype;
	}

	@Column(name = "nname", unique = true, nullable = false, length = 50)

	public String getNname() {
		return this.nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}
	
}