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
import com.bydan.erp.facturacion.util.report.InformesDevolucionesConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.report.*;//InformesDevoluciones


import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class InformesDevolucionesParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected InformesDevoluciones informesdevoluciones;	
	protected List<InformesDevoluciones> informesdevolucioness;
	
	
	public List<Producto> productosForeignKey;
	public List<TipoDevolucionEmpresa> tipodevolucionempresasForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	
	public InformesDevolucionesParameterReturnGeneral () throws Exception {						
		super();
		this.informesdevolucioness= new ArrayList<InformesDevoluciones>();
		this.informesdevoluciones= new InformesDevoluciones();
		
		
		this.productosForeignKey=new ArrayList<Producto>();
		this.tipodevolucionempresasForeignKey=new ArrayList<TipoDevolucionEmpresa>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
	} 
	
	public InformesDevoluciones getInformesDevoluciones() throws Exception {	
		return informesdevoluciones;
	}
		
	public void setInformesDevoluciones(InformesDevoluciones newInformesDevoluciones) {
		this.informesdevoluciones = newInformesDevoluciones;
	}
	
	public List<InformesDevoluciones> getInformesDevolucioness() throws Exception {		
		return informesdevolucioness;
	}
	
	public void setInformesDevolucioness(List<InformesDevoluciones> newInformesDevolucioness) {
		this.informesdevolucioness = newInformesDevolucioness;
	}
	
	

	public List<Producto> getproductosForeignKey() {
		return this.productosForeignKey;
	}

	public List<TipoDevolucionEmpresa> gettipodevolucionempresasForeignKey() {
		return this.tipodevolucionempresasForeignKey;
	}

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}
	
	

	public void setproductosForeignKey(List<Producto> productosForeignKey) {
		this.productosForeignKey=productosForeignKey;
	}

	public void settipodevolucionempresasForeignKey(List<TipoDevolucionEmpresa> tipodevolucionempresasForeignKey) {
		this.tipodevolucionempresasForeignKey=tipodevolucionempresasForeignKey;
	}

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}
}

