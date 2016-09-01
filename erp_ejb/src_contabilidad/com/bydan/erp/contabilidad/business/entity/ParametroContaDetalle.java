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
//import com.bydan.erp.contabilidad.util.ParametroContaDetalleConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;









@SuppressWarnings("unused")
public class ParametroContaDetalle extends ParametroContaDetalleAdditional implements Serializable ,Cloneable {//ParametroContaDetalleAdditional,GeneralEntity
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
	
	private ParametroContaDetalle parametrocontadetalleOriginal;
	
	private Map<String, Object> mapParametroContaDetalle;
			
	public Map<String, Object> getMapParametroContaDetalle() {
		return mapParametroContaDetalle;
	}

	public void setMapParametroContaDetalle(Map<String, Object> mapParametroContaDetalle) {
		this.mapParametroContaDetalle = mapParametroContaDetalle;
	}
	
	public void inicializarMapParametroContaDetalle() {
		this.mapParametroContaDetalle = new HashMap<String,Object>();
	}
	
	public void setMapParametroContaDetalleValue(String sKey,Object oValue) {
		this.mapParametroContaDetalle.put(sKey, oValue);
	}
	
	public Object getMapParametroContaDetalleValue(String sKey) {
		return this.mapParametroContaDetalle.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_parametro_conta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_parametro_conta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
			
	
	public ParametroConta parametroconta;
	public TipoParametroConta tipoparametroconta;
	public CuentaContable cuentacontable;
	
	
	private String parametroconta_descripcion;
	private String tipoparametroconta_descripcion;
	private String cuentacontable_descripcion;
	
	
		
	public ParametroContaDetalle () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametrocontadetalleOriginal=this;
		
 		this.id_parametro_conta=-1L;
 		this.id_tipo_parametro_conta=-1L;
 		this.id_cuenta_contable=-1L;
		
		
		this.parametroconta=null;
		this.tipoparametroconta=null;
		this.cuentacontable=null;
		
		
		this.parametroconta_descripcion="";
		this.tipoparametroconta_descripcion="";
		this.cuentacontable_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroContaDetalle (Long id,Date versionRow,Long id_parametro_conta,Long id_tipo_parametro_conta,Long id_cuenta_contable) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrocontadetalleOriginal=this;
		
 		this.id_parametro_conta=id_parametro_conta;
 		this.id_tipo_parametro_conta=id_tipo_parametro_conta;
 		this.id_cuenta_contable=id_cuenta_contable;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroContaDetalle (Long id_parametro_conta,Long id_tipo_parametro_conta,Long id_cuenta_contable) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrocontadetalleOriginal=this;
		
 		this.id_parametro_conta=id_parametro_conta;
 		this.id_tipo_parametro_conta=id_tipo_parametro_conta;
 		this.id_cuenta_contable=id_cuenta_contable;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroContaDetalle parametrocontadetalleLocal=null;
		
		if(object!=null) {
			parametrocontadetalleLocal=(ParametroContaDetalle)object;
			
			if(parametrocontadetalleLocal!=null) {
				if(this.getId()!=null && parametrocontadetalleLocal.getId()!=null) {
					if(this.getId().equals(parametrocontadetalleLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroContaDetalleConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroContaDetalleConstantesFunciones.getParametroContaDetalleDescripcion(this);
		} else {
			sDetalle=ParametroContaDetalleConstantesFunciones.getParametroContaDetalleDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroContaDetalle getParametroContaDetalleOriginal() {
		return this.parametrocontadetalleOriginal;
	}
	
	public void setParametroContaDetalleOriginal(ParametroContaDetalle parametrocontadetalle) {
		try {
			this.parametrocontadetalleOriginal=parametrocontadetalle;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroContaDetalleAdditional parametrocontadetalleAdditional=null;
	
	public ParametroContaDetalleAdditional getParametroContaDetalleAdditional() {
		return this.parametrocontadetalleAdditional;
	}
	
	public void setParametroContaDetalleAdditional(ParametroContaDetalleAdditional parametrocontadetalleAdditional) {
		try {
			this.parametrocontadetalleAdditional=parametrocontadetalleAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_parametro_conta() {
		return this.id_parametro_conta;
	}
    
	
	public Long getid_tipo_parametro_conta() {
		return this.id_tipo_parametro_conta;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
	
    
	public void setid_parametro_conta(Long newid_parametro_conta)throws Exception
	{
		try {
			if(this.id_parametro_conta!=newid_parametro_conta) {
				if(newid_parametro_conta==null) {
					//newid_parametro_conta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroContaDetalle:Valor nulo no permitido en columna id_parametro_conta");
					}
				}

				this.id_parametro_conta=newid_parametro_conta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_parametro_conta(Long newid_tipo_parametro_conta)throws Exception
	{
		try {
			if(this.id_tipo_parametro_conta!=newid_tipo_parametro_conta) {
				if(newid_tipo_parametro_conta==null) {
					//newid_tipo_parametro_conta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroContaDetalle:Valor nulo no permitido en columna id_tipo_parametro_conta");
					}
				}

				this.id_tipo_parametro_conta=newid_tipo_parametro_conta;
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
						System.out.println("ParametroContaDetalle:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public ParametroConta getParametroConta() {
		return this.parametroconta;
	}

	public TipoParametroConta getTipoParametroConta() {
		return this.tipoparametroconta;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	
	
	public String getparametroconta_descripcion() {
		return this.parametroconta_descripcion;
	}

	public String gettipoparametroconta_descripcion() {
		return this.tipoparametroconta_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	
	
	public  void  setParametroConta(ParametroConta parametroconta) {
		try {
			this.parametroconta=parametroconta;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoParametroConta(TipoParametroConta tipoparametroconta) {
		try {
			this.tipoparametroconta=tipoparametroconta;
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


	
	
	public  void  setparametroconta_descripcion(String parametroconta_descripcion) {
		try {
			this.parametroconta_descripcion=parametroconta_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoparametroconta_descripcion(String tipoparametroconta_descripcion) {
		try {
			this.tipoparametroconta_descripcion=tipoparametroconta_descripcion;
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
	String id_parametro_conta_descripcion="";String id_tipo_parametro_conta_descripcion="";String id_cuenta_contable_descripcion="";
	
	
	public String getid_parametro_conta_descripcion() {
		return id_parametro_conta_descripcion;
	}
	public String getid_tipo_parametro_conta_descripcion() {
		return id_tipo_parametro_conta_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	
	
	public void setid_parametro_conta_descripcion(String newid_parametro_conta_descripcion)throws Exception {
		try {
			this.id_parametro_conta_descripcion=newid_parametro_conta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_parametro_conta_descripcion(String newid_tipo_parametro_conta_descripcion)throws Exception {
		try {
			this.id_tipo_parametro_conta_descripcion=newid_tipo_parametro_conta_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_parametro_conta_descripcion="";this.id_tipo_parametro_conta_descripcion="";this.id_cuenta_contable_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

