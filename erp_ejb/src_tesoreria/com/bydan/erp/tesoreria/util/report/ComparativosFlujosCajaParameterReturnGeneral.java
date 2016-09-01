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
package com.bydan.erp.tesoreria.util.report;

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
import com.bydan.erp.tesoreria.util.report.ComparativosFlujosCajaConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.report.*;//ComparativosFlujosCaja


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class ComparativosFlujosCajaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ComparativosFlujosCaja comparativosflujoscaja;	
	protected List<ComparativosFlujosCaja> comparativosflujoscajas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	
	public ComparativosFlujosCajaParameterReturnGeneral () throws Exception {						
		super();
		this.comparativosflujoscajas= new ArrayList<ComparativosFlujosCaja>();
		this.comparativosflujoscaja= new ComparativosFlujosCaja();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
	} 
	
	public ComparativosFlujosCaja getComparativosFlujosCaja() throws Exception {	
		return comparativosflujoscaja;
	}
		
	public void setComparativosFlujosCaja(ComparativosFlujosCaja newComparativosFlujosCaja) {
		this.comparativosflujoscaja = newComparativosFlujosCaja;
	}
	
	public List<ComparativosFlujosCaja> getComparativosFlujosCajas() throws Exception {		
		return comparativosflujoscajas;
	}
	
	public void setComparativosFlujosCajas(List<ComparativosFlujosCaja> newComparativosFlujosCajas) {
		this.comparativosflujoscajas = newComparativosFlujosCajas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}
}

