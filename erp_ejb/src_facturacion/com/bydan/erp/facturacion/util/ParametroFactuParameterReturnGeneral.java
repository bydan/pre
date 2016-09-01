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
import com.bydan.erp.facturacion.util.ParametroFactuConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//ParametroFactu


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class ParametroFactuParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroFactu parametrofactu;	
	protected List<ParametroFactu> parametrofactus;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<CuentaContable> cuentacontablefactusForeignKey;
	public List<CuentaContable> cuentacontablefinansForeignKey;
	public List<CuentaContable> cuentacontableotrosForeignKey;
	public List<Formato> formatoproformasForeignKey;
	public List<Formato> formatopedidosForeignKey;
	public List<Formato> formatofacturasForeignKey;
	public List<Formato> formatonotacreditosForeignKey;
	public List<Formato> formatoinventariosForeignKey;
	
	public ParametroFactuParameterReturnGeneral () throws Exception {						
		super();
		this.parametrofactus= new ArrayList<ParametroFactu>();
		this.parametrofactu= new ParametroFactu();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.cuentacontablefactusForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablefinansForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableotrosForeignKey=new ArrayList<CuentaContable>();
		this.formatoproformasForeignKey=new ArrayList<Formato>();
		this.formatopedidosForeignKey=new ArrayList<Formato>();
		this.formatofacturasForeignKey=new ArrayList<Formato>();
		this.formatonotacreditosForeignKey=new ArrayList<Formato>();
		this.formatoinventariosForeignKey=new ArrayList<Formato>();
	} 
	
	public ParametroFactu getParametroFactu() throws Exception {	
		return parametrofactu;
	}
		
	public void setParametroFactu(ParametroFactu newParametroFactu) {
		this.parametrofactu = newParametroFactu;
	}
	
	public List<ParametroFactu> getParametroFactus() throws Exception {		
		return parametrofactus;
	}
	
	public void setParametroFactus(List<ParametroFactu> newParametroFactus) {
		this.parametrofactus = newParametroFactus;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<CuentaContable> getcuentacontablefactusForeignKey() {
		return this.cuentacontablefactusForeignKey;
	}

	public List<CuentaContable> getcuentacontablefinansForeignKey() {
		return this.cuentacontablefinansForeignKey;
	}

	public List<CuentaContable> getcuentacontableotrosForeignKey() {
		return this.cuentacontableotrosForeignKey;
	}

	public List<Formato> getformatoproformasForeignKey() {
		return this.formatoproformasForeignKey;
	}

	public List<Formato> getformatopedidosForeignKey() {
		return this.formatopedidosForeignKey;
	}

	public List<Formato> getformatofacturasForeignKey() {
		return this.formatofacturasForeignKey;
	}

	public List<Formato> getformatonotacreditosForeignKey() {
		return this.formatonotacreditosForeignKey;
	}

	public List<Formato> getformatoinventariosForeignKey() {
		return this.formatoinventariosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setcuentacontablefactusForeignKey(List<CuentaContable> cuentacontablefactusForeignKey) {
		this.cuentacontablefactusForeignKey=cuentacontablefactusForeignKey;
	}

	public void setcuentacontablefinansForeignKey(List<CuentaContable> cuentacontablefinansForeignKey) {
		this.cuentacontablefinansForeignKey=cuentacontablefinansForeignKey;
	}

	public void setcuentacontableotrosForeignKey(List<CuentaContable> cuentacontableotrosForeignKey) {
		this.cuentacontableotrosForeignKey=cuentacontableotrosForeignKey;
	}

	public void setformatoproformasForeignKey(List<Formato> formatoproformasForeignKey) {
		this.formatoproformasForeignKey=formatoproformasForeignKey;
	}

	public void setformatopedidosForeignKey(List<Formato> formatopedidosForeignKey) {
		this.formatopedidosForeignKey=formatopedidosForeignKey;
	}

	public void setformatofacturasForeignKey(List<Formato> formatofacturasForeignKey) {
		this.formatofacturasForeignKey=formatofacturasForeignKey;
	}

	public void setformatonotacreditosForeignKey(List<Formato> formatonotacreditosForeignKey) {
		this.formatonotacreditosForeignKey=formatonotacreditosForeignKey;
	}

	public void setformatoinventariosForeignKey(List<Formato> formatoinventariosForeignKey) {
		this.formatoinventariosForeignKey=formatoinventariosForeignKey;
	}
}

