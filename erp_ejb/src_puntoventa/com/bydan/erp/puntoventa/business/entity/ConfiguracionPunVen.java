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



import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesValidacion;
//import com.bydan.erp.puntoventa.util.ConfiguracionPunVenConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class ConfiguracionPunVen extends ConfiguracionPunVenAdditional implements Serializable ,Cloneable {//ConfiguracionPunVenAdditional,GeneralEntity
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
	
	private ConfiguracionPunVen configuracionpunvenOriginal;
	
	private Map<String, Object> mapConfiguracionPunVen;
			
	public Map<String, Object> getMapConfiguracionPunVen() {
		return mapConfiguracionPunVen;
	}

	public void setMapConfiguracionPunVen(Map<String, Object> mapConfiguracionPunVen) {
		this.mapConfiguracionPunVen = mapConfiguracionPunVen;
	}
	
	public void inicializarMapConfiguracionPunVen() {
		this.mapConfiguracionPunVen = new HashMap<String,Object>();
	}
	
	public void setMapConfiguracionPunVenValue(String sKey,Object oValue) {
		this.mapConfiguracionPunVen.put(sKey, oValue);
	}
	
	public Object getMapConfiguracionPunVenValue(String sKey) {
		return this.mapConfiguracionPunVen.get(sKey);
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
	private Long id_bodega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_efectivo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_otros;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente_consumidor_final;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_documento_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_documento_nota_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_documento_nota_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_documento_tarjeta_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_nota_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_nota_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_nota_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_nota_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_cuenta_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_cuenta_nota_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_cuenta_nota_credito;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Bodega bodega;
	public CuentaContable cuentacontableefectivo;
	public CuentaContable cuentacontableice;
	public CuentaContable cuentacontableotros;
	public Cliente clienteconsumidorfinal;
	public TipoDocumento tipodocumentofactura;
	public TipoDocumento tipodocumentonotaventa;
	public TipoDocumento tipodocumentonotacredito;
	public TipoDocumento tipodocumentotarjetacredito;
	public Formato formatofactura;
	public Formato formatonotaventa;
	public Formato formatonotacredito;
	public Transaccion transaccionfactura;
	public Transaccion transaccionnotaventa;
	public Transaccion transaccionnotacredito;
	public Transaccion transaccioncuentafactura;
	public Transaccion transaccioncuentanotaventa;
	public Transaccion transaccioncuentanotacredito;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String bodega_descripcion;
	private String cuentacontableefectivo_descripcion;
	private String cuentacontableice_descripcion;
	private String cuentacontableotros_descripcion;
	private String clienteconsumidorfinal_descripcion;
	private String tipodocumentofactura_descripcion;
	private String tipodocumentonotaventa_descripcion;
	private String tipodocumentonotacredito_descripcion;
	private String tipodocumentotarjetacredito_descripcion;
	private String formatofactura_descripcion;
	private String formatonotaventa_descripcion;
	private String formatonotacredito_descripcion;
	private String transaccionfactura_descripcion;
	private String transaccionnotaventa_descripcion;
	private String transaccionnotacredito_descripcion;
	private String transaccioncuentafactura_descripcion;
	private String transaccioncuentanotaventa_descripcion;
	private String transaccioncuentanotacredito_descripcion;
	
	
		
	public ConfiguracionPunVen () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.configuracionpunvenOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_bodega=-1L;
 		this.id_cuenta_contable_efectivo=-1L;
 		this.id_cuenta_contable_ice=-1L;
 		this.id_cuenta_contable_otros=-1L;
 		this.id_cliente_consumidor_final=-1L;
 		this.id_tipo_documento_factura=-1L;
 		this.id_tipo_documento_nota_venta=-1L;
 		this.id_tipo_documento_nota_credito=-1L;
 		this.id_tipo_documento_tarjeta_credito=-1L;
 		this.id_formato_factura=-1L;
 		this.id_formato_nota_venta=-1L;
 		this.id_formato_nota_credito=-1L;
 		this.id_transaccion_factura=-1L;
 		this.id_transaccion_nota_venta=-1L;
 		this.id_transaccion_nota_credito=-1L;
 		this.id_transaccion_cuenta_factura=-1L;
 		this.id_transaccion_cuenta_nota_venta=-1L;
 		this.id_transaccion_cuenta_nota_credito=-1L;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.bodega=null;
		this.cuentacontableefectivo=null;
		this.cuentacontableice=null;
		this.cuentacontableotros=null;
		this.clienteconsumidorfinal=null;
		this.tipodocumentofactura=null;
		this.tipodocumentonotaventa=null;
		this.tipodocumentonotacredito=null;
		this.tipodocumentotarjetacredito=null;
		this.formatofactura=null;
		this.formatonotaventa=null;
		this.formatonotacredito=null;
		this.transaccionfactura=null;
		this.transaccionnotaventa=null;
		this.transaccionnotacredito=null;
		this.transaccioncuentafactura=null;
		this.transaccioncuentanotaventa=null;
		this.transaccioncuentanotacredito=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.bodega_descripcion="";
		this.cuentacontableefectivo_descripcion="";
		this.cuentacontableice_descripcion="";
		this.cuentacontableotros_descripcion="";
		this.clienteconsumidorfinal_descripcion="";
		this.tipodocumentofactura_descripcion="";
		this.tipodocumentonotaventa_descripcion="";
		this.tipodocumentonotacredito_descripcion="";
		this.tipodocumentotarjetacredito_descripcion="";
		this.formatofactura_descripcion="";
		this.formatonotaventa_descripcion="";
		this.formatonotacredito_descripcion="";
		this.transaccionfactura_descripcion="";
		this.transaccionnotaventa_descripcion="";
		this.transaccionnotacredito_descripcion="";
		this.transaccioncuentafactura_descripcion="";
		this.transaccioncuentanotaventa_descripcion="";
		this.transaccioncuentanotacredito_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ConfiguracionPunVen (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_bodega,Long id_cuenta_contable_efectivo,Long id_cuenta_contable_ice,Long id_cuenta_contable_otros,Long id_cliente_consumidor_final,Long id_tipo_documento_factura,Long id_tipo_documento_nota_venta,Long id_tipo_documento_nota_credito,Long id_tipo_documento_tarjeta_credito,Long id_formato_factura,Long id_formato_nota_venta,Long id_formato_nota_credito,Long id_transaccion_factura,Long id_transaccion_nota_venta,Long id_transaccion_nota_credito,Long id_transaccion_cuenta_factura,Long id_transaccion_cuenta_nota_venta,Long id_transaccion_cuenta_nota_credito) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.configuracionpunvenOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_bodega=id_bodega;
 		this.id_cuenta_contable_efectivo=id_cuenta_contable_efectivo;
 		this.id_cuenta_contable_ice=id_cuenta_contable_ice;
 		this.id_cuenta_contable_otros=id_cuenta_contable_otros;
 		this.id_cliente_consumidor_final=id_cliente_consumidor_final;
 		this.id_tipo_documento_factura=id_tipo_documento_factura;
 		this.id_tipo_documento_nota_venta=id_tipo_documento_nota_venta;
 		this.id_tipo_documento_nota_credito=id_tipo_documento_nota_credito;
 		this.id_tipo_documento_tarjeta_credito=id_tipo_documento_tarjeta_credito;
 		this.id_formato_factura=id_formato_factura;
 		this.id_formato_nota_venta=id_formato_nota_venta;
 		this.id_formato_nota_credito=id_formato_nota_credito;
 		this.id_transaccion_factura=id_transaccion_factura;
 		this.id_transaccion_nota_venta=id_transaccion_nota_venta;
 		this.id_transaccion_nota_credito=id_transaccion_nota_credito;
 		this.id_transaccion_cuenta_factura=id_transaccion_cuenta_factura;
 		this.id_transaccion_cuenta_nota_venta=id_transaccion_cuenta_nota_venta;
 		this.id_transaccion_cuenta_nota_credito=id_transaccion_cuenta_nota_credito;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ConfiguracionPunVen (Long id_empresa,Long id_sucursal,Long id_bodega,Long id_cuenta_contable_efectivo,Long id_cuenta_contable_ice,Long id_cuenta_contable_otros,Long id_cliente_consumidor_final,Long id_tipo_documento_factura,Long id_tipo_documento_nota_venta,Long id_tipo_documento_nota_credito,Long id_tipo_documento_tarjeta_credito,Long id_formato_factura,Long id_formato_nota_venta,Long id_formato_nota_credito,Long id_transaccion_factura,Long id_transaccion_nota_venta,Long id_transaccion_nota_credito,Long id_transaccion_cuenta_factura,Long id_transaccion_cuenta_nota_venta,Long id_transaccion_cuenta_nota_credito) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.configuracionpunvenOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_bodega=id_bodega;
 		this.id_cuenta_contable_efectivo=id_cuenta_contable_efectivo;
 		this.id_cuenta_contable_ice=id_cuenta_contable_ice;
 		this.id_cuenta_contable_otros=id_cuenta_contable_otros;
 		this.id_cliente_consumidor_final=id_cliente_consumidor_final;
 		this.id_tipo_documento_factura=id_tipo_documento_factura;
 		this.id_tipo_documento_nota_venta=id_tipo_documento_nota_venta;
 		this.id_tipo_documento_nota_credito=id_tipo_documento_nota_credito;
 		this.id_tipo_documento_tarjeta_credito=id_tipo_documento_tarjeta_credito;
 		this.id_formato_factura=id_formato_factura;
 		this.id_formato_nota_venta=id_formato_nota_venta;
 		this.id_formato_nota_credito=id_formato_nota_credito;
 		this.id_transaccion_factura=id_transaccion_factura;
 		this.id_transaccion_nota_venta=id_transaccion_nota_venta;
 		this.id_transaccion_nota_credito=id_transaccion_nota_credito;
 		this.id_transaccion_cuenta_factura=id_transaccion_cuenta_factura;
 		this.id_transaccion_cuenta_nota_venta=id_transaccion_cuenta_nota_venta;
 		this.id_transaccion_cuenta_nota_credito=id_transaccion_cuenta_nota_credito;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ConfiguracionPunVen configuracionpunvenLocal=null;
		
		if(object!=null) {
			configuracionpunvenLocal=(ConfiguracionPunVen)object;
			
			if(configuracionpunvenLocal!=null) {
				if(this.getId()!=null && configuracionpunvenLocal.getId()!=null) {
					if(this.getId().equals(configuracionpunvenLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ConfiguracionPunVenConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ConfiguracionPunVenConstantesFunciones.getConfiguracionPunVenDescripcion(this);
		} else {
			sDetalle=ConfiguracionPunVenConstantesFunciones.getConfiguracionPunVenDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ConfiguracionPunVen getConfiguracionPunVenOriginal() {
		return this.configuracionpunvenOriginal;
	}
	
	public void setConfiguracionPunVenOriginal(ConfiguracionPunVen configuracionpunven) {
		try {
			this.configuracionpunvenOriginal=configuracionpunven;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ConfiguracionPunVenAdditional configuracionpunvenAdditional=null;
	
	public ConfiguracionPunVenAdditional getConfiguracionPunVenAdditional() {
		return this.configuracionpunvenAdditional;
	}
	
	public void setConfiguracionPunVenAdditional(ConfiguracionPunVenAdditional configuracionpunvenAdditional) {
		try {
			this.configuracionpunvenAdditional=configuracionpunvenAdditional;
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
    
	
	public Long getid_bodega() {
		return this.id_bodega;
	}
    
	
	public Long getid_cuenta_contable_efectivo() {
		return this.id_cuenta_contable_efectivo;
	}
    
	
	public Long getid_cuenta_contable_ice() {
		return this.id_cuenta_contable_ice;
	}
    
	
	public Long getid_cuenta_contable_otros() {
		return this.id_cuenta_contable_otros;
	}
    
	
	public Long getid_cliente_consumidor_final() {
		return this.id_cliente_consumidor_final;
	}
    
	
	public Long getid_tipo_documento_factura() {
		return this.id_tipo_documento_factura;
	}
    
	
	public Long getid_tipo_documento_nota_venta() {
		return this.id_tipo_documento_nota_venta;
	}
    
	
	public Long getid_tipo_documento_nota_credito() {
		return this.id_tipo_documento_nota_credito;
	}
    
	
	public Long getid_tipo_documento_tarjeta_credito() {
		return this.id_tipo_documento_tarjeta_credito;
	}
    
	
	public Long getid_formato_factura() {
		return this.id_formato_factura;
	}
    
	
	public Long getid_formato_nota_venta() {
		return this.id_formato_nota_venta;
	}
    
	
	public Long getid_formato_nota_credito() {
		return this.id_formato_nota_credito;
	}
    
	
	public Long getid_transaccion_factura() {
		return this.id_transaccion_factura;
	}
    
	
	public Long getid_transaccion_nota_venta() {
		return this.id_transaccion_nota_venta;
	}
    
	
	public Long getid_transaccion_nota_credito() {
		return this.id_transaccion_nota_credito;
	}
    
	
	public Long getid_transaccion_cuenta_factura() {
		return this.id_transaccion_cuenta_factura;
	}
    
	
	public Long getid_transaccion_cuenta_nota_venta() {
		return this.id_transaccion_cuenta_nota_venta;
	}
    
	
	public Long getid_transaccion_cuenta_nota_credito() {
		return this.id_transaccion_cuenta_nota_credito;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConfiguracionPunVen:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ConfiguracionPunVen:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("ConfiguracionPunVen:Valor nulo no permitido en columna id_bodega");
					}
				}

				this.id_bodega=newid_bodega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_efectivo(Long newid_cuenta_contable_efectivo)throws Exception
	{
		try {
			if(this.id_cuenta_contable_efectivo!=newid_cuenta_contable_efectivo) {
				if(newid_cuenta_contable_efectivo==null) {
					//newid_cuenta_contable_efectivo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConfiguracionPunVen:Valor nulo no permitido en columna id_cuenta_contable_efectivo");
					}
				}

				this.id_cuenta_contable_efectivo=newid_cuenta_contable_efectivo;
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
						System.out.println("ConfiguracionPunVen:Valor nulo no permitido en columna id_cuenta_contable_ice");
					}
				}

				this.id_cuenta_contable_ice=newid_cuenta_contable_ice;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_otros(Long newid_cuenta_contable_otros)throws Exception
	{
		try {
			if(this.id_cuenta_contable_otros!=newid_cuenta_contable_otros) {
				if(newid_cuenta_contable_otros==null) {
					//newid_cuenta_contable_otros=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConfiguracionPunVen:Valor nulo no permitido en columna id_cuenta_contable_otros");
					}
				}

				this.id_cuenta_contable_otros=newid_cuenta_contable_otros;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente_consumidor_final(Long newid_cliente_consumidor_final)throws Exception
	{
		try {
			if(this.id_cliente_consumidor_final!=newid_cliente_consumidor_final) {
				if(newid_cliente_consumidor_final==null) {
					//newid_cliente_consumidor_final=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConfiguracionPunVen:Valor nulo no permitido en columna id_cliente_consumidor_final");
					}
				}

				this.id_cliente_consumidor_final=newid_cliente_consumidor_final;
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
						System.out.println("ConfiguracionPunVen:Valor nulo no permitido en columna id_tipo_documento_factura");
					}
				}

				this.id_tipo_documento_factura=newid_tipo_documento_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_documento_nota_venta(Long newid_tipo_documento_nota_venta)throws Exception
	{
		try {
			if(this.id_tipo_documento_nota_venta!=newid_tipo_documento_nota_venta) {
				if(newid_tipo_documento_nota_venta==null) {
					//newid_tipo_documento_nota_venta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConfiguracionPunVen:Valor nulo no permitido en columna id_tipo_documento_nota_venta");
					}
				}

				this.id_tipo_documento_nota_venta=newid_tipo_documento_nota_venta;
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
						System.out.println("ConfiguracionPunVen:Valor nulo no permitido en columna id_tipo_documento_nota_credito");
					}
				}

				this.id_tipo_documento_nota_credito=newid_tipo_documento_nota_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_documento_tarjeta_credito(Long newid_tipo_documento_tarjeta_credito)throws Exception
	{
		try {
			if(this.id_tipo_documento_tarjeta_credito!=newid_tipo_documento_tarjeta_credito) {
				if(newid_tipo_documento_tarjeta_credito==null) {
					//newid_tipo_documento_tarjeta_credito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConfiguracionPunVen:Valor nulo no permitido en columna id_tipo_documento_tarjeta_credito");
					}
				}

				this.id_tipo_documento_tarjeta_credito=newid_tipo_documento_tarjeta_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_factura(Long newid_formato_factura)throws Exception
	{
		try {
			if(this.id_formato_factura!=newid_formato_factura) {
				if(newid_formato_factura==null) {
					//newid_formato_factura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConfiguracionPunVen:Valor nulo no permitido en columna id_formato_factura");
					}
				}

				this.id_formato_factura=newid_formato_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_nota_venta(Long newid_formato_nota_venta)throws Exception
	{
		try {
			if(this.id_formato_nota_venta!=newid_formato_nota_venta) {
				if(newid_formato_nota_venta==null) {
					//newid_formato_nota_venta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConfiguracionPunVen:Valor nulo no permitido en columna id_formato_nota_venta");
					}
				}

				this.id_formato_nota_venta=newid_formato_nota_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_nota_credito(Long newid_formato_nota_credito)throws Exception
	{
		try {
			if(this.id_formato_nota_credito!=newid_formato_nota_credito) {
				if(newid_formato_nota_credito==null) {
					//newid_formato_nota_credito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConfiguracionPunVen:Valor nulo no permitido en columna id_formato_nota_credito");
					}
				}

				this.id_formato_nota_credito=newid_formato_nota_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_factura(Long newid_transaccion_factura)throws Exception
	{
		try {
			if(this.id_transaccion_factura!=newid_transaccion_factura) {
				if(newid_transaccion_factura==null) {
					//newid_transaccion_factura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConfiguracionPunVen:Valor nulo no permitido en columna id_transaccion_factura");
					}
				}

				this.id_transaccion_factura=newid_transaccion_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_nota_venta(Long newid_transaccion_nota_venta)throws Exception
	{
		try {
			if(this.id_transaccion_nota_venta!=newid_transaccion_nota_venta) {
				if(newid_transaccion_nota_venta==null) {
					//newid_transaccion_nota_venta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConfiguracionPunVen:Valor nulo no permitido en columna id_transaccion_nota_venta");
					}
				}

				this.id_transaccion_nota_venta=newid_transaccion_nota_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_nota_credito(Long newid_transaccion_nota_credito)throws Exception
	{
		try {
			if(this.id_transaccion_nota_credito!=newid_transaccion_nota_credito) {
				if(newid_transaccion_nota_credito==null) {
					//newid_transaccion_nota_credito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConfiguracionPunVen:Valor nulo no permitido en columna id_transaccion_nota_credito");
					}
				}

				this.id_transaccion_nota_credito=newid_transaccion_nota_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_cuenta_factura(Long newid_transaccion_cuenta_factura)throws Exception
	{
		try {
			if(this.id_transaccion_cuenta_factura!=newid_transaccion_cuenta_factura) {
				if(newid_transaccion_cuenta_factura==null) {
					//newid_transaccion_cuenta_factura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConfiguracionPunVen:Valor nulo no permitido en columna id_transaccion_cuenta_factura");
					}
				}

				this.id_transaccion_cuenta_factura=newid_transaccion_cuenta_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_cuenta_nota_venta(Long newid_transaccion_cuenta_nota_venta)throws Exception
	{
		try {
			if(this.id_transaccion_cuenta_nota_venta!=newid_transaccion_cuenta_nota_venta) {
				if(newid_transaccion_cuenta_nota_venta==null) {
					//newid_transaccion_cuenta_nota_venta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConfiguracionPunVen:Valor nulo no permitido en columna id_transaccion_cuenta_nota_venta");
					}
				}

				this.id_transaccion_cuenta_nota_venta=newid_transaccion_cuenta_nota_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_cuenta_nota_credito(Long newid_transaccion_cuenta_nota_credito)throws Exception
	{
		try {
			if(this.id_transaccion_cuenta_nota_credito!=newid_transaccion_cuenta_nota_credito) {
				if(newid_transaccion_cuenta_nota_credito==null) {
					//newid_transaccion_cuenta_nota_credito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConfiguracionPunVen:Valor nulo no permitido en columna id_transaccion_cuenta_nota_credito");
					}
				}

				this.id_transaccion_cuenta_nota_credito=newid_transaccion_cuenta_nota_credito;
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

	public Bodega getBodega() {
		return this.bodega;
	}

	public CuentaContable getCuentaContableEfectivo() {
		return this.cuentacontableefectivo;
	}

	public CuentaContable getCuentaContableIce() {
		return this.cuentacontableice;
	}

	public CuentaContable getCuentaContableOtros() {
		return this.cuentacontableotros;
	}

	public Cliente getClienteConsumidorFinal() {
		return this.clienteconsumidorfinal;
	}

	public TipoDocumento getTipoDocumentoFactura() {
		return this.tipodocumentofactura;
	}

	public TipoDocumento getTipoDocumentoNotaVenta() {
		return this.tipodocumentonotaventa;
	}

	public TipoDocumento getTipoDocumentoNotaCredito() {
		return this.tipodocumentonotacredito;
	}

	public TipoDocumento getTipoDocumentoTarjetaCredito() {
		return this.tipodocumentotarjetacredito;
	}

	public Formato getFormatoFactura() {
		return this.formatofactura;
	}

	public Formato getFormatoNotaVenta() {
		return this.formatonotaventa;
	}

	public Formato getFormatoNotaCredito() {
		return this.formatonotacredito;
	}

	public Transaccion getTransaccionFactura() {
		return this.transaccionfactura;
	}

	public Transaccion getTransaccionNotaVenta() {
		return this.transaccionnotaventa;
	}

	public Transaccion getTransaccionNotaCredito() {
		return this.transaccionnotacredito;
	}

	public Transaccion getTransaccionCuentaFactura() {
		return this.transaccioncuentafactura;
	}

	public Transaccion getTransaccionCuentaNotaVenta() {
		return this.transaccioncuentanotaventa;
	}

	public Transaccion getTransaccionCuentaNotaCredito() {
		return this.transaccioncuentanotacredito;
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

	public String getcuentacontableefectivo_descripcion() {
		return this.cuentacontableefectivo_descripcion;
	}

	public String getcuentacontableice_descripcion() {
		return this.cuentacontableice_descripcion;
	}

	public String getcuentacontableotros_descripcion() {
		return this.cuentacontableotros_descripcion;
	}

	public String getclienteconsumidorfinal_descripcion() {
		return this.clienteconsumidorfinal_descripcion;
	}

	public String gettipodocumentofactura_descripcion() {
		return this.tipodocumentofactura_descripcion;
	}

	public String gettipodocumentonotaventa_descripcion() {
		return this.tipodocumentonotaventa_descripcion;
	}

	public String gettipodocumentonotacredito_descripcion() {
		return this.tipodocumentonotacredito_descripcion;
	}

	public String gettipodocumentotarjetacredito_descripcion() {
		return this.tipodocumentotarjetacredito_descripcion;
	}

	public String getformatofactura_descripcion() {
		return this.formatofactura_descripcion;
	}

	public String getformatonotaventa_descripcion() {
		return this.formatonotaventa_descripcion;
	}

	public String getformatonotacredito_descripcion() {
		return this.formatonotacredito_descripcion;
	}

	public String gettransaccionfactura_descripcion() {
		return this.transaccionfactura_descripcion;
	}

	public String gettransaccionnotaventa_descripcion() {
		return this.transaccionnotaventa_descripcion;
	}

	public String gettransaccionnotacredito_descripcion() {
		return this.transaccionnotacredito_descripcion;
	}

	public String gettransaccioncuentafactura_descripcion() {
		return this.transaccioncuentafactura_descripcion;
	}

	public String gettransaccioncuentanotaventa_descripcion() {
		return this.transaccioncuentanotaventa_descripcion;
	}

	public String gettransaccioncuentanotacredito_descripcion() {
		return this.transaccioncuentanotacredito_descripcion;
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


	public  void  setCuentaContableEfectivo(CuentaContable cuentacontableefectivo) {
		try {
			this.cuentacontableefectivo=cuentacontableefectivo;
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


	public  void  setCuentaContableOtros(CuentaContable cuentacontableotros) {
		try {
			this.cuentacontableotros=cuentacontableotros;
		} catch(Exception e) {
			;
		}
	}


	public  void  setClienteConsumidorFinal(Cliente clienteconsumidorfinal) {
		try {
			this.clienteconsumidorfinal=clienteconsumidorfinal;
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


	public  void  setTipoDocumentoNotaVenta(TipoDocumento tipodocumentonotaventa) {
		try {
			this.tipodocumentonotaventa=tipodocumentonotaventa;
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


	public  void  setTipoDocumentoTarjetaCredito(TipoDocumento tipodocumentotarjetacredito) {
		try {
			this.tipodocumentotarjetacredito=tipodocumentotarjetacredito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoFactura(Formato formatofactura) {
		try {
			this.formatofactura=formatofactura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoNotaVenta(Formato formatonotaventa) {
		try {
			this.formatonotaventa=formatonotaventa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoNotaCredito(Formato formatonotacredito) {
		try {
			this.formatonotacredito=formatonotacredito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionFactura(Transaccion transaccionfactura) {
		try {
			this.transaccionfactura=transaccionfactura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionNotaVenta(Transaccion transaccionnotaventa) {
		try {
			this.transaccionnotaventa=transaccionnotaventa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionNotaCredito(Transaccion transaccionnotacredito) {
		try {
			this.transaccionnotacredito=transaccionnotacredito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionCuentaFactura(Transaccion transaccioncuentafactura) {
		try {
			this.transaccioncuentafactura=transaccioncuentafactura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionCuentaNotaVenta(Transaccion transaccioncuentanotaventa) {
		try {
			this.transaccioncuentanotaventa=transaccioncuentanotaventa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionCuentaNotaCredito(Transaccion transaccioncuentanotacredito) {
		try {
			this.transaccioncuentanotacredito=transaccioncuentanotacredito;
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


	public  void  setcuentacontableefectivo_descripcion(String cuentacontableefectivo_descripcion) {
		try {
			this.cuentacontableefectivo_descripcion=cuentacontableefectivo_descripcion;
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


	public  void  setcuentacontableotros_descripcion(String cuentacontableotros_descripcion) {
		try {
			this.cuentacontableotros_descripcion=cuentacontableotros_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setclienteconsumidorfinal_descripcion(String clienteconsumidorfinal_descripcion) {
		try {
			this.clienteconsumidorfinal_descripcion=clienteconsumidorfinal_descripcion;
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


	public  void  settipodocumentonotaventa_descripcion(String tipodocumentonotaventa_descripcion) {
		try {
			this.tipodocumentonotaventa_descripcion=tipodocumentonotaventa_descripcion;
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


	public  void  settipodocumentotarjetacredito_descripcion(String tipodocumentotarjetacredito_descripcion) {
		try {
			this.tipodocumentotarjetacredito_descripcion=tipodocumentotarjetacredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatofactura_descripcion(String formatofactura_descripcion) {
		try {
			this.formatofactura_descripcion=formatofactura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatonotaventa_descripcion(String formatonotaventa_descripcion) {
		try {
			this.formatonotaventa_descripcion=formatonotaventa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatonotacredito_descripcion(String formatonotacredito_descripcion) {
		try {
			this.formatonotacredito_descripcion=formatonotacredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccionfactura_descripcion(String transaccionfactura_descripcion) {
		try {
			this.transaccionfactura_descripcion=transaccionfactura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccionnotaventa_descripcion(String transaccionnotaventa_descripcion) {
		try {
			this.transaccionnotaventa_descripcion=transaccionnotaventa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccionnotacredito_descripcion(String transaccionnotacredito_descripcion) {
		try {
			this.transaccionnotacredito_descripcion=transaccionnotacredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccioncuentafactura_descripcion(String transaccioncuentafactura_descripcion) {
		try {
			this.transaccioncuentafactura_descripcion=transaccioncuentafactura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccioncuentanotaventa_descripcion(String transaccioncuentanotaventa_descripcion) {
		try {
			this.transaccioncuentanotaventa_descripcion=transaccioncuentanotaventa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccioncuentanotacredito_descripcion(String transaccioncuentanotacredito_descripcion) {
		try {
			this.transaccioncuentanotacredito_descripcion=transaccioncuentanotacredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_bodega_descripcion="";String id_cuenta_contable_efectivo_descripcion="";String id_cuenta_contable_ice_descripcion="";String id_cuenta_contable_otros_descripcion="";String id_cliente_consumidor_final_descripcion="";String id_tipo_documento_factura_descripcion="";String id_tipo_documento_nota_venta_descripcion="";String id_tipo_documento_nota_credito_descripcion="";String id_tipo_documento_tarjeta_credito_descripcion="";String id_formato_factura_descripcion="";String id_formato_nota_venta_descripcion="";String id_formato_nota_credito_descripcion="";String id_transaccion_factura_descripcion="";String id_transaccion_nota_venta_descripcion="";String id_transaccion_nota_credito_descripcion="";String id_transaccion_cuenta_factura_descripcion="";String id_transaccion_cuenta_nota_venta_descripcion="";String id_transaccion_cuenta_nota_credito_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_bodega_descripcion() {
		return id_bodega_descripcion;
	}
	public String getid_cuenta_contable_efectivo_descripcion() {
		return id_cuenta_contable_efectivo_descripcion;
	}
	public String getid_cuenta_contable_ice_descripcion() {
		return id_cuenta_contable_ice_descripcion;
	}
	public String getid_cuenta_contable_otros_descripcion() {
		return id_cuenta_contable_otros_descripcion;
	}
	public String getid_cliente_consumidor_final_descripcion() {
		return id_cliente_consumidor_final_descripcion;
	}
	public String getid_tipo_documento_factura_descripcion() {
		return id_tipo_documento_factura_descripcion;
	}
	public String getid_tipo_documento_nota_venta_descripcion() {
		return id_tipo_documento_nota_venta_descripcion;
	}
	public String getid_tipo_documento_nota_credito_descripcion() {
		return id_tipo_documento_nota_credito_descripcion;
	}
	public String getid_tipo_documento_tarjeta_credito_descripcion() {
		return id_tipo_documento_tarjeta_credito_descripcion;
	}
	public String getid_formato_factura_descripcion() {
		return id_formato_factura_descripcion;
	}
	public String getid_formato_nota_venta_descripcion() {
		return id_formato_nota_venta_descripcion;
	}
	public String getid_formato_nota_credito_descripcion() {
		return id_formato_nota_credito_descripcion;
	}
	public String getid_transaccion_factura_descripcion() {
		return id_transaccion_factura_descripcion;
	}
	public String getid_transaccion_nota_venta_descripcion() {
		return id_transaccion_nota_venta_descripcion;
	}
	public String getid_transaccion_nota_credito_descripcion() {
		return id_transaccion_nota_credito_descripcion;
	}
	public String getid_transaccion_cuenta_factura_descripcion() {
		return id_transaccion_cuenta_factura_descripcion;
	}
	public String getid_transaccion_cuenta_nota_venta_descripcion() {
		return id_transaccion_cuenta_nota_venta_descripcion;
	}
	public String getid_transaccion_cuenta_nota_credito_descripcion() {
		return id_transaccion_cuenta_nota_credito_descripcion;
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
	public void setid_cuenta_contable_efectivo_descripcion(String newid_cuenta_contable_efectivo_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_efectivo_descripcion=newid_cuenta_contable_efectivo_descripcion;
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
	public void setid_cuenta_contable_otros_descripcion(String newid_cuenta_contable_otros_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_otros_descripcion=newid_cuenta_contable_otros_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cliente_consumidor_final_descripcion(String newid_cliente_consumidor_final_descripcion)throws Exception {
		try {
			this.id_cliente_consumidor_final_descripcion=newid_cliente_consumidor_final_descripcion;
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
	public void setid_tipo_documento_nota_venta_descripcion(String newid_tipo_documento_nota_venta_descripcion)throws Exception {
		try {
			this.id_tipo_documento_nota_venta_descripcion=newid_tipo_documento_nota_venta_descripcion;
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
	public void setid_tipo_documento_tarjeta_credito_descripcion(String newid_tipo_documento_tarjeta_credito_descripcion)throws Exception {
		try {
			this.id_tipo_documento_tarjeta_credito_descripcion=newid_tipo_documento_tarjeta_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_factura_descripcion(String newid_formato_factura_descripcion)throws Exception {
		try {
			this.id_formato_factura_descripcion=newid_formato_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_nota_venta_descripcion(String newid_formato_nota_venta_descripcion)throws Exception {
		try {
			this.id_formato_nota_venta_descripcion=newid_formato_nota_venta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_nota_credito_descripcion(String newid_formato_nota_credito_descripcion)throws Exception {
		try {
			this.id_formato_nota_credito_descripcion=newid_formato_nota_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_factura_descripcion(String newid_transaccion_factura_descripcion)throws Exception {
		try {
			this.id_transaccion_factura_descripcion=newid_transaccion_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_nota_venta_descripcion(String newid_transaccion_nota_venta_descripcion)throws Exception {
		try {
			this.id_transaccion_nota_venta_descripcion=newid_transaccion_nota_venta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_nota_credito_descripcion(String newid_transaccion_nota_credito_descripcion)throws Exception {
		try {
			this.id_transaccion_nota_credito_descripcion=newid_transaccion_nota_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_cuenta_factura_descripcion(String newid_transaccion_cuenta_factura_descripcion)throws Exception {
		try {
			this.id_transaccion_cuenta_factura_descripcion=newid_transaccion_cuenta_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_cuenta_nota_venta_descripcion(String newid_transaccion_cuenta_nota_venta_descripcion)throws Exception {
		try {
			this.id_transaccion_cuenta_nota_venta_descripcion=newid_transaccion_cuenta_nota_venta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_cuenta_nota_credito_descripcion(String newid_transaccion_cuenta_nota_credito_descripcion)throws Exception {
		try {
			this.id_transaccion_cuenta_nota_credito_descripcion=newid_transaccion_cuenta_nota_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_bodega_descripcion="";this.id_cuenta_contable_efectivo_descripcion="";this.id_cuenta_contable_ice_descripcion="";this.id_cuenta_contable_otros_descripcion="";this.id_cliente_consumidor_final_descripcion="";this.id_tipo_documento_factura_descripcion="";this.id_tipo_documento_nota_venta_descripcion="";this.id_tipo_documento_nota_credito_descripcion="";this.id_tipo_documento_tarjeta_credito_descripcion="";this.id_formato_factura_descripcion="";this.id_formato_nota_venta_descripcion="";this.id_formato_nota_credito_descripcion="";this.id_transaccion_factura_descripcion="";this.id_transaccion_nota_venta_descripcion="";this.id_transaccion_nota_credito_descripcion="";this.id_transaccion_cuenta_factura_descripcion="";this.id_transaccion_cuenta_nota_venta_descripcion="";this.id_transaccion_cuenta_nota_credito_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

