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
//import com.bydan.erp.inventario.util.DefinicionConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class Definicion extends DefinicionAdditional implements Serializable ,Cloneable {//DefinicionAdditional,GeneralEntity
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
	
	private Definicion definicionOriginal;
	
	private Map<String, Object> mapDefinicion;
			
	public Map<String, Object> getMapDefinicion() {
		return mapDefinicion;
	}

	public void setMapDefinicion(Map<String, Object> mapDefinicion) {
		this.mapDefinicion = mapDefinicion;
	}
	
	public void inicializarMapDefinicion() {
		this.mapDefinicion = new HashMap<String,Object>();
	}
	
	public void setMapDefinicionValue(String sKey,Object oValue) {
		this.mapDefinicion.put(sKey, oValue);
	}
	
	public Object getMapDefinicionValue(String sKey) {
		return this.mapDefinicion.get(sKey);
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
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DefinicionConstantesFunciones.SREGEXSECUENCIAL_FORMATO,message=DefinicionConstantesFunciones.SMENSAJEREGEXSECUENCIAL_FORMATO)
	private String secuencial_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_definicion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_iva_item;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_mostrar_bodega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double factor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_otro_recargo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_global_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_coa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_costeo_definicion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_costo_definicion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_novedad_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_cantidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_producto_por_proveedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_lote_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_detalle;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_iva_incluido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_lotes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_descuentos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_registros;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_orden_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_multi_empresa;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_en_linea;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_tributario;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_evaluacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_ot;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_anticipo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_cierre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_general;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_por_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_series;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_documento;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_libro_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_interno;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_reserva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_precio_proveedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_produccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_codigo_barra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_romaneos;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_transaccion_modulo;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
			
	
	public Empresa empresa;
	public Modulo modulo;
	public TipoDefinicion tipodefinicion;
	public Transaccion transaccion;
	public Sucursal sucursal;
	public TipoIvaItem tipoivaitem;
	public TipoGlobalCliente tipoglobalcliente;
	public TipoCosteoDefinicion tipocosteodefinicion;
	public TipoCostoDefinicion tipocostodefinicion;
	public Formato formato;
	public TipoTributario tipotributario;
	public TipoRetencion tiporetencion;
	public TipoDocumento tipodocumento;
	public LibroContable librocontable;
	public TipoTransaccionModulo tipotransaccionmodulo;
	public CuentaContable cuentacontable;
	
	
	private String empresa_descripcion;
	private String modulo_descripcion;
	private String tipodefinicion_descripcion;
	private String transaccion_descripcion;
	private String sucursal_descripcion;
	private String tipoivaitem_descripcion;
	private String tipoglobalcliente_descripcion;
	private String tipocosteodefinicion_descripcion;
	private String tipocostodefinicion_descripcion;
	private String formato_descripcion;
	private String tipotributario_descripcion;
	private String tiporetencion_descripcion;
	private String tipodocumento_descripcion;
	private String librocontable_descripcion;
	private String tipotransaccionmodulo_descripcion;
	private String cuentacontable_descripcion;
	
	
		
	public Definicion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.definicionOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_modulo=-1L;
 		this.secuencial_formato="";
 		this.secuencial=0L;
 		this.id_tipo_definicion=-1L;
 		this.id_transaccion=-1L;
 		this.id_sucursal=-1L;
 		this.id_tipo_iva_item=-1L;
 		this.con_mostrar_bodega=false;
 		this.factor=0.0;
 		this.con_otro_recargo=false;
 		this.id_tipo_global_cliente=-1L;
 		this.con_coa=false;
 		this.id_tipo_costeo_definicion=-1L;
 		this.con_retencion=false;
 		this.id_tipo_costo_definicion=-1L;
 		this.con_novedad_producto=false;
 		this.con_ice=false;
 		this.con_cantidad=false;
 		this.con_producto_por_proveedor=false;
 		this.con_lote_cliente=false;
 		this.con_cuenta_contable=false;
 		this.con_detalle=false;
 		this.con_iva_incluido=false;
 		this.con_lotes=false;
 		this.numero_descuentos=0;
 		this.con_precio=false;
 		this.numero_registros=0;
 		this.con_centro_costo=false;
 		this.con_orden_iva=false;
 		this.con_multi_empresa=false;
 		this.id_formato=null;
 		this.con_en_linea=false;
 		this.id_tipo_tributario=null;
 		this.id_tipo_retencion=null;
 		this.con_evaluacion=false;
 		this.con_ot=false;
 		this.con_anticipo=false;
 		this.con_cierre=false;
 		this.con_general=false;
 		this.con_por_producto=false;
 		this.con_descuento=false;
 		this.con_series=false;
 		this.cantidad=0;
 		this.id_tipo_documento=null;
 		this.id_libro_contable=null;
 		this.con_interno=false;
 		this.con_reserva=false;
 		this.con_precio_proveedor=false;
 		this.con_produccion=false;
 		this.con_codigo_barra=false;
 		this.con_romaneos=false;
 		this.id_tipo_transaccion_modulo=null;
 		this.id_cuenta_contable=null;
		
		
		this.empresa=null;
		this.modulo=null;
		this.tipodefinicion=null;
		this.transaccion=null;
		this.sucursal=null;
		this.tipoivaitem=null;
		this.tipoglobalcliente=null;
		this.tipocosteodefinicion=null;
		this.tipocostodefinicion=null;
		this.formato=null;
		this.tipotributario=null;
		this.tiporetencion=null;
		this.tipodocumento=null;
		this.librocontable=null;
		this.tipotransaccionmodulo=null;
		this.cuentacontable=null;
		
		
		this.empresa_descripcion="";
		this.modulo_descripcion="";
		this.tipodefinicion_descripcion="";
		this.transaccion_descripcion="";
		this.sucursal_descripcion="";
		this.tipoivaitem_descripcion="";
		this.tipoglobalcliente_descripcion="";
		this.tipocosteodefinicion_descripcion="";
		this.tipocostodefinicion_descripcion="";
		this.formato_descripcion="";
		this.tipotributario_descripcion="";
		this.tiporetencion_descripcion="";
		this.tipodocumento_descripcion="";
		this.librocontable_descripcion="";
		this.tipotransaccionmodulo_descripcion="";
		this.cuentacontable_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Definicion (Long id,Date versionRow,Long id_empresa,Long id_modulo,String secuencial_formato,Long secuencial,Long id_tipo_definicion,Long id_transaccion,Long id_sucursal,Long id_tipo_iva_item,Boolean con_mostrar_bodega,Double factor,Boolean con_otro_recargo,Long id_tipo_global_cliente,Boolean con_coa,Long id_tipo_costeo_definicion,Boolean con_retencion,Long id_tipo_costo_definicion,Boolean con_novedad_producto,Boolean con_ice,Boolean con_cantidad,Boolean con_producto_por_proveedor,Boolean con_lote_cliente,Boolean con_cuenta_contable,Boolean con_detalle,Boolean con_iva_incluido,Boolean con_lotes,Integer numero_descuentos,Boolean con_precio,Integer numero_registros,Boolean con_centro_costo,Boolean con_orden_iva,Boolean con_multi_empresa,Long id_formato,Boolean con_en_linea,Long id_tipo_tributario,Long id_tipo_retencion,Boolean con_evaluacion,Boolean con_ot,Boolean con_anticipo,Boolean con_cierre,Boolean con_general,Boolean con_por_producto,Boolean con_descuento,Boolean con_series,Integer cantidad,Long id_tipo_documento,Long id_libro_contable,Boolean con_interno,Boolean con_reserva,Boolean con_precio_proveedor,Boolean con_produccion,Boolean con_codigo_barra,Boolean con_romaneos,Long id_tipo_transaccion_modulo,Long id_cuenta_contable) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.definicionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_modulo=id_modulo;
 		this.secuencial_formato=secuencial_formato;
 		this.secuencial=secuencial;
 		this.id_tipo_definicion=id_tipo_definicion;
 		this.id_transaccion=id_transaccion;
 		this.id_sucursal=id_sucursal;
 		this.id_tipo_iva_item=id_tipo_iva_item;
 		this.con_mostrar_bodega=con_mostrar_bodega;
 		this.factor=factor;
 		this.con_otro_recargo=con_otro_recargo;
 		this.id_tipo_global_cliente=id_tipo_global_cliente;
 		this.con_coa=con_coa;
 		this.id_tipo_costeo_definicion=id_tipo_costeo_definicion;
 		this.con_retencion=con_retencion;
 		this.id_tipo_costo_definicion=id_tipo_costo_definicion;
 		this.con_novedad_producto=con_novedad_producto;
 		this.con_ice=con_ice;
 		this.con_cantidad=con_cantidad;
 		this.con_producto_por_proveedor=con_producto_por_proveedor;
 		this.con_lote_cliente=con_lote_cliente;
 		this.con_cuenta_contable=con_cuenta_contable;
 		this.con_detalle=con_detalle;
 		this.con_iva_incluido=con_iva_incluido;
 		this.con_lotes=con_lotes;
 		this.numero_descuentos=numero_descuentos;
 		this.con_precio=con_precio;
 		this.numero_registros=numero_registros;
 		this.con_centro_costo=con_centro_costo;
 		this.con_orden_iva=con_orden_iva;
 		this.con_multi_empresa=con_multi_empresa;
 		this.id_formato=id_formato;
 		this.con_en_linea=con_en_linea;
 		this.id_tipo_tributario=id_tipo_tributario;
 		this.id_tipo_retencion=id_tipo_retencion;
 		this.con_evaluacion=con_evaluacion;
 		this.con_ot=con_ot;
 		this.con_anticipo=con_anticipo;
 		this.con_cierre=con_cierre;
 		this.con_general=con_general;
 		this.con_por_producto=con_por_producto;
 		this.con_descuento=con_descuento;
 		this.con_series=con_series;
 		this.cantidad=cantidad;
 		this.id_tipo_documento=id_tipo_documento;
 		this.id_libro_contable=id_libro_contable;
 		this.con_interno=con_interno;
 		this.con_reserva=con_reserva;
 		this.con_precio_proveedor=con_precio_proveedor;
 		this.con_produccion=con_produccion;
 		this.con_codigo_barra=con_codigo_barra;
 		this.con_romaneos=con_romaneos;
 		this.id_tipo_transaccion_modulo=id_tipo_transaccion_modulo;
 		this.id_cuenta_contable=id_cuenta_contable;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Definicion (Long id_empresa,Long id_modulo,String secuencial_formato,Long secuencial,Long id_tipo_definicion,Long id_transaccion,Long id_sucursal,Long id_tipo_iva_item,Boolean con_mostrar_bodega,Double factor,Boolean con_otro_recargo,Long id_tipo_global_cliente,Boolean con_coa,Long id_tipo_costeo_definicion,Boolean con_retencion,Long id_tipo_costo_definicion,Boolean con_novedad_producto,Boolean con_ice,Boolean con_cantidad,Boolean con_producto_por_proveedor,Boolean con_lote_cliente,Boolean con_cuenta_contable,Boolean con_detalle,Boolean con_iva_incluido,Boolean con_lotes,Integer numero_descuentos,Boolean con_precio,Integer numero_registros,Boolean con_centro_costo,Boolean con_orden_iva,Boolean con_multi_empresa,Long id_formato,Boolean con_en_linea,Long id_tipo_tributario,Long id_tipo_retencion,Boolean con_evaluacion,Boolean con_ot,Boolean con_anticipo,Boolean con_cierre,Boolean con_general,Boolean con_por_producto,Boolean con_descuento,Boolean con_series,Integer cantidad,Long id_tipo_documento,Long id_libro_contable,Boolean con_interno,Boolean con_reserva,Boolean con_precio_proveedor,Boolean con_produccion,Boolean con_codigo_barra,Boolean con_romaneos,Long id_tipo_transaccion_modulo,Long id_cuenta_contable) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.definicionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_modulo=id_modulo;
 		this.secuencial_formato=secuencial_formato;
 		this.secuencial=secuencial;
 		this.id_tipo_definicion=id_tipo_definicion;
 		this.id_transaccion=id_transaccion;
 		this.id_sucursal=id_sucursal;
 		this.id_tipo_iva_item=id_tipo_iva_item;
 		this.con_mostrar_bodega=con_mostrar_bodega;
 		this.factor=factor;
 		this.con_otro_recargo=con_otro_recargo;
 		this.id_tipo_global_cliente=id_tipo_global_cliente;
 		this.con_coa=con_coa;
 		this.id_tipo_costeo_definicion=id_tipo_costeo_definicion;
 		this.con_retencion=con_retencion;
 		this.id_tipo_costo_definicion=id_tipo_costo_definicion;
 		this.con_novedad_producto=con_novedad_producto;
 		this.con_ice=con_ice;
 		this.con_cantidad=con_cantidad;
 		this.con_producto_por_proveedor=con_producto_por_proveedor;
 		this.con_lote_cliente=con_lote_cliente;
 		this.con_cuenta_contable=con_cuenta_contable;
 		this.con_detalle=con_detalle;
 		this.con_iva_incluido=con_iva_incluido;
 		this.con_lotes=con_lotes;
 		this.numero_descuentos=numero_descuentos;
 		this.con_precio=con_precio;
 		this.numero_registros=numero_registros;
 		this.con_centro_costo=con_centro_costo;
 		this.con_orden_iva=con_orden_iva;
 		this.con_multi_empresa=con_multi_empresa;
 		this.id_formato=id_formato;
 		this.con_en_linea=con_en_linea;
 		this.id_tipo_tributario=id_tipo_tributario;
 		this.id_tipo_retencion=id_tipo_retencion;
 		this.con_evaluacion=con_evaluacion;
 		this.con_ot=con_ot;
 		this.con_anticipo=con_anticipo;
 		this.con_cierre=con_cierre;
 		this.con_general=con_general;
 		this.con_por_producto=con_por_producto;
 		this.con_descuento=con_descuento;
 		this.con_series=con_series;
 		this.cantidad=cantidad;
 		this.id_tipo_documento=id_tipo_documento;
 		this.id_libro_contable=id_libro_contable;
 		this.con_interno=con_interno;
 		this.con_reserva=con_reserva;
 		this.con_precio_proveedor=con_precio_proveedor;
 		this.con_produccion=con_produccion;
 		this.con_codigo_barra=con_codigo_barra;
 		this.con_romaneos=con_romaneos;
 		this.id_tipo_transaccion_modulo=id_tipo_transaccion_modulo;
 		this.id_cuenta_contable=id_cuenta_contable;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Definicion definicionLocal=null;
		
		if(object!=null) {
			definicionLocal=(Definicion)object;
			
			if(definicionLocal!=null) {
				if(this.getId()!=null && definicionLocal.getId()!=null) {
					if(this.getId().equals(definicionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DefinicionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DefinicionConstantesFunciones.getDefinicionDescripcion(this);
		} else {
			sDetalle=DefinicionConstantesFunciones.getDefinicionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Definicion getDefinicionOriginal() {
		return this.definicionOriginal;
	}
	
	public void setDefinicionOriginal(Definicion definicion) {
		try {
			this.definicionOriginal=definicion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DefinicionAdditional definicionAdditional=null;
	
	public DefinicionAdditional getDefinicionAdditional() {
		return this.definicionAdditional;
	}
	
	public void setDefinicionAdditional(DefinicionAdditional definicionAdditional) {
		try {
			this.definicionAdditional=definicionAdditional;
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
    
	
	public String getsecuencial_formato() {
		return this.secuencial_formato;
	}
    
	
	public Long getsecuencial() {
		return this.secuencial;
	}
    
	
	public Long getid_tipo_definicion() {
		return this.id_tipo_definicion;
	}
    
	
	public Long getid_transaccion() {
		return this.id_transaccion;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_tipo_iva_item() {
		return this.id_tipo_iva_item;
	}
    
	
	public Boolean getcon_mostrar_bodega() {
		return this.con_mostrar_bodega;
	}
    
	
	public Double getfactor() {
		return this.factor;
	}
    
	
	public Boolean getcon_otro_recargo() {
		return this.con_otro_recargo;
	}
    
	
	public Long getid_tipo_global_cliente() {
		return this.id_tipo_global_cliente;
	}
    
	
	public Boolean getcon_coa() {
		return this.con_coa;
	}
    
	
	public Long getid_tipo_costeo_definicion() {
		return this.id_tipo_costeo_definicion;
	}
    
	
	public Boolean getcon_retencion() {
		return this.con_retencion;
	}
    
	
	public Long getid_tipo_costo_definicion() {
		return this.id_tipo_costo_definicion;
	}
    
	
	public Boolean getcon_novedad_producto() {
		return this.con_novedad_producto;
	}
    
	
	public Boolean getcon_ice() {
		return this.con_ice;
	}
    
	
	public Boolean getcon_cantidad() {
		return this.con_cantidad;
	}
    
	
	public Boolean getcon_producto_por_proveedor() {
		return this.con_producto_por_proveedor;
	}
    
	
	public Boolean getcon_lote_cliente() {
		return this.con_lote_cliente;
	}
    
	
	public Boolean getcon_cuenta_contable() {
		return this.con_cuenta_contable;
	}
    
	
	public Boolean getcon_detalle() {
		return this.con_detalle;
	}
    
	
	public Boolean getcon_iva_incluido() {
		return this.con_iva_incluido;
	}
    
	
	public Boolean getcon_lotes() {
		return this.con_lotes;
	}
    
	
	public Integer getnumero_descuentos() {
		return this.numero_descuentos;
	}
    
	
	public Boolean getcon_precio() {
		return this.con_precio;
	}
    
	
	public Integer getnumero_registros() {
		return this.numero_registros;
	}
    
	
	public Boolean getcon_centro_costo() {
		return this.con_centro_costo;
	}
    
	
	public Boolean getcon_orden_iva() {
		return this.con_orden_iva;
	}
    
	
	public Boolean getcon_multi_empresa() {
		return this.con_multi_empresa;
	}
    
	
	public Long getid_formato() {
		return this.id_formato;
	}
    
	
	public Boolean getcon_en_linea() {
		return this.con_en_linea;
	}
    
	
	public Long getid_tipo_tributario() {
		return this.id_tipo_tributario;
	}
    
	
	public Long getid_tipo_retencion() {
		return this.id_tipo_retencion;
	}
    
	
	public Boolean getcon_evaluacion() {
		return this.con_evaluacion;
	}
    
	
	public Boolean getcon_ot() {
		return this.con_ot;
	}
    
	
	public Boolean getcon_anticipo() {
		return this.con_anticipo;
	}
    
	
	public Boolean getcon_cierre() {
		return this.con_cierre;
	}
    
	
	public Boolean getcon_general() {
		return this.con_general;
	}
    
	
	public Boolean getcon_por_producto() {
		return this.con_por_producto;
	}
    
	
	public Boolean getcon_descuento() {
		return this.con_descuento;
	}
    
	
	public Boolean getcon_series() {
		return this.con_series;
	}
    
	
	public Integer getcantidad() {
		return this.cantidad;
	}
    
	
	public Long getid_tipo_documento() {
		return this.id_tipo_documento;
	}
    
	
	public Long getid_libro_contable() {
		return this.id_libro_contable;
	}
    
	
	public Boolean getcon_interno() {
		return this.con_interno;
	}
    
	
	public Boolean getcon_reserva() {
		return this.con_reserva;
	}
    
	
	public Boolean getcon_precio_proveedor() {
		return this.con_precio_proveedor;
	}
    
	
	public Boolean getcon_produccion() {
		return this.con_produccion;
	}
    
	
	public Boolean getcon_codigo_barra() {
		return this.con_codigo_barra;
	}
    
	
	public Boolean getcon_romaneos() {
		return this.con_romaneos;
	}
    
	
	public Long getid_tipo_transaccion_modulo() {
		return this.id_tipo_transaccion_modulo;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("Definicion:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial_formato(String newsecuencial_formato)throws Exception
	{
		try {
			if(this.secuencial_formato!=newsecuencial_formato) {
				if(newsecuencial_formato==null) {
					//newsecuencial_formato="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna secuencial_formato");
					}
				}

				if(newsecuencial_formato!=null&&newsecuencial_formato.length()>50) {
					newsecuencial_formato=newsecuencial_formato.substring(0,48);
					System.out.println("Definicion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencial_formato");
				}

				this.secuencial_formato=newsecuencial_formato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial(Long newsecuencial)throws Exception
	{
		try {
			if(this.secuencial!=newsecuencial) {
				if(newsecuencial==null) {
					//newsecuencial=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna secuencial");
					}
				}

				this.secuencial=newsecuencial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_definicion(Long newid_tipo_definicion)throws Exception
	{
		try {
			if(this.id_tipo_definicion!=newid_tipo_definicion) {
				if(newid_tipo_definicion==null) {
					//newid_tipo_definicion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna id_tipo_definicion");
					}
				}

				this.id_tipo_definicion=newid_tipo_definicion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion(Long newid_transaccion)throws Exception
	{
		try {
			if(this.id_transaccion!=newid_transaccion) {
				if(newid_transaccion==null) {
					//newid_transaccion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna id_transaccion");
					}
				}

				this.id_transaccion=newid_transaccion;
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
						System.out.println("Definicion:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_iva_item(Long newid_tipo_iva_item)throws Exception
	{
		try {
			if(this.id_tipo_iva_item!=newid_tipo_iva_item) {
				if(newid_tipo_iva_item==null) {
					//newid_tipo_iva_item=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna id_tipo_iva_item");
					}
				}

				this.id_tipo_iva_item=newid_tipo_iva_item;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_mostrar_bodega(Boolean newcon_mostrar_bodega)throws Exception
	{
		try {
			if(this.con_mostrar_bodega!=newcon_mostrar_bodega) {
				if(newcon_mostrar_bodega==null) {
					//newcon_mostrar_bodega=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_mostrar_bodega");
					}
				}

				this.con_mostrar_bodega=newcon_mostrar_bodega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfactor(Double newfactor)throws Exception
	{
		try {
			if(this.factor!=newfactor) {
				if(newfactor==null) {
					//newfactor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna factor");
					}
				}

				this.factor=newfactor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_otro_recargo(Boolean newcon_otro_recargo)throws Exception
	{
		try {
			if(this.con_otro_recargo!=newcon_otro_recargo) {
				if(newcon_otro_recargo==null) {
					//newcon_otro_recargo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_otro_recargo");
					}
				}

				this.con_otro_recargo=newcon_otro_recargo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_global_cliente(Long newid_tipo_global_cliente)throws Exception
	{
		try {
			if(this.id_tipo_global_cliente!=newid_tipo_global_cliente) {
				if(newid_tipo_global_cliente==null) {
					//newid_tipo_global_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna id_tipo_global_cliente");
					}
				}

				this.id_tipo_global_cliente=newid_tipo_global_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_coa(Boolean newcon_coa)throws Exception
	{
		try {
			if(this.con_coa!=newcon_coa) {
				if(newcon_coa==null) {
					//newcon_coa=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_coa");
					}
				}

				this.con_coa=newcon_coa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_costeo_definicion(Long newid_tipo_costeo_definicion)throws Exception
	{
		try {
			if(this.id_tipo_costeo_definicion!=newid_tipo_costeo_definicion) {
				if(newid_tipo_costeo_definicion==null) {
					//newid_tipo_costeo_definicion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna id_tipo_costeo_definicion");
					}
				}

				this.id_tipo_costeo_definicion=newid_tipo_costeo_definicion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_retencion(Boolean newcon_retencion)throws Exception
	{
		try {
			if(this.con_retencion!=newcon_retencion) {
				if(newcon_retencion==null) {
					//newcon_retencion=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_retencion");
					}
				}

				this.con_retencion=newcon_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_costo_definicion(Long newid_tipo_costo_definicion)throws Exception
	{
		try {
			if(this.id_tipo_costo_definicion!=newid_tipo_costo_definicion) {
				if(newid_tipo_costo_definicion==null) {
					//newid_tipo_costo_definicion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna id_tipo_costo_definicion");
					}
				}

				this.id_tipo_costo_definicion=newid_tipo_costo_definicion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_novedad_producto(Boolean newcon_novedad_producto)throws Exception
	{
		try {
			if(this.con_novedad_producto!=newcon_novedad_producto) {
				if(newcon_novedad_producto==null) {
					//newcon_novedad_producto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_novedad_producto");
					}
				}

				this.con_novedad_producto=newcon_novedad_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_ice(Boolean newcon_ice)throws Exception
	{
		try {
			if(this.con_ice!=newcon_ice) {
				if(newcon_ice==null) {
					//newcon_ice=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_ice");
					}
				}

				this.con_ice=newcon_ice;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_cantidad(Boolean newcon_cantidad)throws Exception
	{
		try {
			if(this.con_cantidad!=newcon_cantidad) {
				if(newcon_cantidad==null) {
					//newcon_cantidad=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_cantidad");
					}
				}

				this.con_cantidad=newcon_cantidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_producto_por_proveedor(Boolean newcon_producto_por_proveedor)throws Exception
	{
		try {
			if(this.con_producto_por_proveedor!=newcon_producto_por_proveedor) {
				if(newcon_producto_por_proveedor==null) {
					//newcon_producto_por_proveedor=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_producto_por_proveedor");
					}
				}

				this.con_producto_por_proveedor=newcon_producto_por_proveedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_lote_cliente(Boolean newcon_lote_cliente)throws Exception
	{
		try {
			if(this.con_lote_cliente!=newcon_lote_cliente) {
				if(newcon_lote_cliente==null) {
					//newcon_lote_cliente=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_lote_cliente");
					}
				}

				this.con_lote_cliente=newcon_lote_cliente;
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
						System.out.println("Definicion:Valor nulo no permitido en columna con_cuenta_contable");
					}
				}

				this.con_cuenta_contable=newcon_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_detalle(Boolean newcon_detalle)throws Exception
	{
		try {
			if(this.con_detalle!=newcon_detalle) {
				if(newcon_detalle==null) {
					//newcon_detalle=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_detalle");
					}
				}

				this.con_detalle=newcon_detalle;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_iva_incluido(Boolean newcon_iva_incluido)throws Exception
	{
		try {
			if(this.con_iva_incluido!=newcon_iva_incluido) {
				if(newcon_iva_incluido==null) {
					//newcon_iva_incluido=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_iva_incluido");
					}
				}

				this.con_iva_incluido=newcon_iva_incluido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_lotes(Boolean newcon_lotes)throws Exception
	{
		try {
			if(this.con_lotes!=newcon_lotes) {
				if(newcon_lotes==null) {
					//newcon_lotes=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_lotes");
					}
				}

				this.con_lotes=newcon_lotes;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_descuentos(Integer newnumero_descuentos)throws Exception
	{
		try {
			if(this.numero_descuentos!=newnumero_descuentos) {
				if(newnumero_descuentos==null) {
					//newnumero_descuentos=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna numero_descuentos");
					}
				}

				this.numero_descuentos=newnumero_descuentos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_precio(Boolean newcon_precio)throws Exception
	{
		try {
			if(this.con_precio!=newcon_precio) {
				if(newcon_precio==null) {
					//newcon_precio=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_precio");
					}
				}

				this.con_precio=newcon_precio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_registros(Integer newnumero_registros)throws Exception
	{
		try {
			if(this.numero_registros!=newnumero_registros) {
				if(newnumero_registros==null) {
					//newnumero_registros=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna numero_registros");
					}
				}

				this.numero_registros=newnumero_registros;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_centro_costo(Boolean newcon_centro_costo)throws Exception
	{
		try {
			if(this.con_centro_costo!=newcon_centro_costo) {
				if(newcon_centro_costo==null) {
					//newcon_centro_costo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_centro_costo");
					}
				}

				this.con_centro_costo=newcon_centro_costo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_orden_iva(Boolean newcon_orden_iva)throws Exception
	{
		try {
			if(this.con_orden_iva!=newcon_orden_iva) {
				if(newcon_orden_iva==null) {
					//newcon_orden_iva=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_orden_iva");
					}
				}

				this.con_orden_iva=newcon_orden_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_multi_empresa(Boolean newcon_multi_empresa)throws Exception
	{
		try {
			if(this.con_multi_empresa!=newcon_multi_empresa) {
				if(newcon_multi_empresa==null) {
					//newcon_multi_empresa=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_multi_empresa");
					}
				}

				this.con_multi_empresa=newcon_multi_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato(Long newid_formato) {
		if(this.id_formato==null&&newid_formato!=null) {
			this.id_formato=newid_formato;
				this.setIsChanged(true);
		}

		if(this.id_formato!=null&&!this.id_formato.equals(newid_formato)) {

			this.id_formato=newid_formato;
				this.setIsChanged(true);
		}
	}
    
	public void setcon_en_linea(Boolean newcon_en_linea)throws Exception
	{
		try {
			if(this.con_en_linea!=newcon_en_linea) {
				if(newcon_en_linea==null) {
					//newcon_en_linea=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_en_linea");
					}
				}

				this.con_en_linea=newcon_en_linea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_tributario(Long newid_tipo_tributario) {
		if(this.id_tipo_tributario==null&&newid_tipo_tributario!=null) {
			this.id_tipo_tributario=newid_tipo_tributario;
				this.setIsChanged(true);
		}

		if(this.id_tipo_tributario!=null&&!this.id_tipo_tributario.equals(newid_tipo_tributario)) {

			this.id_tipo_tributario=newid_tipo_tributario;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_retencion(Long newid_tipo_retencion) {
		if(this.id_tipo_retencion==null&&newid_tipo_retencion!=null) {
			this.id_tipo_retencion=newid_tipo_retencion;
				this.setIsChanged(true);
		}

		if(this.id_tipo_retencion!=null&&!this.id_tipo_retencion.equals(newid_tipo_retencion)) {

			this.id_tipo_retencion=newid_tipo_retencion;
				this.setIsChanged(true);
		}
	}
    
	public void setcon_evaluacion(Boolean newcon_evaluacion)throws Exception
	{
		try {
			if(this.con_evaluacion!=newcon_evaluacion) {
				if(newcon_evaluacion==null) {
					//newcon_evaluacion=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_evaluacion");
					}
				}

				this.con_evaluacion=newcon_evaluacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_ot(Boolean newcon_ot)throws Exception
	{
		try {
			if(this.con_ot!=newcon_ot) {
				if(newcon_ot==null) {
					//newcon_ot=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_ot");
					}
				}

				this.con_ot=newcon_ot;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_anticipo(Boolean newcon_anticipo)throws Exception
	{
		try {
			if(this.con_anticipo!=newcon_anticipo) {
				if(newcon_anticipo==null) {
					//newcon_anticipo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_anticipo");
					}
				}

				this.con_anticipo=newcon_anticipo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_cierre(Boolean newcon_cierre)throws Exception
	{
		try {
			if(this.con_cierre!=newcon_cierre) {
				if(newcon_cierre==null) {
					//newcon_cierre=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_cierre");
					}
				}

				this.con_cierre=newcon_cierre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_general(Boolean newcon_general)throws Exception
	{
		try {
			if(this.con_general!=newcon_general) {
				if(newcon_general==null) {
					//newcon_general=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_general");
					}
				}

				this.con_general=newcon_general;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_por_producto(Boolean newcon_por_producto)throws Exception
	{
		try {
			if(this.con_por_producto!=newcon_por_producto) {
				if(newcon_por_producto==null) {
					//newcon_por_producto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_por_producto");
					}
				}

				this.con_por_producto=newcon_por_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_descuento(Boolean newcon_descuento)throws Exception
	{
		try {
			if(this.con_descuento!=newcon_descuento) {
				if(newcon_descuento==null) {
					//newcon_descuento=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_descuento");
					}
				}

				this.con_descuento=newcon_descuento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_series(Boolean newcon_series)throws Exception
	{
		try {
			if(this.con_series!=newcon_series) {
				if(newcon_series==null) {
					//newcon_series=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_series");
					}
				}

				this.con_series=newcon_series;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad(Integer newcantidad)throws Exception
	{
		try {
			if(this.cantidad!=newcantidad) {
				if(newcantidad==null) {
					//newcantidad=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna cantidad");
					}
				}

				this.cantidad=newcantidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_documento(Long newid_tipo_documento) {
		if(this.id_tipo_documento==null&&newid_tipo_documento!=null) {
			this.id_tipo_documento=newid_tipo_documento;
				this.setIsChanged(true);
		}

		if(this.id_tipo_documento!=null&&!this.id_tipo_documento.equals(newid_tipo_documento)) {

			this.id_tipo_documento=newid_tipo_documento;
				this.setIsChanged(true);
		}
	}
    
	public void setid_libro_contable(Long newid_libro_contable) {
		if(this.id_libro_contable==null&&newid_libro_contable!=null) {
			this.id_libro_contable=newid_libro_contable;
				this.setIsChanged(true);
		}

		if(this.id_libro_contable!=null&&!this.id_libro_contable.equals(newid_libro_contable)) {

			this.id_libro_contable=newid_libro_contable;
				this.setIsChanged(true);
		}
	}
    
	public void setcon_interno(Boolean newcon_interno)throws Exception
	{
		try {
			if(this.con_interno!=newcon_interno) {
				if(newcon_interno==null) {
					//newcon_interno=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_interno");
					}
				}

				this.con_interno=newcon_interno;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_reserva(Boolean newcon_reserva)throws Exception
	{
		try {
			if(this.con_reserva!=newcon_reserva) {
				if(newcon_reserva==null) {
					//newcon_reserva=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_reserva");
					}
				}

				this.con_reserva=newcon_reserva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_precio_proveedor(Boolean newcon_precio_proveedor)throws Exception
	{
		try {
			if(this.con_precio_proveedor!=newcon_precio_proveedor) {
				if(newcon_precio_proveedor==null) {
					//newcon_precio_proveedor=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_precio_proveedor");
					}
				}

				this.con_precio_proveedor=newcon_precio_proveedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_produccion(Boolean newcon_produccion)throws Exception
	{
		try {
			if(this.con_produccion!=newcon_produccion) {
				if(newcon_produccion==null) {
					//newcon_produccion=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_produccion");
					}
				}

				this.con_produccion=newcon_produccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_codigo_barra(Boolean newcon_codigo_barra)throws Exception
	{
		try {
			if(this.con_codigo_barra!=newcon_codigo_barra) {
				if(newcon_codigo_barra==null) {
					//newcon_codigo_barra=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_codigo_barra");
					}
				}

				this.con_codigo_barra=newcon_codigo_barra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_romaneos(Boolean newcon_romaneos)throws Exception
	{
		try {
			if(this.con_romaneos!=newcon_romaneos) {
				if(newcon_romaneos==null) {
					//newcon_romaneos=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Definicion:Valor nulo no permitido en columna con_romaneos");
					}
				}

				this.con_romaneos=newcon_romaneos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_transaccion_modulo(Long newid_tipo_transaccion_modulo) {
		if(this.id_tipo_transaccion_modulo==null&&newid_tipo_transaccion_modulo!=null) {
			this.id_tipo_transaccion_modulo=newid_tipo_transaccion_modulo;
				this.setIsChanged(true);
		}

		if(this.id_tipo_transaccion_modulo!=null&&!this.id_tipo_transaccion_modulo.equals(newid_tipo_transaccion_modulo)) {

			this.id_tipo_transaccion_modulo=newid_tipo_transaccion_modulo;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable(Long newid_cuenta_contable) {
		if(this.id_cuenta_contable==null&&newid_cuenta_contable!=null) {
			this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable!=null&&!this.id_cuenta_contable.equals(newid_cuenta_contable)) {

			this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public TipoDefinicion getTipoDefinicion() {
		return this.tipodefinicion;
	}

	public Transaccion getTransaccion() {
		return this.transaccion;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public TipoIvaItem getTipoIvaItem() {
		return this.tipoivaitem;
	}

	public TipoGlobalCliente getTipoGlobalCliente() {
		return this.tipoglobalcliente;
	}

	public TipoCosteoDefinicion getTipoCosteoDefinicion() {
		return this.tipocosteodefinicion;
	}

	public TipoCostoDefinicion getTipoCostoDefinicion() {
		return this.tipocostodefinicion;
	}

	public Formato getFormato() {
		return this.formato;
	}

	public TipoTributario getTipoTributario() {
		return this.tipotributario;
	}

	public TipoRetencion getTipoRetencion() {
		return this.tiporetencion;
	}

	public TipoDocumento getTipoDocumento() {
		return this.tipodocumento;
	}

	public LibroContable getLibroContable() {
		return this.librocontable;
	}

	public TipoTransaccionModulo getTipoTransaccionModulo() {
		return this.tipotransaccionmodulo;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String gettipodefinicion_descripcion() {
		return this.tipodefinicion_descripcion;
	}

	public String gettransaccion_descripcion() {
		return this.transaccion_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String gettipoivaitem_descripcion() {
		return this.tipoivaitem_descripcion;
	}

	public String gettipoglobalcliente_descripcion() {
		return this.tipoglobalcliente_descripcion;
	}

	public String gettipocosteodefinicion_descripcion() {
		return this.tipocosteodefinicion_descripcion;
	}

	public String gettipocostodefinicion_descripcion() {
		return this.tipocostodefinicion_descripcion;
	}

	public String getformato_descripcion() {
		return this.formato_descripcion;
	}

	public String gettipotributario_descripcion() {
		return this.tipotributario_descripcion;
	}

	public String gettiporetencion_descripcion() {
		return this.tiporetencion_descripcion;
	}

	public String gettipodocumento_descripcion() {
		return this.tipodocumento_descripcion;
	}

	public String getlibrocontable_descripcion() {
		return this.librocontable_descripcion;
	}

	public String gettipotransaccionmodulo_descripcion() {
		return this.tipotransaccionmodulo_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
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


	public  void  setTipoDefinicion(TipoDefinicion tipodefinicion) {
		try {
			this.tipodefinicion=tipodefinicion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccion(Transaccion transaccion) {
		try {
			this.transaccion=transaccion;
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


	public  void  setTipoIvaItem(TipoIvaItem tipoivaitem) {
		try {
			this.tipoivaitem=tipoivaitem;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoGlobalCliente(TipoGlobalCliente tipoglobalcliente) {
		try {
			this.tipoglobalcliente=tipoglobalcliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoCosteoDefinicion(TipoCosteoDefinicion tipocosteodefinicion) {
		try {
			this.tipocosteodefinicion=tipocosteodefinicion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoCostoDefinicion(TipoCostoDefinicion tipocostodefinicion) {
		try {
			this.tipocostodefinicion=tipocostodefinicion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormato(Formato formato) {
		try {
			this.formato=formato;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoTributario(TipoTributario tipotributario) {
		try {
			this.tipotributario=tipotributario;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRetencion(TipoRetencion tiporetencion) {
		try {
			this.tiporetencion=tiporetencion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoDocumento(TipoDocumento tipodocumento) {
		try {
			this.tipodocumento=tipodocumento;
		} catch(Exception e) {
			;
		}
	}


	public  void  setLibroContable(LibroContable librocontable) {
		try {
			this.librocontable=librocontable;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoTransaccionModulo(TipoTransaccionModulo tipotransaccionmodulo) {
		try {
			this.tipotransaccionmodulo=tipotransaccionmodulo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContable(CuentaContable cuentacontable) {
		try {
			this.cuentacontable=cuentacontable;
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


	public  void  settipodefinicion_descripcion(String tipodefinicion_descripcion) {
		try {
			this.tipodefinicion_descripcion=tipodefinicion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccion_descripcion(String transaccion_descripcion) {
		try {
			this.transaccion_descripcion=transaccion_descripcion;
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


	public  void  settipoivaitem_descripcion(String tipoivaitem_descripcion) {
		try {
			this.tipoivaitem_descripcion=tipoivaitem_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoglobalcliente_descripcion(String tipoglobalcliente_descripcion) {
		try {
			this.tipoglobalcliente_descripcion=tipoglobalcliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipocosteodefinicion_descripcion(String tipocosteodefinicion_descripcion) {
		try {
			this.tipocosteodefinicion_descripcion=tipocosteodefinicion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipocostodefinicion_descripcion(String tipocostodefinicion_descripcion) {
		try {
			this.tipocostodefinicion_descripcion=tipocostodefinicion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformato_descripcion(String formato_descripcion) {
		try {
			this.formato_descripcion=formato_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipotributario_descripcion(String tipotributario_descripcion) {
		try {
			this.tipotributario_descripcion=tipotributario_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiporetencion_descripcion(String tiporetencion_descripcion) {
		try {
			this.tiporetencion_descripcion=tiporetencion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipodocumento_descripcion(String tipodocumento_descripcion) {
		try {
			this.tipodocumento_descripcion=tipodocumento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setlibrocontable_descripcion(String librocontable_descripcion) {
		try {
			this.librocontable_descripcion=librocontable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipotransaccionmodulo_descripcion(String tipotransaccionmodulo_descripcion) {
		try {
			this.tipotransaccionmodulo_descripcion=tipotransaccionmodulo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontable_descripcion(String cuentacontable_descripcion) {
		try {
			this.cuentacontable_descripcion=cuentacontable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_modulo_descripcion="";String id_tipo_definicion_descripcion="";String id_transaccion_descripcion="";String id_sucursal_descripcion="";String id_tipo_iva_item_descripcion="";String con_mostrar_bodega_descripcion="";String con_otro_recargo_descripcion="";String id_tipo_global_cliente_descripcion="";String con_coa_descripcion="";String id_tipo_costeo_definicion_descripcion="";String con_retencion_descripcion="";String id_tipo_costo_definicion_descripcion="";String con_novedad_producto_descripcion="";String con_ice_descripcion="";String con_cantidad_descripcion="";String con_producto_por_proveedor_descripcion="";String con_lote_cliente_descripcion="";String con_cuenta_contable_descripcion="";String con_detalle_descripcion="";String con_iva_incluido_descripcion="";String con_lotes_descripcion="";String con_precio_descripcion="";String con_centro_costo_descripcion="";String con_orden_iva_descripcion="";String con_multi_empresa_descripcion="";String id_formato_descripcion="";String con_en_linea_descripcion="";String id_tipo_tributario_descripcion="";String id_tipo_retencion_descripcion="";String con_evaluacion_descripcion="";String con_ot_descripcion="";String con_anticipo_descripcion="";String con_cierre_descripcion="";String con_general_descripcion="";String con_por_producto_descripcion="";String con_descuento_descripcion="";String con_series_descripcion="";String id_tipo_documento_descripcion="";String id_libro_contable_descripcion="";String con_interno_descripcion="";String con_reserva_descripcion="";String con_precio_proveedor_descripcion="";String con_produccion_descripcion="";String con_codigo_barra_descripcion="";String con_romaneos_descripcion="";String id_tipo_transaccion_modulo_descripcion="";String id_cuenta_contable_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_tipo_definicion_descripcion() {
		return id_tipo_definicion_descripcion;
	}
	public String getid_transaccion_descripcion() {
		return id_transaccion_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_tipo_iva_item_descripcion() {
		return id_tipo_iva_item_descripcion;
	}
	public String getcon_mostrar_bodega_descripcion() {
		return con_mostrar_bodega_descripcion;
	}
	public String getcon_otro_recargo_descripcion() {
		return con_otro_recargo_descripcion;
	}
	public String getid_tipo_global_cliente_descripcion() {
		return id_tipo_global_cliente_descripcion;
	}
	public String getcon_coa_descripcion() {
		return con_coa_descripcion;
	}
	public String getid_tipo_costeo_definicion_descripcion() {
		return id_tipo_costeo_definicion_descripcion;
	}
	public String getcon_retencion_descripcion() {
		return con_retencion_descripcion;
	}
	public String getid_tipo_costo_definicion_descripcion() {
		return id_tipo_costo_definicion_descripcion;
	}
	public String getcon_novedad_producto_descripcion() {
		return con_novedad_producto_descripcion;
	}
	public String getcon_ice_descripcion() {
		return con_ice_descripcion;
	}
	public String getcon_cantidad_descripcion() {
		return con_cantidad_descripcion;
	}
	public String getcon_producto_por_proveedor_descripcion() {
		return con_producto_por_proveedor_descripcion;
	}
	public String getcon_lote_cliente_descripcion() {
		return con_lote_cliente_descripcion;
	}
	public String getcon_cuenta_contable_descripcion() {
		return con_cuenta_contable_descripcion;
	}
	public String getcon_detalle_descripcion() {
		return con_detalle_descripcion;
	}
	public String getcon_iva_incluido_descripcion() {
		return con_iva_incluido_descripcion;
	}
	public String getcon_lotes_descripcion() {
		return con_lotes_descripcion;
	}
	public String getcon_precio_descripcion() {
		return con_precio_descripcion;
	}
	public String getcon_centro_costo_descripcion() {
		return con_centro_costo_descripcion;
	}
	public String getcon_orden_iva_descripcion() {
		return con_orden_iva_descripcion;
	}
	public String getcon_multi_empresa_descripcion() {
		return con_multi_empresa_descripcion;
	}
	public String getid_formato_descripcion() {
		return id_formato_descripcion;
	}
	public String getcon_en_linea_descripcion() {
		return con_en_linea_descripcion;
	}
	public String getid_tipo_tributario_descripcion() {
		return id_tipo_tributario_descripcion;
	}
	public String getid_tipo_retencion_descripcion() {
		return id_tipo_retencion_descripcion;
	}
	public String getcon_evaluacion_descripcion() {
		return con_evaluacion_descripcion;
	}
	public String getcon_ot_descripcion() {
		return con_ot_descripcion;
	}
	public String getcon_anticipo_descripcion() {
		return con_anticipo_descripcion;
	}
	public String getcon_cierre_descripcion() {
		return con_cierre_descripcion;
	}
	public String getcon_general_descripcion() {
		return con_general_descripcion;
	}
	public String getcon_por_producto_descripcion() {
		return con_por_producto_descripcion;
	}
	public String getcon_descuento_descripcion() {
		return con_descuento_descripcion;
	}
	public String getcon_series_descripcion() {
		return con_series_descripcion;
	}
	public String getid_tipo_documento_descripcion() {
		return id_tipo_documento_descripcion;
	}
	public String getid_libro_contable_descripcion() {
		return id_libro_contable_descripcion;
	}
	public String getcon_interno_descripcion() {
		return con_interno_descripcion;
	}
	public String getcon_reserva_descripcion() {
		return con_reserva_descripcion;
	}
	public String getcon_precio_proveedor_descripcion() {
		return con_precio_proveedor_descripcion;
	}
	public String getcon_produccion_descripcion() {
		return con_produccion_descripcion;
	}
	public String getcon_codigo_barra_descripcion() {
		return con_codigo_barra_descripcion;
	}
	public String getcon_romaneos_descripcion() {
		return con_romaneos_descripcion;
	}
	public String getid_tipo_transaccion_modulo_descripcion() {
		return id_tipo_transaccion_modulo_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
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
	public void setid_tipo_definicion_descripcion(String newid_tipo_definicion_descripcion)throws Exception {
		try {
			this.id_tipo_definicion_descripcion=newid_tipo_definicion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_descripcion(String newid_transaccion_descripcion)throws Exception {
		try {
			this.id_transaccion_descripcion=newid_transaccion_descripcion;
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
	public void setid_tipo_iva_item_descripcion(String newid_tipo_iva_item_descripcion)throws Exception {
		try {
			this.id_tipo_iva_item_descripcion=newid_tipo_iva_item_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_mostrar_bodega_descripcion(String newcon_mostrar_bodega_descripcion)throws Exception {
		try {
			this.con_mostrar_bodega_descripcion=newcon_mostrar_bodega_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_otro_recargo_descripcion(String newcon_otro_recargo_descripcion)throws Exception {
		try {
			this.con_otro_recargo_descripcion=newcon_otro_recargo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_global_cliente_descripcion(String newid_tipo_global_cliente_descripcion)throws Exception {
		try {
			this.id_tipo_global_cliente_descripcion=newid_tipo_global_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_coa_descripcion(String newcon_coa_descripcion)throws Exception {
		try {
			this.con_coa_descripcion=newcon_coa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_costeo_definicion_descripcion(String newid_tipo_costeo_definicion_descripcion)throws Exception {
		try {
			this.id_tipo_costeo_definicion_descripcion=newid_tipo_costeo_definicion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_retencion_descripcion(String newcon_retencion_descripcion)throws Exception {
		try {
			this.con_retencion_descripcion=newcon_retencion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_costo_definicion_descripcion(String newid_tipo_costo_definicion_descripcion)throws Exception {
		try {
			this.id_tipo_costo_definicion_descripcion=newid_tipo_costo_definicion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_novedad_producto_descripcion(String newcon_novedad_producto_descripcion)throws Exception {
		try {
			this.con_novedad_producto_descripcion=newcon_novedad_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_ice_descripcion(String newcon_ice_descripcion)throws Exception {
		try {
			this.con_ice_descripcion=newcon_ice_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_cantidad_descripcion(String newcon_cantidad_descripcion)throws Exception {
		try {
			this.con_cantidad_descripcion=newcon_cantidad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_producto_por_proveedor_descripcion(String newcon_producto_por_proveedor_descripcion)throws Exception {
		try {
			this.con_producto_por_proveedor_descripcion=newcon_producto_por_proveedor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_lote_cliente_descripcion(String newcon_lote_cliente_descripcion)throws Exception {
		try {
			this.con_lote_cliente_descripcion=newcon_lote_cliente_descripcion;
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
	public void setcon_detalle_descripcion(String newcon_detalle_descripcion)throws Exception {
		try {
			this.con_detalle_descripcion=newcon_detalle_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_iva_incluido_descripcion(String newcon_iva_incluido_descripcion)throws Exception {
		try {
			this.con_iva_incluido_descripcion=newcon_iva_incluido_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_lotes_descripcion(String newcon_lotes_descripcion)throws Exception {
		try {
			this.con_lotes_descripcion=newcon_lotes_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_precio_descripcion(String newcon_precio_descripcion)throws Exception {
		try {
			this.con_precio_descripcion=newcon_precio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_centro_costo_descripcion(String newcon_centro_costo_descripcion)throws Exception {
		try {
			this.con_centro_costo_descripcion=newcon_centro_costo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_orden_iva_descripcion(String newcon_orden_iva_descripcion)throws Exception {
		try {
			this.con_orden_iva_descripcion=newcon_orden_iva_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_multi_empresa_descripcion(String newcon_multi_empresa_descripcion)throws Exception {
		try {
			this.con_multi_empresa_descripcion=newcon_multi_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_descripcion(String newid_formato_descripcion)throws Exception {
		try {
			this.id_formato_descripcion=newid_formato_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_en_linea_descripcion(String newcon_en_linea_descripcion)throws Exception {
		try {
			this.con_en_linea_descripcion=newcon_en_linea_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_tributario_descripcion(String newid_tipo_tributario_descripcion)throws Exception {
		try {
			this.id_tipo_tributario_descripcion=newid_tipo_tributario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_retencion_descripcion(String newid_tipo_retencion_descripcion)throws Exception {
		try {
			this.id_tipo_retencion_descripcion=newid_tipo_retencion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_evaluacion_descripcion(String newcon_evaluacion_descripcion)throws Exception {
		try {
			this.con_evaluacion_descripcion=newcon_evaluacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_ot_descripcion(String newcon_ot_descripcion)throws Exception {
		try {
			this.con_ot_descripcion=newcon_ot_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_anticipo_descripcion(String newcon_anticipo_descripcion)throws Exception {
		try {
			this.con_anticipo_descripcion=newcon_anticipo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_cierre_descripcion(String newcon_cierre_descripcion)throws Exception {
		try {
			this.con_cierre_descripcion=newcon_cierre_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_general_descripcion(String newcon_general_descripcion)throws Exception {
		try {
			this.con_general_descripcion=newcon_general_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_por_producto_descripcion(String newcon_por_producto_descripcion)throws Exception {
		try {
			this.con_por_producto_descripcion=newcon_por_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_descuento_descripcion(String newcon_descuento_descripcion)throws Exception {
		try {
			this.con_descuento_descripcion=newcon_descuento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_series_descripcion(String newcon_series_descripcion)throws Exception {
		try {
			this.con_series_descripcion=newcon_series_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_documento_descripcion(String newid_tipo_documento_descripcion)throws Exception {
		try {
			this.id_tipo_documento_descripcion=newid_tipo_documento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_libro_contable_descripcion(String newid_libro_contable_descripcion)throws Exception {
		try {
			this.id_libro_contable_descripcion=newid_libro_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_interno_descripcion(String newcon_interno_descripcion) {
		this.con_interno_descripcion=newcon_interno_descripcion;
	}
	public void setcon_reserva_descripcion(String newcon_reserva_descripcion)throws Exception {
		try {
			this.con_reserva_descripcion=newcon_reserva_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_precio_proveedor_descripcion(String newcon_precio_proveedor_descripcion)throws Exception {
		try {
			this.con_precio_proveedor_descripcion=newcon_precio_proveedor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_produccion_descripcion(String newcon_produccion_descripcion)throws Exception {
		try {
			this.con_produccion_descripcion=newcon_produccion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_codigo_barra_descripcion(String newcon_codigo_barra_descripcion)throws Exception {
		try {
			this.con_codigo_barra_descripcion=newcon_codigo_barra_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_romaneos_descripcion(String newcon_romaneos_descripcion)throws Exception {
		try {
			this.con_romaneos_descripcion=newcon_romaneos_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_transaccion_modulo_descripcion(String newid_tipo_transaccion_modulo_descripcion)throws Exception {
		try {
			this.id_tipo_transaccion_modulo_descripcion=newid_tipo_transaccion_modulo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_descripcion(String newid_cuenta_contable_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_descripcion=newid_cuenta_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_modulo_descripcion="";this.id_tipo_definicion_descripcion="";this.id_transaccion_descripcion="";this.id_sucursal_descripcion="";this.id_tipo_iva_item_descripcion="";this.con_mostrar_bodega_descripcion="";this.con_otro_recargo_descripcion="";this.id_tipo_global_cliente_descripcion="";this.con_coa_descripcion="";this.id_tipo_costeo_definicion_descripcion="";this.con_retencion_descripcion="";this.id_tipo_costo_definicion_descripcion="";this.con_novedad_producto_descripcion="";this.con_ice_descripcion="";this.con_cantidad_descripcion="";this.con_producto_por_proveedor_descripcion="";this.con_lote_cliente_descripcion="";this.con_cuenta_contable_descripcion="";this.con_detalle_descripcion="";this.con_iva_incluido_descripcion="";this.con_lotes_descripcion="";this.con_precio_descripcion="";this.con_centro_costo_descripcion="";this.con_orden_iva_descripcion="";this.con_multi_empresa_descripcion="";this.id_formato_descripcion="";this.con_en_linea_descripcion="";this.id_tipo_tributario_descripcion="";this.id_tipo_retencion_descripcion="";this.con_evaluacion_descripcion="";this.con_ot_descripcion="";this.con_anticipo_descripcion="";this.con_cierre_descripcion="";this.con_general_descripcion="";this.con_por_producto_descripcion="";this.con_descuento_descripcion="";this.con_series_descripcion="";this.id_tipo_documento_descripcion="";this.id_libro_contable_descripcion="";this.con_interno_descripcion="";this.con_reserva_descripcion="";this.con_precio_proveedor_descripcion="";this.con_produccion_descripcion="";this.con_codigo_barra_descripcion="";this.con_romaneos_descripcion="";this.id_tipo_transaccion_modulo_descripcion="";this.id_cuenta_contable_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

