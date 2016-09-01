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
import com.bydan.erp.nomina.util.HistorialPagoMesNomiConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//HistorialPagoMesNomi


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class HistorialPagoMesNomiParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected HistorialPagoMesNomi historialpagomesnomi;	
	protected List<HistorialPagoMesNomi> historialpagomesnomis;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<RubroEmplea> rubroempleasForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	
	public HistorialPagoMesNomiParameterReturnGeneral () throws Exception {						
		super();
		this.historialpagomesnomis= new ArrayList<HistorialPagoMesNomi>();
		this.historialpagomesnomi= new HistorialPagoMesNomi();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.rubroempleasForeignKey=new ArrayList<RubroEmplea>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
	} 
	
	public HistorialPagoMesNomi getHistorialPagoMesNomi() throws Exception {	
		return historialpagomesnomi;
	}
		
	public void setHistorialPagoMesNomi(HistorialPagoMesNomi newHistorialPagoMesNomi) {
		this.historialpagomesnomi = newHistorialPagoMesNomi;
	}
	
	public List<HistorialPagoMesNomi> getHistorialPagoMesNomis() throws Exception {		
		return historialpagomesnomis;
	}
	
	public void setHistorialPagoMesNomis(List<HistorialPagoMesNomi> newHistorialPagoMesNomis) {
		this.historialpagomesnomis = newHistorialPagoMesNomis;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<RubroEmplea> getrubroempleasForeignKey() {
		return this.rubroempleasForeignKey;
	}

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setrubroempleasForeignKey(List<RubroEmplea> rubroempleasForeignKey) {
		this.rubroempleasForeignKey=rubroempleasForeignKey;
	}

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}
}

