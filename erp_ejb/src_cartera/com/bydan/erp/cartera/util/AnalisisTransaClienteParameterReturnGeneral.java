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
import com.bydan.erp.cartera.util.AnalisisTransaClienteConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//AnalisisTransaCliente


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class AnalisisTransaClienteParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected AnalisisTransaCliente analisistransacliente;	
	protected List<AnalisisTransaCliente> analisistransaclientes;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<Transaccion> transaccionsForeignKey;
	public List<Transaccion> transaccion1sForeignKey;
	public List<Transaccion> transaccion2sForeignKey;
	public List<Transaccion> transaccion3sForeignKey;
	public List<Transaccion> transaccion4sForeignKey;
	public List<Transaccion> transaccion5sForeignKey;
	public List<Transaccion> transaccion6sForeignKey;
	public List<Transaccion> transaccion7sForeignKey;
	public List<Transaccion> transaccion8sForeignKey;
	public List<Transaccion> transaccion9sForeignKey;
	public List<Transaccion> transaccion10sForeignKey;
	
	public AnalisisTransaClienteParameterReturnGeneral () throws Exception {						
		super();
		this.analisistransaclientes= new ArrayList<AnalisisTransaCliente>();
		this.analisistransacliente= new AnalisisTransaCliente();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.transaccionsForeignKey=new ArrayList<Transaccion>();
		this.transaccion1sForeignKey=new ArrayList<Transaccion>();
		this.transaccion2sForeignKey=new ArrayList<Transaccion>();
		this.transaccion3sForeignKey=new ArrayList<Transaccion>();
		this.transaccion4sForeignKey=new ArrayList<Transaccion>();
		this.transaccion5sForeignKey=new ArrayList<Transaccion>();
		this.transaccion6sForeignKey=new ArrayList<Transaccion>();
		this.transaccion7sForeignKey=new ArrayList<Transaccion>();
		this.transaccion8sForeignKey=new ArrayList<Transaccion>();
		this.transaccion9sForeignKey=new ArrayList<Transaccion>();
		this.transaccion10sForeignKey=new ArrayList<Transaccion>();
	} 
	
	public AnalisisTransaCliente getAnalisisTransaCliente() throws Exception {	
		return analisistransacliente;
	}
		
	public void setAnalisisTransaCliente(AnalisisTransaCliente newAnalisisTransaCliente) {
		this.analisistransacliente = newAnalisisTransaCliente;
	}
	
	public List<AnalisisTransaCliente> getAnalisisTransaClientes() throws Exception {		
		return analisistransaclientes;
	}
	
	public void setAnalisisTransaClientes(List<AnalisisTransaCliente> newAnalisisTransaClientes) {
		this.analisistransaclientes = newAnalisisTransaClientes;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}

	public List<Transaccion> gettransaccionsForeignKey() {
		return this.transaccionsForeignKey;
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

	public List<Transaccion> gettransaccion6sForeignKey() {
		return this.transaccion6sForeignKey;
	}

	public List<Transaccion> gettransaccion7sForeignKey() {
		return this.transaccion7sForeignKey;
	}

	public List<Transaccion> gettransaccion8sForeignKey() {
		return this.transaccion8sForeignKey;
	}

	public List<Transaccion> gettransaccion9sForeignKey() {
		return this.transaccion9sForeignKey;
	}

	public List<Transaccion> gettransaccion10sForeignKey() {
		return this.transaccion10sForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}

	public void settransaccionsForeignKey(List<Transaccion> transaccionsForeignKey) {
		this.transaccionsForeignKey=transaccionsForeignKey;
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

	public void settransaccion6sForeignKey(List<Transaccion> transaccion6sForeignKey) {
		this.transaccion6sForeignKey=transaccion6sForeignKey;
	}

	public void settransaccion7sForeignKey(List<Transaccion> transaccion7sForeignKey) {
		this.transaccion7sForeignKey=transaccion7sForeignKey;
	}

	public void settransaccion8sForeignKey(List<Transaccion> transaccion8sForeignKey) {
		this.transaccion8sForeignKey=transaccion8sForeignKey;
	}

	public void settransaccion9sForeignKey(List<Transaccion> transaccion9sForeignKey) {
		this.transaccion9sForeignKey=transaccion9sForeignKey;
	}

	public void settransaccion10sForeignKey(List<Transaccion> transaccion10sForeignKey) {
		this.transaccion10sForeignKey=transaccion10sForeignKey;
	}
}

