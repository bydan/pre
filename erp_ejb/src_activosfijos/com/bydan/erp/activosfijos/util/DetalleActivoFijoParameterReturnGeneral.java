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
import com.bydan.erp.activosfijos.util.DetalleActivoFijoConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.*;//DetalleActivoFijo


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


@SuppressWarnings("unused")
public class DetalleActivoFijoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleActivoFijo detalleactivofijo;	
	protected List<DetalleActivoFijo> detalleactivofijos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<DetalleGrupoActivoFijo> detallegrupoactivofijosForeignKey;
	public List<SubGrupoActivoFijo> subgrupoactivofijosForeignKey;
	public List<TipoRamoActivoFijo> tiporamoactivofijosForeignKey;
	public List<TipoActivoFijoEmpresa> tipoactivofijoempresasForeignKey;
	public List<TipoDepreciacionEmpresa> tipodepreciacionempresasForeignKey;
	public List<EstadoActivoFijo> estadoactivofijosForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<PartidaPresu> partidapresusForeignKey;
	
	public DetalleActivoFijoParameterReturnGeneral () throws Exception {						
		super();
		this.detalleactivofijos= new ArrayList<DetalleActivoFijo>();
		this.detalleactivofijo= new DetalleActivoFijo();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.detallegrupoactivofijosForeignKey=new ArrayList<DetalleGrupoActivoFijo>();
		this.subgrupoactivofijosForeignKey=new ArrayList<SubGrupoActivoFijo>();
		this.tiporamoactivofijosForeignKey=new ArrayList<TipoRamoActivoFijo>();
		this.tipoactivofijoempresasForeignKey=new ArrayList<TipoActivoFijoEmpresa>();
		this.tipodepreciacionempresasForeignKey=new ArrayList<TipoDepreciacionEmpresa>();
		this.estadoactivofijosForeignKey=new ArrayList<EstadoActivoFijo>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.partidapresusForeignKey=new ArrayList<PartidaPresu>();
	} 
	
	public DetalleActivoFijo getDetalleActivoFijo() throws Exception {	
		return detalleactivofijo;
	}
		
	public void setDetalleActivoFijo(DetalleActivoFijo newDetalleActivoFijo) {
		this.detalleactivofijo = newDetalleActivoFijo;
	}
	
	public List<DetalleActivoFijo> getDetalleActivoFijos() throws Exception {		
		return detalleactivofijos;
	}
	
	public void setDetalleActivoFijos(List<DetalleActivoFijo> newDetalleActivoFijos) {
		this.detalleactivofijos = newDetalleActivoFijos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<DetalleGrupoActivoFijo> getdetallegrupoactivofijosForeignKey() {
		return this.detallegrupoactivofijosForeignKey;
	}

	public List<SubGrupoActivoFijo> getsubgrupoactivofijosForeignKey() {
		return this.subgrupoactivofijosForeignKey;
	}

	public List<TipoRamoActivoFijo> gettiporamoactivofijosForeignKey() {
		return this.tiporamoactivofijosForeignKey;
	}

	public List<TipoActivoFijoEmpresa> gettipoactivofijoempresasForeignKey() {
		return this.tipoactivofijoempresasForeignKey;
	}

	public List<TipoDepreciacionEmpresa> gettipodepreciacionempresasForeignKey() {
		return this.tipodepreciacionempresasForeignKey;
	}

	public List<EstadoActivoFijo> getestadoactivofijosForeignKey() {
		return this.estadoactivofijosForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<PartidaPresu> getpartidapresusForeignKey() {
		return this.partidapresusForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setdetallegrupoactivofijosForeignKey(List<DetalleGrupoActivoFijo> detallegrupoactivofijosForeignKey) {
		this.detallegrupoactivofijosForeignKey=detallegrupoactivofijosForeignKey;
	}

	public void setsubgrupoactivofijosForeignKey(List<SubGrupoActivoFijo> subgrupoactivofijosForeignKey) {
		this.subgrupoactivofijosForeignKey=subgrupoactivofijosForeignKey;
	}

	public void settiporamoactivofijosForeignKey(List<TipoRamoActivoFijo> tiporamoactivofijosForeignKey) {
		this.tiporamoactivofijosForeignKey=tiporamoactivofijosForeignKey;
	}

	public void settipoactivofijoempresasForeignKey(List<TipoActivoFijoEmpresa> tipoactivofijoempresasForeignKey) {
		this.tipoactivofijoempresasForeignKey=tipoactivofijoempresasForeignKey;
	}

	public void settipodepreciacionempresasForeignKey(List<TipoDepreciacionEmpresa> tipodepreciacionempresasForeignKey) {
		this.tipodepreciacionempresasForeignKey=tipodepreciacionempresasForeignKey;
	}

	public void setestadoactivofijosForeignKey(List<EstadoActivoFijo> estadoactivofijosForeignKey) {
		this.estadoactivofijosForeignKey=estadoactivofijosForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void setpartidapresusForeignKey(List<PartidaPresu> partidapresusForeignKey) {
		this.partidapresusForeignKey=partidapresusForeignKey;
	}
}

