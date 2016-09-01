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
import com.bydan.erp.activosfijos.util.ParteActivoFijoConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.*;//ParteActivoFijo


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ParteActivoFijoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParteActivoFijo parteactivofijo;	
	protected List<ParteActivoFijo> parteactivofijos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<EstadoActivoFijo> estadoactivofijosForeignKey;
	public List<DetalleActivoFijo> detalleactivofijosForeignKey;
	
	public ParteActivoFijoParameterReturnGeneral () throws Exception {						
		super();
		this.parteactivofijos= new ArrayList<ParteActivoFijo>();
		this.parteactivofijo= new ParteActivoFijo();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.estadoactivofijosForeignKey=new ArrayList<EstadoActivoFijo>();
		this.detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
	} 
	
	public ParteActivoFijo getParteActivoFijo() throws Exception {	
		return parteactivofijo;
	}
		
	public void setParteActivoFijo(ParteActivoFijo newParteActivoFijo) {
		this.parteactivofijo = newParteActivoFijo;
	}
	
	public List<ParteActivoFijo> getParteActivoFijos() throws Exception {		
		return parteactivofijos;
	}
	
	public void setParteActivoFijos(List<ParteActivoFijo> newParteActivoFijos) {
		this.parteactivofijos = newParteActivoFijos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<EstadoActivoFijo> getestadoactivofijosForeignKey() {
		return this.estadoactivofijosForeignKey;
	}

	public List<DetalleActivoFijo> getdetalleactivofijosForeignKey() {
		return this.detalleactivofijosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setestadoactivofijosForeignKey(List<EstadoActivoFijo> estadoactivofijosForeignKey) {
		this.estadoactivofijosForeignKey=estadoactivofijosForeignKey;
	}

	public void setdetalleactivofijosForeignKey(List<DetalleActivoFijo> detalleactivofijosForeignKey) {
		this.detalleactivofijosForeignKey=detalleactivofijosForeignKey;
	}
}

