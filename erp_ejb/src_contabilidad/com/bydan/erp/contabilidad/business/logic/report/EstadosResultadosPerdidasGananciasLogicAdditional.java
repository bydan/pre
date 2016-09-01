










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.contabilidad.business.logic.report;

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
import com.bydan.erp.contabilidad.util.report.EstadosResultadosPerdidasGananciasConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;
////import com.bydan.erp.contabilidad.business.interfaces.EstadosResultadosPerdidasGananciasAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class EstadosResultadosPerdidasGananciasLogicAdditional extends EstadosResultadosPerdidasGananciasLogic{		
	
	public  EstadosResultadosPerdidasGananciasLogicAdditional(Connexion connexion)throws Exception {
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
	public  EstadosResultadosPerdidasGananciasLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkEstadosResultadosPerdidasGananciasToSave(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkEstadosResultadosPerdidasGananciasToSave(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkEstadosResultadosPerdidasGananciasToSaveAfter(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkEstadosResultadosPerdidasGananciasToSaves(List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkEstadosResultadosPerdidasGananciasToSaves(List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkEstadosResultadosPerdidasGananciasToSavesAfter(List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkEstadosResultadosPerdidasGananciasToGet(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkEstadosResultadosPerdidasGananciasToGets(List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateEstadosResultadosPerdidasGananciasToSave(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateEstadosResultadosPerdidasGananciasToGet(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectEstadosResultadosPerdidasGananciasActions(String sTipoJsonResponse,JSONObject jsonObjectEstadosResultadosPerdidasGanancias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonEstadosResultadosPerdidasGananciasDataTable(String sTipoJsonResponse,EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonEstadosResultadosPerdidasGananciassDataTable(String sTipoJsonResponse,List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciass,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayEstadosResultadosPerdidasGananciasColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayEstadosResultadosPerdidasGananciassColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayEstadosResultadosPerdidasGananciassColumns;
	}
	
	public static void updateJSONArrayEstadosResultadosPerdidasGananciasActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectEstadosResultadosPerdidasGanancias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosEstadosResultadosPerdidasGanancias(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadosresultadosperdidasganancias.setcodigo(estadosresultadosperdidasganancias.getcodigo().trim());
		estadosresultadosperdidasganancias.setnombre(estadosresultadosperdidasganancias.getnombre().trim());
		estadosresultadosperdidasganancias.setnombre_nivel_cuenta(estadosresultadosperdidasganancias.getnombre_nivel_cuenta().trim());
	}
	
	public static void quitarEspaciosEstadosResultadosPerdidasGananciass(List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias: estadosresultadosperdidasgananciass) {
			estadosresultadosperdidasganancias.setcodigo(estadosresultadosperdidasganancias.getcodigo().trim());
			estadosresultadosperdidasganancias.setnombre(estadosresultadosperdidasganancias.getnombre().trim());
			estadosresultadosperdidasganancias.setnombre_nivel_cuenta(estadosresultadosperdidasganancias.getnombre_nivel_cuenta().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadosResultadosPerdidasGanancias(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(EstadosResultadosPerdidasGananciasConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(EstadosResultadosPerdidasGananciasConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(EstadosResultadosPerdidasGananciasConstantesFunciones.IDPERIODO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciass,EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadosResultadosPerdidasGanancias estadosresultadosperdidasgananciasAux: estadosresultadosperdidasgananciass) {
			if((estadosresultadosperdidasgananciasAux.getId()==null && estadosresultadosperdidasganancias.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(estadosresultadosperdidasgananciasAux.getId()!=null && estadosresultadosperdidasganancias.getId()!=null){
				if(estadosresultadosperdidasgananciasAux.getId().equals(estadosresultadosperdidasganancias.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadosResultadosPerdidasGanancias(List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_inicialTotal=0.0;
		Double credito_inicialTotal=0.0;
		Double saldo_inicialTotal=0.0;
	
		for(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias: estadosresultadosperdidasgananciass) {			
			debito_inicialTotal+=estadosresultadosperdidasganancias.getdebito_inicial();
			credito_inicialTotal+=estadosresultadosperdidasganancias.getcredito_inicial();
			saldo_inicialTotal+=estadosresultadosperdidasganancias.getsaldo_inicial();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EstadosResultadosPerdidasGananciasConstantesFunciones.DEBITOINICIAL);
		datoGeneral.setsDescripcion(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_DEBITOINICIAL);
		datoGeneral.setdValorDouble(debito_inicialTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EstadosResultadosPerdidasGananciasConstantesFunciones.CREDITOINICIAL);
		datoGeneral.setsDescripcion(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_CREDITOINICIAL);
		datoGeneral.setdValorDouble(credito_inicialTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EstadosResultadosPerdidasGananciasConstantesFunciones.SALDOINICIAL);
		datoGeneral.setsDescripcion(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_SALDOINICIAL);
		datoGeneral.setdValorDouble(saldo_inicialTotal);
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