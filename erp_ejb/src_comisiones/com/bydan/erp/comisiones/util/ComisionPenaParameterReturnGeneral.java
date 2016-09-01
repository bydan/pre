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
import com.bydan.erp.comisiones.util.ComisionPenaConstantesFunciones;

import com.bydan.erp.comisiones.business.entity.*;//ComisionPena


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ComisionPenaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ComisionPena comisionpena;	
	protected List<ComisionPena> comisionpenas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<ComisionConfig> comisionconfigsForeignKey;
	
	public ComisionPenaParameterReturnGeneral () throws Exception {						
		super();
		this.comisionpenas= new ArrayList<ComisionPena>();
		this.comisionpena= new ComisionPena();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.comisionconfigsForeignKey=new ArrayList<ComisionConfig>();
	} 
	
	public ComisionPena getComisionPena() throws Exception {	
		return comisionpena;
	}
		
	public void setComisionPena(ComisionPena newComisionPena) {
		this.comisionpena = newComisionPena;
	}
	
	public List<ComisionPena> getComisionPenas() throws Exception {		
		return comisionpenas;
	}
	
	public void setComisionPenas(List<ComisionPena> newComisionPenas) {
		this.comisionpenas = newComisionPenas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<ComisionConfig> getcomisionconfigsForeignKey() {
		return this.comisionconfigsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setcomisionconfigsForeignKey(List<ComisionConfig> comisionconfigsForeignKey) {
		this.comisionconfigsForeignKey=comisionconfigsForeignKey;
	}
}

