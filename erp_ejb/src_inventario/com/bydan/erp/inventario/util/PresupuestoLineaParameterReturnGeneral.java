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
package com.bydan.erp.inventario.util;

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
import com.bydan.erp.inventario.util.PresupuestoLineaConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//PresupuestoLinea


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class PresupuestoLineaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PresupuestoLinea presupuestolinea;	
	protected List<PresupuestoLinea> presupuestolineas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Linea> lineasForeignKey;
	
	public PresupuestoLineaParameterReturnGeneral () throws Exception {						
		super();
		this.presupuestolineas= new ArrayList<PresupuestoLinea>();
		this.presupuestolinea= new PresupuestoLinea();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.lineasForeignKey=new ArrayList<Linea>();
	} 
	
	public PresupuestoLinea getPresupuestoLinea() throws Exception {	
		return presupuestolinea;
	}
		
	public void setPresupuestoLinea(PresupuestoLinea newPresupuestoLinea) {
		this.presupuestolinea = newPresupuestoLinea;
	}
	
	public List<PresupuestoLinea> getPresupuestoLineas() throws Exception {		
		return presupuestolineas;
	}
	
	public void setPresupuestoLineas(List<PresupuestoLinea> newPresupuestoLineas) {
		this.presupuestolineas = newPresupuestoLineas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Linea> getlineasForeignKey() {
		return this.lineasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setlineasForeignKey(List<Linea> lineasForeignKey) {
		this.lineasForeignKey=lineasForeignKey;
	}
}

