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
import com.bydan.erp.facturacion.util.report.VentasCanalesConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.report.*;//VentasCanales


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class VentasCanalesParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected VentasCanales ventascanales;	
	protected List<VentasCanales> ventascanaless;
	
	
	public List<Empresa> empresasForeignKey;
	public List<TituloCliente> tituloclientesForeignKey;
	
	public VentasCanalesParameterReturnGeneral () throws Exception {						
		super();
		this.ventascanaless= new ArrayList<VentasCanales>();
		this.ventascanales= new VentasCanales();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.tituloclientesForeignKey=new ArrayList<TituloCliente>();
	} 
	
	public VentasCanales getVentasCanales() throws Exception {	
		return ventascanales;
	}
		
	public void setVentasCanales(VentasCanales newVentasCanales) {
		this.ventascanales = newVentasCanales;
	}
	
	public List<VentasCanales> getVentasCanaless() throws Exception {		
		return ventascanaless;
	}
	
	public void setVentasCanaless(List<VentasCanales> newVentasCanaless) {
		this.ventascanaless = newVentasCanaless;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<TituloCliente> gettituloclientesForeignKey() {
		return this.tituloclientesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settituloclientesForeignKey(List<TituloCliente> tituloclientesForeignKey) {
		this.tituloclientesForeignKey=tituloclientesForeignKey;
	}
}

