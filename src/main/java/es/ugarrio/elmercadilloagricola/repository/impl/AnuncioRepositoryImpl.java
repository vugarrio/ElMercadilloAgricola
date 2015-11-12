package es.ugarrio.elmercadilloagricola.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import es.ugarrio.elmercadilloagricola.domain.Anuncio;
import es.ugarrio.elmercadilloagricola.repository.custom.AnuncioRepositoryCustom;

@Repository
public class AnuncioRepositoryImpl implements AnuncioRepositoryCustom  {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Anuncio> findLast(int num) {

        Query query = this.em.createQuery("from Anuncio as a where a.anunciosEstado.idAnuncioEstado = 1 order by a.fechaPublicacion desc", Anuncio.class);
	    query.setMaxResults(num);	
	    return query.getResultList();
	
	}

}
