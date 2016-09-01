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
package com.bydan.erp.puntoventa.util;

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
import com.bydan.erp.puntoventa.util.NumeroRecapConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//NumeroRecap


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class NumeroRecapParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected NumeroRecap numerorecap;	
	protected List<NumeroRecap> numerorecaps;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Conexion> conexionsForeignKey;
	
	public NumeroRecapParameterReturnGeneral () throws Exception {						
		super();
		this.numerorecaps= new ArrayList<NumeroRecap>();
		this.numerorecap= new NumeroRecap();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.conexionsForeignKey=new ArrayList<Conexion>();
	} 
	
	public NumeroRecap getNumeroRecap() throws Exception {	
		return numerorecap;
	}
		
	public void setNumeroRecap(NumeroRecap newNumeroRecap) {
		this.numerorecap = newNumeroRecap;
	}
	
	public List<NumeroRecap> getNumeroRecaps() throws Exception {		
		return numerorecaps;
	}
	
	public void setNumeroRecaps(List<NumeroRecap> newNumeroRecaps) {
		this.numerorecaps = newNumeroRecaps;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Conexion> getconexionsForeignKey() {
		return this.conexionsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setconexionsForeignKey(List<Conexion> conexionsForeignKey) {
		this.conexionsForeignKey=conexionsForeignKey;
	}
}

