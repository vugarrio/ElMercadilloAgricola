package es.ugarrio.elmercadilloagricola.repository.custom;

import java.util.List;

import es.ugarrio.elmercadilloagricola.dto.ProvinciaAnunciosDTO;
import es.ugarrio.elmercadilloagricola.form.AnuncioSearchForm;



public interface  ProvinciaRepositoryCustom {
	
	
	public List<ProvinciaAnunciosDTO> findProvinciasAnuncios(AnuncioSearchForm anuncioSearchForm);
	


}