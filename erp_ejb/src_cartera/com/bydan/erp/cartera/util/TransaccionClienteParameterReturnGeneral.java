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
package com.bydan.erp.cartera.util;

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
import com.bydan.erp.cartera.util.TransaccionClienteConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//TransaccionCliente


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class TransaccionClienteParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TransaccionCliente transaccioncliente;	
	protected List<TransaccionCliente> transaccionclientes;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<Transaccion> transaccion1sForeignKey;
	public List<Transaccion> transaccion2sForeignKey;
	public List<Transaccion> transaccion3sForeignKey;
	public List<Transaccion> transaccion4sForeignKey;
	public List<Transaccion> transaccion5sForeignKey;
	
	public TransaccionClienteParameterReturnGeneral () throws Exception {						
		super();
		this.transaccionclientes= new ArrayList<TransaccionCliente>();
		this.transaccioncliente= new TransaccionCliente();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.transaccion1sForeignKey=new ArrayList<Transaccion>();
		this.transaccion2sForeignKey=new ArrayList<Transaccion>();
		this.transaccion3sForeignKey=new ArrayList<Transaccion>();
		this.transaccion4sForeignKey=new ArrayList<Transaccion>();
		this.transaccion5sForeignKey=new ArrayList<Transaccion>();
	} 
	
	public TransaccionCliente getTransaccionCliente() throws Exception {	
		return transaccioncliente;
	}
		
	public void setTransaccionCliente(TransaccionCliente newTransaccionCliente) {
		this.transaccioncliente = newTransaccionCliente;
	}
	
	public List<TransaccionCliente> getTransaccionClientes() throws Exception {		
		return transaccionclientes;
	}
	
	public void setTransaccionClientes(List<TransaccionCliente> newTransaccionClientes) {
		this.transaccionclientes = newTransaccionClientes;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}

	public List<Transaccion> gettransaccion1sForeignKey() {
		return this.transaccion1sForeignKey;
	}

	public List<Transaccion> gettransaccion2sForeignKey() {
		return this.transaccion2sForeignKey;
	}

	public List<Transaccion> gettransaccion3sForeignKey() {
		return this.transaccion3sForeignKey;
	}

	public List<Transaccion> gettransaccion4sForeignKey() {
		return this.transaccion4sForeignKey;
	}

	public List<Transaccion> gettransaccion5sForeignKey() {
		return this.transaccion5sForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}

	public void settransaccion1sForeignKey(List<Transaccion> transaccion1sForeignKey) {
		this.transaccion1sForeignKey=transaccion1sForeignKey;
	}

	public void settransaccion2sForeignKey(List<Transaccion> transaccion2sForeignKey) {
		this.transaccion2sForeignKey=transaccion2sForeignKey;
	}

	public void settransaccion3sForeignKey(List<Transaccion> transaccion3sForeignKey) {
		this.transaccion3sForeignKey=transaccion3sForeignKey;
	}

	public void settransaccion4sForeignKey(List<Transaccion> transaccion4sForeignKey) {
		this.transaccion4sForeignKey=transaccion4sForeignKey;
	}

	public void settransaccion5sForeignKey(List<Transaccion> transaccion5sForeignKey) {
		this.transaccion5sForeignKey=transaccion5sForeignKey;
	}
}

