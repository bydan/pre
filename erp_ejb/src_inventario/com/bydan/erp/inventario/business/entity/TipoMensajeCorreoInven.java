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
package com.bydan.erp.inventario.business.entity;

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
//import com.bydan.erp.inventario.util.TipoMensajeCorreoInvenConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class TipoMensajeCorreoInven extends GeneralEntity implements Serializable ,Cloneable {//TipoMensajeCorreoInvenAdditional,GeneralEntity
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
	
	private TipoMensajeCorreoInven tipomensajecorreoinvenOriginal;
	
	private Map<String, Object> mapTipoMensajeCorreoInven;
			
	public Map<String, Object> getMapTipoMensajeCorreoInven() {
		return mapTipoMensajeCorreoInven;
	}

	public void setMapTipoMensajeCorreoInven(Map<String, Object> mapTipoMensajeCorreoInven) {
		this.mapTipoMensajeCorreoInven = mapTipoMensajeCorreoInven;
	}
	
	public void inicializarMapTipoMensajeCorreoInven() {
		this.mapTipoMensajeCorreoInven = new HashMap<String,Object>();
	}
	
	public void setMapTipoMensajeCorreoInvenValue(String sKey,Object oValue) {
		this.mapTipoMensajeCorreoInven.put(sKey, oValue);
	}
	
	public Object getMapTipoMensajeCorreoInvenValue(String sKey) {
		return this.mapTipoMensajeCorreoInven.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoMensajeCorreoInvenConstantesFunciones.SREGEXCODIGO,message=TipoMensajeCorreoInvenConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoMensajeCorreoInvenConstantesFunciones.SREGEXNOMBRE,message=TipoMensajeCorreoInvenConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	public Modulo modulo;
	
	
	private String modulo_descripcion;
	
	
		
	public TipoMensajeCorreoInven () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipomensajecorreoinvenOriginal=this;
		
 		this.id_modulo=-1L;
 		this.codigo="";
 		this.nombre="";
		
		
		this.modulo=null;
		
		
		this.modulo_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoMensajeCorreoInven (Long id,Date versionRow,Long id_modulo,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipomensajecorreoinvenOriginal=this;
		
 		this.id_modulo=id_modulo;
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoMensajeCorreoInven (Long id_modulo,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipomensajecorreoinvenOriginal=this;
		
 		this.id_modulo=id_modulo;
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoMensajeCorreoInven tipomensajecorreoinvenLocal=null;
		
		if(object!=null) {
			tipomensajecorreoinvenLocal=(TipoMensajeCorreoInven)object;
			
			if(tipomensajecorreoinvenLocal!=null) {
				if(this.getId()!=null && tipomensajecorreoinvenLocal.getId()!=null) {
					if(this.getId().equals(tipomensajecorreoinvenLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoMensajeCorreoInvenConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoMensajeCorreoInvenConstantesFunciones.getTipoMensajeCorreoInvenDescripcion(this);
		} else {
			sDetalle=TipoMensajeCorreoInvenConstantesFunciones.getTipoMensajeCorreoInvenDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoMensajeCorreoInven getTipoMensajeCorreoInvenOriginal() {
		return this.tipomensajecorreoinvenOriginal;
	}
	
	public void setTipoMensajeCorreoInvenOriginal(TipoMensajeCorreoInven tipomensajecorreoinven) {
		try {
			this.tipomensajecorreoinvenOriginal=tipomensajecorreoinven;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
	
    
	public void setid_modulo(Long newid_modulo)throws Exception
	{
		try {
			if(this.id_modulo!=newid_modulo) {
				if(newid_modulo==null) {
					//newid_modulo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoMensajeCorreoInven:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoMensajeCorreoInven:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("TipoMensajeCorreoInven:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoMensajeCorreoInven:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("TipoMensajeCorreoInven:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Modulo getModulo() {
		return this.modulo;
	}

	
	
	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	
	
	public  void  setModulo(Modulo modulo) {
		try {
			this.modulo=modulo;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setmodulo_descripcion(String modulo_descripcion) {
		try {
			this.modulo_descripcion=modulo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_modulo_descripcion="";
	
	
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	
	
	public void setid_modulo_descripcion(String newid_modulo_descripcion)throws Exception {
		try {
			this.id_modulo_descripcion=newid_modulo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_modulo_descripcion="";
	}
	
	
	Object mensajecorreoinvensDescripcionReporte;
	
	
	public Object getmensajecorreoinvensDescripcionReporte() {
		return mensajecorreoinvensDescripcionReporte;
	}

	
	
	public  void  setmensajecorreoinvensDescripcionReporte(Object mensajecorreoinvens) {
		try {
			this.mensajecorreoinvensDescripcionReporte=mensajecorreoinvens;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

