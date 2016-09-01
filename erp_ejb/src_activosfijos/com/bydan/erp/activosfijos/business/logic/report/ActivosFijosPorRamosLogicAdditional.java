










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.activosfijos.business.logic.report;

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
import com.bydan.erp.activosfijos.util.report.ActivosFijosPorRamosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.report.*;
////import com.bydan.erp.activosfijos.business.interfaces.ActivosFijosPorRamosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ActivosFijosPorRamosLogicAdditional extends ActivosFijosPorRamosLogic{		
	
	public  ActivosFijosPorRamosLogicAdditional(Connexion connexion)throws Exception {
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
	public  ActivosFijosPorRamosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkActivosFijosPorRamosToSave(ActivosFijosPorRamos activosfijosporramos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkActivosFijosPorRamosToSave(ActivosFijosPorRamos activosfijosporramos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkActivosFijosPorRamosToSaveAfter(ActivosFijosPorRamos activosfijosporramos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkActivosFijosPorRamosToSaves(List<ActivosFijosPorRamos> activosfijosporramoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkActivosFijosPorRamosToSaves(List<ActivosFijosPorRamos> activosfijosporramoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkActivosFijosPorRamosToSavesAfter(List<ActivosFijosPorRamos> activosfijosporramoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkActivosFijosPorRamosToGet(ActivosFijosPorRamos activosfijosporramos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkActivosFijosPorRamosToGets(List<ActivosFijosPorRamos> activosfijosporramoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateActivosFijosPorRamosToSave(ActivosFijosPorRamos activosfijosporramos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateActivosFijosPorRamosToGet(ActivosFijosPorRamos activosfijosporramos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectActivosFijosPorRamosActions(String sTipoJsonResponse,JSONObject jsonObjectActivosFijosPorRamos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonActivosFijosPorRamosDataTable(String sTipoJsonResponse,ActivosFijosPorRamos activosfijosporramos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonActivosFijosPorRamossDataTable(String sTipoJsonResponse,List<ActivosFijosPorRamos> activosfijosporramoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayActivosFijosPorRamosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayActivosFijosPorRamossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayActivosFijosPorRamossColumns;
	}
	
	public static void updateJSONArrayActivosFijosPorRamosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectActivosFijosPorRamos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosActivosFijosPorRamos(ActivosFijosPorRamos activosfijosporramos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		activosfijosporramos.setnombre_sub_grupo(activosfijosporramos.getnombre_sub_grupo().trim());
		activosfijosporramos.setnombre_detalle_grupo(activosfijosporramos.getnombre_detalle_grupo().trim());
		activosfijosporramos.setclave(activosfijosporramos.getclave().trim());
		activosfijosporramos.setnombre(activosfijosporramos.getnombre().trim());
		activosfijosporramos.setmarca(activosfijosporramos.getmarca().trim());
		activosfijosporramos.setmodelo(activosfijosporramos.getmodelo().trim());
		activosfijosporramos.setnumero_matricula(activosfijosporramos.getnumero_matricula().trim());
		activosfijosporramos.setnumero_motor(activosfijosporramos.getnumero_motor().trim());
		activosfijosporramos.setnumero_chasis(activosfijosporramos.getnumero_chasis().trim());
		activosfijosporramos.setnumero_placa(activosfijosporramos.getnumero_placa().trim());
	}
	
	public static void quitarEspaciosActivosFijosPorRamoss(List<ActivosFijosPorRamos> activosfijosporramoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ActivosFijosPorRamos activosfijosporramos: activosfijosporramoss) {
			activosfijosporramos.setnombre_sub_grupo(activosfijosporramos.getnombre_sub_grupo().trim());
			activosfijosporramos.setnombre_detalle_grupo(activosfijosporramos.getnombre_detalle_grupo().trim());
			activosfijosporramos.setclave(activosfijosporramos.getclave().trim());
			activosfijosporramos.setnombre(activosfijosporramos.getnombre().trim());
			activosfijosporramos.setmarca(activosfijosporramos.getmarca().trim());
			activosfijosporramos.setmodelo(activosfijosporramos.getmodelo().trim());
			activosfijosporramos.setnumero_matricula(activosfijosporramos.getnumero_matricula().trim());
			activosfijosporramos.setnumero_motor(activosfijosporramos.getnumero_motor().trim());
			activosfijosporramos.setnumero_chasis(activosfijosporramos.getnumero_chasis().trim());
			activosfijosporramos.setnumero_placa(activosfijosporramos.getnumero_placa().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesActivosFijosPorRamos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ActivosFijosPorRamosConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ActivosFijosPorRamos> activosfijosporramoss,ActivosFijosPorRamos activosfijosporramos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ActivosFijosPorRamos activosfijosporramosAux: activosfijosporramoss) {
			if((activosfijosporramosAux.getId()==null && activosfijosporramos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(activosfijosporramosAux.getId()!=null && activosfijosporramos.getId()!=null){
				if(activosfijosporramosAux.getId().equals(activosfijosporramos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaActivosFijosPorRamos(List<ActivosFijosPorRamos> activosfijosporramoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double vida_utilTotal=0.0;
		Double costo_de_compraTotal=0.0;
		Double valor_comercialTotal=0.0;
	
		for(ActivosFijosPorRamos activosfijosporramos: activosfijosporramoss) {			
			vida_utilTotal+=activosfijosporramos.getvida_util();
			costo_de_compraTotal+=activosfijosporramos.getcosto_de_compra();
			valor_comercialTotal+=activosfijosporramos.getvalor_comercial();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ActivosFijosPorRamosConstantesFunciones.VIDAUTIL);
		datoGeneral.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_VIDAUTIL);
		datoGeneral.setdValorDouble(vida_utilTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ActivosFijosPorRamosConstantesFunciones.COSTODECOMPRA);
		datoGeneral.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_COSTODECOMPRA);
		datoGeneral.setdValorDouble(costo_de_compraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ActivosFijosPorRamosConstantesFunciones.VALORCOMERCIAL);
		datoGeneral.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_VALORCOMERCIAL);
		datoGeneral.setdValorDouble(valor_comercialTotal);
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