package es.ugarrio.elmercadilloagricola.dto;

import java.io.Serializable;

public class ProvinciaAnunciosDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idProvincia;	
	private String nombreProvincia;
	private int countProvincias;
	
	
	
	public ProvinciaAnunciosDTO(int idProvincia, String nombreProvincia, int countProvincias) {
		super();
		this.idProvincia = idProvincia;
		this.nombreProvincia = nombreProvincia;
		this.countProvincias = countProvincias;
	}
	public int getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
	public String getNombreProvincia() {
		return nombreProvincia;
	}
	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}
	public int getCountProvincias() {
		return countProvincias;
	}
	public void setCountProvincias(int countProvincias) {
		this.countProvincias = countProvincias;
	}
	
	@Override
	public String toString() {
		return "ProvinciaAnunciosDTO [idProvincia=" + idProvincia + ", nombreProvincia=" + nombreProvincia
				+ ", countProvincias=" + countProvincias + "]";
	}
	
	
	
	

}
