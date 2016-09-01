










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.activosfijos.business.logic.report;

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
import com.bydan.erp.activosfijos.util.report.ActivosFijosPorGruposConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.report.*;
////import com.bydan.erp.activosfijos.business.interfaces.ActivosFijosPorGruposAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ActivosFijosPorGruposLogicAdditional extends ActivosFijosPorGruposLogic{		
	
	public  ActivosFijosPorGruposLogicAdditional(Connexion connexion)throws Exception {
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
	public  ActivosFijosPorGruposLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkActivosFijosPorGruposToSave(ActivosFijosPorGrupos activosfijosporgrupos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkActivosFijosPorGruposToSave(ActivosFijosPorGrupos activosfijosporgrupos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkActivosFijosPorGruposToSaveAfter(ActivosFijosPorGrupos activosfijosporgrupos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkActivosFijosPorGruposToSaves(List<ActivosFijosPorGrupos> activosfijosporgruposs,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkActivosFijosPorGruposToSaves(List<ActivosFijosPorGrupos> activosfijosporgruposs,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkActivosFijosPorGruposToSavesAfter(List<ActivosFijosPorGrupos> activosfijosporgruposs,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkActivosFijosPorGruposToGet(ActivosFijosPorGrupos activosfijosporgrupos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkActivosFijosPorGruposToGets(List<ActivosFijosPorGrupos> activosfijosporgruposs,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateActivosFijosPorGruposToSave(ActivosFijosPorGrupos activosfijosporgrupos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateActivosFijosPorGruposToGet(ActivosFijosPorGrupos activosfijosporgrupos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectActivosFijosPorGruposActions(String sTipoJsonResponse,JSONObject jsonObjectActivosFijosPorGrupos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonActivosFijosPorGruposDataTable(String sTipoJsonResponse,ActivosFijosPorGrupos activosfijosporgrupos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonActivosFijosPorGrupossDataTable(String sTipoJsonResponse,List<ActivosFijosPorGrupos> activosfijosporgruposs,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayActivosFijosPorGruposColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayActivosFijosPorGrupossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayActivosFijosPorGrupossColumns;
	}
	
	public static void updateJSONArrayActivosFijosPorGruposActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectActivosFijosPorGrupos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosActivosFijosPorGrupos(ActivosFijosPorGrupos activosfijosporgrupos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		activosfijosporgrupos.setcodigo_sub_grupo(activosfijosporgrupos.getcodigo_sub_grupo().trim());
		activosfijosporgrupos.setnombre_sub_grupo(activosfijosporgrupos.getnombre_sub_grupo().trim());
		activosfijosporgrupos.setcodigo_detalle_grupo(activosfijosporgrupos.getcodigo_detalle_grupo().trim());
		activosfijosporgrupos.setnombre_detalle_grupo(activosfijosporgrupos.getnombre_detalle_grupo().trim());
		activosfijosporgrupos.setclave(activosfijosporgrupos.getclave().trim());
		activosfijosporgrupos.setnombre(activosfijosporgrupos.getnombre().trim());
		activosfijosporgrupos.setmarca(activosfijosporgrupos.getmarca().trim());
		activosfijosporgrupos.setmodelo(activosfijosporgrupos.getmodelo().trim());
		activosfijosporgrupos.setcolor(activosfijosporgrupos.getcolor().trim());
		activosfijosporgrupos.setserie(activosfijosporgrupos.getserie().trim());
	}
	
	public static void quitarEspaciosActivosFijosPorGruposs(List<ActivosFijosPorGrupos> activosfijosporgruposs,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ActivosFijosPorGrupos activosfijosporgrupos: activosfijosporgruposs) {
			activosfijosporgrupos.setcodigo_sub_grupo(activosfijosporgrupos.getcodigo_sub_grupo().trim());
			activosfijosporgrupos.setnombre_sub_grupo(activosfijosporgrupos.getnombre_sub_grupo().trim());
			activosfijosporgrupos.setcodigo_detalle_grupo(activosfijosporgrupos.getcodigo_detalle_grupo().trim());
			activosfijosporgrupos.setnombre_detalle_grupo(activosfijosporgrupos.getnombre_detalle_grupo().trim());
			activosfijosporgrupos.setclave(activosfijosporgrupos.getclave().trim());
			activosfijosporgrupos.setnombre(activosfijosporgrupos.getnombre().trim());
			activosfijosporgrupos.setmarca(activosfijosporgrupos.getmarca().trim());
			activosfijosporgrupos.setmodelo(activosfijosporgrupos.getmodelo().trim());
			activosfijosporgrupos.setcolor(activosfijosporgrupos.getcolor().trim());
			activosfijosporgrupos.setserie(activosfijosporgrupos.getserie().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesActivosFijosPorGrupos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ActivosFijosPorGruposConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(ActivosFijosPorGruposConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ActivosFijosPorGrupos> activosfijosporgruposs,ActivosFijosPorGrupos activosfijosporgrupos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ActivosFijosPorGrupos activosfijosporgruposAux: activosfijosporgruposs) {
			if((activosfijosporgruposAux.getId()==null && activosfijosporgrupos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(activosfijosporgruposAux.getId()!=null && activosfijosporgrupos.getId()!=null){
				if(activosfijosporgruposAux.getId().equals(activosfijosporgrupos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaActivosFijosPorGrupos(List<ActivosFijosPorGrupos> activosfijosporgruposs) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double vida_utilTotal=0.0;
		Double costo_de_compraTotal=0.0;
	
		for(ActivosFijosPorGrupos activosfijosporgrupos: activosfijosporgruposs) {			
			vida_utilTotal+=activosfijosporgrupos.getvida_util();
			costo_de_compraTotal+=activosfijosporgrupos.getcosto_de_compra();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ActivosFijosPorGruposConstantesFunciones.VIDAUTIL);
		datoGeneral.setsDescripcion(ActivosFijosPorGruposConstantesFunciones.LABEL_VIDAUTIL);
		datoGeneral.setdValorDouble(vida_utilTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ActivosFijosPorGruposConstantesFunciones.COSTODECOMPRA);
		datoGeneral.setsDescripcion(ActivosFijosPorGruposConstantesFunciones.LABEL_COSTODECOMPRA);
		datoGeneral.setdValorDouble(costo_de_compraTotal);
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