










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.inventario.business.logic.report;

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
import com.bydan.erp.inventario.util.report.MovimientosDetalladosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;
////import com.bydan.erp.inventario.business.interfaces.MovimientosDetalladosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class MovimientosDetalladosLogicAdditional extends MovimientosDetalladosLogic{		
	
	public  MovimientosDetalladosLogicAdditional(Connexion connexion)throws Exception {
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
	public  MovimientosDetalladosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkMovimientosDetalladosToSave(MovimientosDetallados movimientosdetallados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkMovimientosDetalladosToSave(MovimientosDetallados movimientosdetallados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkMovimientosDetalladosToSaveAfter(MovimientosDetallados movimientosdetallados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkMovimientosDetalladosToSaves(List<MovimientosDetallados> movimientosdetalladoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkMovimientosDetalladosToSaves(List<MovimientosDetallados> movimientosdetalladoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkMovimientosDetalladosToSavesAfter(List<MovimientosDetallados> movimientosdetalladoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkMovimientosDetalladosToGet(MovimientosDetallados movimientosdetallados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkMovimientosDetalladosToGets(List<MovimientosDetallados> movimientosdetalladoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateMovimientosDetalladosToSave(MovimientosDetallados movimientosdetallados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateMovimientosDetalladosToGet(MovimientosDetallados movimientosdetallados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectMovimientosDetalladosActions(String sTipoJsonResponse,JSONObject jsonObjectMovimientosDetallados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonMovimientosDetalladosDataTable(String sTipoJsonResponse,MovimientosDetallados movimientosdetallados,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonMovimientosDetalladossDataTable(String sTipoJsonResponse,List<MovimientosDetallados> movimientosdetalladoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayMovimientosDetalladosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayMovimientosDetalladossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayMovimientosDetalladossColumns;
	}
	
	public static void updateJSONArrayMovimientosDetalladosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectMovimientosDetallados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosMovimientosDetallados(MovimientosDetallados movimientosdetallados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		movimientosdetallados.setnombre_sucursal(movimientosdetallados.getnombre_sucursal().trim());
		movimientosdetallados.setnombre_completo_cliente(movimientosdetallados.getnombre_completo_cliente().trim());
		movimientosdetallados.setnombre_transaccion(movimientosdetallados.getnombre_transaccion().trim());
		movimientosdetallados.setnumero_comprobante(movimientosdetallados.getnumero_comprobante().trim());
		movimientosdetallados.setnumero_factura(movimientosdetallados.getnumero_factura().trim());
		movimientosdetallados.setnumero_secuencial(movimientosdetallados.getnumero_secuencial().trim());
		movimientosdetallados.setnombre_producto(movimientosdetallados.getnombre_producto().trim());
		movimientosdetallados.setnombre_unidad(movimientosdetallados.getnombre_unidad().trim());
		movimientosdetallados.setcodigo_producto(movimientosdetallados.getcodigo_producto().trim());
	}
	
	public static void quitarEspaciosMovimientosDetalladoss(List<MovimientosDetallados> movimientosdetalladoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(MovimientosDetallados movimientosdetallados: movimientosdetalladoss) {
			movimientosdetallados.setnombre_sucursal(movimientosdetallados.getnombre_sucursal().trim());
			movimientosdetallados.setnombre_completo_cliente(movimientosdetallados.getnombre_completo_cliente().trim());
			movimientosdetallados.setnombre_transaccion(movimientosdetallados.getnombre_transaccion().trim());
			movimientosdetallados.setnumero_comprobante(movimientosdetallados.getnumero_comprobante().trim());
			movimientosdetallados.setnumero_factura(movimientosdetallados.getnumero_factura().trim());
			movimientosdetallados.setnumero_secuencial(movimientosdetallados.getnumero_secuencial().trim());
			movimientosdetallados.setnombre_producto(movimientosdetallados.getnombre_producto().trim());
			movimientosdetallados.setnombre_unidad(movimientosdetallados.getnombre_unidad().trim());
			movimientosdetallados.setcodigo_producto(movimientosdetallados.getcodigo_producto().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMovimientosDetallados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(MovimientosDetalladosConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(MovimientosDetalladosConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<MovimientosDetallados> movimientosdetalladoss,MovimientosDetallados movimientosdetallados,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(MovimientosDetallados movimientosdetalladosAux: movimientosdetalladoss) {
			if((movimientosdetalladosAux.getId()==null && movimientosdetallados.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(movimientosdetalladosAux.getId()!=null && movimientosdetallados.getId()!=null){
				if(movimientosdetalladosAux.getId().equals(movimientosdetallados.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMovimientosDetallados(List<MovimientosDetallados> movimientosdetalladoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ivaTotal=0.0;
		Double costo_unitarioTotal=0.0;
		Double costo_totalTotal=0.0;
		Double iceTotal=0.0;
	
		for(MovimientosDetallados movimientosdetallados: movimientosdetalladoss) {			
			ivaTotal+=movimientosdetallados.getiva();
			costo_unitarioTotal+=movimientosdetallados.getcosto_unitario();
			costo_totalTotal+=movimientosdetallados.getcosto_total();
			iceTotal+=movimientosdetallados.getice();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientosDetalladosConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientosDetalladosConstantesFunciones.COSTOUNITARIO);
		datoGeneral.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_COSTOUNITARIO);
		datoGeneral.setdValorDouble(costo_unitarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientosDetalladosConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientosDetalladosConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_ICE);
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