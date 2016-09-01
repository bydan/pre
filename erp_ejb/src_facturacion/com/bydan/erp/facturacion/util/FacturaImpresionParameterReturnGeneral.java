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
import com.bydan.erp.facturacion.util.FacturaImpresionConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//FacturaImpresion


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class FacturaImpresionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected FacturaImpresion facturaimpresion;	
	protected List<FacturaImpresion> facturaimpresions;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Factura> facturasForeignKey;
	public List<EstadoFactuImpre> estadofactuimpresForeignKey;
	
	public FacturaImpresionParameterReturnGeneral () throws Exception {						
		super();
		this.facturaimpresions= new ArrayList<FacturaImpresion>();
		this.facturaimpresion= new FacturaImpresion();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.facturasForeignKey=new ArrayList<Factura>();
		this.estadofactuimpresForeignKey=new ArrayList<EstadoFactuImpre>();
	} 
	
	public FacturaImpresion getFacturaImpresion() throws Exception {	
		return facturaimpresion;
	}
		
	public void setFacturaImpresion(FacturaImpresion newFacturaImpresion) {
		this.facturaimpresion = newFacturaImpresion;
	}
	
	public List<FacturaImpresion> getFacturaImpresions() throws Exception {		
		return facturaimpresions;
	}
	
	public void setFacturaImpresions(List<FacturaImpresion> newFacturaImpresions) {
		this.facturaimpresions = newFacturaImpresions;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Factura> getfacturasForeignKey() {
		return this.facturasForeignKey;
	}

	public List<EstadoFactuImpre> getestadofactuimpresForeignKey() {
		return this.estadofactuimpresForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setfacturasForeignKey(List<Factura> facturasForeignKey) {
		this.facturasForeignKey=facturasForeignKey;
	}

	public void setestadofactuimpresForeignKey(List<EstadoFactuImpre> estadofactuimpresForeignKey) {
		this.estadofactuimpresForeignKey=estadofactuimpresForeignKey;
	}
}

