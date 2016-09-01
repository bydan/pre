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
import com.bydan.erp.contabilidad.util.ParametroGraficoConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//ParametroGrafico


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ParametroGraficoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroGrafico parametrografico;	
	protected List<ParametroGrafico> parametrograficos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<CuentaContable> cuentacontableactivosForeignKey;
	public List<CuentaContable> cuentacontablepasivosForeignKey;
	public List<CuentaContable> cuentacontableinventariosForeignKey;
	public List<CuentaContable> cuentacontabledisponibilidadsForeignKey;
	public List<CuentaContable> cuentacontablecostoventasForeignKey;
	public List<CuentaContable> cuentacontableinventarioinisForeignKey;
	public List<CuentaContable> cuentacontableinventariofinsForeignKey;
	public List<CuentaContable> cuentacontablecuentascobrarsForeignKey;
	public List<CuentaContable> cuentacontableventacreditosForeignKey;
	public List<CuentaContable> cuentacontableactivototalsForeignKey;
	public List<CuentaContable> cuentacontablepasivototalsForeignKey;
	public List<CuentaContable> cuentacontablepatrimoniosForeignKey;
	public List<CuentaContable> cuentacontablepatrimoniototalsForeignKey;
	public List<CuentaContable> cuentacontableventasForeignKey;
	
	public ParametroGraficoParameterReturnGeneral () throws Exception {						
		super();
		this.parametrograficos= new ArrayList<ParametroGrafico>();
		this.parametrografico= new ParametroGrafico();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.cuentacontableactivosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablepasivosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableinventariosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontabledisponibilidadsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecostoventasForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableinventarioinisForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableinventariofinsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecuentascobrarsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableventacreditosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableactivototalsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablepasivototalsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablepatrimoniosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablepatrimoniototalsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableventasForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public ParametroGrafico getParametroGrafico() throws Exception {	
		return parametrografico;
	}
		
	public void setParametroGrafico(ParametroGrafico newParametroGrafico) {
		this.parametrografico = newParametroGrafico;
	}
	
	public List<ParametroGrafico> getParametroGraficos() throws Exception {		
		return parametrograficos;
	}
	
	public void setParametroGraficos(List<ParametroGrafico> newParametroGraficos) {
		this.parametrograficos = newParametroGraficos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<CuentaContable> getcuentacontableactivosForeignKey() {
		return this.cuentacontableactivosForeignKey;
	}

	public List<CuentaContable> getcuentacontablepasivosForeignKey() {
		return this.cuentacontablepasivosForeignKey;
	}

	public List<CuentaContable> getcuentacontableinventariosForeignKey() {
		return this.cuentacontableinventariosForeignKey;
	}

	public List<CuentaContable> getcuentacontabledisponibilidadsForeignKey() {
		return this.cuentacontabledisponibilidadsForeignKey;
	}

	public List<CuentaContable> getcuentacontablecostoventasForeignKey() {
		return this.cuentacontablecostoventasForeignKey;
	}

	public List<CuentaContable> getcuentacontableinventarioinisForeignKey() {
		return this.cuentacontableinventarioinisForeignKey;
	}

	public List<CuentaContable> getcuentacontableinventariofinsForeignKey() {
		return this.cuentacontableinventariofinsForeignKey;
	}

	public List<CuentaContable> getcuentacontablecuentascobrarsForeignKey() {
		return this.cuentacontablecuentascobrarsForeignKey;
	}

	public List<CuentaContable> getcuentacontableventacreditosForeignKey() {
		return this.cuentacontableventacreditosForeignKey;
	}

	public List<CuentaContable> getcuentacontableactivototalsForeignKey() {
		return this.cuentacontableactivototalsForeignKey;
	}

	public List<CuentaContable> getcuentacontablepasivototalsForeignKey() {
		return this.cuentacontablepasivototalsForeignKey;
	}

	public List<CuentaContable> getcuentacontablepatrimoniosForeignKey() {
		return this.cuentacontablepatrimoniosForeignKey;
	}

	public List<CuentaContable> getcuentacontablepatrimoniototalsForeignKey() {
		return this.cuentacontablepatrimoniototalsForeignKey;
	}

	public List<CuentaContable> getcuentacontableventasForeignKey() {
		return this.cuentacontableventasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setcuentacontableactivosForeignKey(List<CuentaContable> cuentacontableactivosForeignKey) {
		this.cuentacontableactivosForeignKey=cuentacontableactivosForeignKey;
	}

	public void setcuentacontablepasivosForeignKey(List<CuentaContable> cuentacontablepasivosForeignKey) {
		this.cuentacontablepasivosForeignKey=cuentacontablepasivosForeignKey;
	}

	public void setcuentacontableinventariosForeignKey(List<CuentaContable> cuentacontableinventariosForeignKey) {
		this.cuentacontableinventariosForeignKey=cuentacontableinventariosForeignKey;
	}

	public void setcuentacontabledisponibilidadsForeignKey(List<CuentaContable> cuentacontabledisponibilidadsForeignKey) {
		this.cuentacontabledisponibilidadsForeignKey=cuentacontabledisponibilidadsForeignKey;
	}

	public void setcuentacontablecostoventasForeignKey(List<CuentaContable> cuentacontablecostoventasForeignKey) {
		this.cuentacontablecostoventasForeignKey=cuentacontablecostoventasForeignKey;
	}

	public void setcuentacontableinventarioinisForeignKey(List<CuentaContable> cuentacontableinventarioinisForeignKey) {
		this.cuentacontableinventarioinisForeignKey=cuentacontableinventarioinisForeignKey;
	}

	public void setcuentacontableinventariofinsForeignKey(List<CuentaContable> cuentacontableinventariofinsForeignKey) {
		this.cuentacontableinventariofinsForeignKey=cuentacontableinventariofinsForeignKey;
	}

	public void setcuentacontablecuentascobrarsForeignKey(List<CuentaContable> cuentacontablecuentascobrarsForeignKey) {
		this.cuentacontablecuentascobrarsForeignKey=cuentacontablecuentascobrarsForeignKey;
	}

	public void setcuentacontableventacreditosForeignKey(List<CuentaContable> cuentacontableventacreditosForeignKey) {
		this.cuentacontableventacreditosForeignKey=cuentacontableventacreditosForeignKey;
	}

	public void setcuentacontableactivototalsForeignKey(List<CuentaContable> cuentacontableactivototalsForeignKey) {
		this.cuentacontableactivototalsForeignKey=cuentacontableactivototalsForeignKey;
	}

	public void setcuentacontablepasivototalsForeignKey(List<CuentaContable> cuentacontablepasivototalsForeignKey) {
		this.cuentacontablepasivototalsForeignKey=cuentacontablepasivototalsForeignKey;
	}

	public void setcuentacontablepatrimoniosForeignKey(List<CuentaContable> cuentacontablepatrimoniosForeignKey) {
		this.cuentacontablepatrimoniosForeignKey=cuentacontablepatrimoniosForeignKey;
	}

	public void setcuentacontablepatrimoniototalsForeignKey(List<CuentaContable> cuentacontablepatrimoniototalsForeignKey) {
		this.cuentacontablepatrimoniototalsForeignKey=cuentacontablepatrimoniototalsForeignKey;
	}

	public void setcuentacontableventasForeignKey(List<CuentaContable> cuentacontableventasForeignKey) {
		this.cuentacontableventasForeignKey=cuentacontableventasForeignKey;
	}
}

