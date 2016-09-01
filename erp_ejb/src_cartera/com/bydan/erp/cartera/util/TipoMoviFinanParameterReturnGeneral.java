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
import com.bydan.erp.cartera.util.TipoMoviFinanConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//TipoMoviFinan


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoMoviFinanParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoMoviFinan tipomovifinan;	
	protected List<TipoMoviFinan> tipomovifinans;
	
	
	public List<Empresa> empresasForeignKey;
	
	public TipoMoviFinanParameterReturnGeneral () throws Exception {						
		super();
		this.tipomovifinans= new ArrayList<TipoMoviFinan>();
		this.tipomovifinan= new TipoMoviFinan();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public TipoMoviFinan getTipoMoviFinan() throws Exception {	
		return tipomovifinan;
	}
		
	public void setTipoMoviFinan(TipoMoviFinan newTipoMoviFinan) {
		this.tipomovifinan = newTipoMoviFinan;
	}
	
	public List<TipoMoviFinan> getTipoMoviFinans() throws Exception {		
		return tipomovifinans;
	}
	
	public void setTipoMoviFinans(List<TipoMoviFinan> newTipoMoviFinans) {
		this.tipomovifinans = newTipoMoviFinans;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

