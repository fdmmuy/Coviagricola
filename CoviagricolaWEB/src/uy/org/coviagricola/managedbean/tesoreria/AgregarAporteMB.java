package uy.org.coviagricola.managedbean.tesoreria;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import uy.org.coviagricola.aporte.AporteLocal;
import uy.org.coviagricola.dto.AporteDTO;
import uy.org.coviagricola.dto.SocioDTO;
import uy.org.coviagricola.dto.TipoAporteDTO;
import uy.org.coviagricola.socio.SocioLocal;

@ManagedBean
@ViewScoped
public class AgregarAporteMB {
	
	@EJB
	SocioLocal socioEJB;
	
	@EJB
	AporteLocal aporteEJB;
	
	private List<SocioDTO> listaSocios;
	private List<SocioDTO> listaSociosFiltrada;
	
	private List<TipoAporteDTO> listaTipoAporte;
	private AporteDTO aporte;
	private boolean seleccionarTodo;
	
	@PostConstruct
	public void init() {
		listaSocios=socioEJB.obtenerSocios();
		listaTipoAporte=aporteEJB.obtenerTiposAportes();
		aporte=new AporteDTO();
		aporte.setTipoAporte( new TipoAporteDTO() );
	}
	
	public void seleccionar() {
		if((this.listaSociosFiltrada==null) || this.listaSociosFiltrada.isEmpty()) {
			for(SocioDTO s:this.listaSocios) {
				s.setSeleccionado(seleccionarTodo);
			}
		}
		else {
			for(SocioDTO s:this.listaSociosFiltrada) {
				s.setSeleccionado(seleccionarTodo);
			}
		}
	}
	
	public void agregarAporte() {
		
		List<SocioDTO> listaSociosVista=new ArrayList<SocioDTO>();
		List<SocioDTO> listaSociosAgregarAporte=new ArrayList<SocioDTO>();
		
		
		
		if((this.listaSociosFiltrada==null) || this.listaSociosFiltrada.isEmpty()) 
			listaSociosVista=listaSocios;
		else
			listaSociosVista=listaSociosFiltrada;
		for(SocioDTO socioAporte : listaSociosVista) {
			if(socioAporte.isSeleccionado())
				listaSociosAgregarAporte.add(socioAporte);
		}
		aporteEJB.agregarAporteListaSocios(aporte, listaSociosAgregarAporte);
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

	public boolean getSeleccionarTodo() {
		return seleccionarTodo;
	}

	public void setSeleccionarTodo(boolean seleccionarTodo) {
		this.seleccionarTodo = seleccionarTodo;
	}
	
	

	public List<TipoAporteDTO> getListaTipoAporte() {
		return listaTipoAporte;
	}

	public void setListaTipoAporte(List<TipoAporteDTO> listaTipoAporte) {
		this.listaTipoAporte = listaTipoAporte;
	}

	public AporteDTO getAporte() {
		return aporte;
	}

	public void setAporte(AporteDTO aporte) {
		this.aporte = aporte;
	}


	
}