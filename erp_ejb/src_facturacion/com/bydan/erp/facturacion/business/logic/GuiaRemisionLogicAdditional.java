











/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.erp.facturacion.util.GuiaRemisionConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
//import com.bydan.erp.facturacion.business.interfaces.GuiaRemisionAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class GuiaRemisionLogicAdditional extends GuiaRemisionLogic { // implements GuiaRemisionAdditionable{
	
	public  GuiaRemisionLogicAdditional(Connexion connexion)throws Exception {
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
	public  GuiaRemisionLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkGuiaRemisionToSave(GuiaRemision guiaremision,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkGuiaRemisionToSave(GuiaRemision guiaremision,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkGuiaRemisionToSaveAfter(GuiaRemision guiaremision,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkGuiaRemisionToSaves(List<GuiaRemision> guiaremisions,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkGuiaRemisionToSaves(List<GuiaRemision> guiaremisions,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkGuiaRemisionToSavesAfter(List<GuiaRemision> guiaremisions,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkGuiaRemisionToGet(GuiaRemision guiaremision,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkGuiaRemisionToGets(List<GuiaRemision> guiaremisions,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateGuiaRemisionToSave(GuiaRemision guiaremision,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateGuiaRemisionToGet(GuiaRemision guiaremision,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectGuiaRemisionActions(String sTipoJsonResponse,JSONObject jsonObjectGuiaRemision,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonGuiaRemisionDataTable(String sTipoJsonResponse,GuiaRemision guiaremision,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonGuiaRemisionsDataTable(String sTipoJsonResponse,List<GuiaRemision> guiaremisions,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayGuiaRemisionColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayGuiaRemisionsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayGuiaRemisionsColumns;
	}
	
	public static void updateJSONArrayGuiaRemisionActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectGuiaRemision,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosGuiaRemision(GuiaRemision guiaremision,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		guiaremision.setsecuencial(guiaremision.getsecuencial().trim());
		guiaremision.setnombre_cliente(guiaremision.getnombre_cliente().trim());
		guiaremision.settelefono_cliente(guiaremision.gettelefono_cliente().trim());
		guiaremision.setruc_cliente(guiaremision.getruc_cliente().trim());
		guiaremision.setdireccion_cliente(guiaremision.getdireccion_cliente().trim());
		guiaremision.setnumero_pre_impreso(guiaremision.getnumero_pre_impreso().trim());
		guiaremision.setidentificacion(guiaremision.getidentificacion().trim());
		guiaremision.settransporte_codigo(guiaremision.gettransporte_codigo().trim());
		guiaremision.setnumero_camion(guiaremision.getnumero_camion().trim());
	}
	
	public static void quitarEspaciosGuiaRemisions(List<GuiaRemision> guiaremisions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(GuiaRemision guiaremision: guiaremisions) {
			guiaremision.setsecuencial(guiaremision.getsecuencial().trim());
			guiaremision.setnombre_cliente(guiaremision.getnombre_cliente().trim());
			guiaremision.settelefono_cliente(guiaremision.gettelefono_cliente().trim());
			guiaremision.setruc_cliente(guiaremision.getruc_cliente().trim());
			guiaremision.setdireccion_cliente(guiaremision.getdireccion_cliente().trim());
			guiaremision.setnumero_pre_impreso(guiaremision.getnumero_pre_impreso().trim());
			guiaremision.setidentificacion(guiaremision.getidentificacion().trim());
			guiaremision.settransporte_codigo(guiaremision.gettransporte_codigo().trim());
			guiaremision.setnumero_camion(guiaremision.getnumero_camion().trim());
					
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesGuiaRemision(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(GuiaRemisionConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(GuiaRemisionConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(GuiaRemisionConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(GuiaRemisionConstantesFunciones.IDPERIODO);
		arrColumnasGlobales.add(GuiaRemisionConstantesFunciones.IDUSUARIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<GuiaRemision> guiaremisions,GuiaRemision guiaremision,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(GuiaRemision guiaremisionAux: guiaremisions) {
			if((guiaremisionAux.getId()==null && guiaremision.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(guiaremisionAux.getId()!=null && guiaremision.getId()!=null){
				if(guiaremisionAux.getId().equals(guiaremision.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaGuiaRemision(List<GuiaRemision> guiaremisions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double montoTotal=0.0;
		Double saldoTotal=0.0;
		Double disponibleTotal=0.0;
		Double peso_brutoTotal=0.0;
		Double ivaTotal=0.0;
		Double total_ivaTotal=0.0;
		Double total_sin_ivaTotal=0.0;
		Double monto_retencionTotal=0.0;
		Double porcentaje_descuentoTotal=0.0;
		Double descuentoTotal=0.0;
		Double fleteTotal=0.0;
		Double otroTotal=0.0;
		Double financiamientoTotal=0.0;
		Double totalTotal=0.0;
	
		for(GuiaRemision guiaremision: guiaremisions) {			
			saldoTotal+=guiaremision.getsaldo();
			disponibleTotal+=guiaremision.getdisponible();
			peso_brutoTotal+=guiaremision.getpeso_bruto();
			ivaTotal+=guiaremision.getiva();
			total_ivaTotal+=guiaremision.gettotal_iva();
			total_sin_ivaTotal+=guiaremision.gettotal_sin_iva();
			monto_retencionTotal+=guiaremision.getmonto_retencion();
			porcentaje_descuentoTotal+=guiaremision.getdescuento();
			descuentoTotal+=guiaremision.getdescuento();
			fleteTotal+=guiaremision.getflete();
			otroTotal+=guiaremision.getotro();
			financiamientoTotal+=guiaremision.getfinanciamiento();
			totalTotal+=guiaremision.gettotal();
		}
		
		
	
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.DISPONIBLE);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_DISPONIBLE);
		datoGeneral.setdValorDouble(disponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.PESOBRUTO);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_PESOBRUTO);
		datoGeneral.setdValorDouble(peso_brutoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.TOTALSINIVA);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_TOTALSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.MONTORETENCION);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_MONTORETENCION);
		datoGeneral.setdValorDouble(monto_retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(porcentaje_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.OTRO);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_OTRO);
		datoGeneral.setdValorDouble(otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_TOTAL);
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