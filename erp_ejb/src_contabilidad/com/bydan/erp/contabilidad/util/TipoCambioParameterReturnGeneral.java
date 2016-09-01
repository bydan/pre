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
import com.bydan.erp.contabilidad.util.TipoCambioConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//TipoCambio


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.sris.business.entity.*;


@SuppressWarnings("unused")
public class TipoCambioParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoCambio tipocambio;	
	protected List<TipoCambio> tipocambios;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Moneda> monedasForeignKey;
	
	public TipoCambioParameterReturnGeneral () throws Exception {						
		super();
		this.tipocambios= new ArrayList<TipoCambio>();
		this.tipocambio= new TipoCambio();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.monedasForeignKey=new ArrayList<Moneda>();
	} 
	
	public TipoCambio getTipoCambio() throws Exception {	
		return tipocambio;
	}
		
	public void setTipoCambio(TipoCambio newTipoCambio) {
		this.tipocambio = newTipoCambio;
	}
	
	public List<TipoCambio> getTipoCambios() throws Exception {		
		return tipocambios;
	}
	
	public void setTipoCambios(List<TipoCambio> newTipoCambios) {
		this.tipocambios = newTipoCambios;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Moneda> getmonedasForeignKey() {
		return this.monedasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setmonedasForeignKey(List<Moneda> monedasForeignKey) {
		this.monedasForeignKey=monedasForeignKey;
	}
}

