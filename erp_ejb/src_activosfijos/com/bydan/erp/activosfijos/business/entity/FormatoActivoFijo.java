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
package com.bydan.erp.activosfijos.business.entity;

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
//import com.bydan.erp.activosfijos.util.FormatoActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class FormatoActivoFijo extends FormatoActivoFijoAdditional implements Serializable ,Cloneable {//FormatoActivoFijoAdditional,GeneralEntity
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
	
	private FormatoActivoFijo formatoactivofijoOriginal;
	
	private Map<String, Object> mapFormatoActivoFijo;
			
	public Map<String, Object> getMapFormatoActivoFijo() {
		return mapFormatoActivoFijo;
	}

	public void setMapFormatoActivoFijo(Map<String, Object> mapFormatoActivoFijo) {
		this.mapFormatoActivoFijo = mapFormatoActivoFijo;
	}
	
	public void inicializarMapFormatoActivoFijo() {
		this.mapFormatoActivoFijo = new HashMap<String,Object>();
	}
	
	public void setMapFormatoActivoFijoValue(String sKey,Object oValue) {
		this.mapFormatoActivoFijo.put(sKey, oValue);
	}
	
	public Object getMapFormatoActivoFijoValue(String sKey) {
		return this.mapFormatoActivoFijo.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato2;
			
	
	public Empresa empresa;
	public Formato formato;
	public Formato formato2;
	
	
	private String empresa_descripcion;
	private String formato_descripcion;
	private String formato2_descripcion;
	
	
		
	public FormatoActivoFijo () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.formatoactivofijoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_formato=-1L;
 		this.id_formato2=-1L;
		
		
		this.empresa=null;
		this.formato=null;
		this.formato2=null;
		
		
		this.empresa_descripcion="";
		this.formato_descripcion="";
		this.formato2_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public FormatoActivoFijo (Long id,Date versionRow,Long id_empresa,Long id_formato,Long id_formato2) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.formatoactivofijoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_formato=id_formato;
 		this.id_formato2=id_formato2;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public FormatoActivoFijo (Long id_empresa,Long id_formato,Long id_formato2) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.formatoactivofijoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_formato=id_formato;
 		this.id_formato2=id_formato2;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		FormatoActivoFijo formatoactivofijoLocal=null;
		
		if(object!=null) {
			formatoactivofijoLocal=(FormatoActivoFijo)object;
			
			if(formatoactivofijoLocal!=null) {
				if(this.getId()!=null && formatoactivofijoLocal.getId()!=null) {
					if(this.getId().equals(formatoactivofijoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!FormatoActivoFijoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=FormatoActivoFijoConstantesFunciones.getFormatoActivoFijoDescripcion(this);
		} else {
			sDetalle=FormatoActivoFijoConstantesFunciones.getFormatoActivoFijoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public FormatoActivoFijo getFormatoActivoFijoOriginal() {
		return this.formatoactivofijoOriginal;
	}
	
	public void setFormatoActivoFijoOriginal(FormatoActivoFijo formatoactivofijo) {
		try {
			this.formatoactivofijoOriginal=formatoactivofijo;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected FormatoActivoFijoAdditional formatoactivofijoAdditional=null;
	
	public FormatoActivoFijoAdditional getFormatoActivoFijoAdditional() {
		return this.formatoactivofijoAdditional;
	}
	
	public void setFormatoActivoFijoAdditional(FormatoActivoFijoAdditional formatoactivofijoAdditional) {
		try {
			this.formatoactivofijoAdditional=formatoactivofijoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_formato() {
		return this.id_formato;
	}
    
	
	public Long getid_formato2() {
		return this.id_formato2;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormatoActivoFijo:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato(Long newid_formato)throws Exception
	{
		try {
			if(this.id_formato!=newid_formato) {
				if(newid_formato==null) {
					//newid_formato=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormatoActivoFijo:Valor nulo no permitido en columna id_formato");
					}
				}

				this.id_formato=newid_formato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato2(Long newid_formato2)throws Exception
	{
		try {
			if(this.id_formato2!=newid_formato2) {
				if(newid_formato2==null) {
					//newid_formato2=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormatoActivoFijo:Valor nulo no permitido en columna id_formato2");
					}
				}

				this.id_formato2=newid_formato2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Formato getFormato() {
		return this.formato;
	}

	public Formato getFormato2() {
		return this.formato2;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getformato_descripcion() {
		return this.formato_descripcion;
	}

	public String getformato2_descripcion() {
		return this.formato2_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormato(Formato formato) {
		try {
			this.formato=formato;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormato2(Formato formato2) {
		try {
			this.formato2=formato2;
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


	public  void  setformato_descripcion(String formato_descripcion) {
		try {
			this.formato_descripcion=formato_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformato2_descripcion(String formato2_descripcion) {
		try {
			this.formato2_descripcion=formato2_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_formato_descripcion="";String id_formato2_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_formato_descripcion() {
		return id_formato_descripcion;
	}
	public String getid_formato2_descripcion() {
		return id_formato2_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_descripcion(String newid_formato_descripcion)throws Exception {
		try {
			this.id_formato_descripcion=newid_formato_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato2_descripcion(String newid_formato2_descripcion)throws Exception {
		try {
			this.id_formato2_descripcion=newid_formato2_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_formato_descripcion="";this.id_formato2_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

