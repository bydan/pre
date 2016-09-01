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
//import com.bydan.erp.inventario.util.DetallePlaneacionCompraConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class DetallePlaneacionCompra extends DetallePlaneacionCompraAdditional implements Serializable ,Cloneable {//DetallePlaneacionCompraAdditional,GeneralEntity
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
	
	private DetallePlaneacionCompra detalleplaneacioncompraOriginal;
	
	private Map<String, Object> mapDetallePlaneacionCompra;
			
	public Map<String, Object> getMapDetallePlaneacionCompra() {
		return mapDetallePlaneacionCompra;
	}

	public void setMapDetallePlaneacionCompra(Map<String, Object> mapDetallePlaneacionCompra) {
		this.mapDetallePlaneacionCompra = mapDetallePlaneacionCompra;
	}
	
	public void inicializarMapDetallePlaneacionCompra() {
		this.mapDetallePlaneacionCompra = new HashMap<String,Object>();
	}
	
	public void setMapDetallePlaneacionCompraValue(String sKey,Object oValue) {
		this.mapDetallePlaneacionCompra.put(sKey, oValue);
	}
	
	public Object getMapDetallePlaneacionCompraValue(String sKey) {
		return this.mapDetallePlaneacionCompra.get(sKey);
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
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_planeacion_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea;
	
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
	private Double stock;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer dia_minimo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double stock_minimo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer dia_maximo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double stock_maximo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double salida;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double stock_mensual;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetallePlaneacionCompraConstantesFunciones.SREGEXDESCRIPCION,message=DetallePlaneacionCompraConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public PlaneacionCompra planeacioncompra;
	public Linea linea;
	public Producto producto;
	public Unidad unidad;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String planeacioncompra_descripcion;
	private String linea_descripcion;
	private String producto_descripcion;
	private String unidad_descripcion;
	
	
		
	public DetallePlaneacionCompra () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detalleplaneacioncompraOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_planeacion_compra=-1L;
 		this.id_linea=-1L;
 		this.id_producto=-1L;
 		this.id_unidad=-1L;
 		this.stock=0.0;
 		this.dia_minimo=0;
 		this.stock_minimo=0.0;
 		this.dia_maximo=0;
 		this.stock_maximo=0.0;
 		this.salida=0.0;
 		this.stock_mensual=0.0;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.planeacioncompra=null;
		this.linea=null;
		this.producto=null;
		this.unidad=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.planeacioncompra_descripcion="";
		this.linea_descripcion="";
		this.producto_descripcion="";
		this.unidad_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetallePlaneacionCompra (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_planeacion_compra,Long id_linea,Long id_producto,Long id_unidad,Double stock,Integer dia_minimo,Double stock_minimo,Integer dia_maximo,Double stock_maximo,Double salida,Double stock_mensual,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleplaneacioncompraOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_planeacion_compra=id_planeacion_compra;
 		this.id_linea=id_linea;
 		this.id_producto=id_producto;
 		this.id_unidad=id_unidad;
 		this.stock=stock;
 		this.dia_minimo=dia_minimo;
 		this.stock_minimo=stock_minimo;
 		this.dia_maximo=dia_maximo;
 		this.stock_maximo=stock_maximo;
 		this.salida=salida;
 		this.stock_mensual=stock_mensual;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetallePlaneacionCompra (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_planeacion_compra,Long id_linea,Long id_producto,Long id_unidad,Double stock,Integer dia_minimo,Double stock_minimo,Integer dia_maximo,Double stock_maximo,Double salida,Double stock_mensual,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleplaneacioncompraOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_planeacion_compra=id_planeacion_compra;
 		this.id_linea=id_linea;
 		this.id_producto=id_producto;
 		this.id_unidad=id_unidad;
 		this.stock=stock;
 		this.dia_minimo=dia_minimo;
 		this.stock_minimo=stock_minimo;
 		this.dia_maximo=dia_maximo;
 		this.stock_maximo=stock_maximo;
 		this.salida=salida;
 		this.stock_mensual=stock_mensual;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetallePlaneacionCompra detalleplaneacioncompraLocal=null;
		
		if(object!=null) {
			detalleplaneacioncompraLocal=(DetallePlaneacionCompra)object;
			
			if(detalleplaneacioncompraLocal!=null) {
				if(this.getId()!=null && detalleplaneacioncompraLocal.getId()!=null) {
					if(this.getId().equals(detalleplaneacioncompraLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetallePlaneacionCompraConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetallePlaneacionCompraConstantesFunciones.getDetallePlaneacionCompraDescripcion(this);
		} else {
			sDetalle=DetallePlaneacionCompraConstantesFunciones.getDetallePlaneacionCompraDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetallePlaneacionCompra getDetallePlaneacionCompraOriginal() {
		return this.detalleplaneacioncompraOriginal;
	}
	
	public void setDetallePlaneacionCompraOriginal(DetallePlaneacionCompra detalleplaneacioncompra) {
		try {
			this.detalleplaneacioncompraOriginal=detalleplaneacioncompra;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetallePlaneacionCompraAdditional detalleplaneacioncompraAdditional=null;
	
	public DetallePlaneacionCompraAdditional getDetallePlaneacionCompraAdditional() {
		return this.detalleplaneacioncompraAdditional;
	}
	
	public void setDetallePlaneacionCompraAdditional(DetallePlaneacionCompraAdditional detalleplaneacioncompraAdditional) {
		try {
			this.detalleplaneacioncompraAdditional=detalleplaneacioncompraAdditional;
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
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public Long getid_planeacion_compra() {
		return this.id_planeacion_compra;
	}
    
	
	public Long getid_linea() {
		return this.id_linea;
	}
    
	
	public Long getid_producto() {
		return this.id_producto;
	}
    
	
	public Long getid_unidad() {
		return this.id_unidad;
	}
    
	
	public Double getstock() {
		return this.stock;
	}
    
	
	public Integer getdia_minimo() {
		return this.dia_minimo;
	}
    
	
	public Double getstock_minimo() {
		return this.stock_minimo;
	}
    
	
	public Integer getdia_maximo() {
		return this.dia_maximo;
	}
    
	
	public Double getstock_maximo() {
		return this.stock_maximo;
	}
    
	
	public Double getsalida() {
		return this.salida;
	}
    
	
	public Double getstock_mensual() {
		return this.stock_mensual;
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
						System.out.println("DetallePlaneacionCompra:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("DetallePlaneacionCompra:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ejercicio(Long newid_ejercicio)throws Exception
	{
		try {
			if(this.id_ejercicio!=newid_ejercicio) {
				if(newid_ejercicio==null) {
					//newid_ejercicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePlaneacionCompra:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_periodo(Long newid_periodo)throws Exception
	{
		try {
			if(this.id_periodo!=newid_periodo) {
				if(newid_periodo==null) {
					//newid_periodo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePlaneacionCompra:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_planeacion_compra(Long newid_planeacion_compra)throws Exception
	{
		try {
			if(this.id_planeacion_compra!=newid_planeacion_compra) {
				if(newid_planeacion_compra==null) {
					//newid_planeacion_compra=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePlaneacionCompra:Valor nulo no permitido en columna id_planeacion_compra");
					}
				}

				this.id_planeacion_compra=newid_planeacion_compra;
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
						System.out.println("DetallePlaneacionCompra:Valor nulo no permitido en columna id_linea");
					}
				}

				this.id_linea=newid_linea;
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
						System.out.println("DetallePlaneacionCompra:Valor nulo no permitido en columna id_producto");
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
						System.out.println("DetallePlaneacionCompra:Valor nulo no permitido en columna id_unidad");
					}
				}

				this.id_unidad=newid_unidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setstock(Double newstock)throws Exception
	{
		try {
			if(this.stock!=newstock) {
				if(newstock==null) {
					//newstock=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePlaneacionCompra:Valor nulo no permitido en columna stock");
					}
				}

				this.stock=newstock;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdia_minimo(Integer newdia_minimo)throws Exception
	{
		try {
			if(this.dia_minimo!=newdia_minimo) {
				if(newdia_minimo==null) {
					//newdia_minimo=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePlaneacionCompra:Valor nulo no permitido en columna dia_minimo");
					}
				}

				this.dia_minimo=newdia_minimo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setstock_minimo(Double newstock_minimo)throws Exception
	{
		try {
			if(this.stock_minimo!=newstock_minimo) {
				if(newstock_minimo==null) {
					//newstock_minimo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePlaneacionCompra:Valor nulo no permitido en columna stock_minimo");
					}
				}

				this.stock_minimo=newstock_minimo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdia_maximo(Integer newdia_maximo)throws Exception
	{
		try {
			if(this.dia_maximo!=newdia_maximo) {
				if(newdia_maximo==null) {
					//newdia_maximo=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePlaneacionCompra:Valor nulo no permitido en columna dia_maximo");
					}
				}

				this.dia_maximo=newdia_maximo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setstock_maximo(Double newstock_maximo)throws Exception
	{
		try {
			if(this.stock_maximo!=newstock_maximo) {
				if(newstock_maximo==null) {
					//newstock_maximo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePlaneacionCompra:Valor nulo no permitido en columna stock_maximo");
					}
				}

				this.stock_maximo=newstock_maximo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsalida(Double newsalida)throws Exception
	{
		try {
			if(this.salida!=newsalida) {
				if(newsalida==null) {
					//newsalida=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePlaneacionCompra:Valor nulo no permitido en columna salida");
					}
				}

				this.salida=newsalida;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setstock_mensual(Double newstock_mensual)throws Exception
	{
		try {
			if(this.stock_mensual!=newstock_mensual) {
				if(newstock_mensual==null) {
					//newstock_mensual=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePlaneacionCompra:Valor nulo no permitido en columna stock_mensual");
					}
				}

				this.stock_mensual=newstock_mensual;
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
						System.out.println("DetallePlaneacionCompra:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>250) {
					newdescripcion=newdescripcion.substring(0,248);
					System.out.println("DetallePlaneacionCompra:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna descripcion");
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

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public PlaneacionCompra getPlaneacionCompra() {
		return this.planeacioncompra;
	}

	public Linea getLinea() {
		return this.linea;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public Unidad getUnidad() {
		return this.unidad;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
	}

	public String getplaneacioncompra_descripcion() {
		return this.planeacioncompra_descripcion;
	}

	public String getlinea_descripcion() {
		return this.linea_descripcion;
	}

	public String getproducto_descripcion() {
		return this.producto_descripcion;
	}

	public String getunidad_descripcion() {
		return this.unidad_descripcion;
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


	public  void  setEjercicio(Ejercicio ejercicio) {
		try {
			this.ejercicio=ejercicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPeriodo(Periodo periodo) {
		try {
			this.periodo=periodo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPlaneacionCompra(PlaneacionCompra planeacioncompra) {
		try {
			this.planeacioncompra=planeacioncompra;
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


	public  void  setejercicio_descripcion(String ejercicio_descripcion) {
		try {
			this.ejercicio_descripcion=ejercicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setperiodo_descripcion(String periodo_descripcion) {
		try {
			this.periodo_descripcion=periodo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setplaneacioncompra_descripcion(String planeacioncompra_descripcion) {
		try {
			this.planeacioncompra_descripcion=planeacioncompra_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_planeacion_compra_descripcion="";String id_linea_descripcion="";String id_producto_descripcion="";String id_unidad_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	public String getid_planeacion_compra_descripcion() {
		return id_planeacion_compra_descripcion;
	}
	public String getid_linea_descripcion() {
		return id_linea_descripcion;
	}
	public String getid_producto_descripcion() {
		return id_producto_descripcion;
	}
	public String getid_unidad_descripcion() {
		return id_unidad_descripcion;
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
	public void setid_ejercicio_descripcion(String newid_ejercicio_descripcion)throws Exception {
		try {
			this.id_ejercicio_descripcion=newid_ejercicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_periodo_descripcion(String newid_periodo_descripcion)throws Exception {
		try {
			this.id_periodo_descripcion=newid_periodo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_planeacion_compra_descripcion(String newid_planeacion_compra_descripcion)throws Exception {
		try {
			this.id_planeacion_compra_descripcion=newid_planeacion_compra_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_planeacion_compra_descripcion="";this.id_linea_descripcion="";this.id_producto_descripcion="";this.id_unidad_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

