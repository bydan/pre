














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.tesoreria.business.logic;

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
import com.bydan.erp.tesoreria.util.PagoAutoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
//import com.bydan.erp.tesoreria.business.interfaces.PagoAutoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class PagoAutoLogicAdditional extends PagoAutoLogic { // implements PagoAutoAdditionable{
	
	public  PagoAutoLogicAdditional(Connexion connexion)throws Exception {
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
	public  PagoAutoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkPagoAutoToSave(PagoAuto pagoauto,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkPagoAutoToSave(PagoAuto pagoauto,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkPagoAutoToSaveAfter(PagoAuto pagoauto,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkPagoAutoToSaves(List<PagoAuto> pagoautos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkPagoAutoToSaves(List<PagoAuto> pagoautos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkPagoAutoToSavesAfter(List<PagoAuto> pagoautos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkPagoAutoToGet(PagoAuto pagoauto,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkPagoAutoToGets(List<PagoAuto> pagoautos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updatePagoAutoToSave(PagoAuto pagoauto,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updatePagoAutoToGet(PagoAuto pagoauto,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectPagoAutoActions(String sTipoJsonResponse,JSONObject jsonObjectPagoAuto,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonPagoAutoDataTable(String sTipoJsonResponse,PagoAuto pagoauto,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonPagoAutosDataTable(String sTipoJsonResponse,List<PagoAuto> pagoautos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayPagoAutoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayPagoAutosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayPagoAutosColumns;
	}
	
	public static void updateJSONArrayPagoAutoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectPagoAuto,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosPagoAuto(PagoAuto pagoauto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pagoauto.setnumero_factura(pagoauto.getnumero_factura().trim());
		pagoauto.setdescripcion(pagoauto.getdescripcion().trim());
	}
	
	public static void quitarEspaciosPagoAutos(List<PagoAuto> pagoautos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PagoAuto pagoauto: pagoautos) {
			pagoauto.setnumero_factura(pagoauto.getnumero_factura().trim());
			pagoauto.setdescripcion(pagoauto.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPagoAuto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(PagoAutoConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(PagoAutoConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(PagoAutoConstantesFunciones.IDEJERCICIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PagoAuto> pagoautos,PagoAuto pagoauto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PagoAuto pagoautoAux: pagoautos) {
			if((pagoautoAux.getId()==null && pagoauto.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(pagoautoAux.getId()!=null && pagoauto.getId()!=null){
				if(pagoautoAux.getId().equals(pagoauto.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPagoAuto(List<PagoAuto> pagoautos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_por_pagarTotal=0.0;
		Double valor_canceladoTotal=0.0;
	
		for(PagoAuto pagoauto: pagoautos) {			
			valor_por_pagarTotal+=pagoauto.getvalor_por_pagar();
			valor_canceladoTotal+=pagoauto.getvalor_cancelado();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PagoAutoConstantesFunciones.VALORPORPAGAR);
		datoGeneral.setsDescripcion(PagoAutoConstantesFunciones.LABEL_VALORPORPAGAR);
		datoGeneral.setdValorDouble(valor_por_pagarTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PagoAutoConstantesFunciones.VALORCANCELADO);
		datoGeneral.setsDescripcion(PagoAutoConstantesFunciones.LABEL_VALORCANCELADO);
		datoGeneral.setdValorDouble(valor_canceladoTotal);
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