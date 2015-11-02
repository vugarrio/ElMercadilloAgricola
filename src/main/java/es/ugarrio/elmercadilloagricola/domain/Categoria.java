package es.ugarrio.elmercadilloagricola.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the categorias database table.
 * 
 */
@Entity
@Table(name="categorias")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_categoria", unique=true, nullable=false)
	private int idCategoria;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at", nullable=false)
	private Date createdAt;

	@Column(name="es_activa", nullable=false)
	private byte esActiva;

	@Column(name="es_ultimo_nivel", nullable=false)
	private byte esUltimoNivel;

	private int nivel;

	@Column(name="nombre_categoria", length=100)
	private String nombreCategoria;

	@Column(nullable=false)
	private int orden;

	@Column(length=100)
	private String path;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="url_imagen", length=255)
	private String urlImagen;

	//bi-directional many-to-one association to Anuncio
	@OneToMany(mappedBy="categoria")
	private List<Anuncio> anuncios;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="id_categoria_padre")
	private Categoria categoria;

	//bi-directional many-to-one association to Categoria
	@OneToMany(mappedBy="categoria")
	private List<Categoria> categorias;

	public Categoria() {
	}

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public byte getEsActiva() {
		return this.esActiva;
	}

	public void setEsActiva(byte esActiva) {
		this.esActiva = esActiva;
	}

	public byte getEsUltimoNivel() {
		return this.esUltimoNivel;
	}

	public void setEsUltimoNivel(byte esUltimoNivel) {
		this.esUltimoNivel = esUltimoNivel;
	}

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getNombreCategoria() {
		return this.nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUrlImagen() {
		return this.urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public List<Anuncio> getAnuncios() {
		return this.anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}

	public Anuncio addAnuncio(Anuncio anuncio) {
		getAnuncios().add(anuncio);
		anuncio.setCategoria(this);

		return anuncio;
	}

	public Anuncio removeAnuncio(Anuncio anuncio) {
		getAnuncios().remove(anuncio);
		anuncio.setCategoria(null);

		return anuncio;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return this.categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Categoria addCategoria(Categoria categoria) {
		getCategorias().add(categoria);
		categoria.setCategoria(this);

		return categoria;
	}

	public Categoria removeCategoria(Categoria categoria) {
		getCategorias().remove(categoria);
		categoria.setCategoria(null);

		return categoria;
	}

}