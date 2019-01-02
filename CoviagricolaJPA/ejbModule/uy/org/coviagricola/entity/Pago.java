package uy.org.coviagricola.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import uy.org.coviagricola.enumerated.EstadoPago;

/**
 * Entity implementation class for Entity: Pago
 *
 */
@Entity(name="Pagos")
@NamedQueries({
	@NamedQuery(name="Pago.ObtenerPagos",query="select p from Pagos p"),
	@NamedQuery(name="Pago.ObtenerPagosPorIdAporte",query="select p from Pagos p where p.aporte.id=:id"),
})
public class Pago implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column
	private Integer montoIngresado;
	@Column
	private Integer montoAprobado;
	@Column
	private Date fechaIngresado;
	@Column
	private EstadoPago estado;
	@Column
	private String observaciones;
	
	
	@ManyToOne
    @JoinColumn(name = "aporte_id")
	Aporte aporte;
	

	public Pago() {
		super();
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

	public Aporte getAporte() {
		return aporte;
	}

	public void setAporte(Aporte aporte) {
		this.aporte = aporte;
	}
	
	
   
}
