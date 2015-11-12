/**
 * 
 */
package es.ugarrio.elmercadilloagricola.service;

import java.util.List;

import es.ugarrio.elmercadilloagricola.domain.Anuncio;
import es.ugarrio.elmercadilloagricola.web.dto.AnuncioDTO;

/**
 * @author Vicente Ugarrio
 *
 */
public interface AnuncioService {
	
		
	/**
	 * @param num NUM DE REGISGTROS A DEVOLVER
	 * 
	 * @return LISTADO DE LOS ULTIMOS NUM REGISTROS PUBLICADOS
	 */	
	public List<AnuncioDTO> findLast(int num);
	
}
