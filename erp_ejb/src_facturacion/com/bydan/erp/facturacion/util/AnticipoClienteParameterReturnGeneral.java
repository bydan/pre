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
import com.bydan.erp.facturacion.util.AnticipoClienteConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//AnticipoCliente


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class AnticipoClienteParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected AnticipoCliente anticipocliente;	
	protected List<AnticipoCliente> anticipoclientes;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<EstadoAntiCliente> estadoanticlientesForeignKey;
	public List<TipoGrupoFormaPago> tipogrupoformapagosForeignKey;
	
	public AnticipoClienteParameterReturnGeneral () throws Exception {						
		super();
		this.anticipoclientes= new ArrayList<AnticipoCliente>();
		this.anticipocliente= new AnticipoCliente();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.estadoanticlientesForeignKey=new ArrayList<EstadoAntiCliente>();
		this.tipogrupoformapagosForeignKey=new ArrayList<TipoGrupoFormaPago>();
	} 
	
	public AnticipoCliente getAnticipoCliente() throws Exception {	
		return anticipocliente;
	}
		
	public void setAnticipoCliente(AnticipoCliente newAnticipoCliente) {
		this.anticipocliente = newAnticipoCliente;
	}
	
	public List<AnticipoCliente> getAnticipoClientes() throws Exception {		
		return anticipoclientes;
	}
	
	public void setAnticipoClientes(List<AnticipoCliente> newAnticipoClientes) {
		this.anticipoclientes = newAnticipoClientes;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<EstadoAntiCliente> getestadoanticlientesForeignKey() {
		return this.estadoanticlientesForeignKey;
	}

	public List<TipoGrupoFormaPago> gettipogrupoformapagosForeignKey() {
		return this.tipogrupoformapagosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setestadoanticlientesForeignKey(List<EstadoAntiCliente> estadoanticlientesForeignKey) {
		this.estadoanticlientesForeignKey=estadoanticlientesForeignKey;
	}

	public void settipogrupoformapagosForeignKey(List<TipoGrupoFormaPago> tipogrupoformapagosForeignKey) {
		this.tipogrupoformapagosForeignKey=tipogrupoformapagosForeignKey;
	}
}

