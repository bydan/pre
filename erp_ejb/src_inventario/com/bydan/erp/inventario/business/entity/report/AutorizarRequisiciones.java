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
package com.bydan.erp.inventario.business.entity.report;

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
//import com.bydan.erp.inventario.util.AutorizarRequisicionesConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class AutorizarRequisiciones extends AutorizarRequisicionesAdditional implements Serializable ,Cloneable {//AutorizarRequisicionesAdditional,GeneralEntity
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
	
	private AutorizarRequisiciones autorizarrequisicionesOriginal;
	
	private Map<String, Object> mapAutorizarRequisiciones;
			
	public Map<String, Object> getMapAutorizarRequisiciones() {
		return mapAutorizarRequisiciones;
	}

	public void setMapAutorizarRequisiciones(Map<String, Object> mapAutorizarRequisiciones) {
		this.mapAutorizarRequisiciones = mapAutorizarRequisiciones;
	}
	
	public void inicializarMapAutorizarRequisiciones() {
		this.mapAutorizarRequisiciones = new HashMap<String,Object>();
	}
	
	public void setMapAutorizarRequisicionesValue(String sKey,Object oValue) {
		this.mapAutorizarRequisiciones.put(sKey, oValue);
	}
	
	public Object getMapAutorizarRequisicionesValue(String sKey) {
		return this.mapAutorizarRequisiciones.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AutorizarRequisicionesConstantesFunciones.SREGEXCODIGO_TIPO_REQUISICION,message=AutorizarRequisicionesConstantesFunciones.SMENSAJEREGEXCODIGO_TIPO_REQUISICION)
	private String codigo_tipo_requisicion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AutorizarRequisicionesConstantesFunciones.SREGEXCODIGO,message=AutorizarRequisicionesConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AutorizarRequisicionesConstantesFunciones.SREGEXNOMBRE_COMPLETO_CLIENTE,message=AutorizarRequisicionesConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE)
	private String nombre_completo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AutorizarRequisicionesConstantesFunciones.SREGEXNOMBRE_BODEGA,message=AutorizarRequisicionesConstantesFunciones.SMENSAJEREGEXNOMBRE_BODEGA)
	private String nombre_bodega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AutorizarRequisicionesConstantesFunciones.SREGEXNOMBRE_PRODUCTO,message=AutorizarRequisicionesConstantesFunciones.SMENSAJEREGEXNOMBRE_PRODUCTO)
	private String nombre_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long cantidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_autoriza;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	
	
		
	public AutorizarRequisiciones () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.autorizarrequisicionesOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.fecha_desde=new Date();
 		this.fecha_hasta=new Date();
 		this.codigo_tipo_requisicion="";
 		this.codigo="";
 		this.fecha=new Date();
 		this.nombre_completo_cliente="";
 		this.nombre_bodega="";
 		this.nombre_producto="";
 		this.cantidad=0L;
 		this.fecha_autoriza=new Date();
		
		
		this.empresa=null;
		this.sucursal=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public AutorizarRequisiciones (Long id,Date versionRow,String codigo_tipo_requisicion,String codigo,Date fecha,String nombre_completo_cliente,String nombre_bodega,String nombre_producto,Long cantidad,Date fecha_autoriza) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.autorizarrequisicionesOriginal=this;
		
 		this.codigo_tipo_requisicion=codigo_tipo_requisicion;
 		this.codigo=codigo;
 		this.fecha=fecha;
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.nombre_bodega=nombre_bodega;
 		this.nombre_producto=nombre_producto;
 		this.cantidad=cantidad;
 		this.fecha_autoriza=fecha_autoriza;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public AutorizarRequisiciones (String codigo_tipo_requisicion,String codigo,Date fecha,String nombre_completo_cliente,String nombre_bodega,String nombre_producto,Long cantidad,Date fecha_autoriza) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.autorizarrequisicionesOriginal=this;
		
 		this.codigo_tipo_requisicion=codigo_tipo_requisicion;
 		this.codigo=codigo;
 		this.fecha=fecha;
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.nombre_bodega=nombre_bodega;
 		this.nombre_producto=nombre_producto;
 		this.cantidad=cantidad;
 		this.fecha_autoriza=fecha_autoriza;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public AutorizarRequisiciones getAutorizarRequisicionesOriginal() {
		return this.autorizarrequisicionesOriginal;
	}
	
	public void setAutorizarRequisicionesOriginal(AutorizarRequisiciones autorizarrequisiciones) {
		try {
			this.autorizarrequisicionesOriginal=autorizarrequisiciones;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected AutorizarRequisicionesAdditional autorizarrequisicionesAdditional=null;
	
	public AutorizarRequisicionesAdditional getAutorizarRequisicionesAdditional() {
		return this.autorizarrequisicionesAdditional;
	}
	
	public void setAutorizarRequisicionesAdditional(AutorizarRequisicionesAdditional autorizarrequisicionesAdditional) {
		try {
			this.autorizarrequisicionesAdditional=autorizarrequisicionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Date getfecha_desde() {
		return this.fecha_desde;
	}
    
	
	public Date getfecha_hasta() {
		return this.fecha_hasta;
	}
    
	
	public String getcodigo_tipo_requisicion() {
		return this.codigo_tipo_requisicion;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public String getnombre_completo_cliente() {
		return this.nombre_completo_cliente;
	}
    
	
	public String getnombre_bodega() {
		return this.nombre_bodega;
	}
    
	
	public String getnombre_producto() {
		return this.nombre_producto;
	}
    
	
	public Long getcantidad() {
		return this.cantidad;
	}
    
	
	public Date getfecha_autoriza() {
		return this.fecha_autoriza;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutorizarRequisiciones:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal(Long newid_sucursal)throws Exception
	{
		try {
			if(this.id_sucursal!=newid_sucursal) {
				if(newid_sucursal==null) {
					//newid_sucursal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutorizarRequisiciones:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_desde(Date newfecha_desde)throws Exception
	{
		try {
			if(this.fecha_desde!=newfecha_desde) {
				if(newfecha_desde==null) {
					//newfecha_desde=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutorizarRequisiciones:Valor nulo no permitido en columna fecha_desde");
					}
				}

				this.fecha_desde=newfecha_desde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_hasta(Date newfecha_hasta)throws Exception
	{
		try {
			if(this.fecha_hasta!=newfecha_hasta) {
				if(newfecha_hasta==null) {
					//newfecha_hasta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutorizarRequisiciones:Valor nulo no permitido en columna fecha_hasta");
					}
				}

				this.fecha_hasta=newfecha_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_tipo_requisicion(String newcodigo_tipo_requisicion)throws Exception
	{
		try {
			if(this.codigo_tipo_requisicion!=newcodigo_tipo_requisicion) {
				if(newcodigo_tipo_requisicion==null) {
					//newcodigo_tipo_requisicion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutorizarRequisiciones:Valor nulo no permitido en columna codigo_tipo_requisicion");
					}
				}

				if(newcodigo_tipo_requisicion!=null&&newcodigo_tipo_requisicion.length()>50) {
					newcodigo_tipo_requisicion=newcodigo_tipo_requisicion.substring(0,48);
					System.out.println("AutorizarRequisiciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_tipo_requisicion");
				}

				this.codigo_tipo_requisicion=newcodigo_tipo_requisicion;
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
						System.out.println("AutorizarRequisiciones:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("AutorizarRequisiciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutorizarRequisiciones:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_completo_cliente(String newnombre_completo_cliente)throws Exception
	{
		try {
			if(this.nombre_completo_cliente!=newnombre_completo_cliente) {
				if(newnombre_completo_cliente==null) {
					//newnombre_completo_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutorizarRequisiciones:Valor nulo no permitido en columna nombre_completo_cliente");
					}
				}

				if(newnombre_completo_cliente!=null&&newnombre_completo_cliente.length()>150) {
					newnombre_completo_cliente=newnombre_completo_cliente.substring(0,148);
					System.out.println("AutorizarRequisiciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_completo_cliente");
				}

				this.nombre_completo_cliente=newnombre_completo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_bodega(String newnombre_bodega)throws Exception
	{
		try {
			if(this.nombre_bodega!=newnombre_bodega) {
				if(newnombre_bodega==null) {
					//newnombre_bodega="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutorizarRequisiciones:Valor nulo no permitido en columna nombre_bodega");
					}
				}

				if(newnombre_bodega!=null&&newnombre_bodega.length()>150) {
					newnombre_bodega=newnombre_bodega.substring(0,148);
					System.out.println("AutorizarRequisiciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_bodega");
				}

				this.nombre_bodega=newnombre_bodega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_producto(String newnombre_producto)throws Exception
	{
		try {
			if(this.nombre_producto!=newnombre_producto) {
				if(newnombre_producto==null) {
					//newnombre_producto="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutorizarRequisiciones:Valor nulo no permitido en columna nombre_producto");
					}
				}

				if(newnombre_producto!=null&&newnombre_producto.length()>150) {
					newnombre_producto=newnombre_producto.substring(0,148);
					System.out.println("AutorizarRequisiciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_producto");
				}

				this.nombre_producto=newnombre_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad(Long newcantidad)throws Exception
	{
		try {
			if(this.cantidad!=newcantidad) {
				if(newcantidad==null) {
					//newcantidad=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutorizarRequisiciones:Valor nulo no permitido en columna cantidad");
					}
				}

				this.cantidad=newcantidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_autoriza(Date newfecha_autoriza)throws Exception
	{
		try {
			if(this.fecha_autoriza!=newfecha_autoriza) {
				if(newfecha_autoriza==null) {
					//newfecha_autoriza=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutorizarRequisiciones:Valor nulo no permitido en columna fecha_autoriza");
					}
				}

				this.fecha_autoriza=newfecha_autoriza;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

