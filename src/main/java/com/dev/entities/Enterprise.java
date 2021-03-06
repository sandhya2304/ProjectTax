package com.dev.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


@Entity
public class Enterprise implements Serializable
{
	@Id @GeneratedValue
	private Long code;
	@NotNull
	@Size(min=3,max=20)
	private String name;
	@NotNull
	@Email
	private String email;
	@NotNull
	@Size(min=3,max=20)
	private String reasonSocial;
	
	@OneToMany(mappedBy="enterprise",fetch=FetchType.LAZY)
	private Collection<Tax> taxes;
	
	public Enterprise() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Enterprise(String name, String email, String reasonSocial) {
		super();
		this.name = name;
		this.email = email;
		this.reasonSocial = reasonSocial;
	}



	public Long getCode() {
		return code;
	}



	public void setCode(Long code) {
		this.code = code;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getReasonSocial() {
		return reasonSocial;
	}



	public void setReasonSocial(String reasonSocial) {
		this.reasonSocial = reasonSocial;
	}



	public Collection<Tax> getTaxes() {
		return taxes;
	}



	public void setTaxes(Collection<Tax> taxes) {
		this.taxes = taxes;
	}



	@Override
	public String toString() {
		return "Enterprise [code=" + code + ", name=" + name + ", email=" + email + ", reasonSocial=" + reasonSocial
				+ ", taxes=" + taxes + "]";
	}
	
	
	

}
