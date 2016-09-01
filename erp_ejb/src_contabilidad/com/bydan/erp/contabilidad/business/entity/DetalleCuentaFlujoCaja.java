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
package com.bydan.erp.contabilidad.business.entity;

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
//import com.bydan.erp.contabilidad.util.DetalleCuentaFlujoCajaConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class DetalleCuentaFlujoCaja extends DetalleCuentaFlujoCajaAdditional implements Serializable ,Cloneable {//DetalleCuentaFlujoCajaAdditional,GeneralEntity
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
	
	private DetalleCuentaFlujoCaja detallecuentaflujocajaOriginal;
	
	private Map<String, Object> mapDetalleCuentaFlujoCaja;
			
	public Map<String, Object> getMapDetalleCuentaFlujoCaja() {
		return mapDetalleCuentaFlujoCaja;
	}

	public void setMapDetalleCuentaFlujoCaja(Map<String, Object> mapDetalleCuentaFlujoCaja) {
		this.mapDetalleCuentaFlujoCaja = mapDetalleCuentaFlujoCaja;
	}
	
	public void inicializarMapDetalleCuentaFlujoCaja() {
		this.mapDetalleCuentaFlujoCaja = new HashMap<String,Object>();
	}
	
	public void setMapDetalleCuentaFlujoCajaValue(String sKey,Object oValue) {
		this.mapDetalleCuentaFlujoCaja.put(sKey, oValue);
	}
	
	public Object getMapDetalleCuentaFlujoCajaValue(String sKey) {
		return this.mapDetalleCuentaFlujoCaja.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_operacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_flujo_caja;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esta_activo;
			
	
	public TipoOperacion tipooperacion;
	public CuentaFlujoCaja cuentaflujocaja;
	public CuentaContable cuentacontable;
	
	
	private String tipooperacion_descripcion;
	private String cuentaflujocaja_descripcion;
	private String cuentacontable_descripcion;
	
	
		
	public DetalleCuentaFlujoCaja () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detallecuentaflujocajaOriginal=this;
		
 		this.id_tipo_operacion=-1L;
 		this.id_cuenta_flujo_caja=-1L;
 		this.id_cuenta_contable=-1L;
 		this.esta_activo=false;
		
		
		this.tipooperacion=null;
		this.cuentaflujocaja=null;
		this.cuentacontable=null;
		
		
		this.tipooperacion_descripcion="";
		this.cuentaflujocaja_descripcion="";
		this.cuentacontable_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetalleCuentaFlujoCaja (Long id,Date versionRow,Long id_tipo_operacion,Long id_cuenta_flujo_caja,Long id_cuenta_contable,Boolean esta_activo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detallecuentaflujocajaOriginal=this;
		
 		this.id_tipo_operacion=id_tipo_operacion;
 		this.id_cuenta_flujo_caja=id_cuenta_flujo_caja;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.esta_activo=esta_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetalleCuentaFlujoCaja (Long id_tipo_operacion,Long id_cuenta_flujo_caja,Long id_cuenta_contable,Boolean esta_activo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detallecuentaflujocajaOriginal=this;
		
 		this.id_tipo_operacion=id_tipo_operacion;
 		this.id_cuenta_flujo_caja=id_cuenta_flujo_caja;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.esta_activo=esta_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetalleCuentaFlujoCaja detallecuentaflujocajaLocal=null;
		
		if(object!=null) {
			detallecuentaflujocajaLocal=(DetalleCuentaFlujoCaja)object;
			
			if(detallecuentaflujocajaLocal!=null) {
				if(this.getId()!=null && detallecuentaflujocajaLocal.getId()!=null) {
					if(this.getId().equals(detallecuentaflujocajaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetalleCuentaFlujoCajaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetalleCuentaFlujoCajaConstantesFunciones.getDetalleCuentaFlujoCajaDescripcion(this);
		} else {
			sDetalle=DetalleCuentaFlujoCajaConstantesFunciones.getDetalleCuentaFlujoCajaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetalleCuentaFlujoCaja getDetalleCuentaFlujoCajaOriginal() {
		return this.detallecuentaflujocajaOriginal;
	}
	
	public void setDetalleCuentaFlujoCajaOriginal(DetalleCuentaFlujoCaja detallecuentaflujocaja) {
		try {
			this.detallecuentaflujocajaOriginal=detallecuentaflujocaja;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetalleCuentaFlujoCajaAdditional detallecuentaflujocajaAdditional=null;
	
	public DetalleCuentaFlujoCajaAdditional getDetalleCuentaFlujoCajaAdditional() {
		return this.detallecuentaflujocajaAdditional;
	}
	
	public void setDetalleCuentaFlujoCajaAdditional(DetalleCuentaFlujoCajaAdditional detallecuentaflujocajaAdditional) {
		try {
			this.detallecuentaflujocajaAdditional=detallecuentaflujocajaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_tipo_operacion() {
		return this.id_tipo_operacion;
	}
    
	
	public Long getid_cuenta_flujo_caja() {
		return this.id_cuenta_flujo_caja;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Boolean getesta_activo() {
		return this.esta_activo;
	}
	
    
	public void setid_tipo_operacion(Long newid_tipo_operacion)throws Exception
	{
		try {
			if(this.id_tipo_operacion!=newid_tipo_operacion) {
				if(newid_tipo_operacion==null) {
					//newid_tipo_operacion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleCuentaFlujoCaja:Valor nulo no permitido en columna id_tipo_operacion");
					}
				}

				this.id_tipo_operacion=newid_tipo_operacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_flujo_caja(Long newid_cuenta_flujo_caja)throws Exception
	{
		try {
			if(this.id_cuenta_flujo_caja!=newid_cuenta_flujo_caja) {
				if(newid_cuenta_flujo_caja==null) {
					//newid_cuenta_flujo_caja=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleCuentaFlujoCaja:Valor nulo no permitido en columna id_cuenta_flujo_caja");
					}
				}

				this.id_cuenta_flujo_caja=newid_cuenta_flujo_caja;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable(Long newid_cuenta_contable)throws Exception
	{
		try {
			if(this.id_cuenta_contable!=newid_cuenta_contable) {
				if(newid_cuenta_contable==null) {
					//newid_cuenta_contable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleCuentaFlujoCaja:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setesta_activo(Boolean newesta_activo)throws Exception
	{
		try {
			if(this.esta_activo!=newesta_activo) {
				if(newesta_activo==null) {
					//newesta_activo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleCuentaFlujoCaja:Valor nulo no permitido en columna esta_activo");
					}
				}

				this.esta_activo=newesta_activo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public TipoOperacion getTipoOperacion() {
		return this.tipooperacion;
	}

	public CuentaFlujoCaja getCuentaFlujoCaja() {
		return this.cuentaflujocaja;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	
	
	public String gettipooperacion_descripcion() {
		return this.tipooperacion_descripcion;
	}

	public String getcuentaflujocaja_descripcion() {
		return this.cuentaflujocaja_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	
	
	public  void  setTipoOperacion(TipoOperacion tipooperacion) {
		try {
			this.tipooperacion=tipooperacion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaFlujoCaja(CuentaFlujoCaja cuentaflujocaja) {
		try {
			this.cuentaflujocaja=cuentaflujocaja;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContable(CuentaContable cuentacontable) {
		try {
			this.cuentacontable=cuentacontable;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  settipooperacion_descripcion(String tipooperacion_descripcion) {
		try {
			this.tipooperacion_descripcion=tipooperacion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentaflujocaja_descripcion(String cuentaflujocaja_descripcion) {
		try {
			this.cuentaflujocaja_descripcion=cuentaflujocaja_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_tipo_operacion_descripcion="";String id_cuenta_flujo_caja_descripcion="";String id_cuenta_contable_descripcion="";String esta_activo_descripcion="";
	
	
	public String getid_tipo_operacion_descripcion() {
		return id_tipo_operacion_descripcion;
	}
	public String getid_cuenta_flujo_caja_descripcion() {
		return id_cuenta_flujo_caja_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	public String getesta_activo_descripcion() {
		return esta_activo_descripcion;
	}
	
	
	public void setid_tipo_operacion_descripcion(String newid_tipo_operacion_descripcion)throws Exception {
		try {
			this.id_tipo_operacion_descripcion=newid_tipo_operacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_flujo_caja_descripcion(String newid_cuenta_flujo_caja_descripcion)throws Exception {
		try {
			this.id_cuenta_flujo_caja_descripcion=newid_cuenta_flujo_caja_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_descripcion(String newid_cuenta_contable_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_descripcion=newid_cuenta_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setesta_activo_descripcion(String newesta_activo_descripcion)throws Exception {
		try {
			this.esta_activo_descripcion=newesta_activo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_tipo_operacion_descripcion="";this.id_cuenta_flujo_caja_descripcion="";this.id_cuenta_contable_descripcion="";this.esta_activo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

