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
package com.bydan.erp.contabilidad.util.report;

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
import com.bydan.erp.contabilidad.util.report.ProcesoAsientoInicialEjercicioConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.report.*;//ProcesoAsientoInicialEjercicio


import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class ProcesoAsientoInicialEjercicioParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio;	
	protected List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejercicios;
	
	
	public List<TipoDocumento> tipodocumentosForeignKey;
	
	public ProcesoAsientoInicialEjercicioParameterReturnGeneral () throws Exception {						
		super();
		this.procesoasientoinicialejercicios= new ArrayList<ProcesoAsientoInicialEjercicio>();
		this.procesoasientoinicialejercicio= new ProcesoAsientoInicialEjercicio();
		
		
		this.tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
	} 
	
	public ProcesoAsientoInicialEjercicio getProcesoAsientoInicialEjercicio() throws Exception {	
		return procesoasientoinicialejercicio;
	}
		
	public void setProcesoAsientoInicialEjercicio(ProcesoAsientoInicialEjercicio newProcesoAsientoInicialEjercicio) {
		this.procesoasientoinicialejercicio = newProcesoAsientoInicialEjercicio;
	}
	
	public List<ProcesoAsientoInicialEjercicio> getProcesoAsientoInicialEjercicios() throws Exception {		
		return procesoasientoinicialejercicios;
	}
	
	public void setProcesoAsientoInicialEjercicios(List<ProcesoAsientoInicialEjercicio> newProcesoAsientoInicialEjercicios) {
		this.procesoasientoinicialejercicios = newProcesoAsientoInicialEjercicios;
	}
	
	

	public List<TipoDocumento> gettipodocumentosForeignKey() {
		return this.tipodocumentosForeignKey;
	}
	
	

	public void settipodocumentosForeignKey(List<TipoDocumento> tipodocumentosForeignKey) {
		this.tipodocumentosForeignKey=tipodocumentosForeignKey;
	}
}
