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
package com.bydan.erp.puntoventa.util;

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
import com.bydan.erp.puntoventa.util.ConexionConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//Conexion




@SuppressWarnings("unused")
public class ConexionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Conexion conexion;	
	protected List<Conexion> conexions;
	
	
	public List<TipoConexion> tipoconexionsForeignKey;
	
	public ConexionParameterReturnGeneral () throws Exception {						
		super();
		this.conexions= new ArrayList<Conexion>();
		this.conexion= new Conexion();
		
		
		this.tipoconexionsForeignKey=new ArrayList<TipoConexion>();
	} 
	
	public Conexion getConexion() throws Exception {	
		return conexion;
	}
		
	public void setConexion(Conexion newConexion) {
		this.conexion = newConexion;
	}
	
	public List<Conexion> getConexions() throws Exception {		
		return conexions;
	}
	
	public void setConexions(List<Conexion> newConexions) {
		this.conexions = newConexions;
	}
	
	

	public List<TipoConexion> gettipoconexionsForeignKey() {
		return this.tipoconexionsForeignKey;
	}
	
	

	public void settipoconexionsForeignKey(List<TipoConexion> tipoconexionsForeignKey) {
		this.tipoconexionsForeignKey=tipoconexionsForeignKey;
	}
}

