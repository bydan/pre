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
package com.bydan.erp.contabilidad.util;

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
import com.bydan.erp.contabilidad.util.ImportarExportarConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//ImportarExportar


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class ImportarExportarParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ImportarExportar importarexportar;	
	protected List<ImportarExportar> importarexportars;
	
	
	public List<Modulo> modulosForeignKey;
	public List<AsientoContable> asientocontablesForeignKey;
	public List<PeriodoImportExport> periodoimportexportsForeignKey;
	public List<TransaccionConta> transaccioncontasForeignKey;
	public List<TipoImportacion> tipoimportacionsForeignKey;
	public List<TipoComprobante> tipocomprobantesForeignKey;
	public List<TipoTributario> tipotributariosForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<TipoIva> tipoivasForeignKey;
	public List<TipoIce> tipoicesForeignKey;
	public List<TipoBanco> tipobancosForeignKey;
	public List<TipoComprobante> tipocomprobantebancosForeignKey;
	
	public ImportarExportarParameterReturnGeneral () throws Exception {						
		super();
		this.importarexportars= new ArrayList<ImportarExportar>();
		this.importarexportar= new ImportarExportar();
		
		
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.asientocontablesForeignKey=new ArrayList<AsientoContable>();
		this.periodoimportexportsForeignKey=new ArrayList<PeriodoImportExport>();
		this.transaccioncontasForeignKey=new ArrayList<TransaccionConta>();
		this.tipoimportacionsForeignKey=new ArrayList<TipoImportacion>();
		this.tipocomprobantesForeignKey=new ArrayList<TipoComprobante>();
		this.tipotributariosForeignKey=new ArrayList<TipoTributario>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipoivasForeignKey=new ArrayList<TipoIva>();
		this.tipoicesForeignKey=new ArrayList<TipoIce>();
		this.tipobancosForeignKey=new ArrayList<TipoBanco>();
		this.tipocomprobantebancosForeignKey=new ArrayList<TipoComprobante>();
	} 
	
	public ImportarExportar getImportarExportar() throws Exception {	
		return importarexportar;
	}
		
	public void setImportarExportar(ImportarExportar newImportarExportar) {
		this.importarexportar = newImportarExportar;
	}
	
	public List<ImportarExportar> getImportarExportars() throws Exception {		
		return importarexportars;
	}
	
	public void setImportarExportars(List<ImportarExportar> newImportarExportars) {
		this.importarexportars = newImportarExportars;
	}
	
	

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}

	public List<AsientoContable> getasientocontablesForeignKey() {
		return this.asientocontablesForeignKey;
	}

	public List<PeriodoImportExport> getperiodoimportexportsForeignKey() {
		return this.periodoimportexportsForeignKey;
	}

	public List<TransaccionConta> gettransaccioncontasForeignKey() {
		return this.transaccioncontasForeignKey;
	}

	public List<TipoImportacion> gettipoimportacionsForeignKey() {
		return this.tipoimportacionsForeignKey;
	}

	public List<TipoComprobante> gettipocomprobantesForeignKey() {
		return this.tipocomprobantesForeignKey;
	}

	public List<TipoTributario> gettipotributariosForeignKey() {
		return this.tipotributariosForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoIva> gettipoivasForeignKey() {
		return this.tipoivasForeignKey;
	}

	public List<TipoIce> gettipoicesForeignKey() {
		return this.tipoicesForeignKey;
	}

	public List<TipoBanco> gettipobancosForeignKey() {
		return this.tipobancosForeignKey;
	}

	public List<TipoComprobante> gettipocomprobantebancosForeignKey() {
		return this.tipocomprobantebancosForeignKey;
	}
	
	

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}

	public void setasientocontablesForeignKey(List<AsientoContable> asientocontablesForeignKey) {
		this.asientocontablesForeignKey=asientocontablesForeignKey;
	}

	public void setperiodoimportexportsForeignKey(List<PeriodoImportExport> periodoimportexportsForeignKey) {
		this.periodoimportexportsForeignKey=periodoimportexportsForeignKey;
	}

	public void settransaccioncontasForeignKey(List<TransaccionConta> transaccioncontasForeignKey) {
		this.transaccioncontasForeignKey=transaccioncontasForeignKey;
	}

	public void settipoimportacionsForeignKey(List<TipoImportacion> tipoimportacionsForeignKey) {
		this.tipoimportacionsForeignKey=tipoimportacionsForeignKey;
	}

	public void settipocomprobantesForeignKey(List<TipoComprobante> tipocomprobantesForeignKey) {
		this.tipocomprobantesForeignKey=tipocomprobantesForeignKey;
	}

	public void settipotributariosForeignKey(List<TipoTributario> tipotributariosForeignKey) {
		this.tipotributariosForeignKey=tipotributariosForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settipoivasForeignKey(List<TipoIva> tipoivasForeignKey) {
		this.tipoivasForeignKey=tipoivasForeignKey;
	}

	public void settipoicesForeignKey(List<TipoIce> tipoicesForeignKey) {
		this.tipoicesForeignKey=tipoicesForeignKey;
	}

	public void settipobancosForeignKey(List<TipoBanco> tipobancosForeignKey) {
		this.tipobancosForeignKey=tipobancosForeignKey;
	}

	public void settipocomprobantebancosForeignKey(List<TipoComprobante> tipocomprobantebancosForeignKey) {
		this.tipocomprobantebancosForeignKey=tipocomprobantebancosForeignKey;
	}
}

