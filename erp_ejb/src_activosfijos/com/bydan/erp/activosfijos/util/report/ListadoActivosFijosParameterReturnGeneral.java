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
package com.bydan.erp.activosfijos.util.report;

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
import com.bydan.erp.activosfijos.util.report.ListadoActivosFijosConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.report.*;//ListadoActivosFijos


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ListadoActivosFijosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ListadoActivosFijos listadoactivosfijos;	
	protected List<ListadoActivosFijos> listadoactivosfijoss;
	
	
	public List<Empresa> empresasForeignKey;
	
	public ListadoActivosFijosParameterReturnGeneral () throws Exception {						
		super();
		this.listadoactivosfijoss= new ArrayList<ListadoActivosFijos>();
		this.listadoactivosfijos= new ListadoActivosFijos();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public ListadoActivosFijos getListadoActivosFijos() throws Exception {	
		return listadoactivosfijos;
	}
		
	public void setListadoActivosFijos(ListadoActivosFijos newListadoActivosFijos) {
		this.listadoactivosfijos = newListadoActivosFijos;
	}
	
	public List<ListadoActivosFijos> getListadoActivosFijoss() throws Exception {		
		return listadoactivosfijoss;
	}
	
	public void setListadoActivosFijoss(List<ListadoActivosFijos> newListadoActivosFijoss) {
		this.listadoactivosfijoss = newListadoActivosFijoss;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

