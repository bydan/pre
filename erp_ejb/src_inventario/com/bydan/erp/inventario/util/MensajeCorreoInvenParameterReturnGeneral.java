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
import com.bydan.erp.inventario.util.MensajeCorreoInvenConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//MensajeCorreoInven


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class MensajeCorreoInvenParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected MensajeCorreoInven mensajecorreoinven;	
	protected List<MensajeCorreoInven> mensajecorreoinvens;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<TipoMensajeCorreoInven> tipomensajecorreoinvensForeignKey;
	
	public MensajeCorreoInvenParameterReturnGeneral () throws Exception {						
		super();
		this.mensajecorreoinvens= new ArrayList<MensajeCorreoInven>();
		this.mensajecorreoinven= new MensajeCorreoInven();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.tipomensajecorreoinvensForeignKey=new ArrayList<TipoMensajeCorreoInven>();
	} 
	
	public MensajeCorreoInven getMensajeCorreoInven() throws Exception {	
		return mensajecorreoinven;
	}
		
	public void setMensajeCorreoInven(MensajeCorreoInven newMensajeCorreoInven) {
		this.mensajecorreoinven = newMensajeCorreoInven;
	}
	
	public List<MensajeCorreoInven> getMensajeCorreoInvens() throws Exception {		
		return mensajecorreoinvens;
	}
	
	public void setMensajeCorreoInvens(List<MensajeCorreoInven> newMensajeCorreoInvens) {
		this.mensajecorreoinvens = newMensajeCorreoInvens;
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

	public List<TipoMensajeCorreoInven> gettipomensajecorreoinvensForeignKey() {
		return this.tipomensajecorreoinvensForeignKey;
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

	public void settipomensajecorreoinvensForeignKey(List<TipoMensajeCorreoInven> tipomensajecorreoinvensForeignKey) {
		this.tipomensajecorreoinvensForeignKey=tipomensajecorreoinvensForeignKey;
	}
}

