













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
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;




import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.EventoGlobalTipo;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.contabilidad.business.logic.FormatoLogicAdditional;
import com.bydan.erp.inventario.util.DetalleOrdenCompraConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleOrdenCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleOrdenCompraReturnGeneral;
//import com.bydan.erp.inventario.util.OrdenCompraReturnGeneral;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.inventario.business.entity.*;
//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.logic.TransaccionLogicAdditional;


@SuppressWarnings("unused")
public class DetalleOrdenCompraLogicAdditional extends DetalleOrdenCompraLogic { // implements DetalleOrdenCompraAdditionable{
	
	public  DetalleOrdenCompraLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19

			 DetalleOrdenCompraParameterReturnGeneral detalleordencompraReturnGeneral=(DetalleOrdenCompraParameterReturnGeneral)generalEntityReturnGeneral;
			 DetalleOrdenCompra detalleordencompra=detalleordencompraReturnGeneral.getDetalleOrdenCompra();;
			 DetalleOrdenCompraLogic detalleordencompraLogic=(DetalleOrdenCompraLogic)generalEntityLogic;
			// DetalleOrdenCompra pedidoDetalleOrdenCompra=(DetalleOrdenCompra)object;
					
			 String sFinalQuery="";
			 Long id_formato=0L;			 
			 Long id_transaccion=0L;
			 
			 //CONTROL_19
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
					&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
					&& sTipo.equals("FORM")) {															
					
					 try {
						 detalleordencompraLogic.getNewConnexionToDeep();
						 
						 detalleordencompra.setid_estado_detalle_orden_compra(1L);
																			 
						 detalleordencompraLogic.commitNewConnexionToDeep();
						 
					 } catch(Exception e) {
						 detalleordencompraLogic.rollbackNewConnexionToDeep();
						 
					 } finally {
						 detalleordencompraLogic.closeNewConnexionToDeep();
					 }
			}
			
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
	public  DetalleOrdenCompraLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDetalleOrdenCompraToSave(DetalleOrdenCompra detalleordencompra,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDetalleOrdenCompraToSave(DetalleOrdenCompra detalleordencompra,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDetalleOrdenCompraToSaveAfter(DetalleOrdenCompra detalleordencompra,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDetalleOrdenCompraToSaves(List<DetalleOrdenCompra> detalleordencompras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDetalleOrdenCompraToSaves(List<DetalleOrdenCompra> detalleordencompras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDetalleOrdenCompraToSavesAfter(List<DetalleOrdenCompra> detalleordencompras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDetalleOrdenCompraToGet(DetalleOrdenCompra detalleordencompra,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDetalleOrdenCompraToGets(List<DetalleOrdenCompra> detalleordencompras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDetalleOrdenCompraToSave(DetalleOrdenCompra detalleordencompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDetalleOrdenCompraToGet(DetalleOrdenCompra detalleordencompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDetalleOrdenCompraActions(String sTipoJsonResponse,JSONObject jsonObjectDetalleOrdenCompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDetalleOrdenCompraDataTable(String sTipoJsonResponse,DetalleOrdenCompra detalleordencompra,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDetalleOrdenComprasDataTable(String sTipoJsonResponse,List<DetalleOrdenCompra> detalleordencompras,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDetalleOrdenCompraColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDetalleOrdenComprasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDetalleOrdenComprasColumns;
	}
	
	public static void updateJSONArrayDetalleOrdenCompraActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDetalleOrdenCompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<DetalleOrdenCompra> detalleordencompras) throws Exception  {
		//CONTROL_16
		Boolean esProcesado=true;
		
		return esProcesado;
	}
	
	
	
	//CONTROL_FUNCION1
	
	
	
	
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