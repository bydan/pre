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
import com.bydan.erp.nomina.util.FuncionEstrucConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//FuncionEstruc


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class FuncionEstrucParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected FuncionEstruc funcionestruc;	
	protected List<FuncionEstruc> funcionestrucs;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Estructura> estructurasForeignKey;
	public List<Funcion> funcionsForeignKey;
	
	public FuncionEstrucParameterReturnGeneral () throws Exception {						
		super();
		this.funcionestrucs= new ArrayList<FuncionEstruc>();
		this.funcionestruc= new FuncionEstruc();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
		this.funcionsForeignKey=new ArrayList<Funcion>();
	} 
	
	public FuncionEstruc getFuncionEstruc() throws Exception {	
		return funcionestruc;
	}
		
	public void setFuncionEstruc(FuncionEstruc newFuncionEstruc) {
		this.funcionestruc = newFuncionEstruc;
	}
	
	public List<FuncionEstruc> getFuncionEstrucs() throws Exception {		
		return funcionestrucs;
	}
	
	public void setFuncionEstrucs(List<FuncionEstruc> newFuncionEstrucs) {
		this.funcionestrucs = newFuncionEstrucs;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Estructura> getestructurasForeignKey() {
		return this.estructurasForeignKey;
	}

	public List<Funcion> getfuncionsForeignKey() {
		return this.funcionsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setestructurasForeignKey(List<Estructura> estructurasForeignKey) {
		this.estructurasForeignKey=estructurasForeignKey;
	}

	public void setfuncionsForeignKey(List<Funcion> funcionsForeignKey) {
		this.funcionsForeignKey=funcionsForeignKey;
	}
}

