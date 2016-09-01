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
package com.bydan.erp.contabilidad.util;

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
import com.bydan.erp.contabilidad.util.ParametroContabilidadDefectoConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//ParametroContabilidadDefecto


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ParametroContabilidadDefectoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroContabilidadDefecto parametrocontabilidaddefecto;	
	protected List<ParametroContabilidadDefecto> parametrocontabilidaddefectos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<TipoMoneda> tipomonedasForeignKey;
	public List<Moneda> monedasForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<TipoIntervalo> tipointervalosForeignKey;
	public List<TipoMovimiento> tipomovimientosForeignKey;
	public List<TipoDocumento> tipodocumentosForeignKey;
	public List<EstadoAsientoContable> estadoasientocontablesForeignKey;
	
	public ParametroContabilidadDefectoParameterReturnGeneral () throws Exception {						
		super();
		this.parametrocontabilidaddefectos= new ArrayList<ParametroContabilidadDefecto>();
		this.parametrocontabilidaddefecto= new ParametroContabilidadDefecto();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.tipomonedasForeignKey=new ArrayList<TipoMoneda>();
		this.monedasForeignKey=new ArrayList<Moneda>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.tipointervalosForeignKey=new ArrayList<TipoIntervalo>();
		this.tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
		this.tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
		this.estadoasientocontablesForeignKey=new ArrayList<EstadoAsientoContable>();
	} 
	
	public ParametroContabilidadDefecto getParametroContabilidadDefecto() throws Exception {	
		return parametrocontabilidaddefecto;
	}
		
	public void setParametroContabilidadDefecto(ParametroContabilidadDefecto newParametroContabilidadDefecto) {
		this.parametrocontabilidaddefecto = newParametroContabilidadDefecto;
	}
	
	public List<ParametroContabilidadDefecto> getParametroContabilidadDefectos() throws Exception {		
		return parametrocontabilidaddefectos;
	}
	
	public void setParametroContabilidadDefectos(List<ParametroContabilidadDefecto> newParametroContabilidadDefectos) {
		this.parametrocontabilidaddefectos = newParametroContabilidadDefectos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<TipoMoneda> gettipomonedasForeignKey() {
		return this.tipomonedasForeignKey;
	}

	public List<Moneda> getmonedasForeignKey() {
		return this.monedasForeignKey;
	}

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}

	public List<TipoIntervalo> gettipointervalosForeignKey() {
		return this.tipointervalosForeignKey;
	}

	public List<TipoMovimiento> gettipomovimientosForeignKey() {
		return this.tipomovimientosForeignKey;
	}

	public List<TipoDocumento> gettipodocumentosForeignKey() {
		return this.tipodocumentosForeignKey;
	}

	public List<EstadoAsientoContable> getestadoasientocontablesForeignKey() {
		return this.estadoasientocontablesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void settipomonedasForeignKey(List<TipoMoneda> tipomonedasForeignKey) {
		this.tipomonedasForeignKey=tipomonedasForeignKey;
	}

	public void setmonedasForeignKey(List<Moneda> monedasForeignKey) {
		this.monedasForeignKey=monedasForeignKey;
	}

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}

	public void settipointervalosForeignKey(List<TipoIntervalo> tipointervalosForeignKey) {
		this.tipointervalosForeignKey=tipointervalosForeignKey;
	}

	public void settipomovimientosForeignKey(List<TipoMovimiento> tipomovimientosForeignKey) {
		this.tipomovimientosForeignKey=tipomovimientosForeignKey;
	}

	public void settipodocumentosForeignKey(List<TipoDocumento> tipodocumentosForeignKey) {
		this.tipodocumentosForeignKey=tipodocumentosForeignKey;
	}

	public void setestadoasientocontablesForeignKey(List<EstadoAsientoContable> estadoasientocontablesForeignKey) {
		this.estadoasientocontablesForeignKey=estadoasientocontablesForeignKey;
	}
}

