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
import com.bydan.erp.facturacion.util.SecuencialUsuarioConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//SecuencialUsuario


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class SecuencialUsuarioParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected SecuencialUsuario secuencialusuario;	
	protected List<SecuencialUsuario> secuencialusuarios;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Usuario> usuariosForeignKey;
	public List<TipoDocumentoGeneral> tipodocumentogeneralsForeignKey;
	
	public SecuencialUsuarioParameterReturnGeneral () throws Exception {						
		super();
		this.secuencialusuarios= new ArrayList<SecuencialUsuario>();
		this.secuencialusuario= new SecuencialUsuario();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.usuariosForeignKey=new ArrayList<Usuario>();
		this.tipodocumentogeneralsForeignKey=new ArrayList<TipoDocumentoGeneral>();
	} 
	
	public SecuencialUsuario getSecuencialUsuario() throws Exception {	
		return secuencialusuario;
	}
		
	public void setSecuencialUsuario(SecuencialUsuario newSecuencialUsuario) {
		this.secuencialusuario = newSecuencialUsuario;
	}
	
	public List<SecuencialUsuario> getSecuencialUsuarios() throws Exception {		
		return secuencialusuarios;
	}
	
	public void setSecuencialUsuarios(List<SecuencialUsuario> newSecuencialUsuarios) {
		this.secuencialusuarios = newSecuencialUsuarios;
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

	public List<TipoDocumentoGeneral> gettipodocumentogeneralsForeignKey() {
		return this.tipodocumentogeneralsForeignKey;
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

	public void settipodocumentogeneralsForeignKey(List<TipoDocumentoGeneral> tipodocumentogeneralsForeignKey) {
		this.tipodocumentogeneralsForeignKey=tipodocumentogeneralsForeignKey;
	}
}

