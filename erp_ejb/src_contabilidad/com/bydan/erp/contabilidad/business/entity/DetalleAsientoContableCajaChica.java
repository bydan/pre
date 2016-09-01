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
package com.bydan.erp.contabilidad.business.entity;

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
//import com.bydan.erp.contabilidad.util.DetalleAsientoContableCajaChicaConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class DetalleAsientoContableCajaChica extends DetalleAsientoContableCajaChicaAdditional implements Serializable ,Cloneable {//DetalleAsientoContableCajaChicaAdditional,GeneralEntity
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
	
	private DetalleAsientoContableCajaChica detalleasientocontablecajachicaOriginal;
	
	private Map<String, Object> mapDetalleAsientoContableCajaChica;
			
	public Map<String, Object> getMapDetalleAsientoContableCajaChica() {
		return mapDetalleAsientoContableCajaChica;
	}

	public void setMapDetalleAsientoContableCajaChica(Map<String, Object> mapDetalleAsientoContableCajaChica) {
		this.mapDetalleAsientoContableCajaChica = mapDetalleAsientoContableCajaChica;
	}
	
	public void inicializarMapDetalleAsientoContableCajaChica() {
		this.mapDetalleAsientoContableCajaChica = new HashMap<String,Object>();
	}
	
	public void setMapDetalleAsientoContableCajaChicaValue(String sKey,Object oValue) {
		this.mapDetalleAsientoContableCajaChica.put(sKey, oValue);
	}
	
	public Object getMapDetalleAsientoContableCajaChicaValue(String sKey) {
		return this.mapDetalleAsientoContableCajaChica.get(sKey);
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
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_asiento_contable_caja_chica;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_gasto_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_proveedor;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_asiento_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=DetalleAsientoContableCajaChicaConstantesFunciones.SREGEXDETALLE,message=DetalleAsientoContableCajaChicaConstantesFunciones.SMENSAJEREGEXDETALLE)
	private String detalle;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_bien_tarifa12;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_servicio_tarifa12;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_bien_tarifa0;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_servicio_tarifa0;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_bien_ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_servicio_ice;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_centro_costo;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_tipo_cambio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_tipo_transaccion_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Modulo modulo;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Anio anio;
	public Mes mes;
	public AsientoContableCajaChica asientocontablecajachica;
	public TipoGastoEmpresa tipogastoempresa;
	public Transaccion transaccion;
	public Factura factura;
	public AsientoContable asientocontable;
	public CentroCosto centrocosto;
	public TipoCambio tipocambio;
	public TipoTransaccionModulo tipotransaccionmodulo;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String modulo_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	private String asientocontablecajachica_descripcion;
	private String tipogastoempresa_descripcion;
	private String transaccion_descripcion;
	private String factura_descripcion;
	private String asientocontable_descripcion;
	private String centrocosto_descripcion;
	private String tipocambio_descripcion;
	private String tipotransaccionmodulo_descripcion;
	
	
		
	public DetalleAsientoContableCajaChica () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detalleasientocontablecajachicaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_modulo=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_anio=null;
 		this.id_mes=null;
 		this.id_asiento_contable_caja_chica=-1L;
 		this.id_tipo_gasto_empresa=-1L;
 		this.fecha_emision=new Date();
 		this.id_transaccion=-1L;
 		this.id_factura=null;
 		this.es_proveedor=false;
 		this.id_asiento_contable=null;
 		this.detalle="";
 		this.valor_bien_tarifa12=0.0;
 		this.valor_servicio_tarifa12=0.0;
 		this.porcentaje_iva=0.0;
 		this.valor_bien_tarifa0=0.0;
 		this.valor_servicio_tarifa0=0.0;
 		this.valor_iva=0.0;
 		this.valor_bien_ice=0.0;
 		this.valor_servicio_ice=0.0;
 		this.id_centro_costo=null;
 		this.id_tipo_cambio=null;
 		this.id_tipo_transaccion_modulo=null;
 		this.fecha=new Date();
		
		
		this.empresa=null;
		this.sucursal=null;
		this.modulo=null;
		this.ejercicio=null;
		this.periodo=null;
		this.anio=null;
		this.mes=null;
		this.asientocontablecajachica=null;
		this.tipogastoempresa=null;
		this.transaccion=null;
		this.factura=null;
		this.asientocontable=null;
		this.centrocosto=null;
		this.tipocambio=null;
		this.tipotransaccionmodulo=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.modulo_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		this.asientocontablecajachica_descripcion="";
		this.tipogastoempresa_descripcion="";
		this.transaccion_descripcion="";
		this.factura_descripcion="";
		this.asientocontable_descripcion="";
		this.centrocosto_descripcion="";
		this.tipocambio_descripcion="";
		this.tipotransaccionmodulo_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetalleAsientoContableCajaChica (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_modulo,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Long id_asiento_contable_caja_chica,Long id_tipo_gasto_empresa,Date fecha_emision,Long id_transaccion,Long id_factura,Boolean es_proveedor,Long id_asiento_contable,String detalle,Double valor_bien_tarifa12,Double valor_servicio_tarifa12,Double porcentaje_iva,Double valor_bien_tarifa0,Double valor_servicio_tarifa0,Double valor_iva,Double valor_bien_ice,Double valor_servicio_ice,Long id_centro_costo,Long id_tipo_cambio,Long id_tipo_transaccion_modulo,Date fecha) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleasientocontablecajachicaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_modulo=id_modulo;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_asiento_contable_caja_chica=id_asiento_contable_caja_chica;
 		this.id_tipo_gasto_empresa=id_tipo_gasto_empresa;
 		this.fecha_emision=fecha_emision;
 		this.id_transaccion=id_transaccion;
 		this.id_factura=id_factura;
 		this.es_proveedor=es_proveedor;
 		this.id_asiento_contable=id_asiento_contable;
 		this.detalle=detalle;
 		this.valor_bien_tarifa12=valor_bien_tarifa12;
 		this.valor_servicio_tarifa12=valor_servicio_tarifa12;
 		this.porcentaje_iva=porcentaje_iva;
 		this.valor_bien_tarifa0=valor_bien_tarifa0;
 		this.valor_servicio_tarifa0=valor_servicio_tarifa0;
 		this.valor_iva=valor_iva;
 		this.valor_bien_ice=valor_bien_ice;
 		this.valor_servicio_ice=valor_servicio_ice;
 		this.id_centro_costo=id_centro_costo;
 		this.id_tipo_cambio=id_tipo_cambio;
 		this.id_tipo_transaccion_modulo=id_tipo_transaccion_modulo;
 		this.fecha=fecha;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetalleAsientoContableCajaChica (Long id_empresa,Long id_sucursal,Long id_modulo,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Long id_asiento_contable_caja_chica,Long id_tipo_gasto_empresa,Date fecha_emision,Long id_transaccion,Long id_factura,Boolean es_proveedor,Long id_asiento_contable,String detalle,Double valor_bien_tarifa12,Double valor_servicio_tarifa12,Double porcentaje_iva,Double valor_bien_tarifa0,Double valor_servicio_tarifa0,Double valor_iva,Double valor_bien_ice,Double valor_servicio_ice,Long id_centro_costo,Long id_tipo_cambio,Long id_tipo_transaccion_modulo,Date fecha) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleasientocontablecajachicaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_modulo=id_modulo;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_asiento_contable_caja_chica=id_asiento_contable_caja_chica;
 		this.id_tipo_gasto_empresa=id_tipo_gasto_empresa;
 		this.fecha_emision=fecha_emision;
 		this.id_transaccion=id_transaccion;
 		this.id_factura=id_factura;
 		this.es_proveedor=es_proveedor;
 		this.id_asiento_contable=id_asiento_contable;
 		this.detalle=detalle;
 		this.valor_bien_tarifa12=valor_bien_tarifa12;
 		this.valor_servicio_tarifa12=valor_servicio_tarifa12;
 		this.porcentaje_iva=porcentaje_iva;
 		this.valor_bien_tarifa0=valor_bien_tarifa0;
 		this.valor_servicio_tarifa0=valor_servicio_tarifa0;
 		this.valor_iva=valor_iva;
 		this.valor_bien_ice=valor_bien_ice;
 		this.valor_servicio_ice=valor_servicio_ice;
 		this.id_centro_costo=id_centro_costo;
 		this.id_tipo_cambio=id_tipo_cambio;
 		this.id_tipo_transaccion_modulo=id_tipo_transaccion_modulo;
 		this.fecha=fecha;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetalleAsientoContableCajaChica detalleasientocontablecajachicaLocal=null;
		
		if(object!=null) {
			detalleasientocontablecajachicaLocal=(DetalleAsientoContableCajaChica)object;
			
			if(detalleasientocontablecajachicaLocal!=null) {
				if(this.getId()!=null && detalleasientocontablecajachicaLocal.getId()!=null) {
					if(this.getId().equals(detalleasientocontablecajachicaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetalleAsientoContableCajaChicaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetalleAsientoContableCajaChicaConstantesFunciones.getDetalleAsientoContableCajaChicaDescripcion(this);
		} else {
			sDetalle=DetalleAsientoContableCajaChicaConstantesFunciones.getDetalleAsientoContableCajaChicaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetalleAsientoContableCajaChica getDetalleAsientoContableCajaChicaOriginal() {
		return this.detalleasientocontablecajachicaOriginal;
	}
	
	public void setDetalleAsientoContableCajaChicaOriginal(DetalleAsientoContableCajaChica detalleasientocontablecajachica) {
		try {
			this.detalleasientocontablecajachicaOriginal=detalleasientocontablecajachica;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetalleAsientoContableCajaChicaAdditional detalleasientocontablecajachicaAdditional=null;
	
	public DetalleAsientoContableCajaChicaAdditional getDetalleAsientoContableCajaChicaAdditional() {
		return this.detalleasientocontablecajachicaAdditional;
	}
	
	public void setDetalleAsientoContableCajaChicaAdditional(DetalleAsientoContableCajaChicaAdditional detalleasientocontablecajachicaAdditional) {
		try {
			this.detalleasientocontablecajachicaAdditional=detalleasientocontablecajachicaAdditional;
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
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public Long getid_asiento_contable_caja_chica() {
		return this.id_asiento_contable_caja_chica;
	}
    
	
	public Long getid_tipo_gasto_empresa() {
		return this.id_tipo_gasto_empresa;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Long getid_transaccion() {
		return this.id_transaccion;
	}
    
	
	public Long getid_factura() {
		return this.id_factura;
	}
    
	
	public Boolean getes_proveedor() {
		return this.es_proveedor;
	}
    
	
	public Long getid_asiento_contable() {
		return this.id_asiento_contable;
	}
    
	
	public String getdetalle() {
		return this.detalle;
	}
    
	
	public Double getvalor_bien_tarifa12() {
		return this.valor_bien_tarifa12;
	}
    
	
	public Double getvalor_servicio_tarifa12() {
		return this.valor_servicio_tarifa12;
	}
    
	
	public Double getporcentaje_iva() {
		return this.porcentaje_iva;
	}
    
	
	public Double getvalor_bien_tarifa0() {
		return this.valor_bien_tarifa0;
	}
    
	
	public Double getvalor_servicio_tarifa0() {
		return this.valor_servicio_tarifa0;
	}
    
	
	public Double getvalor_iva() {
		return this.valor_iva;
	}
    
	
	public Double getvalor_bien_ice() {
		return this.valor_bien_ice;
	}
    
	
	public Double getvalor_servicio_ice() {
		return this.valor_servicio_ice;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Long getid_tipo_cambio() {
		return this.id_tipo_cambio;
	}
    
	
	public Long getid_tipo_transaccion_modulo() {
		return this.id_tipo_transaccion_modulo;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleAsientoContableCajaChica:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("DetalleAsientoContableCajaChica:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("DetalleAsientoContableCajaChica:Valor nulo no permitido en columna id_modulo");
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
						System.out.println("DetalleAsientoContableCajaChica:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("DetalleAsientoContableCajaChica:Valor nulo no permitido en columna id_periodo");
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
    
	public void setid_asiento_contable_caja_chica(Long newid_asiento_contable_caja_chica)throws Exception
	{
		try {
			if(this.id_asiento_contable_caja_chica!=newid_asiento_contable_caja_chica) {
				if(newid_asiento_contable_caja_chica==null) {
					//newid_asiento_contable_caja_chica=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleAsientoContableCajaChica:Valor nulo no permitido en columna id_asiento_contable_caja_chica");
					}
				}

				this.id_asiento_contable_caja_chica=newid_asiento_contable_caja_chica;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_gasto_empresa(Long newid_tipo_gasto_empresa)throws Exception
	{
		try {
			if(this.id_tipo_gasto_empresa!=newid_tipo_gasto_empresa) {
				if(newid_tipo_gasto_empresa==null) {
					//newid_tipo_gasto_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleAsientoContableCajaChica:Valor nulo no permitido en columna id_tipo_gasto_empresa");
					}
				}

				this.id_tipo_gasto_empresa=newid_tipo_gasto_empresa;
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
						System.out.println("DetalleAsientoContableCajaChica:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
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
						System.out.println("DetalleAsientoContableCajaChica:Valor nulo no permitido en columna id_transaccion");
					}
				}

				this.id_transaccion=newid_transaccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_factura(Long newid_factura) {
		if(this.id_factura==null&&newid_factura!=null) {
			this.id_factura=newid_factura;
				this.setIsChanged(true);
		}

		if(this.id_factura!=null&&!this.id_factura.equals(newid_factura)) {

			this.id_factura=newid_factura;
				this.setIsChanged(true);
		}
	}
    
	public void setes_proveedor(Boolean newes_proveedor)throws Exception
	{
		try {
			if(this.es_proveedor!=newes_proveedor) {
				if(newes_proveedor==null) {
					//newes_proveedor=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleAsientoContableCajaChica:Valor nulo no permitido en columna es_proveedor");
					}
				}

				this.es_proveedor=newes_proveedor;
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
    
	public void setdetalle(String newdetalle)throws Exception
	{
		try {
			if(this.detalle!=newdetalle) {
				if(newdetalle==null) {
					//newdetalle="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleAsientoContableCajaChica:Valor nulo no permitido en columna detalle");
					}
				}

				if(newdetalle!=null&&newdetalle.length()>250) {
					newdetalle=newdetalle.substring(0,248);
					System.out.println("DetalleAsientoContableCajaChica:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna detalle");
				}

				this.detalle=newdetalle;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_bien_tarifa12(Double newvalor_bien_tarifa12)throws Exception
	{
		try {
			if(this.valor_bien_tarifa12!=newvalor_bien_tarifa12) {
				if(newvalor_bien_tarifa12==null) {
					//newvalor_bien_tarifa12=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleAsientoContableCajaChica:Valor nulo no permitido en columna valor_bien_tarifa12");
					}
				}

				this.valor_bien_tarifa12=newvalor_bien_tarifa12;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_servicio_tarifa12(Double newvalor_servicio_tarifa12)throws Exception
	{
		try {
			if(this.valor_servicio_tarifa12!=newvalor_servicio_tarifa12) {
				if(newvalor_servicio_tarifa12==null) {
					//newvalor_servicio_tarifa12=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleAsientoContableCajaChica:Valor nulo no permitido en columna valor_servicio_tarifa12");
					}
				}

				this.valor_servicio_tarifa12=newvalor_servicio_tarifa12;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_iva(Double newporcentaje_iva)throws Exception
	{
		try {
			if(this.porcentaje_iva!=newporcentaje_iva) {
				if(newporcentaje_iva==null) {
					//newporcentaje_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleAsientoContableCajaChica:Valor nulo no permitido en columna porcentaje_iva");
					}
				}

				this.porcentaje_iva=newporcentaje_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_bien_tarifa0(Double newvalor_bien_tarifa0)throws Exception
	{
		try {
			if(this.valor_bien_tarifa0!=newvalor_bien_tarifa0) {
				if(newvalor_bien_tarifa0==null) {
					//newvalor_bien_tarifa0=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleAsientoContableCajaChica:Valor nulo no permitido en columna valor_bien_tarifa0");
					}
				}

				this.valor_bien_tarifa0=newvalor_bien_tarifa0;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_servicio_tarifa0(Double newvalor_servicio_tarifa0)throws Exception
	{
		try {
			if(this.valor_servicio_tarifa0!=newvalor_servicio_tarifa0) {
				if(newvalor_servicio_tarifa0==null) {
					//newvalor_servicio_tarifa0=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleAsientoContableCajaChica:Valor nulo no permitido en columna valor_servicio_tarifa0");
					}
				}

				this.valor_servicio_tarifa0=newvalor_servicio_tarifa0;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_iva(Double newvalor_iva)throws Exception
	{
		try {
			if(this.valor_iva!=newvalor_iva) {
				if(newvalor_iva==null) {
					//newvalor_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleAsientoContableCajaChica:Valor nulo no permitido en columna valor_iva");
					}
				}

				this.valor_iva=newvalor_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_bien_ice(Double newvalor_bien_ice)throws Exception
	{
		try {
			if(this.valor_bien_ice!=newvalor_bien_ice) {
				if(newvalor_bien_ice==null) {
					//newvalor_bien_ice=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleAsientoContableCajaChica:Valor nulo no permitido en columna valor_bien_ice");
					}
				}

				this.valor_bien_ice=newvalor_bien_ice;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_servicio_ice(Double newvalor_servicio_ice)throws Exception
	{
		try {
			if(this.valor_servicio_ice!=newvalor_servicio_ice) {
				if(newvalor_servicio_ice==null) {
					//newvalor_servicio_ice=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleAsientoContableCajaChica:Valor nulo no permitido en columna valor_servicio_ice");
					}
				}

				this.valor_servicio_ice=newvalor_servicio_ice;
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
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleAsientoContableCajaChica:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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

	public Modulo getModulo() {
		return this.modulo;
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

	public AsientoContableCajaChica getAsientoContableCajaChica() {
		return this.asientocontablecajachica;
	}

	public TipoGastoEmpresa getTipoGastoEmpresa() {
		return this.tipogastoempresa;
	}

	public Transaccion getTransaccion() {
		return this.transaccion;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public AsientoContable getAsientoContable() {
		return this.asientocontable;
	}

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
	}

	public TipoCambio getTipoCambio() {
		return this.tipocambio;
	}

	public TipoTransaccionModulo getTipoTransaccionModulo() {
		return this.tipotransaccionmodulo;
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

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
	}

	public String getasientocontablecajachica_descripcion() {
		return this.asientocontablecajachica_descripcion;
	}

	public String gettipogastoempresa_descripcion() {
		return this.tipogastoempresa_descripcion;
	}

	public String gettransaccion_descripcion() {
		return this.transaccion_descripcion;
	}

	public String getfactura_descripcion() {
		return this.factura_descripcion;
	}

	public String getasientocontable_descripcion() {
		return this.asientocontable_descripcion;
	}

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
	}

	public String gettipocambio_descripcion() {
		return this.tipocambio_descripcion;
	}

	public String gettipotransaccionmodulo_descripcion() {
		return this.tipotransaccionmodulo_descripcion;
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


	public  void  setAsientoContableCajaChica(AsientoContableCajaChica asientocontablecajachica) {
		try {
			this.asientocontablecajachica=asientocontablecajachica;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoGastoEmpresa(TipoGastoEmpresa tipogastoempresa) {
		try {
			this.tipogastoempresa=tipogastoempresa;
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


	public  void  setFactura(Factura factura) {
		try {
			this.factura=factura;
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


	public  void  setCentroCosto(CentroCosto centrocosto) {
		try {
			this.centrocosto=centrocosto;
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


	public  void  setTipoTransaccionModulo(TipoTransaccionModulo tipotransaccionmodulo) {
		try {
			this.tipotransaccionmodulo=tipotransaccionmodulo;
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


	public  void  setasientocontablecajachica_descripcion(String asientocontablecajachica_descripcion) {
		try {
			this.asientocontablecajachica_descripcion=asientocontablecajachica_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipogastoempresa_descripcion(String tipogastoempresa_descripcion) {
		try {
			this.tipogastoempresa_descripcion=tipogastoempresa_descripcion;
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


	public  void  setfactura_descripcion(String factura_descripcion) {
		try {
			this.factura_descripcion=factura_descripcion;
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


	public  void  setcentrocosto_descripcion(String centrocosto_descripcion) {
		try {
			this.centrocosto_descripcion=centrocosto_descripcion;
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


	public  void  settipotransaccionmodulo_descripcion(String tipotransaccionmodulo_descripcion) {
		try {
			this.tipotransaccionmodulo_descripcion=tipotransaccionmodulo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_modulo_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";String id_asiento_contable_caja_chica_descripcion="";String id_tipo_gasto_empresa_descripcion="";String id_transaccion_descripcion="";String id_factura_descripcion="";String es_proveedor_descripcion="";String id_asiento_contable_descripcion="";String id_centro_costo_descripcion="";String id_tipo_cambio_descripcion="";String id_tipo_transaccion_modulo_descripcion="";
	
	
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
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
	}
	public String getid_asiento_contable_caja_chica_descripcion() {
		return id_asiento_contable_caja_chica_descripcion;
	}
	public String getid_tipo_gasto_empresa_descripcion() {
		return id_tipo_gasto_empresa_descripcion;
	}
	public String getid_transaccion_descripcion() {
		return id_transaccion_descripcion;
	}
	public String getid_factura_descripcion() {
		return id_factura_descripcion;
	}
	public String getes_proveedor_descripcion() {
		return es_proveedor_descripcion;
	}
	public String getid_asiento_contable_descripcion() {
		return id_asiento_contable_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
	}
	public String getid_tipo_cambio_descripcion() {
		return id_tipo_cambio_descripcion;
	}
	public String getid_tipo_transaccion_modulo_descripcion() {
		return id_tipo_transaccion_modulo_descripcion;
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
	public void setid_asiento_contable_caja_chica_descripcion(String newid_asiento_contable_caja_chica_descripcion)throws Exception {
		try {
			this.id_asiento_contable_caja_chica_descripcion=newid_asiento_contable_caja_chica_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_gasto_empresa_descripcion(String newid_tipo_gasto_empresa_descripcion)throws Exception {
		try {
			this.id_tipo_gasto_empresa_descripcion=newid_tipo_gasto_empresa_descripcion;
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
	public void setid_factura_descripcion(String newid_factura_descripcion) {
		this.id_factura_descripcion=newid_factura_descripcion;
	}
	public void setes_proveedor_descripcion(String newes_proveedor_descripcion)throws Exception {
		try {
			this.es_proveedor_descripcion=newes_proveedor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_asiento_contable_descripcion(String newid_asiento_contable_descripcion) {
		this.id_asiento_contable_descripcion=newid_asiento_contable_descripcion;
	}
	public void setid_centro_costo_descripcion(String newid_centro_costo_descripcion) {
		this.id_centro_costo_descripcion=newid_centro_costo_descripcion;
	}
	public void setid_tipo_cambio_descripcion(String newid_tipo_cambio_descripcion) {
		this.id_tipo_cambio_descripcion=newid_tipo_cambio_descripcion;
	}
	public void setid_tipo_transaccion_modulo_descripcion(String newid_tipo_transaccion_modulo_descripcion) {
		this.id_tipo_transaccion_modulo_descripcion=newid_tipo_transaccion_modulo_descripcion;
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_modulo_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";this.id_asiento_contable_caja_chica_descripcion="";this.id_tipo_gasto_empresa_descripcion="";this.id_transaccion_descripcion="";this.id_factura_descripcion="";this.es_proveedor_descripcion="";this.id_asiento_contable_descripcion="";this.id_centro_costo_descripcion="";this.id_tipo_cambio_descripcion="";this.id_tipo_transaccion_modulo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

