package com.SPQ.clasesBasicas;

public class Usuario {
	
	static String usuario;//identificador unico y estatico
	
	private String nombre;
	private String apellido;
	private String numero;
	private String pass;
	private String mail;
	private String descripcion;
	private String foto;
	private Anuncio[] anuncios;
	private String palabraRecuperacion;
	private String preguntaRecuperacion;
	
	
	public static String getUsuario() {
		return usuario;
	}
	public static void setUsuario(String usuario) {
		Usuario.usuario = usuario;
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
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
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
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", numero=" + numero + ", pass=" + pass
				+ ", mail=" + mail + ", descripcion=" + descripcion + ", foto=" + foto + "]";
	}
	

}
