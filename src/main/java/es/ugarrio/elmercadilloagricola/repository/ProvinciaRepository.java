package es.ugarrio.elmercadilloagricola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.ugarrio.elmercadilloagricola.domain.Provincia;


public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {

	@Query("from Provincia as p where esActivo = 1 order by nombreProvincia desc")
	List<Provincia> findAllActivas();
	
}
