














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.produccion.business.logic;

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
import com.bydan.erp.produccion.util.PedidoProduConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;
//import com.bydan.erp.produccion.business.interfaces.PedidoProduAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class PedidoProduLogicAdditional extends PedidoProduLogic { // implements PedidoProduAdditionable{
	public  PedidoProduLogicAdditional(Connexion connexion)throws Exception {
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
	public  PedidoProduLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkPedidoProduToSave(PedidoProdu pedidoprodu,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkPedidoProduToSave(PedidoProdu pedidoprodu,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkPedidoProduToSaveAfter(PedidoProdu pedidoprodu,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkPedidoProduToSaves(List<PedidoProdu> pedidoprodus,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkPedidoProduToSaves(List<PedidoProdu> pedidoprodus,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkPedidoProduToSavesAfter(List<PedidoProdu> pedidoprodus,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkPedidoProduToGet(PedidoProdu pedidoprodu,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkPedidoProduToGets(List<PedidoProdu> pedidoprodus,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updatePedidoProduToSave(PedidoProdu pedidoprodu,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updatePedidoProduToGet(PedidoProdu pedidoprodu,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectPedidoProduActions(String sTipoJsonResponse,JSONObject jsonObjectPedidoProdu,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonPedidoProduDataTable(String sTipoJsonResponse,PedidoProdu pedidoprodu,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonPedidoProdusDataTable(String sTipoJsonResponse,List<PedidoProdu> pedidoprodus,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayPedidoProduColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayPedidoProdusColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayPedidoProdusColumns;
	}
	
	public static void updateJSONArrayPedidoProduActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectPedidoProdu,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosPedidoProdu(PedidoProdu pedidoprodu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pedidoprodu.setsecuencial(pedidoprodu.getsecuencial().trim());
		pedidoprodu.setdireccion_cliente(pedidoprodu.getdireccion_cliente().trim());
		pedidoprodu.settelefono_cliente(pedidoprodu.gettelefono_cliente().trim());
		pedidoprodu.setruc_cliente(pedidoprodu.getruc_cliente().trim());
		pedidoprodu.setlote(pedidoprodu.getlote().trim());
		pedidoprodu.setdescripcion(pedidoprodu.getdescripcion().trim());
	}
	
	public static void quitarEspaciosPedidoProdus(List<PedidoProdu> pedidoprodus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PedidoProdu pedidoprodu: pedidoprodus) {
			pedidoprodu.setsecuencial(pedidoprodu.getsecuencial().trim());
			pedidoprodu.setdireccion_cliente(pedidoprodu.getdireccion_cliente().trim());
			pedidoprodu.settelefono_cliente(pedidoprodu.gettelefono_cliente().trim());
			pedidoprodu.setruc_cliente(pedidoprodu.getruc_cliente().trim());
			pedidoprodu.setlote(pedidoprodu.getlote().trim());
			pedidoprodu.setdescripcion(pedidoprodu.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPedidoProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(PedidoProduConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(PedidoProduConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(PedidoProduConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(PedidoProduConstantesFunciones.IDPERIODO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PedidoProdu> pedidoprodus,PedidoProdu pedidoprodu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PedidoProdu pedidoproduAux: pedidoprodus) {
			if((pedidoproduAux.getId()==null && pedidoprodu.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(pedidoproduAux.getId()!=null && pedidoprodu.getId()!=null){
				if(pedidoproduAux.getId().equals(pedidoprodu.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPedidoProdu(List<PedidoProdu> pedidoprodus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PedidoProdu pedidoprodu: pedidoprodus) {			
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