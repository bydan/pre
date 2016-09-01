










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
import com.bydan.erp.cartera.util.report.ListadoMovimientosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.ListadoMovimientosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ListadoMovimientosLogicAdditional extends ListadoMovimientosLogic{		
	
	public  ListadoMovimientosLogicAdditional(Connexion connexion)throws Exception {
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
	public  ListadoMovimientosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkListadoMovimientosToSave(ListadoMovimientos listadomovimientos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkListadoMovimientosToSave(ListadoMovimientos listadomovimientos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkListadoMovimientosToSaveAfter(ListadoMovimientos listadomovimientos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkListadoMovimientosToSaves(List<ListadoMovimientos> listadomovimientoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkListadoMovimientosToSaves(List<ListadoMovimientos> listadomovimientoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkListadoMovimientosToSavesAfter(List<ListadoMovimientos> listadomovimientoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkListadoMovimientosToGet(ListadoMovimientos listadomovimientos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkListadoMovimientosToGets(List<ListadoMovimientos> listadomovimientoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateListadoMovimientosToSave(ListadoMovimientos listadomovimientos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateListadoMovimientosToGet(ListadoMovimientos listadomovimientos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectListadoMovimientosActions(String sTipoJsonResponse,JSONObject jsonObjectListadoMovimientos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonListadoMovimientosDataTable(String sTipoJsonResponse,ListadoMovimientos listadomovimientos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonListadoMovimientossDataTable(String sTipoJsonResponse,List<ListadoMovimientos> listadomovimientoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayListadoMovimientosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayListadoMovimientossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayListadoMovimientossColumns;
	}
	
	public static void updateJSONArrayListadoMovimientosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectListadoMovimientos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosListadoMovimientos(ListadoMovimientos listadomovimientos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		listadomovimientos.setnombre_transaccion(listadomovimientos.getnombre_transaccion().trim());
		listadomovimientos.setnumero_comprobante(listadomovimientos.getnumero_comprobante().trim());
		listadomovimientos.setnombre_cliente(listadomovimientos.getnombre_cliente().trim());
		listadomovimientos.setdescripcion(listadomovimientos.getdescripcion().trim());
	}
	
	public static void quitarEspaciosListadoMovimientoss(List<ListadoMovimientos> listadomovimientoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ListadoMovimientos listadomovimientos: listadomovimientoss) {
			listadomovimientos.setnombre_transaccion(listadomovimientos.getnombre_transaccion().trim());
			listadomovimientos.setnumero_comprobante(listadomovimientos.getnumero_comprobante().trim());
			listadomovimientos.setnombre_cliente(listadomovimientos.getnombre_cliente().trim());
			listadomovimientos.setdescripcion(listadomovimientos.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesListadoMovimientos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ListadoMovimientosConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ListadoMovimientos> listadomovimientoss,ListadoMovimientos listadomovimientos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ListadoMovimientos listadomovimientosAux: listadomovimientoss) {
			if((listadomovimientosAux.getId()==null && listadomovimientos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(listadomovimientosAux.getId()!=null && listadomovimientos.getId()!=null){
				if(listadomovimientosAux.getId().equals(listadomovimientos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaListadoMovimientos(List<ListadoMovimientos> listadomovimientoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_mone_localTotal=0.0;
		Double credito_mone_localTotal=0.0;
	
		for(ListadoMovimientos listadomovimientos: listadomovimientoss) {			
			debito_mone_localTotal+=listadomovimientos.getdebito_mone_local();
			credito_mone_localTotal+=listadomovimientos.getcredito_mone_local();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ListadoMovimientosConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(ListadoMovimientosConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ListadoMovimientosConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(ListadoMovimientosConstantesFunciones.LABEL_CREDITOMONELOCAL);
		datoGeneral.setdValorDouble(credito_mone_localTotal);
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