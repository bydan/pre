










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.cartera.business.logic.report;

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
import com.bydan.erp.cartera.util.report.DetallePagosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.DetallePagosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class DetallePagosLogicAdditional extends DetallePagosLogic{		
	
	public  DetallePagosLogicAdditional(Connexion connexion)throws Exception {
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
	public  DetallePagosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDetallePagosToSave(DetallePagos detallepagos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDetallePagosToSave(DetallePagos detallepagos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDetallePagosToSaveAfter(DetallePagos detallepagos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDetallePagosToSaves(List<DetallePagos> detallepagoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDetallePagosToSaves(List<DetallePagos> detallepagoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDetallePagosToSavesAfter(List<DetallePagos> detallepagoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDetallePagosToGet(DetallePagos detallepagos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDetallePagosToGets(List<DetallePagos> detallepagoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDetallePagosToSave(DetallePagos detallepagos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDetallePagosToGet(DetallePagos detallepagos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDetallePagosActions(String sTipoJsonResponse,JSONObject jsonObjectDetallePagos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDetallePagosDataTable(String sTipoJsonResponse,DetallePagos detallepagos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDetallePagossDataTable(String sTipoJsonResponse,List<DetallePagos> detallepagoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDetallePagosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDetallePagossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDetallePagossColumns;
	}
	
	public static void updateJSONArrayDetallePagosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDetallePagos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDetallePagos(DetallePagos detallepagos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallepagos.setcodigo(detallepagos.getcodigo().trim());
		detallepagos.setnombre_cliente(detallepagos.getnombre_cliente().trim());
		detallepagos.setruc(detallepagos.getruc().trim());
	}
	
	public static void quitarEspaciosDetallePagoss(List<DetallePagos> detallepagoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetallePagos detallepagos: detallepagoss) {
			detallepagos.setcodigo(detallepagos.getcodigo().trim());
			detallepagos.setnombre_cliente(detallepagos.getnombre_cliente().trim());
			detallepagos.setruc(detallepagos.getruc().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePagos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DetallePagosConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetallePagos> detallepagoss,DetallePagos detallepagos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetallePagos detallepagosAux: detallepagoss) {
			if((detallepagosAux.getId()==null && detallepagos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(detallepagosAux.getId()!=null && detallepagos.getId()!=null){
				if(detallepagosAux.getId().equals(detallepagos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetallePagos(List<DetallePagos> detallepagoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_facturasTotal=0.0;
		Double total_abonosTotal=0.0;
		Double total_facturas_actualTotal=0.0;
		Double abonos_anteriorTotal=0.0;
		Double abonos_actualTotal=0.0;
	
		for(DetallePagos detallepagos: detallepagoss) {			
			total_facturasTotal+=detallepagos.gettotal_facturas();
			total_abonosTotal+=detallepagos.gettotal_abonos();
			total_facturas_actualTotal+=detallepagos.gettotal_facturas_actual();
			abonos_anteriorTotal+=detallepagos.getabonos_anterior();
			abonos_actualTotal+=detallepagos.getabonos_actual();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePagosConstantesFunciones.TOTALFACTURAS);
		datoGeneral.setsDescripcion(DetallePagosConstantesFunciones.LABEL_TOTALFACTURAS);
		datoGeneral.setdValorDouble(total_facturasTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePagosConstantesFunciones.TOTALABONOS);
		datoGeneral.setsDescripcion(DetallePagosConstantesFunciones.LABEL_TOTALABONOS);
		datoGeneral.setdValorDouble(total_abonosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePagosConstantesFunciones.TOTALFACTURASACTUAL);
		datoGeneral.setsDescripcion(DetallePagosConstantesFunciones.LABEL_TOTALFACTURASACTUAL);
		datoGeneral.setdValorDouble(total_facturas_actualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePagosConstantesFunciones.ABONOSANTERIOR);
		datoGeneral.setsDescripcion(DetallePagosConstantesFunciones.LABEL_ABONOSANTERIOR);
		datoGeneral.setdValorDouble(abonos_anteriorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePagosConstantesFunciones.ABONOSACTUAL);
		datoGeneral.setsDescripcion(DetallePagosConstantesFunciones.LABEL_ABONOSACTUAL);
		datoGeneral.setdValorDouble(abonos_actualTotal);
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