package uy.org.coviagricola.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TipoAporte
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name="TipoAporte.ObtenerTiposAportes",query="select ta from TipoAporte ta"),
	@NamedQuery(name="TipoAporte.ObtenerTipoAportesPorId",query="select ta from TipoAporte ta where ta.id=:id"),

})
public class TipoAporte implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column
	private String codigo;
	
	@Column 
	private String descripcion;
	
//	@OneToMany(  mappedBy = "tipoAporte", cascade = CascadeType.ALL,orphanRemoval = true)
//	private List<Aporte> listaAportesPorTipo;
	

	public TipoAporte() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


/*	public List<Aporte> getListaAportesPorTipo() {
		return listaAportesPorTipo;
	}


	public void setListaAportesPorTipo(List<Aporte> listaAportesPorTipo) {
		this.listaAportesPorTipo = listaAportesPorTipo;
	}
*/	
	
	
	
   
}
