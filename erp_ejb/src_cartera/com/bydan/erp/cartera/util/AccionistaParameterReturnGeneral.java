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
import com.bydan.erp.cartera.util.AccionistaConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//Accionista




@SuppressWarnings("unused")
public class AccionistaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Accionista accionista;	
	protected List<Accionista> accionistas;
	
	
	public List<Cliente> clientesForeignKey;
	public List<TipoInversion> tipoinversionsForeignKey;
	public List<TipoIdentificacion> tipoidentificacionsForeignKey;
	
	public AccionistaParameterReturnGeneral () throws Exception {						
		super();
		this.accionistas= new ArrayList<Accionista>();
		this.accionista= new Accionista();
		
		
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipoinversionsForeignKey=new ArrayList<TipoInversion>();
		this.tipoidentificacionsForeignKey=new ArrayList<TipoIdentificacion>();
	} 
	
	public Accionista getAccionista() throws Exception {	
		return accionista;
	}
		
	public void setAccionista(Accionista newAccionista) {
		this.accionista = newAccionista;
	}
	
	public List<Accionista> getAccionistas() throws Exception {		
		return accionistas;
	}
	
	public void setAccionistas(List<Accionista> newAccionistas) {
		this.accionistas = newAccionistas;
	}
	
	

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoInversion> gettipoinversionsForeignKey() {
		return this.tipoinversionsForeignKey;
	}

	public List<TipoIdentificacion> gettipoidentificacionsForeignKey() {
		return this.tipoidentificacionsForeignKey;
	}
	
	

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settipoinversionsForeignKey(List<TipoInversion> tipoinversionsForeignKey) {
		this.tipoinversionsForeignKey=tipoinversionsForeignKey;
	}

	public void settipoidentificacionsForeignKey(List<TipoIdentificacion> tipoidentificacionsForeignKey) {
		this.tipoidentificacionsForeignKey=tipoidentificacionsForeignKey;
	}
}

