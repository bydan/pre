










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
import com.bydan.erp.inventario.util.report.PedidosComprasConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;
////import com.bydan.erp.inventario.business.interfaces.PedidosComprasAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class PedidosComprasLogicAdditional extends PedidosComprasLogic{		
	
	public  PedidosComprasLogicAdditional(Connexion connexion)throws Exception {
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
	public  PedidosComprasLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkPedidosComprasToSave(PedidosCompras pedidoscompras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkPedidosComprasToSave(PedidosCompras pedidoscompras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkPedidosComprasToSaveAfter(PedidosCompras pedidoscompras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkPedidosComprasToSaves(List<PedidosCompras> pedidoscomprass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkPedidosComprasToSaves(List<PedidosCompras> pedidoscomprass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkPedidosComprasToSavesAfter(List<PedidosCompras> pedidoscomprass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkPedidosComprasToGet(PedidosCompras pedidoscompras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkPedidosComprasToGets(List<PedidosCompras> pedidoscomprass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updatePedidosComprasToSave(PedidosCompras pedidoscompras,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updatePedidosComprasToGet(PedidosCompras pedidoscompras,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectPedidosComprasActions(String sTipoJsonResponse,JSONObject jsonObjectPedidosCompras,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonPedidosComprasDataTable(String sTipoJsonResponse,PedidosCompras pedidoscompras,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonPedidosComprassDataTable(String sTipoJsonResponse,List<PedidosCompras> pedidoscomprass,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayPedidosComprasColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayPedidosComprassColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayPedidosComprassColumns;
	}
	
	public static void updateJSONArrayPedidosComprasActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectPedidosCompras,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosPedidosCompras(PedidosCompras pedidoscompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pedidoscompras.setsecuencial(pedidoscompras.getsecuencial().trim());
		pedidoscompras.setnombre_producto(pedidoscompras.getnombre_producto().trim());
		pedidoscompras.setnombre_unidad(pedidoscompras.getnombre_unidad().trim());
		pedidoscompras.setcodigo_producto(pedidoscompras.getcodigo_producto().trim());
	}
	
	public static void quitarEspaciosPedidosComprass(List<PedidosCompras> pedidoscomprass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PedidosCompras pedidoscompras: pedidoscomprass) {
			pedidoscompras.setsecuencial(pedidoscompras.getsecuencial().trim());
			pedidoscompras.setnombre_producto(pedidoscompras.getnombre_producto().trim());
			pedidoscompras.setnombre_unidad(pedidoscompras.getnombre_unidad().trim());
			pedidoscompras.setcodigo_producto(pedidoscompras.getcodigo_producto().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPedidosCompras(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(PedidosComprasConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(PedidosComprasConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PedidosCompras> pedidoscomprass,PedidosCompras pedidoscompras,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PedidosCompras pedidoscomprasAux: pedidoscomprass) {
			if((pedidoscomprasAux.getId()==null && pedidoscompras.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(pedidoscomprasAux.getId()!=null && pedidoscompras.getId()!=null){
				if(pedidoscomprasAux.getId().equals(pedidoscompras.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPedidosCompras(List<PedidosCompras> pedidoscomprass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PedidosCompras pedidoscompras: pedidoscomprass) {			
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