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
package com.bydan.erp.facturacion.util;

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
import com.bydan.erp.facturacion.util.TerminoProformaConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//TerminoProforma


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class TerminoProformaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TerminoProforma terminoproforma;	
	protected List<TerminoProforma> terminoproformas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Moneda> monedasForeignKey;
	public List<Proforma> proformasForeignKey;
	
	public TerminoProformaParameterReturnGeneral () throws Exception {						
		super();
		this.terminoproformas= new ArrayList<TerminoProforma>();
		this.terminoproforma= new TerminoProforma();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.monedasForeignKey=new ArrayList<Moneda>();
		this.proformasForeignKey=new ArrayList<Proforma>();
	} 
	
	public TerminoProforma getTerminoProforma() throws Exception {	
		return terminoproforma;
	}
		
	public void setTerminoProforma(TerminoProforma newTerminoProforma) {
		this.terminoproforma = newTerminoProforma;
	}
	
	public List<TerminoProforma> getTerminoProformas() throws Exception {		
		return terminoproformas;
	}
	
	public void setTerminoProformas(List<TerminoProforma> newTerminoProformas) {
		this.terminoproformas = newTerminoProformas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Moneda> getmonedasForeignKey() {
		return this.monedasForeignKey;
	}

	public List<Proforma> getproformasForeignKey() {
		return this.proformasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setmonedasForeignKey(List<Moneda> monedasForeignKey) {
		this.monedasForeignKey=monedasForeignKey;
	}

	public void setproformasForeignKey(List<Proforma> proformasForeignKey) {
		this.proformasForeignKey=proformasForeignKey;
	}
}

