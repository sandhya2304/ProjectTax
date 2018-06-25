package com.dev.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",discriminatorType=DiscriminatorType.STRING,length=3)
public abstract class Tax implements Serializable
{
	@Id @GeneratedValue
	private Long id;
	private String title;
	private Date dateTax;
	private double balance;
	
	@ManyToOne
	@JoinColumn(name="code_enterprise")
	private Enterprise enterprise;
	
	public Tax() {
		// TODO Auto-generated constructor stub
	}

	public Tax(String title, Date dateTax, double balance, Enterprise enterprise) {
		super();
		this.title = title;
		this.dateTax = dateTax;
		this.balance = balance;
		this.enterprise = enterprise;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDateTax() {
		return dateTax;
	}

	public void setDateTax(Date dateTax) {
		this.dateTax = dateTax;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	
	
	

}
