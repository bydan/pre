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


import com.bydan.erp.seguridad.util.TipoExportarConstantesFunciones;
import com.bydan.erp.seguridad.util.TipoExportarParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.TipoExportarParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoExportarConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoExportar";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoExportar"+TipoExportarConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoExportarHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoExportarHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoExportarConstantesFunciones.SCHEMA+"_"+TipoExportarConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoExportarHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoExportarConstantesFunciones.SCHEMA+"_"+TipoExportarConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoExportarConstantesFunciones.SCHEMA+"_"+TipoExportarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoExportarHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoExportarConstantesFunciones.SCHEMA+"_"+TipoExportarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoExportarConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoExportarHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoExportarConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoExportarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoExportarHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoExportarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoExportarConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoExportarConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoExportarConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoExportarConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Exportars";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Exportar";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Exportar";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoExportar";
	public static final String OBJECTNAME="tipoexportar";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="tipo_exportar";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoexportar from "+TipoExportarConstantesFunciones.SPERSISTENCENAME+" tipoexportar";
	public static String QUERYSELECTNATIVE="select "+TipoExportarConstantesFunciones.SCHEMA+"."+TipoExportarConstantesFunciones.TABLENAME+".id,"+TipoExportarConstantesFunciones.SCHEMA+"."+TipoExportarConstantesFunciones.TABLENAME+".version_row,"+TipoExportarConstantesFunciones.SCHEMA+"."+TipoExportarConstantesFunciones.TABLENAME+".codigo,"+TipoExportarConstantesFunciones.SCHEMA+"."+TipoExportarConstantesFunciones.TABLENAME+".nombre from "+TipoExportarConstantesFunciones.SCHEMA+"."+TipoExportarConstantesFunciones.TABLENAME;//+" as "+TipoExportarConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoExportarLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoExportarConstantesFunciones.CODIGO)) {sLabelColumna=TipoExportarConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoExportarConstantesFunciones.NOMBRE)) {sLabelColumna=TipoExportarConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoExportarDescripcion(TipoExportar tipoexportar) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoexportar !=null/* && tipoexportar.getId()!=0*/) {
			sDescripcion=tipoexportar.getcodigo();//tipoexportartipoexportar.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoExportarDescripcionDetallado(TipoExportar tipoexportar) {
		String sDescripcion="";
			
		sDescripcion+=TipoExportarConstantesFunciones.ID+"=";
		sDescripcion+=tipoexportar.getId().toString()+",";
		sDescripcion+=TipoExportarConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoexportar.getVersionRow().toString()+",";
		sDescripcion+=TipoExportarConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoexportar.getcodigo()+",";
		sDescripcion+=TipoExportarConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoexportar.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoExportarDescripcion(TipoExportar tipoexportar,String sValor) throws Exception {			
		if(tipoexportar !=null) {
			tipoexportar.setcodigo(sValor);;//tipoexportartipoexportar.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoExportar(TipoExportar tipoexportar,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoexportar.setcodigo(tipoexportar.getcodigo().trim());
		tipoexportar.setnombre(tipoexportar.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoExportars(List<TipoExportar> tipoexportars,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoExportar tipoexportar: tipoexportars) {
			tipoexportar.setcodigo(tipoexportar.getcodigo().trim());
			tipoexportar.setnombre(tipoexportar.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoExportar(TipoExportar tipoexportar,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoexportar.getConCambioAuxiliar()) {
			tipoexportar.setIsDeleted(tipoexportar.getIsDeletedAuxiliar());	
			tipoexportar.setIsNew(tipoexportar.getIsNewAuxiliar());	
			tipoexportar.setIsChanged(tipoexportar.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoexportar.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoexportar.setIsDeletedAuxiliar(false);	
			tipoexportar.setIsNewAuxiliar(false);	
			tipoexportar.setIsChangedAuxiliar(false);
			
			tipoexportar.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoExportars(List<TipoExportar> tipoexportars,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoExportar tipoexportar : tipoexportars) {
			if(conAsignarBase && tipoexportar.getConCambioAuxiliar()) {
				tipoexportar.setIsDeleted(tipoexportar.getIsDeletedAuxiliar());	
				tipoexportar.setIsNew(tipoexportar.getIsNewAuxiliar());	
				tipoexportar.setIsChanged(tipoexportar.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoexportar.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoexportar.setIsDeletedAuxiliar(false);	
				tipoexportar.setIsNewAuxiliar(false);	
				tipoexportar.setIsChangedAuxiliar(false);
				
				tipoexportar.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoExportar(TipoExportar tipoexportar,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoExportars(List<TipoExportar> tipoexportars,Boolean conEnteros) throws Exception  {
		
		for(TipoExportar tipoexportar: tipoexportars) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoExportar(List<TipoExportar> tipoexportars,TipoExportar tipoexportarAux) throws Exception  {
		TipoExportarConstantesFunciones.InicializarValoresTipoExportar(tipoexportarAux,true);
		
		for(TipoExportar tipoexportar: tipoexportars) {
			if(tipoexportar.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoExportar(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoExportarConstantesFunciones.getArrayColumnasGlobalesTipoExportar(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoExportar(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoExportar(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoExportar> tipoexportars,TipoExportar tipoexportar,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoExportar tipoexportarAux: tipoexportars) {
			if(tipoexportarAux!=null && tipoexportar!=null) {
				if((tipoexportarAux.getId()==null && tipoexportar.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoexportarAux.getId()!=null && tipoexportar.getId()!=null){
					if(tipoexportarAux.getId().equals(tipoexportar.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoExportar(List<TipoExportar> tipoexportars) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoExportar tipoexportar: tipoexportars) {			
			if(tipoexportar.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoExportar() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoExportarConstantesFunciones.LABEL_ID, TipoExportarConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoExportarConstantesFunciones.LABEL_VERSIONROW, TipoExportarConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoExportarConstantesFunciones.LABEL_CODIGO, TipoExportarConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoExportarConstantesFunciones.LABEL_NOMBRE, TipoExportarConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoExportar() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoExportarConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoExportarConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoExportarConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoExportarConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoExportar() throws Exception  {
		return TipoExportarConstantesFunciones.getTiposSeleccionarTipoExportar(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoExportar(Boolean conFk) throws Exception  {
		return TipoExportarConstantesFunciones.getTiposSeleccionarTipoExportar(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoExportar(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoExportarConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoExportarConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoExportarConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoExportarConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoExportar(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoExportar(TipoExportar tipoexportarAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoExportar(List<TipoExportar> tipoexportarsTemp) throws Exception {
		for(TipoExportar tipoexportarAux:tipoexportarsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoExportar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoExportar(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoExportar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoExportarConstantesFunciones.getClassesRelationshipsOfTipoExportar(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoExportar(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoExportar(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoExportarConstantesFunciones.getClassesRelationshipsFromStringsOfTipoExportar(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoExportar(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoExportar tipoexportar,List<TipoExportar> tipoexportars,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoExportar tipoexportarEncontrado=null;
			
			for(TipoExportar tipoexportarLocal:tipoexportars) {
				if(tipoexportarLocal.getId().equals(tipoexportar.getId())) {
					tipoexportarEncontrado=tipoexportarLocal;
					
					tipoexportarLocal.setIsChanged(tipoexportar.getIsChanged());
					tipoexportarLocal.setIsNew(tipoexportar.getIsNew());
					tipoexportarLocal.setIsDeleted(tipoexportar.getIsDeleted());
					
					tipoexportarLocal.setGeneralEntityOriginal(tipoexportar.getGeneralEntityOriginal());
					
					tipoexportarLocal.setId(tipoexportar.getId());	
					tipoexportarLocal.setVersionRow(tipoexportar.getVersionRow());	
					tipoexportarLocal.setcodigo(tipoexportar.getcodigo());	
					tipoexportarLocal.setnombre(tipoexportar.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoexportar.getIsDeleted()) {
				if(!existe) {
					tipoexportars.add(tipoexportar);
				}
			} else {
				if(tipoexportarEncontrado!=null && permiteQuitar)  {
					tipoexportars.remove(tipoexportarEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoExportar tipoexportar,List<TipoExportar> tipoexportars) throws Exception {
		try	{			
			for(TipoExportar tipoexportarLocal:tipoexportars) {
				if(tipoexportarLocal.getId().equals(tipoexportar.getId())) {
					tipoexportarLocal.setIsSelected(tipoexportar.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoExportar(List<TipoExportar> tipoexportarsAux) throws Exception {
		//this.tipoexportarsAux=tipoexportarsAux;
		
		for(TipoExportar tipoexportarAux:tipoexportarsAux) {
			if(tipoexportarAux.getIsChanged()) {
				tipoexportarAux.setIsChanged(false);
			}		
			
			if(tipoexportarAux.getIsNew()) {
				tipoexportarAux.setIsNew(false);
			}	
			
			if(tipoexportarAux.getIsDeleted()) {
				tipoexportarAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoExportar(TipoExportar tipoexportarAux) throws Exception {
		//this.tipoexportarAux=tipoexportarAux;
		
			if(tipoexportarAux.getIsChanged()) {
				tipoexportarAux.setIsChanged(false);
			}		
			
			if(tipoexportarAux.getIsNew()) {
				tipoexportarAux.setIsNew(false);
			}	
			
			if(tipoexportarAux.getIsDeleted()) {
				tipoexportarAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoExportar tipoexportarAsignar,TipoExportar tipoexportar) throws Exception {
		tipoexportarAsignar.setId(tipoexportar.getId());	
		tipoexportarAsignar.setVersionRow(tipoexportar.getVersionRow());	
		tipoexportarAsignar.setcodigo(tipoexportar.getcodigo());	
		tipoexportarAsignar.setnombre(tipoexportar.getnombre());	
	}
	
	public static void inicializarTipoExportar(TipoExportar tipoexportar) throws Exception {
		try {
				tipoexportar.setId(0L);	
					
				tipoexportar.setcodigo("");	
				tipoexportar.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoExportar(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoExportarConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoExportarConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoExportar(String sTipo,Row row,Workbook workbook,TipoExportar tipoexportar,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoexportar.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoexportar.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoExportar=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoExportar() {
		return this.sFinalQueryTipoExportar;
	}
	
	public void setsFinalQueryTipoExportar(String sFinalQueryTipoExportar) {
		this.sFinalQueryTipoExportar= sFinalQueryTipoExportar;
	}
	
	public Border resaltarSeleccionarTipoExportar=null;
	
	public Border setResaltarSeleccionarTipoExportar(ParametroGeneralUsuario parametroGeneralUsuario/*TipoExportarBeanSwingJInternalFrame tipoexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoexportarBeanSwingJInternalFrame.jTtoolBarTipoExportar.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoExportar= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoExportar() {
		return this.resaltarSeleccionarTipoExportar;
	}
	
	public void setResaltarSeleccionarTipoExportar(Border borderResaltarSeleccionarTipoExportar) {
		this.resaltarSeleccionarTipoExportar= borderResaltarSeleccionarTipoExportar;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoExportar=null;
	public Boolean mostraridTipoExportar=true;
	public Boolean activaridTipoExportar=true;

	public Border resaltarcodigoTipoExportar=null;
	public Boolean mostrarcodigoTipoExportar=true;
	public Boolean activarcodigoTipoExportar=true;

	public Border resaltarnombreTipoExportar=null;
	public Boolean mostrarnombreTipoExportar=true;
	public Boolean activarnombreTipoExportar=true;

	
	

	public Border setResaltaridTipoExportar(ParametroGeneralUsuario parametroGeneralUsuario/*TipoExportarBeanSwingJInternalFrame tipoexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoexportarBeanSwingJInternalFrame.jTtoolBarTipoExportar.setBorder(borderResaltar);
		
		this.resaltaridTipoExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoExportar() {
		return this.resaltaridTipoExportar;
	}

	public void setResaltaridTipoExportar(Border borderResaltar) {
		this.resaltaridTipoExportar= borderResaltar;
	}

	public Boolean getMostraridTipoExportar() {
		return this.mostraridTipoExportar;
	}

	public void setMostraridTipoExportar(Boolean mostraridTipoExportar) {
		this.mostraridTipoExportar= mostraridTipoExportar;
	}

	public Boolean getActivaridTipoExportar() {
		return this.activaridTipoExportar;
	}

	public void setActivaridTipoExportar(Boolean activaridTipoExportar) {
		this.activaridTipoExportar= activaridTipoExportar;
	}

	public Border setResaltarcodigoTipoExportar(ParametroGeneralUsuario parametroGeneralUsuario/*TipoExportarBeanSwingJInternalFrame tipoexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoexportarBeanSwingJInternalFrame.jTtoolBarTipoExportar.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoExportar() {
		return this.resaltarcodigoTipoExportar;
	}

	public void setResaltarcodigoTipoExportar(Border borderResaltar) {
		this.resaltarcodigoTipoExportar= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoExportar() {
		return this.mostrarcodigoTipoExportar;
	}

	public void setMostrarcodigoTipoExportar(Boolean mostrarcodigoTipoExportar) {
		this.mostrarcodigoTipoExportar= mostrarcodigoTipoExportar;
	}

	public Boolean getActivarcodigoTipoExportar() {
		return this.activarcodigoTipoExportar;
	}

	public void setActivarcodigoTipoExportar(Boolean activarcodigoTipoExportar) {
		this.activarcodigoTipoExportar= activarcodigoTipoExportar;
	}

	public Border setResaltarnombreTipoExportar(ParametroGeneralUsuario parametroGeneralUsuario/*TipoExportarBeanSwingJInternalFrame tipoexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoexportarBeanSwingJInternalFrame.jTtoolBarTipoExportar.setBorder(borderResaltar);
		
		this.resaltarnombreTipoExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoExportar() {
		return this.resaltarnombreTipoExportar;
	}

	public void setResaltarnombreTipoExportar(Border borderResaltar) {
		this.resaltarnombreTipoExportar= borderResaltar;
	}

	public Boolean getMostrarnombreTipoExportar() {
		return this.mostrarnombreTipoExportar;
	}

	public void setMostrarnombreTipoExportar(Boolean mostrarnombreTipoExportar) {
		this.mostrarnombreTipoExportar= mostrarnombreTipoExportar;
	}

	public Boolean getActivarnombreTipoExportar() {
		return this.activarnombreTipoExportar;
	}

	public void setActivarnombreTipoExportar(Boolean activarnombreTipoExportar) {
		this.activarnombreTipoExportar= activarnombreTipoExportar;
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
		
		
		this.setMostraridTipoExportar(esInicial);
		this.setMostrarcodigoTipoExportar(esInicial);
		this.setMostrarnombreTipoExportar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoExportarConstantesFunciones.ID)) {
				this.setMostraridTipoExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoExportarConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoExportarConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoExportar(esAsigna);
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
		
		
		this.setActivaridTipoExportar(esInicial);
		this.setActivarcodigoTipoExportar(esInicial);
		this.setActivarnombreTipoExportar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoExportarConstantesFunciones.ID)) {
				this.setActivaridTipoExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoExportarConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoExportarConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoExportar(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoExportarBeanSwingJInternalFrame tipoexportarBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoExportar(esInicial);
		this.setResaltarcodigoTipoExportar(esInicial);
		this.setResaltarnombreTipoExportar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoExportarConstantesFunciones.ID)) {
				this.setResaltaridTipoExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoExportarConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoExportarConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoExportar(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoExportarBeanSwingJInternalFrame tipoexportarBeanSwingJInternalFrame*/)throws Exception {	
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