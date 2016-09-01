










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
import com.bydan.erp.cartera.util.report.PlaneacionPagosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.PlaneacionPagosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class PlaneacionPagosLogicAdditional extends PlaneacionPagosLogic{		
	
	public  PlaneacionPagosLogicAdditional(Connexion connexion)throws Exception {
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
	public  PlaneacionPagosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkPlaneacionPagosToSave(PlaneacionPagos planeacionpagos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkPlaneacionPagosToSave(PlaneacionPagos planeacionpagos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkPlaneacionPagosToSaveAfter(PlaneacionPagos planeacionpagos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkPlaneacionPagosToSaves(List<PlaneacionPagos> planeacionpagoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkPlaneacionPagosToSaves(List<PlaneacionPagos> planeacionpagoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkPlaneacionPagosToSavesAfter(List<PlaneacionPagos> planeacionpagoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkPlaneacionPagosToGet(PlaneacionPagos planeacionpagos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkPlaneacionPagosToGets(List<PlaneacionPagos> planeacionpagoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updatePlaneacionPagosToSave(PlaneacionPagos planeacionpagos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updatePlaneacionPagosToGet(PlaneacionPagos planeacionpagos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectPlaneacionPagosActions(String sTipoJsonResponse,JSONObject jsonObjectPlaneacionPagos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonPlaneacionPagosDataTable(String sTipoJsonResponse,PlaneacionPagos planeacionpagos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonPlaneacionPagossDataTable(String sTipoJsonResponse,List<PlaneacionPagos> planeacionpagoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayPlaneacionPagosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayPlaneacionPagossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayPlaneacionPagossColumns;
	}
	
	public static void updateJSONArrayPlaneacionPagosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectPlaneacionPagos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosPlaneacionPagos(PlaneacionPagos planeacionpagos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		planeacionpagos.setnombre_cliente(planeacionpagos.getnombre_cliente().trim());
		planeacionpagos.setnumero_factura(planeacionpagos.getnumero_factura().trim());
	}
	
	public static void quitarEspaciosPlaneacionPagoss(List<PlaneacionPagos> planeacionpagoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PlaneacionPagos planeacionpagos: planeacionpagoss) {
			planeacionpagos.setnombre_cliente(planeacionpagos.getnombre_cliente().trim());
			planeacionpagos.setnumero_factura(planeacionpagos.getnumero_factura().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPlaneacionPagos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(PlaneacionPagosConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PlaneacionPagos> planeacionpagoss,PlaneacionPagos planeacionpagos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PlaneacionPagos planeacionpagosAux: planeacionpagoss) {
			if((planeacionpagosAux.getId()==null && planeacionpagos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(planeacionpagosAux.getId()!=null && planeacionpagos.getId()!=null){
				if(planeacionpagosAux.getId().equals(planeacionpagos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPlaneacionPagos(List<PlaneacionPagos> planeacionpagoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double saldoTotal=0.0;
	
		for(PlaneacionPagos planeacionpagos: planeacionpagoss) {			
			saldoTotal+=planeacionpagos.getsaldo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PlaneacionPagosConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(PlaneacionPagosConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
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