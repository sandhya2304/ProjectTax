package com.dev.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("vat")
public class Vat extends Tax
{

	public Vat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vat(String title, Date dateTax, double balance, Enterprise enterprise) {
		super(title, dateTax, balance, enterprise);
		// TODO Auto-generated constructor stub
	}
	
	

}
