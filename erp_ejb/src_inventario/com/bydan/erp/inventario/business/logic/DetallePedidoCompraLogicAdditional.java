














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.erp.inventario.util.DetallePedidoCompraConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
//import com.bydan.erp.inventario.business.interfaces.DetallePedidoCompraAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class DetallePedidoCompraLogicAdditional extends DetallePedidoCompraLogic { // implements DetallePedidoCompraAdditionable{
	public  DetallePedidoCompraLogicAdditional(Connexion connexion)throws Exception {
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
	public  DetallePedidoCompraLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDetallePedidoCompraToSave(DetallePedidoCompra detallepedidocompra,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDetallePedidoCompraToSave(DetallePedidoCompra detallepedidocompra,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDetallePedidoCompraToSaveAfter(DetallePedidoCompra detallepedidocompra,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDetallePedidoCompraToSaves(List<DetallePedidoCompra> detallepedidocompras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDetallePedidoCompraToSaves(List<DetallePedidoCompra> detallepedidocompras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDetallePedidoCompraToSavesAfter(List<DetallePedidoCompra> detallepedidocompras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDetallePedidoCompraToGet(DetallePedidoCompra detallepedidocompra,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDetallePedidoCompraToGets(List<DetallePedidoCompra> detallepedidocompras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDetallePedidoCompraToSave(DetallePedidoCompra detallepedidocompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDetallePedidoCompraToGet(DetallePedidoCompra detallepedidocompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDetallePedidoCompraActions(String sTipoJsonResponse,JSONObject jsonObjectDetallePedidoCompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDetallePedidoCompraDataTable(String sTipoJsonResponse,DetallePedidoCompra detallepedidocompra,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDetallePedidoComprasDataTable(String sTipoJsonResponse,List<DetallePedidoCompra> detallepedidocompras,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDetallePedidoCompraColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDetallePedidoComprasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDetallePedidoComprasColumns;
	}
	
	public static void updateJSONArrayDetallePedidoCompraActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDetallePedidoCompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDetallePedidoCompra(DetallePedidoCompra detallepedidocompra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallepedidocompra.setdescripcion(detallepedidocompra.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetallePedidoCompras(List<DetallePedidoCompra> detallepedidocompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetallePedidoCompra detallepedidocompra: detallepedidocompras) {
			detallepedidocompra.setdescripcion(detallepedidocompra.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePedidoCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DetallePedidoCompraConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(DetallePedidoCompraConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(DetallePedidoCompraConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(DetallePedidoCompraConstantesFunciones.IDPERIODO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetallePedidoCompra> detallepedidocompras,DetallePedidoCompra detallepedidocompra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetallePedidoCompra detallepedidocompraAux: detallepedidocompras) {
			if((detallepedidocompraAux.getId()==null && detallepedidocompra.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(detallepedidocompraAux.getId()!=null && detallepedidocompra.getId()!=null){
				if(detallepedidocompraAux.getId().equals(detallepedidocompra.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetallePedidoCompra(List<DetallePedidoCompra> detallepedidocompras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precio_unitario_compraTotal=0.0;
		Double totalTotal=0.0;
	
		for(DetallePedidoCompra detallepedidocompra: detallepedidocompras) {			
			precio_unitario_compraTotal+=detallepedidocompra.getcosto_unitario();
			totalTotal+=detallepedidocompra.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoCompraConstantesFunciones.COSTOUNITARIO);
		datoGeneral.setsDescripcion(DetallePedidoCompraConstantesFunciones.LABEL_COSTOUNITARIO);
		datoGeneral.setdValorDouble(precio_unitario_compraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoCompraConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(DetallePedidoCompraConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(totalTotal);
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