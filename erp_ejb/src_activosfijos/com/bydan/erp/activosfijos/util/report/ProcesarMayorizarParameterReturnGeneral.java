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
import com.bydan.erp.activosfijos.util.report.ProcesarMayorizarConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.report.*;//ProcesarMayorizar


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class ProcesarMayorizarParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProcesarMayorizar procesarmayorizar;	
	protected List<ProcesarMayorizar> procesarmayorizars;
	
	
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	public List<TipoDocumento> tipodocumentosForeignKey;
	
	public ProcesarMayorizarParameterReturnGeneral () throws Exception {						
		super();
		this.procesarmayorizars= new ArrayList<ProcesarMayorizar>();
		this.procesarmayorizar= new ProcesarMayorizar();
		
		
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
		this.tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
	} 
	
	public ProcesarMayorizar getProcesarMayorizar() throws Exception {	
		return procesarmayorizar;
	}
		
	public void setProcesarMayorizar(ProcesarMayorizar newProcesarMayorizar) {
		this.procesarmayorizar = newProcesarMayorizar;
	}
	
	public List<ProcesarMayorizar> getProcesarMayorizars() throws Exception {		
		return procesarmayorizars;
	}
	
	public void setProcesarMayorizars(List<ProcesarMayorizar> newProcesarMayorizars) {
		this.procesarmayorizars = newProcesarMayorizars;
	}
	
	

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}

	public List<TipoDocumento> gettipodocumentosForeignKey() {
		return this.tipodocumentosForeignKey;
	}
	
	

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}

	public void settipodocumentosForeignKey(List<TipoDocumento> tipodocumentosForeignKey) {
		this.tipodocumentosForeignKey=tipodocumentosForeignKey;
	}
}

