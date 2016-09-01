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
import com.bydan.erp.facturacion.util.ParametroFacturacionDefectoConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//ParametroFacturacionDefecto


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class ParametroFacturacionDefectoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroFacturacionDefecto parametrofacturaciondefecto;	
	protected List<ParametroFacturacionDefecto> parametrofacturaciondefectos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<TipoViaTransporte> tipoviatransportesForeignKey;
	
	public ParametroFacturacionDefectoParameterReturnGeneral () throws Exception {						
		super();
		this.parametrofacturaciondefectos= new ArrayList<ParametroFacturacionDefecto>();
		this.parametrofacturaciondefecto= new ParametroFacturacionDefecto();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.tipoviatransportesForeignKey=new ArrayList<TipoViaTransporte>();
	} 
	
	public ParametroFacturacionDefecto getParametroFacturacionDefecto() throws Exception {	
		return parametrofacturaciondefecto;
	}
		
	public void setParametroFacturacionDefecto(ParametroFacturacionDefecto newParametroFacturacionDefecto) {
		this.parametrofacturaciondefecto = newParametroFacturacionDefecto;
	}
	
	public List<ParametroFacturacionDefecto> getParametroFacturacionDefectos() throws Exception {		
		return parametrofacturaciondefectos;
	}
	
	public void setParametroFacturacionDefectos(List<ParametroFacturacionDefecto> newParametroFacturacionDefectos) {
		this.parametrofacturaciondefectos = newParametroFacturacionDefectos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<TipoViaTransporte> gettipoviatransportesForeignKey() {
		return this.tipoviatransportesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void settipoviatransportesForeignKey(List<TipoViaTransporte> tipoviatransportesForeignKey) {
		this.tipoviatransportesForeignKey=tipoviatransportesForeignKey;
	}
}

