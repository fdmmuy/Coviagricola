package uy.org.coviagricola.managedbean.tesoreria;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import uy.org.coviagricola.aporte.TipoAporteLocal;
import uy.org.coviagricola.dto.TipoAporteDTO;

@ManagedBean
@ViewScoped
public class TipoAporteMB {
	
	@EJB
	TipoAporteLocal tipoAporteEJB;
	
	private List<TipoAporteDTO> listaTipoAportes;
	
	private TipoAporteDTO tipoAporteNuevo;
	
	@PostConstruct
	public void init() {
		listaTipoAportes= tipoAporteEJB.obtenerTiposAportes();
		tipoAporteNuevo=new  TipoAporteDTO();
	}
	
	
	public void agregar() {
		
		tipoAporteEJB.agregarTipoAporte(tipoAporteNuevo);
        FacesContext context = FacesContext.getCurrentInstance();
		listaTipoAportes= tipoAporteEJB.obtenerTiposAportes();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Correxto",  null) );
        PrimeFaces.current().ajax().addCallbackParam("agregarOk", true);
	}

	public List<TipoAporteDTO> getListaTipoAportes() {
		return listaTipoAportes;
	}

	public void setListaTipoAportes(List<TipoAporteDTO> listaTipoAportes) {
		this.listaTipoAportes = listaTipoAportes;
	}


	public TipoAporteDTO getTipoAporteNuevo() {
		return tipoAporteNuevo;
	}


	public void setTipoAporteNuevo(TipoAporteDTO tipoAporteNuevo) {
		this.tipoAporteNuevo = tipoAporteNuevo;
	}
	

}
