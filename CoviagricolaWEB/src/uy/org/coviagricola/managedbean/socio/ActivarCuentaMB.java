package uy.org.coviagricola.managedbean.socio;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import uy.org.coviagricola.cuenta.CuentaLocal;
import uy.org.coviagricola.dto.SocioDTO;

@ManagedBean
@ViewScoped
public class ActivarCuentaMB {
	
	@EJB
	CuentaLocal cuenta;
	
	private String token;
	private SocioDTO socio;
	
	@PostConstruct
	public void init() {
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String token=params.get("token");
		socio=cuenta.obtenerUsuarioPorToken(token);
		System.out.println("Se obtuvo el usuario:"+socio.getEmail());
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public SocioDTO getSocio() {
		return socio;
	}

	public void setSocio(SocioDTO socio) {
		this.socio = socio;
	}
	
	

	

}
