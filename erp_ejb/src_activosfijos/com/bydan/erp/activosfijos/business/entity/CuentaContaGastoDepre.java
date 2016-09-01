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
//import com.bydan.erp.activosfijos.util.CuentaContaGastoDepreConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class CuentaContaGastoDepre extends CuentaContaGastoDepreAdditional implements Serializable ,Cloneable {//CuentaContaGastoDepreAdditional,GeneralEntity
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
	
	private CuentaContaGastoDepre cuentacontagastodepreOriginal;
	
	private Map<String, Object> mapCuentaContaGastoDepre;
			
	public Map<String, Object> getMapCuentaContaGastoDepre() {
		return mapCuentaContaGastoDepre;
	}

	public void setMapCuentaContaGastoDepre(Map<String, Object> mapCuentaContaGastoDepre) {
		this.mapCuentaContaGastoDepre = mapCuentaContaGastoDepre;
	}
	
	public void inicializarMapCuentaContaGastoDepre() {
		this.mapCuentaContaGastoDepre = new HashMap<String,Object>();
	}
	
	public void setMapCuentaContaGastoDepreValue(String sKey,Object oValue) {
		this.mapCuentaContaGastoDepre.put(sKey, oValue);
	}
	
	public Object getMapCuentaContaGastoDepreValue(String sKey) {
		return this.mapCuentaContaGastoDepre.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_gasto_depreciacion;
			
	
	public CuentaContable cuentacontable;
	public GastoDepreciacion gastodepreciacion;
	
	
	private String cuentacontable_descripcion;
	private String gastodepreciacion_descripcion;
	
	
		
	public CuentaContaGastoDepre () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cuentacontagastodepreOriginal=this;
		
 		this.id_cuenta_contable=-1L;
 		this.id_gasto_depreciacion=-1L;
		
		
		this.cuentacontable=null;
		this.gastodepreciacion=null;
		
		
		this.cuentacontable_descripcion="";
		this.gastodepreciacion_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CuentaContaGastoDepre (Long id,Date versionRow,Long id_cuenta_contable,Long id_gasto_depreciacion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cuentacontagastodepreOriginal=this;
		
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_gasto_depreciacion=id_gasto_depreciacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CuentaContaGastoDepre (Long id_cuenta_contable,Long id_gasto_depreciacion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cuentacontagastodepreOriginal=this;
		
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_gasto_depreciacion=id_gasto_depreciacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		CuentaContaGastoDepre cuentacontagastodepreLocal=null;
		
		if(object!=null) {
			cuentacontagastodepreLocal=(CuentaContaGastoDepre)object;
			
			if(cuentacontagastodepreLocal!=null) {
				if(this.getId()!=null && cuentacontagastodepreLocal.getId()!=null) {
					if(this.getId().equals(cuentacontagastodepreLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CuentaContaGastoDepreConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CuentaContaGastoDepreConstantesFunciones.getCuentaContaGastoDepreDescripcion(this);
		} else {
			sDetalle=CuentaContaGastoDepreConstantesFunciones.getCuentaContaGastoDepreDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public CuentaContaGastoDepre getCuentaContaGastoDepreOriginal() {
		return this.cuentacontagastodepreOriginal;
	}
	
	public void setCuentaContaGastoDepreOriginal(CuentaContaGastoDepre cuentacontagastodepre) {
		try {
			this.cuentacontagastodepreOriginal=cuentacontagastodepre;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CuentaContaGastoDepreAdditional cuentacontagastodepreAdditional=null;
	
	public CuentaContaGastoDepreAdditional getCuentaContaGastoDepreAdditional() {
		return this.cuentacontagastodepreAdditional;
	}
	
	public void setCuentaContaGastoDepreAdditional(CuentaContaGastoDepreAdditional cuentacontagastodepreAdditional) {
		try {
			this.cuentacontagastodepreAdditional=cuentacontagastodepreAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Long getid_gasto_depreciacion() {
		return this.id_gasto_depreciacion;
	}
	
    
	public void setid_cuenta_contable(Long newid_cuenta_contable)throws Exception
	{
		try {
			if(this.id_cuenta_contable!=newid_cuenta_contable) {
				if(newid_cuenta_contable==null) {
					//newid_cuenta_contable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaContaGastoDepre:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_gasto_depreciacion(Long newid_gasto_depreciacion)throws Exception
	{
		try {
			if(this.id_gasto_depreciacion!=newid_gasto_depreciacion) {
				if(newid_gasto_depreciacion==null) {
					//newid_gasto_depreciacion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaContaGastoDepre:Valor nulo no permitido en columna id_gasto_depreciacion");
					}
				}

				this.id_gasto_depreciacion=newid_gasto_depreciacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	public GastoDepreciacion getGastoDepreciacion() {
		return this.gastodepreciacion;
	}

	
	
	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	public String getgastodepreciacion_descripcion() {
		return this.gastodepreciacion_descripcion;
	}

	
	
	public  void  setCuentaContable(CuentaContable cuentacontable) {
		try {
			this.cuentacontable=cuentacontable;
		} catch(Exception e) {
			;
		}
	}


	public  void  setGastoDepreciacion(GastoDepreciacion gastodepreciacion) {
		try {
			this.gastodepreciacion=gastodepreciacion;
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


	public  void  setgastodepreciacion_descripcion(String gastodepreciacion_descripcion) {
		try {
			this.gastodepreciacion_descripcion=gastodepreciacion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_cuenta_contable_descripcion="";String id_gasto_depreciacion_descripcion="";
	
	
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	public String getid_gasto_depreciacion_descripcion() {
		return id_gasto_depreciacion_descripcion;
	}
	
	
	public void setid_cuenta_contable_descripcion(String newid_cuenta_contable_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_descripcion=newid_cuenta_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_gasto_depreciacion_descripcion(String newid_gasto_depreciacion_descripcion)throws Exception {
		try {
			this.id_gasto_depreciacion_descripcion=newid_gasto_depreciacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_cuenta_contable_descripcion="";this.id_gasto_depreciacion_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

