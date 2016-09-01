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
package com.bydan.erp.nomina.util;

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
import com.bydan.erp.nomina.util.FormatoNomiFactorNomiConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//FormatoNomiFactorNomi


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class FormatoNomiFactorNomiParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected FormatoNomiFactorNomi formatonomifactornomi;	
	protected List<FormatoNomiFactorNomi> formatonomifactornomis;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<FormatoNomi> formatonomisForeignKey;
	public List<FactorNomi> factornomisForeignKey;
	
	public FormatoNomiFactorNomiParameterReturnGeneral () throws Exception {						
		super();
		this.formatonomifactornomis= new ArrayList<FormatoNomiFactorNomi>();
		this.formatonomifactornomi= new FormatoNomiFactorNomi();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.formatonomisForeignKey=new ArrayList<FormatoNomi>();
		this.factornomisForeignKey=new ArrayList<FactorNomi>();
	} 
	
	public FormatoNomiFactorNomi getFormatoNomiFactorNomi() throws Exception {	
		return formatonomifactornomi;
	}
		
	public void setFormatoNomiFactorNomi(FormatoNomiFactorNomi newFormatoNomiFactorNomi) {
		this.formatonomifactornomi = newFormatoNomiFactorNomi;
	}
	
	public List<FormatoNomiFactorNomi> getFormatoNomiFactorNomis() throws Exception {		
		return formatonomifactornomis;
	}
	
	public void setFormatoNomiFactorNomis(List<FormatoNomiFactorNomi> newFormatoNomiFactorNomis) {
		this.formatonomifactornomis = newFormatoNomiFactorNomis;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<FormatoNomi> getformatonomisForeignKey() {
		return this.formatonomisForeignKey;
	}

	public List<FactorNomi> getfactornomisForeignKey() {
		return this.factornomisForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setformatonomisForeignKey(List<FormatoNomi> formatonomisForeignKey) {
		this.formatonomisForeignKey=formatonomisForeignKey;
	}

	public void setfactornomisForeignKey(List<FactorNomi> factornomisForeignKey) {
		this.factornomisForeignKey=factornomisForeignKey;
	}
}

