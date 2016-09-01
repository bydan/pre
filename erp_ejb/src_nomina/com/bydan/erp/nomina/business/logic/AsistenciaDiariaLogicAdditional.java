














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
import com.bydan.erp.nomina.util.AsistenciaDiariaConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
//import com.bydan.erp.nomina.business.interfaces.AsistenciaDiariaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class AsistenciaDiariaLogicAdditional extends AsistenciaDiariaLogic { // implements AsistenciaDiariaAdditionable{
	public  AsistenciaDiariaLogicAdditional(Connexion connexion)throws Exception {
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
	public  AsistenciaDiariaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkAsistenciaDiariaToSave(AsistenciaDiaria asistenciadiaria,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkAsistenciaDiariaToSave(AsistenciaDiaria asistenciadiaria,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkAsistenciaDiariaToSaveAfter(AsistenciaDiaria asistenciadiaria,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkAsistenciaDiariaToSaves(List<AsistenciaDiaria> asistenciadiarias,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkAsistenciaDiariaToSaves(List<AsistenciaDiaria> asistenciadiarias,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkAsistenciaDiariaToSavesAfter(List<AsistenciaDiaria> asistenciadiarias,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkAsistenciaDiariaToGet(AsistenciaDiaria asistenciadiaria,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkAsistenciaDiariaToGets(List<AsistenciaDiaria> asistenciadiarias,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateAsistenciaDiariaToSave(AsistenciaDiaria asistenciadiaria,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateAsistenciaDiariaToGet(AsistenciaDiaria asistenciadiaria,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectAsistenciaDiariaActions(String sTipoJsonResponse,JSONObject jsonObjectAsistenciaDiaria,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonAsistenciaDiariaDataTable(String sTipoJsonResponse,AsistenciaDiaria asistenciadiaria,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonAsistenciaDiariasDataTable(String sTipoJsonResponse,List<AsistenciaDiaria> asistenciadiarias,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayAsistenciaDiariaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayAsistenciaDiariasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayAsistenciaDiariasColumns;
	}
	
	public static void updateJSONArrayAsistenciaDiariaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectAsistenciaDiaria,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosAsistenciaDiaria(AsistenciaDiaria asistenciadiaria,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		asistenciadiaria.setdescripcion(asistenciadiaria.getdescripcion().trim());
	}
	
	public static void quitarEspaciosAsistenciaDiarias(List<AsistenciaDiaria> asistenciadiarias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AsistenciaDiaria asistenciadiaria: asistenciadiarias) {
			asistenciadiaria.setdescripcion(asistenciadiaria.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAsistenciaDiaria(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(AsistenciaDiariaConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AsistenciaDiaria> asistenciadiarias,AsistenciaDiaria asistenciadiaria,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AsistenciaDiaria asistenciadiariaAux: asistenciadiarias) {
			if((asistenciadiariaAux.getId()==null && asistenciadiaria.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(asistenciadiariaAux.getId()!=null && asistenciadiaria.getId()!=null){
				if(asistenciadiariaAux.getId().equals(asistenciadiaria.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAsistenciaDiaria(List<AsistenciaDiaria> asistenciadiarias) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double horas_atrasoTotal=0.0;
		Double horas_faltaTotal=0.0;
		Double horas_permisoTotal=0.0;
		Double horas_extra25Total=0.0;
		Double horas_extra50Total=0.0;
		Double horas_extra100Total=0.0;
	
		for(AsistenciaDiaria asistenciadiaria: asistenciadiarias) {			
			horas_atrasoTotal+=asistenciadiaria.gethoras_atraso();
			horas_faltaTotal+=asistenciadiaria.gethoras_falta();
			horas_permisoTotal+=asistenciadiaria.gethoras_permiso();
			horas_extra25Total+=asistenciadiaria.gethoras_extra25();
			horas_extra50Total+=asistenciadiaria.gethoras_extra50();
			horas_extra100Total+=asistenciadiaria.gethoras_extra100();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaDiariaConstantesFunciones.HORASATRASO);
		datoGeneral.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_HORASATRASO);
		datoGeneral.setdValorDouble(horas_atrasoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaDiariaConstantesFunciones.HORASFALTA);
		datoGeneral.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_HORASFALTA);
		datoGeneral.setdValorDouble(horas_faltaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaDiariaConstantesFunciones.HORASPERMISO);
		datoGeneral.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_HORASPERMISO);
		datoGeneral.setdValorDouble(horas_permisoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaDiariaConstantesFunciones.HORASEXTRA25);
		datoGeneral.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_HORASEXTRA25);
		datoGeneral.setdValorDouble(horas_extra25Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaDiariaConstantesFunciones.HORASEXTRA50);
		datoGeneral.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_HORASEXTRA50);
		datoGeneral.setdValorDouble(horas_extra50Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaDiariaConstantesFunciones.HORASEXTRA100);
		datoGeneral.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_HORASEXTRA100);
		datoGeneral.setdValorDouble(horas_extra100Total);
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