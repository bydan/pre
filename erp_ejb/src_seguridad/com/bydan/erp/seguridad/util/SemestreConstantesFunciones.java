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
package com.bydan.erp.seguridad.util;

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


import com.bydan.erp.seguridad.util.SemestreConstantesFunciones;
import com.bydan.erp.seguridad.util.SemestreParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.SemestreParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;



import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class SemestreConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="Semestre";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Semestre"+SemestreConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SemestreHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SemestreHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SemestreConstantesFunciones.SCHEMA+"_"+SemestreConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SemestreHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SemestreConstantesFunciones.SCHEMA+"_"+SemestreConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SemestreConstantesFunciones.SCHEMA+"_"+SemestreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SemestreHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SemestreConstantesFunciones.SCHEMA+"_"+SemestreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SemestreConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SemestreHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SemestreConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SemestreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SemestreHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SemestreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SemestreConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SemestreConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SemestreConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SemestreConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Semestres";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Semestre";
	public static final String SCLASSWEBTITULO_LOWER="Semestre";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Semestre";
	public static final String OBJECTNAME="semestre";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="semestre";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select semestre from "+SemestreConstantesFunciones.SPERSISTENCENAME+" semestre";
	public static String QUERYSELECTNATIVE="select "+SemestreConstantesFunciones.SCHEMA+"."+SemestreConstantesFunciones.TABLENAME+".id,"+SemestreConstantesFunciones.SCHEMA+"."+SemestreConstantesFunciones.TABLENAME+".version_row,"+SemestreConstantesFunciones.SCHEMA+"."+SemestreConstantesFunciones.TABLENAME+".nombre from "+SemestreConstantesFunciones.SCHEMA+"."+SemestreConstantesFunciones.TABLENAME;//+" as "+SemestreConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getSemestreLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SemestreConstantesFunciones.NOMBRE)) {sLabelColumna=SemestreConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getSemestreDescripcion(Semestre semestre) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(semestre !=null/* && semestre.getId()!=0*/) {
			sDescripcion=semestre.getnombre();//semestresemestre.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getSemestreDescripcionDetallado(Semestre semestre) {
		String sDescripcion="";
			
		sDescripcion+=SemestreConstantesFunciones.ID+"=";
		sDescripcion+=semestre.getId().toString()+",";
		sDescripcion+=SemestreConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=semestre.getVersionRow().toString()+",";
		sDescripcion+=SemestreConstantesFunciones.NOMBRE+"=";
		sDescripcion+=semestre.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setSemestreDescripcion(Semestre semestre,String sValor) throws Exception {			
		if(semestre !=null) {
			semestre.setnombre(sValor);;//semestresemestre.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosSemestre(Semestre semestre,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		semestre.setnombre(semestre.getnombre().trim());
	}
	
	public static void quitarEspaciosSemestres(List<Semestre> semestres,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Semestre semestre: semestres) {
			semestre.setnombre(semestre.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSemestre(Semestre semestre,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && semestre.getConCambioAuxiliar()) {
			semestre.setIsDeleted(semestre.getIsDeletedAuxiliar());	
			semestre.setIsNew(semestre.getIsNewAuxiliar());	
			semestre.setIsChanged(semestre.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			semestre.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			semestre.setIsDeletedAuxiliar(false);	
			semestre.setIsNewAuxiliar(false);	
			semestre.setIsChangedAuxiliar(false);
			
			semestre.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSemestres(List<Semestre> semestres,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Semestre semestre : semestres) {
			if(conAsignarBase && semestre.getConCambioAuxiliar()) {
				semestre.setIsDeleted(semestre.getIsDeletedAuxiliar());	
				semestre.setIsNew(semestre.getIsNewAuxiliar());	
				semestre.setIsChanged(semestre.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				semestre.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				semestre.setIsDeletedAuxiliar(false);	
				semestre.setIsNewAuxiliar(false);	
				semestre.setIsChangedAuxiliar(false);
				
				semestre.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSemestre(Semestre semestre,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSemestres(List<Semestre> semestres,Boolean conEnteros) throws Exception  {
		
		for(Semestre semestre: semestres) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSemestre(List<Semestre> semestres,Semestre semestreAux) throws Exception  {
		SemestreConstantesFunciones.InicializarValoresSemestre(semestreAux,true);
		
		for(Semestre semestre: semestres) {
			if(semestre.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSemestre(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SemestreConstantesFunciones.getArrayColumnasGlobalesSemestre(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSemestre(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSemestre(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Semestre> semestres,Semestre semestre,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Semestre semestreAux: semestres) {
			if(semestreAux!=null && semestre!=null) {
				if((semestreAux.getId()==null && semestre.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(semestreAux.getId()!=null && semestre.getId()!=null){
					if(semestreAux.getId().equals(semestre.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSemestre(List<Semestre> semestres) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Semestre semestre: semestres) {			
			if(semestre.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSemestre() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SemestreConstantesFunciones.LABEL_ID, SemestreConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SemestreConstantesFunciones.LABEL_VERSIONROW, SemestreConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SemestreConstantesFunciones.LABEL_NOMBRE, SemestreConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSemestre() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SemestreConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SemestreConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SemestreConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSemestre() throws Exception  {
		return SemestreConstantesFunciones.getTiposSeleccionarSemestre(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSemestre(Boolean conFk) throws Exception  {
		return SemestreConstantesFunciones.getTiposSeleccionarSemestre(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSemestre(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SemestreConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(SemestreConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSemestre(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSemestre(Semestre semestreAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesSemestre(List<Semestre> semestresTemp) throws Exception {
		for(Semestre semestreAux:semestresTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSemestre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSemestre(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSemestre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SemestreConstantesFunciones.getClassesRelationshipsOfSemestre(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSemestre(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSemestre(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SemestreConstantesFunciones.getClassesRelationshipsFromStringsOfSemestre(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSemestre(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(Semestre semestre,List<Semestre> semestres,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Semestre semestreEncontrado=null;
			
			for(Semestre semestreLocal:semestres) {
				if(semestreLocal.getId().equals(semestre.getId())) {
					semestreEncontrado=semestreLocal;
					
					semestreLocal.setIsChanged(semestre.getIsChanged());
					semestreLocal.setIsNew(semestre.getIsNew());
					semestreLocal.setIsDeleted(semestre.getIsDeleted());
					
					semestreLocal.setGeneralEntityOriginal(semestre.getGeneralEntityOriginal());
					
					semestreLocal.setId(semestre.getId());	
					semestreLocal.setVersionRow(semestre.getVersionRow());	
					semestreLocal.setnombre(semestre.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!semestre.getIsDeleted()) {
				if(!existe) {
					semestres.add(semestre);
				}
			} else {
				if(semestreEncontrado!=null && permiteQuitar)  {
					semestres.remove(semestreEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Semestre semestre,List<Semestre> semestres) throws Exception {
		try	{			
			for(Semestre semestreLocal:semestres) {
				if(semestreLocal.getId().equals(semestre.getId())) {
					semestreLocal.setIsSelected(semestre.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSemestre(List<Semestre> semestresAux) throws Exception {
		//this.semestresAux=semestresAux;
		
		for(Semestre semestreAux:semestresAux) {
			if(semestreAux.getIsChanged()) {
				semestreAux.setIsChanged(false);
			}		
			
			if(semestreAux.getIsNew()) {
				semestreAux.setIsNew(false);
			}	
			
			if(semestreAux.getIsDeleted()) {
				semestreAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSemestre(Semestre semestreAux) throws Exception {
		//this.semestreAux=semestreAux;
		
			if(semestreAux.getIsChanged()) {
				semestreAux.setIsChanged(false);
			}		
			
			if(semestreAux.getIsNew()) {
				semestreAux.setIsNew(false);
			}	
			
			if(semestreAux.getIsDeleted()) {
				semestreAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Semestre semestreAsignar,Semestre semestre) throws Exception {
		semestreAsignar.setId(semestre.getId());	
		semestreAsignar.setVersionRow(semestre.getVersionRow());	
		semestreAsignar.setnombre(semestre.getnombre());	
	}
	
	public static void inicializarSemestre(Semestre semestre) throws Exception {
		try {
				semestre.setId(0L);	
					
				semestre.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSemestre(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SemestreConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSemestre(String sTipo,Row row,Workbook workbook,Semestre semestre,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(semestre.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySemestre=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySemestre() {
		return this.sFinalQuerySemestre;
	}
	
	public void setsFinalQuerySemestre(String sFinalQuerySemestre) {
		this.sFinalQuerySemestre= sFinalQuerySemestre;
	}
	
	public Border resaltarSeleccionarSemestre=null;
	
	public Border setResaltarSeleccionarSemestre(ParametroGeneralUsuario parametroGeneralUsuario/*SemestreBeanSwingJInternalFrame semestreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//semestreBeanSwingJInternalFrame.jTtoolBarSemestre.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSemestre= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSemestre() {
		return this.resaltarSeleccionarSemestre;
	}
	
	public void setResaltarSeleccionarSemestre(Border borderResaltarSeleccionarSemestre) {
		this.resaltarSeleccionarSemestre= borderResaltarSeleccionarSemestre;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSemestre=null;
	public Boolean mostraridSemestre=true;
	public Boolean activaridSemestre=true;

	public Border resaltarnombreSemestre=null;
	public Boolean mostrarnombreSemestre=true;
	public Boolean activarnombreSemestre=true;

	
	

	public Border setResaltaridSemestre(ParametroGeneralUsuario parametroGeneralUsuario/*SemestreBeanSwingJInternalFrame semestreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//semestreBeanSwingJInternalFrame.jTtoolBarSemestre.setBorder(borderResaltar);
		
		this.resaltaridSemestre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSemestre() {
		return this.resaltaridSemestre;
	}

	public void setResaltaridSemestre(Border borderResaltar) {
		this.resaltaridSemestre= borderResaltar;
	}

	public Boolean getMostraridSemestre() {
		return this.mostraridSemestre;
	}

	public void setMostraridSemestre(Boolean mostraridSemestre) {
		this.mostraridSemestre= mostraridSemestre;
	}

	public Boolean getActivaridSemestre() {
		return this.activaridSemestre;
	}

	public void setActivaridSemestre(Boolean activaridSemestre) {
		this.activaridSemestre= activaridSemestre;
	}

	public Border setResaltarnombreSemestre(ParametroGeneralUsuario parametroGeneralUsuario/*SemestreBeanSwingJInternalFrame semestreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//semestreBeanSwingJInternalFrame.jTtoolBarSemestre.setBorder(borderResaltar);
		
		this.resaltarnombreSemestre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreSemestre() {
		return this.resaltarnombreSemestre;
	}

	public void setResaltarnombreSemestre(Border borderResaltar) {
		this.resaltarnombreSemestre= borderResaltar;
	}

	public Boolean getMostrarnombreSemestre() {
		return this.mostrarnombreSemestre;
	}

	public void setMostrarnombreSemestre(Boolean mostrarnombreSemestre) {
		this.mostrarnombreSemestre= mostrarnombreSemestre;
	}

	public Boolean getActivarnombreSemestre() {
		return this.activarnombreSemestre;
	}

	public void setActivarnombreSemestre(Boolean activarnombreSemestre) {
		this.activarnombreSemestre= activarnombreSemestre;
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
		
		
		this.setMostraridSemestre(esInicial);
		this.setMostrarnombreSemestre(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SemestreConstantesFunciones.ID)) {
				this.setMostraridSemestre(esAsigna);
				continue;
			}

			if(campo.clase.equals(SemestreConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreSemestre(esAsigna);
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
		
		
		this.setActivaridSemestre(esInicial);
		this.setActivarnombreSemestre(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SemestreConstantesFunciones.ID)) {
				this.setActivaridSemestre(esAsigna);
				continue;
			}

			if(campo.clase.equals(SemestreConstantesFunciones.NOMBRE)) {
				this.setActivarnombreSemestre(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SemestreBeanSwingJInternalFrame semestreBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSemestre(esInicial);
		this.setResaltarnombreSemestre(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SemestreConstantesFunciones.ID)) {
				this.setResaltaridSemestre(esAsigna);
				continue;
			}

			if(campo.clase.equals(SemestreConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreSemestre(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SemestreBeanSwingJInternalFrame semestreBeanSwingJInternalFrame*/)throws Exception {	
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