package com.bydan.framework.global.seguridad.updates.entity;

public class ArchivoUpdate {
	private String nombreArchivo="";
	private String numeroArchivo="";
	
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	public String getNumeroArchivo() {
		return numeroArchivo;
	}
	public void setNumeroArchivo(String numeroArchivo) {
		this.numeroArchivo = numeroArchivo;
	}
	
	public ArchivoUpdate(String nombreArchivo, String numeroArchivo) {
		super();
		this.nombreArchivo = nombreArchivo;
		this.numeroArchivo = numeroArchivo;
	}
	
	public ArchivoUpdate() {
		super();
		this.nombreArchivo = "";
		this.numeroArchivo = "";
	}
}
