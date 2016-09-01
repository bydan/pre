/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
/*Empresa: com.bydan
 *Programador: ByDan
 *Descripcion: Clase que contiene todos los Accesos a BDD de tabla Usuario
 * Fecha Creacion: domingo, 26 de enero de 2014
 **CAMBIOS***** 
 * Motivo Cambio:
 * Nombre Programador:
 * Fecha Cambio:
 **************
 */
package com.bydan.erp.seguridad.business.entity;

import java.util.ArrayList;
import javax.persistence.MappedSuperclass;

import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.*;//GeneralEntity;

@SuppressWarnings("unused")
@MappedSuperclass
public class UsuarioAdditional extends GeneralEntity {
	//CONTROL_INICIO	
	public UsuarioAdditional() throws Exception {
		super();	
		try {
					
		} catch(Exception e) {
			throw e;
		}
	} 
	//CONTROL_FUNCION1
}
