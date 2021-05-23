package com.SPQ.clasesBasicas;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;

/**
 * Clase USUARIO donde creamos los perfiles de los usuarios del software
 * @author AitorGG
 *
 */

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
	private List<Anuncio> favoritos;
	
	/**
	 * Constructor de la clase USUARIO
	 * @param nombre String con el nombre del USUARIO
	 * @param apellido String con el apellido del USUARIO
	 * @param nombreUsuario String con el nombre del USUARIO
	 * @param pass String con la contraseña del USUARIO
	 * @param mail String con el mail del USUARIO
	 * @param telefono String con el telefono del USUARIO
	 * @param direccion String con la direccion del USUARIO
	 * @param foto String con la foto del USUARIO
	 * @param palabraRecuperacion String con la palabra de recuperacion del USUARIO
	 * @param preguntaRecupperacion String con la pregunta de recuperacion del USUARIO
	 * @param descripcion String con la descripcion del USUARIO
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

	/**
	 * Devuelve la descripción del USUARIO
	 * @return String con el nombre de usuario del USUARIO
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Actualiza la descripción del USUARIO
	 * @param username String con el nuevo nombre de usuario
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Devuelve el idUsuario del USUARIO
	 * @return String con el nombre de usuario del USUARIO
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * Actualiza idUsuario del USUARIO
	 * @param username String con el nuevo nombre de usuario
	 */
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
	 * Actualiza el nombre de usuario del USUARIO
	 * @param username String con el nuevo nombre de usuario
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * Devuelve el nombre del USUARIO
	 * @return String con el nombre de usuario del USUARIO
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Actualiza el nombre de usuario del USUARIO
	 * @param username String con el nuevo nombre de usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el apellido de usuario del USUARIO
	 * @return String con el nombre de usuario del USUARIO
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Actualiza el apellido del USUARIO
	 * @param username String con el nuevo nombre de usuario
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Devuelve el telefono del USUARIO
	 * @return String con el nombre de usuario del USUARIO
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Actualiza el telefono del USUARIO
	 * @param username String con el nuevo nombre de usuario
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Devuelve la direccion del USUARIO
	 * @return String con el nombre de usuario del USUARIO
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Actualiza la direccion del USUARIO
	 * @param username String con el nuevo nombre de usuario
	 */
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
	 * @return String con el mail del usuario
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
	 * @param foto String con la foto
	 */
	public String getFoto() {
		return foto;
	}
	
	/**
	 * Actualiza la foto del USUARIO
	 * @param foto String con la nueva foto
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * Devuelve la palabra recuperación del USUARIO
	 * @param palabraRecuperacion String con la palabra de recuperación
	 */
	public String getPalabraRecuperacion() {
		return palabraRecuperacion;
	}
	
	/**
	 * Actualiza la palabra de recuperación del USUARIO
	 * @param palabraRecuperacion String con la nueva palabra de reucperacion
	 */
	public void setPalabraRecuperacion(String palabraRecuperacion) {
		this.palabraRecuperacion = palabraRecuperacion;
	}
	/**
	 * Devuelve la pregunta de recuperación del USUARIO
	 * @param preguntaRecuperacion String con la pregunta de recuperación
	 */
	public String getPreguntaRecuperacion() {
		return preguntaRecuperacion;
	}
	
	/**
	 * Actualiza la pregunta de recuperación del USUARIO
	 * @param preguntaRecuperacion String con la nueva pregunta de recuperación
	 */
	public void setPreguntaRecuperacion(String preguntaRecuperacion) {
		this.preguntaRecuperacion = preguntaRecuperacion;
	}
	
	/**
	 * Devuelve los favoritos del USUARIO
	 * @param Favoritos String con los favoritos del USUARIO
	 */
	public List<Anuncio> getFavoritos() {
		return favoritos;
	}

	/**
	 * Actualiza los favoritos del USUARIO
	 * @param Favoritos String con los nuevos favoritos del USUARIO
	 */
	public void setFavoritos(List<Anuncio> favoritos) {
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

	/**
	 * Boolean de todos los datos de un USUARIO
	 */
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


}
