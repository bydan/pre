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
import com.bydan.erp.activosfijos.util.DepreciacionActivoFijoConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.*;//DepreciacionActivoFijo


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class DepreciacionActivoFijoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DepreciacionActivoFijo depreciacionactivofijo;	
	protected List<DepreciacionActivoFijo> depreciacionactivofijos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<DetalleActivoFijo> detalleactivofijosForeignKey;
	public List<TipoDepreciacionEmpresa> tipodepreciacionempresasForeignKey;
	public List<EstadoDepreActi> estadodepreactisForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	
	public DepreciacionActivoFijoParameterReturnGeneral () throws Exception {						
		super();
		this.depreciacionactivofijos= new ArrayList<DepreciacionActivoFijo>();
		this.depreciacionactivofijo= new DepreciacionActivoFijo();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
		this.tipodepreciacionempresasForeignKey=new ArrayList<TipoDepreciacionEmpresa>();
		this.estadodepreactisForeignKey=new ArrayList<EstadoDepreActi>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
	} 
	
	public DepreciacionActivoFijo getDepreciacionActivoFijo() throws Exception {	
		return depreciacionactivofijo;
	}
		
	public void setDepreciacionActivoFijo(DepreciacionActivoFijo newDepreciacionActivoFijo) {
		this.depreciacionactivofijo = newDepreciacionActivoFijo;
	}
	
	public List<DepreciacionActivoFijo> getDepreciacionActivoFijos() throws Exception {		
		return depreciacionactivofijos;
	}
	
	public void setDepreciacionActivoFijos(List<DepreciacionActivoFijo> newDepreciacionActivoFijos) {
		this.depreciacionactivofijos = newDepreciacionActivoFijos;
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

	public List<TipoDepreciacionEmpresa> gettipodepreciacionempresasForeignKey() {
		return this.tipodepreciacionempresasForeignKey;
	}

	public List<EstadoDepreActi> getestadodepreactisForeignKey() {
		return this.estadodepreactisForeignKey;
	}

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
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

	public void settipodepreciacionempresasForeignKey(List<TipoDepreciacionEmpresa> tipodepreciacionempresasForeignKey) {
		this.tipodepreciacionempresasForeignKey=tipodepreciacionempresasForeignKey;
	}

	public void setestadodepreactisForeignKey(List<EstadoDepreActi> estadodepreactisForeignKey) {
		this.estadodepreactisForeignKey=estadodepreactisForeignKey;
	}

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}
}

