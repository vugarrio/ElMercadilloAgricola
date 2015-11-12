/**
 * 
 */
package es.ugarrio.elmercadilloagricola.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.ugarrio.elmercadilloagricola.domain.Anuncio;
import es.ugarrio.elmercadilloagricola.repository.AnuncioRepository;
import es.ugarrio.elmercadilloagricola.repository.custom.AnuncioRepositoryCustom;
import es.ugarrio.elmercadilloagricola.repository.impl.AnuncioRepositoryImpl;
import es.ugarrio.elmercadilloagricola.service.AnuncioService;
import es.ugarrio.elmercadilloagricola.web.dto.AnuncioDTO;

/**
 * @author Vicente Ugarrio
 *
 */

@Service
@Transactional(readOnly = true)
public class AnuncioServiceImpl implements AnuncioService {

	@Inject
	private AnuncioRepository anuncioRepository;
		

	@SuppressWarnings("unchecked")
	@Override
	public List<AnuncioDTO> findLast(int num) {
		
		// Utilizando el JPARepository (No utilizo esta forma poque necesitamos filtrar por "a.anunciosEstados.idAnuncioEstado = 1")
		/*PageRequest pageRequest = new PageRequest(0, num, Sort.Direction.DESC, "fechaPublicacion");  
        return anuncioRepository.findAll(pageRequest).getContent();*/
         
	    //return anuncioRepository.findLast(num);
		
			
		//return anuncioRepository.findAll(); //Funcion de JpaRepository		
		List<Anuncio> listLastAnuncios = anuncioRepository.findLast(num);  //Funcion mia de AnuncioRepositoryCustom
		List<AnuncioDTO> listLastAnunciosDAO = new ArrayList<AnuncioDTO>();
		for (Anuncio anuncio : listLastAnuncios) {
			listLastAnunciosDAO.add(new AnuncioDTO(anuncio));
		}
		
		return listLastAnunciosDAO;		
	}
	
	
	
}
