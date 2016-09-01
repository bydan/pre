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
//import com.bydan.erp.inventario.util.ConversionUnidadConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ConversionUnidad extends ConversionUnidadAdditional implements Serializable ,Cloneable {//ConversionUnidadAdditional,GeneralEntity
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
	
	private ConversionUnidad conversionunidadOriginal;
	
	private Map<String, Object> mapConversionUnidad;
			
	public Map<String, Object> getMapConversionUnidad() {
		return mapConversionUnidad;
	}

	public void setMapConversionUnidad(Map<String, Object> mapConversionUnidad) {
		this.mapConversionUnidad = mapConversionUnidad;
	}
	
	public void inicializarMapConversionUnidad() {
		this.mapConversionUnidad = new HashMap<String,Object>();
	}
	
	public void setMapConversionUnidadValue(String sKey,Object oValue) {
		this.mapConversionUnidad.put(sKey, oValue);
	}
	
	public Object getMapConversionUnidadValue(String sKey) {
		return this.mapConversionUnidad.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_unidad_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_unidad_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double relacion;
			
	
	public Empresa empresa;
	public Unidad unidaddesde;
	public Unidad unidadhasta;
	
	
	private String empresa_descripcion;
	private String unidaddesde_descripcion;
	private String unidadhasta_descripcion;
	
	
		
	public ConversionUnidad () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.conversionunidadOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_unidad_desde=-1L;
 		this.id_unidad_hasta=-1L;
 		this.valor=0.0;
 		this.relacion=0.0;
		
		
		this.empresa=null;
		this.unidaddesde=null;
		this.unidadhasta=null;
		
		
		this.empresa_descripcion="";
		this.unidaddesde_descripcion="";
		this.unidadhasta_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ConversionUnidad (Long id,Date versionRow,Long id_empresa,Long id_unidad_desde,Long id_unidad_hasta,Double valor,Double relacion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.conversionunidadOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_unidad_desde=id_unidad_desde;
 		this.id_unidad_hasta=id_unidad_hasta;
 		this.valor=valor;
 		this.relacion=relacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ConversionUnidad (Long id_empresa,Long id_unidad_desde,Long id_unidad_hasta,Double valor,Double relacion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.conversionunidadOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_unidad_desde=id_unidad_desde;
 		this.id_unidad_hasta=id_unidad_hasta;
 		this.valor=valor;
 		this.relacion=relacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ConversionUnidad conversionunidadLocal=null;
		
		if(object!=null) {
			conversionunidadLocal=(ConversionUnidad)object;
			
			if(conversionunidadLocal!=null) {
				if(this.getId()!=null && conversionunidadLocal.getId()!=null) {
					if(this.getId().equals(conversionunidadLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ConversionUnidadConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ConversionUnidadConstantesFunciones.getConversionUnidadDescripcion(this);
		} else {
			sDetalle=ConversionUnidadConstantesFunciones.getConversionUnidadDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ConversionUnidad getConversionUnidadOriginal() {
		return this.conversionunidadOriginal;
	}
	
	public void setConversionUnidadOriginal(ConversionUnidad conversionunidad) {
		try {
			this.conversionunidadOriginal=conversionunidad;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ConversionUnidadAdditional conversionunidadAdditional=null;
	
	public ConversionUnidadAdditional getConversionUnidadAdditional() {
		return this.conversionunidadAdditional;
	}
	
	public void setConversionUnidadAdditional(ConversionUnidadAdditional conversionunidadAdditional) {
		try {
			this.conversionunidadAdditional=conversionunidadAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_unidad_desde() {
		return this.id_unidad_desde;
	}
    
	
	public Long getid_unidad_hasta() {
		return this.id_unidad_hasta;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Double getrelacion() {
		return this.relacion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConversionUnidad:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_unidad_desde(Long newid_unidad_desde)throws Exception
	{
		try {
			if(this.id_unidad_desde!=newid_unidad_desde) {
				if(newid_unidad_desde==null) {
					//newid_unidad_desde=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConversionUnidad:Valor nulo no permitido en columna id_unidad_desde");
					}
				}

				this.id_unidad_desde=newid_unidad_desde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_unidad_hasta(Long newid_unidad_hasta)throws Exception
	{
		try {
			if(this.id_unidad_hasta!=newid_unidad_hasta) {
				if(newid_unidad_hasta==null) {
					//newid_unidad_hasta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConversionUnidad:Valor nulo no permitido en columna id_unidad_hasta");
					}
				}

				this.id_unidad_hasta=newid_unidad_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor(Double newvalor)throws Exception
	{
		try {
			if(this.valor!=newvalor) {
				if(newvalor==null) {
					//newvalor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConversionUnidad:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setrelacion(Double newrelacion)throws Exception
	{
		try {
			if(this.relacion!=newrelacion) {
				if(newrelacion==null) {
					//newrelacion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConversionUnidad:Valor nulo no permitido en columna relacion");
					}
				}

				this.relacion=newrelacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Unidad getUnidadDesde() {
		return this.unidaddesde;
	}

	public Unidad getUnidadHasta() {
		return this.unidadhasta;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getunidaddesde_descripcion() {
		return this.unidaddesde_descripcion;
	}

	public String getunidadhasta_descripcion() {
		return this.unidadhasta_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setUnidadDesde(Unidad unidaddesde) {
		try {
			this.unidaddesde=unidaddesde;
		} catch(Exception e) {
			;
		}
	}


	public  void  setUnidadHasta(Unidad unidadhasta) {
		try {
			this.unidadhasta=unidadhasta;
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


	public  void  setunidaddesde_descripcion(String unidaddesde_descripcion) {
		try {
			this.unidaddesde_descripcion=unidaddesde_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setunidadhasta_descripcion(String unidadhasta_descripcion) {
		try {
			this.unidadhasta_descripcion=unidadhasta_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_unidad_desde_descripcion="";String id_unidad_hasta_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_unidad_desde_descripcion() {
		return id_unidad_desde_descripcion;
	}
	public String getid_unidad_hasta_descripcion() {
		return id_unidad_hasta_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_unidad_desde_descripcion(String newid_unidad_desde_descripcion)throws Exception {
		try {
			this.id_unidad_desde_descripcion=newid_unidad_desde_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_unidad_hasta_descripcion(String newid_unidad_hasta_descripcion)throws Exception {
		try {
			this.id_unidad_hasta_descripcion=newid_unidad_hasta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_unidad_desde_descripcion="";this.id_unidad_hasta_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

