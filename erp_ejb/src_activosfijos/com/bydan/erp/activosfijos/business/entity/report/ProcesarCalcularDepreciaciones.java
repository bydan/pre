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
package com.bydan.erp.activosfijos.business.entity.report;

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
//import com.bydan.erp.activosfijos.util.ProcesarCalcularDepreciacionesConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.activosfijos.util.*;

import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;




@SuppressWarnings("unused")
public class ProcesarCalcularDepreciaciones extends ProcesarCalcularDepreciacionesAdditional implements Serializable ,Cloneable {//ProcesarCalcularDepreciacionesAdditional,GeneralEntity
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
	
	private ProcesarCalcularDepreciaciones procesarcalculardepreciacionesOriginal;
	
	private Map<String, Object> mapProcesarCalcularDepreciaciones;
			
	public Map<String, Object> getMapProcesarCalcularDepreciaciones() {
		return mapProcesarCalcularDepreciaciones;
	}

	public void setMapProcesarCalcularDepreciaciones(Map<String, Object> mapProcesarCalcularDepreciaciones) {
		this.mapProcesarCalcularDepreciaciones = mapProcesarCalcularDepreciaciones;
	}
	
	public void inicializarMapProcesarCalcularDepreciaciones() {
		this.mapProcesarCalcularDepreciaciones = new HashMap<String,Object>();
	}
	
	public void setMapProcesarCalcularDepreciacionesValue(String sKey,Object oValue) {
		this.mapProcesarCalcularDepreciaciones.put(sKey, oValue);
	}
	
	public Object getMapProcesarCalcularDepreciacionesValue(String sKey) {
		return this.mapProcesarCalcularDepreciaciones.get(sKey);
	}
	
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_detalle_grupo_activo_fijo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sub_grupo_activo_fijo;
			
	
	public Anio anio;
	public Mes mes;
	public DetalleGrupoActivoFijo detallegrupoactivofijo;
	public SubGrupoActivoFijo subgrupoactivofijo;
	
	
	private String anio_descripcion;
	private String mes_descripcion;
	private String detallegrupoactivofijo_descripcion;
	private String subgrupoactivofijo_descripcion;
	
	
		
	public ProcesarCalcularDepreciaciones () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.procesarcalculardepreciacionesOriginal=this;
		
 		this.id_anio=null;
 		this.id_mes=null;
 		this.id_detalle_grupo_activo_fijo=-1L;
 		this.id_sub_grupo_activo_fijo=-1L;
		
		
		this.anio=null;
		this.mes=null;
		this.detallegrupoactivofijo=null;
		this.subgrupoactivofijo=null;
		
		
		this.anio_descripcion="";
		this.mes_descripcion="";
		this.detallegrupoactivofijo_descripcion="";
		this.subgrupoactivofijo_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	
	public ProcesarCalcularDepreciaciones getProcesarCalcularDepreciacionesOriginal() {
		return this.procesarcalculardepreciacionesOriginal;
	}
	
	public void setProcesarCalcularDepreciacionesOriginal(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones) {
		try {
			this.procesarcalculardepreciacionesOriginal=procesarcalculardepreciaciones;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProcesarCalcularDepreciacionesAdditional procesarcalculardepreciacionesAdditional=null;
	
	public ProcesarCalcularDepreciacionesAdditional getProcesarCalcularDepreciacionesAdditional() {
		return this.procesarcalculardepreciacionesAdditional;
	}
	
	public void setProcesarCalcularDepreciacionesAdditional(ProcesarCalcularDepreciacionesAdditional procesarcalculardepreciacionesAdditional) {
		try {
			this.procesarcalculardepreciacionesAdditional=procesarcalculardepreciacionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public Long getid_detalle_grupo_activo_fijo() {
		return this.id_detalle_grupo_activo_fijo;
	}
    
	
	public Long getid_sub_grupo_activo_fijo() {
		return this.id_sub_grupo_activo_fijo;
	}
	
    
	public void setid_anio(Long newid_anio) {
		if(this.id_anio==null&&newid_anio!=null) {
			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}

		if(this.id_anio!=null&&!this.id_anio.equals(newid_anio)) {

			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}
	}
    
	public void setid_mes(Long newid_mes) {
		if(this.id_mes==null&&newid_mes!=null) {
			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}

		if(this.id_mes!=null&&!this.id_mes.equals(newid_mes)) {

			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}
	}
    
	public void setid_detalle_grupo_activo_fijo(Long newid_detalle_grupo_activo_fijo)throws Exception
	{
		try {
			if(this.id_detalle_grupo_activo_fijo!=newid_detalle_grupo_activo_fijo) {
				if(newid_detalle_grupo_activo_fijo==null) {
					//newid_detalle_grupo_activo_fijo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesarCalcularDepreciaciones:Valor nulo no permitido en columna id_detalle_grupo_activo_fijo");
					}
				}

				this.id_detalle_grupo_activo_fijo=newid_detalle_grupo_activo_fijo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sub_grupo_activo_fijo(Long newid_sub_grupo_activo_fijo)throws Exception
	{
		try {
			if(this.id_sub_grupo_activo_fijo!=newid_sub_grupo_activo_fijo) {
				if(newid_sub_grupo_activo_fijo==null) {
					//newid_sub_grupo_activo_fijo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesarCalcularDepreciaciones:Valor nulo no permitido en columna id_sub_grupo_activo_fijo");
					}
				}

				this.id_sub_grupo_activo_fijo=newid_sub_grupo_activo_fijo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	public DetalleGrupoActivoFijo getDetalleGrupoActivoFijo() {
		return this.detallegrupoactivofijo;
	}

	public SubGrupoActivoFijo getSubGrupoActivoFijo() {
		return this.subgrupoactivofijo;
	}

	
	
	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
	}

	public String getdetallegrupoactivofijo_descripcion() {
		return this.detallegrupoactivofijo_descripcion;
	}

	public String getsubgrupoactivofijo_descripcion() {
		return this.subgrupoactivofijo_descripcion;
	}

	
	
	public  void  setAnio(Anio anio) {
		try {
			this.anio=anio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMes(Mes mes) {
		try {
			this.mes=mes;
		} catch(Exception e) {
			;
		}
	}


	public  void  setDetalleGrupoActivoFijo(DetalleGrupoActivoFijo detallegrupoactivofijo) {
		try {
			this.detallegrupoactivofijo=detallegrupoactivofijo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSubGrupoActivoFijo(SubGrupoActivoFijo subgrupoactivofijo) {
		try {
			this.subgrupoactivofijo=subgrupoactivofijo;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setanio_descripcion(String anio_descripcion) {
		try {
			this.anio_descripcion=anio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmes_descripcion(String mes_descripcion) {
		try {
			this.mes_descripcion=mes_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setdetallegrupoactivofijo_descripcion(String detallegrupoactivofijo_descripcion) {
		try {
			this.detallegrupoactivofijo_descripcion=detallegrupoactivofijo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setsubgrupoactivofijo_descripcion(String subgrupoactivofijo_descripcion) {
		try {
			this.subgrupoactivofijo_descripcion=subgrupoactivofijo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_anio_descripcion="";String id_mes_descripcion="";String id_detalle_grupo_activo_fijo_descripcion="";String id_sub_grupo_activo_fijo_descripcion="";
	
	
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
	}
	public String getid_detalle_grupo_activo_fijo_descripcion() {
		return id_detalle_grupo_activo_fijo_descripcion;
	}
	public String getid_sub_grupo_activo_fijo_descripcion() {
		return id_sub_grupo_activo_fijo_descripcion;
	}
	
	
	public void setid_anio_descripcion(String newid_anio_descripcion)throws Exception {
		try {
			this.id_anio_descripcion=newid_anio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_mes_descripcion(String newid_mes_descripcion)throws Exception {
		try {
			this.id_mes_descripcion=newid_mes_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_detalle_grupo_activo_fijo_descripcion(String newid_detalle_grupo_activo_fijo_descripcion)throws Exception {
		try {
			this.id_detalle_grupo_activo_fijo_descripcion=newid_detalle_grupo_activo_fijo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sub_grupo_activo_fijo_descripcion(String newid_sub_grupo_activo_fijo_descripcion)throws Exception {
		try {
			this.id_sub_grupo_activo_fijo_descripcion=newid_sub_grupo_activo_fijo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_anio_descripcion="";this.id_mes_descripcion="";this.id_detalle_grupo_activo_fijo_descripcion="";this.id_sub_grupo_activo_fijo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

