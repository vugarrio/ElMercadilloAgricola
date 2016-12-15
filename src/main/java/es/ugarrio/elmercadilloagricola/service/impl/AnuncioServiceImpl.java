/**
 * 
 */
package es.ugarrio.elmercadilloagricola.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import es.ugarrio.elmercadilloagricola.domain.Anuncio;
import es.ugarrio.elmercadilloagricola.domain.Categoria;
import es.ugarrio.elmercadilloagricola.dto.AnuncioDTO;
import es.ugarrio.elmercadilloagricola.form.AnuncioSearchForm;
import es.ugarrio.elmercadilloagricola.repository.AnuncioRepository;
import es.ugarrio.elmercadilloagricola.repository.CategoriaRepository;
import es.ugarrio.elmercadilloagricola.repository.custom.AnuncioRepositoryCustom;
import es.ugarrio.elmercadilloagricola.repository.impl.AnuncioRepositoryImpl;
import es.ugarrio.elmercadilloagricola.service.AnuncioService;

/**
 * @author Vicente Ugarrio
 *
 */

@Service
@Transactional(readOnly = true)
public class AnuncioServiceImpl implements AnuncioService {

	@Inject
	private AnuncioRepository anuncioRepository;
	
	@Inject
	private CategoriaRepository categoriaRepository;
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AnuncioDTO> findAnunciosPaginados(AnuncioSearchForm anuncioSearchForm, int pagina, int num_elementos, String orden) {
		
		//En el caso de pasar como filtro una categoria, comprobamos si es del ultimo nivel, para pasarla como id_categoria o id_categoria_padre.
		boolean esCategoriaUltimoNivel = false;        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdCategoria())) {            
            //Obtener si una categoria de ultimo nivel 
            Categoria cat = categoriaRepository.findOne(Integer.parseInt(anuncioSearchForm.getFiltroIdCategoria()));
            
            if (cat != null) {
            	esCategoriaUltimoNivel  = (cat.getEsUltimoNivel()!=0);
            }
            
            if (!esCategoriaUltimoNivel) {
            	anuncioSearchForm.setFiltroIdCategoriaPadre(anuncioSearchForm.getFiltroIdCategoria());
            	anuncioSearchForm.setFiltroIdCategoria(null);
            }
        }    
		
		
		List<Anuncio> listAllAnuncios =  anuncioRepository.findAllWitchFiltersAndPagination(anuncioSearchForm, pagina, num_elementos, orden);
		List<AnuncioDTO> listAllAnunciosDAO = new ArrayList<AnuncioDTO>();
		for (Anuncio anuncio : listAllAnuncios) {
			listAllAnunciosDAO.add(new AnuncioDTO(anuncio));
		}
		
		return listAllAnunciosDAO;		
	}
	
	@Override
	public int countAnunciosPaginados(AnuncioSearchForm anuncioSearchForm) {
		return (int)anuncioRepository.countAllWitchFiltersAndPagination(anuncioSearchForm);
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<AnuncioDTO> findLast(int num) {
		
		// Utilizando el JPARepository (No utilizo esta forma poque necesitamos filtrar por "a.anunciosEstados.idAnuncioEstado = 1")
		/*PageRequest pageRequest = new PageRequest(0, num, Sort.Direction.DESC, "fechaPublicacion");  
        return anuncioRepository.findAll(pageRequest).getContent();*/
         
	    //return anuncioRepository.findLast(num);
		
			
		//return anuncioRepository.findAll(); //Funcion de JpaRepository		
		List<Anuncio> listLastAnuncios = anuncioRepository.findLast(num);  //Funcion mia de AnuncioRepositoryCustom
		List<AnuncioDTO> listLastAnunciosDAO = new ArrayList<AnuncioDTO>();
		for (Anuncio anuncio : listLastAnuncios) {
			listLastAnunciosDAO.add(new AnuncioDTO(anuncio));
		}
		
		return listLastAnunciosDAO;		
	}
	
	@Override
	public int countActivos() {
		return (int)anuncioRepository.countActivos();
	}
	
	@Override
	public AnuncioDTO findOne (int idAnuncio) {
		Anuncio anuncio = anuncioRepository.findOne(idAnuncio);
		return new AnuncioDTO(anuncio);
		
	}
	
}
