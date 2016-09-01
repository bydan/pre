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
package com.bydan.erp.inventario.util;

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
import com.bydan.erp.inventario.util.RecargoCompraConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//RecargoCompra


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class RecargoCompraParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected RecargoCompra recargocompra;	
	protected List<RecargoCompra> recargocompras;
	
	
	public List<Empresa> empresasForeignKey;
	public List<CuentaContable> cuentacontabledebitosForeignKey;
	public List<CuentaContable> cuentacontablecreditosForeignKey;
	
	public RecargoCompraParameterReturnGeneral () throws Exception {						
		super();
		this.recargocompras= new ArrayList<RecargoCompra>();
		this.recargocompra= new RecargoCompra();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public RecargoCompra getRecargoCompra() throws Exception {	
		return recargocompra;
	}
		
	public void setRecargoCompra(RecargoCompra newRecargoCompra) {
		this.recargocompra = newRecargoCompra;
	}
	
	public List<RecargoCompra> getRecargoCompras() throws Exception {		
		return recargocompras;
	}
	
	public void setRecargoCompras(List<RecargoCompra> newRecargoCompras) {
		this.recargocompras = newRecargoCompras;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
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

	public void setcuentacontabledebitosForeignKey(List<CuentaContable> cuentacontabledebitosForeignKey) {
		this.cuentacontabledebitosForeignKey=cuentacontabledebitosForeignKey;
	}

	public void setcuentacontablecreditosForeignKey(List<CuentaContable> cuentacontablecreditosForeignKey) {
		this.cuentacontablecreditosForeignKey=cuentacontablecreditosForeignKey;
	}
}

