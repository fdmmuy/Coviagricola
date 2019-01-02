package uy.org.coviagricola.managedbean.usuario;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


import uy.org.coviagricola.aporte.AporteLocal;
import uy.org.coviagricola.dto.AporteDTO;
import uy.org.coviagricola.dto.PagoDTO;

@ManagedBean
@ViewScoped
public class AgregarPagoMB {
	
	@EJB
	AporteLocal aporteEJB;
	
	private AporteDTO aporte;
	
	private PagoDTO pago;

	private List<PagoDTO> listaPagos;

	
	@PostConstruct
	public void init() {
		long id = Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("aporte"));
		aporte=aporteEJB.obtenerAportePorId(id);
		pago=new PagoDTO();
		listaPagos=aporteEJB.obtenenerPagosPorAporte(aporte);
	}
	
	public void agregarPago() {
		pago.setFechaIngresado(new Date());
		aporteEJB.ingresarPago(aporte,pago);
		listaPagos=aporteEJB.obtenenerPagosPorAporte(aporte);

	}

	public AporteDTO getAporte() {
		return aporte;
	}

	public void setAporte(AporteDTO aporte) {
		this.aporte = aporte;
	}

	public PagoDTO getPago() {
		return pago;
	}

	public void setPago(PagoDTO pago) {
		this.pago = pago;
	}

	public List<PagoDTO> getListaPagos() {
		return listaPagos;
	}

	public void setListaPagos(List<PagoDTO> listaPagos) {
		this.listaPagos = listaPagos;
	}
	
	
	
	
	
	
}
