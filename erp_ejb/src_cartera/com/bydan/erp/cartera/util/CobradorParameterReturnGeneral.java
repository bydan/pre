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
import com.bydan.erp.cartera.util.CobradorConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//Cobrador




@SuppressWarnings("unused")
public class CobradorParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Cobrador cobrador;	
	protected List<Cobrador> cobradors;
	
	
	public List<TipoIdentificacion> tipoidentificacionsForeignKey;
	
	public CobradorParameterReturnGeneral () throws Exception {						
		super();
		this.cobradors= new ArrayList<Cobrador>();
		this.cobrador= new Cobrador();
		
		
		this.tipoidentificacionsForeignKey=new ArrayList<TipoIdentificacion>();
	} 
	
	public Cobrador getCobrador() throws Exception {	
		return cobrador;
	}
		
	public void setCobrador(Cobrador newCobrador) {
		this.cobrador = newCobrador;
	}
	
	public List<Cobrador> getCobradors() throws Exception {		
		return cobradors;
	}
	
	public void setCobradors(List<Cobrador> newCobradors) {
		this.cobradors = newCobradors;
	}
	
	

	public List<TipoIdentificacion> gettipoidentificacionsForeignKey() {
		return this.tipoidentificacionsForeignKey;
	}
	
	

	public void settipoidentificacionsForeignKey(List<TipoIdentificacion> tipoidentificacionsForeignKey) {
		this.tipoidentificacionsForeignKey=tipoidentificacionsForeignKey;
	}
}

