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
package com.bydan.erp.facturacion.util;

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
import com.bydan.erp.facturacion.util.ParametroFactuTransaccionConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//ParametroFactuTransaccion


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class ParametroFactuTransaccionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroFactuTransaccion parametrofactutransaccion;	
	protected List<ParametroFactuTransaccion> parametrofactutransaccions;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Transaccion> transaccioninvenfacturasForeignKey;
	public List<Transaccion> transaccioninvennotacreditosForeignKey;
	public List<Transaccion> transaccioninvennotaventasForeignKey;
	public List<Transaccion> transaccioncuentacofacturasForeignKey;
	public List<Transaccion> transaccioncuentaconotacreditosForeignKey;
	public List<Transaccion> transaccioncuentaconotaventasForeignKey;
	public List<Transaccion> transaccioncuentacotarjetasForeignKey;
	public List<Transaccion> transaccioncuentapafacturasForeignKey;
	public List<Transaccion> transaccioncuentapanotacreditosForeignKey;
	
	public ParametroFactuTransaccionParameterReturnGeneral () throws Exception {						
		super();
		this.parametrofactutransaccions= new ArrayList<ParametroFactuTransaccion>();
		this.parametrofactutransaccion= new ParametroFactuTransaccion();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.transaccioninvenfacturasForeignKey=new ArrayList<Transaccion>();
		this.transaccioninvennotacreditosForeignKey=new ArrayList<Transaccion>();
		this.transaccioninvennotaventasForeignKey=new ArrayList<Transaccion>();
		this.transaccioncuentacofacturasForeignKey=new ArrayList<Transaccion>();
		this.transaccioncuentaconotacreditosForeignKey=new ArrayList<Transaccion>();
		this.transaccioncuentaconotaventasForeignKey=new ArrayList<Transaccion>();
		this.transaccioncuentacotarjetasForeignKey=new ArrayList<Transaccion>();
		this.transaccioncuentapafacturasForeignKey=new ArrayList<Transaccion>();
		this.transaccioncuentapanotacreditosForeignKey=new ArrayList<Transaccion>();
	} 
	
	public ParametroFactuTransaccion getParametroFactuTransaccion() throws Exception {	
		return parametrofactutransaccion;
	}
		
	public void setParametroFactuTransaccion(ParametroFactuTransaccion newParametroFactuTransaccion) {
		this.parametrofactutransaccion = newParametroFactuTransaccion;
	}
	
	public List<ParametroFactuTransaccion> getParametroFactuTransaccions() throws Exception {		
		return parametrofactutransaccions;
	}
	
	public void setParametroFactuTransaccions(List<ParametroFactuTransaccion> newParametroFactuTransaccions) {
		this.parametrofactutransaccions = newParametroFactuTransaccions;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Transaccion> gettransaccioninvenfacturasForeignKey() {
		return this.transaccioninvenfacturasForeignKey;
	}

	public List<Transaccion> gettransaccioninvennotacreditosForeignKey() {
		return this.transaccioninvennotacreditosForeignKey;
	}

	public List<Transaccion> gettransaccioninvennotaventasForeignKey() {
		return this.transaccioninvennotaventasForeignKey;
	}

	public List<Transaccion> gettransaccioncuentacofacturasForeignKey() {
		return this.transaccioncuentacofacturasForeignKey;
	}

	public List<Transaccion> gettransaccioncuentaconotacreditosForeignKey() {
		return this.transaccioncuentaconotacreditosForeignKey;
	}

	public List<Transaccion> gettransaccioncuentaconotaventasForeignKey() {
		return this.transaccioncuentaconotaventasForeignKey;
	}

	public List<Transaccion> gettransaccioncuentacotarjetasForeignKey() {
		return this.transaccioncuentacotarjetasForeignKey;
	}

	public List<Transaccion> gettransaccioncuentapafacturasForeignKey() {
		return this.transaccioncuentapafacturasForeignKey;
	}

	public List<Transaccion> gettransaccioncuentapanotacreditosForeignKey() {
		return this.transaccioncuentapanotacreditosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void settransaccioninvenfacturasForeignKey(List<Transaccion> transaccioninvenfacturasForeignKey) {
		this.transaccioninvenfacturasForeignKey=transaccioninvenfacturasForeignKey;
	}

	public void settransaccioninvennotacreditosForeignKey(List<Transaccion> transaccioninvennotacreditosForeignKey) {
		this.transaccioninvennotacreditosForeignKey=transaccioninvennotacreditosForeignKey;
	}

	public void settransaccioninvennotaventasForeignKey(List<Transaccion> transaccioninvennotaventasForeignKey) {
		this.transaccioninvennotaventasForeignKey=transaccioninvennotaventasForeignKey;
	}

	public void settransaccioncuentacofacturasForeignKey(List<Transaccion> transaccioncuentacofacturasForeignKey) {
		this.transaccioncuentacofacturasForeignKey=transaccioncuentacofacturasForeignKey;
	}

	public void settransaccioncuentaconotacreditosForeignKey(List<Transaccion> transaccioncuentaconotacreditosForeignKey) {
		this.transaccioncuentaconotacreditosForeignKey=transaccioncuentaconotacreditosForeignKey;
	}

	public void settransaccioncuentaconotaventasForeignKey(List<Transaccion> transaccioncuentaconotaventasForeignKey) {
		this.transaccioncuentaconotaventasForeignKey=transaccioncuentaconotaventasForeignKey;
	}

	public void settransaccioncuentacotarjetasForeignKey(List<Transaccion> transaccioncuentacotarjetasForeignKey) {
		this.transaccioncuentacotarjetasForeignKey=transaccioncuentacotarjetasForeignKey;
	}

	public void settransaccioncuentapafacturasForeignKey(List<Transaccion> transaccioncuentapafacturasForeignKey) {
		this.transaccioncuentapafacturasForeignKey=transaccioncuentapafacturasForeignKey;
	}

	public void settransaccioncuentapanotacreditosForeignKey(List<Transaccion> transaccioncuentapanotacreditosForeignKey) {
		this.transaccioncuentapanotacreditosForeignKey=transaccioncuentapanotacreditosForeignKey;
	}
}

