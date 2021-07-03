package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.spring.controller.validator.OperaValidator;
import it.uniroma3.siw.spring.model.Opera;
import it.uniroma3.siw.spring.service.ArtistaService;
import it.uniroma3.siw.spring.service.CollezioneService;
import it.uniroma3.siw.spring.service.OperaService;

@Controller
public class OperaController 
{
	@Autowired
	private OperaService operaService;
	@Autowired
	private ArtistaService artistaService;
	@Autowired
	private CollezioneService collezioneService;
	@Autowired
	private OperaValidator operaValidator;
	
	@RequestMapping(value="/opera/{id}",method= RequestMethod.GET)
	 public String showOpera(@PathVariable("id") Long id,Model model)
	 {
		 model.addAttribute("opera",this.operaService.getOpera(id));
		 return"opera.html";
	 }
	
	@RequestMapping(value="/periodi", method= RequestMethod.GET)
	public String MostraAnni(Model model)
	{
		model.addAttribute("anni",this.operaService.getAnnate());
		return"periodi.html";
	}
	
	@RequestMapping(value="/anno/{String}", method=RequestMethod.GET)
	public String showOpereAnno(@PathVariable("String") String anno, Model model)
	{
		model.addAttribute("opereAnno", this.operaService.getOpereAnno(anno));
		return "opereAnno.html";
	}
	
	@RequestMapping(value="/formOpera/{opera}", method=RequestMethod.GET)
	public String  cerca(@RequestParam(value="opera", required=false) String titolo, Model model)
	{
		model.addAttribute("opera", this.operaService.CercaPerTitolo(titolo));
		return "modificaOpera";
	}
	
	@RequestMapping(value = "/inserisciOpera", method = RequestMethod.GET)
    public String addOpera(Model model) {
        model.addAttribute("opera", new Opera());
        model.addAttribute("artista", this.artistaService.getAllArtista());
        model.addAttribute("collezione", this.collezioneService.getAllCollezioni());
        return "inserisciOpera";
    }
	
	@RequestMapping(value="/inserisciOpera", method=RequestMethod.POST)
	public String aggiungi(@ModelAttribute("opera") Opera opera, Model model,BindingResult br)
	{
		this.operaValidator.validate(opera, br);
		if(!br.hasErrors())
		{
			this.operaService.saveOpera(opera);
			return "inserimentoBuono";
		}
		return "inserimentoBrutto";
	}
}
