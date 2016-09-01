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
//import com.bydan.erp.inventario.util.ParametroInvenConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ParametroInven extends ParametroInvenAdditional implements Serializable ,Cloneable {//ParametroInvenAdditional,GeneralEntity
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
	
	private ParametroInven parametroinvenOriginal;
	
	private Map<String, Object> mapParametroInven;
			
	public Map<String, Object> getMapParametroInven() {
		return mapParametroInven;
	}

	public void setMapParametroInven(Map<String, Object> mapParametroInven) {
		this.mapParametroInven = mapParametroInven;
	}
	
	public void inicializarMapParametroInven() {
		this.mapParametroInven = new HashMap<String,Object>();
	}
	
	public void setMapParametroInvenValue(String sKey,Object oValue) {
		this.mapParametroInven.put(sKey, oValue);
	}
	
	public Object getMapParametroInvenValue(String sKey) {
		return this.mapParametroInven.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer secuencial_pedido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_serie;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_decimales;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_items_requisicion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_cuenta_contable_linea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_cuenta_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_copiar_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_crear_producto_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_crear_lista_precio_sucursal_bodega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_compras_aprobacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_envio_mail;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public ParametroInven () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametroinvenOriginal=this;
		
 		this.id_empresa=-1L;
 		this.secuencial_pedido=0;
 		this.numero_serie=0;
 		this.numero_decimales=0;
 		this.numero_items_requisicion=0;
 		this.con_cuenta_contable=false;
 		this.con_cuenta_contable_linea=false;
 		this.con_cuenta_banco=false;
 		this.con_copiar_producto=false;
 		this.con_crear_producto_sucursal=false;
 		this.con_crear_lista_precio_sucursal_bodega=false;
 		this.con_compras_aprobacion=false;
 		this.con_envio_mail=false;
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroInven (Long id,Date versionRow,Long id_empresa,Integer secuencial_pedido,Integer numero_serie,Integer numero_decimales,Integer numero_items_requisicion,Boolean con_cuenta_contable,Boolean con_cuenta_contable_linea,Boolean con_cuenta_banco,Boolean con_copiar_producto,Boolean con_crear_producto_sucursal,Boolean con_crear_lista_precio_sucursal_bodega,Boolean con_compras_aprobacion,Boolean con_envio_mail) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametroinvenOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.secuencial_pedido=secuencial_pedido;
 		this.numero_serie=numero_serie;
 		this.numero_decimales=numero_decimales;
 		this.numero_items_requisicion=numero_items_requisicion;
 		this.con_cuenta_contable=con_cuenta_contable;
 		this.con_cuenta_contable_linea=con_cuenta_contable_linea;
 		this.con_cuenta_banco=con_cuenta_banco;
 		this.con_copiar_producto=con_copiar_producto;
 		this.con_crear_producto_sucursal=con_crear_producto_sucursal;
 		this.con_crear_lista_precio_sucursal_bodega=con_crear_lista_precio_sucursal_bodega;
 		this.con_compras_aprobacion=con_compras_aprobacion;
 		this.con_envio_mail=con_envio_mail;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroInven (Long id_empresa,Integer secuencial_pedido,Integer numero_serie,Integer numero_decimales,Integer numero_items_requisicion,Boolean con_cuenta_contable,Boolean con_cuenta_contable_linea,Boolean con_cuenta_banco,Boolean con_copiar_producto,Boolean con_crear_producto_sucursal,Boolean con_crear_lista_precio_sucursal_bodega,Boolean con_compras_aprobacion,Boolean con_envio_mail) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametroinvenOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.secuencial_pedido=secuencial_pedido;
 		this.numero_serie=numero_serie;
 		this.numero_decimales=numero_decimales;
 		this.numero_items_requisicion=numero_items_requisicion;
 		this.con_cuenta_contable=con_cuenta_contable;
 		this.con_cuenta_contable_linea=con_cuenta_contable_linea;
 		this.con_cuenta_banco=con_cuenta_banco;
 		this.con_copiar_producto=con_copiar_producto;
 		this.con_crear_producto_sucursal=con_crear_producto_sucursal;
 		this.con_crear_lista_precio_sucursal_bodega=con_crear_lista_precio_sucursal_bodega;
 		this.con_compras_aprobacion=con_compras_aprobacion;
 		this.con_envio_mail=con_envio_mail;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroInven parametroinvenLocal=null;
		
		if(object!=null) {
			parametroinvenLocal=(ParametroInven)object;
			
			if(parametroinvenLocal!=null) {
				if(this.getId()!=null && parametroinvenLocal.getId()!=null) {
					if(this.getId().equals(parametroinvenLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroInvenConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroInvenConstantesFunciones.getParametroInvenDescripcion(this);
		} else {
			sDetalle=ParametroInvenConstantesFunciones.getParametroInvenDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroInven getParametroInvenOriginal() {
		return this.parametroinvenOriginal;
	}
	
	public void setParametroInvenOriginal(ParametroInven parametroinven) {
		try {
			this.parametroinvenOriginal=parametroinven;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroInvenAdditional parametroinvenAdditional=null;
	
	public ParametroInvenAdditional getParametroInvenAdditional() {
		return this.parametroinvenAdditional;
	}
	
	public void setParametroInvenAdditional(ParametroInvenAdditional parametroinvenAdditional) {
		try {
			this.parametroinvenAdditional=parametroinvenAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Integer getsecuencial_pedido() {
		return this.secuencial_pedido;
	}
    
	
	public Integer getnumero_serie() {
		return this.numero_serie;
	}
    
	
	public Integer getnumero_decimales() {
		return this.numero_decimales;
	}
    
	
	public Integer getnumero_items_requisicion() {
		return this.numero_items_requisicion;
	}
    
	
	public Boolean getcon_cuenta_contable() {
		return this.con_cuenta_contable;
	}
    
	
	public Boolean getcon_cuenta_contable_linea() {
		return this.con_cuenta_contable_linea;
	}
    
	
	public Boolean getcon_cuenta_banco() {
		return this.con_cuenta_banco;
	}
    
	
	public Boolean getcon_copiar_producto() {
		return this.con_copiar_producto;
	}
    
	
	public Boolean getcon_crear_producto_sucursal() {
		return this.con_crear_producto_sucursal;
	}
    
	
	public Boolean getcon_crear_lista_precio_sucursal_bodega() {
		return this.con_crear_lista_precio_sucursal_bodega;
	}
    
	
	public Boolean getcon_compras_aprobacion() {
		return this.con_compras_aprobacion;
	}
    
	
	public Boolean getcon_envio_mail() {
		return this.con_envio_mail;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInven:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial_pedido(Integer newsecuencial_pedido)throws Exception
	{
		try {
			if(this.secuencial_pedido!=newsecuencial_pedido) {
				if(newsecuencial_pedido==null) {
					//newsecuencial_pedido=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInven:Valor nulo no permitido en columna secuencial_pedido");
					}
				}

				this.secuencial_pedido=newsecuencial_pedido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_serie(Integer newnumero_serie)throws Exception
	{
		try {
			if(this.numero_serie!=newnumero_serie) {
				if(newnumero_serie==null) {
					//newnumero_serie=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInven:Valor nulo no permitido en columna numero_serie");
					}
				}

				this.numero_serie=newnumero_serie;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_decimales(Integer newnumero_decimales)throws Exception
	{
		try {
			if(this.numero_decimales!=newnumero_decimales) {
				if(newnumero_decimales==null) {
					//newnumero_decimales=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInven:Valor nulo no permitido en columna numero_decimales");
					}
				}

				this.numero_decimales=newnumero_decimales;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_items_requisicion(Integer newnumero_items_requisicion)throws Exception
	{
		try {
			if(this.numero_items_requisicion!=newnumero_items_requisicion) {
				if(newnumero_items_requisicion==null) {
					//newnumero_items_requisicion=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInven:Valor nulo no permitido en columna numero_items_requisicion");
					}
				}

				this.numero_items_requisicion=newnumero_items_requisicion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_cuenta_contable(Boolean newcon_cuenta_contable)throws Exception
	{
		try {
			if(this.con_cuenta_contable!=newcon_cuenta_contable) {
				if(newcon_cuenta_contable==null) {
					//newcon_cuenta_contable=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInven:Valor nulo no permitido en columna con_cuenta_contable");
					}
				}

				this.con_cuenta_contable=newcon_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_cuenta_contable_linea(Boolean newcon_cuenta_contable_linea)throws Exception
	{
		try {
			if(this.con_cuenta_contable_linea!=newcon_cuenta_contable_linea) {
				if(newcon_cuenta_contable_linea==null) {
					//newcon_cuenta_contable_linea=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInven:Valor nulo no permitido en columna con_cuenta_contable_linea");
					}
				}

				this.con_cuenta_contable_linea=newcon_cuenta_contable_linea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_cuenta_banco(Boolean newcon_cuenta_banco)throws Exception
	{
		try {
			if(this.con_cuenta_banco!=newcon_cuenta_banco) {
				if(newcon_cuenta_banco==null) {
					//newcon_cuenta_banco=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInven:Valor nulo no permitido en columna con_cuenta_banco");
					}
				}

				this.con_cuenta_banco=newcon_cuenta_banco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_copiar_producto(Boolean newcon_copiar_producto)throws Exception
	{
		try {
			if(this.con_copiar_producto!=newcon_copiar_producto) {
				if(newcon_copiar_producto==null) {
					//newcon_copiar_producto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInven:Valor nulo no permitido en columna con_copiar_producto");
					}
				}

				this.con_copiar_producto=newcon_copiar_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_crear_producto_sucursal(Boolean newcon_crear_producto_sucursal)throws Exception
	{
		try {
			if(this.con_crear_producto_sucursal!=newcon_crear_producto_sucursal) {
				if(newcon_crear_producto_sucursal==null) {
					//newcon_crear_producto_sucursal=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInven:Valor nulo no permitido en columna con_crear_producto_sucursal");
					}
				}

				this.con_crear_producto_sucursal=newcon_crear_producto_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_crear_lista_precio_sucursal_bodega(Boolean newcon_crear_lista_precio_sucursal_bodega)throws Exception
	{
		try {
			if(this.con_crear_lista_precio_sucursal_bodega!=newcon_crear_lista_precio_sucursal_bodega) {
				if(newcon_crear_lista_precio_sucursal_bodega==null) {
					//newcon_crear_lista_precio_sucursal_bodega=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInven:Valor nulo no permitido en columna con_crear_lista_precio_sucursal_bodega");
					}
				}

				this.con_crear_lista_precio_sucursal_bodega=newcon_crear_lista_precio_sucursal_bodega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_compras_aprobacion(Boolean newcon_compras_aprobacion)throws Exception
	{
		try {
			if(this.con_compras_aprobacion!=newcon_compras_aprobacion) {
				if(newcon_compras_aprobacion==null) {
					//newcon_compras_aprobacion=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInven:Valor nulo no permitido en columna con_compras_aprobacion");
					}
				}

				this.con_compras_aprobacion=newcon_compras_aprobacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_envio_mail(Boolean newcon_envio_mail)throws Exception
	{
		try {
			if(this.con_envio_mail!=newcon_envio_mail) {
				if(newcon_envio_mail==null) {
					//newcon_envio_mail=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInven:Valor nulo no permitido en columna con_envio_mail");
					}
				}

				this.con_envio_mail=newcon_envio_mail;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String con_cuenta_contable_descripcion="";String con_cuenta_contable_linea_descripcion="";String con_cuenta_banco_descripcion="";String con_copiar_producto_descripcion="";String con_crear_producto_sucursal_descripcion="";String con_crear_lista_precio_sucursal_bodega_descripcion="";String con_compras_aprobacion_descripcion="";String con_envio_mail_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getcon_cuenta_contable_descripcion() {
		return con_cuenta_contable_descripcion;
	}
	public String getcon_cuenta_contable_linea_descripcion() {
		return con_cuenta_contable_linea_descripcion;
	}
	public String getcon_cuenta_banco_descripcion() {
		return con_cuenta_banco_descripcion;
	}
	public String getcon_copiar_producto_descripcion() {
		return con_copiar_producto_descripcion;
	}
	public String getcon_crear_producto_sucursal_descripcion() {
		return con_crear_producto_sucursal_descripcion;
	}
	public String getcon_crear_lista_precio_sucursal_bodega_descripcion() {
		return con_crear_lista_precio_sucursal_bodega_descripcion;
	}
	public String getcon_compras_aprobacion_descripcion() {
		return con_compras_aprobacion_descripcion;
	}
	public String getcon_envio_mail_descripcion() {
		return con_envio_mail_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_cuenta_contable_descripcion(String newcon_cuenta_contable_descripcion)throws Exception {
		try {
			this.con_cuenta_contable_descripcion=newcon_cuenta_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_cuenta_contable_linea_descripcion(String newcon_cuenta_contable_linea_descripcion)throws Exception {
		try {
			this.con_cuenta_contable_linea_descripcion=newcon_cuenta_contable_linea_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_cuenta_banco_descripcion(String newcon_cuenta_banco_descripcion)throws Exception {
		try {
			this.con_cuenta_banco_descripcion=newcon_cuenta_banco_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_copiar_producto_descripcion(String newcon_copiar_producto_descripcion)throws Exception {
		try {
			this.con_copiar_producto_descripcion=newcon_copiar_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_crear_producto_sucursal_descripcion(String newcon_crear_producto_sucursal_descripcion)throws Exception {
		try {
			this.con_crear_producto_sucursal_descripcion=newcon_crear_producto_sucursal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_crear_lista_precio_sucursal_bodega_descripcion(String newcon_crear_lista_precio_sucursal_bodega_descripcion)throws Exception {
		try {
			this.con_crear_lista_precio_sucursal_bodega_descripcion=newcon_crear_lista_precio_sucursal_bodega_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_compras_aprobacion_descripcion(String newcon_compras_aprobacion_descripcion)throws Exception {
		try {
			this.con_compras_aprobacion_descripcion=newcon_compras_aprobacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_envio_mail_descripcion(String newcon_envio_mail_descripcion)throws Exception {
		try {
			this.con_envio_mail_descripcion=newcon_envio_mail_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.con_cuenta_contable_descripcion="";this.con_cuenta_contable_linea_descripcion="";this.con_cuenta_banco_descripcion="";this.con_copiar_producto_descripcion="";this.con_crear_producto_sucursal_descripcion="";this.con_crear_lista_precio_sucursal_bodega_descripcion="";this.con_compras_aprobacion_descripcion="";this.con_envio_mail_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

