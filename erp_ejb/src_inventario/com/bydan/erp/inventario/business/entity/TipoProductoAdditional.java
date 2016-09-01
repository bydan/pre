/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
/*Empresa: com.bydan
 *Programador: ByDan
 *Descripcion: Clase que contiene todos los Accesos a BDD de tabla TipoProducto
 * Fecha Creacion: jueves, 24 de octubre de 2013
 **CAMBIOS***** 
 * Motivo Cambio:
 * Nombre Programador:
 * Fecha Cambio:
 **************
 */
package com.bydan.erp.inventario.business.entity;

import java.util.ArrayList;
import javax.persistence.MappedSuperclass;

import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.*;//GeneralEntity;

@SuppressWarnings("unused")
@MappedSuperclass
public class TipoProductoAdditional extends GeneralEntity {
	//CONTROL_INICIO	
	public TipoProductoAdditional() throws Exception {
		super();	
		try {
					
		} catch(Exception e) {
			throw e;
		}
	} 
	//CONTROL_FUNCION1
}
