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
import com.bydan.erp.cartera.util.DatoConstitucionConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//DatoConstitucion




@SuppressWarnings("unused")
public class DatoConstitucionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DatoConstitucion datoconstitucion;	
	protected List<DatoConstitucion> datoconstitucions;
	
	
	public List<Cliente> clientesForeignKey;
	public List<TipoCompania> tipocompaniasForeignKey;
	
	public DatoConstitucionParameterReturnGeneral () throws Exception {						
		super();
		this.datoconstitucions= new ArrayList<DatoConstitucion>();
		this.datoconstitucion= new DatoConstitucion();
		
		
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipocompaniasForeignKey=new ArrayList<TipoCompania>();
	} 
	
	public DatoConstitucion getDatoConstitucion() throws Exception {	
		return datoconstitucion;
	}
		
	public void setDatoConstitucion(DatoConstitucion newDatoConstitucion) {
		this.datoconstitucion = newDatoConstitucion;
	}
	
	public List<DatoConstitucion> getDatoConstitucions() throws Exception {		
		return datoconstitucions;
	}
	
	public void setDatoConstitucions(List<DatoConstitucion> newDatoConstitucions) {
		this.datoconstitucions = newDatoConstitucions;
	}
	
	

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoCompania> gettipocompaniasForeignKey() {
		return this.tipocompaniasForeignKey;
	}
	
	

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settipocompaniasForeignKey(List<TipoCompania> tipocompaniasForeignKey) {
		this.tipocompaniasForeignKey=tipocompaniasForeignKey;
	}
}

