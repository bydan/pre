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
package com.bydan.erp.sris.util.report;

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
import com.bydan.erp.sris.util.report.FacturasPuntoVentaConstantesFunciones;

import com.bydan.erp.sris.business.entity.report.*;//FacturasPuntoVenta


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class FacturasPuntoVentaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected FacturasPuntoVenta facturaspuntoventa;	
	protected List<FacturasPuntoVenta> facturaspuntoventas;
	
	
	public List<Empresa> empresasForeignKey;
	
	public FacturasPuntoVentaParameterReturnGeneral () throws Exception {						
		super();
		this.facturaspuntoventas= new ArrayList<FacturasPuntoVenta>();
		this.facturaspuntoventa= new FacturasPuntoVenta();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public FacturasPuntoVenta getFacturasPuntoVenta() throws Exception {	
		return facturaspuntoventa;
	}
		
	public void setFacturasPuntoVenta(FacturasPuntoVenta newFacturasPuntoVenta) {
		this.facturaspuntoventa = newFacturasPuntoVenta;
	}
	
	public List<FacturasPuntoVenta> getFacturasPuntoVentas() throws Exception {		
		return facturaspuntoventas;
	}
	
	public void setFacturasPuntoVentas(List<FacturasPuntoVenta> newFacturasPuntoVentas) {
		this.facturaspuntoventas = newFacturasPuntoVentas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

