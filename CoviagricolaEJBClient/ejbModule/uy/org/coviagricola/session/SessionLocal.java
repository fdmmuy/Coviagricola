package uy.org.coviagricola.session;

import uy.org.coviagricola.dto.SocioDTO;

public interface SessionLocal {
	
	public SocioDTO getSocioPorEmail(String email);

}
