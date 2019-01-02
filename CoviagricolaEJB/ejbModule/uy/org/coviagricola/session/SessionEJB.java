package uy.org.coviagricola.session;



import java.lang.reflect.InvocationTargetException;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.commons.beanutils.BeanUtils;

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
		SocioDTO socioDTO= new SocioDTO();
		try {
			BeanUtils.copyProperties(socioDTO, socio);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return socioDTO;
	}


}
