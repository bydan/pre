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
import com.bydan.erp.nomina.util.NumeroPatronalConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//NumeroPatronal


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


@SuppressWarnings("unused")
public class NumeroPatronalParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected NumeroPatronal numeropatronal;	
	protected List<NumeroPatronal> numeropatronals;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Provincia> provinciasForeignKey;
	public List<Canton> cantonsForeignKey;
	public List<Parroquia> parroquiasForeignKey;
	
	public NumeroPatronalParameterReturnGeneral () throws Exception {						
		super();
		this.numeropatronals= new ArrayList<NumeroPatronal>();
		this.numeropatronal= new NumeroPatronal();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.provinciasForeignKey=new ArrayList<Provincia>();
		this.cantonsForeignKey=new ArrayList<Canton>();
		this.parroquiasForeignKey=new ArrayList<Parroquia>();
	} 
	
	public NumeroPatronal getNumeroPatronal() throws Exception {	
		return numeropatronal;
	}
		
	public void setNumeroPatronal(NumeroPatronal newNumeroPatronal) {
		this.numeropatronal = newNumeroPatronal;
	}
	
	public List<NumeroPatronal> getNumeroPatronals() throws Exception {		
		return numeropatronals;
	}
	
	public void setNumeroPatronals(List<NumeroPatronal> newNumeroPatronals) {
		this.numeropatronals = newNumeroPatronals;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
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
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
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

