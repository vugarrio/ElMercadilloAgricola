package es.ugarrio.elmercadilloagricola.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.ugarrio.elmercadilloagricola.domain.Role;
import es.ugarrio.elmercadilloagricola.domain.Usuario;
import es.ugarrio.elmercadilloagricola.repository.UsuarioRepository;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
    private UsuarioRepository usuarioRepository;
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Usuario user = usuarioRepository.findByEmail(email);
		if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + email);
        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        
        //Indicamos si el usuario esta activo
        if (user.getUsuariosEstado().getIdUsuarioEstado() != 1) {
        	enabled = false; 
        }
        
        logger.info("CustomUserDetailsService --> Usuario login : " + user.toString());
        
        return  new org.springframework.security.core.userdetails.User (  user.getEmail(), user.getPassword(), enabled, 
        		                                                          accountNonExpired, credentialsNonExpired, accountNonLocked, 
																          getAuthorities(user.getRoles()));
	}
	
	//Obtenemos la lista de Roles Autorizados para el usuario
	private static List<GrantedAuthority> getAuthorities (List<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getNombre()));
        }
        return authorities;
    }

}
