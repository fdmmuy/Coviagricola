package uy.org.coviagricola.managedbean.socio;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import uy.org.coviagricola.dto.SocioDTO;
import uy.org.coviagricola.exception.CoviagricolaException;
import uy.org.coviagricola.socio.SocioLocal;

@ManagedBean
@ViewScoped
public class AgregarSocioMB {
	
	@EJB
	SocioLocal socioLocal;
	private SocioDTO socio;
	private String cibarra;
	
	
	

	@PostConstruct
	public void inicializarMB() {
		this.socio=new SocioDTO();
	}
	
	public void agregarSocio() {
		try {
			socioLocal.agregarSocio(socio);
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Socio "+socio.getNroSocio()+ " agregado correctamente",  null) );
	        socio=new SocioDTO();
	        cibarra="";
		} catch (CoviagricolaException e) {
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: "+e.getMessage(),  null) );
			
		}
	}
	
	
	public SocioDTO getSocio() {
		return socio;
	}

	public void setSocio(SocioDTO socio) {
		this.socio = socio;
	}

	public String getCibarra() {
		return cibarra;
	}

	public void setCibarra(String cibarra) {
		this.cibarra = cibarra;
		String[] partes = cibarra.split("-");
		if(partes.length==2) {
			try {
				socio.setCi(Integer.parseInt(partes[0]));
				socio.setBarraCi(Integer.parseInt(partes[1]));
			} catch (Exception e) {
		        FacesContext context = FacesContext.getCurrentInstance();
		        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: formato de ci incorrecti",null) );
			}
		}
		else {
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: formato de ci incorrecti",null) );

		}
	}
	
	
}
