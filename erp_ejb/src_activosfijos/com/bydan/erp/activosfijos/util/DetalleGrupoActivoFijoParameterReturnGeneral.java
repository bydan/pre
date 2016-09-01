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
import com.bydan.erp.activosfijos.util.DetalleGrupoActivoFijoConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.*;//DetalleGrupoActivoFijo


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class DetalleGrupoActivoFijoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleGrupoActivoFijo detallegrupoactivofijo;	
	protected List<DetalleGrupoActivoFijo> detallegrupoactivofijos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<CuentaContable> cuentacontablecostooriginalsForeignKey;
	public List<CuentaContable> cuentacontabledeprenormalsForeignKey;
	public List<CuentaContable> cuentacontabledepregastonormalsForeignKey;
	
	public DetalleGrupoActivoFijoParameterReturnGeneral () throws Exception {						
		super();
		this.detallegrupoactivofijos= new ArrayList<DetalleGrupoActivoFijo>();
		this.detallegrupoactivofijo= new DetalleGrupoActivoFijo();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.cuentacontablecostooriginalsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontabledeprenormalsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontabledepregastonormalsForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public DetalleGrupoActivoFijo getDetalleGrupoActivoFijo() throws Exception {	
		return detallegrupoactivofijo;
	}
		
	public void setDetalleGrupoActivoFijo(DetalleGrupoActivoFijo newDetalleGrupoActivoFijo) {
		this.detallegrupoactivofijo = newDetalleGrupoActivoFijo;
	}
	
	public List<DetalleGrupoActivoFijo> getDetalleGrupoActivoFijos() throws Exception {		
		return detallegrupoactivofijos;
	}
	
	public void setDetalleGrupoActivoFijos(List<DetalleGrupoActivoFijo> newDetalleGrupoActivoFijos) {
		this.detallegrupoactivofijos = newDetalleGrupoActivoFijos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<CuentaContable> getcuentacontablecostooriginalsForeignKey() {
		return this.cuentacontablecostooriginalsForeignKey;
	}

	public List<CuentaContable> getcuentacontabledeprenormalsForeignKey() {
		return this.cuentacontabledeprenormalsForeignKey;
	}

	public List<CuentaContable> getcuentacontabledepregastonormalsForeignKey() {
		return this.cuentacontabledepregastonormalsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setcuentacontablecostooriginalsForeignKey(List<CuentaContable> cuentacontablecostooriginalsForeignKey) {
		this.cuentacontablecostooriginalsForeignKey=cuentacontablecostooriginalsForeignKey;
	}

	public void setcuentacontabledeprenormalsForeignKey(List<CuentaContable> cuentacontabledeprenormalsForeignKey) {
		this.cuentacontabledeprenormalsForeignKey=cuentacontabledeprenormalsForeignKey;
	}

	public void setcuentacontabledepregastonormalsForeignKey(List<CuentaContable> cuentacontabledepregastonormalsForeignKey) {
		this.cuentacontabledepregastonormalsForeignKey=cuentacontabledepregastonormalsForeignKey;
	}
}

