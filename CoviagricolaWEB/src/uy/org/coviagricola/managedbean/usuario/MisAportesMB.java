package uy.org.coviagricola.managedbean.usuario;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import uy.org.coviagricola.aporte.AporteLocal;
import uy.org.coviagricola.dto.AporteDTO;

@ManagedBean
@ViewScoped
public class MisAportesMB {
	
	@EJB
	AporteLocal aporteEJB;
	
	
	private List<AporteDTO> listaAportes;
	private List<AporteDTO> listaAportesFiltrada;
	
	
	
	@PostConstruct
	public void init() {
		Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        String email= principal.getName();
        listaAportes=aporteEJB.obtenerAportesPorEmailSocio(email);
	}

	public String ingresarPago() {
		System.out.println("Redirigiendo a ingresar pago......");
		return "/Coviagricola/paginas/usuario/agregarPago.xhtml?faces-redirect=true";
	}


	public List<AporteDTO> getListaAportes() {
		return listaAportes;
	}



	public void setListaAportes(List<AporteDTO> listaAportes) {
		this.listaAportes = listaAportes;
	}



	public List<AporteDTO> getListaAportesFiltrada() {
		return listaAportesFiltrada;
	}



	public void setListaAportesFiltrada(List<AporteDTO> listaAportesFiltrada) {
		this.listaAportesFiltrada = listaAportesFiltrada;
	}

	
	
	
}
