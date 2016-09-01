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
package com.bydan.erp.facturacion.business.entity;

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
//import com.bydan.erp.facturacion.util.ParametroFactuPrincipalConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class ParametroFactuPrincipal extends ParametroFactuPrincipalAdditional implements Serializable ,Cloneable {//ParametroFactuPrincipalAdditional,GeneralEntity
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
	
	private ParametroFactuPrincipal parametrofactuprincipalOriginal;
	
	private Map<String, Object> mapParametroFactuPrincipal;
			
	public Map<String, Object> getMapParametroFactuPrincipal() {
		return mapParametroFactuPrincipal;
	}

	public void setMapParametroFactuPrincipal(Map<String, Object> mapParametroFactuPrincipal) {
		this.mapParametroFactuPrincipal = mapParametroFactuPrincipal;
	}
	
	public void inicializarMapParametroFactuPrincipal() {
		this.mapParametroFactuPrincipal = new HashMap<String,Object>();
	}
	
	public void setMapParametroFactuPrincipalValue(String sKey,Object oValue) {
		this.mapParametroFactuPrincipal.put(sKey, oValue);
	}
	
	public Object getMapParametroFactuPrincipalValue(String sKey) {
		return this.mapParametroFactuPrincipal.get(sKey);
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
	private Long id_tipo_param_factu_descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_param_factu_listado_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_param_factu_secuencia_trabajo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_documento_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_documento_nota_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_documento_nota_debito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean en_linea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_cuenta_tipo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_cliente_impuesto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_libro_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_moneda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_impresion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_secuencial_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_secuencial_editable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_precio_por_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_modificar_precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_modificar_servicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_cambiar_unidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_decimales_unidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_activar_serie;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_activar_lote;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_activar_multi_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_centro_costos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_unidades;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_cupo_disponible;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_forma_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_envio_mail;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_autorizar_proforma;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_bloqueo_pedido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_control_anticipo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_factura_auto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_grabar_valor_cero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_agregar_item;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_copias;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroFactuPrincipalConstantesFunciones.SREGEXLEYENDA,message=ParametroFactuPrincipalConstantesFunciones.SMENSAJEREGEXLEYENDA)
	private String leyenda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_sin_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_flete_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_cuenta_contable_otro_cargo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_finan;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_boni;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_boni_devol;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_ice;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public TipoParamFactuDescuento tipoparamfactudescuento;
	public TipoParamFactuListadoCliente tipoparamfactulistadocliente;
	public TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo;
	public TipoDocumento tipodocumentofactura;
	public TipoDocumento tipodocumentonotacredito;
	public TipoDocumento tipodocumentonotadebito;
	public LibroContable librocontable;
	public Moneda moneda;
	public Formato formato;
	public CuentaContable cuentacontablefleteventa;
	public CuentaContable cuentacontableotrocargo;
	public CuentaContable cuentacontablefinan;
	public CuentaContable cuentacontableboni;
	public CuentaContable cuentacontablebonidevol;
	public CuentaContable cuentacontableice;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String tipoparamfactudescuento_descripcion;
	private String tipoparamfactulistadocliente_descripcion;
	private String tipoparamfactusecuenciatrabajo_descripcion;
	private String tipodocumentofactura_descripcion;
	private String tipodocumentonotacredito_descripcion;
	private String tipodocumentonotadebito_descripcion;
	private String librocontable_descripcion;
	private String moneda_descripcion;
	private String formato_descripcion;
	private String cuentacontablefleteventa_descripcion;
	private String cuentacontableotrocargo_descripcion;
	private String cuentacontablefinan_descripcion;
	private String cuentacontableboni_descripcion;
	private String cuentacontablebonidevol_descripcion;
	private String cuentacontableice_descripcion;
	
	
		
	public ParametroFactuPrincipal () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametrofactuprincipalOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_tipo_param_factu_descuento=-1L;
 		this.id_tipo_param_factu_listado_cliente=-1L;
 		this.id_tipo_param_factu_secuencia_trabajo=-1L;
 		this.id_tipo_documento_factura=-1L;
 		this.id_tipo_documento_nota_credito=-1L;
 		this.id_tipo_documento_nota_debito=-1L;
 		this.en_linea=false;
 		this.con_cuenta_tipo_cliente=false;
 		this.con_cliente_impuesto=false;
 		this.id_libro_contable=-1L;
 		this.id_moneda=-1L;
 		this.con_impresion=false;
 		this.id_formato=-1L;
 		this.con_secuencial_usuario=false;
 		this.con_secuencial_editable=false;
 		this.con_precio_por_cliente=false;
 		this.con_modificar_precio=false;
 		this.con_modificar_servicio=false;
 		this.con_cambiar_unidad=false;
 		this.numero_decimales_unidad=0;
 		this.con_activar_serie=false;
 		this.con_activar_lote=false;
 		this.con_activar_multi_empresa=false;
 		this.con_centro_costos=false;
 		this.con_unidades=false;
 		this.con_cupo_disponible=false;
 		this.con_forma_pago=false;
 		this.con_envio_mail=false;
 		this.con_autorizar_proforma=false;
 		this.con_bloqueo_pedido=false;
 		this.con_control_anticipo=false;
 		this.con_factura_auto=false;
 		this.con_grabar_valor_cero=false;
 		this.con_agregar_item=false;
 		this.numero_copias=0;
 		this.leyenda="";
 		this.con_sin_factura=false;
 		this.id_cuenta_contable_flete_venta=-1L;
 		this.id_cuenta_contable_otro_cargo=-1L;
 		this.id_cuenta_contable_finan=-1L;
 		this.id_cuenta_contable_boni=-1L;
 		this.id_cuenta_contable_boni_devol=-1L;
 		this.id_cuenta_contable_ice=-1L;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.tipoparamfactudescuento=null;
		this.tipoparamfactulistadocliente=null;
		this.tipoparamfactusecuenciatrabajo=null;
		this.tipodocumentofactura=null;
		this.tipodocumentonotacredito=null;
		this.tipodocumentonotadebito=null;
		this.librocontable=null;
		this.moneda=null;
		this.formato=null;
		this.cuentacontablefleteventa=null;
		this.cuentacontableotrocargo=null;
		this.cuentacontablefinan=null;
		this.cuentacontableboni=null;
		this.cuentacontablebonidevol=null;
		this.cuentacontableice=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.tipoparamfactudescuento_descripcion="";
		this.tipoparamfactulistadocliente_descripcion="";
		this.tipoparamfactusecuenciatrabajo_descripcion="";
		this.tipodocumentofactura_descripcion="";
		this.tipodocumentonotacredito_descripcion="";
		this.tipodocumentonotadebito_descripcion="";
		this.librocontable_descripcion="";
		this.moneda_descripcion="";
		this.formato_descripcion="";
		this.cuentacontablefleteventa_descripcion="";
		this.cuentacontableotrocargo_descripcion="";
		this.cuentacontablefinan_descripcion="";
		this.cuentacontableboni_descripcion="";
		this.cuentacontablebonidevol_descripcion="";
		this.cuentacontableice_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroFactuPrincipal (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_tipo_param_factu_descuento,Long id_tipo_param_factu_listado_cliente,Long id_tipo_param_factu_secuencia_trabajo,Long id_tipo_documento_factura,Long id_tipo_documento_nota_credito,Long id_tipo_documento_nota_debito,Boolean en_linea,Boolean con_cuenta_tipo_cliente,Boolean con_cliente_impuesto,Long id_libro_contable,Long id_moneda,Boolean con_impresion,Long id_formato,Boolean con_secuencial_usuario,Boolean con_secuencial_editable,Boolean con_precio_por_cliente,Boolean con_modificar_precio,Boolean con_modificar_servicio,Boolean con_cambiar_unidad,Integer numero_decimales_unidad,Boolean con_activar_serie,Boolean con_activar_lote,Boolean con_activar_multi_empresa,Boolean con_centro_costos,Boolean con_unidades,Boolean con_cupo_disponible,Boolean con_forma_pago,Boolean con_envio_mail,Boolean con_autorizar_proforma,Boolean con_bloqueo_pedido,Boolean con_control_anticipo,Boolean con_factura_auto,Boolean con_grabar_valor_cero,Boolean con_agregar_item,Integer numero_copias,String leyenda,Boolean con_sin_factura,Long id_cuenta_contable_flete_venta,Long id_cuenta_contable_otro_cargo,Long id_cuenta_contable_finan,Long id_cuenta_contable_boni,Long id_cuenta_contable_boni_devol,Long id_cuenta_contable_ice) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrofactuprincipalOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_tipo_param_factu_descuento=id_tipo_param_factu_descuento;
 		this.id_tipo_param_factu_listado_cliente=id_tipo_param_factu_listado_cliente;
 		this.id_tipo_param_factu_secuencia_trabajo=id_tipo_param_factu_secuencia_trabajo;
 		this.id_tipo_documento_factura=id_tipo_documento_factura;
 		this.id_tipo_documento_nota_credito=id_tipo_documento_nota_credito;
 		this.id_tipo_documento_nota_debito=id_tipo_documento_nota_debito;
 		this.en_linea=en_linea;
 		this.con_cuenta_tipo_cliente=con_cuenta_tipo_cliente;
 		this.con_cliente_impuesto=con_cliente_impuesto;
 		this.id_libro_contable=id_libro_contable;
 		this.id_moneda=id_moneda;
 		this.con_impresion=con_impresion;
 		this.id_formato=id_formato;
 		this.con_secuencial_usuario=con_secuencial_usuario;
 		this.con_secuencial_editable=con_secuencial_editable;
 		this.con_precio_por_cliente=con_precio_por_cliente;
 		this.con_modificar_precio=con_modificar_precio;
 		this.con_modificar_servicio=con_modificar_servicio;
 		this.con_cambiar_unidad=con_cambiar_unidad;
 		this.numero_decimales_unidad=numero_decimales_unidad;
 		this.con_activar_serie=con_activar_serie;
 		this.con_activar_lote=con_activar_lote;
 		this.con_activar_multi_empresa=con_activar_multi_empresa;
 		this.con_centro_costos=con_centro_costos;
 		this.con_unidades=con_unidades;
 		this.con_cupo_disponible=con_cupo_disponible;
 		this.con_forma_pago=con_forma_pago;
 		this.con_envio_mail=con_envio_mail;
 		this.con_autorizar_proforma=con_autorizar_proforma;
 		this.con_bloqueo_pedido=con_bloqueo_pedido;
 		this.con_control_anticipo=con_control_anticipo;
 		this.con_factura_auto=con_factura_auto;
 		this.con_grabar_valor_cero=con_grabar_valor_cero;
 		this.con_agregar_item=con_agregar_item;
 		this.numero_copias=numero_copias;
 		this.leyenda=leyenda;
 		this.con_sin_factura=con_sin_factura;
 		this.id_cuenta_contable_flete_venta=id_cuenta_contable_flete_venta;
 		this.id_cuenta_contable_otro_cargo=id_cuenta_contable_otro_cargo;
 		this.id_cuenta_contable_finan=id_cuenta_contable_finan;
 		this.id_cuenta_contable_boni=id_cuenta_contable_boni;
 		this.id_cuenta_contable_boni_devol=id_cuenta_contable_boni_devol;
 		this.id_cuenta_contable_ice=id_cuenta_contable_ice;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroFactuPrincipal (Long id_empresa,Long id_sucursal,Long id_tipo_param_factu_descuento,Long id_tipo_param_factu_listado_cliente,Long id_tipo_param_factu_secuencia_trabajo,Long id_tipo_documento_factura,Long id_tipo_documento_nota_credito,Long id_tipo_documento_nota_debito,Boolean en_linea,Boolean con_cuenta_tipo_cliente,Boolean con_cliente_impuesto,Long id_libro_contable,Long id_moneda,Boolean con_impresion,Long id_formato,Boolean con_secuencial_usuario,Boolean con_secuencial_editable,Boolean con_precio_por_cliente,Boolean con_modificar_precio,Boolean con_modificar_servicio,Boolean con_cambiar_unidad,Integer numero_decimales_unidad,Boolean con_activar_serie,Boolean con_activar_lote,Boolean con_activar_multi_empresa,Boolean con_centro_costos,Boolean con_unidades,Boolean con_cupo_disponible,Boolean con_forma_pago,Boolean con_envio_mail,Boolean con_autorizar_proforma,Boolean con_bloqueo_pedido,Boolean con_control_anticipo,Boolean con_factura_auto,Boolean con_grabar_valor_cero,Boolean con_agregar_item,Integer numero_copias,String leyenda,Boolean con_sin_factura,Long id_cuenta_contable_flete_venta,Long id_cuenta_contable_otro_cargo,Long id_cuenta_contable_finan,Long id_cuenta_contable_boni,Long id_cuenta_contable_boni_devol,Long id_cuenta_contable_ice) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrofactuprincipalOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_tipo_param_factu_descuento=id_tipo_param_factu_descuento;
 		this.id_tipo_param_factu_listado_cliente=id_tipo_param_factu_listado_cliente;
 		this.id_tipo_param_factu_secuencia_trabajo=id_tipo_param_factu_secuencia_trabajo;
 		this.id_tipo_documento_factura=id_tipo_documento_factura;
 		this.id_tipo_documento_nota_credito=id_tipo_documento_nota_credito;
 		this.id_tipo_documento_nota_debito=id_tipo_documento_nota_debito;
 		this.en_linea=en_linea;
 		this.con_cuenta_tipo_cliente=con_cuenta_tipo_cliente;
 		this.con_cliente_impuesto=con_cliente_impuesto;
 		this.id_libro_contable=id_libro_contable;
 		this.id_moneda=id_moneda;
 		this.con_impresion=con_impresion;
 		this.id_formato=id_formato;
 		this.con_secuencial_usuario=con_secuencial_usuario;
 		this.con_secuencial_editable=con_secuencial_editable;
 		this.con_precio_por_cliente=con_precio_por_cliente;
 		this.con_modificar_precio=con_modificar_precio;
 		this.con_modificar_servicio=con_modificar_servicio;
 		this.con_cambiar_unidad=con_cambiar_unidad;
 		this.numero_decimales_unidad=numero_decimales_unidad;
 		this.con_activar_serie=con_activar_serie;
 		this.con_activar_lote=con_activar_lote;
 		this.con_activar_multi_empresa=con_activar_multi_empresa;
 		this.con_centro_costos=con_centro_costos;
 		this.con_unidades=con_unidades;
 		this.con_cupo_disponible=con_cupo_disponible;
 		this.con_forma_pago=con_forma_pago;
 		this.con_envio_mail=con_envio_mail;
 		this.con_autorizar_proforma=con_autorizar_proforma;
 		this.con_bloqueo_pedido=con_bloqueo_pedido;
 		this.con_control_anticipo=con_control_anticipo;
 		this.con_factura_auto=con_factura_auto;
 		this.con_grabar_valor_cero=con_grabar_valor_cero;
 		this.con_agregar_item=con_agregar_item;
 		this.numero_copias=numero_copias;
 		this.leyenda=leyenda;
 		this.con_sin_factura=con_sin_factura;
 		this.id_cuenta_contable_flete_venta=id_cuenta_contable_flete_venta;
 		this.id_cuenta_contable_otro_cargo=id_cuenta_contable_otro_cargo;
 		this.id_cuenta_contable_finan=id_cuenta_contable_finan;
 		this.id_cuenta_contable_boni=id_cuenta_contable_boni;
 		this.id_cuenta_contable_boni_devol=id_cuenta_contable_boni_devol;
 		this.id_cuenta_contable_ice=id_cuenta_contable_ice;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroFactuPrincipal parametrofactuprincipalLocal=null;
		
		if(object!=null) {
			parametrofactuprincipalLocal=(ParametroFactuPrincipal)object;
			
			if(parametrofactuprincipalLocal!=null) {
				if(this.getId()!=null && parametrofactuprincipalLocal.getId()!=null) {
					if(this.getId().equals(parametrofactuprincipalLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroFactuPrincipalConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroFactuPrincipalConstantesFunciones.getParametroFactuPrincipalDescripcion(this);
		} else {
			sDetalle=ParametroFactuPrincipalConstantesFunciones.getParametroFactuPrincipalDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroFactuPrincipal getParametroFactuPrincipalOriginal() {
		return this.parametrofactuprincipalOriginal;
	}
	
	public void setParametroFactuPrincipalOriginal(ParametroFactuPrincipal parametrofactuprincipal) {
		try {
			this.parametrofactuprincipalOriginal=parametrofactuprincipal;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroFactuPrincipalAdditional parametrofactuprincipalAdditional=null;
	
	public ParametroFactuPrincipalAdditional getParametroFactuPrincipalAdditional() {
		return this.parametrofactuprincipalAdditional;
	}
	
	public void setParametroFactuPrincipalAdditional(ParametroFactuPrincipalAdditional parametrofactuprincipalAdditional) {
		try {
			this.parametrofactuprincipalAdditional=parametrofactuprincipalAdditional;
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
    
	
	public Long getid_tipo_param_factu_descuento() {
		return this.id_tipo_param_factu_descuento;
	}
    
	
	public Long getid_tipo_param_factu_listado_cliente() {
		return this.id_tipo_param_factu_listado_cliente;
	}
    
	
	public Long getid_tipo_param_factu_secuencia_trabajo() {
		return this.id_tipo_param_factu_secuencia_trabajo;
	}
    
	
	public Long getid_tipo_documento_factura() {
		return this.id_tipo_documento_factura;
	}
    
	
	public Long getid_tipo_documento_nota_credito() {
		return this.id_tipo_documento_nota_credito;
	}
    
	
	public Long getid_tipo_documento_nota_debito() {
		return this.id_tipo_documento_nota_debito;
	}
    
	
	public Boolean geten_linea() {
		return this.en_linea;
	}
    
	
	public Boolean getcon_cuenta_tipo_cliente() {
		return this.con_cuenta_tipo_cliente;
	}
    
	
	public Boolean getcon_cliente_impuesto() {
		return this.con_cliente_impuesto;
	}
    
	
	public Long getid_libro_contable() {
		return this.id_libro_contable;
	}
    
	
	public Long getid_moneda() {
		return this.id_moneda;
	}
    
	
	public Boolean getcon_impresion() {
		return this.con_impresion;
	}
    
	
	public Long getid_formato() {
		return this.id_formato;
	}
    
	
	public Boolean getcon_secuencial_usuario() {
		return this.con_secuencial_usuario;
	}
    
	
	public Boolean getcon_secuencial_editable() {
		return this.con_secuencial_editable;
	}
    
	
	public Boolean getcon_precio_por_cliente() {
		return this.con_precio_por_cliente;
	}
    
	
	public Boolean getcon_modificar_precio() {
		return this.con_modificar_precio;
	}
    
	
	public Boolean getcon_modificar_servicio() {
		return this.con_modificar_servicio;
	}
    
	
	public Boolean getcon_cambiar_unidad() {
		return this.con_cambiar_unidad;
	}
    
	
	public Integer getnumero_decimales_unidad() {
		return this.numero_decimales_unidad;
	}
    
	
	public Boolean getcon_activar_serie() {
		return this.con_activar_serie;
	}
    
	
	public Boolean getcon_activar_lote() {
		return this.con_activar_lote;
	}
    
	
	public Boolean getcon_activar_multi_empresa() {
		return this.con_activar_multi_empresa;
	}
    
	
	public Boolean getcon_centro_costos() {
		return this.con_centro_costos;
	}
    
	
	public Boolean getcon_unidades() {
		return this.con_unidades;
	}
    
	
	public Boolean getcon_cupo_disponible() {
		return this.con_cupo_disponible;
	}
    
	
	public Boolean getcon_forma_pago() {
		return this.con_forma_pago;
	}
    
	
	public Boolean getcon_envio_mail() {
		return this.con_envio_mail;
	}
    
	
	public Boolean getcon_autorizar_proforma() {
		return this.con_autorizar_proforma;
	}
    
	
	public Boolean getcon_bloqueo_pedido() {
		return this.con_bloqueo_pedido;
	}
    
	
	public Boolean getcon_control_anticipo() {
		return this.con_control_anticipo;
	}
    
	
	public Boolean getcon_factura_auto() {
		return this.con_factura_auto;
	}
    
	
	public Boolean getcon_grabar_valor_cero() {
		return this.con_grabar_valor_cero;
	}
    
	
	public Boolean getcon_agregar_item() {
		return this.con_agregar_item;
	}
    
	
	public Integer getnumero_copias() {
		return this.numero_copias;
	}
    
	
	public String getleyenda() {
		return this.leyenda;
	}
    
	
	public Boolean getcon_sin_factura() {
		return this.con_sin_factura;
	}
    
	
	public Long getid_cuenta_contable_flete_venta() {
		return this.id_cuenta_contable_flete_venta;
	}
    
	
	public Long getid_cuenta_contable_otro_cargo() {
		return this.id_cuenta_contable_otro_cargo;
	}
    
	
	public Long getid_cuenta_contable_finan() {
		return this.id_cuenta_contable_finan;
	}
    
	
	public Long getid_cuenta_contable_boni() {
		return this.id_cuenta_contable_boni;
	}
    
	
	public Long getid_cuenta_contable_boni_devol() {
		return this.id_cuenta_contable_boni_devol;
	}
    
	
	public Long getid_cuenta_contable_ice() {
		return this.id_cuenta_contable_ice;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_param_factu_descuento(Long newid_tipo_param_factu_descuento)throws Exception
	{
		try {
			if(this.id_tipo_param_factu_descuento!=newid_tipo_param_factu_descuento) {
				if(newid_tipo_param_factu_descuento==null) {
					//newid_tipo_param_factu_descuento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna id_tipo_param_factu_descuento");
					}
				}

				this.id_tipo_param_factu_descuento=newid_tipo_param_factu_descuento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_param_factu_listado_cliente(Long newid_tipo_param_factu_listado_cliente)throws Exception
	{
		try {
			if(this.id_tipo_param_factu_listado_cliente!=newid_tipo_param_factu_listado_cliente) {
				if(newid_tipo_param_factu_listado_cliente==null) {
					//newid_tipo_param_factu_listado_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna id_tipo_param_factu_listado_cliente");
					}
				}

				this.id_tipo_param_factu_listado_cliente=newid_tipo_param_factu_listado_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_param_factu_secuencia_trabajo(Long newid_tipo_param_factu_secuencia_trabajo)throws Exception
	{
		try {
			if(this.id_tipo_param_factu_secuencia_trabajo!=newid_tipo_param_factu_secuencia_trabajo) {
				if(newid_tipo_param_factu_secuencia_trabajo==null) {
					//newid_tipo_param_factu_secuencia_trabajo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna id_tipo_param_factu_secuencia_trabajo");
					}
				}

				this.id_tipo_param_factu_secuencia_trabajo=newid_tipo_param_factu_secuencia_trabajo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_documento_factura(Long newid_tipo_documento_factura)throws Exception
	{
		try {
			if(this.id_tipo_documento_factura!=newid_tipo_documento_factura) {
				if(newid_tipo_documento_factura==null) {
					//newid_tipo_documento_factura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna id_tipo_documento_factura");
					}
				}

				this.id_tipo_documento_factura=newid_tipo_documento_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_documento_nota_credito(Long newid_tipo_documento_nota_credito)throws Exception
	{
		try {
			if(this.id_tipo_documento_nota_credito!=newid_tipo_documento_nota_credito) {
				if(newid_tipo_documento_nota_credito==null) {
					//newid_tipo_documento_nota_credito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna id_tipo_documento_nota_credito");
					}
				}

				this.id_tipo_documento_nota_credito=newid_tipo_documento_nota_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_documento_nota_debito(Long newid_tipo_documento_nota_debito)throws Exception
	{
		try {
			if(this.id_tipo_documento_nota_debito!=newid_tipo_documento_nota_debito) {
				if(newid_tipo_documento_nota_debito==null) {
					//newid_tipo_documento_nota_debito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna id_tipo_documento_nota_debito");
					}
				}

				this.id_tipo_documento_nota_debito=newid_tipo_documento_nota_debito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void seten_linea(Boolean newen_linea)throws Exception
	{
		try {
			if(this.en_linea!=newen_linea) {
				if(newen_linea==null) {
					//newen_linea=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna en_linea");
					}
				}

				this.en_linea=newen_linea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_cuenta_tipo_cliente(Boolean newcon_cuenta_tipo_cliente)throws Exception
	{
		try {
			if(this.con_cuenta_tipo_cliente!=newcon_cuenta_tipo_cliente) {
				if(newcon_cuenta_tipo_cliente==null) {
					//newcon_cuenta_tipo_cliente=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_cuenta_tipo_cliente");
					}
				}

				this.con_cuenta_tipo_cliente=newcon_cuenta_tipo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_cliente_impuesto(Boolean newcon_cliente_impuesto)throws Exception
	{
		try {
			if(this.con_cliente_impuesto!=newcon_cliente_impuesto) {
				if(newcon_cliente_impuesto==null) {
					//newcon_cliente_impuesto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_cliente_impuesto");
					}
				}

				this.con_cliente_impuesto=newcon_cliente_impuesto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_libro_contable(Long newid_libro_contable)throws Exception
	{
		try {
			if(this.id_libro_contable!=newid_libro_contable) {
				if(newid_libro_contable==null) {
					//newid_libro_contable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna id_libro_contable");
					}
				}

				this.id_libro_contable=newid_libro_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_moneda(Long newid_moneda)throws Exception
	{
		try {
			if(this.id_moneda!=newid_moneda) {
				if(newid_moneda==null) {
					//newid_moneda=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna id_moneda");
					}
				}

				this.id_moneda=newid_moneda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_impresion(Boolean newcon_impresion)throws Exception
	{
		try {
			if(this.con_impresion!=newcon_impresion) {
				if(newcon_impresion==null) {
					//newcon_impresion=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_impresion");
					}
				}

				this.con_impresion=newcon_impresion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato(Long newid_formato)throws Exception
	{
		try {
			if(this.id_formato!=newid_formato) {
				if(newid_formato==null) {
					//newid_formato=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna id_formato");
					}
				}

				this.id_formato=newid_formato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_secuencial_usuario(Boolean newcon_secuencial_usuario)throws Exception
	{
		try {
			if(this.con_secuencial_usuario!=newcon_secuencial_usuario) {
				if(newcon_secuencial_usuario==null) {
					//newcon_secuencial_usuario=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_secuencial_usuario");
					}
				}

				this.con_secuencial_usuario=newcon_secuencial_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_secuencial_editable(Boolean newcon_secuencial_editable)throws Exception
	{
		try {
			if(this.con_secuencial_editable!=newcon_secuencial_editable) {
				if(newcon_secuencial_editable==null) {
					//newcon_secuencial_editable=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_secuencial_editable");
					}
				}

				this.con_secuencial_editable=newcon_secuencial_editable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_precio_por_cliente(Boolean newcon_precio_por_cliente)throws Exception
	{
		try {
			if(this.con_precio_por_cliente!=newcon_precio_por_cliente) {
				if(newcon_precio_por_cliente==null) {
					//newcon_precio_por_cliente=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_precio_por_cliente");
					}
				}

				this.con_precio_por_cliente=newcon_precio_por_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_modificar_precio(Boolean newcon_modificar_precio)throws Exception
	{
		try {
			if(this.con_modificar_precio!=newcon_modificar_precio) {
				if(newcon_modificar_precio==null) {
					//newcon_modificar_precio=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_modificar_precio");
					}
				}

				this.con_modificar_precio=newcon_modificar_precio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_modificar_servicio(Boolean newcon_modificar_servicio)throws Exception
	{
		try {
			if(this.con_modificar_servicio!=newcon_modificar_servicio) {
				if(newcon_modificar_servicio==null) {
					//newcon_modificar_servicio=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_modificar_servicio");
					}
				}

				this.con_modificar_servicio=newcon_modificar_servicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_cambiar_unidad(Boolean newcon_cambiar_unidad)throws Exception
	{
		try {
			if(this.con_cambiar_unidad!=newcon_cambiar_unidad) {
				if(newcon_cambiar_unidad==null) {
					//newcon_cambiar_unidad=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_cambiar_unidad");
					}
				}

				this.con_cambiar_unidad=newcon_cambiar_unidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_decimales_unidad(Integer newnumero_decimales_unidad)throws Exception
	{
		try {
			if(this.numero_decimales_unidad!=newnumero_decimales_unidad) {
				if(newnumero_decimales_unidad==null) {
					//newnumero_decimales_unidad=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna numero_decimales_unidad");
					}
				}

				this.numero_decimales_unidad=newnumero_decimales_unidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_activar_serie(Boolean newcon_activar_serie)throws Exception
	{
		try {
			if(this.con_activar_serie!=newcon_activar_serie) {
				if(newcon_activar_serie==null) {
					//newcon_activar_serie=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_activar_serie");
					}
				}

				this.con_activar_serie=newcon_activar_serie;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_activar_lote(Boolean newcon_activar_lote)throws Exception
	{
		try {
			if(this.con_activar_lote!=newcon_activar_lote) {
				if(newcon_activar_lote==null) {
					//newcon_activar_lote=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_activar_lote");
					}
				}

				this.con_activar_lote=newcon_activar_lote;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_activar_multi_empresa(Boolean newcon_activar_multi_empresa)throws Exception
	{
		try {
			if(this.con_activar_multi_empresa!=newcon_activar_multi_empresa) {
				if(newcon_activar_multi_empresa==null) {
					//newcon_activar_multi_empresa=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_activar_multi_empresa");
					}
				}

				this.con_activar_multi_empresa=newcon_activar_multi_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_centro_costos(Boolean newcon_centro_costos)throws Exception
	{
		try {
			if(this.con_centro_costos!=newcon_centro_costos) {
				if(newcon_centro_costos==null) {
					//newcon_centro_costos=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_centro_costos");
					}
				}

				this.con_centro_costos=newcon_centro_costos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_unidades(Boolean newcon_unidades)throws Exception
	{
		try {
			if(this.con_unidades!=newcon_unidades) {
				if(newcon_unidades==null) {
					//newcon_unidades=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_unidades");
					}
				}

				this.con_unidades=newcon_unidades;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_cupo_disponible(Boolean newcon_cupo_disponible)throws Exception
	{
		try {
			if(this.con_cupo_disponible!=newcon_cupo_disponible) {
				if(newcon_cupo_disponible==null) {
					//newcon_cupo_disponible=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_cupo_disponible");
					}
				}

				this.con_cupo_disponible=newcon_cupo_disponible;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_forma_pago(Boolean newcon_forma_pago)throws Exception
	{
		try {
			if(this.con_forma_pago!=newcon_forma_pago) {
				if(newcon_forma_pago==null) {
					//newcon_forma_pago=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_forma_pago");
					}
				}

				this.con_forma_pago=newcon_forma_pago;
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
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_envio_mail");
					}
				}

				this.con_envio_mail=newcon_envio_mail;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_autorizar_proforma(Boolean newcon_autorizar_proforma)throws Exception
	{
		try {
			if(this.con_autorizar_proforma!=newcon_autorizar_proforma) {
				if(newcon_autorizar_proforma==null) {
					//newcon_autorizar_proforma=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_autorizar_proforma");
					}
				}

				this.con_autorizar_proforma=newcon_autorizar_proforma;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_bloqueo_pedido(Boolean newcon_bloqueo_pedido)throws Exception
	{
		try {
			if(this.con_bloqueo_pedido!=newcon_bloqueo_pedido) {
				if(newcon_bloqueo_pedido==null) {
					//newcon_bloqueo_pedido=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_bloqueo_pedido");
					}
				}

				this.con_bloqueo_pedido=newcon_bloqueo_pedido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_control_anticipo(Boolean newcon_control_anticipo)throws Exception
	{
		try {
			if(this.con_control_anticipo!=newcon_control_anticipo) {
				if(newcon_control_anticipo==null) {
					//newcon_control_anticipo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_control_anticipo");
					}
				}

				this.con_control_anticipo=newcon_control_anticipo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_factura_auto(Boolean newcon_factura_auto)throws Exception
	{
		try {
			if(this.con_factura_auto!=newcon_factura_auto) {
				if(newcon_factura_auto==null) {
					//newcon_factura_auto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_factura_auto");
					}
				}

				this.con_factura_auto=newcon_factura_auto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_grabar_valor_cero(Boolean newcon_grabar_valor_cero)throws Exception
	{
		try {
			if(this.con_grabar_valor_cero!=newcon_grabar_valor_cero) {
				if(newcon_grabar_valor_cero==null) {
					//newcon_grabar_valor_cero=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_grabar_valor_cero");
					}
				}

				this.con_grabar_valor_cero=newcon_grabar_valor_cero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_agregar_item(Boolean newcon_agregar_item)throws Exception
	{
		try {
			if(this.con_agregar_item!=newcon_agregar_item) {
				if(newcon_agregar_item==null) {
					//newcon_agregar_item=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_agregar_item");
					}
				}

				this.con_agregar_item=newcon_agregar_item;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_copias(Integer newnumero_copias)throws Exception
	{
		try {
			if(this.numero_copias!=newnumero_copias) {
				if(newnumero_copias==null) {
					//newnumero_copias=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna numero_copias");
					}
				}

				this.numero_copias=newnumero_copias;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setleyenda(String newleyenda)throws Exception
	{
		try {
			if(this.leyenda!=newleyenda) {
				if(newleyenda==null) {
					//newleyenda="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna leyenda");
					}
				}

				if(newleyenda!=null&&newleyenda.length()>150) {
					newleyenda=newleyenda.substring(0,148);
					System.out.println("ParametroFactuPrincipal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna leyenda");
				}

				this.leyenda=newleyenda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_sin_factura(Boolean newcon_sin_factura)throws Exception
	{
		try {
			if(this.con_sin_factura!=newcon_sin_factura) {
				if(newcon_sin_factura==null) {
					//newcon_sin_factura=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna con_sin_factura");
					}
				}

				this.con_sin_factura=newcon_sin_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_flete_venta(Long newid_cuenta_contable_flete_venta)throws Exception
	{
		try {
			if(this.id_cuenta_contable_flete_venta!=newid_cuenta_contable_flete_venta) {
				if(newid_cuenta_contable_flete_venta==null) {
					//newid_cuenta_contable_flete_venta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna id_cuenta_contable_flete_venta");
					}
				}

				this.id_cuenta_contable_flete_venta=newid_cuenta_contable_flete_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_otro_cargo(Long newid_cuenta_contable_otro_cargo)throws Exception
	{
		try {
			if(this.id_cuenta_contable_otro_cargo!=newid_cuenta_contable_otro_cargo) {
				if(newid_cuenta_contable_otro_cargo==null) {
					//newid_cuenta_contable_otro_cargo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna id_cuenta_contable_otro_cargo");
					}
				}

				this.id_cuenta_contable_otro_cargo=newid_cuenta_contable_otro_cargo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_finan(Long newid_cuenta_contable_finan)throws Exception
	{
		try {
			if(this.id_cuenta_contable_finan!=newid_cuenta_contable_finan) {
				if(newid_cuenta_contable_finan==null) {
					//newid_cuenta_contable_finan=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna id_cuenta_contable_finan");
					}
				}

				this.id_cuenta_contable_finan=newid_cuenta_contable_finan;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_boni(Long newid_cuenta_contable_boni)throws Exception
	{
		try {
			if(this.id_cuenta_contable_boni!=newid_cuenta_contable_boni) {
				if(newid_cuenta_contable_boni==null) {
					//newid_cuenta_contable_boni=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna id_cuenta_contable_boni");
					}
				}

				this.id_cuenta_contable_boni=newid_cuenta_contable_boni;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_boni_devol(Long newid_cuenta_contable_boni_devol)throws Exception
	{
		try {
			if(this.id_cuenta_contable_boni_devol!=newid_cuenta_contable_boni_devol) {
				if(newid_cuenta_contable_boni_devol==null) {
					//newid_cuenta_contable_boni_devol=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna id_cuenta_contable_boni_devol");
					}
				}

				this.id_cuenta_contable_boni_devol=newid_cuenta_contable_boni_devol;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_ice(Long newid_cuenta_contable_ice)throws Exception
	{
		try {
			if(this.id_cuenta_contable_ice!=newid_cuenta_contable_ice) {
				if(newid_cuenta_contable_ice==null) {
					//newid_cuenta_contable_ice=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuPrincipal:Valor nulo no permitido en columna id_cuenta_contable_ice");
					}
				}

				this.id_cuenta_contable_ice=newid_cuenta_contable_ice;
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

	public TipoParamFactuDescuento getTipoParamFactuDescuento() {
		return this.tipoparamfactudescuento;
	}

	public TipoParamFactuListadoCliente getTipoParamFactuListadoCliente() {
		return this.tipoparamfactulistadocliente;
	}

	public TipoParamFactuSecuenciaTrabajo getTipoParamFactuSecuenciaTrabajo() {
		return this.tipoparamfactusecuenciatrabajo;
	}

	public TipoDocumento getTipoDocumentoFactura() {
		return this.tipodocumentofactura;
	}

	public TipoDocumento getTipoDocumentoNotaCredito() {
		return this.tipodocumentonotacredito;
	}

	public TipoDocumento getTipoDocumentoNotaDebito() {
		return this.tipodocumentonotadebito;
	}

	public LibroContable getLibroContable() {
		return this.librocontable;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	public Formato getFormato() {
		return this.formato;
	}

	public CuentaContable getCuentaContableFleteVenta() {
		return this.cuentacontablefleteventa;
	}

	public CuentaContable getCuentaContableOtroCargo() {
		return this.cuentacontableotrocargo;
	}

	public CuentaContable getCuentaContableFinan() {
		return this.cuentacontablefinan;
	}

	public CuentaContable getCuentaContableBoni() {
		return this.cuentacontableboni;
	}

	public CuentaContable getCuentaContableBoniDevol() {
		return this.cuentacontablebonidevol;
	}

	public CuentaContable getCuentaContableIce() {
		return this.cuentacontableice;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String gettipoparamfactudescuento_descripcion() {
		return this.tipoparamfactudescuento_descripcion;
	}

	public String gettipoparamfactulistadocliente_descripcion() {
		return this.tipoparamfactulistadocliente_descripcion;
	}

	public String gettipoparamfactusecuenciatrabajo_descripcion() {
		return this.tipoparamfactusecuenciatrabajo_descripcion;
	}

	public String gettipodocumentofactura_descripcion() {
		return this.tipodocumentofactura_descripcion;
	}

	public String gettipodocumentonotacredito_descripcion() {
		return this.tipodocumentonotacredito_descripcion;
	}

	public String gettipodocumentonotadebito_descripcion() {
		return this.tipodocumentonotadebito_descripcion;
	}

	public String getlibrocontable_descripcion() {
		return this.librocontable_descripcion;
	}

	public String getmoneda_descripcion() {
		return this.moneda_descripcion;
	}

	public String getformato_descripcion() {
		return this.formato_descripcion;
	}

	public String getcuentacontablefleteventa_descripcion() {
		return this.cuentacontablefleteventa_descripcion;
	}

	public String getcuentacontableotrocargo_descripcion() {
		return this.cuentacontableotrocargo_descripcion;
	}

	public String getcuentacontablefinan_descripcion() {
		return this.cuentacontablefinan_descripcion;
	}

	public String getcuentacontableboni_descripcion() {
		return this.cuentacontableboni_descripcion;
	}

	public String getcuentacontablebonidevol_descripcion() {
		return this.cuentacontablebonidevol_descripcion;
	}

	public String getcuentacontableice_descripcion() {
		return this.cuentacontableice_descripcion;
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


	public  void  setTipoParamFactuDescuento(TipoParamFactuDescuento tipoparamfactudescuento) {
		try {
			this.tipoparamfactudescuento=tipoparamfactudescuento;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoParamFactuListadoCliente(TipoParamFactuListadoCliente tipoparamfactulistadocliente) {
		try {
			this.tipoparamfactulistadocliente=tipoparamfactulistadocliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoParamFactuSecuenciaTrabajo(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo) {
		try {
			this.tipoparamfactusecuenciatrabajo=tipoparamfactusecuenciatrabajo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoDocumentoFactura(TipoDocumento tipodocumentofactura) {
		try {
			this.tipodocumentofactura=tipodocumentofactura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoDocumentoNotaCredito(TipoDocumento tipodocumentonotacredito) {
		try {
			this.tipodocumentonotacredito=tipodocumentonotacredito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoDocumentoNotaDebito(TipoDocumento tipodocumentonotadebito) {
		try {
			this.tipodocumentonotadebito=tipodocumentonotadebito;
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


	public  void  setMoneda(Moneda moneda) {
		try {
			this.moneda=moneda;
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


	public  void  setCuentaContableFleteVenta(CuentaContable cuentacontablefleteventa) {
		try {
			this.cuentacontablefleteventa=cuentacontablefleteventa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableOtroCargo(CuentaContable cuentacontableotrocargo) {
		try {
			this.cuentacontableotrocargo=cuentacontableotrocargo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableFinan(CuentaContable cuentacontablefinan) {
		try {
			this.cuentacontablefinan=cuentacontablefinan;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableBoni(CuentaContable cuentacontableboni) {
		try {
			this.cuentacontableboni=cuentacontableboni;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableBoniDevol(CuentaContable cuentacontablebonidevol) {
		try {
			this.cuentacontablebonidevol=cuentacontablebonidevol;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableIce(CuentaContable cuentacontableice) {
		try {
			this.cuentacontableice=cuentacontableice;
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


	public  void  settipoparamfactudescuento_descripcion(String tipoparamfactudescuento_descripcion) {
		try {
			this.tipoparamfactudescuento_descripcion=tipoparamfactudescuento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoparamfactulistadocliente_descripcion(String tipoparamfactulistadocliente_descripcion) {
		try {
			this.tipoparamfactulistadocliente_descripcion=tipoparamfactulistadocliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoparamfactusecuenciatrabajo_descripcion(String tipoparamfactusecuenciatrabajo_descripcion) {
		try {
			this.tipoparamfactusecuenciatrabajo_descripcion=tipoparamfactusecuenciatrabajo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipodocumentofactura_descripcion(String tipodocumentofactura_descripcion) {
		try {
			this.tipodocumentofactura_descripcion=tipodocumentofactura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipodocumentonotacredito_descripcion(String tipodocumentonotacredito_descripcion) {
		try {
			this.tipodocumentonotacredito_descripcion=tipodocumentonotacredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipodocumentonotadebito_descripcion(String tipodocumentonotadebito_descripcion) {
		try {
			this.tipodocumentonotadebito_descripcion=tipodocumentonotadebito_descripcion;
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


	public  void  setmoneda_descripcion(String moneda_descripcion) {
		try {
			this.moneda_descripcion=moneda_descripcion;
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


	public  void  setcuentacontablefleteventa_descripcion(String cuentacontablefleteventa_descripcion) {
		try {
			this.cuentacontablefleteventa_descripcion=cuentacontablefleteventa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableotrocargo_descripcion(String cuentacontableotrocargo_descripcion) {
		try {
			this.cuentacontableotrocargo_descripcion=cuentacontableotrocargo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablefinan_descripcion(String cuentacontablefinan_descripcion) {
		try {
			this.cuentacontablefinan_descripcion=cuentacontablefinan_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableboni_descripcion(String cuentacontableboni_descripcion) {
		try {
			this.cuentacontableboni_descripcion=cuentacontableboni_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablebonidevol_descripcion(String cuentacontablebonidevol_descripcion) {
		try {
			this.cuentacontablebonidevol_descripcion=cuentacontablebonidevol_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableice_descripcion(String cuentacontableice_descripcion) {
		try {
			this.cuentacontableice_descripcion=cuentacontableice_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_tipo_param_factu_descuento_descripcion="";String id_tipo_param_factu_listado_cliente_descripcion="";String id_tipo_param_factu_secuencia_trabajo_descripcion="";String id_tipo_documento_factura_descripcion="";String id_tipo_documento_nota_credito_descripcion="";String id_tipo_documento_nota_debito_descripcion="";String en_linea_descripcion="";String con_cuenta_tipo_cliente_descripcion="";String con_cliente_impuesto_descripcion="";String id_libro_contable_descripcion="";String id_moneda_descripcion="";String con_impresion_descripcion="";String id_formato_descripcion="";String con_secuencial_usuario_descripcion="";String con_secuencial_editable_descripcion="";String con_precio_por_cliente_descripcion="";String con_modificar_precio_descripcion="";String con_modificar_servicio_descripcion="";String con_cambiar_unidad_descripcion="";String con_activar_serie_descripcion="";String con_activar_lote_descripcion="";String con_activar_multi_empresa_descripcion="";String con_centro_costos_descripcion="";String con_unidades_descripcion="";String con_cupo_disponible_descripcion="";String con_forma_pago_descripcion="";String con_envio_mail_descripcion="";String con_autorizar_proforma_descripcion="";String con_bloqueo_pedido_descripcion="";String con_control_anticipo_descripcion="";String con_factura_auto_descripcion="";String con_grabar_valor_cero_descripcion="";String con_agregar_item_descripcion="";String con_sin_factura_descripcion="";String id_cuenta_contable_flete_venta_descripcion="";String id_cuenta_contable_otro_cargo_descripcion="";String id_cuenta_contable_finan_descripcion="";String id_cuenta_contable_boni_descripcion="";String id_cuenta_contable_boni_devol_descripcion="";String id_cuenta_contable_ice_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_tipo_param_factu_descuento_descripcion() {
		return id_tipo_param_factu_descuento_descripcion;
	}
	public String getid_tipo_param_factu_listado_cliente_descripcion() {
		return id_tipo_param_factu_listado_cliente_descripcion;
	}
	public String getid_tipo_param_factu_secuencia_trabajo_descripcion() {
		return id_tipo_param_factu_secuencia_trabajo_descripcion;
	}
	public String getid_tipo_documento_factura_descripcion() {
		return id_tipo_documento_factura_descripcion;
	}
	public String getid_tipo_documento_nota_credito_descripcion() {
		return id_tipo_documento_nota_credito_descripcion;
	}
	public String getid_tipo_documento_nota_debito_descripcion() {
		return id_tipo_documento_nota_debito_descripcion;
	}
	public String geten_linea_descripcion() {
		return en_linea_descripcion;
	}
	public String getcon_cuenta_tipo_cliente_descripcion() {
		return con_cuenta_tipo_cliente_descripcion;
	}
	public String getcon_cliente_impuesto_descripcion() {
		return con_cliente_impuesto_descripcion;
	}
	public String getid_libro_contable_descripcion() {
		return id_libro_contable_descripcion;
	}
	public String getid_moneda_descripcion() {
		return id_moneda_descripcion;
	}
	public String getcon_impresion_descripcion() {
		return con_impresion_descripcion;
	}
	public String getid_formato_descripcion() {
		return id_formato_descripcion;
	}
	public String getcon_secuencial_usuario_descripcion() {
		return con_secuencial_usuario_descripcion;
	}
	public String getcon_secuencial_editable_descripcion() {
		return con_secuencial_editable_descripcion;
	}
	public String getcon_precio_por_cliente_descripcion() {
		return con_precio_por_cliente_descripcion;
	}
	public String getcon_modificar_precio_descripcion() {
		return con_modificar_precio_descripcion;
	}
	public String getcon_modificar_servicio_descripcion() {
		return con_modificar_servicio_descripcion;
	}
	public String getcon_cambiar_unidad_descripcion() {
		return con_cambiar_unidad_descripcion;
	}
	public String getcon_activar_serie_descripcion() {
		return con_activar_serie_descripcion;
	}
	public String getcon_activar_lote_descripcion() {
		return con_activar_lote_descripcion;
	}
	public String getcon_activar_multi_empresa_descripcion() {
		return con_activar_multi_empresa_descripcion;
	}
	public String getcon_centro_costos_descripcion() {
		return con_centro_costos_descripcion;
	}
	public String getcon_unidades_descripcion() {
		return con_unidades_descripcion;
	}
	public String getcon_cupo_disponible_descripcion() {
		return con_cupo_disponible_descripcion;
	}
	public String getcon_forma_pago_descripcion() {
		return con_forma_pago_descripcion;
	}
	public String getcon_envio_mail_descripcion() {
		return con_envio_mail_descripcion;
	}
	public String getcon_autorizar_proforma_descripcion() {
		return con_autorizar_proforma_descripcion;
	}
	public String getcon_bloqueo_pedido_descripcion() {
		return con_bloqueo_pedido_descripcion;
	}
	public String getcon_control_anticipo_descripcion() {
		return con_control_anticipo_descripcion;
	}
	public String getcon_factura_auto_descripcion() {
		return con_factura_auto_descripcion;
	}
	public String getcon_grabar_valor_cero_descripcion() {
		return con_grabar_valor_cero_descripcion;
	}
	public String getcon_agregar_item_descripcion() {
		return con_agregar_item_descripcion;
	}
	public String getcon_sin_factura_descripcion() {
		return con_sin_factura_descripcion;
	}
	public String getid_cuenta_contable_flete_venta_descripcion() {
		return id_cuenta_contable_flete_venta_descripcion;
	}
	public String getid_cuenta_contable_otro_cargo_descripcion() {
		return id_cuenta_contable_otro_cargo_descripcion;
	}
	public String getid_cuenta_contable_finan_descripcion() {
		return id_cuenta_contable_finan_descripcion;
	}
	public String getid_cuenta_contable_boni_descripcion() {
		return id_cuenta_contable_boni_descripcion;
	}
	public String getid_cuenta_contable_boni_devol_descripcion() {
		return id_cuenta_contable_boni_devol_descripcion;
	}
	public String getid_cuenta_contable_ice_descripcion() {
		return id_cuenta_contable_ice_descripcion;
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
	public void setid_tipo_param_factu_descuento_descripcion(String newid_tipo_param_factu_descuento_descripcion)throws Exception {
		try {
			this.id_tipo_param_factu_descuento_descripcion=newid_tipo_param_factu_descuento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_param_factu_listado_cliente_descripcion(String newid_tipo_param_factu_listado_cliente_descripcion)throws Exception {
		try {
			this.id_tipo_param_factu_listado_cliente_descripcion=newid_tipo_param_factu_listado_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_param_factu_secuencia_trabajo_descripcion(String newid_tipo_param_factu_secuencia_trabajo_descripcion)throws Exception {
		try {
			this.id_tipo_param_factu_secuencia_trabajo_descripcion=newid_tipo_param_factu_secuencia_trabajo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_documento_factura_descripcion(String newid_tipo_documento_factura_descripcion)throws Exception {
		try {
			this.id_tipo_documento_factura_descripcion=newid_tipo_documento_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_documento_nota_credito_descripcion(String newid_tipo_documento_nota_credito_descripcion)throws Exception {
		try {
			this.id_tipo_documento_nota_credito_descripcion=newid_tipo_documento_nota_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_documento_nota_debito_descripcion(String newid_tipo_documento_nota_debito_descripcion)throws Exception {
		try {
			this.id_tipo_documento_nota_debito_descripcion=newid_tipo_documento_nota_debito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void seten_linea_descripcion(String newen_linea_descripcion)throws Exception {
		try {
			this.en_linea_descripcion=newen_linea_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_cuenta_tipo_cliente_descripcion(String newcon_cuenta_tipo_cliente_descripcion)throws Exception {
		try {
			this.con_cuenta_tipo_cliente_descripcion=newcon_cuenta_tipo_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_cliente_impuesto_descripcion(String newcon_cliente_impuesto_descripcion)throws Exception {
		try {
			this.con_cliente_impuesto_descripcion=newcon_cliente_impuesto_descripcion;
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
	public void setid_moneda_descripcion(String newid_moneda_descripcion)throws Exception {
		try {
			this.id_moneda_descripcion=newid_moneda_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_impresion_descripcion(String newcon_impresion_descripcion)throws Exception {
		try {
			this.con_impresion_descripcion=newcon_impresion_descripcion;
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
	public void setcon_secuencial_usuario_descripcion(String newcon_secuencial_usuario_descripcion)throws Exception {
		try {
			this.con_secuencial_usuario_descripcion=newcon_secuencial_usuario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_secuencial_editable_descripcion(String newcon_secuencial_editable_descripcion)throws Exception {
		try {
			this.con_secuencial_editable_descripcion=newcon_secuencial_editable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_precio_por_cliente_descripcion(String newcon_precio_por_cliente_descripcion)throws Exception {
		try {
			this.con_precio_por_cliente_descripcion=newcon_precio_por_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_modificar_precio_descripcion(String newcon_modificar_precio_descripcion)throws Exception {
		try {
			this.con_modificar_precio_descripcion=newcon_modificar_precio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_modificar_servicio_descripcion(String newcon_modificar_servicio_descripcion)throws Exception {
		try {
			this.con_modificar_servicio_descripcion=newcon_modificar_servicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_cambiar_unidad_descripcion(String newcon_cambiar_unidad_descripcion)throws Exception {
		try {
			this.con_cambiar_unidad_descripcion=newcon_cambiar_unidad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_activar_serie_descripcion(String newcon_activar_serie_descripcion)throws Exception {
		try {
			this.con_activar_serie_descripcion=newcon_activar_serie_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_activar_lote_descripcion(String newcon_activar_lote_descripcion)throws Exception {
		try {
			this.con_activar_lote_descripcion=newcon_activar_lote_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_activar_multi_empresa_descripcion(String newcon_activar_multi_empresa_descripcion)throws Exception {
		try {
			this.con_activar_multi_empresa_descripcion=newcon_activar_multi_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_centro_costos_descripcion(String newcon_centro_costos_descripcion)throws Exception {
		try {
			this.con_centro_costos_descripcion=newcon_centro_costos_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_unidades_descripcion(String newcon_unidades_descripcion)throws Exception {
		try {
			this.con_unidades_descripcion=newcon_unidades_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_cupo_disponible_descripcion(String newcon_cupo_disponible_descripcion)throws Exception {
		try {
			this.con_cupo_disponible_descripcion=newcon_cupo_disponible_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_forma_pago_descripcion(String newcon_forma_pago_descripcion)throws Exception {
		try {
			this.con_forma_pago_descripcion=newcon_forma_pago_descripcion;
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
	public void setcon_autorizar_proforma_descripcion(String newcon_autorizar_proforma_descripcion)throws Exception {
		try {
			this.con_autorizar_proforma_descripcion=newcon_autorizar_proforma_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_bloqueo_pedido_descripcion(String newcon_bloqueo_pedido_descripcion)throws Exception {
		try {
			this.con_bloqueo_pedido_descripcion=newcon_bloqueo_pedido_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_control_anticipo_descripcion(String newcon_control_anticipo_descripcion)throws Exception {
		try {
			this.con_control_anticipo_descripcion=newcon_control_anticipo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_factura_auto_descripcion(String newcon_factura_auto_descripcion)throws Exception {
		try {
			this.con_factura_auto_descripcion=newcon_factura_auto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_grabar_valor_cero_descripcion(String newcon_grabar_valor_cero_descripcion)throws Exception {
		try {
			this.con_grabar_valor_cero_descripcion=newcon_grabar_valor_cero_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_agregar_item_descripcion(String newcon_agregar_item_descripcion)throws Exception {
		try {
			this.con_agregar_item_descripcion=newcon_agregar_item_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_sin_factura_descripcion(String newcon_sin_factura_descripcion)throws Exception {
		try {
			this.con_sin_factura_descripcion=newcon_sin_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_flete_venta_descripcion(String newid_cuenta_contable_flete_venta_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_flete_venta_descripcion=newid_cuenta_contable_flete_venta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_otro_cargo_descripcion(String newid_cuenta_contable_otro_cargo_descripcion) {
		this.id_cuenta_contable_otro_cargo_descripcion=newid_cuenta_contable_otro_cargo_descripcion;
	}
	public void setid_cuenta_contable_finan_descripcion(String newid_cuenta_contable_finan_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_finan_descripcion=newid_cuenta_contable_finan_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_boni_descripcion(String newid_cuenta_contable_boni_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_boni_descripcion=newid_cuenta_contable_boni_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_boni_devol_descripcion(String newid_cuenta_contable_boni_devol_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_boni_devol_descripcion=newid_cuenta_contable_boni_devol_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_ice_descripcion(String newid_cuenta_contable_ice_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_ice_descripcion=newid_cuenta_contable_ice_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_tipo_param_factu_descuento_descripcion="";this.id_tipo_param_factu_listado_cliente_descripcion="";this.id_tipo_param_factu_secuencia_trabajo_descripcion="";this.id_tipo_documento_factura_descripcion="";this.id_tipo_documento_nota_credito_descripcion="";this.id_tipo_documento_nota_debito_descripcion="";this.en_linea_descripcion="";this.con_cuenta_tipo_cliente_descripcion="";this.con_cliente_impuesto_descripcion="";this.id_libro_contable_descripcion="";this.id_moneda_descripcion="";this.con_impresion_descripcion="";this.id_formato_descripcion="";this.con_secuencial_usuario_descripcion="";this.con_secuencial_editable_descripcion="";this.con_precio_por_cliente_descripcion="";this.con_modificar_precio_descripcion="";this.con_modificar_servicio_descripcion="";this.con_cambiar_unidad_descripcion="";this.con_activar_serie_descripcion="";this.con_activar_lote_descripcion="";this.con_activar_multi_empresa_descripcion="";this.con_centro_costos_descripcion="";this.con_unidades_descripcion="";this.con_cupo_disponible_descripcion="";this.con_forma_pago_descripcion="";this.con_envio_mail_descripcion="";this.con_autorizar_proforma_descripcion="";this.con_bloqueo_pedido_descripcion="";this.con_control_anticipo_descripcion="";this.con_factura_auto_descripcion="";this.con_grabar_valor_cero_descripcion="";this.con_agregar_item_descripcion="";this.con_sin_factura_descripcion="";this.id_cuenta_contable_flete_venta_descripcion="";this.id_cuenta_contable_otro_cargo_descripcion="";this.id_cuenta_contable_finan_descripcion="";this.id_cuenta_contable_boni_descripcion="";this.id_cuenta_contable_boni_devol_descripcion="";this.id_cuenta_contable_ice_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

