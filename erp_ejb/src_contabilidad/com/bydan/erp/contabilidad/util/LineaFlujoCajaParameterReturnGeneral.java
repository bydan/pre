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
package com.bydan.erp.contabilidad.util;

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
import com.bydan.erp.contabilidad.util.LineaFlujoCajaConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//LineaFlujoCaja


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class LineaFlujoCajaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected LineaFlujoCaja lineaflujocaja;	
	protected List<LineaFlujoCaja> lineaflujocajas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<TipoGrupoFlujoCaja> tipogrupoflujocajasForeignKey;
	public List<TipoLineaFlujoCaja> tipolineaflujocajasForeignKey;
	
	public LineaFlujoCajaParameterReturnGeneral () throws Exception {						
		super();
		this.lineaflujocajas= new ArrayList<LineaFlujoCaja>();
		this.lineaflujocaja= new LineaFlujoCaja();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.tipogrupoflujocajasForeignKey=new ArrayList<TipoGrupoFlujoCaja>();
		this.tipolineaflujocajasForeignKey=new ArrayList<TipoLineaFlujoCaja>();
	} 
	
	public LineaFlujoCaja getLineaFlujoCaja() throws Exception {	
		return lineaflujocaja;
	}
		
	public void setLineaFlujoCaja(LineaFlujoCaja newLineaFlujoCaja) {
		this.lineaflujocaja = newLineaFlujoCaja;
	}
	
	public List<LineaFlujoCaja> getLineaFlujoCajas() throws Exception {		
		return lineaflujocajas;
	}
	
	public void setLineaFlujoCajas(List<LineaFlujoCaja> newLineaFlujoCajas) {
		this.lineaflujocajas = newLineaFlujoCajas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<TipoGrupoFlujoCaja> gettipogrupoflujocajasForeignKey() {
		return this.tipogrupoflujocajasForeignKey;
	}

	public List<TipoLineaFlujoCaja> gettipolineaflujocajasForeignKey() {
		return this.tipolineaflujocajasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settipogrupoflujocajasForeignKey(List<TipoGrupoFlujoCaja> tipogrupoflujocajasForeignKey) {
		this.tipogrupoflujocajasForeignKey=tipogrupoflujocajasForeignKey;
	}

	public void settipolineaflujocajasForeignKey(List<TipoLineaFlujoCaja> tipolineaflujocajasForeignKey) {
		this.tipolineaflujocajasForeignKey=tipolineaflujocajasForeignKey;
	}
}

