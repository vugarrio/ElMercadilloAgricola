package es.ugarrio.elmercadilloagricola.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_usuario", unique=true, nullable=false)
	private int idUsuario;

	@Column(name="confirmacion_code", length=20)
	private String confirmacionCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at", nullable=false)
	private Date createdAt;

	@Column(nullable=false, length=100)
	private String email;

	@Column(name="last_ip", length=45)
	private String lastIp;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_logged_in")
	private Date lastLoggedIn;

	@Column(length=100)
	private String nombre;

	@Column(length=20)
	private String password;

	@Column(length=20)
	private String telefono;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="url_foto", length=200)
	private String urlFoto;

	//bi-directional many-to-one association to Anuncio
	@OneToMany(mappedBy="usuario")
	private List<Anuncio> anuncios;

	//bi-directional many-to-one association to UsuarioEstado
	@ManyToOne
	@JoinColumn(name="usuario_estado_id", nullable=false)
	private UsuarioEstado usuariosEstado;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getConfirmacionCode() {
		return this.confirmacionCode;
	}

	public void setConfirmacionCode(String confirmacionCode) {
		this.confirmacionCode = confirmacionCode;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastIp() {
		return this.lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public Date getLastLoggedIn() {
		return this.lastLoggedIn;
	}

	public void setLastLoggedIn(Date lastLoggedIn) {
		this.lastLoggedIn = lastLoggedIn;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUrlFoto() {
		return this.urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public List<Anuncio> getAnuncios() {
		return this.anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}

	public Anuncio addAnuncio(Anuncio anuncio) {
		getAnuncios().add(anuncio);
		anuncio.setUsuario(this);

		return anuncio;
	}

	public Anuncio removeAnuncio(Anuncio anuncio) {
		getAnuncios().remove(anuncio);
		anuncio.setUsuario(null);

		return anuncio;
	}

	public UsuarioEstado getUsuariosEstado() {
		return this.usuariosEstado;
	}

	public void setUsuariosEstado(UsuarioEstado usuariosEstado) {
		this.usuariosEstado = usuariosEstado;
	}

}