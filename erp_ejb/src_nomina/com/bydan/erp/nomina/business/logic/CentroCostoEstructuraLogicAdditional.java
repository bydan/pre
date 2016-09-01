














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
import com.bydan.erp.nomina.util.CentroCostoEstructuraConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
//import com.bydan.erp.nomina.business.interfaces.CentroCostoEstructuraAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class CentroCostoEstructuraLogicAdditional extends CentroCostoEstructuraLogic { // implements CentroCostoEstructuraAdditionable{
	public  CentroCostoEstructuraLogicAdditional(Connexion connexion)throws Exception {
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
	public  CentroCostoEstructuraLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCentroCostoEstructuraToSave(CentroCostoEstructura centrocostoestructura,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCentroCostoEstructuraToSave(CentroCostoEstructura centrocostoestructura,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCentroCostoEstructuraToSaveAfter(CentroCostoEstructura centrocostoestructura,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCentroCostoEstructuraToSaves(List<CentroCostoEstructura> centrocostoestructuras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCentroCostoEstructuraToSaves(List<CentroCostoEstructura> centrocostoestructuras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCentroCostoEstructuraToSavesAfter(List<CentroCostoEstructura> centrocostoestructuras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCentroCostoEstructuraToGet(CentroCostoEstructura centrocostoestructura,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCentroCostoEstructuraToGets(List<CentroCostoEstructura> centrocostoestructuras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCentroCostoEstructuraToSave(CentroCostoEstructura centrocostoestructura,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCentroCostoEstructuraToGet(CentroCostoEstructura centrocostoestructura,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCentroCostoEstructuraActions(String sTipoJsonResponse,JSONObject jsonObjectCentroCostoEstructura,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCentroCostoEstructuraDataTable(String sTipoJsonResponse,CentroCostoEstructura centrocostoestructura,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCentroCostoEstructurasDataTable(String sTipoJsonResponse,List<CentroCostoEstructura> centrocostoestructuras,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCentroCostoEstructuraColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCentroCostoEstructurasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCentroCostoEstructurasColumns;
	}
	
	public static void updateJSONArrayCentroCostoEstructuraActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCentroCostoEstructura,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCentroCostoEstructura(CentroCostoEstructura centrocostoestructura,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosCentroCostoEstructuras(List<CentroCostoEstructura> centrocostoestructuras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CentroCostoEstructura centrocostoestructura: centrocostoestructuras) {
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCentroCostoEstructura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(CentroCostoEstructuraConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(CentroCostoEstructuraConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CentroCostoEstructura> centrocostoestructuras,CentroCostoEstructura centrocostoestructura,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CentroCostoEstructura centrocostoestructuraAux: centrocostoestructuras) {
			if((centrocostoestructuraAux.getId()==null && centrocostoestructura.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(centrocostoestructuraAux.getId()!=null && centrocostoestructura.getId()!=null){
				if(centrocostoestructuraAux.getId().equals(centrocostoestructura.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCentroCostoEstructura(List<CentroCostoEstructura> centrocostoestructuras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
	
		for(CentroCostoEstructura centrocostoestructura: centrocostoestructuras) {			
			porcentajeTotal+=centrocostoestructura.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CentroCostoEstructuraConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(CentroCostoEstructuraConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
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