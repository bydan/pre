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
package com.bydan.erp.seguridad.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
//import java.util.ArrayList;
import com.bydan.framework.erp.business.logic.Pagination;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.util.Connexion;
import com.bydan.framework.erp.util.ConnexionType;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.Funciones;
import com.bydan.framework.erp.util.ParameterDbType;
import com.bydan.erp.seguridad.business.entity.*;
//import com.bydan.erp.seguridad.business.interfaces.UsuarioAdditionable;
import com.bydan.framework.erp.business.logic.DatosCliente;
//import com.bydan.framework.erp.util.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import com.bydan.framework.erp.business.logic.*;
//import java.sql.SQLException;

@SuppressWarnings("unused")
final public class SistemaSql {		
	public  SistemaSql()throws Exception {
		
    }		
	
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
	
	public static String GetWhereGrupoOpcionUsuario(ConnexionType connexionType,ParameterDbType parameterDbType,Long lIdModulo) throws Exception {
		String sSql="";
		
		if(connexionType.equals(ConnexionType.HIBERNATE)) {
			sSql=" select distinct grupo_opcion from "+GrupoOpcionConstantesFunciones.SPERSISTENCENAME+" grupo_opcion ";
			sSql+=" where estado=true and id_modulo = "+lIdModulo;
			sSql+=" order by orden asc ";
			
		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {
				sSql=" select distinct * from "+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+"";
				sSql+=" where estado=true and id_modulo = "+lIdModulo;
				sSql+=" order by orden asc ";
				
			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				sSql=" select distinct * from "+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+"";
				sSql+=" where estado=true and id_modulo = "+lIdModulo;
				sSql+=" order by orden asc ";
			}
		}
		
		return sSql;
	}	
	
	public static String GetSelectOpcionesUsuario(ConnexionType connexionType,ParameterDbType parameterDbType) throws Exception {
		String sSql="";
		
		if(connexionType.equals(ConnexionType.HIBERNATE)) {
			sSql=" select distinct opcion from "+OpcionConstantesFunciones.SPERSISTENCENAME+" opcion ";
			
		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {
				sSql=" select distinct * from "+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+"";
				
			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				sSql=" select distinct * from "+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+"";
			}
		}
		
		return sSql;
	}	
	
	public static String GetFinalOpcionesUsuario(ConnexionType connexionType,ParameterDbType parameterDbType,Long lIdSistema,String sPerfiles,Boolean paraPrecargar,Boolean paraPrecargarPorUsuario,Usuario usuario) throws Exception {
		String sSql="";
		String sSqlPrecargar="";
		String sSqlUsuario="";
		
		if(!paraPrecargarPorUsuario) {
			if(paraPrecargar) {
				sSqlPrecargar=" and perfil_opcion.con_precargar=true ";
			}
			
			if(connexionType.equals(ConnexionType.HIBERNATE)) {
				//CON RELACIONES
				/*
				sSql=" inner join opcion.perfilOpcions perfilopcion where opcion.id_modulo="+lIdSistema.toString();
				sSql+=" and perfilopcion.id_perfil in ("+sPerfiles+") ";
				sSql+=" and opcion.es_para_menu=true and opcion.estado=true order by opcion.posicion asc ";
				*/
				
				//SIN RELACIONES
				sSql=" , PerfilOpcion perfil_opcion where opcion.id=perfil_opcion.id_opcion ";
				sSql+=" and opcion.id_modulo="+lIdSistema+" and (perfil_opcion.id_perfil in ("+sPerfiles+")) and opcion.es_para_menu=true and opcion.estado=true "+sSqlPrecargar;
				sSql+=" order by posicion asc";
				
			} else if(connexionType.equals(ConnexionType.JDBC32)) {
				
				if(parameterDbType.equals(ParameterDbType.MYSQL)) {
					sSql=" inner join "+PerfilConstantesFunciones.SCHEMA+".perfil_opcion perfil_opcion on opcion.id=perfil_opcion.id_opcion ";
					sSql+=" where opcion.id_modulo="+lIdSistema+" and (perfil_opcion.id_perfil in ("+sPerfiles+")) and opcion.es_para_menu=true and opcion.estado=true "+sSqlPrecargar;
					sSql+=" order by opcion.posicion asc";
					
					
				} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
					sSql=" inner join "+PerfilConstantesFunciones.SCHEMA+".perfil_opcion perfil_opcion on opcion.id=perfil_opcion.id_opcion ";
					sSql+=" where opcion.id_modulo="+lIdSistema+" and (perfil_opcion.id_perfil in ("+sPerfiles+")) and opcion.es_para_menu=true and opcion.estado=true "+sSqlPrecargar;
					sSql+=" order by posicion asc";
				}
			}
			
		} else {
			
			if(paraPrecargar) {
				sSqlPrecargar=" and usuario_opcion.con_precargar=true ";
			}
			
			sSqlUsuario=" and usuario_opcion.id_usuario="+usuario.getId()+" ";
			
			if(connexionType.equals(ConnexionType.HIBERNATE)) {
				//CON RELACIONES
				/*
				sSql=" inner join opcion.perfilOpcions perfilopcion where opcion.id_modulo="+lIdSistema.toString();
				sSql+=" and perfilopcion.id_perfil in ("+sPerfiles+") ";
				sSql+=" and opcion.es_para_menu=true and opcion.estado=true order by opcion.posicion asc ";
				*/
				
				//SIN RELACIONES
				sSql=" , UsuarioOpcion usuario_opcion where opcion.id=usuario_opcion.id_opcion ";
				sSql+=" and opcion.id_modulo="+lIdSistema+" and (usuario_opcion.id_perfil in ("+sPerfiles+")) "+sSqlUsuario;
				sSql+=" and opcion.es_para_menu=true and opcion.estado=true "+sSqlPrecargar;
				sSql+=" order by posicion asc";
				
			} else if(connexionType.equals(ConnexionType.JDBC32)) {
				
				if(parameterDbType.equals(ParameterDbType.MYSQL)) {
					sSql=" inner join "+PerfilConstantesFunciones.SCHEMA+".usuario_opcion usuario_opcion on opcion.id=usuario_opcion.id_opcion ";
					sSql+=" where opcion.id_modulo="+lIdSistema+" and (usuario_opcion.id_perfil in ("+sPerfiles+")) "+sSqlUsuario;
					sSql+=" and opcion.es_para_menu=true and opcion.estado=true "+sSqlPrecargar;
					sSql+=" order by opcion.posicion asc";
					
					
				} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
					sSql=" inner join "+PerfilConstantesFunciones.SCHEMA+".usuario_opcion usuario_opcion on opcion.id=usuario_opcion.id_opcion ";
					sSql+=" where opcion.id_modulo="+lIdSistema+" and (usuario_opcion.id_perfil in ("+sPerfiles+")) "+sSqlUsuario;
					sSql+=" and opcion.es_para_menu=true and opcion.estado=true "+sSqlPrecargar;
					sSql+=" order by posicion asc";
				}
			}
		}
		return sSql;
	}	
}

