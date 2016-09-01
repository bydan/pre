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
package com.bydan.erp.cartera.util;

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
import com.bydan.erp.cartera.util.CargaFamiliarConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//CargaFamiliar


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class CargaFamiliarParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CargaFamiliar cargafamiliar;	
	protected List<CargaFamiliar> cargafamiliars;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<TipoCargaFami> tipocargafamisForeignKey;
	public List<TipoGenero> tipogenerosForeignKey;
	public List<EstadoCivil> estadocivilsForeignKey;
	
	public CargaFamiliarParameterReturnGeneral () throws Exception {						
		super();
		this.cargafamiliars= new ArrayList<CargaFamiliar>();
		this.cargafamiliar= new CargaFamiliar();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipocargafamisForeignKey=new ArrayList<TipoCargaFami>();
		this.tipogenerosForeignKey=new ArrayList<TipoGenero>();
		this.estadocivilsForeignKey=new ArrayList<EstadoCivil>();
	} 
	
	public CargaFamiliar getCargaFamiliar() throws Exception {	
		return cargafamiliar;
	}
		
	public void setCargaFamiliar(CargaFamiliar newCargaFamiliar) {
		this.cargafamiliar = newCargaFamiliar;
	}
	
	public List<CargaFamiliar> getCargaFamiliars() throws Exception {		
		return cargafamiliars;
	}
	
	public void setCargaFamiliars(List<CargaFamiliar> newCargaFamiliars) {
		this.cargafamiliars = newCargaFamiliars;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoCargaFami> gettipocargafamisForeignKey() {
		return this.tipocargafamisForeignKey;
	}

	public List<TipoGenero> gettipogenerosForeignKey() {
		return this.tipogenerosForeignKey;
	}

	public List<EstadoCivil> getestadocivilsForeignKey() {
		return this.estadocivilsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settipocargafamisForeignKey(List<TipoCargaFami> tipocargafamisForeignKey) {
		this.tipocargafamisForeignKey=tipocargafamisForeignKey;
	}

	public void settipogenerosForeignKey(List<TipoGenero> tipogenerosForeignKey) {
		this.tipogenerosForeignKey=tipogenerosForeignKey;
	}

	public void setestadocivilsForeignKey(List<EstadoCivil> estadocivilsForeignKey) {
		this.estadocivilsForeignKey=estadocivilsForeignKey;
	}
}

