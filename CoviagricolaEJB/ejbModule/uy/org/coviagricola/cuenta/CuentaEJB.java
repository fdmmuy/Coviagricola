package uy.org.coviagricola.cuenta;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import uy.org.coviagricola.dao.SocioDAO;
import uy.org.coviagricola.dto.SocioDTO;

@Stateless
public class CuentaEJB implements CuentaLocal {

	@EJB
	private SocioDAO socioDAO;
	
	@Override
	public SocioDTO obtenerUsuarioPorToken(String token) {

		return socioDAO.obtenerSocioPorToken(token);
	}

}
