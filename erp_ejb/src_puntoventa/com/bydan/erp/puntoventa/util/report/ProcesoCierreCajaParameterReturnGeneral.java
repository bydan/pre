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
package com.bydan.erp.puntoventa.util.report;

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
import com.bydan.erp.puntoventa.util.report.ProcesoCierreCajaConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.report.*;//ProcesoCierreCaja


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


@SuppressWarnings("unused")
public class ProcesoCierreCajaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProcesoCierreCaja procesocierrecaja;	
	protected List<ProcesoCierreCaja> procesocierrecajas;
	
	
	public List<Usuario> usuariosForeignKey;
	public List<Caja> cajasForeignKey;
	
	public ProcesoCierreCajaParameterReturnGeneral () throws Exception {						
		super();
		this.procesocierrecajas= new ArrayList<ProcesoCierreCaja>();
		this.procesocierrecaja= new ProcesoCierreCaja();
		
		
		this.usuariosForeignKey=new ArrayList<Usuario>();
		this.cajasForeignKey=new ArrayList<Caja>();
	} 
	
	public ProcesoCierreCaja getProcesoCierreCaja() throws Exception {	
		return procesocierrecaja;
	}
		
	public void setProcesoCierreCaja(ProcesoCierreCaja newProcesoCierreCaja) {
		this.procesocierrecaja = newProcesoCierreCaja;
	}
	
	public List<ProcesoCierreCaja> getProcesoCierreCajas() throws Exception {		
		return procesocierrecajas;
	}
	
	public void setProcesoCierreCajas(List<ProcesoCierreCaja> newProcesoCierreCajas) {
		this.procesocierrecajas = newProcesoCierreCajas;
	}
	
	

	public List<Usuario> getusuariosForeignKey() {
		return this.usuariosForeignKey;
	}

	public List<Caja> getcajasForeignKey() {
		return this.cajasForeignKey;
	}
	
	

	public void setusuariosForeignKey(List<Usuario> usuariosForeignKey) {
		this.usuariosForeignKey=usuariosForeignKey;
	}

	public void setcajasForeignKey(List<Caja> cajasForeignKey) {
		this.cajasForeignKey=cajasForeignKey;
	}
}

