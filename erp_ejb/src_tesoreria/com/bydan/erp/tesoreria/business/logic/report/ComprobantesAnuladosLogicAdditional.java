










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
import com.bydan.erp.tesoreria.util.report.ComprobantesAnuladosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;
////import com.bydan.erp.tesoreria.business.interfaces.ComprobantesAnuladosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ComprobantesAnuladosLogicAdditional extends ComprobantesAnuladosLogic{		
	
	public  ComprobantesAnuladosLogicAdditional(Connexion connexion)throws Exception {
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
	public  ComprobantesAnuladosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkComprobantesAnuladosToSave(ComprobantesAnulados comprobantesanulados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkComprobantesAnuladosToSave(ComprobantesAnulados comprobantesanulados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkComprobantesAnuladosToSaveAfter(ComprobantesAnulados comprobantesanulados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkComprobantesAnuladosToSaves(List<ComprobantesAnulados> comprobantesanuladoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkComprobantesAnuladosToSaves(List<ComprobantesAnulados> comprobantesanuladoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkComprobantesAnuladosToSavesAfter(List<ComprobantesAnulados> comprobantesanuladoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkComprobantesAnuladosToGet(ComprobantesAnulados comprobantesanulados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkComprobantesAnuladosToGets(List<ComprobantesAnulados> comprobantesanuladoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateComprobantesAnuladosToSave(ComprobantesAnulados comprobantesanulados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateComprobantesAnuladosToGet(ComprobantesAnulados comprobantesanulados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectComprobantesAnuladosActions(String sTipoJsonResponse,JSONObject jsonObjectComprobantesAnulados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonComprobantesAnuladosDataTable(String sTipoJsonResponse,ComprobantesAnulados comprobantesanulados,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonComprobantesAnuladossDataTable(String sTipoJsonResponse,List<ComprobantesAnulados> comprobantesanuladoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayComprobantesAnuladosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayComprobantesAnuladossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayComprobantesAnuladossColumns;
	}
	
	public static void updateJSONArrayComprobantesAnuladosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectComprobantesAnulados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosComprobantesAnulados(ComprobantesAnulados comprobantesanulados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		comprobantesanulados.settipo_movimiento(comprobantesanulados.gettipo_movimiento().trim());
		comprobantesanulados.setnumero_mayor(comprobantesanulados.getnumero_mayor().trim());
		comprobantesanulados.setbeneficiario(comprobantesanulados.getbeneficiario().trim());
		comprobantesanulados.setnombre_usuario(comprobantesanulados.getnombre_usuario().trim());
		comprobantesanulados.setdetalle(comprobantesanulados.getdetalle().trim());
		comprobantesanulados.setnumero_cheque(comprobantesanulados.getnumero_cheque().trim());
		comprobantesanulados.setnombre_empresa(comprobantesanulados.getnombre_empresa().trim());
		comprobantesanulados.setruc_empresa(comprobantesanulados.getruc_empresa().trim());
	}
	
	public static void quitarEspaciosComprobantesAnuladoss(List<ComprobantesAnulados> comprobantesanuladoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ComprobantesAnulados comprobantesanulados: comprobantesanuladoss) {
			comprobantesanulados.settipo_movimiento(comprobantesanulados.gettipo_movimiento().trim());
			comprobantesanulados.setnumero_mayor(comprobantesanulados.getnumero_mayor().trim());
			comprobantesanulados.setbeneficiario(comprobantesanulados.getbeneficiario().trim());
			comprobantesanulados.setnombre_usuario(comprobantesanulados.getnombre_usuario().trim());
			comprobantesanulados.setdetalle(comprobantesanulados.getdetalle().trim());
			comprobantesanulados.setnumero_cheque(comprobantesanulados.getnumero_cheque().trim());
			comprobantesanulados.setnombre_empresa(comprobantesanulados.getnombre_empresa().trim());
			comprobantesanulados.setruc_empresa(comprobantesanulados.getruc_empresa().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesComprobantesAnulados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ComprobantesAnuladosConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(ComprobantesAnuladosConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(ComprobantesAnuladosConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(ComprobantesAnuladosConstantesFunciones.IDMODULO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ComprobantesAnulados> comprobantesanuladoss,ComprobantesAnulados comprobantesanulados,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ComprobantesAnulados comprobantesanuladosAux: comprobantesanuladoss) {
			if((comprobantesanuladosAux.getId()==null && comprobantesanulados.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(comprobantesanuladosAux.getId()!=null && comprobantesanulados.getId()!=null){
				if(comprobantesanuladosAux.getId().equals(comprobantesanulados.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaComprobantesAnulados(List<ComprobantesAnulados> comprobantesanuladoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(ComprobantesAnulados comprobantesanulados: comprobantesanuladoss) {			
			valorTotal+=comprobantesanulados.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobantesAnuladosConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
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