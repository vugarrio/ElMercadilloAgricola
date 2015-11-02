package es.ugarrio.elmercadilloagricola.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the provincias database table.
 * 
 */
@Entity
@Table(name="provincias")

public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idProvincia;
	private String codProvincia;
	private byte esActivo;
	private int idCcaa;
	private String nombreProvincia;
	private List<Anuncio> anuncios;

	public Provincia() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_provincia", unique=true, nullable=false)
	public int getIdProvincia() {
		return this.idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}


	@Column(name="cod_provincia", length=2)
	public String getCodProvincia() {
		return this.codProvincia;
	}

	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
	}


	@Column(name="es_activo", nullable=false)
	public byte getEsActivo() {
		return this.esActivo;
	}

	public void setEsActivo(byte esActivo) {
		this.esActivo = esActivo;
	}


	@Column(name="id_ccaa")
	public int getIdCcaa() {
		return this.idCcaa;
	}

	public void setIdCcaa(int idCcaa) {
		this.idCcaa = idCcaa;
	}


	@Column(name="nombre_provincia", length=50)
	public String getNombreProvincia() {
		return this.nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}


	//bi-directional many-to-one association to Anuncio
	@OneToMany(mappedBy="provincia")
	public List<Anuncio> getAnuncios() {
		return this.anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}

	public Anuncio addAnuncio(Anuncio anuncio) {
		getAnuncios().add(anuncio);
		anuncio.setProvincia(this);

		return anuncio;
	}

	public Anuncio removeAnuncio(Anuncio anuncio) {
		getAnuncios().remove(anuncio);
		anuncio.setProvincia(null);

		return anuncio;
	}

}