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
package com.bydan.erp.importaciones.util;

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
import com.bydan.erp.importaciones.util.LiquidacionImporConstantesFunciones;

import com.bydan.erp.importaciones.business.entity.*;//LiquidacionImpor


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class LiquidacionImporParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected LiquidacionImpor liquidacionimpor;	
	protected List<LiquidacionImpor> liquidacionimpors;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<CentroCosto> centrocostosForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<Pais> paissForeignKey;
	public List<Puerto> puertosForeignKey;
	
	public LiquidacionImporParameterReturnGeneral () throws Exception {						
		super();
		this.liquidacionimpors= new ArrayList<LiquidacionImpor>();
		this.liquidacionimpor= new LiquidacionImpor();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.centrocostosForeignKey=new ArrayList<CentroCosto>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.puertosForeignKey=new ArrayList<Puerto>();
	} 
	
	public LiquidacionImpor getLiquidacionImpor() throws Exception {	
		return liquidacionimpor;
	}
		
	public void setLiquidacionImpor(LiquidacionImpor newLiquidacionImpor) {
		this.liquidacionimpor = newLiquidacionImpor;
	}
	
	public List<LiquidacionImpor> getLiquidacionImpors() throws Exception {		
		return liquidacionimpors;
	}
	
	public void setLiquidacionImpors(List<LiquidacionImpor> newLiquidacionImpors) {
		this.liquidacionimpors = newLiquidacionImpors;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<CentroCosto> getcentrocostosForeignKey() {
		return this.centrocostosForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<Puerto> getpuertosForeignKey() {
		return this.puertosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setcentrocostosForeignKey(List<CentroCosto> centrocostosForeignKey) {
		this.centrocostosForeignKey=centrocostosForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setpuertosForeignKey(List<Puerto> puertosForeignKey) {
		this.puertosForeignKey=puertosForeignKey;
	}
}

