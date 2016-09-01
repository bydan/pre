










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
import com.bydan.erp.facturacion.util.report.VentasLineasConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;
////import com.bydan.erp.facturacion.business.interfaces.VentasLineasAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class VentasLineasLogicAdditional extends VentasLineasLogic{		
	
	public  VentasLineasLogicAdditional(Connexion connexion)throws Exception {
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
	public  VentasLineasLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkVentasLineasToSave(VentasLineas ventaslineas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkVentasLineasToSave(VentasLineas ventaslineas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkVentasLineasToSaveAfter(VentasLineas ventaslineas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkVentasLineasToSaves(List<VentasLineas> ventaslineass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkVentasLineasToSaves(List<VentasLineas> ventaslineass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkVentasLineasToSavesAfter(List<VentasLineas> ventaslineass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkVentasLineasToGet(VentasLineas ventaslineas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkVentasLineasToGets(List<VentasLineas> ventaslineass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateVentasLineasToSave(VentasLineas ventaslineas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateVentasLineasToGet(VentasLineas ventaslineas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectVentasLineasActions(String sTipoJsonResponse,JSONObject jsonObjectVentasLineas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonVentasLineasDataTable(String sTipoJsonResponse,VentasLineas ventaslineas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonVentasLineassDataTable(String sTipoJsonResponse,List<VentasLineas> ventaslineass,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayVentasLineasColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayVentasLineassColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayVentasLineassColumns;
	}
	
	public static void updateJSONArrayVentasLineasActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectVentasLineas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosVentasLineas(VentasLineas ventaslineas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ventaslineas.setnombre_linea(ventaslineas.getnombre_linea().trim());
		ventaslineas.setnombre_grupo(ventaslineas.getnombre_grupo().trim());
		ventaslineas.setnombre_categoria(ventaslineas.getnombre_categoria().trim());
		ventaslineas.setnombre_marca(ventaslineas.getnombre_marca().trim());
		ventaslineas.settipo(ventaslineas.gettipo().trim());
	}
	
	public static void quitarEspaciosVentasLineass(List<VentasLineas> ventaslineass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VentasLineas ventaslineas: ventaslineass) {
			ventaslineas.setnombre_linea(ventaslineas.getnombre_linea().trim());
			ventaslineas.setnombre_grupo(ventaslineas.getnombre_grupo().trim());
			ventaslineas.setnombre_categoria(ventaslineas.getnombre_categoria().trim());
			ventaslineas.setnombre_marca(ventaslineas.getnombre_marca().trim());
			ventaslineas.settipo(ventaslineas.gettipo().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasLineas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(VentasLineasConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VentasLineas> ventaslineass,VentasLineas ventaslineas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VentasLineas ventaslineasAux: ventaslineass) {
			if((ventaslineasAux.getId()==null && ventaslineas.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(ventaslineasAux.getId()!=null && ventaslineas.getId()!=null){
				if(ventaslineasAux.getId().equals(ventaslineas.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVentasLineas(List<VentasLineas> ventaslineass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double montoTotal=0.0;
		Double notas_creditoTotal=0.0;
		Double venta_netaTotal=0.0;
		Double porcentajeTotal=0.0;
		Double acumuladoTotal=0.0;
	
		for(VentasLineas ventaslineas: ventaslineass) {			
			montoTotal+=ventaslineas.getmonto();
			notas_creditoTotal+=ventaslineas.getnotas_credito();
			venta_netaTotal+=ventaslineas.getventa_neta();
			porcentajeTotal+=ventaslineas.getporcentaje();
			acumuladoTotal+=ventaslineas.getacumulado();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasLineasConstantesFunciones.MONTO);
		datoGeneral.setsDescripcion(VentasLineasConstantesFunciones.LABEL_MONTO);
		datoGeneral.setdValorDouble(montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasLineasConstantesFunciones.NOTASCREDITO);
		datoGeneral.setsDescripcion(VentasLineasConstantesFunciones.LABEL_NOTASCREDITO);
		datoGeneral.setdValorDouble(notas_creditoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasLineasConstantesFunciones.VENTANETA);
		datoGeneral.setsDescripcion(VentasLineasConstantesFunciones.LABEL_VENTANETA);
		datoGeneral.setdValorDouble(venta_netaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasLineasConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(VentasLineasConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasLineasConstantesFunciones.ACUMULADO);
		datoGeneral.setsDescripcion(VentasLineasConstantesFunciones.LABEL_ACUMULADO);
		datoGeneral.setdValorDouble(acumuladoTotal);
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