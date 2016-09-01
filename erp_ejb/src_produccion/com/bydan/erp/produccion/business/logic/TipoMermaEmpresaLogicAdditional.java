














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
import com.bydan.erp.produccion.util.TipoMermaEmpresaConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;
//import com.bydan.erp.produccion.business.interfaces.TipoMermaEmpresaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class TipoMermaEmpresaLogicAdditional extends TipoMermaEmpresaLogic { // implements TipoMermaEmpresaAdditionable{
	public  TipoMermaEmpresaLogicAdditional(Connexion connexion)throws Exception {
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
	public  TipoMermaEmpresaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkTipoMermaEmpresaToSave(TipoMermaEmpresa tipomermaempresa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkTipoMermaEmpresaToSave(TipoMermaEmpresa tipomermaempresa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkTipoMermaEmpresaToSaveAfter(TipoMermaEmpresa tipomermaempresa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkTipoMermaEmpresaToSaves(List<TipoMermaEmpresa> tipomermaempresas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkTipoMermaEmpresaToSaves(List<TipoMermaEmpresa> tipomermaempresas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkTipoMermaEmpresaToSavesAfter(List<TipoMermaEmpresa> tipomermaempresas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkTipoMermaEmpresaToGet(TipoMermaEmpresa tipomermaempresa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkTipoMermaEmpresaToGets(List<TipoMermaEmpresa> tipomermaempresas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateTipoMermaEmpresaToSave(TipoMermaEmpresa tipomermaempresa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateTipoMermaEmpresaToGet(TipoMermaEmpresa tipomermaempresa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectTipoMermaEmpresaActions(String sTipoJsonResponse,JSONObject jsonObjectTipoMermaEmpresa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonTipoMermaEmpresaDataTable(String sTipoJsonResponse,TipoMermaEmpresa tipomermaempresa,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonTipoMermaEmpresasDataTable(String sTipoJsonResponse,List<TipoMermaEmpresa> tipomermaempresas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayTipoMermaEmpresaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayTipoMermaEmpresasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayTipoMermaEmpresasColumns;
	}
	
	public static void updateJSONArrayTipoMermaEmpresaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectTipoMermaEmpresa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosTipoMermaEmpresa(TipoMermaEmpresa tipomermaempresa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipomermaempresa.setnombre(tipomermaempresa.getnombre().trim());
		tipomermaempresa.setdescripcion(tipomermaempresa.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoMermaEmpresas(List<TipoMermaEmpresa> tipomermaempresas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoMermaEmpresa tipomermaempresa: tipomermaempresas) {
			tipomermaempresa.setnombre(tipomermaempresa.getnombre().trim());
			tipomermaempresa.setdescripcion(tipomermaempresa.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoMermaEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(TipoMermaEmpresaConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoMermaEmpresa> tipomermaempresas,TipoMermaEmpresa tipomermaempresa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoMermaEmpresa tipomermaempresaAux: tipomermaempresas) {
			if((tipomermaempresaAux.getId()==null && tipomermaempresa.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(tipomermaempresaAux.getId()!=null && tipomermaempresa.getId()!=null){
				if(tipomermaempresaAux.getId().equals(tipomermaempresa.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoMermaEmpresa(List<TipoMermaEmpresa> tipomermaempresas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoMermaEmpresa tipomermaempresa: tipomermaempresas) {			
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