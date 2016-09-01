














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.importaciones.business.logic;

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
import com.bydan.erp.importaciones.util.LiquidacionImporConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;
//import com.bydan.erp.importaciones.business.interfaces.LiquidacionImporAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class LiquidacionImporLogicAdditional extends LiquidacionImporLogic { // implements LiquidacionImporAdditionable{
	public  LiquidacionImporLogicAdditional(Connexion connexion)throws Exception {
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
	public  LiquidacionImporLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkLiquidacionImporToSave(LiquidacionImpor liquidacionimpor,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkLiquidacionImporToSave(LiquidacionImpor liquidacionimpor,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkLiquidacionImporToSaveAfter(LiquidacionImpor liquidacionimpor,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkLiquidacionImporToSaves(List<LiquidacionImpor> liquidacionimpors,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkLiquidacionImporToSaves(List<LiquidacionImpor> liquidacionimpors,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkLiquidacionImporToSavesAfter(List<LiquidacionImpor> liquidacionimpors,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkLiquidacionImporToGet(LiquidacionImpor liquidacionimpor,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkLiquidacionImporToGets(List<LiquidacionImpor> liquidacionimpors,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateLiquidacionImporToSave(LiquidacionImpor liquidacionimpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateLiquidacionImporToGet(LiquidacionImpor liquidacionimpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectLiquidacionImporActions(String sTipoJsonResponse,JSONObject jsonObjectLiquidacionImpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonLiquidacionImporDataTable(String sTipoJsonResponse,LiquidacionImpor liquidacionimpor,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonLiquidacionImporsDataTable(String sTipoJsonResponse,List<LiquidacionImpor> liquidacionimpors,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayLiquidacionImporColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayLiquidacionImporsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayLiquidacionImporsColumns;
	}
	
	public static void updateJSONArrayLiquidacionImporActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectLiquidacionImpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosLiquidacionImpor(LiquidacionImpor liquidacionimpor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		liquidacionimpor.setnombre(liquidacionimpor.getnombre().trim());
		liquidacionimpor.setdescripcion(liquidacionimpor.getdescripcion().trim());
		liquidacionimpor.settipo(liquidacionimpor.gettipo().trim());
	}
	
	public static void quitarEspaciosLiquidacionImpors(List<LiquidacionImpor> liquidacionimpors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(LiquidacionImpor liquidacionimpor: liquidacionimpors) {
			liquidacionimpor.setnombre(liquidacionimpor.getnombre().trim());
			liquidacionimpor.setdescripcion(liquidacionimpor.getdescripcion().trim());
			liquidacionimpor.settipo(liquidacionimpor.gettipo().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesLiquidacionImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(LiquidacionImporConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(LiquidacionImporConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<LiquidacionImpor> liquidacionimpors,LiquidacionImpor liquidacionimpor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(LiquidacionImpor liquidacionimporAux: liquidacionimpors) {
			if((liquidacionimporAux.getId()==null && liquidacionimpor.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(liquidacionimporAux.getId()!=null && liquidacionimpor.getId()!=null){
				if(liquidacionimporAux.getId().equals(liquidacionimpor.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaLiquidacionImpor(List<LiquidacionImpor> liquidacionimpors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double fleteTotal=0.0;
	
		for(LiquidacionImpor liquidacionimpor: liquidacionimpors) {			
			fleteTotal+=liquidacionimpor.getflete();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(LiquidacionImporConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(LiquidacionImporConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
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