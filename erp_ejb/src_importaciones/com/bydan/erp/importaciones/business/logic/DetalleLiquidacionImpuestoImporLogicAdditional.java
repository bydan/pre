











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

import com.bydan.framework.erp.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.importaciones.util.DetalleLiquidacionImpuestoImporConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;
//import com.bydan.erp.importaciones.business.interfaces.DetalleLiquidacionImpuestoImporAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class DetalleLiquidacionImpuestoImporLogicAdditional extends DetalleLiquidacionImpuestoImporLogic { // implements DetalleLiquidacionImpuestoImporAdditionable{
	public  DetalleLiquidacionImpuestoImporLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	
	public static void updateRelacionesToSave(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}


	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_22
	}
	
	public static Boolean validarSaveRelaciones(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_20
		Boolean validado=true;

		return validado;	
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
	public  DetalleLiquidacionImpuestoImporLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDetalleLiquidacionImpuestoImporToSave(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDetalleLiquidacionImpuestoImporToSave(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDetalleLiquidacionImpuestoImporToSaveAfter(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDetalleLiquidacionImpuestoImporToSaves(List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDetalleLiquidacionImpuestoImporToSaves(List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDetalleLiquidacionImpuestoImporToSavesAfter(List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDetalleLiquidacionImpuestoImporToGet(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDetalleLiquidacionImpuestoImporToGets(List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDetalleLiquidacionImpuestoImporToSave(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDetalleLiquidacionImpuestoImporToGet(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDetalleLiquidacionImpuestoImporActions(String sTipoJsonResponse,JSONObject jsonObjectDetalleLiquidacionImpuestoImpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDetalleLiquidacionImpuestoImporDataTable(String sTipoJsonResponse,DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDetalleLiquidacionImpuestoImporsDataTable(String sTipoJsonResponse,List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDetalleLiquidacionImpuestoImporColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDetalleLiquidacionImpuestoImporsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDetalleLiquidacionImpuestoImporsColumns;
	}
	
	public static void updateJSONArrayDetalleLiquidacionImpuestoImporActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDetalleLiquidacionImpuestoImpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDetalleLiquidacionImpuestoImpor(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosDetalleLiquidacionImpuestoImpors(List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor: detalleliquidacionimpuestoimpors) {
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleLiquidacionImpuestoImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DetalleLiquidacionImpuestoImporConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(DetalleLiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors,DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimporAux: detalleliquidacionimpuestoimpors) {
			if((detalleliquidacionimpuestoimporAux.getId()==null && detalleliquidacionimpuestoimpor.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(detalleliquidacionimpuestoimporAux.getId()!=null && detalleliquidacionimpuestoimpor.getId()!=null){
				if(detalleliquidacionimpuestoimporAux.getId().equals(detalleliquidacionimpuestoimpor.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleLiquidacionImpuestoImpor(List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
		Double fobTotal=0.0;
		Double porcentaje_ivaTotal=0.0;
		Double porcentaje_arancelTotal=0.0;
		Double porcentaje_aplicarTotal=0.0;
		Double fleteTotal=0.0;
		Double seguroTotal=0.0;
		Double base_imponibleTotal=0.0;
		Double valor_arancelTotal=0.0;
		Double valor_fodiTotal=0.0;
		Double valor_ivaTotal=0.0;
		Double porcentaje_fodiTotal=0.0;
		Double valor_imponibleTotal=0.0;
	
		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor: detalleliquidacionimpuestoimpors) {			
			valorTotal+=detalleliquidacionimpuestoimpor.getvalor();
			fobTotal+=detalleliquidacionimpuestoimpor.getfob();
			porcentaje_ivaTotal+=detalleliquidacionimpuestoimpor.getporcentaje_iva();
			porcentaje_arancelTotal+=detalleliquidacionimpuestoimpor.getporcentaje_arancel();
			porcentaje_aplicarTotal+=detalleliquidacionimpuestoimpor.getporcentaje_aplicar();
			fleteTotal+=detalleliquidacionimpuestoimpor.getflete();
			seguroTotal+=detalleliquidacionimpuestoimpor.getseguro();
			base_imponibleTotal+=detalleliquidacionimpuestoimpor.getbase_imponible();
			valor_arancelTotal+=detalleliquidacionimpuestoimpor.getvalor_arancel();
			valor_fodiTotal+=detalleliquidacionimpuestoimpor.getvalor_fodi();
			valor_ivaTotal+=detalleliquidacionimpuestoimpor.getvalor_iva();
			porcentaje_fodiTotal+=detalleliquidacionimpuestoimpor.getporcentaje_fodi();
			valor_imponibleTotal+=detalleliquidacionimpuestoimpor.getvalor_imponible();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.FOB);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_FOB);
		datoGeneral.setdValorDouble(fobTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEIVA);
		datoGeneral.setdValorDouble(porcentaje_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEARANCEL);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEARANCEL);
		datoGeneral.setdValorDouble(porcentaje_arancelTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEAPLICAR);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEAPLICAR);
		datoGeneral.setdValorDouble(porcentaje_aplicarTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.SEGURO);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_SEGURO);
		datoGeneral.setdValorDouble(seguroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.BASEIMPONIBLE);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_BASEIMPONIBLE);
		datoGeneral.setdValorDouble(base_imponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORARANCEL);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORARANCEL);
		datoGeneral.setdValorDouble(valor_arancelTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORFODI);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORFODI);
		datoGeneral.setdValorDouble(valor_fodiTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIVA);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORIVA);
		datoGeneral.setdValorDouble(valor_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_PORCENTAJEFODI);
		datoGeneral.setdValorDouble(porcentaje_fodiTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIMPONIBLE);
		datoGeneral.setsDescripcion(DetalleLiquidacionImpuestoImporConstantesFunciones.LABEL_VALORIMPONIBLE);
		datoGeneral.setdValorDouble(valor_imponibleTotal);
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