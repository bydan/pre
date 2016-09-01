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
import com.bydan.erp.inventario.util.UbicacionBodeConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//UbicacionBode


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class UbicacionBodeParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected UbicacionBode ubicacionbode;	
	protected List<UbicacionBode> ubicacionbodes;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<UbicacionBode> ubicacionbodesForeignKey;
	
	public UbicacionBodeParameterReturnGeneral () throws Exception {						
		super();
		this.ubicacionbodes= new ArrayList<UbicacionBode>();
		this.ubicacionbode= new UbicacionBode();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.ubicacionbodesForeignKey=new ArrayList<UbicacionBode>();
	} 
	
	public UbicacionBode getUbicacionBode() throws Exception {	
		return ubicacionbode;
	}
		
	public void setUbicacionBode(UbicacionBode newUbicacionBode) {
		this.ubicacionbode = newUbicacionBode;
	}
	
	public List<UbicacionBode> getUbicacionBodes() throws Exception {		
		return ubicacionbodes;
	}
	
	public void setUbicacionBodes(List<UbicacionBode> newUbicacionBodes) {
		this.ubicacionbodes = newUbicacionBodes;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Bodega> getbodegasForeignKey() {
		return this.bodegasForeignKey;
	}

	public List<UbicacionBode> getubicacionbodesForeignKey() {
		return this.ubicacionbodesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setbodegasForeignKey(List<Bodega> bodegasForeignKey) {
		this.bodegasForeignKey=bodegasForeignKey;
	}

	public void setubicacionbodesForeignKey(List<UbicacionBode> ubicacionbodesForeignKey) {
		this.ubicacionbodesForeignKey=ubicacionbodesForeignKey;
	}
}

