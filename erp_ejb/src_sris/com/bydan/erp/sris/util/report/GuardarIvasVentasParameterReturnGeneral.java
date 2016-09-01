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
package com.bydan.erp.sris.util.report;

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
import com.bydan.erp.sris.util.report.GuardarIvasVentasConstantesFunciones;

import com.bydan.erp.sris.business.entity.report.*;//GuardarIvasVentas


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class GuardarIvasVentasParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected GuardarIvasVentas guardarivasventas;	
	protected List<GuardarIvasVentas> guardarivasventass;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<TipoRetencion> tiporetencionfuenteivasForeignKey;
	
	public GuardarIvasVentasParameterReturnGeneral () throws Exception {						
		super();
		this.guardarivasventass= new ArrayList<GuardarIvasVentas>();
		this.guardarivasventas= new GuardarIvasVentas();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.tiporetencionfuenteivasForeignKey=new ArrayList<TipoRetencion>();
	} 
	
	public GuardarIvasVentas getGuardarIvasVentas() throws Exception {	
		return guardarivasventas;
	}
		
	public void setGuardarIvasVentas(GuardarIvasVentas newGuardarIvasVentas) {
		this.guardarivasventas = newGuardarIvasVentas;
	}
	
	public List<GuardarIvasVentas> getGuardarIvasVentass() throws Exception {		
		return guardarivasventass;
	}
	
	public void setGuardarIvasVentass(List<GuardarIvasVentas> newGuardarIvasVentass) {
		this.guardarivasventass = newGuardarIvasVentass;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}

	public List<Periodo> getperiodosForeignKey() {
		return this.periodosForeignKey;
	}

	public List<TipoRetencion> gettiporetencionfuenteivasForeignKey() {
		return this.tiporetencionfuenteivasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setperiodosForeignKey(List<Periodo> periodosForeignKey) {
		this.periodosForeignKey=periodosForeignKey;
	}

	public void settiporetencionfuenteivasForeignKey(List<TipoRetencion> tiporetencionfuenteivasForeignKey) {
		this.tiporetencionfuenteivasForeignKey=tiporetencionfuenteivasForeignKey;
	}
}

