










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
import com.bydan.erp.facturacion.util.report.VentasVentasNoCerradasConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;
////import com.bydan.erp.facturacion.business.interfaces.VentasVentasNoCerradasAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class VentasVentasNoCerradasLogicAdditional extends VentasVentasNoCerradasLogic{		
	
	public  VentasVentasNoCerradasLogicAdditional(Connexion connexion)throws Exception {
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
	public  VentasVentasNoCerradasLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkVentasVentasNoCerradasToSave(VentasVentasNoCerradas ventasventasnocerradas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkVentasVentasNoCerradasToSave(VentasVentasNoCerradas ventasventasnocerradas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkVentasVentasNoCerradasToSaveAfter(VentasVentasNoCerradas ventasventasnocerradas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkVentasVentasNoCerradasToSaves(List<VentasVentasNoCerradas> ventasventasnocerradass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkVentasVentasNoCerradasToSaves(List<VentasVentasNoCerradas> ventasventasnocerradass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkVentasVentasNoCerradasToSavesAfter(List<VentasVentasNoCerradas> ventasventasnocerradass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkVentasVentasNoCerradasToGet(VentasVentasNoCerradas ventasventasnocerradas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkVentasVentasNoCerradasToGets(List<VentasVentasNoCerradas> ventasventasnocerradass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateVentasVentasNoCerradasToSave(VentasVentasNoCerradas ventasventasnocerradas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateVentasVentasNoCerradasToGet(VentasVentasNoCerradas ventasventasnocerradas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectVentasVentasNoCerradasActions(String sTipoJsonResponse,JSONObject jsonObjectVentasVentasNoCerradas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonVentasVentasNoCerradasDataTable(String sTipoJsonResponse,VentasVentasNoCerradas ventasventasnocerradas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonVentasVentasNoCerradassDataTable(String sTipoJsonResponse,List<VentasVentasNoCerradas> ventasventasnocerradass,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayVentasVentasNoCerradasColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayVentasVentasNoCerradassColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayVentasVentasNoCerradassColumns;
	}
	
	public static void updateJSONArrayVentasVentasNoCerradasActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectVentasVentasNoCerradas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosVentasVentasNoCerradas(VentasVentasNoCerradas ventasventasnocerradas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ventasventasnocerradas.setcodigo(ventasventasnocerradas.getcodigo().trim());
		ventasventasnocerradas.setnombre_completo(ventasventasnocerradas.getnombre_completo().trim());
		ventasventasnocerradas.setnumero_pre_impreso(ventasventasnocerradas.getnumero_pre_impreso().trim());
		ventasventasnocerradas.setnumero_documento(ventasventasnocerradas.getnumero_documento().trim());
	}
	
	public static void quitarEspaciosVentasVentasNoCerradass(List<VentasVentasNoCerradas> ventasventasnocerradass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VentasVentasNoCerradas ventasventasnocerradas: ventasventasnocerradass) {
			ventasventasnocerradas.setcodigo(ventasventasnocerradas.getcodigo().trim());
			ventasventasnocerradas.setnombre_completo(ventasventasnocerradas.getnombre_completo().trim());
			ventasventasnocerradas.setnumero_pre_impreso(ventasventasnocerradas.getnumero_pre_impreso().trim());
			ventasventasnocerradas.setnumero_documento(ventasventasnocerradas.getnumero_documento().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasVentasNoCerradas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(VentasVentasNoCerradasConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(VentasVentasNoCerradasConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VentasVentasNoCerradas> ventasventasnocerradass,VentasVentasNoCerradas ventasventasnocerradas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VentasVentasNoCerradas ventasventasnocerradasAux: ventasventasnocerradass) {
			if((ventasventasnocerradasAux.getId()==null && ventasventasnocerradas.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(ventasventasnocerradasAux.getId()!=null && ventasventasnocerradas.getId()!=null){
				if(ventasventasnocerradasAux.getId().equals(ventasventasnocerradas.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVentasVentasNoCerradas(List<VentasVentasNoCerradas> ventasventasnocerradass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double totalTotal=0.0;
		Double efectivoTotal=0.0;
	
		for(VentasVentasNoCerradas ventasventasnocerradas: ventasventasnocerradass) {			
			totalTotal+=ventasventasnocerradas.gettotal();
			efectivoTotal+=ventasventasnocerradas.getefectivo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasVentasNoCerradasConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(VentasVentasNoCerradasConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasVentasNoCerradasConstantesFunciones.EFECTIVO);
		datoGeneral.setsDescripcion(VentasVentasNoCerradasConstantesFunciones.LABEL_EFECTIVO);
		datoGeneral.setdValorDouble(efectivoTotal);
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