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
package com.bydan.erp.activosfijos.util;

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
import com.bydan.erp.activosfijos.util.SubGrupoActivoFijoConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.*;//SubGrupoActivoFijo


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


@SuppressWarnings("unused")
public class SubGrupoActivoFijoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected SubGrupoActivoFijo subgrupoactivofijo;	
	protected List<SubGrupoActivoFijo> subgrupoactivofijos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<DetalleGrupoActivoFijo> detallegrupoactivofijosForeignKey;
	
	public SubGrupoActivoFijoParameterReturnGeneral () throws Exception {						
		super();
		this.subgrupoactivofijos= new ArrayList<SubGrupoActivoFijo>();
		this.subgrupoactivofijo= new SubGrupoActivoFijo();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.detallegrupoactivofijosForeignKey=new ArrayList<DetalleGrupoActivoFijo>();
	} 
	
	public SubGrupoActivoFijo getSubGrupoActivoFijo() throws Exception {	
		return subgrupoactivofijo;
	}
		
	public void setSubGrupoActivoFijo(SubGrupoActivoFijo newSubGrupoActivoFijo) {
		this.subgrupoactivofijo = newSubGrupoActivoFijo;
	}
	
	public List<SubGrupoActivoFijo> getSubGrupoActivoFijos() throws Exception {		
		return subgrupoactivofijos;
	}
	
	public void setSubGrupoActivoFijos(List<SubGrupoActivoFijo> newSubGrupoActivoFijos) {
		this.subgrupoactivofijos = newSubGrupoActivoFijos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<DetalleGrupoActivoFijo> getdetallegrupoactivofijosForeignKey() {
		return this.detallegrupoactivofijosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setdetallegrupoactivofijosForeignKey(List<DetalleGrupoActivoFijo> detallegrupoactivofijosForeignKey) {
		this.detallegrupoactivofijosForeignKey=detallegrupoactivofijosForeignKey;
	}
}

