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
//import com.bydan.erp.inventario.util.ParametroCompraConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class ParametroCompra extends ParametroCompraAdditional implements Serializable ,Cloneable {//ParametroCompraAdditional,GeneralEntity
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
	
	private ParametroCompra parametrocompraOriginal;
	
	private Map<String, Object> mapParametroCompra;
			
	public Map<String, Object> getMapParametroCompra() {
		return mapParametroCompra;
	}

	public void setMapParametroCompra(Map<String, Object> mapParametroCompra) {
		this.mapParametroCompra = mapParametroCompra;
	}
	
	public void inicializarMapParametroCompra() {
		this.mapParametroCompra = new HashMap<String,Object>();
	}
	
	public void setMapParametroCompraValue(String sKey,Object oValue) {
		this.mapParametroCompra.put(sKey, oValue);
	}
	
	public Object getMapParametroCompraValue(String sKey) {
		return this.mapParametroCompra.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroCompraConstantesFunciones.SREGEXSECUENCIAL_PEDIDO,message=ParametroCompraConstantesFunciones.SMENSAJEREGEXSECUENCIAL_PEDIDO)
	private String secuencial_pedido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroCompraConstantesFunciones.SREGEXSECUENCIAL_COTIZACION,message=ParametroCompraConstantesFunciones.SMENSAJEREGEXSECUENCIAL_COTIZACION)
	private String secuencial_cotizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroCompraConstantesFunciones.SREGEXSECUENCIAL_PRODUCCION,message=ParametroCompraConstantesFunciones.SMENSAJEREGEXSECUENCIAL_PRODUCCION)
	private String secuencial_produccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_documento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega_reserva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_embarcador;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroCompraConstantesFunciones.SREGEXTEXTO_MAIL,message=ParametroCompraConstantesFunciones.SMENSAJEREGEXTEXTO_MAIL)
	private String texto_mail;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_movimiento_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroCompraConstantesFunciones.SREGEXDESCRIPCION,message=ParametroCompraConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_pedido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_pedido_pendiente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_cotizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_pedido_cotizado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_autorizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_pedido_autorizado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_item;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_pedido_anulado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_prioridad_pedido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_pedido_suspendido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_pedido_regularizado;
			
	
	public Empresa empresa;
	public TipoDocumento tipodocumento;
	public TipoMovimiento tipomovimiento;
	public Bodega bodega;
	public Bodega bodegareserva;
	public Empleado empleado;
	public Embarcador embarcador;
	public Modulo modulo;
	public TipoMovimientoModulo tipomovimientomodulo;
	public Formato formatopedido;
	public EstadoPedido estadopedidopendiente;
	public Formato formatocotizacion;
	public EstadoPedido estadopedidocotizado;
	public Formato formatoautorizacion;
	public EstadoPedido estadopedidoautorizado;
	public Formato formatoitem;
	public EstadoPedido estadopedidoanulado;
	public PrioridadPedido prioridadpedido;
	public EstadoPedido estadopedidosuspendido;
	public EstadoPedido estadopedidoregularizado;
	
	
	private String empresa_descripcion;
	private String tipodocumento_descripcion;
	private String tipomovimiento_descripcion;
	private String bodega_descripcion;
	private String bodegareserva_descripcion;
	private String empleado_descripcion;
	private String embarcador_descripcion;
	private String modulo_descripcion;
	private String tipomovimientomodulo_descripcion;
	private String formatopedido_descripcion;
	private String estadopedidopendiente_descripcion;
	private String formatocotizacion_descripcion;
	private String estadopedidocotizado_descripcion;
	private String formatoautorizacion_descripcion;
	private String estadopedidoautorizado_descripcion;
	private String formatoitem_descripcion;
	private String estadopedidoanulado_descripcion;
	private String prioridadpedido_descripcion;
	private String estadopedidosuspendido_descripcion;
	private String estadopedidoregularizado_descripcion;
	
	
		
	public ParametroCompra () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametrocompraOriginal=this;
		
 		this.id_empresa=-1L;
 		this.secuencial_pedido="";
 		this.secuencial_cotizacion="";
 		this.secuencial_produccion="";
 		this.id_tipo_documento=-1L;
 		this.id_tipo_movimiento=-1L;
 		this.id_bodega=-1L;
 		this.id_bodega_reserva=-1L;
 		this.id_empleado=-1L;
 		this.id_embarcador=-1L;
 		this.con_centro_costo=false;
 		this.texto_mail="";
 		this.id_modulo=-1L;
 		this.id_tipo_movimiento_modulo=-1L;
 		this.descripcion="";
 		this.id_formato_pedido=-1L;
 		this.id_estado_pedido_pendiente=-1L;
 		this.id_formato_cotizacion=-1L;
 		this.id_estado_pedido_cotizado=-1L;
 		this.id_formato_autorizacion=-1L;
 		this.id_estado_pedido_autorizado=-1L;
 		this.id_formato_item=-1L;
 		this.id_estado_pedido_anulado=-1L;
 		this.id_prioridad_pedido=-1L;
 		this.id_estado_pedido_suspendido=-1L;
 		this.id_estado_pedido_regularizado=-1L;
		
		
		this.empresa=null;
		this.tipodocumento=null;
		this.tipomovimiento=null;
		this.bodega=null;
		this.bodegareserva=null;
		this.empleado=null;
		this.embarcador=null;
		this.modulo=null;
		this.tipomovimientomodulo=null;
		this.formatopedido=null;
		this.estadopedidopendiente=null;
		this.formatocotizacion=null;
		this.estadopedidocotizado=null;
		this.formatoautorizacion=null;
		this.estadopedidoautorizado=null;
		this.formatoitem=null;
		this.estadopedidoanulado=null;
		this.prioridadpedido=null;
		this.estadopedidosuspendido=null;
		this.estadopedidoregularizado=null;
		
		
		this.empresa_descripcion="";
		this.tipodocumento_descripcion="";
		this.tipomovimiento_descripcion="";
		this.bodega_descripcion="";
		this.bodegareserva_descripcion="";
		this.empleado_descripcion="";
		this.embarcador_descripcion="";
		this.modulo_descripcion="";
		this.tipomovimientomodulo_descripcion="";
		this.formatopedido_descripcion="";
		this.estadopedidopendiente_descripcion="";
		this.formatocotizacion_descripcion="";
		this.estadopedidocotizado_descripcion="";
		this.formatoautorizacion_descripcion="";
		this.estadopedidoautorizado_descripcion="";
		this.formatoitem_descripcion="";
		this.estadopedidoanulado_descripcion="";
		this.prioridadpedido_descripcion="";
		this.estadopedidosuspendido_descripcion="";
		this.estadopedidoregularizado_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroCompra (Long id,Date versionRow,Long id_empresa,String secuencial_pedido,String secuencial_cotizacion,String secuencial_produccion,Long id_tipo_documento,Long id_tipo_movimiento,Long id_bodega,Long id_bodega_reserva,Long id_empleado,Long id_embarcador,Boolean con_centro_costo,String texto_mail,Long id_modulo,Long id_tipo_movimiento_modulo,String descripcion,Long id_formato_pedido,Long id_estado_pedido_pendiente,Long id_formato_cotizacion,Long id_estado_pedido_cotizado,Long id_formato_autorizacion,Long id_estado_pedido_autorizado,Long id_formato_item,Long id_estado_pedido_anulado,Long id_prioridad_pedido,Long id_estado_pedido_suspendido,Long id_estado_pedido_regularizado) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrocompraOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.secuencial_pedido=secuencial_pedido;
 		this.secuencial_cotizacion=secuencial_cotizacion;
 		this.secuencial_produccion=secuencial_produccion;
 		this.id_tipo_documento=id_tipo_documento;
 		this.id_tipo_movimiento=id_tipo_movimiento;
 		this.id_bodega=id_bodega;
 		this.id_bodega_reserva=id_bodega_reserva;
 		this.id_empleado=id_empleado;
 		this.id_embarcador=id_embarcador;
 		this.con_centro_costo=con_centro_costo;
 		this.texto_mail=texto_mail;
 		this.id_modulo=id_modulo;
 		this.id_tipo_movimiento_modulo=id_tipo_movimiento_modulo;
 		this.descripcion=descripcion;
 		this.id_formato_pedido=id_formato_pedido;
 		this.id_estado_pedido_pendiente=id_estado_pedido_pendiente;
 		this.id_formato_cotizacion=id_formato_cotizacion;
 		this.id_estado_pedido_cotizado=id_estado_pedido_cotizado;
 		this.id_formato_autorizacion=id_formato_autorizacion;
 		this.id_estado_pedido_autorizado=id_estado_pedido_autorizado;
 		this.id_formato_item=id_formato_item;
 		this.id_estado_pedido_anulado=id_estado_pedido_anulado;
 		this.id_prioridad_pedido=id_prioridad_pedido;
 		this.id_estado_pedido_suspendido=id_estado_pedido_suspendido;
 		this.id_estado_pedido_regularizado=id_estado_pedido_regularizado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroCompra (Long id_empresa,String secuencial_pedido,String secuencial_cotizacion,String secuencial_produccion,Long id_tipo_documento,Long id_tipo_movimiento,Long id_bodega,Long id_bodega_reserva,Long id_empleado,Long id_embarcador,Boolean con_centro_costo,String texto_mail,Long id_modulo,Long id_tipo_movimiento_modulo,String descripcion,Long id_formato_pedido,Long id_estado_pedido_pendiente,Long id_formato_cotizacion,Long id_estado_pedido_cotizado,Long id_formato_autorizacion,Long id_estado_pedido_autorizado,Long id_formato_item,Long id_estado_pedido_anulado,Long id_prioridad_pedido,Long id_estado_pedido_suspendido,Long id_estado_pedido_regularizado) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrocompraOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.secuencial_pedido=secuencial_pedido;
 		this.secuencial_cotizacion=secuencial_cotizacion;
 		this.secuencial_produccion=secuencial_produccion;
 		this.id_tipo_documento=id_tipo_documento;
 		this.id_tipo_movimiento=id_tipo_movimiento;
 		this.id_bodega=id_bodega;
 		this.id_bodega_reserva=id_bodega_reserva;
 		this.id_empleado=id_empleado;
 		this.id_embarcador=id_embarcador;
 		this.con_centro_costo=con_centro_costo;
 		this.texto_mail=texto_mail;
 		this.id_modulo=id_modulo;
 		this.id_tipo_movimiento_modulo=id_tipo_movimiento_modulo;
 		this.descripcion=descripcion;
 		this.id_formato_pedido=id_formato_pedido;
 		this.id_estado_pedido_pendiente=id_estado_pedido_pendiente;
 		this.id_formato_cotizacion=id_formato_cotizacion;
 		this.id_estado_pedido_cotizado=id_estado_pedido_cotizado;
 		this.id_formato_autorizacion=id_formato_autorizacion;
 		this.id_estado_pedido_autorizado=id_estado_pedido_autorizado;
 		this.id_formato_item=id_formato_item;
 		this.id_estado_pedido_anulado=id_estado_pedido_anulado;
 		this.id_prioridad_pedido=id_prioridad_pedido;
 		this.id_estado_pedido_suspendido=id_estado_pedido_suspendido;
 		this.id_estado_pedido_regularizado=id_estado_pedido_regularizado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroCompra parametrocompraLocal=null;
		
		if(object!=null) {
			parametrocompraLocal=(ParametroCompra)object;
			
			if(parametrocompraLocal!=null) {
				if(this.getId()!=null && parametrocompraLocal.getId()!=null) {
					if(this.getId().equals(parametrocompraLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroCompraConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroCompraConstantesFunciones.getParametroCompraDescripcion(this);
		} else {
			sDetalle=ParametroCompraConstantesFunciones.getParametroCompraDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroCompra getParametroCompraOriginal() {
		return this.parametrocompraOriginal;
	}
	
	public void setParametroCompraOriginal(ParametroCompra parametrocompra) {
		try {
			this.parametrocompraOriginal=parametrocompra;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroCompraAdditional parametrocompraAdditional=null;
	
	public ParametroCompraAdditional getParametroCompraAdditional() {
		return this.parametrocompraAdditional;
	}
	
	public void setParametroCompraAdditional(ParametroCompraAdditional parametrocompraAdditional) {
		try {
			this.parametrocompraAdditional=parametrocompraAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getsecuencial_pedido() {
		return this.secuencial_pedido;
	}
    
	
	public String getsecuencial_cotizacion() {
		return this.secuencial_cotizacion;
	}
    
	
	public String getsecuencial_produccion() {
		return this.secuencial_produccion;
	}
    
	
	public Long getid_tipo_documento() {
		return this.id_tipo_documento;
	}
    
	
	public Long getid_tipo_movimiento() {
		return this.id_tipo_movimiento;
	}
    
	
	public Long getid_bodega() {
		return this.id_bodega;
	}
    
	
	public Long getid_bodega_reserva() {
		return this.id_bodega_reserva;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_embarcador() {
		return this.id_embarcador;
	}
    
	
	public Boolean getcon_centro_costo() {
		return this.con_centro_costo;
	}
    
	
	public String gettexto_mail() {
		return this.texto_mail;
	}
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public Long getid_tipo_movimiento_modulo() {
		return this.id_tipo_movimiento_modulo;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Long getid_formato_pedido() {
		return this.id_formato_pedido;
	}
    
	
	public Long getid_estado_pedido_pendiente() {
		return this.id_estado_pedido_pendiente;
	}
    
	
	public Long getid_formato_cotizacion() {
		return this.id_formato_cotizacion;
	}
    
	
	public Long getid_estado_pedido_cotizado() {
		return this.id_estado_pedido_cotizado;
	}
    
	
	public Long getid_formato_autorizacion() {
		return this.id_formato_autorizacion;
	}
    
	
	public Long getid_estado_pedido_autorizado() {
		return this.id_estado_pedido_autorizado;
	}
    
	
	public Long getid_formato_item() {
		return this.id_formato_item;
	}
    
	
	public Long getid_estado_pedido_anulado() {
		return this.id_estado_pedido_anulado;
	}
    
	
	public Long getid_prioridad_pedido() {
		return this.id_prioridad_pedido;
	}
    
	
	public Long getid_estado_pedido_suspendido() {
		return this.id_estado_pedido_suspendido;
	}
    
	
	public Long getid_estado_pedido_regularizado() {
		return this.id_estado_pedido_regularizado;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCompra:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial_pedido(String newsecuencial_pedido)throws Exception
	{
		try {
			if(this.secuencial_pedido!=newsecuencial_pedido) {
				if(newsecuencial_pedido==null) {
					//newsecuencial_pedido="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCompra:Valor nulo no permitido en columna secuencial_pedido");
					}
				}

				if(newsecuencial_pedido!=null&&newsecuencial_pedido.length()>50) {
					newsecuencial_pedido=newsecuencial_pedido.substring(0,48);
					System.out.println("ParametroCompra:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencial_pedido");
				}

				this.secuencial_pedido=newsecuencial_pedido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial_cotizacion(String newsecuencial_cotizacion)throws Exception
	{
		try {
			if(this.secuencial_cotizacion!=newsecuencial_cotizacion) {
				if(newsecuencial_cotizacion==null) {
					//newsecuencial_cotizacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCompra:Valor nulo no permitido en columna secuencial_cotizacion");
					}
				}

				if(newsecuencial_cotizacion!=null&&newsecuencial_cotizacion.length()>50) {
					newsecuencial_cotizacion=newsecuencial_cotizacion.substring(0,48);
					System.out.println("ParametroCompra:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencial_cotizacion");
				}

				this.secuencial_cotizacion=newsecuencial_cotizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial_produccion(String newsecuencial_produccion)throws Exception
	{
		try {
			if(this.secuencial_produccion!=newsecuencial_produccion) {
				if(newsecuencial_produccion==null) {
					//newsecuencial_produccion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCompra:Valor nulo no permitido en columna secuencial_produccion");
					}
				}

				if(newsecuencial_produccion!=null&&newsecuencial_produccion.length()>50) {
					newsecuencial_produccion=newsecuencial_produccion.substring(0,48);
					System.out.println("ParametroCompra:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencial_produccion");
				}

				this.secuencial_produccion=newsecuencial_produccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_documento(Long newid_tipo_documento)throws Exception
	{
		try {
			if(this.id_tipo_documento!=newid_tipo_documento) {
				if(newid_tipo_documento==null) {
					//newid_tipo_documento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCompra:Valor nulo no permitido en columna id_tipo_documento");
					}
				}

				this.id_tipo_documento=newid_tipo_documento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_movimiento(Long newid_tipo_movimiento)throws Exception
	{
		try {
			if(this.id_tipo_movimiento!=newid_tipo_movimiento) {
				if(newid_tipo_movimiento==null) {
					//newid_tipo_movimiento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCompra:Valor nulo no permitido en columna id_tipo_movimiento");
					}
				}

				this.id_tipo_movimiento=newid_tipo_movimiento;
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
						System.out.println("ParametroCompra:Valor nulo no permitido en columna id_bodega");
					}
				}

				this.id_bodega=newid_bodega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_bodega_reserva(Long newid_bodega_reserva)throws Exception
	{
		try {
			if(this.id_bodega_reserva!=newid_bodega_reserva) {
				if(newid_bodega_reserva==null) {
					//newid_bodega_reserva=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCompra:Valor nulo no permitido en columna id_bodega_reserva");
					}
				}

				this.id_bodega_reserva=newid_bodega_reserva;
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
						System.out.println("ParametroCompra:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
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
						System.out.println("ParametroCompra:Valor nulo no permitido en columna id_embarcador");
					}
				}

				this.id_embarcador=newid_embarcador;
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
						System.out.println("ParametroCompra:Valor nulo no permitido en columna con_centro_costo");
					}
				}

				this.con_centro_costo=newcon_centro_costo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settexto_mail(String newtexto_mail)throws Exception
	{
		try {
			if(this.texto_mail!=newtexto_mail) {
				if(newtexto_mail==null) {
					//newtexto_mail="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCompra:Valor nulo no permitido en columna texto_mail");
					}
				}

				if(newtexto_mail!=null&&newtexto_mail.length()>100) {
					newtexto_mail=newtexto_mail.substring(0,98);
					System.out.println("ParametroCompra:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna texto_mail");
				}

				this.texto_mail=newtexto_mail;
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
						System.out.println("ParametroCompra:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_movimiento_modulo(Long newid_tipo_movimiento_modulo)throws Exception
	{
		try {
			if(this.id_tipo_movimiento_modulo!=newid_tipo_movimiento_modulo) {
				if(newid_tipo_movimiento_modulo==null) {
					//newid_tipo_movimiento_modulo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCompra:Valor nulo no permitido en columna id_tipo_movimiento_modulo");
					}
				}

				this.id_tipo_movimiento_modulo=newid_tipo_movimiento_modulo;
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
						System.out.println("ParametroCompra:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>100) {
					newdescripcion=newdescripcion.substring(0,98);
					System.out.println("ParametroCompra:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_pedido(Long newid_formato_pedido)throws Exception
	{
		try {
			if(this.id_formato_pedido!=newid_formato_pedido) {
				if(newid_formato_pedido==null) {
					//newid_formato_pedido=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCompra:Valor nulo no permitido en columna id_formato_pedido");
					}
				}

				this.id_formato_pedido=newid_formato_pedido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_pedido_pendiente(Long newid_estado_pedido_pendiente)throws Exception
	{
		try {
			if(this.id_estado_pedido_pendiente!=newid_estado_pedido_pendiente) {
				if(newid_estado_pedido_pendiente==null) {
					//newid_estado_pedido_pendiente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCompra:Valor nulo no permitido en columna id_estado_pedido_pendiente");
					}
				}

				this.id_estado_pedido_pendiente=newid_estado_pedido_pendiente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_cotizacion(Long newid_formato_cotizacion)throws Exception
	{
		try {
			if(this.id_formato_cotizacion!=newid_formato_cotizacion) {
				if(newid_formato_cotizacion==null) {
					//newid_formato_cotizacion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCompra:Valor nulo no permitido en columna id_formato_cotizacion");
					}
				}

				this.id_formato_cotizacion=newid_formato_cotizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_pedido_cotizado(Long newid_estado_pedido_cotizado)throws Exception
	{
		try {
			if(this.id_estado_pedido_cotizado!=newid_estado_pedido_cotizado) {
				if(newid_estado_pedido_cotizado==null) {
					//newid_estado_pedido_cotizado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCompra:Valor nulo no permitido en columna id_estado_pedido_cotizado");
					}
				}

				this.id_estado_pedido_cotizado=newid_estado_pedido_cotizado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_autorizacion(Long newid_formato_autorizacion)throws Exception
	{
		try {
			if(this.id_formato_autorizacion!=newid_formato_autorizacion) {
				if(newid_formato_autorizacion==null) {
					//newid_formato_autorizacion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCompra:Valor nulo no permitido en columna id_formato_autorizacion");
					}
				}

				this.id_formato_autorizacion=newid_formato_autorizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_pedido_autorizado(Long newid_estado_pedido_autorizado)throws Exception
	{
		try {
			if(this.id_estado_pedido_autorizado!=newid_estado_pedido_autorizado) {
				if(newid_estado_pedido_autorizado==null) {
					//newid_estado_pedido_autorizado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCompra:Valor nulo no permitido en columna id_estado_pedido_autorizado");
					}
				}

				this.id_estado_pedido_autorizado=newid_estado_pedido_autorizado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_item(Long newid_formato_item)throws Exception
	{
		try {
			if(this.id_formato_item!=newid_formato_item) {
				if(newid_formato_item==null) {
					//newid_formato_item=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCompra:Valor nulo no permitido en columna id_formato_item");
					}
				}

				this.id_formato_item=newid_formato_item;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_pedido_anulado(Long newid_estado_pedido_anulado)throws Exception
	{
		try {
			if(this.id_estado_pedido_anulado!=newid_estado_pedido_anulado) {
				if(newid_estado_pedido_anulado==null) {
					//newid_estado_pedido_anulado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCompra:Valor nulo no permitido en columna id_estado_pedido_anulado");
					}
				}

				this.id_estado_pedido_anulado=newid_estado_pedido_anulado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_prioridad_pedido(Long newid_prioridad_pedido)throws Exception
	{
		try {
			if(this.id_prioridad_pedido!=newid_prioridad_pedido) {
				if(newid_prioridad_pedido==null) {
					//newid_prioridad_pedido=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCompra:Valor nulo no permitido en columna id_prioridad_pedido");
					}
				}

				this.id_prioridad_pedido=newid_prioridad_pedido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_pedido_suspendido(Long newid_estado_pedido_suspendido)throws Exception
	{
		try {
			if(this.id_estado_pedido_suspendido!=newid_estado_pedido_suspendido) {
				if(newid_estado_pedido_suspendido==null) {
					//newid_estado_pedido_suspendido=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCompra:Valor nulo no permitido en columna id_estado_pedido_suspendido");
					}
				}

				this.id_estado_pedido_suspendido=newid_estado_pedido_suspendido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_pedido_regularizado(Long newid_estado_pedido_regularizado)throws Exception
	{
		try {
			if(this.id_estado_pedido_regularizado!=newid_estado_pedido_regularizado) {
				if(newid_estado_pedido_regularizado==null) {
					//newid_estado_pedido_regularizado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCompra:Valor nulo no permitido en columna id_estado_pedido_regularizado");
					}
				}

				this.id_estado_pedido_regularizado=newid_estado_pedido_regularizado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public TipoDocumento getTipoDocumento() {
		return this.tipodocumento;
	}

	public TipoMovimiento getTipoMovimiento() {
		return this.tipomovimiento;
	}

	public Bodega getBodega() {
		return this.bodega;
	}

	public Bodega getBodegaReserva() {
		return this.bodegareserva;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public Embarcador getEmbarcador() {
		return this.embarcador;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public TipoMovimientoModulo getTipoMovimientoModulo() {
		return this.tipomovimientomodulo;
	}

	public Formato getFormatoPedido() {
		return this.formatopedido;
	}

	public EstadoPedido getEstadoPedidoPendiente() {
		return this.estadopedidopendiente;
	}

	public Formato getFormatoCotizacion() {
		return this.formatocotizacion;
	}

	public EstadoPedido getEstadoPedidoCotizado() {
		return this.estadopedidocotizado;
	}

	public Formato getFormatoAutorizacion() {
		return this.formatoautorizacion;
	}

	public EstadoPedido getEstadoPedidoAutorizado() {
		return this.estadopedidoautorizado;
	}

	public Formato getFormatoItem() {
		return this.formatoitem;
	}

	public EstadoPedido getEstadoPedidoAnulado() {
		return this.estadopedidoanulado;
	}

	public PrioridadPedido getPrioridadPedido() {
		return this.prioridadpedido;
	}

	public EstadoPedido getEstadoPedidoSuspendido() {
		return this.estadopedidosuspendido;
	}

	public EstadoPedido getEstadoPedidoRegularizado() {
		return this.estadopedidoregularizado;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettipodocumento_descripcion() {
		return this.tipodocumento_descripcion;
	}

	public String gettipomovimiento_descripcion() {
		return this.tipomovimiento_descripcion;
	}

	public String getbodega_descripcion() {
		return this.bodega_descripcion;
	}

	public String getbodegareserva_descripcion() {
		return this.bodegareserva_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getembarcador_descripcion() {
		return this.embarcador_descripcion;
	}

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String gettipomovimientomodulo_descripcion() {
		return this.tipomovimientomodulo_descripcion;
	}

	public String getformatopedido_descripcion() {
		return this.formatopedido_descripcion;
	}

	public String getestadopedidopendiente_descripcion() {
		return this.estadopedidopendiente_descripcion;
	}

	public String getformatocotizacion_descripcion() {
		return this.formatocotizacion_descripcion;
	}

	public String getestadopedidocotizado_descripcion() {
		return this.estadopedidocotizado_descripcion;
	}

	public String getformatoautorizacion_descripcion() {
		return this.formatoautorizacion_descripcion;
	}

	public String getestadopedidoautorizado_descripcion() {
		return this.estadopedidoautorizado_descripcion;
	}

	public String getformatoitem_descripcion() {
		return this.formatoitem_descripcion;
	}

	public String getestadopedidoanulado_descripcion() {
		return this.estadopedidoanulado_descripcion;
	}

	public String getprioridadpedido_descripcion() {
		return this.prioridadpedido_descripcion;
	}

	public String getestadopedidosuspendido_descripcion() {
		return this.estadopedidosuspendido_descripcion;
	}

	public String getestadopedidoregularizado_descripcion() {
		return this.estadopedidoregularizado_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	public  void  setTipoMovimiento(TipoMovimiento tipomovimiento) {
		try {
			this.tipomovimiento=tipomovimiento;
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


	public  void  setBodegaReserva(Bodega bodegareserva) {
		try {
			this.bodegareserva=bodegareserva;
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


	public  void  setEmbarcador(Embarcador embarcador) {
		try {
			this.embarcador=embarcador;
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


	public  void  setTipoMovimientoModulo(TipoMovimientoModulo tipomovimientomodulo) {
		try {
			this.tipomovimientomodulo=tipomovimientomodulo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoPedido(Formato formatopedido) {
		try {
			this.formatopedido=formatopedido;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoPedidoPendiente(EstadoPedido estadopedidopendiente) {
		try {
			this.estadopedidopendiente=estadopedidopendiente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoCotizacion(Formato formatocotizacion) {
		try {
			this.formatocotizacion=formatocotizacion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoPedidoCotizado(EstadoPedido estadopedidocotizado) {
		try {
			this.estadopedidocotizado=estadopedidocotizado;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoAutorizacion(Formato formatoautorizacion) {
		try {
			this.formatoautorizacion=formatoautorizacion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoPedidoAutorizado(EstadoPedido estadopedidoautorizado) {
		try {
			this.estadopedidoautorizado=estadopedidoautorizado;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoItem(Formato formatoitem) {
		try {
			this.formatoitem=formatoitem;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoPedidoAnulado(EstadoPedido estadopedidoanulado) {
		try {
			this.estadopedidoanulado=estadopedidoanulado;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPrioridadPedido(PrioridadPedido prioridadpedido) {
		try {
			this.prioridadpedido=prioridadpedido;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoPedidoSuspendido(EstadoPedido estadopedidosuspendido) {
		try {
			this.estadopedidosuspendido=estadopedidosuspendido;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoPedidoRegularizado(EstadoPedido estadopedidoregularizado) {
		try {
			this.estadopedidoregularizado=estadopedidoregularizado;
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


	public  void  settipodocumento_descripcion(String tipodocumento_descripcion) {
		try {
			this.tipodocumento_descripcion=tipodocumento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipomovimiento_descripcion(String tipomovimiento_descripcion) {
		try {
			this.tipomovimiento_descripcion=tipomovimiento_descripcion;
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


	public  void  setbodegareserva_descripcion(String bodegareserva_descripcion) {
		try {
			this.bodegareserva_descripcion=bodegareserva_descripcion;
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


	public  void  setembarcador_descripcion(String embarcador_descripcion) {
		try {
			this.embarcador_descripcion=embarcador_descripcion;
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


	public  void  settipomovimientomodulo_descripcion(String tipomovimientomodulo_descripcion) {
		try {
			this.tipomovimientomodulo_descripcion=tipomovimientomodulo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatopedido_descripcion(String formatopedido_descripcion) {
		try {
			this.formatopedido_descripcion=formatopedido_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadopedidopendiente_descripcion(String estadopedidopendiente_descripcion) {
		try {
			this.estadopedidopendiente_descripcion=estadopedidopendiente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatocotizacion_descripcion(String formatocotizacion_descripcion) {
		try {
			this.formatocotizacion_descripcion=formatocotizacion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadopedidocotizado_descripcion(String estadopedidocotizado_descripcion) {
		try {
			this.estadopedidocotizado_descripcion=estadopedidocotizado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatoautorizacion_descripcion(String formatoautorizacion_descripcion) {
		try {
			this.formatoautorizacion_descripcion=formatoautorizacion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadopedidoautorizado_descripcion(String estadopedidoautorizado_descripcion) {
		try {
			this.estadopedidoautorizado_descripcion=estadopedidoautorizado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatoitem_descripcion(String formatoitem_descripcion) {
		try {
			this.formatoitem_descripcion=formatoitem_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadopedidoanulado_descripcion(String estadopedidoanulado_descripcion) {
		try {
			this.estadopedidoanulado_descripcion=estadopedidoanulado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setprioridadpedido_descripcion(String prioridadpedido_descripcion) {
		try {
			this.prioridadpedido_descripcion=prioridadpedido_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadopedidosuspendido_descripcion(String estadopedidosuspendido_descripcion) {
		try {
			this.estadopedidosuspendido_descripcion=estadopedidosuspendido_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadopedidoregularizado_descripcion(String estadopedidoregularizado_descripcion) {
		try {
			this.estadopedidoregularizado_descripcion=estadopedidoregularizado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_tipo_documento_descripcion="";String id_tipo_movimiento_descripcion="";String id_bodega_descripcion="";String id_bodega_reserva_descripcion="";String id_empleado_descripcion="";String id_embarcador_descripcion="";String con_centro_costo_descripcion="";String id_modulo_descripcion="";String id_tipo_movimiento_modulo_descripcion="";String id_formato_pedido_descripcion="";String id_estado_pedido_pendiente_descripcion="";String id_formato_cotizacion_descripcion="";String id_estado_pedido_cotizado_descripcion="";String id_formato_autorizacion_descripcion="";String id_estado_pedido_autorizado_descripcion="";String id_formato_item_descripcion="";String id_estado_pedido_anulado_descripcion="";String id_prioridad_pedido_descripcion="";String id_estado_pedido_suspendido_descripcion="";String id_estado_pedido_regularizado_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_documento_descripcion() {
		return id_tipo_documento_descripcion;
	}
	public String getid_tipo_movimiento_descripcion() {
		return id_tipo_movimiento_descripcion;
	}
	public String getid_bodega_descripcion() {
		return id_bodega_descripcion;
	}
	public String getid_bodega_reserva_descripcion() {
		return id_bodega_reserva_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_embarcador_descripcion() {
		return id_embarcador_descripcion;
	}
	public String getcon_centro_costo_descripcion() {
		return con_centro_costo_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_tipo_movimiento_modulo_descripcion() {
		return id_tipo_movimiento_modulo_descripcion;
	}
	public String getid_formato_pedido_descripcion() {
		return id_formato_pedido_descripcion;
	}
	public String getid_estado_pedido_pendiente_descripcion() {
		return id_estado_pedido_pendiente_descripcion;
	}
	public String getid_formato_cotizacion_descripcion() {
		return id_formato_cotizacion_descripcion;
	}
	public String getid_estado_pedido_cotizado_descripcion() {
		return id_estado_pedido_cotizado_descripcion;
	}
	public String getid_formato_autorizacion_descripcion() {
		return id_formato_autorizacion_descripcion;
	}
	public String getid_estado_pedido_autorizado_descripcion() {
		return id_estado_pedido_autorizado_descripcion;
	}
	public String getid_formato_item_descripcion() {
		return id_formato_item_descripcion;
	}
	public String getid_estado_pedido_anulado_descripcion() {
		return id_estado_pedido_anulado_descripcion;
	}
	public String getid_prioridad_pedido_descripcion() {
		return id_prioridad_pedido_descripcion;
	}
	public String getid_estado_pedido_suspendido_descripcion() {
		return id_estado_pedido_suspendido_descripcion;
	}
	public String getid_estado_pedido_regularizado_descripcion() {
		return id_estado_pedido_regularizado_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	public void setid_tipo_movimiento_descripcion(String newid_tipo_movimiento_descripcion)throws Exception {
		try {
			this.id_tipo_movimiento_descripcion=newid_tipo_movimiento_descripcion;
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
	public void setid_bodega_reserva_descripcion(String newid_bodega_reserva_descripcion)throws Exception {
		try {
			this.id_bodega_reserva_descripcion=newid_bodega_reserva_descripcion;
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
	public void setid_embarcador_descripcion(String newid_embarcador_descripcion)throws Exception {
		try {
			this.id_embarcador_descripcion=newid_embarcador_descripcion;
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
	public void setid_modulo_descripcion(String newid_modulo_descripcion)throws Exception {
		try {
			this.id_modulo_descripcion=newid_modulo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_movimiento_modulo_descripcion(String newid_tipo_movimiento_modulo_descripcion)throws Exception {
		try {
			this.id_tipo_movimiento_modulo_descripcion=newid_tipo_movimiento_modulo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_pedido_descripcion(String newid_formato_pedido_descripcion)throws Exception {
		try {
			this.id_formato_pedido_descripcion=newid_formato_pedido_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_pedido_pendiente_descripcion(String newid_estado_pedido_pendiente_descripcion)throws Exception {
		try {
			this.id_estado_pedido_pendiente_descripcion=newid_estado_pedido_pendiente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_cotizacion_descripcion(String newid_formato_cotizacion_descripcion)throws Exception {
		try {
			this.id_formato_cotizacion_descripcion=newid_formato_cotizacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_pedido_cotizado_descripcion(String newid_estado_pedido_cotizado_descripcion)throws Exception {
		try {
			this.id_estado_pedido_cotizado_descripcion=newid_estado_pedido_cotizado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_autorizacion_descripcion(String newid_formato_autorizacion_descripcion)throws Exception {
		try {
			this.id_formato_autorizacion_descripcion=newid_formato_autorizacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_pedido_autorizado_descripcion(String newid_estado_pedido_autorizado_descripcion)throws Exception {
		try {
			this.id_estado_pedido_autorizado_descripcion=newid_estado_pedido_autorizado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_item_descripcion(String newid_formato_item_descripcion)throws Exception {
		try {
			this.id_formato_item_descripcion=newid_formato_item_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_pedido_anulado_descripcion(String newid_estado_pedido_anulado_descripcion)throws Exception {
		try {
			this.id_estado_pedido_anulado_descripcion=newid_estado_pedido_anulado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_prioridad_pedido_descripcion(String newid_prioridad_pedido_descripcion)throws Exception {
		try {
			this.id_prioridad_pedido_descripcion=newid_prioridad_pedido_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_pedido_suspendido_descripcion(String newid_estado_pedido_suspendido_descripcion)throws Exception {
		try {
			this.id_estado_pedido_suspendido_descripcion=newid_estado_pedido_suspendido_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_pedido_regularizado_descripcion(String newid_estado_pedido_regularizado_descripcion)throws Exception {
		try {
			this.id_estado_pedido_regularizado_descripcion=newid_estado_pedido_regularizado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_documento_descripcion="";this.id_tipo_movimiento_descripcion="";this.id_bodega_descripcion="";this.id_bodega_reserva_descripcion="";this.id_empleado_descripcion="";this.id_embarcador_descripcion="";this.con_centro_costo_descripcion="";this.id_modulo_descripcion="";this.id_tipo_movimiento_modulo_descripcion="";this.id_formato_pedido_descripcion="";this.id_estado_pedido_pendiente_descripcion="";this.id_formato_cotizacion_descripcion="";this.id_estado_pedido_cotizado_descripcion="";this.id_formato_autorizacion_descripcion="";this.id_estado_pedido_autorizado_descripcion="";this.id_formato_item_descripcion="";this.id_estado_pedido_anulado_descripcion="";this.id_prioridad_pedido_descripcion="";this.id_estado_pedido_suspendido_descripcion="";this.id_estado_pedido_regularizado_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

