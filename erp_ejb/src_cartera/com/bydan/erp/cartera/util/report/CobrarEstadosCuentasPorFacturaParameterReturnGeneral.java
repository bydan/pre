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
import com.bydan.erp.cartera.util.report.CobrarEstadosCuentasPorFacturaConstantesFunciones;

import com.bydan.erp.cartera.business.entity.report.*;//CobrarEstadosCuentasPorFactura


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class CobrarEstadosCuentasPorFacturaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura;	
	protected List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturas;
	
	
	public List<Empresa> empresasForeignKey;
	
	public CobrarEstadosCuentasPorFacturaParameterReturnGeneral () throws Exception {						
		super();
		this.cobrarestadoscuentasporfacturas= new ArrayList<CobrarEstadosCuentasPorFactura>();
		this.cobrarestadoscuentasporfactura= new CobrarEstadosCuentasPorFactura();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public CobrarEstadosCuentasPorFactura getCobrarEstadosCuentasPorFactura() throws Exception {	
		return cobrarestadoscuentasporfactura;
	}
		
	public void setCobrarEstadosCuentasPorFactura(CobrarEstadosCuentasPorFactura newCobrarEstadosCuentasPorFactura) {
		this.cobrarestadoscuentasporfactura = newCobrarEstadosCuentasPorFactura;
	}
	
	public List<CobrarEstadosCuentasPorFactura> getCobrarEstadosCuentasPorFacturas() throws Exception {		
		return cobrarestadoscuentasporfacturas;
	}
	
	public void setCobrarEstadosCuentasPorFacturas(List<CobrarEstadosCuentasPorFactura> newCobrarEstadosCuentasPorFacturas) {
		this.cobrarestadoscuentasporfacturas = newCobrarEstadosCuentasPorFacturas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

