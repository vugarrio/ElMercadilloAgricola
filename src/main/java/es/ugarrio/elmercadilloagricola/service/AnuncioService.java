/**
 * 
 */
package es.ugarrio.elmercadilloagricola.service;

import java.util.List;

import es.ugarrio.elmercadilloagricola.domain.Anuncio;

/**
 * @author Tente
 *
 */
public interface AnuncioService {
	
		
	/**
	 * @param num NUM DE REGISGTROS A DEVOLVER
	 * 
	 * @return LISTADO DE LOS ULTIMOS NUM REGISTROS PUBLICADOS
	 */	
	public List<Anuncio> findLast(int num);
	
}
