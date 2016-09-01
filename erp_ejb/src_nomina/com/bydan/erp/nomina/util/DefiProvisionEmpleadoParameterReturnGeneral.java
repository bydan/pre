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
import com.bydan.erp.nomina.util.DefiProvisionEmpleadoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//DefiProvisionEmpleado


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class DefiProvisionEmpleadoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DefiProvisionEmpleado defiprovisionempleado;	
	protected List<DefiProvisionEmpleado> defiprovisionempleados;
	
	
	public List<Empresa> empresasForeignKey;
	public List<RubroEmplea> rubroempleasForeignKey;
	public List<Formato> formatosForeignKey;
	public List<Mes> mesinicialsForeignKey;
	public List<Mes> mesfinalsForeignKey;
	
	public DefiProvisionEmpleadoParameterReturnGeneral () throws Exception {						
		super();
		this.defiprovisionempleados= new ArrayList<DefiProvisionEmpleado>();
		this.defiprovisionempleado= new DefiProvisionEmpleado();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.rubroempleasForeignKey=new ArrayList<RubroEmplea>();
		this.formatosForeignKey=new ArrayList<Formato>();
		this.mesinicialsForeignKey=new ArrayList<Mes>();
		this.mesfinalsForeignKey=new ArrayList<Mes>();
	} 
	
	public DefiProvisionEmpleado getDefiProvisionEmpleado() throws Exception {	
		return defiprovisionempleado;
	}
		
	public void setDefiProvisionEmpleado(DefiProvisionEmpleado newDefiProvisionEmpleado) {
		this.defiprovisionempleado = newDefiProvisionEmpleado;
	}
	
	public List<DefiProvisionEmpleado> getDefiProvisionEmpleados() throws Exception {		
		return defiprovisionempleados;
	}
	
	public void setDefiProvisionEmpleados(List<DefiProvisionEmpleado> newDefiProvisionEmpleados) {
		this.defiprovisionempleados = newDefiProvisionEmpleados;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<RubroEmplea> getrubroempleasForeignKey() {
		return this.rubroempleasForeignKey;
	}

	public List<Formato> getformatosForeignKey() {
		return this.formatosForeignKey;
	}

	public List<Mes> getmesinicialsForeignKey() {
		return this.mesinicialsForeignKey;
	}

	public List<Mes> getmesfinalsForeignKey() {
		return this.mesfinalsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setrubroempleasForeignKey(List<RubroEmplea> rubroempleasForeignKey) {
		this.rubroempleasForeignKey=rubroempleasForeignKey;
	}

	public void setformatosForeignKey(List<Formato> formatosForeignKey) {
		this.formatosForeignKey=formatosForeignKey;
	}

	public void setmesinicialsForeignKey(List<Mes> mesinicialsForeignKey) {
		this.mesinicialsForeignKey=mesinicialsForeignKey;
	}

	public void setmesfinalsForeignKey(List<Mes> mesfinalsForeignKey) {
		this.mesfinalsForeignKey=mesfinalsForeignKey;
	}
}

