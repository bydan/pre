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
import com.bydan.erp.produccion.util.TipoGastoProduEmpresaConstantesFunciones;

import com.bydan.erp.produccion.business.entity.*;//TipoGastoProduEmpresa


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoGastoProduEmpresaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoGastoProduEmpresa tipogastoproduempresa;	
	protected List<TipoGastoProduEmpresa> tipogastoproduempresas;
	
	
	public List<Empresa> empresasForeignKey;
	
	public TipoGastoProduEmpresaParameterReturnGeneral () throws Exception {						
		super();
		this.tipogastoproduempresas= new ArrayList<TipoGastoProduEmpresa>();
		this.tipogastoproduempresa= new TipoGastoProduEmpresa();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public TipoGastoProduEmpresa getTipoGastoProduEmpresa() throws Exception {	
		return tipogastoproduempresa;
	}
		
	public void setTipoGastoProduEmpresa(TipoGastoProduEmpresa newTipoGastoProduEmpresa) {
		this.tipogastoproduempresa = newTipoGastoProduEmpresa;
	}
	
	public List<TipoGastoProduEmpresa> getTipoGastoProduEmpresas() throws Exception {		
		return tipogastoproduempresas;
	}
	
	public void setTipoGastoProduEmpresas(List<TipoGastoProduEmpresa> newTipoGastoProduEmpresas) {
		this.tipogastoproduempresas = newTipoGastoProduEmpresas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

