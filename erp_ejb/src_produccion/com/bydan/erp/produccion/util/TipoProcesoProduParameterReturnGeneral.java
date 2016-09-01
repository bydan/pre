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
package com.bydan.erp.produccion.util;

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
import com.bydan.erp.produccion.util.TipoProcesoProduConstantesFunciones;

import com.bydan.erp.produccion.business.entity.*;//TipoProcesoProdu


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class TipoProcesoProduParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoProcesoProdu tipoprocesoprodu;	
	protected List<TipoProcesoProdu> tipoprocesoprodus;
	
	
	public List<Empresa> empresasForeignKey;
	
	public TipoProcesoProduParameterReturnGeneral () throws Exception {						
		super();
		this.tipoprocesoprodus= new ArrayList<TipoProcesoProdu>();
		this.tipoprocesoprodu= new TipoProcesoProdu();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public TipoProcesoProdu getTipoProcesoProdu() throws Exception {	
		return tipoprocesoprodu;
	}
		
	public void setTipoProcesoProdu(TipoProcesoProdu newTipoProcesoProdu) {
		this.tipoprocesoprodu = newTipoProcesoProdu;
	}
	
	public List<TipoProcesoProdu> getTipoProcesoProdus() throws Exception {		
		return tipoprocesoprodus;
	}
	
	public void setTipoProcesoProdus(List<TipoProcesoProdu> newTipoProcesoProdus) {
		this.tipoprocesoprodus = newTipoProcesoProdus;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

