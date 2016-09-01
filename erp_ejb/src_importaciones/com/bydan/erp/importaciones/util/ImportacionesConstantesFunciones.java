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
package com.bydan.erp.importaciones.util;

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


import com.bydan.erp.importaciones.util.ImportacionesConstantesFunciones;
import com.bydan.erp.importaciones.util.ImportacionesParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.ImportacionesParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.importaciones.util.report.*;
import com.bydan.erp.importaciones.business.entity.report.*;
import com.bydan.erp.importaciones.util.ImportacionesSql;
import com.bydan.erp.importaciones.util.ImportacionesSqlReporte;


@SuppressWarnings("unused")
final public class ImportacionesConstantesFunciones extends ImportacionesConstantesFuncionesAdditional {		
	
	
	
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
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="Importaciones";
	public static final String SPATHOPCION="Importaciones";	
	public static final String SPATHMODULO="importaciones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Importaciones"+ImportacionesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ImportacionesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ImportacionesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ImportacionesConstantesFunciones.SCHEMA+"_"+ImportacionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ImportacionesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ImportacionesConstantesFunciones.SCHEMA+"_"+ImportacionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ImportacionesConstantesFunciones.SCHEMA+"_"+ImportacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ImportacionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ImportacionesConstantesFunciones.SCHEMA+"_"+ImportacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ImportacionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ImportacionesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ImportacionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ImportacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ImportacionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ImportacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ImportacionesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ImportacionesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ImportacionesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ImportacionesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Importacioneses";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Importaciones";
	public static final String SCLASSWEBTITULO_LOWER="Importaciones";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Importaciones";
	public static final String OBJECTNAME="importaciones";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_IMPORTACIONES;	
	public static final String TABLENAME="importaciones";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select importaciones from "+ImportacionesConstantesFunciones.SPERSISTENCENAME+" importaciones";
	public static String QUERYSELECTNATIVE="select "+ImportacionesConstantesFunciones.SCHEMA+"."+ImportacionesConstantesFunciones.TABLENAME+".id,"+ImportacionesConstantesFunciones.SCHEMA+"."+ImportacionesConstantesFunciones.TABLENAME+".version_row,"+ImportacionesConstantesFunciones.SCHEMA+"."+ImportacionesConstantesFunciones.TABLENAME+".codigo from "+ImportacionesConstantesFunciones.SCHEMA+"."+ImportacionesConstantesFunciones.TABLENAME;//+" as "+ImportacionesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ImportacionesConstantesFuncionesAdditional importacionesConstantesFuncionesAdditional=null;
	
	public ImportacionesConstantesFuncionesAdditional getImportacionesConstantesFuncionesAdditional() {
		return this.importacionesConstantesFuncionesAdditional;
	}
	
	public void setImportacionesConstantesFuncionesAdditional(ImportacionesConstantesFuncionesAdditional importacionesConstantesFuncionesAdditional) {
		try {
			this.importacionesConstantesFuncionesAdditional=importacionesConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getImportacionesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ImportacionesConstantesFunciones.CODIGO)) {sLabelColumna=ImportacionesConstantesFunciones.LABEL_CODIGO;}
		
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
	
	
	
			
			
			
	
	public static String getImportacionesDescripcion(Importaciones importaciones) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(importaciones !=null/* && importaciones.getId()!=0*/) {
			sDescripcion=importaciones.getcodigo();//importacionesimportaciones.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getImportacionesDescripcionDetallado(Importaciones importaciones) {
		String sDescripcion="";
			
		sDescripcion+=ImportacionesConstantesFunciones.ID+"=";
		sDescripcion+=importaciones.getId().toString()+",";
		sDescripcion+=ImportacionesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=importaciones.getVersionRow().toString()+",";
		sDescripcion+=ImportacionesConstantesFunciones.CODIGO+"=";
		sDescripcion+=importaciones.getcodigo()+",";
			
		return sDescripcion;
	}
	
	public static void setImportacionesDescripcion(Importaciones importaciones,String sValor) throws Exception {			
		if(importaciones !=null) {
			importaciones.setcodigo(sValor);;//importacionesimportaciones.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosImportaciones(Importaciones importaciones,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		importaciones.setcodigo(importaciones.getcodigo().trim());
	}
	
	public static void quitarEspaciosImportacioness(List<Importaciones> importacioness,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Importaciones importaciones: importacioness) {
			importaciones.setcodigo(importaciones.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresImportaciones(Importaciones importaciones,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && importaciones.getConCambioAuxiliar()) {
			importaciones.setIsDeleted(importaciones.getIsDeletedAuxiliar());	
			importaciones.setIsNew(importaciones.getIsNewAuxiliar());	
			importaciones.setIsChanged(importaciones.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			importaciones.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			importaciones.setIsDeletedAuxiliar(false);	
			importaciones.setIsNewAuxiliar(false);	
			importaciones.setIsChangedAuxiliar(false);
			
			importaciones.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresImportacioness(List<Importaciones> importacioness,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Importaciones importaciones : importacioness) {
			if(conAsignarBase && importaciones.getConCambioAuxiliar()) {
				importaciones.setIsDeleted(importaciones.getIsDeletedAuxiliar());	
				importaciones.setIsNew(importaciones.getIsNewAuxiliar());	
				importaciones.setIsChanged(importaciones.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				importaciones.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				importaciones.setIsDeletedAuxiliar(false);	
				importaciones.setIsNewAuxiliar(false);	
				importaciones.setIsChangedAuxiliar(false);
				
				importaciones.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresImportaciones(Importaciones importaciones,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresImportacioness(List<Importaciones> importacioness,Boolean conEnteros) throws Exception  {
		
		for(Importaciones importaciones: importacioness) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaImportaciones(List<Importaciones> importacioness,Importaciones importacionesAux) throws Exception  {
		ImportacionesConstantesFunciones.InicializarValoresImportaciones(importacionesAux,true);
		
		for(Importaciones importaciones: importacioness) {
			if(importaciones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesImportaciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ImportacionesConstantesFunciones.getArrayColumnasGlobalesImportaciones(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesImportaciones(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoImportaciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Importaciones> importacioness,Importaciones importaciones,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Importaciones importacionesAux: importacioness) {
			if(importacionesAux!=null && importaciones!=null) {
				if((importacionesAux.getId()==null && importaciones.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(importacionesAux.getId()!=null && importaciones.getId()!=null){
					if(importacionesAux.getId().equals(importaciones.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaImportaciones(List<Importaciones> importacioness) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Importaciones importaciones: importacioness) {			
			if(importaciones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaImportaciones() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasImportaciones() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarImportaciones() throws Exception  {
		return ImportacionesConstantesFunciones.getTiposSeleccionarImportaciones(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarImportaciones(Boolean conFk) throws Exception  {
		return ImportacionesConstantesFunciones.getTiposSeleccionarImportaciones(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarImportaciones(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportacionesConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ImportacionesConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesImportaciones(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesImportaciones(Importaciones importacionesAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesImportaciones(List<Importaciones> importacionessTemp) throws Exception {
		for(Importaciones importacionesAux:importacionessTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfImportaciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfImportaciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfImportaciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ImportacionesConstantesFunciones.getClassesRelationshipsOfImportaciones(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfImportaciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfImportaciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ImportacionesConstantesFunciones.getClassesRelationshipsFromStringsOfImportaciones(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfImportaciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Importaciones importaciones,List<Importaciones> importacioness,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Importaciones importacionesEncontrado=null;
			
			for(Importaciones importacionesLocal:importacioness) {
				if(importacionesLocal.getId().equals(importaciones.getId())) {
					importacionesEncontrado=importacionesLocal;
					
					importacionesLocal.setIsChanged(importaciones.getIsChanged());
					importacionesLocal.setIsNew(importaciones.getIsNew());
					importacionesLocal.setIsDeleted(importaciones.getIsDeleted());
					
					importacionesLocal.setGeneralEntityOriginal(importaciones.getGeneralEntityOriginal());
					
					importacionesLocal.setId(importaciones.getId());	
					importacionesLocal.setVersionRow(importaciones.getVersionRow());	
					importacionesLocal.setcodigo(importaciones.getcodigo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!importaciones.getIsDeleted()) {
				if(!existe) {
					importacioness.add(importaciones);
				}
			} else {
				if(importacionesEncontrado!=null && permiteQuitar)  {
					importacioness.remove(importacionesEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Importaciones importaciones,List<Importaciones> importacioness) throws Exception {
		try	{			
			for(Importaciones importacionesLocal:importacioness) {
				if(importacionesLocal.getId().equals(importaciones.getId())) {
					importacionesLocal.setIsSelected(importaciones.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesImportaciones(List<Importaciones> importacionessAux) throws Exception {
		//this.importacionessAux=importacionessAux;
		
		for(Importaciones importacionesAux:importacionessAux) {
			if(importacionesAux.getIsChanged()) {
				importacionesAux.setIsChanged(false);
			}		
			
			if(importacionesAux.getIsNew()) {
				importacionesAux.setIsNew(false);
			}	
			
			if(importacionesAux.getIsDeleted()) {
				importacionesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesImportaciones(Importaciones importacionesAux) throws Exception {
		//this.importacionesAux=importacionesAux;
		
			if(importacionesAux.getIsChanged()) {
				importacionesAux.setIsChanged(false);
			}		
			
			if(importacionesAux.getIsNew()) {
				importacionesAux.setIsNew(false);
			}	
			
			if(importacionesAux.getIsDeleted()) {
				importacionesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Importaciones importacionesAsignar,Importaciones importaciones) throws Exception {
		importacionesAsignar.setId(importaciones.getId());	
		importacionesAsignar.setVersionRow(importaciones.getVersionRow());	
		importacionesAsignar.setcodigo(importaciones.getcodigo());	
	}
	
	public static void inicializarImportaciones(Importaciones importaciones) throws Exception {
		try {
				importaciones.setId(0L);	
					
				importaciones.setcodigo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderImportaciones(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportacionesConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataImportaciones(String sTipo,Row row,Workbook workbook,Importaciones importaciones,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(importaciones.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryImportaciones=Constantes.SFINALQUERY;
	
	public String getsFinalQueryImportaciones() {
		return this.sFinalQueryImportaciones;
	}
	
	public void setsFinalQueryImportaciones(String sFinalQueryImportaciones) {
		this.sFinalQueryImportaciones= sFinalQueryImportaciones;
	}
	
	public Border resaltarSeleccionarImportaciones=null;
	
	public Border setResaltarSeleccionarImportaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ImportacionesBeanSwingJInternalFrame importacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//importacionesBeanSwingJInternalFrame.jTtoolBarImportaciones.setBorder(borderResaltar);
		
		this.resaltarSeleccionarImportaciones= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarImportaciones() {
		return this.resaltarSeleccionarImportaciones;
	}
	
	public void setResaltarSeleccionarImportaciones(Border borderResaltarSeleccionarImportaciones) {
		this.resaltarSeleccionarImportaciones= borderResaltarSeleccionarImportaciones;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridImportaciones=null;
	public Boolean mostraridImportaciones=true;
	public Boolean activaridImportaciones=true;

	public Border resaltarcodigoImportaciones=null;
	public Boolean mostrarcodigoImportaciones=true;
	public Boolean activarcodigoImportaciones=true;

	
	

	public Border setResaltaridImportaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ImportacionesBeanSwingJInternalFrame importacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//importacionesBeanSwingJInternalFrame.jTtoolBarImportaciones.setBorder(borderResaltar);
		
		this.resaltaridImportaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridImportaciones() {
		return this.resaltaridImportaciones;
	}

	public void setResaltaridImportaciones(Border borderResaltar) {
		this.resaltaridImportaciones= borderResaltar;
	}

	public Boolean getMostraridImportaciones() {
		return this.mostraridImportaciones;
	}

	public void setMostraridImportaciones(Boolean mostraridImportaciones) {
		this.mostraridImportaciones= mostraridImportaciones;
	}

	public Boolean getActivaridImportaciones() {
		return this.activaridImportaciones;
	}

	public void setActivaridImportaciones(Boolean activaridImportaciones) {
		this.activaridImportaciones= activaridImportaciones;
	}

	public Border setResaltarcodigoImportaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ImportacionesBeanSwingJInternalFrame importacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//importacionesBeanSwingJInternalFrame.jTtoolBarImportaciones.setBorder(borderResaltar);
		
		this.resaltarcodigoImportaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoImportaciones() {
		return this.resaltarcodigoImportaciones;
	}

	public void setResaltarcodigoImportaciones(Border borderResaltar) {
		this.resaltarcodigoImportaciones= borderResaltar;
	}

	public Boolean getMostrarcodigoImportaciones() {
		return this.mostrarcodigoImportaciones;
	}

	public void setMostrarcodigoImportaciones(Boolean mostrarcodigoImportaciones) {
		this.mostrarcodigoImportaciones= mostrarcodigoImportaciones;
	}

	public Boolean getActivarcodigoImportaciones() {
		return this.activarcodigoImportaciones;
	}

	public void setActivarcodigoImportaciones(Boolean activarcodigoImportaciones) {
		this.activarcodigoImportaciones= activarcodigoImportaciones;
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
		
		
		this.setMostraridImportaciones(esInicial);
		this.setMostrarcodigoImportaciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ImportacionesConstantesFunciones.ID)) {
				this.setMostraridImportaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportacionesConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoImportaciones(esAsigna);
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
		
		
		this.setActivaridImportaciones(esInicial);
		this.setActivarcodigoImportaciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ImportacionesConstantesFunciones.ID)) {
				this.setActivaridImportaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportacionesConstantesFunciones.CODIGO)) {
				this.setActivarcodigoImportaciones(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ImportacionesBeanSwingJInternalFrame importacionesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridImportaciones(esInicial);
		this.setResaltarcodigoImportaciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ImportacionesConstantesFunciones.ID)) {
				this.setResaltaridImportaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportacionesConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoImportaciones(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ImportacionesBeanSwingJInternalFrame importacionesBeanSwingJInternalFrame*/)throws Exception {	
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