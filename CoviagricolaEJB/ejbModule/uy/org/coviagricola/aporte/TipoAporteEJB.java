package uy.org.coviagricola.aporte;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import uy.org.coviagricola.aporte.TipoAporteLocal;
import uy.org.coviagricola.dao.TipoAporteDAO;
import uy.org.coviagricola.dto.TipoAporteDTO;

@Stateless
public class TipoAporteEJB implements TipoAporteLocal{

	
	@EJB
	TipoAporteDAO tipoAporteDAO;
	
	@Override
	public List<TipoAporteDTO> obtenerTiposAportes() {
				
		return tipoAporteDAO.obtenerTiposAportes();

		
	}

	@Override
	public void agregarTipoAporte(TipoAporteDTO tipoAporte) {
		tipoAporteDAO.agregarTipoPorte(tipoAporte);
	}

	@Override
	public TipoAporteDTO obtenerTipoAportePorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
