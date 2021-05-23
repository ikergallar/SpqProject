package com.SPQ.clasesBasicas;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;

import java.util.ArrayList;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Usuario {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private int idUsuario;
	private String nombre;
	private String apellido;
	@Unique
	private String nombreUsuario;
	private String pass;
	private String mail;
	private String telefono;
	private String direccion;
	private String foto;
	private String descripcion;
	
	private String palabraRecuperacion;
	private String preguntaRecuperacion;
	private ArrayList<Anuncio> favoritos;
	// private UsuarioConectado usuarioConectado;
	
	/**
	 * Constructor de la clase USUARIO
	 * @param Usuario String con el nombre del USUARIO
	 * @param password String con la contraseña del USUARIO
	 * @param email String con el mail del USUARIO
	 */

	public Usuario(String nombre, String apellido, String nombreUsuario, String pass, String mail, String telefono,
			String direccion, String foto, String palabraRecuperacion, String preguntaRecuperacion, String descripcion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreUsuario = nombreUsuario;
		this.pass = pass;
		this.mail = mail;
		this.telefono = telefono;
		this.direccion = direccion;
		this.foto = foto;
		this.palabraRecuperacion = palabraRecuperacion;
		this.preguntaRecuperacion = preguntaRecuperacion;
		this.descripcion = descripcion;
//		this.setUsuarioConectado(usuarioConectado);
	}
	
	/**
	 * Constructor vacio de la clase USUARIO
	 */
	public Usuario() {
		this.nombre = "";
		this.apellido = "";
		this.nombreUsuario = "";
		this.pass = "";
		this.mail = "";
		this.telefono = "";
		this.direccion = "";
		this.foto = "";
		this.palabraRecuperacion = "";
		this.preguntaRecuperacion = "";
		this.descripcion = "";
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * Devuelve el nombre de usuario del USUARIO
	 * @return String con el nombre de usuario del USUARIO
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * Permite cambiar el nombre de usuario del USUARIO
	 * @param username String con el nuevo nombre de usuario
	 */
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

	/**
	 * Devuelve la contraseña del USUARIO
	 * @return String de la contraseña
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * Actualiza la contraseña del USUARIO
	 * @param password String con la nueva contraseña
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * Devuelve el mail del USUARIO
	 * @return String con el main del usuario
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Actualiza el mail del USUARIO
	 * @param email String con el nuevo mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Devuelve la foto del USUARIO
	 * @param email String con el nuevo mail
	 */
	public String getFoto() {
		return foto;
	}
	
	/**
	 * Actualiza la foto del USUARIO
	 * @param email String con el nuevo mail
	 */
	public void setFoto(String foto) {
		this.foto = foto;
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
	
	public ArrayList<Anuncio> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(ArrayList<Anuncio> favoritos) {
		this.favoritos = favoritos;
	}

	/**
	 * String de resumen de datos publicos del USUARIO
	 */
	
	public String printPublicData() {
		return "Usuario [Nombre=" + nombre + ", Apellido=" + apellido + ", Email=" + mail + "]";
	}
	
	/**
	 * String de todos los datos de un USUARIO
	 */
	public String printAllData() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", pass=" + pass
				+ ", mail=" + mail + ", foto=" + foto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUsuario;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (idUsuario != other.idUsuario)
			return false;
		return true;
	}

//	public static String getStatus() {
//		if(UsuarioConectado.isConnected(nombre)) {
//			return "Conectado";
//		}else {
//			return "No conectado";
//		}
//	}
//
//	public UsuarioConectado Conectado() {
//		return usuarioConectado;
//	}
//
//	public void setUsuarioConectado(UsuarioConectado usuarioConectado) {
//		this.usuarioConectado = usuarioConectado;
//	}

}
