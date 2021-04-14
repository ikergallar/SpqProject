package com.SPQ.clasesBasicas;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;

@PersistenceCapable()
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Usuario {
	
	@PrimaryKey
	static int id;//identificador unico y estatico
	String nombre;	
	String apellido;	
	String nombreUsuario;	
	String pass;	
	String mail;	
	String telefono;	
	String direccion;	
	String descripcion;	
	String foto;	
	Anuncio[] anuncios;	
	String palabraRecuperacion;
	String preguntaRecuperacion;
	
	
	public Usuario(String nombre, String apellido, String nombreUsuario, String pass, String mail, String telefono,
			String direccion, String descripcion, String foto, Anuncio[] anuncios, String palabraRecuperacion,
			String preguntaRecuperacion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreUsuario = nombreUsuario;
		this.pass = pass;
		this.mail = mail;
		this.telefono = telefono;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.foto = foto;
		this.anuncios = anuncios;
		this.palabraRecuperacion = palabraRecuperacion;
		this.preguntaRecuperacion = preguntaRecuperacion;
	}
	
	public Usuario() {
		super();
		this.nombre = "";
		this.apellido = "";
		this.nombreUsuario = "";
		this.pass = "";
		this.mail = "";
		this.telefono = "";
		this.direccion = "";
		this.descripcion = "";
		this.foto = "";
		this.anuncios = null;
		this.palabraRecuperacion = "";
		this.preguntaRecuperacion = "";
	}
	public static int getUsuario() {
		return id;
	}
	public static void setUsuario(int id) {
		Usuario.id = id;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Anuncio[] getAnuncios() {
		return anuncios;
	}
	public void setAnuncios(Anuncio[] anuncios) {
		this.anuncios = anuncios;
	}
	public String getPalabraRecuperacion() {
		return palabraRecuperacion;
	}
	public void setPalabraRecuperacion(String palabraRecuperacion) {
		this.palabraRecuperacion = palabraRecuperacion;
	}
	public String getPreguntaRecuperacion() {
		return preguntaRecuperacion;
	}
	public void setPreguntaRecuperacion(String preguntaRecuperacion) {
		this.preguntaRecuperacion = preguntaRecuperacion;
	}
	//Resumen de datos publicos del usuario
	public String printPublicData() {
		return "Usuario [Nombre=" + nombre + ", Apellido=" + apellido + ", Email=" + mail + ", Descripcion=" + descripcion + "]";
	}
	//Todos los datos de un usuario
	public String printAllData() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", pass=" + pass
				+ ", mail=" + mail + ", descripcion=" + descripcion + ", foto=" + foto + "]";
	}
	

}
