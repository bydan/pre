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
import com.bydan.erp.importaciones.util.DetalleLiquidacionImporConstantesFunciones;

import com.bydan.erp.importaciones.business.entity.*;//DetalleLiquidacionImpor


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class DetalleLiquidacionImporParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleLiquidacionImpor detalleliquidacionimpor;	
	protected List<DetalleLiquidacionImpor> detalleliquidacionimpors;
	
	
	public List<LiquidacionImpor> liquidacionimporsForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Usuario> usuariosForeignKey;
	public List<CentroCosto> centrocostosForeignKey;
	public List<CostoGastoImpor> costogastoimporsForeignKey;
	
	public DetalleLiquidacionImporParameterReturnGeneral () throws Exception {						
		super();
		this.detalleliquidacionimpors= new ArrayList<DetalleLiquidacionImpor>();
		this.detalleliquidacionimpor= new DetalleLiquidacionImpor();
		
		
		this.liquidacionimporsForeignKey=new ArrayList<LiquidacionImpor>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.usuariosForeignKey=new ArrayList<Usuario>();
		this.centrocostosForeignKey=new ArrayList<CentroCosto>();
		this.costogastoimporsForeignKey=new ArrayList<CostoGastoImpor>();
	} 
	
	public DetalleLiquidacionImpor getDetalleLiquidacionImpor() throws Exception {	
		return detalleliquidacionimpor;
	}
		
	public void setDetalleLiquidacionImpor(DetalleLiquidacionImpor newDetalleLiquidacionImpor) {
		this.detalleliquidacionimpor = newDetalleLiquidacionImpor;
	}
	
	public List<DetalleLiquidacionImpor> getDetalleLiquidacionImpors() throws Exception {		
		return detalleliquidacionimpors;
	}
	
	public void setDetalleLiquidacionImpors(List<DetalleLiquidacionImpor> newDetalleLiquidacionImpors) {
		this.detalleliquidacionimpors = newDetalleLiquidacionImpors;
	}
	
	

	public List<LiquidacionImpor> getliquidacionimporsForeignKey() {
		return this.liquidacionimporsForeignKey;
	}

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Usuario> getusuariosForeignKey() {
		return this.usuariosForeignKey;
	}

	public List<CentroCosto> getcentrocostosForeignKey() {
		return this.centrocostosForeignKey;
	}

	public List<CostoGastoImpor> getcostogastoimporsForeignKey() {
		return this.costogastoimporsForeignKey;
	}
	
	

	public void setliquidacionimporsForeignKey(List<LiquidacionImpor> liquidacionimporsForeignKey) {
		this.liquidacionimporsForeignKey=liquidacionimporsForeignKey;
	}

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setusuariosForeignKey(List<Usuario> usuariosForeignKey) {
		this.usuariosForeignKey=usuariosForeignKey;
	}

	public void setcentrocostosForeignKey(List<CentroCosto> centrocostosForeignKey) {
		this.centrocostosForeignKey=centrocostosForeignKey;
	}

	public void setcostogastoimporsForeignKey(List<CostoGastoImpor> costogastoimporsForeignKey) {
		this.costogastoimporsForeignKey=costogastoimporsForeignKey;
	}
}

