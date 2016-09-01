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
package com.bydan.erp.nomina.util.report;

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
import com.bydan.erp.nomina.util.report.ListadosFormasPagosConstantesFunciones;

import com.bydan.erp.nomina.business.entity.report.*;//ListadosFormasPagos


import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ListadosFormasPagosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ListadosFormasPagos listadosformaspagos;	
	protected List<ListadosFormasPagos> listadosformaspagoss;
	
	
	public List<TipoGrupoFormaPago> tipogrupoformapagosForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	
	public ListadosFormasPagosParameterReturnGeneral () throws Exception {						
		super();
		this.listadosformaspagoss= new ArrayList<ListadosFormasPagos>();
		this.listadosformaspagos= new ListadosFormasPagos();
		
		
		this.tipogrupoformapagosForeignKey=new ArrayList<TipoGrupoFormaPago>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
	} 
	
	public ListadosFormasPagos getListadosFormasPagos() throws Exception {	
		return listadosformaspagos;
	}
		
	public void setListadosFormasPagos(ListadosFormasPagos newListadosFormasPagos) {
		this.listadosformaspagos = newListadosFormasPagos;
	}
	
	public List<ListadosFormasPagos> getListadosFormasPagoss() throws Exception {		
		return listadosformaspagoss;
	}
	
	public void setListadosFormasPagoss(List<ListadosFormasPagos> newListadosFormasPagoss) {
		this.listadosformaspagoss = newListadosFormasPagoss;
	}
	
	

	public List<TipoGrupoFormaPago> gettipogrupoformapagosForeignKey() {
		return this.tipogrupoformapagosForeignKey;
	}

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}
	
	

	public void settipogrupoformapagosForeignKey(List<TipoGrupoFormaPago> tipogrupoformapagosForeignKey) {
		this.tipogrupoformapagosForeignKey=tipogrupoformapagosForeignKey;
	}

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}
}

