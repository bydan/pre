










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
import com.bydan.erp.contabilidad.util.report.DiarioGeneralConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;
////import com.bydan.erp.contabilidad.business.interfaces.DiarioGeneralAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class DiarioGeneralLogicAdditional extends DiarioGeneralLogic{		
	
	public  DiarioGeneralLogicAdditional(Connexion connexion)throws Exception {
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
	public  DiarioGeneralLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDiarioGeneralToSave(DiarioGeneral diariogeneral,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDiarioGeneralToSave(DiarioGeneral diariogeneral,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDiarioGeneralToSaveAfter(DiarioGeneral diariogeneral,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDiarioGeneralToSaves(List<DiarioGeneral> diariogenerals,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDiarioGeneralToSaves(List<DiarioGeneral> diariogenerals,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDiarioGeneralToSavesAfter(List<DiarioGeneral> diariogenerals,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDiarioGeneralToGet(DiarioGeneral diariogeneral,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDiarioGeneralToGets(List<DiarioGeneral> diariogenerals,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDiarioGeneralToSave(DiarioGeneral diariogeneral,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDiarioGeneralToGet(DiarioGeneral diariogeneral,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDiarioGeneralActions(String sTipoJsonResponse,JSONObject jsonObjectDiarioGeneral,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDiarioGeneralDataTable(String sTipoJsonResponse,DiarioGeneral diariogeneral,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDiarioGeneralsDataTable(String sTipoJsonResponse,List<DiarioGeneral> diariogenerals,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDiarioGeneralColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDiarioGeneralsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDiarioGeneralsColumns;
	}
	
	public static void updateJSONArrayDiarioGeneralActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDiarioGeneral,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDiarioGeneral(DiarioGeneral diariogeneral,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		diariogeneral.settipo_movimiento(diariogeneral.gettipo_movimiento().trim());
		diariogeneral.setnumero_mayor(diariogeneral.getnumero_mayor().trim());
		diariogeneral.setcodigo(diariogeneral.getcodigo().trim());
		diariogeneral.setnombre(diariogeneral.getnombre().trim());
		diariogeneral.setcodigo_asiento(diariogeneral.getcodigo_asiento().trim());
		diariogeneral.setdetalle(diariogeneral.getdetalle().trim());
		diariogeneral.setnombre_estado(diariogeneral.getnombre_estado().trim());
	}
	
	public static void quitarEspaciosDiarioGenerals(List<DiarioGeneral> diariogenerals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DiarioGeneral diariogeneral: diariogenerals) {
			diariogeneral.settipo_movimiento(diariogeneral.gettipo_movimiento().trim());
			diariogeneral.setnumero_mayor(diariogeneral.getnumero_mayor().trim());
			diariogeneral.setcodigo(diariogeneral.getcodigo().trim());
			diariogeneral.setnombre(diariogeneral.getnombre().trim());
			diariogeneral.setcodigo_asiento(diariogeneral.getcodigo_asiento().trim());
			diariogeneral.setdetalle(diariogeneral.getdetalle().trim());
			diariogeneral.setnombre_estado(diariogeneral.getnombre_estado().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDiarioGeneral(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DiarioGeneralConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(DiarioGeneralConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(DiarioGeneralConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(DiarioGeneralConstantesFunciones.IDPERIODO);
		arrColumnasGlobales.add(DiarioGeneralConstantesFunciones.IDMODULO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DiarioGeneral> diariogenerals,DiarioGeneral diariogeneral,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DiarioGeneral diariogeneralAux: diariogenerals) {
			if((diariogeneralAux.getId()==null && diariogeneral.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(diariogeneralAux.getId()!=null && diariogeneral.getId()!=null){
				if(diariogeneralAux.getId().equals(diariogeneral.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDiarioGeneral(List<DiarioGeneral> diariogenerals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_localTotal=0.0;
		Double credito_localTotal=0.0;
		Double debito_extranTotal=0.0;
		Double credito_extranTotal=0.0;
	
		for(DiarioGeneral diariogeneral: diariogenerals) {			
			debito_localTotal+=diariogeneral.getdebito_local();
			credito_localTotal+=diariogeneral.getcredito_local();
			debito_extranTotal+=diariogeneral.getdebito_extran();
			credito_extranTotal+=diariogeneral.getcredito_extran();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DiarioGeneralConstantesFunciones.DEBITOLOCAL);
		datoGeneral.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_DEBITOLOCAL);
		datoGeneral.setdValorDouble(debito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DiarioGeneralConstantesFunciones.CREDITOLOCAL);
		datoGeneral.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_CREDITOLOCAL);
		datoGeneral.setdValorDouble(credito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DiarioGeneralConstantesFunciones.DEBITOEXTRAN);
		datoGeneral.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_DEBITOEXTRAN);
		datoGeneral.setdValorDouble(debito_extranTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DiarioGeneralConstantesFunciones.CREDITOEXTRAN);
		datoGeneral.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_CREDITOEXTRAN);
		datoGeneral.setdValorDouble(credito_extranTotal);
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