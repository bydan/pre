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
package com.bydan.erp.contabilidad.business.entity.report;

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
//import com.bydan.erp.contabilidad.util.ProcesoCierrePeriodoConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class ProcesoCierrePeriodo extends ProcesoCierrePeriodoAdditional implements Serializable ,Cloneable {//ProcesoCierrePeriodoAdditional,GeneralEntity
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
	
	private ProcesoCierrePeriodo procesocierreperiodoOriginal;
	
	private Map<String, Object> mapProcesoCierrePeriodo;
			
	public Map<String, Object> getMapProcesoCierrePeriodo() {
		return mapProcesoCierrePeriodo;
	}

	public void setMapProcesoCierrePeriodo(Map<String, Object> mapProcesoCierrePeriodo) {
		this.mapProcesoCierrePeriodo = mapProcesoCierrePeriodo;
	}
	
	public void inicializarMapProcesoCierrePeriodo() {
		this.mapProcesoCierrePeriodo = new HashMap<String,Object>();
	}
	
	public void setMapProcesoCierrePeriodoValue(String sKey,Object oValue) {
		this.mapProcesoCierrePeriodo.put(sKey, oValue);
	}
	
	public Object getMapProcesoCierrePeriodoValue(String sKey) {
		return this.mapProcesoCierrePeriodo.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_periodo;
			
	
	public Ejercicio ejercicio;
	public Periodo periodo;
	public EstadoPeriodo estadoperiodo;
	
	
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String estadoperiodo_descripcion;
	
	
		
	public ProcesoCierrePeriodo () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.procesocierreperiodoOriginal=this;
		
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_estado_periodo=-1L;
		
		
		this.ejercicio=null;
		this.periodo=null;
		this.estadoperiodo=null;
		
		
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.estadoperiodo_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	
	public ProcesoCierrePeriodo getProcesoCierrePeriodoOriginal() {
		return this.procesocierreperiodoOriginal;
	}
	
	public void setProcesoCierrePeriodoOriginal(ProcesoCierrePeriodo procesocierreperiodo) {
		try {
			this.procesocierreperiodoOriginal=procesocierreperiodo;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProcesoCierrePeriodoAdditional procesocierreperiodoAdditional=null;
	
	public ProcesoCierrePeriodoAdditional getProcesoCierrePeriodoAdditional() {
		return this.procesocierreperiodoAdditional;
	}
	
	public void setProcesoCierrePeriodoAdditional(ProcesoCierrePeriodoAdditional procesocierreperiodoAdditional) {
		try {
			this.procesocierreperiodoAdditional=procesocierreperiodoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public Long getid_estado_periodo() {
		return this.id_estado_periodo;
	}
	
    
	public void setid_ejercicio(Long newid_ejercicio)throws Exception
	{
		try {
			if(this.id_ejercicio!=newid_ejercicio) {
				if(newid_ejercicio==null) {
					//newid_ejercicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoCierrePeriodo:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_periodo(Long newid_periodo)throws Exception
	{
		try {
			if(this.id_periodo!=newid_periodo) {
				if(newid_periodo==null) {
					//newid_periodo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoCierrePeriodo:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_periodo(Long newid_estado_periodo)throws Exception
	{
		try {
			if(this.id_estado_periodo!=newid_estado_periodo) {
				if(newid_estado_periodo==null) {
					//newid_estado_periodo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoCierrePeriodo:Valor nulo no permitido en columna id_estado_periodo");
					}
				}

				this.id_estado_periodo=newid_estado_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public EstadoPeriodo getEstadoPeriodo() {
		return this.estadoperiodo;
	}

	
	
	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
	}

	public String getestadoperiodo_descripcion() {
		return this.estadoperiodo_descripcion;
	}

	
	
	public  void  setEjercicio(Ejercicio ejercicio) {
		try {
			this.ejercicio=ejercicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPeriodo(Periodo periodo) {
		try {
			this.periodo=periodo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoPeriodo(EstadoPeriodo estadoperiodo) {
		try {
			this.estadoperiodo=estadoperiodo;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setejercicio_descripcion(String ejercicio_descripcion) {
		try {
			this.ejercicio_descripcion=ejercicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setperiodo_descripcion(String periodo_descripcion) {
		try {
			this.periodo_descripcion=periodo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadoperiodo_descripcion(String estadoperiodo_descripcion) {
		try {
			this.estadoperiodo_descripcion=estadoperiodo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_estado_periodo_descripcion="";
	
	
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	public String getid_estado_periodo_descripcion() {
		return id_estado_periodo_descripcion;
	}
	
	
	public void setid_ejercicio_descripcion(String newid_ejercicio_descripcion)throws Exception {
		try {
			this.id_ejercicio_descripcion=newid_ejercicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_periodo_descripcion(String newid_periodo_descripcion)throws Exception {
		try {
			this.id_periodo_descripcion=newid_periodo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_periodo_descripcion(String newid_estado_periodo_descripcion)throws Exception {
		try {
			this.id_estado_periodo_descripcion=newid_estado_periodo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_estado_periodo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

