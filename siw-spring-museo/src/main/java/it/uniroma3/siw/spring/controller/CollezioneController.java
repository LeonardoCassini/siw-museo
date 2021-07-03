package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.siw.spring.service.CollezioneService;

@Controller
public class CollezioneController 
{
	@Autowired
	private CollezioneService collezioneService;
	
	 @RequestMapping(value="/collezioni",method= RequestMethod.GET)
	 public String showCollezioni(Model model)
	 {
		 model.addAttribute("collezioni",this.collezioneService.getAllCollezioni());
		 return"collezioni.html";
	 }
	 
	 @RequestMapping(value="/collezioni/{id}",method= RequestMethod.GET)
	 public String showCollezione(@PathVariable("id") Long id,Model model)
	 {
		 model.addAttribute("collezione",this.collezioneService.getCollezione(id));
		 return"collezione.html";
	 }
	 
//	 @RequestMapping(value="/inserisciOpera", method= RequestMethod.GET)
//	 public String prendiTutteCollezioni(Model model)
//	 {
//		 model.addAttribute("collezioni",this.collezioneService.getAllCollezioni());
//		 return"inserisciOpera";
//	 }
}
