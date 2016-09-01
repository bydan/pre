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
package com.bydan.erp.nomina.util;

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
import com.bydan.erp.nomina.util.RubroEmpleaConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//RubroEmplea


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class RubroEmpleaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected RubroEmplea rubroemplea;	
	protected List<RubroEmplea> rubroempleas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<TipoCalculo> tipocalculosForeignKey;
	public List<TipoRubroEmplea> tiporubroempleasForeignKey;
	public List<TipoGrupoRubroEmplea> tipogruporubroempleasForeignKey;
	
	public RubroEmpleaParameterReturnGeneral () throws Exception {						
		super();
		this.rubroempleas= new ArrayList<RubroEmplea>();
		this.rubroemplea= new RubroEmplea();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.tipocalculosForeignKey=new ArrayList<TipoCalculo>();
		this.tiporubroempleasForeignKey=new ArrayList<TipoRubroEmplea>();
		this.tipogruporubroempleasForeignKey=new ArrayList<TipoGrupoRubroEmplea>();
	} 
	
	public RubroEmplea getRubroEmplea() throws Exception {	
		return rubroemplea;
	}
		
	public void setRubroEmplea(RubroEmplea newRubroEmplea) {
		this.rubroemplea = newRubroEmplea;
	}
	
	public List<RubroEmplea> getRubroEmpleas() throws Exception {		
		return rubroempleas;
	}
	
	public void setRubroEmpleas(List<RubroEmplea> newRubroEmpleas) {
		this.rubroempleas = newRubroEmpleas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<TipoCalculo> gettipocalculosForeignKey() {
		return this.tipocalculosForeignKey;
	}

	public List<TipoRubroEmplea> gettiporubroempleasForeignKey() {
		return this.tiporubroempleasForeignKey;
	}

	public List<TipoGrupoRubroEmplea> gettipogruporubroempleasForeignKey() {
		return this.tipogruporubroempleasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settipocalculosForeignKey(List<TipoCalculo> tipocalculosForeignKey) {
		this.tipocalculosForeignKey=tipocalculosForeignKey;
	}

	public void settiporubroempleasForeignKey(List<TipoRubroEmplea> tiporubroempleasForeignKey) {
		this.tiporubroempleasForeignKey=tiporubroempleasForeignKey;
	}

	public void settipogruporubroempleasForeignKey(List<TipoGrupoRubroEmplea> tipogruporubroempleasForeignKey) {
		this.tipogruporubroempleasForeignKey=tipogruporubroempleasForeignKey;
	}
}

