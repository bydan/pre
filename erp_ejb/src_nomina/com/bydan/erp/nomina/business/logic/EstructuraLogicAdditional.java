














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.erp.nomina.util.EstructuraConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
//import com.bydan.erp.nomina.business.interfaces.EstructuraAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class EstructuraLogicAdditional extends EstructuraLogic { // implements EstructuraAdditionable{
	public  EstructuraLogicAdditional(Connexion connexion)throws Exception {
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
	public  EstructuraLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkEstructuraToSave(Estructura estructura,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkEstructuraToSave(Estructura estructura,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkEstructuraToSaveAfter(Estructura estructura,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkEstructuraToSaves(List<Estructura> estructuras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkEstructuraToSaves(List<Estructura> estructuras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkEstructuraToSavesAfter(List<Estructura> estructuras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkEstructuraToGet(Estructura estructura,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkEstructuraToGets(List<Estructura> estructuras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateEstructuraToSave(Estructura estructura,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateEstructuraToGet(Estructura estructura,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectEstructuraActions(String sTipoJsonResponse,JSONObject jsonObjectEstructura,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonEstructuraDataTable(String sTipoJsonResponse,Estructura estructura,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonEstructurasDataTable(String sTipoJsonResponse,List<Estructura> estructuras,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayEstructuraColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayEstructurasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayEstructurasColumns;
	}
	
	public static void updateJSONArrayEstructuraActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectEstructura,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosEstructura(Estructura estructura,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estructura.setcodigo(estructura.getcodigo().trim());
		estructura.setnumero(estructura.getnumero().trim());
		estructura.setnombre(estructura.getnombre().trim());
	}
	
	public static void quitarEspaciosEstructuras(List<Estructura> estructuras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Estructura estructura: estructuras) {
			estructura.setcodigo(estructura.getcodigo().trim());
			estructura.setnumero(estructura.getnumero().trim());
			estructura.setnombre(estructura.getnombre().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstructura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(EstructuraConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(EstructuraConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Estructura> estructuras,Estructura estructura,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Estructura estructuraAux: estructuras) {
			if((estructuraAux.getId()==null && estructura.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(estructuraAux.getId()!=null && estructura.getId()!=null){
				if(estructuraAux.getId().equals(estructura.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstructura(List<Estructura> estructuras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_anticipoTotal=0.0;
		Double porcentaje_anticipoTotal=0.0;
		Double porcentajeTotal=0.0;
		Double valorTotal=0.0;
	
		for(Estructura estructura: estructuras) {			
			valor_anticipoTotal+=estructura.getvalor_anticipo();
			porcentaje_anticipoTotal+=estructura.getporcentaje_anticipo();
			porcentajeTotal+=estructura.getporcentaje();
			valorTotal+=estructura.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EstructuraConstantesFunciones.VALORANTICIPO);
		datoGeneral.setsDescripcion(EstructuraConstantesFunciones.LABEL_VALORANTICIPO);
		datoGeneral.setdValorDouble(valor_anticipoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EstructuraConstantesFunciones.PORCENTAJEANTICIPO);
		datoGeneral.setsDescripcion(EstructuraConstantesFunciones.LABEL_PORCENTAJEANTICIPO);
		datoGeneral.setdValorDouble(porcentaje_anticipoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EstructuraConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(EstructuraConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EstructuraConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(EstructuraConstantesFunciones.LABEL_VALOR);
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