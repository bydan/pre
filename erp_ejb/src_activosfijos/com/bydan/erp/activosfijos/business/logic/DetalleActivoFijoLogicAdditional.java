














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.activosfijos.business.logic;

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
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.activosfijos.util.DetalleActivoFijoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
//import com.bydan.erp.activosfijos.business.interfaces.DetalleActivoFijoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class DetalleActivoFijoLogicAdditional extends DetalleActivoFijoLogic { // implements DetalleActivoFijoAdditionable{
	
	public  DetalleActivoFijoLogicAdditional(Connexion connexion)throws Exception {
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


	public static Boolean validarSaveRelaciones(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_20
		Boolean validado=true;

		return validado;	
	}


	public static void updateRelacionesToSave(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}


	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}

	//CONTROL_INICIO
	public  DetalleActivoFijoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDetalleActivoFijoToSave(DetalleActivoFijo detalleactivofijo,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDetalleActivoFijoToSave(DetalleActivoFijo detalleactivofijo,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDetalleActivoFijoToSaveAfter(DetalleActivoFijo detalleactivofijo,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDetalleActivoFijoToSaves(List<DetalleActivoFijo> detalleactivofijos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDetalleActivoFijoToSaves(List<DetalleActivoFijo> detalleactivofijos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDetalleActivoFijoToSavesAfter(List<DetalleActivoFijo> detalleactivofijos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDetalleActivoFijoToGet(DetalleActivoFijo detalleactivofijo,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDetalleActivoFijoToGets(List<DetalleActivoFijo> detalleactivofijos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDetalleActivoFijoToSave(DetalleActivoFijo detalleactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDetalleActivoFijoToGet(DetalleActivoFijo detalleactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDetalleActivoFijoActions(String sTipoJsonResponse,JSONObject jsonObjectDetalleActivoFijo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDetalleActivoFijoDataTable(String sTipoJsonResponse,DetalleActivoFijo detalleactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDetalleActivoFijosDataTable(String sTipoJsonResponse,List<DetalleActivoFijo> detalleactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDetalleActivoFijoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDetalleActivoFijosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDetalleActivoFijosColumns;
	}
	
	public static void updateJSONArrayDetalleActivoFijoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDetalleActivoFijo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDetalleActivoFijo(DetalleActivoFijo detalleactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleactivofijo.setcodigo(detalleactivofijo.getcodigo().trim());
		detalleactivofijo.setnombre(detalleactivofijo.getnombre().trim());
		detalleactivofijo.setserie(detalleactivofijo.getserie().trim());
		detalleactivofijo.setclave(detalleactivofijo.getclave().trim());
		detalleactivofijo.setmarca(detalleactivofijo.getmarca().trim());
		detalleactivofijo.setmodelo(detalleactivofijo.getmodelo().trim());
		detalleactivofijo.setcolor(detalleactivofijo.getcolor().trim());
		detalleactivofijo.setnombre_propietario(detalleactivofijo.getnombre_propietario().trim());
		detalleactivofijo.setresponsable(detalleactivofijo.getresponsable().trim());
		detalleactivofijo.setpath_foto(detalleactivofijo.getpath_foto().trim());
		detalleactivofijo.setnumero_comprobante(detalleactivofijo.getnumero_comprobante().trim());
		detalleactivofijo.setreferencia(detalleactivofijo.getreferencia().trim());
		detalleactivofijo.setpath_foto2(detalleactivofijo.getpath_foto2().trim());
	}
	
	public static void quitarEspaciosDetalleActivoFijos(List<DetalleActivoFijo> detalleactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleActivoFijo detalleactivofijo: detalleactivofijos) {
			detalleactivofijo.setcodigo(detalleactivofijo.getcodigo().trim());
			detalleactivofijo.setnombre(detalleactivofijo.getnombre().trim());
			detalleactivofijo.setserie(detalleactivofijo.getserie().trim());
			detalleactivofijo.setclave(detalleactivofijo.getclave().trim());
			detalleactivofijo.setmarca(detalleactivofijo.getmarca().trim());
			detalleactivofijo.setmodelo(detalleactivofijo.getmodelo().trim());
			detalleactivofijo.setcolor(detalleactivofijo.getcolor().trim());
			detalleactivofijo.setnombre_propietario(detalleactivofijo.getnombre_propietario().trim());
			detalleactivofijo.setresponsable(detalleactivofijo.getresponsable().trim());
			detalleactivofijo.setpath_foto(detalleactivofijo.getpath_foto().trim());
			detalleactivofijo.setnumero_comprobante(detalleactivofijo.getnumero_comprobante().trim());
			detalleactivofijo.setreferencia(detalleactivofijo.getreferencia().trim());
			detalleactivofijo.setpath_foto2(detalleactivofijo.getpath_foto2().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DetalleActivoFijoConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(DetalleActivoFijoConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleActivoFijo> detalleactivofijos,DetalleActivoFijo detalleactivofijo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleActivoFijo detalleactivofijoAux: detalleactivofijos) {
			if((detalleactivofijoAux.getId()==null && detalleactivofijo.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(detalleactivofijoAux.getId()!=null && detalleactivofijo.getId()!=null){
				if(detalleactivofijoAux.getId().equals(detalleactivofijo.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleActivoFijo(List<DetalleActivoFijo> detalleactivofijos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_utilTotal=0.0;
		Double costo_de_compraTotal=0.0;
		Double vida_utilTotal=0.0;
		Double valor_residualTotal=0.0;
		Double valor_cotizacionTotal=0.0;
	
		for(DetalleActivoFijo detalleactivofijo: detalleactivofijos) {			
			valor_utilTotal+=detalleactivofijo.getvalor_util();
			costo_de_compraTotal+=detalleactivofijo.getcosto_de_compra();
			vida_utilTotal+=detalleactivofijo.getvida_util();
			valor_residualTotal+=detalleactivofijo.getvalor_residual();
			valor_cotizacionTotal+=detalleactivofijo.getvalor_cotizacion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleActivoFijoConstantesFunciones.VALORUTIL);
		datoGeneral.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_VALORUTIL);
		datoGeneral.setdValorDouble(valor_utilTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleActivoFijoConstantesFunciones.COSTODECOMPRA);
		datoGeneral.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_COSTODECOMPRA);
		datoGeneral.setdValorDouble(costo_de_compraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleActivoFijoConstantesFunciones.VIDAUTIL);
		datoGeneral.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_VIDAUTIL);
		datoGeneral.setdValorDouble(vida_utilTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleActivoFijoConstantesFunciones.VALORRESIDUAL);
		datoGeneral.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_VALORRESIDUAL);
		datoGeneral.setdValorDouble(valor_residualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleActivoFijoConstantesFunciones.VALORCOTIZACION);
		datoGeneral.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_VALORCOTIZACION);
		datoGeneral.setdValorDouble(valor_cotizacionTotal);
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