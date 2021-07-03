package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import it.uniroma3.siw.spring.service.CuratoreService;

@Controller
public class CuratoreController 
{
	@Autowired
	private CuratoreService curatoreService;
}
