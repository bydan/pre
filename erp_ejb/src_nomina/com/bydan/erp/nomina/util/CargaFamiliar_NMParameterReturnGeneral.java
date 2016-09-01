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
package com.bydan.erp.nomina.util;

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
import com.bydan.erp.nomina.util.CargaFamiliar_NMConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//CargaFamiliar_NM


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class CargaFamiliar_NMParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CargaFamiliar_NM cargafamiliar_nm;	
	protected List<CargaFamiliar_NM> cargafamiliar_nms;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<TipoCargaFami> tipocargafamisForeignKey;
	public List<TipoGenero> tipogenerosForeignKey;
	public List<EstadoCivil> estadocivilsForeignKey;
	
	public CargaFamiliar_NMParameterReturnGeneral () throws Exception {						
		super();
		this.cargafamiliar_nms= new ArrayList<CargaFamiliar_NM>();
		this.cargafamiliar_nm= new CargaFamiliar_NM();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.tipocargafamisForeignKey=new ArrayList<TipoCargaFami>();
		this.tipogenerosForeignKey=new ArrayList<TipoGenero>();
		this.estadocivilsForeignKey=new ArrayList<EstadoCivil>();
	} 
	
	public CargaFamiliar_NM getCargaFamiliar_NM() throws Exception {	
		return cargafamiliar_nm;
	}
		
	public void setCargaFamiliar_NM(CargaFamiliar_NM newCargaFamiliar_NM) {
		this.cargafamiliar_nm = newCargaFamiliar_NM;
	}
	
	public List<CargaFamiliar_NM> getCargaFamiliar_NMs() throws Exception {		
		return cargafamiliar_nms;
	}
	
	public void setCargaFamiliar_NMs(List<CargaFamiliar_NM> newCargaFamiliar_NMs) {
		this.cargafamiliar_nms = newCargaFamiliar_NMs;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
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

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
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

