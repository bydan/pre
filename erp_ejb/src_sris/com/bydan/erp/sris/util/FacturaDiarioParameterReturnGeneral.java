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
package com.bydan.erp.sris.util;

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
import com.bydan.erp.sris.util.FacturaDiarioConstantesFunciones;

import com.bydan.erp.sris.business.entity.*;//FacturaDiario


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class FacturaDiarioParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected FacturaDiario facturadiario;	
	protected List<FacturaDiario> facturadiarios;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<PeriodoDeclara> periododeclarasForeignKey;
	public List<TipoIva> tipoivasForeignKey;
	
	public FacturaDiarioParameterReturnGeneral () throws Exception {						
		super();
		this.facturadiarios= new ArrayList<FacturaDiario>();
		this.facturadiario= new FacturaDiario();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.periododeclarasForeignKey=new ArrayList<PeriodoDeclara>();
		this.tipoivasForeignKey=new ArrayList<TipoIva>();
	} 
	
	public FacturaDiario getFacturaDiario() throws Exception {	
		return facturadiario;
	}
		
	public void setFacturaDiario(FacturaDiario newFacturaDiario) {
		this.facturadiario = newFacturaDiario;
	}
	
	public List<FacturaDiario> getFacturaDiarios() throws Exception {		
		return facturadiarios;
	}
	
	public void setFacturaDiarios(List<FacturaDiario> newFacturaDiarios) {
		this.facturadiarios = newFacturaDiarios;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<PeriodoDeclara> getperiododeclarasForeignKey() {
		return this.periododeclarasForeignKey;
	}

	public List<TipoIva> gettipoivasForeignKey() {
		return this.tipoivasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void setperiododeclarasForeignKey(List<PeriodoDeclara> periododeclarasForeignKey) {
		this.periododeclarasForeignKey=periododeclarasForeignKey;
	}

	public void settipoivasForeignKey(List<TipoIva> tipoivasForeignKey) {
		this.tipoivasForeignKey=tipoivasForeignKey;
	}
}

