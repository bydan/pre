










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
import com.bydan.erp.inventario.util.report.TransferenciasResumidosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;
////import com.bydan.erp.inventario.business.interfaces.TransferenciasResumidosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class TransferenciasResumidosLogicAdditional extends TransferenciasResumidosLogic{		
	
	public  TransferenciasResumidosLogicAdditional(Connexion connexion)throws Exception {
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
	public  TransferenciasResumidosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkTransferenciasResumidosToSave(TransferenciasResumidos transferenciasresumidos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkTransferenciasResumidosToSave(TransferenciasResumidos transferenciasresumidos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkTransferenciasResumidosToSaveAfter(TransferenciasResumidos transferenciasresumidos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkTransferenciasResumidosToSaves(List<TransferenciasResumidos> transferenciasresumidoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkTransferenciasResumidosToSaves(List<TransferenciasResumidos> transferenciasresumidoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkTransferenciasResumidosToSavesAfter(List<TransferenciasResumidos> transferenciasresumidoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkTransferenciasResumidosToGet(TransferenciasResumidos transferenciasresumidos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkTransferenciasResumidosToGets(List<TransferenciasResumidos> transferenciasresumidoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateTransferenciasResumidosToSave(TransferenciasResumidos transferenciasresumidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateTransferenciasResumidosToGet(TransferenciasResumidos transferenciasresumidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectTransferenciasResumidosActions(String sTipoJsonResponse,JSONObject jsonObjectTransferenciasResumidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonTransferenciasResumidosDataTable(String sTipoJsonResponse,TransferenciasResumidos transferenciasresumidos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonTransferenciasResumidossDataTable(String sTipoJsonResponse,List<TransferenciasResumidos> transferenciasresumidoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayTransferenciasResumidosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayTransferenciasResumidossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayTransferenciasResumidossColumns;
	}
	
	public static void updateJSONArrayTransferenciasResumidosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectTransferenciasResumidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosTransferenciasResumidos(TransferenciasResumidos transferenciasresumidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		transferenciasresumidos.setnombre_transaccion(transferenciasresumidos.getnombre_transaccion().trim());
		transferenciasresumidos.setnombre_bodega(transferenciasresumidos.getnombre_bodega().trim());
		transferenciasresumidos.setnombre_producto(transferenciasresumidos.getnombre_producto().trim());
		transferenciasresumidos.setnombre_unidad(transferenciasresumidos.getnombre_unidad().trim());
		transferenciasresumidos.setnombre_bodega_enviar(transferenciasresumidos.getnombre_bodega_enviar().trim());
		transferenciasresumidos.setcodigo_producto(transferenciasresumidos.getcodigo_producto().trim());
		transferenciasresumidos.settipo(transferenciasresumidos.gettipo().trim());
	}
	
	public static void quitarEspaciosTransferenciasResumidoss(List<TransferenciasResumidos> transferenciasresumidoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TransferenciasResumidos transferenciasresumidos: transferenciasresumidoss) {
			transferenciasresumidos.setnombre_transaccion(transferenciasresumidos.getnombre_transaccion().trim());
			transferenciasresumidos.setnombre_bodega(transferenciasresumidos.getnombre_bodega().trim());
			transferenciasresumidos.setnombre_producto(transferenciasresumidos.getnombre_producto().trim());
			transferenciasresumidos.setnombre_unidad(transferenciasresumidos.getnombre_unidad().trim());
			transferenciasresumidos.setnombre_bodega_enviar(transferenciasresumidos.getnombre_bodega_enviar().trim());
			transferenciasresumidos.setcodigo_producto(transferenciasresumidos.getcodigo_producto().trim());
			transferenciasresumidos.settipo(transferenciasresumidos.gettipo().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTransferenciasResumidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(TransferenciasResumidosConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(TransferenciasResumidosConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TransferenciasResumidos> transferenciasresumidoss,TransferenciasResumidos transferenciasresumidos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TransferenciasResumidos transferenciasresumidosAux: transferenciasresumidoss) {
			if((transferenciasresumidosAux.getId()==null && transferenciasresumidos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(transferenciasresumidosAux.getId()!=null && transferenciasresumidos.getId()!=null){
				if(transferenciasresumidosAux.getId().equals(transferenciasresumidos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTransferenciasResumidos(List<TransferenciasResumidos> transferenciasresumidoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costo_unitarioTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(TransferenciasResumidos transferenciasresumidos: transferenciasresumidoss) {			
			costo_unitarioTotal+=transferenciasresumidos.getcosto_unitario();
			costo_totalTotal+=transferenciasresumidos.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciasResumidosConstantesFunciones.COSTOUNITARIO);
		datoGeneral.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_COSTOUNITARIO);
		datoGeneral.setdValorDouble(costo_unitarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciasResumidosConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_COSTOTOTAL);
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