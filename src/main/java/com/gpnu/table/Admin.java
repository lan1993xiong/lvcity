package com.gpnu.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "admin_", catalog = "lvcitydb", uniqueConstraints = @UniqueConstraint(columnNames = "adminname"))
public class Admin implements java.io.Serializable {

	// Fields

	private Integer adminid;
	private String adminname;
	private String passwd;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(String adminname) {
		this.adminname = adminname;
	}

	/** full constructor */
	public Admin(String adminname, String passwd) {
		this.adminname = adminname;
		this.passwd = passwd;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "adminid", unique = true, nullable = false)
	public Integer getAdminid() {
		return this.adminid;
	}

	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}

	@Column(name = "adminname", unique = true, nullable = false, length = 20)
	public String getAdminname() {
		return this.adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	@Column(name = "passwd", length = 32)

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}