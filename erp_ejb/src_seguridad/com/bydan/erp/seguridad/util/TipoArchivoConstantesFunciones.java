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


import com.bydan.erp.seguridad.util.TipoArchivoConstantesFunciones;
import com.bydan.erp.seguridad.util.TipoArchivoParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.TipoArchivoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;



import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoArchivoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoArchivo";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoArchivo"+TipoArchivoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoArchivoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoArchivoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoArchivoConstantesFunciones.SCHEMA+"_"+TipoArchivoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoArchivoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoArchivoConstantesFunciones.SCHEMA+"_"+TipoArchivoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoArchivoConstantesFunciones.SCHEMA+"_"+TipoArchivoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoArchivoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoArchivoConstantesFunciones.SCHEMA+"_"+TipoArchivoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoArchivoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoArchivoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoArchivoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoArchivoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoArchivoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoArchivoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoArchivoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoArchivoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoArchivoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoArchivoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Archivos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Archivo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Archivo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoArchivo";
	public static final String OBJECTNAME="tipoarchivo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="tipo_archivo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoarchivo from "+TipoArchivoConstantesFunciones.SPERSISTENCENAME+" tipoarchivo";
	public static String QUERYSELECTNATIVE="select "+TipoArchivoConstantesFunciones.SCHEMA+"."+TipoArchivoConstantesFunciones.TABLENAME+".id,"+TipoArchivoConstantesFunciones.SCHEMA+"."+TipoArchivoConstantesFunciones.TABLENAME+".version_row,"+TipoArchivoConstantesFunciones.SCHEMA+"."+TipoArchivoConstantesFunciones.TABLENAME+".codigo,"+TipoArchivoConstantesFunciones.SCHEMA+"."+TipoArchivoConstantesFunciones.TABLENAME+".nombre from "+TipoArchivoConstantesFunciones.SCHEMA+"."+TipoArchivoConstantesFunciones.TABLENAME;//+" as "+TipoArchivoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoArchivoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoArchivoConstantesFunciones.CODIGO)) {sLabelColumna=TipoArchivoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoArchivoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoArchivoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoArchivoDescripcion(TipoArchivo tipoarchivo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoarchivo !=null/* && tipoarchivo.getId()!=0*/) {
			sDescripcion=tipoarchivo.getcodigo();//tipoarchivotipoarchivo.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoArchivoDescripcionDetallado(TipoArchivo tipoarchivo) {
		String sDescripcion="";
			
		sDescripcion+=TipoArchivoConstantesFunciones.ID+"=";
		sDescripcion+=tipoarchivo.getId().toString()+",";
		sDescripcion+=TipoArchivoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoarchivo.getVersionRow().toString()+",";
		sDescripcion+=TipoArchivoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoarchivo.getcodigo()+",";
		sDescripcion+=TipoArchivoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoarchivo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoArchivoDescripcion(TipoArchivo tipoarchivo,String sValor) throws Exception {			
		if(tipoarchivo !=null) {
			tipoarchivo.setcodigo(sValor);;//tipoarchivotipoarchivo.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoArchivo(TipoArchivo tipoarchivo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoarchivo.setcodigo(tipoarchivo.getcodigo().trim());
		tipoarchivo.setnombre(tipoarchivo.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoArchivos(List<TipoArchivo> tipoarchivos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoArchivo tipoarchivo: tipoarchivos) {
			tipoarchivo.setcodigo(tipoarchivo.getcodigo().trim());
			tipoarchivo.setnombre(tipoarchivo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoArchivo(TipoArchivo tipoarchivo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoarchivo.getConCambioAuxiliar()) {
			tipoarchivo.setIsDeleted(tipoarchivo.getIsDeletedAuxiliar());	
			tipoarchivo.setIsNew(tipoarchivo.getIsNewAuxiliar());	
			tipoarchivo.setIsChanged(tipoarchivo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoarchivo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoarchivo.setIsDeletedAuxiliar(false);	
			tipoarchivo.setIsNewAuxiliar(false);	
			tipoarchivo.setIsChangedAuxiliar(false);
			
			tipoarchivo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoArchivos(List<TipoArchivo> tipoarchivos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoArchivo tipoarchivo : tipoarchivos) {
			if(conAsignarBase && tipoarchivo.getConCambioAuxiliar()) {
				tipoarchivo.setIsDeleted(tipoarchivo.getIsDeletedAuxiliar());	
				tipoarchivo.setIsNew(tipoarchivo.getIsNewAuxiliar());	
				tipoarchivo.setIsChanged(tipoarchivo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoarchivo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoarchivo.setIsDeletedAuxiliar(false);	
				tipoarchivo.setIsNewAuxiliar(false);	
				tipoarchivo.setIsChangedAuxiliar(false);
				
				tipoarchivo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoArchivo(TipoArchivo tipoarchivo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoArchivos(List<TipoArchivo> tipoarchivos,Boolean conEnteros) throws Exception  {
		
		for(TipoArchivo tipoarchivo: tipoarchivos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoArchivo(List<TipoArchivo> tipoarchivos,TipoArchivo tipoarchivoAux) throws Exception  {
		TipoArchivoConstantesFunciones.InicializarValoresTipoArchivo(tipoarchivoAux,true);
		
		for(TipoArchivo tipoarchivo: tipoarchivos) {
			if(tipoarchivo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoArchivo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoArchivoConstantesFunciones.getArrayColumnasGlobalesTipoArchivo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoArchivo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoArchivo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoArchivo> tipoarchivos,TipoArchivo tipoarchivo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoArchivo tipoarchivoAux: tipoarchivos) {
			if(tipoarchivoAux!=null && tipoarchivo!=null) {
				if((tipoarchivoAux.getId()==null && tipoarchivo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoarchivoAux.getId()!=null && tipoarchivo.getId()!=null){
					if(tipoarchivoAux.getId().equals(tipoarchivo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoArchivo(List<TipoArchivo> tipoarchivos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoArchivo tipoarchivo: tipoarchivos) {			
			if(tipoarchivo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoArchivo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoArchivoConstantesFunciones.LABEL_ID, TipoArchivoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoArchivoConstantesFunciones.LABEL_VERSIONROW, TipoArchivoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoArchivoConstantesFunciones.LABEL_CODIGO, TipoArchivoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoArchivoConstantesFunciones.LABEL_NOMBRE, TipoArchivoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoArchivo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoArchivoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoArchivoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoArchivoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoArchivoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoArchivo() throws Exception  {
		return TipoArchivoConstantesFunciones.getTiposSeleccionarTipoArchivo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoArchivo(Boolean conFk) throws Exception  {
		return TipoArchivoConstantesFunciones.getTiposSeleccionarTipoArchivo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoArchivo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoArchivoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoArchivoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoArchivoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoArchivoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoArchivo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoArchivo(TipoArchivo tipoarchivoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoArchivo(List<TipoArchivo> tipoarchivosTemp) throws Exception {
		for(TipoArchivo tipoarchivoAux:tipoarchivosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoArchivo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoArchivo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoArchivo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoArchivoConstantesFunciones.getClassesRelationshipsOfTipoArchivo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoArchivo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoArchivo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoArchivoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoArchivo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoArchivo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoArchivo tipoarchivo,List<TipoArchivo> tipoarchivos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoArchivo tipoarchivoEncontrado=null;
			
			for(TipoArchivo tipoarchivoLocal:tipoarchivos) {
				if(tipoarchivoLocal.getId().equals(tipoarchivo.getId())) {
					tipoarchivoEncontrado=tipoarchivoLocal;
					
					tipoarchivoLocal.setIsChanged(tipoarchivo.getIsChanged());
					tipoarchivoLocal.setIsNew(tipoarchivo.getIsNew());
					tipoarchivoLocal.setIsDeleted(tipoarchivo.getIsDeleted());
					
					tipoarchivoLocal.setGeneralEntityOriginal(tipoarchivo.getGeneralEntityOriginal());
					
					tipoarchivoLocal.setId(tipoarchivo.getId());	
					tipoarchivoLocal.setVersionRow(tipoarchivo.getVersionRow());	
					tipoarchivoLocal.setcodigo(tipoarchivo.getcodigo());	
					tipoarchivoLocal.setnombre(tipoarchivo.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoarchivo.getIsDeleted()) {
				if(!existe) {
					tipoarchivos.add(tipoarchivo);
				}
			} else {
				if(tipoarchivoEncontrado!=null && permiteQuitar)  {
					tipoarchivos.remove(tipoarchivoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoArchivo tipoarchivo,List<TipoArchivo> tipoarchivos) throws Exception {
		try	{			
			for(TipoArchivo tipoarchivoLocal:tipoarchivos) {
				if(tipoarchivoLocal.getId().equals(tipoarchivo.getId())) {
					tipoarchivoLocal.setIsSelected(tipoarchivo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoArchivo(List<TipoArchivo> tipoarchivosAux) throws Exception {
		//this.tipoarchivosAux=tipoarchivosAux;
		
		for(TipoArchivo tipoarchivoAux:tipoarchivosAux) {
			if(tipoarchivoAux.getIsChanged()) {
				tipoarchivoAux.setIsChanged(false);
			}		
			
			if(tipoarchivoAux.getIsNew()) {
				tipoarchivoAux.setIsNew(false);
			}	
			
			if(tipoarchivoAux.getIsDeleted()) {
				tipoarchivoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoArchivo(TipoArchivo tipoarchivoAux) throws Exception {
		//this.tipoarchivoAux=tipoarchivoAux;
		
			if(tipoarchivoAux.getIsChanged()) {
				tipoarchivoAux.setIsChanged(false);
			}		
			
			if(tipoarchivoAux.getIsNew()) {
				tipoarchivoAux.setIsNew(false);
			}	
			
			if(tipoarchivoAux.getIsDeleted()) {
				tipoarchivoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoArchivo tipoarchivoAsignar,TipoArchivo tipoarchivo) throws Exception {
		tipoarchivoAsignar.setId(tipoarchivo.getId());	
		tipoarchivoAsignar.setVersionRow(tipoarchivo.getVersionRow());	
		tipoarchivoAsignar.setcodigo(tipoarchivo.getcodigo());	
		tipoarchivoAsignar.setnombre(tipoarchivo.getnombre());	
	}
	
	public static void inicializarTipoArchivo(TipoArchivo tipoarchivo) throws Exception {
		try {
				tipoarchivo.setId(0L);	
					
				tipoarchivo.setcodigo("");	
				tipoarchivo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoArchivo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoArchivoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoArchivoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoArchivo(String sTipo,Row row,Workbook workbook,TipoArchivo tipoarchivo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoarchivo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoarchivo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoArchivo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoArchivo() {
		return this.sFinalQueryTipoArchivo;
	}
	
	public void setsFinalQueryTipoArchivo(String sFinalQueryTipoArchivo) {
		this.sFinalQueryTipoArchivo= sFinalQueryTipoArchivo;
	}
	
	public Border resaltarSeleccionarTipoArchivo=null;
	
	public Border setResaltarSeleccionarTipoArchivo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoArchivoBeanSwingJInternalFrame tipoarchivoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoarchivoBeanSwingJInternalFrame.jTtoolBarTipoArchivo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoArchivo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoArchivo() {
		return this.resaltarSeleccionarTipoArchivo;
	}
	
	public void setResaltarSeleccionarTipoArchivo(Border borderResaltarSeleccionarTipoArchivo) {
		this.resaltarSeleccionarTipoArchivo= borderResaltarSeleccionarTipoArchivo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoArchivo=null;
	public Boolean mostraridTipoArchivo=true;
	public Boolean activaridTipoArchivo=true;

	public Border resaltarcodigoTipoArchivo=null;
	public Boolean mostrarcodigoTipoArchivo=true;
	public Boolean activarcodigoTipoArchivo=true;

	public Border resaltarnombreTipoArchivo=null;
	public Boolean mostrarnombreTipoArchivo=true;
	public Boolean activarnombreTipoArchivo=true;

	
	

	public Border setResaltaridTipoArchivo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoArchivoBeanSwingJInternalFrame tipoarchivoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoarchivoBeanSwingJInternalFrame.jTtoolBarTipoArchivo.setBorder(borderResaltar);
		
		this.resaltaridTipoArchivo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoArchivo() {
		return this.resaltaridTipoArchivo;
	}

	public void setResaltaridTipoArchivo(Border borderResaltar) {
		this.resaltaridTipoArchivo= borderResaltar;
	}

	public Boolean getMostraridTipoArchivo() {
		return this.mostraridTipoArchivo;
	}

	public void setMostraridTipoArchivo(Boolean mostraridTipoArchivo) {
		this.mostraridTipoArchivo= mostraridTipoArchivo;
	}

	public Boolean getActivaridTipoArchivo() {
		return this.activaridTipoArchivo;
	}

	public void setActivaridTipoArchivo(Boolean activaridTipoArchivo) {
		this.activaridTipoArchivo= activaridTipoArchivo;
	}

	public Border setResaltarcodigoTipoArchivo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoArchivoBeanSwingJInternalFrame tipoarchivoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoarchivoBeanSwingJInternalFrame.jTtoolBarTipoArchivo.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoArchivo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoArchivo() {
		return this.resaltarcodigoTipoArchivo;
	}

	public void setResaltarcodigoTipoArchivo(Border borderResaltar) {
		this.resaltarcodigoTipoArchivo= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoArchivo() {
		return this.mostrarcodigoTipoArchivo;
	}

	public void setMostrarcodigoTipoArchivo(Boolean mostrarcodigoTipoArchivo) {
		this.mostrarcodigoTipoArchivo= mostrarcodigoTipoArchivo;
	}

	public Boolean getActivarcodigoTipoArchivo() {
		return this.activarcodigoTipoArchivo;
	}

	public void setActivarcodigoTipoArchivo(Boolean activarcodigoTipoArchivo) {
		this.activarcodigoTipoArchivo= activarcodigoTipoArchivo;
	}

	public Border setResaltarnombreTipoArchivo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoArchivoBeanSwingJInternalFrame tipoarchivoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoarchivoBeanSwingJInternalFrame.jTtoolBarTipoArchivo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoArchivo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoArchivo() {
		return this.resaltarnombreTipoArchivo;
	}

	public void setResaltarnombreTipoArchivo(Border borderResaltar) {
		this.resaltarnombreTipoArchivo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoArchivo() {
		return this.mostrarnombreTipoArchivo;
	}

	public void setMostrarnombreTipoArchivo(Boolean mostrarnombreTipoArchivo) {
		this.mostrarnombreTipoArchivo= mostrarnombreTipoArchivo;
	}

	public Boolean getActivarnombreTipoArchivo() {
		return this.activarnombreTipoArchivo;
	}

	public void setActivarnombreTipoArchivo(Boolean activarnombreTipoArchivo) {
		this.activarnombreTipoArchivo= activarnombreTipoArchivo;
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
		
		
		this.setMostraridTipoArchivo(esInicial);
		this.setMostrarcodigoTipoArchivo(esInicial);
		this.setMostrarnombreTipoArchivo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoArchivoConstantesFunciones.ID)) {
				this.setMostraridTipoArchivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoArchivoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoArchivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoArchivoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoArchivo(esAsigna);
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
		
		
		this.setActivaridTipoArchivo(esInicial);
		this.setActivarcodigoTipoArchivo(esInicial);
		this.setActivarnombreTipoArchivo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoArchivoConstantesFunciones.ID)) {
				this.setActivaridTipoArchivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoArchivoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoArchivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoArchivoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoArchivo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoArchivoBeanSwingJInternalFrame tipoarchivoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoArchivo(esInicial);
		this.setResaltarcodigoTipoArchivo(esInicial);
		this.setResaltarnombreTipoArchivo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoArchivoConstantesFunciones.ID)) {
				this.setResaltaridTipoArchivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoArchivoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoArchivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoArchivoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoArchivo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoArchivoBeanSwingJInternalFrame tipoarchivoBeanSwingJInternalFrame*/)throws Exception {	
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