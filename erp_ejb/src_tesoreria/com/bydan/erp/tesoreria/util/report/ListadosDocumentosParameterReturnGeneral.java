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
import com.bydan.erp.tesoreria.util.report.ListadosDocumentosConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.report.*;//ListadosDocumentos


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class ListadosDocumentosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ListadosDocumentos listadosdocumentos;	
	protected List<ListadosDocumentos> listadosdocumentoss;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<TipoMovimiento> tipomovimientosForeignKey;
	
	public ListadosDocumentosParameterReturnGeneral () throws Exception {						
		super();
		this.listadosdocumentoss= new ArrayList<ListadosDocumentos>();
		this.listadosdocumentos= new ListadosDocumentos();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
	} 
	
	public ListadosDocumentos getListadosDocumentos() throws Exception {	
		return listadosdocumentos;
	}
		
	public void setListadosDocumentos(ListadosDocumentos newListadosDocumentos) {
		this.listadosdocumentos = newListadosDocumentos;
	}
	
	public List<ListadosDocumentos> getListadosDocumentoss() throws Exception {		
		return listadosdocumentoss;
	}
	
	public void setListadosDocumentoss(List<ListadosDocumentos> newListadosDocumentoss) {
		this.listadosdocumentoss = newListadosDocumentoss;
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

	public List<TipoMovimiento> gettipomovimientosForeignKey() {
		return this.tipomovimientosForeignKey;
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

	public void settipomovimientosForeignKey(List<TipoMovimiento> tipomovimientosForeignKey) {
		this.tipomovimientosForeignKey=tipomovimientosForeignKey;
	}
}

