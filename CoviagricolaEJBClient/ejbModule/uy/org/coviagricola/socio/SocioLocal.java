package uy.org.coviagricola.socio;

import java.util.List;

import javax.ejb.Local;

import uy.org.coviagricola.dto.SocioDTO;
import uy.org.coviagricola.exception.CoviagricolaException;

@Local
public interface SocioLocal {
	
	public void agregarSocio(SocioDTO socio) throws CoviagricolaException;
	
	public void actualizarSocio(SocioDTO socioDTO) throws CoviagricolaException;

	public List<SocioDTO> obtenerSocios();
	
	public SocioDTO obtenerSocioPorNumero(int nroSocio);
	

}
