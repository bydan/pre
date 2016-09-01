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
package com.bydan.erp.contabilidad.util.report;

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
import com.bydan.erp.contabilidad.util.report.ListadosPlanCuentasConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.report.*;//ListadosPlanCuentas


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ListadosPlanCuentasParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ListadosPlanCuentas listadosplancuentas;	
	protected List<ListadosPlanCuentas> listadosplancuentass;
	
	
	public List<Empresa> empresasForeignKey;
	
	public ListadosPlanCuentasParameterReturnGeneral () throws Exception {						
		super();
		this.listadosplancuentass= new ArrayList<ListadosPlanCuentas>();
		this.listadosplancuentas= new ListadosPlanCuentas();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public ListadosPlanCuentas getListadosPlanCuentas() throws Exception {	
		return listadosplancuentas;
	}
		
	public void setListadosPlanCuentas(ListadosPlanCuentas newListadosPlanCuentas) {
		this.listadosplancuentas = newListadosPlanCuentas;
	}
	
	public List<ListadosPlanCuentas> getListadosPlanCuentass() throws Exception {		
		return listadosplancuentass;
	}
	
	public void setListadosPlanCuentass(List<ListadosPlanCuentas> newListadosPlanCuentass) {
		this.listadosplancuentass = newListadosPlanCuentass;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

