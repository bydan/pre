














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
import com.bydan.erp.puntoventa.util.TarjetaCreditoDescuentoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
//import com.bydan.erp.puntoventa.business.interfaces.TarjetaCreditoDescuentoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class TarjetaCreditoDescuentoLogicAdditional extends TarjetaCreditoDescuentoLogic { // implements TarjetaCreditoDescuentoAdditionable{
	public  TarjetaCreditoDescuentoLogicAdditional(Connexion connexion)throws Exception {
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
	public  TarjetaCreditoDescuentoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkTarjetaCreditoDescuentoToSave(TarjetaCreditoDescuento tarjetacreditodescuento,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkTarjetaCreditoDescuentoToSave(TarjetaCreditoDescuento tarjetacreditodescuento,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkTarjetaCreditoDescuentoToSaveAfter(TarjetaCreditoDescuento tarjetacreditodescuento,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkTarjetaCreditoDescuentoToSaves(List<TarjetaCreditoDescuento> tarjetacreditodescuentos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkTarjetaCreditoDescuentoToSaves(List<TarjetaCreditoDescuento> tarjetacreditodescuentos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkTarjetaCreditoDescuentoToSavesAfter(List<TarjetaCreditoDescuento> tarjetacreditodescuentos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkTarjetaCreditoDescuentoToGet(TarjetaCreditoDescuento tarjetacreditodescuento,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkTarjetaCreditoDescuentoToGets(List<TarjetaCreditoDescuento> tarjetacreditodescuentos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateTarjetaCreditoDescuentoToSave(TarjetaCreditoDescuento tarjetacreditodescuento,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateTarjetaCreditoDescuentoToGet(TarjetaCreditoDescuento tarjetacreditodescuento,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectTarjetaCreditoDescuentoActions(String sTipoJsonResponse,JSONObject jsonObjectTarjetaCreditoDescuento,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonTarjetaCreditoDescuentoDataTable(String sTipoJsonResponse,TarjetaCreditoDescuento tarjetacreditodescuento,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonTarjetaCreditoDescuentosDataTable(String sTipoJsonResponse,List<TarjetaCreditoDescuento> tarjetacreditodescuentos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayTarjetaCreditoDescuentoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayTarjetaCreditoDescuentosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayTarjetaCreditoDescuentosColumns;
	}
	
	public static void updateJSONArrayTarjetaCreditoDescuentoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectTarjetaCreditoDescuento,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosTarjetaCreditoDescuento(TarjetaCreditoDescuento tarjetacreditodescuento,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosTarjetaCreditoDescuentos(List<TarjetaCreditoDescuento> tarjetacreditodescuentos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TarjetaCreditoDescuento tarjetacreditodescuento: tarjetacreditodescuentos) {
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTarjetaCreditoDescuento(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(TarjetaCreditoDescuentoConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(TarjetaCreditoDescuentoConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TarjetaCreditoDescuento> tarjetacreditodescuentos,TarjetaCreditoDescuento tarjetacreditodescuento,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TarjetaCreditoDescuento tarjetacreditodescuentoAux: tarjetacreditodescuentos) {
			if((tarjetacreditodescuentoAux.getId()==null && tarjetacreditodescuento.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(tarjetacreditodescuentoAux.getId()!=null && tarjetacreditodescuento.getId()!=null){
				if(tarjetacreditodescuentoAux.getId().equals(tarjetacreditodescuento.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTarjetaCreditoDescuento(List<TarjetaCreditoDescuento> tarjetacreditodescuentos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
	
		for(TarjetaCreditoDescuento tarjetacreditodescuento: tarjetacreditodescuentos) {			
			porcentajeTotal+=tarjetacreditodescuento.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TarjetaCreditoDescuentoConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(TarjetaCreditoDescuentoConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
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