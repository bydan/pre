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
import com.bydan.erp.nomina.util.TipoAfiliacionConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//TipoAfiliacion


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoAfiliacionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoAfiliacion tipoafiliacion;	
	protected List<TipoAfiliacion> tipoafiliacions;
	
	
	public List<Empresa> empresasForeignKey;
	public List<CateTipoAfiliacion> catetipoafiliacionsForeignKey;
	
	public TipoAfiliacionParameterReturnGeneral () throws Exception {						
		super();
		this.tipoafiliacions= new ArrayList<TipoAfiliacion>();
		this.tipoafiliacion= new TipoAfiliacion();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.catetipoafiliacionsForeignKey=new ArrayList<CateTipoAfiliacion>();
	} 
	
	public TipoAfiliacion getTipoAfiliacion() throws Exception {	
		return tipoafiliacion;
	}
		
	public void setTipoAfiliacion(TipoAfiliacion newTipoAfiliacion) {
		this.tipoafiliacion = newTipoAfiliacion;
	}
	
	public List<TipoAfiliacion> getTipoAfiliacions() throws Exception {		
		return tipoafiliacions;
	}
	
	public void setTipoAfiliacions(List<TipoAfiliacion> newTipoAfiliacions) {
		this.tipoafiliacions = newTipoAfiliacions;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<CateTipoAfiliacion> getcatetipoafiliacionsForeignKey() {
		return this.catetipoafiliacionsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setcatetipoafiliacionsForeignKey(List<CateTipoAfiliacion> catetipoafiliacionsForeignKey) {
		this.catetipoafiliacionsForeignKey=catetipoafiliacionsForeignKey;
	}
}

