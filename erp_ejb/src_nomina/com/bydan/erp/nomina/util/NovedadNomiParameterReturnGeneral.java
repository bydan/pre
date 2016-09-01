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
import com.bydan.erp.nomina.util.NovedadNomiConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//NovedadNomi


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class NovedadNomiParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected NovedadNomi novedadnomi;	
	protected List<NovedadNomi> novedadnomis;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Empleado> empleadoautorizasForeignKey;
	public List<TipoNovedadNomi> tiponovedadnomisForeignKey;
	public List<EstadoNovedadNomi> estadonovedadnomisForeignKey;
	
	public NovedadNomiParameterReturnGeneral () throws Exception {						
		super();
		this.novedadnomis= new ArrayList<NovedadNomi>();
		this.novedadnomi= new NovedadNomi();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.empleadoautorizasForeignKey=new ArrayList<Empleado>();
		this.tiponovedadnomisForeignKey=new ArrayList<TipoNovedadNomi>();
		this.estadonovedadnomisForeignKey=new ArrayList<EstadoNovedadNomi>();
	} 
	
	public NovedadNomi getNovedadNomi() throws Exception {	
		return novedadnomi;
	}
		
	public void setNovedadNomi(NovedadNomi newNovedadNomi) {
		this.novedadnomi = newNovedadNomi;
	}
	
	public List<NovedadNomi> getNovedadNomis() throws Exception {		
		return novedadnomis;
	}
	
	public void setNovedadNomis(List<NovedadNomi> newNovedadNomis) {
		this.novedadnomis = newNovedadNomis;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Empleado> getempleadoautorizasForeignKey() {
		return this.empleadoautorizasForeignKey;
	}

	public List<TipoNovedadNomi> gettiponovedadnomisForeignKey() {
		return this.tiponovedadnomisForeignKey;
	}

	public List<EstadoNovedadNomi> getestadonovedadnomisForeignKey() {
		return this.estadonovedadnomisForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setempleadoautorizasForeignKey(List<Empleado> empleadoautorizasForeignKey) {
		this.empleadoautorizasForeignKey=empleadoautorizasForeignKey;
	}

	public void settiponovedadnomisForeignKey(List<TipoNovedadNomi> tiponovedadnomisForeignKey) {
		this.tiponovedadnomisForeignKey=tiponovedadnomisForeignKey;
	}

	public void setestadonovedadnomisForeignKey(List<EstadoNovedadNomi> estadonovedadnomisForeignKey) {
		this.estadonovedadnomisForeignKey=estadonovedadnomisForeignKey;
	}
}

