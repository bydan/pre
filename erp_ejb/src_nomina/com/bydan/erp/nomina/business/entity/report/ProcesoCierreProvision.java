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
package com.bydan.erp.nomina.business.entity.report;

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
//import com.bydan.erp.nomina.util.ProcesoCierreProvisionConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;

import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class ProcesoCierreProvision extends ProcesoCierreProvisionAdditional implements Serializable ,Cloneable {//ProcesoCierreProvisionAdditional,GeneralEntity
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
	
	private ProcesoCierreProvision procesocierreprovisionOriginal;
	
	private Map<String, Object> mapProcesoCierreProvision;
			
	public Map<String, Object> getMapProcesoCierreProvision() {
		return mapProcesoCierreProvision;
	}

	public void setMapProcesoCierreProvision(Map<String, Object> mapProcesoCierreProvision) {
		this.mapProcesoCierreProvision = mapProcesoCierreProvision;
	}
	
	public void inicializarMapProcesoCierreProvision() {
		this.mapProcesoCierreProvision = new HashMap<String,Object>();
	}
	
	public void setMapProcesoCierreProvisionValue(String sKey,Object oValue) {
		this.mapProcesoCierreProvision.put(sKey, oValue);
	}
	
	public Object getMapProcesoCierreProvisionValue(String sKey) {
		return this.mapProcesoCierreProvision.get(sKey);
	}
	
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_defi_provision_empleado;
			
	
	public Anio anio;
	public Estructura estructura;
	public Empleado empleado;
	public DefiProvisionEmpleado defiprovisionempleado;
	
	
	private String anio_descripcion;
	private String estructura_descripcion;
	private String empleado_descripcion;
	private String defiprovisionempleado_descripcion;
	
	
		
	public ProcesoCierreProvision () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.procesocierreprovisionOriginal=this;
		
 		this.id_anio=null;
 		this.id_estructura=-1L;
 		this.id_empleado=-1L;
 		this.id_defi_provision_empleado=-1L;
		
		
		this.anio=null;
		this.estructura=null;
		this.empleado=null;
		this.defiprovisionempleado=null;
		
		
		this.anio_descripcion="";
		this.estructura_descripcion="";
		this.empleado_descripcion="";
		this.defiprovisionempleado_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	
	public ProcesoCierreProvision getProcesoCierreProvisionOriginal() {
		return this.procesocierreprovisionOriginal;
	}
	
	public void setProcesoCierreProvisionOriginal(ProcesoCierreProvision procesocierreprovision) {
		try {
			this.procesocierreprovisionOriginal=procesocierreprovision;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProcesoCierreProvisionAdditional procesocierreprovisionAdditional=null;
	
	public ProcesoCierreProvisionAdditional getProcesoCierreProvisionAdditional() {
		return this.procesocierreprovisionAdditional;
	}
	
	public void setProcesoCierreProvisionAdditional(ProcesoCierreProvisionAdditional procesocierreprovisionAdditional) {
		try {
			this.procesocierreprovisionAdditional=procesocierreprovisionAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_estructura() {
		return this.id_estructura;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_defi_provision_empleado() {
		return this.id_defi_provision_empleado;
	}
	
    
	public void setid_anio(Long newid_anio) {
		if(this.id_anio==null&&newid_anio!=null) {
			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}

		if(this.id_anio!=null&&!this.id_anio.equals(newid_anio)) {

			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}
	}
    
	public void setid_estructura(Long newid_estructura)throws Exception
	{
		try {
			if(this.id_estructura!=newid_estructura) {
				if(newid_estructura==null) {
					//newid_estructura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoCierreProvision:Valor nulo no permitido en columna id_estructura");
					}
				}

				this.id_estructura=newid_estructura;
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
						System.out.println("ProcesoCierreProvision:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_defi_provision_empleado(Long newid_defi_provision_empleado)throws Exception
	{
		try {
			if(this.id_defi_provision_empleado!=newid_defi_provision_empleado) {
				if(newid_defi_provision_empleado==null) {
					//newid_defi_provision_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoCierreProvision:Valor nulo no permitido en columna id_defi_provision_empleado");
					}
				}

				this.id_defi_provision_empleado=newid_defi_provision_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Anio getAnio() {
		return this.anio;
	}

	public Estructura getEstructura() {
		return this.estructura;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public DefiProvisionEmpleado getDefiProvisionEmpleado() {
		return this.defiprovisionempleado;
	}

	
	
	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getestructura_descripcion() {
		return this.estructura_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getdefiprovisionempleado_descripcion() {
		return this.defiprovisionempleado_descripcion;
	}

	
	
	public  void  setAnio(Anio anio) {
		try {
			this.anio=anio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstructura(Estructura estructura) {
		try {
			this.estructura=estructura;
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


	public  void  setDefiProvisionEmpleado(DefiProvisionEmpleado defiprovisionempleado) {
		try {
			this.defiprovisionempleado=defiprovisionempleado;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setanio_descripcion(String anio_descripcion) {
		try {
			this.anio_descripcion=anio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestructura_descripcion(String estructura_descripcion) {
		try {
			this.estructura_descripcion=estructura_descripcion;
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


	public  void  setdefiprovisionempleado_descripcion(String defiprovisionempleado_descripcion) {
		try {
			this.defiprovisionempleado_descripcion=defiprovisionempleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_anio_descripcion="";String id_estructura_descripcion="";String id_empleado_descripcion="";String id_defi_provision_empleado_descripcion="";
	
	
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_estructura_descripcion() {
		return id_estructura_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_defi_provision_empleado_descripcion() {
		return id_defi_provision_empleado_descripcion;
	}
	
	
	public void setid_anio_descripcion(String newid_anio_descripcion)throws Exception {
		try {
			this.id_anio_descripcion=newid_anio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estructura_descripcion(String newid_estructura_descripcion)throws Exception {
		try {
			this.id_estructura_descripcion=newid_estructura_descripcion;
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
	public void setid_defi_provision_empleado_descripcion(String newid_defi_provision_empleado_descripcion)throws Exception {
		try {
			this.id_defi_provision_empleado_descripcion=newid_defi_provision_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_anio_descripcion="";this.id_estructura_descripcion="";this.id_empleado_descripcion="";this.id_defi_provision_empleado_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

