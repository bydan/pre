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
import com.bydan.erp.nomina.util.TipoCursoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//TipoCurso


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoCursoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoCurso tipocurso;	
	protected List<TipoCurso> tipocursos;
	
	
	public List<Empresa> empresasForeignKey;
	
	public TipoCursoParameterReturnGeneral () throws Exception {						
		super();
		this.tipocursos= new ArrayList<TipoCurso>();
		this.tipocurso= new TipoCurso();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public TipoCurso getTipoCurso() throws Exception {	
		return tipocurso;
	}
		
	public void setTipoCurso(TipoCurso newTipoCurso) {
		this.tipocurso = newTipoCurso;
	}
	
	public List<TipoCurso> getTipoCursos() throws Exception {		
		return tipocursos;
	}
	
	public void setTipoCursos(List<TipoCurso> newTipoCursos) {
		this.tipocursos = newTipoCursos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

