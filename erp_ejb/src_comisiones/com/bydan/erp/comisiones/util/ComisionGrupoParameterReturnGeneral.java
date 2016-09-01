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
package com.bydan.erp.comisiones.util;

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
import com.bydan.erp.comisiones.util.ComisionGrupoConstantesFunciones;

import com.bydan.erp.comisiones.business.entity.*;//ComisionGrupo


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class ComisionGrupoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ComisionGrupo comisiongrupo;	
	protected List<ComisionGrupo> comisiongrupos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<ComisionConfig> comisionconfigsForeignKey;
	public List<Vendedor> vendedorsForeignKey;
	public List<Linea> lineasForeignKey;
	public List<Linea> lineagruposForeignKey;
	public List<EstadoComision> estadocomisionsForeignKey;
	
	public ComisionGrupoParameterReturnGeneral () throws Exception {						
		super();
		this.comisiongrupos= new ArrayList<ComisionGrupo>();
		this.comisiongrupo= new ComisionGrupo();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.comisionconfigsForeignKey=new ArrayList<ComisionConfig>();
		this.vendedorsForeignKey=new ArrayList<Vendedor>();
		this.lineasForeignKey=new ArrayList<Linea>();
		this.lineagruposForeignKey=new ArrayList<Linea>();
		this.estadocomisionsForeignKey=new ArrayList<EstadoComision>();
	} 
	
	public ComisionGrupo getComisionGrupo() throws Exception {	
		return comisiongrupo;
	}
		
	public void setComisionGrupo(ComisionGrupo newComisionGrupo) {
		this.comisiongrupo = newComisionGrupo;
	}
	
	public List<ComisionGrupo> getComisionGrupos() throws Exception {		
		return comisiongrupos;
	}
	
	public void setComisionGrupos(List<ComisionGrupo> newComisionGrupos) {
		this.comisiongrupos = newComisionGrupos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<ComisionConfig> getcomisionconfigsForeignKey() {
		return this.comisionconfigsForeignKey;
	}

	public List<Vendedor> getvendedorsForeignKey() {
		return this.vendedorsForeignKey;
	}

	public List<Linea> getlineasForeignKey() {
		return this.lineasForeignKey;
	}

	public List<Linea> getlineagruposForeignKey() {
		return this.lineagruposForeignKey;
	}

	public List<EstadoComision> getestadocomisionsForeignKey() {
		return this.estadocomisionsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setcomisionconfigsForeignKey(List<ComisionConfig> comisionconfigsForeignKey) {
		this.comisionconfigsForeignKey=comisionconfigsForeignKey;
	}

	public void setvendedorsForeignKey(List<Vendedor> vendedorsForeignKey) {
		this.vendedorsForeignKey=vendedorsForeignKey;
	}

	public void setlineasForeignKey(List<Linea> lineasForeignKey) {
		this.lineasForeignKey=lineasForeignKey;
	}

	public void setlineagruposForeignKey(List<Linea> lineagruposForeignKey) {
		this.lineagruposForeignKey=lineagruposForeignKey;
	}

	public void setestadocomisionsForeignKey(List<EstadoComision> estadocomisionsForeignKey) {
		this.estadocomisionsForeignKey=estadocomisionsForeignKey;
	}
}

