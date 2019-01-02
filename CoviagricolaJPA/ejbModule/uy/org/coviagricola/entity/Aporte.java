package uy.org.coviagricola.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import uy.org.coviagricola.enumerated.EstadoAporte;


/**
 * Entity implementation class for Entity: Aporte
 *
 */
@Entity(name="Aportes")
@NamedQueries({
	@NamedQuery(name="Aporte.ObtenerAportesPorEmailSocio",query="select a from Aportes a where a.socio.email=:email"),
	@NamedQuery(name="Aporte.ObtenerAportePorId",query="select a from Aportes a where a.id=:id"),

})
public class Aporte implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column
	private Date fecha;
	
	@Column
	private Date vencimiento;
	
	@Column
	private int monto;
	
	@Column
    @Enumerated(EnumType.STRING)
	EstadoAporte estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipoaporte_id")
	private TipoAporte tipoAporte;
	
	@ManyToOne
    @JoinColumn(name = "socio_id")
	private Socio socio;	
	
	@OneToMany( mappedBy = "aporte", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Pago> pago;
	
	
	
	public Aporte() {
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



	public TipoAporte getTipoAporte() {
		return tipoAporte;
	}



	public void setTipoAporte(TipoAporte tipoAporte) {
		this.tipoAporte = tipoAporte;
	}



	public Socio getSocio() {
		return socio;
	}



	public void setSocio(Socio socio) {
		this.socio = socio;
	}



	public EstadoAporte getEstado() {
		return estado;
	}



	public void setEstado(EstadoAporte estado) {
		this.estado = estado;
	}
	
	
   
}
