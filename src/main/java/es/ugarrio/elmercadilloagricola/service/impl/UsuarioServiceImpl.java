package es.ugarrio.elmercadilloagricola.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.ugarrio.elmercadilloagricola.domain.Usuario;
import es.ugarrio.elmercadilloagricola.exception.EMCAException;
import es.ugarrio.elmercadilloagricola.repository.UsuarioRepository;
import es.ugarrio.elmercadilloagricola.service.UsuarioService;

@Service
@Transactional(readOnly = true)
public class UsuarioServiceImpl  implements UsuarioService { 
	
	@Inject
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario findByEmail(String email) throws EMCAException  {
		return usuarioRepository.findByEmail(email);
	}

}



