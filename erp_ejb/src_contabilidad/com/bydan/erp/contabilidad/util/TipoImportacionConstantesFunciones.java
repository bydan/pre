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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.TipoImportacionConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoImportacionParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoImportacionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoImportacionConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoImportacion";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoImportacion"+TipoImportacionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoImportacionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoImportacionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoImportacionConstantesFunciones.SCHEMA+"_"+TipoImportacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoImportacionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoImportacionConstantesFunciones.SCHEMA+"_"+TipoImportacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoImportacionConstantesFunciones.SCHEMA+"_"+TipoImportacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoImportacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoImportacionConstantesFunciones.SCHEMA+"_"+TipoImportacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoImportacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoImportacionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoImportacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoImportacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoImportacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoImportacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoImportacionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoImportacionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoImportacionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoImportacionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Importacions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Importacion";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Importacion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoImportacion";
	public static final String OBJECTNAME="tipoimportacion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_importacion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoimportacion from "+TipoImportacionConstantesFunciones.SPERSISTENCENAME+" tipoimportacion";
	public static String QUERYSELECTNATIVE="select "+TipoImportacionConstantesFunciones.SCHEMA+"."+TipoImportacionConstantesFunciones.TABLENAME+".id,"+TipoImportacionConstantesFunciones.SCHEMA+"."+TipoImportacionConstantesFunciones.TABLENAME+".version_row,"+TipoImportacionConstantesFunciones.SCHEMA+"."+TipoImportacionConstantesFunciones.TABLENAME+".codigo,"+TipoImportacionConstantesFunciones.SCHEMA+"."+TipoImportacionConstantesFunciones.TABLENAME+".nombre from "+TipoImportacionConstantesFunciones.SCHEMA+"."+TipoImportacionConstantesFunciones.TABLENAME;//+" as "+TipoImportacionConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoImportacionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoImportacionConstantesFunciones.CODIGO)) {sLabelColumna=TipoImportacionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoImportacionConstantesFunciones.NOMBRE)) {sLabelColumna=TipoImportacionConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoImportacionDescripcion(TipoImportacion tipoimportacion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoimportacion !=null/* && tipoimportacion.getId()!=0*/) {
			sDescripcion=tipoimportacion.getcodigo();//tipoimportaciontipoimportacion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoImportacionDescripcionDetallado(TipoImportacion tipoimportacion) {
		String sDescripcion="";
			
		sDescripcion+=TipoImportacionConstantesFunciones.ID+"=";
		sDescripcion+=tipoimportacion.getId().toString()+",";
		sDescripcion+=TipoImportacionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoimportacion.getVersionRow().toString()+",";
		sDescripcion+=TipoImportacionConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoimportacion.getcodigo()+",";
		sDescripcion+=TipoImportacionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoimportacion.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoImportacionDescripcion(TipoImportacion tipoimportacion,String sValor) throws Exception {			
		if(tipoimportacion !=null) {
			tipoimportacion.setcodigo(sValor);;//tipoimportaciontipoimportacion.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoImportacion(TipoImportacion tipoimportacion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoimportacion.setcodigo(tipoimportacion.getcodigo().trim());
		tipoimportacion.setnombre(tipoimportacion.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoImportacions(List<TipoImportacion> tipoimportacions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoImportacion tipoimportacion: tipoimportacions) {
			tipoimportacion.setcodigo(tipoimportacion.getcodigo().trim());
			tipoimportacion.setnombre(tipoimportacion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoImportacion(TipoImportacion tipoimportacion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoimportacion.getConCambioAuxiliar()) {
			tipoimportacion.setIsDeleted(tipoimportacion.getIsDeletedAuxiliar());	
			tipoimportacion.setIsNew(tipoimportacion.getIsNewAuxiliar());	
			tipoimportacion.setIsChanged(tipoimportacion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoimportacion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoimportacion.setIsDeletedAuxiliar(false);	
			tipoimportacion.setIsNewAuxiliar(false);	
			tipoimportacion.setIsChangedAuxiliar(false);
			
			tipoimportacion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoImportacions(List<TipoImportacion> tipoimportacions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoImportacion tipoimportacion : tipoimportacions) {
			if(conAsignarBase && tipoimportacion.getConCambioAuxiliar()) {
				tipoimportacion.setIsDeleted(tipoimportacion.getIsDeletedAuxiliar());	
				tipoimportacion.setIsNew(tipoimportacion.getIsNewAuxiliar());	
				tipoimportacion.setIsChanged(tipoimportacion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoimportacion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoimportacion.setIsDeletedAuxiliar(false);	
				tipoimportacion.setIsNewAuxiliar(false);	
				tipoimportacion.setIsChangedAuxiliar(false);
				
				tipoimportacion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoImportacion(TipoImportacion tipoimportacion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoImportacions(List<TipoImportacion> tipoimportacions,Boolean conEnteros) throws Exception  {
		
		for(TipoImportacion tipoimportacion: tipoimportacions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoImportacion(List<TipoImportacion> tipoimportacions,TipoImportacion tipoimportacionAux) throws Exception  {
		TipoImportacionConstantesFunciones.InicializarValoresTipoImportacion(tipoimportacionAux,true);
		
		for(TipoImportacion tipoimportacion: tipoimportacions) {
			if(tipoimportacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoImportacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoImportacionConstantesFunciones.getArrayColumnasGlobalesTipoImportacion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoImportacion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoImportacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoImportacion> tipoimportacions,TipoImportacion tipoimportacion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoImportacion tipoimportacionAux: tipoimportacions) {
			if(tipoimportacionAux!=null && tipoimportacion!=null) {
				if((tipoimportacionAux.getId()==null && tipoimportacion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoimportacionAux.getId()!=null && tipoimportacion.getId()!=null){
					if(tipoimportacionAux.getId().equals(tipoimportacion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoImportacion(List<TipoImportacion> tipoimportacions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoImportacion tipoimportacion: tipoimportacions) {			
			if(tipoimportacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoImportacion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoImportacionConstantesFunciones.LABEL_ID, TipoImportacionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoImportacionConstantesFunciones.LABEL_VERSIONROW, TipoImportacionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoImportacionConstantesFunciones.LABEL_CODIGO, TipoImportacionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoImportacionConstantesFunciones.LABEL_NOMBRE, TipoImportacionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoImportacion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoImportacionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoImportacionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoImportacionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoImportacionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoImportacion() throws Exception  {
		return TipoImportacionConstantesFunciones.getTiposSeleccionarTipoImportacion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoImportacion(Boolean conFk) throws Exception  {
		return TipoImportacionConstantesFunciones.getTiposSeleccionarTipoImportacion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoImportacion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoImportacionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoImportacionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoImportacionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoImportacionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoImportacion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoImportacion(TipoImportacion tipoimportacionAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoImportacion(List<TipoImportacion> tipoimportacionsTemp) throws Exception {
		for(TipoImportacion tipoimportacionAux:tipoimportacionsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoImportacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoImportacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoImportacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoImportacionConstantesFunciones.getClassesRelationshipsOfTipoImportacion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoImportacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ImportarExportar.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ImportarExportar.class)) {
						classes.add(new Classe(ImportarExportar.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoImportacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoImportacionConstantesFunciones.getClassesRelationshipsFromStringsOfTipoImportacion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoImportacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ImportarExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImportarExportar.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ImportarExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImportarExportar.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(TipoImportacion tipoimportacion,List<TipoImportacion> tipoimportacions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoImportacion tipoimportacionEncontrado=null;
			
			for(TipoImportacion tipoimportacionLocal:tipoimportacions) {
				if(tipoimportacionLocal.getId().equals(tipoimportacion.getId())) {
					tipoimportacionEncontrado=tipoimportacionLocal;
					
					tipoimportacionLocal.setIsChanged(tipoimportacion.getIsChanged());
					tipoimportacionLocal.setIsNew(tipoimportacion.getIsNew());
					tipoimportacionLocal.setIsDeleted(tipoimportacion.getIsDeleted());
					
					tipoimportacionLocal.setGeneralEntityOriginal(tipoimportacion.getGeneralEntityOriginal());
					
					tipoimportacionLocal.setId(tipoimportacion.getId());	
					tipoimportacionLocal.setVersionRow(tipoimportacion.getVersionRow());	
					tipoimportacionLocal.setcodigo(tipoimportacion.getcodigo());	
					tipoimportacionLocal.setnombre(tipoimportacion.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoimportacion.getIsDeleted()) {
				if(!existe) {
					tipoimportacions.add(tipoimportacion);
				}
			} else {
				if(tipoimportacionEncontrado!=null && permiteQuitar)  {
					tipoimportacions.remove(tipoimportacionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoImportacion tipoimportacion,List<TipoImportacion> tipoimportacions) throws Exception {
		try	{			
			for(TipoImportacion tipoimportacionLocal:tipoimportacions) {
				if(tipoimportacionLocal.getId().equals(tipoimportacion.getId())) {
					tipoimportacionLocal.setIsSelected(tipoimportacion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoImportacion(List<TipoImportacion> tipoimportacionsAux) throws Exception {
		//this.tipoimportacionsAux=tipoimportacionsAux;
		
		for(TipoImportacion tipoimportacionAux:tipoimportacionsAux) {
			if(tipoimportacionAux.getIsChanged()) {
				tipoimportacionAux.setIsChanged(false);
			}		
			
			if(tipoimportacionAux.getIsNew()) {
				tipoimportacionAux.setIsNew(false);
			}	
			
			if(tipoimportacionAux.getIsDeleted()) {
				tipoimportacionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoImportacion(TipoImportacion tipoimportacionAux) throws Exception {
		//this.tipoimportacionAux=tipoimportacionAux;
		
			if(tipoimportacionAux.getIsChanged()) {
				tipoimportacionAux.setIsChanged(false);
			}		
			
			if(tipoimportacionAux.getIsNew()) {
				tipoimportacionAux.setIsNew(false);
			}	
			
			if(tipoimportacionAux.getIsDeleted()) {
				tipoimportacionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoImportacion tipoimportacionAsignar,TipoImportacion tipoimportacion) throws Exception {
		tipoimportacionAsignar.setId(tipoimportacion.getId());	
		tipoimportacionAsignar.setVersionRow(tipoimportacion.getVersionRow());	
		tipoimportacionAsignar.setcodigo(tipoimportacion.getcodigo());	
		tipoimportacionAsignar.setnombre(tipoimportacion.getnombre());	
	}
	
	public static void inicializarTipoImportacion(TipoImportacion tipoimportacion) throws Exception {
		try {
				tipoimportacion.setId(0L);	
					
				tipoimportacion.setcodigo("");	
				tipoimportacion.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoImportacion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoImportacionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoImportacionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoImportacion(String sTipo,Row row,Workbook workbook,TipoImportacion tipoimportacion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoimportacion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoimportacion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoImportacion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoImportacion() {
		return this.sFinalQueryTipoImportacion;
	}
	
	public void setsFinalQueryTipoImportacion(String sFinalQueryTipoImportacion) {
		this.sFinalQueryTipoImportacion= sFinalQueryTipoImportacion;
	}
	
	public Border resaltarSeleccionarTipoImportacion=null;
	
	public Border setResaltarSeleccionarTipoImportacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoImportacionBeanSwingJInternalFrame tipoimportacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoimportacionBeanSwingJInternalFrame.jTtoolBarTipoImportacion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoImportacion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoImportacion() {
		return this.resaltarSeleccionarTipoImportacion;
	}
	
	public void setResaltarSeleccionarTipoImportacion(Border borderResaltarSeleccionarTipoImportacion) {
		this.resaltarSeleccionarTipoImportacion= borderResaltarSeleccionarTipoImportacion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoImportacion=null;
	public Boolean mostraridTipoImportacion=true;
	public Boolean activaridTipoImportacion=true;

	public Border resaltarcodigoTipoImportacion=null;
	public Boolean mostrarcodigoTipoImportacion=true;
	public Boolean activarcodigoTipoImportacion=true;

	public Border resaltarnombreTipoImportacion=null;
	public Boolean mostrarnombreTipoImportacion=true;
	public Boolean activarnombreTipoImportacion=true;

	
	

	public Border setResaltaridTipoImportacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoImportacionBeanSwingJInternalFrame tipoimportacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoimportacionBeanSwingJInternalFrame.jTtoolBarTipoImportacion.setBorder(borderResaltar);
		
		this.resaltaridTipoImportacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoImportacion() {
		return this.resaltaridTipoImportacion;
	}

	public void setResaltaridTipoImportacion(Border borderResaltar) {
		this.resaltaridTipoImportacion= borderResaltar;
	}

	public Boolean getMostraridTipoImportacion() {
		return this.mostraridTipoImportacion;
	}

	public void setMostraridTipoImportacion(Boolean mostraridTipoImportacion) {
		this.mostraridTipoImportacion= mostraridTipoImportacion;
	}

	public Boolean getActivaridTipoImportacion() {
		return this.activaridTipoImportacion;
	}

	public void setActivaridTipoImportacion(Boolean activaridTipoImportacion) {
		this.activaridTipoImportacion= activaridTipoImportacion;
	}

	public Border setResaltarcodigoTipoImportacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoImportacionBeanSwingJInternalFrame tipoimportacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoimportacionBeanSwingJInternalFrame.jTtoolBarTipoImportacion.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoImportacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoImportacion() {
		return this.resaltarcodigoTipoImportacion;
	}

	public void setResaltarcodigoTipoImportacion(Border borderResaltar) {
		this.resaltarcodigoTipoImportacion= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoImportacion() {
		return this.mostrarcodigoTipoImportacion;
	}

	public void setMostrarcodigoTipoImportacion(Boolean mostrarcodigoTipoImportacion) {
		this.mostrarcodigoTipoImportacion= mostrarcodigoTipoImportacion;
	}

	public Boolean getActivarcodigoTipoImportacion() {
		return this.activarcodigoTipoImportacion;
	}

	public void setActivarcodigoTipoImportacion(Boolean activarcodigoTipoImportacion) {
		this.activarcodigoTipoImportacion= activarcodigoTipoImportacion;
	}

	public Border setResaltarnombreTipoImportacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoImportacionBeanSwingJInternalFrame tipoimportacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoimportacionBeanSwingJInternalFrame.jTtoolBarTipoImportacion.setBorder(borderResaltar);
		
		this.resaltarnombreTipoImportacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoImportacion() {
		return this.resaltarnombreTipoImportacion;
	}

	public void setResaltarnombreTipoImportacion(Border borderResaltar) {
		this.resaltarnombreTipoImportacion= borderResaltar;
	}

	public Boolean getMostrarnombreTipoImportacion() {
		return this.mostrarnombreTipoImportacion;
	}

	public void setMostrarnombreTipoImportacion(Boolean mostrarnombreTipoImportacion) {
		this.mostrarnombreTipoImportacion= mostrarnombreTipoImportacion;
	}

	public Boolean getActivarnombreTipoImportacion() {
		return this.activarnombreTipoImportacion;
	}

	public void setActivarnombreTipoImportacion(Boolean activarnombreTipoImportacion) {
		this.activarnombreTipoImportacion= activarnombreTipoImportacion;
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
		
		
		this.setMostraridTipoImportacion(esInicial);
		this.setMostrarcodigoTipoImportacion(esInicial);
		this.setMostrarnombreTipoImportacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoImportacionConstantesFunciones.ID)) {
				this.setMostraridTipoImportacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoImportacionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoImportacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoImportacionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoImportacion(esAsigna);
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
		
		
		this.setActivaridTipoImportacion(esInicial);
		this.setActivarcodigoTipoImportacion(esInicial);
		this.setActivarnombreTipoImportacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoImportacionConstantesFunciones.ID)) {
				this.setActivaridTipoImportacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoImportacionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoImportacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoImportacionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoImportacion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoImportacionBeanSwingJInternalFrame tipoimportacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoImportacion(esInicial);
		this.setResaltarcodigoTipoImportacion(esInicial);
		this.setResaltarnombreTipoImportacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoImportacionConstantesFunciones.ID)) {
				this.setResaltaridTipoImportacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoImportacionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoImportacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoImportacionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoImportacion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoImportacionBeanSwingJInternalFrame tipoimportacionBeanSwingJInternalFrame*/)throws Exception {	
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