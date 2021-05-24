package com.SPQ.clasesBasicas;

import java.text.SimpleDateFormat;  
import java.util.Date;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;  

/**
 * Clase Comentario con la que se crean los comentarios de los servicios
 * @author AitorFournier
 *
 */
@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Comentario {
	
	private String mensaje;
	private String nombreUsuario;
	private String fecha;
	private int valoracion;
	
	
	/**
	 * Devuelve el mensaje del COMENTARIO
	 * @return String mensaje del COMENTARIO
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * Define el mensaje del COMENTARIO
	 * @param String con el mensaje del COMENTARIO
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	/**
	 * Devuelve el mensaje del COMENTARIO
	 * @return String mensaje del COMENTARIO
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * Define el nombre de usuario del USUARIO que hace el COMENTARIO
	 * @param String con el nombre de usuario
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * Devuelve la fecha del COMENTARIO
	 * @return String fecha del COMENTARIO
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * Fija la fecha del COMENTARIO
	 * @param String con la fecha del COMENTARIO
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * Devuelve la valoracion del COMENTARIO
	 * @return int con la valoracion del COMENTARIO
	 */
	public int getValoracion() {
		return valoracion;
	}
	/**
	 * Define la valoracion del COMENTARIO
	 * @param int con la valoracion del COMENTARIO
	 */
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	/**
	 * Genera un COMENTARIO con el mensaje y el usuario que ha recibido
	 * @param String mensaje del COMENTARIO y USUARIO que comenta
	 */
	public void generarComentario(String mensaje, int valoracion, Usuario user) {
		this.mensaje = mensaje;
		if(valoracion>5) {
			valoracion=5;
		}
		this.valoracion = valoracion;
		this.nombreUsuario = user.getNombreUsuario();
		//fecha
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date date = new Date();    
		this.fecha = formatter.format(date);
	}
	/**
	 * Constructor de la clase COMENTARIO
	 * @param mensaje String con el mensaje del COMENTARIO
	 * @param nombreUsuario String con el nombre del USUARIO
	 * @param fecha String con la fecha en la que se realiza el COMENTARIO
	 */
	public Comentario(String mensaje, int valoracion, String nombreUsuario, String fecha) {
		this.valoracion = valoracion;
		this.mensaje = mensaje;
		this.nombreUsuario = nombreUsuario;
		this.fecha = fecha;
	}
	/**
	 * Constructor vacio de la clase USUARIO
	 */
	public Comentario() {
		this.valoracion = 0;
		this.mensaje = "";
		this.nombreUsuario = "";
		this.fecha = "";
	}
	
	
	

}