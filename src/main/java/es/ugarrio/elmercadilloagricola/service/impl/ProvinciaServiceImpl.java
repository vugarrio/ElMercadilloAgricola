package es.ugarrio.elmercadilloagricola.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




import es.ugarrio.elmercadilloagricola.domain.Provincia;
import es.ugarrio.elmercadilloagricola.exception.EMCAException;
import es.ugarrio.elmercadilloagricola.repository.ProvinciaRepository;
import es.ugarrio.elmercadilloagricola.service.ProvinciaService;



@Service
@Transactional(readOnly = true)
public class ProvinciaServiceImpl  implements ProvinciaService {
	
	
	/*@PersistenceContext
	private EntityManager em;*/
	
	@Inject
	private ProvinciaRepository provinciaRepository;
	
	
		
	 @Override
	 @Transactional
	 public Provincia save (Provincia account) {
	    return provinciaRepository.save(account);
	 }
	
	

	@Override
	@Transactional(rollbackFor=EMCAException.class)
	public Provincia delete(int id) throws EMCAException {
		Provincia deletedProvincia = provinciaRepository.findOne(id);
		
		if (deletedProvincia == null)
			throw new EMCAException();
		
		provinciaRepository.delete(deletedProvincia);
		return deletedProvincia;
	}
	
	
	@Override
	@Transactional(rollbackFor=EMCAException.class)
	public Provincia update(Provincia provincia) throws EMCAException {
		Provincia updatedProvincia = provinciaRepository.findOne(provincia.getIdProvincia());
		
		if (updatedProvincia == null)
			throw new EMCAException();
		
		updatedProvincia.setNombreProvincia(provincia.getNombreProvincia());
		//updatedProvincia.setEmplNumber(provincia.getEmplNumber());
		provinciaRepository.save(updatedProvincia);
		return updatedProvincia;
	} 
	
	@Override
	public Provincia findById(int id) {
		return provinciaRepository.findOne(id);
	}

	@Override
	public List<Provincia> findAll() {
		return provinciaRepository.findAllActivas();
	}
	
	/*@Override
	public List<Provincia> findByCodProvincia(String codProvincia) {

	    TypedQuery query = em.createQuery("select p from Provincia p where p.codProvincia = ?1", Provincia.class);
	    query.setParameter(1, codProvincia);

	    return query.getResultList();
	}*/
	
	
}

