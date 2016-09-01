










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
import com.bydan.erp.cartera.util.report.CobrarDetalleCobrosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.CobrarDetalleCobrosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class CobrarDetalleCobrosLogicAdditional extends CobrarDetalleCobrosLogic{		
	
	public  CobrarDetalleCobrosLogicAdditional(Connexion connexion)throws Exception {
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
	public  CobrarDetalleCobrosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCobrarDetalleCobrosToSave(CobrarDetalleCobros cobrardetallecobros,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCobrarDetalleCobrosToSave(CobrarDetalleCobros cobrardetallecobros,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCobrarDetalleCobrosToSaveAfter(CobrarDetalleCobros cobrardetallecobros,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCobrarDetalleCobrosToSaves(List<CobrarDetalleCobros> cobrardetallecobross,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCobrarDetalleCobrosToSaves(List<CobrarDetalleCobros> cobrardetallecobross,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCobrarDetalleCobrosToSavesAfter(List<CobrarDetalleCobros> cobrardetallecobross,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCobrarDetalleCobrosToGet(CobrarDetalleCobros cobrardetallecobros,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCobrarDetalleCobrosToGets(List<CobrarDetalleCobros> cobrardetallecobross,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCobrarDetalleCobrosToSave(CobrarDetalleCobros cobrardetallecobros,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCobrarDetalleCobrosToGet(CobrarDetalleCobros cobrardetallecobros,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCobrarDetalleCobrosActions(String sTipoJsonResponse,JSONObject jsonObjectCobrarDetalleCobros,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCobrarDetalleCobrosDataTable(String sTipoJsonResponse,CobrarDetalleCobros cobrardetallecobros,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCobrarDetalleCobrossDataTable(String sTipoJsonResponse,List<CobrarDetalleCobros> cobrardetallecobross,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCobrarDetalleCobrosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCobrarDetalleCobrossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCobrarDetalleCobrossColumns;
	}
	
	public static void updateJSONArrayCobrarDetalleCobrosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCobrarDetalleCobros,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCobrarDetalleCobros(CobrarDetalleCobros cobrardetallecobros,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrardetallecobros.setnombre_vendedor(cobrardetallecobros.getnombre_vendedor().trim());
		cobrardetallecobros.setcodigo(cobrardetallecobros.getcodigo().trim());
		cobrardetallecobros.setnombre(cobrardetallecobros.getnombre().trim());
		cobrardetallecobros.setapellido(cobrardetallecobros.getapellido().trim());
	}
	
	public static void quitarEspaciosCobrarDetalleCobross(List<CobrarDetalleCobros> cobrardetallecobross,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarDetalleCobros cobrardetallecobros: cobrardetallecobross) {
			cobrardetallecobros.setnombre_vendedor(cobrardetallecobros.getnombre_vendedor().trim());
			cobrardetallecobros.setcodigo(cobrardetallecobros.getcodigo().trim());
			cobrardetallecobros.setnombre(cobrardetallecobros.getnombre().trim());
			cobrardetallecobros.setapellido(cobrardetallecobros.getapellido().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarDetalleCobros(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(CobrarDetalleCobrosConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarDetalleCobros> cobrardetallecobross,CobrarDetalleCobros cobrardetallecobros,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarDetalleCobros cobrardetallecobrosAux: cobrardetallecobross) {
			if((cobrardetallecobrosAux.getId()==null && cobrardetallecobros.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(cobrardetallecobrosAux.getId()!=null && cobrardetallecobros.getId()!=null){
				if(cobrardetallecobrosAux.getId().equals(cobrardetallecobros.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarDetalleCobros(List<CobrarDetalleCobros> cobrardetallecobross) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_facturasTotal=0.0;
		Double total_abonosTotal=0.0;
		Double total_facturas_actualTotal=0.0;
		Double abonos_anteriorTotal=0.0;
		Double abonos_actualTotal=0.0;
	
		for(CobrarDetalleCobros cobrardetallecobros: cobrardetallecobross) {			
			total_facturasTotal+=cobrardetallecobros.gettotal_facturas();
			total_abonosTotal+=cobrardetallecobros.gettotal_abonos();
			total_facturas_actualTotal+=cobrardetallecobros.gettotal_facturas_actual();
			abonos_anteriorTotal+=cobrardetallecobros.getabonos_anterior();
			abonos_actualTotal+=cobrardetallecobros.getabonos_actual();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarDetalleCobrosConstantesFunciones.TOTALFACTURAS);
		datoGeneral.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_TOTALFACTURAS);
		datoGeneral.setdValorDouble(total_facturasTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarDetalleCobrosConstantesFunciones.TOTALABONOS);
		datoGeneral.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_TOTALABONOS);
		datoGeneral.setdValorDouble(total_abonosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarDetalleCobrosConstantesFunciones.TOTALFACTURASACTUAL);
		datoGeneral.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_TOTALFACTURASACTUAL);
		datoGeneral.setdValorDouble(total_facturas_actualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarDetalleCobrosConstantesFunciones.ABONOSANTERIOR);
		datoGeneral.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_ABONOSANTERIOR);
		datoGeneral.setdValorDouble(abonos_anteriorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarDetalleCobrosConstantesFunciones.ABONOSACTUAL);
		datoGeneral.setsDescripcion(CobrarDetalleCobrosConstantesFunciones.LABEL_ABONOSACTUAL);
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