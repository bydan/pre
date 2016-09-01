/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.inventario.business.entity;

import java.io.Serializable;
import java.io.File;

import java.util.Calendar;
import java.sql.Timestamp;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;



import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesValidacion;
//import com.bydan.erp.inventario.util.PresupuestoLineaConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class PresupuestoLinea extends PresupuestoLineaAdditional implements Serializable ,Cloneable {//PresupuestoLineaAdditional,GeneralEntity
	private static final long serialVersionUID=1L;
	
	public Object clone() {
        return super.clone();
    }
	
	protected Long id;
	protected boolean isNew;
	protected boolean isChanged;
	protected boolean isDeleted;
	protected boolean isSelected;
	protected Date versionRow;
	protected String sType;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long newId) {
		if(this.id!=newId) {
			this.isChanged=true;
		}
		
		this.id=newId;
		super.setId(newId);
	}
	
	
	
	public Date getVersionRow(){
		//ESTO SIEMPRE SE EJECUTA CUANDO SE CONSUME EJB
		return this.versionRow;
	}
	
	public void setVersionRow(Date newVersionRow){
		if(this.versionRow!=newVersionRow){
			//LE COMENTO PORQUE CUANDO HAGO GET SIEMPRE POR ESTO LE PONE isChanged=true
			//this.isChanged=true;
		}
		
		this.versionRow=newVersionRow;
		super.setVersionRow(newVersionRow);
	}
	
	
	public boolean getIsNew() {
		return this.isNew;
	}
	
	public void setIsNew(boolean newIsNew) {
		this.isNew=newIsNew;
		super.setIsNew(newIsNew);
	}
	
	public boolean getIsChanged() {
		return this.isChanged;
	}
	
	public void setIsChanged(boolean newIsChanged) {
		this.isChanged=newIsChanged;
		super.setIsChanged(newIsChanged);
	}
	
	public boolean getIsDeleted() {
		return this.isDeleted;
	}
	
	public void setIsDeleted(boolean newIsDeleted) {
		this.isDeleted=newIsDeleted;
		super.setIsDeleted(newIsDeleted);
	}
	
	public boolean getIsSelected() {
		return this.isSelected;
	}
	
	public void setIsSelected(boolean newIsSelected) {
		this.isSelected=newIsSelected;
		super.setIsSelected(newIsSelected);
	}
	
	public String getsType() {
		return this.sType;
	}
	
	public void setsType(String sType) {
		this.sType=sType;
		super.setsType(sType);
	}
	
	private PresupuestoLinea presupuestolineaOriginal;
	
	private Map<String, Object> mapPresupuestoLinea;
			
	public Map<String, Object> getMapPresupuestoLinea() {
		return mapPresupuestoLinea;
	}

	public void setMapPresupuestoLinea(Map<String, Object> mapPresupuestoLinea) {
		this.mapPresupuestoLinea = mapPresupuestoLinea;
	}
	
	public void inicializarMapPresupuestoLinea() {
		this.mapPresupuestoLinea = new HashMap<String,Object>();
	}
	
	public void setMapPresupuestoLineaValue(String sKey,Object oValue) {
		this.mapPresupuestoLinea.put(sKey, oValue);
	}
	
	public Object getMapPresupuestoLineaValue(String sKey) {
		return this.mapPresupuestoLinea.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double margen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_para_presupuesto;
			
	
	public Empresa empresa;
	public Linea linea;
	
	
	private String empresa_descripcion;
	private String linea_descripcion;
	
	
		
	public PresupuestoLinea () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.presupuestolineaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_linea=-1L;
 		this.margen=0.0;
 		this.descuento=0.0;
 		this.es_para_presupuesto=false;
		
		
		this.empresa=null;
		this.linea=null;
		
		
		this.empresa_descripcion="";
		this.linea_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PresupuestoLinea (Long id,Date versionRow,Long id_empresa,Long id_linea,Double margen,Double descuento,Boolean es_para_presupuesto) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.presupuestolineaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_linea=id_linea;
 		this.margen=margen;
 		this.descuento=descuento;
 		this.es_para_presupuesto=es_para_presupuesto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PresupuestoLinea (Long id_empresa,Long id_linea,Double margen,Double descuento,Boolean es_para_presupuesto) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.presupuestolineaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_linea=id_linea;
 		this.margen=margen;
 		this.descuento=descuento;
 		this.es_para_presupuesto=es_para_presupuesto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		PresupuestoLinea presupuestolineaLocal=null;
		
		if(object!=null) {
			presupuestolineaLocal=(PresupuestoLinea)object;
			
			if(presupuestolineaLocal!=null) {
				if(this.getId()!=null && presupuestolineaLocal.getId()!=null) {
					if(this.getId().equals(presupuestolineaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PresupuestoLineaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PresupuestoLineaConstantesFunciones.getPresupuestoLineaDescripcion(this);
		} else {
			sDetalle=PresupuestoLineaConstantesFunciones.getPresupuestoLineaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public PresupuestoLinea getPresupuestoLineaOriginal() {
		return this.presupuestolineaOriginal;
	}
	
	public void setPresupuestoLineaOriginal(PresupuestoLinea presupuestolinea) {
		try {
			this.presupuestolineaOriginal=presupuestolinea;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PresupuestoLineaAdditional presupuestolineaAdditional=null;
	
	public PresupuestoLineaAdditional getPresupuestoLineaAdditional() {
		return this.presupuestolineaAdditional;
	}
	
	public void setPresupuestoLineaAdditional(PresupuestoLineaAdditional presupuestolineaAdditional) {
		try {
			this.presupuestolineaAdditional=presupuestolineaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_linea() {
		return this.id_linea;
	}
    
	
	public Double getmargen() {
		return this.margen;
	}
    
	
	public Double getdescuento() {
		return this.descuento;
	}
    
	
	public Boolean getes_para_presupuesto() {
		return this.es_para_presupuesto;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestoLinea:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_linea(Long newid_linea)throws Exception
	{
		try {
			if(this.id_linea!=newid_linea) {
				if(newid_linea==null) {
					//newid_linea=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestoLinea:Valor nulo no permitido en columna id_linea");
					}
				}

				this.id_linea=newid_linea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmargen(Double newmargen)throws Exception
	{
		try {
			if(this.margen!=newmargen) {
				if(newmargen==null) {
					//newmargen=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestoLinea:Valor nulo no permitido en columna margen");
					}
				}

				this.margen=newmargen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento(Double newdescuento)throws Exception
	{
		try {
			if(this.descuento!=newdescuento) {
				if(newdescuento==null) {
					//newdescuento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestoLinea:Valor nulo no permitido en columna descuento");
					}
				}

				this.descuento=newdescuento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_para_presupuesto(Boolean newes_para_presupuesto)throws Exception
	{
		try {
			if(this.es_para_presupuesto!=newes_para_presupuesto) {
				if(newes_para_presupuesto==null) {
					//newes_para_presupuesto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestoLinea:Valor nulo no permitido en columna es_para_presupuesto");
					}
				}

				this.es_para_presupuesto=newes_para_presupuesto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Linea getLinea() {
		return this.linea;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getlinea_descripcion() {
		return this.linea_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setLinea(Linea linea) {
		try {
			this.linea=linea;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setlinea_descripcion(String linea_descripcion) {
		try {
			this.linea_descripcion=linea_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_linea_descripcion="";String es_para_presupuesto_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_linea_descripcion() {
		return id_linea_descripcion;
	}
	public String getes_para_presupuesto_descripcion() {
		return es_para_presupuesto_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_linea_descripcion(String newid_linea_descripcion)throws Exception {
		try {
			this.id_linea_descripcion=newid_linea_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_para_presupuesto_descripcion(String newes_para_presupuesto_descripcion)throws Exception {
		try {
			this.es_para_presupuesto_descripcion=newes_para_presupuesto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_linea_descripcion="";this.es_para_presupuesto_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

