package uy.org.coviagricola.dao;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.beanutils.BeanUtils;

import uy.org.coviagricola.dto.SocioDTO;
import uy.org.coviagricola.entity.Socio;
import uy.org.coviagricola.exception.CoviagricolaException;

@Stateless
public class SocioDAO {
	
	@PersistenceContext(unitName = "CoviagricolaJPA")
	protected EntityManager em;
	
	
	public void agregarSocio(SocioDTO socio) throws CoviagricolaException{

		/*Restricciones: nroSocio, ci, email UNIQUE
		 */
		if (existeSocioNroSocio(socio.getNroSocio()))
			throw new CoviagricolaException("Ya existe un socio con el numero "+socio.getNroSocio());
		
		if (existeSocioCi(socio.getCi()))
			throw new CoviagricolaException("Ya existe un socio con ci "+socio.getCi());
		if (existeSocioEmail(socio.getEmail()))
			throw new CoviagricolaException("Ya existe un socio con email "+socio.getEmail());

		
		Socio socioEntity=new Socio();
		dtoToEntity(socio,socioEntity);
		try {
			em.persist(socioEntity);
		} catch (Exception e) {
			throw new CoviagricolaException("Error al intentar guardar en la base de datos");
		}
		
		
		
	}
	
	public List<SocioDTO> obtenerListaSocios(){
		List<SocioDTO> listaDTO=new ArrayList<SocioDTO>();

		TypedQuery<Socio> q=em.createNamedQuery("Socio.ObtenerSocios",Socio.class);
		List<Socio> listaSocios=q.getResultList();
		
		for(Socio socio:listaSocios) {
			SocioDTO socioDTO= toDTO(socio);
			listaDTO.add(socioDTO);
		}
		return listaDTO;
	}
	
	public void actualizarSocio(SocioDTO socioDTO) throws CoviagricolaException {
		Socio socioEntity=obtenerSocioDTOPorMail(socioDTO.getEmail());
		dtoToEntity(socioDTO, socioEntity);
		try {
			em.persist(socioEntity);
		} catch (Exception e) {
			throw new CoviagricolaException("Error al intentar guardar en la base de datos");
		}
	
	}
	
	public boolean existeSocioNroSocio(int nroSocio) {
		
		TypedQuery<Socio> q=em.createNamedQuery("Socio.ObtenerSocioNroSocio",Socio.class);
		q.setParameter("nroSocio", nroSocio);
		List<Socio> listaSocios=q.getResultList();
		
		return !listaSocios.isEmpty();
	}
	
	public boolean existeSocioCi(int ci) {
		
		TypedQuery<Socio> q=em.createNamedQuery("Socio.ObtenerSocioCi",Socio.class);
		q.setParameter("ci", ci);
		List<Socio> listaSocios=q.getResultList();
		
		return !listaSocios.isEmpty();
	}

	public boolean existeSocioEmail(String email) {
		
		TypedQuery<Socio> q=em.createNamedQuery("Socio.ObtenerSocioEmail",Socio.class);
		q.setParameter("email", email);
		List<Socio> listaSocios=q.getResultList();
		
		return !listaSocios.isEmpty();
		
	}
	
	public Socio obtenerSocioDTOPorMail(String email) {
		TypedQuery<Socio> q=em.createNamedQuery("Socio.ObtenerSocioEmail",Socio.class);
		q.setParameter("email", email);
		try {
			Socio socioEntity=q.getSingleResult();
			return socioEntity;

		} catch (Exception e) {
			return null;
		}
	}

	public SocioDTO obtenerSocioPorNumero(int nroSocio) {
		TypedQuery<Socio> q=em.createNamedQuery("Socio.ObtenerSocioNroSocio",Socio.class);
		q.setParameter("nroSocio", nroSocio);
		Socio socioEntity=q.getSingleResult();
		SocioDTO socioDTO=new SocioDTO();
		try {
			BeanUtils.copyProperties(socioDTO, socioEntity);
			return socioDTO;
		} catch (IllegalAccessException e) {
			return null;
		} catch (InvocationTargetException e) {
			return null;
		}

	}

	public SocioDTO toDTO(Socio socioEntity) {
		
		SocioDTO socio= new SocioDTO();
		socio.setId(socioEntity.getId());
		socio.setNroSocio(socioEntity.getNroSocio());
		socio.setCi(socioEntity.getCi());
		socio.setBarraCi(socioEntity.getBarraCi());
		socio.setFechaIngreso(socioEntity.getFechaIngreso());
		socio.setFechaEgreso(socioEntity.getFechaEgreso());
		socio.setJubilado(socioEntity.isJubilado());
		socio.setActivo(socioEntity.isActivo());
		socio.setPrimerNombre(socioEntity.getPrimerNombre());
		socio.setSegundoNombre(socioEntity.getSegundoNombre());
		socio.setPrimerApellido(socioEntity.getPrimerApellido());
		socio.setSegundoApellido(socioEntity.getSegundoApellido());
		socio.setCantDormitorios(socioEntity.getCantDormitorios());
		socio.setTelefono(socioEntity.getTelefono());
		socio.setCelular(socioEntity.getCelular());
		socio.setEmail(socioEntity.getEmail());
		socio.setDireccion(socioEntity.getDireccion());
		socio.setDireccionNumero(socioEntity.getDireccionNumero());
		socio.setApto(socioEntity.getApto());
		return socio;
	}
	
	public void dtoToEntity(SocioDTO socioDTO, Socio socio) {

		socio.setId(socioDTO.getId());
		socio.setNroSocio(socioDTO.getNroSocio());
		socio.setCi(socioDTO.getCi());
		socio.setBarraCi(socioDTO.getBarraCi());
		socio.setFechaIngreso(socioDTO.getFechaIngreso());
		socio.setFechaEgreso(socioDTO.getFechaEgreso());
		socio.setJubilado(socioDTO.isJubilado());
		socio.setActivo(socioDTO.isActivo());
		socio.setPrimerNombre(socioDTO.getPrimerNombre());
		socio.setSegundoNombre(socioDTO.getSegundoNombre());
		socio.setPrimerApellido(socioDTO.getPrimerApellido());
		socio.setSegundoApellido(socioDTO.getSegundoApellido());
		socio.setCantDormitorios(socioDTO.getCantDormitorios());
		socio.setTelefono(socioDTO.getTelefono());
		socio.setCelular(socioDTO.getCelular());
		socio.setEmail(socioDTO.getEmail());
		socio.setDireccion(socioDTO.getDireccion());
		socio.setDireccionNumero(socioDTO.getDireccionNumero());
		socio.setApto(socioDTO.getApto());

	}
}