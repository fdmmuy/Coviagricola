package uy.org.coviagricola.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import uy.org.coviagricola.dto.AporteDTO;
import uy.org.coviagricola.dto.PagoDTO;
import uy.org.coviagricola.dto.SocioDTO;
import uy.org.coviagricola.entity.Aporte;
import uy.org.coviagricola.entity.Pago;
import uy.org.coviagricola.entity.Socio;
import uy.org.coviagricola.enumerated.EstadoAporte;
import uy.org.coviagricola.enumerated.EstadoPago;

@Stateless
public class AporteDAO {
	
	@PersistenceContext(unitName = "CoviagricolaJPA")
	protected EntityManager em;
	
	@EJB
	SocioDAO socioDAO; 
	
	@EJB
	TipoAporteDAO tipoAporteDAO;
	
	public void agregarAporte(SocioDTO socio,AporteDTO aporteDTO) {
		
		Socio s = socioDAO.obtenerSocioDTOPorMail(socio.getEmail());
		Aporte aporte = toEntity(aporteDTO);
		aporte.setEstado(EstadoAporte.PENDIENTE_PAGO);
		aporte.setTipoAporte(tipoAporteDAO.obtenerTipoAportePorId(aporteDTO.getTipoAporte().getId()));
		aporte.setSocio(s);
		em.persist(aporte);
	}
	
	public List<AporteDTO> obtenerAportesPorEmailSocio(String email){
		
		TypedQuery<Aporte> q= em.createNamedQuery("Aporte.ObtenerAportesPorEmailSocio", Aporte.class);
		q.setParameter("email", email);
		List<Aporte> listaAportes=q.getResultList();
		List<AporteDTO> listaAportesDTO=new ArrayList<AporteDTO>();
		for(Aporte a:listaAportes) {
			AporteDTO aporteDTO=toDTO(a);
			listaAportesDTO.add(aporteDTO);
		}
		return listaAportesDTO;
	}
	
	public Aporte toEntity(AporteDTO aporteDTO) {
		
		Aporte aporte= new Aporte();
		aporte.setFecha(aporteDTO.getFecha());
		aporte.setVencimiento(aporteDTO.getVencimiento());
		aporte.setMonto(aporteDTO.getMonto());
		return aporte;
		
	}
	
	public Pago toEntity(PagoDTO pago) {
		Pago pagoEntity= new Pago();
		pagoEntity.setId(pago.getId());
		pagoEntity.setFechaIngresado(pago.getFechaIngresado());
		pagoEntity.setMontoIngresado(pago.getMontoIngresado());
		pagoEntity.setMontoAprobado(pago.getMontoAprobado());
		pagoEntity.setEstado(pago.getEstado());
		pagoEntity.setObservaciones(pago.getObservaciones());
		return pagoEntity;

	}
	
	public AporteDTO obtenerAporteporId(long id) {
		TypedQuery<Aporte>q=em.createNamedQuery("Aporte.ObtenerAportePorId", Aporte.class);
		q.setParameter("id", id);
		Aporte aporteEntity=q.getSingleResult();
		return toDTO(aporteEntity);
	}

	public List<PagoDTO> obtenenerPagosPorAporte(AporteDTO aporteDTO){
		
		TypedQuery<Pago> q=em.createNamedQuery("Pago.ObtenerPagosPorIdAporte", Pago.class);
		q.setParameter("id", aporteDTO.getId());
		List<Pago> listaPagos=q.getResultList();
		List<PagoDTO> listaPagosDTO =new ArrayList<PagoDTO>();
		for(Pago pagoEntity:listaPagos) {
			PagoDTO pagoDTO=toDTO(pagoEntity);
			listaPagosDTO.add(pagoDTO);
		}
		return listaPagosDTO;
	}

	public PagoDTO toDTO(Pago pago) {
		PagoDTO pagoDTO= new PagoDTO();
		pagoDTO.setId(pago.getId());
		pagoDTO.setFechaIngresado(pago.getFechaIngresado());
		pagoDTO.setMontoIngresado(pago.getMontoIngresado());
		pagoDTO.setMontoAprobado(pago.getMontoAprobado());
		pagoDTO.setEstado(pago.getEstado());
		pagoDTO.setObservaciones(pago.getObservaciones());
		return pagoDTO;
	}
	
	public AporteDTO toDTO(Aporte aporte) {
		
		AporteDTO aporteDTO= new AporteDTO();
		aporteDTO.setId(aporte.getId());
		aporteDTO.setFecha(aporte.getFecha());
		aporteDTO.setVencimiento(aporte.getVencimiento());
		aporteDTO.setMonto(aporte.getMonto());
		aporteDTO.setEstado(aporte.getEstado());
		return aporteDTO;
		
	}

	public void ingresarPago(AporteDTO aporte, PagoDTO pago) {
		TypedQuery<Aporte>q=em.createNamedQuery("Aporte.ObtenerAportePorId", Aporte.class);
		q.setParameter("id", aporte.getId());
		Aporte aporteEntity=q.getSingleResult();
		Pago pagoEntity =toEntity(pago);
		pagoEntity.setAporte(aporteEntity);
		pagoEntity.setEstado(EstadoPago.PENDIENTE_APROBACION);
		em.persist(pagoEntity);
	
	}


	public List<PagoDTO> obtenerPagos(){
		TypedQuery<Pago> q=em.createNamedQuery("Pago.ObtenerPagos",Pago.class);
		List<Pago> listaPagos=q.getResultList();
		List<PagoDTO> listaPagosDTO=new ArrayList<PagoDTO>();
		for(Pago pagoEntity:listaPagos) {
			PagoDTO pagoDTO=toDTO(pagoEntity);
			pagoDTO.setAporte(toDTO(pagoEntity.getAporte()));
			pagoDTO.getAporte().setSocio(socioDAO.toDTO(pagoEntity.getAporte().getSocio()));
			listaPagosDTO.add(pagoDTO);
		}
		
		return listaPagosDTO;
	}
}
