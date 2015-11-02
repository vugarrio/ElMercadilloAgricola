package es.ugarrio.elmercadilloagricola.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the anuncios_imagenes database table.
 * 
 */
@Entity
@Table(name="anuncios_imagenes")
public class AnuncioImagen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_anuncio_imagen", unique=true, nullable=false)
	private int idAnuncioImagen;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at", nullable=false)
	private Date createdAt;

	@Column(name="es_activo", nullable=false)
	private byte esActivo;

	@Column(nullable=false)
	private int orden;

	@Column(length=255)
	private String titulo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="url_fichero", length=255)
	private String urlFichero;

	//bi-directional many-to-one association to Anuncio
	@ManyToOne
	@JoinColumn(name="anuncio_id", nullable=false)
	private Anuncio anuncio;

	public AnuncioImagen() {
	}

	public int getIdAnuncioImagen() {
		return this.idAnuncioImagen;
	}

	public void setIdAnuncioImagen(int idAnuncioImagen) {
		this.idAnuncioImagen = idAnuncioImagen;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public byte getEsActivo() {
		return this.esActivo;
	}

	public void setEsActivo(byte esActivo) {
		this.esActivo = esActivo;
	}

	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
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

	public String getUrlFichero() {
		return this.urlFichero;
	}

	public void setUrlFichero(String urlFichero) {
		this.urlFichero = urlFichero;
	}

	public Anuncio getAnuncio() {
		return this.anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

}