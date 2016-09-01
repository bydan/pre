










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.puntoventa.business.logic.report;

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
import com.bydan.erp.puntoventa.util.report.EstadisticaProductosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;
////import com.bydan.erp.puntoventa.business.interfaces.EstadisticaProductosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class EstadisticaProductosLogicAdditional extends EstadisticaProductosLogic{		
	
	public  EstadisticaProductosLogicAdditional(Connexion connexion)throws Exception {
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
	public  EstadisticaProductosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkEstadisticaProductosToSave(EstadisticaProductos estadisticaproductos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkEstadisticaProductosToSave(EstadisticaProductos estadisticaproductos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkEstadisticaProductosToSaveAfter(EstadisticaProductos estadisticaproductos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkEstadisticaProductosToSaves(List<EstadisticaProductos> estadisticaproductoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkEstadisticaProductosToSaves(List<EstadisticaProductos> estadisticaproductoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkEstadisticaProductosToSavesAfter(List<EstadisticaProductos> estadisticaproductoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkEstadisticaProductosToGet(EstadisticaProductos estadisticaproductos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkEstadisticaProductosToGets(List<EstadisticaProductos> estadisticaproductoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateEstadisticaProductosToSave(EstadisticaProductos estadisticaproductos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateEstadisticaProductosToGet(EstadisticaProductos estadisticaproductos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectEstadisticaProductosActions(String sTipoJsonResponse,JSONObject jsonObjectEstadisticaProductos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonEstadisticaProductosDataTable(String sTipoJsonResponse,EstadisticaProductos estadisticaproductos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonEstadisticaProductossDataTable(String sTipoJsonResponse,List<EstadisticaProductos> estadisticaproductoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayEstadisticaProductosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayEstadisticaProductossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayEstadisticaProductossColumns;
	}
	
	public static void updateJSONArrayEstadisticaProductosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectEstadisticaProductos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosEstadisticaProductos(EstadisticaProductos estadisticaproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadisticaproductos.setcodigo_producto(estadisticaproductos.getcodigo_producto().trim());
		estadisticaproductos.setnombre_producto(estadisticaproductos.getnombre_producto().trim());
	}
	
	public static void quitarEspaciosEstadisticaProductoss(List<EstadisticaProductos> estadisticaproductoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadisticaProductos estadisticaproductos: estadisticaproductoss) {
			estadisticaproductos.setcodigo_producto(estadisticaproductos.getcodigo_producto().trim());
			estadisticaproductos.setnombre_producto(estadisticaproductos.getnombre_producto().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadisticaProductos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(EstadisticaProductosConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(EstadisticaProductosConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadisticaProductos> estadisticaproductoss,EstadisticaProductos estadisticaproductos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadisticaProductos estadisticaproductosAux: estadisticaproductoss) {
			if((estadisticaproductosAux.getId()==null && estadisticaproductos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(estadisticaproductosAux.getId()!=null && estadisticaproductos.getId()!=null){
				if(estadisticaproductosAux.getId().equals(estadisticaproductos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadisticaProductos(List<EstadisticaProductos> estadisticaproductoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double cantidad_precioTotal=0.0;
	
		for(EstadisticaProductos estadisticaproductos: estadisticaproductoss) {			
			cantidad_precioTotal+=estadisticaproductos.getcantidad_precio();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EstadisticaProductosConstantesFunciones.CANTIDADPRECIO);
		datoGeneral.setsDescripcion(EstadisticaProductosConstantesFunciones.LABEL_CANTIDADPRECIO);
		datoGeneral.setdValorDouble(cantidad_precioTotal);
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