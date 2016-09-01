














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.erp.puntoventa.util.CajaIngresoDetalleConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
//import com.bydan.erp.puntoventa.business.interfaces.CajaIngresoDetalleAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class CajaIngresoDetalleLogicAdditional extends CajaIngresoDetalleLogic { // implements CajaIngresoDetalleAdditionable{
	public  CajaIngresoDetalleLogicAdditional(Connexion connexion)throws Exception {
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
	public  CajaIngresoDetalleLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCajaIngresoDetalleToSave(CajaIngresoDetalle cajaingresodetalle,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCajaIngresoDetalleToSave(CajaIngresoDetalle cajaingresodetalle,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCajaIngresoDetalleToSaveAfter(CajaIngresoDetalle cajaingresodetalle,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCajaIngresoDetalleToSaves(List<CajaIngresoDetalle> cajaingresodetalles,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCajaIngresoDetalleToSaves(List<CajaIngresoDetalle> cajaingresodetalles,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCajaIngresoDetalleToSavesAfter(List<CajaIngresoDetalle> cajaingresodetalles,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCajaIngresoDetalleToGet(CajaIngresoDetalle cajaingresodetalle,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCajaIngresoDetalleToGets(List<CajaIngresoDetalle> cajaingresodetalles,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCajaIngresoDetalleToSave(CajaIngresoDetalle cajaingresodetalle,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCajaIngresoDetalleToGet(CajaIngresoDetalle cajaingresodetalle,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCajaIngresoDetalleActions(String sTipoJsonResponse,JSONObject jsonObjectCajaIngresoDetalle,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCajaIngresoDetalleDataTable(String sTipoJsonResponse,CajaIngresoDetalle cajaingresodetalle,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCajaIngresoDetallesDataTable(String sTipoJsonResponse,List<CajaIngresoDetalle> cajaingresodetalles,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCajaIngresoDetalleColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCajaIngresoDetallesColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCajaIngresoDetallesColumns;
	}
	
	public static void updateJSONArrayCajaIngresoDetalleActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCajaIngresoDetalle,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCajaIngresoDetalle(CajaIngresoDetalle cajaingresodetalle,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cajaingresodetalle.setconcepto(cajaingresodetalle.getconcepto().trim());
	}
	
	public static void quitarEspaciosCajaIngresoDetalles(List<CajaIngresoDetalle> cajaingresodetalles,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CajaIngresoDetalle cajaingresodetalle: cajaingresodetalles) {
			cajaingresodetalle.setconcepto(cajaingresodetalle.getconcepto().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCajaIngresoDetalle(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(CajaIngresoDetalleConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(CajaIngresoDetalleConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CajaIngresoDetalle> cajaingresodetalles,CajaIngresoDetalle cajaingresodetalle,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CajaIngresoDetalle cajaingresodetalleAux: cajaingresodetalles) {
			if((cajaingresodetalleAux.getId()==null && cajaingresodetalle.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(cajaingresodetalleAux.getId()!=null && cajaingresodetalle.getId()!=null){
				if(cajaingresodetalleAux.getId().equals(cajaingresodetalle.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCajaIngresoDetalle(List<CajaIngresoDetalle> cajaingresodetalles) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(CajaIngresoDetalle cajaingresodetalle: cajaingresodetalles) {			
			valorTotal+=cajaingresodetalle.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaIngresoDetalleConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(CajaIngresoDetalleConstantesFunciones.LABEL_VALOR);
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