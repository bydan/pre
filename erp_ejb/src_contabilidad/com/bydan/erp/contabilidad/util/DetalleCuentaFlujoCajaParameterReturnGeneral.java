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
import com.bydan.erp.contabilidad.util.DetalleCuentaFlujoCajaConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//DetalleCuentaFlujoCaja


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class DetalleCuentaFlujoCajaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleCuentaFlujoCaja detallecuentaflujocaja;	
	protected List<DetalleCuentaFlujoCaja> detallecuentaflujocajas;
	
	
	public List<TipoOperacion> tipooperacionsForeignKey;
	public List<CuentaFlujoCaja> cuentaflujocajasForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	
	public DetalleCuentaFlujoCajaParameterReturnGeneral () throws Exception {						
		super();
		this.detallecuentaflujocajas= new ArrayList<DetalleCuentaFlujoCaja>();
		this.detallecuentaflujocaja= new DetalleCuentaFlujoCaja();
		
		
		this.tipooperacionsForeignKey=new ArrayList<TipoOperacion>();
		this.cuentaflujocajasForeignKey=new ArrayList<CuentaFlujoCaja>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public DetalleCuentaFlujoCaja getDetalleCuentaFlujoCaja() throws Exception {	
		return detallecuentaflujocaja;
	}
		
	public void setDetalleCuentaFlujoCaja(DetalleCuentaFlujoCaja newDetalleCuentaFlujoCaja) {
		this.detallecuentaflujocaja = newDetalleCuentaFlujoCaja;
	}
	
	public List<DetalleCuentaFlujoCaja> getDetalleCuentaFlujoCajas() throws Exception {		
		return detallecuentaflujocajas;
	}
	
	public void setDetalleCuentaFlujoCajas(List<DetalleCuentaFlujoCaja> newDetalleCuentaFlujoCajas) {
		this.detallecuentaflujocajas = newDetalleCuentaFlujoCajas;
	}
	
	

	public List<TipoOperacion> gettipooperacionsForeignKey() {
		return this.tipooperacionsForeignKey;
	}

	public List<CuentaFlujoCaja> getcuentaflujocajasForeignKey() {
		return this.cuentaflujocajasForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}
	
	

	public void settipooperacionsForeignKey(List<TipoOperacion> tipooperacionsForeignKey) {
		this.tipooperacionsForeignKey=tipooperacionsForeignKey;
	}

	public void setcuentaflujocajasForeignKey(List<CuentaFlujoCaja> cuentaflujocajasForeignKey) {
		this.cuentaflujocajasForeignKey=cuentaflujocajasForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}
}

