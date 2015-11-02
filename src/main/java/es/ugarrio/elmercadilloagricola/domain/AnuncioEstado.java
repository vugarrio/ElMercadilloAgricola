package es.ugarrio.elmercadilloagricola.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the anuncios_estados database table.
 * 
 */
@Entity
@Table(name="anuncios_estados")
public class AnuncioEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_anuncio_estado", unique=true, nullable=false)
	private int idAnuncioEstado;

	@Column(name="nombre_anuncio_estado", length=50)
	private String nombreAnuncioEstado;

	//bi-directional many-to-one association to Anuncio
	@OneToMany(mappedBy="anunciosEstado")
	private List<Anuncio> anuncios;

	public AnuncioEstado() {
	}

	public int getIdAnuncioEstado() {
		return this.idAnuncioEstado;
	}

	public void setIdAnuncioEstado(int idAnuncioEstado) {
		this.idAnuncioEstado = idAnuncioEstado;
	}

	public String getNombreAnuncioEstado() {
		return this.nombreAnuncioEstado;
	}

	public void setNombreAnuncioEstado(String nombreAnuncioEstado) {
		this.nombreAnuncioEstado = nombreAnuncioEstado;
	}

	public List<Anuncio> getAnuncios() {
		return this.anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}

	public Anuncio addAnuncio(Anuncio anuncio) {
		getAnuncios().add(anuncio);
		anuncio.setAnunciosEstado(this);

		return anuncio;
	}

	public Anuncio removeAnuncio(Anuncio anuncio) {
		getAnuncios().remove(anuncio);
		anuncio.setAnunciosEstado(null);

		return anuncio;
	}

}