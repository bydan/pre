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
import com.bydan.erp.contabilidad.util.SubGrupoParametroFormularioIvaConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//SubGrupoParametroFormularioIva


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class SubGrupoParametroFormularioIvaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected SubGrupoParametroFormularioIva subgrupoparametroformularioiva;	
	protected List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivas;
	
	
	public List<Empresa> empresasForeignKey;
	
	public SubGrupoParametroFormularioIvaParameterReturnGeneral () throws Exception {						
		super();
		this.subgrupoparametroformularioivas= new ArrayList<SubGrupoParametroFormularioIva>();
		this.subgrupoparametroformularioiva= new SubGrupoParametroFormularioIva();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public SubGrupoParametroFormularioIva getSubGrupoParametroFormularioIva() throws Exception {	
		return subgrupoparametroformularioiva;
	}
		
	public void setSubGrupoParametroFormularioIva(SubGrupoParametroFormularioIva newSubGrupoParametroFormularioIva) {
		this.subgrupoparametroformularioiva = newSubGrupoParametroFormularioIva;
	}
	
	public List<SubGrupoParametroFormularioIva> getSubGrupoParametroFormularioIvas() throws Exception {		
		return subgrupoparametroformularioivas;
	}
	
	public void setSubGrupoParametroFormularioIvas(List<SubGrupoParametroFormularioIva> newSubGrupoParametroFormularioIvas) {
		this.subgrupoparametroformularioivas = newSubGrupoParametroFormularioIvas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

