package uy.org.coviagricola.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ActivarCuenta
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name="ActivarCuenta.ObtenerEmailPorCuenta",query="select a.email from ActivarCuenta a where a.token=:token"),
})
public class ActivarCuenta implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(unique=true)
	private String email;
	
	@Column
	private String token;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
   
}
