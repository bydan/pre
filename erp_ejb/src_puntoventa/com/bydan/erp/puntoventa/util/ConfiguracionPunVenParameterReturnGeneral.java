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
package com.bydan.erp.puntoventa.util;

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;

import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.DeepLoadType;
import com.bydan.erp.puntoventa.util.ConfiguracionPunVenConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//ConfiguracionPunVen


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class ConfiguracionPunVenParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ConfiguracionPunVen configuracionpunven;	
	protected List<ConfiguracionPunVen> configuracionpunvens;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<CuentaContable> cuentacontableefectivosForeignKey;
	public List<CuentaContable> cuentacontableicesForeignKey;
	public List<CuentaContable> cuentacontableotrossForeignKey;
	public List<Cliente> clienteconsumidorfinalsForeignKey;
	public List<TipoDocumento> tipodocumentofacturasForeignKey;
	public List<TipoDocumento> tipodocumentonotaventasForeignKey;
	public List<TipoDocumento> tipodocumentonotacreditosForeignKey;
	public List<TipoDocumento> tipodocumentotarjetacreditosForeignKey;
	public List<Formato> formatofacturasForeignKey;
	public List<Formato> formatonotaventasForeignKey;
	public List<Formato> formatonotacreditosForeignKey;
	public List<Transaccion> transaccionfacturasForeignKey;
	public List<Transaccion> transaccionnotaventasForeignKey;
	public List<Transaccion> transaccionnotacreditosForeignKey;
	public List<Transaccion> transaccioncuentafacturasForeignKey;
	public List<Transaccion> transaccioncuentanotaventasForeignKey;
	public List<Transaccion> transaccioncuentanotacreditosForeignKey;
	
	public ConfiguracionPunVenParameterReturnGeneral () throws Exception {						
		super();
		this.configuracionpunvens= new ArrayList<ConfiguracionPunVen>();
		this.configuracionpunven= new ConfiguracionPunVen();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.cuentacontableefectivosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableicesForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableotrossForeignKey=new ArrayList<CuentaContable>();
		this.clienteconsumidorfinalsForeignKey=new ArrayList<Cliente>();
		this.tipodocumentofacturasForeignKey=new ArrayList<TipoDocumento>();
		this.tipodocumentonotaventasForeignKey=new ArrayList<TipoDocumento>();
		this.tipodocumentonotacreditosForeignKey=new ArrayList<TipoDocumento>();
		this.tipodocumentotarjetacreditosForeignKey=new ArrayList<TipoDocumento>();
		this.formatofacturasForeignKey=new ArrayList<Formato>();
		this.formatonotaventasForeignKey=new ArrayList<Formato>();
		this.formatonotacreditosForeignKey=new ArrayList<Formato>();
		this.transaccionfacturasForeignKey=new ArrayList<Transaccion>();
		this.transaccionnotaventasForeignKey=new ArrayList<Transaccion>();
		this.transaccionnotacreditosForeignKey=new ArrayList<Transaccion>();
		this.transaccioncuentafacturasForeignKey=new ArrayList<Transaccion>();
		this.transaccioncuentanotaventasForeignKey=new ArrayList<Transaccion>();
		this.transaccioncuentanotacreditosForeignKey=new ArrayList<Transaccion>();
	} 
	
	public ConfiguracionPunVen getConfiguracionPunVen() throws Exception {	
		return configuracionpunven;
	}
		
	public void setConfiguracionPunVen(ConfiguracionPunVen newConfiguracionPunVen) {
		this.configuracionpunven = newConfiguracionPunVen;
	}
	
	public List<ConfiguracionPunVen> getConfiguracionPunVens() throws Exception {		
		return configuracionpunvens;
	}
	
	public void setConfiguracionPunVens(List<ConfiguracionPunVen> newConfiguracionPunVens) {
		this.configuracionpunvens = newConfiguracionPunVens;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Bodega> getbodegasForeignKey() {
		return this.bodegasForeignKey;
	}

	public List<CuentaContable> getcuentacontableefectivosForeignKey() {
		return this.cuentacontableefectivosForeignKey;
	}

	public List<CuentaContable> getcuentacontableicesForeignKey() {
		return this.cuentacontableicesForeignKey;
	}

	public List<CuentaContable> getcuentacontableotrossForeignKey() {
		return this.cuentacontableotrossForeignKey;
	}

	public List<Cliente> getclienteconsumidorfinalsForeignKey() {
		return this.clienteconsumidorfinalsForeignKey;
	}

	public List<TipoDocumento> gettipodocumentofacturasForeignKey() {
		return this.tipodocumentofacturasForeignKey;
	}

	public List<TipoDocumento> gettipodocumentonotaventasForeignKey() {
		return this.tipodocumentonotaventasForeignKey;
	}

	public List<TipoDocumento> gettipodocumentonotacreditosForeignKey() {
		return this.tipodocumentonotacreditosForeignKey;
	}

	public List<TipoDocumento> gettipodocumentotarjetacreditosForeignKey() {
		return this.tipodocumentotarjetacreditosForeignKey;
	}

	public List<Formato> getformatofacturasForeignKey() {
		return this.formatofacturasForeignKey;
	}

	public List<Formato> getformatonotaventasForeignKey() {
		return this.formatonotaventasForeignKey;
	}

	public List<Formato> getformatonotacreditosForeignKey() {
		return this.formatonotacreditosForeignKey;
	}

	public List<Transaccion> gettransaccionfacturasForeignKey() {
		return this.transaccionfacturasForeignKey;
	}

	public List<Transaccion> gettransaccionnotaventasForeignKey() {
		return this.transaccionnotaventasForeignKey;
	}

	public List<Transaccion> gettransaccionnotacreditosForeignKey() {
		return this.transaccionnotacreditosForeignKey;
	}

	public List<Transaccion> gettransaccioncuentafacturasForeignKey() {
		return this.transaccioncuentafacturasForeignKey;
	}

	public List<Transaccion> gettransaccioncuentanotaventasForeignKey() {
		return this.transaccioncuentanotaventasForeignKey;
	}

	public List<Transaccion> gettransaccioncuentanotacreditosForeignKey() {
		return this.transaccioncuentanotacreditosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setbodegasForeignKey(List<Bodega> bodegasForeignKey) {
		this.bodegasForeignKey=bodegasForeignKey;
	}

	public void setcuentacontableefectivosForeignKey(List<CuentaContable> cuentacontableefectivosForeignKey) {
		this.cuentacontableefectivosForeignKey=cuentacontableefectivosForeignKey;
	}

	public void setcuentacontableicesForeignKey(List<CuentaContable> cuentacontableicesForeignKey) {
		this.cuentacontableicesForeignKey=cuentacontableicesForeignKey;
	}

	public void setcuentacontableotrossForeignKey(List<CuentaContable> cuentacontableotrossForeignKey) {
		this.cuentacontableotrossForeignKey=cuentacontableotrossForeignKey;
	}

	public void setclienteconsumidorfinalsForeignKey(List<Cliente> clienteconsumidorfinalsForeignKey) {
		this.clienteconsumidorfinalsForeignKey=clienteconsumidorfinalsForeignKey;
	}

	public void settipodocumentofacturasForeignKey(List<TipoDocumento> tipodocumentofacturasForeignKey) {
		this.tipodocumentofacturasForeignKey=tipodocumentofacturasForeignKey;
	}

	public void settipodocumentonotaventasForeignKey(List<TipoDocumento> tipodocumentonotaventasForeignKey) {
		this.tipodocumentonotaventasForeignKey=tipodocumentonotaventasForeignKey;
	}

	public void settipodocumentonotacreditosForeignKey(List<TipoDocumento> tipodocumentonotacreditosForeignKey) {
		this.tipodocumentonotacreditosForeignKey=tipodocumentonotacreditosForeignKey;
	}

	public void settipodocumentotarjetacreditosForeignKey(List<TipoDocumento> tipodocumentotarjetacreditosForeignKey) {
		this.tipodocumentotarjetacreditosForeignKey=tipodocumentotarjetacreditosForeignKey;
	}

	public void setformatofacturasForeignKey(List<Formato> formatofacturasForeignKey) {
		this.formatofacturasForeignKey=formatofacturasForeignKey;
	}

	public void setformatonotaventasForeignKey(List<Formato> formatonotaventasForeignKey) {
		this.formatonotaventasForeignKey=formatonotaventasForeignKey;
	}

	public void setformatonotacreditosForeignKey(List<Formato> formatonotacreditosForeignKey) {
		this.formatonotacreditosForeignKey=formatonotacreditosForeignKey;
	}

	public void settransaccionfacturasForeignKey(List<Transaccion> transaccionfacturasForeignKey) {
		this.transaccionfacturasForeignKey=transaccionfacturasForeignKey;
	}

	public void settransaccionnotaventasForeignKey(List<Transaccion> transaccionnotaventasForeignKey) {
		this.transaccionnotaventasForeignKey=transaccionnotaventasForeignKey;
	}

	public void settransaccionnotacreditosForeignKey(List<Transaccion> transaccionnotacreditosForeignKey) {
		this.transaccionnotacreditosForeignKey=transaccionnotacreditosForeignKey;
	}

	public void settransaccioncuentafacturasForeignKey(List<Transaccion> transaccioncuentafacturasForeignKey) {
		this.transaccioncuentafacturasForeignKey=transaccioncuentafacturasForeignKey;
	}

	public void settransaccioncuentanotaventasForeignKey(List<Transaccion> transaccioncuentanotaventasForeignKey) {
		this.transaccioncuentanotaventasForeignKey=transaccioncuentanotaventasForeignKey;
	}

	public void settransaccioncuentanotacreditosForeignKey(List<Transaccion> transaccioncuentanotacreditosForeignKey) {
		this.transaccioncuentanotacreditosForeignKey=transaccioncuentanotacreditosForeignKey;
	}
}

