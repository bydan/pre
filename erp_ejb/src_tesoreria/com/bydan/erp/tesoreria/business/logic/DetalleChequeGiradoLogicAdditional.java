













/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.tesoreria.business.logic;

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
import com.bydan.erp.tesoreria.util.DetalleChequeGiradoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
//import com.bydan.erp.tesoreria.business.interfaces.DetalleChequeGiradoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class DetalleChequeGiradoLogicAdditional extends DetalleChequeGiradoLogic { // implements DetalleChequeGiradoAdditionable{
	
	public  DetalleChequeGiradoLogicAdditional(Connexion connexion)throws Exception {
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
	public  DetalleChequeGiradoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDetalleChequeGiradoToSave(DetalleChequeGirado detallechequegirado,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDetalleChequeGiradoToSave(DetalleChequeGirado detallechequegirado,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDetalleChequeGiradoToSaveAfter(DetalleChequeGirado detallechequegirado,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDetalleChequeGiradoToSaves(List<DetalleChequeGirado> detallechequegirados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDetalleChequeGiradoToSaves(List<DetalleChequeGirado> detallechequegirados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDetalleChequeGiradoToSavesAfter(List<DetalleChequeGirado> detallechequegirados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDetalleChequeGiradoToGet(DetalleChequeGirado detallechequegirado,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDetalleChequeGiradoToGets(List<DetalleChequeGirado> detallechequegirados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDetalleChequeGiradoToSave(DetalleChequeGirado detallechequegirado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDetalleChequeGiradoToGet(DetalleChequeGirado detallechequegirado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDetalleChequeGiradoActions(String sTipoJsonResponse,JSONObject jsonObjectDetalleChequeGirado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDetalleChequeGiradoDataTable(String sTipoJsonResponse,DetalleChequeGirado detallechequegirado,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDetalleChequeGiradosDataTable(String sTipoJsonResponse,List<DetalleChequeGirado> detallechequegirados,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDetalleChequeGiradoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDetalleChequeGiradosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDetalleChequeGiradosColumns;
	}
	
	public static void updateJSONArrayDetalleChequeGiradoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDetalleChequeGirado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDetalleChequeGirado(DetalleChequeGirado detallechequegirado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallechequegirado.setnumero_cheque(detallechequegirado.getnumero_cheque().trim());
		detallechequegirado.setcuenta(detallechequegirado.getcuenta().trim());
		detallechequegirado.setbeneficiario(detallechequegirado.getbeneficiario().trim());
		detallechequegirado.setcodigo(detallechequegirado.getcodigo().trim());
		detallechequegirado.setnombre_banco(detallechequegirado.getnombre_banco().trim());
	}
	
	public static void quitarEspaciosDetalleChequeGirados(List<DetalleChequeGirado> detallechequegirados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleChequeGirado detallechequegirado: detallechequegirados) {
			detallechequegirado.setnumero_cheque(detallechequegirado.getnumero_cheque().trim());
			detallechequegirado.setcuenta(detallechequegirado.getcuenta().trim());
			detallechequegirado.setbeneficiario(detallechequegirado.getbeneficiario().trim());
			detallechequegirado.setcodigo(detallechequegirado.getcodigo().trim());
			detallechequegirado.setnombre_banco(detallechequegirado.getnombre_banco().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleChequeGirado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DetalleChequeGiradoConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(DetalleChequeGiradoConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(DetalleChequeGiradoConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(DetalleChequeGiradoConstantesFunciones.IDPERIODO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleChequeGirado> detallechequegirados,DetalleChequeGirado detallechequegirado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleChequeGirado detallechequegiradoAux: detallechequegirados) {
			if((detallechequegiradoAux.getId()==null && detallechequegirado.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(detallechequegiradoAux.getId()!=null && detallechequegirado.getId()!=null){
				if(detallechequegiradoAux.getId().equals(detallechequegirado.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleChequeGirado(List<DetalleChequeGirado> detallechequegirados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(DetalleChequeGirado detallechequegirado: detallechequegirados) {			
			valorTotal+=detallechequegirado.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleChequeGiradoConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(DetalleChequeGiradoConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
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