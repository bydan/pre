
/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.contabilidad.business.logic.report;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;
import java.sql.Timestamp;

import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;

import com.bydan.erp.contabilidad.resources.general.AuxiliarGeneral;

import com.bydan.erp.contabilidad.util.report.ProcesoAsientoInicialEjercicioConstantesFunciones;
//import com.bydan.erp.contabilidad.util.report.ProcesoAsientoInicialEjercicioReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.ProcesoAsientoInicialEjercicioParameterGeneral;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;
////import com.bydan.erp.contabilidad.business.interfaces.ProcesoAsientoInicialEjercicioAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.contabilidad.business.logic.ContabilidadLogicAdditional;

@SuppressWarnings("unused")
final public class ProcesoAsientoInicialEjercicioLogicAdditional extends ProcesoAsientoInicialEjercicioLogic{		
	
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19


			return generalEntityReturnGeneral;

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;

		} finally {

		}
	}

	//CONTROL_INICIO
	public  ProcesoAsientoInicialEjercicioLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProcesoAsientoInicialEjercicioToSave(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProcesoAsientoInicialEjercicioToSave(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProcesoAsientoInicialEjercicioToSaveAfter(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProcesoAsientoInicialEjercicioToSaves(List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejercicios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProcesoAsientoInicialEjercicioToSaves(List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejercicios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProcesoAsientoInicialEjercicioToSavesAfter(List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejercicios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProcesoAsientoInicialEjercicioToGet(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProcesoAsientoInicialEjercicioToGets(List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejercicios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProcesoAsientoInicialEjercicioToSave(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProcesoAsientoInicialEjercicioToGet(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProcesoAsientoInicialEjercicioActions(String sTipoJsonResponse,JSONObject jsonObjectProcesoAsientoInicialEjercicio,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProcesoAsientoInicialEjercicioDataTable(String sTipoJsonResponse,ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProcesoAsientoInicialEjerciciosDataTable(String sTipoJsonResponse,List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejercicios,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProcesoAsientoInicialEjercicioColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProcesoAsientoInicialEjerciciosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProcesoAsientoInicialEjerciciosColumns;
	}
	
	public static void updateJSONArrayProcesoAsientoInicialEjercicioActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProcesoAsientoInicialEjercicio,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	//PARA ACCIONES ADDITIONAL
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejercicios) throws Exception  {
		//CONTROL_16
		Boolean esProcesado=true;
		
		try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
		
			this.connexion.commit();
			
		} catch(Exception e) {
			this.connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
      		this.connexion.close();			
		}
		
		return esProcesado;
	}
	
	//PARA ACCIONES NORMALES		
	public static GeneralEntityParameterReturnGeneral procesarAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral)throws Exception {				
		 try {	
			
			//GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();
				
			
			return generalEntityReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	

	@SuppressWarnings("resource")
	public void BusquedaProcesoAsientoInicialEjercicio(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_documento,Date fecha_inicio,Date fecha_fin)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		//this.connexion=this.connexion.getNewConnexion(connexionType,parameterDbType,this.entityManagerFactory);this.connexion.begin();

		try {

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ProcesoAsientoInicialEjercicio_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" f.id_empresa="+parametroGeneralUsuario.getid_empresa();
					//existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" f.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(id_tipo_documento!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.id_tipo_documento = "+id_tipo_documento.toString();
					existeWhere=true;
				}

				if(fecha_inicio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.fecha between "+"'"+Funciones2.getStringPostgresDate(fecha_inicio)+"'";
					existeWhere=true;
				}

				if(fecha_fin!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+="'"+Funciones2.getStringPostgresDate(fecha_fin)+"'";
					existeWhere=true;
				}

				if(existeWhere) {
					sSqlWhere=" where "+sSqlWhere;
				}

				if(sSelectQuery.contains(Constantes2.S_KEYWHERE)) {
					sSql=sSelectQuery.replace(Constantes2.S_KEYWHERE,sSqlWhere);
				} else {
					sSql=sSelectQuery+sSqlWhere;
				}

				if(Constantes.ISDEVELOPING) {
					System.out.println(sSql);
				}

				this.getEntities(sSelectQuery, "");
			}
		}

			//this.connexion.commit();

		} catch(Exception e) {
			//this.connexion.rollback();
			throw e;

		} finally {
			//this.connexion.close();
		}
	}
	
	
	public Boolean ProcesarInformacionProcesoAsientoInicialEjercicio(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoAsientoInicialEjercicio> procesoasientoinicialejercicios,String sTipoBusqueda,Long id_tipo_documentoBusquedaProcesoAsientoInicialEjercicio,Date fecha_inicioBusquedaProcesoAsientoInicialEjercicio,Date fecha_finBusquedaProcesoAsientoInicialEjercicio) throws Exception {
		Boolean procesado=false;

		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}

		return procesado;
	}

	public static GeneralEntityParameterReturnGeneral ProcesarInformacionProcesoAsientoInicialEjercicio(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,GeneralEntityLogic generalEntityLogic,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,String sTipoBusqueda,Long id_tipo_documentoBusquedaProcesoAsientoInicialEjercicio,Date fecha_inicioBusquedaProcesoAsientoInicialEjercicio,Date fecha_finBusquedaProcesoAsientoInicialEjercicio) throws Exception {

		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}

		return generalEntityReturnGeneral;
	}
	//CONTROL_FUNCION1
	
	
	
	
	//CONTROL_FUNCION2
}
