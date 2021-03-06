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
import com.bydan.erp.nomina.util.EnfermedadConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//Enfermedad


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class EnfermedadParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Enfermedad enfermedad;	
	protected List<Enfermedad> enfermedads;
	
	
	public List<Empresa> empresasForeignKey;
	public List<TipoEnfermedad> tipoenfermedadsForeignKey;
	
	public EnfermedadParameterReturnGeneral () throws Exception {						
		super();
		this.enfermedads= new ArrayList<Enfermedad>();
		this.enfermedad= new Enfermedad();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.tipoenfermedadsForeignKey=new ArrayList<TipoEnfermedad>();
	} 
	
	public Enfermedad getEnfermedad() throws Exception {	
		return enfermedad;
	}
		
	public void setEnfermedad(Enfermedad newEnfermedad) {
		this.enfermedad = newEnfermedad;
	}
	
	public List<Enfermedad> getEnfermedads() throws Exception {		
		return enfermedads;
	}
	
	public void setEnfermedads(List<Enfermedad> newEnfermedads) {
		this.enfermedads = newEnfermedads;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<TipoEnfermedad> gettipoenfermedadsForeignKey() {
		return this.tipoenfermedadsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settipoenfermedadsForeignKey(List<TipoEnfermedad> tipoenfermedadsForeignKey) {
		this.tipoenfermedadsForeignKey=tipoenfermedadsForeignKey;
	}
}

