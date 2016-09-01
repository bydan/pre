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
package com.bydan.erp.tesoreria.util.report;

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
import com.bydan.erp.tesoreria.util.report.PagosAutorizadosProcesoConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.report.*;//PagosAutorizadosProceso


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class PagosAutorizadosProcesoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PagosAutorizadosProceso pagosautorizadosproceso;	
	protected List<PagosAutorizadosProceso> pagosautorizadosprocesos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	
	public PagosAutorizadosProcesoParameterReturnGeneral () throws Exception {						
		super();
		this.pagosautorizadosprocesos= new ArrayList<PagosAutorizadosProceso>();
		this.pagosautorizadosproceso= new PagosAutorizadosProceso();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
	} 
	
	public PagosAutorizadosProceso getPagosAutorizadosProceso() throws Exception {	
		return pagosautorizadosproceso;
	}
		
	public void setPagosAutorizadosProceso(PagosAutorizadosProceso newPagosAutorizadosProceso) {
		this.pagosautorizadosproceso = newPagosAutorizadosProceso;
	}
	
	public List<PagosAutorizadosProceso> getPagosAutorizadosProcesos() throws Exception {		
		return pagosautorizadosprocesos;
	}
	
	public void setPagosAutorizadosProcesos(List<PagosAutorizadosProceso> newPagosAutorizadosProcesos) {
		this.pagosautorizadosprocesos = newPagosAutorizadosProcesos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}
}

