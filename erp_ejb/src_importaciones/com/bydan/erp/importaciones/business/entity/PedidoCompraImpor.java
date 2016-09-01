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
//import com.bydan.erp.importaciones.util.PedidoCompraImporConstantesFunciones;
import com.bydan.erp.importaciones.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class PedidoCompraImpor extends PedidoCompraImporAdditional implements Serializable ,Cloneable {//PedidoCompraImporAdditional,GeneralEntity
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
	
	private PedidoCompraImpor pedidocompraimporOriginal;
	
	private Map<String, Object> mapPedidoCompraImpor;
			
	public Map<String, Object> getMapPedidoCompraImpor() {
		return mapPedidoCompraImpor;
	}

	public void setMapPedidoCompraImpor(Map<String, Object> mapPedidoCompraImpor) {
		this.mapPedidoCompraImpor = mapPedidoCompraImpor;
	}
	
	public void inicializarMapPedidoCompraImpor() {
		this.mapPedidoCompraImpor = new HashMap<String,Object>();
	}
	
	public void setMapPedidoCompraImporValue(String sKey,Object oValue) {
		this.mapPedidoCompraImpor.put(sKey, oValue);
	}
	
	public Object getMapPedidoCompraImporValue(String sKey) {
		return this.mapPedidoCompraImpor.get(sKey);
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
	private Long id_modulo;
	
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
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente_proveedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_usuario;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_cambio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_moneda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_prorrateo_impor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_embarcador;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_via_transporte;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_puerto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_puerto_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_terminos_impor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_pedido_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PedidoCompraImporConstantesFunciones.SREGEXFORMA_PAGO,message=PedidoCompraImporConstantesFunciones.SMENSAJEREGEXFORMA_PAGO)
	private String forma_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PedidoCompraImporConstantesFunciones.SREGEXNUMERO_DUI,message=PedidoCompraImporConstantesFunciones.SMENSAJEREGEXNUMERO_DUI)
	private String numero_dui;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PedidoCompraImporConstantesFunciones.SREGEXSECUENCIAL,message=PedidoCompraImporConstantesFunciones.SMENSAJEREGEXSECUENCIAL)
	private String secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_orden;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PedidoCompraImporConstantesFunciones.SREGEXUSO_EN,message=PedidoCompraImporConstantesFunciones.SMENSAJEREGEXUSO_EN)
	private String uso_en;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PedidoCompraImporConstantesFunciones.SREGEXRESPONSABLE,message=PedidoCompraImporConstantesFunciones.SMENSAJEREGEXRESPONSABLE)
	private String responsable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PedidoCompraImporConstantesFunciones.SREGEXORDEN_COMPRA,message=PedidoCompraImporConstantesFunciones.SMENSAJEREGEXORDEN_COMPRA)
	private String orden_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PedidoCompraImporConstantesFunciones.SREGEXLUGAR_ENTREGA,message=PedidoCompraImporConstantesFunciones.SMENSAJEREGEXLUGAR_ENTREGA)
	private String lugar_entrega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PedidoCompraImporConstantesFunciones.SREGEXDESCRIPCION,message=PedidoCompraImporConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_entrega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_entrega_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PedidoCompraImporConstantesFunciones.SREGEXNOMBRE_SEGURO,message=PedidoCompraImporConstantesFunciones.SMENSAJEREGEXNOMBRE_SEGURO)
	private String nombre_seguro;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PedidoCompraImporConstantesFunciones.SREGEXNOMBRE_CONSIGNATARIO,message=PedidoCompraImporConstantesFunciones.SMENSAJEREGEXNOMBRE_CONSIGNATARIO)
	private String nombre_consignatario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PedidoCompraImporConstantesFunciones.SREGEXPRECIOS,message=PedidoCompraImporConstantesFunciones.SMENSAJEREGEXPRECIOS)
	private String precios;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double flete;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double seguro;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double gastos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cfr;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cif;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Modulo modulo;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Pais pais;
	public Cliente cliente;
	public Cliente clienteproveedor;
	public Empleado empleado;
	public Usuario usuario;
	public TipoCambio tipocambio;
	public Moneda moneda;
	public TipoProrrateoImpor tipoprorrateoimpor;
	public Embarcador embarcador;
	public TipoViaTransporte tipoviatransporte;
	public Puerto puerto;
	public Puerto puertodestino;
	public TipoTerminosImpor tipoterminosimpor;
	public EstadoPedidoCompra estadopedidocompra;
	public Formato formato;
	public Anio anio;
	public Mes mes;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String modulo_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String pais_descripcion;
	private String cliente_descripcion;
	private String clienteproveedor_descripcion;
	private String empleado_descripcion;
	private String usuario_descripcion;
	private String tipocambio_descripcion;
	private String moneda_descripcion;
	private String tipoprorrateoimpor_descripcion;
	private String embarcador_descripcion;
	private String tipoviatransporte_descripcion;
	private String puerto_descripcion;
	private String puertodestino_descripcion;
	private String tipoterminosimpor_descripcion;
	private String estadopedidocompra_descripcion;
	private String formato_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	
	
	public List<DetallePedidoCompraImpor> detallepedidocompraimpors;
	public List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors;
		
	public PedidoCompraImpor () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.pedidocompraimporOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_modulo=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_pais=-1L;
 		this.id_cliente=-1L;
 		this.id_cliente_proveedor=-1L;
 		this.id_empleado=-1L;
 		this.id_usuario=-1L;
 		this.id_tipo_cambio=null;
 		this.id_moneda=-1L;
 		this.id_tipo_prorrateo_impor=-1L;
 		this.id_embarcador=-1L;
 		this.id_tipo_via_transporte=-1L;
 		this.id_puerto=-1L;
 		this.id_puerto_destino=-1L;
 		this.id_tipo_terminos_impor=-1L;
 		this.id_estado_pedido_compra=-1L;
 		this.forma_pago="";
 		this.numero_dui="";
 		this.secuencial="";
 		this.numero_orden=0;
 		this.uso_en="";
 		this.responsable="";
 		this.orden_compra="";
 		this.lugar_entrega="";
 		this.descripcion="";
 		this.fecha=new Date();
 		this.fecha_emision=new Date();
 		this.fecha_entrega=new Date();
 		this.fecha_entrega_cliente=new Date();
 		this.nombre_seguro="";
 		this.nombre_consignatario="";
 		this.precios="";
 		this.flete=0.0;
 		this.seguro=0.0;
 		this.gastos=0.0;
 		this.cfr=0.0;
 		this.cif=0.0;
 		this.total=0.0;
 		this.id_formato=-1L;
 		this.id_anio=null;
 		this.id_mes=null;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.modulo=null;
		this.ejercicio=null;
		this.periodo=null;
		this.pais=null;
		this.cliente=null;
		this.clienteproveedor=null;
		this.empleado=null;
		this.usuario=null;
		this.tipocambio=null;
		this.moneda=null;
		this.tipoprorrateoimpor=null;
		this.embarcador=null;
		this.tipoviatransporte=null;
		this.puerto=null;
		this.puertodestino=null;
		this.tipoterminosimpor=null;
		this.estadopedidocompra=null;
		this.formato=null;
		this.anio=null;
		this.mes=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.modulo_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.pais_descripcion="";
		this.cliente_descripcion="";
		this.clienteproveedor_descripcion="";
		this.empleado_descripcion="";
		this.usuario_descripcion="";
		this.tipocambio_descripcion="";
		this.moneda_descripcion="";
		this.tipoprorrateoimpor_descripcion="";
		this.embarcador_descripcion="";
		this.tipoviatransporte_descripcion="";
		this.puerto_descripcion="";
		this.puertodestino_descripcion="";
		this.tipoterminosimpor_descripcion="";
		this.estadopedidocompra_descripcion="";
		this.formato_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		
		
		this.detallepedidocompraimpors=null;
		this.liquidacionimpuestoimpors=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PedidoCompraImpor (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_modulo,Long id_ejercicio,Long id_periodo,Long id_pais,Long id_cliente,Long id_cliente_proveedor,Long id_empleado,Long id_usuario,Long id_tipo_cambio,Long id_moneda,Long id_tipo_prorrateo_impor,Long id_embarcador,Long id_tipo_via_transporte,Long id_puerto,Long id_puerto_destino,Long id_tipo_terminos_impor,Long id_estado_pedido_compra,String forma_pago,String numero_dui,String secuencial,Integer numero_orden,String uso_en,String responsable,String orden_compra,String lugar_entrega,String descripcion,Date fecha,Date fecha_emision,Date fecha_entrega,Date fecha_entrega_cliente,String nombre_seguro,String nombre_consignatario,String precios,Double flete,Double seguro,Double gastos,Double cfr,Double cif,Double total,Long id_formato,Long id_anio,Long id_mes) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.pedidocompraimporOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_modulo=id_modulo;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_pais=id_pais;
 		this.id_cliente=id_cliente;
 		this.id_cliente_proveedor=id_cliente_proveedor;
 		this.id_empleado=id_empleado;
 		this.id_usuario=id_usuario;
 		this.id_tipo_cambio=id_tipo_cambio;
 		this.id_moneda=id_moneda;
 		this.id_tipo_prorrateo_impor=id_tipo_prorrateo_impor;
 		this.id_embarcador=id_embarcador;
 		this.id_tipo_via_transporte=id_tipo_via_transporte;
 		this.id_puerto=id_puerto;
 		this.id_puerto_destino=id_puerto_destino;
 		this.id_tipo_terminos_impor=id_tipo_terminos_impor;
 		this.id_estado_pedido_compra=id_estado_pedido_compra;
 		this.forma_pago=forma_pago;
 		this.numero_dui=numero_dui;
 		this.secuencial=secuencial;
 		this.numero_orden=numero_orden;
 		this.uso_en=uso_en;
 		this.responsable=responsable;
 		this.orden_compra=orden_compra;
 		this.lugar_entrega=lugar_entrega;
 		this.descripcion=descripcion;
 		this.fecha=fecha;
 		this.fecha_emision=fecha_emision;
 		this.fecha_entrega=fecha_entrega;
 		this.fecha_entrega_cliente=fecha_entrega_cliente;
 		this.nombre_seguro=nombre_seguro;
 		this.nombre_consignatario=nombre_consignatario;
 		this.precios=precios;
 		this.flete=flete;
 		this.seguro=seguro;
 		this.gastos=gastos;
 		this.cfr=cfr;
 		this.cif=cif;
 		this.total=total;
 		this.id_formato=id_formato;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PedidoCompraImpor (Long id_empresa,Long id_sucursal,Long id_modulo,Long id_ejercicio,Long id_periodo,Long id_pais,Long id_cliente,Long id_cliente_proveedor,Long id_empleado,Long id_usuario,Long id_tipo_cambio,Long id_moneda,Long id_tipo_prorrateo_impor,Long id_embarcador,Long id_tipo_via_transporte,Long id_puerto,Long id_puerto_destino,Long id_tipo_terminos_impor,Long id_estado_pedido_compra,String forma_pago,String numero_dui,String secuencial,Integer numero_orden,String uso_en,String responsable,String orden_compra,String lugar_entrega,String descripcion,Date fecha,Date fecha_emision,Date fecha_entrega,Date fecha_entrega_cliente,String nombre_seguro,String nombre_consignatario,String precios,Double flete,Double seguro,Double gastos,Double cfr,Double cif,Double total,Long id_formato,Long id_anio,Long id_mes) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.pedidocompraimporOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_modulo=id_modulo;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_pais=id_pais;
 		this.id_cliente=id_cliente;
 		this.id_cliente_proveedor=id_cliente_proveedor;
 		this.id_empleado=id_empleado;
 		this.id_usuario=id_usuario;
 		this.id_tipo_cambio=id_tipo_cambio;
 		this.id_moneda=id_moneda;
 		this.id_tipo_prorrateo_impor=id_tipo_prorrateo_impor;
 		this.id_embarcador=id_embarcador;
 		this.id_tipo_via_transporte=id_tipo_via_transporte;
 		this.id_puerto=id_puerto;
 		this.id_puerto_destino=id_puerto_destino;
 		this.id_tipo_terminos_impor=id_tipo_terminos_impor;
 		this.id_estado_pedido_compra=id_estado_pedido_compra;
 		this.forma_pago=forma_pago;
 		this.numero_dui=numero_dui;
 		this.secuencial=secuencial;
 		this.numero_orden=numero_orden;
 		this.uso_en=uso_en;
 		this.responsable=responsable;
 		this.orden_compra=orden_compra;
 		this.lugar_entrega=lugar_entrega;
 		this.descripcion=descripcion;
 		this.fecha=fecha;
 		this.fecha_emision=fecha_emision;
 		this.fecha_entrega=fecha_entrega;
 		this.fecha_entrega_cliente=fecha_entrega_cliente;
 		this.nombre_seguro=nombre_seguro;
 		this.nombre_consignatario=nombre_consignatario;
 		this.precios=precios;
 		this.flete=flete;
 		this.seguro=seguro;
 		this.gastos=gastos;
 		this.cfr=cfr;
 		this.cif=cif;
 		this.total=total;
 		this.id_formato=id_formato;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		PedidoCompraImpor pedidocompraimporLocal=null;
		
		if(object!=null) {
			pedidocompraimporLocal=(PedidoCompraImpor)object;
			
			if(pedidocompraimporLocal!=null) {
				if(this.getId()!=null && pedidocompraimporLocal.getId()!=null) {
					if(this.getId().equals(pedidocompraimporLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PedidoCompraImporConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PedidoCompraImporConstantesFunciones.getPedidoCompraImporDescripcion(this);
		} else {
			sDetalle=PedidoCompraImporConstantesFunciones.getPedidoCompraImporDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public PedidoCompraImpor getPedidoCompraImporOriginal() {
		return this.pedidocompraimporOriginal;
	}
	
	public void setPedidoCompraImporOriginal(PedidoCompraImpor pedidocompraimpor) {
		try {
			this.pedidocompraimporOriginal=pedidocompraimpor;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PedidoCompraImporAdditional pedidocompraimporAdditional=null;
	
	public PedidoCompraImporAdditional getPedidoCompraImporAdditional() {
		return this.pedidocompraimporAdditional;
	}
	
	public void setPedidoCompraImporAdditional(PedidoCompraImporAdditional pedidocompraimporAdditional) {
		try {
			this.pedidocompraimporAdditional=pedidocompraimporAdditional;
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
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_cliente_proveedor() {
		return this.id_cliente_proveedor;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_usuario() {
		return this.id_usuario;
	}
    
	
	public Long getid_tipo_cambio() {
		return this.id_tipo_cambio;
	}
    
	
	public Long getid_moneda() {
		return this.id_moneda;
	}
    
	
	public Long getid_tipo_prorrateo_impor() {
		return this.id_tipo_prorrateo_impor;
	}
    
	
	public Long getid_embarcador() {
		return this.id_embarcador;
	}
    
	
	public Long getid_tipo_via_transporte() {
		return this.id_tipo_via_transporte;
	}
    
	
	public Long getid_puerto() {
		return this.id_puerto;
	}
    
	
	public Long getid_puerto_destino() {
		return this.id_puerto_destino;
	}
    
	
	public Long getid_tipo_terminos_impor() {
		return this.id_tipo_terminos_impor;
	}
    
	
	public Long getid_estado_pedido_compra() {
		return this.id_estado_pedido_compra;
	}
    
	
	public String getforma_pago() {
		return this.forma_pago;
	}
    
	
	public String getnumero_dui() {
		return this.numero_dui;
	}
    
	
	public String getsecuencial() {
		return this.secuencial;
	}
    
	
	public Integer getnumero_orden() {
		return this.numero_orden;
	}
    
	
	public String getuso_en() {
		return this.uso_en;
	}
    
	
	public String getresponsable() {
		return this.responsable;
	}
    
	
	public String getorden_compra() {
		return this.orden_compra;
	}
    
	
	public String getlugar_entrega() {
		return this.lugar_entrega;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Date getfecha_entrega() {
		return this.fecha_entrega;
	}
    
	
	public Date getfecha_entrega_cliente() {
		return this.fecha_entrega_cliente;
	}
    
	
	public String getnombre_seguro() {
		return this.nombre_seguro;
	}
    
	
	public String getnombre_consignatario() {
		return this.nombre_consignatario;
	}
    
	
	public String getprecios() {
		return this.precios;
	}
    
	
	public Double getflete() {
		return this.flete;
	}
    
	
	public Double getseguro() {
		return this.seguro;
	}
    
	
	public Double getgastos() {
		return this.gastos;
	}
    
	
	public Double getcfr() {
		return this.cfr;
	}
    
	
	public Double getcif() {
		return this.cif;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
    
	
	public Long getid_formato() {
		return this.id_formato;
	}
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
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
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
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
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente(Long newid_cliente)throws Exception
	{
		try {
			if(this.id_cliente!=newid_cliente) {
				if(newid_cliente==null) {
					//newid_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente_proveedor(Long newid_cliente_proveedor)throws Exception
	{
		try {
			if(this.id_cliente_proveedor!=newid_cliente_proveedor) {
				if(newid_cliente_proveedor==null) {
					//newid_cliente_proveedor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna id_cliente_proveedor");
					}
				}

				this.id_cliente_proveedor=newid_cliente_proveedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empleado(Long newid_empleado)throws Exception
	{
		try {
			if(this.id_empleado!=newid_empleado) {
				if(newid_empleado==null) {
					//newid_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_usuario(Long newid_usuario)throws Exception
	{
		try {
			if(this.id_usuario!=newid_usuario) {
				if(newid_usuario==null) {
					//newid_usuario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_cambio(Long newid_tipo_cambio) {
		if(this.id_tipo_cambio==null&&newid_tipo_cambio!=null) {
			this.id_tipo_cambio=newid_tipo_cambio;
				this.setIsChanged(true);
		}

		if(this.id_tipo_cambio!=null&&!this.id_tipo_cambio.equals(newid_tipo_cambio)) {

			this.id_tipo_cambio=newid_tipo_cambio;
				this.setIsChanged(true);
		}
	}
    
	public void setid_moneda(Long newid_moneda)throws Exception
	{
		try {
			if(this.id_moneda!=newid_moneda) {
				if(newid_moneda==null) {
					//newid_moneda=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna id_moneda");
					}
				}

				this.id_moneda=newid_moneda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_prorrateo_impor(Long newid_tipo_prorrateo_impor)throws Exception
	{
		try {
			if(this.id_tipo_prorrateo_impor!=newid_tipo_prorrateo_impor) {
				if(newid_tipo_prorrateo_impor==null) {
					//newid_tipo_prorrateo_impor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna id_tipo_prorrateo_impor");
					}
				}

				this.id_tipo_prorrateo_impor=newid_tipo_prorrateo_impor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_embarcador(Long newid_embarcador)throws Exception
	{
		try {
			if(this.id_embarcador!=newid_embarcador) {
				if(newid_embarcador==null) {
					//newid_embarcador=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna id_embarcador");
					}
				}

				this.id_embarcador=newid_embarcador;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_via_transporte(Long newid_tipo_via_transporte)throws Exception
	{
		try {
			if(this.id_tipo_via_transporte!=newid_tipo_via_transporte) {
				if(newid_tipo_via_transporte==null) {
					//newid_tipo_via_transporte=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna id_tipo_via_transporte");
					}
				}

				this.id_tipo_via_transporte=newid_tipo_via_transporte;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_puerto(Long newid_puerto)throws Exception
	{
		try {
			if(this.id_puerto!=newid_puerto) {
				if(newid_puerto==null) {
					//newid_puerto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna id_puerto");
					}
				}

				this.id_puerto=newid_puerto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_puerto_destino(Long newid_puerto_destino)throws Exception
	{
		try {
			if(this.id_puerto_destino!=newid_puerto_destino) {
				if(newid_puerto_destino==null) {
					//newid_puerto_destino=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna id_puerto_destino");
					}
				}

				this.id_puerto_destino=newid_puerto_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_terminos_impor(Long newid_tipo_terminos_impor)throws Exception
	{
		try {
			if(this.id_tipo_terminos_impor!=newid_tipo_terminos_impor) {
				if(newid_tipo_terminos_impor==null) {
					//newid_tipo_terminos_impor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna id_tipo_terminos_impor");
					}
				}

				this.id_tipo_terminos_impor=newid_tipo_terminos_impor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_pedido_compra(Long newid_estado_pedido_compra)throws Exception
	{
		try {
			if(this.id_estado_pedido_compra!=newid_estado_pedido_compra) {
				if(newid_estado_pedido_compra==null) {
					//newid_estado_pedido_compra=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna id_estado_pedido_compra");
					}
				}

				this.id_estado_pedido_compra=newid_estado_pedido_compra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setforma_pago(String newforma_pago)throws Exception
	{
		try {
			if(this.forma_pago!=newforma_pago) {
				if(newforma_pago==null) {
					//newforma_pago="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna forma_pago");
					}
				}

				if(newforma_pago!=null&&newforma_pago.length()>50) {
					newforma_pago=newforma_pago.substring(0,48);
					System.out.println("PedidoCompraImpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna forma_pago");
				}

				this.forma_pago=newforma_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_dui(String newnumero_dui)throws Exception
	{
		try {
			if(this.numero_dui!=newnumero_dui) {
				if(newnumero_dui==null) {
					//newnumero_dui="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna numero_dui");
					}
				}

				if(newnumero_dui!=null&&newnumero_dui.length()>50) {
					newnumero_dui=newnumero_dui.substring(0,48);
					System.out.println("PedidoCompraImpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_dui");
				}

				this.numero_dui=newnumero_dui;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial(String newsecuencial)throws Exception
	{
		try {
			if(this.secuencial!=newsecuencial) {
				if(newsecuencial==null) {
					//newsecuencial="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna secuencial");
					}
				}

				if(newsecuencial!=null&&newsecuencial.length()>50) {
					newsecuencial=newsecuencial.substring(0,48);
					System.out.println("PedidoCompraImpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencial");
				}

				this.secuencial=newsecuencial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_orden(Integer newnumero_orden)throws Exception
	{
		try {
			if(this.numero_orden!=newnumero_orden) {
				if(newnumero_orden==null) {
					//newnumero_orden=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna numero_orden");
					}
				}

				this.numero_orden=newnumero_orden;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setuso_en(String newuso_en)throws Exception
	{
		try {
			if(this.uso_en!=newuso_en) {
				if(newuso_en==null) {
					//newuso_en="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna uso_en");
					}
				}

				if(newuso_en!=null&&newuso_en.length()>50) {
					newuso_en=newuso_en.substring(0,48);
					System.out.println("PedidoCompraImpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna uso_en");
				}

				this.uso_en=newuso_en;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setresponsable(String newresponsable)throws Exception
	{
		try {
			if(this.responsable!=newresponsable) {
				if(newresponsable==null) {
					//newresponsable="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna responsable");
					}
				}

				if(newresponsable!=null&&newresponsable.length()>150) {
					newresponsable=newresponsable.substring(0,148);
					System.out.println("PedidoCompraImpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna responsable");
				}

				this.responsable=newresponsable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setorden_compra(String neworden_compra)throws Exception
	{
		try {
			if(this.orden_compra!=neworden_compra) {
				if(neworden_compra==null) {
					//neworden_compra="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna orden_compra");
					}
				}

				if(neworden_compra!=null&&neworden_compra.length()>50) {
					neworden_compra=neworden_compra.substring(0,48);
					System.out.println("PedidoCompraImpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna orden_compra");
				}

				this.orden_compra=neworden_compra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setlugar_entrega(String newlugar_entrega)throws Exception
	{
		try {
			if(this.lugar_entrega!=newlugar_entrega) {
				if(newlugar_entrega==null) {
					//newlugar_entrega="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna lugar_entrega");
					}
				}

				if(newlugar_entrega!=null&&newlugar_entrega.length()>50) {
					newlugar_entrega=newlugar_entrega.substring(0,48);
					System.out.println("PedidoCompraImpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna lugar_entrega");
				}

				this.lugar_entrega=newlugar_entrega;
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
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("PedidoCompraImpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
				}

				this.descripcion=newdescripcion;
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
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision(Date newfecha_emision)throws Exception
	{
		try {
			if(this.fecha_emision!=newfecha_emision) {
				if(newfecha_emision==null) {
					//newfecha_emision=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_entrega(Date newfecha_entrega)throws Exception
	{
		try {
			if(this.fecha_entrega!=newfecha_entrega) {
				if(newfecha_entrega==null) {
					//newfecha_entrega=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna fecha_entrega");
					}
				}

				this.fecha_entrega=newfecha_entrega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_entrega_cliente(Date newfecha_entrega_cliente)throws Exception
	{
		try {
			if(this.fecha_entrega_cliente!=newfecha_entrega_cliente) {
				if(newfecha_entrega_cliente==null) {
					//newfecha_entrega_cliente=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna fecha_entrega_cliente");
					}
				}

				this.fecha_entrega_cliente=newfecha_entrega_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_seguro(String newnombre_seguro)throws Exception
	{
		try {
			if(this.nombre_seguro!=newnombre_seguro) {
				if(newnombre_seguro==null) {
					//newnombre_seguro="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna nombre_seguro");
					}
				}

				if(newnombre_seguro!=null&&newnombre_seguro.length()>50) {
					newnombre_seguro=newnombre_seguro.substring(0,48);
					System.out.println("PedidoCompraImpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_seguro");
				}

				this.nombre_seguro=newnombre_seguro;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_consignatario(String newnombre_consignatario)throws Exception
	{
		try {
			if(this.nombre_consignatario!=newnombre_consignatario) {
				if(newnombre_consignatario==null) {
					//newnombre_consignatario="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna nombre_consignatario");
					}
				}

				if(newnombre_consignatario!=null&&newnombre_consignatario.length()>50) {
					newnombre_consignatario=newnombre_consignatario.substring(0,48);
					System.out.println("PedidoCompraImpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_consignatario");
				}

				this.nombre_consignatario=newnombre_consignatario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprecios(String newprecios)throws Exception
	{
		try {
			if(this.precios!=newprecios) {
				if(newprecios==null) {
					//newprecios="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna precios");
					}
				}

				if(newprecios!=null&&newprecios.length()>50) {
					newprecios=newprecios.substring(0,48);
					System.out.println("PedidoCompraImpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna precios");
				}

				this.precios=newprecios;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setflete(Double newflete)throws Exception
	{
		try {
			if(this.flete!=newflete) {
				if(newflete==null) {
					//newflete=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna flete");
					}
				}

				this.flete=newflete;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setseguro(Double newseguro)throws Exception
	{
		try {
			if(this.seguro!=newseguro) {
				if(newseguro==null) {
					//newseguro=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna seguro");
					}
				}

				this.seguro=newseguro;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgastos(Double newgastos)throws Exception
	{
		try {
			if(this.gastos!=newgastos) {
				if(newgastos==null) {
					//newgastos=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna gastos");
					}
				}

				this.gastos=newgastos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcfr(Double newcfr)throws Exception
	{
		try {
			if(this.cfr!=newcfr) {
				if(newcfr==null) {
					//newcfr=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna cfr");
					}
				}

				this.cfr=newcfr;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcif(Double newcif)throws Exception
	{
		try {
			if(this.cif!=newcif) {
				if(newcif==null) {
					//newcif=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna cif");
					}
				}

				this.cif=newcif;
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
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
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
						System.out.println("PedidoCompraImpor:Valor nulo no permitido en columna id_formato");
					}
				}

				this.id_formato=newid_formato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
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
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public Pais getPais() {
		return this.pais;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Cliente getClienteProveedor() {
		return this.clienteproveedor;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public TipoCambio getTipoCambio() {
		return this.tipocambio;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	public TipoProrrateoImpor getTipoProrrateoImpor() {
		return this.tipoprorrateoimpor;
	}

	public Embarcador getEmbarcador() {
		return this.embarcador;
	}

	public TipoViaTransporte getTipoViaTransporte() {
		return this.tipoviatransporte;
	}

	public Puerto getPuerto() {
		return this.puerto;
	}

	public Puerto getPuertoDestino() {
		return this.puertodestino;
	}

	public TipoTerminosImpor getTipoTerminosImpor() {
		return this.tipoterminosimpor;
	}

	public EstadoPedidoCompra getEstadoPedidoCompra() {
		return this.estadopedidocompra;
	}

	public Formato getFormato() {
		return this.formato;
	}

	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String getclienteproveedor_descripcion() {
		return this.clienteproveedor_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getusuario_descripcion() {
		return this.usuario_descripcion;
	}

	public String gettipocambio_descripcion() {
		return this.tipocambio_descripcion;
	}

	public String getmoneda_descripcion() {
		return this.moneda_descripcion;
	}

	public String gettipoprorrateoimpor_descripcion() {
		return this.tipoprorrateoimpor_descripcion;
	}

	public String getembarcador_descripcion() {
		return this.embarcador_descripcion;
	}

	public String gettipoviatransporte_descripcion() {
		return this.tipoviatransporte_descripcion;
	}

	public String getpuerto_descripcion() {
		return this.puerto_descripcion;
	}

	public String getpuertodestino_descripcion() {
		return this.puertodestino_descripcion;
	}

	public String gettipoterminosimpor_descripcion() {
		return this.tipoterminosimpor_descripcion;
	}

	public String getestadopedidocompra_descripcion() {
		return this.estadopedidocompra_descripcion;
	}

	public String getformato_descripcion() {
		return this.formato_descripcion;
	}

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
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


	public  void  setModulo(Modulo modulo) {
		try {
			this.modulo=modulo;
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


	public  void  setPais(Pais pais) {
		try {
			this.pais=pais;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setClienteProveedor(Cliente clienteproveedor) {
		try {
			this.clienteproveedor=clienteproveedor;
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


	public  void  setUsuario(Usuario usuario) {
		try {
			this.usuario=usuario;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoCambio(TipoCambio tipocambio) {
		try {
			this.tipocambio=tipocambio;
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


	public  void  setTipoProrrateoImpor(TipoProrrateoImpor tipoprorrateoimpor) {
		try {
			this.tipoprorrateoimpor=tipoprorrateoimpor;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmbarcador(Embarcador embarcador) {
		try {
			this.embarcador=embarcador;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoViaTransporte(TipoViaTransporte tipoviatransporte) {
		try {
			this.tipoviatransporte=tipoviatransporte;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPuerto(Puerto puerto) {
		try {
			this.puerto=puerto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPuertoDestino(Puerto puertodestino) {
		try {
			this.puertodestino=puertodestino;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoTerminosImpor(TipoTerminosImpor tipoterminosimpor) {
		try {
			this.tipoterminosimpor=tipoterminosimpor;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoPedidoCompra(EstadoPedidoCompra estadopedidocompra) {
		try {
			this.estadopedidocompra=estadopedidocompra;
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


	public  void  setmodulo_descripcion(String modulo_descripcion) {
		try {
			this.modulo_descripcion=modulo_descripcion;
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


	public  void  setpais_descripcion(String pais_descripcion) {
		try {
			this.pais_descripcion=pais_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setclienteproveedor_descripcion(String clienteproveedor_descripcion) {
		try {
			this.clienteproveedor_descripcion=clienteproveedor_descripcion;
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


	public  void  setusuario_descripcion(String usuario_descripcion) {
		try {
			this.usuario_descripcion=usuario_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipocambio_descripcion(String tipocambio_descripcion) {
		try {
			this.tipocambio_descripcion=tipocambio_descripcion;
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


	public  void  settipoprorrateoimpor_descripcion(String tipoprorrateoimpor_descripcion) {
		try {
			this.tipoprorrateoimpor_descripcion=tipoprorrateoimpor_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setembarcador_descripcion(String embarcador_descripcion) {
		try {
			this.embarcador_descripcion=embarcador_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoviatransporte_descripcion(String tipoviatransporte_descripcion) {
		try {
			this.tipoviatransporte_descripcion=tipoviatransporte_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setpuerto_descripcion(String puerto_descripcion) {
		try {
			this.puerto_descripcion=puerto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setpuertodestino_descripcion(String puertodestino_descripcion) {
		try {
			this.puertodestino_descripcion=puertodestino_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoterminosimpor_descripcion(String tipoterminosimpor_descripcion) {
		try {
			this.tipoterminosimpor_descripcion=tipoterminosimpor_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadopedidocompra_descripcion(String estadopedidocompra_descripcion) {
		try {
			this.estadopedidocompra_descripcion=estadopedidocompra_descripcion;
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


	
	
	public List<DetallePedidoCompraImpor> getDetallePedidoCompraImpors() {
		return this.detallepedidocompraimpors;
	}

	public List<LiquidacionImpuestoImpor> getLiquidacionImpuestoImpors() {
		return this.liquidacionimpuestoimpors;
	}

	
	
	public  void  setDetallePedidoCompraImpors(List<DetallePedidoCompraImpor> detallepedidocompraimpors) {
		try {
			this.detallepedidocompraimpors=detallepedidocompraimpors;
		} catch(Exception e) {
			;
		}
	}

	public  void  setLiquidacionImpuestoImpors(List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors) {
		try {
			this.liquidacionimpuestoimpors=liquidacionimpuestoimpors;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_modulo_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_pais_descripcion="";String id_cliente_descripcion="";String id_cliente_proveedor_descripcion="";String id_empleado_descripcion="";String id_usuario_descripcion="";String id_tipo_cambio_descripcion="";String id_moneda_descripcion="";String id_tipo_prorrateo_impor_descripcion="";String id_embarcador_descripcion="";String id_tipo_via_transporte_descripcion="";String id_puerto_descripcion="";String id_puerto_destino_descripcion="";String id_tipo_terminos_impor_descripcion="";String id_estado_pedido_compra_descripcion="";String id_formato_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_cliente_proveedor_descripcion() {
		return id_cliente_proveedor_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_usuario_descripcion() {
		return id_usuario_descripcion;
	}
	public String getid_tipo_cambio_descripcion() {
		return id_tipo_cambio_descripcion;
	}
	public String getid_moneda_descripcion() {
		return id_moneda_descripcion;
	}
	public String getid_tipo_prorrateo_impor_descripcion() {
		return id_tipo_prorrateo_impor_descripcion;
	}
	public String getid_embarcador_descripcion() {
		return id_embarcador_descripcion;
	}
	public String getid_tipo_via_transporte_descripcion() {
		return id_tipo_via_transporte_descripcion;
	}
	public String getid_puerto_descripcion() {
		return id_puerto_descripcion;
	}
	public String getid_puerto_destino_descripcion() {
		return id_puerto_destino_descripcion;
	}
	public String getid_tipo_terminos_impor_descripcion() {
		return id_tipo_terminos_impor_descripcion;
	}
	public String getid_estado_pedido_compra_descripcion() {
		return id_estado_pedido_compra_descripcion;
	}
	public String getid_formato_descripcion() {
		return id_formato_descripcion;
	}
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
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
	public void setid_modulo_descripcion(String newid_modulo_descripcion)throws Exception {
		try {
			this.id_modulo_descripcion=newid_modulo_descripcion;
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
	public void setid_pais_descripcion(String newid_pais_descripcion)throws Exception {
		try {
			this.id_pais_descripcion=newid_pais_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cliente_proveedor_descripcion(String newid_cliente_proveedor_descripcion)throws Exception {
		try {
			this.id_cliente_proveedor_descripcion=newid_cliente_proveedor_descripcion;
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
	public void setid_usuario_descripcion(String newid_usuario_descripcion)throws Exception {
		try {
			this.id_usuario_descripcion=newid_usuario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_cambio_descripcion(String newid_tipo_cambio_descripcion)throws Exception {
		try {
			this.id_tipo_cambio_descripcion=newid_tipo_cambio_descripcion;
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
	public void setid_tipo_prorrateo_impor_descripcion(String newid_tipo_prorrateo_impor_descripcion)throws Exception {
		try {
			this.id_tipo_prorrateo_impor_descripcion=newid_tipo_prorrateo_impor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_embarcador_descripcion(String newid_embarcador_descripcion)throws Exception {
		try {
			this.id_embarcador_descripcion=newid_embarcador_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_via_transporte_descripcion(String newid_tipo_via_transporte_descripcion)throws Exception {
		try {
			this.id_tipo_via_transporte_descripcion=newid_tipo_via_transporte_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_puerto_descripcion(String newid_puerto_descripcion)throws Exception {
		try {
			this.id_puerto_descripcion=newid_puerto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_puerto_destino_descripcion(String newid_puerto_destino_descripcion)throws Exception {
		try {
			this.id_puerto_destino_descripcion=newid_puerto_destino_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_terminos_impor_descripcion(String newid_tipo_terminos_impor_descripcion)throws Exception {
		try {
			this.id_tipo_terminos_impor_descripcion=newid_tipo_terminos_impor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_pedido_compra_descripcion(String newid_estado_pedido_compra_descripcion)throws Exception {
		try {
			this.id_estado_pedido_compra_descripcion=newid_estado_pedido_compra_descripcion;
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
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_modulo_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_pais_descripcion="";this.id_cliente_descripcion="";this.id_cliente_proveedor_descripcion="";this.id_empleado_descripcion="";this.id_usuario_descripcion="";this.id_tipo_cambio_descripcion="";this.id_moneda_descripcion="";this.id_tipo_prorrateo_impor_descripcion="";this.id_embarcador_descripcion="";this.id_tipo_via_transporte_descripcion="";this.id_puerto_descripcion="";this.id_puerto_destino_descripcion="";this.id_tipo_terminos_impor_descripcion="";this.id_estado_pedido_compra_descripcion="";this.id_formato_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";
	}
	
	
	Object detallepedidocompraimporsDescripcionReporte;
	Object liquidacionimpuestoimporsDescripcionReporte;
	
	
	public Object getdetallepedidocompraimporsDescripcionReporte() {
		return detallepedidocompraimporsDescripcionReporte;
	}

	public Object getliquidacionimpuestoimporsDescripcionReporte() {
		return liquidacionimpuestoimporsDescripcionReporte;
	}

	
	
	public  void  setdetallepedidocompraimporsDescripcionReporte(Object detallepedidocompraimpors) {
		try {
			this.detallepedidocompraimporsDescripcionReporte=detallepedidocompraimpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setliquidacionimpuestoimporsDescripcionReporte(Object liquidacionimpuestoimpors) {
		try {
			this.liquidacionimpuestoimporsDescripcionReporte=liquidacionimpuestoimpors;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

