package uy.org.coviagricola.aporte;

import java.util.List;

import javax.ejb.Local;

import uy.org.coviagricola.dto.TipoAporteDTO;

@Local
public interface TipoAporteLocal {
	
	public List<TipoAporteDTO> obtenerTiposAportes();
	
	public void agregarTipoAporte(TipoAporteDTO tipoAporte);
	
	public TipoAporteDTO obtenerTipoAportePorId(long id);
	
	

}
