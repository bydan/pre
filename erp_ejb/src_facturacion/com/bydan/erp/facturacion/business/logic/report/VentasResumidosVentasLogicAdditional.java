










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
import com.bydan.erp.facturacion.util.report.VentasResumidosVentasConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;
////import com.bydan.erp.facturacion.business.interfaces.VentasResumidosVentasAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class VentasResumidosVentasLogicAdditional extends VentasResumidosVentasLogic{		
	
	public  VentasResumidosVentasLogicAdditional(Connexion connexion)throws Exception {
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
	public  VentasResumidosVentasLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkVentasResumidosVentasToSave(VentasResumidosVentas ventasresumidosventas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkVentasResumidosVentasToSave(VentasResumidosVentas ventasresumidosventas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkVentasResumidosVentasToSaveAfter(VentasResumidosVentas ventasresumidosventas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkVentasResumidosVentasToSaves(List<VentasResumidosVentas> ventasresumidosventass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkVentasResumidosVentasToSaves(List<VentasResumidosVentas> ventasresumidosventass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkVentasResumidosVentasToSavesAfter(List<VentasResumidosVentas> ventasresumidosventass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkVentasResumidosVentasToGet(VentasResumidosVentas ventasresumidosventas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkVentasResumidosVentasToGets(List<VentasResumidosVentas> ventasresumidosventass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateVentasResumidosVentasToSave(VentasResumidosVentas ventasresumidosventas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateVentasResumidosVentasToGet(VentasResumidosVentas ventasresumidosventas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectVentasResumidosVentasActions(String sTipoJsonResponse,JSONObject jsonObjectVentasResumidosVentas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonVentasResumidosVentasDataTable(String sTipoJsonResponse,VentasResumidosVentas ventasresumidosventas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonVentasResumidosVentassDataTable(String sTipoJsonResponse,List<VentasResumidosVentas> ventasresumidosventass,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayVentasResumidosVentasColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayVentasResumidosVentassColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayVentasResumidosVentassColumns;
	}
	
	public static void updateJSONArrayVentasResumidosVentasActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectVentasResumidosVentas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosVentasResumidosVentas(VentasResumidosVentas ventasresumidosventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ventasresumidosventas.setdia(ventasresumidosventas.getdia().trim());
		ventasresumidosventas.setnombre_anio(ventasresumidosventas.getnombre_anio().trim());
		ventasresumidosventas.setnombre_mes(ventasresumidosventas.getnombre_mes().trim());
	}
	
	public static void quitarEspaciosVentasResumidosVentass(List<VentasResumidosVentas> ventasresumidosventass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VentasResumidosVentas ventasresumidosventas: ventasresumidosventass) {
			ventasresumidosventas.setdia(ventasresumidosventas.getdia().trim());
			ventasresumidosventas.setnombre_anio(ventasresumidosventas.getnombre_anio().trim());
			ventasresumidosventas.setnombre_mes(ventasresumidosventas.getnombre_mes().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasResumidosVentas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(VentasResumidosVentasConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VentasResumidosVentas> ventasresumidosventass,VentasResumidosVentas ventasresumidosventas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VentasResumidosVentas ventasresumidosventasAux: ventasresumidosventass) {
			if((ventasresumidosventasAux.getId()==null && ventasresumidosventas.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(ventasresumidosventasAux.getId()!=null && ventasresumidosventas.getId()!=null){
				if(ventasresumidosventasAux.getId().equals(ventasresumidosventas.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVentasResumidosVentas(List<VentasResumidosVentas> ventasresumidosventass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_ivaTotal=0.0;
		Double total_sin_ivaTotal=0.0;
		Double total_fleteTotal=0.0;
		Double ivaTotal=0.0;
	
		for(VentasResumidosVentas ventasresumidosventas: ventasresumidosventass) {			
			total_ivaTotal+=ventasresumidosventas.gettotal_iva();
			total_sin_ivaTotal+=ventasresumidosventas.gettotal_sin_iva();
			total_fleteTotal+=ventasresumidosventas.gettotal_flete();
			ivaTotal+=ventasresumidosventas.getiva();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidosVentasConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(VentasResumidosVentasConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidosVentasConstantesFunciones.TOTALSINIVA);
		datoGeneral.setsDescripcion(VentasResumidosVentasConstantesFunciones.LABEL_TOTALSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidosVentasConstantesFunciones.TOTALFLETE);
		datoGeneral.setsDescripcion(VentasResumidosVentasConstantesFunciones.LABEL_TOTALFLETE);
		datoGeneral.setdValorDouble(total_fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidosVentasConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(VentasResumidosVentasConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
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