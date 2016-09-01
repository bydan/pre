










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
import com.bydan.erp.facturacion.util.report.VentasCanalesConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;
////import com.bydan.erp.facturacion.business.interfaces.VentasCanalesAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class VentasCanalesLogicAdditional extends VentasCanalesLogic{		
	
	public  VentasCanalesLogicAdditional(Connexion connexion)throws Exception {
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
	public  VentasCanalesLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkVentasCanalesToSave(VentasCanales ventascanales,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkVentasCanalesToSave(VentasCanales ventascanales,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkVentasCanalesToSaveAfter(VentasCanales ventascanales,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkVentasCanalesToSaves(List<VentasCanales> ventascanaless,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkVentasCanalesToSaves(List<VentasCanales> ventascanaless,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkVentasCanalesToSavesAfter(List<VentasCanales> ventascanaless,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkVentasCanalesToGet(VentasCanales ventascanales,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkVentasCanalesToGets(List<VentasCanales> ventascanaless,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateVentasCanalesToSave(VentasCanales ventascanales,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateVentasCanalesToGet(VentasCanales ventascanales,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectVentasCanalesActions(String sTipoJsonResponse,JSONObject jsonObjectVentasCanales,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonVentasCanalesDataTable(String sTipoJsonResponse,VentasCanales ventascanales,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonVentasCanalessDataTable(String sTipoJsonResponse,List<VentasCanales> ventascanaless,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayVentasCanalesColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayVentasCanalessColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayVentasCanalessColumns;
	}
	
	public static void updateJSONArrayVentasCanalesActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectVentasCanales,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosVentasCanales(VentasCanales ventascanales,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ventascanales.setnombre_titulo_cliente(ventascanales.getnombre_titulo_cliente().trim());
		ventascanales.setcodigo_titulo_cliente(ventascanales.getcodigo_titulo_cliente().trim());
		ventascanales.settipo(ventascanales.gettipo().trim());
	}
	
	public static void quitarEspaciosVentasCanaless(List<VentasCanales> ventascanaless,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VentasCanales ventascanales: ventascanaless) {
			ventascanales.setnombre_titulo_cliente(ventascanales.getnombre_titulo_cliente().trim());
			ventascanales.setcodigo_titulo_cliente(ventascanales.getcodigo_titulo_cliente().trim());
			ventascanales.settipo(ventascanales.gettipo().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasCanales(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(VentasCanalesConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VentasCanales> ventascanaless,VentasCanales ventascanales,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VentasCanales ventascanalesAux: ventascanaless) {
			if((ventascanalesAux.getId()==null && ventascanales.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(ventascanalesAux.getId()!=null && ventascanales.getId()!=null){
				if(ventascanalesAux.getId().equals(ventascanales.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVentasCanales(List<VentasCanales> ventascanaless) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double montoTotal=0.0;
		Double notas_creditoTotal=0.0;
		Double venta_netaTotal=0.0;
		Double porcentajeTotal=0.0;
		Double acumuladoTotal=0.0;
	
		for(VentasCanales ventascanales: ventascanaless) {			
			montoTotal+=ventascanales.getmonto();
			notas_creditoTotal+=ventascanales.getnotas_credito();
			venta_netaTotal+=ventascanales.getventa_neta();
			porcentajeTotal+=ventascanales.getporcentaje();
			acumuladoTotal+=ventascanales.getacumulado();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasCanalesConstantesFunciones.MONTO);
		datoGeneral.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_MONTO);
		datoGeneral.setdValorDouble(montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasCanalesConstantesFunciones.NOTASCREDITO);
		datoGeneral.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_NOTASCREDITO);
		datoGeneral.setdValorDouble(notas_creditoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasCanalesConstantesFunciones.VENTANETA);
		datoGeneral.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_VENTANETA);
		datoGeneral.setdValorDouble(venta_netaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasCanalesConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasCanalesConstantesFunciones.ACUMULADO);
		datoGeneral.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_ACUMULADO);
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