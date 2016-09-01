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
package com.bydan.erp.inventario.util.report;

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
import com.bydan.erp.inventario.util.report.ProcesoGenerarSaldosConstantesFunciones;

import com.bydan.erp.inventario.business.entity.report.*;//ProcesoGenerarSaldos


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class ProcesoGenerarSaldosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProcesoGenerarSaldos procesogenerarsaldos;	
	protected List<ProcesoGenerarSaldos> procesogenerarsaldoss;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey;
	
	public ProcesoGenerarSaldosParameterReturnGeneral () throws Exception {						
		super();
		this.procesogenerarsaldoss= new ArrayList<ProcesoGenerarSaldos>();
		this.procesogenerarsaldos= new ProcesoGenerarSaldos();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
	} 
	
	public ProcesoGenerarSaldos getProcesoGenerarSaldos() throws Exception {	
		return procesogenerarsaldos;
	}
		
	public void setProcesoGenerarSaldos(ProcesoGenerarSaldos newProcesoGenerarSaldos) {
		this.procesogenerarsaldos = newProcesoGenerarSaldos;
	}
	
	public List<ProcesoGenerarSaldos> getProcesoGenerarSaldoss() throws Exception {		
		return procesogenerarsaldoss;
	}
	
	public void setProcesoGenerarSaldoss(List<ProcesoGenerarSaldos> newProcesoGenerarSaldoss) {
		this.procesogenerarsaldoss = newProcesoGenerarSaldoss;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}

	public List<Periodo> getperiodosForeignKey() {
		return this.periodosForeignKey;
	}

	public List<TipoTransaccionModulo> gettipotransaccionmodulosForeignKey() {
		return this.tipotransaccionmodulosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setperiodosForeignKey(List<Periodo> periodosForeignKey) {
		this.periodosForeignKey=periodosForeignKey;
	}

	public void settipotransaccionmodulosForeignKey(List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey) {
		this.tipotransaccionmodulosForeignKey=tipotransaccionmodulosForeignKey;
	}
}

