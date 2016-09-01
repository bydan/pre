










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.puntoventa.business.logic.report;

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
import com.bydan.erp.puntoventa.util.report.TarjetasCreditosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;
////import com.bydan.erp.puntoventa.business.interfaces.TarjetasCreditosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class TarjetasCreditosLogicAdditional extends TarjetasCreditosLogic{		
	
	public  TarjetasCreditosLogicAdditional(Connexion connexion)throws Exception {
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
	public  TarjetasCreditosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkTarjetasCreditosToSave(TarjetasCreditos tarjetascreditos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkTarjetasCreditosToSave(TarjetasCreditos tarjetascreditos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkTarjetasCreditosToSaveAfter(TarjetasCreditos tarjetascreditos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkTarjetasCreditosToSaves(List<TarjetasCreditos> tarjetascreditoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkTarjetasCreditosToSaves(List<TarjetasCreditos> tarjetascreditoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkTarjetasCreditosToSavesAfter(List<TarjetasCreditos> tarjetascreditoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkTarjetasCreditosToGet(TarjetasCreditos tarjetascreditos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkTarjetasCreditosToGets(List<TarjetasCreditos> tarjetascreditoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateTarjetasCreditosToSave(TarjetasCreditos tarjetascreditos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateTarjetasCreditosToGet(TarjetasCreditos tarjetascreditos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectTarjetasCreditosActions(String sTipoJsonResponse,JSONObject jsonObjectTarjetasCreditos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonTarjetasCreditosDataTable(String sTipoJsonResponse,TarjetasCreditos tarjetascreditos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonTarjetasCreditossDataTable(String sTipoJsonResponse,List<TarjetasCreditos> tarjetascreditoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayTarjetasCreditosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayTarjetasCreditossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayTarjetasCreditossColumns;
	}
	
	public static void updateJSONArrayTarjetasCreditosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectTarjetasCreditos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosTarjetasCreditos(TarjetasCreditos tarjetascreditos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tarjetascreditos.setnombre_tarjeta(tarjetascreditos.getnombre_tarjeta().trim());
		tarjetascreditos.setlote(tarjetascreditos.getlote().trim());
	}
	
	public static void quitarEspaciosTarjetasCreditoss(List<TarjetasCreditos> tarjetascreditoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TarjetasCreditos tarjetascreditos: tarjetascreditoss) {
			tarjetascreditos.setnombre_tarjeta(tarjetascreditos.getnombre_tarjeta().trim());
			tarjetascreditos.setlote(tarjetascreditos.getlote().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTarjetasCreditos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(TarjetasCreditosConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(TarjetasCreditosConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TarjetasCreditos> tarjetascreditoss,TarjetasCreditos tarjetascreditos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TarjetasCreditos tarjetascreditosAux: tarjetascreditoss) {
			if((tarjetascreditosAux.getId()==null && tarjetascreditos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(tarjetascreditosAux.getId()!=null && tarjetascreditos.getId()!=null){
				if(tarjetascreditosAux.getId().equals(tarjetascreditos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTarjetasCreditos(List<TarjetasCreditos> tarjetascreditoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double totalTotal=0.0;
	
		for(TarjetasCreditos tarjetascreditos: tarjetascreditoss) {			
			totalTotal+=tarjetascreditos.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TarjetasCreditosConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(TarjetasCreditosConstantesFunciones.LABEL_TOTAL);
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