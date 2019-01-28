package uy.org.coviagricola.socio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import uy.org.coviagricola.dao.SocioDAO;
import uy.org.coviagricola.dto.SocioDTO;
import uy.org.coviagricola.entity.Socio;
import uy.org.coviagricola.exception.CoviagricolaException;
import uy.org.coviagricola.mail.Mail;

@Stateless
public class SocioEJB implements SocioLocal {
	
	@EJB
	SocioDAO socioDAO;

	@Override
	public void agregarSocio(SocioDTO socio) throws CoviagricolaException {
		
		/*Restricciones: nroSocio, ci, email UNIQUE
		 */
		if (socioDAO.existeSocioNroSocio(socio.getNroSocio()))
			throw new CoviagricolaException("Ya existe un socio con el numero de socio: "+socio.getNroSocio());
		if (socioDAO.existeSocioCi(socio.getCi()))
			throw new CoviagricolaException("Ya existe un socio con el numero de ci: "+socio.getCi());
		if (socioDAO.existeSocioEmail(socio.getEmail()))
			throw new CoviagricolaException("Ya existe un socio con el email: "+socio.getEmail());
		try {
			socioDAO.agregarSocio(socio);
		} catch (Exception e) {
			throw new CoviagricolaException("Ocurrio un error al intentar guardar al usuario. Contactar al administrador del sistema");
		}
		
		
	}

	@Override
	public List<SocioDTO> obtenerSocios() {

		return socioDAO.obtenerListaSocios();
	}

	@Override
	public SocioDTO obtenerSocioPorNumero(int nroSocio) {
		// TODO Auto-generated method stub
		return socioDAO.obtenerSocioPorNumero(nroSocio);
	}

	@Override
	public void actualizarSocio(SocioDTO socioDTO) throws CoviagricolaException{
		try {
			socioDAO.actualizarSocio(socioDTO);
		} catch (CoviagricolaException e) {
			throw new CoviagricolaException("Ocurrio un error al intentar guardar al usuario. Contactar al administrador del sistema");

		}
	}


	public void pruebaMail() {
		Mail m= new Mail();
		m.sendEmail("np-responde@gmail.com", "fdmmuy@hotmail.com", "Activar cuenta", "Activar cuenta ingreso aqui");
	}
}
