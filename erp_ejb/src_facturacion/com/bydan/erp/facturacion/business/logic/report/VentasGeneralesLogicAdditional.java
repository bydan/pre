










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
import com.bydan.erp.facturacion.util.report.VentasGeneralesConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;
////import com.bydan.erp.facturacion.business.interfaces.VentasGeneralesAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class VentasGeneralesLogicAdditional extends VentasGeneralesLogic{		
	
	public  VentasGeneralesLogicAdditional(Connexion connexion)throws Exception {
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
	public  VentasGeneralesLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkVentasGeneralesToSave(VentasGenerales ventasgenerales,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkVentasGeneralesToSave(VentasGenerales ventasgenerales,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkVentasGeneralesToSaveAfter(VentasGenerales ventasgenerales,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkVentasGeneralesToSaves(List<VentasGenerales> ventasgeneraless,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkVentasGeneralesToSaves(List<VentasGenerales> ventasgeneraless,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkVentasGeneralesToSavesAfter(List<VentasGenerales> ventasgeneraless,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkVentasGeneralesToGet(VentasGenerales ventasgenerales,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkVentasGeneralesToGets(List<VentasGenerales> ventasgeneraless,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateVentasGeneralesToSave(VentasGenerales ventasgenerales,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateVentasGeneralesToGet(VentasGenerales ventasgenerales,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectVentasGeneralesActions(String sTipoJsonResponse,JSONObject jsonObjectVentasGenerales,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonVentasGeneralesDataTable(String sTipoJsonResponse,VentasGenerales ventasgenerales,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonVentasGeneralessDataTable(String sTipoJsonResponse,List<VentasGenerales> ventasgeneraless,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayVentasGeneralesColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayVentasGeneralessColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayVentasGeneralessColumns;
	}
	
	public static void updateJSONArrayVentasGeneralesActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectVentasGenerales,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosVentasGenerales(VentasGenerales ventasgenerales,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ventasgenerales.setnombre_producto(ventasgenerales.getnombre_producto().trim());
		ventasgenerales.setcodigo_producto(ventasgenerales.getcodigo_producto().trim());
		ventasgenerales.settipo(ventasgenerales.gettipo().trim());
	}
	
	public static void quitarEspaciosVentasGeneraless(List<VentasGenerales> ventasgeneraless,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VentasGenerales ventasgenerales: ventasgeneraless) {
			ventasgenerales.setnombre_producto(ventasgenerales.getnombre_producto().trim());
			ventasgenerales.setcodigo_producto(ventasgenerales.getcodigo_producto().trim());
			ventasgenerales.settipo(ventasgenerales.gettipo().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasGenerales(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(VentasGeneralesConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VentasGenerales> ventasgeneraless,VentasGenerales ventasgenerales,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VentasGenerales ventasgeneralesAux: ventasgeneraless) {
			if((ventasgeneralesAux.getId()==null && ventasgenerales.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(ventasgeneralesAux.getId()!=null && ventasgenerales.getId()!=null){
				if(ventasgeneralesAux.getId().equals(ventasgenerales.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVentasGenerales(List<VentasGenerales> ventasgeneraless) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double montoTotal=0.0;
		Double notas_creditoTotal=0.0;
		Double venta_netaTotal=0.0;
		Double porcentajeTotal=0.0;
		Double acumuladoTotal=0.0;
	
		for(VentasGenerales ventasgenerales: ventasgeneraless) {			
			montoTotal+=ventasgenerales.getmonto();
			notas_creditoTotal+=ventasgenerales.getnotas_credito();
			venta_netaTotal+=ventasgenerales.getventa_neta();
			porcentajeTotal+=ventasgenerales.getporcentaje();
			acumuladoTotal+=ventasgenerales.getacumulado();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasGeneralesConstantesFunciones.MONTO);
		datoGeneral.setsDescripcion(VentasGeneralesConstantesFunciones.LABEL_MONTO);
		datoGeneral.setdValorDouble(montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasGeneralesConstantesFunciones.NOTASCREDITO);
		datoGeneral.setsDescripcion(VentasGeneralesConstantesFunciones.LABEL_NOTASCREDITO);
		datoGeneral.setdValorDouble(notas_creditoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasGeneralesConstantesFunciones.VENTANETA);
		datoGeneral.setsDescripcion(VentasGeneralesConstantesFunciones.LABEL_VENTANETA);
		datoGeneral.setdValorDouble(venta_netaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasGeneralesConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(VentasGeneralesConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasGeneralesConstantesFunciones.ACUMULADO);
		datoGeneral.setsDescripcion(VentasGeneralesConstantesFunciones.LABEL_ACUMULADO);
		datoGeneral.setdValorDouble(acumuladoTotal);
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