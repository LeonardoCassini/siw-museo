package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.uniroma3.siw.spring.model.Opera;
import it.uniroma3.siw.spring.repository.OperaRepository;
@Service
public class OperaService 
{
	@Autowired
	protected OperaRepository operaRepository;
	
	public Opera getOpera(Long id)
	{
		Optional<Opera> result=this.operaRepository.findById(id);
		return result.orElse(null);
	}
	
	public List<Opera> getAllOpere()
	{
		List<Opera> result = new ArrayList<Opera>();
		Iterable<Opera> it = this.operaRepository.findAll();
		for(Opera opera :it)
		{
			result.add(opera);
		}
		return result;
	}
	
	public List<Opera> getOpereAnno(String anno)
	{
		List<Opera> result = new ArrayList<Opera>();
		Iterable<Opera> it = this.operaRepository.findByAnnoRealizzazione(anno);
		for(Opera opera :it)
		{
			result.add(opera);
		}
		return result;
	}
	
	public List<Integer> getAnnate()
	{
		List<Integer> result = new ArrayList<Integer>();
		Iterable<Integer> it = this.operaRepository.findByAnni();
		for(Integer integer :it)
		{
			result.add(integer);
		}
		return result;
	}
	
	public boolean duplicato(Opera opera)
	{
		List<Opera> result=this.operaRepository.findByTitolo(opera.getTitolo());
		if (result.size() > 0)
			return true;
		else 
			return false;
	}
	
	public List<Opera> CercaPerTitolo(String titolo)
	{
		List<Opera> result=this.operaRepository.findByTitolo(titolo);
		return result;
	}
	
	@Transactional
	public Opera saveOpera(Opera opera)
	{
		return this.operaRepository.save(opera);
	}
}
