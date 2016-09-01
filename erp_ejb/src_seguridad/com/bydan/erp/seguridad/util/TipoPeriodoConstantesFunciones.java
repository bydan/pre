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


import com.bydan.erp.seguridad.util.TipoPeriodoConstantesFunciones;
import com.bydan.erp.seguridad.util.TipoPeriodoParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.TipoPeriodoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;



import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoPeriodoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoPeriodo";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoPeriodo"+TipoPeriodoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoPeriodoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoPeriodoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoPeriodoConstantesFunciones.SCHEMA+"_"+TipoPeriodoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoPeriodoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoPeriodoConstantesFunciones.SCHEMA+"_"+TipoPeriodoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoPeriodoConstantesFunciones.SCHEMA+"_"+TipoPeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoPeriodoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoPeriodoConstantesFunciones.SCHEMA+"_"+TipoPeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPeriodoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPeriodoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoPeriodoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoPeriodoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoPeriodoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoPeriodoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Periodos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Periodo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Periodo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoPeriodo";
	public static final String OBJECTNAME="tipoperiodo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="tipo_periodo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoperiodo from "+TipoPeriodoConstantesFunciones.SPERSISTENCENAME+" tipoperiodo";
	public static String QUERYSELECTNATIVE="select "+TipoPeriodoConstantesFunciones.SCHEMA+"."+TipoPeriodoConstantesFunciones.TABLENAME+".id,"+TipoPeriodoConstantesFunciones.SCHEMA+"."+TipoPeriodoConstantesFunciones.TABLENAME+".version_row,"+TipoPeriodoConstantesFunciones.SCHEMA+"."+TipoPeriodoConstantesFunciones.TABLENAME+".codigo,"+TipoPeriodoConstantesFunciones.SCHEMA+"."+TipoPeriodoConstantesFunciones.TABLENAME+".nombre from "+TipoPeriodoConstantesFunciones.SCHEMA+"."+TipoPeriodoConstantesFunciones.TABLENAME;//+" as "+TipoPeriodoConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoPeriodoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoPeriodoConstantesFunciones.CODIGO)) {sLabelColumna=TipoPeriodoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoPeriodoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoPeriodoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoPeriodoDescripcion(TipoPeriodo tipoperiodo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoperiodo !=null/* && tipoperiodo.getId()!=0*/) {
			sDescripcion=tipoperiodo.getcodigo();//tipoperiodotipoperiodo.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoPeriodoDescripcionDetallado(TipoPeriodo tipoperiodo) {
		String sDescripcion="";
			
		sDescripcion+=TipoPeriodoConstantesFunciones.ID+"=";
		sDescripcion+=tipoperiodo.getId().toString()+",";
		sDescripcion+=TipoPeriodoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoperiodo.getVersionRow().toString()+",";
		sDescripcion+=TipoPeriodoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoperiodo.getcodigo()+",";
		sDescripcion+=TipoPeriodoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoperiodo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoPeriodoDescripcion(TipoPeriodo tipoperiodo,String sValor) throws Exception {			
		if(tipoperiodo !=null) {
			tipoperiodo.setcodigo(sValor);;//tipoperiodotipoperiodo.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoPeriodo(TipoPeriodo tipoperiodo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoperiodo.setcodigo(tipoperiodo.getcodigo().trim());
		tipoperiodo.setnombre(tipoperiodo.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoPeriodos(List<TipoPeriodo> tipoperiodos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoPeriodo tipoperiodo: tipoperiodos) {
			tipoperiodo.setcodigo(tipoperiodo.getcodigo().trim());
			tipoperiodo.setnombre(tipoperiodo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPeriodo(TipoPeriodo tipoperiodo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoperiodo.getConCambioAuxiliar()) {
			tipoperiodo.setIsDeleted(tipoperiodo.getIsDeletedAuxiliar());	
			tipoperiodo.setIsNew(tipoperiodo.getIsNewAuxiliar());	
			tipoperiodo.setIsChanged(tipoperiodo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoperiodo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoperiodo.setIsDeletedAuxiliar(false);	
			tipoperiodo.setIsNewAuxiliar(false);	
			tipoperiodo.setIsChangedAuxiliar(false);
			
			tipoperiodo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPeriodos(List<TipoPeriodo> tipoperiodos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoPeriodo tipoperiodo : tipoperiodos) {
			if(conAsignarBase && tipoperiodo.getConCambioAuxiliar()) {
				tipoperiodo.setIsDeleted(tipoperiodo.getIsDeletedAuxiliar());	
				tipoperiodo.setIsNew(tipoperiodo.getIsNewAuxiliar());	
				tipoperiodo.setIsChanged(tipoperiodo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoperiodo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoperiodo.setIsDeletedAuxiliar(false);	
				tipoperiodo.setIsNewAuxiliar(false);	
				tipoperiodo.setIsChangedAuxiliar(false);
				
				tipoperiodo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoPeriodo(TipoPeriodo tipoperiodo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoPeriodos(List<TipoPeriodo> tipoperiodos,Boolean conEnteros) throws Exception  {
		
		for(TipoPeriodo tipoperiodo: tipoperiodos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoPeriodo(List<TipoPeriodo> tipoperiodos,TipoPeriodo tipoperiodoAux) throws Exception  {
		TipoPeriodoConstantesFunciones.InicializarValoresTipoPeriodo(tipoperiodoAux,true);
		
		for(TipoPeriodo tipoperiodo: tipoperiodos) {
			if(tipoperiodo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPeriodo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoPeriodoConstantesFunciones.getArrayColumnasGlobalesTipoPeriodo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPeriodo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoPeriodo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoPeriodo> tipoperiodos,TipoPeriodo tipoperiodo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoPeriodo tipoperiodoAux: tipoperiodos) {
			if(tipoperiodoAux!=null && tipoperiodo!=null) {
				if((tipoperiodoAux.getId()==null && tipoperiodo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoperiodoAux.getId()!=null && tipoperiodo.getId()!=null){
					if(tipoperiodoAux.getId().equals(tipoperiodo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoPeriodo(List<TipoPeriodo> tipoperiodos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoPeriodo tipoperiodo: tipoperiodos) {			
			if(tipoperiodo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoPeriodo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoPeriodoConstantesFunciones.LABEL_ID, TipoPeriodoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPeriodoConstantesFunciones.LABEL_VERSIONROW, TipoPeriodoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPeriodoConstantesFunciones.LABEL_CODIGO, TipoPeriodoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPeriodoConstantesFunciones.LABEL_NOMBRE, TipoPeriodoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoPeriodo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoPeriodoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPeriodoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPeriodoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPeriodoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPeriodo() throws Exception  {
		return TipoPeriodoConstantesFunciones.getTiposSeleccionarTipoPeriodo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPeriodo(Boolean conFk) throws Exception  {
		return TipoPeriodoConstantesFunciones.getTiposSeleccionarTipoPeriodo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPeriodo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPeriodoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoPeriodoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPeriodoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoPeriodoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoPeriodo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPeriodo(TipoPeriodo tipoperiodoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPeriodo(List<TipoPeriodo> tipoperiodosTemp) throws Exception {
		for(TipoPeriodo tipoperiodoAux:tipoperiodosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoPeriodo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoPeriodo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPeriodo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPeriodoConstantesFunciones.getClassesRelationshipsOfTipoPeriodo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPeriodo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPeriodo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPeriodoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoPeriodo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPeriodo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoPeriodo tipoperiodo,List<TipoPeriodo> tipoperiodos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoPeriodo tipoperiodoEncontrado=null;
			
			for(TipoPeriodo tipoperiodoLocal:tipoperiodos) {
				if(tipoperiodoLocal.getId().equals(tipoperiodo.getId())) {
					tipoperiodoEncontrado=tipoperiodoLocal;
					
					tipoperiodoLocal.setIsChanged(tipoperiodo.getIsChanged());
					tipoperiodoLocal.setIsNew(tipoperiodo.getIsNew());
					tipoperiodoLocal.setIsDeleted(tipoperiodo.getIsDeleted());
					
					tipoperiodoLocal.setGeneralEntityOriginal(tipoperiodo.getGeneralEntityOriginal());
					
					tipoperiodoLocal.setId(tipoperiodo.getId());	
					tipoperiodoLocal.setVersionRow(tipoperiodo.getVersionRow());	
					tipoperiodoLocal.setcodigo(tipoperiodo.getcodigo());	
					tipoperiodoLocal.setnombre(tipoperiodo.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoperiodo.getIsDeleted()) {
				if(!existe) {
					tipoperiodos.add(tipoperiodo);
				}
			} else {
				if(tipoperiodoEncontrado!=null && permiteQuitar)  {
					tipoperiodos.remove(tipoperiodoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoPeriodo tipoperiodo,List<TipoPeriodo> tipoperiodos) throws Exception {
		try	{			
			for(TipoPeriodo tipoperiodoLocal:tipoperiodos) {
				if(tipoperiodoLocal.getId().equals(tipoperiodo.getId())) {
					tipoperiodoLocal.setIsSelected(tipoperiodo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoPeriodo(List<TipoPeriodo> tipoperiodosAux) throws Exception {
		//this.tipoperiodosAux=tipoperiodosAux;
		
		for(TipoPeriodo tipoperiodoAux:tipoperiodosAux) {
			if(tipoperiodoAux.getIsChanged()) {
				tipoperiodoAux.setIsChanged(false);
			}		
			
			if(tipoperiodoAux.getIsNew()) {
				tipoperiodoAux.setIsNew(false);
			}	
			
			if(tipoperiodoAux.getIsDeleted()) {
				tipoperiodoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoPeriodo(TipoPeriodo tipoperiodoAux) throws Exception {
		//this.tipoperiodoAux=tipoperiodoAux;
		
			if(tipoperiodoAux.getIsChanged()) {
				tipoperiodoAux.setIsChanged(false);
			}		
			
			if(tipoperiodoAux.getIsNew()) {
				tipoperiodoAux.setIsNew(false);
			}	
			
			if(tipoperiodoAux.getIsDeleted()) {
				tipoperiodoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoPeriodo tipoperiodoAsignar,TipoPeriodo tipoperiodo) throws Exception {
		tipoperiodoAsignar.setId(tipoperiodo.getId());	
		tipoperiodoAsignar.setVersionRow(tipoperiodo.getVersionRow());	
		tipoperiodoAsignar.setcodigo(tipoperiodo.getcodigo());	
		tipoperiodoAsignar.setnombre(tipoperiodo.getnombre());	
	}
	
	public static void inicializarTipoPeriodo(TipoPeriodo tipoperiodo) throws Exception {
		try {
				tipoperiodo.setId(0L);	
					
				tipoperiodo.setcodigo("");	
				tipoperiodo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoPeriodo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPeriodoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPeriodoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoPeriodo(String sTipo,Row row,Workbook workbook,TipoPeriodo tipoperiodo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoperiodo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoperiodo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoPeriodo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoPeriodo() {
		return this.sFinalQueryTipoPeriodo;
	}
	
	public void setsFinalQueryTipoPeriodo(String sFinalQueryTipoPeriodo) {
		this.sFinalQueryTipoPeriodo= sFinalQueryTipoPeriodo;
	}
	
	public Border resaltarSeleccionarTipoPeriodo=null;
	
	public Border setResaltarSeleccionarTipoPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPeriodoBeanSwingJInternalFrame tipoperiodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoperiodoBeanSwingJInternalFrame.jTtoolBarTipoPeriodo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoPeriodo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoPeriodo() {
		return this.resaltarSeleccionarTipoPeriodo;
	}
	
	public void setResaltarSeleccionarTipoPeriodo(Border borderResaltarSeleccionarTipoPeriodo) {
		this.resaltarSeleccionarTipoPeriodo= borderResaltarSeleccionarTipoPeriodo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoPeriodo=null;
	public Boolean mostraridTipoPeriodo=true;
	public Boolean activaridTipoPeriodo=true;

	public Border resaltarcodigoTipoPeriodo=null;
	public Boolean mostrarcodigoTipoPeriodo=true;
	public Boolean activarcodigoTipoPeriodo=true;

	public Border resaltarnombreTipoPeriodo=null;
	public Boolean mostrarnombreTipoPeriodo=true;
	public Boolean activarnombreTipoPeriodo=true;

	
	

	public Border setResaltaridTipoPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPeriodoBeanSwingJInternalFrame tipoperiodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoperiodoBeanSwingJInternalFrame.jTtoolBarTipoPeriodo.setBorder(borderResaltar);
		
		this.resaltaridTipoPeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoPeriodo() {
		return this.resaltaridTipoPeriodo;
	}

	public void setResaltaridTipoPeriodo(Border borderResaltar) {
		this.resaltaridTipoPeriodo= borderResaltar;
	}

	public Boolean getMostraridTipoPeriodo() {
		return this.mostraridTipoPeriodo;
	}

	public void setMostraridTipoPeriodo(Boolean mostraridTipoPeriodo) {
		this.mostraridTipoPeriodo= mostraridTipoPeriodo;
	}

	public Boolean getActivaridTipoPeriodo() {
		return this.activaridTipoPeriodo;
	}

	public void setActivaridTipoPeriodo(Boolean activaridTipoPeriodo) {
		this.activaridTipoPeriodo= activaridTipoPeriodo;
	}

	public Border setResaltarcodigoTipoPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPeriodoBeanSwingJInternalFrame tipoperiodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoperiodoBeanSwingJInternalFrame.jTtoolBarTipoPeriodo.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoPeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoPeriodo() {
		return this.resaltarcodigoTipoPeriodo;
	}

	public void setResaltarcodigoTipoPeriodo(Border borderResaltar) {
		this.resaltarcodigoTipoPeriodo= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoPeriodo() {
		return this.mostrarcodigoTipoPeriodo;
	}

	public void setMostrarcodigoTipoPeriodo(Boolean mostrarcodigoTipoPeriodo) {
		this.mostrarcodigoTipoPeriodo= mostrarcodigoTipoPeriodo;
	}

	public Boolean getActivarcodigoTipoPeriodo() {
		return this.activarcodigoTipoPeriodo;
	}

	public void setActivarcodigoTipoPeriodo(Boolean activarcodigoTipoPeriodo) {
		this.activarcodigoTipoPeriodo= activarcodigoTipoPeriodo;
	}

	public Border setResaltarnombreTipoPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPeriodoBeanSwingJInternalFrame tipoperiodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoperiodoBeanSwingJInternalFrame.jTtoolBarTipoPeriodo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoPeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoPeriodo() {
		return this.resaltarnombreTipoPeriodo;
	}

	public void setResaltarnombreTipoPeriodo(Border borderResaltar) {
		this.resaltarnombreTipoPeriodo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoPeriodo() {
		return this.mostrarnombreTipoPeriodo;
	}

	public void setMostrarnombreTipoPeriodo(Boolean mostrarnombreTipoPeriodo) {
		this.mostrarnombreTipoPeriodo= mostrarnombreTipoPeriodo;
	}

	public Boolean getActivarnombreTipoPeriodo() {
		return this.activarnombreTipoPeriodo;
	}

	public void setActivarnombreTipoPeriodo(Boolean activarnombreTipoPeriodo) {
		this.activarnombreTipoPeriodo= activarnombreTipoPeriodo;
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
		
		
		this.setMostraridTipoPeriodo(esInicial);
		this.setMostrarcodigoTipoPeriodo(esInicial);
		this.setMostrarnombreTipoPeriodo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPeriodoConstantesFunciones.ID)) {
				this.setMostraridTipoPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPeriodoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPeriodoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoPeriodo(esAsigna);
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
		
		
		this.setActivaridTipoPeriodo(esInicial);
		this.setActivarcodigoTipoPeriodo(esInicial);
		this.setActivarnombreTipoPeriodo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPeriodoConstantesFunciones.ID)) {
				this.setActivaridTipoPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPeriodoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPeriodoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoPeriodo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPeriodoBeanSwingJInternalFrame tipoperiodoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoPeriodo(esInicial);
		this.setResaltarcodigoTipoPeriodo(esInicial);
		this.setResaltarnombreTipoPeriodo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPeriodoConstantesFunciones.ID)) {
				this.setResaltaridTipoPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPeriodoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPeriodoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoPeriodo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPeriodoBeanSwingJInternalFrame tipoperiodoBeanSwingJInternalFrame*/)throws Exception {	
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