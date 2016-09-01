





















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


import com.bydan.framework.erp.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.tesoreria.util.BancoConstantesFunciones;
import com.bydan.erp.tesoreria.util.BancoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.BancoReturnGeneral;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.tesoreria.business.entity.*;
//import com.bydan.erp.tesoreria.business.interfaces.BancoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class BancoLogicAdditional extends BancoLogic { // implements BancoAdditionable{
	public  BancoLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	



	

	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19
			BancoParameterReturnGeneral bancoReturnGeneral=(BancoParameterReturnGeneral)generalEntityReturnGeneral;

			if(controlTipo.equals(ControlTipo.FORM) && eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW)) {
				//bancoReturnGeneral.getBanco().setnombre("asdfsad");
				//bancoReturnGeneral.getBanco().setdias_efectivo_extranjero(150);
			
			} else if(controlTipo.equals(ControlTipo.TEXTAREA) && eventoTipo.equals(EventoTipo.CHANGE) && eventoSubTipo.equals(EventoSubTipo.CHANGED)) {
				bancoReturnGeneral.setConRecargarPropiedades(true);
				
				//if(sTipo.equals("nombre_control")) {
				//}
				
				bancoReturnGeneral.getBanco().setcodigo("aaaaaaa");
				bancoReturnGeneral.getBanco().setdias_efectivo_local(5);
				bancoReturnGeneral.getBanco().setdias_efectivo_extranjero(15);
				//bancoReturnGeneral.getBanco().setid_tipo_banco(11L);
				
			} else if(controlTipo.equals(ControlTipo.COMBOBOX) && eventoTipo.equals(EventoTipo.CHANGE) && eventoSubTipo.equals(EventoSubTipo.CHANGED)) {
				bancoReturnGeneral.setConRecargarPropiedades(true);
				
				bancoReturnGeneral.getBanco().setcodigo("combo-combo");
				bancoReturnGeneral.getBanco().setdias_efectivo_local(105);
				bancoReturnGeneral.getBanco().setdias_efectivo_extranjero(105);
				
				
			} else if(controlTipo.equals(ControlTipo.TEXTBOX) && eventoTipo.equals(EventoTipo.CHANGE) && eventoSubTipo.equals(EventoSubTipo.CHANGED)) {
				bancoReturnGeneral.setConRecargarPropiedades(true);
				
				bancoReturnGeneral.getBanco().setcodigo("textbox_213456789");
				bancoReturnGeneral.getBanco().setdias_efectivo_local(999);
				bancoReturnGeneral.getBanco().setdias_efectivo_extranjero(888);
				
				
			}
			
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
	public  BancoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkBancoToSave(Banco banco,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkBancoToSave(Banco banco,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkBancoToSaveAfter(Banco banco,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkBancoToSaves(List<Banco> bancos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkBancoToSaves(List<Banco> bancos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkBancoToSavesAfter(List<Banco> bancos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkBancoToGet(Banco banco,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkBancoToGets(List<Banco> bancos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateBancoToSave(Banco banco,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateBancoToGet(Banco banco,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectBancoActions(String sTipoJsonResponse,JSONObject jsonObjectBanco,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonBancoDataTable(String sTipoJsonResponse,Banco banco,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonBancosDataTable(String sTipoJsonResponse,List<Banco> bancos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayBancoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayBancosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayBancosColumns;
	}
	
	public static void updateJSONArrayBancoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectBanco,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosBanco(Banco banco,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		banco.setcodigo(banco.getcodigo().trim());
		banco.setnombre(banco.getnombre().trim());
	}
	
	public static void quitarEspaciosBancos(List<Banco> bancos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Banco banco: bancos) {
			banco.setcodigo(banco.getcodigo().trim());
			banco.setnombre(banco.getnombre().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(BancoConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(BancoConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Banco> bancos,Banco banco,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Banco bancoAux: bancos) {
			if((bancoAux.getId()==null && banco.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(bancoAux.getId()!=null && banco.getId()!=null){
				if(bancoAux.getId().equals(banco.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaBanco(List<Banco> bancos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Banco banco: bancos) {			
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