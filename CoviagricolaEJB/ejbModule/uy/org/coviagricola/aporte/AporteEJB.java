package uy.org.coviagricola.aporte;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import uy.org.coviagricola.dao.AporteDAO;
import uy.org.coviagricola.dao.TipoAporteDAO;
import uy.org.coviagricola.dto.AporteDTO;
import uy.org.coviagricola.dto.PagoDTO;
import uy.org.coviagricola.dto.SocioDTO;
import uy.org.coviagricola.dto.TipoAporteDTO;

@Stateless
public class AporteEJB implements AporteLocal {

	@EJB
	TipoAporteDAO tipoAporteDAO;
	
	@EJB
	AporteDAO aporteDAO;
	
	@Override
	public void agregarAporteSocio(AporteDTO aporte, SocioDTO socio) {
		aporteDAO.agregarAporte(socio, aporte);
	}

	@Override
	public void agregarAporteListaSocios(AporteDTO aporte, List<SocioDTO> socios) {
		for(SocioDTO socio:socios) {
			this.agregarAporteSocio(aporte, socio);
		}

	}

	@Override
	public List<TipoAporteDTO> obtenerTiposAportes() {
		return tipoAporteDAO.obtenerTiposAportes();

	}

	@Override
	public void agregarTipoAporte(TipoAporteDTO tipoAporte) {
		// TODO Auto-generated method stub

	}

	@Override
	public TipoAporteDTO obtenerTipoAportePorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AporteDTO> obtenerAportesPorEmailSocio(String email) {
		return aporteDAO.obtenerAportesPorEmailSocio(email);
	}

	@Override
	public AporteDTO obtenerAportePorId(long id) {
		return aporteDAO.obtenerAporteporId(id);
	}

	@Override
	public List<PagoDTO> obtenenerPagosPorAporte(AporteDTO aporteDTO) {
		
		return aporteDAO.obtenenerPagosPorAporte(aporteDTO);
	}
	
	public void ingresarPago(AporteDTO aporte, PagoDTO pago) {
		
		aporteDAO.ingresarPago(aporte, pago);
	}

	@Override
	public List<PagoDTO> obtenerPagos() {
		List<PagoDTO> listaPagos=aporteDAO.obtenerPagos();
		return listaPagos;
	}

	@Override
	public AporteDTO obtenerAportePorPago(PagoDTO pago) {
		// TODO Auto-generated method stub
		return null;
	}

}
