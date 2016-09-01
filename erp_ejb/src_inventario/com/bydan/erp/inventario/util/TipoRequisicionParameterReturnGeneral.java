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
package com.bydan.erp.inventario.util;

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
import com.bydan.erp.inventario.util.TipoRequisicionConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//TipoRequisicion


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class TipoRequisicionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoRequisicion tiporequisicion;	
	protected List<TipoRequisicion> tiporequisicions;
	
	
	public List<Empresa> empresasForeignKey;
	public List<TipoPeriodo> tipoperiodosForeignKey;
	public List<Dia> diasForeignKey;
	
	public TipoRequisicionParameterReturnGeneral () throws Exception {						
		super();
		this.tiporequisicions= new ArrayList<TipoRequisicion>();
		this.tiporequisicion= new TipoRequisicion();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.tipoperiodosForeignKey=new ArrayList<TipoPeriodo>();
		this.diasForeignKey=new ArrayList<Dia>();
	} 
	
	public TipoRequisicion getTipoRequisicion() throws Exception {	
		return tiporequisicion;
	}
		
	public void setTipoRequisicion(TipoRequisicion newTipoRequisicion) {
		this.tiporequisicion = newTipoRequisicion;
	}
	
	public List<TipoRequisicion> getTipoRequisicions() throws Exception {		
		return tiporequisicions;
	}
	
	public void setTipoRequisicions(List<TipoRequisicion> newTipoRequisicions) {
		this.tiporequisicions = newTipoRequisicions;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<TipoPeriodo> gettipoperiodosForeignKey() {
		return this.tipoperiodosForeignKey;
	}

	public List<Dia> getdiasForeignKey() {
		return this.diasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settipoperiodosForeignKey(List<TipoPeriodo> tipoperiodosForeignKey) {
		this.tipoperiodosForeignKey=tipoperiodosForeignKey;
	}

	public void setdiasForeignKey(List<Dia> diasForeignKey) {
		this.diasForeignKey=diasForeignKey;
	}
}

