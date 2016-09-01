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
package com.bydan.erp.cartera.util.report;

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
import com.bydan.erp.cartera.util.report.SaldosCuentasPorPagarConstantesFunciones;

import com.bydan.erp.cartera.business.entity.report.*;//SaldosCuentasPorPagar


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class SaldosCuentasPorPagarParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected SaldosCuentasPorPagar saldoscuentasporpagar;	
	protected List<SaldosCuentasPorPagar> saldoscuentasporpagars;
	
	
	public List<Zona> zonasForeignKey;
	public List<GrupoCliente> grupoclientesForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Cliente> clientesForeignKey;
	
	public SaldosCuentasPorPagarParameterReturnGeneral () throws Exception {						
		super();
		this.saldoscuentasporpagars= new ArrayList<SaldosCuentasPorPagar>();
		this.saldoscuentasporpagar= new SaldosCuentasPorPagar();
		
		
		this.zonasForeignKey=new ArrayList<Zona>();
		this.grupoclientesForeignKey=new ArrayList<GrupoCliente>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.clientesForeignKey=new ArrayList<Cliente>();
	} 
	
	public SaldosCuentasPorPagar getSaldosCuentasPorPagar() throws Exception {	
		return saldoscuentasporpagar;
	}
		
	public void setSaldosCuentasPorPagar(SaldosCuentasPorPagar newSaldosCuentasPorPagar) {
		this.saldoscuentasporpagar = newSaldosCuentasPorPagar;
	}
	
	public List<SaldosCuentasPorPagar> getSaldosCuentasPorPagars() throws Exception {		
		return saldoscuentasporpagars;
	}
	
	public void setSaldosCuentasPorPagars(List<SaldosCuentasPorPagar> newSaldosCuentasPorPagars) {
		this.saldoscuentasporpagars = newSaldosCuentasPorPagars;
	}
	
	

	public List<Zona> getzonasForeignKey() {
		return this.zonasForeignKey;
	}

	public List<GrupoCliente> getgrupoclientesForeignKey() {
		return this.grupoclientesForeignKey;
	}

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}
	
	

	public void setzonasForeignKey(List<Zona> zonasForeignKey) {
		this.zonasForeignKey=zonasForeignKey;
	}

	public void setgrupoclientesForeignKey(List<GrupoCliente> grupoclientesForeignKey) {
		this.grupoclientesForeignKey=grupoclientesForeignKey;
	}

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}
}

