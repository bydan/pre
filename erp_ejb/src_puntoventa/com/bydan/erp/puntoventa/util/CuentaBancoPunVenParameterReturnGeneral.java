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
import com.bydan.erp.puntoventa.util.CuentaBancoPunVenConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//CuentaBancoPunVen


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class CuentaBancoPunVenParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CuentaBancoPunVen cuentabancopunven;	
	protected List<CuentaBancoPunVen> cuentabancopunvens;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Banco> bancosForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	
	public CuentaBancoPunVenParameterReturnGeneral () throws Exception {						
		super();
		this.cuentabancopunvens= new ArrayList<CuentaBancoPunVen>();
		this.cuentabancopunven= new CuentaBancoPunVen();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.bancosForeignKey=new ArrayList<Banco>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public CuentaBancoPunVen getCuentaBancoPunVen() throws Exception {	
		return cuentabancopunven;
	}
		
	public void setCuentaBancoPunVen(CuentaBancoPunVen newCuentaBancoPunVen) {
		this.cuentabancopunven = newCuentaBancoPunVen;
	}
	
	public List<CuentaBancoPunVen> getCuentaBancoPunVens() throws Exception {		
		return cuentabancopunvens;
	}
	
	public void setCuentaBancoPunVens(List<CuentaBancoPunVen> newCuentaBancoPunVens) {
		this.cuentabancopunvens = newCuentaBancoPunVens;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Banco> getbancosForeignKey() {
		return this.bancosForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setbancosForeignKey(List<Banco> bancosForeignKey) {
		this.bancosForeignKey=bancosForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}
}

