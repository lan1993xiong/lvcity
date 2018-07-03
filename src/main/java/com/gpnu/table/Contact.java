package com.gpnu.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "contact", catalog = "lvcitydb")

public class Contact implements java.io.Serializable {

	// Fields

	private Integer contactid;
	private String contactname;
	private String tel;
	private String qq;
	private String web;
	private String zipcode;
	private String fax;
	private String address;

	// Constructors

	/** default constructor */
	public Contact() {
	}

	/** full constructor */
	public Contact(String contactname, String tel, String qq, String web, String zipcode, String fax, String address) {
		this.contactname = contactname;
		this.tel = tel;
		this.qq = qq;
		this.web = web;
		this.zipcode = zipcode;
		this.fax = fax;
		this.address = address;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "contactid", unique = true, nullable = false)

	public Integer getContactid() {
		return this.contactid;
	}

	public void setContactid(Integer contactid) {
		this.contactid = contactid;
	}

	@Column(name = "contactname", nullable = false, length = 80)

	public String getContactname() {
		return this.contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname;
	}

	@Column(name = "tel", nullable = false, length = 20)

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "qq", nullable = false, length = 25)

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "web", nullable = false, length = 250)

	public String getWeb() {
		return this.web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	@Column(name = "zipcode", nullable = false, length = 12)

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "fax", nullable = false, length = 50)

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "address", nullable = false, length = 250)

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}