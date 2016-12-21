package es.ugarrio.elmercadilloagricola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.ugarrio.elmercadilloagricola.domain.Provincia;
import es.ugarrio.elmercadilloagricola.repository.custom.CategoriaRepositoryCustom;
import es.ugarrio.elmercadilloagricola.repository.custom.ProvinciaRepositoryCustom;


public interface ProvinciaRepository extends JpaRepository<Provincia, Integer>, ProvinciaRepositoryCustom {

	@Query("from Provincia as p where esActivo = 1 order by nombreProvincia")
	List<Provincia> findAllActivas();
	
}
