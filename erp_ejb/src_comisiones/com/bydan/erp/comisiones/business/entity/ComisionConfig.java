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
//import com.bydan.erp.comisiones.util.ComisionConfigConstantesFunciones;
import com.bydan.erp.comisiones.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class ComisionConfig extends ComisionConfigAdditional implements Serializable ,Cloneable {//ComisionConfigAdditional,GeneralEntity
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
	
	private ComisionConfig comisionconfigOriginal;
	
	private Map<String, Object> mapComisionConfig;
			
	public Map<String, Object> getMapComisionConfig() {
		return mapComisionConfig;
	}

	public void setMapComisionConfig(Map<String, Object> mapComisionConfig) {
		this.mapComisionConfig = mapComisionConfig;
	}
	
	public void inicializarMapComisionConfig() {
		this.mapComisionConfig = new HashMap<String,Object>();
	}
	
	public void setMapComisionConfigValue(String sKey,Object oValue) {
		this.mapComisionConfig.put(sKey, oValue);
	}
	
	public Object getMapComisionConfigValue(String sKey) {
		return this.mapComisionConfig.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_comision_config;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_nivel_linea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_vendedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_ventas;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_cobros;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_remesa_transito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_penalidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_abono;
			
	
	public Empresa empresa;
	public TipoComisionConfig tipocomisionconfig;
	public NivelLinea nivellinea;
	
	
	private String empresa_descripcion;
	private String tipocomisionconfig_descripcion;
	private String nivellinea_descripcion;
	
	
	public List<ComisionCate> comisioncates;
	public List<ComisionMarca> comisionmarcas;
	public List<ComisionLinea> comisionlineas;
	public List<ComisionPena> comisionpenas;
	public List<ComisionGrupo> comisiongrupos;
		
	public ComisionConfig () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.comisionconfigOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_tipo_comision_config=-1L;
 		this.id_nivel_linea=-1L;
 		this.con_vendedor=false;
 		this.con_ventas=false;
 		this.con_cobros=false;
 		this.con_remesa_transito=false;
 		this.con_penalidad=false;
 		this.con_abono=false;
		
		
		this.empresa=null;
		this.tipocomisionconfig=null;
		this.nivellinea=null;
		
		
		this.empresa_descripcion="";
		this.tipocomisionconfig_descripcion="";
		this.nivellinea_descripcion="";
		
		
		this.comisioncates=null;
		this.comisionmarcas=null;
		this.comisionlineas=null;
		this.comisionpenas=null;
		this.comisiongrupos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ComisionConfig (Long id,Date versionRow,Long id_empresa,Long id_tipo_comision_config,Long id_nivel_linea,Boolean con_vendedor,Boolean con_ventas,Boolean con_cobros,Boolean con_remesa_transito,Boolean con_penalidad,Boolean con_abono) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.comisionconfigOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_comision_config=id_tipo_comision_config;
 		this.id_nivel_linea=id_nivel_linea;
 		this.con_vendedor=con_vendedor;
 		this.con_ventas=con_ventas;
 		this.con_cobros=con_cobros;
 		this.con_remesa_transito=con_remesa_transito;
 		this.con_penalidad=con_penalidad;
 		this.con_abono=con_abono;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ComisionConfig (Long id_empresa,Long id_tipo_comision_config,Long id_nivel_linea,Boolean con_vendedor,Boolean con_ventas,Boolean con_cobros,Boolean con_remesa_transito,Boolean con_penalidad,Boolean con_abono) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.comisionconfigOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_comision_config=id_tipo_comision_config;
 		this.id_nivel_linea=id_nivel_linea;
 		this.con_vendedor=con_vendedor;
 		this.con_ventas=con_ventas;
 		this.con_cobros=con_cobros;
 		this.con_remesa_transito=con_remesa_transito;
 		this.con_penalidad=con_penalidad;
 		this.con_abono=con_abono;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ComisionConfig comisionconfigLocal=null;
		
		if(object!=null) {
			comisionconfigLocal=(ComisionConfig)object;
			
			if(comisionconfigLocal!=null) {
				if(this.getId()!=null && comisionconfigLocal.getId()!=null) {
					if(this.getId().equals(comisionconfigLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ComisionConfigConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ComisionConfigConstantesFunciones.getComisionConfigDescripcion(this);
		} else {
			sDetalle=ComisionConfigConstantesFunciones.getComisionConfigDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ComisionConfig getComisionConfigOriginal() {
		return this.comisionconfigOriginal;
	}
	
	public void setComisionConfigOriginal(ComisionConfig comisionconfig) {
		try {
			this.comisionconfigOriginal=comisionconfig;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ComisionConfigAdditional comisionconfigAdditional=null;
	
	public ComisionConfigAdditional getComisionConfigAdditional() {
		return this.comisionconfigAdditional;
	}
	
	public void setComisionConfigAdditional(ComisionConfigAdditional comisionconfigAdditional) {
		try {
			this.comisionconfigAdditional=comisionconfigAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_tipo_comision_config() {
		return this.id_tipo_comision_config;
	}
    
	
	public Long getid_nivel_linea() {
		return this.id_nivel_linea;
	}
    
	
	public Boolean getcon_vendedor() {
		return this.con_vendedor;
	}
    
	
	public Boolean getcon_ventas() {
		return this.con_ventas;
	}
    
	
	public Boolean getcon_cobros() {
		return this.con_cobros;
	}
    
	
	public Boolean getcon_remesa_transito() {
		return this.con_remesa_transito;
	}
    
	
	public Boolean getcon_penalidad() {
		return this.con_penalidad;
	}
    
	
	public Boolean getcon_abono() {
		return this.con_abono;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionConfig:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_comision_config(Long newid_tipo_comision_config)throws Exception
	{
		try {
			if(this.id_tipo_comision_config!=newid_tipo_comision_config) {
				if(newid_tipo_comision_config==null) {
					//newid_tipo_comision_config=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionConfig:Valor nulo no permitido en columna id_tipo_comision_config");
					}
				}

				this.id_tipo_comision_config=newid_tipo_comision_config;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_nivel_linea(Long newid_nivel_linea)throws Exception
	{
		try {
			if(this.id_nivel_linea!=newid_nivel_linea) {
				if(newid_nivel_linea==null) {
					//newid_nivel_linea=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionConfig:Valor nulo no permitido en columna id_nivel_linea");
					}
				}

				this.id_nivel_linea=newid_nivel_linea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_vendedor(Boolean newcon_vendedor)throws Exception
	{
		try {
			if(this.con_vendedor!=newcon_vendedor) {
				if(newcon_vendedor==null) {
					//newcon_vendedor=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionConfig:Valor nulo no permitido en columna con_vendedor");
					}
				}

				this.con_vendedor=newcon_vendedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_ventas(Boolean newcon_ventas)throws Exception
	{
		try {
			if(this.con_ventas!=newcon_ventas) {
				if(newcon_ventas==null) {
					//newcon_ventas=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionConfig:Valor nulo no permitido en columna con_ventas");
					}
				}

				this.con_ventas=newcon_ventas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_cobros(Boolean newcon_cobros)throws Exception
	{
		try {
			if(this.con_cobros!=newcon_cobros) {
				if(newcon_cobros==null) {
					//newcon_cobros=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionConfig:Valor nulo no permitido en columna con_cobros");
					}
				}

				this.con_cobros=newcon_cobros;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_remesa_transito(Boolean newcon_remesa_transito)throws Exception
	{
		try {
			if(this.con_remesa_transito!=newcon_remesa_transito) {
				if(newcon_remesa_transito==null) {
					//newcon_remesa_transito=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionConfig:Valor nulo no permitido en columna con_remesa_transito");
					}
				}

				this.con_remesa_transito=newcon_remesa_transito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_penalidad(Boolean newcon_penalidad)throws Exception
	{
		try {
			if(this.con_penalidad!=newcon_penalidad) {
				if(newcon_penalidad==null) {
					//newcon_penalidad=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionConfig:Valor nulo no permitido en columna con_penalidad");
					}
				}

				this.con_penalidad=newcon_penalidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_abono(Boolean newcon_abono)throws Exception
	{
		try {
			if(this.con_abono!=newcon_abono) {
				if(newcon_abono==null) {
					//newcon_abono=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionConfig:Valor nulo no permitido en columna con_abono");
					}
				}

				this.con_abono=newcon_abono;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public TipoComisionConfig getTipoComisionConfig() {
		return this.tipocomisionconfig;
	}

	public NivelLinea getNivelLinea() {
		return this.nivellinea;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettipocomisionconfig_descripcion() {
		return this.tipocomisionconfig_descripcion;
	}

	public String getnivellinea_descripcion() {
		return this.nivellinea_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoComisionConfig(TipoComisionConfig tipocomisionconfig) {
		try {
			this.tipocomisionconfig=tipocomisionconfig;
		} catch(Exception e) {
			;
		}
	}


	public  void  setNivelLinea(NivelLinea nivellinea) {
		try {
			this.nivellinea=nivellinea;
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


	public  void  settipocomisionconfig_descripcion(String tipocomisionconfig_descripcion) {
		try {
			this.tipocomisionconfig_descripcion=tipocomisionconfig_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setnivellinea_descripcion(String nivellinea_descripcion) {
		try {
			this.nivellinea_descripcion=nivellinea_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<ComisionCate> getComisionCates() {
		return this.comisioncates;
	}

	public List<ComisionMarca> getComisionMarcas() {
		return this.comisionmarcas;
	}

	public List<ComisionLinea> getComisionLineas() {
		return this.comisionlineas;
	}

	public List<ComisionPena> getComisionPenas() {
		return this.comisionpenas;
	}

	public List<ComisionGrupo> getComisionGrupos() {
		return this.comisiongrupos;
	}

	
	
	public  void  setComisionCates(List<ComisionCate> comisioncates) {
		try {
			this.comisioncates=comisioncates;
		} catch(Exception e) {
			;
		}
	}

	public  void  setComisionMarcas(List<ComisionMarca> comisionmarcas) {
		try {
			this.comisionmarcas=comisionmarcas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setComisionLineas(List<ComisionLinea> comisionlineas) {
		try {
			this.comisionlineas=comisionlineas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setComisionPenas(List<ComisionPena> comisionpenas) {
		try {
			this.comisionpenas=comisionpenas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setComisionGrupos(List<ComisionGrupo> comisiongrupos) {
		try {
			this.comisiongrupos=comisiongrupos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_tipo_comision_config_descripcion="";String id_nivel_linea_descripcion="";String con_vendedor_descripcion="";String con_ventas_descripcion="";String con_cobros_descripcion="";String con_remesa_transito_descripcion="";String con_penalidad_descripcion="";String con_abono_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_comision_config_descripcion() {
		return id_tipo_comision_config_descripcion;
	}
	public String getid_nivel_linea_descripcion() {
		return id_nivel_linea_descripcion;
	}
	public String getcon_vendedor_descripcion() {
		return con_vendedor_descripcion;
	}
	public String getcon_ventas_descripcion() {
		return con_ventas_descripcion;
	}
	public String getcon_cobros_descripcion() {
		return con_cobros_descripcion;
	}
	public String getcon_remesa_transito_descripcion() {
		return con_remesa_transito_descripcion;
	}
	public String getcon_penalidad_descripcion() {
		return con_penalidad_descripcion;
	}
	public String getcon_abono_descripcion() {
		return con_abono_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_comision_config_descripcion(String newid_tipo_comision_config_descripcion)throws Exception {
		try {
			this.id_tipo_comision_config_descripcion=newid_tipo_comision_config_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_nivel_linea_descripcion(String newid_nivel_linea_descripcion)throws Exception {
		try {
			this.id_nivel_linea_descripcion=newid_nivel_linea_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_vendedor_descripcion(String newcon_vendedor_descripcion)throws Exception {
		try {
			this.con_vendedor_descripcion=newcon_vendedor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_ventas_descripcion(String newcon_ventas_descripcion)throws Exception {
		try {
			this.con_ventas_descripcion=newcon_ventas_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_cobros_descripcion(String newcon_cobros_descripcion)throws Exception {
		try {
			this.con_cobros_descripcion=newcon_cobros_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_remesa_transito_descripcion(String newcon_remesa_transito_descripcion)throws Exception {
		try {
			this.con_remesa_transito_descripcion=newcon_remesa_transito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_penalidad_descripcion(String newcon_penalidad_descripcion)throws Exception {
		try {
			this.con_penalidad_descripcion=newcon_penalidad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_abono_descripcion(String newcon_abono_descripcion)throws Exception {
		try {
			this.con_abono_descripcion=newcon_abono_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_comision_config_descripcion="";this.id_nivel_linea_descripcion="";this.con_vendedor_descripcion="";this.con_ventas_descripcion="";this.con_cobros_descripcion="";this.con_remesa_transito_descripcion="";this.con_penalidad_descripcion="";this.con_abono_descripcion="";
	}
	
	
	Object comisioncatesDescripcionReporte;
	Object comisionmarcasDescripcionReporte;
	Object comisionlineasDescripcionReporte;
	Object comisionpenasDescripcionReporte;
	Object comisiongruposDescripcionReporte;
	
	
	public Object getcomisioncatesDescripcionReporte() {
		return comisioncatesDescripcionReporte;
	}

	public Object getcomisionmarcasDescripcionReporte() {
		return comisionmarcasDescripcionReporte;
	}

	public Object getcomisionlineasDescripcionReporte() {
		return comisionlineasDescripcionReporte;
	}

	public Object getcomisionpenasDescripcionReporte() {
		return comisionpenasDescripcionReporte;
	}

	public Object getcomisiongruposDescripcionReporte() {
		return comisiongruposDescripcionReporte;
	}

	
	
	public  void  setcomisioncatesDescripcionReporte(Object comisioncates) {
		try {
			this.comisioncatesDescripcionReporte=comisioncates;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcomisionmarcasDescripcionReporte(Object comisionmarcas) {
		try {
			this.comisionmarcasDescripcionReporte=comisionmarcas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcomisionlineasDescripcionReporte(Object comisionlineas) {
		try {
			this.comisionlineasDescripcionReporte=comisionlineas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcomisionpenasDescripcionReporte(Object comisionpenas) {
		try {
			this.comisionpenasDescripcionReporte=comisionpenas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcomisiongruposDescripcionReporte(Object comisiongrupos) {
		try {
			this.comisiongruposDescripcionReporte=comisiongrupos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

