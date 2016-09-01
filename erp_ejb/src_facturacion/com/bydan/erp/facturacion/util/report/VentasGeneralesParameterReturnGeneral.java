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
import com.bydan.erp.facturacion.util.report.VentasGeneralesConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.report.*;//VentasGenerales


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class VentasGeneralesParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected VentasGenerales ventasgenerales;	
	protected List<VentasGenerales> ventasgeneraless;
	
	
	public List<Empresa> empresasForeignKey;
	
	public VentasGeneralesParameterReturnGeneral () throws Exception {						
		super();
		this.ventasgeneraless= new ArrayList<VentasGenerales>();
		this.ventasgenerales= new VentasGenerales();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public VentasGenerales getVentasGenerales() throws Exception {	
		return ventasgenerales;
	}
		
	public void setVentasGenerales(VentasGenerales newVentasGenerales) {
		this.ventasgenerales = newVentasGenerales;
	}
	
	public List<VentasGenerales> getVentasGeneraless() throws Exception {		
		return ventasgeneraless;
	}
	
	public void setVentasGeneraless(List<VentasGenerales> newVentasGeneraless) {
		this.ventasgeneraless = newVentasGeneraless;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

