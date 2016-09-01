










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
import com.bydan.erp.puntoventa.util.report.CajaDiariaUsuarioConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;
////import com.bydan.erp.puntoventa.business.interfaces.CajaDiariaUsuarioAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class CajaDiariaUsuarioLogicAdditional extends CajaDiariaUsuarioLogic{		
	
	public  CajaDiariaUsuarioLogicAdditional(Connexion connexion)throws Exception {
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
	public  CajaDiariaUsuarioLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCajaDiariaUsuarioToSave(CajaDiariaUsuario cajadiariausuario,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCajaDiariaUsuarioToSave(CajaDiariaUsuario cajadiariausuario,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCajaDiariaUsuarioToSaveAfter(CajaDiariaUsuario cajadiariausuario,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCajaDiariaUsuarioToSaves(List<CajaDiariaUsuario> cajadiariausuarios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCajaDiariaUsuarioToSaves(List<CajaDiariaUsuario> cajadiariausuarios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCajaDiariaUsuarioToSavesAfter(List<CajaDiariaUsuario> cajadiariausuarios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCajaDiariaUsuarioToGet(CajaDiariaUsuario cajadiariausuario,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCajaDiariaUsuarioToGets(List<CajaDiariaUsuario> cajadiariausuarios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCajaDiariaUsuarioToSave(CajaDiariaUsuario cajadiariausuario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCajaDiariaUsuarioToGet(CajaDiariaUsuario cajadiariausuario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCajaDiariaUsuarioActions(String sTipoJsonResponse,JSONObject jsonObjectCajaDiariaUsuario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCajaDiariaUsuarioDataTable(String sTipoJsonResponse,CajaDiariaUsuario cajadiariausuario,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCajaDiariaUsuariosDataTable(String sTipoJsonResponse,List<CajaDiariaUsuario> cajadiariausuarios,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCajaDiariaUsuarioColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCajaDiariaUsuariosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCajaDiariaUsuariosColumns;
	}
	
	public static void updateJSONArrayCajaDiariaUsuarioActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCajaDiariaUsuario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCajaDiariaUsuario(CajaDiariaUsuario cajadiariausuario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cajadiariausuario.setnombre_caja(cajadiariausuario.getnombre_caja().trim());
		cajadiariausuario.setnombre_usuario(cajadiariausuario.getnombre_usuario().trim());
		cajadiariausuario.setsecuencial(cajadiariausuario.getsecuencial().trim());
		cajadiariausuario.setcodigo_cliente(cajadiariausuario.getcodigo_cliente().trim());
		cajadiariausuario.setnombre_cliente(cajadiariausuario.getnombre_cliente().trim());
	}
	
	public static void quitarEspaciosCajaDiariaUsuarios(List<CajaDiariaUsuario> cajadiariausuarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CajaDiariaUsuario cajadiariausuario: cajadiariausuarios) {
			cajadiariausuario.setnombre_caja(cajadiariausuario.getnombre_caja().trim());
			cajadiariausuario.setnombre_usuario(cajadiariausuario.getnombre_usuario().trim());
			cajadiariausuario.setsecuencial(cajadiariausuario.getsecuencial().trim());
			cajadiariausuario.setcodigo_cliente(cajadiariausuario.getcodigo_cliente().trim());
			cajadiariausuario.setnombre_cliente(cajadiariausuario.getnombre_cliente().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCajaDiariaUsuario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(CajaDiariaUsuarioConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(CajaDiariaUsuarioConstantesFunciones.IDUSUARIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CajaDiariaUsuario> cajadiariausuarios,CajaDiariaUsuario cajadiariausuario,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CajaDiariaUsuario cajadiariausuarioAux: cajadiariausuarios) {
			if((cajadiariausuarioAux.getId()==null && cajadiariausuario.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(cajadiariausuarioAux.getId()!=null && cajadiariausuario.getId()!=null){
				if(cajadiariausuarioAux.getId().equals(cajadiariausuario.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCajaDiariaUsuario(List<CajaDiariaUsuario> cajadiariausuarios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double subtotalTotal=0.0;
		Double ivaTotal=0.0;
		Double descuentoTotal=0.0;
		Double financiamientoTotal=0.0;
		Double fleteTotal=0.0;
		Double iceTotal=0.0;
		Double totalTotal=0.0;
	
		for(CajaDiariaUsuario cajadiariausuario: cajadiariausuarios) {			
			subtotalTotal+=cajadiariausuario.getsubtotal();
			ivaTotal+=cajadiariausuario.getiva();
			descuentoTotal+=cajadiariausuario.getdescuento();
			financiamientoTotal+=cajadiariausuario.getfinanciamiento();
			fleteTotal+=cajadiariausuario.getflete();
			iceTotal+=cajadiariausuario.getice();
			totalTotal+=cajadiariausuario.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaUsuarioConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(subtotalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaUsuarioConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaUsuarioConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaUsuarioConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaUsuarioConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaUsuarioConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaUsuarioConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(CajaDiariaUsuarioConstantesFunciones.LABEL_TOTAL);
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