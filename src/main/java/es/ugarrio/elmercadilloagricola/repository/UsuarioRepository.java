package es.ugarrio.elmercadilloagricola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.ugarrio.elmercadilloagricola.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	 @Query("select u from Usuario u where u.email = ?1")
	 Usuario findByEmail(String email);
	 
}
