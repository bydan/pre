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
import com.bydan.erp.nomina.util.PreguntaNomiConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//PreguntaNomi


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class PreguntaNomiParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PreguntaNomi preguntanomi;	
	protected List<PreguntaNomi> preguntanomis;
	
	
	public List<Empresa> empresasForeignKey;
	public List<FactorNomi> factornomisForeignKey;
	
	public PreguntaNomiParameterReturnGeneral () throws Exception {						
		super();
		this.preguntanomis= new ArrayList<PreguntaNomi>();
		this.preguntanomi= new PreguntaNomi();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.factornomisForeignKey=new ArrayList<FactorNomi>();
	} 
	
	public PreguntaNomi getPreguntaNomi() throws Exception {	
		return preguntanomi;
	}
		
	public void setPreguntaNomi(PreguntaNomi newPreguntaNomi) {
		this.preguntanomi = newPreguntaNomi;
	}
	
	public List<PreguntaNomi> getPreguntaNomis() throws Exception {		
		return preguntanomis;
	}
	
	public void setPreguntaNomis(List<PreguntaNomi> newPreguntaNomis) {
		this.preguntanomis = newPreguntaNomis;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<FactorNomi> getfactornomisForeignKey() {
		return this.factornomisForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setfactornomisForeignKey(List<FactorNomi> factornomisForeignKey) {
		this.factornomisForeignKey=factornomisForeignKey;
	}
}

