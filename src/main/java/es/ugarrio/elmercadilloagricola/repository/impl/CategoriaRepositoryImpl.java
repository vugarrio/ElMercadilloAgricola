package es.ugarrio.elmercadilloagricola.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;



import org.springframework.util.StringUtils;

import es.ugarrio.elmercadilloagricola.domain.Categoria;
import es.ugarrio.elmercadilloagricola.dto.CategoriaAnunciosDTO;
import es.ugarrio.elmercadilloagricola.form.AnuncioSearchForm;
import es.ugarrio.elmercadilloagricola.repository.custom.CategoriaRepositoryCustom;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepositoryCustom  {
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
	
	@PersistenceContext
	private EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CategoriaAnunciosDTO> findCategoriasAnuncios(AnuncioSearchForm anuncioSearchForm) {
		
		String consulta;
        String consulta_ini;
                 
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdCategoria())) {
        	int esUltimoNivel = 0;
            
            //Obtener si una categoria de ultimo nivel
            consulta_ini= "from Categoria c where c.idCategoria = :idCategoria ";
           
            Query q_c = em.createQuery(consulta_ini);
            q_c.setParameter("idCategoria", Integer.parseInt(anuncioSearchForm.getFiltroIdCategoria()));
            Categoria cat = (Categoria) q_c.getSingleResult();
            
            if (cat != null) {
                esUltimoNivel  = cat.getEsUltimoNivel();
            }
            
             
                        
            if (esUltimoNivel == 1) {
//                 Equivale:
//                    select COUNT(ANUNCIOS.ID_ANUNCIO) as num_anuncio, C2.ID_CATEGORIA, C2.NOMBRE_CATEGORIA 
//                           from CATEGORIAS c1 
//                                INNER JOIN CATEGORIAS c2 on C1.ID_CATEGORIA = C2.ID_CATEGORIA_PADRE
//                                                                    INNER JOIN ANUNCIOS ON C2.ID_CATEGORIA = ANUNCIOS.CATEGORIA_ID
//                    where C2.ID_CATEGORIA = 2
//                    group BY C2.ID_CATEGORIA, C2.NOMBRE_CATEGORIA    ; 
               
                consulta = "select a.categoria.idCategoria, a.categoria.nombreCategoria, count(a.idAnuncio) from Anuncio as a where  a.categoria.idCategoria = " + anuncioSearchForm.getFiltroIdCategoria() + " ";
            } else {
//                 Equivale:
//                    select COUNT(ANUNCIOS.ID_ANUNCIO) as num_anuncio, C2.ID_CATEGORIA, C2.NOMBRE_CATEGORIA 
//                           from CATEGORIAS c1 
//                                INNER JOIN CATEGORIAS c2 on C1.ID_CATEGORIA = C2.ID_CATEGORIA_PADRE
//                                                                    INNER JOIN ANUNCIOS ON C2.ID_CATEGORIA = ANUNCIOS.CATEGORIA_ID
//                    where C1.ID_CATEGORIA = 1
//                    group BY C2.ID_CATEGORIA, C2.NOMBRE_CATEGORIA    ; 
               
               consulta = "select a.categoria.idCategoria, a.categoria.nombreCategoria, count(a.idAnuncio) from Anuncio as a where  a.categoria.categoria.idCategoria = " + anuncioSearchForm.getFiltroIdCategoria() + " ";
            }
            
        } else {
//             Equivale a:
//               select COUNT(ANUNCIOS.ID_ANUNCIO) as num_anuncio, C1.ID_CATEGORIA, C1.NOMBRE_CATEGORIA 
//                        from CATEGORIAS c1 
//                             LEFT JOIN CATEGORIAS c2 on C1.ID_CATEGORIA = C2.ID_CATEGORIA_PADRE
//                             LEFT JOIN ANUNCIOS ON C2.ID_CATEGORIA = ANUNCIOS.CATEGORIA_ID
//                 where C1.ID_CATEGORIA_PADRE is null
//                 group BY C1.ID_CATEGORIA, C1.NOMBRE_CATEGORIA    ;
//                        
            consulta = "select  a.categoria.categoria.idCategoria, a.categoria.categoria.nombreCategoria, count(a.idAnuncio)  from Anuncio as a where 1 = 1 ";
        }
        
        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdAnuncio())) {
            consulta += " and a.idAnuncio = :idAnuncio ";
        }        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdUsuario())) {
            consulta += " and a.usuario.idUsuario = :idUsuario ";
        }  
                
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdProvincia())) {
            consulta += " and a.provincia.idProvincia = :idProvincia " ;
        }
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdAnuncioEstado())) {
            consulta += " and a.anunciosEstado.idAnuncioEstado = :idAnuncioEstado " ;
        }
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroCP())) {
            consulta += " and a.cp = :cp ";
        }
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroTxt())) {
            consulta += " and (upper(a.titulo) like :filtro_txt "
                     + "  or upper(a.descripcion) like :filtro_txt"
                     + "  or upper(a.marca) like :filtro_txt"
                     + "  or upper(a.modelo) like :filtro_txt)  ";
        }
        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroPrecioDesde())) {
            consulta += " and a.precio >= :precio_desde ";
        }
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroPrecioHasta())) {
            consulta += " and a.precio <= :precio_hasta ";
        }
        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdCategoria())) {        
             consulta += " group by a.categoria.idCategoria, a.categoria.nombreCategoria  ";        
             consulta += " order by a.categoria.nombreCategoria ";
         } else {
             consulta += " group by a.categoria.categoria.idCategoria, a.categoria.categoria.nombreCategoria  ";        
             consulta += " order by a.categoria.categoria.nombreCategoria ";
         }  
        
        logger.info(consulta); 
        
        Query q = em.createQuery(consulta);
        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdAnuncio())) {
            q.setParameter("idAnuncio", Integer.parseInt(anuncioSearchForm.getFiltroIdAnuncio()));
        }        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdUsuario())) {
             q.setParameter("idUsuario", Integer.parseInt(anuncioSearchForm.getFiltroIdUsuario()));
        }        
      
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdProvincia())) {
            q.setParameter("idProvincia", Integer.parseInt(anuncioSearchForm.getFiltroIdProvincia()));
        }
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdAnuncioEstado())) {
             q.setParameter("idAnuncioEstado", Integer.parseInt(anuncioSearchForm.getFiltroIdAnuncioEstado()));
        }
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroCP())) {
            q.setParameter("cp", anuncioSearchForm.getFiltroCP());
        }
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroTxt())) {
            q.setParameter("filtro_txt", "%"+anuncioSearchForm.getFiltroTxt().toUpperCase()+"%");
        }
        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroPrecioDesde())) {
            q.setParameter("precio_desde", new BigDecimal(anuncioSearchForm.getFiltroPrecioDesde()));
        }
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroPrecioHasta())) {
            q.setParameter("precio_hasta", new BigDecimal(anuncioSearchForm.getFiltroPrecioHasta()));
        }  
        
        List<CategoriaAnunciosDTO> resultCategoriaAnunciosDTO = new ArrayList<CategoriaAnunciosDTO>();
        
        for (Object[] registro: (List<Object[]>)q.getResultList()) {
        	resultCategoriaAnunciosDTO.add(new CategoriaAnunciosDTO(Integer.parseInt(registro[0].toString()), registro[1].toString(), Integer.parseInt(registro[2].toString())));
        }
        
       return resultCategoriaAnunciosDTO;
	} 
	
}
