










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.inventario.business.logic.report;

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
import com.bydan.erp.inventario.util.report.ConsumosBodegasConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;
////import com.bydan.erp.inventario.business.interfaces.ConsumosBodegasAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ConsumosBodegasLogicAdditional extends ConsumosBodegasLogic{		
	
	public  ConsumosBodegasLogicAdditional(Connexion connexion)throws Exception {
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
	public  ConsumosBodegasLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkConsumosBodegasToSave(ConsumosBodegas consumosbodegas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkConsumosBodegasToSave(ConsumosBodegas consumosbodegas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkConsumosBodegasToSaveAfter(ConsumosBodegas consumosbodegas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkConsumosBodegasToSaves(List<ConsumosBodegas> consumosbodegass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkConsumosBodegasToSaves(List<ConsumosBodegas> consumosbodegass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkConsumosBodegasToSavesAfter(List<ConsumosBodegas> consumosbodegass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkConsumosBodegasToGet(ConsumosBodegas consumosbodegas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkConsumosBodegasToGets(List<ConsumosBodegas> consumosbodegass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateConsumosBodegasToSave(ConsumosBodegas consumosbodegas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateConsumosBodegasToGet(ConsumosBodegas consumosbodegas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectConsumosBodegasActions(String sTipoJsonResponse,JSONObject jsonObjectConsumosBodegas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonConsumosBodegasDataTable(String sTipoJsonResponse,ConsumosBodegas consumosbodegas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonConsumosBodegassDataTable(String sTipoJsonResponse,List<ConsumosBodegas> consumosbodegass,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayConsumosBodegasColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayConsumosBodegassColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayConsumosBodegassColumns;
	}
	
	public static void updateJSONArrayConsumosBodegasActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectConsumosBodegas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosConsumosBodegas(ConsumosBodegas consumosbodegas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		consumosbodegas.setnombre_producto(consumosbodegas.getnombre_producto().trim());
		consumosbodegas.setnombre_unidad(consumosbodegas.getnombre_unidad().trim());
		consumosbodegas.setnombre_linea(consumosbodegas.getnombre_linea().trim());
		consumosbodegas.setnombre_linea_grupo(consumosbodegas.getnombre_linea_grupo().trim());
		consumosbodegas.setnombre_linea_categoria(consumosbodegas.getnombre_linea_categoria().trim());
		consumosbodegas.setnombre_linea_marca(consumosbodegas.getnombre_linea_marca().trim());
		consumosbodegas.setcodigo(consumosbodegas.getcodigo().trim());
	}
	
	public static void quitarEspaciosConsumosBodegass(List<ConsumosBodegas> consumosbodegass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ConsumosBodegas consumosbodegas: consumosbodegass) {
			consumosbodegas.setnombre_producto(consumosbodegas.getnombre_producto().trim());
			consumosbodegas.setnombre_unidad(consumosbodegas.getnombre_unidad().trim());
			consumosbodegas.setnombre_linea(consumosbodegas.getnombre_linea().trim());
			consumosbodegas.setnombre_linea_grupo(consumosbodegas.getnombre_linea_grupo().trim());
			consumosbodegas.setnombre_linea_categoria(consumosbodegas.getnombre_linea_categoria().trim());
			consumosbodegas.setnombre_linea_marca(consumosbodegas.getnombre_linea_marca().trim());
			consumosbodegas.setcodigo(consumosbodegas.getcodigo().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesConsumosBodegas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ConsumosBodegasConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ConsumosBodegas> consumosbodegass,ConsumosBodegas consumosbodegas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ConsumosBodegas consumosbodegasAux: consumosbodegass) {
			if((consumosbodegasAux.getId()==null && consumosbodegas.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(consumosbodegasAux.getId()!=null && consumosbodegas.getId()!=null){
				if(consumosbodegasAux.getId().equals(consumosbodegas.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaConsumosBodegas(List<ConsumosBodegas> consumosbodegass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costo_totalTotal=0.0;
	
		for(ConsumosBodegas consumosbodegas: consumosbodegass) {			
			costo_totalTotal+=consumosbodegas.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsumosBodegasConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(ConsumosBodegasConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
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