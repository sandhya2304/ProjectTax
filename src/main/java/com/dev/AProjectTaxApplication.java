package com.dev;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dev.dao.EnterpriseRepository;
import com.dev.dao.TaxRepository;
import com.dev.entities.Enterprise;
import com.dev.entities.IncomeTax;
import com.dev.entities.Tax;
import com.dev.entities.Vat;

@SpringBootApplication
public class AProjectTaxApplication  implements CommandLineRunner
{
	@Autowired
	private EnterpriseRepository enterpriseRepository;
	
	@Autowired
	private TaxRepository taxRepository;

	public static void main(String[] args) {
		SpringApplication.run(AProjectTaxApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception
	{
		
	/* Enterprise	e1=enterpriseRepository.save(new Enterprise("lolo","sharma@gmail.com","manufacture"));
	 
	 Enterprise	e2=enterpriseRepository.save(new Enterprise("bebo","group@gmail.com","finsihing"));
	 
	 taxRepository.save(new Vat("vat habitate",new Date(),60000, e1));
	 taxRepository.save(new Vat("vat car",new Date(),60000, e1));
	 
	 taxRepository.save(new IncomeTax("IT 2017",new Date(),3, e1));
	 taxRepository.save(new Vat("vat car",new Date(),60000, e2));*/
	 
		
	}
}
