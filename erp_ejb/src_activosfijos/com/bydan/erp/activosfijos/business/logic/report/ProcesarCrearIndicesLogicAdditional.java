



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

import java.sql.SQLException;
import java.sql.Timestamp;

import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
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
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.activosfijos.util.report.ProcesarCrearIndicesConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.report.*;
import com.bydan.erp.activosfijos.business.logic.DetalleActivoFijoLogic;
import com.bydan.erp.activosfijos.business.logic.MetodoDepreciacionLogic;
import com.bydan.erp.activosfijos.business.logic.TipoDepreciacionEmpresaLogic;
////import com.bydan.erp.activosfijos.business.interfaces.ProcesarCrearIndicesAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings({"unused"})
final public class ProcesarCrearIndicesLogicAdditional extends ProcesarCrearIndicesLogic{		
	
	//CONTROL_INICIO
	public  ProcesarCrearIndicesLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProcesarCrearIndicesToSave(ProcesarCrearIndices procesarcrearindices,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProcesarCrearIndicesToSave(ProcesarCrearIndices procesarcrearindices,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProcesarCrearIndicesToSaveAfter(ProcesarCrearIndices procesarcrearindices,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProcesarCrearIndicesToSaves(List<ProcesarCrearIndices> procesarcrearindicess,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProcesarCrearIndicesToSaves(List<ProcesarCrearIndices> procesarcrearindicess,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProcesarCrearIndicesToSavesAfter(List<ProcesarCrearIndices> procesarcrearindicess,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProcesarCrearIndicesToGet(ProcesarCrearIndices procesarcrearindices,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProcesarCrearIndicesToGets(List<ProcesarCrearIndices> procesarcrearindicess,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProcesarCrearIndicesToSave(ProcesarCrearIndices procesarcrearindices,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProcesarCrearIndicesToGet(ProcesarCrearIndices procesarcrearindices,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProcesarCrearIndicesActions(String sTipoJsonResponse,JSONObject jsonObjectProcesarCrearIndices,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProcesarCrearIndicesDataTable(String sTipoJsonResponse,ProcesarCrearIndices procesarcrearindices,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProcesarCrearIndicessDataTable(String sTipoJsonResponse,List<ProcesarCrearIndices> procesarcrearindicess,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProcesarCrearIndicesColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProcesarCrearIndicessColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProcesarCrearIndicessColumns;
	}
	
	public static void updateJSONArrayProcesarCrearIndicesActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProcesarCrearIndices,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	

	public void BusquedaProcesarCrearIndices(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;
		List<ProcesarCrearIndices> procesarcrearindicess=new ArrayList<ProcesarCrearIndices>();
				
		this.ProcesarInformacionProcesarCrearIndices(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,procesarcrearindicess,"NONE",id);
		
		/*
		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamSql = null;//AuxiliarGeneral.class.getResourceAsStream("ProcesarCrearIndices_Postgres.sql");
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" a.id_empresa="+parametroGeneralUsuario.getid_empresa();
					//existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						//sSqlWhere+=" and";
					}
					//sSqlWhere+=" a.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					//existeWhere=true;
				}
				

				if(existeWhere) {
					sSqlWhere=" where "+sSqlWhere;
				}

				if(sSelectQuery.contains(Constantes2.S_KEYWHERE)) {
					sSql=sSelectQuery.replace(Constantes2.S_KEYWHERE,sSqlWhere);
				} else {
					sSql=sSelectQuery+sSqlWhere;
				}

				if(Constantes.ISDEVELOPING) {
					System.out.println(sSql);
				}
			}
		}
		*/
	}
	
	
	public Boolean ProcesarInformacionProcesarCrearIndices(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesarCrearIndices> procesarcrearindicess,String sTipoBusqueda,Long idBusquedaProcesarCrearIndices) throws Exception {
		Boolean procesado=false;
		String sFinalQuery="";
		String sQueryExecute="";
		DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
		MetodoDepreciacionLogic metododepreciacionLogic=new MetodoDepreciacionLogic();
		TipoDepreciacionEmpresaLogic tipodepreciacionempresaLogic=new TipoDepreciacionEmpresaLogic();

		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
			
			detalleactivofijoLogic.setConnexion(this.connexion);
			metododepreciacionLogic.setConnexion(this.connexion);
			tipodepreciacionempresaLogic.setConnexion(this.connexion);
			
			sFinalQuery=" where id_empresa="+parametroGeneralUsuario.getid_empresa();			
			detalleactivofijoLogic.getEntities(sFinalQuery);
			
			sQueryExecute="delete from activosfijos.metodo_depreciacion where id_empresa="+parametroGeneralUsuario.getid_empresa();
			metododepreciacionLogic.executeQuery(sQueryExecute);
			
			for(DetalleActivoFijo detalleactivofijo:detalleactivofijoLogic.getDetalleActivoFijos()) {						
				Long idTipoDepreciacionEmpresa=detalleactivofijo.getid_tipo_depreciacion_empresa();
				tipodepreciacionempresaLogic.getEntity(idTipoDepreciacionEmpresa);
				
				//ES MENSUAL
				if(tipodepreciacionempresaLogic.getTipoDepreciacionEmpresa().getes_mensual()) {
					this.GeneraIndiceDepreciacionMensual(detalleactivofijo,tipodepreciacionempresaLogic.getTipoDepreciacionEmpresa());
				} else {
					//ES DIARIA
				}
			}
			
			//this.connexion.commit();
			
		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}

		return procesado;
	}

	public void GeneraIndiceDepreciacionMensual(DetalleActivoFijo detalleactivofijo,TipoDepreciacionEmpresa tipoDepreciacionEmpresa) throws SQLException, Exception  {
		MetodoDepreciacion metododepreciacion=new MetodoDepreciacion();
		
		MetodoDepreciacionLogic metododepreciacionLogic=new MetodoDepreciacionLogic();
		metododepreciacionLogic.setConnexion(this.connexion);
		
		Integer anio=0;
		Integer mes=0;
		
		Date fecha_inicial=null;
		Date fecha_final=null;
		Date fecha_final_anual=null;
		
		String sFechaInicial="";
		String sFechaFinal="";
		String sFechaFinalAnual="";
		
		Double dValor=0.0;
		Double dPorcentaje=0.0;
		
		//ES UNA TABLA REFERENCIAL QUE RESUME LA DEPRECIACION MENSUAL DE UN ACTIVO
		if(detalleactivofijo.getfecha_depreciacion()!=null) {
			anio=Funciones2.GetAnioMesDiaFromDate(detalleactivofijo.getfecha_depreciacion(),"A");
			mes=Funciones2.GetAnioMesDiaFromDate(detalleactivofijo.getfecha_depreciacion(),"M");
			
			for(int i=1;i<=(detalleactivofijo.getvida_util()*12);i++) {
				dValor=0.0;
				dPorcentaje=0.0;
				
				sFechaInicial=anio+"-"+mes+"-01";
				fecha_inicial=Funciones2.GetDateFromString(sFechaInicial);
				
				sFechaFinal=anio+"-"+mes+"-"+Funciones2.GetUltimoDiaMes(fecha_inicial);
				fecha_final=Funciones2.GetDateFromString(sFechaFinal);
				
				sFechaFinalAnual=anio+"-12-31";
				fecha_final_anual=Funciones2.GetDateFromString(sFechaFinalAnual);
				
				
				metododepreciacion=new MetodoDepreciacion();
				
				metododepreciacion.setid_empresa(detalleactivofijo.getid_empresa());
				metododepreciacion.setid_sucursal(detalleactivofijo.getid_sucursal());
				metododepreciacion.setid_detalle_activo_fijo(detalleactivofijo.getId());
				metododepreciacion.setid_anio(Long.parseLong(anio.toString()));				
				metododepreciacion.setfecha_desde(fecha_inicial);
				metododepreciacion.setfecha_hasta(fecha_final);
				
				if(tipoDepreciacionEmpresa.getes_linea_recta()) {
					dValor = detalleactivofijo.getcosto_de_compra() / (detalleactivofijo.getvida_util()*12);
					dPorcentaje = dValor / detalleactivofijo.getcosto_de_compra();
				}
				
				metododepreciacion.setporcentaje(dPorcentaje);
				metododepreciacion.setvalor(dValor);
				
				//metododepreciacion.setnumero_dias(0);
				
				metododepreciacionLogic.getMetodoDepreciacions().add(metododepreciacion);
				
				if(mes.equals(12)) {
					mes=1;
				}
				
				if(fecha_final_anual.equals(fecha_final)) {
					anio=anio+1;
				}
			}
		}
		
		metododepreciacionLogic.saveMetodoDepreciacions();
	}
	
	public static GeneralEntityParameterReturnGeneral ProcesarInformacionProcesarCrearIndices(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,GeneralEntityLogic generalEntityLogic,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,String sTipoBusqueda,Long idBusquedaProcesarCrearIndices) throws Exception {

		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}

		return generalEntityReturnGeneral;
	}
	
	//CONTROL_FUNCION1
	
	
	
	
	
	public static void quitarEspaciosProcesarCrearIndices(ProcesarCrearIndices procesarcrearindices,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesarCrearIndicess(List<ProcesarCrearIndices> procesarcrearindicess,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesarCrearIndices procesarcrearindices: procesarcrearindicess) {
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesarCrearIndices(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesarCrearIndices> procesarcrearindicess,ProcesarCrearIndices procesarcrearindices,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesarCrearIndices procesarcrearindicesAux: procesarcrearindicess) {
			if((procesarcrearindicesAux.getId()==null && procesarcrearindices.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(procesarcrearindicesAux.getId()!=null && procesarcrearindices.getId()!=null){
				if(procesarcrearindicesAux.getId().equals(procesarcrearindices.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesarCrearIndices(List<ProcesarCrearIndices> procesarcrearindicess) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesarCrearIndices procesarcrearindices: procesarcrearindicess) {			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesarCrearIndices() throws Exception  {
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

	//CONTROL_FUNCION2
}