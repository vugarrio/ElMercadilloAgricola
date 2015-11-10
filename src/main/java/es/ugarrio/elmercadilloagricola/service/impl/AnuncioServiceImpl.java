/**
 * 
 */
package es.ugarrio.elmercadilloagricola.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.ugarrio.elmercadilloagricola.domain.Anuncio;
import es.ugarrio.elmercadilloagricola.repository.AnuncioRepository;
import es.ugarrio.elmercadilloagricola.service.AnuncioService;

/**
 * @author Tente
 *
 */

@Service
@Transactional(readOnly = true)
public class AnuncioServiceImpl implements AnuncioService {

	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private AnuncioRepository anuncioRepository;

	@SuppressWarnings("unchecked")
	@Override
	public List<Anuncio> findLast(int num) {
		
		// Utilizando el JPARepository (No utilizo esta forma poque necesitamos filtrar por "a.anunciosEstados.idAnuncioEstado = 1")
		/*PageRequest pageRequest = new PageRequest(0, num, Sort.Direction.DESC, "fechaPublicacion");  
        return anuncioRepository.findAll(pageRequest).getContent();*/
              
        
        /* Otra forma de hacerlo utilizando EntitAyManager */       
		Query query = this.em.createQuery("from Anuncio as a where a.anunciosEstado.idAnuncioEstado = 1 order by a.fechaPublicacion desc", Anuncio.class);
	    query.setMaxResults(num);	
	    return query.getResultList();     
	}
	
	
	
}
