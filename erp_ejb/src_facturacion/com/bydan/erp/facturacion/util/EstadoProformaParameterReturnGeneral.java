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
package com.bydan.erp.facturacion.util;

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
import com.bydan.erp.facturacion.util.EstadoProformaConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//EstadoProforma


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


@SuppressWarnings("unused")
public class EstadoProformaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EstadoProforma estadoproforma;	
	protected List<EstadoProforma> estadoproformas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<ColorGeneral> colorgeneralsForeignKey;
	
	public EstadoProformaParameterReturnGeneral () throws Exception {						
		super();
		this.estadoproformas= new ArrayList<EstadoProforma>();
		this.estadoproforma= new EstadoProforma();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.colorgeneralsForeignKey=new ArrayList<ColorGeneral>();
	} 
	
	public EstadoProforma getEstadoProforma() throws Exception {	
		return estadoproforma;
	}
		
	public void setEstadoProforma(EstadoProforma newEstadoProforma) {
		this.estadoproforma = newEstadoProforma;
	}
	
	public List<EstadoProforma> getEstadoProformas() throws Exception {		
		return estadoproformas;
	}
	
	public void setEstadoProformas(List<EstadoProforma> newEstadoProformas) {
		this.estadoproformas = newEstadoProformas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<ColorGeneral> getcolorgeneralsForeignKey() {
		return this.colorgeneralsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setcolorgeneralsForeignKey(List<ColorGeneral> colorgeneralsForeignKey) {
		this.colorgeneralsForeignKey=colorgeneralsForeignKey;
	}
}

