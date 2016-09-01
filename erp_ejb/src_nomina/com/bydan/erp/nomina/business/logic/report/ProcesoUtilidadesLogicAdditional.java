
/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.nomina.business.logic.report;

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

import com.bydan.erp.nomina.resources.general.AuxiliarGeneral;

import com.bydan.erp.nomina.util.report.ProcesoUtilidadesConstantesFunciones;
//import com.bydan.erp.nomina.util.report.ProcesoUtilidadesReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoUtilidadesParameterGeneral;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.business.entity.report.*;
////import com.bydan.erp.nomina.business.interfaces.ProcesoUtilidadesAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.nomina.business.logic.NominaLogicAdditional;

@SuppressWarnings("unused")
final public class ProcesoUtilidadesLogicAdditional extends ProcesoUtilidadesLogic{		
	
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
	public  ProcesoUtilidadesLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProcesoUtilidadesToSave(ProcesoUtilidades procesoutilidades,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProcesoUtilidadesToSave(ProcesoUtilidades procesoutilidades,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProcesoUtilidadesToSaveAfter(ProcesoUtilidades procesoutilidades,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProcesoUtilidadesToSaves(List<ProcesoUtilidades> procesoutilidadess,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProcesoUtilidadesToSaves(List<ProcesoUtilidades> procesoutilidadess,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProcesoUtilidadesToSavesAfter(List<ProcesoUtilidades> procesoutilidadess,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProcesoUtilidadesToGet(ProcesoUtilidades procesoutilidades,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProcesoUtilidadesToGets(List<ProcesoUtilidades> procesoutilidadess,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProcesoUtilidadesToSave(ProcesoUtilidades procesoutilidades,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProcesoUtilidadesToGet(ProcesoUtilidades procesoutilidades,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProcesoUtilidadesActions(String sTipoJsonResponse,JSONObject jsonObjectProcesoUtilidades,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProcesoUtilidadesDataTable(String sTipoJsonResponse,ProcesoUtilidades procesoutilidades,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProcesoUtilidadessDataTable(String sTipoJsonResponse,List<ProcesoUtilidades> procesoutilidadess,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProcesoUtilidadesColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProcesoUtilidadessColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProcesoUtilidadessColumns;
	}
	
	public static void updateJSONArrayProcesoUtilidadesActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProcesoUtilidades,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	//PARA ACCIONES ADDITIONAL
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<ProcesoUtilidades> procesoutilidadess) throws Exception  {
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
	public void BusquedaProcesoUtilidades(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio,Double valor)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		//this.connexion=this.connexion.getNewConnexion(connexionType,parameterDbType,this.entityManagerFactory);this.connexion.begin();

		try {

		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("ProcesoUtilidades_Postgres.sql");
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
				

				if(id_anio!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.id_anio = "+id_anio.toString();
					existeWhere=true;
				}

				if(valor!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" f.valor = "+valor.toString();
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
	
	
	public Boolean ProcesarInformacionProcesoUtilidades(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoUtilidades> procesoutilidadess,String sTipoBusqueda,Long id_anioBusquedaProcesoUtilidades,Double valorBusquedaProcesoUtilidades) throws Exception {
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

	public static GeneralEntityParameterReturnGeneral ProcesarInformacionProcesoUtilidades(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,GeneralEntityLogic generalEntityLogic,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,String sTipoBusqueda,Long id_anioBusquedaProcesoUtilidades,Double valorBusquedaProcesoUtilidades) throws Exception {

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
