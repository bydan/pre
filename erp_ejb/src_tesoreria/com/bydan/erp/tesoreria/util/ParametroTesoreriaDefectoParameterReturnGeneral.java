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
package com.bydan.erp.tesoreria.util;

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
import com.bydan.erp.tesoreria.util.ParametroTesoreriaDefectoConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.*;//ParametroTesoreriaDefecto


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ParametroTesoreriaDefectoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroTesoreriaDefecto parametrotesoreriadefecto;	
	protected List<ParametroTesoreriaDefecto> parametrotesoreriadefectos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey;
	
	public ParametroTesoreriaDefectoParameterReturnGeneral () throws Exception {						
		super();
		this.parametrotesoreriadefectos= new ArrayList<ParametroTesoreriaDefecto>();
		this.parametrotesoreriadefecto= new ParametroTesoreriaDefecto();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.tipocuentabancoglobalsForeignKey=new ArrayList<TipoCuentaBancoGlobal>();
	} 
	
	public ParametroTesoreriaDefecto getParametroTesoreriaDefecto() throws Exception {	
		return parametrotesoreriadefecto;
	}
		
	public void setParametroTesoreriaDefecto(ParametroTesoreriaDefecto newParametroTesoreriaDefecto) {
		this.parametrotesoreriadefecto = newParametroTesoreriaDefecto;
	}
	
	public List<ParametroTesoreriaDefecto> getParametroTesoreriaDefectos() throws Exception {		
		return parametrotesoreriadefectos;
	}
	
	public void setParametroTesoreriaDefectos(List<ParametroTesoreriaDefecto> newParametroTesoreriaDefectos) {
		this.parametrotesoreriadefectos = newParametroTesoreriaDefectos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<TipoCuentaBancoGlobal> gettipocuentabancoglobalsForeignKey() {
		return this.tipocuentabancoglobalsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void settipocuentabancoglobalsForeignKey(List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey) {
		this.tipocuentabancoglobalsForeignKey=tipocuentabancoglobalsForeignKey;
	}
}

