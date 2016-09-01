










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.tesoreria.business.logic.report;

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
import com.bydan.erp.tesoreria.util.report.ComparativosFlujosCajaConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;
////import com.bydan.erp.tesoreria.business.interfaces.ComparativosFlujosCajaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ComparativosFlujosCajaLogicAdditional extends ComparativosFlujosCajaLogic{		
	
	public  ComparativosFlujosCajaLogicAdditional(Connexion connexion)throws Exception {
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
	public  ComparativosFlujosCajaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkComparativosFlujosCajaToSave(ComparativosFlujosCaja comparativosflujoscaja,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkComparativosFlujosCajaToSave(ComparativosFlujosCaja comparativosflujoscaja,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkComparativosFlujosCajaToSaveAfter(ComparativosFlujosCaja comparativosflujoscaja,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkComparativosFlujosCajaToSaves(List<ComparativosFlujosCaja> comparativosflujoscajas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkComparativosFlujosCajaToSaves(List<ComparativosFlujosCaja> comparativosflujoscajas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkComparativosFlujosCajaToSavesAfter(List<ComparativosFlujosCaja> comparativosflujoscajas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkComparativosFlujosCajaToGet(ComparativosFlujosCaja comparativosflujoscaja,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkComparativosFlujosCajaToGets(List<ComparativosFlujosCaja> comparativosflujoscajas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateComparativosFlujosCajaToSave(ComparativosFlujosCaja comparativosflujoscaja,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateComparativosFlujosCajaToGet(ComparativosFlujosCaja comparativosflujoscaja,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectComparativosFlujosCajaActions(String sTipoJsonResponse,JSONObject jsonObjectComparativosFlujosCaja,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonComparativosFlujosCajaDataTable(String sTipoJsonResponse,ComparativosFlujosCaja comparativosflujoscaja,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonComparativosFlujosCajasDataTable(String sTipoJsonResponse,List<ComparativosFlujosCaja> comparativosflujoscajas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayComparativosFlujosCajaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayComparativosFlujosCajasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayComparativosFlujosCajasColumns;
	}
	
	public static void updateJSONArrayComparativosFlujosCajaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectComparativosFlujosCaja,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosComparativosFlujosCaja(ComparativosFlujosCaja comparativosflujoscaja,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		comparativosflujoscaja.setnombre_centro_actividad(comparativosflujoscaja.getnombre_centro_actividad().trim());
		comparativosflujoscaja.settipo_movimiento(comparativosflujoscaja.gettipo_movimiento().trim());
	}
	
	public static void quitarEspaciosComparativosFlujosCajas(List<ComparativosFlujosCaja> comparativosflujoscajas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ComparativosFlujosCaja comparativosflujoscaja: comparativosflujoscajas) {
			comparativosflujoscaja.setnombre_centro_actividad(comparativosflujoscaja.getnombre_centro_actividad().trim());
			comparativosflujoscaja.settipo_movimiento(comparativosflujoscaja.gettipo_movimiento().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesComparativosFlujosCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ComparativosFlujosCajaConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(ComparativosFlujosCajaConstantesFunciones.IDEJERCICIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ComparativosFlujosCaja> comparativosflujoscajas,ComparativosFlujosCaja comparativosflujoscaja,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ComparativosFlujosCaja comparativosflujoscajaAux: comparativosflujoscajas) {
			if((comparativosflujoscajaAux.getId()==null && comparativosflujoscaja.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(comparativosflujoscajaAux.getId()!=null && comparativosflujoscaja.getId()!=null){
				if(comparativosflujoscajaAux.getId().equals(comparativosflujoscaja.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaComparativosFlujosCaja(List<ComparativosFlujosCaja> comparativosflujoscajas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double saldo_actualTotal=0.0;
		Double saldo_acumuladoTotal=0.0;
		Double saldo_pres_actualTotal=0.0;
		Double saldo_pres_acumuladoTotal=0.0;
	
		for(ComparativosFlujosCaja comparativosflujoscaja: comparativosflujoscajas) {			
			saldo_actualTotal+=comparativosflujoscaja.getsaldo_actual();
			saldo_acumuladoTotal+=comparativosflujoscaja.getsaldo_acumulado();
			saldo_pres_actualTotal+=comparativosflujoscaja.getsaldo_pres_actual();
			saldo_pres_acumuladoTotal+=comparativosflujoscaja.getsaldo_pres_acumulado();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComparativosFlujosCajaConstantesFunciones.SALDOACTUAL);
		datoGeneral.setsDescripcion(ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOACTUAL);
		datoGeneral.setdValorDouble(saldo_actualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComparativosFlujosCajaConstantesFunciones.SALDOACUMULADO);
		datoGeneral.setsDescripcion(ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOACUMULADO);
		datoGeneral.setdValorDouble(saldo_acumuladoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComparativosFlujosCajaConstantesFunciones.SALDOPRESACTUAL);
		datoGeneral.setsDescripcion(ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOPRESACTUAL);
		datoGeneral.setdValorDouble(saldo_pres_actualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComparativosFlujosCajaConstantesFunciones.SALDOPRESACUMULADO);
		datoGeneral.setsDescripcion(ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOPRESACUMULADO);
		datoGeneral.setdValorDouble(saldo_pres_acumuladoTotal);
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