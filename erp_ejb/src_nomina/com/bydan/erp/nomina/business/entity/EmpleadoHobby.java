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
//import com.bydan.erp.nomina.util.EmpleadoHobbyConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class EmpleadoHobby extends EmpleadoHobbyAdditional implements Serializable ,Cloneable {//EmpleadoHobbyAdditional,GeneralEntity
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
	
	private EmpleadoHobby empleadohobbyOriginal;
	
	private Map<String, Object> mapEmpleadoHobby;
			
	public Map<String, Object> getMapEmpleadoHobby() {
		return mapEmpleadoHobby;
	}

	public void setMapEmpleadoHobby(Map<String, Object> mapEmpleadoHobby) {
		this.mapEmpleadoHobby = mapEmpleadoHobby;
	}
	
	public void inicializarMapEmpleadoHobby() {
		this.mapEmpleadoHobby = new HashMap<String,Object>();
	}
	
	public void setMapEmpleadoHobbyValue(String sKey,Object oValue) {
		this.mapEmpleadoHobby.put(sKey, oValue);
	}
	
	public Object getMapEmpleadoHobbyValue(String sKey) {
		return this.mapEmpleadoHobby.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_hobby;
			
	
	public Empresa empresa;
	public Empleado empleado;
	public Hobby hobby;
	
	
	private String empresa_descripcion;
	private String empleado_descripcion;
	private String hobby_descripcion;
	
	
		
	public EmpleadoHobby () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.empleadohobbyOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_empleado=-1L;
 		this.id_hobby=-1L;
		
		
		this.empresa=null;
		this.empleado=null;
		this.hobby=null;
		
		
		this.empresa_descripcion="";
		this.empleado_descripcion="";
		this.hobby_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public EmpleadoHobby (Long id,Date versionRow,Long id_empresa,Long id_empleado,Long id_hobby) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.empleadohobbyOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_hobby=id_hobby;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public EmpleadoHobby (Long id_empresa,Long id_empleado,Long id_hobby) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.empleadohobbyOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_hobby=id_hobby;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		EmpleadoHobby empleadohobbyLocal=null;
		
		if(object!=null) {
			empleadohobbyLocal=(EmpleadoHobby)object;
			
			if(empleadohobbyLocal!=null) {
				if(this.getId()!=null && empleadohobbyLocal.getId()!=null) {
					if(this.getId().equals(empleadohobbyLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EmpleadoHobbyConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EmpleadoHobbyConstantesFunciones.getEmpleadoHobbyDescripcion(this);
		} else {
			sDetalle=EmpleadoHobbyConstantesFunciones.getEmpleadoHobbyDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public EmpleadoHobby getEmpleadoHobbyOriginal() {
		return this.empleadohobbyOriginal;
	}
	
	public void setEmpleadoHobbyOriginal(EmpleadoHobby empleadohobby) {
		try {
			this.empleadohobbyOriginal=empleadohobby;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected EmpleadoHobbyAdditional empleadohobbyAdditional=null;
	
	public EmpleadoHobbyAdditional getEmpleadoHobbyAdditional() {
		return this.empleadohobbyAdditional;
	}
	
	public void setEmpleadoHobbyAdditional(EmpleadoHobbyAdditional empleadohobbyAdditional) {
		try {
			this.empleadohobbyAdditional=empleadohobbyAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_hobby() {
		return this.id_hobby;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoHobby:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empleado(Long newid_empleado)throws Exception
	{
		try {
			if(this.id_empleado!=newid_empleado) {
				if(newid_empleado==null) {
					//newid_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoHobby:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_hobby(Long newid_hobby)throws Exception
	{
		try {
			if(this.id_hobby!=newid_hobby) {
				if(newid_hobby==null) {
					//newid_hobby=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoHobby:Valor nulo no permitido en columna id_hobby");
					}
				}

				this.id_hobby=newid_hobby;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public Hobby getHobby() {
		return this.hobby;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String gethobby_descripcion() {
		return this.hobby_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpleado(Empleado empleado) {
		try {
			this.empleado=empleado;
		} catch(Exception e) {
			;
		}
	}


	public  void  setHobby(Hobby hobby) {
		try {
			this.hobby=hobby;
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


	public  void  setempleado_descripcion(String empleado_descripcion) {
		try {
			this.empleado_descripcion=empleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  sethobby_descripcion(String hobby_descripcion) {
		try {
			this.hobby_descripcion=hobby_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empleado_descripcion="";String id_hobby_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_hobby_descripcion() {
		return id_hobby_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_empleado_descripcion(String newid_empleado_descripcion)throws Exception {
		try {
			this.id_empleado_descripcion=newid_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_hobby_descripcion(String newid_hobby_descripcion)throws Exception {
		try {
			this.id_hobby_descripcion=newid_hobby_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empleado_descripcion="";this.id_hobby_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

