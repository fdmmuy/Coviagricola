package uy.org.coviagricola.cuenta;

import javax.ejb.Local;

import uy.org.coviagricola.dto.SocioDTO;

@Local
public interface CuentaLocal {
	
	public SocioDTO obtenerUsuarioPorToken(String token);
	
	public void activarCuenta(String mail,String pass);

}
