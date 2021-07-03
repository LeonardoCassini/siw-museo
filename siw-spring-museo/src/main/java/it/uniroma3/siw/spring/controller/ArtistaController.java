package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.service.ArtistaService;

@Controller
public class ArtistaController 
{
	@Autowired
	private ArtistaService artistaService;
	
	@RequestMapping(value="/artisti",method= RequestMethod.GET)
	 public String showArtisti(Model model)
	 {
		 model.addAttribute("artisti",this.artistaService.getAllArtista());
		 return"artisti.html";
	 }
	 
	 @RequestMapping(value="/artista/{id}",method= RequestMethod.GET)
	 public String showArtista(@PathVariable("id") Long id,Model model)
	 {
		 model.addAttribute("artista",this.artistaService.getArtista(id));
		 return"artista.html";
	 }
	 
//	 @RequestMapping(value="/inserisciOpera", method= RequestMethod.GET)
//	 public String prendiTuttiArtisti(Model model)
//	 {
//		 model.addAttribute("artisti",this.artistaService.getAllArtista());
//		 return"inserisciOpera.html";
//	 }
}
