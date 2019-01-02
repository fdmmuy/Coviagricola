package uy.org.coviagricola.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.beanutils.BeanUtils;

import uy.org.coviagricola.dto.SocioDTO;
import uy.org.coviagricola.dto.TipoAporteDTO;
import uy.org.coviagricola.entity.Socio;
import uy.org.coviagricola.entity.TipoAporte;

@Stateless
public class TipoAporteDAO {

	@PersistenceContext(unitName = "CoviagricolaJPA")
	protected EntityManager em;
	
	public List<TipoAporteDTO> obtenerTiposAportes(){
		
		List<TipoAporteDTO> listaTipoAporteDTO=new ArrayList<TipoAporteDTO>();

		TypedQuery<TipoAporte> q=em.createNamedQuery("TipoAporte.ObtenerTiposAportes",TipoAporte.class);
		List<TipoAporte> listaTipoAporteEntity=q.getResultList();
		
		for(TipoAporte tipoAporte:listaTipoAporteEntity) {
			TipoAporteDTO tipoAporteDTO= new TipoAporteDTO(); 
			try {
				BeanUtils.copyProperties(tipoAporteDTO, tipoAporte);
				listaTipoAporteDTO.add(tipoAporteDTO);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return listaTipoAporteDTO;
		
	}

	public void agregarTipoPorte(TipoAporteDTO tipoAporteDTO) {
		
		TipoAporte tipoAporteEntity=new TipoAporte();
		
		try {
			BeanUtils.copyProperties(tipoAporteEntity, tipoAporteDTO);
			em.persist(tipoAporteEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	

	public TipoAporte obtenerTipoAportePorId(long id) {
		TypedQuery<TipoAporte> q=em.createNamedQuery("TipoAporte.ObtenerTipoAportesPorId",TipoAporte.class);
		q.setParameter("id", id);
		return q.getSingleResult();
	}
}
