package es.ugarrio.elmercadilloagricola.web.dto;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import es.ugarrio.elmercadilloagricola.domain.Anuncio;
import es.ugarrio.elmercadilloagricola.domain.AnuncioEstado;
import es.ugarrio.elmercadilloagricola.domain.AnuncioImagen;
import es.ugarrio.elmercadilloagricola.domain.AnuncioMensaje;
import es.ugarrio.elmercadilloagricola.domain.Categoria;
import es.ugarrio.elmercadilloagricola.domain.HorarioLlamada;
import es.ugarrio.elmercadilloagricola.domain.Provincia;
import es.ugarrio.elmercadilloagricola.domain.Usuario;
import es.ugarrio.elmercadilloagricola.domain.VendedorTipo;

public class AnuncioDTO {


	private int idAnuncio;

	private String cp;

	private String descripcion;

	private String email;

	private String empresaNombre;

	private String localidad;

	private String marca;

	private String modelo;

	private int numEnviosEmail;

	private int numVistos;

	private BigDecimal precio;

	private String telefono;

	private String titulo;
	
	private AnuncioEstado anunciosEstado;

	private Categoria categoria;

	private HorarioLlamada horariosLlamada;

	private Provincia provincia;

	private Usuario usuario;

	private VendedorTipo vendedoresTipo;

	private List<AnuncioImagen> anunciosImagenes;

	private List<AnuncioMensaje> anunciosMensajes;
	
	//Nuevos datos
	private String txtFechaPublicado;
	
	private String txtDescripcionDestacado;
	   
	private String urlImagen;
	
	private int numAnunciosImagenes;
	
	private int numAnunciosMensajes;    
	
	public AnuncioDTO (Anuncio anuncio) {
		this.setIdAnuncio(anuncio.getIdAnuncio());
		this.setTitulo(anuncio.getTitulo());
		this.setPrecio(anuncio.getPrecio());
		this.setCategoria(anuncio.getCategoria());
		this.setProvincia(anuncio.getProvincia());
		this.setMarca(anuncio.getMarca());
		this.setModelo(anuncio.getModelo());
		
		this.setNumEnviosEmail(anuncio.getNumEnviosEmal());
		this.setNumVistos(anuncio.getNumVistos());
		
		this.setNumAnunciosImagenes(0);
		this.setNumAnunciosMensajes(0);
		
		//Listado de imagenes
		this.setAnunciosImagenes(anuncio.getAnunciosImagenes());
		
		//Listado de mensajes
		this.setAnunciosMensajes(anuncio.getAnunciosMensajes());
		
	
		
		//Descripcion
		String descripcion = anuncio.getDescripcion();
		if (descripcion.length() > 220) {
            descripcion = descripcion.substring(0, 217) + "...";
        } 
		this.setDescripcion(descripcion);
		
		
		//Calculamos el tiempo transcurrido desde que se publico el anuncio
		String fecha_anuncio_txt = "";
		if (anuncio.getFechaPublicacion() != null) {
            fecha_anuncio_txt = new SimpleDateFormat("dd/MM/yyyy").format(anuncio.getFechaPublicacion());

            java.util.Date hoy = new Date(); //Fecha de hoy 

            long  diferencia = ( hoy.getTime() - anuncio.getFechaPublicacion().getTime());
            long diffHours = diferencia / (60 * 60 * 1000); // calcular la diferencia en horas
            int txt_dia_hoy = Integer.parseInt(new SimpleDateFormat("dd").format(hoy));
            int txt_dia_anuncio = Integer.parseInt(new SimpleDateFormat("dd").format(anuncio.getFechaPublicacion()));

            if (diffHours < 48 && (txt_dia_hoy == txt_dia_anuncio)) {
                fecha_anuncio_txt = "Hoy " +  new SimpleDateFormat("HH:mm").format(anuncio.getFechaPublicacion());
            } else if (diffHours < 48) {
                fecha_anuncio_txt = "Ayer " +  new SimpleDateFormat("HH:mm").format(anuncio.getFechaPublicacion());
            }
            this.setTxtFechaPublicado(fecha_anuncio_txt);
        }    
		
		//Texto descripcion destacado
		String txtDescripcionDestacado = "";
		if (anuncio.getMarca() != null || anuncio.getModelo() != null ) {
            if (anuncio.getMarca() != null) {
            	txtDescripcionDestacado +=  anuncio.getMarca() ;                    
            }
            if (anuncio.getMarca() != null && anuncio.getModelo() != null ) {
            	txtDescripcionDestacado += ", ";
            }
            if (anuncio.getModelo() != null) {
            	txtDescripcionDestacado += anuncio.getModelo();     
            }            
        }    
		this.setTxtDescripcionDestacado(txtDescripcionDestacado);		
		
		//Imagen
		String urlImagen = "";
		if (anuncio.getAnunciosImagenes() != null && anuncio.getAnunciosImagenes().size()>0) {
            urlImagen = anuncio.getAnunciosImagenes().get(0).getUrlFichero();  
            this.setNumAnunciosImagenes(anuncio.getAnunciosImagenes().size());
        } else {
    	   urlImagen = "images/listado_sin_imagen_600x40.png";  
        }  
		this.setUrlImagen(urlImagen);
		
		//Mensajes
		if (anuncio.getAnunciosMensajes() != null ) { 
			//this.setNumAnunciosMensajes(anuncio.getAnunciosMensajes().size());
		}
		
		
	}
	

	public int getIdAnuncio() {
		return idAnuncio;
	}
	
	public void setIdAnuncio(int idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpresaNombre() {
		return empresaNombre;
	}

	public void setEmpresaNombre(String empresaNombre) {
		this.empresaNombre = empresaNombre;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getNumEnviosEmail() {
		return numEnviosEmail;
	}

	public void setNumEnviosEmail(int numEnviosEmail) {
		this.numEnviosEmail = numEnviosEmail;
	}

	public int getNumVistos() {
		return numVistos;
	}

	public void setNumVistos(int numVistos) {
		this.numVistos = numVistos;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public AnuncioEstado getAnunciosEstado() {
		return anunciosEstado;
	}

	public void setAnunciosEstado(AnuncioEstado anunciosEstado) {
		this.anunciosEstado = anunciosEstado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public HorarioLlamada getHorariosLlamada() {
		return horariosLlamada;
	}

	public void setHorariosLlamada(HorarioLlamada horariosLlamada) {
		this.horariosLlamada = horariosLlamada;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public VendedorTipo getVendedoresTipo() {
		return vendedoresTipo;
	}

	public void setVendedoresTipo(VendedorTipo vendedoresTipo) {
		this.vendedoresTipo = vendedoresTipo;
	}

	public List<AnuncioImagen> getAnunciosImagenes() {
		return anunciosImagenes;
	}

	public void setAnunciosImagenes(List<AnuncioImagen> anunciosImagenes) {
		this.anunciosImagenes = anunciosImagenes;
	}

	public List<AnuncioMensaje> getAnunciosMensajes() {
		return anunciosMensajes;
	}

	public void setAnunciosMensajes(List<AnuncioMensaje> anunciosMensajes) {
		this.anunciosMensajes = anunciosMensajes;
	}

	public String getTxtFechaPublicado() {
		return txtFechaPublicado;
	}

	public void setTxtFechaPublicado(String txtFechaPublicado) {
		this.txtFechaPublicado = txtFechaPublicado;
	}

	public String getTxtDescripcionDestacado() {
		return txtDescripcionDestacado;
	}

	public void setTxtDescripcionDestacado(String txtDescripcionDestacado) {
		this.txtDescripcionDestacado = txtDescripcionDestacado;
	}
	
	public int getNumAnunciosImagenes() {
		return numAnunciosImagenes;
	}


	public void setNumAnunciosImagenes(int numAnunciosImagenes) {
		this.numAnunciosImagenes = numAnunciosImagenes;
	}


	public int getNumAnunciosMensajes() {
		return numAnunciosMensajes;
	}


	public void setNumAnunciosMensajes(int numAnunciosMensajes) {
		this.numAnunciosMensajes = numAnunciosMensajes;
	}


	public String getUrlImagen() {
		return urlImagen;
	}


	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	@Override
	public String toString() {
		return "AnuncioDTO [idAnuncio=" + idAnuncio + ", cp=" + cp + ", descripcion=" + descripcion + ", email=" + email
				+ ", empresaNombre=" + empresaNombre + ", localidad=" + localidad + ", marca=" + marca + ", modelo="
				+ modelo + ", numEnviosEmail=" + numEnviosEmail + ", numVistos=" + numVistos + ", precio=" + precio
				+ ", telefono=" + telefono + ", titulo=" + titulo + ", anunciosEstado=" + anunciosEstado
				+ ", categoria=" + categoria + ", provincia=" + provincia + ", usuario=" + usuario + ", vendedoresTipo="
				+ vendedoresTipo + ", txtFechaPublicado=" + txtFechaPublicado + ", txtDescripcionDestacado="
				+ txtDescripcionDestacado + ", urlImagen=" + urlImagen + "]";
	}
	
	
	
	
	
}
