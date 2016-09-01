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
package com.bydan.erp.contabilidad.util;

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
import com.bydan.erp.contabilidad.util.TipoDescripcionAsientoConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//TipoDescripcionAsiento


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


@SuppressWarnings("unused")
public class TipoDescripcionAsientoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoDescripcionAsiento tipodescripcionasiento;	
	protected List<TipoDescripcionAsiento> tipodescripcionasientos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Modulo> modulosForeignKey;
	
	public TipoDescripcionAsientoParameterReturnGeneral () throws Exception {						
		super();
		this.tipodescripcionasientos= new ArrayList<TipoDescripcionAsiento>();
		this.tipodescripcionasiento= new TipoDescripcionAsiento();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.modulosForeignKey=new ArrayList<Modulo>();
	} 
	
	public TipoDescripcionAsiento getTipoDescripcionAsiento() throws Exception {	
		return tipodescripcionasiento;
	}
		
	public void setTipoDescripcionAsiento(TipoDescripcionAsiento newTipoDescripcionAsiento) {
		this.tipodescripcionasiento = newTipoDescripcionAsiento;
	}
	
	public List<TipoDescripcionAsiento> getTipoDescripcionAsientos() throws Exception {		
		return tipodescripcionasientos;
	}
	
	public void setTipoDescripcionAsientos(List<TipoDescripcionAsiento> newTipoDescripcionAsientos) {
		this.tipodescripcionasientos = newTipoDescripcionAsientos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}
}

