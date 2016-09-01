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
//import com.bydan.erp.contabilidad.util.TipoMovimientoConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.activosfijos.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;




@SuppressWarnings("unused")
public class TipoMovimiento extends GeneralEntitySinIdGenerated implements Serializable ,Cloneable {//TipoMovimientoAdditional,GeneralEntity
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
	
	private TipoMovimiento tipomovimientoOriginal;
	
	private Map<String, Object> mapTipoMovimiento;
			
	public Map<String, Object> getMapTipoMovimiento() {
		return mapTipoMovimiento;
	}

	public void setMapTipoMovimiento(Map<String, Object> mapTipoMovimiento) {
		this.mapTipoMovimiento = mapTipoMovimiento;
	}
	
	public void inicializarMapTipoMovimiento() {
		this.mapTipoMovimiento = new HashMap<String,Object>();
	}
	
	public void setMapTipoMovimientoValue(String sKey,Object oValue) {
		this.mapTipoMovimiento.put(sKey, oValue);
	}
	
	public Object getMapTipoMovimientoValue(String sKey) {
		return this.mapTipoMovimiento.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoMovimientoConstantesFunciones.SREGEXCODIGO,message=TipoMovimientoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoMovimientoConstantesFunciones.SREGEXNOMBRE,message=TipoMovimientoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	
	
	
	
		
	public TipoMovimiento () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipomovimientoOriginal=this;
		
 		this.codigo="";
 		this.nombre="";
		
		
		
		
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoMovimiento (Long id,Date versionRow,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipomovimientoOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoMovimiento (String codigo,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipomovimientoOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoMovimiento tipomovimientoLocal=null;
		
		if(object!=null) {
			tipomovimientoLocal=(TipoMovimiento)object;
			
			if(tipomovimientoLocal!=null) {
				if(this.getId()!=null && tipomovimientoLocal.getId()!=null) {
					if(this.getId().equals(tipomovimientoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoMovimientoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(this);
		} else {
			sDetalle=TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoMovimiento getTipoMovimientoOriginal() {
		return this.tipomovimientoOriginal;
	}
	
	public void setTipoMovimientoOriginal(TipoMovimiento tipomovimiento) {
		try {
			this.tipomovimientoOriginal=tipomovimiento;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
	
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoMovimiento:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("TipoMovimiento:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("TipoMovimiento:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("TipoMovimiento:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object facturaproveedorserviciosDescripcionReporte;
	Object facturaproveedorsDescripcionReporte;
	Object presupuestoflujocajatsrsDescripcionReporte;
	Object tipodocumentosDescripcionReporte;
	Object centroactividadsDescripcionReporte;
	Object parametrocomprasDescripcionReporte;
	Object srisDescripcionReporte;
	Object asientocontablesDescripcionReporte;
	Object parametrocontabilidaddefectosDescripcionReporte;
	Object mantenimientoactivofijosDescripcionReporte;
	Object secuencialsDescripcionReporte;
	Object formatosDescripcionReporte;
	Object asientocontablecajachicasDescripcionReporte;
	
	
	public Object getfacturaproveedorserviciosDescripcionReporte() {
		return facturaproveedorserviciosDescripcionReporte;
	}

	public Object getfacturaproveedorsDescripcionReporte() {
		return facturaproveedorsDescripcionReporte;
	}

	public Object getpresupuestoflujocajatsrsDescripcionReporte() {
		return presupuestoflujocajatsrsDescripcionReporte;
	}

	public Object gettipodocumentosDescripcionReporte() {
		return tipodocumentosDescripcionReporte;
	}

	public Object getcentroactividadsDescripcionReporte() {
		return centroactividadsDescripcionReporte;
	}

	public Object getparametrocomprasDescripcionReporte() {
		return parametrocomprasDescripcionReporte;
	}

	public Object getsrisDescripcionReporte() {
		return srisDescripcionReporte;
	}

	public Object getasientocontablesDescripcionReporte() {
		return asientocontablesDescripcionReporte;
	}

	public Object getparametrocontabilidaddefectosDescripcionReporte() {
		return parametrocontabilidaddefectosDescripcionReporte;
	}

	public Object getmantenimientoactivofijosDescripcionReporte() {
		return mantenimientoactivofijosDescripcionReporte;
	}

	public Object getsecuencialsDescripcionReporte() {
		return secuencialsDescripcionReporte;
	}

	public Object getformatosDescripcionReporte() {
		return formatosDescripcionReporte;
	}

	public Object getasientocontablecajachicasDescripcionReporte() {
		return asientocontablecajachicasDescripcionReporte;
	}

	
	
	public  void  setfacturaproveedorserviciosDescripcionReporte(Object facturaproveedorservicios) {
		try {
			this.facturaproveedorserviciosDescripcionReporte=facturaproveedorservicios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setfacturaproveedorsDescripcionReporte(Object facturaproveedors) {
		try {
			this.facturaproveedorsDescripcionReporte=facturaproveedors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpresupuestoflujocajatsrsDescripcionReporte(Object presupuestoflujocajatsrs) {
		try {
			this.presupuestoflujocajatsrsDescripcionReporte=presupuestoflujocajatsrs;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settipodocumentosDescripcionReporte(Object tipodocumentos) {
		try {
			this.tipodocumentosDescripcionReporte=tipodocumentos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcentroactividadsDescripcionReporte(Object centroactividads) {
		try {
			this.centroactividadsDescripcionReporte=centroactividads;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrocomprasDescripcionReporte(Object parametrocompras) {
		try {
			this.parametrocomprasDescripcionReporte=parametrocompras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setsrisDescripcionReporte(Object sris) {
		try {
			this.srisDescripcionReporte=sris;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setasientocontablesDescripcionReporte(Object asientocontables) {
		try {
			this.asientocontablesDescripcionReporte=asientocontables;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrocontabilidaddefectosDescripcionReporte(Object parametrocontabilidaddefectos) {
		try {
			this.parametrocontabilidaddefectosDescripcionReporte=parametrocontabilidaddefectos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setmantenimientoactivofijosDescripcionReporte(Object mantenimientoactivofijos) {
		try {
			this.mantenimientoactivofijosDescripcionReporte=mantenimientoactivofijos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setsecuencialsDescripcionReporte(Object secuencials) {
		try {
			this.secuencialsDescripcionReporte=secuencials;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setformatosDescripcionReporte(Object formatos) {
		try {
			this.formatosDescripcionReporte=formatos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setasientocontablecajachicasDescripcionReporte(Object asientocontablecajachicas) {
		try {
			this.asientocontablecajachicasDescripcionReporte=asientocontablecajachicas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

