package uy.org.coviagricola.aporte;

import java.util.List;

import javax.ejb.Local;

import uy.org.coviagricola.dto.AporteDTO;
import uy.org.coviagricola.dto.PagoDTO;
import uy.org.coviagricola.dto.SocioDTO;
import uy.org.coviagricola.dto.TipoAporteDTO;

@Local
public interface AporteLocal {
	
	public void agregarAporteSocio(AporteDTO aporte, SocioDTO socio);
	
	public void agregarAporteListaSocios(AporteDTO aporte, List<SocioDTO> socio);
	
	public AporteDTO obtenerAportePorId(long id);
	
	public List<PagoDTO> obtenenerPagosPorAporte(AporteDTO aporteDTO);
	
	public List<AporteDTO> obtenerAportesPorEmailSocio(String email);
	
	public List<TipoAporteDTO> obtenerTiposAportes();
	
	public void agregarTipoAporte(TipoAporteDTO tipoAporte);
	
	public TipoAporteDTO obtenerTipoAportePorId(long id);
	
	public void ingresarPago(AporteDTO aporte, PagoDTO pago);
	
	public List<PagoDTO> obtenerPagos();
	
	public AporteDTO obtenerAportePorPago(PagoDTO pago);
	

}
