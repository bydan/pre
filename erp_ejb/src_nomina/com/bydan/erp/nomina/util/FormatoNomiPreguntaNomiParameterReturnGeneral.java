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
import com.bydan.erp.nomina.util.FormatoNomiPreguntaNomiConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//FormatoNomiPreguntaNomi


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class FormatoNomiPreguntaNomiParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected FormatoNomiPreguntaNomi formatonomipreguntanomi;	
	protected List<FormatoNomiPreguntaNomi> formatonomipreguntanomis;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<FormatoNomi> formatonomisForeignKey;
	public List<FactorNomi> factornomisForeignKey;
	public List<PreguntaNomi> preguntanomisForeignKey;
	
	public FormatoNomiPreguntaNomiParameterReturnGeneral () throws Exception {						
		super();
		this.formatonomipreguntanomis= new ArrayList<FormatoNomiPreguntaNomi>();
		this.formatonomipreguntanomi= new FormatoNomiPreguntaNomi();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.formatonomisForeignKey=new ArrayList<FormatoNomi>();
		this.factornomisForeignKey=new ArrayList<FactorNomi>();
		this.preguntanomisForeignKey=new ArrayList<PreguntaNomi>();
	} 
	
	public FormatoNomiPreguntaNomi getFormatoNomiPreguntaNomi() throws Exception {	
		return formatonomipreguntanomi;
	}
		
	public void setFormatoNomiPreguntaNomi(FormatoNomiPreguntaNomi newFormatoNomiPreguntaNomi) {
		this.formatonomipreguntanomi = newFormatoNomiPreguntaNomi;
	}
	
	public List<FormatoNomiPreguntaNomi> getFormatoNomiPreguntaNomis() throws Exception {		
		return formatonomipreguntanomis;
	}
	
	public void setFormatoNomiPreguntaNomis(List<FormatoNomiPreguntaNomi> newFormatoNomiPreguntaNomis) {
		this.formatonomipreguntanomis = newFormatoNomiPreguntaNomis;
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

	public List<PreguntaNomi> getpreguntanomisForeignKey() {
		return this.preguntanomisForeignKey;
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

	public void setpreguntanomisForeignKey(List<PreguntaNomi> preguntanomisForeignKey) {
		this.preguntanomisForeignKey=preguntanomisForeignKey;
	}
}

