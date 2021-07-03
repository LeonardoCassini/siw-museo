package it.uniroma3.siw.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siw.spring.model.Opera;

public interface OperaRepository extends CrudRepository<Opera,Long> 
{
	//utilizzata per trovare i duplicati
	public List<Opera> findByTitolo(String titolo);
	
	@Query(value="select * from opera where titolo=?1", nativeQuery=true)
	public Opera trovaPerNome(String titolo);
	
	//permette di trovare tutte gli anni delle varie opere senza duplicati
	@Query(value="select distinct anno_realizzazione from opera", nativeQuery=true)
	public List<Integer> findByAnni();
	
	//permette di trovare tutte le opere dato uno specifico anno
	public List<Opera> findByAnnoRealizzazione(String anno);
}