














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
import com.bydan.erp.produccion.util.TipoManoProduEmpresaConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;
//import com.bydan.erp.produccion.business.interfaces.TipoManoProduEmpresaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class TipoManoProduEmpresaLogicAdditional extends TipoManoProduEmpresaLogic { // implements TipoManoProduEmpresaAdditionable{
	public  TipoManoProduEmpresaLogicAdditional(Connexion connexion)throws Exception {
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
	public  TipoManoProduEmpresaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkTipoManoProduEmpresaToSave(TipoManoProduEmpresa tipomanoproduempresa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkTipoManoProduEmpresaToSave(TipoManoProduEmpresa tipomanoproduempresa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkTipoManoProduEmpresaToSaveAfter(TipoManoProduEmpresa tipomanoproduempresa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkTipoManoProduEmpresaToSaves(List<TipoManoProduEmpresa> tipomanoproduempresas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkTipoManoProduEmpresaToSaves(List<TipoManoProduEmpresa> tipomanoproduempresas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkTipoManoProduEmpresaToSavesAfter(List<TipoManoProduEmpresa> tipomanoproduempresas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkTipoManoProduEmpresaToGet(TipoManoProduEmpresa tipomanoproduempresa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkTipoManoProduEmpresaToGets(List<TipoManoProduEmpresa> tipomanoproduempresas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateTipoManoProduEmpresaToSave(TipoManoProduEmpresa tipomanoproduempresa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateTipoManoProduEmpresaToGet(TipoManoProduEmpresa tipomanoproduempresa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectTipoManoProduEmpresaActions(String sTipoJsonResponse,JSONObject jsonObjectTipoManoProduEmpresa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonTipoManoProduEmpresaDataTable(String sTipoJsonResponse,TipoManoProduEmpresa tipomanoproduempresa,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonTipoManoProduEmpresasDataTable(String sTipoJsonResponse,List<TipoManoProduEmpresa> tipomanoproduempresas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayTipoManoProduEmpresaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayTipoManoProduEmpresasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayTipoManoProduEmpresasColumns;
	}
	
	public static void updateJSONArrayTipoManoProduEmpresaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectTipoManoProduEmpresa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosTipoManoProduEmpresa(TipoManoProduEmpresa tipomanoproduempresa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipomanoproduempresa.setnombre(tipomanoproduempresa.getnombre().trim());
		tipomanoproduempresa.setdescripcion(tipomanoproduempresa.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoManoProduEmpresas(List<TipoManoProduEmpresa> tipomanoproduempresas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoManoProduEmpresa tipomanoproduempresa: tipomanoproduempresas) {
			tipomanoproduempresa.setnombre(tipomanoproduempresa.getnombre().trim());
			tipomanoproduempresa.setdescripcion(tipomanoproduempresa.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoManoProduEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(TipoManoProduEmpresaConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoManoProduEmpresa> tipomanoproduempresas,TipoManoProduEmpresa tipomanoproduempresa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoManoProduEmpresa tipomanoproduempresaAux: tipomanoproduempresas) {
			if((tipomanoproduempresaAux.getId()==null && tipomanoproduempresa.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(tipomanoproduempresaAux.getId()!=null && tipomanoproduempresa.getId()!=null){
				if(tipomanoproduempresaAux.getId().equals(tipomanoproduempresa.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoManoProduEmpresa(List<TipoManoProduEmpresa> tipomanoproduempresas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoManoProduEmpresa tipomanoproduempresa: tipomanoproduempresas) {			
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