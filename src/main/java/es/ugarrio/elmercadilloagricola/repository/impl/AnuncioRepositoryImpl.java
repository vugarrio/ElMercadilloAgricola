package es.ugarrio.elmercadilloagricola.repository.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import es.ugarrio.elmercadilloagricola.domain.Anuncio;
import es.ugarrio.elmercadilloagricola.domain.Categoria;
import es.ugarrio.elmercadilloagricola.repository.custom.AnuncioRepositoryCustom;

@Repository
public class AnuncioRepositoryImpl implements AnuncioRepositoryCustom  {
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
	
	@PersistenceContext
	private EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	@Override	
	public List<Anuncio> findAllWitchFiltersAndPagination(Map<String, String> filtros, int pagina, int num_elementos, String orden) {
		
		
        String consulta = "from Anuncio as a where 1 = 1 ";
        
        if (filtros.get("filtroIdAnuncio")!=null) {
            consulta += " and a.idAnuncio = :idAnuncio ";
        }        
        if (filtros.get("filtroIdUsuario")!=null) {
            consulta += " and a.usuario.idUsuario = :idUsuario ";
        }        
        if (filtros.get("filtroIdCategoria")!=null) {
            consulta += " and a.categoria.idCategoria = :idCategoria " ;
        } else  if (filtros.get("filtroIdCategoriaPadre")!=null) {
            consulta += " and a.categoria.categoria.idCategoria = :idCategoria " ;
        }
        
        
        
        if (filtros.get("filtroIdProvincia")!=null) {
            consulta += " and a.provincia.idProvincia = :idProvincia " ;
        }
        if (filtros.get("filtro_id_anuncio_estado")!=null) {
            consulta += " and a.anunciosEstado.idAnuncioEstado = :idAnuncioEstado " ;
        }
        if (filtros.get("filtroCP")!=null) {
            consulta += " and a.cp = :cp ";
        }
        if (filtros.get("filtroTxt")!=null) {
            consulta += " and (upper(a.titulo) like :filtroTxt "
                     + "  or upper(a.descripcion) like :filtroTxt"
                     + "  or upper(a.marca) like :filtroTxt"
                     + "  or upper(a.modelo) like :filtroTxt)  ";
        }
        
        if (filtros.get("filtroPrecioDesde")!=null) {
            consulta += " and a.precio >= :precio_desde ";
        }
        if (filtros.get("filtroPrecioHasta")!=null) {
            consulta += " and a.precio <= :precio_hasta ";
        }
        
        if (orden!=null && !orden.isEmpty()) {  
            consulta += " order by " + orden;
        } else {
            consulta += " order by a.fechaPublicacion desc ";
        }
        
        logger.info(consulta);
        
        Query q = em.createQuery(consulta, Anuncio.class);
		
        //Paginacion:
        q.setFirstResult(((pagina-1) * num_elementos));
        q.setMaxResults(num_elementos);
        
        if (filtros.get("filtroIdAnuncio")!=null) {
            q.setParameter("idAnuncio", Integer.parseInt(filtros.get("filtroIdAnuncio")));
        }        
        if (filtros.get("filtroIdUsuario")!=null) {
             q.setParameter("idUsuario", Integer.parseInt(filtros.get("filtroIdUsuario")));
        }        
        if (filtros.get("filtroIdCategoria")!=null) {
            q.setParameter("idCategoria", Integer.parseInt(filtros.get("filtroIdCategoria")));
        }
        if (filtros.get("filtroIdCategoria")!=null) {
        	 q.setParameter("idCategoria", Integer.parseInt(filtros.get("filtroIdCategoria")));;
        } else  if (filtros.get("filtroIdCategoriaPadre")!=null) {
        	 q.setParameter("idCategoria", Integer.parseInt(filtros.get("filtroIdCategoriaPadre")));
        }
        
        if (filtros.get("filtroIdProvincia")!=null) {
            q.setParameter("idProvincia", Integer.parseInt(filtros.get("filtroIdProvincia")));
        }
        if (filtros.get("filtro_id_anuncio_estado")!=null) {
             q.setParameter("idAnuncioEstado", Integer.parseInt(filtros.get("filtro_id_anuncio_estado")));
        }
        if (filtros.get("filtroCP")!=null) {
            q.setParameter("cp", filtros.get("filtroCP"));
        }
        
        if (filtros.get("filtroPrecioDesde")!=null) {
            q.setParameter("precio_desde", new BigDecimal(filtros.get("filtroPrecioDesde")));
        }
        if (filtros.get("filtroPrecioHasta")!=null) {
            q.setParameter("precio_hasta", new BigDecimal(filtros.get("filtroPrecioHasta")));
        }
        
        if (filtros.get("filtroTxt")!=null) {
            q.setParameter("filtroTxt", "%"+filtros.get("filtroTxt").toUpperCase()+"%");
        }
        
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override	
	public int countAllWitchFiltersAndPagination(Map<String, String> filtros) {
		
		
        String consulta = "select count(a.idAnuncio) from Anuncio as a where 1 = 1 ";
        Number count = 0;
        
        if (filtros.get("filtroIdAnuncio")!=null) {
            consulta += " and a.idAnuncio = :idAnuncio ";
        }        
        if (filtros.get("filtroIdUsuario")!=null) {
            consulta += " and a.usuario.idUsuario = :idUsuario ";
        }        
        if (filtros.get("filtroIdCategoria")!=null) {
            consulta += " and a.categoria.idCategoria = :idCategoria " ;
        } else  if (filtros.get("filtroIdCategoriaPadre")!=null) {
            consulta += " and a.categoria.categoria.idCategoria = :idCategoria " ;
        }
                
        
        if (filtros.get("filtroIdProvincia")!=null) {
            consulta += " and a.provincia.idProvincia = :idProvincia " ;
        }
        if (filtros.get("filtro_id_anuncio_estado")!=null) {
            consulta += " and a.anunciosEstado.idAnuncioEstado = :idAnuncioEstado " ;
        }
        if (filtros.get("filtroCP")!=null) {
            consulta += " and a.cp = :cp ";
        }
        if (filtros.get("filtroTxt")!=null) {
            consulta += " and (upper(a.titulo) like :filtroTxt "
                     + "  or upper(a.descripcion) like :filtroTxt"
                     + "  or upper(a.marca) like :filtroTxt"
                     + "  or upper(a.modelo) like :filtroTxt)  ";
        }
        
        if (filtros.get("filtroPrecioDesde")!=null) {
            consulta += " and a.precio >= :precio_desde ";
        }
        if (filtros.get("filtroPrecioHasta")!=null) {
            consulta += " and a.precio <= :precio_hasta ";
        }
              
        logger.info(consulta);
        
        Query q = em.createQuery(consulta);
		        
        if (filtros.get("filtroIdAnuncio")!=null) {
            q.setParameter("idAnuncio", Integer.parseInt(filtros.get("filtroIdAnuncio")));
        }        
        if (filtros.get("filtroIdUsuario")!=null) {
             q.setParameter("idUsuario", Integer.parseInt(filtros.get("filtroIdUsuario")));
        }        
        if (filtros.get("filtroIdCategoria")!=null) {
            q.setParameter("idCategoria", Integer.parseInt(filtros.get("filtroIdCategoria")));
        }
        if (filtros.get("filtroIdCategoria")!=null) {
        	 q.setParameter("idCategoria", Integer.parseInt(filtros.get("filtroIdCategoria")));;
        } else  if (filtros.get("filtroIdCategoriaPadre")!=null) {
        	 q.setParameter("idCategoria", Integer.parseInt(filtros.get("filtroIdCategoriaPadre")));
        }
        
        if (filtros.get("filtroIdProvincia")!=null) {
            q.setParameter("idProvincia", Integer.parseInt(filtros.get("filtroIdProvincia")));
        }
        if (filtros.get("filtro_id_anuncio_estado")!=null) {
             q.setParameter("idAnuncioEstado", Integer.parseInt(filtros.get("filtro_id_anuncio_estado")));
        }
        if (filtros.get("filtroCP")!=null) {
            q.setParameter("cp", filtros.get("filtroCP"));
        }
        
        if (filtros.get("filtroPrecioDesde")!=null) {
            q.setParameter("precio_desde", new BigDecimal(filtros.get("filtroPrecioDesde")));
        }
        if (filtros.get("filtroPrecioHasta")!=null) {
            q.setParameter("precio_hasta", new BigDecimal(filtros.get("filtroPrecioHasta")));
        }
        
        if (filtros.get("filtroTxt")!=null) {
            q.setParameter("filtroTxt", "%"+filtros.get("filtroTxt").toUpperCase()+"%");
        }
        
        count = (Number) q.getSingleResult ();        
        
		return count.intValue();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Anuncio> findLast(int num) {

        Query query = this.em.createQuery("from Anuncio as a where a.anunciosEstado.idAnuncioEstado = 1 order by a.fechaPublicacion desc", Anuncio.class);
	    query.setMaxResults(num);	
	    return query.getResultList();
	
	}

}
