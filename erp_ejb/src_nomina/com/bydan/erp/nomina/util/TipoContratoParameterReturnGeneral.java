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
import com.bydan.erp.nomina.util.TipoContratoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//TipoContrato


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class TipoContratoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoContrato tipocontrato;	
	protected List<TipoContrato> tipocontratos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Formato> formatosForeignKey;
	
	public TipoContratoParameterReturnGeneral () throws Exception {						
		super();
		this.tipocontratos= new ArrayList<TipoContrato>();
		this.tipocontrato= new TipoContrato();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.formatosForeignKey=new ArrayList<Formato>();
	} 
	
	public TipoContrato getTipoContrato() throws Exception {	
		return tipocontrato;
	}
		
	public void setTipoContrato(TipoContrato newTipoContrato) {
		this.tipocontrato = newTipoContrato;
	}
	
	public List<TipoContrato> getTipoContratos() throws Exception {		
		return tipocontratos;
	}
	
	public void setTipoContratos(List<TipoContrato> newTipoContratos) {
		this.tipocontratos = newTipoContratos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Formato> getformatosForeignKey() {
		return this.formatosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setformatosForeignKey(List<Formato> formatosForeignKey) {
		this.formatosForeignKey=formatosForeignKey;
	}
}

