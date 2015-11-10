package es.ugarrio.elmercadilloagricola.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the anuncios database table.
 * 
 */
@Entity
@Table(name="anuncios")
public class Anuncio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_anuncio", unique=true, nullable=false)
	private int idAnuncio;

	@Column(length=5)
	private String cp;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at", nullable=false)
	private Date createdAt;

	@Lob
	private String descripcion;

	@Column(length=255)
	private String email;

	@Column(name="empresa_nombre", length=100)
	private String empresaNombre;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_caducidad")
	private Date fechaCaducidad;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_publicacion")
	private Date fechaPublicacion;

	@Column(length=100)
	private String localidad;

	@Column(length=50)
	private String marca;

	@Column(length=100)
	private String modelo;

	@Column(name="num_envios_emal", nullable=false)
	private int numEnviosEmal;

	@Column(name="num_vistos", nullable=false)
	private int numVistos;

	@Column(precision=10, scale=3)
	private BigDecimal precio;

	@Column(length=20)
	private String telefono;

	@Column(length=225)
	private String titulo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	//bi-directional many-to-one association to AnuncioEstado
	@ManyToOne
	@JoinColumn(name="anuncio_estado_id", nullable=false)
	private AnuncioEstado anunciosEstado;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="categoria_id", nullable=false)
	private Categoria categoria;

	//bi-directional many-to-one association to HorarioLlamada
	@ManyToOne
	@JoinColumn(name="horario_llamada_id")
	private HorarioLlamada horariosLlamada;

	//bi-directional many-to-one association to Provincia
	@ManyToOne
	@JoinColumn(name="provincia_id", nullable=false)
	private Provincia provincia;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario_id", nullable=false)
	private Usuario usuario;

	//bi-directional many-to-one association to VendedorTipo
	@ManyToOne
	@JoinColumn(name="vendedor_tipo_id")
	private VendedorTipo vendedoresTipo;

	//bi-directional many-to-one association to AnuncioImagen
	@OneToMany(mappedBy="anuncio", fetch = FetchType.LAZY)
	private List<AnuncioImagen> anunciosImagenes;

	//bi-directional many-to-one association to AnuncioMensaje
	@OneToMany(mappedBy="anuncio", fetch = FetchType.LAZY)
	private List<AnuncioMensaje> anunciosMensajes;

	public Anuncio() {
	}

	public int getIdAnuncio() {
		return this.idAnuncio;
	}

	public void setIdAnuncio(int idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	public String getCp() {
		return this.cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpresaNombre() {
		return this.empresaNombre;
	}

	public void setEmpresaNombre(String empresaNombre) {
		this.empresaNombre = empresaNombre;
	}

	public Date getFechaCaducidad() {
		return this.fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public Date getFechaPublicacion() {
		return this.fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getNumEnviosEmal() {
		return this.numEnviosEmal;
	}

	public void setNumEnviosEmal(int numEnviosEmal) {
		this.numEnviosEmal = numEnviosEmal;
	}

	public int getNumVistos() {
		return this.numVistos;
	}

	public void setNumVistos(int numVistos) {
		this.numVistos = numVistos;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public AnuncioEstado getAnunciosEstado() {
		return this.anunciosEstado;
	}

	public void setAnunciosEstado(AnuncioEstado anunciosEstado) {
		this.anunciosEstado = anunciosEstado;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public HorarioLlamada getHorariosLlamada() {
		return this.horariosLlamada;
	}

	public void setHorariosLlamada(HorarioLlamada horariosLlamada) {
		this.horariosLlamada = horariosLlamada;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public VendedorTipo getVendedoresTipo() {
		return this.vendedoresTipo;
	}

	public void setVendedoresTipo(VendedorTipo vendedoresTipo) {
		this.vendedoresTipo = vendedoresTipo;
	}

	public List<AnuncioImagen> getAnunciosImagenes() {
		return this.anunciosImagenes;
	}

	public void setAnunciosImagenes(List<AnuncioImagen> anunciosImagenes) {
		this.anunciosImagenes = anunciosImagenes;
	}

	public AnuncioImagen addAnunciosImagene(AnuncioImagen anunciosImagene) {
		getAnunciosImagenes().add(anunciosImagene);
		anunciosImagene.setAnuncio(this);

		return anunciosImagene;
	}

	public AnuncioImagen removeAnunciosImagene(AnuncioImagen anunciosImagene) {
		getAnunciosImagenes().remove(anunciosImagene);
		anunciosImagene.setAnuncio(null);

		return anunciosImagene;
	}

	public List<AnuncioMensaje> getAnunciosMensajes() {
		return this.anunciosMensajes;
	}

	public void setAnunciosMensajes(List<AnuncioMensaje> anunciosMensajes) {
		this.anunciosMensajes = anunciosMensajes;
	}

	public AnuncioMensaje addAnunciosMensaje(AnuncioMensaje anunciosMensaje) {
		getAnunciosMensajes().add(anunciosMensaje);
		anunciosMensaje.setAnuncio(this);

		return anunciosMensaje;
	}

	public AnuncioMensaje removeAnunciosMensaje(AnuncioMensaje anunciosMensaje) {
		getAnunciosMensajes().remove(anunciosMensaje);
		anunciosMensaje.setAnuncio(null);

		return anunciosMensaje;
	}

}