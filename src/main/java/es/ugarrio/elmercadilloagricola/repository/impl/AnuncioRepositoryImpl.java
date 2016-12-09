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
import org.springframework.util.StringUtils;

import es.ugarrio.elmercadilloagricola.domain.Anuncio;
import es.ugarrio.elmercadilloagricola.domain.Categoria;
import es.ugarrio.elmercadilloagricola.form.AnuncioSearchForm;
import es.ugarrio.elmercadilloagricola.repository.custom.AnuncioRepositoryCustom;

@Repository
public class AnuncioRepositoryImpl implements AnuncioRepositoryCustom  {
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
	
	@PersistenceContext
	private EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	@Override	
	public List<Anuncio> findAllWitchFiltersAndPagination(AnuncioSearchForm anuncioSearchFrom, int pagina, int num_elementos, String orden) {
		
		
        String consulta = "from Anuncio as a where 1 = 1 ";
        
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdAnuncio())) {
            consulta += " and a.idAnuncio = :idAnuncio ";
        }        
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdUsuario())) {
            consulta += " and a.usuario.idUsuario = :idUsuario ";
        }        
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdCategoria())) {
            consulta += " and a.categoria.idCategoria = :idCategoria " ;
        } else  if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdCategoriaPadre())) {
            consulta += " and a.categoria.categoria.idCategoria = :idCategoria " ;
        }        
                
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdProvincia())) {
            consulta += " and a.provincia.idProvincia = :idProvincia " ;
        }
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdAnuncioEstado())) {
            consulta += " and a.anunciosEstado.idAnuncioEstado = :idAnuncioEstado " ;
        }
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroCP())) {
            consulta += " and a.cp = :cp ";
        }
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroTxt())) {
            consulta += " and (upper(a.titulo) like :filtroTxt "
                     + "  or upper(a.descripcion) like :filtroTxt"
                     + "  or upper(a.marca) like :filtroTxt"
                     + "  or upper(a.modelo) like :filtroTxt)  ";
        }
        
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroPrecioDesde())) {
            consulta += " and a.precio >= :precio_desde ";
        }
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroPrecioHasta())) {
            consulta += " and a.precio <= :precio_hasta ";
        }
        
        if (!StringUtils.isEmpty(orden)) {  
            consulta += " order by " + orden;
        } else {
            consulta += " order by a.fechaPublicacion desc ";
        }
        
        logger.info(consulta);
        
        Query q = em.createQuery(consulta, Anuncio.class);
		
        //Paginacion:
        q.setFirstResult(((pagina-1) * num_elementos));
        q.setMaxResults(num_elementos);
        
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdAnuncio())) {
            q.setParameter("idAnuncio", Integer.parseInt(anuncioSearchFrom.getFiltroIdAnuncio()));
        }        
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdUsuario())) {
             q.setParameter("idUsuario", Integer.parseInt(anuncioSearchFrom.getFiltroIdUsuario()));
        }        
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdCategoria())) {
            q.setParameter("idCategoria", Integer.parseInt(anuncioSearchFrom.getFiltroIdCategoria()));
        }
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdCategoria())) {
        	 q.setParameter("idCategoria", Integer.parseInt(anuncioSearchFrom.getFiltroIdCategoria()));;
        } else  if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdCategoriaPadre())) {
        	 q.setParameter("idCategoria", Integer.parseInt(anuncioSearchFrom.getFiltroIdCategoriaPadre()));
        }
        
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdProvincia())) {
            q.setParameter("idProvincia", Integer.parseInt(anuncioSearchFrom.getFiltroIdProvincia()));
        }
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdAnuncioEstado())) {
             q.setParameter("idAnuncioEstado", Integer.parseInt(anuncioSearchFrom.getFiltroIdAnuncioEstado()));
        }
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroCP())) {
            q.setParameter("cp", anuncioSearchFrom.getFiltroCP());
        }
        
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroPrecioDesde())) {
            q.setParameter("precio_desde", new BigDecimal(anuncioSearchFrom.getFiltroPrecioDesde()));
        }
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroPrecioHasta())) {
            q.setParameter("precio_hasta", new BigDecimal(anuncioSearchFrom.getFiltroPrecioHasta()));
        }
        
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroTxt())) {
            q.setParameter("filtroTxt", "%"+anuncioSearchFrom.getFiltroTxt().toUpperCase()+"%");
        }
        
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override	
	public int countAllWitchFiltersAndPagination(AnuncioSearchForm anuncioSearchFrom) {
		
		
        String consulta = "select count(a.idAnuncio) from Anuncio as a where 1 = 1 ";
        Number count = 0;
        
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdAnuncio())) {
            consulta += " and a.idAnuncio = :idAnuncio ";
        }        
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdUsuario())) {
            consulta += " and a.usuario.idUsuario = :idUsuario ";
        }        
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdCategoria())) {
            consulta += " and a.categoria.idCategoria = :idCategoria " ;
        } else  if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdCategoriaPadre())) {
            consulta += " and a.categoria.categoria.idCategoria = :idCategoria " ;
        }        
                
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdProvincia())) {
            consulta += " and a.provincia.idProvincia = :idProvincia " ;
        }
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdAnuncioEstado())) {
            consulta += " and a.anunciosEstado.idAnuncioEstado = :idAnuncioEstado " ;
        }
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroCP())) {
            consulta += " and a.cp = :cp ";
        }
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroTxt())) {
            consulta += " and (upper(a.titulo) like :filtroTxt "
                     + "  or upper(a.descripcion) like :filtroTxt"
                     + "  or upper(a.marca) like :filtroTxt"
                     + "  or upper(a.modelo) like :filtroTxt)  ";
        }
        
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroPrecioDesde())) {
            consulta += " and a.precio >= :precio_desde ";
        }
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroPrecioHasta())) {
            consulta += " and a.precio <= :precio_hasta ";
        }
        
              
        logger.info(consulta);
        
        Query q = em.createQuery(consulta);
		        
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdAnuncio())) {
            q.setParameter("idAnuncio", Integer.parseInt(anuncioSearchFrom.getFiltroIdAnuncio()));
        }        
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdUsuario())) {
             q.setParameter("idUsuario", Integer.parseInt(anuncioSearchFrom.getFiltroIdUsuario()));
        }        
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdCategoria())) {
            q.setParameter("idCategoria", Integer.parseInt(anuncioSearchFrom.getFiltroIdCategoria()));
        }
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdCategoria())) {
        	 q.setParameter("idCategoria", Integer.parseInt(anuncioSearchFrom.getFiltroIdCategoria()));;
        } else  if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdCategoriaPadre())) {
        	 q.setParameter("idCategoria", Integer.parseInt(anuncioSearchFrom.getFiltroIdCategoriaPadre()));
        }
        
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdProvincia())) {
            q.setParameter("idProvincia", Integer.parseInt(anuncioSearchFrom.getFiltroIdProvincia()));
        }
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroIdAnuncioEstado())) {
             q.setParameter("idAnuncioEstado", Integer.parseInt(anuncioSearchFrom.getFiltroIdAnuncioEstado()));
        }
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroCP())) {
            q.setParameter("cp", anuncioSearchFrom.getFiltroCP());
        }
        
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroPrecioDesde())) {
            q.setParameter("precio_desde", new BigDecimal(anuncioSearchFrom.getFiltroPrecioDesde()));
        }
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroPrecioHasta())) {
            q.setParameter("precio_hasta", new BigDecimal(anuncioSearchFrom.getFiltroPrecioHasta()));
        }
        
        if (!StringUtils.isEmpty(anuncioSearchFrom.getFiltroTxt())) {
            q.setParameter("filtroTxt", "%"+anuncioSearchFrom.getFiltroTxt().toUpperCase()+"%");
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
