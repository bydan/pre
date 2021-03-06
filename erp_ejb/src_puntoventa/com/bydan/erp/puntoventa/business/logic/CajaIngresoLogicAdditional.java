














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
import com.bydan.erp.puntoventa.util.CajaIngresoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
//import com.bydan.erp.puntoventa.business.interfaces.CajaIngresoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class CajaIngresoLogicAdditional extends CajaIngresoLogic { // implements CajaIngresoAdditionable{
	public  CajaIngresoLogicAdditional(Connexion connexion)throws Exception {
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
	public  CajaIngresoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCajaIngresoToSave(CajaIngreso cajaingreso,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCajaIngresoToSave(CajaIngreso cajaingreso,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCajaIngresoToSaveAfter(CajaIngreso cajaingreso,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCajaIngresoToSaves(List<CajaIngreso> cajaingresos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCajaIngresoToSaves(List<CajaIngreso> cajaingresos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCajaIngresoToSavesAfter(List<CajaIngreso> cajaingresos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCajaIngresoToGet(CajaIngreso cajaingreso,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCajaIngresoToGets(List<CajaIngreso> cajaingresos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCajaIngresoToSave(CajaIngreso cajaingreso,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCajaIngresoToGet(CajaIngreso cajaingreso,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCajaIngresoActions(String sTipoJsonResponse,JSONObject jsonObjectCajaIngreso,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCajaIngresoDataTable(String sTipoJsonResponse,CajaIngreso cajaingreso,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCajaIngresosDataTable(String sTipoJsonResponse,List<CajaIngreso> cajaingresos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCajaIngresoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCajaIngresosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCajaIngresosColumns;
	}
	
	public static void updateJSONArrayCajaIngresoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCajaIngreso,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCajaIngreso(CajaIngreso cajaingreso,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cajaingreso.setsecuencial(cajaingreso.getsecuencial().trim());
	}
	
	public static void quitarEspaciosCajaIngresos(List<CajaIngreso> cajaingresos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CajaIngreso cajaingreso: cajaingresos) {
			cajaingreso.setsecuencial(cajaingreso.getsecuencial().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCajaIngreso(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(CajaIngresoConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(CajaIngresoConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(CajaIngresoConstantesFunciones.IDUSUARIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CajaIngreso> cajaingresos,CajaIngreso cajaingreso,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CajaIngreso cajaingresoAux: cajaingresos) {
			if((cajaingresoAux.getId()==null && cajaingreso.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(cajaingresoAux.getId()!=null && cajaingreso.getId()!=null){
				if(cajaingresoAux.getId().equals(cajaingreso.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCajaIngreso(List<CajaIngreso> cajaingresos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CajaIngreso cajaingreso: cajaingresos) {			
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