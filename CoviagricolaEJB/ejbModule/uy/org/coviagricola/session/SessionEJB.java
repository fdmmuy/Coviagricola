package uy.org.coviagricola.session;




import javax.ejb.EJB;
import javax.ejb.Stateless;
import uy.org.coviagricola.dao.SocioDAO;
import uy.org.coviagricola.dto.SocioDTO;
import uy.org.coviagricola.entity.Socio;

@Stateless
public class SessionEJB implements SessionLocal{
	
	@EJB
	SocioDAO socioDAO;

	@Override
	public SocioDTO getSocioPorEmail(String email) {

		Socio socio=socioDAO.obtenerSocioDTOPorMail(email);
		if(socio==null)
			return null;
		return socioDAO.toDTO(socio);
	}


}
