package uy.org.coviagricola.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import uy.org.coviagricola.dto.SocioDTO;

/**
 * Entity implementation class for Entity: Socio
 *
 */
@Entity(name="Socios")
@NamedQueries({
	@NamedQuery(name="Socio.ObtenerSocioNroSocio",query="select s from Socios s where s.nroSocio=:nroSocio"),
	@NamedQuery(name="Socio.ObtenerSocioEmail",query="select s from Socios s where s.email=:email"),
	@NamedQuery(name="Socio.ObtenerSocioCi",query="select s from Socios s where s.ci=:ci"),
	@NamedQuery(name="Socio.ObtenerSocios",query="select s from Socios s"),


})
public class Socio implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(unique=true)
	private int nroSocio;
	
	@Column(unique=true)
	private  int ci;
	
	@Column
	private int barraCi;
	
	@Column
	private Date fechaIngreso;
	
	@Column
	private Date fechaEgreso;
	
	@Column
	private boolean activo;
	@Column
	private boolean jubilado;
	
	@Column
	private String primerNombre;
	@Column
	private String segundoNombre;
	@Column
	private String primerApellido;
	@Column
	private String segundoApellido;
	
	private int cantDormitorios;
	
	@Column
	private int telefono;
	@Column
	private String celular;
	@Column(unique=true)
	private String email;
	
	@Column
	private String direccion;
	@Column
	private String direccionNumero;
	@Column
	private String apto;
	
	@Column
	private boolean cuentaActiva;
	
	
	@OneToMany(  mappedBy = "socio", cascade = CascadeType.ALL,orphanRemoval = true)
	List<Aporte> aportes;
	
	
	public Socio() {
		super();
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

	public int getCantDormitorios() {
		return cantDormitorios;
	}

	public void setCantDormitorios(int cantDormitorios) {
		this.cantDormitorios = cantDormitorios;
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

	public boolean isCuentaActiva() {
		return cuentaActiva;
	}

	public void setCuentaActiva(boolean cuentaActiva) {
		this.cuentaActiva = cuentaActiva;
	}

	public List<Aporte> getAportes() {
		return aportes;
	}

	public void setAportes(List<Aporte> aportes) {
		this.aportes = aportes;
	}
	
	
   
}
