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
package com.bydan.erp.puntoventa.business.entity;

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
//import com.bydan.erp.puntoventa.util.NotaCreditoPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class NotaCreditoPuntoVenta extends NotaCreditoPuntoVentaAdditional implements Serializable ,Cloneable {//NotaCreditoPuntoVentaAdditional,GeneralEntity
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
	
	private NotaCreditoPuntoVenta notacreditopuntoventaOriginal;
	
	private Map<String, Object> mapNotaCreditoPuntoVenta;
			
	public Map<String, Object> getMapNotaCreditoPuntoVenta() {
		return mapNotaCreditoPuntoVenta;
	}

	public void setMapNotaCreditoPuntoVenta(Map<String, Object> mapNotaCreditoPuntoVenta) {
		this.mapNotaCreditoPuntoVenta = mapNotaCreditoPuntoVenta;
	}
	
	public void inicializarMapNotaCreditoPuntoVenta() {
		this.mapNotaCreditoPuntoVenta = new HashMap<String,Object>();
	}
	
	public void setMapNotaCreditoPuntoVentaValue(String sKey,Object oValue) {
		this.mapNotaCreditoPuntoVenta.put(sKey, oValue);
	}
	
	public Object getMapNotaCreditoPuntoVentaValue(String sKey) {
		return this.mapNotaCreditoPuntoVenta.get(sKey);
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
	private Long id_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_vendedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_caja;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_asiento_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mesa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_factura_punto_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_nota_credito_punto_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NotaCreditoPuntoVentaConstantesFunciones.SREGEXNUMERO_SECUENCIAL,message=NotaCreditoPuntoVentaConstantesFunciones.SMENSAJEREGEXNUMERO_SECUENCIAL)
	private String numero_secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NotaCreditoPuntoVentaConstantesFunciones.SREGEXCODIGO_CLIENTE,message=NotaCreditoPuntoVentaConstantesFunciones.SMENSAJEREGEXCODIGO_CLIENTE)
	private String codigo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NotaCreditoPuntoVentaConstantesFunciones.SREGEXNOMBRE_CLIENTE,message=NotaCreditoPuntoVentaConstantesFunciones.SMENSAJEREGEXNOMBRE_CLIENTE)
	private String nombre_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=NotaCreditoPuntoVentaConstantesFunciones.SREGEXTARJETA_CLIENTE,message=NotaCreditoPuntoVentaConstantesFunciones.SMENSAJEREGEXTARJETA_CLIENTE)
	private String tarjeta_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=NotaCreditoPuntoVentaConstantesFunciones.SREGEXDIRECCION_CLIENTE,message=NotaCreditoPuntoVentaConstantesFunciones.SMENSAJEREGEXDIRECCION_CLIENTE)
	private String direccion_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=NotaCreditoPuntoVentaConstantesFunciones.SREGEXTELEFONO_CLIENTE,message=NotaCreditoPuntoVentaConstantesFunciones.SMENSAJEREGEXTELEFONO_CLIENTE)
	private String telefono_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_sin_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double financiamiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double flete;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double otros;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double sub_total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Usuario usuario;
	public Vendedor vendedor;
	public Cliente cliente;
	public Caja caja;
	public AsientoContable asientocontable;
	public TipoPrecio tipoprecio;
	public Mesa mesa;
	public Formato formato;
	public TipoFacturaPuntoVenta tipofacturapuntoventa;
	public EstadoNotaCredito estadonotacreditopuntoventa;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String usuario_descripcion;
	private String vendedor_descripcion;
	private String cliente_descripcion;
	private String caja_descripcion;
	private String asientocontable_descripcion;
	private String tipoprecio_descripcion;
	private String mesa_descripcion;
	private String formato_descripcion;
	private String tipofacturapuntoventa_descripcion;
	private String estadonotacreditopuntoventa_descripcion;
	
	
	public List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas;
		
	public NotaCreditoPuntoVenta () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.notacreditopuntoventaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_usuario=-1L;
 		this.id_vendedor=-1L;
 		this.id_cliente=-1L;
 		this.id_caja=-1L;
 		this.id_asiento_contable=null;
 		this.id_tipo_precio=-1L;
 		this.id_mesa=-1L;
 		this.id_formato=-1L;
 		this.id_tipo_factura_punto_venta=-1L;
 		this.id_estado_nota_credito_punto_venta=-1L;
 		this.numero_secuencial="";
 		this.codigo_cliente="";
 		this.nombre_cliente="";
 		this.tarjeta_cliente="";
 		this.direccion_cliente="";
 		this.telefono_cliente="";
 		this.fecha=new Date();
 		this.hora=new Time((new Date()).getTime());
 		this.total_iva=0.0;
 		this.total_sin_iva=0.0;
 		this.iva=0.0;
 		this.descuento=0.0;
 		this.financiamiento=0.0;
 		this.flete=0.0;
 		this.ice=0.0;
 		this.otros=0.0;
 		this.sub_total=0.0;
 		this.total=0.0;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.usuario=null;
		this.vendedor=null;
		this.cliente=null;
		this.caja=null;
		this.asientocontable=null;
		this.tipoprecio=null;
		this.mesa=null;
		this.formato=null;
		this.tipofacturapuntoventa=null;
		this.estadonotacreditopuntoventa=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.usuario_descripcion="";
		this.vendedor_descripcion="";
		this.cliente_descripcion="";
		this.caja_descripcion="";
		this.asientocontable_descripcion="";
		this.tipoprecio_descripcion="";
		this.mesa_descripcion="";
		this.formato_descripcion="";
		this.tipofacturapuntoventa_descripcion="";
		this.estadonotacreditopuntoventa_descripcion="";
		
		
		this.detallenotacreditopuntoventas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public NotaCreditoPuntoVenta (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_usuario,Long id_vendedor,Long id_cliente,Long id_caja,Long id_asiento_contable,Long id_tipo_precio,Long id_mesa,Long id_formato,Long id_tipo_factura_punto_venta,Long id_estado_nota_credito_punto_venta,String numero_secuencial,String codigo_cliente,String nombre_cliente,String tarjeta_cliente,String direccion_cliente,String telefono_cliente,Date fecha,Time hora,Double total_iva,Double total_sin_iva,Double iva,Double descuento,Double financiamiento,Double flete,Double ice,Double otros,Double sub_total,Double total) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.notacreditopuntoventaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_usuario=id_usuario;
 		this.id_vendedor=id_vendedor;
 		this.id_cliente=id_cliente;
 		this.id_caja=id_caja;
 		this.id_asiento_contable=id_asiento_contable;
 		this.id_tipo_precio=id_tipo_precio;
 		this.id_mesa=id_mesa;
 		this.id_formato=id_formato;
 		this.id_tipo_factura_punto_venta=id_tipo_factura_punto_venta;
 		this.id_estado_nota_credito_punto_venta=id_estado_nota_credito_punto_venta;
 		this.numero_secuencial=numero_secuencial;
 		this.codigo_cliente=codigo_cliente;
 		this.nombre_cliente=nombre_cliente;
 		this.tarjeta_cliente=tarjeta_cliente;
 		this.direccion_cliente=direccion_cliente;
 		this.telefono_cliente=telefono_cliente;
 		this.fecha=fecha;
 		this.hora=hora;
 		this.total_iva=total_iva;
 		this.total_sin_iva=total_sin_iva;
 		this.iva=iva;
 		this.descuento=descuento;
 		this.financiamiento=financiamiento;
 		this.flete=flete;
 		this.ice=ice;
 		this.otros=otros;
 		this.sub_total=sub_total;
 		this.total=total;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public NotaCreditoPuntoVenta (Long id_empresa,Long id_sucursal,Long id_usuario,Long id_vendedor,Long id_cliente,Long id_caja,Long id_asiento_contable,Long id_tipo_precio,Long id_mesa,Long id_formato,Long id_tipo_factura_punto_venta,Long id_estado_nota_credito_punto_venta,String numero_secuencial,String codigo_cliente,String nombre_cliente,String tarjeta_cliente,String direccion_cliente,String telefono_cliente,Date fecha,Time hora,Double total_iva,Double total_sin_iva,Double iva,Double descuento,Double financiamiento,Double flete,Double ice,Double otros,Double sub_total,Double total) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.notacreditopuntoventaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_usuario=id_usuario;
 		this.id_vendedor=id_vendedor;
 		this.id_cliente=id_cliente;
 		this.id_caja=id_caja;
 		this.id_asiento_contable=id_asiento_contable;
 		this.id_tipo_precio=id_tipo_precio;
 		this.id_mesa=id_mesa;
 		this.id_formato=id_formato;
 		this.id_tipo_factura_punto_venta=id_tipo_factura_punto_venta;
 		this.id_estado_nota_credito_punto_venta=id_estado_nota_credito_punto_venta;
 		this.numero_secuencial=numero_secuencial;
 		this.codigo_cliente=codigo_cliente;
 		this.nombre_cliente=nombre_cliente;
 		this.tarjeta_cliente=tarjeta_cliente;
 		this.direccion_cliente=direccion_cliente;
 		this.telefono_cliente=telefono_cliente;
 		this.fecha=fecha;
 		this.hora=hora;
 		this.total_iva=total_iva;
 		this.total_sin_iva=total_sin_iva;
 		this.iva=iva;
 		this.descuento=descuento;
 		this.financiamiento=financiamiento;
 		this.flete=flete;
 		this.ice=ice;
 		this.otros=otros;
 		this.sub_total=sub_total;
 		this.total=total;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		NotaCreditoPuntoVenta notacreditopuntoventaLocal=null;
		
		if(object!=null) {
			notacreditopuntoventaLocal=(NotaCreditoPuntoVenta)object;
			
			if(notacreditopuntoventaLocal!=null) {
				if(this.getId()!=null && notacreditopuntoventaLocal.getId()!=null) {
					if(this.getId().equals(notacreditopuntoventaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!NotaCreditoPuntoVentaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=NotaCreditoPuntoVentaConstantesFunciones.getNotaCreditoPuntoVentaDescripcion(this);
		} else {
			sDetalle=NotaCreditoPuntoVentaConstantesFunciones.getNotaCreditoPuntoVentaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public NotaCreditoPuntoVenta getNotaCreditoPuntoVentaOriginal() {
		return this.notacreditopuntoventaOriginal;
	}
	
	public void setNotaCreditoPuntoVentaOriginal(NotaCreditoPuntoVenta notacreditopuntoventa) {
		try {
			this.notacreditopuntoventaOriginal=notacreditopuntoventa;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected NotaCreditoPuntoVentaAdditional notacreditopuntoventaAdditional=null;
	
	public NotaCreditoPuntoVentaAdditional getNotaCreditoPuntoVentaAdditional() {
		return this.notacreditopuntoventaAdditional;
	}
	
	public void setNotaCreditoPuntoVentaAdditional(NotaCreditoPuntoVentaAdditional notacreditopuntoventaAdditional) {
		try {
			this.notacreditopuntoventaAdditional=notacreditopuntoventaAdditional;
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
    
	
	public Long getid_usuario() {
		return this.id_usuario;
	}
    
	
	public Long getid_vendedor() {
		return this.id_vendedor;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_caja() {
		return this.id_caja;
	}
    
	
	public Long getid_asiento_contable() {
		return this.id_asiento_contable;
	}
    
	
	public Long getid_tipo_precio() {
		return this.id_tipo_precio;
	}
    
	
	public Long getid_mesa() {
		return this.id_mesa;
	}
    
	
	public Long getid_formato() {
		return this.id_formato;
	}
    
	
	public Long getid_tipo_factura_punto_venta() {
		return this.id_tipo_factura_punto_venta;
	}
    
	
	public Long getid_estado_nota_credito_punto_venta() {
		return this.id_estado_nota_credito_punto_venta;
	}
    
	
	public String getnumero_secuencial() {
		return this.numero_secuencial;
	}
    
	
	public String getcodigo_cliente() {
		return this.codigo_cliente;
	}
    
	
	public String getnombre_cliente() {
		return this.nombre_cliente;
	}
    
	
	public String gettarjeta_cliente() {
		return this.tarjeta_cliente;
	}
    
	
	public String getdireccion_cliente() {
		return this.direccion_cliente;
	}
    
	
	public String gettelefono_cliente() {
		return this.telefono_cliente;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Time gethora() {
		return this.hora;
	}
    
	
	public Double gettotal_iva() {
		return this.total_iva;
	}
    
	
	public Double gettotal_sin_iva() {
		return this.total_sin_iva;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public Double getdescuento() {
		return this.descuento;
	}
    
	
	public Double getfinanciamiento() {
		return this.financiamiento;
	}
    
	
	public Double getflete() {
		return this.flete;
	}
    
	
	public Double getice() {
		return this.ice;
	}
    
	
	public Double getotros() {
		return this.otros;
	}
    
	
	public Double getsub_total() {
		return this.sub_total;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_vendedor(Long newid_vendedor)throws Exception
	{
		try {
			if(this.id_vendedor!=newid_vendedor) {
				if(newid_vendedor==null) {
					//newid_vendedor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna id_vendedor");
					}
				}

				this.id_vendedor=newid_vendedor;
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
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_caja(Long newid_caja)throws Exception
	{
		try {
			if(this.id_caja!=newid_caja) {
				if(newid_caja==null) {
					//newid_caja=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna id_caja");
					}
				}

				this.id_caja=newid_caja;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_asiento_contable(Long newid_asiento_contable) {
		if(this.id_asiento_contable==null&&newid_asiento_contable!=null) {
			this.id_asiento_contable=newid_asiento_contable;
				this.setIsChanged(true);
		}

		if(this.id_asiento_contable!=null&&!this.id_asiento_contable.equals(newid_asiento_contable)) {

			this.id_asiento_contable=newid_asiento_contable;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_precio(Long newid_tipo_precio)throws Exception
	{
		try {
			if(this.id_tipo_precio!=newid_tipo_precio) {
				if(newid_tipo_precio==null) {
					//newid_tipo_precio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna id_tipo_precio");
					}
				}

				this.id_tipo_precio=newid_tipo_precio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_mesa(Long newid_mesa)throws Exception
	{
		try {
			if(this.id_mesa!=newid_mesa) {
				if(newid_mesa==null) {
					//newid_mesa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna id_mesa");
					}
				}

				this.id_mesa=newid_mesa;
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
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna id_formato");
					}
				}

				this.id_formato=newid_formato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_factura_punto_venta(Long newid_tipo_factura_punto_venta)throws Exception
	{
		try {
			if(this.id_tipo_factura_punto_venta!=newid_tipo_factura_punto_venta) {
				if(newid_tipo_factura_punto_venta==null) {
					//newid_tipo_factura_punto_venta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna id_tipo_factura_punto_venta");
					}
				}

				this.id_tipo_factura_punto_venta=newid_tipo_factura_punto_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_nota_credito_punto_venta(Long newid_estado_nota_credito_punto_venta)throws Exception
	{
		try {
			if(this.id_estado_nota_credito_punto_venta!=newid_estado_nota_credito_punto_venta) {
				if(newid_estado_nota_credito_punto_venta==null) {
					//newid_estado_nota_credito_punto_venta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna id_estado_nota_credito_punto_venta");
					}
				}

				this.id_estado_nota_credito_punto_venta=newid_estado_nota_credito_punto_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_secuencial(String newnumero_secuencial)throws Exception
	{
		try {
			if(this.numero_secuencial!=newnumero_secuencial) {
				if(newnumero_secuencial==null) {
					//newnumero_secuencial="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna numero_secuencial");
					}
				}

				if(newnumero_secuencial!=null&&newnumero_secuencial.length()>50) {
					newnumero_secuencial=newnumero_secuencial.substring(0,48);
					System.out.println("NotaCreditoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_secuencial");
				}

				this.numero_secuencial=newnumero_secuencial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_cliente(String newcodigo_cliente)throws Exception
	{
		try {
			if(this.codigo_cliente!=newcodigo_cliente) {
				if(newcodigo_cliente==null) {
					//newcodigo_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna codigo_cliente");
					}
				}

				if(newcodigo_cliente!=null&&newcodigo_cliente.length()>20) {
					newcodigo_cliente=newcodigo_cliente.substring(0,18);
					System.out.println("NotaCreditoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna codigo_cliente");
				}

				this.codigo_cliente=newcodigo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_cliente(String newnombre_cliente)throws Exception
	{
		try {
			if(this.nombre_cliente!=newnombre_cliente) {
				if(newnombre_cliente==null) {
					//newnombre_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna nombre_cliente");
					}
				}

				if(newnombre_cliente!=null&&newnombre_cliente.length()>100) {
					newnombre_cliente=newnombre_cliente.substring(0,98);
					System.out.println("NotaCreditoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_cliente");
				}

				this.nombre_cliente=newnombre_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settarjeta_cliente(String newtarjeta_cliente)throws Exception
	{
		try {
			if(this.tarjeta_cliente!=newtarjeta_cliente) {
				if(newtarjeta_cliente==null) {
					//newtarjeta_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna tarjeta_cliente");
					}
				}

				if(newtarjeta_cliente!=null&&newtarjeta_cliente.length()>50) {
					newtarjeta_cliente=newtarjeta_cliente.substring(0,48);
					System.out.println("NotaCreditoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna tarjeta_cliente");
				}

				this.tarjeta_cliente=newtarjeta_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion_cliente(String newdireccion_cliente)throws Exception
	{
		try {
			if(this.direccion_cliente!=newdireccion_cliente) {
				if(newdireccion_cliente==null) {
					//newdireccion_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna direccion_cliente");
					}
				}

				if(newdireccion_cliente!=null&&newdireccion_cliente.length()>150) {
					newdireccion_cliente=newdireccion_cliente.substring(0,148);
					System.out.println("NotaCreditoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna direccion_cliente");
				}

				this.direccion_cliente=newdireccion_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono_cliente(String newtelefono_cliente)throws Exception
	{
		try {
			if(this.telefono_cliente!=newtelefono_cliente) {
				if(newtelefono_cliente==null) {
					//newtelefono_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna telefono_cliente");
					}
				}

				if(newtelefono_cliente!=null&&newtelefono_cliente.length()>100) {
					newtelefono_cliente=newtelefono_cliente.substring(0,98);
					System.out.println("NotaCreditoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna telefono_cliente");
				}

				this.telefono_cliente=newtelefono_cliente;
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
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora(Time newhora)throws Exception
	{
		try {
			if(this.hora!=newhora) {
				if(newhora==null) {
					//newhora=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna hora");
					}
				}

				this.hora=newhora;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_iva(Double newtotal_iva)throws Exception
	{
		try {
			if(this.total_iva!=newtotal_iva) {
				if(newtotal_iva==null) {
					//newtotal_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna total_iva");
					}
				}

				this.total_iva=newtotal_iva;
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
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna total_sin_iva");
					}
				}

				this.total_sin_iva=newtotal_sin_iva;
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
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna iva");
					}
				}

				this.iva=newiva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento(Double newdescuento)throws Exception
	{
		try {
			if(this.descuento!=newdescuento) {
				if(newdescuento==null) {
					//newdescuento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna descuento");
					}
				}

				this.descuento=newdescuento;
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
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna financiamiento");
					}
				}

				this.financiamiento=newfinanciamiento;
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
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna flete");
					}
				}

				this.flete=newflete;
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
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna ice");
					}
				}

				this.ice=newice;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setotros(Double newotros)throws Exception
	{
		try {
			if(this.otros!=newotros) {
				if(newotros==null) {
					//newotros=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna otros");
					}
				}

				this.otros=newotros;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsub_total(Double newsub_total)throws Exception
	{
		try {
			if(this.sub_total!=newsub_total) {
				if(newsub_total==null) {
					//newsub_total=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna sub_total");
					}
				}

				this.sub_total=newsub_total;
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
						System.out.println("NotaCreditoPuntoVenta:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Caja getCaja() {
		return this.caja;
	}

	public AsientoContable getAsientoContable() {
		return this.asientocontable;
	}

	public TipoPrecio getTipoPrecio() {
		return this.tipoprecio;
	}

	public Mesa getMesa() {
		return this.mesa;
	}

	public Formato getFormato() {
		return this.formato;
	}

	public TipoFacturaPuntoVenta getTipoFacturaPuntoVenta() {
		return this.tipofacturapuntoventa;
	}

	public EstadoNotaCredito getEstadoNotaCreditoPuntoVenta() {
		return this.estadonotacreditopuntoventa;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getusuario_descripcion() {
		return this.usuario_descripcion;
	}

	public String getvendedor_descripcion() {
		return this.vendedor_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String getcaja_descripcion() {
		return this.caja_descripcion;
	}

	public String getasientocontable_descripcion() {
		return this.asientocontable_descripcion;
	}

	public String gettipoprecio_descripcion() {
		return this.tipoprecio_descripcion;
	}

	public String getmesa_descripcion() {
		return this.mesa_descripcion;
	}

	public String getformato_descripcion() {
		return this.formato_descripcion;
	}

	public String gettipofacturapuntoventa_descripcion() {
		return this.tipofacturapuntoventa_descripcion;
	}

	public String getestadonotacreditopuntoventa_descripcion() {
		return this.estadonotacreditopuntoventa_descripcion;
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


	public  void  setUsuario(Usuario usuario) {
		try {
			this.usuario=usuario;
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


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCaja(Caja caja) {
		try {
			this.caja=caja;
		} catch(Exception e) {
			;
		}
	}


	public  void  setAsientoContable(AsientoContable asientocontable) {
		try {
			this.asientocontable=asientocontable;
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


	public  void  setMesa(Mesa mesa) {
		try {
			this.mesa=mesa;
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


	public  void  setTipoFacturaPuntoVenta(TipoFacturaPuntoVenta tipofacturapuntoventa) {
		try {
			this.tipofacturapuntoventa=tipofacturapuntoventa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoNotaCreditoPuntoVenta(EstadoNotaCredito estadonotacreditopuntoventa) {
		try {
			this.estadonotacreditopuntoventa=estadonotacreditopuntoventa;
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


	public  void  setusuario_descripcion(String usuario_descripcion) {
		try {
			this.usuario_descripcion=usuario_descripcion;
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


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcaja_descripcion(String caja_descripcion) {
		try {
			this.caja_descripcion=caja_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setasientocontable_descripcion(String asientocontable_descripcion) {
		try {
			this.asientocontable_descripcion=asientocontable_descripcion;
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


	public  void  setmesa_descripcion(String mesa_descripcion) {
		try {
			this.mesa_descripcion=mesa_descripcion;
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


	public  void  settipofacturapuntoventa_descripcion(String tipofacturapuntoventa_descripcion) {
		try {
			this.tipofacturapuntoventa_descripcion=tipofacturapuntoventa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadonotacreditopuntoventa_descripcion(String estadonotacreditopuntoventa_descripcion) {
		try {
			this.estadonotacreditopuntoventa_descripcion=estadonotacreditopuntoventa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<DetalleNotaCreditoPuntoVenta> getDetalleNotaCreditoPuntoVentas() {
		return this.detallenotacreditopuntoventas;
	}

	
	
	public  void  setDetalleNotaCreditoPuntoVentas(List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas) {
		try {
			this.detallenotacreditopuntoventas=detallenotacreditopuntoventas;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_usuario_descripcion="";String id_vendedor_descripcion="";String id_cliente_descripcion="";String id_caja_descripcion="";String id_asiento_contable_descripcion="";String id_tipo_precio_descripcion="";String id_mesa_descripcion="";String id_formato_descripcion="";String id_tipo_factura_punto_venta_descripcion="";String id_estado_nota_credito_punto_venta_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_usuario_descripcion() {
		return id_usuario_descripcion;
	}
	public String getid_vendedor_descripcion() {
		return id_vendedor_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_caja_descripcion() {
		return id_caja_descripcion;
	}
	public String getid_asiento_contable_descripcion() {
		return id_asiento_contable_descripcion;
	}
	public String getid_tipo_precio_descripcion() {
		return id_tipo_precio_descripcion;
	}
	public String getid_mesa_descripcion() {
		return id_mesa_descripcion;
	}
	public String getid_formato_descripcion() {
		return id_formato_descripcion;
	}
	public String getid_tipo_factura_punto_venta_descripcion() {
		return id_tipo_factura_punto_venta_descripcion;
	}
	public String getid_estado_nota_credito_punto_venta_descripcion() {
		return id_estado_nota_credito_punto_venta_descripcion;
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
	public void setid_usuario_descripcion(String newid_usuario_descripcion)throws Exception {
		try {
			this.id_usuario_descripcion=newid_usuario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_vendedor_descripcion(String newid_vendedor_descripcion)throws Exception {
		try {
			this.id_vendedor_descripcion=newid_vendedor_descripcion;
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
	public void setid_caja_descripcion(String newid_caja_descripcion)throws Exception {
		try {
			this.id_caja_descripcion=newid_caja_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_asiento_contable_descripcion(String newid_asiento_contable_descripcion)throws Exception {
		try {
			this.id_asiento_contable_descripcion=newid_asiento_contable_descripcion;
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
	public void setid_mesa_descripcion(String newid_mesa_descripcion)throws Exception {
		try {
			this.id_mesa_descripcion=newid_mesa_descripcion;
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
	public void setid_tipo_factura_punto_venta_descripcion(String newid_tipo_factura_punto_venta_descripcion)throws Exception {
		try {
			this.id_tipo_factura_punto_venta_descripcion=newid_tipo_factura_punto_venta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_nota_credito_punto_venta_descripcion(String newid_estado_nota_credito_punto_venta_descripcion)throws Exception {
		try {
			this.id_estado_nota_credito_punto_venta_descripcion=newid_estado_nota_credito_punto_venta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_usuario_descripcion="";this.id_vendedor_descripcion="";this.id_cliente_descripcion="";this.id_caja_descripcion="";this.id_asiento_contable_descripcion="";this.id_tipo_precio_descripcion="";this.id_mesa_descripcion="";this.id_formato_descripcion="";this.id_tipo_factura_punto_venta_descripcion="";this.id_estado_nota_credito_punto_venta_descripcion="";
	}
	
	
	Object detallenotacreditopuntoventasDescripcionReporte;
	
	
	public Object getdetallenotacreditopuntoventasDescripcionReporte() {
		return detallenotacreditopuntoventasDescripcionReporte;
	}

	
	
	public  void  setdetallenotacreditopuntoventasDescripcionReporte(Object detallenotacreditopuntoventas) {
		try {
			this.detallenotacreditopuntoventasDescripcionReporte=detallenotacreditopuntoventas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

