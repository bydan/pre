














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
import com.bydan.erp.activosfijos.util.MovimientoActivoFijoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
//import com.bydan.erp.activosfijos.business.interfaces.MovimientoActivoFijoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class MovimientoActivoFijoLogicAdditional extends MovimientoActivoFijoLogic { // implements MovimientoActivoFijoAdditionable{
	
	public  MovimientoActivoFijoLogicAdditional(Connexion connexion)throws Exception {
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
	public  MovimientoActivoFijoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkMovimientoActivoFijoToSave(MovimientoActivoFijo movimientoactivofijo,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkMovimientoActivoFijoToSave(MovimientoActivoFijo movimientoactivofijo,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkMovimientoActivoFijoToSaveAfter(MovimientoActivoFijo movimientoactivofijo,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkMovimientoActivoFijoToSaves(List<MovimientoActivoFijo> movimientoactivofijos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkMovimientoActivoFijoToSaves(List<MovimientoActivoFijo> movimientoactivofijos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkMovimientoActivoFijoToSavesAfter(List<MovimientoActivoFijo> movimientoactivofijos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkMovimientoActivoFijoToGet(MovimientoActivoFijo movimientoactivofijo,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkMovimientoActivoFijoToGets(List<MovimientoActivoFijo> movimientoactivofijos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateMovimientoActivoFijoToSave(MovimientoActivoFijo movimientoactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateMovimientoActivoFijoToGet(MovimientoActivoFijo movimientoactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectMovimientoActivoFijoActions(String sTipoJsonResponse,JSONObject jsonObjectMovimientoActivoFijo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonMovimientoActivoFijoDataTable(String sTipoJsonResponse,MovimientoActivoFijo movimientoactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonMovimientoActivoFijosDataTable(String sTipoJsonResponse,List<MovimientoActivoFijo> movimientoactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayMovimientoActivoFijoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayMovimientoActivoFijosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayMovimientoActivoFijosColumns;
	}
	
	public static void updateJSONArrayMovimientoActivoFijoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectMovimientoActivoFijo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosMovimientoActivoFijo(MovimientoActivoFijo movimientoactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		movimientoactivofijo.setsecuencial(movimientoactivofijo.getsecuencial().trim());
		movimientoactivofijo.setnumero_documento(movimientoactivofijo.getnumero_documento().trim());
		movimientoactivofijo.setrazon(movimientoactivofijo.getrazon().trim());
		movimientoactivofijo.setdescripcion(movimientoactivofijo.getdescripcion().trim());
	}
	
	public static void quitarEspaciosMovimientoActivoFijos(List<MovimientoActivoFijo> movimientoactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(MovimientoActivoFijo movimientoactivofijo: movimientoactivofijos) {
			movimientoactivofijo.setsecuencial(movimientoactivofijo.getsecuencial().trim());
			movimientoactivofijo.setnumero_documento(movimientoactivofijo.getnumero_documento().trim());
			movimientoactivofijo.setrazon(movimientoactivofijo.getrazon().trim());
			movimientoactivofijo.setdescripcion(movimientoactivofijo.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMovimientoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(MovimientoActivoFijoConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(MovimientoActivoFijoConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(MovimientoActivoFijoConstantesFunciones.IDUSUARIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<MovimientoActivoFijo> movimientoactivofijos,MovimientoActivoFijo movimientoactivofijo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(MovimientoActivoFijo movimientoactivofijoAux: movimientoactivofijos) {
			if((movimientoactivofijoAux.getId()==null && movimientoactivofijo.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(movimientoactivofijoAux.getId()!=null && movimientoactivofijo.getId()!=null){
				if(movimientoactivofijoAux.getId().equals(movimientoactivofijo.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMovimientoActivoFijo(List<MovimientoActivoFijo> movimientoactivofijos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costoTotal=0.0;
		Double depreciacionTotal=0.0;
		Double costo_origenTotal=0.0;
		Double depreciacion_origenTotal=0.0;
	
		for(MovimientoActivoFijo movimientoactivofijo: movimientoactivofijos) {			
			costoTotal+=movimientoactivofijo.getcosto();
			depreciacionTotal+=movimientoactivofijo.getdepreciacion();
			costo_origenTotal+=movimientoactivofijo.getcosto_origen();
			depreciacion_origenTotal+=movimientoactivofijo.getdepreciacion_origen();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoActivoFijoConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoActivoFijoConstantesFunciones.DEPRECIACION);
		datoGeneral.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_DEPRECIACION);
		datoGeneral.setdValorDouble(depreciacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoActivoFijoConstantesFunciones.COSTOORIGEN);
		datoGeneral.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_COSTOORIGEN);
		datoGeneral.setdValorDouble(costo_origenTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoActivoFijoConstantesFunciones.DEPRECIACIONORIGEN);
		datoGeneral.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_DEPRECIACIONORIGEN);
		datoGeneral.setdValorDouble(depreciacion_origenTotal);
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