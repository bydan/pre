










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.inventario.business.logic.report;

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
import com.bydan.erp.inventario.util.report.AntiguedadesInventariosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;
////import com.bydan.erp.inventario.business.interfaces.AntiguedadesInventariosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class AntiguedadesInventariosLogicAdditional extends AntiguedadesInventariosLogic{		
	
	public  AntiguedadesInventariosLogicAdditional(Connexion connexion)throws Exception {
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
	public  AntiguedadesInventariosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkAntiguedadesInventariosToSave(AntiguedadesInventarios antiguedadesinventarios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkAntiguedadesInventariosToSave(AntiguedadesInventarios antiguedadesinventarios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkAntiguedadesInventariosToSaveAfter(AntiguedadesInventarios antiguedadesinventarios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkAntiguedadesInventariosToSaves(List<AntiguedadesInventarios> antiguedadesinventarioss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkAntiguedadesInventariosToSaves(List<AntiguedadesInventarios> antiguedadesinventarioss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkAntiguedadesInventariosToSavesAfter(List<AntiguedadesInventarios> antiguedadesinventarioss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkAntiguedadesInventariosToGet(AntiguedadesInventarios antiguedadesinventarios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkAntiguedadesInventariosToGets(List<AntiguedadesInventarios> antiguedadesinventarioss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateAntiguedadesInventariosToSave(AntiguedadesInventarios antiguedadesinventarios,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateAntiguedadesInventariosToGet(AntiguedadesInventarios antiguedadesinventarios,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectAntiguedadesInventariosActions(String sTipoJsonResponse,JSONObject jsonObjectAntiguedadesInventarios,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonAntiguedadesInventariosDataTable(String sTipoJsonResponse,AntiguedadesInventarios antiguedadesinventarios,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonAntiguedadesInventariossDataTable(String sTipoJsonResponse,List<AntiguedadesInventarios> antiguedadesinventarioss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayAntiguedadesInventariosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayAntiguedadesInventariossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayAntiguedadesInventariossColumns;
	}
	
	public static void updateJSONArrayAntiguedadesInventariosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectAntiguedadesInventarios,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosAntiguedadesInventarios(AntiguedadesInventarios antiguedadesinventarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		antiguedadesinventarios.setnombre_sucursal(antiguedadesinventarios.getnombre_sucursal().trim());
		antiguedadesinventarios.setnombre_linea(antiguedadesinventarios.getnombre_linea().trim());
		antiguedadesinventarios.setnombre_linea_grupo(antiguedadesinventarios.getnombre_linea_grupo().trim());
		antiguedadesinventarios.setnombre_linea_categoria(antiguedadesinventarios.getnombre_linea_categoria().trim());
		antiguedadesinventarios.setnombre_linea_marca(antiguedadesinventarios.getnombre_linea_marca().trim());
		antiguedadesinventarios.setcodigo(antiguedadesinventarios.getcodigo().trim());
		antiguedadesinventarios.setnombre(antiguedadesinventarios.getnombre().trim());
		antiguedadesinventarios.setnombre_bodega(antiguedadesinventarios.getnombre_bodega().trim());
		antiguedadesinventarios.setnombre_unidad(antiguedadesinventarios.getnombre_unidad().trim());
	}
	
	public static void quitarEspaciosAntiguedadesInventarioss(List<AntiguedadesInventarios> antiguedadesinventarioss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AntiguedadesInventarios antiguedadesinventarios: antiguedadesinventarioss) {
			antiguedadesinventarios.setnombre_sucursal(antiguedadesinventarios.getnombre_sucursal().trim());
			antiguedadesinventarios.setnombre_linea(antiguedadesinventarios.getnombre_linea().trim());
			antiguedadesinventarios.setnombre_linea_grupo(antiguedadesinventarios.getnombre_linea_grupo().trim());
			antiguedadesinventarios.setnombre_linea_categoria(antiguedadesinventarios.getnombre_linea_categoria().trim());
			antiguedadesinventarios.setnombre_linea_marca(antiguedadesinventarios.getnombre_linea_marca().trim());
			antiguedadesinventarios.setcodigo(antiguedadesinventarios.getcodigo().trim());
			antiguedadesinventarios.setnombre(antiguedadesinventarios.getnombre().trim());
			antiguedadesinventarios.setnombre_bodega(antiguedadesinventarios.getnombre_bodega().trim());
			antiguedadesinventarios.setnombre_unidad(antiguedadesinventarios.getnombre_unidad().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAntiguedadesInventarios(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(AntiguedadesInventariosConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(AntiguedadesInventariosConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AntiguedadesInventarios> antiguedadesinventarioss,AntiguedadesInventarios antiguedadesinventarios,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AntiguedadesInventarios antiguedadesinventariosAux: antiguedadesinventarioss) {
			if((antiguedadesinventariosAux.getId()==null && antiguedadesinventarios.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(antiguedadesinventariosAux.getId()!=null && antiguedadesinventarios.getId()!=null){
				if(antiguedadesinventariosAux.getId().equals(antiguedadesinventarios.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAntiguedadesInventarios(List<AntiguedadesInventarios> antiguedadesinventarioss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(AntiguedadesInventarios antiguedadesinventarios: antiguedadesinventarioss) {			
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