/**
 * 
 */
package es.ugarrio.elmercadilloagricola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.ugarrio.elmercadilloagricola.domain.Anuncio;


/**
 * @author Tente
 * 
 * 
 */
public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {
	 
	
	 //Mirar http://docs.spring.io/spring-data/jpa/docs/1.3.0.RELEASE/reference/html/jpa.repositories.html
	
	 /*@Query("SELECT a FROM Anuncio a order by a.fechaPublicacion ") 
     List<Anuncio> findOrderByFechaPublicacionDesc(@Param("num") int num);*/
	
	
	
}
