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
package com.bydan.erp.activosfijos.util;

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


import com.bydan.erp.activosfijos.util.ActivosFijosConstantesFunciones;
import com.bydan.erp.activosfijos.util.ActivosFijosParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.ActivosFijosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.activosfijos.util.report.*;
import com.bydan.erp.activosfijos.business.entity.report.*;
import com.bydan.erp.activosfijos.util.ActivosFijosSql;
import com.bydan.erp.activosfijos.util.ActivosFijosSqlReporte;


@SuppressWarnings("unused")
final public class ActivosFijosConstantesFunciones extends ActivosFijosConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ActivosFijos";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ActivosFijos"+ActivosFijosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ActivosFijosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ActivosFijosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ActivosFijosConstantesFunciones.SCHEMA+"_"+ActivosFijosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ActivosFijosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ActivosFijosConstantesFunciones.SCHEMA+"_"+ActivosFijosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ActivosFijosConstantesFunciones.SCHEMA+"_"+ActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ActivosFijosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ActivosFijosConstantesFunciones.SCHEMA+"_"+ActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ActivosFijosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ActivosFijosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ActivosFijosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ActivosFijosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ActivosFijosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ActivosFijosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Activos Fijoses";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Activos Fijos";
	public static final String SCLASSWEBTITULO_LOWER="Activos Fijos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ActivosFijos";
	public static final String OBJECTNAME="activosfijos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="activos_fijos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select activosfijos from "+ActivosFijosConstantesFunciones.SPERSISTENCENAME+" activosfijos";
	public static String QUERYSELECTNATIVE="select "+ActivosFijosConstantesFunciones.SCHEMA+"."+ActivosFijosConstantesFunciones.TABLENAME+".id,"+ActivosFijosConstantesFunciones.SCHEMA+"."+ActivosFijosConstantesFunciones.TABLENAME+".version_row,"+ActivosFijosConstantesFunciones.SCHEMA+"."+ActivosFijosConstantesFunciones.TABLENAME+".codigo from "+ActivosFijosConstantesFunciones.SCHEMA+"."+ActivosFijosConstantesFunciones.TABLENAME;//+" as "+ActivosFijosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ActivosFijosConstantesFuncionesAdditional activosfijosConstantesFuncionesAdditional=null;
	
	public ActivosFijosConstantesFuncionesAdditional getActivosFijosConstantesFuncionesAdditional() {
		return this.activosfijosConstantesFuncionesAdditional;
	}
	
	public void setActivosFijosConstantesFuncionesAdditional(ActivosFijosConstantesFuncionesAdditional activosfijosConstantesFuncionesAdditional) {
		try {
			this.activosfijosConstantesFuncionesAdditional=activosfijosConstantesFuncionesAdditional;
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
	
	public static String getActivosFijosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ActivosFijosConstantesFunciones.CODIGO)) {sLabelColumna=ActivosFijosConstantesFunciones.LABEL_CODIGO;}
		
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
	
	
	
			
			
			
	
	public static String getActivosFijosDescripcion(ActivosFijos activosfijos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(activosfijos !=null/* && activosfijos.getId()!=0*/) {
			sDescripcion=activosfijos.getcodigo();//activosfijosactivosfijos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getActivosFijosDescripcionDetallado(ActivosFijos activosfijos) {
		String sDescripcion="";
			
		sDescripcion+=ActivosFijosConstantesFunciones.ID+"=";
		sDescripcion+=activosfijos.getId().toString()+",";
		sDescripcion+=ActivosFijosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=activosfijos.getVersionRow().toString()+",";
		sDescripcion+=ActivosFijosConstantesFunciones.CODIGO+"=";
		sDescripcion+=activosfijos.getcodigo()+",";
			
		return sDescripcion;
	}
	
	public static void setActivosFijosDescripcion(ActivosFijos activosfijos,String sValor) throws Exception {			
		if(activosfijos !=null) {
			activosfijos.setcodigo(sValor);;//activosfijosactivosfijos.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosActivosFijos(ActivosFijos activosfijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		activosfijos.setcodigo(activosfijos.getcodigo().trim());
	}
	
	public static void quitarEspaciosActivosFijoss(List<ActivosFijos> activosfijoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ActivosFijos activosfijos: activosfijoss) {
			activosfijos.setcodigo(activosfijos.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresActivosFijos(ActivosFijos activosfijos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && activosfijos.getConCambioAuxiliar()) {
			activosfijos.setIsDeleted(activosfijos.getIsDeletedAuxiliar());	
			activosfijos.setIsNew(activosfijos.getIsNewAuxiliar());	
			activosfijos.setIsChanged(activosfijos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			activosfijos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			activosfijos.setIsDeletedAuxiliar(false);	
			activosfijos.setIsNewAuxiliar(false);	
			activosfijos.setIsChangedAuxiliar(false);
			
			activosfijos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresActivosFijoss(List<ActivosFijos> activosfijoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ActivosFijos activosfijos : activosfijoss) {
			if(conAsignarBase && activosfijos.getConCambioAuxiliar()) {
				activosfijos.setIsDeleted(activosfijos.getIsDeletedAuxiliar());	
				activosfijos.setIsNew(activosfijos.getIsNewAuxiliar());	
				activosfijos.setIsChanged(activosfijos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				activosfijos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				activosfijos.setIsDeletedAuxiliar(false);	
				activosfijos.setIsNewAuxiliar(false);	
				activosfijos.setIsChangedAuxiliar(false);
				
				activosfijos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresActivosFijos(ActivosFijos activosfijos,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresActivosFijoss(List<ActivosFijos> activosfijoss,Boolean conEnteros) throws Exception  {
		
		for(ActivosFijos activosfijos: activosfijoss) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaActivosFijos(List<ActivosFijos> activosfijoss,ActivosFijos activosfijosAux) throws Exception  {
		ActivosFijosConstantesFunciones.InicializarValoresActivosFijos(activosfijosAux,true);
		
		for(ActivosFijos activosfijos: activosfijoss) {
			if(activosfijos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesActivosFijos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ActivosFijosConstantesFunciones.getArrayColumnasGlobalesActivosFijos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesActivosFijos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoActivosFijos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ActivosFijos> activosfijoss,ActivosFijos activosfijos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ActivosFijos activosfijosAux: activosfijoss) {
			if(activosfijosAux!=null && activosfijos!=null) {
				if((activosfijosAux.getId()==null && activosfijos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(activosfijosAux.getId()!=null && activosfijos.getId()!=null){
					if(activosfijosAux.getId().equals(activosfijos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaActivosFijos(List<ActivosFijos> activosfijoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ActivosFijos activosfijos: activosfijoss) {			
			if(activosfijos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaActivosFijos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasActivosFijos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarActivosFijos() throws Exception  {
		return ActivosFijosConstantesFunciones.getTiposSeleccionarActivosFijos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarActivosFijos(Boolean conFk) throws Exception  {
		return ActivosFijosConstantesFunciones.getTiposSeleccionarActivosFijos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarActivosFijos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ActivosFijosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesActivosFijos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesActivosFijos(ActivosFijos activosfijosAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesActivosFijos(List<ActivosFijos> activosfijossTemp) throws Exception {
		for(ActivosFijos activosfijosAux:activosfijossTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfActivosFijos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfActivosFijos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfActivosFijos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ActivosFijosConstantesFunciones.getClassesRelationshipsOfActivosFijos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfActivosFijos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfActivosFijos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ActivosFijosConstantesFunciones.getClassesRelationshipsFromStringsOfActivosFijos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfActivosFijos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ActivosFijos activosfijos,List<ActivosFijos> activosfijoss,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ActivosFijos activosfijosEncontrado=null;
			
			for(ActivosFijos activosfijosLocal:activosfijoss) {
				if(activosfijosLocal.getId().equals(activosfijos.getId())) {
					activosfijosEncontrado=activosfijosLocal;
					
					activosfijosLocal.setIsChanged(activosfijos.getIsChanged());
					activosfijosLocal.setIsNew(activosfijos.getIsNew());
					activosfijosLocal.setIsDeleted(activosfijos.getIsDeleted());
					
					activosfijosLocal.setGeneralEntityOriginal(activosfijos.getGeneralEntityOriginal());
					
					activosfijosLocal.setId(activosfijos.getId());	
					activosfijosLocal.setVersionRow(activosfijos.getVersionRow());	
					activosfijosLocal.setcodigo(activosfijos.getcodigo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!activosfijos.getIsDeleted()) {
				if(!existe) {
					activosfijoss.add(activosfijos);
				}
			} else {
				if(activosfijosEncontrado!=null && permiteQuitar)  {
					activosfijoss.remove(activosfijosEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ActivosFijos activosfijos,List<ActivosFijos> activosfijoss) throws Exception {
		try	{			
			for(ActivosFijos activosfijosLocal:activosfijoss) {
				if(activosfijosLocal.getId().equals(activosfijos.getId())) {
					activosfijosLocal.setIsSelected(activosfijos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesActivosFijos(List<ActivosFijos> activosfijossAux) throws Exception {
		//this.activosfijossAux=activosfijossAux;
		
		for(ActivosFijos activosfijosAux:activosfijossAux) {
			if(activosfijosAux.getIsChanged()) {
				activosfijosAux.setIsChanged(false);
			}		
			
			if(activosfijosAux.getIsNew()) {
				activosfijosAux.setIsNew(false);
			}	
			
			if(activosfijosAux.getIsDeleted()) {
				activosfijosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesActivosFijos(ActivosFijos activosfijosAux) throws Exception {
		//this.activosfijosAux=activosfijosAux;
		
			if(activosfijosAux.getIsChanged()) {
				activosfijosAux.setIsChanged(false);
			}		
			
			if(activosfijosAux.getIsNew()) {
				activosfijosAux.setIsNew(false);
			}	
			
			if(activosfijosAux.getIsDeleted()) {
				activosfijosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ActivosFijos activosfijosAsignar,ActivosFijos activosfijos) throws Exception {
		activosfijosAsignar.setId(activosfijos.getId());	
		activosfijosAsignar.setVersionRow(activosfijos.getVersionRow());	
		activosfijosAsignar.setcodigo(activosfijos.getcodigo());	
	}
	
	public static void inicializarActivosFijos(ActivosFijos activosfijos) throws Exception {
		try {
				activosfijos.setId(0L);	
					
				activosfijos.setcodigo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderActivosFijos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataActivosFijos(String sTipo,Row row,Workbook workbook,ActivosFijos activosfijos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryActivosFijos=Constantes.SFINALQUERY;
	
	public String getsFinalQueryActivosFijos() {
		return this.sFinalQueryActivosFijos;
	}
	
	public void setsFinalQueryActivosFijos(String sFinalQueryActivosFijos) {
		this.sFinalQueryActivosFijos= sFinalQueryActivosFijos;
	}
	
	public Border resaltarSeleccionarActivosFijos=null;
	
	public Border setResaltarSeleccionarActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosBeanSwingJInternalFrame activosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//activosfijosBeanSwingJInternalFrame.jTtoolBarActivosFijos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarActivosFijos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarActivosFijos() {
		return this.resaltarSeleccionarActivosFijos;
	}
	
	public void setResaltarSeleccionarActivosFijos(Border borderResaltarSeleccionarActivosFijos) {
		this.resaltarSeleccionarActivosFijos= borderResaltarSeleccionarActivosFijos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridActivosFijos=null;
	public Boolean mostraridActivosFijos=true;
	public Boolean activaridActivosFijos=true;

	public Border resaltarcodigoActivosFijos=null;
	public Boolean mostrarcodigoActivosFijos=true;
	public Boolean activarcodigoActivosFijos=true;

	
	

	public Border setResaltaridActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosBeanSwingJInternalFrame activosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosBeanSwingJInternalFrame.jTtoolBarActivosFijos.setBorder(borderResaltar);
		
		this.resaltaridActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridActivosFijos() {
		return this.resaltaridActivosFijos;
	}

	public void setResaltaridActivosFijos(Border borderResaltar) {
		this.resaltaridActivosFijos= borderResaltar;
	}

	public Boolean getMostraridActivosFijos() {
		return this.mostraridActivosFijos;
	}

	public void setMostraridActivosFijos(Boolean mostraridActivosFijos) {
		this.mostraridActivosFijos= mostraridActivosFijos;
	}

	public Boolean getActivaridActivosFijos() {
		return this.activaridActivosFijos;
	}

	public void setActivaridActivosFijos(Boolean activaridActivosFijos) {
		this.activaridActivosFijos= activaridActivosFijos;
	}

	public Border setResaltarcodigoActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosBeanSwingJInternalFrame activosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosBeanSwingJInternalFrame.jTtoolBarActivosFijos.setBorder(borderResaltar);
		
		this.resaltarcodigoActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoActivosFijos() {
		return this.resaltarcodigoActivosFijos;
	}

	public void setResaltarcodigoActivosFijos(Border borderResaltar) {
		this.resaltarcodigoActivosFijos= borderResaltar;
	}

	public Boolean getMostrarcodigoActivosFijos() {
		return this.mostrarcodigoActivosFijos;
	}

	public void setMostrarcodigoActivosFijos(Boolean mostrarcodigoActivosFijos) {
		this.mostrarcodigoActivosFijos= mostrarcodigoActivosFijos;
	}

	public Boolean getActivarcodigoActivosFijos() {
		return this.activarcodigoActivosFijos;
	}

	public void setActivarcodigoActivosFijos(Boolean activarcodigoActivosFijos) {
		this.activarcodigoActivosFijos= activarcodigoActivosFijos;
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
		
		
		this.setMostraridActivosFijos(esInicial);
		this.setMostrarcodigoActivosFijos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ActivosFijosConstantesFunciones.ID)) {
				this.setMostraridActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoActivosFijos(esAsigna);
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
		
		
		this.setActivaridActivosFijos(esInicial);
		this.setActivarcodigoActivosFijos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ActivosFijosConstantesFunciones.ID)) {
				this.setActivaridActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoActivosFijos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ActivosFijosBeanSwingJInternalFrame activosfijosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridActivosFijos(esInicial);
		this.setResaltarcodigoActivosFijos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ActivosFijosConstantesFunciones.ID)) {
				this.setResaltaridActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoActivosFijos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ActivosFijosBeanSwingJInternalFrame activosfijosBeanSwingJInternalFrame*/)throws Exception {	
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