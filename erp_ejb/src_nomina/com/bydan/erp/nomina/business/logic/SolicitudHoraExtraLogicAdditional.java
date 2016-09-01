














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.erp.nomina.util.SolicitudHoraExtraConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
//import com.bydan.erp.nomina.business.interfaces.SolicitudHoraExtraAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class SolicitudHoraExtraLogicAdditional extends SolicitudHoraExtraLogic { // implements SolicitudHoraExtraAdditionable{
	public  SolicitudHoraExtraLogicAdditional(Connexion connexion)throws Exception {
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
	public  SolicitudHoraExtraLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkSolicitudHoraExtraToSave(SolicitudHoraExtra solicitudhoraextra,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkSolicitudHoraExtraToSave(SolicitudHoraExtra solicitudhoraextra,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkSolicitudHoraExtraToSaveAfter(SolicitudHoraExtra solicitudhoraextra,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkSolicitudHoraExtraToSaves(List<SolicitudHoraExtra> solicitudhoraextras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkSolicitudHoraExtraToSaves(List<SolicitudHoraExtra> solicitudhoraextras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkSolicitudHoraExtraToSavesAfter(List<SolicitudHoraExtra> solicitudhoraextras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkSolicitudHoraExtraToGet(SolicitudHoraExtra solicitudhoraextra,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkSolicitudHoraExtraToGets(List<SolicitudHoraExtra> solicitudhoraextras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateSolicitudHoraExtraToSave(SolicitudHoraExtra solicitudhoraextra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateSolicitudHoraExtraToGet(SolicitudHoraExtra solicitudhoraextra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectSolicitudHoraExtraActions(String sTipoJsonResponse,JSONObject jsonObjectSolicitudHoraExtra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonSolicitudHoraExtraDataTable(String sTipoJsonResponse,SolicitudHoraExtra solicitudhoraextra,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonSolicitudHoraExtrasDataTable(String sTipoJsonResponse,List<SolicitudHoraExtra> solicitudhoraextras,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArraySolicitudHoraExtraColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArraySolicitudHoraExtrasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArraySolicitudHoraExtrasColumns;
	}
	
	public static void updateJSONArraySolicitudHoraExtraActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectSolicitudHoraExtra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosSolicitudHoraExtra(SolicitudHoraExtra solicitudhoraextra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		solicitudhoraextra.setsecuencial(solicitudhoraextra.getsecuencial().trim());
		solicitudhoraextra.setdescripcion(solicitudhoraextra.getdescripcion().trim());
	}
	
	public static void quitarEspaciosSolicitudHoraExtras(List<SolicitudHoraExtra> solicitudhoraextras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SolicitudHoraExtra solicitudhoraextra: solicitudhoraextras) {
			solicitudhoraextra.setsecuencial(solicitudhoraextra.getsecuencial().trim());
			solicitudhoraextra.setdescripcion(solicitudhoraextra.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSolicitudHoraExtra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(SolicitudHoraExtraConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(SolicitudHoraExtraConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SolicitudHoraExtra> solicitudhoraextras,SolicitudHoraExtra solicitudhoraextra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SolicitudHoraExtra solicitudhoraextraAux: solicitudhoraextras) {
			if((solicitudhoraextraAux.getId()==null && solicitudhoraextra.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(solicitudhoraextraAux.getId()!=null && solicitudhoraextra.getId()!=null){
				if(solicitudhoraextraAux.getId().equals(solicitudhoraextra.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSolicitudHoraExtra(List<SolicitudHoraExtra> solicitudhoraextras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costo_unitarioTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(SolicitudHoraExtra solicitudhoraextra: solicitudhoraextras) {			
			costo_unitarioTotal+=solicitudhoraextra.getcosto_unitario();
			costo_totalTotal+=solicitudhoraextra.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SolicitudHoraExtraConstantesFunciones.COSTOUNITARIO);
		datoGeneral.setsDescripcion(SolicitudHoraExtraConstantesFunciones.LABEL_COSTOUNITARIO);
		datoGeneral.setdValorDouble(costo_unitarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SolicitudHoraExtraConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(SolicitudHoraExtraConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
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