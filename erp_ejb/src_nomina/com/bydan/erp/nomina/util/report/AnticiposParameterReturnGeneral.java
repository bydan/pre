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
import com.bydan.erp.nomina.util.report.AnticiposConstantesFunciones;

import com.bydan.erp.nomina.business.entity.report.*;//Anticipos


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class AnticiposParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Anticipos anticipos;	
	protected List<Anticipos> anticiposs;
	
	
	public List<Empresa> empresasForeignKey;
	public List<TipoContrato> tipocontratosForeignKey;
	
	public AnticiposParameterReturnGeneral () throws Exception {						
		super();
		this.anticiposs= new ArrayList<Anticipos>();
		this.anticipos= new Anticipos();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.tipocontratosForeignKey=new ArrayList<TipoContrato>();
	} 
	
	public Anticipos getAnticipos() throws Exception {	
		return anticipos;
	}
		
	public void setAnticipos(Anticipos newAnticipos) {
		this.anticipos = newAnticipos;
	}
	
	public List<Anticipos> getAnticiposs() throws Exception {		
		return anticiposs;
	}
	
	public void setAnticiposs(List<Anticipos> newAnticiposs) {
		this.anticiposs = newAnticiposs;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<TipoContrato> gettipocontratosForeignKey() {
		return this.tipocontratosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settipocontratosForeignKey(List<TipoContrato> tipocontratosForeignKey) {
		this.tipocontratosForeignKey=tipocontratosForeignKey;
	}
}

