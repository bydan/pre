














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
import com.bydan.erp.nomina.util.HistorialPagoNomiConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
//import com.bydan.erp.nomina.business.interfaces.HistorialPagoNomiAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class HistorialPagoNomiLogicAdditional extends HistorialPagoNomiLogic { // implements HistorialPagoNomiAdditionable{
	public  HistorialPagoNomiLogicAdditional(Connexion connexion)throws Exception {
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
	public  HistorialPagoNomiLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkHistorialPagoNomiToSave(HistorialPagoNomi historialpagonomi,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkHistorialPagoNomiToSave(HistorialPagoNomi historialpagonomi,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkHistorialPagoNomiToSaveAfter(HistorialPagoNomi historialpagonomi,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkHistorialPagoNomiToSaves(List<HistorialPagoNomi> historialpagonomis,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkHistorialPagoNomiToSaves(List<HistorialPagoNomi> historialpagonomis,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkHistorialPagoNomiToSavesAfter(List<HistorialPagoNomi> historialpagonomis,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkHistorialPagoNomiToGet(HistorialPagoNomi historialpagonomi,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkHistorialPagoNomiToGets(List<HistorialPagoNomi> historialpagonomis,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateHistorialPagoNomiToSave(HistorialPagoNomi historialpagonomi,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateHistorialPagoNomiToGet(HistorialPagoNomi historialpagonomi,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectHistorialPagoNomiActions(String sTipoJsonResponse,JSONObject jsonObjectHistorialPagoNomi,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonHistorialPagoNomiDataTable(String sTipoJsonResponse,HistorialPagoNomi historialpagonomi,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonHistorialPagoNomisDataTable(String sTipoJsonResponse,List<HistorialPagoNomi> historialpagonomis,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayHistorialPagoNomiColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayHistorialPagoNomisColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayHistorialPagoNomisColumns;
	}
	
	public static void updateJSONArrayHistorialPagoNomiActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectHistorialPagoNomi,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosHistorialPagoNomi(HistorialPagoNomi historialpagonomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosHistorialPagoNomis(List<HistorialPagoNomi> historialpagonomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(HistorialPagoNomi historialpagonomi: historialpagonomis) {
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesHistorialPagoNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(HistorialPagoNomiConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<HistorialPagoNomi> historialpagonomis,HistorialPagoNomi historialpagonomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(HistorialPagoNomi historialpagonomiAux: historialpagonomis) {
			if((historialpagonomiAux.getId()==null && historialpagonomi.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(historialpagonomiAux.getId()!=null && historialpagonomi.getId()!=null){
				if(historialpagonomiAux.getId().equals(historialpagonomi.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaHistorialPagoNomi(List<HistorialPagoNomi> historialpagonomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(HistorialPagoNomi historialpagonomi: historialpagonomis) {			
			valorTotal+=historialpagonomi.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(HistorialPagoNomiConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(HistorialPagoNomiConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
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