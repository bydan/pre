/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.seguridad.util.report;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;

import com.bydan.erp.seguridad.resources.general.AuxiliarGeneral;

import com.bydan.erp.seguridad.util.report.ProcesoCambiarEjercicioPeriodoConstantesFunciones;
import com.bydan.erp.seguridad.util.report.ProcesoCambiarEjercicioPeriodoParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.report.ProcesoCambiarEjercicioPeriodoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.business.entity.report.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesoCambiarEjercicioPeriodoConstantesFunciones{		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="ProcesoCambiarEjercicioPeriodo";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoCambiarEjercicioPeriodo"+ProcesoCambiarEjercicioPeriodoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoCambiarEjercicioPeriodoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoCambiarEjercicioPeriodoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoCambiarEjercicioPeriodoConstantesFunciones.SCHEMA+"_"+ProcesoCambiarEjercicioPeriodoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCambiarEjercicioPeriodoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoCambiarEjercicioPeriodoConstantesFunciones.SCHEMA+"_"+ProcesoCambiarEjercicioPeriodoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoCambiarEjercicioPeriodoConstantesFunciones.SCHEMA+"_"+ProcesoCambiarEjercicioPeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCambiarEjercicioPeriodoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoCambiarEjercicioPeriodoConstantesFunciones.SCHEMA+"_"+ProcesoCambiarEjercicioPeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCambiarEjercicioPeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCambiarEjercicioPeriodoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCambiarEjercicioPeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCambiarEjercicioPeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCambiarEjercicioPeriodoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCambiarEjercicioPeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoCambiarEjercicioPeriodoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoCambiarEjercicioPeriodoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoCambiarEjercicioPeriodoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoCambiarEjercicioPeriodoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Cambiar Ejercicio Periodos";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Proceso Cambiar Ejercicio Periodo";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Cambiar Ejercicio Periodo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoCambiarEjercicioPeriodo";
	public static final String OBJECTNAME="procesocambiarejercicioperiodo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="proceso_cambiar_ejercicio_periodo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesocambiarejercicioperiodo from "+ProcesoCambiarEjercicioPeriodoConstantesFunciones.SPERSISTENCENAME+" procesocambiarejercicioperiodo";
	public static String QUERYSELECTNATIVE="select "+ProcesoCambiarEjercicioPeriodoConstantesFunciones.SCHEMA+"."+ProcesoCambiarEjercicioPeriodoConstantesFunciones.TABLENAME+".id,"+ProcesoCambiarEjercicioPeriodoConstantesFunciones.SCHEMA+"."+ProcesoCambiarEjercicioPeriodoConstantesFunciones.TABLENAME+".version_row,"+ProcesoCambiarEjercicioPeriodoConstantesFunciones.SCHEMA+"."+ProcesoCambiarEjercicioPeriodoConstantesFunciones.TABLENAME+".fecha_sistema from "+ProcesoCambiarEjercicioPeriodoConstantesFunciones.SCHEMA+"."+ProcesoCambiarEjercicioPeriodoConstantesFunciones.TABLENAME;//+" as "+ProcesoCambiarEjercicioPeriodoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String FECHASISTEMA= "fecha_sistema";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_FECHASISTEMA= "Fecha Sistema";
		public static final String LABEL_FECHASISTEMA_LOWER= "Fecha Sistema";
	
		
		
		
	
	public static String getProcesoCambiarEjercicioPeriodoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoCambiarEjercicioPeriodoConstantesFunciones.FECHASISTEMA)) {sLabelColumna=ProcesoCambiarEjercicioPeriodoConstantesFunciones.LABEL_FECHASISTEMA;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
	
	public static String getProcesoCambiarEjercicioPeriodoDescripcion(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesocambiarejercicioperiodo !=null/* && procesocambiarejercicioperiodo.getId()!=0*/) {
			sDescripcion=procesocambiarejercicioperiodo.getfecha_sistema().toString();//procesocambiarejercicioperiodoprocesocambiarejercicioperiodo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoCambiarEjercicioPeriodoDescripcionDetallado(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoCambiarEjercicioPeriodoConstantesFunciones.ID+"=";
		sDescripcion+=procesocambiarejercicioperiodo.getId().toString()+",";
		sDescripcion+=ProcesoCambiarEjercicioPeriodoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesocambiarejercicioperiodo.getVersionRow().toString()+",";
		sDescripcion+=ProcesoCambiarEjercicioPeriodoConstantesFunciones.FECHASISTEMA+"=";
		sDescripcion+=procesocambiarejercicioperiodo.getfecha_sistema().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoCambiarEjercicioPeriodoDescripcion(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo,String sValor) throws Exception {			
		if(procesocambiarejercicioperiodo !=null) {
			//procesocambiarejercicioperiodoprocesocambiarejercicioperiodo.getId().toString();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesoCambiarEjercicioPeriodo")) {
			sNombreIndice="Tipo=  Por Fecha Sistema";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesoCambiarEjercicioPeriodo(Date fecha_sistema) {
		String sDetalleIndice=" Parametros->";
		if(fecha_sistema!=null) {sDetalleIndice+=" Fecha Sistema="+fecha_sistema.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoCambiarEjercicioPeriodo(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoCambiarEjercicioPeriodos(List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo: procesocambiarejercicioperiodos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCambiarEjercicioPeriodo(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesocambiarejercicioperiodo.getConCambioAuxiliar()) {
			procesocambiarejercicioperiodo.setIsDeleted(procesocambiarejercicioperiodo.getIsDeletedAuxiliar());	
			procesocambiarejercicioperiodo.setIsNew(procesocambiarejercicioperiodo.getIsNewAuxiliar());	
			procesocambiarejercicioperiodo.setIsChanged(procesocambiarejercicioperiodo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesocambiarejercicioperiodo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesocambiarejercicioperiodo.setIsDeletedAuxiliar(false);	
			procesocambiarejercicioperiodo.setIsNewAuxiliar(false);	
			procesocambiarejercicioperiodo.setIsChangedAuxiliar(false);
			
			procesocambiarejercicioperiodo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCambiarEjercicioPeriodos(List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo : procesocambiarejercicioperiodos) {
			if(conAsignarBase && procesocambiarejercicioperiodo.getConCambioAuxiliar()) {
				procesocambiarejercicioperiodo.setIsDeleted(procesocambiarejercicioperiodo.getIsDeletedAuxiliar());	
				procesocambiarejercicioperiodo.setIsNew(procesocambiarejercicioperiodo.getIsNewAuxiliar());	
				procesocambiarejercicioperiodo.setIsChanged(procesocambiarejercicioperiodo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesocambiarejercicioperiodo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesocambiarejercicioperiodo.setIsDeletedAuxiliar(false);	
				procesocambiarejercicioperiodo.setIsNewAuxiliar(false);	
				procesocambiarejercicioperiodo.setIsChangedAuxiliar(false);
				
				procesocambiarejercicioperiodo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoCambiarEjercicioPeriodo(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoCambiarEjercicioPeriodos(List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodos,Boolean conEnteros) throws Exception  {
		
		for(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo: procesocambiarejercicioperiodos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoCambiarEjercicioPeriodo(List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodos,ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodoAux) throws Exception  {
		ProcesoCambiarEjercicioPeriodoConstantesFunciones.InicializarValoresProcesoCambiarEjercicioPeriodo(procesocambiarejercicioperiodoAux,true);
		
		for(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo: procesocambiarejercicioperiodos) {
			if(procesocambiarejercicioperiodo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCambiarEjercicioPeriodo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoCambiarEjercicioPeriodoConstantesFunciones.getArrayColumnasGlobalesProcesoCambiarEjercicioPeriodo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCambiarEjercicioPeriodo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoCambiarEjercicioPeriodo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodos,ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodoAux: procesocambiarejercicioperiodos) {
			if(procesocambiarejercicioperiodoAux!=null && procesocambiarejercicioperiodo!=null) {
				if((procesocambiarejercicioperiodoAux.getId()==null && procesocambiarejercicioperiodo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesocambiarejercicioperiodoAux.getId()!=null && procesocambiarejercicioperiodo.getId()!=null){
					if(procesocambiarejercicioperiodoAux.getId().equals(procesocambiarejercicioperiodo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoCambiarEjercicioPeriodo(List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo: procesocambiarejercicioperiodos) {			
			if(procesocambiarejercicioperiodo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoCambiarEjercicioPeriodo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoCambiarEjercicioPeriodo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCambiarEjercicioPeriodo() throws Exception  {
		return ProcesoCambiarEjercicioPeriodoConstantesFunciones.getTiposSeleccionarProcesoCambiarEjercicioPeriodo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCambiarEjercicioPeriodo(Boolean conFk) throws Exception  {
		return ProcesoCambiarEjercicioPeriodoConstantesFunciones.getTiposSeleccionarProcesoCambiarEjercicioPeriodo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCambiarEjercicioPeriodo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCambiarEjercicioPeriodoConstantesFunciones.LABEL_FECHASISTEMA);
			reporte.setsDescripcion(ProcesoCambiarEjercicioPeriodoConstantesFunciones.LABEL_FECHASISTEMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoCambiarEjercicioPeriodo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCambiarEjercicioPeriodo(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCambiarEjercicioPeriodo(List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodosTemp) throws Exception {
		for(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodoAux:procesocambiarejercicioperiodosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoCambiarEjercicioPeriodo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoCambiarEjercicioPeriodo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCambiarEjercicioPeriodo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCambiarEjercicioPeriodoConstantesFunciones.getClassesRelationshipsOfProcesoCambiarEjercicioPeriodo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCambiarEjercicioPeriodo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCambiarEjercicioPeriodo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCambiarEjercicioPeriodoConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoCambiarEjercicioPeriodo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCambiarEjercicioPeriodo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo,List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodos,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo,List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodos) throws Exception {
		try	{			
			for(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodoLocal:procesocambiarejercicioperiodos) {
				if(procesocambiarejercicioperiodoLocal.getId().equals(procesocambiarejercicioperiodo.getId())) {
					procesocambiarejercicioperiodoLocal.setIsSelected(procesocambiarejercicioperiodo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoCambiarEjercicioPeriodo(List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodosAux) throws Exception {
		//this.procesocambiarejercicioperiodosAux=procesocambiarejercicioperiodosAux;
		
		for(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodoAux:procesocambiarejercicioperiodosAux) {
			if(procesocambiarejercicioperiodoAux.getIsChanged()) {
				procesocambiarejercicioperiodoAux.setIsChanged(false);
			}		
			
			if(procesocambiarejercicioperiodoAux.getIsNew()) {
				procesocambiarejercicioperiodoAux.setIsNew(false);
			}	
			
			if(procesocambiarejercicioperiodoAux.getIsDeleted()) {
				procesocambiarejercicioperiodoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoCambiarEjercicioPeriodo(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodoAux) throws Exception {
		//this.procesocambiarejercicioperiodoAux=procesocambiarejercicioperiodoAux;
		
			if(procesocambiarejercicioperiodoAux.getIsChanged()) {
				procesocambiarejercicioperiodoAux.setIsChanged(false);
			}		
			
			if(procesocambiarejercicioperiodoAux.getIsNew()) {
				procesocambiarejercicioperiodoAux.setIsNew(false);
			}	
			
			if(procesocambiarejercicioperiodoAux.getIsDeleted()) {
				procesocambiarejercicioperiodoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodoAsignar,ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo) throws Exception {
		procesocambiarejercicioperiodoAsignar.setId(procesocambiarejercicioperiodo.getId());	
		procesocambiarejercicioperiodoAsignar.setVersionRow(procesocambiarejercicioperiodo.getVersionRow());	
	}
	
	public static void inicializarProcesoCambiarEjercicioPeriodo(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo) throws Exception {
		try {
				procesocambiarejercicioperiodo.setId(0L);	
					
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoCambiarEjercicioPeriodo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCambiarEjercicioPeriodoConstantesFunciones.LABEL_FECHASISTEMA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoCambiarEjercicioPeriodo(String sTipo,Row row,Workbook workbook,ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocambiarejercicioperiodo.getfecha_sistema());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoCambiarEjercicioPeriodo="";
	
	public String getsFinalQueryProcesoCambiarEjercicioPeriodo() {
		return this.sFinalQueryProcesoCambiarEjercicioPeriodo;
	}
	
	public void setsFinalQueryProcesoCambiarEjercicioPeriodo(String sFinalQueryProcesoCambiarEjercicioPeriodo) {
		this.sFinalQueryProcesoCambiarEjercicioPeriodo= sFinalQueryProcesoCambiarEjercicioPeriodo;
	}
	
	public Border resaltarSeleccionarProcesoCambiarEjercicioPeriodo=null;
	
	public Border setResaltarSeleccionarProcesoCambiarEjercicioPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarEjercicioPeriodoBeanSwingJInternalFrame procesocambiarejercicioperiodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesocambiarejercicioperiodoBeanSwingJInternalFrame.jTtoolBarProcesoCambiarEjercicioPeriodo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoCambiarEjercicioPeriodo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoCambiarEjercicioPeriodo() {
		return this.resaltarSeleccionarProcesoCambiarEjercicioPeriodo;
	}
	
	public void setResaltarSeleccionarProcesoCambiarEjercicioPeriodo(Border borderResaltarSeleccionarProcesoCambiarEjercicioPeriodo) {
		this.resaltarSeleccionarProcesoCambiarEjercicioPeriodo= borderResaltarSeleccionarProcesoCambiarEjercicioPeriodo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoCambiarEjercicioPeriodo=null;
	public Boolean mostraridProcesoCambiarEjercicioPeriodo=true;
	public Boolean activaridProcesoCambiarEjercicioPeriodo=true;

	public Border resaltarfecha_sistemaProcesoCambiarEjercicioPeriodo=null;
	public Boolean mostrarfecha_sistemaProcesoCambiarEjercicioPeriodo=true;
	public Boolean activarfecha_sistemaProcesoCambiarEjercicioPeriodo=true;

	
	

	public Border setResaltaridProcesoCambiarEjercicioPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarEjercicioPeriodoBeanSwingJInternalFrame procesocambiarejercicioperiodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocambiarejercicioperiodoBeanSwingJInternalFrame.jTtoolBarProcesoCambiarEjercicioPeriodo.setBorder(borderResaltar);
		
		this.resaltaridProcesoCambiarEjercicioPeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoCambiarEjercicioPeriodo() {
		return this.resaltaridProcesoCambiarEjercicioPeriodo;
	}

	public void setResaltaridProcesoCambiarEjercicioPeriodo(Border borderResaltar) {
		this.resaltaridProcesoCambiarEjercicioPeriodo= borderResaltar;
	}

	public Boolean getMostraridProcesoCambiarEjercicioPeriodo() {
		return this.mostraridProcesoCambiarEjercicioPeriodo;
	}

	public void setMostraridProcesoCambiarEjercicioPeriodo(Boolean mostraridProcesoCambiarEjercicioPeriodo) {
		this.mostraridProcesoCambiarEjercicioPeriodo= mostraridProcesoCambiarEjercicioPeriodo;
	}

	public Boolean getActivaridProcesoCambiarEjercicioPeriodo() {
		return this.activaridProcesoCambiarEjercicioPeriodo;
	}

	public void setActivaridProcesoCambiarEjercicioPeriodo(Boolean activaridProcesoCambiarEjercicioPeriodo) {
		this.activaridProcesoCambiarEjercicioPeriodo= activaridProcesoCambiarEjercicioPeriodo;
	}

	public Border setResaltarfecha_sistemaProcesoCambiarEjercicioPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarEjercicioPeriodoBeanSwingJInternalFrame procesocambiarejercicioperiodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocambiarejercicioperiodoBeanSwingJInternalFrame.jTtoolBarProcesoCambiarEjercicioPeriodo.setBorder(borderResaltar);
		
		this.resaltarfecha_sistemaProcesoCambiarEjercicioPeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_sistemaProcesoCambiarEjercicioPeriodo() {
		return this.resaltarfecha_sistemaProcesoCambiarEjercicioPeriodo;
	}

	public void setResaltarfecha_sistemaProcesoCambiarEjercicioPeriodo(Border borderResaltar) {
		this.resaltarfecha_sistemaProcesoCambiarEjercicioPeriodo= borderResaltar;
	}

	public Boolean getMostrarfecha_sistemaProcesoCambiarEjercicioPeriodo() {
		return this.mostrarfecha_sistemaProcesoCambiarEjercicioPeriodo;
	}

	public void setMostrarfecha_sistemaProcesoCambiarEjercicioPeriodo(Boolean mostrarfecha_sistemaProcesoCambiarEjercicioPeriodo) {
		this.mostrarfecha_sistemaProcesoCambiarEjercicioPeriodo= mostrarfecha_sistemaProcesoCambiarEjercicioPeriodo;
	}

	public Boolean getActivarfecha_sistemaProcesoCambiarEjercicioPeriodo() {
		return this.activarfecha_sistemaProcesoCambiarEjercicioPeriodo;
	}

	public void setActivarfecha_sistemaProcesoCambiarEjercicioPeriodo(Boolean activarfecha_sistemaProcesoCambiarEjercicioPeriodo) {
		this.activarfecha_sistemaProcesoCambiarEjercicioPeriodo= activarfecha_sistemaProcesoCambiarEjercicioPeriodo;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridProcesoCambiarEjercicioPeriodo(esInicial);
		this.setMostrarfecha_sistemaProcesoCambiarEjercicioPeriodo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCambiarEjercicioPeriodoConstantesFunciones.ID)) {
				this.setMostraridProcesoCambiarEjercicioPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarEjercicioPeriodoConstantesFunciones.FECHASISTEMA)) {
				this.setMostrarfecha_sistemaProcesoCambiarEjercicioPeriodo(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridProcesoCambiarEjercicioPeriodo(esInicial);
		this.setActivarfecha_sistemaProcesoCambiarEjercicioPeriodo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCambiarEjercicioPeriodoConstantesFunciones.ID)) {
				this.setActivaridProcesoCambiarEjercicioPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarEjercicioPeriodoConstantesFunciones.FECHASISTEMA)) {
				this.setActivarfecha_sistemaProcesoCambiarEjercicioPeriodo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCambiarEjercicioPeriodoBeanSwingJInternalFrame procesocambiarejercicioperiodoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoCambiarEjercicioPeriodo(esInicial);
		this.setResaltarfecha_sistemaProcesoCambiarEjercicioPeriodo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCambiarEjercicioPeriodoConstantesFunciones.ID)) {
				this.setResaltaridProcesoCambiarEjercicioPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarEjercicioPeriodoConstantesFunciones.FECHASISTEMA)) {
				this.setResaltarfecha_sistemaProcesoCambiarEjercicioPeriodo(esAsigna);
				continue;
			}
		}
	}
	
			
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCambiarEjercicioPeriodoBeanSwingJInternalFrame procesocambiarejercicioperiodoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarBusquedaProcesoCambiarEjercicioPeriodoProcesoCambiarEjercicioPeriodo=true;

	public Boolean getMostrarBusquedaProcesoCambiarEjercicioPeriodoProcesoCambiarEjercicioPeriodo() {
		return this.mostrarBusquedaProcesoCambiarEjercicioPeriodoProcesoCambiarEjercicioPeriodo;
	}

	public void setMostrarBusquedaProcesoCambiarEjercicioPeriodoProcesoCambiarEjercicioPeriodo(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoCambiarEjercicioPeriodoProcesoCambiarEjercicioPeriodo= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoCambiarEjercicioPeriodoProcesoCambiarEjercicioPeriodo=true;

	public Boolean getActivarBusquedaProcesoCambiarEjercicioPeriodoProcesoCambiarEjercicioPeriodo() {
		return this.activarBusquedaProcesoCambiarEjercicioPeriodoProcesoCambiarEjercicioPeriodo;
	}

	public void setActivarBusquedaProcesoCambiarEjercicioPeriodoProcesoCambiarEjercicioPeriodo(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoCambiarEjercicioPeriodoProcesoCambiarEjercicioPeriodo= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoCambiarEjercicioPeriodoProcesoCambiarEjercicioPeriodo=null;

	public Border getResaltarBusquedaProcesoCambiarEjercicioPeriodoProcesoCambiarEjercicioPeriodo() {
		return this.resaltarBusquedaProcesoCambiarEjercicioPeriodoProcesoCambiarEjercicioPeriodo;
	}

	public void setResaltarBusquedaProcesoCambiarEjercicioPeriodoProcesoCambiarEjercicioPeriodo(Border borderResaltar) {
		this.resaltarBusquedaProcesoCambiarEjercicioPeriodoProcesoCambiarEjercicioPeriodo= borderResaltar;
	}

	public void setResaltarBusquedaProcesoCambiarEjercicioPeriodoProcesoCambiarEjercicioPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarEjercicioPeriodoBeanSwingJInternalFrame procesocambiarejercicioperiodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoCambiarEjercicioPeriodoProcesoCambiarEjercicioPeriodo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}