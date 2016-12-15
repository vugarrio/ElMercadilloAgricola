package es.ugarrio.elmercadilloagricola.repository.custom;

import java.util.List;
import java.util.Map;

import es.ugarrio.elmercadilloagricola.domain.Anuncio;
import es.ugarrio.elmercadilloagricola.dto.AnuncioDTO;
import es.ugarrio.elmercadilloagricola.form.AnuncioSearchForm;


public interface AnuncioRepositoryCustom {
	
	public List<Anuncio> findLast(int num);
	
	public List<Anuncio> findAllWitchFiltersAndPagination(AnuncioSearchForm anuncioSearchForm, int pagina, int num_elementos, String orden);

	int countAllWitchFiltersAndPagination(AnuncioSearchForm anuncioSearchForm);
	
}

