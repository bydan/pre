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
package com.bydan.erp.activosfijos.util.report;

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

import com.bydan.erp.activosfijos.resources.general.AuxiliarGeneral;

import com.bydan.erp.activosfijos.util.report.ProcesarCrearIndicesConstantesFunciones;
import com.bydan.erp.activosfijos.util.report.ProcesarCrearIndicesParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.ProcesarCrearIndicesParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.report.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesarCrearIndicesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesarCrearIndices";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesarCrearIndices"+ProcesarCrearIndicesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesarCrearIndicesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesarCrearIndicesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesarCrearIndicesConstantesFunciones.SCHEMA+"_"+ProcesarCrearIndicesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesarCrearIndicesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesarCrearIndicesConstantesFunciones.SCHEMA+"_"+ProcesarCrearIndicesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesarCrearIndicesConstantesFunciones.SCHEMA+"_"+ProcesarCrearIndicesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesarCrearIndicesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesarCrearIndicesConstantesFunciones.SCHEMA+"_"+ProcesarCrearIndicesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesarCrearIndicesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesarCrearIndicesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesarCrearIndicesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesarCrearIndicesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesarCrearIndicesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesarCrearIndicesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesarCrearIndicesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesarCrearIndicesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesarCrearIndicesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesarCrearIndicesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Procesar Crear Indiceses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Procesar Crear Indices";
	public static final String SCLASSWEBTITULO_LOWER="Procesar Crear Indices";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesarCrearIndices";
	public static final String OBJECTNAME="procesarcrearindices";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="procesar_crear_indices";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesarcrearindices from "+ProcesarCrearIndicesConstantesFunciones.SPERSISTENCENAME+" procesarcrearindices";
	public static String QUERYSELECTNATIVE="select "+ProcesarCrearIndicesConstantesFunciones.SCHEMA+"."+ProcesarCrearIndicesConstantesFunciones.TABLENAME+".id,"+ProcesarCrearIndicesConstantesFunciones.SCHEMA+"."+ProcesarCrearIndicesConstantesFunciones.TABLENAME+".version_row from "+ProcesarCrearIndicesConstantesFunciones.SCHEMA+"."+ProcesarCrearIndicesConstantesFunciones.TABLENAME;//+" as "+ProcesarCrearIndicesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
	
		
		
	
	public static String getProcesarCrearIndicesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		
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
	
	
	
			
			
	
	public static String getProcesarCrearIndicesDescripcion(ProcesarCrearIndices procesarcrearindices) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesarcrearindices !=null/* && procesarcrearindices.getId()!=0*/) {
			if(procesarcrearindices.getId()!=null) {
				sDescripcion=procesarcrearindices.getId().toString();
			}//procesarcrearindicesprocesarcrearindices.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesarCrearIndicesDescripcionDetallado(ProcesarCrearIndices procesarcrearindices) {
		String sDescripcion="";
			
		sDescripcion+=ProcesarCrearIndicesConstantesFunciones.ID+"=";
		sDescripcion+=procesarcrearindices.getId().toString()+",";
		sDescripcion+=ProcesarCrearIndicesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesarcrearindices.getVersionRow().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesarCrearIndicesDescripcion(ProcesarCrearIndices procesarcrearindices,String sValor) throws Exception {			
		if(procesarcrearindices !=null) {
			//procesarcrearindicesprocesarcrearindices.getId().toString();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesarCrearIndices")) {
			sNombreIndice="Tipo=  Por Id";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesarCrearIndices(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesarCrearIndices(ProcesarCrearIndices procesarcrearindices,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesarCrearIndicess(List<ProcesarCrearIndices> procesarcrearindicess,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesarCrearIndices procesarcrearindices: procesarcrearindicess) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesarCrearIndices(ProcesarCrearIndices procesarcrearindices,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesarcrearindices.getConCambioAuxiliar()) {
			procesarcrearindices.setIsDeleted(procesarcrearindices.getIsDeletedAuxiliar());	
			procesarcrearindices.setIsNew(procesarcrearindices.getIsNewAuxiliar());	
			procesarcrearindices.setIsChanged(procesarcrearindices.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesarcrearindices.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesarcrearindices.setIsDeletedAuxiliar(false);	
			procesarcrearindices.setIsNewAuxiliar(false);	
			procesarcrearindices.setIsChangedAuxiliar(false);
			
			procesarcrearindices.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesarCrearIndicess(List<ProcesarCrearIndices> procesarcrearindicess,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesarCrearIndices procesarcrearindices : procesarcrearindicess) {
			if(conAsignarBase && procesarcrearindices.getConCambioAuxiliar()) {
				procesarcrearindices.setIsDeleted(procesarcrearindices.getIsDeletedAuxiliar());	
				procesarcrearindices.setIsNew(procesarcrearindices.getIsNewAuxiliar());	
				procesarcrearindices.setIsChanged(procesarcrearindices.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesarcrearindices.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesarcrearindices.setIsDeletedAuxiliar(false);	
				procesarcrearindices.setIsNewAuxiliar(false);	
				procesarcrearindices.setIsChangedAuxiliar(false);
				
				procesarcrearindices.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesarCrearIndices(ProcesarCrearIndices procesarcrearindices,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesarCrearIndicess(List<ProcesarCrearIndices> procesarcrearindicess,Boolean conEnteros) throws Exception  {
		
		for(ProcesarCrearIndices procesarcrearindices: procesarcrearindicess) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesarCrearIndices(List<ProcesarCrearIndices> procesarcrearindicess,ProcesarCrearIndices procesarcrearindicesAux) throws Exception  {
		ProcesarCrearIndicesConstantesFunciones.InicializarValoresProcesarCrearIndices(procesarcrearindicesAux,true);
		
		for(ProcesarCrearIndices procesarcrearindices: procesarcrearindicess) {
			if(procesarcrearindices.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesarCrearIndices(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesarCrearIndicesConstantesFunciones.getArrayColumnasGlobalesProcesarCrearIndices(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesarCrearIndices(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesarCrearIndices(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesarCrearIndices> procesarcrearindicess,ProcesarCrearIndices procesarcrearindices,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesarCrearIndices procesarcrearindicesAux: procesarcrearindicess) {
			if(procesarcrearindicesAux!=null && procesarcrearindices!=null) {
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
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesarCrearIndices(List<ProcesarCrearIndices> procesarcrearindicess) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesarCrearIndices procesarcrearindices: procesarcrearindicess) {			
			if(procesarcrearindices.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesarCrearIndices() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesarCrearIndices() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesarCrearIndices() throws Exception  {
		return ProcesarCrearIndicesConstantesFunciones.getTiposSeleccionarProcesarCrearIndices(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesarCrearIndices(Boolean conFk) throws Exception  {
		return ProcesarCrearIndicesConstantesFunciones.getTiposSeleccionarProcesarCrearIndices(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesarCrearIndices(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesarCrearIndices(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesarCrearIndices(ProcesarCrearIndices procesarcrearindicesAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesProcesarCrearIndices(List<ProcesarCrearIndices> procesarcrearindicessTemp) throws Exception {
		for(ProcesarCrearIndices procesarcrearindicesAux:procesarcrearindicessTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesarCrearIndices(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesarCrearIndices(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesarCrearIndices(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesarCrearIndicesConstantesFunciones.getClassesRelationshipsOfProcesarCrearIndices(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesarCrearIndices(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesarCrearIndices(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesarCrearIndicesConstantesFunciones.getClassesRelationshipsFromStringsOfProcesarCrearIndices(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesarCrearIndices(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesarCrearIndices procesarcrearindices,List<ProcesarCrearIndices> procesarcrearindicess,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesarCrearIndices procesarcrearindices,List<ProcesarCrearIndices> procesarcrearindicess) throws Exception {
		try	{			
			for(ProcesarCrearIndices procesarcrearindicesLocal:procesarcrearindicess) {
				if(procesarcrearindicesLocal.getId().equals(procesarcrearindices.getId())) {
					procesarcrearindicesLocal.setIsSelected(procesarcrearindices.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesarCrearIndices(List<ProcesarCrearIndices> procesarcrearindicessAux) throws Exception {
		//this.procesarcrearindicessAux=procesarcrearindicessAux;
		
		for(ProcesarCrearIndices procesarcrearindicesAux:procesarcrearindicessAux) {
			if(procesarcrearindicesAux.getIsChanged()) {
				procesarcrearindicesAux.setIsChanged(false);
			}		
			
			if(procesarcrearindicesAux.getIsNew()) {
				procesarcrearindicesAux.setIsNew(false);
			}	
			
			if(procesarcrearindicesAux.getIsDeleted()) {
				procesarcrearindicesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesarCrearIndices(ProcesarCrearIndices procesarcrearindicesAux) throws Exception {
		//this.procesarcrearindicesAux=procesarcrearindicesAux;
		
			if(procesarcrearindicesAux.getIsChanged()) {
				procesarcrearindicesAux.setIsChanged(false);
			}		
			
			if(procesarcrearindicesAux.getIsNew()) {
				procesarcrearindicesAux.setIsNew(false);
			}	
			
			if(procesarcrearindicesAux.getIsDeleted()) {
				procesarcrearindicesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesarCrearIndices procesarcrearindicesAsignar,ProcesarCrearIndices procesarcrearindices) throws Exception {
		procesarcrearindicesAsignar.setVersionRow(procesarcrearindices.getVersionRow());	
	}
	
	public static void inicializarProcesarCrearIndices(ProcesarCrearIndices procesarcrearindices) throws Exception {
		try {
					
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesarCrearIndices(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		
	}
	
	public static void generarExcelReporteDataProcesarCrearIndices(String sTipo,Row row,Workbook workbook,ProcesarCrearIndices procesarcrearindices,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesarCrearIndices="";
	
	public String getsFinalQueryProcesarCrearIndices() {
		return this.sFinalQueryProcesarCrearIndices;
	}
	
	public void setsFinalQueryProcesarCrearIndices(String sFinalQueryProcesarCrearIndices) {
		this.sFinalQueryProcesarCrearIndices= sFinalQueryProcesarCrearIndices;
	}
	
	public Border resaltarSeleccionarProcesarCrearIndices=null;
	
	public Border setResaltarSeleccionarProcesarCrearIndices(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesarCrearIndicesBeanSwingJInternalFrame procesarcrearindicesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesarcrearindicesBeanSwingJInternalFrame.jTtoolBarProcesarCrearIndices.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesarCrearIndices= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesarCrearIndices() {
		return this.resaltarSeleccionarProcesarCrearIndices;
	}
	
	public void setResaltarSeleccionarProcesarCrearIndices(Border borderResaltarSeleccionarProcesarCrearIndices) {
		this.resaltarSeleccionarProcesarCrearIndices= borderResaltarSeleccionarProcesarCrearIndices;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesarCrearIndices=null;
	public Boolean mostraridProcesarCrearIndices=true;
	public Boolean activaridProcesarCrearIndices=true;

	
	

	public Border setResaltaridProcesarCrearIndices(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesarCrearIndicesBeanSwingJInternalFrame procesarcrearindicesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesarcrearindicesBeanSwingJInternalFrame.jTtoolBarProcesarCrearIndices.setBorder(borderResaltar);
		
		this.resaltaridProcesarCrearIndices= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesarCrearIndices() {
		return this.resaltaridProcesarCrearIndices;
	}

	public void setResaltaridProcesarCrearIndices(Border borderResaltar) {
		this.resaltaridProcesarCrearIndices= borderResaltar;
	}

	public Boolean getMostraridProcesarCrearIndices() {
		return this.mostraridProcesarCrearIndices;
	}

	public void setMostraridProcesarCrearIndices(Boolean mostraridProcesarCrearIndices) {
		this.mostraridProcesarCrearIndices= mostraridProcesarCrearIndices;
	}

	public Boolean getActivaridProcesarCrearIndices() {
		return this.activaridProcesarCrearIndices;
	}

	public void setActivaridProcesarCrearIndices(Boolean activaridProcesarCrearIndices) {
		this.activaridProcesarCrearIndices= activaridProcesarCrearIndices;
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
		
		
		this.setMostraridProcesarCrearIndices(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesarCrearIndicesConstantesFunciones.ID)) {
				this.setMostraridProcesarCrearIndices(esAsigna);
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
		
		
		this.setActivaridProcesarCrearIndices(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesarCrearIndicesConstantesFunciones.ID)) {
				this.setActivaridProcesarCrearIndices(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesarCrearIndicesBeanSwingJInternalFrame procesarcrearindicesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesarCrearIndices(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesarCrearIndicesConstantesFunciones.ID)) {
				this.setResaltaridProcesarCrearIndices(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesarCrearIndicesBeanSwingJInternalFrame procesarcrearindicesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesarCrearIndicesProcesarCrearIndices=true;

	public Boolean getMostrarBusquedaProcesarCrearIndicesProcesarCrearIndices() {
		return this.mostrarBusquedaProcesarCrearIndicesProcesarCrearIndices;
	}

	public void setMostrarBusquedaProcesarCrearIndicesProcesarCrearIndices(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesarCrearIndicesProcesarCrearIndices= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesarCrearIndicesProcesarCrearIndices=true;

	public Boolean getActivarBusquedaProcesarCrearIndicesProcesarCrearIndices() {
		return this.activarBusquedaProcesarCrearIndicesProcesarCrearIndices;
	}

	public void setActivarBusquedaProcesarCrearIndicesProcesarCrearIndices(Boolean habilitarResaltar) {
		this.activarBusquedaProcesarCrearIndicesProcesarCrearIndices= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesarCrearIndicesProcesarCrearIndices=null;

	public Border getResaltarBusquedaProcesarCrearIndicesProcesarCrearIndices() {
		return this.resaltarBusquedaProcesarCrearIndicesProcesarCrearIndices;
	}

	public void setResaltarBusquedaProcesarCrearIndicesProcesarCrearIndices(Border borderResaltar) {
		this.resaltarBusquedaProcesarCrearIndicesProcesarCrearIndices= borderResaltar;
	}

	public void setResaltarBusquedaProcesarCrearIndicesProcesarCrearIndices(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesarCrearIndicesBeanSwingJInternalFrame procesarcrearindicesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesarCrearIndicesProcesarCrearIndices= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}