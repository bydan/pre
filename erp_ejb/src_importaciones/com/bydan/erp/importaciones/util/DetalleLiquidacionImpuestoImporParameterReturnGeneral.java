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
import com.bydan.erp.importaciones.util.DetalleLiquidacionImpuestoImporConstantesFunciones;

import com.bydan.erp.importaciones.business.entity.*;//DetalleLiquidacionImpuestoImpor


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class DetalleLiquidacionImpuestoImporParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor;	
	protected List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors;
	
	
	public List<LiquidacionImpuestoImpor> liquidacionimpuestoimporsForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	
	public DetalleLiquidacionImpuestoImporParameterReturnGeneral () throws Exception {						
		super();
		this.detalleliquidacionimpuestoimpors= new ArrayList<DetalleLiquidacionImpuestoImpor>();
		this.detalleliquidacionimpuestoimpor= new DetalleLiquidacionImpuestoImpor();
		
		
		this.liquidacionimpuestoimporsForeignKey=new ArrayList<LiquidacionImpuestoImpor>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
	} 
	
	public DetalleLiquidacionImpuestoImpor getDetalleLiquidacionImpuestoImpor() throws Exception {	
		return detalleliquidacionimpuestoimpor;
	}
		
	public void setDetalleLiquidacionImpuestoImpor(DetalleLiquidacionImpuestoImpor newDetalleLiquidacionImpuestoImpor) {
		this.detalleliquidacionimpuestoimpor = newDetalleLiquidacionImpuestoImpor;
	}
	
	public List<DetalleLiquidacionImpuestoImpor> getDetalleLiquidacionImpuestoImpors() throws Exception {		
		return detalleliquidacionimpuestoimpors;
	}
	
	public void setDetalleLiquidacionImpuestoImpors(List<DetalleLiquidacionImpuestoImpor> newDetalleLiquidacionImpuestoImpors) {
		this.detalleliquidacionimpuestoimpors = newDetalleLiquidacionImpuestoImpors;
	}
	
	

	public List<LiquidacionImpuestoImpor> getliquidacionimpuestoimporsForeignKey() {
		return this.liquidacionimpuestoimporsForeignKey;
	}

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}
	
	

	public void setliquidacionimpuestoimporsForeignKey(List<LiquidacionImpuestoImpor> liquidacionimpuestoimporsForeignKey) {
		this.liquidacionimpuestoimporsForeignKey=liquidacionimpuestoimporsForeignKey;
	}

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}
}

