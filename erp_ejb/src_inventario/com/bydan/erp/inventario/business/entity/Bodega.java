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
//import com.bydan.erp.inventario.util.BodegaConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class Bodega extends BodegaAdditional implements Serializable ,Cloneable {//BodegaAdditional,GeneralEntity
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
	
	private Bodega bodegaOriginal;
	
	private Map<String, Object> mapBodega;
			
	public Map<String, Object> getMapBodega() {
		return mapBodega;
	}

	public void setMapBodega(Map<String, Object> mapBodega) {
		this.mapBodega = mapBodega;
	}
	
	public void inicializarMapBodega() {
		this.mapBodega = new HashMap<String,Object>();
	}
	
	public void setMapBodegaValue(String sKey,Object oValue) {
		this.mapBodega.put(sKey, oValue);
	}
	
	public Object getMapBodegaValue(String sKey) {
		return this.mapBodega.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_grupo_bodega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_calidad_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=BodegaConstantesFunciones.SREGEXCODIGO,message=BodegaConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=BodegaConstantesFunciones.SREGEXNOMBRE,message=BodegaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=BodegaConstantesFunciones.SREGEXSIGLAS,message=BodegaConstantesFunciones.SMENSAJEREGEXSIGLAS)
	private String siglas;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=BodegaConstantesFunciones.SREGEXDIRECCION,message=BodegaConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=BodegaConstantesFunciones.SREGEXTELEFONO,message=BodegaConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=BodegaConstantesFunciones.SREGEXRUC,message=BodegaConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=BodegaConstantesFunciones.SREGEXRESPONSABLE_NOMBRE,message=BodegaConstantesFunciones.SMENSAJEREGEXRESPONSABLE_NOMBRE)
	private String responsable_nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=BodegaConstantesFunciones.SREGEXDESCRIPCION,message=BodegaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ciudad;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_multi_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_mostrar_stock;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_bodega_transito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_stock_negativo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_inventario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_devolucion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_debito;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_bonifica;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_produccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_costo_bonifica;
			
	
	public Empresa empresa;
	public GrupoBodega grupobodega;
	public CalidadProducto calidadproducto;
	public Pais pais;
	public Ciudad ciudad;
	public CentroCosto centrocosto;
	public Empleado empleado;
	public CuentaContable cuentacontableinventario;
	public CuentaContable cuentacontablecosto;
	public CuentaContable cuentacontableventa;
	public CuentaContable cuentacontabledescuento;
	public CuentaContable cuentacontabledevolucion;
	public CuentaContable cuentacontabledebito;
	public CuentaContable cuentacontablecredito;
	public CuentaContable cuentacontablebonifica;
	public CuentaContable cuentacontableproduccion;
	public CuentaContable cuentacontablecostobonifica;
	
	
	private String empresa_descripcion;
	private String grupobodega_descripcion;
	private String calidadproducto_descripcion;
	private String pais_descripcion;
	private String ciudad_descripcion;
	private String centrocosto_descripcion;
	private String empleado_descripcion;
	private String cuentacontableinventario_descripcion;
	private String cuentacontablecosto_descripcion;
	private String cuentacontableventa_descripcion;
	private String cuentacontabledescuento_descripcion;
	private String cuentacontabledevolucion_descripcion;
	private String cuentacontabledebito_descripcion;
	private String cuentacontablecredito_descripcion;
	private String cuentacontablebonifica_descripcion;
	private String cuentacontableproduccion_descripcion;
	private String cuentacontablecostobonifica_descripcion;
	
	
		
	public Bodega () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.bodegaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_grupo_bodega=-1L;
 		this.id_calidad_producto=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.siglas="";
 		this.direccion="";
 		this.telefono="";
 		this.ruc="";
 		this.responsable_nombre="";
 		this.descripcion="";
 		this.id_pais=-1L;
 		this.id_ciudad=-1L;
 		this.id_centro_costo=null;
 		this.id_empleado=-1L;
 		this.es_multi_empresa=false;
 		this.con_mostrar_stock=false;
 		this.es_bodega_transito=false;
 		this.con_stock_negativo=false;
 		this.id_cuenta_contable_inventario=-1L;
 		this.id_cuenta_contable_costo=-1L;
 		this.id_cuenta_contable_venta=-1L;
 		this.id_cuenta_contable_descuento=-1L;
 		this.id_cuenta_contable_devolucion=-1L;
 		this.id_cuenta_contable_debito=null;
 		this.id_cuenta_contable_credito=null;
 		this.id_cuenta_contable_bonifica=-1L;
 		this.id_cuenta_contable_produccion=-1L;
 		this.id_cuenta_contable_costo_bonifica=-1L;
		
		
		this.empresa=null;
		this.grupobodega=null;
		this.calidadproducto=null;
		this.pais=null;
		this.ciudad=null;
		this.centrocosto=null;
		this.empleado=null;
		this.cuentacontableinventario=null;
		this.cuentacontablecosto=null;
		this.cuentacontableventa=null;
		this.cuentacontabledescuento=null;
		this.cuentacontabledevolucion=null;
		this.cuentacontabledebito=null;
		this.cuentacontablecredito=null;
		this.cuentacontablebonifica=null;
		this.cuentacontableproduccion=null;
		this.cuentacontablecostobonifica=null;
		
		
		this.empresa_descripcion="";
		this.grupobodega_descripcion="";
		this.calidadproducto_descripcion="";
		this.pais_descripcion="";
		this.ciudad_descripcion="";
		this.centrocosto_descripcion="";
		this.empleado_descripcion="";
		this.cuentacontableinventario_descripcion="";
		this.cuentacontablecosto_descripcion="";
		this.cuentacontableventa_descripcion="";
		this.cuentacontabledescuento_descripcion="";
		this.cuentacontabledevolucion_descripcion="";
		this.cuentacontabledebito_descripcion="";
		this.cuentacontablecredito_descripcion="";
		this.cuentacontablebonifica_descripcion="";
		this.cuentacontableproduccion_descripcion="";
		this.cuentacontablecostobonifica_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Bodega (Long id,Date versionRow,Long id_empresa,Long id_grupo_bodega,Long id_calidad_producto,String codigo,String nombre,String siglas,String direccion,String telefono,String ruc,String responsable_nombre,String descripcion,Long id_pais,Long id_ciudad,Long id_centro_costo,Long id_empleado,Boolean es_multi_empresa,Boolean con_mostrar_stock,Boolean es_bodega_transito,Boolean con_stock_negativo,Long id_cuenta_contable_inventario,Long id_cuenta_contable_costo,Long id_cuenta_contable_venta,Long id_cuenta_contable_descuento,Long id_cuenta_contable_devolucion,Long id_cuenta_contable_debito,Long id_cuenta_contable_credito,Long id_cuenta_contable_bonifica,Long id_cuenta_contable_produccion,Long id_cuenta_contable_costo_bonifica) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.bodegaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_grupo_bodega=id_grupo_bodega;
 		this.id_calidad_producto=id_calidad_producto;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.siglas=siglas;
 		this.direccion=direccion;
 		this.telefono=telefono;
 		this.ruc=ruc;
 		this.responsable_nombre=responsable_nombre;
 		this.descripcion=descripcion;
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.id_centro_costo=id_centro_costo;
 		this.id_empleado=id_empleado;
 		this.es_multi_empresa=es_multi_empresa;
 		this.con_mostrar_stock=con_mostrar_stock;
 		this.es_bodega_transito=es_bodega_transito;
 		this.con_stock_negativo=con_stock_negativo;
 		this.id_cuenta_contable_inventario=id_cuenta_contable_inventario;
 		this.id_cuenta_contable_costo=id_cuenta_contable_costo;
 		this.id_cuenta_contable_venta=id_cuenta_contable_venta;
 		this.id_cuenta_contable_descuento=id_cuenta_contable_descuento;
 		this.id_cuenta_contable_devolucion=id_cuenta_contable_devolucion;
 		this.id_cuenta_contable_debito=id_cuenta_contable_debito;
 		this.id_cuenta_contable_credito=id_cuenta_contable_credito;
 		this.id_cuenta_contable_bonifica=id_cuenta_contable_bonifica;
 		this.id_cuenta_contable_produccion=id_cuenta_contable_produccion;
 		this.id_cuenta_contable_costo_bonifica=id_cuenta_contable_costo_bonifica;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Bodega (Long id_empresa,Long id_grupo_bodega,Long id_calidad_producto,String codigo,String nombre,String siglas,String direccion,String telefono,String ruc,String responsable_nombre,String descripcion,Long id_pais,Long id_ciudad,Long id_centro_costo,Long id_empleado,Boolean es_multi_empresa,Boolean con_mostrar_stock,Boolean es_bodega_transito,Boolean con_stock_negativo,Long id_cuenta_contable_inventario,Long id_cuenta_contable_costo,Long id_cuenta_contable_venta,Long id_cuenta_contable_descuento,Long id_cuenta_contable_devolucion,Long id_cuenta_contable_debito,Long id_cuenta_contable_credito,Long id_cuenta_contable_bonifica,Long id_cuenta_contable_produccion,Long id_cuenta_contable_costo_bonifica) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.bodegaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_grupo_bodega=id_grupo_bodega;
 		this.id_calidad_producto=id_calidad_producto;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.siglas=siglas;
 		this.direccion=direccion;
 		this.telefono=telefono;
 		this.ruc=ruc;
 		this.responsable_nombre=responsable_nombre;
 		this.descripcion=descripcion;
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.id_centro_costo=id_centro_costo;
 		this.id_empleado=id_empleado;
 		this.es_multi_empresa=es_multi_empresa;
 		this.con_mostrar_stock=con_mostrar_stock;
 		this.es_bodega_transito=es_bodega_transito;
 		this.con_stock_negativo=con_stock_negativo;
 		this.id_cuenta_contable_inventario=id_cuenta_contable_inventario;
 		this.id_cuenta_contable_costo=id_cuenta_contable_costo;
 		this.id_cuenta_contable_venta=id_cuenta_contable_venta;
 		this.id_cuenta_contable_descuento=id_cuenta_contable_descuento;
 		this.id_cuenta_contable_devolucion=id_cuenta_contable_devolucion;
 		this.id_cuenta_contable_debito=id_cuenta_contable_debito;
 		this.id_cuenta_contable_credito=id_cuenta_contable_credito;
 		this.id_cuenta_contable_bonifica=id_cuenta_contable_bonifica;
 		this.id_cuenta_contable_produccion=id_cuenta_contable_produccion;
 		this.id_cuenta_contable_costo_bonifica=id_cuenta_contable_costo_bonifica;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Bodega bodegaLocal=null;
		
		if(object!=null) {
			bodegaLocal=(Bodega)object;
			
			if(bodegaLocal!=null) {
				if(this.getId()!=null && bodegaLocal.getId()!=null) {
					if(this.getId().equals(bodegaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!BodegaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=BodegaConstantesFunciones.getBodegaDescripcion(this);
		} else {
			sDetalle=BodegaConstantesFunciones.getBodegaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Bodega getBodegaOriginal() {
		return this.bodegaOriginal;
	}
	
	public void setBodegaOriginal(Bodega bodega) {
		try {
			this.bodegaOriginal=bodega;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected BodegaAdditional bodegaAdditional=null;
	
	public BodegaAdditional getBodegaAdditional() {
		return this.bodegaAdditional;
	}
	
	public void setBodegaAdditional(BodegaAdditional bodegaAdditional) {
		try {
			this.bodegaAdditional=bodegaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_grupo_bodega() {
		return this.id_grupo_bodega;
	}
    
	
	public Long getid_calidad_producto() {
		return this.id_calidad_producto;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getsiglas() {
		return this.siglas;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public String getresponsable_nombre() {
		return this.responsable_nombre;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getid_ciudad() {
		return this.id_ciudad;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Boolean getes_multi_empresa() {
		return this.es_multi_empresa;
	}
    
	
	public Boolean getcon_mostrar_stock() {
		return this.con_mostrar_stock;
	}
    
	
	public Boolean getes_bodega_transito() {
		return this.es_bodega_transito;
	}
    
	
	public Boolean getcon_stock_negativo() {
		return this.con_stock_negativo;
	}
    
	
	public Long getid_cuenta_contable_inventario() {
		return this.id_cuenta_contable_inventario;
	}
    
	
	public Long getid_cuenta_contable_costo() {
		return this.id_cuenta_contable_costo;
	}
    
	
	public Long getid_cuenta_contable_venta() {
		return this.id_cuenta_contable_venta;
	}
    
	
	public Long getid_cuenta_contable_descuento() {
		return this.id_cuenta_contable_descuento;
	}
    
	
	public Long getid_cuenta_contable_devolucion() {
		return this.id_cuenta_contable_devolucion;
	}
    
	
	public Long getid_cuenta_contable_debito() {
		return this.id_cuenta_contable_debito;
	}
    
	
	public Long getid_cuenta_contable_credito() {
		return this.id_cuenta_contable_credito;
	}
    
	
	public Long getid_cuenta_contable_bonifica() {
		return this.id_cuenta_contable_bonifica;
	}
    
	
	public Long getid_cuenta_contable_produccion() {
		return this.id_cuenta_contable_produccion;
	}
    
	
	public Long getid_cuenta_contable_costo_bonifica() {
		return this.id_cuenta_contable_costo_bonifica;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_grupo_bodega(Long newid_grupo_bodega)throws Exception
	{
		try {
			if(this.id_grupo_bodega!=newid_grupo_bodega) {
				if(newid_grupo_bodega==null) {
					//newid_grupo_bodega=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna id_grupo_bodega");
					}
				}

				this.id_grupo_bodega=newid_grupo_bodega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_calidad_producto(Long newid_calidad_producto)throws Exception
	{
		try {
			if(this.id_calidad_producto!=newid_calidad_producto) {
				if(newid_calidad_producto==null) {
					//newid_calidad_producto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna id_calidad_producto");
					}
				}

				this.id_calidad_producto=newid_calidad_producto;
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
						System.out.println("Bodega:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>100) {
					newcodigo=newcodigo.substring(0,98);
					System.out.println("Bodega:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna codigo");
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
						System.out.println("Bodega:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("Bodega:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsiglas(String newsiglas)throws Exception
	{
		try {
			if(this.siglas!=newsiglas) {
				if(newsiglas==null) {
					//newsiglas="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna siglas");
					}
				}

				if(newsiglas!=null&&newsiglas.length()>50) {
					newsiglas=newsiglas.substring(0,48);
					System.out.println("Bodega:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna siglas");
				}

				this.siglas=newsiglas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion(String newdireccion)throws Exception
	{
		try {
			if(this.direccion!=newdireccion) {
				if(newdireccion==null) {
					//newdireccion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>150) {
					newdireccion=newdireccion.substring(0,148);
					System.out.println("Bodega:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna direccion");
				}

				this.direccion=newdireccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono(String newtelefono)throws Exception
	{
		try {
			if(this.telefono!=newtelefono) {
				if(newtelefono==null) {
					//newtelefono="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>50) {
					newtelefono=newtelefono.substring(0,48);
					System.out.println("Bodega:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna telefono");
				}

				this.telefono=newtelefono;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setruc(String newruc)throws Exception
	{
		try {
			if(this.ruc!=newruc) {
				if(newruc==null) {
					//newruc="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>20) {
					newruc=newruc.substring(0,18);
					System.out.println("Bodega:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna ruc");
				}

				this.ruc=newruc;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setresponsable_nombre(String newresponsable_nombre)throws Exception
	{
		try {
			if(this.responsable_nombre!=newresponsable_nombre) {
				if(newresponsable_nombre==null) {
					//newresponsable_nombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna responsable_nombre");
					}
				}

				if(newresponsable_nombre!=null&&newresponsable_nombre.length()>150) {
					newresponsable_nombre=newresponsable_nombre.substring(0,148);
					System.out.println("Bodega:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna responsable_nombre");
				}

				this.responsable_nombre=newresponsable_nombre;
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
						System.out.println("Bodega:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>250) {
					newdescripcion=newdescripcion.substring(0,248);
					System.out.println("Bodega:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_pais(Long newid_pais)throws Exception
	{
		try {
			if(this.id_pais!=newid_pais) {
				if(newid_pais==null) {
					//newid_pais=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ciudad(Long newid_ciudad)throws Exception
	{
		try {
			if(this.id_ciudad!=newid_ciudad) {
				if(newid_ciudad==null) {
					//newid_ciudad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna id_ciudad");
					}
				}

				this.id_ciudad=newid_ciudad;
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
    
	public void setid_empleado(Long newid_empleado)throws Exception
	{
		try {
			if(this.id_empleado!=newid_empleado) {
				if(newid_empleado==null) {
					//newid_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_multi_empresa(Boolean newes_multi_empresa)throws Exception
	{
		try {
			if(this.es_multi_empresa!=newes_multi_empresa) {
				if(newes_multi_empresa==null) {
					//newes_multi_empresa=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna es_multi_empresa");
					}
				}

				this.es_multi_empresa=newes_multi_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_mostrar_stock(Boolean newcon_mostrar_stock)throws Exception
	{
		try {
			if(this.con_mostrar_stock!=newcon_mostrar_stock) {
				if(newcon_mostrar_stock==null) {
					//newcon_mostrar_stock=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna con_mostrar_stock");
					}
				}

				this.con_mostrar_stock=newcon_mostrar_stock;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_bodega_transito(Boolean newes_bodega_transito)throws Exception
	{
		try {
			if(this.es_bodega_transito!=newes_bodega_transito) {
				if(newes_bodega_transito==null) {
					//newes_bodega_transito=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna es_bodega_transito");
					}
				}

				this.es_bodega_transito=newes_bodega_transito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_stock_negativo(Boolean newcon_stock_negativo)throws Exception
	{
		try {
			if(this.con_stock_negativo!=newcon_stock_negativo) {
				if(newcon_stock_negativo==null) {
					//newcon_stock_negativo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna con_stock_negativo");
					}
				}

				this.con_stock_negativo=newcon_stock_negativo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_inventario(Long newid_cuenta_contable_inventario)throws Exception
	{
		try {
			if(this.id_cuenta_contable_inventario!=newid_cuenta_contable_inventario) {
				if(newid_cuenta_contable_inventario==null) {
					//newid_cuenta_contable_inventario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna id_cuenta_contable_inventario");
					}
				}

				this.id_cuenta_contable_inventario=newid_cuenta_contable_inventario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_costo(Long newid_cuenta_contable_costo)throws Exception
	{
		try {
			if(this.id_cuenta_contable_costo!=newid_cuenta_contable_costo) {
				if(newid_cuenta_contable_costo==null) {
					//newid_cuenta_contable_costo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna id_cuenta_contable_costo");
					}
				}

				this.id_cuenta_contable_costo=newid_cuenta_contable_costo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_venta(Long newid_cuenta_contable_venta)throws Exception
	{
		try {
			if(this.id_cuenta_contable_venta!=newid_cuenta_contable_venta) {
				if(newid_cuenta_contable_venta==null) {
					//newid_cuenta_contable_venta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna id_cuenta_contable_venta");
					}
				}

				this.id_cuenta_contable_venta=newid_cuenta_contable_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_descuento(Long newid_cuenta_contable_descuento)throws Exception
	{
		try {
			if(this.id_cuenta_contable_descuento!=newid_cuenta_contable_descuento) {
				if(newid_cuenta_contable_descuento==null) {
					//newid_cuenta_contable_descuento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna id_cuenta_contable_descuento");
					}
				}

				this.id_cuenta_contable_descuento=newid_cuenta_contable_descuento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_devolucion(Long newid_cuenta_contable_devolucion)throws Exception
	{
		try {
			if(this.id_cuenta_contable_devolucion!=newid_cuenta_contable_devolucion) {
				if(newid_cuenta_contable_devolucion==null) {
					//newid_cuenta_contable_devolucion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna id_cuenta_contable_devolucion");
					}
				}

				this.id_cuenta_contable_devolucion=newid_cuenta_contable_devolucion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_debito(Long newid_cuenta_contable_debito) {
		if(this.id_cuenta_contable_debito==null&&newid_cuenta_contable_debito!=null) {
			this.id_cuenta_contable_debito=newid_cuenta_contable_debito;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_debito!=null&&!this.id_cuenta_contable_debito.equals(newid_cuenta_contable_debito)) {

			this.id_cuenta_contable_debito=newid_cuenta_contable_debito;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_credito(Long newid_cuenta_contable_credito) {
		if(this.id_cuenta_contable_credito==null&&newid_cuenta_contable_credito!=null) {
			this.id_cuenta_contable_credito=newid_cuenta_contable_credito;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_credito!=null&&!this.id_cuenta_contable_credito.equals(newid_cuenta_contable_credito)) {

			this.id_cuenta_contable_credito=newid_cuenta_contable_credito;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_bonifica(Long newid_cuenta_contable_bonifica)throws Exception
	{
		try {
			if(this.id_cuenta_contable_bonifica!=newid_cuenta_contable_bonifica) {
				if(newid_cuenta_contable_bonifica==null) {
					//newid_cuenta_contable_bonifica=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna id_cuenta_contable_bonifica");
					}
				}

				this.id_cuenta_contable_bonifica=newid_cuenta_contable_bonifica;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_produccion(Long newid_cuenta_contable_produccion)throws Exception
	{
		try {
			if(this.id_cuenta_contable_produccion!=newid_cuenta_contable_produccion) {
				if(newid_cuenta_contable_produccion==null) {
					//newid_cuenta_contable_produccion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna id_cuenta_contable_produccion");
					}
				}

				this.id_cuenta_contable_produccion=newid_cuenta_contable_produccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_costo_bonifica(Long newid_cuenta_contable_costo_bonifica)throws Exception
	{
		try {
			if(this.id_cuenta_contable_costo_bonifica!=newid_cuenta_contable_costo_bonifica) {
				if(newid_cuenta_contable_costo_bonifica==null) {
					//newid_cuenta_contable_costo_bonifica=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Bodega:Valor nulo no permitido en columna id_cuenta_contable_costo_bonifica");
					}
				}

				this.id_cuenta_contable_costo_bonifica=newid_cuenta_contable_costo_bonifica;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public GrupoBodega getGrupoBodega() {
		return this.grupobodega;
	}

	public CalidadProducto getCalidadProducto() {
		return this.calidadproducto;
	}

	public Pais getPais() {
		return this.pais;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public CuentaContable getCuentaContableInventario() {
		return this.cuentacontableinventario;
	}

	public CuentaContable getCuentaContableCosto() {
		return this.cuentacontablecosto;
	}

	public CuentaContable getCuentaContableVenta() {
		return this.cuentacontableventa;
	}

	public CuentaContable getCuentaContableDescuento() {
		return this.cuentacontabledescuento;
	}

	public CuentaContable getCuentaContableDevolucion() {
		return this.cuentacontabledevolucion;
	}

	public CuentaContable getCuentaContableDebito() {
		return this.cuentacontabledebito;
	}

	public CuentaContable getCuentaContableCredito() {
		return this.cuentacontablecredito;
	}

	public CuentaContable getCuentaContableBonifica() {
		return this.cuentacontablebonifica;
	}

	public CuentaContable getCuentaContableProduccion() {
		return this.cuentacontableproduccion;
	}

	public CuentaContable getCuentaContableCostoBonifica() {
		return this.cuentacontablecostobonifica;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getgrupobodega_descripcion() {
		return this.grupobodega_descripcion;
	}

	public String getcalidadproducto_descripcion() {
		return this.calidadproducto_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getciudad_descripcion() {
		return this.ciudad_descripcion;
	}

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getcuentacontableinventario_descripcion() {
		return this.cuentacontableinventario_descripcion;
	}

	public String getcuentacontablecosto_descripcion() {
		return this.cuentacontablecosto_descripcion;
	}

	public String getcuentacontableventa_descripcion() {
		return this.cuentacontableventa_descripcion;
	}

	public String getcuentacontabledescuento_descripcion() {
		return this.cuentacontabledescuento_descripcion;
	}

	public String getcuentacontabledevolucion_descripcion() {
		return this.cuentacontabledevolucion_descripcion;
	}

	public String getcuentacontabledebito_descripcion() {
		return this.cuentacontabledebito_descripcion;
	}

	public String getcuentacontablecredito_descripcion() {
		return this.cuentacontablecredito_descripcion;
	}

	public String getcuentacontablebonifica_descripcion() {
		return this.cuentacontablebonifica_descripcion;
	}

	public String getcuentacontableproduccion_descripcion() {
		return this.cuentacontableproduccion_descripcion;
	}

	public String getcuentacontablecostobonifica_descripcion() {
		return this.cuentacontablecostobonifica_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setGrupoBodega(GrupoBodega grupobodega) {
		try {
			this.grupobodega=grupobodega;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCalidadProducto(CalidadProducto calidadproducto) {
		try {
			this.calidadproducto=calidadproducto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPais(Pais pais) {
		try {
			this.pais=pais;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCiudad(Ciudad ciudad) {
		try {
			this.ciudad=ciudad;
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


	public  void  setEmpleado(Empleado empleado) {
		try {
			this.empleado=empleado;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableInventario(CuentaContable cuentacontableinventario) {
		try {
			this.cuentacontableinventario=cuentacontableinventario;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableCosto(CuentaContable cuentacontablecosto) {
		try {
			this.cuentacontablecosto=cuentacontablecosto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableVenta(CuentaContable cuentacontableventa) {
		try {
			this.cuentacontableventa=cuentacontableventa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableDescuento(CuentaContable cuentacontabledescuento) {
		try {
			this.cuentacontabledescuento=cuentacontabledescuento;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableDevolucion(CuentaContable cuentacontabledevolucion) {
		try {
			this.cuentacontabledevolucion=cuentacontabledevolucion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableDebito(CuentaContable cuentacontabledebito) {
		try {
			this.cuentacontabledebito=cuentacontabledebito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableCredito(CuentaContable cuentacontablecredito) {
		try {
			this.cuentacontablecredito=cuentacontablecredito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableBonifica(CuentaContable cuentacontablebonifica) {
		try {
			this.cuentacontablebonifica=cuentacontablebonifica;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableProduccion(CuentaContable cuentacontableproduccion) {
		try {
			this.cuentacontableproduccion=cuentacontableproduccion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableCostoBonifica(CuentaContable cuentacontablecostobonifica) {
		try {
			this.cuentacontablecostobonifica=cuentacontablecostobonifica;
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


	public  void  setgrupobodega_descripcion(String grupobodega_descripcion) {
		try {
			this.grupobodega_descripcion=grupobodega_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcalidadproducto_descripcion(String calidadproducto_descripcion) {
		try {
			this.calidadproducto_descripcion=calidadproducto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setpais_descripcion(String pais_descripcion) {
		try {
			this.pais_descripcion=pais_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setciudad_descripcion(String ciudad_descripcion) {
		try {
			this.ciudad_descripcion=ciudad_descripcion;
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


	public  void  setempleado_descripcion(String empleado_descripcion) {
		try {
			this.empleado_descripcion=empleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableinventario_descripcion(String cuentacontableinventario_descripcion) {
		try {
			this.cuentacontableinventario_descripcion=cuentacontableinventario_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablecosto_descripcion(String cuentacontablecosto_descripcion) {
		try {
			this.cuentacontablecosto_descripcion=cuentacontablecosto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableventa_descripcion(String cuentacontableventa_descripcion) {
		try {
			this.cuentacontableventa_descripcion=cuentacontableventa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontabledescuento_descripcion(String cuentacontabledescuento_descripcion) {
		try {
			this.cuentacontabledescuento_descripcion=cuentacontabledescuento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontabledevolucion_descripcion(String cuentacontabledevolucion_descripcion) {
		try {
			this.cuentacontabledevolucion_descripcion=cuentacontabledevolucion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontabledebito_descripcion(String cuentacontabledebito_descripcion) {
		try {
			this.cuentacontabledebito_descripcion=cuentacontabledebito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablecredito_descripcion(String cuentacontablecredito_descripcion) {
		try {
			this.cuentacontablecredito_descripcion=cuentacontablecredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablebonifica_descripcion(String cuentacontablebonifica_descripcion) {
		try {
			this.cuentacontablebonifica_descripcion=cuentacontablebonifica_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableproduccion_descripcion(String cuentacontableproduccion_descripcion) {
		try {
			this.cuentacontableproduccion_descripcion=cuentacontableproduccion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablecostobonifica_descripcion(String cuentacontablecostobonifica_descripcion) {
		try {
			this.cuentacontablecostobonifica_descripcion=cuentacontablecostobonifica_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_grupo_bodega_descripcion="";String id_calidad_producto_descripcion="";String id_pais_descripcion="";String id_ciudad_descripcion="";String id_centro_costo_descripcion="";String id_empleado_descripcion="";String es_multi_empresa_descripcion="";String con_mostrar_stock_descripcion="";String es_bodega_transito_descripcion="";String con_stock_negativo_descripcion="";String id_cuenta_contable_inventario_descripcion="";String id_cuenta_contable_costo_descripcion="";String id_cuenta_contable_venta_descripcion="";String id_cuenta_contable_descuento_descripcion="";String id_cuenta_contable_devolucion_descripcion="";String id_cuenta_contable_debito_descripcion="";String id_cuenta_contable_credito_descripcion="";String id_cuenta_contable_bonifica_descripcion="";String id_cuenta_contable_produccion_descripcion="";String id_cuenta_contable_costo_bonifica_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_grupo_bodega_descripcion() {
		return id_grupo_bodega_descripcion;
	}
	public String getid_calidad_producto_descripcion() {
		return id_calidad_producto_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_ciudad_descripcion() {
		return id_ciudad_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getes_multi_empresa_descripcion() {
		return es_multi_empresa_descripcion;
	}
	public String getcon_mostrar_stock_descripcion() {
		return con_mostrar_stock_descripcion;
	}
	public String getes_bodega_transito_descripcion() {
		return es_bodega_transito_descripcion;
	}
	public String getcon_stock_negativo_descripcion() {
		return con_stock_negativo_descripcion;
	}
	public String getid_cuenta_contable_inventario_descripcion() {
		return id_cuenta_contable_inventario_descripcion;
	}
	public String getid_cuenta_contable_costo_descripcion() {
		return id_cuenta_contable_costo_descripcion;
	}
	public String getid_cuenta_contable_venta_descripcion() {
		return id_cuenta_contable_venta_descripcion;
	}
	public String getid_cuenta_contable_descuento_descripcion() {
		return id_cuenta_contable_descuento_descripcion;
	}
	public String getid_cuenta_contable_devolucion_descripcion() {
		return id_cuenta_contable_devolucion_descripcion;
	}
	public String getid_cuenta_contable_debito_descripcion() {
		return id_cuenta_contable_debito_descripcion;
	}
	public String getid_cuenta_contable_credito_descripcion() {
		return id_cuenta_contable_credito_descripcion;
	}
	public String getid_cuenta_contable_bonifica_descripcion() {
		return id_cuenta_contable_bonifica_descripcion;
	}
	public String getid_cuenta_contable_produccion_descripcion() {
		return id_cuenta_contable_produccion_descripcion;
	}
	public String getid_cuenta_contable_costo_bonifica_descripcion() {
		return id_cuenta_contable_costo_bonifica_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_grupo_bodega_descripcion(String newid_grupo_bodega_descripcion)throws Exception {
		try {
			this.id_grupo_bodega_descripcion=newid_grupo_bodega_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_calidad_producto_descripcion(String newid_calidad_producto_descripcion)throws Exception {
		try {
			this.id_calidad_producto_descripcion=newid_calidad_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_pais_descripcion(String newid_pais_descripcion)throws Exception {
		try {
			this.id_pais_descripcion=newid_pais_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_ciudad_descripcion(String newid_ciudad_descripcion)throws Exception {
		try {
			this.id_ciudad_descripcion=newid_ciudad_descripcion;
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
	public void setid_empleado_descripcion(String newid_empleado_descripcion)throws Exception {
		try {
			this.id_empleado_descripcion=newid_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_multi_empresa_descripcion(String newes_multi_empresa_descripcion)throws Exception {
		try {
			this.es_multi_empresa_descripcion=newes_multi_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_mostrar_stock_descripcion(String newcon_mostrar_stock_descripcion)throws Exception {
		try {
			this.con_mostrar_stock_descripcion=newcon_mostrar_stock_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_bodega_transito_descripcion(String newes_bodega_transito_descripcion)throws Exception {
		try {
			this.es_bodega_transito_descripcion=newes_bodega_transito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_stock_negativo_descripcion(String newcon_stock_negativo_descripcion)throws Exception {
		try {
			this.con_stock_negativo_descripcion=newcon_stock_negativo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_inventario_descripcion(String newid_cuenta_contable_inventario_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_inventario_descripcion=newid_cuenta_contable_inventario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_costo_descripcion(String newid_cuenta_contable_costo_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_costo_descripcion=newid_cuenta_contable_costo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_venta_descripcion(String newid_cuenta_contable_venta_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_venta_descripcion=newid_cuenta_contable_venta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_descuento_descripcion(String newid_cuenta_contable_descuento_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_descuento_descripcion=newid_cuenta_contable_descuento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_devolucion_descripcion(String newid_cuenta_contable_devolucion_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_devolucion_descripcion=newid_cuenta_contable_devolucion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_debito_descripcion(String newid_cuenta_contable_debito_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_debito_descripcion=newid_cuenta_contable_debito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_credito_descripcion(String newid_cuenta_contable_credito_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_credito_descripcion=newid_cuenta_contable_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_bonifica_descripcion(String newid_cuenta_contable_bonifica_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_bonifica_descripcion=newid_cuenta_contable_bonifica_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_produccion_descripcion(String newid_cuenta_contable_produccion_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_produccion_descripcion=newid_cuenta_contable_produccion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_costo_bonifica_descripcion(String newid_cuenta_contable_costo_bonifica_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_costo_bonifica_descripcion=newid_cuenta_contable_costo_bonifica_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_grupo_bodega_descripcion="";this.id_calidad_producto_descripcion="";this.id_pais_descripcion="";this.id_ciudad_descripcion="";this.id_centro_costo_descripcion="";this.id_empleado_descripcion="";this.es_multi_empresa_descripcion="";this.con_mostrar_stock_descripcion="";this.es_bodega_transito_descripcion="";this.con_stock_negativo_descripcion="";this.id_cuenta_contable_inventario_descripcion="";this.id_cuenta_contable_costo_descripcion="";this.id_cuenta_contable_venta_descripcion="";this.id_cuenta_contable_descuento_descripcion="";this.id_cuenta_contable_devolucion_descripcion="";this.id_cuenta_contable_debito_descripcion="";this.id_cuenta_contable_credito_descripcion="";this.id_cuenta_contable_bonifica_descripcion="";this.id_cuenta_contable_produccion_descripcion="";this.id_cuenta_contable_costo_bonifica_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

