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
package com.bydan.erp.contabilidad.util;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
//import java.util.ArrayList;
import com.bydan.framework.erp.business.logic.Pagination;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.util.Connexion;
import com.bydan.framework.erp.util.ConnexionType;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.Constantes2;
import com.bydan.framework.erp.util.Funciones;
import com.bydan.framework.erp.util.ParameterDbType;
import com.bydan.erp.contabilidad.resources.general.AuxiliarGeneral;
import com.bydan.erp.seguridad.business.entity.*;
//import com.bydan.erp.seguridad.business.interfaces.UsuarioAdditionable;
import com.bydan.framework.erp.business.logic.DatosCliente;
//import com.bydan.framework.erp.util.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import com.bydan.framework.erp.business.logic.*;
//import java.sql.SQLException;


@SuppressWarnings({"unused","resource"})
final public class ContabilidadSql {	
	public  ContabilidadSql()throws Exception {
		
    }		
	//DIARIO_GENERAL
	public static String GetSelecSqlDiarioGeneral(ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Long id_ejercicio,Long id_periodo,Long id_modulo,Long id_tipo_movimiento,Long id_tipo_documento,Date fecha_inicio,Date fecha_fin) throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;
		
		if(connexionType.equals(ConnexionType.HIBERNATE)) {
			
			
		} else if(connexionType.equals(ConnexionType.JDBC32)) {		
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {
				
			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("DiarioGeneral_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();
				
				
				
				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					sSqlWhere+=" a.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}
				
				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					sSqlWhere+=" and a.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				
				if(id_ejercicio!= null && id_ejercicio>0) {
					sSqlWhere+=" and a.id_ejercicio="+id_ejercicio;
					existeWhere=true;
				}
				
				if(id_periodo!= null && id_periodo>0) {
					sSqlWhere+=" and a.id_periodo="+id_periodo;
					existeWhere=true;
				}
				
				if(id_tipo_documento!= null && id_tipo_documento>0) {
					sSqlWhere+=" and a.id_tipo_documento="+id_tipo_documento;
					existeWhere=true;
				}
				
				if(id_tipo_movimiento!= null && id_tipo_movimiento>0) {
					sSqlWhere+=" and a.id_tipo_movimiento="+id_tipo_movimiento;
					existeWhere=true;
				}
				
				if(existeWhere) {
					sSqlWhere=" where "+sSqlWhere;
				}
				
				sSql=sSelectQuery+sSqlWhere;
		        
				System.out.println(sSql);
			         
				
			}
		}
		
		return sSql;
	}
	
	//MAYORIZAR
	public static String GetSqlConWhereAsientosContablesParaMayorizar(ConnexionType connexionType,ParameterDbType parameterDbType,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Date fecha_inicio,Date fecha_fin) throws Exception {
		String sSql="";
		
		if(connexionType.equals(ConnexionType.HIBERNATE)) {
			sSql="";//" select distinct modulo from "+ModuloConstantesFunciones.SPERSISTENCENAME+" modulo ";
			
		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {
				sSql="";//" select distinct * from "+ModuloConstantesFunciones.SCHEMA+"."+ModuloConstantesFunciones.TABLENAME+"";
				
			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				sSql="SELECT id, version_row, codigo, beneficiario,  fecha,  valor";
				sSql+=" FROM contabilidad.asiento_contable where id_empresa="+parametroGeneralUsuario.getid_empresa();
				sSql+=" and id_sucursal="+parametroGeneralUsuario.getid_sucursal();
				sSql+=" and id_ejercicio="+parametroGeneralUsuario.getid_ejercicio();
			}
		}
		
		return sSql;
	}
	
	//EJEMPLO
	/*
	public static String GetWhereModulos(ConnexionType connexionType,ParameterDbType parameterDbType) throws Exception {
		String sSql="";
		
		if(connexionType.equals(ConnexionType.HIBERNATE)) {
			sSql=" select distinct modulo from "+ModuloConstantesFunciones.SPERSISTENCENAME+" modulo ";
			
		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {
				sSql=" select distinct * from "+ModuloConstantesFunciones.SCHEMA+"."+ModuloConstantesFunciones.TABLENAME+"";
				
			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				sSql=" select distinct * from "+ModuloConstantesFunciones.SCHEMA+"."+ModuloConstantesFunciones.TABLENAME+"";
			}
		}
		
		return sSql;
	}
	*/
}

