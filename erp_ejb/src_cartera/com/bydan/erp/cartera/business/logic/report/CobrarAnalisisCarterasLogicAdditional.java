










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.cartera.business.logic.report;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.cartera.util.report.CobrarAnalisisCarterasConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.CobrarAnalisisCarterasAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class CobrarAnalisisCarterasLogicAdditional extends CobrarAnalisisCarterasLogic{		
	
	public  CobrarAnalisisCarterasLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
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
	public  CobrarAnalisisCarterasLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCobrarAnalisisCarterasToSave(CobrarAnalisisCarteras cobraranalisiscarteras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCobrarAnalisisCarterasToSave(CobrarAnalisisCarteras cobraranalisiscarteras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCobrarAnalisisCarterasToSaveAfter(CobrarAnalisisCarteras cobraranalisiscarteras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCobrarAnalisisCarterasToSaves(List<CobrarAnalisisCarteras> cobraranalisiscarterass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCobrarAnalisisCarterasToSaves(List<CobrarAnalisisCarteras> cobraranalisiscarterass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCobrarAnalisisCarterasToSavesAfter(List<CobrarAnalisisCarteras> cobraranalisiscarterass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCobrarAnalisisCarterasToGet(CobrarAnalisisCarteras cobraranalisiscarteras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCobrarAnalisisCarterasToGets(List<CobrarAnalisisCarteras> cobraranalisiscarterass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCobrarAnalisisCarterasToSave(CobrarAnalisisCarteras cobraranalisiscarteras,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCobrarAnalisisCarterasToGet(CobrarAnalisisCarteras cobraranalisiscarteras,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCobrarAnalisisCarterasActions(String sTipoJsonResponse,JSONObject jsonObjectCobrarAnalisisCarteras,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCobrarAnalisisCarterasDataTable(String sTipoJsonResponse,CobrarAnalisisCarteras cobraranalisiscarteras,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCobrarAnalisisCarterassDataTable(String sTipoJsonResponse,List<CobrarAnalisisCarteras> cobraranalisiscarterass,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCobrarAnalisisCarterasColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCobrarAnalisisCarterassColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCobrarAnalisisCarterassColumns;
	}
	
	public static void updateJSONArrayCobrarAnalisisCarterasActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCobrarAnalisisCarteras,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCobrarAnalisisCarteras(CobrarAnalisisCarteras cobraranalisiscarteras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobraranalisiscarteras.setnombre_tipo_radio_venci(cobraranalisiscarteras.getnombre_tipo_radio_venci().trim());
	}
	
	public static void quitarEspaciosCobrarAnalisisCarterass(List<CobrarAnalisisCarteras> cobraranalisiscarterass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarAnalisisCarteras cobraranalisiscarteras: cobraranalisiscarterass) {
			cobraranalisiscarteras.setnombre_tipo_radio_venci(cobraranalisiscarteras.getnombre_tipo_radio_venci().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarAnalisisCarteras(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarAnalisisCarteras> cobraranalisiscarterass,CobrarAnalisisCarteras cobraranalisiscarteras,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarAnalisisCarteras cobraranalisiscarterasAux: cobraranalisiscarterass) {
			if((cobraranalisiscarterasAux.getId()==null && cobraranalisiscarteras.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(cobraranalisiscarterasAux.getId()!=null && cobraranalisiscarteras.getId()!=null){
				if(cobraranalisiscarterasAux.getId().equals(cobraranalisiscarteras.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarAnalisisCarteras(List<CobrarAnalisisCarteras> cobraranalisiscarterass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CobrarAnalisisCarteras cobraranalisiscarteras: cobraranalisiscarterass) {			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	//PARA ACCIONES NORMALES
	public static GeneralEntityParameterReturnGeneral procesarAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral)throws Exception {
		try {

			//GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();


			return generalEntityReturnGeneral;

		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;

		} finally {

		}
	}

	//CONTROL_FUNCION2
}