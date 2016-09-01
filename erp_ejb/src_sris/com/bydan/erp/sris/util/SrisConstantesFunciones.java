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
package com.bydan.erp.sris.util;

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


import com.bydan.erp.sris.util.SrisConstantesFunciones;
import com.bydan.erp.sris.util.SrisParameterReturnGeneral;
//import com.bydan.erp.sris.util.SrisParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.sris.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.sris.business.dataaccess.*;
//import com.bydan.erp.sris.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.sris.util.report.*;
import com.bydan.erp.sris.business.entity.report.*;
import com.bydan.erp.sris.util.SrisSql;
import com.bydan.erp.sris.util.SrisSqlReporte;


@SuppressWarnings("unused")
final public class SrisConstantesFunciones extends SrisConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Sris";
	public static final String SPATHOPCION="Sris";	
	public static final String SPATHMODULO="sris/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Sris"+SrisConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SrisHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SrisHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SrisConstantesFunciones.SCHEMA+"_"+SrisConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SrisHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SrisConstantesFunciones.SCHEMA+"_"+SrisConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SrisConstantesFunciones.SCHEMA+"_"+SrisConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SrisHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SrisConstantesFunciones.SCHEMA+"_"+SrisConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SrisConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SrisHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SrisConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SrisConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SrisHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SrisConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SrisConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SrisConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SrisConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SrisConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Sriss";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Sris";
	public static final String SCLASSWEBTITULO_LOWER="Sris";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Sris";
	public static final String OBJECTNAME="sris";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SRIS;	
	public static final String TABLENAME="sris";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select sris from "+SrisConstantesFunciones.SPERSISTENCENAME+" sris";
	public static String QUERYSELECTNATIVE="select "+SrisConstantesFunciones.SCHEMA+"."+SrisConstantesFunciones.TABLENAME+".id,"+SrisConstantesFunciones.SCHEMA+"."+SrisConstantesFunciones.TABLENAME+".version_row,"+SrisConstantesFunciones.SCHEMA+"."+SrisConstantesFunciones.TABLENAME+".codigo from "+SrisConstantesFunciones.SCHEMA+"."+SrisConstantesFunciones.TABLENAME;//+" as "+SrisConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected SrisConstantesFuncionesAdditional srisConstantesFuncionesAdditional=null;
	
	public SrisConstantesFuncionesAdditional getSrisConstantesFuncionesAdditional() {
		return this.srisConstantesFuncionesAdditional;
	}
	
	public void setSrisConstantesFuncionesAdditional(SrisConstantesFuncionesAdditional srisConstantesFuncionesAdditional) {
		try {
			this.srisConstantesFuncionesAdditional=srisConstantesFuncionesAdditional;
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
	
	public static String getSrisLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SrisConstantesFunciones.CODIGO)) {sLabelColumna=SrisConstantesFunciones.LABEL_CODIGO;}
		
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
	
	
	
			
			
			
	
	public static String getSrisDescripcion(Sris sris) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(sris !=null/* && sris.getId()!=0*/) {
			sDescripcion=sris.getcodigo();//srissris.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getSrisDescripcionDetallado(Sris sris) {
		String sDescripcion="";
			
		sDescripcion+=SrisConstantesFunciones.ID+"=";
		sDescripcion+=sris.getId().toString()+",";
		sDescripcion+=SrisConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=sris.getVersionRow().toString()+",";
		sDescripcion+=SrisConstantesFunciones.CODIGO+"=";
		sDescripcion+=sris.getcodigo()+",";
			
		return sDescripcion;
	}
	
	public static void setSrisDescripcion(Sris sris,String sValor) throws Exception {			
		if(sris !=null) {
			sris.setcodigo(sValor);;//srissris.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosSris(Sris sris,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		sris.setcodigo(sris.getcodigo().trim());
	}
	
	public static void quitarEspaciosSriss(List<Sris> sriss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Sris sris: sriss) {
			sris.setcodigo(sris.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSris(Sris sris,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && sris.getConCambioAuxiliar()) {
			sris.setIsDeleted(sris.getIsDeletedAuxiliar());	
			sris.setIsNew(sris.getIsNewAuxiliar());	
			sris.setIsChanged(sris.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			sris.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			sris.setIsDeletedAuxiliar(false);	
			sris.setIsNewAuxiliar(false);	
			sris.setIsChangedAuxiliar(false);
			
			sris.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSriss(List<Sris> sriss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Sris sris : sriss) {
			if(conAsignarBase && sris.getConCambioAuxiliar()) {
				sris.setIsDeleted(sris.getIsDeletedAuxiliar());	
				sris.setIsNew(sris.getIsNewAuxiliar());	
				sris.setIsChanged(sris.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				sris.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				sris.setIsDeletedAuxiliar(false);	
				sris.setIsNewAuxiliar(false);	
				sris.setIsChangedAuxiliar(false);
				
				sris.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSris(Sris sris,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSriss(List<Sris> sriss,Boolean conEnteros) throws Exception  {
		
		for(Sris sris: sriss) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSris(List<Sris> sriss,Sris srisAux) throws Exception  {
		SrisConstantesFunciones.InicializarValoresSris(srisAux,true);
		
		for(Sris sris: sriss) {
			if(sris.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSris(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SrisConstantesFunciones.getArrayColumnasGlobalesSris(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSris(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSris(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Sris> sriss,Sris sris,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Sris srisAux: sriss) {
			if(srisAux!=null && sris!=null) {
				if((srisAux.getId()==null && sris.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(srisAux.getId()!=null && sris.getId()!=null){
					if(srisAux.getId().equals(sris.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSris(List<Sris> sriss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Sris sris: sriss) {			
			if(sris.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSris() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSris() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSris() throws Exception  {
		return SrisConstantesFunciones.getTiposSeleccionarSris(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSris(Boolean conFk) throws Exception  {
		return SrisConstantesFunciones.getTiposSeleccionarSris(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSris(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SrisConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(SrisConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSris(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSris(Sris srisAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesSris(List<Sris> srissTemp) throws Exception {
		for(Sris srisAux:srissTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSris(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSris(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSris(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SrisConstantesFunciones.getClassesRelationshipsOfSris(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSris(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSris(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SrisConstantesFunciones.getClassesRelationshipsFromStringsOfSris(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSris(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Sris sris,List<Sris> sriss,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Sris srisEncontrado=null;
			
			for(Sris srisLocal:sriss) {
				if(srisLocal.getId().equals(sris.getId())) {
					srisEncontrado=srisLocal;
					
					srisLocal.setIsChanged(sris.getIsChanged());
					srisLocal.setIsNew(sris.getIsNew());
					srisLocal.setIsDeleted(sris.getIsDeleted());
					
					srisLocal.setGeneralEntityOriginal(sris.getGeneralEntityOriginal());
					
					srisLocal.setId(sris.getId());	
					srisLocal.setVersionRow(sris.getVersionRow());	
					srisLocal.setcodigo(sris.getcodigo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!sris.getIsDeleted()) {
				if(!existe) {
					sriss.add(sris);
				}
			} else {
				if(srisEncontrado!=null && permiteQuitar)  {
					sriss.remove(srisEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Sris sris,List<Sris> sriss) throws Exception {
		try	{			
			for(Sris srisLocal:sriss) {
				if(srisLocal.getId().equals(sris.getId())) {
					srisLocal.setIsSelected(sris.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSris(List<Sris> srissAux) throws Exception {
		//this.srissAux=srissAux;
		
		for(Sris srisAux:srissAux) {
			if(srisAux.getIsChanged()) {
				srisAux.setIsChanged(false);
			}		
			
			if(srisAux.getIsNew()) {
				srisAux.setIsNew(false);
			}	
			
			if(srisAux.getIsDeleted()) {
				srisAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSris(Sris srisAux) throws Exception {
		//this.srisAux=srisAux;
		
			if(srisAux.getIsChanged()) {
				srisAux.setIsChanged(false);
			}		
			
			if(srisAux.getIsNew()) {
				srisAux.setIsNew(false);
			}	
			
			if(srisAux.getIsDeleted()) {
				srisAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Sris srisAsignar,Sris sris) throws Exception {
		srisAsignar.setId(sris.getId());	
		srisAsignar.setVersionRow(sris.getVersionRow());	
		srisAsignar.setcodigo(sris.getcodigo());	
	}
	
	public static void inicializarSris(Sris sris) throws Exception {
		try {
				sris.setId(0L);	
					
				sris.setcodigo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSris(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SrisConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSris(String sTipo,Row row,Workbook workbook,Sris sris,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(sris.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySris=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySris() {
		return this.sFinalQuerySris;
	}
	
	public void setsFinalQuerySris(String sFinalQuerySris) {
		this.sFinalQuerySris= sFinalQuerySris;
	}
	
	public Border resaltarSeleccionarSris=null;
	
	public Border setResaltarSeleccionarSris(ParametroGeneralUsuario parametroGeneralUsuario/*SrisBeanSwingJInternalFrame srisBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//srisBeanSwingJInternalFrame.jTtoolBarSris.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSris= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSris() {
		return this.resaltarSeleccionarSris;
	}
	
	public void setResaltarSeleccionarSris(Border borderResaltarSeleccionarSris) {
		this.resaltarSeleccionarSris= borderResaltarSeleccionarSris;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSris=null;
	public Boolean mostraridSris=true;
	public Boolean activaridSris=true;

	public Border resaltarcodigoSris=null;
	public Boolean mostrarcodigoSris=true;
	public Boolean activarcodigoSris=true;

	
	

	public Border setResaltaridSris(ParametroGeneralUsuario parametroGeneralUsuario/*SrisBeanSwingJInternalFrame srisBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srisBeanSwingJInternalFrame.jTtoolBarSris.setBorder(borderResaltar);
		
		this.resaltaridSris= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSris() {
		return this.resaltaridSris;
	}

	public void setResaltaridSris(Border borderResaltar) {
		this.resaltaridSris= borderResaltar;
	}

	public Boolean getMostraridSris() {
		return this.mostraridSris;
	}

	public void setMostraridSris(Boolean mostraridSris) {
		this.mostraridSris= mostraridSris;
	}

	public Boolean getActivaridSris() {
		return this.activaridSris;
	}

	public void setActivaridSris(Boolean activaridSris) {
		this.activaridSris= activaridSris;
	}

	public Border setResaltarcodigoSris(ParametroGeneralUsuario parametroGeneralUsuario/*SrisBeanSwingJInternalFrame srisBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srisBeanSwingJInternalFrame.jTtoolBarSris.setBorder(borderResaltar);
		
		this.resaltarcodigoSris= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoSris() {
		return this.resaltarcodigoSris;
	}

	public void setResaltarcodigoSris(Border borderResaltar) {
		this.resaltarcodigoSris= borderResaltar;
	}

	public Boolean getMostrarcodigoSris() {
		return this.mostrarcodigoSris;
	}

	public void setMostrarcodigoSris(Boolean mostrarcodigoSris) {
		this.mostrarcodigoSris= mostrarcodigoSris;
	}

	public Boolean getActivarcodigoSris() {
		return this.activarcodigoSris;
	}

	public void setActivarcodigoSris(Boolean activarcodigoSris) {
		this.activarcodigoSris= activarcodigoSris;
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
		
		
		this.setMostraridSris(esInicial);
		this.setMostrarcodigoSris(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SrisConstantesFunciones.ID)) {
				this.setMostraridSris(esAsigna);
				continue;
			}

			if(campo.clase.equals(SrisConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoSris(esAsigna);
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
		
		
		this.setActivaridSris(esInicial);
		this.setActivarcodigoSris(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SrisConstantesFunciones.ID)) {
				this.setActivaridSris(esAsigna);
				continue;
			}

			if(campo.clase.equals(SrisConstantesFunciones.CODIGO)) {
				this.setActivarcodigoSris(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SrisBeanSwingJInternalFrame srisBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSris(esInicial);
		this.setResaltarcodigoSris(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SrisConstantesFunciones.ID)) {
				this.setResaltaridSris(esAsigna);
				continue;
			}

			if(campo.clase.equals(SrisConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoSris(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SrisBeanSwingJInternalFrame srisBeanSwingJInternalFrame*/)throws Exception {	
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