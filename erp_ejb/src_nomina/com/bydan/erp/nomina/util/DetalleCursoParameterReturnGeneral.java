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
import com.bydan.erp.nomina.util.DetalleCursoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//DetalleCurso




@SuppressWarnings("unused")
public class DetalleCursoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleCurso detallecurso;	
	protected List<DetalleCurso> detallecursos;
	
	
	public List<Curso> cursosForeignKey;
	
	public DetalleCursoParameterReturnGeneral () throws Exception {						
		super();
		this.detallecursos= new ArrayList<DetalleCurso>();
		this.detallecurso= new DetalleCurso();
		
		
		this.cursosForeignKey=new ArrayList<Curso>();
	} 
	
	public DetalleCurso getDetalleCurso() throws Exception {	
		return detallecurso;
	}
		
	public void setDetalleCurso(DetalleCurso newDetalleCurso) {
		this.detallecurso = newDetalleCurso;
	}
	
	public List<DetalleCurso> getDetalleCursos() throws Exception {		
		return detallecursos;
	}
	
	public void setDetalleCursos(List<DetalleCurso> newDetalleCursos) {
		this.detallecursos = newDetalleCursos;
	}
	
	

	public List<Curso> getcursosForeignKey() {
		return this.cursosForeignKey;
	}
	
	

	public void setcursosForeignKey(List<Curso> cursosForeignKey) {
		this.cursosForeignKey=cursosForeignKey;
	}
}

