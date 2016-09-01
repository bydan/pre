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
package com.bydan.erp.inventario.business.entity;

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
//import com.bydan.erp.inventario.util.DetalleAutoriConsepConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class DetalleAutoriConsep extends DetalleAutoriConsepAdditional implements Serializable ,Cloneable {//DetalleAutoriConsepAdditional,GeneralEntity
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
	
	private DetalleAutoriConsep detalleautoriconsepOriginal;
	
	private Map<String, Object> mapDetalleAutoriConsep;
			
	public Map<String, Object> getMapDetalleAutoriConsep() {
		return mapDetalleAutoriConsep;
	}

	public void setMapDetalleAutoriConsep(Map<String, Object> mapDetalleAutoriConsep) {
		this.mapDetalleAutoriConsep = mapDetalleAutoriConsep;
	}
	
	public void inicializarMapDetalleAutoriConsep() {
		this.mapDetalleAutoriConsep = new HashMap<String,Object>();
	}
	
	public void setMapDetalleAutoriConsepValue(String sKey,Object oValue) {
		this.mapDetalleAutoriConsep.put(sKey, oValue);
	}
	
	public Object getMapDetalleAutoriConsepValue(String sKey) {
		return this.mapDetalleAutoriConsep.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_autori_consep;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_unidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cantidad_anio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cantidad_saldo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_detalle_autori_consep;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=DetalleAutoriConsepConstantesFunciones.SREGEXNOMBRE,message=DetalleAutoriConsepConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	public AutoriConsep autoriconsep;
	public Empresa empresa;
	public Producto producto;
	public Unidad unidad;
	public EstadoDetalleAutoriConsep estadodetalleautoriconsep;
	
	
	private String autoriconsep_descripcion;
	private String empresa_descripcion;
	private String producto_descripcion;
	private String unidad_descripcion;
	private String estadodetalleautoriconsep_descripcion;
	
	
		
	public DetalleAutoriConsep () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detalleautoriconsepOriginal=this;
		
 		this.id_autori_consep=-1L;
 		this.id_empresa=-1L;
 		this.id_producto=-1L;
 		this.id_unidad=-1L;
 		this.cantidad_anio=0.0;
 		this.cantidad_saldo=0.0;
 		this.id_estado_detalle_autori_consep=-1L;
 		this.nombre="";
		
		
		this.autoriconsep=null;
		this.empresa=null;
		this.producto=null;
		this.unidad=null;
		this.estadodetalleautoriconsep=null;
		
		
		this.autoriconsep_descripcion="";
		this.empresa_descripcion="";
		this.producto_descripcion="";
		this.unidad_descripcion="";
		this.estadodetalleautoriconsep_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetalleAutoriConsep (Long id,Date versionRow,Long id_autori_consep,Long id_empresa,Long id_producto,Long id_unidad,Double cantidad_anio,Double cantidad_saldo,Long id_estado_detalle_autori_consep,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleautoriconsepOriginal=this;
		
 		this.id_autori_consep=id_autori_consep;
 		this.id_empresa=id_empresa;
 		this.id_producto=id_producto;
 		this.id_unidad=id_unidad;
 		this.cantidad_anio=cantidad_anio;
 		this.cantidad_saldo=cantidad_saldo;
 		this.id_estado_detalle_autori_consep=id_estado_detalle_autori_consep;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetalleAutoriConsep (Long id_autori_consep,Long id_empresa,Long id_producto,Long id_unidad,Double cantidad_anio,Double cantidad_saldo,Long id_estado_detalle_autori_consep,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleautoriconsepOriginal=this;
		
 		this.id_autori_consep=id_autori_consep;
 		this.id_empresa=id_empresa;
 		this.id_producto=id_producto;
 		this.id_unidad=id_unidad;
 		this.cantidad_anio=cantidad_anio;
 		this.cantidad_saldo=cantidad_saldo;
 		this.id_estado_detalle_autori_consep=id_estado_detalle_autori_consep;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetalleAutoriConsep detalleautoriconsepLocal=null;
		
		if(object!=null) {
			detalleautoriconsepLocal=(DetalleAutoriConsep)object;
			
			if(detalleautoriconsepLocal!=null) {
				if(this.getId()!=null && detalleautoriconsepLocal.getId()!=null) {
					if(this.getId().equals(detalleautoriconsepLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetalleAutoriConsepConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetalleAutoriConsepConstantesFunciones.getDetalleAutoriConsepDescripcion(this);
		} else {
			sDetalle=DetalleAutoriConsepConstantesFunciones.getDetalleAutoriConsepDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetalleAutoriConsep getDetalleAutoriConsepOriginal() {
		return this.detalleautoriconsepOriginal;
	}
	
	public void setDetalleAutoriConsepOriginal(DetalleAutoriConsep detalleautoriconsep) {
		try {
			this.detalleautoriconsepOriginal=detalleautoriconsep;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetalleAutoriConsepAdditional detalleautoriconsepAdditional=null;
	
	public DetalleAutoriConsepAdditional getDetalleAutoriConsepAdditional() {
		return this.detalleautoriconsepAdditional;
	}
	
	public void setDetalleAutoriConsepAdditional(DetalleAutoriConsepAdditional detalleautoriconsepAdditional) {
		try {
			this.detalleautoriconsepAdditional=detalleautoriconsepAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_autori_consep() {
		return this.id_autori_consep;
	}
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_producto() {
		return this.id_producto;
	}
    
	
	public Long getid_unidad() {
		return this.id_unidad;
	}
    
	
	public Double getcantidad_anio() {
		return this.cantidad_anio;
	}
    
	
	public Double getcantidad_saldo() {
		return this.cantidad_saldo;
	}
    
	
	public Long getid_estado_detalle_autori_consep() {
		return this.id_estado_detalle_autori_consep;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
	
    
	public void setid_autori_consep(Long newid_autori_consep)throws Exception
	{
		try {
			if(this.id_autori_consep!=newid_autori_consep) {
				if(newid_autori_consep==null) {
					//newid_autori_consep=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleAutoriConsep:Valor nulo no permitido en columna id_autori_consep");
					}
				}

				this.id_autori_consep=newid_autori_consep;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleAutoriConsep:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_producto(Long newid_producto)throws Exception
	{
		try {
			if(this.id_producto!=newid_producto) {
				if(newid_producto==null) {
					//newid_producto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleAutoriConsep:Valor nulo no permitido en columna id_producto");
					}
				}

				this.id_producto=newid_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_unidad(Long newid_unidad)throws Exception
	{
		try {
			if(this.id_unidad!=newid_unidad) {
				if(newid_unidad==null) {
					//newid_unidad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleAutoriConsep:Valor nulo no permitido en columna id_unidad");
					}
				}

				this.id_unidad=newid_unidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_anio(Double newcantidad_anio)throws Exception
	{
		try {
			if(this.cantidad_anio!=newcantidad_anio) {
				if(newcantidad_anio==null) {
					//newcantidad_anio=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleAutoriConsep:Valor nulo no permitido en columna cantidad_anio");
					}
				}

				this.cantidad_anio=newcantidad_anio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_saldo(Double newcantidad_saldo)throws Exception
	{
		try {
			if(this.cantidad_saldo!=newcantidad_saldo) {
				if(newcantidad_saldo==null) {
					//newcantidad_saldo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleAutoriConsep:Valor nulo no permitido en columna cantidad_saldo");
					}
				}

				this.cantidad_saldo=newcantidad_saldo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_detalle_autori_consep(Long newid_estado_detalle_autori_consep)throws Exception
	{
		try {
			if(this.id_estado_detalle_autori_consep!=newid_estado_detalle_autori_consep) {
				if(newid_estado_detalle_autori_consep==null) {
					//newid_estado_detalle_autori_consep=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleAutoriConsep:Valor nulo no permitido en columna id_estado_detalle_autori_consep");
					}
				}

				this.id_estado_detalle_autori_consep=newid_estado_detalle_autori_consep;
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
						System.out.println("DetalleAutoriConsep:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("DetalleAutoriConsep:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public AutoriConsep getAutoriConsep() {
		return this.autoriconsep;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public Unidad getUnidad() {
		return this.unidad;
	}

	public EstadoDetalleAutoriConsep getEstadoDetalleAutoriConsep() {
		return this.estadodetalleautoriconsep;
	}

	
	
	public String getautoriconsep_descripcion() {
		return this.autoriconsep_descripcion;
	}

	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getproducto_descripcion() {
		return this.producto_descripcion;
	}

	public String getunidad_descripcion() {
		return this.unidad_descripcion;
	}

	public String getestadodetalleautoriconsep_descripcion() {
		return this.estadodetalleautoriconsep_descripcion;
	}

	
	
	public  void  setAutoriConsep(AutoriConsep autoriconsep) {
		try {
			this.autoriconsep=autoriconsep;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setProducto(Producto producto) {
		try {
			this.producto=producto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setUnidad(Unidad unidad) {
		try {
			this.unidad=unidad;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoDetalleAutoriConsep(EstadoDetalleAutoriConsep estadodetalleautoriconsep) {
		try {
			this.estadodetalleautoriconsep=estadodetalleautoriconsep;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setautoriconsep_descripcion(String autoriconsep_descripcion) {
		try {
			this.autoriconsep_descripcion=autoriconsep_descripcion;
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


	public  void  setproducto_descripcion(String producto_descripcion) {
		try {
			this.producto_descripcion=producto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setunidad_descripcion(String unidad_descripcion) {
		try {
			this.unidad_descripcion=unidad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadodetalleautoriconsep_descripcion(String estadodetalleautoriconsep_descripcion) {
		try {
			this.estadodetalleautoriconsep_descripcion=estadodetalleautoriconsep_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_autori_consep_descripcion="";String id_empresa_descripcion="";String id_producto_descripcion="";String id_unidad_descripcion="";String id_estado_detalle_autori_consep_descripcion="";
	
	
	public String getid_autori_consep_descripcion() {
		return id_autori_consep_descripcion;
	}
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_producto_descripcion() {
		return id_producto_descripcion;
	}
	public String getid_unidad_descripcion() {
		return id_unidad_descripcion;
	}
	public String getid_estado_detalle_autori_consep_descripcion() {
		return id_estado_detalle_autori_consep_descripcion;
	}
	
	
	public void setid_autori_consep_descripcion(String newid_autori_consep_descripcion)throws Exception {
		try {
			this.id_autori_consep_descripcion=newid_autori_consep_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_producto_descripcion(String newid_producto_descripcion)throws Exception {
		try {
			this.id_producto_descripcion=newid_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_unidad_descripcion(String newid_unidad_descripcion)throws Exception {
		try {
			this.id_unidad_descripcion=newid_unidad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_detalle_autori_consep_descripcion(String newid_estado_detalle_autori_consep_descripcion)throws Exception {
		try {
			this.id_estado_detalle_autori_consep_descripcion=newid_estado_detalle_autori_consep_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_autori_consep_descripcion="";this.id_empresa_descripcion="";this.id_producto_descripcion="";this.id_unidad_descripcion="";this.id_estado_detalle_autori_consep_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

