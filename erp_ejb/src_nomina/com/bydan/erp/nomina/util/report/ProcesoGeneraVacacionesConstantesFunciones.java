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
package com.bydan.erp.nomina.util.report;

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

import com.bydan.erp.nomina.resources.general.AuxiliarGeneral;

import com.bydan.erp.nomina.util.report.ProcesoGeneraVacacionesConstantesFunciones;
import com.bydan.erp.nomina.util.report.ProcesoGeneraVacacionesParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoGeneraVacacionesParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.business.entity.report.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesoGeneraVacacionesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoGeneraVacaciones";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoGeneraVacaciones"+ProcesoGeneraVacacionesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoGeneraVacacionesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoGeneraVacacionesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoGeneraVacacionesConstantesFunciones.SCHEMA+"_"+ProcesoGeneraVacacionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoGeneraVacacionesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoGeneraVacacionesConstantesFunciones.SCHEMA+"_"+ProcesoGeneraVacacionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoGeneraVacacionesConstantesFunciones.SCHEMA+"_"+ProcesoGeneraVacacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoGeneraVacacionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoGeneraVacacionesConstantesFunciones.SCHEMA+"_"+ProcesoGeneraVacacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoGeneraVacacionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoGeneraVacacionesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoGeneraVacacionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoGeneraVacacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoGeneraVacacionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoGeneraVacacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoGeneraVacacionesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoGeneraVacacionesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoGeneraVacacionesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoGeneraVacacionesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Genera Vacacioneses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Genera Vacaciones";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Genera Vacaciones";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoGeneraVacaciones";
	public static final String OBJECTNAME="procesogeneravacaciones";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="proceso_genera_vacaciones";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesogeneravacaciones from "+ProcesoGeneraVacacionesConstantesFunciones.SPERSISTENCENAME+" procesogeneravacaciones";
	public static String QUERYSELECTNATIVE="select "+ProcesoGeneraVacacionesConstantesFunciones.SCHEMA+"."+ProcesoGeneraVacacionesConstantesFunciones.TABLENAME+".id,"+ProcesoGeneraVacacionesConstantesFunciones.SCHEMA+"."+ProcesoGeneraVacacionesConstantesFunciones.TABLENAME+".version_row,"+ProcesoGeneraVacacionesConstantesFunciones.SCHEMA+"."+ProcesoGeneraVacacionesConstantesFunciones.TABLENAME+".fecha from "+ProcesoGeneraVacacionesConstantesFunciones.SCHEMA+"."+ProcesoGeneraVacacionesConstantesFunciones.TABLENAME;//+" as "+ProcesoGeneraVacacionesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String FECHA= "fecha";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
	
		
		
		
	
	public static String getProcesoGeneraVacacionesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoGeneraVacacionesConstantesFunciones.FECHA)) {sLabelColumna=ProcesoGeneraVacacionesConstantesFunciones.LABEL_FECHA;}
		
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
	
	
	
			
			
			
	
	public static String getProcesoGeneraVacacionesDescripcion(ProcesoGeneraVacaciones procesogeneravacaciones) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesogeneravacaciones !=null/* && procesogeneravacaciones.getId()!=0*/) {
			sDescripcion=procesogeneravacaciones.getfecha().toString();//procesogeneravacacionesprocesogeneravacaciones.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoGeneraVacacionesDescripcionDetallado(ProcesoGeneraVacaciones procesogeneravacaciones) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoGeneraVacacionesConstantesFunciones.ID+"=";
		sDescripcion+=procesogeneravacaciones.getId().toString()+",";
		sDescripcion+=ProcesoGeneraVacacionesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesogeneravacaciones.getVersionRow().toString()+",";
		sDescripcion+=ProcesoGeneraVacacionesConstantesFunciones.FECHA+"=";
		sDescripcion+=procesogeneravacaciones.getfecha().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoGeneraVacacionesDescripcion(ProcesoGeneraVacaciones procesogeneravacaciones,String sValor) throws Exception {			
		if(procesogeneravacaciones !=null) {
			//procesogeneravacacionesprocesogeneravacaciones.getId().toString();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoGeneraVacaciones(ProcesoGeneraVacaciones procesogeneravacaciones,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoGeneraVacacioness(List<ProcesoGeneraVacaciones> procesogeneravacacioness,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoGeneraVacaciones procesogeneravacaciones: procesogeneravacacioness) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoGeneraVacaciones(ProcesoGeneraVacaciones procesogeneravacaciones,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesogeneravacaciones.getConCambioAuxiliar()) {
			procesogeneravacaciones.setIsDeleted(procesogeneravacaciones.getIsDeletedAuxiliar());	
			procesogeneravacaciones.setIsNew(procesogeneravacaciones.getIsNewAuxiliar());	
			procesogeneravacaciones.setIsChanged(procesogeneravacaciones.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesogeneravacaciones.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesogeneravacaciones.setIsDeletedAuxiliar(false);	
			procesogeneravacaciones.setIsNewAuxiliar(false);	
			procesogeneravacaciones.setIsChangedAuxiliar(false);
			
			procesogeneravacaciones.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoGeneraVacacioness(List<ProcesoGeneraVacaciones> procesogeneravacacioness,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoGeneraVacaciones procesogeneravacaciones : procesogeneravacacioness) {
			if(conAsignarBase && procesogeneravacaciones.getConCambioAuxiliar()) {
				procesogeneravacaciones.setIsDeleted(procesogeneravacaciones.getIsDeletedAuxiliar());	
				procesogeneravacaciones.setIsNew(procesogeneravacaciones.getIsNewAuxiliar());	
				procesogeneravacaciones.setIsChanged(procesogeneravacaciones.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesogeneravacaciones.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesogeneravacaciones.setIsDeletedAuxiliar(false);	
				procesogeneravacaciones.setIsNewAuxiliar(false);	
				procesogeneravacaciones.setIsChangedAuxiliar(false);
				
				procesogeneravacaciones.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoGeneraVacaciones(ProcesoGeneraVacaciones procesogeneravacaciones,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoGeneraVacacioness(List<ProcesoGeneraVacaciones> procesogeneravacacioness,Boolean conEnteros) throws Exception  {
		
		for(ProcesoGeneraVacaciones procesogeneravacaciones: procesogeneravacacioness) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoGeneraVacaciones(List<ProcesoGeneraVacaciones> procesogeneravacacioness,ProcesoGeneraVacaciones procesogeneravacacionesAux) throws Exception  {
		ProcesoGeneraVacacionesConstantesFunciones.InicializarValoresProcesoGeneraVacaciones(procesogeneravacacionesAux,true);
		
		for(ProcesoGeneraVacaciones procesogeneravacaciones: procesogeneravacacioness) {
			if(procesogeneravacaciones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoGeneraVacaciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoGeneraVacacionesConstantesFunciones.getArrayColumnasGlobalesProcesoGeneraVacaciones(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoGeneraVacaciones(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoGeneraVacaciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoGeneraVacaciones> procesogeneravacacioness,ProcesoGeneraVacaciones procesogeneravacaciones,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoGeneraVacaciones procesogeneravacacionesAux: procesogeneravacacioness) {
			if(procesogeneravacacionesAux!=null && procesogeneravacaciones!=null) {
				if((procesogeneravacacionesAux.getId()==null && procesogeneravacaciones.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesogeneravacacionesAux.getId()!=null && procesogeneravacaciones.getId()!=null){
					if(procesogeneravacacionesAux.getId().equals(procesogeneravacaciones.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoGeneraVacaciones(List<ProcesoGeneraVacaciones> procesogeneravacacioness) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoGeneraVacaciones procesogeneravacaciones: procesogeneravacacioness) {			
			if(procesogeneravacaciones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoGeneraVacaciones() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoGeneraVacaciones() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoGeneraVacaciones() throws Exception  {
		return ProcesoGeneraVacacionesConstantesFunciones.getTiposSeleccionarProcesoGeneraVacaciones(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoGeneraVacaciones(Boolean conFk) throws Exception  {
		return ProcesoGeneraVacacionesConstantesFunciones.getTiposSeleccionarProcesoGeneraVacaciones(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoGeneraVacaciones(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoGeneraVacacionesConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ProcesoGeneraVacacionesConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoGeneraVacaciones(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoGeneraVacaciones(ProcesoGeneraVacaciones procesogeneravacacionesAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoGeneraVacaciones(List<ProcesoGeneraVacaciones> procesogeneravacacionessTemp) throws Exception {
		for(ProcesoGeneraVacaciones procesogeneravacacionesAux:procesogeneravacacionessTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoGeneraVacaciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoGeneraVacaciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoGeneraVacaciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoGeneraVacacionesConstantesFunciones.getClassesRelationshipsOfProcesoGeneraVacaciones(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoGeneraVacaciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoGeneraVacaciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoGeneraVacacionesConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoGeneraVacaciones(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoGeneraVacaciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoGeneraVacaciones procesogeneravacaciones,List<ProcesoGeneraVacaciones> procesogeneravacacioness,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoGeneraVacaciones procesogeneravacaciones,List<ProcesoGeneraVacaciones> procesogeneravacacioness) throws Exception {
		try	{			
			for(ProcesoGeneraVacaciones procesogeneravacacionesLocal:procesogeneravacacioness) {
				if(procesogeneravacacionesLocal.getId().equals(procesogeneravacaciones.getId())) {
					procesogeneravacacionesLocal.setIsSelected(procesogeneravacaciones.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoGeneraVacaciones(List<ProcesoGeneraVacaciones> procesogeneravacacionessAux) throws Exception {
		//this.procesogeneravacacionessAux=procesogeneravacacionessAux;
		
		for(ProcesoGeneraVacaciones procesogeneravacacionesAux:procesogeneravacacionessAux) {
			if(procesogeneravacacionesAux.getIsChanged()) {
				procesogeneravacacionesAux.setIsChanged(false);
			}		
			
			if(procesogeneravacacionesAux.getIsNew()) {
				procesogeneravacacionesAux.setIsNew(false);
			}	
			
			if(procesogeneravacacionesAux.getIsDeleted()) {
				procesogeneravacacionesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoGeneraVacaciones(ProcesoGeneraVacaciones procesogeneravacacionesAux) throws Exception {
		//this.procesogeneravacacionesAux=procesogeneravacacionesAux;
		
			if(procesogeneravacacionesAux.getIsChanged()) {
				procesogeneravacacionesAux.setIsChanged(false);
			}		
			
			if(procesogeneravacacionesAux.getIsNew()) {
				procesogeneravacacionesAux.setIsNew(false);
			}	
			
			if(procesogeneravacacionesAux.getIsDeleted()) {
				procesogeneravacacionesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoGeneraVacaciones procesogeneravacacionesAsignar,ProcesoGeneraVacaciones procesogeneravacaciones) throws Exception {
		procesogeneravacacionesAsignar.setId(procesogeneravacaciones.getId());	
		procesogeneravacacionesAsignar.setVersionRow(procesogeneravacaciones.getVersionRow());	
		procesogeneravacacionesAsignar.setfecha(procesogeneravacaciones.getfecha());	
	}
	
	public static void inicializarProcesoGeneraVacaciones(ProcesoGeneraVacaciones procesogeneravacaciones) throws Exception {
		try {
				procesogeneravacaciones.setId(0L);	
					
				procesogeneravacaciones.setfecha(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoGeneraVacaciones(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoGeneraVacacionesConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoGeneraVacaciones(String sTipo,Row row,Workbook workbook,ProcesoGeneraVacaciones procesogeneravacaciones,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesogeneravacaciones.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoGeneraVacaciones="";
	
	public String getsFinalQueryProcesoGeneraVacaciones() {
		return this.sFinalQueryProcesoGeneraVacaciones;
	}
	
	public void setsFinalQueryProcesoGeneraVacaciones(String sFinalQueryProcesoGeneraVacaciones) {
		this.sFinalQueryProcesoGeneraVacaciones= sFinalQueryProcesoGeneraVacaciones;
	}
	
	public Border resaltarSeleccionarProcesoGeneraVacaciones=null;
	
	public Border setResaltarSeleccionarProcesoGeneraVacaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGeneraVacacionesBeanSwingJInternalFrame procesogeneravacacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesogeneravacacionesBeanSwingJInternalFrame.jTtoolBarProcesoGeneraVacaciones.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoGeneraVacaciones= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoGeneraVacaciones() {
		return this.resaltarSeleccionarProcesoGeneraVacaciones;
	}
	
	public void setResaltarSeleccionarProcesoGeneraVacaciones(Border borderResaltarSeleccionarProcesoGeneraVacaciones) {
		this.resaltarSeleccionarProcesoGeneraVacaciones= borderResaltarSeleccionarProcesoGeneraVacaciones;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoGeneraVacaciones=null;
	public Boolean mostraridProcesoGeneraVacaciones=true;
	public Boolean activaridProcesoGeneraVacaciones=true;

	public Border resaltarfechaProcesoGeneraVacaciones=null;
	public Boolean mostrarfechaProcesoGeneraVacaciones=true;
	public Boolean activarfechaProcesoGeneraVacaciones=true;

	
	

	public Border setResaltaridProcesoGeneraVacaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGeneraVacacionesBeanSwingJInternalFrame procesogeneravacacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogeneravacacionesBeanSwingJInternalFrame.jTtoolBarProcesoGeneraVacaciones.setBorder(borderResaltar);
		
		this.resaltaridProcesoGeneraVacaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoGeneraVacaciones() {
		return this.resaltaridProcesoGeneraVacaciones;
	}

	public void setResaltaridProcesoGeneraVacaciones(Border borderResaltar) {
		this.resaltaridProcesoGeneraVacaciones= borderResaltar;
	}

	public Boolean getMostraridProcesoGeneraVacaciones() {
		return this.mostraridProcesoGeneraVacaciones;
	}

	public void setMostraridProcesoGeneraVacaciones(Boolean mostraridProcesoGeneraVacaciones) {
		this.mostraridProcesoGeneraVacaciones= mostraridProcesoGeneraVacaciones;
	}

	public Boolean getActivaridProcesoGeneraVacaciones() {
		return this.activaridProcesoGeneraVacaciones;
	}

	public void setActivaridProcesoGeneraVacaciones(Boolean activaridProcesoGeneraVacaciones) {
		this.activaridProcesoGeneraVacaciones= activaridProcesoGeneraVacaciones;
	}

	public Border setResaltarfechaProcesoGeneraVacaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGeneraVacacionesBeanSwingJInternalFrame procesogeneravacacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogeneravacacionesBeanSwingJInternalFrame.jTtoolBarProcesoGeneraVacaciones.setBorder(borderResaltar);
		
		this.resaltarfechaProcesoGeneraVacaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaProcesoGeneraVacaciones() {
		return this.resaltarfechaProcesoGeneraVacaciones;
	}

	public void setResaltarfechaProcesoGeneraVacaciones(Border borderResaltar) {
		this.resaltarfechaProcesoGeneraVacaciones= borderResaltar;
	}

	public Boolean getMostrarfechaProcesoGeneraVacaciones() {
		return this.mostrarfechaProcesoGeneraVacaciones;
	}

	public void setMostrarfechaProcesoGeneraVacaciones(Boolean mostrarfechaProcesoGeneraVacaciones) {
		this.mostrarfechaProcesoGeneraVacaciones= mostrarfechaProcesoGeneraVacaciones;
	}

	public Boolean getActivarfechaProcesoGeneraVacaciones() {
		return this.activarfechaProcesoGeneraVacaciones;
	}

	public void setActivarfechaProcesoGeneraVacaciones(Boolean activarfechaProcesoGeneraVacaciones) {
		this.activarfechaProcesoGeneraVacaciones= activarfechaProcesoGeneraVacaciones;
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
		
		
		this.setMostraridProcesoGeneraVacaciones(esInicial);
		this.setMostrarfechaProcesoGeneraVacaciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoGeneraVacacionesConstantesFunciones.ID)) {
				this.setMostraridProcesoGeneraVacaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGeneraVacacionesConstantesFunciones.FECHA)) {
				this.setMostrarfechaProcesoGeneraVacaciones(esAsigna);
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
		
		
		this.setActivaridProcesoGeneraVacaciones(esInicial);
		this.setActivarfechaProcesoGeneraVacaciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoGeneraVacacionesConstantesFunciones.ID)) {
				this.setActivaridProcesoGeneraVacaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGeneraVacacionesConstantesFunciones.FECHA)) {
				this.setActivarfechaProcesoGeneraVacaciones(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoGeneraVacacionesBeanSwingJInternalFrame procesogeneravacacionesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoGeneraVacaciones(esInicial);
		this.setResaltarfechaProcesoGeneraVacaciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoGeneraVacacionesConstantesFunciones.ID)) {
				this.setResaltaridProcesoGeneraVacaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGeneraVacacionesConstantesFunciones.FECHA)) {
				this.setResaltarfechaProcesoGeneraVacaciones(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoGeneraVacacionesBeanSwingJInternalFrame procesogeneravacacionesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	
	//CONTROL_FUNCION2
}