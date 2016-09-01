










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.facturacion.business.logic.report;

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
import com.bydan.erp.facturacion.util.report.GuiasRemisionesConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;
////import com.bydan.erp.facturacion.business.interfaces.GuiasRemisionesAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class GuiasRemisionesLogicAdditional extends GuiasRemisionesLogic{		
	
	public  GuiasRemisionesLogicAdditional(Connexion connexion)throws Exception {
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
	public  GuiasRemisionesLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkGuiasRemisionesToSave(GuiasRemisiones guiasremisiones,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkGuiasRemisionesToSave(GuiasRemisiones guiasremisiones,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkGuiasRemisionesToSaveAfter(GuiasRemisiones guiasremisiones,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkGuiasRemisionesToSaves(List<GuiasRemisiones> guiasremisioness,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkGuiasRemisionesToSaves(List<GuiasRemisiones> guiasremisioness,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkGuiasRemisionesToSavesAfter(List<GuiasRemisiones> guiasremisioness,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkGuiasRemisionesToGet(GuiasRemisiones guiasremisiones,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkGuiasRemisionesToGets(List<GuiasRemisiones> guiasremisioness,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateGuiasRemisionesToSave(GuiasRemisiones guiasremisiones,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateGuiasRemisionesToGet(GuiasRemisiones guiasremisiones,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectGuiasRemisionesActions(String sTipoJsonResponse,JSONObject jsonObjectGuiasRemisiones,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonGuiasRemisionesDataTable(String sTipoJsonResponse,GuiasRemisiones guiasremisiones,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonGuiasRemisionessDataTable(String sTipoJsonResponse,List<GuiasRemisiones> guiasremisioness,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayGuiasRemisionesColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayGuiasRemisionessColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayGuiasRemisionessColumns;
	}
	
	public static void updateJSONArrayGuiasRemisionesActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectGuiasRemisiones,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosGuiasRemisiones(GuiasRemisiones guiasremisiones,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		guiasremisiones.setnombre_completo_cliente(guiasremisiones.getnombre_completo_cliente().trim());
		guiasremisiones.setnumero_pre_impreso_factura(guiasremisiones.getnumero_pre_impreso_factura().trim());
		guiasremisiones.setsecuencial(guiasremisiones.getsecuencial().trim());
		guiasremisiones.setnombre_tipo_transporte(guiasremisiones.getnombre_tipo_transporte().trim());
	}
	
	public static void quitarEspaciosGuiasRemisioness(List<GuiasRemisiones> guiasremisioness,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(GuiasRemisiones guiasremisiones: guiasremisioness) {
			guiasremisiones.setnombre_completo_cliente(guiasremisiones.getnombre_completo_cliente().trim());
			guiasremisiones.setnumero_pre_impreso_factura(guiasremisiones.getnumero_pre_impreso_factura().trim());
			guiasremisiones.setsecuencial(guiasremisiones.getsecuencial().trim());
			guiasremisiones.setnombre_tipo_transporte(guiasremisiones.getnombre_tipo_transporte().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesGuiasRemisiones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(GuiasRemisionesConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<GuiasRemisiones> guiasremisioness,GuiasRemisiones guiasremisiones,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(GuiasRemisiones guiasremisionesAux: guiasremisioness) {
			if((guiasremisionesAux.getId()==null && guiasremisiones.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(guiasremisionesAux.getId()!=null && guiasremisiones.getId()!=null){
				if(guiasremisionesAux.getId().equals(guiasremisiones.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaGuiasRemisiones(List<GuiasRemisiones> guiasremisioness) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ivaTotal=0.0;
		Double descuentoTotal=0.0;
		Double otroTotal=0.0;
		Double totalTotal=0.0;
	
		for(GuiasRemisiones guiasremisiones: guiasremisioness) {			
			ivaTotal+=guiasremisiones.getiva();
			descuentoTotal+=guiasremisiones.getdescuento();
			otroTotal+=guiasremisiones.getotro();
			totalTotal+=guiasremisiones.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiasRemisionesConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(GuiasRemisionesConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiasRemisionesConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(GuiasRemisionesConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiasRemisionesConstantesFunciones.OTRO);
		datoGeneral.setsDescripcion(GuiasRemisionesConstantesFunciones.LABEL_OTRO);
		datoGeneral.setdValorDouble(otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiasRemisionesConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(GuiasRemisionesConstantesFunciones.LABEL_TOTAL);
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