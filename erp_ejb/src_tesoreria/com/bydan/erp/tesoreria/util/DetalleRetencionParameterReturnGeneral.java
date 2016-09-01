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
package com.bydan.erp.tesoreria.util;

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
import com.bydan.erp.tesoreria.util.DetalleRetencionConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.*;//DetalleRetencion


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class DetalleRetencionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleRetencion detalleretencion;	
	protected List<DetalleRetencion> detalleretencions;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empresa> empresadestinosForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<CuentaContable> cuentacontablecreditosForeignKey;
	
	public DetalleRetencionParameterReturnGeneral () throws Exception {						
		super();
		this.detalleretencions= new ArrayList<DetalleRetencion>();
		this.detalleretencion= new DetalleRetencion();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empresadestinosForeignKey=new ArrayList<Empresa>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public DetalleRetencion getDetalleRetencion() throws Exception {	
		return detalleretencion;
	}
		
	public void setDetalleRetencion(DetalleRetencion newDetalleRetencion) {
		this.detalleretencion = newDetalleRetencion;
	}
	
	public List<DetalleRetencion> getDetalleRetencions() throws Exception {		
		return detalleretencions;
	}
	
	public void setDetalleRetencions(List<DetalleRetencion> newDetalleRetencions) {
		this.detalleretencions = newDetalleRetencions;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empresa> getempresadestinosForeignKey() {
		return this.empresadestinosForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<CuentaContable> getcuentacontablecreditosForeignKey() {
		return this.cuentacontablecreditosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempresadestinosForeignKey(List<Empresa> empresadestinosForeignKey) {
		this.empresadestinosForeignKey=empresadestinosForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void setcuentacontablecreditosForeignKey(List<CuentaContable> cuentacontablecreditosForeignKey) {
		this.cuentacontablecreditosForeignKey=cuentacontablecreditosForeignKey;
	}
}

