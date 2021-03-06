/**
 * 
 */
package es.ugarrio.elmercadilloagricola.service;

import java.util.List;
import java.util.Map;

import es.ugarrio.elmercadilloagricola.domain.Anuncio;
import es.ugarrio.elmercadilloagricola.dto.AnuncioDTO;
import es.ugarrio.elmercadilloagricola.form.AnuncioSearchForm;

/**
 * @author Vicente Ugarrio
 *
 */
public interface AnuncioService {
	
	/**
	 * @param filtro GRUPO DE FILTROS DINAMICOS
	 * @param pagina PAGINA DE LOS ELEMENTOS A MOSTRAR
	 * @param num_elementos NUM. DE ELEMENTOS QUE SE MUESTRAN POR PAGINA
	 * @param orden CAMPOS Y DIRECCION POR LOS QUE SE MUESTRAN LOS REGISTROS ORDENADOS
	 * 
	 * @return LISTADO DE LOS ANUNCIONS BUSCADOS
	 */	
	public List<AnuncioDTO> findAnunciosPaginados(AnuncioSearchForm anuncioSearchForm, int pagina, int num_elementos, String orden);
	

	/**
	 * @return NUMERO DE ANUNCIOS BUSCADOS
	 */	
	public int countAnunciosPaginados(AnuncioSearchForm anuncioSearchForm);
	
	/**
	 * @param num NUM DE REGISGTROS A DEVOLVER
	 * 
	 * @return LISTADO DE LOS ULTIMOS NUM REGISTROS PUBLICADOS
	 */	
	public List<AnuncioDTO> findLast(int num);
	
	
	/**
	 * @return NUMERO DE ANUNCIOS ACTIVOS
	 */	
	public int countActivos();

	
	/**
	 * @param idAnuncio 
	 * 
	 * @return AnuncioDTO
	 */	
	public AnuncioDTO findOne(int idAnuncio);


	


	
	
}
