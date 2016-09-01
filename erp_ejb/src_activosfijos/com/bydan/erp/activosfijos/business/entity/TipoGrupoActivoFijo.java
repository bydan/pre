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
//import com.bydan.erp.activosfijos.util.TipoGrupoActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class TipoGrupoActivoFijo extends GeneralEntitySinIdGenerated implements Serializable ,Cloneable {//TipoGrupoActivoFijoAdditional,GeneralEntity
	private static final long serialVersionUID=1L;
	
	public Object clone() {
        return super.clone();
    }
	
	protected Long id;
	protected Long idOriginal;
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
	
	public Long getIdOriginal() {
		return this.idOriginal;
	}
	
	public void setIdOriginal(Long newIdOriginal) {		
		this.idOriginal=newIdOriginal;
		super.setIdOriginal(newIdOriginal);
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
	
	private TipoGrupoActivoFijo tipogrupoactivofijoOriginal;
	
	private Map<String, Object> mapTipoGrupoActivoFijo;
			
	public Map<String, Object> getMapTipoGrupoActivoFijo() {
		return mapTipoGrupoActivoFijo;
	}

	public void setMapTipoGrupoActivoFijo(Map<String, Object> mapTipoGrupoActivoFijo) {
		this.mapTipoGrupoActivoFijo = mapTipoGrupoActivoFijo;
	}
	
	public void inicializarMapTipoGrupoActivoFijo() {
		this.mapTipoGrupoActivoFijo = new HashMap<String,Object>();
	}
	
	public void setMapTipoGrupoActivoFijoValue(String sKey,Object oValue) {
		this.mapTipoGrupoActivoFijo.put(sKey, oValue);
	}
	
	public Object getMapTipoGrupoActivoFijoValue(String sKey) {
		return this.mapTipoGrupoActivoFijo.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoGrupoActivoFijoConstantesFunciones.SREGEXNOMBRE,message=TipoGrupoActivoFijoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	public Pais pais;
	
	
	private String pais_descripcion;
	
	
		
	public TipoGrupoActivoFijo () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipogrupoactivofijoOriginal=this;
		
 		this.id_pais=-1L;
 		this.nombre="";
		
		
		this.pais=null;
		
		
		this.pais_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoGrupoActivoFijo (Long id,Date versionRow,Long id_pais,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipogrupoactivofijoOriginal=this;
		
 		this.id_pais=id_pais;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoGrupoActivoFijo (Long id_pais,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipogrupoactivofijoOriginal=this;
		
 		this.id_pais=id_pais;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoGrupoActivoFijo tipogrupoactivofijoLocal=null;
		
		if(object!=null) {
			tipogrupoactivofijoLocal=(TipoGrupoActivoFijo)object;
			
			if(tipogrupoactivofijoLocal!=null) {
				if(this.getId()!=null && tipogrupoactivofijoLocal.getId()!=null) {
					if(this.getId().equals(tipogrupoactivofijoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoGrupoActivoFijoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoGrupoActivoFijoConstantesFunciones.getTipoGrupoActivoFijoDescripcion(this);
		} else {
			sDetalle=TipoGrupoActivoFijoConstantesFunciones.getTipoGrupoActivoFijoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoGrupoActivoFijo getTipoGrupoActivoFijoOriginal() {
		return this.tipogrupoactivofijoOriginal;
	}
	
	public void setTipoGrupoActivoFijoOriginal(TipoGrupoActivoFijo tipogrupoactivofijo) {
		try {
			this.tipogrupoactivofijoOriginal=tipogrupoactivofijo;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
	
    
	public void setid_pais(Long newid_pais)throws Exception
	{
		try {
			if(this.id_pais!=newid_pais) {
				if(newid_pais==null) {
					//newid_pais=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoGrupoActivoFijo:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
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
						System.out.println("TipoGrupoActivoFijo:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("TipoGrupoActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Pais getPais() {
		return this.pais;
	}

	
	
	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	
	
	public  void  setPais(Pais pais) {
		try {
			this.pais=pais;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setpais_descripcion(String pais_descripcion) {
		try {
			this.pais_descripcion=pais_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_pais_descripcion="";
	
	
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	
	
	public void setid_pais_descripcion(String newid_pais_descripcion)throws Exception {
		try {
			this.id_pais_descripcion=newid_pais_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_pais_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

