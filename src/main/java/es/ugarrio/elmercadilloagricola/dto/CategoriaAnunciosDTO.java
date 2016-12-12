package es.ugarrio.elmercadilloagricola.dto;

import java.io.Serializable;

public class CategoriaAnunciosDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idCategoria;	
	private String nombreCategoria;
	private int countAnuncios;
	
	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	public int getCountAnuncios() {
		return countAnuncios;
	}
	public void setCountAnuncios(int countAnuncios) {
		this.countAnuncios = countAnuncios;
	}
	@Override
	public String toString() {
		return "CategoriaAnunciosDTO [idCategoria=" + idCategoria
				+ ", nombreCategoria=" + nombreCategoria + ", countAnuncios="
				+ countAnuncios + "]";
	}
	
	
	
}
