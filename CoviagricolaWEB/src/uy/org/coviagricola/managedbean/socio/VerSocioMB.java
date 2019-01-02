package uy.org.coviagricola.managedbean.socio;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import uy.org.coviagricola.dto.SocioDTO;
import uy.org.coviagricola.socio.SocioLocal;

@ManagedBean
@ViewScoped
public class VerSocioMB {
	
	@EJB
	SocioLocal socioEJB;
	
	private SocioDTO socio;
	
	
	@PostConstruct
	public void init() {
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		Integer nroSocio =Integer.valueOf(params.get("socio"));
		socio=socioEJB.obtenerSocioPorNumero(nroSocio);
	}


	public SocioDTO getSocio() {
		return socio;
	}


	public void setSocio(SocioDTO socio) {
		this.socio = socio;
	}



	
	

}
