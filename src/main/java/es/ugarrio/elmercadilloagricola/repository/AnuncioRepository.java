/**
 * 
 */
package es.ugarrio.elmercadilloagricola.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import es.ugarrio.elmercadilloagricola.domain.Anuncio;
import es.ugarrio.elmercadilloagricola.repository.custom.AnuncioRepositoryCustom;


/**
 * @author Vicente Ugarrio
 * 
 */
public interface AnuncioRepository extends JpaRepository<Anuncio, Integer>, AnuncioRepositoryCustom { 
	 
	
	 //Mirar http://docs.spring.io/spring-data/jpa/docs/1.3.0.RELEASE/reference/html/jpa.repositories.html
	 
	 /*  Informacion de como customizar JpaRepository: 
	  * http://www.javabeat.net/spring-data-custom-repository/
	  * http://stackoverflow.com/questions/11880924/how-to-add-custom-method-to-spring-data-jpa
	  * http://stackoverflow.com/questions/26795436/spring-jparepository-detach-and-attach-entity
	  * http://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#repositories.custom-implementations
	 */
	
	 /*@Query("SELECT a FROM Anuncio a order by a.fechaPublicacion ") 
     List<Anuncio> findOrderByFechaPublicacionDesc(@Param("num") int num);*/
	
}
