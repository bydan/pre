package com.bydan.framework.global.seguridad.updates.entity;

public class QueryUpdate extends GeneralEntityUpdate{
	private String query="";
	private String codigo="";
	private Integer orden=0;		
	
	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public QueryUpdate(String query,String codigo,Integer orden) {
		super();
		this.query = query;
		this.codigo=codigo;
		this.orden=orden;
	}
	
	public QueryUpdate() {
		super();
		this.query = "";
		this.codigo="";
		this.orden=0;
	}
}
