package es.ugarrio.elmercadilloagricola.repository.custom;

import java.util.List;

import es.ugarrio.elmercadilloagricola.dto.CategoriaAnunciosDTO;
import es.ugarrio.elmercadilloagricola.form.AnuncioSearchForm;

public interface  CategoriaRepositoryCustom {
	
	
		public List<CategoriaAnunciosDTO> findCategoriasAnuncios(AnuncioSearchForm anuncioSearchForm);
		
	

}
