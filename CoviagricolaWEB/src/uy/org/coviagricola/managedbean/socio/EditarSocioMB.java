package uy.org.coviagricola.managedbean.socio;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import uy.org.coviagricola.dto.SocioDTO;
import uy.org.coviagricola.exception.CoviagricolaException;
import uy.org.coviagricola.socio.SocioLocal;

@ManagedBean
@ViewScoped
public class EditarSocioMB {
	
	@EJB
	SocioLocal socioEJB;
	
	private SocioDTO socio;

	@PostConstruct
	public void init() {
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		Integer nroSocio =Integer.valueOf(params.get("socio"));
		socio=socioEJB.obtenerSocioPorNumero(nroSocio);
	}
	
	public void actualizarDatosSocio() {
		try {
			socioEJB.actualizarSocio(socio);
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Socio actualizado",  null) );

		} catch (CoviagricolaException e) {
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al intenrar actualizar el socio",  null) );
		}
	}

	public SocioDTO getSocio() {
		return socio;
	}

	public void setSocio(SocioDTO socio) {
		this.socio = socio;
	}

}
