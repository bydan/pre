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
import com.bydan.erp.nomina.util.HistorialPagoNomiConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//HistorialPagoNomi


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class HistorialPagoNomiParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected HistorialPagoNomi historialpagonomi;	
	protected List<HistorialPagoNomi> historialpagonomis;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Estructura> estructurasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<RubroEmplea> rubroempleasForeignKey;
	public List<Mes> messForeignKey;
	
	public HistorialPagoNomiParameterReturnGeneral () throws Exception {						
		super();
		this.historialpagonomis= new ArrayList<HistorialPagoNomi>();
		this.historialpagonomi= new HistorialPagoNomi();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.rubroempleasForeignKey=new ArrayList<RubroEmplea>();
		this.messForeignKey=new ArrayList<Mes>();
	} 
	
	public HistorialPagoNomi getHistorialPagoNomi() throws Exception {	
		return historialpagonomi;
	}
		
	public void setHistorialPagoNomi(HistorialPagoNomi newHistorialPagoNomi) {
		this.historialpagonomi = newHistorialPagoNomi;
	}
	
	public List<HistorialPagoNomi> getHistorialPagoNomis() throws Exception {		
		return historialpagonomis;
	}
	
	public void setHistorialPagoNomis(List<HistorialPagoNomi> newHistorialPagoNomis) {
		this.historialpagonomis = newHistorialPagoNomis;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Estructura> getestructurasForeignKey() {
		return this.estructurasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<RubroEmplea> getrubroempleasForeignKey() {
		return this.rubroempleasForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setestructurasForeignKey(List<Estructura> estructurasForeignKey) {
		this.estructurasForeignKey=estructurasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setrubroempleasForeignKey(List<RubroEmplea> rubroempleasForeignKey) {
		this.rubroempleasForeignKey=rubroempleasForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}
}

