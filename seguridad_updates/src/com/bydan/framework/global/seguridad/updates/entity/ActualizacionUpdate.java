package com.bydan.framework.global.seguridad.updates.entity;

import java.util.ArrayList;
import java.util.List;

public class ActualizacionUpdate extends GeneralEntityUpdate{
	String codigo="";
	String codigoArchivo="";
	Integer orden=0;
	Integer dia=0;	
	String queryTotal="";
	String numeroArchivoSql="";
	
	private List<QueryUpdate> querysUpdates;
	
	public List<QueryUpdate> getQuerysUpdates() {
		return querysUpdates;
	}
	public void setQuerysUpdates(List<QueryUpdate> querysUpdates) {
		this.querysUpdates = querysUpdates;
	}
	
	
	public String getQueryTotal() {
		return queryTotal;
	}
	public void setQueryTotal(String queryTotal) {
		this.queryTotal = queryTotal;
	}
	
	
	
	public String getNumeroArchivoSql() {
		return numeroArchivoSql;
	}
	public void setNumeroArchivoSql(String numeroArchivoSql) {
		this.numeroArchivoSql = numeroArchivoSql;
	}
	public String getCodigoArchivo() {
		return codigoArchivo;
	}
	public void setCodigoArchivo(String codigoArchivo) {
		this.codigoArchivo = codigoArchivo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	public Integer getDia() {
		return dia;
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	
	public ActualizacionUpdate(String codigo, Integer orden, Integer dia,String queryTotal,String codigoArchivo,String numeroArchivoSql,ArrayList<QueryUpdate> querysUpdates) {
		super();
		this.codigo = codigo;
		this.orden = orden;
		this.dia = dia;
		this.codigoArchivo=codigoArchivo;
		this.numeroArchivoSql=numeroArchivoSql;
		
		this.querysUpdates=querysUpdates;
	}
	
	public ActualizacionUpdate() {
		super();
		this.codigo = "";
		this.orden = 0;
		this.dia = 0;
		this.queryTotal="";
		this.codigoArchivo="";
		this.numeroArchivoSql="";
		
		this.querysUpdates=new ArrayList<QueryUpdate>();
	}
	
	public static String getCodigoSql(String sAnio,String sMes,String sNumeroArchivoSql) {
		String sCodigoSql="";
		
		sCodigoSql=sAnio+"-"+sMes+"_"+sNumeroArchivoSql+"";
		
		return sCodigoSql;
	}
	
	public void inicializaValoresAutomaticos(AnioUpdate anioUpdate,MesUpdate mesUpdate) {
		//NUMERO ARCHIVO
		String sNumeroArchivo=this.codigoArchivo.split("_")[0];
		
		this.numeroArchivoSql=sNumeroArchivo;
		
		
		//CODIGO
		String sCodigo=anioUpdate.getAnioString()+"-"+mesUpdate.getMesString()+"_"+sNumeroArchivo;
		
		
		this.codigo=sCodigo;
		
	}
}
