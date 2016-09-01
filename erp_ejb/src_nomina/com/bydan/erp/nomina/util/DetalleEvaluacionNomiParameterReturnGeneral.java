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
import com.bydan.erp.nomina.util.DetalleEvaluacionNomiConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//DetalleEvaluacionNomi


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class DetalleEvaluacionNomiParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleEvaluacionNomi detalleevaluacionnomi;	
	protected List<DetalleEvaluacionNomi> detalleevaluacionnomis;
	
	
	public List<Empresa> empresasForeignKey;
	public List<EvaluacionNomi> evaluacionnomisForeignKey;
	public List<FormatoNomi> formatonomisForeignKey;
	public List<PreguntaNomi> preguntanomisForeignKey;
	
	public DetalleEvaluacionNomiParameterReturnGeneral () throws Exception {						
		super();
		this.detalleevaluacionnomis= new ArrayList<DetalleEvaluacionNomi>();
		this.detalleevaluacionnomi= new DetalleEvaluacionNomi();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.evaluacionnomisForeignKey=new ArrayList<EvaluacionNomi>();
		this.formatonomisForeignKey=new ArrayList<FormatoNomi>();
		this.preguntanomisForeignKey=new ArrayList<PreguntaNomi>();
	} 
	
	public DetalleEvaluacionNomi getDetalleEvaluacionNomi() throws Exception {	
		return detalleevaluacionnomi;
	}
		
	public void setDetalleEvaluacionNomi(DetalleEvaluacionNomi newDetalleEvaluacionNomi) {
		this.detalleevaluacionnomi = newDetalleEvaluacionNomi;
	}
	
	public List<DetalleEvaluacionNomi> getDetalleEvaluacionNomis() throws Exception {		
		return detalleevaluacionnomis;
	}
	
	public void setDetalleEvaluacionNomis(List<DetalleEvaluacionNomi> newDetalleEvaluacionNomis) {
		this.detalleevaluacionnomis = newDetalleEvaluacionNomis;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<EvaluacionNomi> getevaluacionnomisForeignKey() {
		return this.evaluacionnomisForeignKey;
	}

	public List<FormatoNomi> getformatonomisForeignKey() {
		return this.formatonomisForeignKey;
	}

	public List<PreguntaNomi> getpreguntanomisForeignKey() {
		return this.preguntanomisForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setevaluacionnomisForeignKey(List<EvaluacionNomi> evaluacionnomisForeignKey) {
		this.evaluacionnomisForeignKey=evaluacionnomisForeignKey;
	}

	public void setformatonomisForeignKey(List<FormatoNomi> formatonomisForeignKey) {
		this.formatonomisForeignKey=formatonomisForeignKey;
	}

	public void setpreguntanomisForeignKey(List<PreguntaNomi> preguntanomisForeignKey) {
		this.preguntanomisForeignKey=preguntanomisForeignKey;
	}
}

