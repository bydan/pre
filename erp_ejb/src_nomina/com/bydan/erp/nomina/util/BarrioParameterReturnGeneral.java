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
import com.bydan.erp.nomina.util.BarrioConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//Barrio


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class BarrioParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Barrio barrio;	
	protected List<Barrio> barrios;
	
	
	public List<Provincia> provinciasForeignKey;
	public List<Canton> cantonsForeignKey;
	public List<Parroquia> parroquiasForeignKey;
	
	public BarrioParameterReturnGeneral () throws Exception {						
		super();
		this.barrios= new ArrayList<Barrio>();
		this.barrio= new Barrio();
		
		
		this.provinciasForeignKey=new ArrayList<Provincia>();
		this.cantonsForeignKey=new ArrayList<Canton>();
		this.parroquiasForeignKey=new ArrayList<Parroquia>();
	} 
	
	public Barrio getBarrio() throws Exception {	
		return barrio;
	}
		
	public void setBarrio(Barrio newBarrio) {
		this.barrio = newBarrio;
	}
	
	public List<Barrio> getBarrios() throws Exception {		
		return barrios;
	}
	
	public void setBarrios(List<Barrio> newBarrios) {
		this.barrios = newBarrios;
	}
	
	

	public List<Provincia> getprovinciasForeignKey() {
		return this.provinciasForeignKey;
	}

	public List<Canton> getcantonsForeignKey() {
		return this.cantonsForeignKey;
	}

	public List<Parroquia> getparroquiasForeignKey() {
		return this.parroquiasForeignKey;
	}
	
	

	public void setprovinciasForeignKey(List<Provincia> provinciasForeignKey) {
		this.provinciasForeignKey=provinciasForeignKey;
	}

	public void setcantonsForeignKey(List<Canton> cantonsForeignKey) {
		this.cantonsForeignKey=cantonsForeignKey;
	}

	public void setparroquiasForeignKey(List<Parroquia> parroquiasForeignKey) {
		this.parroquiasForeignKey=parroquiasForeignKey;
	}
}

