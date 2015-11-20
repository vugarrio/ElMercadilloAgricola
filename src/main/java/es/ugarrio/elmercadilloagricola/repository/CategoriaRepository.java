package es.ugarrio.elmercadilloagricola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.ugarrio.elmercadilloagricola.domain.Categoria;
import es.ugarrio.elmercadilloagricola.repository.custom.AnuncioRepositoryCustom;

/**
 * @author Vicente Ugarrio
 * 
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	@Query("from Categorias c where c.nivel = ?1 order by c.orden, c.nombreCategoria")
	List<Categoria> findByNivel(long nivel);
	
}
