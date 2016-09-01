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
package com.bydan.erp.inventario.util;

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
import com.bydan.erp.inventario.util.CabeceraSerieConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//CabeceraSerie


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class CabeceraSerieParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CabeceraSerie cabeceraserie;	
	protected List<CabeceraSerie> cabeceraseries;
	
	
	public List<Empresa> empresasForeignKey;
	
	public CabeceraSerieParameterReturnGeneral () throws Exception {						
		super();
		this.cabeceraseries= new ArrayList<CabeceraSerie>();
		this.cabeceraserie= new CabeceraSerie();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public CabeceraSerie getCabeceraSerie() throws Exception {	
		return cabeceraserie;
	}
		
	public void setCabeceraSerie(CabeceraSerie newCabeceraSerie) {
		this.cabeceraserie = newCabeceraSerie;
	}
	
	public List<CabeceraSerie> getCabeceraSeries() throws Exception {		
		return cabeceraseries;
	}
	
	public void setCabeceraSeries(List<CabeceraSerie> newCabeceraSeries) {
		this.cabeceraseries = newCabeceraSeries;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

