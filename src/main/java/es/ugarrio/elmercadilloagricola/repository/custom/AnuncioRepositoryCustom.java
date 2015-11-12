package es.ugarrio.elmercadilloagricola.repository.custom;

import java.util.List;

import es.ugarrio.elmercadilloagricola.domain.Anuncio;


public interface AnuncioRepositoryCustom {
	
	public List<Anuncio> findLast(int num);
	
}

