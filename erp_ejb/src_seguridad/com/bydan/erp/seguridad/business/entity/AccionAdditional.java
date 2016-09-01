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
 *Descripcion: Clase que contiene todos los Accesos a BDD de tabla Accion
 * Fecha Creacion: martes, 28 de mayo de 2013
 **CAMBIOS***** 
 * Motivo Cambio:
 * Nombre Programador:
 * Fecha Cambio:
 **************
 */
package com.bydan.erp.seguridad.business.entity;

import java.util.ArrayList;
import javax.persistence.MappedSuperclass;

import org.hibernate.validator.Digits;
import org.hibernate.validator.NotNull;

import com.bydan.framework.erp.business.entity.*;//GeneralEntity;
import com.bydan.framework.erp.util.Constantes;

@SuppressWarnings("unused")
@MappedSuperclass
public class AccionAdditional extends GeneralEntity {
	//CONTROL_INICIO	
	
	@NotNull(message=Constantes.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=Constantes.SVALIDACIONDECIMAL)
	private Double credito_mone_local;
	
	public AccionAdditional() throws Exception {
		super();	
		try {
			this.credito_mone_local=0.0;		
		} catch(Exception e) {
			throw e;
		}
	}
	
	public Double getcredito_mone_local() {
		return this.credito_mone_local;
	}
	
	public void setcredito_mone_local(Double newcredito_mone_local)throws Exception
	{
		try {
			if(!this.credito_mone_local.equals(newcredito_mone_local)) {
				if(newcredito_mone_local==null) {
					newcredito_mone_local=0.0;
					System.out.println("SaldosCuentasPorPagar:Valor nulo no permitido en columna credito_mone_local");
				}

				this.credito_mone_local=newcredito_mone_local;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	//CONTROL_FUNCION1
}
