package com.dev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	@Autowired
	private TaxRepository taxRepository;
	
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
	
	@RequestMapping(value="/formEnterprise",method=RequestMethod.GET)
	public String form(Model model)
	{
		model.addAttribute("enterprise", new Enterprise());
		return "formEnterprise";
	}
	
	
	@RequestMapping(value="/saveEnterprise")
	public String saveform(Model model,@Valid Enterprise e,BindingResult results)
	{
		if(results.hasErrors())
			return "formEnterprise";
		
		enterpriseRepository.save(e);
		return "redirect:/enterprise";
	}
	
	@RequestMapping(value="/tax",method=RequestMethod.GET)
	public String tax(Model model,Long code)
	{
		Enterprise e=new Enterprise();
		e.setCode(code);
		
		model.addAttribute("enterprise",enterpriseRepository.findAll());
		model.addAttribute("taxes",taxRepository.findByEnterprise(e));
		return "tax";
	}

}
