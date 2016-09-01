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
package com.bydan.erp.facturacion.util.report;

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
import com.bydan.erp.facturacion.util.report.VentasResumidasMontosConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.report.*;//VentasResumidasMontos


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


@SuppressWarnings("unused")
public class VentasResumidasMontosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected VentasResumidasMontos ventasresumidasmontos;	
	protected List<VentasResumidasMontos> ventasresumidasmontoss;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Vendedor> vendedorsForeignKey;
	
	public VentasResumidasMontosParameterReturnGeneral () throws Exception {						
		super();
		this.ventasresumidasmontoss= new ArrayList<VentasResumidasMontos>();
		this.ventasresumidasmontos= new VentasResumidasMontos();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.vendedorsForeignKey=new ArrayList<Vendedor>();
	} 
	
	public VentasResumidasMontos getVentasResumidasMontos() throws Exception {	
		return ventasresumidasmontos;
	}
		
	public void setVentasResumidasMontos(VentasResumidasMontos newVentasResumidasMontos) {
		this.ventasresumidasmontos = newVentasResumidasMontos;
	}
	
	public List<VentasResumidasMontos> getVentasResumidasMontoss() throws Exception {		
		return ventasresumidasmontoss;
	}
	
	public void setVentasResumidasMontoss(List<VentasResumidasMontos> newVentasResumidasMontoss) {
		this.ventasresumidasmontoss = newVentasResumidasMontoss;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Vendedor> getvendedorsForeignKey() {
		return this.vendedorsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setvendedorsForeignKey(List<Vendedor> vendedorsForeignKey) {
		this.vendedorsForeignKey=vendedorsForeignKey;
	}
}

