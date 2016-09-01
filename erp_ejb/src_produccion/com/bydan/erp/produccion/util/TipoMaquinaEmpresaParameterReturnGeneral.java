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
package com.bydan.erp.produccion.util;

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
import com.bydan.erp.produccion.util.TipoMaquinaEmpresaConstantesFunciones;

import com.bydan.erp.produccion.business.entity.*;//TipoMaquinaEmpresa


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class TipoMaquinaEmpresaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoMaquinaEmpresa tipomaquinaempresa;	
	protected List<TipoMaquinaEmpresa> tipomaquinaempresas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<CuentaContable> cuentacontabledebitosForeignKey;
	public List<CuentaContable> cuentacontablecreditosForeignKey;
	
	public TipoMaquinaEmpresaParameterReturnGeneral () throws Exception {						
		super();
		this.tipomaquinaempresas= new ArrayList<TipoMaquinaEmpresa>();
		this.tipomaquinaempresa= new TipoMaquinaEmpresa();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public TipoMaquinaEmpresa getTipoMaquinaEmpresa() throws Exception {	
		return tipomaquinaempresa;
	}
		
	public void setTipoMaquinaEmpresa(TipoMaquinaEmpresa newTipoMaquinaEmpresa) {
		this.tipomaquinaempresa = newTipoMaquinaEmpresa;
	}
	
	public List<TipoMaquinaEmpresa> getTipoMaquinaEmpresas() throws Exception {		
		return tipomaquinaempresas;
	}
	
	public void setTipoMaquinaEmpresas(List<TipoMaquinaEmpresa> newTipoMaquinaEmpresas) {
		this.tipomaquinaempresas = newTipoMaquinaEmpresas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<CuentaContable> getcuentacontabledebitosForeignKey() {
		return this.cuentacontabledebitosForeignKey;
	}

	public List<CuentaContable> getcuentacontablecreditosForeignKey() {
		return this.cuentacontablecreditosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setcuentacontabledebitosForeignKey(List<CuentaContable> cuentacontabledebitosForeignKey) {
		this.cuentacontabledebitosForeignKey=cuentacontabledebitosForeignKey;
	}

	public void setcuentacontablecreditosForeignKey(List<CuentaContable> cuentacontablecreditosForeignKey) {
		this.cuentacontablecreditosForeignKey=cuentacontablecreditosForeignKey;
	}
}

