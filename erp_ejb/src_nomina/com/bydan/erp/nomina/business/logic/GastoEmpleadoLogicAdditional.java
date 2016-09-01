














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
import com.bydan.erp.nomina.util.GastoEmpleadoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
//import com.bydan.erp.nomina.business.interfaces.GastoEmpleadoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class GastoEmpleadoLogicAdditional extends GastoEmpleadoLogic { // implements GastoEmpleadoAdditionable{
	public  GastoEmpleadoLogicAdditional(Connexion connexion)throws Exception {
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
	public  GastoEmpleadoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkGastoEmpleadoToSave(GastoEmpleado gastoempleado,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkGastoEmpleadoToSave(GastoEmpleado gastoempleado,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkGastoEmpleadoToSaveAfter(GastoEmpleado gastoempleado,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkGastoEmpleadoToSaves(List<GastoEmpleado> gastoempleados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkGastoEmpleadoToSaves(List<GastoEmpleado> gastoempleados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkGastoEmpleadoToSavesAfter(List<GastoEmpleado> gastoempleados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkGastoEmpleadoToGet(GastoEmpleado gastoempleado,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkGastoEmpleadoToGets(List<GastoEmpleado> gastoempleados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateGastoEmpleadoToSave(GastoEmpleado gastoempleado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateGastoEmpleadoToGet(GastoEmpleado gastoempleado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectGastoEmpleadoActions(String sTipoJsonResponse,JSONObject jsonObjectGastoEmpleado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonGastoEmpleadoDataTable(String sTipoJsonResponse,GastoEmpleado gastoempleado,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonGastoEmpleadosDataTable(String sTipoJsonResponse,List<GastoEmpleado> gastoempleados,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayGastoEmpleadoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayGastoEmpleadosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayGastoEmpleadosColumns;
	}
	
	public static void updateJSONArrayGastoEmpleadoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectGastoEmpleado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosGastoEmpleado(GastoEmpleado gastoempleado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosGastoEmpleados(List<GastoEmpleado> gastoempleados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(GastoEmpleado gastoempleado: gastoempleados) {
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesGastoEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(GastoEmpleadoConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(GastoEmpleadoConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(GastoEmpleadoConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(GastoEmpleadoConstantesFunciones.IDUSUARIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<GastoEmpleado> gastoempleados,GastoEmpleado gastoempleado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(GastoEmpleado gastoempleadoAux: gastoempleados) {
			if((gastoempleadoAux.getId()==null && gastoempleado.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(gastoempleadoAux.getId()!=null && gastoempleado.getId()!=null){
				if(gastoempleadoAux.getId().equals(gastoempleado.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaGastoEmpleado(List<GastoEmpleado> gastoempleados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_ingreso_actualTotal=0.0;
		Double total_ingreso_otroTotal=0.0;
		Double total_ingresoTotal=0.0;
		Double gasto_viviendaTotal=0.0;
		Double gasto_educacionTotal=0.0;
		Double gasto_saludTotal=0.0;
		Double gasto_vestimentaTotal=0.0;
		Double gasto_alimentacionTotal=0.0;
		Double total_gasto_actualTotal=0.0;
		Double total_gastoTotal=0.0;
		Double porcentajeTotal=0.0;
		Double valor_maximoTotal=0.0;
	
		for(GastoEmpleado gastoempleado: gastoempleados) {			
			total_ingreso_actualTotal+=gastoempleado.gettotal_ingreso_actual();
			total_ingreso_otroTotal+=gastoempleado.gettotal_ingreso_otro();
			total_ingresoTotal+=gastoempleado.gettotal_ingreso();
			gasto_viviendaTotal+=gastoempleado.getgasto_vivienda();
			gasto_educacionTotal+=gastoempleado.getgasto_educacion();
			gasto_saludTotal+=gastoempleado.getgasto_salud();
			gasto_vestimentaTotal+=gastoempleado.getgasto_vestimenta();
			gasto_alimentacionTotal+=gastoempleado.getgasto_alimentacion();
			total_gasto_actualTotal+=gastoempleado.gettotal_gasto_actual();
			total_gastoTotal+=gastoempleado.gettotal_gasto();
			porcentajeTotal+=gastoempleado.getporcentaje();
			valor_maximoTotal+=gastoempleado.getvalor_maximo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.TOTALINGRESOACTUAL);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_TOTALINGRESOACTUAL);
		datoGeneral.setdValorDouble(total_ingreso_actualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.TOTALINGRESOOTRO);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_TOTALINGRESOOTRO);
		datoGeneral.setdValorDouble(total_ingreso_otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.TOTALINGRESO);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_TOTALINGRESO);
		datoGeneral.setdValorDouble(total_ingresoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.GASTOVIVIENDA);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_GASTOVIVIENDA);
		datoGeneral.setdValorDouble(gasto_viviendaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.GASTOEDUCACION);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_GASTOEDUCACION);
		datoGeneral.setdValorDouble(gasto_educacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.GASTOSALUD);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_GASTOSALUD);
		datoGeneral.setdValorDouble(gasto_saludTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.GASTOVESTIMENTA);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_GASTOVESTIMENTA);
		datoGeneral.setdValorDouble(gasto_vestimentaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.GASTOALIMENTACION);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_GASTOALIMENTACION);
		datoGeneral.setdValorDouble(gasto_alimentacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.TOTALGASTOACTUAL);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_TOTALGASTOACTUAL);
		datoGeneral.setdValorDouble(total_gasto_actualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.TOTALGASTO);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_TOTALGASTO);
		datoGeneral.setdValorDouble(total_gastoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.VALORMAXIMO);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_VALORMAXIMO);
		datoGeneral.setdValorDouble(valor_maximoTotal);
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