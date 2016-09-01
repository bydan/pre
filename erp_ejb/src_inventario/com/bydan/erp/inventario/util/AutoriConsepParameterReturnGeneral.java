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
import com.bydan.erp.inventario.util.AutoriConsepConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//AutoriConsep


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class AutoriConsepParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected AutoriConsep autoriconsep;	
	protected List<AutoriConsep> autoriconseps;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Usuario> usuariosForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<TipoAutoriConsep> tipoautoriconsepsForeignKey;
	public List<Empleado> empleadosForeignKey;
	
	public AutoriConsepParameterReturnGeneral () throws Exception {						
		super();
		this.autoriconseps= new ArrayList<AutoriConsep>();
		this.autoriconsep= new AutoriConsep();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.usuariosForeignKey=new ArrayList<Usuario>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipoautoriconsepsForeignKey=new ArrayList<TipoAutoriConsep>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
	} 
	
	public AutoriConsep getAutoriConsep() throws Exception {	
		return autoriconsep;
	}
		
	public void setAutoriConsep(AutoriConsep newAutoriConsep) {
		this.autoriconsep = newAutoriConsep;
	}
	
	public List<AutoriConsep> getAutoriConseps() throws Exception {		
		return autoriconseps;
	}
	
	public void setAutoriConseps(List<AutoriConsep> newAutoriConseps) {
		this.autoriconseps = newAutoriConseps;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Usuario> getusuariosForeignKey() {
		return this.usuariosForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoAutoriConsep> gettipoautoriconsepsForeignKey() {
		return this.tipoautoriconsepsForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setusuariosForeignKey(List<Usuario> usuariosForeignKey) {
		this.usuariosForeignKey=usuariosForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settipoautoriconsepsForeignKey(List<TipoAutoriConsep> tipoautoriconsepsForeignKey) {
		this.tipoautoriconsepsForeignKey=tipoautoriconsepsForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}
}

