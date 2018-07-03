package com.gpnu.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message", catalog = "lvcitydb")

public class Message implements java.io.Serializable {

	// Fields

	private Integer mid;
	private String tel;
	private String sex;
	private String name;
	private String message;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(String tel, String sex, String name, String message) {
		this.tel = tel;
		this.sex = sex;
		this.name = name;
		this.message = message;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "mid", unique = true, nullable = false)

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	@Column(name = "tel", nullable = false, length = 20)

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "sex", nullable = false, length = 20)

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "name", nullable = false, length = 100)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "message", nullable = false, length = 65535)

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}