













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
import com.bydan.erp.nomina.util.AsistenciaMensualConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
//import com.bydan.erp.nomina.business.interfaces.AsistenciaMensualAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class AsistenciaMensualLogicAdditional extends AsistenciaMensualLogic { // implements AsistenciaMensualAdditionable{
	public  AsistenciaMensualLogicAdditional(Connexion connexion)throws Exception {
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


	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_22
	}
	
	public static Boolean validarSaveRelaciones(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_20
		Boolean validado=true;

		return validado;	
	}


	public static void updateRelacionesToSave(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}

	//CONTROL_INICIO
	public  AsistenciaMensualLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkAsistenciaMensualToSave(AsistenciaMensual asistenciamensual,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkAsistenciaMensualToSave(AsistenciaMensual asistenciamensual,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkAsistenciaMensualToSaveAfter(AsistenciaMensual asistenciamensual,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkAsistenciaMensualToSaves(List<AsistenciaMensual> asistenciamensuals,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkAsistenciaMensualToSaves(List<AsistenciaMensual> asistenciamensuals,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkAsistenciaMensualToSavesAfter(List<AsistenciaMensual> asistenciamensuals,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkAsistenciaMensualToGet(AsistenciaMensual asistenciamensual,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkAsistenciaMensualToGets(List<AsistenciaMensual> asistenciamensuals,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateAsistenciaMensualToSave(AsistenciaMensual asistenciamensual,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateAsistenciaMensualToGet(AsistenciaMensual asistenciamensual,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectAsistenciaMensualActions(String sTipoJsonResponse,JSONObject jsonObjectAsistenciaMensual,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonAsistenciaMensualDataTable(String sTipoJsonResponse,AsistenciaMensual asistenciamensual,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonAsistenciaMensualsDataTable(String sTipoJsonResponse,List<AsistenciaMensual> asistenciamensuals,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayAsistenciaMensualColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayAsistenciaMensualsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayAsistenciaMensualsColumns;
	}
	
	public static void updateJSONArrayAsistenciaMensualActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectAsistenciaMensual,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosAsistenciaMensual(AsistenciaMensual asistenciamensual,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosAsistenciaMensuals(List<AsistenciaMensual> asistenciamensuals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AsistenciaMensual asistenciamensual: asistenciamensuals) {
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAsistenciaMensual(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(AsistenciaMensualConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AsistenciaMensual> asistenciamensuals,AsistenciaMensual asistenciamensual,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AsistenciaMensual asistenciamensualAux: asistenciamensuals) {
			if((asistenciamensualAux.getId()==null && asistenciamensual.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(asistenciamensualAux.getId()!=null && asistenciamensual.getId()!=null){
				if(asistenciamensualAux.getId().equals(asistenciamensual.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAsistenciaMensual(List<AsistenciaMensual> asistenciamensuals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double horas_trabajoTotal=0.0;
		Double horas_atrasoTotal=0.0;
		Double horas_faltasTotal=0.0;
		Double horas_permisoTotal=0.0;
		Double horas_extra25Total=0.0;
		Double horas_extra50Total=0.0;
		Double horas_extra100Total=0.0;
		Double horas_extra150Total=0.0;
		Double horas_extra0Total=0.0;
		Double horas_enfermoTotal=0.0;
		Double horas_maternidadTotal=0.0;
		Double horas_vacacionTotal=0.0;
		Double numero_diasTotal=0.0;
		Double numero_nochesTotal=0.0;
		Double numero_feriadosTotal=0.0;
		Double numero_trabajoTotal=0.0;
	
		for(AsistenciaMensual asistenciamensual: asistenciamensuals) {			
			horas_trabajoTotal+=asistenciamensual.gethoras_trabajo();
			horas_atrasoTotal+=asistenciamensual.gethoras_atraso();
			horas_faltasTotal+=asistenciamensual.gethoras_faltas();
			horas_permisoTotal+=asistenciamensual.gethoras_permiso();
			horas_extra25Total+=asistenciamensual.gethoras_extra25();
			horas_extra50Total+=asistenciamensual.gethoras_extra50();
			horas_extra100Total+=asistenciamensual.gethoras_extra100();
			horas_extra150Total+=asistenciamensual.gethoras_extra150();
			horas_extra0Total+=asistenciamensual.gethoras_extra0();
			horas_enfermoTotal+=asistenciamensual.gethoras_enfermo();
			horas_maternidadTotal+=asistenciamensual.gethoras_maternidad();
			horas_vacacionTotal+=asistenciamensual.gethoras_vacacion();
			numero_diasTotal+=asistenciamensual.getnumero_dias();
			numero_nochesTotal+=asistenciamensual.getnumero_noches();
			numero_feriadosTotal+=asistenciamensual.getnumero_feriados();
			numero_trabajoTotal+=asistenciamensual.getnumero_trabajo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASTRABAJO);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASTRABAJO);
		datoGeneral.setdValorDouble(horas_trabajoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASATRASO);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASATRASO);
		datoGeneral.setdValorDouble(horas_atrasoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASFALTAS);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASFALTAS);
		datoGeneral.setdValorDouble(horas_faltasTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASPERMISO);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASPERMISO);
		datoGeneral.setdValorDouble(horas_permisoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASEXTRA25);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA25);
		datoGeneral.setdValorDouble(horas_extra25Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASEXTRA50);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA50);
		datoGeneral.setdValorDouble(horas_extra50Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASEXTRA100);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA100);
		datoGeneral.setdValorDouble(horas_extra100Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASEXTRA150);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA150);
		datoGeneral.setdValorDouble(horas_extra150Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASEXTRA0);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA0);
		datoGeneral.setdValorDouble(horas_extra0Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASENFERMO);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASENFERMO);
		datoGeneral.setdValorDouble(horas_enfermoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASMATERNIDAD);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASMATERNIDAD);
		datoGeneral.setdValorDouble(horas_maternidadTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASVACACION);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASVACACION);
		datoGeneral.setdValorDouble(horas_vacacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.NUMERODIAS);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_NUMERODIAS);
		datoGeneral.setdValorDouble(numero_diasTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.NUMERONOCHES);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_NUMERONOCHES);
		datoGeneral.setdValorDouble(numero_nochesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.NUMEROFERIADOS);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_NUMEROFERIADOS);
		datoGeneral.setdValorDouble(numero_feriadosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.NUMEROTRABAJO);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_NUMEROTRABAJO);
		datoGeneral.setdValorDouble(numero_trabajoTotal);
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