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
package com.bydan.erp.importaciones.business.entity;

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
//import com.bydan.erp.importaciones.util.DetallePedidoCompraImporConstantesFunciones;
import com.bydan.erp.importaciones.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class DetallePedidoCompraImpor extends DetallePedidoCompraImporAdditional implements Serializable ,Cloneable {//DetallePedidoCompraImporAdditional,GeneralEntity
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
	
	private DetallePedidoCompraImpor detallepedidocompraimporOriginal;
	
	private Map<String, Object> mapDetallePedidoCompraImpor;
			
	public Map<String, Object> getMapDetallePedidoCompraImpor() {
		return mapDetallePedidoCompraImpor;
	}

	public void setMapDetallePedidoCompraImpor(Map<String, Object> mapDetallePedidoCompraImpor) {
		this.mapDetallePedidoCompraImpor = mapDetallePedidoCompraImpor;
	}
	
	public void inicializarMapDetallePedidoCompraImpor() {
		this.mapDetallePedidoCompraImpor = new HashMap<String,Object>();
	}
	
	public void setMapDetallePedidoCompraImporValue(String sKey,Object oValue) {
		this.mapDetallePedidoCompraImpor.put(sKey, oValue);
	}
	
	public Object getMapDetallePedidoCompraImporValue(String sKey) {
		return this.mapDetallePedidoCompraImpor.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pedido_compra_impor;
	
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
	private Long id_bodega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_unidad;
	
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
	private Long id_arancel;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad_pedido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad_entra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad_pendiente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double peso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetallePedidoCompraImporConstantesFunciones.SREGEXLOTE,message=DetallePedidoCompraImporConstantesFunciones.SMENSAJEREGEXLOTE)
	private String lote;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_arancel;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad_unidad_auxiliar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double precio_unidad_auxiliar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double fob;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double fob_exw;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetallePedidoCompraImporConstantesFunciones.SREGEXDESCRIPCION,message=DetallePedidoCompraImporConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_centro_costo;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
			
	
	public PedidoCompraImpor pedidocompraimpor;
	public Empresa empresa;
	public Sucursal sucursal;
	public Bodega bodega;
	public Producto producto;
	public Unidad unidad;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Arancel arancel;
	public CentroCosto centrocosto;
	public Anio anio;
	public Mes mes;
	
	
	private String pedidocompraimpor_descripcion;
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String bodega_descripcion;
	private String producto_descripcion;
	private String unidad_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String arancel_descripcion;
	private String centrocosto_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	
	
		
	public DetallePedidoCompraImpor () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detallepedidocompraimporOriginal=this;
		
 		this.id_pedido_compra_impor=-1L;
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_bodega=-1L;
 		this.id_producto=-1L;
 		this.id_unidad=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_arancel=-1L;
 		this.cantidad_pedido=0;
 		this.cantidad_entra=0;
 		this.cantidad_pendiente=0;
 		this.porcentaje=0.0;
 		this.peso=0.0;
 		this.precio=0.0;
 		this.lote="";
 		this.porcentaje_arancel=0.0;
 		this.cantidad_unidad_auxiliar=0;
 		this.precio_unidad_auxiliar=0.0;
 		this.fob=0.0;
 		this.fob_exw=0.0;
 		this.total=0.0;
 		this.descripcion="";
 		this.id_centro_costo=null;
 		this.id_anio=null;
 		this.id_mes=null;
		
		
		this.pedidocompraimpor=null;
		this.empresa=null;
		this.sucursal=null;
		this.bodega=null;
		this.producto=null;
		this.unidad=null;
		this.ejercicio=null;
		this.periodo=null;
		this.arancel=null;
		this.centrocosto=null;
		this.anio=null;
		this.mes=null;
		
		
		this.pedidocompraimpor_descripcion="";
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.bodega_descripcion="";
		this.producto_descripcion="";
		this.unidad_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.arancel_descripcion="";
		this.centrocosto_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetallePedidoCompraImpor (Long id,Date versionRow,Long id_pedido_compra_impor,Long id_empresa,Long id_sucursal,Long id_bodega,Long id_producto,Long id_unidad,Long id_ejercicio,Long id_periodo,Long id_arancel,Integer cantidad_pedido,Integer cantidad_entra,Integer cantidad_pendiente,Double porcentaje,Double peso,Double precio,String lote,Double porcentaje_arancel,Integer cantidad_unidad_auxiliar,Double precio_unidad_auxiliar,Double fob,Double fob_exw,Double total,String descripcion,Long id_centro_costo,Long id_anio,Long id_mes) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detallepedidocompraimporOriginal=this;
		
 		this.id_pedido_compra_impor=id_pedido_compra_impor;
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_bodega=id_bodega;
 		this.id_producto=id_producto;
 		this.id_unidad=id_unidad;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_arancel=id_arancel;
 		this.cantidad_pedido=cantidad_pedido;
 		this.cantidad_entra=cantidad_entra;
 		this.cantidad_pendiente=cantidad_pendiente;
 		this.porcentaje=porcentaje;
 		this.peso=peso;
 		this.precio=precio;
 		this.lote=lote;
 		this.porcentaje_arancel=porcentaje_arancel;
 		this.cantidad_unidad_auxiliar=cantidad_unidad_auxiliar;
 		this.precio_unidad_auxiliar=precio_unidad_auxiliar;
 		this.fob=fob;
 		this.fob_exw=fob_exw;
 		this.total=total;
 		this.descripcion=descripcion;
 		this.id_centro_costo=id_centro_costo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetallePedidoCompraImpor (Long id_pedido_compra_impor,Long id_empresa,Long id_sucursal,Long id_bodega,Long id_producto,Long id_unidad,Long id_ejercicio,Long id_periodo,Long id_arancel,Integer cantidad_pedido,Integer cantidad_entra,Integer cantidad_pendiente,Double porcentaje,Double peso,Double precio,String lote,Double porcentaje_arancel,Integer cantidad_unidad_auxiliar,Double precio_unidad_auxiliar,Double fob,Double fob_exw,Double total,String descripcion,Long id_centro_costo,Long id_anio,Long id_mes) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detallepedidocompraimporOriginal=this;
		
 		this.id_pedido_compra_impor=id_pedido_compra_impor;
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_bodega=id_bodega;
 		this.id_producto=id_producto;
 		this.id_unidad=id_unidad;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_arancel=id_arancel;
 		this.cantidad_pedido=cantidad_pedido;
 		this.cantidad_entra=cantidad_entra;
 		this.cantidad_pendiente=cantidad_pendiente;
 		this.porcentaje=porcentaje;
 		this.peso=peso;
 		this.precio=precio;
 		this.lote=lote;
 		this.porcentaje_arancel=porcentaje_arancel;
 		this.cantidad_unidad_auxiliar=cantidad_unidad_auxiliar;
 		this.precio_unidad_auxiliar=precio_unidad_auxiliar;
 		this.fob=fob;
 		this.fob_exw=fob_exw;
 		this.total=total;
 		this.descripcion=descripcion;
 		this.id_centro_costo=id_centro_costo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetallePedidoCompraImpor detallepedidocompraimporLocal=null;
		
		if(object!=null) {
			detallepedidocompraimporLocal=(DetallePedidoCompraImpor)object;
			
			if(detallepedidocompraimporLocal!=null) {
				if(this.getId()!=null && detallepedidocompraimporLocal.getId()!=null) {
					if(this.getId().equals(detallepedidocompraimporLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetallePedidoCompraImporConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetallePedidoCompraImporConstantesFunciones.getDetallePedidoCompraImporDescripcion(this);
		} else {
			sDetalle=DetallePedidoCompraImporConstantesFunciones.getDetallePedidoCompraImporDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetallePedidoCompraImpor getDetallePedidoCompraImporOriginal() {
		return this.detallepedidocompraimporOriginal;
	}
	
	public void setDetallePedidoCompraImporOriginal(DetallePedidoCompraImpor detallepedidocompraimpor) {
		try {
			this.detallepedidocompraimporOriginal=detallepedidocompraimpor;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetallePedidoCompraImporAdditional detallepedidocompraimporAdditional=null;
	
	public DetallePedidoCompraImporAdditional getDetallePedidoCompraImporAdditional() {
		return this.detallepedidocompraimporAdditional;
	}
	
	public void setDetallePedidoCompraImporAdditional(DetallePedidoCompraImporAdditional detallepedidocompraimporAdditional) {
		try {
			this.detallepedidocompraimporAdditional=detallepedidocompraimporAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_pedido_compra_impor() {
		return this.id_pedido_compra_impor;
	}
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_bodega() {
		return this.id_bodega;
	}
    
	
	public Long getid_producto() {
		return this.id_producto;
	}
    
	
	public Long getid_unidad() {
		return this.id_unidad;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public Long getid_arancel() {
		return this.id_arancel;
	}
    
	
	public Integer getcantidad_pedido() {
		return this.cantidad_pedido;
	}
    
	
	public Integer getcantidad_entra() {
		return this.cantidad_entra;
	}
    
	
	public Integer getcantidad_pendiente() {
		return this.cantidad_pendiente;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public Double getpeso() {
		return this.peso;
	}
    
	
	public Double getprecio() {
		return this.precio;
	}
    
	
	public String getlote() {
		return this.lote;
	}
    
	
	public Double getporcentaje_arancel() {
		return this.porcentaje_arancel;
	}
    
	
	public Integer getcantidad_unidad_auxiliar() {
		return this.cantidad_unidad_auxiliar;
	}
    
	
	public Double getprecio_unidad_auxiliar() {
		return this.precio_unidad_auxiliar;
	}
    
	
	public Double getfob() {
		return this.fob;
	}
    
	
	public Double getfob_exw() {
		return this.fob_exw;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
	
    
	public void setid_pedido_compra_impor(Long newid_pedido_compra_impor)throws Exception
	{
		try {
			if(this.id_pedido_compra_impor!=newid_pedido_compra_impor) {
				if(newid_pedido_compra_impor==null) {
					//newid_pedido_compra_impor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna id_pedido_compra_impor");
					}
				}

				this.id_pedido_compra_impor=newid_pedido_compra_impor;
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
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_bodega(Long newid_bodega)throws Exception
	{
		try {
			if(this.id_bodega!=newid_bodega) {
				if(newid_bodega==null) {
					//newid_bodega=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna id_bodega");
					}
				}

				this.id_bodega=newid_bodega;
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
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna id_producto");
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
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna id_unidad");
					}
				}

				this.id_unidad=newid_unidad;
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
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_arancel(Long newid_arancel)throws Exception
	{
		try {
			if(this.id_arancel!=newid_arancel) {
				if(newid_arancel==null) {
					//newid_arancel=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna id_arancel");
					}
				}

				this.id_arancel=newid_arancel;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_pedido(Integer newcantidad_pedido)throws Exception
	{
		try {
			if(this.cantidad_pedido!=newcantidad_pedido) {
				if(newcantidad_pedido==null) {
					//newcantidad_pedido=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna cantidad_pedido");
					}
				}

				this.cantidad_pedido=newcantidad_pedido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_entra(Integer newcantidad_entra)throws Exception
	{
		try {
			if(this.cantidad_entra!=newcantidad_entra) {
				if(newcantidad_entra==null) {
					//newcantidad_entra=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna cantidad_entra");
					}
				}

				this.cantidad_entra=newcantidad_entra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_pendiente(Integer newcantidad_pendiente)throws Exception
	{
		try {
			if(this.cantidad_pendiente!=newcantidad_pendiente) {
				if(newcantidad_pendiente==null) {
					//newcantidad_pendiente=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna cantidad_pendiente");
					}
				}

				this.cantidad_pendiente=newcantidad_pendiente;
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
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpeso(Double newpeso)throws Exception
	{
		try {
			if(this.peso!=newpeso) {
				if(newpeso==null) {
					//newpeso=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna peso");
					}
				}

				this.peso=newpeso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprecio(Double newprecio)throws Exception
	{
		try {
			if(this.precio!=newprecio) {
				if(newprecio==null) {
					//newprecio=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna precio");
					}
				}

				this.precio=newprecio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setlote(String newlote)throws Exception
	{
		try {
			if(this.lote!=newlote) {
				if(newlote==null) {
					//newlote="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna lote");
					}
				}

				if(newlote!=null&&newlote.length()>50) {
					newlote=newlote.substring(0,48);
					System.out.println("DetallePedidoCompraImpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna lote");
				}

				this.lote=newlote;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_arancel(Double newporcentaje_arancel)throws Exception
	{
		try {
			if(this.porcentaje_arancel!=newporcentaje_arancel) {
				if(newporcentaje_arancel==null) {
					//newporcentaje_arancel=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna porcentaje_arancel");
					}
				}

				this.porcentaje_arancel=newporcentaje_arancel;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_unidad_auxiliar(Integer newcantidad_unidad_auxiliar)throws Exception
	{
		try {
			if(this.cantidad_unidad_auxiliar!=newcantidad_unidad_auxiliar) {
				if(newcantidad_unidad_auxiliar==null) {
					//newcantidad_unidad_auxiliar=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna cantidad_unidad_auxiliar");
					}
				}

				this.cantidad_unidad_auxiliar=newcantidad_unidad_auxiliar;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprecio_unidad_auxiliar(Double newprecio_unidad_auxiliar)throws Exception
	{
		try {
			if(this.precio_unidad_auxiliar!=newprecio_unidad_auxiliar) {
				if(newprecio_unidad_auxiliar==null) {
					//newprecio_unidad_auxiliar=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna precio_unidad_auxiliar");
					}
				}

				this.precio_unidad_auxiliar=newprecio_unidad_auxiliar;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfob(Double newfob)throws Exception
	{
		try {
			if(this.fob!=newfob) {
				if(newfob==null) {
					//newfob=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna fob");
					}
				}

				this.fob=newfob;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfob_exw(Double newfob_exw)throws Exception
	{
		try {
			if(this.fob_exw!=newfob_exw) {
				if(newfob_exw==null) {
					//newfob_exw=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna fob_exw");
					}
				}

				this.fob_exw=newfob_exw;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal(Double newtotal)throws Exception
	{
		try {
			if(this.total!=newtotal) {
				if(newtotal==null) {
					//newtotal=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
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
						System.out.println("DetallePedidoCompraImpor:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("DetallePedidoCompraImpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_centro_costo(Long newid_centro_costo) {
		if(this.id_centro_costo==null&&newid_centro_costo!=null) {
			this.id_centro_costo=newid_centro_costo;
				this.setIsChanged(true);
		}

		if(this.id_centro_costo!=null&&!this.id_centro_costo.equals(newid_centro_costo)) {

			this.id_centro_costo=newid_centro_costo;
				this.setIsChanged(true);
		}
	}
    
	public void setid_anio(Long newid_anio) {
		if(this.id_anio==null&&newid_anio!=null) {
			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}

		if(this.id_anio!=null&&!this.id_anio.equals(newid_anio)) {

			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}
	}
    
	public void setid_mes(Long newid_mes) {
		if(this.id_mes==null&&newid_mes!=null) {
			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}

		if(this.id_mes!=null&&!this.id_mes.equals(newid_mes)) {

			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}
	}
	
	
	public PedidoCompraImpor getPedidoCompraImpor() {
		return this.pedidocompraimpor;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Bodega getBodega() {
		return this.bodega;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public Unidad getUnidad() {
		return this.unidad;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public Arancel getArancel() {
		return this.arancel;
	}

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
	}

	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	
	
	public String getpedidocompraimpor_descripcion() {
		return this.pedidocompraimpor_descripcion;
	}

	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getbodega_descripcion() {
		return this.bodega_descripcion;
	}

	public String getproducto_descripcion() {
		return this.producto_descripcion;
	}

	public String getunidad_descripcion() {
		return this.unidad_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
	}

	public String getarancel_descripcion() {
		return this.arancel_descripcion;
	}

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
	}

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
	}

	
	
	public  void  setPedidoCompraImpor(PedidoCompraImpor pedidocompraimpor) {
		try {
			this.pedidocompraimpor=pedidocompraimpor;
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


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setBodega(Bodega bodega) {
		try {
			this.bodega=bodega;
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


	public  void  setArancel(Arancel arancel) {
		try {
			this.arancel=arancel;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCentroCosto(CentroCosto centrocosto) {
		try {
			this.centrocosto=centrocosto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setAnio(Anio anio) {
		try {
			this.anio=anio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMes(Mes mes) {
		try {
			this.mes=mes;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setpedidocompraimpor_descripcion(String pedidocompraimpor_descripcion) {
		try {
			this.pedidocompraimpor_descripcion=pedidocompraimpor_descripcion;
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


	public  void  setbodega_descripcion(String bodega_descripcion) {
		try {
			this.bodega_descripcion=bodega_descripcion;
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


	public  void  setarancel_descripcion(String arancel_descripcion) {
		try {
			this.arancel_descripcion=arancel_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcentrocosto_descripcion(String centrocosto_descripcion) {
		try {
			this.centrocosto_descripcion=centrocosto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setanio_descripcion(String anio_descripcion) {
		try {
			this.anio_descripcion=anio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmes_descripcion(String mes_descripcion) {
		try {
			this.mes_descripcion=mes_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_pedido_compra_impor_descripcion="";String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_bodega_descripcion="";String id_producto_descripcion="";String id_unidad_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_arancel_descripcion="";String id_centro_costo_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";
	
	
	public String getid_pedido_compra_impor_descripcion() {
		return id_pedido_compra_impor_descripcion;
	}
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_bodega_descripcion() {
		return id_bodega_descripcion;
	}
	public String getid_producto_descripcion() {
		return id_producto_descripcion;
	}
	public String getid_unidad_descripcion() {
		return id_unidad_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	public String getid_arancel_descripcion() {
		return id_arancel_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
	}
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
	}
	
	
	public void setid_pedido_compra_impor_descripcion(String newid_pedido_compra_impor_descripcion)throws Exception {
		try {
			this.id_pedido_compra_impor_descripcion=newid_pedido_compra_impor_descripcion;
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
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_bodega_descripcion(String newid_bodega_descripcion)throws Exception {
		try {
			this.id_bodega_descripcion=newid_bodega_descripcion;
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
	public void setid_arancel_descripcion(String newid_arancel_descripcion)throws Exception {
		try {
			this.id_arancel_descripcion=newid_arancel_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_centro_costo_descripcion(String newid_centro_costo_descripcion)throws Exception {
		try {
			this.id_centro_costo_descripcion=newid_centro_costo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_anio_descripcion(String newid_anio_descripcion)throws Exception {
		try {
			this.id_anio_descripcion=newid_anio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_mes_descripcion(String newid_mes_descripcion)throws Exception {
		try {
			this.id_mes_descripcion=newid_mes_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_pedido_compra_impor_descripcion="";this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_bodega_descripcion="";this.id_producto_descripcion="";this.id_unidad_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_arancel_descripcion="";this.id_centro_costo_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

