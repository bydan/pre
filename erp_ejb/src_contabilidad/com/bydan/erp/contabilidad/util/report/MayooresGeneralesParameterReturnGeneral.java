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
package com.bydan.erp.contabilidad.util.report;

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
import com.bydan.erp.contabilidad.util.report.MayooresGeneralesConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.report.*;//MayooresGenerales


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class MayooresGeneralesParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected MayooresGenerales mayooresgenerales;	
	protected List<MayooresGenerales> mayooresgeneraless;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	
	public MayooresGeneralesParameterReturnGeneral () throws Exception {						
		super();
		this.mayooresgeneraless= new ArrayList<MayooresGenerales>();
		this.mayooresgenerales= new MayooresGenerales();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public MayooresGenerales getMayooresGenerales() throws Exception {	
		return mayooresgenerales;
	}
		
	public void setMayooresGenerales(MayooresGenerales newMayooresGenerales) {
		this.mayooresgenerales = newMayooresGenerales;
	}
	
	public List<MayooresGenerales> getMayooresGeneraless() throws Exception {		
		return mayooresgeneraless;
	}
	
	public void setMayooresGeneraless(List<MayooresGenerales> newMayooresGeneraless) {
		this.mayooresgeneraless = newMayooresGeneraless;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}
}

