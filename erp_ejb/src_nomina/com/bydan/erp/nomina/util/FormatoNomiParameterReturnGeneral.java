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
import com.bydan.erp.nomina.util.FormatoNomiConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//FormatoNomi


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class FormatoNomiParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected FormatoNomi formatonomi;	
	protected List<FormatoNomi> formatonomis;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Estructura> estructurasForeignKey;
	public List<PuntajeNomi> puntajenomisForeignKey;
	
	public FormatoNomiParameterReturnGeneral () throws Exception {						
		super();
		this.formatonomis= new ArrayList<FormatoNomi>();
		this.formatonomi= new FormatoNomi();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
		this.puntajenomisForeignKey=new ArrayList<PuntajeNomi>();
	} 
	
	public FormatoNomi getFormatoNomi() throws Exception {	
		return formatonomi;
	}
		
	public void setFormatoNomi(FormatoNomi newFormatoNomi) {
		this.formatonomi = newFormatoNomi;
	}
	
	public List<FormatoNomi> getFormatoNomis() throws Exception {		
		return formatonomis;
	}
	
	public void setFormatoNomis(List<FormatoNomi> newFormatoNomis) {
		this.formatonomis = newFormatoNomis;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Estructura> getestructurasForeignKey() {
		return this.estructurasForeignKey;
	}

	public List<PuntajeNomi> getpuntajenomisForeignKey() {
		return this.puntajenomisForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setestructurasForeignKey(List<Estructura> estructurasForeignKey) {
		this.estructurasForeignKey=estructurasForeignKey;
	}

	public void setpuntajenomisForeignKey(List<PuntajeNomi> puntajenomisForeignKey) {
		this.puntajenomisForeignKey=puntajenomisForeignKey;
	}
}

