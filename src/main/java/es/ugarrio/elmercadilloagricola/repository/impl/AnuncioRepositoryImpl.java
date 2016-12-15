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
	public List<Anuncio> findAllWitchFiltersAndPagination(AnuncioSearchForm anuncioSearchForm, int pagina, int num_elementos, String orden) {
		
		
        String consulta = "from Anuncio as a where 1 = 1 ";
        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdAnuncio())) {
            consulta += " and a.idAnuncio = :idAnuncio ";
        }        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdUsuario())) {
            consulta += " and a.usuario.idUsuario = :idUsuario ";
        }        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdCategoria())) {
            consulta += " and a.categoria.idCategoria = :idCategoria " ;
        } else  if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdCategoriaPadre())) {
            consulta += " and a.categoria.categoria.idCategoria = :idCategoria " ;
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
            consulta += " and (upper(a.titulo) like :filtroTxt "
                     + "  or upper(a.descripcion) like :filtroTxt"
                     + "  or upper(a.marca) like :filtroTxt"
                     + "  or upper(a.modelo) like :filtroTxt)  ";
        }
        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroPrecioDesde())) {
            consulta += " and a.precio >= :precio_desde ";
        }
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroPrecioHasta())) {
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
        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdAnuncio())) {
            q.setParameter("idAnuncio", Integer.parseInt(anuncioSearchForm.getFiltroIdAnuncio()));
        }        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdUsuario())) {
             q.setParameter("idUsuario", Integer.parseInt(anuncioSearchForm.getFiltroIdUsuario()));
        }        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdCategoria())) {
            q.setParameter("idCategoria", Integer.parseInt(anuncioSearchForm.getFiltroIdCategoria()));
        }
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdCategoria())) {
        	 q.setParameter("idCategoria", Integer.parseInt(anuncioSearchForm.getFiltroIdCategoria()));;
        } else  if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdCategoriaPadre())) {
        	 q.setParameter("idCategoria", Integer.parseInt(anuncioSearchForm.getFiltroIdCategoriaPadre()));
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
        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroPrecioDesde())) {
            q.setParameter("precio_desde", new BigDecimal(anuncioSearchForm.getFiltroPrecioDesde()));
        }
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroPrecioHasta())) {
            q.setParameter("precio_hasta", new BigDecimal(anuncioSearchForm.getFiltroPrecioHasta()));
        }
        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroTxt())) {
            q.setParameter("filtroTxt", "%"+anuncioSearchForm.getFiltroTxt().toUpperCase()+"%");
        }
        
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override	
	public int countAllWitchFiltersAndPagination(AnuncioSearchForm anuncioSearchForm) {
		
		
        String consulta = "select count(a.idAnuncio) from Anuncio as a where 1 = 1 ";
        Number count = 0;
        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdAnuncio())) {
            consulta += " and a.idAnuncio = :idAnuncio ";
        }        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdUsuario())) {
            consulta += " and a.usuario.idUsuario = :idUsuario ";
        }        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdCategoria())) {
            consulta += " and a.categoria.idCategoria = :idCategoria " ;
        } else  if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdCategoriaPadre())) {
            consulta += " and a.categoria.categoria.idCategoria = :idCategoria " ;
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
            consulta += " and (upper(a.titulo) like :filtroTxt "
                     + "  or upper(a.descripcion) like :filtroTxt"
                     + "  or upper(a.marca) like :filtroTxt"
                     + "  or upper(a.modelo) like :filtroTxt)  ";
        }
        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroPrecioDesde())) {
            consulta += " and a.precio >= :precio_desde ";
        }
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroPrecioHasta())) {
            consulta += " and a.precio <= :precio_hasta ";
        }
        
              
        logger.info(consulta);
        
        Query q = em.createQuery(consulta);
		        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdAnuncio())) {
            q.setParameter("idAnuncio", Integer.parseInt(anuncioSearchForm.getFiltroIdAnuncio()));
        }        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdUsuario())) {
             q.setParameter("idUsuario", Integer.parseInt(anuncioSearchForm.getFiltroIdUsuario()));
        }        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdCategoria())) {
            q.setParameter("idCategoria", Integer.parseInt(anuncioSearchForm.getFiltroIdCategoria()));
        }
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdCategoria())) {
        	 q.setParameter("idCategoria", Integer.parseInt(anuncioSearchForm.getFiltroIdCategoria()));;
        } else  if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdCategoriaPadre())) {
        	 q.setParameter("idCategoria", Integer.parseInt(anuncioSearchForm.getFiltroIdCategoriaPadre()));
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
        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroPrecioDesde())) {
            q.setParameter("precio_desde", new BigDecimal(anuncioSearchForm.getFiltroPrecioDesde()));
        }
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroPrecioHasta())) {
            q.setParameter("precio_hasta", new BigDecimal(anuncioSearchForm.getFiltroPrecioHasta()));
        }
        
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroTxt())) {
            q.setParameter("filtroTxt", "%"+anuncioSearchForm.getFiltroTxt().toUpperCase()+"%");
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
	
	
	/* Otro ejemplo */
//	public void addRoleToAllUsers(String roleName) {
//	    Role role = roleRepository.findByName(roleName);
//	
//	    for (User user : userRepository.findAll()) {
//	      user.addRole(role);
//	      userRepository.save(user);
//	    }
//	}    

}
