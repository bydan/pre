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
package com.bydan.erp.nomina.business.entity;

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
//import com.bydan.erp.nomina.util.TipoDiscapacidadConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class TipoDiscapacidad extends GeneralEntity implements Serializable ,Cloneable {//TipoDiscapacidadAdditional,GeneralEntity
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
	
	private TipoDiscapacidad tipodiscapacidadOriginal;
	
	private Map<String, Object> mapTipoDiscapacidad;
			
	public Map<String, Object> getMapTipoDiscapacidad() {
		return mapTipoDiscapacidad;
	}

	public void setMapTipoDiscapacidad(Map<String, Object> mapTipoDiscapacidad) {
		this.mapTipoDiscapacidad = mapTipoDiscapacidad;
	}
	
	public void inicializarMapTipoDiscapacidad() {
		this.mapTipoDiscapacidad = new HashMap<String,Object>();
	}
	
	public void setMapTipoDiscapacidadValue(String sKey,Object oValue) {
		this.mapTipoDiscapacidad.put(sKey, oValue);
	}
	
	public Object getMapTipoDiscapacidadValue(String sKey) {
		return this.mapTipoDiscapacidad.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoDiscapacidadConstantesFunciones.SREGEXNOMBRE,message=TipoDiscapacidadConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_inicial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_final;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
	public List<EmpleadoDisca> empleadodiscas;
		
	public TipoDiscapacidad () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipodiscapacidadOriginal=this;
		
 		this.id_empresa=-1L;
 		this.nombre="";
 		this.porcentaje_inicial=0.0;
 		this.porcentaje_final=0.0;
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		this.empleadodiscas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoDiscapacidad (Long id,Date versionRow,Long id_empresa,String nombre,Double porcentaje_inicial,Double porcentaje_final) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipodiscapacidadOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.porcentaje_inicial=porcentaje_inicial;
 		this.porcentaje_final=porcentaje_final;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoDiscapacidad (Long id_empresa,String nombre,Double porcentaje_inicial,Double porcentaje_final) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipodiscapacidadOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.porcentaje_inicial=porcentaje_inicial;
 		this.porcentaje_final=porcentaje_final;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoDiscapacidad tipodiscapacidadLocal=null;
		
		if(object!=null) {
			tipodiscapacidadLocal=(TipoDiscapacidad)object;
			
			if(tipodiscapacidadLocal!=null) {
				if(this.getId()!=null && tipodiscapacidadLocal.getId()!=null) {
					if(this.getId().equals(tipodiscapacidadLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoDiscapacidadConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoDiscapacidadConstantesFunciones.getTipoDiscapacidadDescripcion(this);
		} else {
			sDetalle=TipoDiscapacidadConstantesFunciones.getTipoDiscapacidadDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoDiscapacidad getTipoDiscapacidadOriginal() {
		return this.tipodiscapacidadOriginal;
	}
	
	public void setTipoDiscapacidadOriginal(TipoDiscapacidad tipodiscapacidad) {
		try {
			this.tipodiscapacidadOriginal=tipodiscapacidad;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Double getporcentaje_inicial() {
		return this.porcentaje_inicial;
	}
    
	
	public Double getporcentaje_final() {
		return this.porcentaje_final;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoDiscapacidad:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoDiscapacidad:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("TipoDiscapacidad:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_inicial(Double newporcentaje_inicial)throws Exception
	{
		try {
			if(this.porcentaje_inicial!=newporcentaje_inicial) {
				if(newporcentaje_inicial==null) {
					//newporcentaje_inicial=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoDiscapacidad:Valor nulo no permitido en columna porcentaje_inicial");
					}
				}

				this.porcentaje_inicial=newporcentaje_inicial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_final(Double newporcentaje_final)throws Exception
	{
		try {
			if(this.porcentaje_final!=newporcentaje_final) {
				if(newporcentaje_final==null) {
					//newporcentaje_final=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoDiscapacidad:Valor nulo no permitido en columna porcentaje_final");
					}
				}

				this.porcentaje_final=newporcentaje_final;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	
	
	public List<EmpleadoDisca> getEmpleadoDiscas() {
		return this.empleadodiscas;
	}

	
	
	public  void  setEmpleadoDiscas(List<EmpleadoDisca> empleadodiscas) {
		try {
			this.empleadodiscas=empleadodiscas;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";
	}
	
	
	Object empleadodiscasDescripcionReporte;
	
	
	public Object getempleadodiscasDescripcionReporte() {
		return empleadodiscasDescripcionReporte;
	}

	
	
	public  void  setempleadodiscasDescripcionReporte(Object empleadodiscas) {
		try {
			this.empleadodiscasDescripcionReporte=empleadodiscas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

