package es.ugarrio.elmercadilloagricola.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
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
	
	
	@Override
	public List<CategoriaAnunciosDTO> findCategoriasAnuncios(AnuncioSearchForm anuncioSearchForm) {
		
		
		String consulta;
        String consulta_ini;
                 
        if (!StringUtils.isEmpty(anuncioSearchForm.getFiltroIdCategoria())) {
            
            int esUltimoNivel = 0;
            
            //Obtener si una categoria de ultimo nivel
            consulta_ini= "from Categorias c where c.idCategoria = :idCategoria ";
           
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
               
                consulta = "select count(a.idAnuncio), a.categorias.idCategoria, a.categorias.nombreCategoria from Anuncios as a where  a.categorias.idCategoria = " + anuncioSearchForm.getFiltroIdCategoria() + " ";
            } else {
//                 Equivale:
//                    select COUNT(ANUNCIOS.ID_ANUNCIO) as num_anuncio, C2.ID_CATEGORIA, C2.NOMBRE_CATEGORIA 
//                           from CATEGORIAS c1 
//                                INNER JOIN CATEGORIAS c2 on C1.ID_CATEGORIA = C2.ID_CATEGORIA_PADRE
//                                                                    INNER JOIN ANUNCIOS ON C2.ID_CATEGORIA = ANUNCIOS.CATEGORIA_ID
//                    where C1.ID_CATEGORIA = 1
//                    group BY C2.ID_CATEGORIA, C2.NOMBRE_CATEGORIA    ; 
               
               consulta = "select count(a.idAnuncio), a.categorias.idCategoria, a.categorias.nombreCategoria from Anuncios as a where  a.categorias.categorias.idCategoria = " + anuncioSearchForm.getFiltroIdCategoria() + " ";
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
            consulta = "select count(a.idAnuncio), a.categorias.categorias.idCategoria, a.categorias.categorias.nombreCategoria from Anuncios as a where 1 = 1 ";
        }
        
        
        /* **************
        if (filtros.get("filtro_id_anuncio")!=null) {
            consulta += " and a.idAnuncio = :idAnuncio ";
        }        
        if (filtros.get("filtro_id_usuario")!=null) {
            consulta += " and a.usuarios.idUsuario = :idUsuario ";
        }        
       
        if (filtros.get("filtro_id_provincia")!=null) {
            consulta += " and a.provincias.idProvincia = :idProvincia " ;
        }
        if (filtros.get("filtro_id_anuncio_estado")!=null) {
            consulta += " and a.anunciosEstados.idAnuncioEstado = :idAnuncioEstado " ;
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
        
         if (anuncioSearchForm.getFiltroIdCategoria()!=null) {
             consulta += " group by a.categorias.idCategoria, a.categorias.nombreCategoria  ";        
             consulta += " order by a.categorias.nombreCategoria ";
         } else {
             consulta += " group by a.categorias.categorias.idCategoria, a.categorias.categorias.nombreCategoria  ";        
             consulta += " order by a.categorias.categorias.nombreCategoria ";
         }
        
        
        Query q = this.sesion.createQuery(consulta);
        
        if (filtros.get("filtro_id_anuncio")!=null) {
            q.setParameter("idAnuncio", Integer.parseInt(filtros.get("filtro_id_anuncio")));
        }        
        if (filtros.get("filtro_id_usuario")!=null) {
             q.setParameter("idUsuario", Integer.parseInt(filtros.get("filtro_id_usuario")));
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
        if (filtros.get("filtro_txt")!=null) {
            q.setParameter("filtro_txt", "%"+filtros.get("filtro_txt").toUpperCase()+"%");
        }
        
        if (filtros.get("filtro_precio_desde")!=null) {
            q.setParameter("precio_desde", new BigDecimal(filtros.get("filtro_precio_desde")));
        }
        if (filtros.get("filtro_precio_hasta")!=null) {
            q.setParameter("precio_hasta", new BigDecimal(filtros.get("filtro_precio_hasta")));
        }
		
		**************** */
		return null;
	}
	
}
