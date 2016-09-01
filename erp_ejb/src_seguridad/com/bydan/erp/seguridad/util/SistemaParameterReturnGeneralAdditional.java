/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.seguridad.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.Date;

import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityConstantesFunciones;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterReturnGeneral;
import com.bydan.erp.seguridad.business.entity.Accion;
import com.bydan.erp.seguridad.business.entity.GrupoOpcion;
import com.bydan.erp.seguridad.business.entity.Opcion;
import com.bydan.erp.seguridad.business.entity.PerfilOpcion;
import com.bydan.erp.seguridad.business.entity.Sistema;


import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;


@SuppressWarnings("unused")
public class SistemaParameterReturnGeneralAdditional  extends GeneralEntityParameterReturnGeneral implements Serializable{		
	private static final long serialVersionUID = 1L;
	
	public SistemaParameterReturnGeneralAdditional ()  throws Exception {
		this.opcions=new ArrayList<Opcion>();
		this.grupoopcions=new ArrayList<GrupoOpcion>();	
		
		//PARA CARGAR VENTANAS
		this.perfilOpcion=new PerfilOpcion();
		this.accions=new ArrayList<Accion>();
		this.accionsFormulario=new ArrayList<Accion>();
		this.opcionsRelacionadas=new ArrayList<Opcion>();
    } 
	
	//PARA LOGIN
	public List<GrupoOpcion> grupoopcions;
	public List<Opcion> opcions;

	//PARA CARGAR VENTANAS	
	public PerfilOpcion perfilOpcion;
	public List<Accion> accions;
	public List<Accion> accionsFormulario;
	public List<Opcion> opcionsRelacionadas;
	
	
	public static void inicializarSinSeguridad(SistemaParameterReturnGeneral sistemaReturnGeneral) {
		sistemaReturnGeneral.setEsValidado(true);
	}
	
	public List<Opcion> getOpcions() {
		return opcions;
	}

	public void setOpcions(List<Opcion> opcions) {
		this.opcions = opcions;
	}

	public List<GrupoOpcion> getGrupoopcions() {
		return grupoopcions;
	}

	public void setGrupoopcions(List<GrupoOpcion> grupoopcions) {
		this.grupoopcions = grupoopcions;
	}
	
	public PerfilOpcion getPerfilOpcion() {
		return perfilOpcion;
	}

	public void setPerfilOpcion(PerfilOpcion perfilOpcion) {
		this.perfilOpcion = perfilOpcion;
	}

	public List<Accion> getAccions() {
		return accions;
	}

	public void setAccions(List<Accion> accions) {
		this.accions = accions;
	}

	public List<Accion> getAccionsFormulario() {
		return accionsFormulario;
	}

	public void setAccionsFormulario(List<Accion> accionsFormulario) {
		this.accionsFormulario = accionsFormulario;
	}				

	public List<Opcion> getOpcionsRelacionadas() {
		return opcionsRelacionadas;
	}

	public void setOpcionsRelacionadas(List<Opcion> opcionsRelacionadas) {
		this.opcionsRelacionadas = opcionsRelacionadas;
	}
}
