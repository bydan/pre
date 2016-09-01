










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.activosfijos.business.logic.report;

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
import com.bydan.erp.activosfijos.util.report.TransferenciasConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.report.*;
////import com.bydan.erp.activosfijos.business.interfaces.TransferenciasAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class TransferenciasLogicAdditional extends TransferenciasLogic{		
	
	public  TransferenciasLogicAdditional(Connexion connexion)throws Exception {
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
	public  TransferenciasLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkTransferenciasToSave(Transferencias transferencias,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkTransferenciasToSave(Transferencias transferencias,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkTransferenciasToSaveAfter(Transferencias transferencias,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkTransferenciasToSaves(List<Transferencias> transferenciass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkTransferenciasToSaves(List<Transferencias> transferenciass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkTransferenciasToSavesAfter(List<Transferencias> transferenciass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkTransferenciasToGet(Transferencias transferencias,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkTransferenciasToGets(List<Transferencias> transferenciass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateTransferenciasToSave(Transferencias transferencias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateTransferenciasToGet(Transferencias transferencias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectTransferenciasActions(String sTipoJsonResponse,JSONObject jsonObjectTransferencias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonTransferenciasDataTable(String sTipoJsonResponse,Transferencias transferencias,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonTransferenciassDataTable(String sTipoJsonResponse,List<Transferencias> transferenciass,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayTransferenciasColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayTransferenciassColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayTransferenciassColumns;
	}
	
	public static void updateJSONArrayTransferenciasActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectTransferencias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosTransferencias(Transferencias transferencias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		transferencias.setempresa_origen(transferencias.getempresa_origen().trim());
		transferencias.setsucursal_origen(transferencias.getsucursal_origen().trim());
		transferencias.setsub_grupo_origen(transferencias.getsub_grupo_origen().trim());
		transferencias.setgrupo_origen(transferencias.getgrupo_origen().trim());
		transferencias.setactivo_origen(transferencias.getactivo_origen().trim());
		transferencias.setempresa_destino(transferencias.getempresa_destino().trim());
		transferencias.setsucursal_destino(transferencias.getsucursal_destino().trim());
		transferencias.setsub_grupo_destino(transferencias.getsub_grupo_destino().trim());
		transferencias.setgrupo_destino(transferencias.getgrupo_destino().trim());
		transferencias.setactivo_destino(transferencias.getactivo_destino().trim());
		transferencias.setsecuencial(transferencias.getsecuencial().trim());
		transferencias.setnumero_documento(transferencias.getnumero_documento().trim());
		transferencias.setrazon(transferencias.getrazon().trim());
		transferencias.setdescripcion(transferencias.getdescripcion().trim());
		transferencias.settipo(transferencias.gettipo().trim());
	}
	
	public static void quitarEspaciosTransferenciass(List<Transferencias> transferenciass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Transferencias transferencias: transferenciass) {
			transferencias.setempresa_origen(transferencias.getempresa_origen().trim());
			transferencias.setsucursal_origen(transferencias.getsucursal_origen().trim());
			transferencias.setsub_grupo_origen(transferencias.getsub_grupo_origen().trim());
			transferencias.setgrupo_origen(transferencias.getgrupo_origen().trim());
			transferencias.setactivo_origen(transferencias.getactivo_origen().trim());
			transferencias.setempresa_destino(transferencias.getempresa_destino().trim());
			transferencias.setsucursal_destino(transferencias.getsucursal_destino().trim());
			transferencias.setsub_grupo_destino(transferencias.getsub_grupo_destino().trim());
			transferencias.setgrupo_destino(transferencias.getgrupo_destino().trim());
			transferencias.setactivo_destino(transferencias.getactivo_destino().trim());
			transferencias.setsecuencial(transferencias.getsecuencial().trim());
			transferencias.setnumero_documento(transferencias.getnumero_documento().trim());
			transferencias.setrazon(transferencias.getrazon().trim());
			transferencias.setdescripcion(transferencias.getdescripcion().trim());
			transferencias.settipo(transferencias.gettipo().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTransferencias(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(TransferenciasConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Transferencias> transferenciass,Transferencias transferencias,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Transferencias transferenciasAux: transferenciass) {
			if((transferenciasAux.getId()==null && transferencias.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(transferenciasAux.getId()!=null && transferencias.getId()!=null){
				if(transferenciasAux.getId().equals(transferencias.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTransferencias(List<Transferencias> transferenciass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costoTotal=0.0;
		Double depreciacionTotal=0.0;
		Double costo_origenTotal=0.0;
		Double depreciacion_origenTotal=0.0;
	
		for(Transferencias transferencias: transferenciass) {			
			costoTotal+=transferencias.getcosto();
			depreciacionTotal+=transferencias.getdepreciacion();
			costo_origenTotal+=transferencias.getcosto_origen();
			depreciacion_origenTotal+=transferencias.getdepreciacion_origen();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciasConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(TransferenciasConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciasConstantesFunciones.DEPRECIACION);
		datoGeneral.setsDescripcion(TransferenciasConstantesFunciones.LABEL_DEPRECIACION);
		datoGeneral.setdValorDouble(depreciacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciasConstantesFunciones.COSTOORIGEN);
		datoGeneral.setsDescripcion(TransferenciasConstantesFunciones.LABEL_COSTOORIGEN);
		datoGeneral.setdValorDouble(costo_origenTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciasConstantesFunciones.DEPRECIACIONORIGEN);
		datoGeneral.setsDescripcion(TransferenciasConstantesFunciones.LABEL_DEPRECIACIONORIGEN);
		datoGeneral.setdValorDouble(depreciacion_origenTotal);
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