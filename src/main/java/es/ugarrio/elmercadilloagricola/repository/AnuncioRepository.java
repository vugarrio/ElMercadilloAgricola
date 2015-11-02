/**
 * 
 */
package es.ugarrio.elmercadilloagricola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.ugarrio.elmercadilloagricola.domain.Anuncio;


/**
 * @author Tente
 *
 */
public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {

}
