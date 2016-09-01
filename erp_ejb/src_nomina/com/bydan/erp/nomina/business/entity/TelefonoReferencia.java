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
//import com.bydan.erp.nomina.util.TelefonoReferenciaConstantesFunciones;
import com.bydan.erp.nomina.util.*;









@SuppressWarnings("unused")
public class TelefonoReferencia extends TelefonoReferenciaAdditional implements Serializable ,Cloneable {//TelefonoReferenciaAdditional,GeneralEntity
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
	
	private TelefonoReferencia telefonoreferenciaOriginal;
	
	private Map<String, Object> mapTelefonoReferencia;
			
	public Map<String, Object> getMapTelefonoReferencia() {
		return mapTelefonoReferencia;
	}

	public void setMapTelefonoReferencia(Map<String, Object> mapTelefonoReferencia) {
		this.mapTelefonoReferencia = mapTelefonoReferencia;
	}
	
	public void inicializarMapTelefonoReferencia() {
		this.mapTelefonoReferencia = new HashMap<String,Object>();
	}
	
	public void setMapTelefonoReferenciaValue(String sKey,Object oValue) {
		this.mapTelefonoReferencia.put(sKey, oValue);
	}
	
	public Object getMapTelefonoReferenciaValue(String sKey) {
		return this.mapTelefonoReferencia.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_referencia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TelefonoReferenciaConstantesFunciones.SREGEXNUMERO,message=TelefonoReferenciaConstantesFunciones.SMENSAJEREGEXNUMERO)
	private String numero;
			
	
	public Referencia referencia;
	
	
	private String referencia_descripcion;
	
	
		
	public TelefonoReferencia () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.telefonoreferenciaOriginal=this;
		
 		this.id_referencia=-1L;
 		this.numero="";
		
		
		this.referencia=null;
		
		
		this.referencia_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TelefonoReferencia (Long id,Date versionRow,Long id_referencia,String numero) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.telefonoreferenciaOriginal=this;
		
 		this.id_referencia=id_referencia;
 		this.numero=numero;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TelefonoReferencia (Long id_referencia,String numero) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.telefonoreferenciaOriginal=this;
		
 		this.id_referencia=id_referencia;
 		this.numero=numero;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TelefonoReferencia telefonoreferenciaLocal=null;
		
		if(object!=null) {
			telefonoreferenciaLocal=(TelefonoReferencia)object;
			
			if(telefonoreferenciaLocal!=null) {
				if(this.getId()!=null && telefonoreferenciaLocal.getId()!=null) {
					if(this.getId().equals(telefonoreferenciaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TelefonoReferenciaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TelefonoReferenciaConstantesFunciones.getTelefonoReferenciaDescripcion(this);
		} else {
			sDetalle=TelefonoReferenciaConstantesFunciones.getTelefonoReferenciaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TelefonoReferencia getTelefonoReferenciaOriginal() {
		return this.telefonoreferenciaOriginal;
	}
	
	public void setTelefonoReferenciaOriginal(TelefonoReferencia telefonoreferencia) {
		try {
			this.telefonoreferenciaOriginal=telefonoreferencia;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TelefonoReferenciaAdditional telefonoreferenciaAdditional=null;
	
	public TelefonoReferenciaAdditional getTelefonoReferenciaAdditional() {
		return this.telefonoreferenciaAdditional;
	}
	
	public void setTelefonoReferenciaAdditional(TelefonoReferenciaAdditional telefonoreferenciaAdditional) {
		try {
			this.telefonoreferenciaAdditional=telefonoreferenciaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_referencia() {
		return this.id_referencia;
	}
    
	
	public String getnumero() {
		return this.numero;
	}
	
    
	public void setid_referencia(Long newid_referencia)throws Exception
	{
		try {
			if(this.id_referencia!=newid_referencia) {
				if(newid_referencia==null) {
					//newid_referencia=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TelefonoReferencia:Valor nulo no permitido en columna id_referencia");
					}
				}

				this.id_referencia=newid_referencia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero(String newnumero)throws Exception
	{
		try {
			if(this.numero!=newnumero) {
				if(newnumero==null) {
					//newnumero="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TelefonoReferencia:Valor nulo no permitido en columna numero");
					}
				}

				if(newnumero!=null&&newnumero.length()>50) {
					newnumero=newnumero.substring(0,48);
					System.out.println("TelefonoReferencia:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero");
				}

				this.numero=newnumero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Referencia getReferencia() {
		return this.referencia;
	}

	
	
	public String getreferencia_descripcion() {
		return this.referencia_descripcion;
	}

	
	
	public  void  setReferencia(Referencia referencia) {
		try {
			this.referencia=referencia;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setreferencia_descripcion(String referencia_descripcion) {
		try {
			this.referencia_descripcion=referencia_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_referencia_descripcion="";
	
	
	public String getid_referencia_descripcion() {
		return id_referencia_descripcion;
	}
	
	
	public void setid_referencia_descripcion(String newid_referencia_descripcion)throws Exception {
		try {
			this.id_referencia_descripcion=newid_referencia_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_referencia_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

