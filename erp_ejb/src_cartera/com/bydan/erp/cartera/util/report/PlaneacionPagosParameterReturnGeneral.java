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
import com.bydan.erp.cartera.util.report.PlaneacionPagosConstantesFunciones;

import com.bydan.erp.cartera.business.entity.report.*;//PlaneacionPagos


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


@SuppressWarnings("unused")
public class PlaneacionPagosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PlaneacionPagos planeacionpagos;	
	protected List<PlaneacionPagos> planeacionpagoss;
	
	
	public List<Empresa> empresasForeignKey;
	public List<GrupoCliente> grupoclientesForeignKey;
	public List<Factura> facturasForeignKey;
	public List<Cliente> clientesForeignKey;
	
	public PlaneacionPagosParameterReturnGeneral () throws Exception {						
		super();
		this.planeacionpagoss= new ArrayList<PlaneacionPagos>();
		this.planeacionpagos= new PlaneacionPagos();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.grupoclientesForeignKey=new ArrayList<GrupoCliente>();
		this.facturasForeignKey=new ArrayList<Factura>();
		this.clientesForeignKey=new ArrayList<Cliente>();
	} 
	
	public PlaneacionPagos getPlaneacionPagos() throws Exception {	
		return planeacionpagos;
	}
		
	public void setPlaneacionPagos(PlaneacionPagos newPlaneacionPagos) {
		this.planeacionpagos = newPlaneacionPagos;
	}
	
	public List<PlaneacionPagos> getPlaneacionPagoss() throws Exception {		
		return planeacionpagoss;
	}
	
	public void setPlaneacionPagoss(List<PlaneacionPagos> newPlaneacionPagoss) {
		this.planeacionpagoss = newPlaneacionPagoss;
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

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}
}

