package uy.org.coviagricola.dto;

import java.io.Serializable;
import java.util.Date;

import uy.org.coviagricola.enumerated.EstadoAporte;


public class AporteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;

	private Date fecha;
	
	private Date vencimiento;
	
	private int monto;
	
	private TipoAporteDTO tipoAporte;
	
	private SocioDTO socio;
	
	private EstadoAporte estado;


	
	public AporteDTO() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public TipoAporteDTO getTipoAporte() {
		return tipoAporte;
	}

	public void setTipoAporte(TipoAporteDTO tipoAporte) {
		this.tipoAporte = tipoAporte;
	}

	public SocioDTO getSocio() {
		return socio;
	}

	public void setSocio(SocioDTO socio) {
		this.socio = socio;
	}

	public EstadoAporte getEstado() {
		return estado;
	}

	public void setEstado(EstadoAporte estado) {
		this.estado = estado;
	}
	
	


}
