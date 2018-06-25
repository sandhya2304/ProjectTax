package com.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.dao.EnterpriseRepository;
import com.dev.dao.TaxRepository;
import com.dev.entities.Enterprise;



@Controller
public class TaxController
{
	@Autowired
	private EnterpriseRepository enterpriseRepository;
	
	@RequestMapping(value="/enterprise",method=RequestMethod.GET)
	public String index(Model model,@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="size",defaultValue="3") int s,
			@RequestParam(name="search",defaultValue="")String search)
	{
		Page<Enterprise> pageEnterprises=enterpriseRepository.searchByName("%"+search+"%",new PageRequest(p, s));
		model.addAttribute("listEnterprise",pageEnterprises.getContent());
		int[] pages=new int[pageEnterprises.getTotalPages()];
		model.addAttribute("pages",pages);
		model.addAttribute("pageCurrent",p);
		model.addAttribute("search",search);
		return "enterprise";
	}
	
	

}
