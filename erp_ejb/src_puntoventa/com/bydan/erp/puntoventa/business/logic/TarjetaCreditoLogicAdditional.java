














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
import com.bydan.erp.puntoventa.util.TarjetaCreditoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
//import com.bydan.erp.puntoventa.business.interfaces.TarjetaCreditoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class TarjetaCreditoLogicAdditional extends TarjetaCreditoLogic { // implements TarjetaCreditoAdditionable{
	public  TarjetaCreditoLogicAdditional(Connexion connexion)throws Exception {
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
	public  TarjetaCreditoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkTarjetaCreditoToSave(TarjetaCredito tarjetacredito,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkTarjetaCreditoToSave(TarjetaCredito tarjetacredito,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkTarjetaCreditoToSaveAfter(TarjetaCredito tarjetacredito,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkTarjetaCreditoToSaves(List<TarjetaCredito> tarjetacreditos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkTarjetaCreditoToSaves(List<TarjetaCredito> tarjetacreditos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkTarjetaCreditoToSavesAfter(List<TarjetaCredito> tarjetacreditos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkTarjetaCreditoToGet(TarjetaCredito tarjetacredito,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkTarjetaCreditoToGets(List<TarjetaCredito> tarjetacreditos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateTarjetaCreditoToSave(TarjetaCredito tarjetacredito,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateTarjetaCreditoToGet(TarjetaCredito tarjetacredito,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectTarjetaCreditoActions(String sTipoJsonResponse,JSONObject jsonObjectTarjetaCredito,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonTarjetaCreditoDataTable(String sTipoJsonResponse,TarjetaCredito tarjetacredito,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonTarjetaCreditosDataTable(String sTipoJsonResponse,List<TarjetaCredito> tarjetacreditos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayTarjetaCreditoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayTarjetaCreditosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayTarjetaCreditosColumns;
	}
	
	public static void updateJSONArrayTarjetaCreditoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectTarjetaCredito,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosTarjetaCredito(TarjetaCredito tarjetacredito,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tarjetacredito.setcodigo(tarjetacredito.getcodigo().trim());
		tarjetacredito.setnombre(tarjetacredito.getnombre().trim());
		tarjetacredito.setnombre_corto(tarjetacredito.getnombre_corto().trim());
	}
	
	public static void quitarEspaciosTarjetaCreditos(List<TarjetaCredito> tarjetacreditos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TarjetaCredito tarjetacredito: tarjetacreditos) {
			tarjetacredito.setcodigo(tarjetacredito.getcodigo().trim());
			tarjetacredito.setnombre(tarjetacredito.getnombre().trim());
			tarjetacredito.setnombre_corto(tarjetacredito.getnombre_corto().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTarjetaCredito(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(TarjetaCreditoConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(TarjetaCreditoConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TarjetaCredito> tarjetacreditos,TarjetaCredito tarjetacredito,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TarjetaCredito tarjetacreditoAux: tarjetacreditos) {
			if((tarjetacreditoAux.getId()==null && tarjetacredito.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(tarjetacreditoAux.getId()!=null && tarjetacredito.getId()!=null){
				if(tarjetacreditoAux.getId().equals(tarjetacredito.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTarjetaCredito(List<TarjetaCredito> tarjetacreditos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double comisionTotal=0.0;
		Double interesTotal=0.0;
		Double monto_minimoTotal=0.0;
		Double porcentaje_retencionTotal=0.0;
		Double comision_retencionTotal=0.0;
	
		for(TarjetaCredito tarjetacredito: tarjetacreditos) {			
			comisionTotal+=tarjetacredito.getcomision();
			interesTotal+=tarjetacredito.getinteres();
			monto_minimoTotal+=tarjetacredito.getmonto_minimo();
			porcentaje_retencionTotal+=tarjetacredito.getporcentaje_retencion();
			comision_retencionTotal+=tarjetacredito.getcomision_retencion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TarjetaCreditoConstantesFunciones.COMISION);
		datoGeneral.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_COMISION);
		datoGeneral.setdValorDouble(comisionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TarjetaCreditoConstantesFunciones.INTERES);
		datoGeneral.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_INTERES);
		datoGeneral.setdValorDouble(interesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TarjetaCreditoConstantesFunciones.MONTOMINIMO);
		datoGeneral.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_MONTOMINIMO);
		datoGeneral.setdValorDouble(monto_minimoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TarjetaCreditoConstantesFunciones.PORCENTAJERETENCION);
		datoGeneral.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_PORCENTAJERETENCION);
		datoGeneral.setdValorDouble(porcentaje_retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TarjetaCreditoConstantesFunciones.COMISIONRETENCION);
		datoGeneral.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_COMISIONRETENCION);
		datoGeneral.setdValorDouble(comision_retencionTotal);
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