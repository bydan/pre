/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.facturacion.business.logic;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;
import java.sql.Time;
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
import com.bydan.framework.erp.business.entity.GeneralEntityParameterReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.facturacion.util.ConsignacionConstantesFunciones;
//import com.bydan.erp.facturacion.util.ConsignacionReturnGeneral;
//import com.bydan.erp.facturacion.util.ConsignacionParameterGeneral;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
//import com.bydan.erp.facturacion.business.interfaces.ConsignacionAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ConsignacionLogicAdditional extends ConsignacionLogic { // implements ConsignacionAdditionable{		
	
	//CONTROL_INICIO
	public  ConsignacionLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkConsignacionToSave(Consignacion consignacion,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkConsignacionToSave(Consignacion consignacion,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkConsignacionToSaveAfter(Consignacion consignacion,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkConsignacionToSaves(List<Consignacion> consignacions,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkConsignacionToSaves(List<Consignacion> consignacions,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkConsignacionToSavesAfter(List<Consignacion> consignacions,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkConsignacionToGet(Consignacion consignacion,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkConsignacionToGets(List<Consignacion> consignacions,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateConsignacionToSave(Consignacion consignacion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateConsignacionToGet(Consignacion consignacion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectConsignacionActions(String sTipoJsonResponse,JSONObject jsonObjectConsignacion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonConsignacionDataTable(String sTipoJsonResponse,Consignacion consignacion,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonConsignacionsDataTable(String sTipoJsonResponse,List<Consignacion> consignacions,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayConsignacionColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayConsignacionsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayConsignacionsColumns;
	}
	
	public static void updateJSONArrayConsignacionActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectConsignacion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	//PARA ACCIONES ADDITIONAL
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<Consignacion> consignacions) throws Exception  {
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
		//CONTROL_17
		
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
	
	//ACCION TABLA PROCESO DESDE BUSQUEDA
	public static GeneralEntityParameterReturnGeneral ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral) throws Exception  {
		//CONTROL_18
		//GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();
			
		try {	
			//this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
		
			//this.connexion.commit();
			
		} catch(Exception e) {
			//this.connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
      		//this.connexion.close();			
		}
		
		return generalEntityReturnGeneral;
	}
	
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevoUpdate,ArrayList<Classe> clases)throws Exception {				
		//CONTROL_19		
		 try {	
				
			
			return generalEntityReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public static Boolean validarSaveRelaciones(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_20
		Boolean validado=true;

		return validado;	
	}
	
	public static void updateRelacionesToSave(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {	
		//CONTROL_21
	}
	
	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {	
		//CONTROL_22
	}
	
	
	
	//CONTROL_FUNCION1
	
	
	
	
	//CONTROL_FUNCION2
}

