package com.SPQ.clasesBasicas;

import java.text.SimpleDateFormat;  
import java.util.Date;  

public class Comentario {
	
	private String mensaje;
	private String nombreUsuario;
	private String fecha;
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public void generarComentario(String mensaje, Usuario user) {
		this.mensaje = mensaje;
		this.nombreUsuario = user.getNombreUsuario();
		//fecha
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date date = new Date();    
		this.fecha = formatter.format(date);
	}
	public Comentario(String mensaje, String nombreUsuario, String fecha) {
		this.mensaje = mensaje;
		this.nombreUsuario = nombreUsuario;
		this.fecha = fecha;
	}
	public Comentario() {
		this.mensaje = "";
		this.nombreUsuario = "";
		this.fecha = "";
	}
	
	
	

}