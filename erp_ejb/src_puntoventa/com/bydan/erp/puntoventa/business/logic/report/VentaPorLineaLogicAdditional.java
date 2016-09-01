










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
import com.bydan.erp.puntoventa.util.report.VentaPorLineaConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;
////import com.bydan.erp.puntoventa.business.interfaces.VentaPorLineaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class VentaPorLineaLogicAdditional extends VentaPorLineaLogic{		
	
	public  VentaPorLineaLogicAdditional(Connexion connexion)throws Exception {
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
	public  VentaPorLineaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkVentaPorLineaToSave(VentaPorLinea ventaporlinea,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkVentaPorLineaToSave(VentaPorLinea ventaporlinea,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkVentaPorLineaToSaveAfter(VentaPorLinea ventaporlinea,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkVentaPorLineaToSaves(List<VentaPorLinea> ventaporlineas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkVentaPorLineaToSaves(List<VentaPorLinea> ventaporlineas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkVentaPorLineaToSavesAfter(List<VentaPorLinea> ventaporlineas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkVentaPorLineaToGet(VentaPorLinea ventaporlinea,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkVentaPorLineaToGets(List<VentaPorLinea> ventaporlineas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateVentaPorLineaToSave(VentaPorLinea ventaporlinea,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateVentaPorLineaToGet(VentaPorLinea ventaporlinea,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectVentaPorLineaActions(String sTipoJsonResponse,JSONObject jsonObjectVentaPorLinea,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonVentaPorLineaDataTable(String sTipoJsonResponse,VentaPorLinea ventaporlinea,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonVentaPorLineasDataTable(String sTipoJsonResponse,List<VentaPorLinea> ventaporlineas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayVentaPorLineaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayVentaPorLineasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayVentaPorLineasColumns;
	}
	
	public static void updateJSONArrayVentaPorLineaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectVentaPorLinea,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosVentaPorLinea(VentaPorLinea ventaporlinea,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ventaporlinea.setnombre_producto(ventaporlinea.getnombre_producto().trim());
		ventaporlinea.setnombre_linea(ventaporlinea.getnombre_linea().trim());
		ventaporlinea.setnombre_grupo(ventaporlinea.getnombre_grupo().trim());
		ventaporlinea.setnombre_categoria(ventaporlinea.getnombre_categoria().trim());
		ventaporlinea.setnombre_marca(ventaporlinea.getnombre_marca().trim());
		ventaporlinea.setsecuencial(ventaporlinea.getsecuencial().trim());
	}
	
	public static void quitarEspaciosVentaPorLineas(List<VentaPorLinea> ventaporlineas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VentaPorLinea ventaporlinea: ventaporlineas) {
			ventaporlinea.setnombre_producto(ventaporlinea.getnombre_producto().trim());
			ventaporlinea.setnombre_linea(ventaporlinea.getnombre_linea().trim());
			ventaporlinea.setnombre_grupo(ventaporlinea.getnombre_grupo().trim());
			ventaporlinea.setnombre_categoria(ventaporlinea.getnombre_categoria().trim());
			ventaporlinea.setnombre_marca(ventaporlinea.getnombre_marca().trim());
			ventaporlinea.setsecuencial(ventaporlinea.getsecuencial().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVentaPorLinea(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(VentaPorLineaConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(VentaPorLineaConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VentaPorLinea> ventaporlineas,VentaPorLinea ventaporlinea,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VentaPorLinea ventaporlineaAux: ventaporlineas) {
			if((ventaporlineaAux.getId()==null && ventaporlinea.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(ventaporlineaAux.getId()!=null && ventaporlinea.getId()!=null){
				if(ventaporlineaAux.getId().equals(ventaporlinea.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVentaPorLinea(List<VentaPorLinea> ventaporlineas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double cantidadTotal=0.0;
		Double precioTotal=0.0;
		Double descuentoTotal=0.0;
		Double ivaTotal=0.0;
		Double iceTotal=0.0;
	
		for(VentaPorLinea ventaporlinea: ventaporlineas) {			
			cantidadTotal+=ventaporlinea.getcantidad();
			precioTotal+=ventaporlinea.getprecio();
			descuentoTotal+=ventaporlinea.getdescuento();
			ivaTotal+=ventaporlinea.getiva();
			iceTotal+=ventaporlinea.getice();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentaPorLineaConstantesFunciones.CANTIDAD);
		datoGeneral.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_CANTIDAD);
		datoGeneral.setdValorDouble(cantidadTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentaPorLineaConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentaPorLineaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentaPorLineaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentaPorLineaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
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