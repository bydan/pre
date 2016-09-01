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
import com.bydan.erp.nomina.util.TipoPrestamoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//TipoPrestamo


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class TipoPrestamoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoPrestamo tipoprestamo;	
	protected List<TipoPrestamo> tipoprestamos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<RubroEmplea> rubroempleasForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	
	public TipoPrestamoParameterReturnGeneral () throws Exception {						
		super();
		this.tipoprestamos= new ArrayList<TipoPrestamo>();
		this.tipoprestamo= new TipoPrestamo();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.rubroempleasForeignKey=new ArrayList<RubroEmplea>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public TipoPrestamo getTipoPrestamo() throws Exception {	
		return tipoprestamo;
	}
		
	public void setTipoPrestamo(TipoPrestamo newTipoPrestamo) {
		this.tipoprestamo = newTipoPrestamo;
	}
	
	public List<TipoPrestamo> getTipoPrestamos() throws Exception {		
		return tipoprestamos;
	}
	
	public void setTipoPrestamos(List<TipoPrestamo> newTipoPrestamos) {
		this.tipoprestamos = newTipoPrestamos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<RubroEmplea> getrubroempleasForeignKey() {
		return this.rubroempleasForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setrubroempleasForeignKey(List<RubroEmplea> rubroempleasForeignKey) {
		this.rubroempleasForeignKey=rubroempleasForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}
}

