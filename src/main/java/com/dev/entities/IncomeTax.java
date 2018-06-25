package com.dev.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("IT")
public class IncomeTax extends Tax
{

	public IncomeTax() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IncomeTax(String title, Date dateTax, double balance, Enterprise enterprise) {
		super(title, dateTax, balance, enterprise);
		// TODO Auto-generated constructor stub
	}
	
	

}
