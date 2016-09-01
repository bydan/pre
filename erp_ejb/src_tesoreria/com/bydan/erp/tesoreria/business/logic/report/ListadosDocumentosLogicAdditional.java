










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.tesoreria.business.logic.report;

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
import com.bydan.erp.tesoreria.util.report.ListadosDocumentosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;
////import com.bydan.erp.tesoreria.business.interfaces.ListadosDocumentosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ListadosDocumentosLogicAdditional extends ListadosDocumentosLogic{		
	
	public  ListadosDocumentosLogicAdditional(Connexion connexion)throws Exception {
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
	public  ListadosDocumentosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkListadosDocumentosToSave(ListadosDocumentos listadosdocumentos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkListadosDocumentosToSave(ListadosDocumentos listadosdocumentos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkListadosDocumentosToSaveAfter(ListadosDocumentos listadosdocumentos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkListadosDocumentosToSaves(List<ListadosDocumentos> listadosdocumentoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkListadosDocumentosToSaves(List<ListadosDocumentos> listadosdocumentoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkListadosDocumentosToSavesAfter(List<ListadosDocumentos> listadosdocumentoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkListadosDocumentosToGet(ListadosDocumentos listadosdocumentos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkListadosDocumentosToGets(List<ListadosDocumentos> listadosdocumentoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateListadosDocumentosToSave(ListadosDocumentos listadosdocumentos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateListadosDocumentosToGet(ListadosDocumentos listadosdocumentos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectListadosDocumentosActions(String sTipoJsonResponse,JSONObject jsonObjectListadosDocumentos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonListadosDocumentosDataTable(String sTipoJsonResponse,ListadosDocumentos listadosdocumentos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonListadosDocumentossDataTable(String sTipoJsonResponse,List<ListadosDocumentos> listadosdocumentoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayListadosDocumentosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayListadosDocumentossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayListadosDocumentossColumns;
	}
	
	public static void updateJSONArrayListadosDocumentosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectListadosDocumentos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosListadosDocumentos(ListadosDocumentos listadosdocumentos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		listadosdocumentos.settipo_movimiento(listadosdocumentos.gettipo_movimiento().trim());
		listadosdocumentos.setcodigo(listadosdocumentos.getcodigo().trim());
		listadosdocumentos.setbeneficiario(listadosdocumentos.getbeneficiario().trim());
		listadosdocumentos.setbeneficiario_cheque(listadosdocumentos.getbeneficiario_cheque().trim());
		listadosdocumentos.setdetalle(listadosdocumentos.getdetalle().trim());
		listadosdocumentos.setnombre_empresa(listadosdocumentos.getnombre_empresa().trim());
		listadosdocumentos.setruc_empresa(listadosdocumentos.getruc_empresa().trim());
		listadosdocumentos.setdireccion_empresa(listadosdocumentos.getdireccion_empresa().trim());
		listadosdocumentos.setnombre_sucursal(listadosdocumentos.getnombre_sucursal().trim());
		listadosdocumentos.setnumero_mayor(listadosdocumentos.getnumero_mayor().trim());
		listadosdocumentos.setnombre_usuario(listadosdocumentos.getnombre_usuario().trim());
		listadosdocumentos.setnumero_cheque(listadosdocumentos.getnumero_cheque().trim());
	}
	
	public static void quitarEspaciosListadosDocumentoss(List<ListadosDocumentos> listadosdocumentoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ListadosDocumentos listadosdocumentos: listadosdocumentoss) {
			listadosdocumentos.settipo_movimiento(listadosdocumentos.gettipo_movimiento().trim());
			listadosdocumentos.setcodigo(listadosdocumentos.getcodigo().trim());
			listadosdocumentos.setbeneficiario(listadosdocumentos.getbeneficiario().trim());
			listadosdocumentos.setbeneficiario_cheque(listadosdocumentos.getbeneficiario_cheque().trim());
			listadosdocumentos.setdetalle(listadosdocumentos.getdetalle().trim());
			listadosdocumentos.setnombre_empresa(listadosdocumentos.getnombre_empresa().trim());
			listadosdocumentos.setruc_empresa(listadosdocumentos.getruc_empresa().trim());
			listadosdocumentos.setdireccion_empresa(listadosdocumentos.getdireccion_empresa().trim());
			listadosdocumentos.setnombre_sucursal(listadosdocumentos.getnombre_sucursal().trim());
			listadosdocumentos.setnumero_mayor(listadosdocumentos.getnumero_mayor().trim());
			listadosdocumentos.setnombre_usuario(listadosdocumentos.getnombre_usuario().trim());
			listadosdocumentos.setnumero_cheque(listadosdocumentos.getnumero_cheque().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesListadosDocumentos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ListadosDocumentosConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(ListadosDocumentosConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(ListadosDocumentosConstantesFunciones.IDEJERCICIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ListadosDocumentos> listadosdocumentoss,ListadosDocumentos listadosdocumentos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ListadosDocumentos listadosdocumentosAux: listadosdocumentoss) {
			if((listadosdocumentosAux.getId()==null && listadosdocumentos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(listadosdocumentosAux.getId()!=null && listadosdocumentos.getId()!=null){
				if(listadosdocumentosAux.getId().equals(listadosdocumentos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaListadosDocumentos(List<ListadosDocumentos> listadosdocumentoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_chequeTotal=0.0;
		Double valorTotal=0.0;
	
		for(ListadosDocumentos listadosdocumentos: listadosdocumentoss) {			
			valor_chequeTotal+=listadosdocumentos.getvalor_cheque();
			valorTotal+=listadosdocumentos.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ListadosDocumentosConstantesFunciones.VALORCHEQUE);
		datoGeneral.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_VALORCHEQUE);
		datoGeneral.setdValorDouble(valor_chequeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ListadosDocumentosConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_VALOR);
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