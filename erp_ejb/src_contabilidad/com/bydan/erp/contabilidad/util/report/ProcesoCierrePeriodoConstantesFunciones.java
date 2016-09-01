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
package com.bydan.erp.contabilidad.util.report;

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


import com.bydan.erp.contabilidad.util.report.ProcesoCierrePeriodoConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.ProcesoCierrePeriodoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.ProcesoCierrePeriodoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;



import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesoCierrePeriodoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoCierrePeriodo";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoCierrePeriodo"+ProcesoCierrePeriodoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoCierrePeriodoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoCierrePeriodoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoCierrePeriodoConstantesFunciones.SCHEMA+"_"+ProcesoCierrePeriodoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCierrePeriodoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoCierrePeriodoConstantesFunciones.SCHEMA+"_"+ProcesoCierrePeriodoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoCierrePeriodoConstantesFunciones.SCHEMA+"_"+ProcesoCierrePeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCierrePeriodoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoCierrePeriodoConstantesFunciones.SCHEMA+"_"+ProcesoCierrePeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCierrePeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCierrePeriodoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCierrePeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCierrePeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCierrePeriodoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCierrePeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoCierrePeriodoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoCierrePeriodoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoCierrePeriodoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoCierrePeriodoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cierre Periodo Mensuales";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cierre Periodo Mensual";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Cierre Periodo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoCierrePeriodo";
	public static final String OBJECTNAME="procesocierreperiodo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="proceso_cierre_periodo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesocierreperiodo from "+ProcesoCierrePeriodoConstantesFunciones.SPERSISTENCENAME+" procesocierreperiodo";
	public static String QUERYSELECTNATIVE="select "+ProcesoCierrePeriodoConstantesFunciones.SCHEMA+"."+ProcesoCierrePeriodoConstantesFunciones.TABLENAME+".id,"+ProcesoCierrePeriodoConstantesFunciones.SCHEMA+"."+ProcesoCierrePeriodoConstantesFunciones.TABLENAME+".version_row,"+ProcesoCierrePeriodoConstantesFunciones.SCHEMA+"."+ProcesoCierrePeriodoConstantesFunciones.TABLENAME+".id_ejercicio,"+ProcesoCierrePeriodoConstantesFunciones.SCHEMA+"."+ProcesoCierrePeriodoConstantesFunciones.TABLENAME+".id_periodo,"+ProcesoCierrePeriodoConstantesFunciones.SCHEMA+"."+ProcesoCierrePeriodoConstantesFunciones.TABLENAME+".id_estado_periodo from "+ProcesoCierrePeriodoConstantesFunciones.SCHEMA+"."+ProcesoCierrePeriodoConstantesFunciones.TABLENAME;//+" as "+ProcesoCierrePeriodoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDESTADOPERIODO= "id_estado_periodo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDESTADOPERIODO= "Estado Periodo";
		public static final String LABEL_IDESTADOPERIODO_LOWER= "Estado Periodo";
	
		
		
		
		
		
	
	public static String getProcesoCierrePeriodoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoCierrePeriodoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=ProcesoCierrePeriodoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(ProcesoCierrePeriodoConstantesFunciones.IDPERIODO)) {sLabelColumna=ProcesoCierrePeriodoConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(ProcesoCierrePeriodoConstantesFunciones.IDESTADOPERIODO)) {sLabelColumna=ProcesoCierrePeriodoConstantesFunciones.LABEL_IDESTADOPERIODO;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getProcesoCierrePeriodoDescripcion(ProcesoCierrePeriodo procesocierreperiodo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesocierreperiodo !=null/* && procesocierreperiodo.getId()!=0*/) {
			if(procesocierreperiodo.getId()!=null) {
				sDescripcion=procesocierreperiodo.getId().toString();
			}//procesocierreperiodoprocesocierreperiodo.getId().toString().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoCierrePeriodoDescripcionDetallado(ProcesoCierrePeriodo procesocierreperiodo) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoCierrePeriodoConstantesFunciones.ID+"=";
		sDescripcion+=procesocierreperiodo.getId().toString()+",";
		sDescripcion+=ProcesoCierrePeriodoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesocierreperiodo.getVersionRow().toString()+",";
		sDescripcion+=ProcesoCierrePeriodoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=procesocierreperiodo.getid_ejercicio().toString()+",";
		sDescripcion+=ProcesoCierrePeriodoConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=procesocierreperiodo.getid_periodo().toString()+",";
		sDescripcion+=ProcesoCierrePeriodoConstantesFunciones.IDESTADOPERIODO+"=";
		sDescripcion+=procesocierreperiodo.getid_estado_periodo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoCierrePeriodoDescripcion(ProcesoCierrePeriodo procesocierreperiodo,String sValor) throws Exception {			
		if(procesocierreperiodo !=null) {
			;//procesocierreperiodoprocesocierreperiodo.getId().toString().trim();
		}		
	}
	
		

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getEstadoPeriodoDescripcion(EstadoPeriodo estadoperiodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadoperiodo!=null/*&&estadoperiodo.getId()>0*/) {
			sDescripcion=EstadoPeriodoConstantesFunciones.getEstadoPeriodoDescripcion(estadoperiodo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorIdEjercicioPorIdPeriodoPorEstado")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Periodo Por Estado Periodo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorIdEjercicioPorIdPeriodoPorEstado(Long id_ejercicio,Long id_periodo,Long id_estado_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();}
		if(id_estado_periodo!=null) {sDetalleIndice+=" Codigo Unico De Estado Periodo="+id_estado_periodo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoCierrePeriodo(ProcesoCierrePeriodo procesocierreperiodo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoCierrePeriodos(List<ProcesoCierrePeriodo> procesocierreperiodos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoCierrePeriodo procesocierreperiodo: procesocierreperiodos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCierrePeriodo(ProcesoCierrePeriodo procesocierreperiodo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesocierreperiodo.getConCambioAuxiliar()) {
			procesocierreperiodo.setIsDeleted(procesocierreperiodo.getIsDeletedAuxiliar());	
			procesocierreperiodo.setIsNew(procesocierreperiodo.getIsNewAuxiliar());	
			procesocierreperiodo.setIsChanged(procesocierreperiodo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesocierreperiodo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesocierreperiodo.setIsDeletedAuxiliar(false);	
			procesocierreperiodo.setIsNewAuxiliar(false);	
			procesocierreperiodo.setIsChangedAuxiliar(false);
			
			procesocierreperiodo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCierrePeriodos(List<ProcesoCierrePeriodo> procesocierreperiodos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoCierrePeriodo procesocierreperiodo : procesocierreperiodos) {
			if(conAsignarBase && procesocierreperiodo.getConCambioAuxiliar()) {
				procesocierreperiodo.setIsDeleted(procesocierreperiodo.getIsDeletedAuxiliar());	
				procesocierreperiodo.setIsNew(procesocierreperiodo.getIsNewAuxiliar());	
				procesocierreperiodo.setIsChanged(procesocierreperiodo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesocierreperiodo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesocierreperiodo.setIsDeletedAuxiliar(false);	
				procesocierreperiodo.setIsNewAuxiliar(false);	
				procesocierreperiodo.setIsChangedAuxiliar(false);
				
				procesocierreperiodo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoCierrePeriodo(ProcesoCierrePeriodo procesocierreperiodo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoCierrePeriodos(List<ProcesoCierrePeriodo> procesocierreperiodos,Boolean conEnteros) throws Exception  {
		
		for(ProcesoCierrePeriodo procesocierreperiodo: procesocierreperiodos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoCierrePeriodo(List<ProcesoCierrePeriodo> procesocierreperiodos,ProcesoCierrePeriodo procesocierreperiodoAux) throws Exception  {
		ProcesoCierrePeriodoConstantesFunciones.InicializarValoresProcesoCierrePeriodo(procesocierreperiodoAux,true);
		
		for(ProcesoCierrePeriodo procesocierreperiodo: procesocierreperiodos) {
			if(procesocierreperiodo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCierrePeriodo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoCierrePeriodoConstantesFunciones.getArrayColumnasGlobalesProcesoCierrePeriodo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCierrePeriodo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoCierrePeriodoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoCierrePeriodoConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoCierrePeriodoConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoCierrePeriodoConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoCierrePeriodo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoCierrePeriodo> procesocierreperiodos,ProcesoCierrePeriodo procesocierreperiodo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoCierrePeriodo procesocierreperiodoAux: procesocierreperiodos) {
			if(procesocierreperiodoAux!=null && procesocierreperiodo!=null) {
				if((procesocierreperiodoAux.getId()==null && procesocierreperiodo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesocierreperiodoAux.getId()!=null && procesocierreperiodo.getId()!=null){
					if(procesocierreperiodoAux.getId().equals(procesocierreperiodo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoCierrePeriodo(List<ProcesoCierrePeriodo> procesocierreperiodos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoCierrePeriodo procesocierreperiodo: procesocierreperiodos) {			
			if(procesocierreperiodo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoCierrePeriodo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoCierrePeriodo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCierrePeriodo() throws Exception  {
		return ProcesoCierrePeriodoConstantesFunciones.getTiposSeleccionarProcesoCierrePeriodo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCierrePeriodo(Boolean conFk) throws Exception  {
		return ProcesoCierrePeriodoConstantesFunciones.getTiposSeleccionarProcesoCierrePeriodo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCierrePeriodo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCierrePeriodoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(ProcesoCierrePeriodoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCierrePeriodoConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(ProcesoCierrePeriodoConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCierrePeriodoConstantesFunciones.LABEL_IDESTADOPERIODO);
			reporte.setsDescripcion(ProcesoCierrePeriodoConstantesFunciones.LABEL_IDESTADOPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoCierrePeriodo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCierrePeriodo(ProcesoCierrePeriodo procesocierreperiodoAux) throws Exception {
		
			procesocierreperiodoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(procesocierreperiodoAux.getEjercicio()));
			procesocierreperiodoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(procesocierreperiodoAux.getPeriodo()));
			procesocierreperiodoAux.setestadoperiodo_descripcion(EstadoPeriodoConstantesFunciones.getEstadoPeriodoDescripcion(procesocierreperiodoAux.getEstadoPeriodo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCierrePeriodo(List<ProcesoCierrePeriodo> procesocierreperiodosTemp) throws Exception {
		for(ProcesoCierrePeriodo procesocierreperiodoAux:procesocierreperiodosTemp) {
			
			procesocierreperiodoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(procesocierreperiodoAux.getEjercicio()));
			procesocierreperiodoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(procesocierreperiodoAux.getPeriodo()));
			procesocierreperiodoAux.setestadoperiodo_descripcion(EstadoPeriodoConstantesFunciones.getEstadoPeriodoDescripcion(procesocierreperiodoAux.getEstadoPeriodo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoCierrePeriodo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(EstadoPeriodo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoPeriodo.class)) {
						classes.add(new Classe(EstadoPeriodo.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoCierrePeriodo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(EstadoPeriodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPeriodo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(EstadoPeriodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPeriodo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCierrePeriodo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCierrePeriodoConstantesFunciones.getClassesRelationshipsOfProcesoCierrePeriodo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCierrePeriodo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCierrePeriodo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCierrePeriodoConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoCierrePeriodo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCierrePeriodo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoCierrePeriodo procesocierreperiodo,List<ProcesoCierrePeriodo> procesocierreperiodos,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoCierrePeriodo procesocierreperiodo,List<ProcesoCierrePeriodo> procesocierreperiodos) throws Exception {
		try	{			
			for(ProcesoCierrePeriodo procesocierreperiodoLocal:procesocierreperiodos) {
				if(procesocierreperiodoLocal.getId().equals(procesocierreperiodo.getId())) {
					procesocierreperiodoLocal.setIsSelected(procesocierreperiodo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoCierrePeriodo(List<ProcesoCierrePeriodo> procesocierreperiodosAux) throws Exception {
		//this.procesocierreperiodosAux=procesocierreperiodosAux;
		
		for(ProcesoCierrePeriodo procesocierreperiodoAux:procesocierreperiodosAux) {
			if(procesocierreperiodoAux.getIsChanged()) {
				procesocierreperiodoAux.setIsChanged(false);
			}		
			
			if(procesocierreperiodoAux.getIsNew()) {
				procesocierreperiodoAux.setIsNew(false);
			}	
			
			if(procesocierreperiodoAux.getIsDeleted()) {
				procesocierreperiodoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoCierrePeriodo(ProcesoCierrePeriodo procesocierreperiodoAux) throws Exception {
		//this.procesocierreperiodoAux=procesocierreperiodoAux;
		
			if(procesocierreperiodoAux.getIsChanged()) {
				procesocierreperiodoAux.setIsChanged(false);
			}		
			
			if(procesocierreperiodoAux.getIsNew()) {
				procesocierreperiodoAux.setIsNew(false);
			}	
			
			if(procesocierreperiodoAux.getIsDeleted()) {
				procesocierreperiodoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoCierrePeriodo procesocierreperiodoAsignar,ProcesoCierrePeriodo procesocierreperiodo) throws Exception {
		procesocierreperiodoAsignar.setId(procesocierreperiodo.getId());	
		procesocierreperiodoAsignar.setVersionRow(procesocierreperiodo.getVersionRow());	
		procesocierreperiodoAsignar.setid_ejercicio(procesocierreperiodo.getid_ejercicio());
		procesocierreperiodoAsignar.setejercicio_descripcion(procesocierreperiodo.getejercicio_descripcion());	
	}
	
	public static void inicializarProcesoCierrePeriodo(ProcesoCierrePeriodo procesocierreperiodo) throws Exception {
		try {
				procesocierreperiodo.setId(0L);	
					
				procesocierreperiodo.setid_ejercicio(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoCierrePeriodo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCierrePeriodoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCierrePeriodoConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCierrePeriodoConstantesFunciones.LABEL_IDESTADOPERIODO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoCierrePeriodo(String sTipo,Row row,Workbook workbook,ProcesoCierrePeriodo procesocierreperiodo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocierreperiodo.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocierreperiodo.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocierreperiodo.getestadoperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoCierrePeriodo="";
	
	public String getsFinalQueryProcesoCierrePeriodo() {
		return this.sFinalQueryProcesoCierrePeriodo;
	}
	
	public void setsFinalQueryProcesoCierrePeriodo(String sFinalQueryProcesoCierrePeriodo) {
		this.sFinalQueryProcesoCierrePeriodo= sFinalQueryProcesoCierrePeriodo;
	}
	
	public Border resaltarSeleccionarProcesoCierrePeriodo=null;
	
	public Border setResaltarSeleccionarProcesoCierrePeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierrePeriodoBeanSwingJInternalFrame procesocierreperiodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesocierreperiodoBeanSwingJInternalFrame.jTtoolBarProcesoCierrePeriodo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoCierrePeriodo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoCierrePeriodo() {
		return this.resaltarSeleccionarProcesoCierrePeriodo;
	}
	
	public void setResaltarSeleccionarProcesoCierrePeriodo(Border borderResaltarSeleccionarProcesoCierrePeriodo) {
		this.resaltarSeleccionarProcesoCierrePeriodo= borderResaltarSeleccionarProcesoCierrePeriodo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoCierrePeriodo=null;
	public Boolean mostraridProcesoCierrePeriodo=true;
	public Boolean activaridProcesoCierrePeriodo=true;

	public Border resaltarid_ejercicioProcesoCierrePeriodo=null;
	public Boolean mostrarid_ejercicioProcesoCierrePeriodo=true;
	public Boolean activarid_ejercicioProcesoCierrePeriodo=true;
	public Boolean cargarid_ejercicioProcesoCierrePeriodo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioProcesoCierrePeriodo=false;//ConEventDepend=true

	public Border resaltarid_periodoProcesoCierrePeriodo=null;
	public Boolean mostrarid_periodoProcesoCierrePeriodo=true;
	public Boolean activarid_periodoProcesoCierrePeriodo=true;
	public Boolean cargarid_periodoProcesoCierrePeriodo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoProcesoCierrePeriodo=true;//ConEventDepend=true

	public Border resaltarid_estado_periodoProcesoCierrePeriodo=null;
	public Boolean mostrarid_estado_periodoProcesoCierrePeriodo=true;
	public Boolean activarid_estado_periodoProcesoCierrePeriodo=true;
	public Boolean cargarid_estado_periodoProcesoCierrePeriodo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_periodoProcesoCierrePeriodo=false;//ConEventDepend=true

	
	

	public Border setResaltaridProcesoCierrePeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierrePeriodoBeanSwingJInternalFrame procesocierreperiodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocierreperiodoBeanSwingJInternalFrame.jTtoolBarProcesoCierrePeriodo.setBorder(borderResaltar);
		
		this.resaltaridProcesoCierrePeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoCierrePeriodo() {
		return this.resaltaridProcesoCierrePeriodo;
	}

	public void setResaltaridProcesoCierrePeriodo(Border borderResaltar) {
		this.resaltaridProcesoCierrePeriodo= borderResaltar;
	}

	public Boolean getMostraridProcesoCierrePeriodo() {
		return this.mostraridProcesoCierrePeriodo;
	}

	public void setMostraridProcesoCierrePeriodo(Boolean mostraridProcesoCierrePeriodo) {
		this.mostraridProcesoCierrePeriodo= mostraridProcesoCierrePeriodo;
	}

	public Boolean getActivaridProcesoCierrePeriodo() {
		return this.activaridProcesoCierrePeriodo;
	}

	public void setActivaridProcesoCierrePeriodo(Boolean activaridProcesoCierrePeriodo) {
		this.activaridProcesoCierrePeriodo= activaridProcesoCierrePeriodo;
	}

	public Border setResaltarid_ejercicioProcesoCierrePeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierrePeriodoBeanSwingJInternalFrame procesocierreperiodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocierreperiodoBeanSwingJInternalFrame.jTtoolBarProcesoCierrePeriodo.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioProcesoCierrePeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioProcesoCierrePeriodo() {
		return this.resaltarid_ejercicioProcesoCierrePeriodo;
	}

	public void setResaltarid_ejercicioProcesoCierrePeriodo(Border borderResaltar) {
		this.resaltarid_ejercicioProcesoCierrePeriodo= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioProcesoCierrePeriodo() {
		return this.mostrarid_ejercicioProcesoCierrePeriodo;
	}

	public void setMostrarid_ejercicioProcesoCierrePeriodo(Boolean mostrarid_ejercicioProcesoCierrePeriodo) {
		this.mostrarid_ejercicioProcesoCierrePeriodo= mostrarid_ejercicioProcesoCierrePeriodo;
	}

	public Boolean getActivarid_ejercicioProcesoCierrePeriodo() {
		return this.activarid_ejercicioProcesoCierrePeriodo;
	}

	public void setActivarid_ejercicioProcesoCierrePeriodo(Boolean activarid_ejercicioProcesoCierrePeriodo) {
		this.activarid_ejercicioProcesoCierrePeriodo= activarid_ejercicioProcesoCierrePeriodo;
	}

	public Boolean getCargarid_ejercicioProcesoCierrePeriodo() {
		return this.cargarid_ejercicioProcesoCierrePeriodo;
	}

	public void setCargarid_ejercicioProcesoCierrePeriodo(Boolean cargarid_ejercicioProcesoCierrePeriodo) {
		this.cargarid_ejercicioProcesoCierrePeriodo= cargarid_ejercicioProcesoCierrePeriodo;
	}

	public Border setResaltarid_periodoProcesoCierrePeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierrePeriodoBeanSwingJInternalFrame procesocierreperiodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocierreperiodoBeanSwingJInternalFrame.jTtoolBarProcesoCierrePeriodo.setBorder(borderResaltar);
		
		this.resaltarid_periodoProcesoCierrePeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoProcesoCierrePeriodo() {
		return this.resaltarid_periodoProcesoCierrePeriodo;
	}

	public void setResaltarid_periodoProcesoCierrePeriodo(Border borderResaltar) {
		this.resaltarid_periodoProcesoCierrePeriodo= borderResaltar;
	}

	public Boolean getMostrarid_periodoProcesoCierrePeriodo() {
		return this.mostrarid_periodoProcesoCierrePeriodo;
	}

	public void setMostrarid_periodoProcesoCierrePeriodo(Boolean mostrarid_periodoProcesoCierrePeriodo) {
		this.mostrarid_periodoProcesoCierrePeriodo= mostrarid_periodoProcesoCierrePeriodo;
	}

	public Boolean getActivarid_periodoProcesoCierrePeriodo() {
		return this.activarid_periodoProcesoCierrePeriodo;
	}

	public void setActivarid_periodoProcesoCierrePeriodo(Boolean activarid_periodoProcesoCierrePeriodo) {
		this.activarid_periodoProcesoCierrePeriodo= activarid_periodoProcesoCierrePeriodo;
	}

	public Boolean getCargarid_periodoProcesoCierrePeriodo() {
		return this.cargarid_periodoProcesoCierrePeriodo;
	}

	public void setCargarid_periodoProcesoCierrePeriodo(Boolean cargarid_periodoProcesoCierrePeriodo) {
		this.cargarid_periodoProcesoCierrePeriodo= cargarid_periodoProcesoCierrePeriodo;
	}

	public Border setResaltarid_estado_periodoProcesoCierrePeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierrePeriodoBeanSwingJInternalFrame procesocierreperiodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocierreperiodoBeanSwingJInternalFrame.jTtoolBarProcesoCierrePeriodo.setBorder(borderResaltar);
		
		this.resaltarid_estado_periodoProcesoCierrePeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_periodoProcesoCierrePeriodo() {
		return this.resaltarid_estado_periodoProcesoCierrePeriodo;
	}

	public void setResaltarid_estado_periodoProcesoCierrePeriodo(Border borderResaltar) {
		this.resaltarid_estado_periodoProcesoCierrePeriodo= borderResaltar;
	}

	public Boolean getMostrarid_estado_periodoProcesoCierrePeriodo() {
		return this.mostrarid_estado_periodoProcesoCierrePeriodo;
	}

	public void setMostrarid_estado_periodoProcesoCierrePeriodo(Boolean mostrarid_estado_periodoProcesoCierrePeriodo) {
		this.mostrarid_estado_periodoProcesoCierrePeriodo= mostrarid_estado_periodoProcesoCierrePeriodo;
	}

	public Boolean getActivarid_estado_periodoProcesoCierrePeriodo() {
		return this.activarid_estado_periodoProcesoCierrePeriodo;
	}

	public void setActivarid_estado_periodoProcesoCierrePeriodo(Boolean activarid_estado_periodoProcesoCierrePeriodo) {
		this.activarid_estado_periodoProcesoCierrePeriodo= activarid_estado_periodoProcesoCierrePeriodo;
	}

	public Boolean getCargarid_estado_periodoProcesoCierrePeriodo() {
		return this.cargarid_estado_periodoProcesoCierrePeriodo;
	}

	public void setCargarid_estado_periodoProcesoCierrePeriodo(Boolean cargarid_estado_periodoProcesoCierrePeriodo) {
		this.cargarid_estado_periodoProcesoCierrePeriodo= cargarid_estado_periodoProcesoCierrePeriodo;
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
		
		
		this.setMostraridProcesoCierrePeriodo(esInicial);
		this.setMostrarid_ejercicioProcesoCierrePeriodo(esInicial);
		this.setMostrarid_periodoProcesoCierrePeriodo(esInicial);
		this.setMostrarid_estado_periodoProcesoCierrePeriodo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCierrePeriodoConstantesFunciones.ID)) {
				this.setMostraridProcesoCierrePeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierrePeriodoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioProcesoCierrePeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierrePeriodoConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoProcesoCierrePeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierrePeriodoConstantesFunciones.IDESTADOPERIODO)) {
				this.setMostrarid_estado_periodoProcesoCierrePeriodo(esAsigna);
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
		
		
		this.setActivaridProcesoCierrePeriodo(esInicial);
		this.setActivarid_ejercicioProcesoCierrePeriodo(esInicial);
		this.setActivarid_periodoProcesoCierrePeriodo(esInicial);
		this.setActivarid_estado_periodoProcesoCierrePeriodo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCierrePeriodoConstantesFunciones.ID)) {
				this.setActivaridProcesoCierrePeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierrePeriodoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioProcesoCierrePeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierrePeriodoConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoProcesoCierrePeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierrePeriodoConstantesFunciones.IDESTADOPERIODO)) {
				this.setActivarid_estado_periodoProcesoCierrePeriodo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCierrePeriodoBeanSwingJInternalFrame procesocierreperiodoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoCierrePeriodo(esInicial);
		this.setResaltarid_ejercicioProcesoCierrePeriodo(esInicial);
		this.setResaltarid_periodoProcesoCierrePeriodo(esInicial);
		this.setResaltarid_estado_periodoProcesoCierrePeriodo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCierrePeriodoConstantesFunciones.ID)) {
				this.setResaltaridProcesoCierrePeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierrePeriodoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioProcesoCierrePeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierrePeriodoConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoProcesoCierrePeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierrePeriodoConstantesFunciones.IDESTADOPERIODO)) {
				this.setResaltarid_estado_periodoProcesoCierrePeriodo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCierrePeriodoBeanSwingJInternalFrame procesocierreperiodoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorIdEjercicioPorIdPeriodoPorEstadoProcesoCierrePeriodo=true;

	public Boolean getMostrarBusquedaPorIdEjercicioPorIdPeriodoPorEstadoProcesoCierrePeriodo() {
		return this.mostrarBusquedaPorIdEjercicioPorIdPeriodoPorEstadoProcesoCierrePeriodo;
	}

	public void setMostrarBusquedaPorIdEjercicioPorIdPeriodoPorEstadoProcesoCierrePeriodo(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdEjercicioPorIdPeriodoPorEstadoProcesoCierrePeriodo= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdEjercicioPorIdPeriodoPorEstadoProcesoCierrePeriodo=true;

	public Boolean getActivarBusquedaPorIdEjercicioPorIdPeriodoPorEstadoProcesoCierrePeriodo() {
		return this.activarBusquedaPorIdEjercicioPorIdPeriodoPorEstadoProcesoCierrePeriodo;
	}

	public void setActivarBusquedaPorIdEjercicioPorIdPeriodoPorEstadoProcesoCierrePeriodo(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdEjercicioPorIdPeriodoPorEstadoProcesoCierrePeriodo= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdEjercicioPorIdPeriodoPorEstadoProcesoCierrePeriodo=null;

	public Border getResaltarBusquedaPorIdEjercicioPorIdPeriodoPorEstadoProcesoCierrePeriodo() {
		return this.resaltarBusquedaPorIdEjercicioPorIdPeriodoPorEstadoProcesoCierrePeriodo;
	}

	public void setResaltarBusquedaPorIdEjercicioPorIdPeriodoPorEstadoProcesoCierrePeriodo(Border borderResaltar) {
		this.resaltarBusquedaPorIdEjercicioPorIdPeriodoPorEstadoProcesoCierrePeriodo= borderResaltar;
	}

	public void setResaltarBusquedaPorIdEjercicioPorIdPeriodoPorEstadoProcesoCierrePeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierrePeriodoBeanSwingJInternalFrame procesocierreperiodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdEjercicioPorIdPeriodoPorEstadoProcesoCierrePeriodo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}