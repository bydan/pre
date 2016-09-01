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
import com.bydan.erp.inventario.util.MailMensajeCorreoInvenConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//MailMensajeCorreoInven


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class MailMensajeCorreoInvenParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected MailMensajeCorreoInven mailmensajecorreoinven;	
	protected List<MailMensajeCorreoInven> mailmensajecorreoinvens;
	
	
	public List<MensajeCorreoInven> mensajecorreoinvensForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Modulo> modulosForeignKey;
	
	public MailMensajeCorreoInvenParameterReturnGeneral () throws Exception {						
		super();
		this.mailmensajecorreoinvens= new ArrayList<MailMensajeCorreoInven>();
		this.mailmensajecorreoinven= new MailMensajeCorreoInven();
		
		
		this.mensajecorreoinvensForeignKey=new ArrayList<MensajeCorreoInven>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.modulosForeignKey=new ArrayList<Modulo>();
	} 
	
	public MailMensajeCorreoInven getMailMensajeCorreoInven() throws Exception {	
		return mailmensajecorreoinven;
	}
		
	public void setMailMensajeCorreoInven(MailMensajeCorreoInven newMailMensajeCorreoInven) {
		this.mailmensajecorreoinven = newMailMensajeCorreoInven;
	}
	
	public List<MailMensajeCorreoInven> getMailMensajeCorreoInvens() throws Exception {		
		return mailmensajecorreoinvens;
	}
	
	public void setMailMensajeCorreoInvens(List<MailMensajeCorreoInven> newMailMensajeCorreoInvens) {
		this.mailmensajecorreoinvens = newMailMensajeCorreoInvens;
	}
	
	

	public List<MensajeCorreoInven> getmensajecorreoinvensForeignKey() {
		return this.mensajecorreoinvensForeignKey;
	}

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}
	
	

	public void setmensajecorreoinvensForeignKey(List<MensajeCorreoInven> mensajecorreoinvensForeignKey) {
		this.mensajecorreoinvensForeignKey=mensajecorreoinvensForeignKey;
	}

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}
}

