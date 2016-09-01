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
package com.bydan.erp.cartera.util.report;

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
import com.bydan.erp.cartera.util.report.SaldosVencidosProveedoresConstantesFunciones;

import com.bydan.erp.cartera.business.entity.report.*;//SaldosVencidosProveedores


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class SaldosVencidosProveedoresParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected SaldosVencidosProveedores saldosvencidosproveedores;	
	protected List<SaldosVencidosProveedores> saldosvencidosproveedoress;
	
	
	public List<Empresa> empresasForeignKey;
	public List<GrupoCliente> grupoclientesForeignKey;
	public List<Factura> facturasForeignKey;
	public List<Moneda> monedasForeignKey;
	public List<Cliente> clientesForeignKey;
	
	public SaldosVencidosProveedoresParameterReturnGeneral () throws Exception {						
		super();
		this.saldosvencidosproveedoress= new ArrayList<SaldosVencidosProveedores>();
		this.saldosvencidosproveedores= new SaldosVencidosProveedores();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.grupoclientesForeignKey=new ArrayList<GrupoCliente>();
		this.facturasForeignKey=new ArrayList<Factura>();
		this.monedasForeignKey=new ArrayList<Moneda>();
		this.clientesForeignKey=new ArrayList<Cliente>();
	} 
	
	public SaldosVencidosProveedores getSaldosVencidosProveedores() throws Exception {	
		return saldosvencidosproveedores;
	}
		
	public void setSaldosVencidosProveedores(SaldosVencidosProveedores newSaldosVencidosProveedores) {
		this.saldosvencidosproveedores = newSaldosVencidosProveedores;
	}
	
	public List<SaldosVencidosProveedores> getSaldosVencidosProveedoress() throws Exception {		
		return saldosvencidosproveedoress;
	}
	
	public void setSaldosVencidosProveedoress(List<SaldosVencidosProveedores> newSaldosVencidosProveedoress) {
		this.saldosvencidosproveedoress = newSaldosVencidosProveedoress;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<GrupoCliente> getgrupoclientesForeignKey() {
		return this.grupoclientesForeignKey;
	}

	public List<Factura> getfacturasForeignKey() {
		return this.facturasForeignKey;
	}

	public List<Moneda> getmonedasForeignKey() {
		return this.monedasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setgrupoclientesForeignKey(List<GrupoCliente> grupoclientesForeignKey) {
		this.grupoclientesForeignKey=grupoclientesForeignKey;
	}

	public void setfacturasForeignKey(List<Factura> facturasForeignKey) {
		this.facturasForeignKey=facturasForeignKey;
	}

	public void setmonedasForeignKey(List<Moneda> monedasForeignKey) {
		this.monedasForeignKey=monedasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}
}

