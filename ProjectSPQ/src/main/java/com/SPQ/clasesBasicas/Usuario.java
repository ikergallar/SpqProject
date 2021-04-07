package com.SPQ.clasesBasicas;

public class Usuario {
	
	static int id;//identificador unico y estatico
	
	String nombre;
	String apellido;
	String pass;
	String mail;
	String telefono;
	String direccion;
	String descripcion;
	String foto;
	Anuncio[] anuncios;
	String palabraRecuperacion;
	String preguntaRecuperacion;
	
	
	public static int getUsuario() {
		return id;
	}
	public static void setUsuario(int id) {
		Usuario.id = id;
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
	public String gettelefono() {
		return telefono;
	}
	public void settelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getdireccion() {
		return direccion;
	}
	public void setdireccion(String direccion) {
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
