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
import com.bydan.erp.cartera.util.TipoViviendaConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//TipoVivienda


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoViviendaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoVivienda tipovivienda;	
	protected List<TipoVivienda> tipoviviendas;
	
	
	public List<Empresa> empresasForeignKey;
	
	public TipoViviendaParameterReturnGeneral () throws Exception {						
		super();
		this.tipoviviendas= new ArrayList<TipoVivienda>();
		this.tipovivienda= new TipoVivienda();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public TipoVivienda getTipoVivienda() throws Exception {	
		return tipovivienda;
	}
		
	public void setTipoVivienda(TipoVivienda newTipoVivienda) {
		this.tipovivienda = newTipoVivienda;
	}
	
	public List<TipoVivienda> getTipoViviendas() throws Exception {		
		return tipoviviendas;
	}
	
	public void setTipoViviendas(List<TipoVivienda> newTipoViviendas) {
		this.tipoviviendas = newTipoViviendas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

