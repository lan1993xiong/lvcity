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
@Table(name = "noticetype", catalog = "lvcitydb")

public class Noticetype implements java.io.Serializable {

	// Fields

	private Integer ntid;
	private String nt;
	private Set<Notice> notices = new HashSet<Notice>(0);

	// Constructors

	/** default constructor */
	public Noticetype() {
	}

	/** minimal constructor */
	public Noticetype(String nt) {
		this.nt = nt;
	}

	/** full constructor */
	public Noticetype(String nt, Set<Notice> notices) {
		this.nt = nt;
		this.notices = notices;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "ntid", unique = true, nullable = false)

	public Integer getNtid() {
		return this.ntid;
	}

	public void setNtid(Integer ntid) {
		this.ntid = ntid;
	}

	@Column(name = "nt", nullable = false, length = 50)

	public String getNt() {
		return this.nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "noticetype")

	public Set<Notice> getNotices() {
		return this.notices;
	}

	public void setNotices(Set<Notice> notices) {
		this.notices = notices;
	}

}