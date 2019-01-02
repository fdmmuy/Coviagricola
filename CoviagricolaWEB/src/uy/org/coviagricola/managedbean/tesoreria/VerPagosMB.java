package uy.org.coviagricola.managedbean.tesoreria;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import uy.org.coviagricola.aporte.AporteLocal;
import uy.org.coviagricola.dto.PagoDTO;

@ManagedBean
@ViewScoped
public class VerPagosMB {
	
	@EJB
	AporteLocal aporteEJB;
	
	private List<PagoDTO> listaPagos;
	
	
	@PostConstruct
	public void init() {
		listaPagos=aporteEJB.obtenerPagos();
	}


	public List<PagoDTO> getListaPagos() {
		return listaPagos;
	}


	public void setListaPagos(List<PagoDTO> listaPagos) {
		this.listaPagos = listaPagos;
	}
	
	
}
