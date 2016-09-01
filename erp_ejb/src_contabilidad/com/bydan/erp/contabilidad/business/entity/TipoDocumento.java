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
//import com.bydan.erp.contabilidad.util.TipoDocumentoConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class TipoDocumento extends TipoDocumentoAdditional implements Serializable ,Cloneable {//TipoDocumentoAdditional,GeneralEntity
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
	
	private TipoDocumento tipodocumentoOriginal;
	
	private Map<String, Object> mapTipoDocumento;
			
	public Map<String, Object> getMapTipoDocumento() {
		return mapTipoDocumento;
	}

	public void setMapTipoDocumento(Map<String, Object> mapTipoDocumento) {
		this.mapTipoDocumento = mapTipoDocumento;
	}
	
	public void inicializarMapTipoDocumento() {
		this.mapTipoDocumento = new HashMap<String,Object>();
	}
	
	public void setMapTipoDocumentoValue(String sKey,Object oValue) {
		this.mapTipoDocumento.put(sKey, oValue);
	}
	
	public Object getMapTipoDocumentoValue(String sKey) {
		return this.mapTipoDocumento.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoDocumentoConstantesFunciones.SREGEXCODIGO,message=TipoDocumentoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoDocumentoConstantesFunciones.SREGEXNOMBRE,message=TipoDocumentoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_movimiento_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_defecto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_mayor;
			
	
	public Empresa empresa;
	public Modulo modulo;
	public TipoMovimiento tipomovimiento;
	public TipoMovimientoModulo tipomovimientomodulo;
	
	
	private String empresa_descripcion;
	private String modulo_descripcion;
	private String tipomovimiento_descripcion;
	private String tipomovimientomodulo_descripcion;
	
	
		
	public TipoDocumento () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipodocumentoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_modulo=-1L;
 		this.id_tipo_movimiento=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.id_tipo_movimiento_modulo=-1L;
 		this.es_defecto=false;
 		this.es_mayor=false;
		
		
		this.empresa=null;
		this.modulo=null;
		this.tipomovimiento=null;
		this.tipomovimientomodulo=null;
		
		
		this.empresa_descripcion="";
		this.modulo_descripcion="";
		this.tipomovimiento_descripcion="";
		this.tipomovimientomodulo_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoDocumento (Long id,Date versionRow,Long id_empresa,Long id_modulo,Long id_tipo_movimiento,String codigo,String nombre,Long id_tipo_movimiento_modulo,Boolean es_defecto,Boolean es_mayor) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipodocumentoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_modulo=id_modulo;
 		this.id_tipo_movimiento=id_tipo_movimiento;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_tipo_movimiento_modulo=id_tipo_movimiento_modulo;
 		this.es_defecto=es_defecto;
 		this.es_mayor=es_mayor;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoDocumento (Long id_empresa,Long id_modulo,Long id_tipo_movimiento,String codigo,String nombre,Long id_tipo_movimiento_modulo,Boolean es_defecto,Boolean es_mayor) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipodocumentoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_modulo=id_modulo;
 		this.id_tipo_movimiento=id_tipo_movimiento;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_tipo_movimiento_modulo=id_tipo_movimiento_modulo;
 		this.es_defecto=es_defecto;
 		this.es_mayor=es_mayor;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoDocumento tipodocumentoLocal=null;
		
		if(object!=null) {
			tipodocumentoLocal=(TipoDocumento)object;
			
			if(tipodocumentoLocal!=null) {
				if(this.getId()!=null && tipodocumentoLocal.getId()!=null) {
					if(this.getId().equals(tipodocumentoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoDocumentoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(this);
		} else {
			sDetalle=TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoDocumento getTipoDocumentoOriginal() {
		return this.tipodocumentoOriginal;
	}
	
	public void setTipoDocumentoOriginal(TipoDocumento tipodocumento) {
		try {
			this.tipodocumentoOriginal=tipodocumento;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoDocumentoAdditional tipodocumentoAdditional=null;
	
	public TipoDocumentoAdditional getTipoDocumentoAdditional() {
		return this.tipodocumentoAdditional;
	}
	
	public void setTipoDocumentoAdditional(TipoDocumentoAdditional tipodocumentoAdditional) {
		try {
			this.tipodocumentoAdditional=tipodocumentoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public Long getid_tipo_movimiento() {
		return this.id_tipo_movimiento;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Long getid_tipo_movimiento_modulo() {
		return this.id_tipo_movimiento_modulo;
	}
    
	
	public Boolean getes_defecto() {
		return this.es_defecto;
	}
    
	
	public Boolean getes_mayor() {
		return this.es_mayor;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoDocumento:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_modulo(Long newid_modulo)throws Exception
	{
		try {
			if(this.id_modulo!=newid_modulo) {
				if(newid_modulo==null) {
					//newid_modulo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoDocumento:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_movimiento(Long newid_tipo_movimiento)throws Exception
	{
		try {
			if(this.id_tipo_movimiento!=newid_tipo_movimiento) {
				if(newid_tipo_movimiento==null) {
					//newid_tipo_movimiento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoDocumento:Valor nulo no permitido en columna id_tipo_movimiento");
					}
				}

				this.id_tipo_movimiento=newid_tipo_movimiento;
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
						System.out.println("TipoDocumento:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("TipoDocumento:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("TipoDocumento:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("TipoDocumento:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_movimiento_modulo(Long newid_tipo_movimiento_modulo)throws Exception
	{
		try {
			if(this.id_tipo_movimiento_modulo!=newid_tipo_movimiento_modulo) {
				if(newid_tipo_movimiento_modulo==null) {
					//newid_tipo_movimiento_modulo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoDocumento:Valor nulo no permitido en columna id_tipo_movimiento_modulo");
					}
				}

				this.id_tipo_movimiento_modulo=newid_tipo_movimiento_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_defecto(Boolean newes_defecto)throws Exception
	{
		try {
			if(this.es_defecto!=newes_defecto) {
				if(newes_defecto==null) {
					//newes_defecto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoDocumento:Valor nulo no permitido en columna es_defecto");
					}
				}

				this.es_defecto=newes_defecto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_mayor(Boolean newes_mayor)throws Exception
	{
		try {
			if(this.es_mayor!=newes_mayor) {
				if(newes_mayor==null) {
					//newes_mayor=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoDocumento:Valor nulo no permitido en columna es_mayor");
					}
				}

				this.es_mayor=newes_mayor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public TipoMovimiento getTipoMovimiento() {
		return this.tipomovimiento;
	}

	public TipoMovimientoModulo getTipoMovimientoModulo() {
		return this.tipomovimientomodulo;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String gettipomovimiento_descripcion() {
		return this.tipomovimiento_descripcion;
	}

	public String gettipomovimientomodulo_descripcion() {
		return this.tipomovimientomodulo_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setModulo(Modulo modulo) {
		try {
			this.modulo=modulo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoMovimiento(TipoMovimiento tipomovimiento) {
		try {
			this.tipomovimiento=tipomovimiento;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoMovimientoModulo(TipoMovimientoModulo tipomovimientomodulo) {
		try {
			this.tipomovimientomodulo=tipomovimientomodulo;
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


	public  void  setmodulo_descripcion(String modulo_descripcion) {
		try {
			this.modulo_descripcion=modulo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipomovimiento_descripcion(String tipomovimiento_descripcion) {
		try {
			this.tipomovimiento_descripcion=tipomovimiento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipomovimientomodulo_descripcion(String tipomovimientomodulo_descripcion) {
		try {
			this.tipomovimientomodulo_descripcion=tipomovimientomodulo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_modulo_descripcion="";String id_tipo_movimiento_descripcion="";String id_tipo_movimiento_modulo_descripcion="";String es_defecto_descripcion="";String es_mayor_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_tipo_movimiento_descripcion() {
		return id_tipo_movimiento_descripcion;
	}
	public String getid_tipo_movimiento_modulo_descripcion() {
		return id_tipo_movimiento_modulo_descripcion;
	}
	public String getes_defecto_descripcion() {
		return es_defecto_descripcion;
	}
	public String getes_mayor_descripcion() {
		return es_mayor_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_modulo_descripcion(String newid_modulo_descripcion)throws Exception {
		try {
			this.id_modulo_descripcion=newid_modulo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_movimiento_descripcion(String newid_tipo_movimiento_descripcion)throws Exception {
		try {
			this.id_tipo_movimiento_descripcion=newid_tipo_movimiento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_movimiento_modulo_descripcion(String newid_tipo_movimiento_modulo_descripcion)throws Exception {
		try {
			this.id_tipo_movimiento_modulo_descripcion=newid_tipo_movimiento_modulo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_defecto_descripcion(String newes_defecto_descripcion)throws Exception {
		try {
			this.es_defecto_descripcion=newes_defecto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_mayor_descripcion(String newes_mayor_descripcion)throws Exception {
		try {
			this.es_mayor_descripcion=newes_mayor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_modulo_descripcion="";this.id_tipo_movimiento_descripcion="";this.id_tipo_movimiento_modulo_descripcion="";this.es_defecto_descripcion="";this.es_mayor_descripcion="";
	}
	
	
	Object facturaproveedorserviciosDescripcionReporte;
	Object parametrocontabilidaddefectosDescripcionReporte;
	Object definicionsDescripcionReporte;
	Object parametrocomprasDescripcionReporte;
	Object configuracionpunvenNotaVentasDescripcionReporte;
	Object asientocontablesDescripcionReporte;
	Object parametrofactuprincipalNotaDebitosDescripcionReporte;
	Object facturaproveedorsDescripcionReporte;
	Object secuencialsDescripcionReporte;
	Object asientocontablecajachicasDescripcionReporte;
	
	
	public Object getfacturaproveedorserviciosDescripcionReporte() {
		return facturaproveedorserviciosDescripcionReporte;
	}

	public Object getparametrocontabilidaddefectosDescripcionReporte() {
		return parametrocontabilidaddefectosDescripcionReporte;
	}

	public Object getdefinicionsDescripcionReporte() {
		return definicionsDescripcionReporte;
	}

	public Object getparametrocomprasDescripcionReporte() {
		return parametrocomprasDescripcionReporte;
	}

	public Object getconfiguracionpunvenNotaVentasDescripcionReporte() {
		return configuracionpunvenNotaVentasDescripcionReporte;
	}

	public Object getasientocontablesDescripcionReporte() {
		return asientocontablesDescripcionReporte;
	}

	public Object getparametrofactuprincipalNotaDebitosDescripcionReporte() {
		return parametrofactuprincipalNotaDebitosDescripcionReporte;
	}

	public Object getfacturaproveedorsDescripcionReporte() {
		return facturaproveedorsDescripcionReporte;
	}

	public Object getsecuencialsDescripcionReporte() {
		return secuencialsDescripcionReporte;
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

	public  void  setparametrocontabilidaddefectosDescripcionReporte(Object parametrocontabilidaddefectos) {
		try {
			this.parametrocontabilidaddefectosDescripcionReporte=parametrocontabilidaddefectos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdefinicionsDescripcionReporte(Object definicions) {
		try {
			this.definicionsDescripcionReporte=definicions;
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

	public  void  setconfiguracionpunvenNotaVentasDescripcionReporte(Object configuracionpunvens) {
		try {
			this.configuracionpunvenNotaVentasDescripcionReporte=configuracionpunvens;
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

	public  void  setparametrofactuprincipalNotaDebitosDescripcionReporte(Object parametrofactuprincipals) {
		try {
			this.parametrofactuprincipalNotaDebitosDescripcionReporte=parametrofactuprincipals;
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

	public  void  setsecuencialsDescripcionReporte(Object secuencials) {
		try {
			this.secuencialsDescripcionReporte=secuencials;
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

