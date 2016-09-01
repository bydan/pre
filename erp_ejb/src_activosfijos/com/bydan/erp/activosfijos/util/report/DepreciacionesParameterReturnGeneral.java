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
import com.bydan.erp.activosfijos.util.report.DepreciacionesConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.report.*;//Depreciaciones


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class DepreciacionesParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Depreciaciones depreciaciones;	
	protected List<Depreciaciones> depreciacioness;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Anio> anioiniciosForeignKey;
	public List<Anio> aniofinsForeignKey;
	public List<Mes> mesiniciosForeignKey;
	public List<Mes> mesfinsForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	
	public DepreciacionesParameterReturnGeneral () throws Exception {						
		super();
		this.depreciacioness= new ArrayList<Depreciaciones>();
		this.depreciaciones= new Depreciaciones();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.anioiniciosForeignKey=new ArrayList<Anio>();
		this.aniofinsForeignKey=new ArrayList<Anio>();
		this.mesiniciosForeignKey=new ArrayList<Mes>();
		this.mesfinsForeignKey=new ArrayList<Mes>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
	} 
	
	public Depreciaciones getDepreciaciones() throws Exception {	
		return depreciaciones;
	}
		
	public void setDepreciaciones(Depreciaciones newDepreciaciones) {
		this.depreciaciones = newDepreciaciones;
	}
	
	public List<Depreciaciones> getDepreciacioness() throws Exception {		
		return depreciacioness;
	}
	
	public void setDepreciacioness(List<Depreciaciones> newDepreciacioness) {
		this.depreciacioness = newDepreciacioness;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Anio> getanioiniciosForeignKey() {
		return this.anioiniciosForeignKey;
	}

	public List<Anio> getaniofinsForeignKey() {
		return this.aniofinsForeignKey;
	}

	public List<Mes> getmesiniciosForeignKey() {
		return this.mesiniciosForeignKey;
	}

	public List<Mes> getmesfinsForeignKey() {
		return this.mesfinsForeignKey;
	}

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setanioiniciosForeignKey(List<Anio> anioiniciosForeignKey) {
		this.anioiniciosForeignKey=anioiniciosForeignKey;
	}

	public void setaniofinsForeignKey(List<Anio> aniofinsForeignKey) {
		this.aniofinsForeignKey=aniofinsForeignKey;
	}

	public void setmesiniciosForeignKey(List<Mes> mesiniciosForeignKey) {
		this.mesiniciosForeignKey=mesiniciosForeignKey;
	}

	public void setmesfinsForeignKey(List<Mes> mesfinsForeignKey) {
		this.mesfinsForeignKey=mesfinsForeignKey;
	}

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}
}

