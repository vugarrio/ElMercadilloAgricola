package es.ugarrio.elmercadilloagricola.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import es.ugarrio.elmercadilloagricola.domain.Categoria;
import es.ugarrio.elmercadilloagricola.repository.custom.AnuncioRepositoryCustom;

/**
 * @author Vicente Ugarrio
 * 
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	
	
}
