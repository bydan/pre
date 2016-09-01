










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
import com.bydan.erp.inventario.util.report.PreciosComprasConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;
////import com.bydan.erp.inventario.business.interfaces.PreciosComprasAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class PreciosComprasLogicAdditional extends PreciosComprasLogic{		
	
	public  PreciosComprasLogicAdditional(Connexion connexion)throws Exception {
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
	public  PreciosComprasLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkPreciosComprasToSave(PreciosCompras precioscompras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkPreciosComprasToSave(PreciosCompras precioscompras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkPreciosComprasToSaveAfter(PreciosCompras precioscompras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkPreciosComprasToSaves(List<PreciosCompras> precioscomprass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkPreciosComprasToSaves(List<PreciosCompras> precioscomprass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkPreciosComprasToSavesAfter(List<PreciosCompras> precioscomprass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkPreciosComprasToGet(PreciosCompras precioscompras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkPreciosComprasToGets(List<PreciosCompras> precioscomprass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updatePreciosComprasToSave(PreciosCompras precioscompras,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updatePreciosComprasToGet(PreciosCompras precioscompras,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectPreciosComprasActions(String sTipoJsonResponse,JSONObject jsonObjectPreciosCompras,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonPreciosComprasDataTable(String sTipoJsonResponse,PreciosCompras precioscompras,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonPreciosComprassDataTable(String sTipoJsonResponse,List<PreciosCompras> precioscomprass,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayPreciosComprasColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayPreciosComprassColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayPreciosComprassColumns;
	}
	
	public static void updateJSONArrayPreciosComprasActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectPreciosCompras,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosPreciosCompras(PreciosCompras precioscompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		precioscompras.setnombre_completo_cliente(precioscompras.getnombre_completo_cliente().trim());
		precioscompras.setnumero_comprobante(precioscompras.getnumero_comprobante().trim());
		precioscompras.setnombre_producto(precioscompras.getnombre_producto().trim());
		precioscompras.setcodigo_producto(precioscompras.getcodigo_producto().trim());
	}
	
	public static void quitarEspaciosPreciosComprass(List<PreciosCompras> precioscomprass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PreciosCompras precioscompras: precioscomprass) {
			precioscompras.setnombre_completo_cliente(precioscompras.getnombre_completo_cliente().trim());
			precioscompras.setnumero_comprobante(precioscompras.getnumero_comprobante().trim());
			precioscompras.setnombre_producto(precioscompras.getnombre_producto().trim());
			precioscompras.setcodigo_producto(precioscompras.getcodigo_producto().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPreciosCompras(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(PreciosComprasConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(PreciosComprasConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PreciosCompras> precioscomprass,PreciosCompras precioscompras,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PreciosCompras precioscomprasAux: precioscomprass) {
			if((precioscomprasAux.getId()==null && precioscompras.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(precioscomprasAux.getId()!=null && precioscompras.getId()!=null){
				if(precioscomprasAux.getId().equals(precioscompras.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPreciosCompras(List<PreciosCompras> precioscomprass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costo_unitarioTotal=0.0;
	
		for(PreciosCompras precioscompras: precioscomprass) {			
			costo_unitarioTotal+=precioscompras.getcosto_unitario();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PreciosComprasConstantesFunciones.COSTOUNITARIO);
		datoGeneral.setsDescripcion(PreciosComprasConstantesFunciones.LABEL_COSTOUNITARIO);
		datoGeneral.setdValorDouble(costo_unitarioTotal);
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