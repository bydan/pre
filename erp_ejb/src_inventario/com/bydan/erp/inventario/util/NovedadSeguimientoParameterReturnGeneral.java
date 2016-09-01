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
package com.bydan.erp.inventario.util;

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
import com.bydan.erp.inventario.util.NovedadSeguimientoConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//NovedadSeguimiento


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class NovedadSeguimientoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected NovedadSeguimiento novedadseguimiento;	
	protected List<NovedadSeguimiento> novedadseguimientos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<DetalleMovimientoInventario> detallemovimientoinventariosForeignKey;
	public List<NovedadProducto> novedadproductosForeignKey;
	public List<EstadoNovedadSeguimiento> estadonovedadseguimientosForeignKey;
	
	public NovedadSeguimientoParameterReturnGeneral () throws Exception {						
		super();
		this.novedadseguimientos= new ArrayList<NovedadSeguimiento>();
		this.novedadseguimiento= new NovedadSeguimiento();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.detallemovimientoinventariosForeignKey=new ArrayList<DetalleMovimientoInventario>();
		this.novedadproductosForeignKey=new ArrayList<NovedadProducto>();
		this.estadonovedadseguimientosForeignKey=new ArrayList<EstadoNovedadSeguimiento>();
	} 
	
	public NovedadSeguimiento getNovedadSeguimiento() throws Exception {	
		return novedadseguimiento;
	}
		
	public void setNovedadSeguimiento(NovedadSeguimiento newNovedadSeguimiento) {
		this.novedadseguimiento = newNovedadSeguimiento;
	}
	
	public List<NovedadSeguimiento> getNovedadSeguimientos() throws Exception {		
		return novedadseguimientos;
	}
	
	public void setNovedadSeguimientos(List<NovedadSeguimiento> newNovedadSeguimientos) {
		this.novedadseguimientos = newNovedadSeguimientos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<DetalleMovimientoInventario> getdetallemovimientoinventariosForeignKey() {
		return this.detallemovimientoinventariosForeignKey;
	}

	public List<NovedadProducto> getnovedadproductosForeignKey() {
		return this.novedadproductosForeignKey;
	}

	public List<EstadoNovedadSeguimiento> getestadonovedadseguimientosForeignKey() {
		return this.estadonovedadseguimientosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setdetallemovimientoinventariosForeignKey(List<DetalleMovimientoInventario> detallemovimientoinventariosForeignKey) {
		this.detallemovimientoinventariosForeignKey=detallemovimientoinventariosForeignKey;
	}

	public void setnovedadproductosForeignKey(List<NovedadProducto> novedadproductosForeignKey) {
		this.novedadproductosForeignKey=novedadproductosForeignKey;
	}

	public void setestadonovedadseguimientosForeignKey(List<EstadoNovedadSeguimiento> estadonovedadseguimientosForeignKey) {
		this.estadonovedadseguimientosForeignKey=estadonovedadseguimientosForeignKey;
	}
}

