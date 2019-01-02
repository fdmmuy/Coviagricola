package uy.org.coviagricola.dto;

import java.io.Serializable;
import java.util.Date;

import uy.org.coviagricola.enumerated.EstadoPago;

public class PagoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private long id;
	
	private Integer montoIngresado;
	
	private Integer montoAprobado;
	
	private Date fechaIngresado;
	
	private EstadoPago estado;
	
	private String observaciones;
	
	private AporteDTO aporte;

	public PagoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getMontoIngresado() {
		return montoIngresado;
	}

	public void setMontoIngresado(Integer montoIngresado) {
		this.montoIngresado = montoIngresado;
	}

	public Integer getMontoAprobado() {
		return montoAprobado;
	}

	public void setMontoAprobado(Integer montoAprobado) {
		this.montoAprobado = montoAprobado;
	}

	public Date getFechaIngresado() {
		return fechaIngresado;
	}

	public void setFechaIngresado(Date fechaIngresado) {
		this.fechaIngresado = fechaIngresado;
	}

	public EstadoPago getEstado() {
		return estado;
	}

	public void setEstado(EstadoPago estado) {
		this.estado = estado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public AporteDTO getAporte() {
		return aporte;
	}

	public void setAporte(AporteDTO aporte) {
		this.aporte = aporte;
	}
	
	

}
