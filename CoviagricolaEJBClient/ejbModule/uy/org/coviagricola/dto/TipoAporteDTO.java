package uy.org.coviagricola.dto;

import java.io.Serializable;

public class TipoAporteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
 
	private String codigo;
	
	private String descripcion;

	public TipoAporteDTO() {
		super();
		// TODO Auto-generated constructor stub
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


	

}
