package es.ugarrio.elmercadilloagricola.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the anuncios_mensajes database table.
 * 
 */
@Entity
@Table(name="anuncios_mensajes")
public class AnuncioMensaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_anuncio_mensaje", unique=true, nullable=false)
	private int idAnuncioMensaje;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Column(name="email_from", length=100)
	private String emailFrom;

	@Column(name="es_leido", nullable=false)
	private byte esLeido;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_leido")
	private Date fechaLeido;

	@Column(nullable=false, length=45)
	private String ip;

	@Lob
	private String mensaje;

	@Column(name="nombre_from", length=100)
	private String nombreFrom;

	@Column(name="telefono_from", length=20)
	private String telefonoFrom;

	@Column(length=150)
	private String titulo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="usuario_id_from")
	private Integer usuarioIdFrom;

	//bi-directional many-to-one association to Anuncio
	@ManyToOne
	@JoinColumn(name="anuncio_id", nullable=false)
	private Anuncio anuncio;

	public AnuncioMensaje() {
	}

	public int getIdAnuncioMensaje() {
		return this.idAnuncioMensaje;
	}

	public void setIdAnuncioMensaje(int idAnuncioMensaje) {
		this.idAnuncioMensaje = idAnuncioMensaje;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getEmailFrom() {
		return this.emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public byte getEsLeido() {
		return this.esLeido;
	}

	public void setEsLeido(byte esLeido) {
		this.esLeido = esLeido;
	}

	public Date getFechaLeido() {
		return this.fechaLeido;
	}

	public void setFechaLeido(Date fechaLeido) {
		this.fechaLeido = fechaLeido;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getNombreFrom() {
		return this.nombreFrom;
	}

	public void setNombreFrom(String nombreFrom) {
		this.nombreFrom = nombreFrom;
	}

	public String getTelefonoFrom() {
		return this.telefonoFrom;
	}

	public void setTelefonoFrom(String telefonoFrom) {
		this.telefonoFrom = telefonoFrom;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getUsuarioIdFrom() {
		return this.usuarioIdFrom;
	}

	public void setUsuarioIdFrom(int usuarioIdFrom) {
		this.usuarioIdFrom = usuarioIdFrom;
	}

	public Anuncio getAnuncio() {
		return this.anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

}