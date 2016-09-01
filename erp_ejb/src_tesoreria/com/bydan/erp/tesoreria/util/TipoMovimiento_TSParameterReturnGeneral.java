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
package com.bydan.erp.tesoreria.util;

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
import com.bydan.erp.tesoreria.util.TipoMovimiento_TSConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.*;//TipoMovimiento_TS


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoMovimiento_TSParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoMovimiento_TS tipomovimiento_ts;	
	protected List<TipoMovimiento_TS> tipomovimiento_tss;
	
	
	public List<Empresa> empresasForeignKey;
	
	public TipoMovimiento_TSParameterReturnGeneral () throws Exception {						
		super();
		this.tipomovimiento_tss= new ArrayList<TipoMovimiento_TS>();
		this.tipomovimiento_ts= new TipoMovimiento_TS();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public TipoMovimiento_TS getTipoMovimiento_TS() throws Exception {	
		return tipomovimiento_ts;
	}
		
	public void setTipoMovimiento_TS(TipoMovimiento_TS newTipoMovimiento_TS) {
		this.tipomovimiento_ts = newTipoMovimiento_TS;
	}
	
	public List<TipoMovimiento_TS> getTipoMovimiento_TSs() throws Exception {		
		return tipomovimiento_tss;
	}
	
	public void setTipoMovimiento_TSs(List<TipoMovimiento_TS> newTipoMovimiento_TSs) {
		this.tipomovimiento_tss = newTipoMovimiento_TSs;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

