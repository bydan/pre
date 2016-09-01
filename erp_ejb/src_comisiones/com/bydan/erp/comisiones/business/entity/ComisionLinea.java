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
//import com.bydan.erp.comisiones.util.ComisionLineaConstantesFunciones;
import com.bydan.erp.comisiones.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class ComisionLinea extends ComisionLineaAdditional implements Serializable ,Cloneable {//ComisionLineaAdditional,GeneralEntity
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
	
	private ComisionLinea comisionlineaOriginal;
	
	private Map<String, Object> mapComisionLinea;
			
	public Map<String, Object> getMapComisionLinea() {
		return mapComisionLinea;
	}

	public void setMapComisionLinea(Map<String, Object> mapComisionLinea) {
		this.mapComisionLinea = mapComisionLinea;
	}
	
	public void inicializarMapComisionLinea() {
		this.mapComisionLinea = new HashMap<String,Object>();
	}
	
	public void setMapComisionLineaValue(String sKey,Object oValue) {
		this.mapComisionLinea.put(sKey, oValue);
	}
	
	public Object getMapComisionLineaValue(String sKey) {
		return this.mapComisionLinea.get(sKey);
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
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_vendedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_comision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ComisionLineaConstantesFunciones.SREGEXDESCRIPCION,message=ComisionLineaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public ComisionConfig comisionconfig;
	public Vendedor vendedor;
	public Linea linea;
	public EstadoComision estadocomision;
	
	
	private String empresa_descripcion;
	private String comisionconfig_descripcion;
	private String vendedor_descripcion;
	private String linea_descripcion;
	private String estadocomision_descripcion;
	
	
		
	public ComisionLinea () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.comisionlineaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_comision_config=-1L;
 		this.id_vendedor=-1L;
 		this.id_linea=-1L;
 		this.id_estado_comision=-1L;
 		this.porcentaje=0.0;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.comisionconfig=null;
		this.vendedor=null;
		this.linea=null;
		this.estadocomision=null;
		
		
		this.empresa_descripcion="";
		this.comisionconfig_descripcion="";
		this.vendedor_descripcion="";
		this.linea_descripcion="";
		this.estadocomision_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ComisionLinea (Long id,Date versionRow,Long id_empresa,Long id_comision_config,Long id_vendedor,Long id_linea,Long id_estado_comision,Double porcentaje,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.comisionlineaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_comision_config=id_comision_config;
 		this.id_vendedor=id_vendedor;
 		this.id_linea=id_linea;
 		this.id_estado_comision=id_estado_comision;
 		this.porcentaje=porcentaje;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ComisionLinea (Long id_empresa,Long id_comision_config,Long id_vendedor,Long id_linea,Long id_estado_comision,Double porcentaje,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.comisionlineaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_comision_config=id_comision_config;
 		this.id_vendedor=id_vendedor;
 		this.id_linea=id_linea;
 		this.id_estado_comision=id_estado_comision;
 		this.porcentaje=porcentaje;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ComisionLinea comisionlineaLocal=null;
		
		if(object!=null) {
			comisionlineaLocal=(ComisionLinea)object;
			
			if(comisionlineaLocal!=null) {
				if(this.getId()!=null && comisionlineaLocal.getId()!=null) {
					if(this.getId().equals(comisionlineaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ComisionLineaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ComisionLineaConstantesFunciones.getComisionLineaDescripcion(this);
		} else {
			sDetalle=ComisionLineaConstantesFunciones.getComisionLineaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ComisionLinea getComisionLineaOriginal() {
		return this.comisionlineaOriginal;
	}
	
	public void setComisionLineaOriginal(ComisionLinea comisionlinea) {
		try {
			this.comisionlineaOriginal=comisionlinea;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ComisionLineaAdditional comisionlineaAdditional=null;
	
	public ComisionLineaAdditional getComisionLineaAdditional() {
		return this.comisionlineaAdditional;
	}
	
	public void setComisionLineaAdditional(ComisionLineaAdditional comisionlineaAdditional) {
		try {
			this.comisionlineaAdditional=comisionlineaAdditional;
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
    
	
	public Long getid_vendedor() {
		return this.id_vendedor;
	}
    
	
	public Long getid_linea() {
		return this.id_linea;
	}
    
	
	public Long getid_estado_comision() {
		return this.id_estado_comision;
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
						System.out.println("ComisionLinea:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ComisionLinea:Valor nulo no permitido en columna id_comision_config");
					}
				}

				this.id_comision_config=newid_comision_config;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_vendedor(Long newid_vendedor)throws Exception
	{
		try {
			if(this.id_vendedor!=newid_vendedor) {
				if(newid_vendedor==null) {
					//newid_vendedor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionLinea:Valor nulo no permitido en columna id_vendedor");
					}
				}

				this.id_vendedor=newid_vendedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_linea(Long newid_linea)throws Exception
	{
		try {
			if(this.id_linea!=newid_linea) {
				if(newid_linea==null) {
					//newid_linea=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionLinea:Valor nulo no permitido en columna id_linea");
					}
				}

				this.id_linea=newid_linea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_comision(Long newid_estado_comision)throws Exception
	{
		try {
			if(this.id_estado_comision!=newid_estado_comision) {
				if(newid_estado_comision==null) {
					//newid_estado_comision=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionLinea:Valor nulo no permitido en columna id_estado_comision");
					}
				}

				this.id_estado_comision=newid_estado_comision;
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
						System.out.println("ComisionLinea:Valor nulo no permitido en columna porcentaje");
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
						System.out.println("ComisionLinea:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>100) {
					newdescripcion=newdescripcion.substring(0,98);
					System.out.println("ComisionLinea:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna descripcion");
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

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public Linea getLinea() {
		return this.linea;
	}

	public EstadoComision getEstadoComision() {
		return this.estadocomision;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcomisionconfig_descripcion() {
		return this.comisionconfig_descripcion;
	}

	public String getvendedor_descripcion() {
		return this.vendedor_descripcion;
	}

	public String getlinea_descripcion() {
		return this.linea_descripcion;
	}

	public String getestadocomision_descripcion() {
		return this.estadocomision_descripcion;
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


	public  void  setVendedor(Vendedor vendedor) {
		try {
			this.vendedor=vendedor;
		} catch(Exception e) {
			;
		}
	}


	public  void  setLinea(Linea linea) {
		try {
			this.linea=linea;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoComision(EstadoComision estadocomision) {
		try {
			this.estadocomision=estadocomision;
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


	public  void  setvendedor_descripcion(String vendedor_descripcion) {
		try {
			this.vendedor_descripcion=vendedor_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setlinea_descripcion(String linea_descripcion) {
		try {
			this.linea_descripcion=linea_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadocomision_descripcion(String estadocomision_descripcion) {
		try {
			this.estadocomision_descripcion=estadocomision_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_comision_config_descripcion="";String id_vendedor_descripcion="";String id_linea_descripcion="";String id_estado_comision_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_comision_config_descripcion() {
		return id_comision_config_descripcion;
	}
	public String getid_vendedor_descripcion() {
		return id_vendedor_descripcion;
	}
	public String getid_linea_descripcion() {
		return id_linea_descripcion;
	}
	public String getid_estado_comision_descripcion() {
		return id_estado_comision_descripcion;
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
	public void setid_vendedor_descripcion(String newid_vendedor_descripcion)throws Exception {
		try {
			this.id_vendedor_descripcion=newid_vendedor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_linea_descripcion(String newid_linea_descripcion)throws Exception {
		try {
			this.id_linea_descripcion=newid_linea_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_comision_descripcion(String newid_estado_comision_descripcion)throws Exception {
		try {
			this.id_estado_comision_descripcion=newid_estado_comision_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_comision_config_descripcion="";this.id_vendedor_descripcion="";this.id_linea_descripcion="";this.id_estado_comision_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

