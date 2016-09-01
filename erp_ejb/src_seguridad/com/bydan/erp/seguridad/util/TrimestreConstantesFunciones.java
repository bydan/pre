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


import com.bydan.erp.seguridad.util.TrimestreConstantesFunciones;
import com.bydan.erp.seguridad.util.TrimestreParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.TrimestreParameterGeneral;

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
final public class TrimestreConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="Trimestre";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Trimestre"+TrimestreConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TrimestreHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TrimestreHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TrimestreConstantesFunciones.SCHEMA+"_"+TrimestreConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TrimestreHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TrimestreConstantesFunciones.SCHEMA+"_"+TrimestreConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TrimestreConstantesFunciones.SCHEMA+"_"+TrimestreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TrimestreHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TrimestreConstantesFunciones.SCHEMA+"_"+TrimestreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TrimestreConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TrimestreHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TrimestreConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TrimestreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TrimestreHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TrimestreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TrimestreConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TrimestreConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TrimestreConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TrimestreConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Trimestres";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Trimestre";
	public static final String SCLASSWEBTITULO_LOWER="Trimestre";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Trimestre";
	public static final String OBJECTNAME="trimestre";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="trimestre";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select trimestre from "+TrimestreConstantesFunciones.SPERSISTENCENAME+" trimestre";
	public static String QUERYSELECTNATIVE="select "+TrimestreConstantesFunciones.SCHEMA+"."+TrimestreConstantesFunciones.TABLENAME+".id,"+TrimestreConstantesFunciones.SCHEMA+"."+TrimestreConstantesFunciones.TABLENAME+".version_row,"+TrimestreConstantesFunciones.SCHEMA+"."+TrimestreConstantesFunciones.TABLENAME+".nombre from "+TrimestreConstantesFunciones.SCHEMA+"."+TrimestreConstantesFunciones.TABLENAME;//+" as "+TrimestreConstantesFunciones.TABLENAME;
	
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
	
	public static String getTrimestreLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TrimestreConstantesFunciones.NOMBRE)) {sLabelColumna=TrimestreConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getTrimestreDescripcion(Trimestre trimestre) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(trimestre !=null/* && trimestre.getId()!=0*/) {
			sDescripcion=trimestre.getnombre();//trimestretrimestre.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTrimestreDescripcionDetallado(Trimestre trimestre) {
		String sDescripcion="";
			
		sDescripcion+=TrimestreConstantesFunciones.ID+"=";
		sDescripcion+=trimestre.getId().toString()+",";
		sDescripcion+=TrimestreConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=trimestre.getVersionRow().toString()+",";
		sDescripcion+=TrimestreConstantesFunciones.NOMBRE+"=";
		sDescripcion+=trimestre.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTrimestreDescripcion(Trimestre trimestre,String sValor) throws Exception {			
		if(trimestre !=null) {
			trimestre.setnombre(sValor);;//trimestretrimestre.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTrimestre(Trimestre trimestre,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		trimestre.setnombre(trimestre.getnombre().trim());
	}
	
	public static void quitarEspaciosTrimestres(List<Trimestre> trimestres,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Trimestre trimestre: trimestres) {
			trimestre.setnombre(trimestre.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTrimestre(Trimestre trimestre,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && trimestre.getConCambioAuxiliar()) {
			trimestre.setIsDeleted(trimestre.getIsDeletedAuxiliar());	
			trimestre.setIsNew(trimestre.getIsNewAuxiliar());	
			trimestre.setIsChanged(trimestre.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			trimestre.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			trimestre.setIsDeletedAuxiliar(false);	
			trimestre.setIsNewAuxiliar(false);	
			trimestre.setIsChangedAuxiliar(false);
			
			trimestre.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTrimestres(List<Trimestre> trimestres,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Trimestre trimestre : trimestres) {
			if(conAsignarBase && trimestre.getConCambioAuxiliar()) {
				trimestre.setIsDeleted(trimestre.getIsDeletedAuxiliar());	
				trimestre.setIsNew(trimestre.getIsNewAuxiliar());	
				trimestre.setIsChanged(trimestre.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				trimestre.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				trimestre.setIsDeletedAuxiliar(false);	
				trimestre.setIsNewAuxiliar(false);	
				trimestre.setIsChangedAuxiliar(false);
				
				trimestre.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTrimestre(Trimestre trimestre,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTrimestres(List<Trimestre> trimestres,Boolean conEnteros) throws Exception  {
		
		for(Trimestre trimestre: trimestres) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTrimestre(List<Trimestre> trimestres,Trimestre trimestreAux) throws Exception  {
		TrimestreConstantesFunciones.InicializarValoresTrimestre(trimestreAux,true);
		
		for(Trimestre trimestre: trimestres) {
			if(trimestre.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTrimestre(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TrimestreConstantesFunciones.getArrayColumnasGlobalesTrimestre(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTrimestre(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTrimestre(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Trimestre> trimestres,Trimestre trimestre,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Trimestre trimestreAux: trimestres) {
			if(trimestreAux!=null && trimestre!=null) {
				if((trimestreAux.getId()==null && trimestre.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(trimestreAux.getId()!=null && trimestre.getId()!=null){
					if(trimestreAux.getId().equals(trimestre.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTrimestre(List<Trimestre> trimestres) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Trimestre trimestre: trimestres) {			
			if(trimestre.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTrimestre() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TrimestreConstantesFunciones.LABEL_ID, TrimestreConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TrimestreConstantesFunciones.LABEL_VERSIONROW, TrimestreConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TrimestreConstantesFunciones.LABEL_NOMBRE, TrimestreConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTrimestre() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TrimestreConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TrimestreConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TrimestreConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTrimestre() throws Exception  {
		return TrimestreConstantesFunciones.getTiposSeleccionarTrimestre(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTrimestre(Boolean conFk) throws Exception  {
		return TrimestreConstantesFunciones.getTiposSeleccionarTrimestre(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTrimestre(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TrimestreConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TrimestreConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTrimestre(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTrimestre(Trimestre trimestreAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTrimestre(List<Trimestre> trimestresTemp) throws Exception {
		for(Trimestre trimestreAux:trimestresTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTrimestre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTrimestre(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTrimestre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TrimestreConstantesFunciones.getClassesRelationshipsOfTrimestre(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTrimestre(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTrimestre(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TrimestreConstantesFunciones.getClassesRelationshipsFromStringsOfTrimestre(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTrimestre(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Trimestre trimestre,List<Trimestre> trimestres,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Trimestre trimestreEncontrado=null;
			
			for(Trimestre trimestreLocal:trimestres) {
				if(trimestreLocal.getId().equals(trimestre.getId())) {
					trimestreEncontrado=trimestreLocal;
					
					trimestreLocal.setIsChanged(trimestre.getIsChanged());
					trimestreLocal.setIsNew(trimestre.getIsNew());
					trimestreLocal.setIsDeleted(trimestre.getIsDeleted());
					
					trimestreLocal.setGeneralEntityOriginal(trimestre.getGeneralEntityOriginal());
					
					trimestreLocal.setId(trimestre.getId());	
					trimestreLocal.setVersionRow(trimestre.getVersionRow());	
					trimestreLocal.setnombre(trimestre.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!trimestre.getIsDeleted()) {
				if(!existe) {
					trimestres.add(trimestre);
				}
			} else {
				if(trimestreEncontrado!=null && permiteQuitar)  {
					trimestres.remove(trimestreEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Trimestre trimestre,List<Trimestre> trimestres) throws Exception {
		try	{			
			for(Trimestre trimestreLocal:trimestres) {
				if(trimestreLocal.getId().equals(trimestre.getId())) {
					trimestreLocal.setIsSelected(trimestre.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTrimestre(List<Trimestre> trimestresAux) throws Exception {
		//this.trimestresAux=trimestresAux;
		
		for(Trimestre trimestreAux:trimestresAux) {
			if(trimestreAux.getIsChanged()) {
				trimestreAux.setIsChanged(false);
			}		
			
			if(trimestreAux.getIsNew()) {
				trimestreAux.setIsNew(false);
			}	
			
			if(trimestreAux.getIsDeleted()) {
				trimestreAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTrimestre(Trimestre trimestreAux) throws Exception {
		//this.trimestreAux=trimestreAux;
		
			if(trimestreAux.getIsChanged()) {
				trimestreAux.setIsChanged(false);
			}		
			
			if(trimestreAux.getIsNew()) {
				trimestreAux.setIsNew(false);
			}	
			
			if(trimestreAux.getIsDeleted()) {
				trimestreAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Trimestre trimestreAsignar,Trimestre trimestre) throws Exception {
		trimestreAsignar.setId(trimestre.getId());	
		trimestreAsignar.setVersionRow(trimestre.getVersionRow());	
		trimestreAsignar.setnombre(trimestre.getnombre());	
	}
	
	public static void inicializarTrimestre(Trimestre trimestre) throws Exception {
		try {
				trimestre.setId(0L);	
					
				trimestre.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTrimestre(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TrimestreConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTrimestre(String sTipo,Row row,Workbook workbook,Trimestre trimestre,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(trimestre.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTrimestre=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTrimestre() {
		return this.sFinalQueryTrimestre;
	}
	
	public void setsFinalQueryTrimestre(String sFinalQueryTrimestre) {
		this.sFinalQueryTrimestre= sFinalQueryTrimestre;
	}
	
	public Border resaltarSeleccionarTrimestre=null;
	
	public Border setResaltarSeleccionarTrimestre(ParametroGeneralUsuario parametroGeneralUsuario/*TrimestreBeanSwingJInternalFrame trimestreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//trimestreBeanSwingJInternalFrame.jTtoolBarTrimestre.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTrimestre= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTrimestre() {
		return this.resaltarSeleccionarTrimestre;
	}
	
	public void setResaltarSeleccionarTrimestre(Border borderResaltarSeleccionarTrimestre) {
		this.resaltarSeleccionarTrimestre= borderResaltarSeleccionarTrimestre;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTrimestre=null;
	public Boolean mostraridTrimestre=true;
	public Boolean activaridTrimestre=true;

	public Border resaltarnombreTrimestre=null;
	public Boolean mostrarnombreTrimestre=true;
	public Boolean activarnombreTrimestre=true;

	
	

	public Border setResaltaridTrimestre(ParametroGeneralUsuario parametroGeneralUsuario/*TrimestreBeanSwingJInternalFrame trimestreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//trimestreBeanSwingJInternalFrame.jTtoolBarTrimestre.setBorder(borderResaltar);
		
		this.resaltaridTrimestre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTrimestre() {
		return this.resaltaridTrimestre;
	}

	public void setResaltaridTrimestre(Border borderResaltar) {
		this.resaltaridTrimestre= borderResaltar;
	}

	public Boolean getMostraridTrimestre() {
		return this.mostraridTrimestre;
	}

	public void setMostraridTrimestre(Boolean mostraridTrimestre) {
		this.mostraridTrimestre= mostraridTrimestre;
	}

	public Boolean getActivaridTrimestre() {
		return this.activaridTrimestre;
	}

	public void setActivaridTrimestre(Boolean activaridTrimestre) {
		this.activaridTrimestre= activaridTrimestre;
	}

	public Border setResaltarnombreTrimestre(ParametroGeneralUsuario parametroGeneralUsuario/*TrimestreBeanSwingJInternalFrame trimestreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//trimestreBeanSwingJInternalFrame.jTtoolBarTrimestre.setBorder(borderResaltar);
		
		this.resaltarnombreTrimestre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTrimestre() {
		return this.resaltarnombreTrimestre;
	}

	public void setResaltarnombreTrimestre(Border borderResaltar) {
		this.resaltarnombreTrimestre= borderResaltar;
	}

	public Boolean getMostrarnombreTrimestre() {
		return this.mostrarnombreTrimestre;
	}

	public void setMostrarnombreTrimestre(Boolean mostrarnombreTrimestre) {
		this.mostrarnombreTrimestre= mostrarnombreTrimestre;
	}

	public Boolean getActivarnombreTrimestre() {
		return this.activarnombreTrimestre;
	}

	public void setActivarnombreTrimestre(Boolean activarnombreTrimestre) {
		this.activarnombreTrimestre= activarnombreTrimestre;
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
		
		
		this.setMostraridTrimestre(esInicial);
		this.setMostrarnombreTrimestre(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TrimestreConstantesFunciones.ID)) {
				this.setMostraridTrimestre(esAsigna);
				continue;
			}

			if(campo.clase.equals(TrimestreConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTrimestre(esAsigna);
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
		
		
		this.setActivaridTrimestre(esInicial);
		this.setActivarnombreTrimestre(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TrimestreConstantesFunciones.ID)) {
				this.setActivaridTrimestre(esAsigna);
				continue;
			}

			if(campo.clase.equals(TrimestreConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTrimestre(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TrimestreBeanSwingJInternalFrame trimestreBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTrimestre(esInicial);
		this.setResaltarnombreTrimestre(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TrimestreConstantesFunciones.ID)) {
				this.setResaltaridTrimestre(esAsigna);
				continue;
			}

			if(campo.clase.equals(TrimestreConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTrimestre(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TrimestreBeanSwingJInternalFrame trimestreBeanSwingJInternalFrame*/)throws Exception {	
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