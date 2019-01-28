package uy.org.coviagricola.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public class SocioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	
	private int nroSocio;
	private  int ci;
	private int barraCi;
	
	private Date fechaIngreso;
	private Date fechaEgreso;
	private boolean activo;
	private boolean jubilado;
	
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
		
	private String direccion;
	private String direccionNumero;
	private String apto;
	
	private int telefono;
	private String celular;
	private String email;
	
	private int cantDormitorios;
	
	@Column
	private boolean cuentaActiva;
	
	private boolean seleccionado;
	
	
	
	public SocioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getNroSocio() {
		return nroSocio;
	}


	public void setNroSocio(int nroSocio) {
		this.nroSocio = nroSocio;
	}


	public int getCi() {
		return ci;
	}


	public void setCi(int ci) {
		this.ci = ci;
	}


	public int getBarraCi() {
		return barraCi;
	}


	public void setBarraCi(int barraCi) {
		this.barraCi = barraCi;
	}


	public Date getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	public Date getFechaEgreso() {
		return fechaEgreso;
	}


	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}


	public boolean isJubilado() {
		return jubilado;
	}


	public void setJubilado(boolean jubilado) {
		this.jubilado = jubilado;
	}


	public String getPrimerNombre() {
		return primerNombre;
	}


	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}


	public String getSegundoNombre() {
		return segundoNombre;
	}


	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}


	public String getPrimerApellido() {
		return primerApellido;
	}


	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}


	public String getSegundoApellido() {
		return segundoApellido;
	}


	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getDireccionNumero() {
		return direccionNumero;
	}


	public void setDireccionNumero(String direccionNumero) {
		this.direccionNumero = direccionNumero;
	}


	public String getApto() {
		return apto;
	}


	public void setApto(String apto) {
		this.apto = apto;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getCantDormitorios() {
		return cantDormitorios;
	}


	public void setCantDormitorios(int cantDormitorios) {
		this.cantDormitorios = cantDormitorios;
	}


	public boolean isSeleccionado() {
		return seleccionado;
	}


	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}


	public boolean isCuentaActiva() {
		return cuentaActiva;
	}
	
	public boolean getCuentaActiva() {
		return cuentaActiva;
	}	


	public void setCuentaActiva(boolean cuentaActiva) {
		this.cuentaActiva = cuentaActiva;
	}
	
	
	

	
}
