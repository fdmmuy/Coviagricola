package uy.org.coviagricola.managedbean.socio;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
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
	private String password;
	private String repetirPassword;
	private SocioDTO socio;
	
	@PostConstruct
	public void init() {
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String token=params.get("token");
		socio=cuenta.obtenerUsuarioPorToken(token);
	}

	public void activarCuenta() {
		if(password.equals(repetirPassword)) {
			cuenta.activarCuenta(socio.getEmail(), password);
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Su usuario se a activado correctamente",  null) );

		}
		else {
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Las claves ingresadas son diferentes",  null) );

		}
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepetirPassword() {
		return repetirPassword;
	}

	public void setRepetirPassword(String repetirPassword) {
		this.repetirPassword = repetirPassword;
	}
	
	

	

}
