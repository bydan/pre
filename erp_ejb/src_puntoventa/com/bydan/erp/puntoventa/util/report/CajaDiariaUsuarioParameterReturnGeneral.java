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
package com.bydan.erp.puntoventa.util.report;

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
import com.bydan.erp.puntoventa.util.report.CajaDiariaUsuarioConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.report.*;//CajaDiariaUsuario


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


@SuppressWarnings("unused")
public class CajaDiariaUsuarioParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CajaDiariaUsuario cajadiariausuario;	
	protected List<CajaDiariaUsuario> cajadiariausuarios;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<Caja> cajasForeignKey;
	public List<Usuario> usuariosForeignKey;
	
	public CajaDiariaUsuarioParameterReturnGeneral () throws Exception {						
		super();
		this.cajadiariausuarios= new ArrayList<CajaDiariaUsuario>();
		this.cajadiariausuario= new CajaDiariaUsuario();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.cajasForeignKey=new ArrayList<Caja>();
		this.usuariosForeignKey=new ArrayList<Usuario>();
	} 
	
	public CajaDiariaUsuario getCajaDiariaUsuario() throws Exception {	
		return cajadiariausuario;
	}
		
	public void setCajaDiariaUsuario(CajaDiariaUsuario newCajaDiariaUsuario) {
		this.cajadiariausuario = newCajaDiariaUsuario;
	}
	
	public List<CajaDiariaUsuario> getCajaDiariaUsuarios() throws Exception {		
		return cajadiariausuarios;
	}
	
	public void setCajaDiariaUsuarios(List<CajaDiariaUsuario> newCajaDiariaUsuarios) {
		this.cajadiariausuarios = newCajaDiariaUsuarios;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<Caja> getcajasForeignKey() {
		return this.cajasForeignKey;
	}

	public List<Usuario> getusuariosForeignKey() {
		return this.usuariosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void setcajasForeignKey(List<Caja> cajasForeignKey) {
		this.cajasForeignKey=cajasForeignKey;
	}

	public void setusuariosForeignKey(List<Usuario> usuariosForeignKey) {
		this.usuariosForeignKey=usuariosForeignKey;
	}
}

