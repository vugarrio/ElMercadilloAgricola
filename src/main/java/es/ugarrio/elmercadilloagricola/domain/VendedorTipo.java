package es.ugarrio.elmercadilloagricola.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vendedores_tipos database table.
 * 
 */
@Entity
@Table(name="vendedores_tipos")
public class VendedorTipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_vendedor_tipo", unique=true, nullable=false)
	private int idVendedorTipo;

	@Column(name="es_activo", nullable=false)
	private byte esActivo;

	@Column(name="nombre_vendedor_tipo", length=50)
	private String nombreVendedorTipo;

	//bi-directional many-to-one association to Anuncio
	@OneToMany(mappedBy="vendedoresTipo")
	private List<Anuncio> anuncios;

	public VendedorTipo() {
	}

	public int getIdVendedorTipo() {
		return this.idVendedorTipo;
	}

	public void setIdVendedorTipo(int idVendedorTipo) {
		this.idVendedorTipo = idVendedorTipo;
	}

	public byte getEsActivo() {
		return this.esActivo;
	}

	public void setEsActivo(byte esActivo) {
		this.esActivo = esActivo;
	}

	public String getNombreVendedorTipo() {
		return this.nombreVendedorTipo;
	}

	public void setNombreVendedorTipo(String nombreVendedorTipo) {
		this.nombreVendedorTipo = nombreVendedorTipo;
	}

	public List<Anuncio> getAnuncios() {
		return this.anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}

	public Anuncio addAnuncio(Anuncio anuncio) {
		getAnuncios().add(anuncio);
		anuncio.setVendedoresTipo(this);

		return anuncio;
	}

	public Anuncio removeAnuncio(Anuncio anuncio) {
		getAnuncios().remove(anuncio);
		anuncio.setVendedoresTipo(null);

		return anuncio;
	}

}