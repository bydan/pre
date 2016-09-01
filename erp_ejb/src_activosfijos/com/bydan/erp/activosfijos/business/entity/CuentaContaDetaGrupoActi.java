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
//import com.bydan.erp.activosfijos.util.CuentaContaDetaGrupoActiConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class CuentaContaDetaGrupoActi extends CuentaContaDetaGrupoActiAdditional implements Serializable ,Cloneable {//CuentaContaDetaGrupoActiAdditional,GeneralEntity
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
	
	private CuentaContaDetaGrupoActi cuentacontadetagrupoactiOriginal;
	
	private Map<String, Object> mapCuentaContaDetaGrupoActi;
			
	public Map<String, Object> getMapCuentaContaDetaGrupoActi() {
		return mapCuentaContaDetaGrupoActi;
	}

	public void setMapCuentaContaDetaGrupoActi(Map<String, Object> mapCuentaContaDetaGrupoActi) {
		this.mapCuentaContaDetaGrupoActi = mapCuentaContaDetaGrupoActi;
	}
	
	public void inicializarMapCuentaContaDetaGrupoActi() {
		this.mapCuentaContaDetaGrupoActi = new HashMap<String,Object>();
	}
	
	public void setMapCuentaContaDetaGrupoActiValue(String sKey,Object oValue) {
		this.mapCuentaContaDetaGrupoActi.put(sKey, oValue);
	}
	
	public Object getMapCuentaContaDetaGrupoActiValue(String sKey) {
		return this.mapCuentaContaDetaGrupoActi.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_detalle_grupo_activo_fijo;
			
	
	public CuentaContable cuentacontable;
	public DetalleGrupoActivoFijo detallegrupoactivofijo;
	
	
	private String cuentacontable_descripcion;
	private String detallegrupoactivofijo_descripcion;
	
	
		
	public CuentaContaDetaGrupoActi () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cuentacontadetagrupoactiOriginal=this;
		
 		this.id_cuenta_contable=-1L;
 		this.id_detalle_grupo_activo_fijo=-1L;
		
		
		this.cuentacontable=null;
		this.detallegrupoactivofijo=null;
		
		
		this.cuentacontable_descripcion="";
		this.detallegrupoactivofijo_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CuentaContaDetaGrupoActi (Long id,Date versionRow,Long id_cuenta_contable,Long id_detalle_grupo_activo_fijo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cuentacontadetagrupoactiOriginal=this;
		
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_detalle_grupo_activo_fijo=id_detalle_grupo_activo_fijo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CuentaContaDetaGrupoActi (Long id_cuenta_contable,Long id_detalle_grupo_activo_fijo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cuentacontadetagrupoactiOriginal=this;
		
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_detalle_grupo_activo_fijo=id_detalle_grupo_activo_fijo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		CuentaContaDetaGrupoActi cuentacontadetagrupoactiLocal=null;
		
		if(object!=null) {
			cuentacontadetagrupoactiLocal=(CuentaContaDetaGrupoActi)object;
			
			if(cuentacontadetagrupoactiLocal!=null) {
				if(this.getId()!=null && cuentacontadetagrupoactiLocal.getId()!=null) {
					if(this.getId().equals(cuentacontadetagrupoactiLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CuentaContaDetaGrupoActiConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CuentaContaDetaGrupoActiConstantesFunciones.getCuentaContaDetaGrupoActiDescripcion(this);
		} else {
			sDetalle=CuentaContaDetaGrupoActiConstantesFunciones.getCuentaContaDetaGrupoActiDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public CuentaContaDetaGrupoActi getCuentaContaDetaGrupoActiOriginal() {
		return this.cuentacontadetagrupoactiOriginal;
	}
	
	public void setCuentaContaDetaGrupoActiOriginal(CuentaContaDetaGrupoActi cuentacontadetagrupoacti) {
		try {
			this.cuentacontadetagrupoactiOriginal=cuentacontadetagrupoacti;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CuentaContaDetaGrupoActiAdditional cuentacontadetagrupoactiAdditional=null;
	
	public CuentaContaDetaGrupoActiAdditional getCuentaContaDetaGrupoActiAdditional() {
		return this.cuentacontadetagrupoactiAdditional;
	}
	
	public void setCuentaContaDetaGrupoActiAdditional(CuentaContaDetaGrupoActiAdditional cuentacontadetagrupoactiAdditional) {
		try {
			this.cuentacontadetagrupoactiAdditional=cuentacontadetagrupoactiAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Long getid_detalle_grupo_activo_fijo() {
		return this.id_detalle_grupo_activo_fijo;
	}
	
    
	public void setid_cuenta_contable(Long newid_cuenta_contable)throws Exception
	{
		try {
			if(this.id_cuenta_contable!=newid_cuenta_contable) {
				if(newid_cuenta_contable==null) {
					//newid_cuenta_contable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaContaDetaGrupoActi:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_detalle_grupo_activo_fijo(Long newid_detalle_grupo_activo_fijo)throws Exception
	{
		try {
			if(this.id_detalle_grupo_activo_fijo!=newid_detalle_grupo_activo_fijo) {
				if(newid_detalle_grupo_activo_fijo==null) {
					//newid_detalle_grupo_activo_fijo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaContaDetaGrupoActi:Valor nulo no permitido en columna id_detalle_grupo_activo_fijo");
					}
				}

				this.id_detalle_grupo_activo_fijo=newid_detalle_grupo_activo_fijo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	public DetalleGrupoActivoFijo getDetalleGrupoActivoFijo() {
		return this.detallegrupoactivofijo;
	}

	
	
	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	public String getdetallegrupoactivofijo_descripcion() {
		return this.detallegrupoactivofijo_descripcion;
	}

	
	
	public  void  setCuentaContable(CuentaContable cuentacontable) {
		try {
			this.cuentacontable=cuentacontable;
		} catch(Exception e) {
			;
		}
	}


	public  void  setDetalleGrupoActivoFijo(DetalleGrupoActivoFijo detallegrupoactivofijo) {
		try {
			this.detallegrupoactivofijo=detallegrupoactivofijo;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setcuentacontable_descripcion(String cuentacontable_descripcion) {
		try {
			this.cuentacontable_descripcion=cuentacontable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setdetallegrupoactivofijo_descripcion(String detallegrupoactivofijo_descripcion) {
		try {
			this.detallegrupoactivofijo_descripcion=detallegrupoactivofijo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_cuenta_contable_descripcion="";String id_detalle_grupo_activo_fijo_descripcion="";
	
	
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	public String getid_detalle_grupo_activo_fijo_descripcion() {
		return id_detalle_grupo_activo_fijo_descripcion;
	}
	
	
	public void setid_cuenta_contable_descripcion(String newid_cuenta_contable_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_descripcion=newid_cuenta_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_detalle_grupo_activo_fijo_descripcion(String newid_detalle_grupo_activo_fijo_descripcion)throws Exception {
		try {
			this.id_detalle_grupo_activo_fijo_descripcion=newid_detalle_grupo_activo_fijo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_cuenta_contable_descripcion="";this.id_detalle_grupo_activo_fijo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

