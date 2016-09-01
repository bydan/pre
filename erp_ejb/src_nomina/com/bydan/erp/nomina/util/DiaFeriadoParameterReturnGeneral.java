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
import com.bydan.erp.nomina.util.DiaFeriadoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//DiaFeriado


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class DiaFeriadoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DiaFeriado diaferiado;	
	protected List<DiaFeriado> diaferiados;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Mes> messForeignKey;
	public List<Anio> aniosForeignKey;
	
	public DiaFeriadoParameterReturnGeneral () throws Exception {						
		super();
		this.diaferiados= new ArrayList<DiaFeriado>();
		this.diaferiado= new DiaFeriado();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.messForeignKey=new ArrayList<Mes>();
		this.aniosForeignKey=new ArrayList<Anio>();
	} 
	
	public DiaFeriado getDiaFeriado() throws Exception {	
		return diaferiado;
	}
		
	public void setDiaFeriado(DiaFeriado newDiaFeriado) {
		this.diaferiado = newDiaFeriado;
	}
	
	public List<DiaFeriado> getDiaFeriados() throws Exception {		
		return diaferiados;
	}
	
	public void setDiaFeriados(List<DiaFeriado> newDiaFeriados) {
		this.diaferiados = newDiaFeriados;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}
}

