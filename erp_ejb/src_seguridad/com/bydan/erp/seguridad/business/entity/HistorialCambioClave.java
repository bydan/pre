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
package com.bydan.erp.seguridad.business.entity;

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


import java.sql.Timestamp;

import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesValidacion;
//import com.bydan.erp.seguridad.util.HistorialCambioClaveConstantesFunciones;
import com.bydan.erp.seguridad.util.*;









@SuppressWarnings("unused")
public class HistorialCambioClave extends HistorialCambioClaveAdditional implements Serializable ,Cloneable {//HistorialCambioClaveAdditional,GeneralEntity
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
	
	private HistorialCambioClave historialcambioclaveOriginal;
	
	private Map<String, Object> mapHistorialCambioClave;
			
	public Map<String, Object> getMapHistorialCambioClave() {
		return mapHistorialCambioClave;
	}

	public void setMapHistorialCambioClave(Map<String, Object> mapHistorialCambioClave) {
		this.mapHistorialCambioClave = mapHistorialCambioClave;
	}
	
	public void inicializarMapHistorialCambioClave() {
		this.mapHistorialCambioClave = new HashMap<String,Object>();
	}
	
	public void setMapHistorialCambioClaveValue(String sKey,Object oValue) {
		this.mapHistorialCambioClave.put(sKey, oValue);
	}
	
	public Object getMapHistorialCambioClaveValue(String sKey) {
		return this.mapHistorialCambioClave.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=HistorialCambioClaveConstantesFunciones.SREGEXNOMBRE,message=HistorialCambioClaveConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Timestamp fecha_hora;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=HistorialCambioClaveConstantesFunciones.SREGEXOBSERVACION,message=HistorialCambioClaveConstantesFunciones.SMENSAJEREGEXOBSERVACION)
	private String observacion;
			
	
	public Usuario usuario;
	
	
	private String usuario_descripcion;
	
	
		
	public HistorialCambioClave () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.historialcambioclaveOriginal=this;
		
 		this.id_usuario=-1L;
 		this.nombre="";
 		this.fecha_hora=new Timestamp((new Date()).getTime());
 		this.observacion="";
		
		
		this.usuario=null;
		
		
		this.usuario_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public HistorialCambioClave (Long id,Date versionRow,Long id_usuario,String nombre,Timestamp fecha_hora,String observacion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.historialcambioclaveOriginal=this;
		
 		this.id_usuario=id_usuario;
 		this.nombre=nombre;
 		this.fecha_hora=fecha_hora;
 		this.observacion=observacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public HistorialCambioClave (Long id_usuario,String nombre,Timestamp fecha_hora,String observacion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.historialcambioclaveOriginal=this;
		
 		this.id_usuario=id_usuario;
 		this.nombre=nombre;
 		this.fecha_hora=fecha_hora;
 		this.observacion=observacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		HistorialCambioClave historialcambioclaveLocal=null;
		
		if(object!=null) {
			historialcambioclaveLocal=(HistorialCambioClave)object;
			
			if(historialcambioclaveLocal!=null) {
				if(this.getId()!=null && historialcambioclaveLocal.getId()!=null) {
					if(this.getId().equals(historialcambioclaveLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!HistorialCambioClaveConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=HistorialCambioClaveConstantesFunciones.getHistorialCambioClaveDescripcion(this);
		} else {
			sDetalle=HistorialCambioClaveConstantesFunciones.getHistorialCambioClaveDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public HistorialCambioClave getHistorialCambioClaveOriginal() {
		return this.historialcambioclaveOriginal;
	}
	
	public void setHistorialCambioClaveOriginal(HistorialCambioClave historialcambioclave) {
		try {
			this.historialcambioclaveOriginal=historialcambioclave;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected HistorialCambioClaveAdditional historialcambioclaveAdditional=null;
	
	public HistorialCambioClaveAdditional getHistorialCambioClaveAdditional() {
		return this.historialcambioclaveAdditional;
	}
	
	public void setHistorialCambioClaveAdditional(HistorialCambioClaveAdditional historialcambioclaveAdditional) {
		try {
			this.historialcambioclaveAdditional=historialcambioclaveAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_usuario() {
		return this.id_usuario;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Timestamp getfecha_hora() {
		return this.fecha_hora;
	}
    
	
	public String getobservacion() {
		return this.observacion;
	}
	
    
	public void setid_usuario(Long newid_usuario)throws Exception
	{
		try {
			if(this.id_usuario!=newid_usuario) {
				if(newid_usuario==null) {
					//newid_usuario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("HistorialCambioClave:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
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
						System.out.println("HistorialCambioClave:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("HistorialCambioClave:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_hora(Timestamp newfecha_hora)throws Exception
	{
		try {
			if(this.fecha_hora!=newfecha_hora) {
				if(newfecha_hora==null) {
					//newfecha_hora=new Timestamp((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("HistorialCambioClave:Valor nulo no permitido en columna fecha_hora");
					}
				}

				this.fecha_hora=newfecha_hora;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setobservacion(String newobservacion)throws Exception
	{
		try {
			if(this.observacion!=newobservacion) {
				if(newobservacion==null) {
					//newobservacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("HistorialCambioClave:Valor nulo no permitido en columna observacion");
					}
				}

				if(newobservacion!=null&&newobservacion.length()>150) {
					newobservacion=newobservacion.substring(0,148);
					System.out.println("HistorialCambioClave:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna observacion");
				}

				this.observacion=newobservacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	
	
	public String getusuario_descripcion() {
		return this.usuario_descripcion;
	}

	
	
	public  void  setUsuario(Usuario usuario) {
		try {
			this.usuario=usuario;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setusuario_descripcion(String usuario_descripcion) {
		try {
			this.usuario_descripcion=usuario_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_usuario_descripcion="";
	
	
	public String getid_usuario_descripcion() {
		return id_usuario_descripcion;
	}
	
	
	public void setid_usuario_descripcion(String newid_usuario_descripcion)throws Exception {
		try {
			this.id_usuario_descripcion=newid_usuario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_usuario_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

