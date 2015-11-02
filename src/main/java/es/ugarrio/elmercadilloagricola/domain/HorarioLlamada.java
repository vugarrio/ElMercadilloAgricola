package es.ugarrio.elmercadilloagricola.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the horarios_llamadas database table.
 * 
 */
@Entity
@Table(name="horarios_llamadas")
public class HorarioLlamada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_horario_llamada", unique=true, nullable=false)
	private int idHorarioLlamada;

	@Lob
	private String descripcion;

	@Column(name="es_activo", nullable=false)
	private byte esActivo;

	@Column(nullable=false)
	private int orden;

	//bi-directional many-to-one association to Anuncio
	@OneToMany(mappedBy="horariosLlamada")
	private List<Anuncio> anuncios;

	public HorarioLlamada() {
	}

	public int getIdHorarioLlamada() {
		return this.idHorarioLlamada;
	}

	public void setIdHorarioLlamada(int idHorarioLlamada) {
		this.idHorarioLlamada = idHorarioLlamada;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public List<Anuncio> getAnuncios() {
		return this.anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}

	public Anuncio addAnuncio(Anuncio anuncio) {
		getAnuncios().add(anuncio);
		anuncio.setHorariosLlamada(this);

		return anuncio;
	}

	public Anuncio removeAnuncio(Anuncio anuncio) {
		getAnuncios().remove(anuncio);
		anuncio.setHorariosLlamada(null);

		return anuncio;
	}

}