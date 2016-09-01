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
import com.bydan.erp.contabilidad.util.report.EstadosResultadosPerdidasGananciasConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.report.*;//EstadosResultadosPerdidasGanancias


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class EstadosResultadosPerdidasGananciasParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias;	
	protected List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciass;
	
	
	public List<Empresa> empresasForeignKey;
	public List<NivelCuenta> nivelcuentasForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	
	public EstadosResultadosPerdidasGananciasParameterReturnGeneral () throws Exception {						
		super();
		this.estadosresultadosperdidasgananciass= new ArrayList<EstadosResultadosPerdidasGanancias>();
		this.estadosresultadosperdidasganancias= new EstadosResultadosPerdidasGanancias();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.nivelcuentasForeignKey=new ArrayList<NivelCuenta>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
	} 
	
	public EstadosResultadosPerdidasGanancias getEstadosResultadosPerdidasGanancias() throws Exception {	
		return estadosresultadosperdidasganancias;
	}
		
	public void setEstadosResultadosPerdidasGanancias(EstadosResultadosPerdidasGanancias newEstadosResultadosPerdidasGanancias) {
		this.estadosresultadosperdidasganancias = newEstadosResultadosPerdidasGanancias;
	}
	
	public List<EstadosResultadosPerdidasGanancias> getEstadosResultadosPerdidasGananciass() throws Exception {		
		return estadosresultadosperdidasgananciass;
	}
	
	public void setEstadosResultadosPerdidasGananciass(List<EstadosResultadosPerdidasGanancias> newEstadosResultadosPerdidasGananciass) {
		this.estadosresultadosperdidasgananciass = newEstadosResultadosPerdidasGananciass;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<NivelCuenta> getnivelcuentasForeignKey() {
		return this.nivelcuentasForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}

	public List<Periodo> getperiodosForeignKey() {
		return this.periodosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setnivelcuentasForeignKey(List<NivelCuenta> nivelcuentasForeignKey) {
		this.nivelcuentasForeignKey=nivelcuentasForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setperiodosForeignKey(List<Periodo> periodosForeignKey) {
		this.periodosForeignKey=periodosForeignKey;
	}
}

