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
package com.bydan.erp.comisiones.business.entity;

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
//import com.bydan.erp.comisiones.util.ComisionPenaConstantesFunciones;
import com.bydan.erp.comisiones.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ComisionPena extends ComisionPenaAdditional implements Serializable ,Cloneable {//ComisionPenaAdditional,GeneralEntity
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
	
	private ComisionPena comisionpenaOriginal;
	
	private Map<String, Object> mapComisionPena;
			
	public Map<String, Object> getMapComisionPena() {
		return mapComisionPena;
	}

	public void setMapComisionPena(Map<String, Object> mapComisionPena) {
		this.mapComisionPena = mapComisionPena;
	}
	
	public void inicializarMapComisionPena() {
		this.mapComisionPena = new HashMap<String,Object>();
	}
	
	public void setMapComisionPenaValue(String sKey,Object oValue) {
		this.mapComisionPena.put(sKey, oValue);
	}
	
	public Object getMapComisionPenaValue(String sKey) {
		return this.mapComisionPena.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_comision_config;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer num_dias_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer num_dias_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ComisionPenaConstantesFunciones.SREGEXDESCRIPCION,message=ComisionPenaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public ComisionConfig comisionconfig;
	
	
	private String empresa_descripcion;
	private String comisionconfig_descripcion;
	
	
		
	public ComisionPena () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.comisionpenaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_comision_config=-1L;
 		this.num_dias_inicio=0;
 		this.num_dias_fin=0;
 		this.porcentaje=0.0;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.comisionconfig=null;
		
		
		this.empresa_descripcion="";
		this.comisionconfig_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ComisionPena (Long id,Date versionRow,Long id_empresa,Long id_comision_config,Integer num_dias_inicio,Integer num_dias_fin,Double porcentaje,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.comisionpenaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_comision_config=id_comision_config;
 		this.num_dias_inicio=num_dias_inicio;
 		this.num_dias_fin=num_dias_fin;
 		this.porcentaje=porcentaje;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ComisionPena (Long id_empresa,Long id_comision_config,Integer num_dias_inicio,Integer num_dias_fin,Double porcentaje,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.comisionpenaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_comision_config=id_comision_config;
 		this.num_dias_inicio=num_dias_inicio;
 		this.num_dias_fin=num_dias_fin;
 		this.porcentaje=porcentaje;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ComisionPena comisionpenaLocal=null;
		
		if(object!=null) {
			comisionpenaLocal=(ComisionPena)object;
			
			if(comisionpenaLocal!=null) {
				if(this.getId()!=null && comisionpenaLocal.getId()!=null) {
					if(this.getId().equals(comisionpenaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ComisionPenaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ComisionPenaConstantesFunciones.getComisionPenaDescripcion(this);
		} else {
			sDetalle=ComisionPenaConstantesFunciones.getComisionPenaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ComisionPena getComisionPenaOriginal() {
		return this.comisionpenaOriginal;
	}
	
	public void setComisionPenaOriginal(ComisionPena comisionpena) {
		try {
			this.comisionpenaOriginal=comisionpena;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ComisionPenaAdditional comisionpenaAdditional=null;
	
	public ComisionPenaAdditional getComisionPenaAdditional() {
		return this.comisionpenaAdditional;
	}
	
	public void setComisionPenaAdditional(ComisionPenaAdditional comisionpenaAdditional) {
		try {
			this.comisionpenaAdditional=comisionpenaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_comision_config() {
		return this.id_comision_config;
	}
    
	
	public Integer getnum_dias_inicio() {
		return this.num_dias_inicio;
	}
    
	
	public Integer getnum_dias_fin() {
		return this.num_dias_fin;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionPena:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_comision_config(Long newid_comision_config)throws Exception
	{
		try {
			if(this.id_comision_config!=newid_comision_config) {
				if(newid_comision_config==null) {
					//newid_comision_config=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionPena:Valor nulo no permitido en columna id_comision_config");
					}
				}

				this.id_comision_config=newid_comision_config;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnum_dias_inicio(Integer newnum_dias_inicio)throws Exception
	{
		try {
			if(this.num_dias_inicio!=newnum_dias_inicio) {
				if(newnum_dias_inicio==null) {
					//newnum_dias_inicio=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionPena:Valor nulo no permitido en columna num_dias_inicio");
					}
				}

				this.num_dias_inicio=newnum_dias_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnum_dias_fin(Integer newnum_dias_fin)throws Exception
	{
		try {
			if(this.num_dias_fin!=newnum_dias_fin) {
				if(newnum_dias_fin==null) {
					//newnum_dias_fin=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionPena:Valor nulo no permitido en columna num_dias_fin");
					}
				}

				this.num_dias_fin=newnum_dias_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje(Double newporcentaje)throws Exception
	{
		try {
			if(this.porcentaje!=newporcentaje) {
				if(newporcentaje==null) {
					//newporcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionPena:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescripcion(String newdescripcion)throws Exception
	{
		try {
			if(this.descripcion!=newdescripcion) {
				if(newdescripcion==null) {
					//newdescripcion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionPena:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>100) {
					newdescripcion=newdescripcion.substring(0,98);
					System.out.println("ComisionPena:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public ComisionConfig getComisionConfig() {
		return this.comisionconfig;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcomisionconfig_descripcion() {
		return this.comisionconfig_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setComisionConfig(ComisionConfig comisionconfig) {
		try {
			this.comisionconfig=comisionconfig;
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


	public  void  setcomisionconfig_descripcion(String comisionconfig_descripcion) {
		try {
			this.comisionconfig_descripcion=comisionconfig_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_comision_config_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_comision_config_descripcion() {
		return id_comision_config_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_comision_config_descripcion(String newid_comision_config_descripcion)throws Exception {
		try {
			this.id_comision_config_descripcion=newid_comision_config_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_comision_config_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

