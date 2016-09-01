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
import com.bydan.erp.tesoreria.util.PresupuestoFlujoCajaTsrConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.*;//PresupuestoFlujoCajaTsr


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class PresupuestoFlujoCajaTsrParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PresupuestoFlujoCajaTsr presupuestoflujocajatsr;	
	protected List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrs;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Usuario> usuariosForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	public List<TipoMovimiento> tipomovimientosForeignKey;
	public List<CentroActividad> centroactividadsForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<CentroCosto> centrocostosForeignKey;
	
	public PresupuestoFlujoCajaTsrParameterReturnGeneral () throws Exception {						
		super();
		this.presupuestoflujocajatsrs= new ArrayList<PresupuestoFlujoCajaTsr>();
		this.presupuestoflujocajatsr= new PresupuestoFlujoCajaTsr();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.usuariosForeignKey=new ArrayList<Usuario>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
		this.tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
		this.centroactividadsForeignKey=new ArrayList<CentroActividad>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.centrocostosForeignKey=new ArrayList<CentroCosto>();
	} 
	
	public PresupuestoFlujoCajaTsr getPresupuestoFlujoCajaTsr() throws Exception {	
		return presupuestoflujocajatsr;
	}
		
	public void setPresupuestoFlujoCajaTsr(PresupuestoFlujoCajaTsr newPresupuestoFlujoCajaTsr) {
		this.presupuestoflujocajatsr = newPresupuestoFlujoCajaTsr;
	}
	
	public List<PresupuestoFlujoCajaTsr> getPresupuestoFlujoCajaTsrs() throws Exception {		
		return presupuestoflujocajatsrs;
	}
	
	public void setPresupuestoFlujoCajaTsrs(List<PresupuestoFlujoCajaTsr> newPresupuestoFlujoCajaTsrs) {
		this.presupuestoflujocajatsrs = newPresupuestoFlujoCajaTsrs;
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

	public List<Usuario> getusuariosForeignKey() {
		return this.usuariosForeignKey;
	}

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}

	public List<TipoMovimiento> gettipomovimientosForeignKey() {
		return this.tipomovimientosForeignKey;
	}

	public List<CentroActividad> getcentroactividadsForeignKey() {
		return this.centroactividadsForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<CentroCosto> getcentrocostosForeignKey() {
		return this.centrocostosForeignKey;
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

	public void setusuariosForeignKey(List<Usuario> usuariosForeignKey) {
		this.usuariosForeignKey=usuariosForeignKey;
	}

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}

	public void settipomovimientosForeignKey(List<TipoMovimiento> tipomovimientosForeignKey) {
		this.tipomovimientosForeignKey=tipomovimientosForeignKey;
	}

	public void setcentroactividadsForeignKey(List<CentroActividad> centroactividadsForeignKey) {
		this.centroactividadsForeignKey=centroactividadsForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void setcentrocostosForeignKey(List<CentroCosto> centrocostosForeignKey) {
		this.centrocostosForeignKey=centrocostosForeignKey;
	}
}

