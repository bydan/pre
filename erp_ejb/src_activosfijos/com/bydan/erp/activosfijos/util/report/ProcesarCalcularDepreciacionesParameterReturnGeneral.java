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
package com.bydan.erp.activosfijos.util.report;

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
import com.bydan.erp.activosfijos.util.report.ProcesarCalcularDepreciacionesConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.report.*;//ProcesarCalcularDepreciaciones


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


@SuppressWarnings("unused")
public class ProcesarCalcularDepreciacionesParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProcesarCalcularDepreciaciones procesarcalculardepreciaciones;	
	protected List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness;
	
	
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	public List<DetalleGrupoActivoFijo> detallegrupoactivofijosForeignKey;
	public List<SubGrupoActivoFijo> subgrupoactivofijosForeignKey;
	
	public ProcesarCalcularDepreciacionesParameterReturnGeneral () throws Exception {						
		super();
		this.procesarcalculardepreciacioness= new ArrayList<ProcesarCalcularDepreciaciones>();
		this.procesarcalculardepreciaciones= new ProcesarCalcularDepreciaciones();
		
		
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
		this.detallegrupoactivofijosForeignKey=new ArrayList<DetalleGrupoActivoFijo>();
		this.subgrupoactivofijosForeignKey=new ArrayList<SubGrupoActivoFijo>();
	} 
	
	public ProcesarCalcularDepreciaciones getProcesarCalcularDepreciaciones() throws Exception {	
		return procesarcalculardepreciaciones;
	}
		
	public void setProcesarCalcularDepreciaciones(ProcesarCalcularDepreciaciones newProcesarCalcularDepreciaciones) {
		this.procesarcalculardepreciaciones = newProcesarCalcularDepreciaciones;
	}
	
	public List<ProcesarCalcularDepreciaciones> getProcesarCalcularDepreciacioness() throws Exception {		
		return procesarcalculardepreciacioness;
	}
	
	public void setProcesarCalcularDepreciacioness(List<ProcesarCalcularDepreciaciones> newProcesarCalcularDepreciacioness) {
		this.procesarcalculardepreciacioness = newProcesarCalcularDepreciacioness;
	}
	
	

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}

	public List<DetalleGrupoActivoFijo> getdetallegrupoactivofijosForeignKey() {
		return this.detallegrupoactivofijosForeignKey;
	}

	public List<SubGrupoActivoFijo> getsubgrupoactivofijosForeignKey() {
		return this.subgrupoactivofijosForeignKey;
	}
	
	

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}

	public void setdetallegrupoactivofijosForeignKey(List<DetalleGrupoActivoFijo> detallegrupoactivofijosForeignKey) {
		this.detallegrupoactivofijosForeignKey=detallegrupoactivofijosForeignKey;
	}

	public void setsubgrupoactivofijosForeignKey(List<SubGrupoActivoFijo> subgrupoactivofijosForeignKey) {
		this.subgrupoactivofijosForeignKey=subgrupoactivofijosForeignKey;
	}
}

