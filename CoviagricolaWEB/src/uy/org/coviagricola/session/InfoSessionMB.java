package uy.org.coviagricola.session;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import uy.org.coviagricola.dto.SocioDTO;

@ManagedBean
@SessionScoped
public class InfoSessionMB {
	
	@EJB
	SessionLocal sessionEJB;
	
	private String email;
	private String nombre;
	private Integer ci;
	private List<String> roles;
	
	boolean isUser,isAdminSocios,isTesor,isSuper;

	@PostConstruct
	public void init() {
		Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        this.email= principal.getName();
        SocioDTO socio=sessionEJB.getSocioPorEmail(email);
        if(socio!=null)
        	nombre=socio.getPrimerNombre()+" "+socio.getPrimerApellido();
	}
	
	public void salir() {
		System.out.println("Destruyendo sesion.....");
		((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession().invalidate();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/Coviagricola/paginas/gestionSocios/agregarSocio.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String redirigir() {
		System.out.println("Redirigiendo.....");
		return "http://localhost:8080/Coviagricola/paginas/gestionSocios/agregarSocio.xhtml";
	}
	
	
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCi() {
		return ci;
	}

	public void setCi(Integer ci) {
		this.ci = ci;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public boolean isUser() {
		return isUser;
	}

	public void setUser(boolean isUser) {
		this.isUser = isUser;
	}

	public boolean isAdminSocios() {
		return isAdminSocios;
	}

	public void setAdminSocios(boolean isAdminSocios) {
		this.isAdminSocios = isAdminSocios;
	}

	public boolean isTesor() {
		return isTesor;
	}

	public void setTesor(boolean isTesor) {
		this.isTesor = isTesor;
	}

	public boolean isSuper() {
		return isSuper;
	}

	public void setSuper(boolean isSuper) {
		this.isSuper = isSuper;
	}
	
	
	
	
	
	
	
	
	
}
