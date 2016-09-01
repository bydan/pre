














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.produccion.business.logic;

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
import com.bydan.erp.produccion.util.TipoPrioridadEmpresaProduConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;
//import com.bydan.erp.produccion.business.interfaces.TipoPrioridadEmpresaProduAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class TipoPrioridadEmpresaProduLogicAdditional extends TipoPrioridadEmpresaProduLogic { // implements TipoPrioridadEmpresaProduAdditionable{
	public  TipoPrioridadEmpresaProduLogicAdditional(Connexion connexion)throws Exception {
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
	public  TipoPrioridadEmpresaProduLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkTipoPrioridadEmpresaProduToSave(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkTipoPrioridadEmpresaProduToSave(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkTipoPrioridadEmpresaProduToSaveAfter(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkTipoPrioridadEmpresaProduToSaves(List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkTipoPrioridadEmpresaProduToSaves(List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkTipoPrioridadEmpresaProduToSavesAfter(List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkTipoPrioridadEmpresaProduToGet(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkTipoPrioridadEmpresaProduToGets(List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateTipoPrioridadEmpresaProduToSave(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateTipoPrioridadEmpresaProduToGet(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectTipoPrioridadEmpresaProduActions(String sTipoJsonResponse,JSONObject jsonObjectTipoPrioridadEmpresaProdu,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonTipoPrioridadEmpresaProduDataTable(String sTipoJsonResponse,TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonTipoPrioridadEmpresaProdusDataTable(String sTipoJsonResponse,List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayTipoPrioridadEmpresaProduColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayTipoPrioridadEmpresaProdusColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayTipoPrioridadEmpresaProdusColumns;
	}
	
	public static void updateJSONArrayTipoPrioridadEmpresaProduActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectTipoPrioridadEmpresaProdu,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosTipoPrioridadEmpresaProdu(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoprioridadempresaprodu.setnombre(tipoprioridadempresaprodu.getnombre().trim());
		tipoprioridadempresaprodu.setdescripcion(tipoprioridadempresaprodu.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoPrioridadEmpresaProdus(List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu: tipoprioridadempresaprodus) {
			tipoprioridadempresaprodu.setnombre(tipoprioridadempresaprodu.getnombre().trim());
			tipoprioridadempresaprodu.setdescripcion(tipoprioridadempresaprodu.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPrioridadEmpresaProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(TipoPrioridadEmpresaProduConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus,TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoPrioridadEmpresaProdu tipoprioridadempresaproduAux: tipoprioridadempresaprodus) {
			if((tipoprioridadempresaproduAux.getId()==null && tipoprioridadempresaprodu.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(tipoprioridadempresaproduAux.getId()!=null && tipoprioridadempresaprodu.getId()!=null){
				if(tipoprioridadempresaproduAux.getId().equals(tipoprioridadempresaprodu.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoPrioridadEmpresaProdu(List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu: tipoprioridadempresaprodus) {			
		}
		
		
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