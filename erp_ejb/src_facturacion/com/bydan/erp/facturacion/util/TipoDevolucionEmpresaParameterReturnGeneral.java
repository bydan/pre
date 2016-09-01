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
package com.bydan.erp.facturacion.util;

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
import com.bydan.erp.facturacion.util.TipoDevolucionEmpresaConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//TipoDevolucionEmpresa


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoDevolucionEmpresaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoDevolucionEmpresa tipodevolucionempresa;	
	protected List<TipoDevolucionEmpresa> tipodevolucionempresas;
	
	
	public List<Empresa> empresasForeignKey;
	
	public TipoDevolucionEmpresaParameterReturnGeneral () throws Exception {						
		super();
		this.tipodevolucionempresas= new ArrayList<TipoDevolucionEmpresa>();
		this.tipodevolucionempresa= new TipoDevolucionEmpresa();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public TipoDevolucionEmpresa getTipoDevolucionEmpresa() throws Exception {	
		return tipodevolucionempresa;
	}
		
	public void setTipoDevolucionEmpresa(TipoDevolucionEmpresa newTipoDevolucionEmpresa) {
		this.tipodevolucionempresa = newTipoDevolucionEmpresa;
	}
	
	public List<TipoDevolucionEmpresa> getTipoDevolucionEmpresas() throws Exception {		
		return tipodevolucionempresas;
	}
	
	public void setTipoDevolucionEmpresas(List<TipoDevolucionEmpresa> newTipoDevolucionEmpresas) {
		this.tipodevolucionempresas = newTipoDevolucionEmpresas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

