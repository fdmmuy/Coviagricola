package uy.org.coviagricola.managedbean.socio;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import uy.org.coviagricola.dto.SocioDTO;
import uy.org.coviagricola.socio.SocioLocal;

@ManagedBean
@ViewScoped
public class ListaSociosMB {
	
	@EJB
	SocioLocal socioEJB;
	
	private List<SocioDTO> listaSocios;
	private List<SocioDTO> listaSociosFiltrada;

	@PostConstruct
	public void init() {
		listaSocios=socioEJB.obtenerSocios();
		System.out.println("Obtuve lista de socios");
	}
	
	public List<SocioDTO> getListaSocios() {
		return listaSocios;
	}

	public void setListaSocios(List<SocioDTO> listaSocios) {
		this.listaSocios = listaSocios;
	}

	public List<SocioDTO> getListaSociosFiltrada() {
		return listaSociosFiltrada;
	}

	public void setListaSociosFiltrada(List<SocioDTO> listaSociosFiltrada) {
		this.listaSociosFiltrada = listaSociosFiltrada;
	}
	
	
}
