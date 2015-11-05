/**
 * 
 */
package es.ugarrio.elmercadilloagricola.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

	@Override
	public List<Anuncio> findLast(int num) {
		
		// Utilizando el JPARepository
		PageRequest pageRequest = new PageRequest(0, num, Sort.Direction.DESC, "fechaPublicacion");  
        return anuncioRepository.findAll(pageRequest).getContent();
        //return anuncioRepository.findAll();
        
              
        
        /* Otra forma de hacerlo utilizando EntityManager        
	    TypedQuery query = em.createQuery("select c from Customer c", Customer.class);	
	    query.setFirstResult(page * pageSize);
	    query.setMaxResults(pageSize);	
	    return query.getResultList(); */        
	}
	
	
	
}
