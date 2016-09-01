
/*
* ============================================================================
* GNU Lesser General Public License
* ============================================================================
*
* BYDAN - Free Java BYDAN library.
* Copyright (C) 2008 
* 
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 2.1 of the License, or (at your option) any later version.
* 
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
* Lesser General Public License for more details.
* 
* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
* 
* BYDAN Corporation
*/
/*Empresa: com.bydan
 *Programador: ByDan
 *Descripcion: Clase que contiene todos los Accesos a BDD de tabla ProductoEspeci
 * Fecha Creacion: martes, 28 de mayo de 2013
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

@MappedSuperclass
@SuppressWarnings("unused")
public class ProductoEspeciAdditional extends GeneralEntity {
	//CONTROL_INICIO	
	public ProductoEspeciAdditional() throws Exception {
		super();	
		try {
					
		} catch(Exception e) {
			throw e;
		}
	} 
	//CONTROL_FUNCION1
}