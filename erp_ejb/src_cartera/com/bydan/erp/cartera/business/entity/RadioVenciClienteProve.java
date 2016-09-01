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
package com.bydan.erp.cartera.business.entity;

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
//import com.bydan.erp.cartera.util.RadioVenciClienteProveConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class RadioVenciClienteProve extends RadioVenciClienteProveAdditional implements Serializable ,Cloneable {//RadioVenciClienteProveAdditional,GeneralEntity
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
	
	private RadioVenciClienteProve radiovenciclienteproveOriginal;
	
	private Map<String, Object> mapRadioVenciClienteProve;
			
	public Map<String, Object> getMapRadioVenciClienteProve() {
		return mapRadioVenciClienteProve;
	}

	public void setMapRadioVenciClienteProve(Map<String, Object> mapRadioVenciClienteProve) {
		this.mapRadioVenciClienteProve = mapRadioVenciClienteProve;
	}
	
	public void inicializarMapRadioVenciClienteProve() {
		this.mapRadioVenciClienteProve = new HashMap<String,Object>();
	}
	
	public void setMapRadioVenciClienteProveValue(String sKey,Object oValue) {
		this.mapRadioVenciClienteProve.put(sKey, oValue);
	}
	
	public Object getMapRadioVenciClienteProveValue(String sKey) {
		return this.mapRadioVenciClienteProve.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_radio_venci;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer dia_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer dia_hasta;
			
	
	public Empresa empresa;
	public TipoRadioVenci tiporadiovenci;
	
	
	private String empresa_descripcion;
	private String tiporadiovenci_descripcion;
	
	
		
	public RadioVenciClienteProve () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.radiovenciclienteproveOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_tipo_radio_venci=-1L;
 		this.dia_desde=0;
 		this.dia_hasta=0;
		
		
		this.empresa=null;
		this.tiporadiovenci=null;
		
		
		this.empresa_descripcion="";
		this.tiporadiovenci_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public RadioVenciClienteProve (Long id,Date versionRow,Long id_empresa,Long id_tipo_radio_venci,Integer dia_desde,Integer dia_hasta) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.radiovenciclienteproveOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_radio_venci=id_tipo_radio_venci;
 		this.dia_desde=dia_desde;
 		this.dia_hasta=dia_hasta;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public RadioVenciClienteProve (Long id_empresa,Long id_tipo_radio_venci,Integer dia_desde,Integer dia_hasta) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.radiovenciclienteproveOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_radio_venci=id_tipo_radio_venci;
 		this.dia_desde=dia_desde;
 		this.dia_hasta=dia_hasta;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		RadioVenciClienteProve radiovenciclienteproveLocal=null;
		
		if(object!=null) {
			radiovenciclienteproveLocal=(RadioVenciClienteProve)object;
			
			if(radiovenciclienteproveLocal!=null) {
				if(this.getId()!=null && radiovenciclienteproveLocal.getId()!=null) {
					if(this.getId().equals(radiovenciclienteproveLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!RadioVenciClienteProveConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=RadioVenciClienteProveConstantesFunciones.getRadioVenciClienteProveDescripcion(this);
		} else {
			sDetalle=RadioVenciClienteProveConstantesFunciones.getRadioVenciClienteProveDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public RadioVenciClienteProve getRadioVenciClienteProveOriginal() {
		return this.radiovenciclienteproveOriginal;
	}
	
	public void setRadioVenciClienteProveOriginal(RadioVenciClienteProve radiovenciclienteprove) {
		try {
			this.radiovenciclienteproveOriginal=radiovenciclienteprove;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected RadioVenciClienteProveAdditional radiovenciclienteproveAdditional=null;
	
	public RadioVenciClienteProveAdditional getRadioVenciClienteProveAdditional() {
		return this.radiovenciclienteproveAdditional;
	}
	
	public void setRadioVenciClienteProveAdditional(RadioVenciClienteProveAdditional radiovenciclienteproveAdditional) {
		try {
			this.radiovenciclienteproveAdditional=radiovenciclienteproveAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_tipo_radio_venci() {
		return this.id_tipo_radio_venci;
	}
    
	
	public Integer getdia_desde() {
		return this.dia_desde;
	}
    
	
	public Integer getdia_hasta() {
		return this.dia_hasta;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RadioVenciClienteProve:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_radio_venci(Long newid_tipo_radio_venci)throws Exception
	{
		try {
			if(this.id_tipo_radio_venci!=newid_tipo_radio_venci) {
				if(newid_tipo_radio_venci==null) {
					//newid_tipo_radio_venci=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RadioVenciClienteProve:Valor nulo no permitido en columna id_tipo_radio_venci");
					}
				}

				this.id_tipo_radio_venci=newid_tipo_radio_venci;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdia_desde(Integer newdia_desde)throws Exception
	{
		try {
			if(this.dia_desde!=newdia_desde) {
				if(newdia_desde==null) {
					//newdia_desde=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RadioVenciClienteProve:Valor nulo no permitido en columna dia_desde");
					}
				}

				this.dia_desde=newdia_desde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdia_hasta(Integer newdia_hasta)throws Exception
	{
		try {
			if(this.dia_hasta!=newdia_hasta) {
				if(newdia_hasta==null) {
					//newdia_hasta=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RadioVenciClienteProve:Valor nulo no permitido en columna dia_hasta");
					}
				}

				this.dia_hasta=newdia_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public TipoRadioVenci getTipoRadioVenci() {
		return this.tiporadiovenci;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettiporadiovenci_descripcion() {
		return this.tiporadiovenci_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRadioVenci(TipoRadioVenci tiporadiovenci) {
		try {
			this.tiporadiovenci=tiporadiovenci;
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


	public  void  settiporadiovenci_descripcion(String tiporadiovenci_descripcion) {
		try {
			this.tiporadiovenci_descripcion=tiporadiovenci_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_tipo_radio_venci_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_radio_venci_descripcion() {
		return id_tipo_radio_venci_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_radio_venci_descripcion(String newid_tipo_radio_venci_descripcion)throws Exception {
		try {
			this.id_tipo_radio_venci_descripcion=newid_tipo_radio_venci_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_radio_venci_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

