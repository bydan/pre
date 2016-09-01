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
import com.bydan.erp.facturacion.util.EstadoFisicoFacturaConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//EstadoFisicoFactura


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class EstadoFisicoFacturaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EstadoFisicoFactura estadofisicofactura;	
	protected List<EstadoFisicoFactura> estadofisicofacturas;
	
	
	public List<Pais> paissForeignKey;
	
	public EstadoFisicoFacturaParameterReturnGeneral () throws Exception {						
		super();
		this.estadofisicofacturas= new ArrayList<EstadoFisicoFactura>();
		this.estadofisicofactura= new EstadoFisicoFactura();
		
		
		this.paissForeignKey=new ArrayList<Pais>();
	} 
	
	public EstadoFisicoFactura getEstadoFisicoFactura() throws Exception {	
		return estadofisicofactura;
	}
		
	public void setEstadoFisicoFactura(EstadoFisicoFactura newEstadoFisicoFactura) {
		this.estadofisicofactura = newEstadoFisicoFactura;
	}
	
	public List<EstadoFisicoFactura> getEstadoFisicoFacturas() throws Exception {		
		return estadofisicofacturas;
	}
	
	public void setEstadoFisicoFacturas(List<EstadoFisicoFactura> newEstadoFisicoFacturas) {
		this.estadofisicofacturas = newEstadoFisicoFacturas;
	}
	
	

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}
	
	

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}
}

