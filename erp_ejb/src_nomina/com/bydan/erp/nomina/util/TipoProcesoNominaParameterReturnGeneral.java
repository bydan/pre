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
package com.bydan.erp.nomina.util;

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
import com.bydan.erp.nomina.util.TipoProcesoNominaConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//TipoProcesoNomina




@SuppressWarnings("unused")
public class TipoProcesoNominaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoProcesoNomina tipoprocesonomina;	
	protected List<TipoProcesoNomina> tipoprocesonominas;
	
	
	
	public TipoProcesoNominaParameterReturnGeneral () throws Exception {						
		super();
		this.tipoprocesonominas= new ArrayList<TipoProcesoNomina>();
		this.tipoprocesonomina= new TipoProcesoNomina();
		
		
	} 
	
	public TipoProcesoNomina getTipoProcesoNomina() throws Exception {	
		return tipoprocesonomina;
	}
		
	public void setTipoProcesoNomina(TipoProcesoNomina newTipoProcesoNomina) {
		this.tipoprocesonomina = newTipoProcesoNomina;
	}
	
	public List<TipoProcesoNomina> getTipoProcesoNominas() throws Exception {		
		return tipoprocesonominas;
	}
	
	public void setTipoProcesoNominas(List<TipoProcesoNomina> newTipoProcesoNominas) {
		this.tipoprocesonominas = newTipoProcesoNominas;
	}
	
	
	
	
}

