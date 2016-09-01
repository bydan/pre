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
package com.bydan.erp.cartera.util;

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
import com.bydan.erp.cartera.util.TransporteConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//Transporte


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class TransporteParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Transporte transporte;	
	protected List<Transporte> transportes;
	
	
	public List<Empresa> empresasForeignKey;
	public List<TipoViaTransporte> tipoviatransportesForeignKey;
	
	public TransporteParameterReturnGeneral () throws Exception {						
		super();
		this.transportes= new ArrayList<Transporte>();
		this.transporte= new Transporte();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.tipoviatransportesForeignKey=new ArrayList<TipoViaTransporte>();
	} 
	
	public Transporte getTransporte() throws Exception {	
		return transporte;
	}
		
	public void setTransporte(Transporte newTransporte) {
		this.transporte = newTransporte;
	}
	
	public List<Transporte> getTransportes() throws Exception {		
		return transportes;
	}
	
	public void setTransportes(List<Transporte> newTransportes) {
		this.transportes = newTransportes;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<TipoViaTransporte> gettipoviatransportesForeignKey() {
		return this.tipoviatransportesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settipoviatransportesForeignKey(List<TipoViaTransporte> tipoviatransportesForeignKey) {
		this.tipoviatransportesForeignKey=tipoviatransportesForeignKey;
	}
}

