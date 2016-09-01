














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
import com.bydan.erp.produccion.util.TipoMaquinaEmpresaConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;
//import com.bydan.erp.produccion.business.interfaces.TipoMaquinaEmpresaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class TipoMaquinaEmpresaLogicAdditional extends TipoMaquinaEmpresaLogic { // implements TipoMaquinaEmpresaAdditionable{
	public  TipoMaquinaEmpresaLogicAdditional(Connexion connexion)throws Exception {
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
	public  TipoMaquinaEmpresaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkTipoMaquinaEmpresaToSave(TipoMaquinaEmpresa tipomaquinaempresa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkTipoMaquinaEmpresaToSave(TipoMaquinaEmpresa tipomaquinaempresa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkTipoMaquinaEmpresaToSaveAfter(TipoMaquinaEmpresa tipomaquinaempresa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkTipoMaquinaEmpresaToSaves(List<TipoMaquinaEmpresa> tipomaquinaempresas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkTipoMaquinaEmpresaToSaves(List<TipoMaquinaEmpresa> tipomaquinaempresas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkTipoMaquinaEmpresaToSavesAfter(List<TipoMaquinaEmpresa> tipomaquinaempresas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkTipoMaquinaEmpresaToGet(TipoMaquinaEmpresa tipomaquinaempresa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkTipoMaquinaEmpresaToGets(List<TipoMaquinaEmpresa> tipomaquinaempresas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateTipoMaquinaEmpresaToSave(TipoMaquinaEmpresa tipomaquinaempresa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateTipoMaquinaEmpresaToGet(TipoMaquinaEmpresa tipomaquinaempresa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectTipoMaquinaEmpresaActions(String sTipoJsonResponse,JSONObject jsonObjectTipoMaquinaEmpresa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonTipoMaquinaEmpresaDataTable(String sTipoJsonResponse,TipoMaquinaEmpresa tipomaquinaempresa,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonTipoMaquinaEmpresasDataTable(String sTipoJsonResponse,List<TipoMaquinaEmpresa> tipomaquinaempresas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayTipoMaquinaEmpresaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayTipoMaquinaEmpresasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayTipoMaquinaEmpresasColumns;
	}
	
	public static void updateJSONArrayTipoMaquinaEmpresaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectTipoMaquinaEmpresa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosTipoMaquinaEmpresa(TipoMaquinaEmpresa tipomaquinaempresa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipomaquinaempresa.setcodigo(tipomaquinaempresa.getcodigo().trim());
		tipomaquinaempresa.setnombre(tipomaquinaempresa.getnombre().trim());
		tipomaquinaempresa.setmarca(tipomaquinaempresa.getmarca().trim());
		tipomaquinaempresa.setmodelo(tipomaquinaempresa.getmodelo().trim());
	}
	
	public static void quitarEspaciosTipoMaquinaEmpresas(List<TipoMaquinaEmpresa> tipomaquinaempresas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoMaquinaEmpresa tipomaquinaempresa: tipomaquinaempresas) {
			tipomaquinaempresa.setcodigo(tipomaquinaempresa.getcodigo().trim());
			tipomaquinaempresa.setnombre(tipomaquinaempresa.getnombre().trim());
			tipomaquinaempresa.setmarca(tipomaquinaempresa.getmarca().trim());
			tipomaquinaempresa.setmodelo(tipomaquinaempresa.getmodelo().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoMaquinaEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(TipoMaquinaEmpresaConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(TipoMaquinaEmpresaConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoMaquinaEmpresa> tipomaquinaempresas,TipoMaquinaEmpresa tipomaquinaempresa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoMaquinaEmpresa tipomaquinaempresaAux: tipomaquinaempresas) {
			if((tipomaquinaempresaAux.getId()==null && tipomaquinaempresa.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(tipomaquinaempresaAux.getId()!=null && tipomaquinaempresa.getId()!=null){
				if(tipomaquinaempresaAux.getId().equals(tipomaquinaempresa.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoMaquinaEmpresa(List<TipoMaquinaEmpresa> tipomaquinaempresas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costoTotal=0.0;
	
		for(TipoMaquinaEmpresa tipomaquinaempresa: tipomaquinaempresas) {			
			costoTotal+=tipomaquinaempresa.getcosto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TipoMaquinaEmpresaConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(TipoMaquinaEmpresaConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
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