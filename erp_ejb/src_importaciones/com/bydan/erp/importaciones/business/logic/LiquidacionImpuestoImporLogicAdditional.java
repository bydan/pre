














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
import com.bydan.erp.importaciones.util.LiquidacionImpuestoImporConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;
//import com.bydan.erp.importaciones.business.interfaces.LiquidacionImpuestoImporAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class LiquidacionImpuestoImporLogicAdditional extends LiquidacionImpuestoImporLogic { // implements LiquidacionImpuestoImporAdditionable{
	public  LiquidacionImpuestoImporLogicAdditional(Connexion connexion)throws Exception {
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
	public  LiquidacionImpuestoImporLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkLiquidacionImpuestoImporToSave(LiquidacionImpuestoImpor liquidacionimpuestoimpor,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkLiquidacionImpuestoImporToSave(LiquidacionImpuestoImpor liquidacionimpuestoimpor,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkLiquidacionImpuestoImporToSaveAfter(LiquidacionImpuestoImpor liquidacionimpuestoimpor,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkLiquidacionImpuestoImporToSaves(List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkLiquidacionImpuestoImporToSaves(List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkLiquidacionImpuestoImporToSavesAfter(List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkLiquidacionImpuestoImporToGet(LiquidacionImpuestoImpor liquidacionimpuestoimpor,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkLiquidacionImpuestoImporToGets(List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateLiquidacionImpuestoImporToSave(LiquidacionImpuestoImpor liquidacionimpuestoimpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateLiquidacionImpuestoImporToGet(LiquidacionImpuestoImpor liquidacionimpuestoimpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectLiquidacionImpuestoImporActions(String sTipoJsonResponse,JSONObject jsonObjectLiquidacionImpuestoImpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonLiquidacionImpuestoImporDataTable(String sTipoJsonResponse,LiquidacionImpuestoImpor liquidacionimpuestoimpor,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonLiquidacionImpuestoImporsDataTable(String sTipoJsonResponse,List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayLiquidacionImpuestoImporColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayLiquidacionImpuestoImporsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayLiquidacionImpuestoImporsColumns;
	}
	
	public static void updateJSONArrayLiquidacionImpuestoImporActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectLiquidacionImpuestoImpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosLiquidacionImpuestoImpor(LiquidacionImpuestoImpor liquidacionimpuestoimpor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		liquidacionimpuestoimpor.setnumero_comprobante(liquidacionimpuestoimpor.getnumero_comprobante().trim());
		liquidacionimpuestoimpor.setnumero_dui(liquidacionimpuestoimpor.getnumero_dui().trim());
	}
	
	public static void quitarEspaciosLiquidacionImpuestoImpors(List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(LiquidacionImpuestoImpor liquidacionimpuestoimpor: liquidacionimpuestoimpors) {
			liquidacionimpuestoimpor.setnumero_comprobante(liquidacionimpuestoimpor.getnumero_comprobante().trim());
			liquidacionimpuestoimpor.setnumero_dui(liquidacionimpuestoimpor.getnumero_dui().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesLiquidacionImpuestoImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(LiquidacionImpuestoImporConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(LiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors,LiquidacionImpuestoImpor liquidacionimpuestoimpor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(LiquidacionImpuestoImpor liquidacionimpuestoimporAux: liquidacionimpuestoimpors) {
			if((liquidacionimpuestoimporAux.getId()==null && liquidacionimpuestoimpor.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(liquidacionimpuestoimporAux.getId()!=null && liquidacionimpuestoimpor.getId()!=null){
				if(liquidacionimpuestoimporAux.getId().equals(liquidacionimpuestoimpor.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaLiquidacionImpuestoImpor(List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double fobTotal=0.0;
		Double seguroTotal=0.0;
		Double fleteTotal=0.0;
		Double porcentaje_fodiTotal=0.0;
		Double porcentaje_ivaTotal=0.0;
		Double tasa_controlTotal=0.0;
		Double cfrTotal=0.0;
		Double cifTotal=0.0;
		Double totalTotal=0.0;
	
		for(LiquidacionImpuestoImpor liquidacionimpuestoimpor: liquidacionimpuestoimpors) {			
			fobTotal+=liquidacionimpuestoimpor.getfob();
			seguroTotal+=liquidacionimpuestoimpor.getseguro();
			fleteTotal+=liquidacionimpuestoimpor.getflete();
			porcentaje_fodiTotal+=liquidacionimpuestoimpor.getporcentaje_fodi();
			porcentaje_ivaTotal+=liquidacionimpuestoimpor.getporcentaje_iva();
			tasa_controlTotal+=liquidacionimpuestoimpor.gettasa_control();
			cfrTotal+=liquidacionimpuestoimpor.getcfr();
			cifTotal+=liquidacionimpuestoimpor.getcif();
			totalTotal+=liquidacionimpuestoimpor.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.FOB);
		datoGeneral.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_FOB);
		datoGeneral.setdValorDouble(fobTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.SEGURO);
		datoGeneral.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_SEGURO);
		datoGeneral.setdValorDouble(seguroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI);
		datoGeneral.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEFODI);
		datoGeneral.setdValorDouble(porcentaje_fodiTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA);
		datoGeneral.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEIVA);
		datoGeneral.setdValorDouble(porcentaje_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.TASACONTROL);
		datoGeneral.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_TASACONTROL);
		datoGeneral.setdValorDouble(tasa_controlTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.CFR);
		datoGeneral.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_CFR);
		datoGeneral.setdValorDouble(cfrTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.CIF);
		datoGeneral.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_CIF);
		datoGeneral.setdValorDouble(cifTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(LiquidacionImpuestoImporConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(LiquidacionImpuestoImporConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
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