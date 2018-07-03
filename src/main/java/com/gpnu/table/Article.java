package com.gpnu.table;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "article", catalog = "lvcitydb")
public class Article implements java.io.Serializable {

	// Fields

	private Integer aid;
	private Users users;
	private Articletype articletype;
	private Date releasetime;
	private String content;
	private String image;
	private String articlename;	
	private Set<Scenic> scenics = new HashSet<Scenic>(0);
	private Set<Food> foods = new HashSet<Food>(0);
	private Set<Notice> notices = new HashSet<Notice>(0);

	// Constructors

	/** default constructor */
	public Article() {
	}

	/** minimal constructor */
	public Article(String content, String articlename) {
		this.content = content;
		this.articlename = articlename;
	}

	/** full constructor */
	public Article(Users users, Articletype articletype, Date releasetime, String content, String image,
			String articlename, Set<Scenic> scenics, Set<Food> foods, Set<Notice> notices) {
		this.users = users;
		this.articletype = articletype;
		this.releasetime = releasetime;
		this.content = content;
		this.image = image;
		this.articlename = articlename;
		this.scenics = scenics;
		this.foods = foods;
		this.notices = notices;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "aid", unique = true, nullable = false)

	public Integer getAid() {
		return this.aid;
	}
	

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publisher")

	public Users getUsers() {
		return this.users;
	}


	public void setUsers(Users users) {
		this.users = users;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "atid")

	public Articletype getArticletype() {
		return this.articletype;
	}

	public void setArticletype(Articletype articletype) {
		this.articletype = articletype;
	}

	@Column(name = "releasetime", length = 19)

	public Date getReleasetime() {
		return this.releasetime;
	}
    

	public void setReleasetime(Date releasetime) {
		this.releasetime = releasetime;
	}

	@Column(name = "content", nullable = false, length = 65535)

	public String getContent() {
		return this.content;
	}
    
	
	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "image", length = 250)

	public String getImage() {
		return this.image;
	}
    

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "articlename", nullable = false, length = 100)

	public String getArticlename() {
		return this.articlename;
	}
    

	public void setArticlename(String articlename) {
		this.articlename = articlename;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "article")

	public Set<Scenic> getScenics() {
		return this.scenics;
	}
    

	public void setScenics(Set<Scenic> scenics) {
		this.scenics = scenics;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "article")

	public Set<Food> getFoods() {
		return this.foods;
	}
    

	public void setFoods(Set<Food> foods) {
		this.foods = foods;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "article")

	public Set<Notice> getNotices() {
		return this.notices;
	}
    

	public void setNotices(Set<Notice> notices) {
		this.notices = notices;
	}

}