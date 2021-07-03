package it.uniroma3.siw.spring.controller.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import it.uniroma3.siw.spring.model.Curatore;
import it.uniroma3.siw.spring.service.CuratoreService;

@Component
public class CuratoreValidator implements Validator
{
	@Autowired
	private CuratoreService curatoreService;
	
	private static final Logger logger = LoggerFactory.getLogger(CuratoreValidator.class);
	
	@Override
	public void validate(Object o, Errors errors) 
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataNascita", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "luogoNascita", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		
		if (!errors.hasErrors()) 
		{
			logger.debug("confermato: valori non nulli");
		}
	}
	
	@Override
	public boolean supports(Class<?> aClass) 
	{
		return Curatore.class.equals(aClass);
	}
	
}
