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
import com.bydan.erp.seguridad.business.entity.ParametroGeneralSg;
import com.bydan.erp.seguridad.business.entity.ParametroGeneralUsuario;
import com.bydan.erp.seguridad.business.entity.ResumenUsuario;
import com.bydan.erp.seguridad.business.entity.Usuario;


import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;


@SuppressWarnings("unused")
public class ResumenUsuarioReturnGeneralAdditional  extends GeneralEntityParameterReturnGeneral implements Serializable{		
	private static final long serialVersionUID = 1L;
	
	public ResumenUsuarioReturnGeneralAdditional ()  throws Exception {
		this.parametroGeneralUsuario=new ParametroGeneralUsuario();
		this.parametroGeneralSg=new ParametroGeneralSg();
		this.usuarioActual=new Usuario();
    } 
	
	private ParametroGeneralUsuario parametroGeneralUsuario;
	private ParametroGeneralSg parametroGeneralSg;
	private Usuario usuarioActual;
	
	public ParametroGeneralUsuario getParametroGeneralUsuario() {
		return parametroGeneralUsuario;
	}

	public void setParametroGeneralUsuario(
			ParametroGeneralUsuario parametroGeneralUsuario) {
		this.parametroGeneralUsuario = parametroGeneralUsuario;
	}

	public ParametroGeneralSg getParametroGeneralSg() {
		return parametroGeneralSg;
	}

	public void setParametroGeneralSg(ParametroGeneralSg parametroGeneralSg) {
		this.parametroGeneralSg = parametroGeneralSg;
	}

	public Usuario getUsuarioActual() {
		return usuarioActual;
	}

	public void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	
	
	
}
