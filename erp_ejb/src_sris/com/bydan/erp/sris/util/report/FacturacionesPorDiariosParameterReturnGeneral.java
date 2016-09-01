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
package com.bydan.erp.sris.util.report;

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
import com.bydan.erp.sris.util.report.FacturacionesPorDiariosConstantesFunciones;

import com.bydan.erp.sris.business.entity.report.*;//FacturacionesPorDiarios


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class FacturacionesPorDiariosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected FacturacionesPorDiarios facturacionespordiarios;	
	protected List<FacturacionesPorDiarios> facturacionespordiarioss;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Transaccion> transaccionsForeignKey;
	public List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey;
	
	public FacturacionesPorDiariosParameterReturnGeneral () throws Exception {						
		super();
		this.facturacionespordiarioss= new ArrayList<FacturacionesPorDiarios>();
		this.facturacionespordiarios= new FacturacionesPorDiarios();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.transaccionsForeignKey=new ArrayList<Transaccion>();
		this.tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
	} 
	
	public FacturacionesPorDiarios getFacturacionesPorDiarios() throws Exception {	
		return facturacionespordiarios;
	}
		
	public void setFacturacionesPorDiarios(FacturacionesPorDiarios newFacturacionesPorDiarios) {
		this.facturacionespordiarios = newFacturacionesPorDiarios;
	}
	
	public List<FacturacionesPorDiarios> getFacturacionesPorDiarioss() throws Exception {		
		return facturacionespordiarioss;
	}
	
	public void setFacturacionesPorDiarioss(List<FacturacionesPorDiarios> newFacturacionesPorDiarioss) {
		this.facturacionespordiarioss = newFacturacionesPorDiarioss;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Transaccion> gettransaccionsForeignKey() {
		return this.transaccionsForeignKey;
	}

	public List<TipoTransaccionModulo> gettipotransaccionmodulosForeignKey() {
		return this.tipotransaccionmodulosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settransaccionsForeignKey(List<Transaccion> transaccionsForeignKey) {
		this.transaccionsForeignKey=transaccionsForeignKey;
	}

	public void settipotransaccionmodulosForeignKey(List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey) {
		this.tipotransaccionmodulosForeignKey=tipotransaccionmodulosForeignKey;
	}
}

