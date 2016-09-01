










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
import com.bydan.erp.puntoventa.util.report.ResumenCierreCajaConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;
////import com.bydan.erp.puntoventa.business.interfaces.ResumenCierreCajaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ResumenCierreCajaLogicAdditional extends ResumenCierreCajaLogic{		
	
	public  ResumenCierreCajaLogicAdditional(Connexion connexion)throws Exception {
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
	public  ResumenCierreCajaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkResumenCierreCajaToSave(ResumenCierreCaja resumencierrecaja,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkResumenCierreCajaToSave(ResumenCierreCaja resumencierrecaja,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkResumenCierreCajaToSaveAfter(ResumenCierreCaja resumencierrecaja,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkResumenCierreCajaToSaves(List<ResumenCierreCaja> resumencierrecajas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkResumenCierreCajaToSaves(List<ResumenCierreCaja> resumencierrecajas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkResumenCierreCajaToSavesAfter(List<ResumenCierreCaja> resumencierrecajas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkResumenCierreCajaToGet(ResumenCierreCaja resumencierrecaja,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkResumenCierreCajaToGets(List<ResumenCierreCaja> resumencierrecajas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateResumenCierreCajaToSave(ResumenCierreCaja resumencierrecaja,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateResumenCierreCajaToGet(ResumenCierreCaja resumencierrecaja,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectResumenCierreCajaActions(String sTipoJsonResponse,JSONObject jsonObjectResumenCierreCaja,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonResumenCierreCajaDataTable(String sTipoJsonResponse,ResumenCierreCaja resumencierrecaja,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonResumenCierreCajasDataTable(String sTipoJsonResponse,List<ResumenCierreCaja> resumencierrecajas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayResumenCierreCajaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayResumenCierreCajasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayResumenCierreCajasColumns;
	}
	
	public static void updateJSONArrayResumenCierreCajaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectResumenCierreCaja,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosResumenCierreCaja(ResumenCierreCaja resumencierrecaja,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		resumencierrecaja.settipo_pago(resumencierrecaja.gettipo_pago().trim());
		resumencierrecaja.setnombre_usuario(resumencierrecaja.getnombre_usuario().trim());
		resumencierrecaja.setnombre_caja(resumencierrecaja.getnombre_caja().trim());
	}
	
	public static void quitarEspaciosResumenCierreCajas(List<ResumenCierreCaja> resumencierrecajas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ResumenCierreCaja resumencierrecaja: resumencierrecajas) {
			resumencierrecaja.settipo_pago(resumencierrecaja.gettipo_pago().trim());
			resumencierrecaja.setnombre_usuario(resumencierrecaja.getnombre_usuario().trim());
			resumencierrecaja.setnombre_caja(resumencierrecaja.getnombre_caja().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesResumenCierreCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ResumenCierreCajaConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(ResumenCierreCajaConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(ResumenCierreCajaConstantesFunciones.IDUSUARIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ResumenCierreCaja> resumencierrecajas,ResumenCierreCaja resumencierrecaja,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ResumenCierreCaja resumencierrecajaAux: resumencierrecajas) {
			if((resumencierrecajaAux.getId()==null && resumencierrecaja.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(resumencierrecajaAux.getId()!=null && resumencierrecaja.getId()!=null){
				if(resumencierrecajaAux.getId().equals(resumencierrecaja.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaResumenCierreCaja(List<ResumenCierreCaja> resumencierrecajas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
		Double totalTotal=0.0;
	
		for(ResumenCierreCaja resumencierrecaja: resumencierrecajas) {			
			valorTotal+=resumencierrecaja.getvalor();
			totalTotal+=resumencierrecaja.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ResumenCierreCajaConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ResumenCierreCajaConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ResumenCierreCajaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(ResumenCierreCajaConstantesFunciones.LABEL_TOTAL);
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