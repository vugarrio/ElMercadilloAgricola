package es.ugarrio.elmercadilloagricola.form;

import java.io.Serializable;

public class AnuncioSearchForm implements Serializable {
	
    /**
     * serial version uid.
     */
    private static final long serialVersionUID = 1L;
    
 
    private String filtroIdAnuncio; 
    private String filtroIdUsuario;                
    private String filtroIdCategoria;
    private String filtroIdCategoriaPadre;
    private String filtroIdProvincia;
    private String filtroCP;
    private String filtroTxt;
    private String filtroPrecioDesde;
    private String filtroPrecioHasta;
    private String filtroIdAnuncioEstado; 
    	    
    private String listadoVista;
    private String listadoOrdenarPor;
    private String listadoSize;
    
    
	public String getFiltroIdAnuncio() {
		return filtroIdAnuncio;
	}
	public void setFiltroIdAnuncio(String filtroIdAnuncio) {
		this.filtroIdAnuncio = filtroIdAnuncio;
	}
	public String getFiltroIdUsuario() {
		return filtroIdUsuario;
	}
	public void setFiltroIdUsuario(String filtroIdUsuario) {
		this.filtroIdUsuario = filtroIdUsuario;
	}
	public String getFiltroIdCategoria() {
		return filtroIdCategoria;
	}
	public void setFiltroIdCategoria(String filtroIdCategoria) {
		this.filtroIdCategoria = filtroIdCategoria;
	}
	
	public String getFiltroIdCategoriaPadre() {
		return filtroIdCategoriaPadre;
	}
	public void setFiltroIdCategoriaPadre(String filtroIdCategoriaPadre) {
		this.filtroIdCategoriaPadre = filtroIdCategoriaPadre;
	}
	public String getFiltroIdProvincia() {
		return filtroIdProvincia;
	}
	public void setFiltroIdProvincia(String filtroIdProvincia) {
		this.filtroIdProvincia = filtroIdProvincia;
	}
	public String getFiltroCP() {
		return filtroCP;
	}
	public void setFiltroCP(String filtroCP) {
		this.filtroCP = filtroCP;
	}
	public String getFiltroTxt() {
		return filtroTxt;
	}
	public void setFiltroTxt(String filtroTxt) {
		this.filtroTxt = filtroTxt;
	}
	public String getFiltroPrecioDesde() {
		return filtroPrecioDesde;
	}
	public void setFiltroPrecioDesde(String filtroPrecioDesde) {
		this.filtroPrecioDesde = filtroPrecioDesde;
	}
	public String getFiltroPrecioHasta() {
		return filtroPrecioHasta;
	}
	public void setFiltroPrecioHasta(String filtroPrecioHasta) {
		this.filtroPrecioHasta = filtroPrecioHasta;
	}
	public String getListadoVista() {
		return listadoVista;
	}
	public void setListadoVista(String listadoVista) {
		this.listadoVista = listadoVista;
	}
	public String getListadoOrdenarPor() {
		return listadoOrdenarPor;
	}
	public void setListadoOrdenarPor(String listadoOrdenarPor) {
		this.listadoOrdenarPor = listadoOrdenarPor;
	}
	public String getListadoSize() {
		return listadoSize;
	}
	public void setListadoSize(String listadoSize) {
		this.listadoSize = listadoSize;
	}	
	
	public String getFiltroIdAnuncioEstado() {
		return filtroIdAnuncioEstado;
	}
	public void setFiltroIdAnuncioEstado(String filtroIdAnuncioEstado) {
		this.filtroIdAnuncioEstado = filtroIdAnuncioEstado;
	}
	
	@Override
	public String toString() {
		return "AnuncioSearchForm [filtroIdAnuncio=" + filtroIdAnuncio
				+ ", filtroIdUsuario=" + filtroIdUsuario
				+ ", filtroIdCategoria=" + filtroIdCategoria
				+ ", filtroIdCategoriaPadre=" + filtroIdCategoriaPadre
				+ ", filtroIdProvincia=" + filtroIdProvincia + ", filtroCP="
				+ filtroCP + ", filtroTxt=" + filtroTxt
				+ ", filtroPrecioDesde=" + filtroPrecioDesde
				+ ", filtroPrecioHasta=" + filtroPrecioHasta
				+ ", filtroIdAnuncioEstado=" + filtroIdAnuncioEstado
				+ ", listadoVista=" + listadoVista + ", listadoOrdenarPor="
				+ listadoOrdenarPor + ", listadoSize=" + listadoSize + "]";
	}
	
	
}
