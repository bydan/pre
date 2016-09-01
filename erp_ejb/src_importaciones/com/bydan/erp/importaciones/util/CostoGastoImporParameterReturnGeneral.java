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
package com.bydan.erp.importaciones.util;

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
import com.bydan.erp.importaciones.util.CostoGastoImporConstantesFunciones;

import com.bydan.erp.importaciones.business.entity.*;//CostoGastoImpor


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class CostoGastoImporParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CostoGastoImpor costogastoimpor;	
	protected List<CostoGastoImpor> costogastoimpors;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<TipoCostoGastoImpor> tipocostogastoimporsForeignKey;
	
	public CostoGastoImporParameterReturnGeneral () throws Exception {						
		super();
		this.costogastoimpors= new ArrayList<CostoGastoImpor>();
		this.costogastoimpor= new CostoGastoImpor();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.tipocostogastoimporsForeignKey=new ArrayList<TipoCostoGastoImpor>();
	} 
	
	public CostoGastoImpor getCostoGastoImpor() throws Exception {	
		return costogastoimpor;
	}
		
	public void setCostoGastoImpor(CostoGastoImpor newCostoGastoImpor) {
		this.costogastoimpor = newCostoGastoImpor;
	}
	
	public List<CostoGastoImpor> getCostoGastoImpors() throws Exception {		
		return costogastoimpors;
	}
	
	public void setCostoGastoImpors(List<CostoGastoImpor> newCostoGastoImpors) {
		this.costogastoimpors = newCostoGastoImpors;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<TipoCostoGastoImpor> gettipocostogastoimporsForeignKey() {
		return this.tipocostogastoimporsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void settipocostogastoimporsForeignKey(List<TipoCostoGastoImpor> tipocostogastoimporsForeignKey) {
		this.tipocostogastoimporsForeignKey=tipocostogastoimporsForeignKey;
	}
}

