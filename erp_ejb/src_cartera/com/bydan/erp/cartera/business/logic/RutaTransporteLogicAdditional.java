













/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.cartera.business.logic;

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
import com.bydan.erp.cartera.util.RutaTransporteConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
//import com.bydan.erp.cartera.business.interfaces.RutaTransporteAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class RutaTransporteLogicAdditional extends RutaTransporteLogic { // implements RutaTransporteAdditionable{
	
	public  RutaTransporteLogicAdditional(Connexion connexion)throws Exception {
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
	public  RutaTransporteLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkRutaTransporteToSave(RutaTransporte rutatransporte,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkRutaTransporteToSave(RutaTransporte rutatransporte,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkRutaTransporteToSaveAfter(RutaTransporte rutatransporte,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkRutaTransporteToSaves(List<RutaTransporte> rutatransportes,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkRutaTransporteToSaves(List<RutaTransporte> rutatransportes,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkRutaTransporteToSavesAfter(List<RutaTransporte> rutatransportes,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkRutaTransporteToGet(RutaTransporte rutatransporte,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkRutaTransporteToGets(List<RutaTransporte> rutatransportes,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateRutaTransporteToSave(RutaTransporte rutatransporte,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateRutaTransporteToGet(RutaTransporte rutatransporte,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectRutaTransporteActions(String sTipoJsonResponse,JSONObject jsonObjectRutaTransporte,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonRutaTransporteDataTable(String sTipoJsonResponse,RutaTransporte rutatransporte,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonRutaTransportesDataTable(String sTipoJsonResponse,List<RutaTransporte> rutatransportes,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayRutaTransporteColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayRutaTransportesColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayRutaTransportesColumns;
	}
	
	public static void updateJSONArrayRutaTransporteActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectRutaTransporte,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosRutaTransporte(RutaTransporte rutatransporte,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		rutatransporte.setnombre(rutatransporte.getnombre().trim());
		rutatransporte.setorigen(rutatransporte.getorigen().trim());
		rutatransporte.setdestino(rutatransporte.getdestino().trim());
	}
	
	public static void quitarEspaciosRutaTransportes(List<RutaTransporte> rutatransportes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RutaTransporte rutatransporte: rutatransportes) {
			rutatransporte.setnombre(rutatransporte.getnombre().trim());
			rutatransporte.setorigen(rutatransporte.getorigen().trim());
			rutatransporte.setdestino(rutatransporte.getdestino().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRutaTransporte(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(RutaTransporteConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RutaTransporte> rutatransportes,RutaTransporte rutatransporte,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RutaTransporte rutatransporteAux: rutatransportes) {
			if((rutatransporteAux.getId()==null && rutatransporte.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(rutatransporteAux.getId()!=null && rutatransporte.getId()!=null){
				if(rutatransporteAux.getId().equals(rutatransporte.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRutaTransporte(List<RutaTransporte> rutatransportes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
	
		for(RutaTransporte rutatransporte: rutatransportes) {			
			precioTotal+=rutatransporte.getprecio();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RutaTransporteConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(RutaTransporteConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
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