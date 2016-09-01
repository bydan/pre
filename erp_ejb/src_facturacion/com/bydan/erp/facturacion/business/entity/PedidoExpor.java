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


import java.sql.Time;

import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesValidacion;
//import com.bydan.erp.facturacion.util.PedidoExporConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;




@SuppressWarnings("unused")
public class PedidoExpor extends PedidoExporAdditional implements Serializable ,Cloneable {//PedidoExporAdditional,GeneralEntity
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
	
	private PedidoExpor pedidoexporOriginal;
	
	private Map<String, Object> mapPedidoExpor;
			
	public Map<String, Object> getMapPedidoExpor() {
		return mapPedidoExpor;
	}

	public void setMapPedidoExpor(Map<String, Object> mapPedidoExpor) {
		this.mapPedidoExpor = mapPedidoExpor;
	}
	
	public void inicializarMapPedidoExpor() {
		this.mapPedidoExpor = new HashMap<String,Object>();
	}
	
	public void setMapPedidoExporValue(String sKey,Object oValue) {
		this.mapPedidoExpor.put(sKey, oValue);
	}
	
	public Object getMapPedidoExporValue(String sKey) {
		return this.mapPedidoExpor.get(sKey);
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
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PedidoExporConstantesFunciones.SREGEXNUMERO,message=PedidoExporConstantesFunciones.SMENSAJEREGEXNUMERO)
	private String numero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=PedidoExporConstantesFunciones.SREGEXNUMERO_PREIMPRESO,message=PedidoExporConstantesFunciones.SMENSAJEREGEXNUMERO_PREIMPRESO)
	private String numero_preimpreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vencimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_moneda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cotizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_precio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=PedidoExporConstantesFunciones.SREGEXDIRECCION,message=PedidoExporConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=PedidoExporConstantesFunciones.SREGEXTELEFONO,message=PedidoExporConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=PedidoExporConstantesFunciones.SREGEXRUC,message=PedidoExporConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=PedidoExporConstantesFunciones.SREGEXLUGAR_ENTREGA,message=PedidoExporConstantesFunciones.SMENSAJEREGEXLUGAR_ENTREGA)
	private String lugar_entrega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=PedidoExporConstantesFunciones.SREGEXEMBARQUE,message=PedidoExporConstantesFunciones.SMENSAJEREGEXEMBARQUE)
	private String embarque;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=PedidoExporConstantesFunciones.SREGEXNEGOCIACION,message=PedidoExporConstantesFunciones.SMENSAJEREGEXNEGOCIACION)
	private String negociacion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transporte;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_vendedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=PedidoExporConstantesFunciones.SREGEXFORMA_PAGO,message=PedidoExporConstantesFunciones.SMENSAJEREGEXFORMA_PAGO)
	private String forma_pago;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_sub_cliente;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_consignatario;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_consultor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=PedidoExporConstantesFunciones.SREGEXORDEN,message=PedidoExporConstantesFunciones.SMENSAJEREGEXORDEN)
	private String orden;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_pedido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=PedidoExporConstantesFunciones.SREGEXDESCRIPCION,message=PedidoExporConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double saldo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double disponible;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento_porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_con_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double suman;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento_valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_sin_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double flete;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double subtotal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double seguros;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double financiamiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double otro;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_servidor;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_cambio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PedidoExporConstantesFunciones.SREGEXNUMERO_FUE,message=PedidoExporConstantesFunciones.SMENSAJEREGEXNUMERO_FUE)
	private String numero_fue;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_responsable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transportista;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Anio anio;
	public Mes mes;
	public Usuario usuario;
	public Moneda moneda;
	public Empleado empleado;
	public TipoPrecio tipoprecio;
	public Formato formato;
	public Cliente cliente;
	public Pais pais;
	public Transporte transporte;
	public Vendedor vendedor;
	public SubCliente subcliente;
	public Consignatario consignatario;
	public Consultor consultor;
	public EstadoPedido estadopedidoexpor;
	public TipoCambio tipocambio;
	public CentroCosto centrocosto;
	public Responsable responsable;
	public Transportista transportista;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	private String usuario_descripcion;
	private String moneda_descripcion;
	private String empleado_descripcion;
	private String tipoprecio_descripcion;
	private String formato_descripcion;
	private String cliente_descripcion;
	private String pais_descripcion;
	private String transporte_descripcion;
	private String vendedor_descripcion;
	private String subcliente_descripcion;
	private String consignatario_descripcion;
	private String consultor_descripcion;
	private String estadopedidoexpor_descripcion;
	private String tipocambio_descripcion;
	private String centrocosto_descripcion;
	private String responsable_descripcion;
	private String transportista_descripcion;
	
	
	public List<DetallePedidoExpor> detallepedidoexpors;
		
	public PedidoExpor () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.pedidoexporOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_anio=null;
 		this.id_mes=null;
 		this.id_usuario=-1L;
 		this.numero="";
 		this.numero_preimpreso="";
 		this.fecha_emision=new Date();
 		this.fecha_vencimiento=new Date();
 		this.id_moneda=-1L;
 		this.cotizacion=0.0;
 		this.id_empleado=-1L;
 		this.id_tipo_precio=-1L;
 		this.id_formato=null;
 		this.direccion="";
 		this.id_cliente=-1L;
 		this.telefono="";
 		this.ruc="";
 		this.id_pais=null;
 		this.lugar_entrega="";
 		this.embarque="";
 		this.negociacion="";
 		this.id_transporte=null;
 		this.id_vendedor=null;
 		this.forma_pago="";
 		this.id_sub_cliente=null;
 		this.id_consignatario=null;
 		this.id_consultor=null;
 		this.orden="";
 		this.id_estado_pedido=1L;
 		this.descripcion="";
 		this.monto=0.0;
 		this.saldo=0.0;
 		this.disponible=0.0;
 		this.descuento_porcentaje=0.0;
 		this.total_con_iva=0.0;
 		this.suman=0.0;
 		this.descuento_valor=0.0;
 		this.total_sin_iva=0.0;
 		this.total_descuento=0.0;
 		this.flete=0.0;
 		this.total=0.0;
 		this.subtotal=0.0;
 		this.seguros=0.0;
 		this.iva=0.0;
 		this.financiamiento=0.0;
 		this.monto_retencion=0.0;
 		this.otro=0.0;
 		this.ice=0.0;
 		this.fecha=new Date();
 		this.fecha_servidor=new Date();
 		this.id_tipo_cambio=null;
 		this.numero_fue="";
 		this.id_centro_costo=null;
 		this.id_responsable=-1L;
 		this.hora_inicio=new Time((new Date()).getTime());
 		this.hora_fin=new Time((new Date()).getTime());
 		this.id_transportista=-1L;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.anio=null;
		this.mes=null;
		this.usuario=null;
		this.moneda=null;
		this.empleado=null;
		this.tipoprecio=null;
		this.formato=null;
		this.cliente=null;
		this.pais=null;
		this.transporte=null;
		this.vendedor=null;
		this.subcliente=null;
		this.consignatario=null;
		this.consultor=null;
		this.estadopedidoexpor=null;
		this.tipocambio=null;
		this.centrocosto=null;
		this.responsable=null;
		this.transportista=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		this.usuario_descripcion="";
		this.moneda_descripcion="";
		this.empleado_descripcion="";
		this.tipoprecio_descripcion="";
		this.formato_descripcion="";
		this.cliente_descripcion="";
		this.pais_descripcion="";
		this.transporte_descripcion="";
		this.vendedor_descripcion="";
		this.subcliente_descripcion="";
		this.consignatario_descripcion="";
		this.consultor_descripcion="";
		this.estadopedidoexpor_descripcion="";
		this.tipocambio_descripcion="";
		this.centrocosto_descripcion="";
		this.responsable_descripcion="";
		this.transportista_descripcion="";
		
		
		this.detallepedidoexpors=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PedidoExpor (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Long id_usuario,String numero,String numero_preimpreso,Date fecha_emision,Date fecha_vencimiento,Long id_moneda,Double cotizacion,Long id_empleado,Long id_tipo_precio,Long id_formato,String direccion,Long id_cliente,String telefono,String ruc,Long id_pais,String lugar_entrega,String embarque,String negociacion,Long id_transporte,Long id_vendedor,String forma_pago,Long id_sub_cliente,Long id_consignatario,Long id_consultor,String orden,Long id_estado_pedido,String descripcion,Double monto,Double saldo,Double disponible,Double descuento_porcentaje,Double total_con_iva,Double suman,Double descuento_valor,Double total_sin_iva,Double total_descuento,Double flete,Double total,Double subtotal,Double seguros,Double iva,Double financiamiento,Double monto_retencion,Double otro,Double ice,Date fecha,Date fecha_servidor,Long id_tipo_cambio,String numero_fue,Long id_centro_costo,Long id_responsable,Time hora_inicio,Time hora_fin,Long id_transportista) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.pedidoexporOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_usuario=id_usuario;
 		this.numero=numero;
 		this.numero_preimpreso=numero_preimpreso;
 		this.fecha_emision=fecha_emision;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.id_moneda=id_moneda;
 		this.cotizacion=cotizacion;
 		this.id_empleado=id_empleado;
 		this.id_tipo_precio=id_tipo_precio;
 		this.id_formato=id_formato;
 		this.direccion=direccion;
 		this.id_cliente=id_cliente;
 		this.telefono=telefono;
 		this.ruc=ruc;
 		this.id_pais=id_pais;
 		this.lugar_entrega=lugar_entrega;
 		this.embarque=embarque;
 		this.negociacion=negociacion;
 		this.id_transporte=id_transporte;
 		this.id_vendedor=id_vendedor;
 		this.forma_pago=forma_pago;
 		this.id_sub_cliente=id_sub_cliente;
 		this.id_consignatario=id_consignatario;
 		this.id_consultor=id_consultor;
 		this.orden=orden;
 		this.id_estado_pedido=id_estado_pedido;
 		this.descripcion=descripcion;
 		this.monto=monto;
 		this.saldo=saldo;
 		this.disponible=disponible;
 		this.descuento_porcentaje=descuento_porcentaje;
 		this.total_con_iva=total_con_iva;
 		this.suman=suman;
 		this.descuento_valor=descuento_valor;
 		this.total_sin_iva=total_sin_iva;
 		this.total_descuento=total_descuento;
 		this.flete=flete;
 		this.total=total;
 		this.subtotal=subtotal;
 		this.seguros=seguros;
 		this.iva=iva;
 		this.financiamiento=financiamiento;
 		this.monto_retencion=monto_retencion;
 		this.otro=otro;
 		this.ice=ice;
 		this.fecha=fecha;
 		this.fecha_servidor=fecha_servidor;
 		this.id_tipo_cambio=id_tipo_cambio;
 		this.numero_fue=numero_fue;
 		this.id_centro_costo=id_centro_costo;
 		this.id_responsable=id_responsable;
 		this.hora_inicio=hora_inicio;
 		this.hora_fin=hora_fin;
 		this.id_transportista=id_transportista;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PedidoExpor (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Long id_usuario,String numero,String numero_preimpreso,Date fecha_emision,Date fecha_vencimiento,Long id_moneda,Double cotizacion,Long id_empleado,Long id_tipo_precio,Long id_formato,String direccion,Long id_cliente,String telefono,String ruc,Long id_pais,String lugar_entrega,String embarque,String negociacion,Long id_transporte,Long id_vendedor,String forma_pago,Long id_sub_cliente,Long id_consignatario,Long id_consultor,String orden,Long id_estado_pedido,String descripcion,Double monto,Double saldo,Double disponible,Double descuento_porcentaje,Double total_con_iva,Double suman,Double descuento_valor,Double total_sin_iva,Double total_descuento,Double flete,Double total,Double subtotal,Double seguros,Double iva,Double financiamiento,Double monto_retencion,Double otro,Double ice,Date fecha,Date fecha_servidor,Long id_tipo_cambio,String numero_fue,Long id_centro_costo,Long id_responsable,Time hora_inicio,Time hora_fin,Long id_transportista) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.pedidoexporOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_usuario=id_usuario;
 		this.numero=numero;
 		this.numero_preimpreso=numero_preimpreso;
 		this.fecha_emision=fecha_emision;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.id_moneda=id_moneda;
 		this.cotizacion=cotizacion;
 		this.id_empleado=id_empleado;
 		this.id_tipo_precio=id_tipo_precio;
 		this.id_formato=id_formato;
 		this.direccion=direccion;
 		this.id_cliente=id_cliente;
 		this.telefono=telefono;
 		this.ruc=ruc;
 		this.id_pais=id_pais;
 		this.lugar_entrega=lugar_entrega;
 		this.embarque=embarque;
 		this.negociacion=negociacion;
 		this.id_transporte=id_transporte;
 		this.id_vendedor=id_vendedor;
 		this.forma_pago=forma_pago;
 		this.id_sub_cliente=id_sub_cliente;
 		this.id_consignatario=id_consignatario;
 		this.id_consultor=id_consultor;
 		this.orden=orden;
 		this.id_estado_pedido=id_estado_pedido;
 		this.descripcion=descripcion;
 		this.monto=monto;
 		this.saldo=saldo;
 		this.disponible=disponible;
 		this.descuento_porcentaje=descuento_porcentaje;
 		this.total_con_iva=total_con_iva;
 		this.suman=suman;
 		this.descuento_valor=descuento_valor;
 		this.total_sin_iva=total_sin_iva;
 		this.total_descuento=total_descuento;
 		this.flete=flete;
 		this.total=total;
 		this.subtotal=subtotal;
 		this.seguros=seguros;
 		this.iva=iva;
 		this.financiamiento=financiamiento;
 		this.monto_retencion=monto_retencion;
 		this.otro=otro;
 		this.ice=ice;
 		this.fecha=fecha;
 		this.fecha_servidor=fecha_servidor;
 		this.id_tipo_cambio=id_tipo_cambio;
 		this.numero_fue=numero_fue;
 		this.id_centro_costo=id_centro_costo;
 		this.id_responsable=id_responsable;
 		this.hora_inicio=hora_inicio;
 		this.hora_fin=hora_fin;
 		this.id_transportista=id_transportista;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		PedidoExpor pedidoexporLocal=null;
		
		if(object!=null) {
			pedidoexporLocal=(PedidoExpor)object;
			
			if(pedidoexporLocal!=null) {
				if(this.getId()!=null && pedidoexporLocal.getId()!=null) {
					if(this.getId().equals(pedidoexporLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PedidoExporConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PedidoExporConstantesFunciones.getPedidoExporDescripcion(this);
		} else {
			sDetalle=PedidoExporConstantesFunciones.getPedidoExporDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public PedidoExpor getPedidoExporOriginal() {
		return this.pedidoexporOriginal;
	}
	
	public void setPedidoExporOriginal(PedidoExpor pedidoexpor) {
		try {
			this.pedidoexporOriginal=pedidoexpor;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PedidoExporAdditional pedidoexporAdditional=null;
	
	public PedidoExporAdditional getPedidoExporAdditional() {
		return this.pedidoexporAdditional;
	}
	
	public void setPedidoExporAdditional(PedidoExporAdditional pedidoexporAdditional) {
		try {
			this.pedidoexporAdditional=pedidoexporAdditional;
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
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public Long getid_usuario() {
		return this.id_usuario;
	}
    
	
	public String getnumero() {
		return this.numero;
	}
    
	
	public String getnumero_preimpreso() {
		return this.numero_preimpreso;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Date getfecha_vencimiento() {
		return this.fecha_vencimiento;
	}
    
	
	public Long getid_moneda() {
		return this.id_moneda;
	}
    
	
	public Double getcotizacion() {
		return this.cotizacion;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_tipo_precio() {
		return this.id_tipo_precio;
	}
    
	
	public Long getid_formato() {
		return this.id_formato;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public String getlugar_entrega() {
		return this.lugar_entrega;
	}
    
	
	public String getembarque() {
		return this.embarque;
	}
    
	
	public String getnegociacion() {
		return this.negociacion;
	}
    
	
	public Long getid_transporte() {
		return this.id_transporte;
	}
    
	
	public Long getid_vendedor() {
		return this.id_vendedor;
	}
    
	
	public String getforma_pago() {
		return this.forma_pago;
	}
    
	
	public Long getid_sub_cliente() {
		return this.id_sub_cliente;
	}
    
	
	public Long getid_consignatario() {
		return this.id_consignatario;
	}
    
	
	public Long getid_consultor() {
		return this.id_consultor;
	}
    
	
	public String getorden() {
		return this.orden;
	}
    
	
	public Long getid_estado_pedido() {
		return this.id_estado_pedido;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Double getmonto() {
		return this.monto;
	}
    
	
	public Double getsaldo() {
		return this.saldo;
	}
    
	
	public Double getdisponible() {
		return this.disponible;
	}
    
	
	public Double getdescuento_porcentaje() {
		return this.descuento_porcentaje;
	}
    
	
	public Double gettotal_con_iva() {
		return this.total_con_iva;
	}
    
	
	public Double getsuman() {
		return this.suman;
	}
    
	
	public Double getdescuento_valor() {
		return this.descuento_valor;
	}
    
	
	public Double gettotal_sin_iva() {
		return this.total_sin_iva;
	}
    
	
	public Double gettotal_descuento() {
		return this.total_descuento;
	}
    
	
	public Double getflete() {
		return this.flete;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
    
	
	public Double getsubtotal() {
		return this.subtotal;
	}
    
	
	public Double getseguros() {
		return this.seguros;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public Double getfinanciamiento() {
		return this.financiamiento;
	}
    
	
	public Double getmonto_retencion() {
		return this.monto_retencion;
	}
    
	
	public Double getotro() {
		return this.otro;
	}
    
	
	public Double getice() {
		return this.ice;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Date getfecha_servidor() {
		return this.fecha_servidor;
	}
    
	
	public Long getid_tipo_cambio() {
		return this.id_tipo_cambio;
	}
    
	
	public String getnumero_fue() {
		return this.numero_fue;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Long getid_responsable() {
		return this.id_responsable;
	}
    
	
	public Time gethora_inicio() {
		return this.hora_inicio;
	}
    
	
	public Time gethora_fin() {
		return this.hora_fin;
	}
    
	
	public Long getid_transportista() {
		return this.id_transportista;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("PedidoExpor:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("PedidoExpor:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("PedidoExpor:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
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
    
	public void setid_usuario(Long newid_usuario)throws Exception
	{
		try {
			if(this.id_usuario!=newid_usuario) {
				if(newid_usuario==null) {
					//newid_usuario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero(String newnumero)throws Exception
	{
		try {
			if(this.numero!=newnumero) {
				if(newnumero==null) {
					//newnumero="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna numero");
					}
				}

				if(newnumero!=null&&newnumero.length()>50) {
					newnumero=newnumero.substring(0,48);
					System.out.println("PedidoExpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero");
				}

				this.numero=newnumero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_preimpreso(String newnumero_preimpreso)throws Exception
	{
		try {
			if(this.numero_preimpreso!=newnumero_preimpreso) {
				if(newnumero_preimpreso==null) {
					//newnumero_preimpreso="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna numero_preimpreso");
					}
				}

				if(newnumero_preimpreso!=null&&newnumero_preimpreso.length()>50) {
					newnumero_preimpreso=newnumero_preimpreso.substring(0,48);
					System.out.println("PedidoExpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_preimpreso");
				}

				this.numero_preimpreso=newnumero_preimpreso;
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
						System.out.println("PedidoExpor:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vencimiento(Date newfecha_vencimiento)throws Exception
	{
		try {
			if(this.fecha_vencimiento!=newfecha_vencimiento) {
				if(newfecha_vencimiento==null) {
					//newfecha_vencimiento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna fecha_vencimiento");
					}
				}

				this.fecha_vencimiento=newfecha_vencimiento;
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
						System.out.println("PedidoExpor:Valor nulo no permitido en columna id_moneda");
					}
				}

				this.id_moneda=newid_moneda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcotizacion(Double newcotizacion)throws Exception
	{
		try {
			if(this.cotizacion!=newcotizacion) {
				if(newcotizacion==null) {
					//newcotizacion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna cotizacion");
					}
				}

				this.cotizacion=newcotizacion;
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
						System.out.println("PedidoExpor:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_precio(Long newid_tipo_precio)throws Exception
	{
		try {
			if(this.id_tipo_precio!=newid_tipo_precio) {
				if(newid_tipo_precio==null) {
					//newid_tipo_precio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna id_tipo_precio");
					}
				}

				this.id_tipo_precio=newid_tipo_precio;
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
    
	public void setdireccion(String newdireccion)throws Exception
	{
		try {
			if(this.direccion!=newdireccion) {
				if(newdireccion==null) {
					//newdireccion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>150) {
					newdireccion=newdireccion.substring(0,148);
					System.out.println("PedidoExpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna direccion");
				}

				this.direccion=newdireccion;
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
						System.out.println("PedidoExpor:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
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
						System.out.println("PedidoExpor:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>50) {
					newtelefono=newtelefono.substring(0,48);
					System.out.println("PedidoExpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna telefono");
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
						System.out.println("PedidoExpor:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>20) {
					newruc=newruc.substring(0,18);
					System.out.println("PedidoExpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna ruc");
				}

				this.ruc=newruc;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_pais(Long newid_pais) {
		if(this.id_pais==null&&newid_pais!=null) {
			this.id_pais=newid_pais;
				this.setIsChanged(true);
		}

		if(this.id_pais!=null&&!this.id_pais.equals(newid_pais)) {

			this.id_pais=newid_pais;
				this.setIsChanged(true);
		}
	}
    
	public void setlugar_entrega(String newlugar_entrega)throws Exception
	{
		try {
			if(this.lugar_entrega!=newlugar_entrega) {
				if(newlugar_entrega==null) {
					//newlugar_entrega="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna lugar_entrega");
					}
				}

				if(newlugar_entrega!=null&&newlugar_entrega.length()>50) {
					newlugar_entrega=newlugar_entrega.substring(0,48);
					System.out.println("PedidoExpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna lugar_entrega");
				}

				this.lugar_entrega=newlugar_entrega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setembarque(String newembarque)throws Exception
	{
		try {
			if(this.embarque!=newembarque) {
				if(newembarque==null) {
					//newembarque="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna embarque");
					}
				}

				if(newembarque!=null&&newembarque.length()>150) {
					newembarque=newembarque.substring(0,148);
					System.out.println("PedidoExpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna embarque");
				}

				this.embarque=newembarque;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnegociacion(String newnegociacion)throws Exception
	{
		try {
			if(this.negociacion!=newnegociacion) {
				if(newnegociacion==null) {
					//newnegociacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna negociacion");
					}
				}

				if(newnegociacion!=null&&newnegociacion.length()>150) {
					newnegociacion=newnegociacion.substring(0,148);
					System.out.println("PedidoExpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna negociacion");
				}

				this.negociacion=newnegociacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transporte(Long newid_transporte) {
		if(this.id_transporte==null&&newid_transporte!=null) {
			this.id_transporte=newid_transporte;
				this.setIsChanged(true);
		}

		if(this.id_transporte!=null&&!this.id_transporte.equals(newid_transporte)) {

			this.id_transporte=newid_transporte;
				this.setIsChanged(true);
		}
	}
    
	public void setid_vendedor(Long newid_vendedor) {
		if(this.id_vendedor==null&&newid_vendedor!=null) {
			this.id_vendedor=newid_vendedor;
				this.setIsChanged(true);
		}

		if(this.id_vendedor!=null&&!this.id_vendedor.equals(newid_vendedor)) {

			this.id_vendedor=newid_vendedor;
				this.setIsChanged(true);
		}
	}
    
	public void setforma_pago(String newforma_pago)throws Exception
	{
		try {
			if(this.forma_pago!=newforma_pago) {
				if(newforma_pago==null) {
					//newforma_pago="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna forma_pago");
					}
				}

				if(newforma_pago!=null&&newforma_pago.length()>150) {
					newforma_pago=newforma_pago.substring(0,148);
					System.out.println("PedidoExpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna forma_pago");
				}

				this.forma_pago=newforma_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sub_cliente(Long newid_sub_cliente) {
		if(this.id_sub_cliente==null&&newid_sub_cliente!=null) {
			this.id_sub_cliente=newid_sub_cliente;
				this.setIsChanged(true);
		}

		if(this.id_sub_cliente!=null&&!this.id_sub_cliente.equals(newid_sub_cliente)) {

			this.id_sub_cliente=newid_sub_cliente;
				this.setIsChanged(true);
		}
	}
    
	public void setid_consignatario(Long newid_consignatario) {
		if(this.id_consignatario==null&&newid_consignatario!=null) {
			this.id_consignatario=newid_consignatario;
				this.setIsChanged(true);
		}

		if(this.id_consignatario!=null&&!this.id_consignatario.equals(newid_consignatario)) {

			this.id_consignatario=newid_consignatario;
				this.setIsChanged(true);
		}
	}
    
	public void setid_consultor(Long newid_consultor) {
		if(this.id_consultor==null&&newid_consultor!=null) {
			this.id_consultor=newid_consultor;
				this.setIsChanged(true);
		}

		if(this.id_consultor!=null&&!this.id_consultor.equals(newid_consultor)) {

			this.id_consultor=newid_consultor;
				this.setIsChanged(true);
		}
	}
    
	public void setorden(String neworden)throws Exception
	{
		try {
			if(this.orden!=neworden) {
				if(neworden==null) {
					//neworden="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna orden");
					}
				}

				if(neworden!=null&&neworden.length()>50) {
					neworden=neworden.substring(0,48);
					System.out.println("PedidoExpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna orden");
				}

				this.orden=neworden;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_pedido(Long newid_estado_pedido)throws Exception
	{
		try {
			if(this.id_estado_pedido!=newid_estado_pedido) {
				if(newid_estado_pedido==null) {
					//newid_estado_pedido=1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna id_estado_pedido");
					}
				}

				this.id_estado_pedido=newid_estado_pedido;
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
						System.out.println("PedidoExpor:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("PedidoExpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto(Double newmonto)throws Exception
	{
		try {
			if(this.monto!=newmonto) {
				if(newmonto==null) {
					//newmonto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna monto");
					}
				}

				this.monto=newmonto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsaldo(Double newsaldo)throws Exception
	{
		try {
			if(this.saldo!=newsaldo) {
				if(newsaldo==null) {
					//newsaldo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna saldo");
					}
				}

				this.saldo=newsaldo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdisponible(Double newdisponible)throws Exception
	{
		try {
			if(this.disponible!=newdisponible) {
				if(newdisponible==null) {
					//newdisponible=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna disponible");
					}
				}

				this.disponible=newdisponible;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento_porcentaje(Double newdescuento_porcentaje)throws Exception
	{
		try {
			if(this.descuento_porcentaje!=newdescuento_porcentaje) {
				if(newdescuento_porcentaje==null) {
					//newdescuento_porcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna descuento_porcentaje");
					}
				}

				this.descuento_porcentaje=newdescuento_porcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_con_iva(Double newtotal_con_iva)throws Exception
	{
		try {
			if(this.total_con_iva!=newtotal_con_iva) {
				if(newtotal_con_iva==null) {
					//newtotal_con_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna total_con_iva");
					}
				}

				this.total_con_iva=newtotal_con_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsuman(Double newsuman)throws Exception
	{
		try {
			if(this.suman!=newsuman) {
				if(newsuman==null) {
					//newsuman=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna suman");
					}
				}

				this.suman=newsuman;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento_valor(Double newdescuento_valor)throws Exception
	{
		try {
			if(this.descuento_valor!=newdescuento_valor) {
				if(newdescuento_valor==null) {
					//newdescuento_valor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna descuento_valor");
					}
				}

				this.descuento_valor=newdescuento_valor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_sin_iva(Double newtotal_sin_iva)throws Exception
	{
		try {
			if(this.total_sin_iva!=newtotal_sin_iva) {
				if(newtotal_sin_iva==null) {
					//newtotal_sin_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna total_sin_iva");
					}
				}

				this.total_sin_iva=newtotal_sin_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_descuento(Double newtotal_descuento)throws Exception
	{
		try {
			if(this.total_descuento!=newtotal_descuento) {
				if(newtotal_descuento==null) {
					//newtotal_descuento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna total_descuento");
					}
				}

				this.total_descuento=newtotal_descuento;
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
						System.out.println("PedidoExpor:Valor nulo no permitido en columna flete");
					}
				}

				this.flete=newflete;
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
						System.out.println("PedidoExpor:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsubtotal(Double newsubtotal)throws Exception
	{
		try {
			if(this.subtotal!=newsubtotal) {
				if(newsubtotal==null) {
					//newsubtotal=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna subtotal");
					}
				}

				this.subtotal=newsubtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setseguros(Double newseguros)throws Exception
	{
		try {
			if(this.seguros!=newseguros) {
				if(newseguros==null) {
					//newseguros=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna seguros");
					}
				}

				this.seguros=newseguros;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setiva(Double newiva)throws Exception
	{
		try {
			if(this.iva!=newiva) {
				if(newiva==null) {
					//newiva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna iva");
					}
				}

				this.iva=newiva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfinanciamiento(Double newfinanciamiento)throws Exception
	{
		try {
			if(this.financiamiento!=newfinanciamiento) {
				if(newfinanciamiento==null) {
					//newfinanciamiento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna financiamiento");
					}
				}

				this.financiamiento=newfinanciamiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_retencion(Double newmonto_retencion)throws Exception
	{
		try {
			if(this.monto_retencion!=newmonto_retencion) {
				if(newmonto_retencion==null) {
					//newmonto_retencion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna monto_retencion");
					}
				}

				this.monto_retencion=newmonto_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setotro(Double newotro)throws Exception
	{
		try {
			if(this.otro!=newotro) {
				if(newotro==null) {
					//newotro=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna otro");
					}
				}

				this.otro=newotro;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setice(Double newice)throws Exception
	{
		try {
			if(this.ice!=newice) {
				if(newice==null) {
					//newice=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna ice");
					}
				}

				this.ice=newice;
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
						System.out.println("PedidoExpor:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_servidor(Date newfecha_servidor)throws Exception
	{
		try {
			if(this.fecha_servidor!=newfecha_servidor) {
				if(newfecha_servidor==null) {
					//newfecha_servidor=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna fecha_servidor");
					}
				}

				this.fecha_servidor=newfecha_servidor;
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
    
	public void setnumero_fue(String newnumero_fue)throws Exception
	{
		try {
			if(this.numero_fue!=newnumero_fue) {
				if(newnumero_fue==null) {
					//newnumero_fue="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna numero_fue");
					}
				}

				if(newnumero_fue!=null&&newnumero_fue.length()>50) {
					newnumero_fue=newnumero_fue.substring(0,48);
					System.out.println("PedidoExpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_fue");
				}

				this.numero_fue=newnumero_fue;
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
    
	public void setid_responsable(Long newid_responsable)throws Exception
	{
		try {
			if(this.id_responsable!=newid_responsable) {
				if(newid_responsable==null) {
					//newid_responsable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna id_responsable");
					}
				}

				this.id_responsable=newid_responsable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_inicio(Time newhora_inicio)throws Exception
	{
		try {
			if(this.hora_inicio!=newhora_inicio) {
				if(newhora_inicio==null) {
					//newhora_inicio=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna hora_inicio");
					}
				}

				this.hora_inicio=newhora_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_fin(Time newhora_fin)throws Exception
	{
		try {
			if(this.hora_fin!=newhora_fin) {
				if(newhora_fin==null) {
					//newhora_fin=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna hora_fin");
					}
				}

				this.hora_fin=newhora_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transportista(Long newid_transportista)throws Exception
	{
		try {
			if(this.id_transportista!=newid_transportista) {
				if(newid_transportista==null) {
					//newid_transportista=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoExpor:Valor nulo no permitido en columna id_transportista");
					}
				}

				this.id_transportista=newid_transportista;
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

	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public TipoPrecio getTipoPrecio() {
		return this.tipoprecio;
	}

	public Formato getFormato() {
		return this.formato;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Pais getPais() {
		return this.pais;
	}

	public Transporte getTransporte() {
		return this.transporte;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public SubCliente getSubCliente() {
		return this.subcliente;
	}

	public Consignatario getConsignatario() {
		return this.consignatario;
	}

	public Consultor getConsultor() {
		return this.consultor;
	}

	public EstadoPedido getEstadoPedidoExpor() {
		return this.estadopedidoexpor;
	}

	public TipoCambio getTipoCambio() {
		return this.tipocambio;
	}

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
	}

	public Responsable getResponsable() {
		return this.responsable;
	}

	public Transportista getTransportista() {
		return this.transportista;
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

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
	}

	public String getusuario_descripcion() {
		return this.usuario_descripcion;
	}

	public String getmoneda_descripcion() {
		return this.moneda_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String gettipoprecio_descripcion() {
		return this.tipoprecio_descripcion;
	}

	public String getformato_descripcion() {
		return this.formato_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String gettransporte_descripcion() {
		return this.transporte_descripcion;
	}

	public String getvendedor_descripcion() {
		return this.vendedor_descripcion;
	}

	public String getsubcliente_descripcion() {
		return this.subcliente_descripcion;
	}

	public String getconsignatario_descripcion() {
		return this.consignatario_descripcion;
	}

	public String getconsultor_descripcion() {
		return this.consultor_descripcion;
	}

	public String getestadopedidoexpor_descripcion() {
		return this.estadopedidoexpor_descripcion;
	}

	public String gettipocambio_descripcion() {
		return this.tipocambio_descripcion;
	}

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
	}

	public String getresponsable_descripcion() {
		return this.responsable_descripcion;
	}

	public String gettransportista_descripcion() {
		return this.transportista_descripcion;
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


	public  void  setUsuario(Usuario usuario) {
		try {
			this.usuario=usuario;
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


	public  void  setEmpleado(Empleado empleado) {
		try {
			this.empleado=empleado;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoPrecio(TipoPrecio tipoprecio) {
		try {
			this.tipoprecio=tipoprecio;
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


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
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


	public  void  setTransporte(Transporte transporte) {
		try {
			this.transporte=transporte;
		} catch(Exception e) {
			;
		}
	}


	public  void  setVendedor(Vendedor vendedor) {
		try {
			this.vendedor=vendedor;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSubCliente(SubCliente subcliente) {
		try {
			this.subcliente=subcliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setConsignatario(Consignatario consignatario) {
		try {
			this.consignatario=consignatario;
		} catch(Exception e) {
			;
		}
	}


	public  void  setConsultor(Consultor consultor) {
		try {
			this.consultor=consultor;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoPedidoExpor(EstadoPedido estadopedidoexpor) {
		try {
			this.estadopedidoexpor=estadopedidoexpor;
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


	public  void  setCentroCosto(CentroCosto centrocosto) {
		try {
			this.centrocosto=centrocosto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setResponsable(Responsable responsable) {
		try {
			this.responsable=responsable;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransportista(Transportista transportista) {
		try {
			this.transportista=transportista;
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


	public  void  setusuario_descripcion(String usuario_descripcion) {
		try {
			this.usuario_descripcion=usuario_descripcion;
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


	public  void  setempleado_descripcion(String empleado_descripcion) {
		try {
			this.empleado_descripcion=empleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoprecio_descripcion(String tipoprecio_descripcion) {
		try {
			this.tipoprecio_descripcion=tipoprecio_descripcion;
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


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
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


	public  void  settransporte_descripcion(String transporte_descripcion) {
		try {
			this.transporte_descripcion=transporte_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setvendedor_descripcion(String vendedor_descripcion) {
		try {
			this.vendedor_descripcion=vendedor_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setsubcliente_descripcion(String subcliente_descripcion) {
		try {
			this.subcliente_descripcion=subcliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setconsignatario_descripcion(String consignatario_descripcion) {
		try {
			this.consignatario_descripcion=consignatario_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setconsultor_descripcion(String consultor_descripcion) {
		try {
			this.consultor_descripcion=consultor_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadopedidoexpor_descripcion(String estadopedidoexpor_descripcion) {
		try {
			this.estadopedidoexpor_descripcion=estadopedidoexpor_descripcion;
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


	public  void  setcentrocosto_descripcion(String centrocosto_descripcion) {
		try {
			this.centrocosto_descripcion=centrocosto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setresponsable_descripcion(String responsable_descripcion) {
		try {
			this.responsable_descripcion=responsable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransportista_descripcion(String transportista_descripcion) {
		try {
			this.transportista_descripcion=transportista_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<DetallePedidoExpor> getDetallePedidoExpors() {
		return this.detallepedidoexpors;
	}

	
	
	public  void  setDetallePedidoExpors(List<DetallePedidoExpor> detallepedidoexpors) {
		try {
			this.detallepedidoexpors=detallepedidoexpors;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";String id_usuario_descripcion="";String id_moneda_descripcion="";String id_empleado_descripcion="";String id_tipo_precio_descripcion="";String id_formato_descripcion="";String id_cliente_descripcion="";String id_pais_descripcion="";String id_transporte_descripcion="";String id_vendedor_descripcion="";String id_sub_cliente_descripcion="";String id_consignatario_descripcion="";String id_consultor_descripcion="";String id_estado_pedido_descripcion="";String id_tipo_cambio_descripcion="";String id_centro_costo_descripcion="";String id_responsable_descripcion="";String id_transportista_descripcion="";
	
	
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
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
	}
	public String getid_usuario_descripcion() {
		return id_usuario_descripcion;
	}
	public String getid_moneda_descripcion() {
		return id_moneda_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_tipo_precio_descripcion() {
		return id_tipo_precio_descripcion;
	}
	public String getid_formato_descripcion() {
		return id_formato_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_transporte_descripcion() {
		return id_transporte_descripcion;
	}
	public String getid_vendedor_descripcion() {
		return id_vendedor_descripcion;
	}
	public String getid_sub_cliente_descripcion() {
		return id_sub_cliente_descripcion;
	}
	public String getid_consignatario_descripcion() {
		return id_consignatario_descripcion;
	}
	public String getid_consultor_descripcion() {
		return id_consultor_descripcion;
	}
	public String getid_estado_pedido_descripcion() {
		return id_estado_pedido_descripcion;
	}
	public String getid_tipo_cambio_descripcion() {
		return id_tipo_cambio_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
	}
	public String getid_responsable_descripcion() {
		return id_responsable_descripcion;
	}
	public String getid_transportista_descripcion() {
		return id_transportista_descripcion;
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
	public void setid_usuario_descripcion(String newid_usuario_descripcion)throws Exception {
		try {
			this.id_usuario_descripcion=newid_usuario_descripcion;
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
	public void setid_empleado_descripcion(String newid_empleado_descripcion)throws Exception {
		try {
			this.id_empleado_descripcion=newid_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_precio_descripcion(String newid_tipo_precio_descripcion)throws Exception {
		try {
			this.id_tipo_precio_descripcion=newid_tipo_precio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_descripcion(String newid_formato_descripcion) {
		this.id_formato_descripcion=newid_formato_descripcion;
	}
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_pais_descripcion(String newid_pais_descripcion) {
		this.id_pais_descripcion=newid_pais_descripcion;
	}
	public void setid_transporte_descripcion(String newid_transporte_descripcion) {
		this.id_transporte_descripcion=newid_transporte_descripcion;
	}
	public void setid_vendedor_descripcion(String newid_vendedor_descripcion) {
		this.id_vendedor_descripcion=newid_vendedor_descripcion;
	}
	public void setid_sub_cliente_descripcion(String newid_sub_cliente_descripcion) {
		this.id_sub_cliente_descripcion=newid_sub_cliente_descripcion;
	}
	public void setid_consignatario_descripcion(String newid_consignatario_descripcion) {
		this.id_consignatario_descripcion=newid_consignatario_descripcion;
	}
	public void setid_consultor_descripcion(String newid_consultor_descripcion) {
		this.id_consultor_descripcion=newid_consultor_descripcion;
	}
	public void setid_estado_pedido_descripcion(String newid_estado_pedido_descripcion)throws Exception {
		try {
			this.id_estado_pedido_descripcion=newid_estado_pedido_descripcion;
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
	public void setid_centro_costo_descripcion(String newid_centro_costo_descripcion)throws Exception {
		try {
			this.id_centro_costo_descripcion=newid_centro_costo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_responsable_descripcion(String newid_responsable_descripcion)throws Exception {
		try {
			this.id_responsable_descripcion=newid_responsable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transportista_descripcion(String newid_transportista_descripcion)throws Exception {
		try {
			this.id_transportista_descripcion=newid_transportista_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";this.id_usuario_descripcion="";this.id_moneda_descripcion="";this.id_empleado_descripcion="";this.id_tipo_precio_descripcion="";this.id_formato_descripcion="";this.id_cliente_descripcion="";this.id_pais_descripcion="";this.id_transporte_descripcion="";this.id_vendedor_descripcion="";this.id_sub_cliente_descripcion="";this.id_consignatario_descripcion="";this.id_consultor_descripcion="";this.id_estado_pedido_descripcion="";this.id_tipo_cambio_descripcion="";this.id_centro_costo_descripcion="";this.id_responsable_descripcion="";this.id_transportista_descripcion="";
	}
	
	
	Object detallepedidoexporsDescripcionReporte;
	
	
	public Object getdetallepedidoexporsDescripcionReporte() {
		return detallepedidoexporsDescripcionReporte;
	}

	
	
	public  void  setdetallepedidoexporsDescripcionReporte(Object detallepedidoexpors) {
		try {
			this.detallepedidoexporsDescripcionReporte=detallepedidoexpors;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

