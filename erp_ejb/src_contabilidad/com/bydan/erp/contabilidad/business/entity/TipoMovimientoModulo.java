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
//import com.bydan.erp.contabilidad.util.TipoMovimientoModuloConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.puntoventa.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;




@SuppressWarnings("unused")
public class TipoMovimientoModulo extends TipoMovimientoModuloAdditional implements Serializable ,Cloneable {//TipoMovimientoModuloAdditional,GeneralEntity
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
	
	private TipoMovimientoModulo tipomovimientomoduloOriginal;
	
	private Map<String, Object> mapTipoMovimientoModulo;
			
	public Map<String, Object> getMapTipoMovimientoModulo() {
		return mapTipoMovimientoModulo;
	}

	public void setMapTipoMovimientoModulo(Map<String, Object> mapTipoMovimientoModulo) {
		this.mapTipoMovimientoModulo = mapTipoMovimientoModulo;
	}
	
	public void inicializarMapTipoMovimientoModulo() {
		this.mapTipoMovimientoModulo = new HashMap<String,Object>();
	}
	
	public void setMapTipoMovimientoModuloValue(String sKey,Object oValue) {
		this.mapTipoMovimientoModulo.put(sKey, oValue);
	}
	
	public Object getMapTipoMovimientoModuloValue(String sKey) {
		return this.mapTipoMovimientoModulo.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoMovimientoModuloConstantesFunciones.SREGEXCODIGO,message=TipoMovimientoModuloConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoMovimientoModuloConstantesFunciones.SREGEXNOMBRE,message=TipoMovimientoModuloConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	public Modulo modulo;
	
	
	private String modulo_descripcion;
	
	
	public List<ParametroCompra> parametrocompras;
	public List<FacturaProveedorServicio> facturaproveedorservicios;
	public List<Secuencial> secuencials;
	public List<TipoDocumento> tipodocumentos;
		
	public TipoMovimientoModulo () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipomovimientomoduloOriginal=this;
		
 		this.id_modulo=-1L;
 		this.codigo="";
 		this.nombre="";
		
		
		this.modulo=null;
		
		
		this.modulo_descripcion="";
		
		
		this.parametrocompras=null;
		this.facturaproveedorservicios=null;
		this.secuencials=null;
		this.tipodocumentos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoMovimientoModulo (Long id,Date versionRow,Long id_modulo,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipomovimientomoduloOriginal=this;
		
 		this.id_modulo=id_modulo;
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoMovimientoModulo (Long id_modulo,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipomovimientomoduloOriginal=this;
		
 		this.id_modulo=id_modulo;
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoMovimientoModulo tipomovimientomoduloLocal=null;
		
		if(object!=null) {
			tipomovimientomoduloLocal=(TipoMovimientoModulo)object;
			
			if(tipomovimientomoduloLocal!=null) {
				if(this.getId()!=null && tipomovimientomoduloLocal.getId()!=null) {
					if(this.getId().equals(tipomovimientomoduloLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoMovimientoModuloConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloDescripcion(this);
		} else {
			sDetalle=TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoMovimientoModulo getTipoMovimientoModuloOriginal() {
		return this.tipomovimientomoduloOriginal;
	}
	
	public void setTipoMovimientoModuloOriginal(TipoMovimientoModulo tipomovimientomodulo) {
		try {
			this.tipomovimientomoduloOriginal=tipomovimientomodulo;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoMovimientoModuloAdditional tipomovimientomoduloAdditional=null;
	
	public TipoMovimientoModuloAdditional getTipoMovimientoModuloAdditional() {
		return this.tipomovimientomoduloAdditional;
	}
	
	public void setTipoMovimientoModuloAdditional(TipoMovimientoModuloAdditional tipomovimientomoduloAdditional) {
		try {
			this.tipomovimientomoduloAdditional=tipomovimientomoduloAdditional;
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
						System.out.println("TipoMovimientoModulo:Valor nulo no permitido en columna id_modulo");
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
						System.out.println("TipoMovimientoModulo:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("TipoMovimientoModulo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("TipoMovimientoModulo:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("TipoMovimientoModulo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
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


	
	
	public List<ParametroCompra> getParametroCompras() {
		return this.parametrocompras;
	}

	public List<FacturaProveedorServicio> getFacturaProveedorServicios() {
		return this.facturaproveedorservicios;
	}

	public List<Secuencial> getSecuencials() {
		return this.secuencials;
	}

	public List<TipoDocumento> getTipoDocumentos() {
		return this.tipodocumentos;
	}

	
	
	public  void  setParametroCompras(List<ParametroCompra> parametrocompras) {
		try {
			this.parametrocompras=parametrocompras;
		} catch(Exception e) {
			;
		}
	}

	public  void  setFacturaProveedorServicios(List<FacturaProveedorServicio> facturaproveedorservicios) {
		try {
			this.facturaproveedorservicios=facturaproveedorservicios;
		} catch(Exception e) {
			;
		}
	}

	public  void  setSecuencials(List<Secuencial> secuencials) {
		try {
			this.secuencials=secuencials;
		} catch(Exception e) {
			;
		}
	}

	public  void  setTipoDocumentos(List<TipoDocumento> tipodocumentos) {
		try {
			this.tipodocumentos=tipodocumentos;
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
	
	
	Object parametrocomprasDescripcionReporte;
	Object facturaproveedorsDescripcionReporte;
	Object asientocontablecajachicasDescripcionReporte;
	Object facturaproveedorserviciosDescripcionReporte;
	Object secuencialsDescripcionReporte;
	Object asientocontablesDescripcionReporte;
	Object tipodocumentosDescripcionReporte;
	
	
	public Object getparametrocomprasDescripcionReporte() {
		return parametrocomprasDescripcionReporte;
	}

	public Object getfacturaproveedorsDescripcionReporte() {
		return facturaproveedorsDescripcionReporte;
	}

	public Object getasientocontablecajachicasDescripcionReporte() {
		return asientocontablecajachicasDescripcionReporte;
	}

	public Object getfacturaproveedorserviciosDescripcionReporte() {
		return facturaproveedorserviciosDescripcionReporte;
	}

	public Object getsecuencialsDescripcionReporte() {
		return secuencialsDescripcionReporte;
	}

	public Object getasientocontablesDescripcionReporte() {
		return asientocontablesDescripcionReporte;
	}

	public Object gettipodocumentosDescripcionReporte() {
		return tipodocumentosDescripcionReporte;
	}

	
	
	public  void  setparametrocomprasDescripcionReporte(Object parametrocompras) {
		try {
			this.parametrocomprasDescripcionReporte=parametrocompras;
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

	public  void  setasientocontablecajachicasDescripcionReporte(Object asientocontablecajachicas) {
		try {
			this.asientocontablecajachicasDescripcionReporte=asientocontablecajachicas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setfacturaproveedorserviciosDescripcionReporte(Object facturaproveedorservicios) {
		try {
			this.facturaproveedorserviciosDescripcionReporte=facturaproveedorservicios;
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

	public  void  setasientocontablesDescripcionReporte(Object asientocontables) {
		try {
			this.asientocontablesDescripcionReporte=asientocontables;
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

	/*PARA REPORTES FIN*/		
}

