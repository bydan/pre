














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
import com.bydan.erp.puntoventa.util.CajaEgresoDetalleConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
//import com.bydan.erp.puntoventa.business.interfaces.CajaEgresoDetalleAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class CajaEgresoDetalleLogicAdditional extends CajaEgresoDetalleLogic { // implements CajaEgresoDetalleAdditionable{
	public  CajaEgresoDetalleLogicAdditional(Connexion connexion)throws Exception {
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
	public  CajaEgresoDetalleLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCajaEgresoDetalleToSave(CajaEgresoDetalle cajaegresodetalle,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCajaEgresoDetalleToSave(CajaEgresoDetalle cajaegresodetalle,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCajaEgresoDetalleToSaveAfter(CajaEgresoDetalle cajaegresodetalle,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCajaEgresoDetalleToSaves(List<CajaEgresoDetalle> cajaegresodetalles,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCajaEgresoDetalleToSaves(List<CajaEgresoDetalle> cajaegresodetalles,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCajaEgresoDetalleToSavesAfter(List<CajaEgresoDetalle> cajaegresodetalles,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCajaEgresoDetalleToGet(CajaEgresoDetalle cajaegresodetalle,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCajaEgresoDetalleToGets(List<CajaEgresoDetalle> cajaegresodetalles,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCajaEgresoDetalleToSave(CajaEgresoDetalle cajaegresodetalle,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCajaEgresoDetalleToGet(CajaEgresoDetalle cajaegresodetalle,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCajaEgresoDetalleActions(String sTipoJsonResponse,JSONObject jsonObjectCajaEgresoDetalle,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCajaEgresoDetalleDataTable(String sTipoJsonResponse,CajaEgresoDetalle cajaegresodetalle,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCajaEgresoDetallesDataTable(String sTipoJsonResponse,List<CajaEgresoDetalle> cajaegresodetalles,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCajaEgresoDetalleColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCajaEgresoDetallesColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCajaEgresoDetallesColumns;
	}
	
	public static void updateJSONArrayCajaEgresoDetalleActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCajaEgresoDetalle,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCajaEgresoDetalle(CajaEgresoDetalle cajaegresodetalle,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cajaegresodetalle.setconcepto(cajaegresodetalle.getconcepto().trim());
	}
	
	public static void quitarEspaciosCajaEgresoDetalles(List<CajaEgresoDetalle> cajaegresodetalles,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CajaEgresoDetalle cajaegresodetalle: cajaegresodetalles) {
			cajaegresodetalle.setconcepto(cajaegresodetalle.getconcepto().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCajaEgresoDetalle(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(CajaEgresoDetalleConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(CajaEgresoDetalleConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CajaEgresoDetalle> cajaegresodetalles,CajaEgresoDetalle cajaegresodetalle,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CajaEgresoDetalle cajaegresodetalleAux: cajaegresodetalles) {
			if((cajaegresodetalleAux.getId()==null && cajaegresodetalle.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(cajaegresodetalleAux.getId()!=null && cajaegresodetalle.getId()!=null){
				if(cajaegresodetalleAux.getId().equals(cajaegresodetalle.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCajaEgresoDetalle(List<CajaEgresoDetalle> cajaegresodetalles) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(CajaEgresoDetalle cajaegresodetalle: cajaegresodetalles) {			
			valorTotal+=cajaegresodetalle.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaEgresoDetalleConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(CajaEgresoDetalleConstantesFunciones.LABEL_VALOR);
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