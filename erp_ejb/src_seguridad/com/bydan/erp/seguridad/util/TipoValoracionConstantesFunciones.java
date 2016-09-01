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


import com.bydan.erp.seguridad.util.TipoValoracionConstantesFunciones;
import com.bydan.erp.seguridad.util.TipoValoracionParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.TipoValoracionParameterGeneral;

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
final public class TipoValoracionConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoValoracion";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoValoracion"+TipoValoracionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoValoracionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoValoracionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoValoracionConstantesFunciones.SCHEMA+"_"+TipoValoracionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoValoracionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoValoracionConstantesFunciones.SCHEMA+"_"+TipoValoracionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoValoracionConstantesFunciones.SCHEMA+"_"+TipoValoracionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoValoracionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoValoracionConstantesFunciones.SCHEMA+"_"+TipoValoracionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoValoracionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoValoracionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoValoracionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoValoracionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoValoracionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoValoracionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoValoracionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoValoracionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoValoracionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoValoracionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Valoracions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Valoracion";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Valoracion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoValoracion";
	public static final String OBJECTNAME="tipovaloracion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="tipo_valoracion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipovaloracion from "+TipoValoracionConstantesFunciones.SPERSISTENCENAME+" tipovaloracion";
	public static String QUERYSELECTNATIVE="select "+TipoValoracionConstantesFunciones.SCHEMA+"."+TipoValoracionConstantesFunciones.TABLENAME+".id,"+TipoValoracionConstantesFunciones.SCHEMA+"."+TipoValoracionConstantesFunciones.TABLENAME+".version_row,"+TipoValoracionConstantesFunciones.SCHEMA+"."+TipoValoracionConstantesFunciones.TABLENAME+".codigo,"+TipoValoracionConstantesFunciones.SCHEMA+"."+TipoValoracionConstantesFunciones.TABLENAME+".nombre from "+TipoValoracionConstantesFunciones.SCHEMA+"."+TipoValoracionConstantesFunciones.TABLENAME;//+" as "+TipoValoracionConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoValoracionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoValoracionConstantesFunciones.CODIGO)) {sLabelColumna=TipoValoracionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoValoracionConstantesFunciones.NOMBRE)) {sLabelColumna=TipoValoracionConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoValoracionDescripcion(TipoValoracion tipovaloracion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipovaloracion !=null/* && tipovaloracion.getId()!=0*/) {
			sDescripcion=tipovaloracion.getcodigo();//tipovaloraciontipovaloracion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoValoracionDescripcionDetallado(TipoValoracion tipovaloracion) {
		String sDescripcion="";
			
		sDescripcion+=TipoValoracionConstantesFunciones.ID+"=";
		sDescripcion+=tipovaloracion.getId().toString()+",";
		sDescripcion+=TipoValoracionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipovaloracion.getVersionRow().toString()+",";
		sDescripcion+=TipoValoracionConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipovaloracion.getcodigo()+",";
		sDescripcion+=TipoValoracionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipovaloracion.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoValoracionDescripcion(TipoValoracion tipovaloracion,String sValor) throws Exception {			
		if(tipovaloracion !=null) {
			tipovaloracion.setcodigo(sValor);;//tipovaloraciontipovaloracion.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoValoracion(TipoValoracion tipovaloracion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipovaloracion.setcodigo(tipovaloracion.getcodigo().trim());
		tipovaloracion.setnombre(tipovaloracion.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoValoracions(List<TipoValoracion> tipovaloracions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoValoracion tipovaloracion: tipovaloracions) {
			tipovaloracion.setcodigo(tipovaloracion.getcodigo().trim());
			tipovaloracion.setnombre(tipovaloracion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoValoracion(TipoValoracion tipovaloracion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipovaloracion.getConCambioAuxiliar()) {
			tipovaloracion.setIsDeleted(tipovaloracion.getIsDeletedAuxiliar());	
			tipovaloracion.setIsNew(tipovaloracion.getIsNewAuxiliar());	
			tipovaloracion.setIsChanged(tipovaloracion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipovaloracion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipovaloracion.setIsDeletedAuxiliar(false);	
			tipovaloracion.setIsNewAuxiliar(false);	
			tipovaloracion.setIsChangedAuxiliar(false);
			
			tipovaloracion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoValoracions(List<TipoValoracion> tipovaloracions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoValoracion tipovaloracion : tipovaloracions) {
			if(conAsignarBase && tipovaloracion.getConCambioAuxiliar()) {
				tipovaloracion.setIsDeleted(tipovaloracion.getIsDeletedAuxiliar());	
				tipovaloracion.setIsNew(tipovaloracion.getIsNewAuxiliar());	
				tipovaloracion.setIsChanged(tipovaloracion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipovaloracion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipovaloracion.setIsDeletedAuxiliar(false);	
				tipovaloracion.setIsNewAuxiliar(false);	
				tipovaloracion.setIsChangedAuxiliar(false);
				
				tipovaloracion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoValoracion(TipoValoracion tipovaloracion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoValoracions(List<TipoValoracion> tipovaloracions,Boolean conEnteros) throws Exception  {
		
		for(TipoValoracion tipovaloracion: tipovaloracions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoValoracion(List<TipoValoracion> tipovaloracions,TipoValoracion tipovaloracionAux) throws Exception  {
		TipoValoracionConstantesFunciones.InicializarValoresTipoValoracion(tipovaloracionAux,true);
		
		for(TipoValoracion tipovaloracion: tipovaloracions) {
			if(tipovaloracion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoValoracion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoValoracionConstantesFunciones.getArrayColumnasGlobalesTipoValoracion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoValoracion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoValoracion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoValoracion> tipovaloracions,TipoValoracion tipovaloracion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoValoracion tipovaloracionAux: tipovaloracions) {
			if(tipovaloracionAux!=null && tipovaloracion!=null) {
				if((tipovaloracionAux.getId()==null && tipovaloracion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipovaloracionAux.getId()!=null && tipovaloracion.getId()!=null){
					if(tipovaloracionAux.getId().equals(tipovaloracion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoValoracion(List<TipoValoracion> tipovaloracions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoValoracion tipovaloracion: tipovaloracions) {			
			if(tipovaloracion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoValoracion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoValoracionConstantesFunciones.LABEL_ID, TipoValoracionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoValoracionConstantesFunciones.LABEL_VERSIONROW, TipoValoracionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoValoracionConstantesFunciones.LABEL_CODIGO, TipoValoracionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoValoracionConstantesFunciones.LABEL_NOMBRE, TipoValoracionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoValoracion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoValoracionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoValoracionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoValoracionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoValoracionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoValoracion() throws Exception  {
		return TipoValoracionConstantesFunciones.getTiposSeleccionarTipoValoracion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoValoracion(Boolean conFk) throws Exception  {
		return TipoValoracionConstantesFunciones.getTiposSeleccionarTipoValoracion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoValoracion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoValoracionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoValoracionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoValoracionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoValoracionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoValoracion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoValoracion(TipoValoracion tipovaloracionAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoValoracion(List<TipoValoracion> tipovaloracionsTemp) throws Exception {
		for(TipoValoracion tipovaloracionAux:tipovaloracionsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoValoracion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoValoracion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoValoracion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoValoracionConstantesFunciones.getClassesRelationshipsOfTipoValoracion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoValoracion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ReferenciaBancaria.class));
				classes.add(new Classe(LunaSistemaSolar.class));
				classes.add(new Classe(PlanetaSistemaSolar.class));
				classes.add(new Classe(ReferenciaComercial.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ReferenciaBancaria.class)) {
						classes.add(new Classe(ReferenciaBancaria.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(LunaSistemaSolar.class)) {
						classes.add(new Classe(LunaSistemaSolar.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PlanetaSistemaSolar.class)) {
						classes.add(new Classe(PlanetaSistemaSolar.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ReferenciaComercial.class)) {
						classes.add(new Classe(ReferenciaComercial.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoValoracion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoValoracionConstantesFunciones.getClassesRelationshipsFromStringsOfTipoValoracion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoValoracion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ReferenciaBancaria.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReferenciaBancaria.class)); continue;
					}

					if(LunaSistemaSolar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LunaSistemaSolar.class)); continue;
					}

					if(PlanetaSistemaSolar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PlanetaSistemaSolar.class)); continue;
					}

					if(ReferenciaComercial.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReferenciaComercial.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ReferenciaBancaria.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReferenciaBancaria.class)); continue;
					}

					if(LunaSistemaSolar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LunaSistemaSolar.class)); continue;
					}

					if(PlanetaSistemaSolar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PlanetaSistemaSolar.class)); continue;
					}

					if(ReferenciaComercial.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReferenciaComercial.class)); continue;
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
	public static void actualizarLista(TipoValoracion tipovaloracion,List<TipoValoracion> tipovaloracions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoValoracion tipovaloracionEncontrado=null;
			
			for(TipoValoracion tipovaloracionLocal:tipovaloracions) {
				if(tipovaloracionLocal.getId().equals(tipovaloracion.getId())) {
					tipovaloracionEncontrado=tipovaloracionLocal;
					
					tipovaloracionLocal.setIsChanged(tipovaloracion.getIsChanged());
					tipovaloracionLocal.setIsNew(tipovaloracion.getIsNew());
					tipovaloracionLocal.setIsDeleted(tipovaloracion.getIsDeleted());
					
					tipovaloracionLocal.setGeneralEntityOriginal(tipovaloracion.getGeneralEntityOriginal());
					
					tipovaloracionLocal.setId(tipovaloracion.getId());	
					tipovaloracionLocal.setVersionRow(tipovaloracion.getVersionRow());	
					tipovaloracionLocal.setcodigo(tipovaloracion.getcodigo());	
					tipovaloracionLocal.setnombre(tipovaloracion.getnombre());	
					
					
					tipovaloracionLocal.setReferenciaBancarias(tipovaloracion.getReferenciaBancarias());
					tipovaloracionLocal.setLunaSistemaSolars(tipovaloracion.getLunaSistemaSolars());
					tipovaloracionLocal.setPlanetaSistemaSolars(tipovaloracion.getPlanetaSistemaSolars());
					tipovaloracionLocal.setReferenciaComercials(tipovaloracion.getReferenciaComercials());
					
					existe=true;
					break;
				}
			}
			
			if(!tipovaloracion.getIsDeleted()) {
				if(!existe) {
					tipovaloracions.add(tipovaloracion);
				}
			} else {
				if(tipovaloracionEncontrado!=null && permiteQuitar)  {
					tipovaloracions.remove(tipovaloracionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoValoracion tipovaloracion,List<TipoValoracion> tipovaloracions) throws Exception {
		try	{			
			for(TipoValoracion tipovaloracionLocal:tipovaloracions) {
				if(tipovaloracionLocal.getId().equals(tipovaloracion.getId())) {
					tipovaloracionLocal.setIsSelected(tipovaloracion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoValoracion(List<TipoValoracion> tipovaloracionsAux) throws Exception {
		//this.tipovaloracionsAux=tipovaloracionsAux;
		
		for(TipoValoracion tipovaloracionAux:tipovaloracionsAux) {
			if(tipovaloracionAux.getIsChanged()) {
				tipovaloracionAux.setIsChanged(false);
			}		
			
			if(tipovaloracionAux.getIsNew()) {
				tipovaloracionAux.setIsNew(false);
			}	
			
			if(tipovaloracionAux.getIsDeleted()) {
				tipovaloracionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoValoracion(TipoValoracion tipovaloracionAux) throws Exception {
		//this.tipovaloracionAux=tipovaloracionAux;
		
			if(tipovaloracionAux.getIsChanged()) {
				tipovaloracionAux.setIsChanged(false);
			}		
			
			if(tipovaloracionAux.getIsNew()) {
				tipovaloracionAux.setIsNew(false);
			}	
			
			if(tipovaloracionAux.getIsDeleted()) {
				tipovaloracionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoValoracion tipovaloracionAsignar,TipoValoracion tipovaloracion) throws Exception {
		tipovaloracionAsignar.setId(tipovaloracion.getId());	
		tipovaloracionAsignar.setVersionRow(tipovaloracion.getVersionRow());	
		tipovaloracionAsignar.setcodigo(tipovaloracion.getcodigo());	
		tipovaloracionAsignar.setnombre(tipovaloracion.getnombre());	
	}
	
	public static void inicializarTipoValoracion(TipoValoracion tipovaloracion) throws Exception {
		try {
				tipovaloracion.setId(0L);	
					
				tipovaloracion.setcodigo("");	
				tipovaloracion.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoValoracion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoValoracionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoValoracionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoValoracion(String sTipo,Row row,Workbook workbook,TipoValoracion tipovaloracion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipovaloracion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipovaloracion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoValoracion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoValoracion() {
		return this.sFinalQueryTipoValoracion;
	}
	
	public void setsFinalQueryTipoValoracion(String sFinalQueryTipoValoracion) {
		this.sFinalQueryTipoValoracion= sFinalQueryTipoValoracion;
	}
	
	public Border resaltarSeleccionarTipoValoracion=null;
	
	public Border setResaltarSeleccionarTipoValoracion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoValoracionBeanSwingJInternalFrame tipovaloracionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipovaloracionBeanSwingJInternalFrame.jTtoolBarTipoValoracion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoValoracion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoValoracion() {
		return this.resaltarSeleccionarTipoValoracion;
	}
	
	public void setResaltarSeleccionarTipoValoracion(Border borderResaltarSeleccionarTipoValoracion) {
		this.resaltarSeleccionarTipoValoracion= borderResaltarSeleccionarTipoValoracion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoValoracion=null;
	public Boolean mostraridTipoValoracion=true;
	public Boolean activaridTipoValoracion=true;

	public Border resaltarcodigoTipoValoracion=null;
	public Boolean mostrarcodigoTipoValoracion=true;
	public Boolean activarcodigoTipoValoracion=true;

	public Border resaltarnombreTipoValoracion=null;
	public Boolean mostrarnombreTipoValoracion=true;
	public Boolean activarnombreTipoValoracion=true;

	
	

	public Border setResaltaridTipoValoracion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoValoracionBeanSwingJInternalFrame tipovaloracionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipovaloracionBeanSwingJInternalFrame.jTtoolBarTipoValoracion.setBorder(borderResaltar);
		
		this.resaltaridTipoValoracion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoValoracion() {
		return this.resaltaridTipoValoracion;
	}

	public void setResaltaridTipoValoracion(Border borderResaltar) {
		this.resaltaridTipoValoracion= borderResaltar;
	}

	public Boolean getMostraridTipoValoracion() {
		return this.mostraridTipoValoracion;
	}

	public void setMostraridTipoValoracion(Boolean mostraridTipoValoracion) {
		this.mostraridTipoValoracion= mostraridTipoValoracion;
	}

	public Boolean getActivaridTipoValoracion() {
		return this.activaridTipoValoracion;
	}

	public void setActivaridTipoValoracion(Boolean activaridTipoValoracion) {
		this.activaridTipoValoracion= activaridTipoValoracion;
	}

	public Border setResaltarcodigoTipoValoracion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoValoracionBeanSwingJInternalFrame tipovaloracionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipovaloracionBeanSwingJInternalFrame.jTtoolBarTipoValoracion.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoValoracion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoValoracion() {
		return this.resaltarcodigoTipoValoracion;
	}

	public void setResaltarcodigoTipoValoracion(Border borderResaltar) {
		this.resaltarcodigoTipoValoracion= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoValoracion() {
		return this.mostrarcodigoTipoValoracion;
	}

	public void setMostrarcodigoTipoValoracion(Boolean mostrarcodigoTipoValoracion) {
		this.mostrarcodigoTipoValoracion= mostrarcodigoTipoValoracion;
	}

	public Boolean getActivarcodigoTipoValoracion() {
		return this.activarcodigoTipoValoracion;
	}

	public void setActivarcodigoTipoValoracion(Boolean activarcodigoTipoValoracion) {
		this.activarcodigoTipoValoracion= activarcodigoTipoValoracion;
	}

	public Border setResaltarnombreTipoValoracion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoValoracionBeanSwingJInternalFrame tipovaloracionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipovaloracionBeanSwingJInternalFrame.jTtoolBarTipoValoracion.setBorder(borderResaltar);
		
		this.resaltarnombreTipoValoracion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoValoracion() {
		return this.resaltarnombreTipoValoracion;
	}

	public void setResaltarnombreTipoValoracion(Border borderResaltar) {
		this.resaltarnombreTipoValoracion= borderResaltar;
	}

	public Boolean getMostrarnombreTipoValoracion() {
		return this.mostrarnombreTipoValoracion;
	}

	public void setMostrarnombreTipoValoracion(Boolean mostrarnombreTipoValoracion) {
		this.mostrarnombreTipoValoracion= mostrarnombreTipoValoracion;
	}

	public Boolean getActivarnombreTipoValoracion() {
		return this.activarnombreTipoValoracion;
	}

	public void setActivarnombreTipoValoracion(Boolean activarnombreTipoValoracion) {
		this.activarnombreTipoValoracion= activarnombreTipoValoracion;
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
		
		
		this.setMostraridTipoValoracion(esInicial);
		this.setMostrarcodigoTipoValoracion(esInicial);
		this.setMostrarnombreTipoValoracion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoValoracionConstantesFunciones.ID)) {
				this.setMostraridTipoValoracion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoValoracionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoValoracion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoValoracionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoValoracion(esAsigna);
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
		
		
		this.setActivaridTipoValoracion(esInicial);
		this.setActivarcodigoTipoValoracion(esInicial);
		this.setActivarnombreTipoValoracion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoValoracionConstantesFunciones.ID)) {
				this.setActivaridTipoValoracion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoValoracionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoValoracion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoValoracionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoValoracion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoValoracionBeanSwingJInternalFrame tipovaloracionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoValoracion(esInicial);
		this.setResaltarcodigoTipoValoracion(esInicial);
		this.setResaltarnombreTipoValoracion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoValoracionConstantesFunciones.ID)) {
				this.setResaltaridTipoValoracion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoValoracionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoValoracion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoValoracionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoValoracion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarReferenciaBancariaTipoValoracion=null;

	public Border getResaltarReferenciaBancariaTipoValoracion() {
		return this.resaltarReferenciaBancariaTipoValoracion;
	}

	public void setResaltarReferenciaBancariaTipoValoracion(Border borderResaltarReferenciaBancaria) {
		if(borderResaltarReferenciaBancaria!=null) {
			this.resaltarReferenciaBancariaTipoValoracion= borderResaltarReferenciaBancaria;
		}
	}

	public Border setResaltarReferenciaBancariaTipoValoracion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoValoracionBeanSwingJInternalFrame tipovaloracionBeanSwingJInternalFrame*/) {
		Border borderResaltarReferenciaBancaria=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipovaloracionBeanSwingJInternalFrame.jTtoolBarTipoValoracion.setBorder(borderResaltarReferenciaBancaria);
			
		this.resaltarReferenciaBancariaTipoValoracion= borderResaltarReferenciaBancaria;

		 return borderResaltarReferenciaBancaria;
	}



	public Boolean mostrarReferenciaBancariaTipoValoracion=true;

	public Boolean getMostrarReferenciaBancariaTipoValoracion() {
		return this.mostrarReferenciaBancariaTipoValoracion;
	}

	public void setMostrarReferenciaBancariaTipoValoracion(Boolean visibilidadResaltarReferenciaBancaria) {
		this.mostrarReferenciaBancariaTipoValoracion= visibilidadResaltarReferenciaBancaria;
	}



	public Boolean activarReferenciaBancariaTipoValoracion=true;

	public Boolean gethabilitarResaltarReferenciaBancariaTipoValoracion() {
		return this.activarReferenciaBancariaTipoValoracion;
	}

	public void setActivarReferenciaBancariaTipoValoracion(Boolean habilitarResaltarReferenciaBancaria) {
		this.activarReferenciaBancariaTipoValoracion= habilitarResaltarReferenciaBancaria;
	}


	public Border resaltarLunaSistemaSolarTipoValoracion=null;

	public Border getResaltarLunaSistemaSolarTipoValoracion() {
		return this.resaltarLunaSistemaSolarTipoValoracion;
	}

	public void setResaltarLunaSistemaSolarTipoValoracion(Border borderResaltarLunaSistemaSolar) {
		if(borderResaltarLunaSistemaSolar!=null) {
			this.resaltarLunaSistemaSolarTipoValoracion= borderResaltarLunaSistemaSolar;
		}
	}

	public Border setResaltarLunaSistemaSolarTipoValoracion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoValoracionBeanSwingJInternalFrame tipovaloracionBeanSwingJInternalFrame*/) {
		Border borderResaltarLunaSistemaSolar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipovaloracionBeanSwingJInternalFrame.jTtoolBarTipoValoracion.setBorder(borderResaltarLunaSistemaSolar);
			
		this.resaltarLunaSistemaSolarTipoValoracion= borderResaltarLunaSistemaSolar;

		 return borderResaltarLunaSistemaSolar;
	}



	public Boolean mostrarLunaSistemaSolarTipoValoracion=true;

	public Boolean getMostrarLunaSistemaSolarTipoValoracion() {
		return this.mostrarLunaSistemaSolarTipoValoracion;
	}

	public void setMostrarLunaSistemaSolarTipoValoracion(Boolean visibilidadResaltarLunaSistemaSolar) {
		this.mostrarLunaSistemaSolarTipoValoracion= visibilidadResaltarLunaSistemaSolar;
	}



	public Boolean activarLunaSistemaSolarTipoValoracion=true;

	public Boolean gethabilitarResaltarLunaSistemaSolarTipoValoracion() {
		return this.activarLunaSistemaSolarTipoValoracion;
	}

	public void setActivarLunaSistemaSolarTipoValoracion(Boolean habilitarResaltarLunaSistemaSolar) {
		this.activarLunaSistemaSolarTipoValoracion= habilitarResaltarLunaSistemaSolar;
	}


	public Border resaltarPlanetaSistemaSolarTipoValoracion=null;

	public Border getResaltarPlanetaSistemaSolarTipoValoracion() {
		return this.resaltarPlanetaSistemaSolarTipoValoracion;
	}

	public void setResaltarPlanetaSistemaSolarTipoValoracion(Border borderResaltarPlanetaSistemaSolar) {
		if(borderResaltarPlanetaSistemaSolar!=null) {
			this.resaltarPlanetaSistemaSolarTipoValoracion= borderResaltarPlanetaSistemaSolar;
		}
	}

	public Border setResaltarPlanetaSistemaSolarTipoValoracion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoValoracionBeanSwingJInternalFrame tipovaloracionBeanSwingJInternalFrame*/) {
		Border borderResaltarPlanetaSistemaSolar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipovaloracionBeanSwingJInternalFrame.jTtoolBarTipoValoracion.setBorder(borderResaltarPlanetaSistemaSolar);
			
		this.resaltarPlanetaSistemaSolarTipoValoracion= borderResaltarPlanetaSistemaSolar;

		 return borderResaltarPlanetaSistemaSolar;
	}



	public Boolean mostrarPlanetaSistemaSolarTipoValoracion=true;

	public Boolean getMostrarPlanetaSistemaSolarTipoValoracion() {
		return this.mostrarPlanetaSistemaSolarTipoValoracion;
	}

	public void setMostrarPlanetaSistemaSolarTipoValoracion(Boolean visibilidadResaltarPlanetaSistemaSolar) {
		this.mostrarPlanetaSistemaSolarTipoValoracion= visibilidadResaltarPlanetaSistemaSolar;
	}



	public Boolean activarPlanetaSistemaSolarTipoValoracion=true;

	public Boolean gethabilitarResaltarPlanetaSistemaSolarTipoValoracion() {
		return this.activarPlanetaSistemaSolarTipoValoracion;
	}

	public void setActivarPlanetaSistemaSolarTipoValoracion(Boolean habilitarResaltarPlanetaSistemaSolar) {
		this.activarPlanetaSistemaSolarTipoValoracion= habilitarResaltarPlanetaSistemaSolar;
	}


	public Border resaltarReferenciaComercialTipoValoracion=null;

	public Border getResaltarReferenciaComercialTipoValoracion() {
		return this.resaltarReferenciaComercialTipoValoracion;
	}

	public void setResaltarReferenciaComercialTipoValoracion(Border borderResaltarReferenciaComercial) {
		if(borderResaltarReferenciaComercial!=null) {
			this.resaltarReferenciaComercialTipoValoracion= borderResaltarReferenciaComercial;
		}
	}

	public Border setResaltarReferenciaComercialTipoValoracion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoValoracionBeanSwingJInternalFrame tipovaloracionBeanSwingJInternalFrame*/) {
		Border borderResaltarReferenciaComercial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipovaloracionBeanSwingJInternalFrame.jTtoolBarTipoValoracion.setBorder(borderResaltarReferenciaComercial);
			
		this.resaltarReferenciaComercialTipoValoracion= borderResaltarReferenciaComercial;

		 return borderResaltarReferenciaComercial;
	}



	public Boolean mostrarReferenciaComercialTipoValoracion=true;

	public Boolean getMostrarReferenciaComercialTipoValoracion() {
		return this.mostrarReferenciaComercialTipoValoracion;
	}

	public void setMostrarReferenciaComercialTipoValoracion(Boolean visibilidadResaltarReferenciaComercial) {
		this.mostrarReferenciaComercialTipoValoracion= visibilidadResaltarReferenciaComercial;
	}



	public Boolean activarReferenciaComercialTipoValoracion=true;

	public Boolean gethabilitarResaltarReferenciaComercialTipoValoracion() {
		return this.activarReferenciaComercialTipoValoracion;
	}

	public void setActivarReferenciaComercialTipoValoracion(Boolean habilitarResaltarReferenciaComercial) {
		this.activarReferenciaComercialTipoValoracion= habilitarResaltarReferenciaComercial;
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

		this.setMostrarReferenciaBancariaTipoValoracion(esInicial);
		this.setMostrarLunaSistemaSolarTipoValoracion(esInicial);
		this.setMostrarPlanetaSistemaSolarTipoValoracion(esInicial);
		this.setMostrarReferenciaComercialTipoValoracion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ReferenciaBancaria.class)) {
				this.setMostrarReferenciaBancariaTipoValoracion(esAsigna);
				continue;
			}

			if(clase.clas.equals(LunaSistemaSolar.class)) {
				this.setMostrarLunaSistemaSolarTipoValoracion(esAsigna);
				continue;
			}

			if(clase.clas.equals(PlanetaSistemaSolar.class)) {
				this.setMostrarPlanetaSistemaSolarTipoValoracion(esAsigna);
				continue;
			}

			if(clase.clas.equals(ReferenciaComercial.class)) {
				this.setMostrarReferenciaComercialTipoValoracion(esAsigna);
				continue;
			}
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

		this.setActivarReferenciaBancariaTipoValoracion(esInicial);
		this.setActivarLunaSistemaSolarTipoValoracion(esInicial);
		this.setActivarPlanetaSistemaSolarTipoValoracion(esInicial);
		this.setActivarReferenciaComercialTipoValoracion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ReferenciaBancaria.class)) {
				this.setActivarReferenciaBancariaTipoValoracion(esAsigna);
				continue;
			}

			if(clase.clas.equals(LunaSistemaSolar.class)) {
				this.setActivarLunaSistemaSolarTipoValoracion(esAsigna);
				continue;
			}

			if(clase.clas.equals(PlanetaSistemaSolar.class)) {
				this.setActivarPlanetaSistemaSolarTipoValoracion(esAsigna);
				continue;
			}

			if(clase.clas.equals(ReferenciaComercial.class)) {
				this.setActivarReferenciaComercialTipoValoracion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoValoracionBeanSwingJInternalFrame tipovaloracionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarReferenciaBancariaTipoValoracion(esInicial);
		this.setResaltarLunaSistemaSolarTipoValoracion(esInicial);
		this.setResaltarPlanetaSistemaSolarTipoValoracion(esInicial);
		this.setResaltarReferenciaComercialTipoValoracion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ReferenciaBancaria.class)) {
				this.setResaltarReferenciaBancariaTipoValoracion(esAsigna);
				continue;
			}

			if(clase.clas.equals(LunaSistemaSolar.class)) {
				this.setResaltarLunaSistemaSolarTipoValoracion(esAsigna);
				continue;
			}

			if(clase.clas.equals(PlanetaSistemaSolar.class)) {
				this.setResaltarPlanetaSistemaSolarTipoValoracion(esAsigna);
				continue;
			}

			if(clase.clas.equals(ReferenciaComercial.class)) {
				this.setResaltarReferenciaComercialTipoValoracion(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}