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
import com.bydan.erp.contabilidad.util.DatoFormularioIvaConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//DatoFormularioIva


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class DatoFormularioIvaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DatoFormularioIva datoformularioiva;	
	protected List<DatoFormularioIva> datoformularioivas;
	
	
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	public List<Semestre> semestresForeignKey;
	
	public DatoFormularioIvaParameterReturnGeneral () throws Exception {						
		super();
		this.datoformularioivas= new ArrayList<DatoFormularioIva>();
		this.datoformularioiva= new DatoFormularioIva();
		
		
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
		this.semestresForeignKey=new ArrayList<Semestre>();
	} 
	
	public DatoFormularioIva getDatoFormularioIva() throws Exception {	
		return datoformularioiva;
	}
		
	public void setDatoFormularioIva(DatoFormularioIva newDatoFormularioIva) {
		this.datoformularioiva = newDatoFormularioIva;
	}
	
	public List<DatoFormularioIva> getDatoFormularioIvas() throws Exception {		
		return datoformularioivas;
	}
	
	public void setDatoFormularioIvas(List<DatoFormularioIva> newDatoFormularioIvas) {
		this.datoformularioivas = newDatoFormularioIvas;
	}
	
	

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}

	public List<Semestre> getsemestresForeignKey() {
		return this.semestresForeignKey;
	}
	
	

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}

	public void setsemestresForeignKey(List<Semestre> semestresForeignKey) {
		this.semestresForeignKey=semestresForeignKey;
	}
}

