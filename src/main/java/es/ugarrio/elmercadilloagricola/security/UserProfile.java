package es.ugarrio.elmercadilloagricola.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/* Customizamos la clase UserDetails de springframework.security para poder añadirle mas ifnormación */

public class UserProfile implements UserDetails {
    private static final long serialVersionUID = 1L;
    
    private int idUsuario;
    private String username;
    private String password;
    private String email;
    private String nombre;
    private String urlFoto;
 
    /* Spring Security fields*/
    private List<GrantedAuthority> authorities;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;
    
    
    	
	public UserProfile(int idUsuario, String username, String password, String email, String nombre, String urlFoto,
			List<GrantedAuthority> authorities, boolean accountNonExpired, boolean accountNonLocked,
			boolean credentialsNonExpired, boolean enabled) {
		super();
		this.idUsuario = idUsuario;
		this.username = username;
		this.password = password;
		this.email = email;
		this.nombre = nombre;
		this.urlFoto = urlFoto;
		this.authorities = authorities;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
     
    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
	
    @Override
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
	
	@Override
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
	
	
	@Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }
     
    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }
	
	
    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }
     
    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }
    
    
	@Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }
     
    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }
	
	
    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
 
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(": ");
        sb.append("Email: ").append(this.email).append("; ");
        sb.append("Password: [PROTECTED]; ");
        sb.append("Username: ").append(this.username).append("; ");
        sb.append("IdUsuario: ").append(this.idUsuario).append("; ");
        sb.append("Nombre: ").append(this.nombre).append("; ");
        sb.append("UrlFoto: ").append(this.urlFoto).append("; ");
        sb.append("Enabled: ").append(this.enabled).append("; ");
        sb.append("AccountNonExpired: ").append(this.accountNonExpired).append("; ");
        sb.append("credentialsNonExpired: ").append(this.credentialsNonExpired).append("; ");
        sb.append("AccountNonLocked: ").append(this.accountNonLocked).append("; ");

        if (!authorities.isEmpty()) {
            sb.append("Granted Authorities: ");

            boolean first = true;
            for (GrantedAuthority auth : authorities) {
                if (!first) {
                    sb.append(",");
                }
                first = false;

                sb.append(auth);
            }
        } else {
            sb.append("Not granted any authorities");
        }

        return sb.toString();
    }

}
