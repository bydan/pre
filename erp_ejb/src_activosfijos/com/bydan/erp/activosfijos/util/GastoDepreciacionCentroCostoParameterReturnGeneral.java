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
package com.bydan.erp.activosfijos.util;

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
import com.bydan.erp.activosfijos.util.GastoDepreciacionCentroCostoConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.*;//GastoDepreciacionCentroCosto


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class GastoDepreciacionCentroCostoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected GastoDepreciacionCentroCosto gastodepreciacioncentrocosto;	
	protected List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<CentroCosto> centrocostosForeignKey;
	public List<DetalleActivoFijo> detalleactivofijosForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	
	public GastoDepreciacionCentroCostoParameterReturnGeneral () throws Exception {						
		super();
		this.gastodepreciacioncentrocostos= new ArrayList<GastoDepreciacionCentroCosto>();
		this.gastodepreciacioncentrocosto= new GastoDepreciacionCentroCosto();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.centrocostosForeignKey=new ArrayList<CentroCosto>();
		this.detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public GastoDepreciacionCentroCosto getGastoDepreciacionCentroCosto() throws Exception {	
		return gastodepreciacioncentrocosto;
	}
		
	public void setGastoDepreciacionCentroCosto(GastoDepreciacionCentroCosto newGastoDepreciacionCentroCosto) {
		this.gastodepreciacioncentrocosto = newGastoDepreciacionCentroCosto;
	}
	
	public List<GastoDepreciacionCentroCosto> getGastoDepreciacionCentroCostos() throws Exception {		
		return gastodepreciacioncentrocostos;
	}
	
	public void setGastoDepreciacionCentroCostos(List<GastoDepreciacionCentroCosto> newGastoDepreciacionCentroCostos) {
		this.gastodepreciacioncentrocostos = newGastoDepreciacionCentroCostos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<CentroCosto> getcentrocostosForeignKey() {
		return this.centrocostosForeignKey;
	}

	public List<DetalleActivoFijo> getdetalleactivofijosForeignKey() {
		return this.detalleactivofijosForeignKey;
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

	public void setcentrocostosForeignKey(List<CentroCosto> centrocostosForeignKey) {
		this.centrocostosForeignKey=centrocostosForeignKey;
	}

	public void setdetalleactivofijosForeignKey(List<DetalleActivoFijo> detalleactivofijosForeignKey) {
		this.detalleactivofijosForeignKey=detalleactivofijosForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}
}

