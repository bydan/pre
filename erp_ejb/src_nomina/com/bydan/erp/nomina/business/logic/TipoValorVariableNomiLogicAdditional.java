














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.nomina.util.TipoValorVariableNomiConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
//import com.bydan.erp.nomina.business.interfaces.TipoValorVariableNomiAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class TipoValorVariableNomiLogicAdditional extends TipoValorVariableNomiLogic { // implements TipoValorVariableNomiAdditionable{
	public  TipoValorVariableNomiLogicAdditional(Connexion connexion)throws Exception {
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


	public static Boolean validarSaveRelaciones(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_20
		Boolean validado=true;

		return validado;	
	}


	public static void updateRelacionesToSave(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}


	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}

	//CONTROL_INICIO
	public  TipoValorVariableNomiLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkTipoValorVariableNomiToSave(TipoValorVariableNomi tipovalorvariablenomi,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkTipoValorVariableNomiToSave(TipoValorVariableNomi tipovalorvariablenomi,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkTipoValorVariableNomiToSaveAfter(TipoValorVariableNomi tipovalorvariablenomi,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkTipoValorVariableNomiToSaves(List<TipoValorVariableNomi> tipovalorvariablenomis,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkTipoValorVariableNomiToSaves(List<TipoValorVariableNomi> tipovalorvariablenomis,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkTipoValorVariableNomiToSavesAfter(List<TipoValorVariableNomi> tipovalorvariablenomis,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkTipoValorVariableNomiToGet(TipoValorVariableNomi tipovalorvariablenomi,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkTipoValorVariableNomiToGets(List<TipoValorVariableNomi> tipovalorvariablenomis,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateTipoValorVariableNomiToSave(TipoValorVariableNomi tipovalorvariablenomi,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateTipoValorVariableNomiToGet(TipoValorVariableNomi tipovalorvariablenomi,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectTipoValorVariableNomiActions(String sTipoJsonResponse,JSONObject jsonObjectTipoValorVariableNomi,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonTipoValorVariableNomiDataTable(String sTipoJsonResponse,TipoValorVariableNomi tipovalorvariablenomi,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonTipoValorVariableNomisDataTable(String sTipoJsonResponse,List<TipoValorVariableNomi> tipovalorvariablenomis,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayTipoValorVariableNomiColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayTipoValorVariableNomisColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayTipoValorVariableNomisColumns;
	}
	
	public static void updateJSONArrayTipoValorVariableNomiActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectTipoValorVariableNomi,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosTipoValorVariableNomi(TipoValorVariableNomi tipovalorvariablenomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipovalorvariablenomi.setcodigo(tipovalorvariablenomi.getcodigo().trim());
		tipovalorvariablenomi.setnombre(tipovalorvariablenomi.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoValorVariableNomis(List<TipoValorVariableNomi> tipovalorvariablenomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoValorVariableNomi tipovalorvariablenomi: tipovalorvariablenomis) {
			tipovalorvariablenomi.setcodigo(tipovalorvariablenomi.getcodigo().trim());
			tipovalorvariablenomi.setnombre(tipovalorvariablenomi.getnombre().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoValorVariableNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoValorVariableNomi> tipovalorvariablenomis,TipoValorVariableNomi tipovalorvariablenomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoValorVariableNomi tipovalorvariablenomiAux: tipovalorvariablenomis) {
			if((tipovalorvariablenomiAux.getId()==null && tipovalorvariablenomi.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(tipovalorvariablenomiAux.getId()!=null && tipovalorvariablenomi.getId()!=null){
				if(tipovalorvariablenomiAux.getId().equals(tipovalorvariablenomi.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoValorVariableNomi(List<TipoValorVariableNomi> tipovalorvariablenomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoValorVariableNomi tipovalorvariablenomi: tipovalorvariablenomis) {			
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