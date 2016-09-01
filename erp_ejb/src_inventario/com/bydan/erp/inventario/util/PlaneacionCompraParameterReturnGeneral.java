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
import com.bydan.erp.inventario.util.PlaneacionCompraConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//PlaneacionCompra


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class PlaneacionCompraParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PlaneacionCompra planeacioncompra;	
	protected List<PlaneacionCompra> planeacioncompras;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Usuario> usuariosForeignKey;
	public List<Formato> formatosForeignKey;
	public List<Mes> mesiniciosForeignKey;
	public List<Mes> mesfinsForeignKey;
	
	public PlaneacionCompraParameterReturnGeneral () throws Exception {						
		super();
		this.planeacioncompras= new ArrayList<PlaneacionCompra>();
		this.planeacioncompra= new PlaneacionCompra();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.usuariosForeignKey=new ArrayList<Usuario>();
		this.formatosForeignKey=new ArrayList<Formato>();
		this.mesiniciosForeignKey=new ArrayList<Mes>();
		this.mesfinsForeignKey=new ArrayList<Mes>();
	} 
	
	public PlaneacionCompra getPlaneacionCompra() throws Exception {	
		return planeacioncompra;
	}
		
	public void setPlaneacionCompra(PlaneacionCompra newPlaneacionCompra) {
		this.planeacioncompra = newPlaneacionCompra;
	}
	
	public List<PlaneacionCompra> getPlaneacionCompras() throws Exception {		
		return planeacioncompras;
	}
	
	public void setPlaneacionCompras(List<PlaneacionCompra> newPlaneacionCompras) {
		this.planeacioncompras = newPlaneacionCompras;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}

	public List<Periodo> getperiodosForeignKey() {
		return this.periodosForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Usuario> getusuariosForeignKey() {
		return this.usuariosForeignKey;
	}

	public List<Formato> getformatosForeignKey() {
		return this.formatosForeignKey;
	}

	public List<Mes> getmesiniciosForeignKey() {
		return this.mesiniciosForeignKey;
	}

	public List<Mes> getmesfinsForeignKey() {
		return this.mesfinsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setperiodosForeignKey(List<Periodo> periodosForeignKey) {
		this.periodosForeignKey=periodosForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setusuariosForeignKey(List<Usuario> usuariosForeignKey) {
		this.usuariosForeignKey=usuariosForeignKey;
	}

	public void setformatosForeignKey(List<Formato> formatosForeignKey) {
		this.formatosForeignKey=formatosForeignKey;
	}

	public void setmesiniciosForeignKey(List<Mes> mesiniciosForeignKey) {
		this.mesiniciosForeignKey=mesiniciosForeignKey;
	}

	public void setmesfinsForeignKey(List<Mes> mesfinsForeignKey) {
		this.mesfinsForeignKey=mesfinsForeignKey;
	}
}

