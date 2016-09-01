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
package com.bydan.erp.nomina.util.report;

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
import com.bydan.erp.nomina.util.report.ProcesoBancoNominaConstantesFunciones;

import com.bydan.erp.nomina.business.entity.report.*;//ProcesoBancoNomina


import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class ProcesoBancoNominaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProcesoBancoNomina procesobanconomina;	
	protected List<ProcesoBancoNomina> procesobanconominas;
	
	
	public List<Banco> bancosForeignKey;
	public List<CuentaBanco> cuentabancosForeignKey;
	public List<TipoContrato> tipocontratosForeignKey;
	public List<TipoBancoDisco> tipobancodiscosForeignKey;
	
	public ProcesoBancoNominaParameterReturnGeneral () throws Exception {						
		super();
		this.procesobanconominas= new ArrayList<ProcesoBancoNomina>();
		this.procesobanconomina= new ProcesoBancoNomina();
		
		
		this.bancosForeignKey=new ArrayList<Banco>();
		this.cuentabancosForeignKey=new ArrayList<CuentaBanco>();
		this.tipocontratosForeignKey=new ArrayList<TipoContrato>();
		this.tipobancodiscosForeignKey=new ArrayList<TipoBancoDisco>();
	} 
	
	public ProcesoBancoNomina getProcesoBancoNomina() throws Exception {	
		return procesobanconomina;
	}
		
	public void setProcesoBancoNomina(ProcesoBancoNomina newProcesoBancoNomina) {
		this.procesobanconomina = newProcesoBancoNomina;
	}
	
	public List<ProcesoBancoNomina> getProcesoBancoNominas() throws Exception {		
		return procesobanconominas;
	}
	
	public void setProcesoBancoNominas(List<ProcesoBancoNomina> newProcesoBancoNominas) {
		this.procesobanconominas = newProcesoBancoNominas;
	}
	
	

	public List<Banco> getbancosForeignKey() {
		return this.bancosForeignKey;
	}

	public List<CuentaBanco> getcuentabancosForeignKey() {
		return this.cuentabancosForeignKey;
	}

	public List<TipoContrato> gettipocontratosForeignKey() {
		return this.tipocontratosForeignKey;
	}

	public List<TipoBancoDisco> gettipobancodiscosForeignKey() {
		return this.tipobancodiscosForeignKey;
	}
	
	

	public void setbancosForeignKey(List<Banco> bancosForeignKey) {
		this.bancosForeignKey=bancosForeignKey;
	}

	public void setcuentabancosForeignKey(List<CuentaBanco> cuentabancosForeignKey) {
		this.cuentabancosForeignKey=cuentabancosForeignKey;
	}

	public void settipocontratosForeignKey(List<TipoContrato> tipocontratosForeignKey) {
		this.tipocontratosForeignKey=tipocontratosForeignKey;
	}

	public void settipobancodiscosForeignKey(List<TipoBancoDisco> tipobancodiscosForeignKey) {
		this.tipobancodiscosForeignKey=tipobancodiscosForeignKey;
	}
}

