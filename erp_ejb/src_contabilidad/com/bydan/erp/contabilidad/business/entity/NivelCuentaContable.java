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
//import com.bydan.erp.contabilidad.util.NivelCuentaContableConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class NivelCuentaContable extends NivelCuentaContableAdditional implements Serializable ,Cloneable {//NivelCuentaContableAdditional,GeneralEntity
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
	
	private NivelCuentaContable nivelcuentacontableOriginal;
	
	private Map<String, Object> mapNivelCuentaContable;
			
	public Map<String, Object> getMapNivelCuentaContable() {
		return mapNivelCuentaContable;
	}

	public void setMapNivelCuentaContable(Map<String, Object> mapNivelCuentaContable) {
		this.mapNivelCuentaContable = mapNivelCuentaContable;
	}
	
	public void inicializarMapNivelCuentaContable() {
		this.mapNivelCuentaContable = new HashMap<String,Object>();
	}
	
	public void setMapNivelCuentaContableValue(String sKey,Object oValue) {
		this.mapNivelCuentaContable.put(sKey, oValue);
	}
	
	public Object getMapNivelCuentaContableValue(String sKey) {
		return this.mapNivelCuentaContable.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer nivel;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_digitos;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public NivelCuentaContable () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.nivelcuentacontableOriginal=this;
		
 		this.id_empresa=-1L;
 		this.nivel=0;
 		this.numero_digitos=0;
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public NivelCuentaContable (Long id,Date versionRow,Long id_empresa,Integer nivel,Integer numero_digitos) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.nivelcuentacontableOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nivel=nivel;
 		this.numero_digitos=numero_digitos;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public NivelCuentaContable (Long id_empresa,Integer nivel,Integer numero_digitos) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.nivelcuentacontableOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nivel=nivel;
 		this.numero_digitos=numero_digitos;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		NivelCuentaContable nivelcuentacontableLocal=null;
		
		if(object!=null) {
			nivelcuentacontableLocal=(NivelCuentaContable)object;
			
			if(nivelcuentacontableLocal!=null) {
				if(this.getId()!=null && nivelcuentacontableLocal.getId()!=null) {
					if(this.getId().equals(nivelcuentacontableLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!NivelCuentaContableConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=NivelCuentaContableConstantesFunciones.getNivelCuentaContableDescripcion(this);
		} else {
			sDetalle=NivelCuentaContableConstantesFunciones.getNivelCuentaContableDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public NivelCuentaContable getNivelCuentaContableOriginal() {
		return this.nivelcuentacontableOriginal;
	}
	
	public void setNivelCuentaContableOriginal(NivelCuentaContable nivelcuentacontable) {
		try {
			this.nivelcuentacontableOriginal=nivelcuentacontable;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected NivelCuentaContableAdditional nivelcuentacontableAdditional=null;
	
	public NivelCuentaContableAdditional getNivelCuentaContableAdditional() {
		return this.nivelcuentacontableAdditional;
	}
	
	public void setNivelCuentaContableAdditional(NivelCuentaContableAdditional nivelcuentacontableAdditional) {
		try {
			this.nivelcuentacontableAdditional=nivelcuentacontableAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Integer getnivel() {
		return this.nivel;
	}
    
	
	public Integer getnumero_digitos() {
		return this.numero_digitos;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NivelCuentaContable:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnivel(Integer newnivel)throws Exception
	{
		try {
			if(this.nivel!=newnivel) {
				if(newnivel==null) {
					//newnivel=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NivelCuentaContable:Valor nulo no permitido en columna nivel");
					}
				}

				this.nivel=newnivel;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_digitos(Integer newnumero_digitos)throws Exception
	{
		try {
			if(this.numero_digitos!=newnumero_digitos) {
				if(newnumero_digitos==null) {
					//newnumero_digitos=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NivelCuentaContable:Valor nulo no permitido en columna numero_digitos");
					}
				}

				this.numero_digitos=newnumero_digitos;
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
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

