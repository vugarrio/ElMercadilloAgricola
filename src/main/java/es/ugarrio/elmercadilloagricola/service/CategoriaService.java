package es.ugarrio.elmercadilloagricola.service;

import java.util.List;

import es.ugarrio.elmercadilloagricola.domain.Categoria;
import es.ugarrio.elmercadilloagricola.exception.EMCAException;


public interface CategoriaService {
	
	/**
	 * @param num NIVEL
	 * 
	 * @return LISTADO DE CATEGORIAS
	 */	
	public List<Categoria> findByNivel(int nivel) throws EMCAException;
	
	
	
	
	
}
