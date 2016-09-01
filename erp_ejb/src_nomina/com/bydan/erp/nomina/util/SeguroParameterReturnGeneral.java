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
import com.bydan.erp.nomina.util.SeguroConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//Seguro




@SuppressWarnings("unused")
public class SeguroParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Seguro seguro;	
	protected List<Seguro> seguros;
	
	
	public List<Empleado> empleadosForeignKey;
	
	public SeguroParameterReturnGeneral () throws Exception {						
		super();
		this.seguros= new ArrayList<Seguro>();
		this.seguro= new Seguro();
		
		
		this.empleadosForeignKey=new ArrayList<Empleado>();
	} 
	
	public Seguro getSeguro() throws Exception {	
		return seguro;
	}
		
	public void setSeguro(Seguro newSeguro) {
		this.seguro = newSeguro;
	}
	
	public List<Seguro> getSeguros() throws Exception {		
		return seguros;
	}
	
	public void setSeguros(List<Seguro> newSeguros) {
		this.seguros = newSeguros;
	}
	
	

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}
	
	

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}
}

