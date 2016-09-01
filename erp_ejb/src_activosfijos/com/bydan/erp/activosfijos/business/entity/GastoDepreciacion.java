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
//import com.bydan.erp.activosfijos.util.GastoDepreciacionConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class GastoDepreciacion extends GastoDepreciacionAdditional implements Serializable ,Cloneable {//GastoDepreciacionAdditional,GeneralEntity
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
	
	private GastoDepreciacion gastodepreciacionOriginal;
	
	private Map<String, Object> mapGastoDepreciacion;
			
	public Map<String, Object> getMapGastoDepreciacion() {
		return mapGastoDepreciacion;
	}

	public void setMapGastoDepreciacion(Map<String, Object> mapGastoDepreciacion) {
		this.mapGastoDepreciacion = mapGastoDepreciacion;
	}
	
	public void inicializarMapGastoDepreciacion() {
		this.mapGastoDepreciacion = new HashMap<String,Object>();
	}
	
	public void setMapGastoDepreciacionValue(String sKey,Object oValue) {
		this.mapGastoDepreciacion.put(sKey, oValue);
	}
	
	public Object getMapGastoDepreciacionValue(String sKey) {
		return this.mapGastoDepreciacion.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_detalle_grupo_activo_fijo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer anio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
			
	
	public Empresa empresa;
	public DetalleGrupoActivoFijo detallegrupoactivofijo;
	
	
	private String empresa_descripcion;
	private String detallegrupoactivofijo_descripcion;
	
	
	public List<CuentaContaGastoDepre> cuentacontagastodepres;
		
	public GastoDepreciacion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.gastodepreciacionOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_detalle_grupo_activo_fijo=-1L;
 		this.anio=0;
 		this.valor=0.0;
		
		
		this.empresa=null;
		this.detallegrupoactivofijo=null;
		
		
		this.empresa_descripcion="";
		this.detallegrupoactivofijo_descripcion="";
		
		
		this.cuentacontagastodepres=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public GastoDepreciacion (Long id,Date versionRow,Long id_empresa,Long id_detalle_grupo_activo_fijo,Integer anio,Double valor) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.gastodepreciacionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_detalle_grupo_activo_fijo=id_detalle_grupo_activo_fijo;
 		this.anio=anio;
 		this.valor=valor;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public GastoDepreciacion (Long id_empresa,Long id_detalle_grupo_activo_fijo,Integer anio,Double valor) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.gastodepreciacionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_detalle_grupo_activo_fijo=id_detalle_grupo_activo_fijo;
 		this.anio=anio;
 		this.valor=valor;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		GastoDepreciacion gastodepreciacionLocal=null;
		
		if(object!=null) {
			gastodepreciacionLocal=(GastoDepreciacion)object;
			
			if(gastodepreciacionLocal!=null) {
				if(this.getId()!=null && gastodepreciacionLocal.getId()!=null) {
					if(this.getId().equals(gastodepreciacionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!GastoDepreciacionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=GastoDepreciacionConstantesFunciones.getGastoDepreciacionDescripcion(this);
		} else {
			sDetalle=GastoDepreciacionConstantesFunciones.getGastoDepreciacionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public GastoDepreciacion getGastoDepreciacionOriginal() {
		return this.gastodepreciacionOriginal;
	}
	
	public void setGastoDepreciacionOriginal(GastoDepreciacion gastodepreciacion) {
		try {
			this.gastodepreciacionOriginal=gastodepreciacion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected GastoDepreciacionAdditional gastodepreciacionAdditional=null;
	
	public GastoDepreciacionAdditional getGastoDepreciacionAdditional() {
		return this.gastodepreciacionAdditional;
	}
	
	public void setGastoDepreciacionAdditional(GastoDepreciacionAdditional gastodepreciacionAdditional) {
		try {
			this.gastodepreciacionAdditional=gastodepreciacionAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_detalle_grupo_activo_fijo() {
		return this.id_detalle_grupo_activo_fijo;
	}
    
	
	public Integer getanio() {
		return this.anio;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoDepreciacion:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_detalle_grupo_activo_fijo(Long newid_detalle_grupo_activo_fijo)throws Exception
	{
		try {
			if(this.id_detalle_grupo_activo_fijo!=newid_detalle_grupo_activo_fijo) {
				if(newid_detalle_grupo_activo_fijo==null) {
					//newid_detalle_grupo_activo_fijo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoDepreciacion:Valor nulo no permitido en columna id_detalle_grupo_activo_fijo");
					}
				}

				this.id_detalle_grupo_activo_fijo=newid_detalle_grupo_activo_fijo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setanio(Integer newanio)throws Exception
	{
		try {
			if(this.anio!=newanio) {
				if(newanio==null) {
					//newanio=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoDepreciacion:Valor nulo no permitido en columna anio");
					}
				}

				this.anio=newanio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor(Double newvalor)throws Exception
	{
		try {
			if(this.valor!=newvalor) {
				if(newvalor==null) {
					//newvalor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoDepreciacion:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public DetalleGrupoActivoFijo getDetalleGrupoActivoFijo() {
		return this.detallegrupoactivofijo;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getdetallegrupoactivofijo_descripcion() {
		return this.detallegrupoactivofijo_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
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


	
	
	public List<CuentaContaGastoDepre> getCuentaContaGastoDepres() {
		return this.cuentacontagastodepres;
	}

	
	
	public  void  setCuentaContaGastoDepres(List<CuentaContaGastoDepre> cuentacontagastodepres) {
		try {
			this.cuentacontagastodepres=cuentacontagastodepres;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_detalle_grupo_activo_fijo_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_detalle_grupo_activo_fijo_descripcion() {
		return id_detalle_grupo_activo_fijo_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_detalle_grupo_activo_fijo_descripcion="";
	}
	
	
	Object cuentacontagastodepresDescripcionReporte;
	
	
	public Object getcuentacontagastodepresDescripcionReporte() {
		return cuentacontagastodepresDescripcionReporte;
	}

	
	
	public  void  setcuentacontagastodepresDescripcionReporte(Object cuentacontagastodepres) {
		try {
			this.cuentacontagastodepresDescripcionReporte=cuentacontagastodepres;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

