package es.ugarrio.elmercadilloagricola.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.ugarrio.elmercadilloagricola.domain.Categoria;
import es.ugarrio.elmercadilloagricola.exception.EMCAException;
import es.ugarrio.elmercadilloagricola.repository.CategoriaRepository;
import es.ugarrio.elmercadilloagricola.service.CategoriaService;


@Service
@Transactional(readOnly = true)
public class CategoriaServiceImpl implements CategoriaService {
	
	
	@Inject
	private CategoriaRepository categoriaRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> findByNivel(int nivel) throws EMCAException {
		return categoriaRepository.findByNivel(nivel);
	}
	
}
