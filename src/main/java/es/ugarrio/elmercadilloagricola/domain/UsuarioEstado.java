package es.ugarrio.elmercadilloagricola.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuarios_estados database table.
 * 
 */
@Entity
@Table(name="usuarios_estados")
public class UsuarioEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_usuario_estado", unique=true, nullable=false)
	private int idUsuarioEstado;

	@Column(name="nombre_usuario_estado", length=50)
	private String nombreUsuarioEstado;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="usuariosEstado")
	private List<Usuario> usuarios;

	public UsuarioEstado() {
	}

	public int getIdUsuarioEstado() {
		return this.idUsuarioEstado;
	}

	public void setIdUsuarioEstado(int idUsuarioEstado) {
		this.idUsuarioEstado = idUsuarioEstado;
	}

	public String getNombreUsuarioEstado() {
		return this.nombreUsuarioEstado;
	}

	public void setNombreUsuarioEstado(String nombreUsuarioEstado) {
		this.nombreUsuarioEstado = nombreUsuarioEstado;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setUsuariosEstado(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setUsuariosEstado(null);

		return usuario;
	}

}