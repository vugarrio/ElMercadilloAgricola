package es.ugarrio.elmercadilloagricola.repository.impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import es.ugarrio.elmercadilloagricola.dto.ProvinciaAnunciosDTO;
import es.ugarrio.elmercadilloagricola.form.AnuncioSearchForm;
import es.ugarrio.elmercadilloagricola.repository.custom.ProvinciaRepositoryCustom;

public class ProvinciaRepositoryImpl implements ProvinciaRepositoryCustom  {
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<ProvinciaAnunciosDTO> findProvinciasAnuncios(AnuncioSearchForm anuncioSearchForm) {
		
		String consulta = "select a.provincia.idProvincia, a.provincia.nombreProvincia, count(a.idAnuncio) from Anuncio as a where 1 = 1 ";
		
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
        
        consulta += " group by a.provincia.idProvincia, a.provincia.nombreProvincia  ";
        
        consulta += " order by a.provincia.nombreProvincia ";
        
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
        
        List<ProvinciaAnunciosDTO> resultProvinciaAnunciosDTO = new ArrayList<ProvinciaAnunciosDTO>();
        
        for (Object[] registro: (List<Object[]>)q.getResultList()) {
        	resultProvinciaAnunciosDTO.add(new ProvinciaAnunciosDTO(Integer.parseInt(registro[0].toString()), registro[1].toString(), Integer.parseInt(registro[2].toString())));
        }
        
       return resultProvinciaAnunciosDTO;
	}

}
