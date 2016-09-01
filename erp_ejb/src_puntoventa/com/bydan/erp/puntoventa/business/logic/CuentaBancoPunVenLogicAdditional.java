














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.erp.puntoventa.util.CuentaBancoPunVenConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
//import com.bydan.erp.puntoventa.business.interfaces.CuentaBancoPunVenAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class CuentaBancoPunVenLogicAdditional extends CuentaBancoPunVenLogic { // implements CuentaBancoPunVenAdditionable{
	public  CuentaBancoPunVenLogicAdditional(Connexion connexion)throws Exception {
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
	public  CuentaBancoPunVenLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCuentaBancoPunVenToSave(CuentaBancoPunVen cuentabancopunven,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCuentaBancoPunVenToSave(CuentaBancoPunVen cuentabancopunven,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCuentaBancoPunVenToSaveAfter(CuentaBancoPunVen cuentabancopunven,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCuentaBancoPunVenToSaves(List<CuentaBancoPunVen> cuentabancopunvens,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCuentaBancoPunVenToSaves(List<CuentaBancoPunVen> cuentabancopunvens,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCuentaBancoPunVenToSavesAfter(List<CuentaBancoPunVen> cuentabancopunvens,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCuentaBancoPunVenToGet(CuentaBancoPunVen cuentabancopunven,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCuentaBancoPunVenToGets(List<CuentaBancoPunVen> cuentabancopunvens,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCuentaBancoPunVenToSave(CuentaBancoPunVen cuentabancopunven,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCuentaBancoPunVenToGet(CuentaBancoPunVen cuentabancopunven,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCuentaBancoPunVenActions(String sTipoJsonResponse,JSONObject jsonObjectCuentaBancoPunVen,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCuentaBancoPunVenDataTable(String sTipoJsonResponse,CuentaBancoPunVen cuentabancopunven,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCuentaBancoPunVensDataTable(String sTipoJsonResponse,List<CuentaBancoPunVen> cuentabancopunvens,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCuentaBancoPunVenColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCuentaBancoPunVensColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCuentaBancoPunVensColumns;
	}
	
	public static void updateJSONArrayCuentaBancoPunVenActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCuentaBancoPunVen,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCuentaBancoPunVen(CuentaBancoPunVen cuentabancopunven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cuentabancopunven.setcodigo(cuentabancopunven.getcodigo().trim());
		cuentabancopunven.setnombre(cuentabancopunven.getnombre().trim());
	}
	
	public static void quitarEspaciosCuentaBancoPunVens(List<CuentaBancoPunVen> cuentabancopunvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CuentaBancoPunVen cuentabancopunven: cuentabancopunvens) {
			cuentabancopunven.setcodigo(cuentabancopunven.getcodigo().trim());
			cuentabancopunven.setnombre(cuentabancopunven.getnombre().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentaBancoPunVen(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(CuentaBancoPunVenConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(CuentaBancoPunVenConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CuentaBancoPunVen> cuentabancopunvens,CuentaBancoPunVen cuentabancopunven,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CuentaBancoPunVen cuentabancopunvenAux: cuentabancopunvens) {
			if((cuentabancopunvenAux.getId()==null && cuentabancopunven.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(cuentabancopunvenAux.getId()!=null && cuentabancopunven.getId()!=null){
				if(cuentabancopunvenAux.getId().equals(cuentabancopunven.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCuentaBancoPunVen(List<CuentaBancoPunVen> cuentabancopunvens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CuentaBancoPunVen cuentabancopunven: cuentabancopunvens) {			
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