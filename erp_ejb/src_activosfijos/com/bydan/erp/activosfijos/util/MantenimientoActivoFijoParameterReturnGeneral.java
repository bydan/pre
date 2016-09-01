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
import com.bydan.erp.activosfijos.util.MantenimientoActivoFijoConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.*;//MantenimientoActivoFijo


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class MantenimientoActivoFijoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected MantenimientoActivoFijo mantenimientoactivofijo;	
	protected List<MantenimientoActivoFijo> mantenimientoactivofijos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<DetalleActivoFijo> detalleactivofijosForeignKey;
	public List<TipoMovimiento> tipomovimientosForeignKey;
	
	public MantenimientoActivoFijoParameterReturnGeneral () throws Exception {						
		super();
		this.mantenimientoactivofijos= new ArrayList<MantenimientoActivoFijo>();
		this.mantenimientoactivofijo= new MantenimientoActivoFijo();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
		this.tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
	} 
	
	public MantenimientoActivoFijo getMantenimientoActivoFijo() throws Exception {	
		return mantenimientoactivofijo;
	}
		
	public void setMantenimientoActivoFijo(MantenimientoActivoFijo newMantenimientoActivoFijo) {
		this.mantenimientoactivofijo = newMantenimientoActivoFijo;
	}
	
	public List<MantenimientoActivoFijo> getMantenimientoActivoFijos() throws Exception {		
		return mantenimientoactivofijos;
	}
	
	public void setMantenimientoActivoFijos(List<MantenimientoActivoFijo> newMantenimientoActivoFijos) {
		this.mantenimientoactivofijos = newMantenimientoActivoFijos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<DetalleActivoFijo> getdetalleactivofijosForeignKey() {
		return this.detalleactivofijosForeignKey;
	}

	public List<TipoMovimiento> gettipomovimientosForeignKey() {
		return this.tipomovimientosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setdetalleactivofijosForeignKey(List<DetalleActivoFijo> detalleactivofijosForeignKey) {
		this.detalleactivofijosForeignKey=detalleactivofijosForeignKey;
	}

	public void settipomovimientosForeignKey(List<TipoMovimiento> tipomovimientosForeignKey) {
		this.tipomovimientosForeignKey=tipomovimientosForeignKey;
	}
}

