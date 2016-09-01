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
package com.bydan.erp.seguridad.util;

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
import com.bydan.erp.seguridad.util.EmpresaConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.*;//Empresa




@SuppressWarnings("unused")
public class EmpresaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Empresa empresa;	
	protected List<Empresa> empresas;
	
	
	public List<Pais> paissForeignKey;
	public List<Ciudad> ciudadsForeignKey;
	public List<TipoEmpresa> tipoempresasForeignKey;
	
	public EmpresaParameterReturnGeneral () throws Exception {						
		super();
		this.empresas= new ArrayList<Empresa>();
		this.empresa= new Empresa();
		
		
		this.paissForeignKey=new ArrayList<Pais>();
		this.ciudadsForeignKey=new ArrayList<Ciudad>();
		this.tipoempresasForeignKey=new ArrayList<TipoEmpresa>();
	} 
	
	public Empresa getEmpresa() throws Exception {	
		return empresa;
	}
		
	public void setEmpresa(Empresa newEmpresa) {
		this.empresa = newEmpresa;
	}
	
	public List<Empresa> getEmpresas() throws Exception {		
		return empresas;
	}
	
	public void setEmpresas(List<Empresa> newEmpresas) {
		this.empresas = newEmpresas;
	}
	
	

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<Ciudad> getciudadsForeignKey() {
		return this.ciudadsForeignKey;
	}

	public List<TipoEmpresa> gettipoempresasForeignKey() {
		return this.tipoempresasForeignKey;
	}
	
	

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setciudadsForeignKey(List<Ciudad> ciudadsForeignKey) {
		this.ciudadsForeignKey=ciudadsForeignKey;
	}

	public void settipoempresasForeignKey(List<TipoEmpresa> tipoempresasForeignKey) {
		this.tipoempresasForeignKey=tipoempresasForeignKey;
	}
}

