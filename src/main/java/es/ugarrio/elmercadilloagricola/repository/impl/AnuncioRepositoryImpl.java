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
		
		
        
        /* System.out.println("pagina: " + pagina);
         System.out.println("num_elementos: " + num_elementos);
         System.out.println("esCategoriaUltimoNivel: " + esCategoriaUltimoNivel);
         System.out.println("listado_ordenar_por: " + filtros.get("listado_ordenar_por"));*/
        
       
        
        String consulta = "from Anuncio as a where 1 = 1 ";
        
        if (filtros.get("filtro_id_anuncio")!=null) {
            consulta += " and a.idAnuncio = :idAnuncio ";
        }        
        if (filtros.get("filtro_id_usuario")!=null) {
            consulta += " and a.usuario.idUsuario = :idUsuario ";
        }        
        if (filtros.get("filtro_id_categoria")!=null) {
            consulta += " and a.categoria.idCategoria = :idCategoria " ;
        } else  if (filtros.get("filtro_id_categoria_padre")!=null) {
            consulta += " and a.categoria.categoria.idCategoria = :idCategoria " ;
        }
        
        
        
        if (filtros.get("filtro_id_provincia")!=null) {
            consulta += " and a.provincia.idProvincia = :idProvincia " ;
        }
        if (filtros.get("filtro_id_anuncio_estado")!=null) {
            consulta += " and a.anunciosEstado.idAnuncioEstado = :idAnuncioEstado " ;
        }
        if (filtros.get("filtro_cp")!=null) {
            consulta += " and a.cp = :cp ";
        }
        if (filtros.get("filtro_txt")!=null) {
            consulta += " and (upper(a.titulo) like :filtro_txt "
                     + "  or upper(a.descripcion) like :filtro_txt"
                     + "  or upper(a.marca) like :filtro_txt"
                     + "  or upper(a.modelo) like :filtro_txt)  ";
        }
        
        if (filtros.get("filtro_precio_desde")!=null) {
            consulta += " and a.precio >= :precio_desde ";
        }
        if (filtros.get("filtro_precio_hasta")!=null) {
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
        
        if (filtros.get("filtro_id_anuncio")!=null) {
            q.setParameter("idAnuncio", Integer.parseInt(filtros.get("filtro_id_anuncio")));
        }        
        if (filtros.get("filtro_id_usuario")!=null) {
             q.setParameter("idUsuario", Integer.parseInt(filtros.get("filtro_id_usuario")));
        }        
        if (filtros.get("filtro_id_categoria")!=null) {
            q.setParameter("idCategoria", Integer.parseInt(filtros.get("filtro_id_categoria")));
        }
        if (filtros.get("filtro_id_categoria")!=null) {
        	 q.setParameter("idCategoria", Integer.parseInt(filtros.get("filtro_id_categoria")));;
        } else  if (filtros.get("filtro_id_categoria_padre")!=null) {
        	 q.setParameter("idCategoria", Integer.parseInt(filtros.get("filtro_id_categoria_padre")));
        }
        
        if (filtros.get("filtro_id_provincia")!=null) {
            q.setParameter("idProvincia", Integer.parseInt(filtros.get("filtro_id_provincia")));
        }
        if (filtros.get("filtro_id_anuncio_estado")!=null) {
             q.setParameter("idAnuncioEstado", Integer.parseInt(filtros.get("filtro_id_anuncio_estado")));
        }
        if (filtros.get("filtro_cp")!=null) {
            q.setParameter("cp", filtros.get("filtro_cp"));
        }
        
        if (filtros.get("filtro_precio_desde")!=null) {
            q.setParameter("precio_desde", new BigDecimal(filtros.get("filtro_precio_desde")));
        }
        if (filtros.get("filtro_precio_hasta")!=null) {
            q.setParameter("precio_hasta", new BigDecimal(filtros.get("filtro_precio_hasta")));
        }
        
        if (filtros.get("filtro_txt")!=null) {
            q.setParameter("filtro_txt", "%"+filtros.get("filtro_txt").toUpperCase()+"%");
        }
        
		return q.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Anuncio> findLast(int num) {

        Query query = this.em.createQuery("from Anuncio as a where a.anunciosEstado.idAnuncioEstado = 1 order by a.fechaPublicacion desc", Anuncio.class);
	    query.setMaxResults(num);	
	    return query.getResultList();
	
	}

}
