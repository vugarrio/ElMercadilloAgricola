package es.ugarrio.elmercadilloagricola.service;

import java.util.List;

import es.ugarrio.elmercadilloagricola.domain.Usuario;
import es.ugarrio.elmercadilloagricola.exception.EMCAException;


public interface UsuarioService {
	
	/**
	 * @param strubg EMAIL A BUSCAR
	 * 
	 * @return Usuario
	 */	
	public Usuario findByEmail(String email) throws EMCAException ;

}
