










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.facturacion.business.logic.report;

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
import com.bydan.erp.facturacion.util.report.VentasCajasResumidosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;
////import com.bydan.erp.facturacion.business.interfaces.VentasCajasResumidosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class VentasCajasResumidosLogicAdditional extends VentasCajasResumidosLogic{		
	
	public  VentasCajasResumidosLogicAdditional(Connexion connexion)throws Exception {
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
	public  VentasCajasResumidosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkVentasCajasResumidosToSave(VentasCajasResumidos ventascajasresumidos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkVentasCajasResumidosToSave(VentasCajasResumidos ventascajasresumidos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkVentasCajasResumidosToSaveAfter(VentasCajasResumidos ventascajasresumidos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkVentasCajasResumidosToSaves(List<VentasCajasResumidos> ventascajasresumidoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkVentasCajasResumidosToSaves(List<VentasCajasResumidos> ventascajasresumidoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkVentasCajasResumidosToSavesAfter(List<VentasCajasResumidos> ventascajasresumidoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkVentasCajasResumidosToGet(VentasCajasResumidos ventascajasresumidos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkVentasCajasResumidosToGets(List<VentasCajasResumidos> ventascajasresumidoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateVentasCajasResumidosToSave(VentasCajasResumidos ventascajasresumidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateVentasCajasResumidosToGet(VentasCajasResumidos ventascajasresumidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectVentasCajasResumidosActions(String sTipoJsonResponse,JSONObject jsonObjectVentasCajasResumidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonVentasCajasResumidosDataTable(String sTipoJsonResponse,VentasCajasResumidos ventascajasresumidos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonVentasCajasResumidossDataTable(String sTipoJsonResponse,List<VentasCajasResumidos> ventascajasresumidoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayVentasCajasResumidosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayVentasCajasResumidossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayVentasCajasResumidossColumns;
	}
	
	public static void updateJSONArrayVentasCajasResumidosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectVentasCajasResumidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosVentasCajasResumidos(VentasCajasResumidos ventascajasresumidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ventascajasresumidos.setcodigo(ventascajasresumidos.getcodigo().trim());
		ventascajasresumidos.setnombre_completo(ventascajasresumidos.getnombre_completo().trim());
		ventascajasresumidos.setnumero_pre_impreso(ventascajasresumidos.getnumero_pre_impreso().trim());
		ventascajasresumidos.setnumero_documento(ventascajasresumidos.getnumero_documento().trim());
	}
	
	public static void quitarEspaciosVentasCajasResumidoss(List<VentasCajasResumidos> ventascajasresumidoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VentasCajasResumidos ventascajasresumidos: ventascajasresumidoss) {
			ventascajasresumidos.setcodigo(ventascajasresumidos.getcodigo().trim());
			ventascajasresumidos.setnombre_completo(ventascajasresumidos.getnombre_completo().trim());
			ventascajasresumidos.setnumero_pre_impreso(ventascajasresumidos.getnumero_pre_impreso().trim());
			ventascajasresumidos.setnumero_documento(ventascajasresumidos.getnumero_documento().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasCajasResumidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(VentasCajasResumidosConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(VentasCajasResumidosConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VentasCajasResumidos> ventascajasresumidoss,VentasCajasResumidos ventascajasresumidos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VentasCajasResumidos ventascajasresumidosAux: ventascajasresumidoss) {
			if((ventascajasresumidosAux.getId()==null && ventascajasresumidos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(ventascajasresumidosAux.getId()!=null && ventascajasresumidos.getId()!=null){
				if(ventascajasresumidosAux.getId().equals(ventascajasresumidos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVentasCajasResumidos(List<VentasCajasResumidos> ventascajasresumidoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double totalTotal=0.0;
		Double efectivoTotal=0.0;
		Double tarjetaTotal=0.0;
		Double creditoTotal=0.0;
	
		for(VentasCajasResumidos ventascajasresumidos: ventascajasresumidoss) {			
			totalTotal+=ventascajasresumidos.gettotal();
			efectivoTotal+=ventascajasresumidos.getefectivo();
			tarjetaTotal+=ventascajasresumidos.gettarjeta();
			creditoTotal+=ventascajasresumidos.getcredito();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasCajasResumidosConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(VentasCajasResumidosConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasCajasResumidosConstantesFunciones.EFECTIVO);
		datoGeneral.setsDescripcion(VentasCajasResumidosConstantesFunciones.LABEL_EFECTIVO);
		datoGeneral.setdValorDouble(efectivoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasCajasResumidosConstantesFunciones.TARJETA);
		datoGeneral.setsDescripcion(VentasCajasResumidosConstantesFunciones.LABEL_TARJETA);
		datoGeneral.setdValorDouble(tarjetaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasCajasResumidosConstantesFunciones.CREDITO);
		datoGeneral.setsDescripcion(VentasCajasResumidosConstantesFunciones.LABEL_CREDITO);
		datoGeneral.setdValorDouble(creditoTotal);
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