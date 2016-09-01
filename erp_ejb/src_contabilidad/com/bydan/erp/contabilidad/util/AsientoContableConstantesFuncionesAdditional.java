
/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.contabilidad.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.Date;

import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityConstantesFunciones;



@SuppressWarnings("unused")
public class AsientoContableConstantesFuncionesAdditional extends GeneralEntityConstantesFunciones {		
	public AsientoContableConstantesFuncionesAdditional () {
		
    } 
	
	//LID_ESTADO_ANULADO,LID_ESTADO_MAYORIZADO
	
	public static Long LID_ESTADO_INGRESADO=1L;
	public static Long LID_ESTADO_MAYORIZADO=2L;
	public static Long LID_ESTADO_DESMAYORIZADO=3L;
	public static Long LID_ESTADO_ANULADO=0L;
			
}