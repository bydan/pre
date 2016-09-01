/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.activosfijos.business.logic.report;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;
import java.sql.Timestamp;

import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.Funciones;
import com.bydan.framework.erp.util.Funciones2;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.erp.activosfijos.util.report.ProcesarCalcularDepreciacionesConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.report.*;
import com.bydan.erp.activosfijos.business.logic.DepreciacionActivoFijoLogic;
import com.bydan.erp.activosfijos.business.logic.DetalleActivoFijoLogic;
import com.bydan.erp.activosfijos.business.logic.MetodoDepreciacionLogic;
////import com.bydan.erp.activosfijos.business.interfaces.ProcesarCalcularDepreciacionesAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ProcesarCalcularDepreciacionesLogicAdditional extends ProcesarCalcularDepreciacionesLogic{		
	
	//CONTROL_INICIO
	public  ProcesarCalcularDepreciacionesLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProcesarCalcularDepreciacionesToSave(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProcesarCalcularDepreciacionesToSave(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProcesarCalcularDepreciacionesToSaveAfter(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProcesarCalcularDepreciacionesToSaves(List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProcesarCalcularDepreciacionesToSaves(List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProcesarCalcularDepreciacionesToSavesAfter(List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProcesarCalcularDepreciacionesToGet(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProcesarCalcularDepreciacionesToGets(List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProcesarCalcularDepreciacionesToSave(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProcesarCalcularDepreciacionesToGet(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProcesarCalcularDepreciacionesActions(String sTipoJsonResponse,JSONObject jsonObjectProcesarCalcularDepreciaciones,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProcesarCalcularDepreciacionesDataTable(String sTipoJsonResponse,ProcesarCalcularDepreciaciones procesarcalculardepreciaciones,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProcesarCalcularDepreciacionessDataTable(String sTipoJsonResponse,List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProcesarCalcularDepreciacionesColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProcesarCalcularDepreciacionessColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProcesarCalcularDepreciacionessColumns;
	}
	
	public static void updateJSONArrayProcesarCalcularDepreciacionesActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProcesarCalcularDepreciaciones,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	

	public void BusquedaProcesarCalcularDepreciaciones(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio,Long id_mes,Long id_detalle_grupo_activo_fijo,Long id_sub_grupo_activo_fijo)throws Exception {
		Boolean procesado=false;
		String sFinalQueryLocal="";
		String sQueryExecute="";
		String sFechaFinal="";
		Date fecha_final=null;
		String sFechaInicioAux="";
		Date fecha_inicio_aux=null;
		
		Double dPorcentaje=0.0;
		Double dValor=0.0;
		Double dCosto=0.0;
		Double dDepreciacionMes=0.0;
		Double dDepreciacionAnterior=0.0;
		Double dDepreciacionAcumulada=0.0;
		
		Long id_anio_anterior=0L;
		Long id_mes_anterior=0L;
		
		DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
		DepreciacionActivoFijoLogic depreciacionactivofijoLogic=new DepreciacionActivoFijoLogic();
		DepreciacionActivoFijo depreciacionactivofijo=new DepreciacionActivoFijo();
		MetodoDepreciacionLogic metododepreciacionLogic=new MetodoDepreciacionLogic();
		
		try {
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			detalleactivofijoLogic.setConnexion(this.connexion);
			depreciacionactivofijoLogic.setConnexion(this.connexion);
			metododepreciacionLogic.setConnexion(this.connexion);
			
			sFinalQueryLocal=" where id_empresa="+parametroGeneralUsuario.getid_empresa()+" and "+" id_detalle_grupo_activo_fijo="+id_detalle_grupo_activo_fijo+" and id_sub_grupo_activo_fijo="+id_sub_grupo_activo_fijo;
			detalleactivofijoLogic.getEntities(sFinalQueryLocal);
			
			for(DetalleActivoFijo detalleactivofijo:detalleactivofijoLogic.getDetalleActivoFijos()) {
				dDepreciacionAcumulada=0.0;
				
				sFechaInicioAux=id_anio+"-"+id_mes+"-01";
				fecha_inicio_aux=Funciones2.GetDateFromString(sFechaInicioAux);
				
				sFechaFinal=id_anio+"-"+id_mes+"-"+Funciones2.GetUltimoDiaMes(fecha_inicio_aux);
				fecha_final=Funciones2.GetDateFromString(sFechaFinal);
		
				sQueryExecute="delete from activosfijos.depreciacion_activo_fijo where id_empresa="+parametroGeneralUsuario.getid_empresa()+" and id_detalle_activo_fijo="+detalleactivofijo.getId()+" and id_anio="+id_anio+" and id_mes="+id_mes;
				depreciacionactivofijoLogic.executeQuery(sQueryExecute);
				
				
				depreciacionactivofijo=new DepreciacionActivoFijo();
				
				depreciacionactivofijo.setid_empresa(parametroGeneralUsuario.getid_empresa());
		 		depreciacionactivofijo.setid_sucursal(parametroGeneralUsuario.getid_sucursal());
		 		depreciacionactivofijo.setid_detalle_activo_fijo(detalleactivofijo.getId());
		 		depreciacionactivofijo.setid_tipo_depreciacion_empresa(detalleactivofijo.getid_tipo_depreciacion_empresa());
		 		depreciacionactivofijo.setid_estado_depre_acti(1L);
		 		depreciacionactivofijo.setid_anio(id_anio);
		 		depreciacionactivofijo.setid_mes(id_mes);
		 		depreciacionactivofijo.setfecha_compra(detalleactivofijo.getfecha_compra());
		 		depreciacionactivofijo.setfecha_depre_acti(fecha_final);
		 		depreciacionactivofijo.setvalor_acumulado(0.0);
		 		depreciacionactivofijo.setvalor_total(0.0);		 		
		 		depreciacionactivofijo.setfecha(new Date());
		 		
		 		
		 		sFinalQueryLocal="where id_empresa="+parametroGeneralUsuario.getid_empresa()+" and id_detalle_activo_fijo="+detalleactivofijo.getId();
		 		sFinalQueryLocal+=" and id_anio"+id_anio+" and '"+Funciones2.getStringPostgresDate(fecha_final)+"' between fecha_desde and fecha_hasta";
		 		
		 		metododepreciacionLogic.getEntity(sFinalQueryLocal);
		 		
		 		if(metododepreciacionLogic.getMetodoDepreciacion()!= null &&  metododepreciacionLogic.getMetodoDepreciacion().getId()>0) {
		 			dPorcentaje=metododepreciacionLogic.getMetodoDepreciacion().getporcentaje();
		 			dValor=metododepreciacionLogic.getMetodoDepreciacion().getvalor();
		 		} else {
		 			dPorcentaje=0.0;
		 			dValor=0.0;
		 		}
		 		
		 		depreciacionactivofijo.setporcentaje(dPorcentaje);
		 		
		 		dCosto=detalleactivofijo.getcosto_de_compra();
		 				
		 		dDepreciacionMes=dCosto * dPorcentaje;
		 		
		 				 		
		 		//DEPRECIACION ACUMULADA
		 		
		 		if(id_mes.equals(1L)) {
		 			id_anio_anterior = id_anio - 1L;
		 			id_mes_anterior = 12L;
		 		} else {
		 			id_anio_anterior = id_anio;
		 			id_mes_anterior = id_mes - 1L;
		 		}
		 			
		 		sFinalQueryLocal="select sum(valor_gasto) as total from activosfijos.depreciacion_activo_fijo where id_empresa="+parametroGeneralUsuario.getid_empresa();
		 		sFinalQueryLocal+=" and id_detalle_activo_fijo="+detalleactivofijo.getId() +" and id_anio="+id_anio +" and id_mes<="+id_mes_anterior;
		 				
		 		dDepreciacionAnterior=DataAccessHelperBase.getDoubleValue(this.connexion, sFinalQueryLocal, "total");
		 		
		 		
		 		sFinalQueryLocal="where id_empresa="+parametroGeneralUsuario.getid_empresa() +" and id_detalle_activo_fijo="+detalleactivofijo.getId()+ " and id_anio<"+id_anio;
		 		metododepreciacionLogic.getEntities(sFinalQueryLocal);
		 		
		 		
		 		for(MetodoDepreciacion metododepreciacion:metododepreciacionLogic.getMetodoDepreciacions()) {
		 			dDepreciacionAcumulada+=dCosto * metododepreciacion.getporcentaje();
		 		}
		 		
		 		
		 		if(dDepreciacionMes + dDepreciacionAcumulada > dCosto) {				
		 			dDepreciacionAcumulada = dCosto;
		 			dDepreciacionMes = 0.0;										 		
		 		
		 		} else if((dDepreciacionMes + dDepreciacionAcumulada - dCosto) < 0.05) {
				
		 		} 
				
		 		if(detalleactivofijo.getfecha_compra().compareTo(fecha_final)>0) {		 			
		 			depreciacionactivofijo.setvalor_gasto(0.0);
			 		depreciacionactivofijo.setcosto(0.0);
			 		depreciacionactivofijo.setvalor_acumulado(0.0);
		 		} else {
		 			depreciacionactivofijo.setvalor_gasto(dDepreciacionMes);
			 		depreciacionactivofijo.setcosto(dCosto);
			 		
			 		if(id_anio_anterior.equals(id_anio)) {
			 			depreciacionactivofijo.setvalor_acumulado(dDepreciacionAcumulada + dDepreciacionAnterior);
			 		} else {
			 			depreciacionactivofijo.setvalor_acumulado(dDepreciacionAcumulada);
			 		}
		 		}
		 		
		 		depreciacionactivofijoLogic.getDepreciacionActivoFijos().add(depreciacionactivofijo);
			}
			
			depreciacionactivofijoLogic.saveDepreciacionActivoFijos();
			
			//this.connexion.commit();
			
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}

	}
	
	
	public Boolean ProcesarInformacionProcesarCalcularDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness,String sTipoBusqueda,Long id_anioBusquedaProcesarCalcularDepreciaciones,Long id_mesBusquedaProcesarCalcularDepreciaciones,Long id_detalle_grupo_activo_fijoBusquedaProcesarCalcularDepreciaciones,Long id_sub_grupo_activo_fijoBusquedaProcesarCalcularDepreciaciones) throws Exception {
		Boolean procesado=false;

		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();

			connexion.commit();
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}

		return procesado;
	}

	//CONTROL_FUNCION1
	
	
	
	
	
	public static void quitarEspaciosProcesarCalcularDepreciaciones(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesarCalcularDepreciacioness(List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones: procesarcalculardepreciacioness) {
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesarCalcularDepreciaciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness,ProcesarCalcularDepreciaciones procesarcalculardepreciaciones,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesarCalcularDepreciaciones procesarcalculardepreciacionesAux: procesarcalculardepreciacioness) {
			if((procesarcalculardepreciacionesAux.getId()==null && procesarcalculardepreciaciones.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(procesarcalculardepreciacionesAux.getId()!=null && procesarcalculardepreciaciones.getId()!=null){
				if(procesarcalculardepreciacionesAux.getId().equals(procesarcalculardepreciaciones.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesarCalcularDepreciaciones(List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones: procesarcalculardepreciacioness) {			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesarCalcularDepreciaciones() throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		
		return arrTiposSeleccionarTodos;
	}
	
	//PARA ACCIONES NORMALES
	public static GeneralEntityParameterReturnGeneral procesarAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral)throws Exception {
			try {

				//GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();


				return generalEntityReturnGeneral;

			} catch(Exception e) {
				Funciones.manageException(logger,e);
				throw e;

			} finally {

			}
	}

	public static GeneralEntityParameterReturnGeneral ProcesarInformacionProcesarCalcularDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,GeneralEntityLogic generalEntityLogic,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,String sTipoBusqueda,Long id_anioBusquedaProcesarCalcularDepreciaciones,Long id_mesBusquedaProcesarCalcularDepreciaciones,Long id_detalle_grupo_activo_fijoBusquedaProcesarCalcularDepreciaciones,Long id_sub_grupo_activo_fijoBusquedaProcesarCalcularDepreciaciones) throws Exception {

		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}

		return generalEntityReturnGeneral;
	}
	//CONTROL_FUNCION2
}

