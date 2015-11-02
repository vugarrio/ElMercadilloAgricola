/**
 * 
 */
package es.ugarrio.elmercadilloagricola.service.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	
}
