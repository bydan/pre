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
import com.bydan.erp.facturacion.util.DetalleTerminoProformaConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//DetalleTerminoProforma


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class DetalleTerminoProformaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleTerminoProforma detalleterminoproforma;	
	protected List<DetalleTerminoProforma> detalleterminoproformas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<TerminoProforma> terminoproformasForeignKey;
	
	public DetalleTerminoProformaParameterReturnGeneral () throws Exception {						
		super();
		this.detalleterminoproformas= new ArrayList<DetalleTerminoProforma>();
		this.detalleterminoproforma= new DetalleTerminoProforma();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.terminoproformasForeignKey=new ArrayList<TerminoProforma>();
	} 
	
	public DetalleTerminoProforma getDetalleTerminoProforma() throws Exception {	
		return detalleterminoproforma;
	}
		
	public void setDetalleTerminoProforma(DetalleTerminoProforma newDetalleTerminoProforma) {
		this.detalleterminoproforma = newDetalleTerminoProforma;
	}
	
	public List<DetalleTerminoProforma> getDetalleTerminoProformas() throws Exception {		
		return detalleterminoproformas;
	}
	
	public void setDetalleTerminoProformas(List<DetalleTerminoProforma> newDetalleTerminoProformas) {
		this.detalleterminoproformas = newDetalleTerminoProformas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<TerminoProforma> getterminoproformasForeignKey() {
		return this.terminoproformasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setterminoproformasForeignKey(List<TerminoProforma> terminoproformasForeignKey) {
		this.terminoproformasForeignKey=terminoproformasForeignKey;
	}
}

