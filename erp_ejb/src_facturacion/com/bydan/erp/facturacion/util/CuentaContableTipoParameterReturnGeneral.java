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
import com.bydan.erp.facturacion.util.CuentaContableTipoConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//CuentaContableTipo


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class CuentaContableTipoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CuentaContableTipo cuentacontabletipo;	
	protected List<CuentaContableTipo> cuentacontabletipos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<TipoCuentaContableTipo> tipocuentacontabletiposForeignKey;
	public List<TipoProductoServicio> tipoproductoserviciosForeignKey;
	public List<CuentaContable> cuentacontableventasForeignKey;
	public List<CuentaContable> cuentacontabledescuentosForeignKey;
	public List<CuentaContable> cuentacontabledevolucionsForeignKey;
	public List<CuentaContable> cuentacontablecostosForeignKey;
	
	public CuentaContableTipoParameterReturnGeneral () throws Exception {						
		super();
		this.cuentacontabletipos= new ArrayList<CuentaContableTipo>();
		this.cuentacontabletipo= new CuentaContableTipo();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.tipocuentacontabletiposForeignKey=new ArrayList<TipoCuentaContableTipo>();
		this.tipoproductoserviciosForeignKey=new ArrayList<TipoProductoServicio>();
		this.cuentacontableventasForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontabledescuentosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontabledevolucionsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecostosForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public CuentaContableTipo getCuentaContableTipo() throws Exception {	
		return cuentacontabletipo;
	}
		
	public void setCuentaContableTipo(CuentaContableTipo newCuentaContableTipo) {
		this.cuentacontabletipo = newCuentaContableTipo;
	}
	
	public List<CuentaContableTipo> getCuentaContableTipos() throws Exception {		
		return cuentacontabletipos;
	}
	
	public void setCuentaContableTipos(List<CuentaContableTipo> newCuentaContableTipos) {
		this.cuentacontabletipos = newCuentaContableTipos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<TipoCuentaContableTipo> gettipocuentacontabletiposForeignKey() {
		return this.tipocuentacontabletiposForeignKey;
	}

	public List<TipoProductoServicio> gettipoproductoserviciosForeignKey() {
		return this.tipoproductoserviciosForeignKey;
	}

	public List<CuentaContable> getcuentacontableventasForeignKey() {
		return this.cuentacontableventasForeignKey;
	}

	public List<CuentaContable> getcuentacontabledescuentosForeignKey() {
		return this.cuentacontabledescuentosForeignKey;
	}

	public List<CuentaContable> getcuentacontabledevolucionsForeignKey() {
		return this.cuentacontabledevolucionsForeignKey;
	}

	public List<CuentaContable> getcuentacontablecostosForeignKey() {
		return this.cuentacontablecostosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settipocuentacontabletiposForeignKey(List<TipoCuentaContableTipo> tipocuentacontabletiposForeignKey) {
		this.tipocuentacontabletiposForeignKey=tipocuentacontabletiposForeignKey;
	}

	public void settipoproductoserviciosForeignKey(List<TipoProductoServicio> tipoproductoserviciosForeignKey) {
		this.tipoproductoserviciosForeignKey=tipoproductoserviciosForeignKey;
	}

	public void setcuentacontableventasForeignKey(List<CuentaContable> cuentacontableventasForeignKey) {
		this.cuentacontableventasForeignKey=cuentacontableventasForeignKey;
	}

	public void setcuentacontabledescuentosForeignKey(List<CuentaContable> cuentacontabledescuentosForeignKey) {
		this.cuentacontabledescuentosForeignKey=cuentacontabledescuentosForeignKey;
	}

	public void setcuentacontabledevolucionsForeignKey(List<CuentaContable> cuentacontabledevolucionsForeignKey) {
		this.cuentacontabledevolucionsForeignKey=cuentacontabledevolucionsForeignKey;
	}

	public void setcuentacontablecostosForeignKey(List<CuentaContable> cuentacontablecostosForeignKey) {
		this.cuentacontablecostosForeignKey=cuentacontablecostosForeignKey;
	}
}

