package it.uniroma3.siw.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController 
{
	@RequestMapping(value= {"/","home"}, method= RequestMethod.GET)
	public String login(Model model)
	{
		return "home";
	}
	
	@RequestMapping("/login")
	public String home()
	{
		return "login";
	}
	
	@RequestMapping("/artisti")
	public String artisti() 
	{
	    return "artisti";
	}
	
	@RequestMapping("/artista")
	public String artista() 
	{
	    return "artista";
	}
	
	@RequestMapping("/informazioni")
	public String informazioni() 
	{
	    return "informazioni";
	}
	
	@RequestMapping("/collezioni")
	public String collezioni() 
	{
	    return "collezioni";
	}
	
	@RequestMapping("/collezione")
	public String collezione() 
	{
	    return "collezione";
	}
	
	@RequestMapping("/opera")
	public String opera() 
	{
	    return "opera";
	}
	
	@RequestMapping("/periodi")
	public String periodi()
	{
		return"periodi";
	}
	
	@RequestMapping("/opereAnno")
	public String opereAnno()
	{
		return "opereAnno";
	}
	
//	@RequestMapping("/admin/home")
//	public String adminHome()
//	{
//		return "admin/home";
//	}
	
//	@RequestMapping("/modifica")
//	public String modifica()
//	{
//		return "modifica";
//	}
//
//	@RequestMapping("/formOpera")
//	public String formOpera()
//	{
//		return "formOpera";
//	}
//	
//	@RequestMapping("/modificaOpera")
//	public String modificaOpera()
//	{
//		return "modificaOpera";
//	}
}