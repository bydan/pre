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
package com.bydan.erp.cartera.util;

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
import com.bydan.erp.cartera.util.ParametroCarteraConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//ParametroCartera


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class ParametroCarteraParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroCartera parametrocartera;	
	protected List<ParametroCartera> parametrocarteras;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Transaccion> transaccionfacturasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Transaccion> transacciondeshabilitasForeignKey;
	public List<Transaccion> transaccionhabilitasForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<TipoFactura> tipofacturasForeignKey;
	public List<TipoAutoPago> tipoautopagosForeignKey;
	public List<CuentaContable> cuentacontablecreditofiscalsForeignKey;
	
	public ParametroCarteraParameterReturnGeneral () throws Exception {						
		super();
		this.parametrocarteras= new ArrayList<ParametroCartera>();
		this.parametrocartera= new ParametroCartera();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.transaccionfacturasForeignKey=new ArrayList<Transaccion>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.transacciondeshabilitasForeignKey=new ArrayList<Transaccion>();
		this.transaccionhabilitasForeignKey=new ArrayList<Transaccion>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.tipofacturasForeignKey=new ArrayList<TipoFactura>();
		this.tipoautopagosForeignKey=new ArrayList<TipoAutoPago>();
		this.cuentacontablecreditofiscalsForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public ParametroCartera getParametroCartera() throws Exception {	
		return parametrocartera;
	}
		
	public void setParametroCartera(ParametroCartera newParametroCartera) {
		this.parametrocartera = newParametroCartera;
	}
	
	public List<ParametroCartera> getParametroCarteras() throws Exception {		
		return parametrocarteras;
	}
	
	public void setParametroCarteras(List<ParametroCartera> newParametroCarteras) {
		this.parametrocarteras = newParametroCarteras;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Transaccion> gettransaccionfacturasForeignKey() {
		return this.transaccionfacturasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Transaccion> gettransacciondeshabilitasForeignKey() {
		return this.transacciondeshabilitasForeignKey;
	}

	public List<Transaccion> gettransaccionhabilitasForeignKey() {
		return this.transaccionhabilitasForeignKey;
	}

	public List<Bodega> getbodegasForeignKey() {
		return this.bodegasForeignKey;
	}

	public List<TipoFactura> gettipofacturasForeignKey() {
		return this.tipofacturasForeignKey;
	}

	public List<TipoAutoPago> gettipoautopagosForeignKey() {
		return this.tipoautopagosForeignKey;
	}

	public List<CuentaContable> getcuentacontablecreditofiscalsForeignKey() {
		return this.cuentacontablecreditofiscalsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settransaccionfacturasForeignKey(List<Transaccion> transaccionfacturasForeignKey) {
		this.transaccionfacturasForeignKey=transaccionfacturasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void settransacciondeshabilitasForeignKey(List<Transaccion> transacciondeshabilitasForeignKey) {
		this.transacciondeshabilitasForeignKey=transacciondeshabilitasForeignKey;
	}

	public void settransaccionhabilitasForeignKey(List<Transaccion> transaccionhabilitasForeignKey) {
		this.transaccionhabilitasForeignKey=transaccionhabilitasForeignKey;
	}

	public void setbodegasForeignKey(List<Bodega> bodegasForeignKey) {
		this.bodegasForeignKey=bodegasForeignKey;
	}

	public void settipofacturasForeignKey(List<TipoFactura> tipofacturasForeignKey) {
		this.tipofacturasForeignKey=tipofacturasForeignKey;
	}

	public void settipoautopagosForeignKey(List<TipoAutoPago> tipoautopagosForeignKey) {
		this.tipoautopagosForeignKey=tipoautopagosForeignKey;
	}

	public void setcuentacontablecreditofiscalsForeignKey(List<CuentaContable> cuentacontablecreditofiscalsForeignKey) {
		this.cuentacontablecreditofiscalsForeignKey=cuentacontablecreditofiscalsForeignKey;
	}
}

