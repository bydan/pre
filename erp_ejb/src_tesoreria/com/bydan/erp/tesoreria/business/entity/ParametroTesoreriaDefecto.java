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
package com.bydan.erp.tesoreria.business.entity;

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
//import com.bydan.erp.tesoreria.util.ParametroTesoreriaDefectoConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ParametroTesoreriaDefecto extends ParametroTesoreriaDefectoAdditional implements Serializable ,Cloneable {//ParametroTesoreriaDefectoAdditional,GeneralEntity
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
	
	private ParametroTesoreriaDefecto parametrotesoreriadefectoOriginal;
	
	private Map<String, Object> mapParametroTesoreriaDefecto;
			
	public Map<String, Object> getMapParametroTesoreriaDefecto() {
		return mapParametroTesoreriaDefecto;
	}

	public void setMapParametroTesoreriaDefecto(Map<String, Object> mapParametroTesoreriaDefecto) {
		this.mapParametroTesoreriaDefecto = mapParametroTesoreriaDefecto;
	}
	
	public void inicializarMapParametroTesoreriaDefecto() {
		this.mapParametroTesoreriaDefecto = new HashMap<String,Object>();
	}
	
	public void setMapParametroTesoreriaDefectoValue(String sKey,Object oValue) {
		this.mapParametroTesoreriaDefecto.put(sKey, oValue);
	}
	
	public Object getMapParametroTesoreriaDefectoValue(String sKey) {
		return this.mapParametroTesoreriaDefecto.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_cuenta_banco_global;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public TipoCuentaBancoGlobal tipocuentabancoglobal;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String tipocuentabancoglobal_descripcion;
	
	
		
	public ParametroTesoreriaDefecto () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametrotesoreriadefectoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_tipo_cuenta_banco_global=-1L;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.tipocuentabancoglobal=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.tipocuentabancoglobal_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroTesoreriaDefecto (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_tipo_cuenta_banco_global) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrotesoreriadefectoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_tipo_cuenta_banco_global=id_tipo_cuenta_banco_global;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroTesoreriaDefecto (Long id_empresa,Long id_sucursal,Long id_tipo_cuenta_banco_global) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrotesoreriadefectoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_tipo_cuenta_banco_global=id_tipo_cuenta_banco_global;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroTesoreriaDefecto parametrotesoreriadefectoLocal=null;
		
		if(object!=null) {
			parametrotesoreriadefectoLocal=(ParametroTesoreriaDefecto)object;
			
			if(parametrotesoreriadefectoLocal!=null) {
				if(this.getId()!=null && parametrotesoreriadefectoLocal.getId()!=null) {
					if(this.getId().equals(parametrotesoreriadefectoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroTesoreriaDefectoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroTesoreriaDefectoConstantesFunciones.getParametroTesoreriaDefectoDescripcion(this);
		} else {
			sDetalle=ParametroTesoreriaDefectoConstantesFunciones.getParametroTesoreriaDefectoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroTesoreriaDefecto getParametroTesoreriaDefectoOriginal() {
		return this.parametrotesoreriadefectoOriginal;
	}
	
	public void setParametroTesoreriaDefectoOriginal(ParametroTesoreriaDefecto parametrotesoreriadefecto) {
		try {
			this.parametrotesoreriadefectoOriginal=parametrotesoreriadefecto;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroTesoreriaDefectoAdditional parametrotesoreriadefectoAdditional=null;
	
	public ParametroTesoreriaDefectoAdditional getParametroTesoreriaDefectoAdditional() {
		return this.parametrotesoreriadefectoAdditional;
	}
	
	public void setParametroTesoreriaDefectoAdditional(ParametroTesoreriaDefectoAdditional parametrotesoreriadefectoAdditional) {
		try {
			this.parametrotesoreriadefectoAdditional=parametrotesoreriadefectoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_tipo_cuenta_banco_global() {
		return this.id_tipo_cuenta_banco_global;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroTesoreriaDefecto:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal(Long newid_sucursal)throws Exception
	{
		try {
			if(this.id_sucursal!=newid_sucursal) {
				if(newid_sucursal==null) {
					//newid_sucursal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroTesoreriaDefecto:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_cuenta_banco_global(Long newid_tipo_cuenta_banco_global)throws Exception
	{
		try {
			if(this.id_tipo_cuenta_banco_global!=newid_tipo_cuenta_banco_global) {
				if(newid_tipo_cuenta_banco_global==null) {
					//newid_tipo_cuenta_banco_global=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroTesoreriaDefecto:Valor nulo no permitido en columna id_tipo_cuenta_banco_global");
					}
				}

				this.id_tipo_cuenta_banco_global=newid_tipo_cuenta_banco_global;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public TipoCuentaBancoGlobal getTipoCuentaBancoGlobal() {
		return this.tipocuentabancoglobal;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String gettipocuentabancoglobal_descripcion() {
		return this.tipocuentabancoglobal_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoCuentaBancoGlobal(TipoCuentaBancoGlobal tipocuentabancoglobal) {
		try {
			this.tipocuentabancoglobal=tipocuentabancoglobal;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipocuentabancoglobal_descripcion(String tipocuentabancoglobal_descripcion) {
		try {
			this.tipocuentabancoglobal_descripcion=tipocuentabancoglobal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_tipo_cuenta_banco_global_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_tipo_cuenta_banco_global_descripcion() {
		return id_tipo_cuenta_banco_global_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_cuenta_banco_global_descripcion(String newid_tipo_cuenta_banco_global_descripcion)throws Exception {
		try {
			this.id_tipo_cuenta_banco_global_descripcion=newid_tipo_cuenta_banco_global_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_tipo_cuenta_banco_global_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

