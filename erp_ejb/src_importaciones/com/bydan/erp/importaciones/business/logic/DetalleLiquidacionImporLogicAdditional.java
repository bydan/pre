














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.importaciones.business.logic;

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
import com.bydan.erp.importaciones.util.DetalleLiquidacionImporConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;
//import com.bydan.erp.importaciones.business.interfaces.DetalleLiquidacionImporAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class DetalleLiquidacionImporLogicAdditional extends DetalleLiquidacionImporLogic { // implements DetalleLiquidacionImporAdditionable{
	public  DetalleLiquidacionImporLogicAdditional(Connexion connexion)throws Exception {
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
	public  DetalleLiquidacionImporLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDetalleLiquidacionImporToSave(DetalleLiquidacionImpor detalleliquidacionimpor,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDetalleLiquidacionImporToSave(DetalleLiquidacionImpor detalleliquidacionimpor,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDetalleLiquidacionImporToSaveAfter(DetalleLiquidacionImpor detalleliquidacionimpor,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDetalleLiquidacionImporToSaves(List<DetalleLiquidacionImpor> detalleliquidacionimpors,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDetalleLiquidacionImporToSaves(List<DetalleLiquidacionImpor> detalleliquidacionimpors,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDetalleLiquidacionImporToSavesAfter(List<DetalleLiquidacionImpor> detalleliquidacionimpors,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDetalleLiquidacionImporToGet(DetalleLiquidacionImpor detalleliquidacionimpor,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDetalleLiquidacionImporToGets(List<DetalleLiquidacionImpor> detalleliquidacionimpors,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDetalleLiquidacionImporToSave(DetalleLiquidacionImpor detalleliquidacionimpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDetalleLiquidacionImporToGet(DetalleLiquidacionImpor detalleliquidacionimpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDetalleLiquidacionImporActions(String sTipoJsonResponse,JSONObject jsonObjectDetalleLiquidacionImpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDetalleLiquidacionImporDataTable(String sTipoJsonResponse,DetalleLiquidacionImpor detalleliquidacionimpor,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDetalleLiquidacionImporsDataTable(String sTipoJsonResponse,List<DetalleLiquidacionImpor> detalleliquidacionimpors,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDetalleLiquidacionImporColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDetalleLiquidacionImporsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDetalleLiquidacionImporsColumns;
	}
	
	public static void updateJSONArrayDetalleLiquidacionImporActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDetalleLiquidacionImpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDetalleLiquidacionImpor(DetalleLiquidacionImpor detalleliquidacionimpor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleliquidacionimpor.setreferencia(detalleliquidacionimpor.getreferencia().trim());
	}
	
	public static void quitarEspaciosDetalleLiquidacionImpors(List<DetalleLiquidacionImpor> detalleliquidacionimpors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleLiquidacionImpor detalleliquidacionimpor: detalleliquidacionimpors) {
			detalleliquidacionimpor.setreferencia(detalleliquidacionimpor.getreferencia().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleLiquidacionImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DetalleLiquidacionImporConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(DetalleLiquidacionImporConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(DetalleLiquidacionImporConstantesFunciones.IDUSUARIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleLiquidacionImpor> detalleliquidacionimpors,DetalleLiquidacionImpor detalleliquidacionimpor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleLiquidacionImpor detalleliquidacionimporAux: detalleliquidacionimpors) {
			if((detalleliquidacionimporAux.getId()==null && detalleliquidacionimpor.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(detalleliquidacionimporAux.getId()!=null && detalleliquidacionimpor.getId()!=null){
				if(detalleliquidacionimporAux.getId().equals(detalleliquidacionimpor.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleLiquidacionImpor(List<DetalleLiquidacionImpor> detalleliquidacionimpors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
		Double impuestoTotal=0.0;
		Double impuesto2Total=0.0;
		Double impuesto3Total=0.0;
		Double impuesto4Total=0.0;
		Double impuesto5Total=0.0;
	
		for(DetalleLiquidacionImpor detalleliquidacionimpor: detalleliquidacionimpors) {			
			valorTotal+=detalleliquidacionimpor.getvalor();
			impuestoTotal+=detalleliquidacionimpor.getimpuesto();
			impuesto2Total+=detalleliquidacionimpor.getimpuesto2();
			impuesto3Total+=detalleliquidacionimpor.getimpuesto3();
			impuesto4Total+=detalleliquidacionimpor.getimpuesto4();
			impuesto5Total+=detalleliquidacionimpor.getimpuesto5();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImporConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImporConstantesFunciones.IMPUESTO);
		datoGeneral.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO);
		datoGeneral.setdValorDouble(impuestoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImporConstantesFunciones.IMPUESTO2);
		datoGeneral.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO2);
		datoGeneral.setdValorDouble(impuesto2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImporConstantesFunciones.IMPUESTO3);
		datoGeneral.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO3);
		datoGeneral.setdValorDouble(impuesto3Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImporConstantesFunciones.IMPUESTO4);
		datoGeneral.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO4);
		datoGeneral.setdValorDouble(impuesto4Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImporConstantesFunciones.IMPUESTO5);
		datoGeneral.setsDescripcion(DetalleLiquidacionImporConstantesFunciones.LABEL_IMPUESTO5);
		datoGeneral.setdValorDouble(impuesto5Total);
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