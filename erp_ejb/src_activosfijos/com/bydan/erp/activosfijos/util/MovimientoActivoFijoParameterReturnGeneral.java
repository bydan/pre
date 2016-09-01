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
package com.bydan.erp.activosfijos.util;

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
import com.bydan.erp.activosfijos.util.MovimientoActivoFijoConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.*;//MovimientoActivoFijo


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class MovimientoActivoFijoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected MovimientoActivoFijo movimientoactivofijo;	
	protected List<MovimientoActivoFijo> movimientoactivofijos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Usuario> usuariosForeignKey;
	public List<Empresa> empresaorigensForeignKey;
	public List<Sucursal> sucursalorigensForeignKey;
	public List<DetalleActivoFijo> detalleactivofijoorigensForeignKey;
	public List<Empresa> empresadestinosForeignKey;
	public List<Sucursal> sucursaldestinosForeignKey;
	public List<DetalleActivoFijo> detalleactivofijodestinosForeignKey;
	
	public MovimientoActivoFijoParameterReturnGeneral () throws Exception {						
		super();
		this.movimientoactivofijos= new ArrayList<MovimientoActivoFijo>();
		this.movimientoactivofijo= new MovimientoActivoFijo();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.usuariosForeignKey=new ArrayList<Usuario>();
		this.empresaorigensForeignKey=new ArrayList<Empresa>();
		this.sucursalorigensForeignKey=new ArrayList<Sucursal>();
		this.detalleactivofijoorigensForeignKey=new ArrayList<DetalleActivoFijo>();
		this.empresadestinosForeignKey=new ArrayList<Empresa>();
		this.sucursaldestinosForeignKey=new ArrayList<Sucursal>();
		this.detalleactivofijodestinosForeignKey=new ArrayList<DetalleActivoFijo>();
	} 
	
	public MovimientoActivoFijo getMovimientoActivoFijo() throws Exception {	
		return movimientoactivofijo;
	}
		
	public void setMovimientoActivoFijo(MovimientoActivoFijo newMovimientoActivoFijo) {
		this.movimientoactivofijo = newMovimientoActivoFijo;
	}
	
	public List<MovimientoActivoFijo> getMovimientoActivoFijos() throws Exception {		
		return movimientoactivofijos;
	}
	
	public void setMovimientoActivoFijos(List<MovimientoActivoFijo> newMovimientoActivoFijos) {
		this.movimientoactivofijos = newMovimientoActivoFijos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Usuario> getusuariosForeignKey() {
		return this.usuariosForeignKey;
	}

	public List<Empresa> getempresaorigensForeignKey() {
		return this.empresaorigensForeignKey;
	}

	public List<Sucursal> getsucursalorigensForeignKey() {
		return this.sucursalorigensForeignKey;
	}

	public List<DetalleActivoFijo> getdetalleactivofijoorigensForeignKey() {
		return this.detalleactivofijoorigensForeignKey;
	}

	public List<Empresa> getempresadestinosForeignKey() {
		return this.empresadestinosForeignKey;
	}

	public List<Sucursal> getsucursaldestinosForeignKey() {
		return this.sucursaldestinosForeignKey;
	}

	public List<DetalleActivoFijo> getdetalleactivofijodestinosForeignKey() {
		return this.detalleactivofijodestinosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setusuariosForeignKey(List<Usuario> usuariosForeignKey) {
		this.usuariosForeignKey=usuariosForeignKey;
	}

	public void setempresaorigensForeignKey(List<Empresa> empresaorigensForeignKey) {
		this.empresaorigensForeignKey=empresaorigensForeignKey;
	}

	public void setsucursalorigensForeignKey(List<Sucursal> sucursalorigensForeignKey) {
		this.sucursalorigensForeignKey=sucursalorigensForeignKey;
	}

	public void setdetalleactivofijoorigensForeignKey(List<DetalleActivoFijo> detalleactivofijoorigensForeignKey) {
		this.detalleactivofijoorigensForeignKey=detalleactivofijoorigensForeignKey;
	}

	public void setempresadestinosForeignKey(List<Empresa> empresadestinosForeignKey) {
		this.empresadestinosForeignKey=empresadestinosForeignKey;
	}

	public void setsucursaldestinosForeignKey(List<Sucursal> sucursaldestinosForeignKey) {
		this.sucursaldestinosForeignKey=sucursaldestinosForeignKey;
	}

	public void setdetalleactivofijodestinosForeignKey(List<DetalleActivoFijo> detalleactivofijodestinosForeignKey) {
		this.detalleactivofijodestinosForeignKey=detalleactivofijodestinosForeignKey;
	}
}

