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


import com.bydan.erp.seguridad.util.TipoDelimiterConstantesFunciones;
import com.bydan.erp.seguridad.util.TipoDelimiterParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.TipoDelimiterParameterGeneral;

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
final public class TipoDelimiterConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoDelimiter";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoDelimiter"+TipoDelimiterConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoDelimiterHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoDelimiterHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoDelimiterConstantesFunciones.SCHEMA+"_"+TipoDelimiterConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoDelimiterHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoDelimiterConstantesFunciones.SCHEMA+"_"+TipoDelimiterConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoDelimiterConstantesFunciones.SCHEMA+"_"+TipoDelimiterConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoDelimiterHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoDelimiterConstantesFunciones.SCHEMA+"_"+TipoDelimiterConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDelimiterConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDelimiterHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDelimiterConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDelimiterConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDelimiterHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDelimiterConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoDelimiterConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoDelimiterConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoDelimiterConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoDelimiterConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Delimiters";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Delimiter";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Delimiter";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoDelimiter";
	public static final String OBJECTNAME="tipodelimiter";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="tipo_delimiter";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipodelimiter from "+TipoDelimiterConstantesFunciones.SPERSISTENCENAME+" tipodelimiter";
	public static String QUERYSELECTNATIVE="select "+TipoDelimiterConstantesFunciones.SCHEMA+"."+TipoDelimiterConstantesFunciones.TABLENAME+".id,"+TipoDelimiterConstantesFunciones.SCHEMA+"."+TipoDelimiterConstantesFunciones.TABLENAME+".version_row,"+TipoDelimiterConstantesFunciones.SCHEMA+"."+TipoDelimiterConstantesFunciones.TABLENAME+".codigo,"+TipoDelimiterConstantesFunciones.SCHEMA+"."+TipoDelimiterConstantesFunciones.TABLENAME+".nombre from "+TipoDelimiterConstantesFunciones.SCHEMA+"."+TipoDelimiterConstantesFunciones.TABLENAME;//+" as "+TipoDelimiterConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoDelimiterLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoDelimiterConstantesFunciones.CODIGO)) {sLabelColumna=TipoDelimiterConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoDelimiterConstantesFunciones.NOMBRE)) {sLabelColumna=TipoDelimiterConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoDelimiterDescripcion(TipoDelimiter tipodelimiter) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipodelimiter !=null/* && tipodelimiter.getId()!=0*/) {
			sDescripcion=tipodelimiter.getcodigo();//tipodelimitertipodelimiter.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoDelimiterDescripcionDetallado(TipoDelimiter tipodelimiter) {
		String sDescripcion="";
			
		sDescripcion+=TipoDelimiterConstantesFunciones.ID+"=";
		sDescripcion+=tipodelimiter.getId().toString()+",";
		sDescripcion+=TipoDelimiterConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipodelimiter.getVersionRow().toString()+",";
		sDescripcion+=TipoDelimiterConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipodelimiter.getcodigo()+",";
		sDescripcion+=TipoDelimiterConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipodelimiter.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoDelimiterDescripcion(TipoDelimiter tipodelimiter,String sValor) throws Exception {			
		if(tipodelimiter !=null) {
			tipodelimiter.setcodigo(sValor);;//tipodelimitertipodelimiter.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoDelimiter(TipoDelimiter tipodelimiter,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipodelimiter.setcodigo(tipodelimiter.getcodigo().trim());
		tipodelimiter.setnombre(tipodelimiter.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoDelimiters(List<TipoDelimiter> tipodelimiters,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoDelimiter tipodelimiter: tipodelimiters) {
			tipodelimiter.setcodigo(tipodelimiter.getcodigo().trim());
			tipodelimiter.setnombre(tipodelimiter.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDelimiter(TipoDelimiter tipodelimiter,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipodelimiter.getConCambioAuxiliar()) {
			tipodelimiter.setIsDeleted(tipodelimiter.getIsDeletedAuxiliar());	
			tipodelimiter.setIsNew(tipodelimiter.getIsNewAuxiliar());	
			tipodelimiter.setIsChanged(tipodelimiter.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipodelimiter.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipodelimiter.setIsDeletedAuxiliar(false);	
			tipodelimiter.setIsNewAuxiliar(false);	
			tipodelimiter.setIsChangedAuxiliar(false);
			
			tipodelimiter.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDelimiters(List<TipoDelimiter> tipodelimiters,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoDelimiter tipodelimiter : tipodelimiters) {
			if(conAsignarBase && tipodelimiter.getConCambioAuxiliar()) {
				tipodelimiter.setIsDeleted(tipodelimiter.getIsDeletedAuxiliar());	
				tipodelimiter.setIsNew(tipodelimiter.getIsNewAuxiliar());	
				tipodelimiter.setIsChanged(tipodelimiter.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipodelimiter.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipodelimiter.setIsDeletedAuxiliar(false);	
				tipodelimiter.setIsNewAuxiliar(false);	
				tipodelimiter.setIsChangedAuxiliar(false);
				
				tipodelimiter.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoDelimiter(TipoDelimiter tipodelimiter,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoDelimiters(List<TipoDelimiter> tipodelimiters,Boolean conEnteros) throws Exception  {
		
		for(TipoDelimiter tipodelimiter: tipodelimiters) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoDelimiter(List<TipoDelimiter> tipodelimiters,TipoDelimiter tipodelimiterAux) throws Exception  {
		TipoDelimiterConstantesFunciones.InicializarValoresTipoDelimiter(tipodelimiterAux,true);
		
		for(TipoDelimiter tipodelimiter: tipodelimiters) {
			if(tipodelimiter.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDelimiter(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoDelimiterConstantesFunciones.getArrayColumnasGlobalesTipoDelimiter(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDelimiter(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoDelimiter(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoDelimiter> tipodelimiters,TipoDelimiter tipodelimiter,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoDelimiter tipodelimiterAux: tipodelimiters) {
			if(tipodelimiterAux!=null && tipodelimiter!=null) {
				if((tipodelimiterAux.getId()==null && tipodelimiter.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipodelimiterAux.getId()!=null && tipodelimiter.getId()!=null){
					if(tipodelimiterAux.getId().equals(tipodelimiter.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoDelimiter(List<TipoDelimiter> tipodelimiters) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoDelimiter tipodelimiter: tipodelimiters) {			
			if(tipodelimiter.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoDelimiter() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoDelimiterConstantesFunciones.LABEL_ID, TipoDelimiterConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDelimiterConstantesFunciones.LABEL_VERSIONROW, TipoDelimiterConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDelimiterConstantesFunciones.LABEL_CODIGO, TipoDelimiterConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDelimiterConstantesFunciones.LABEL_NOMBRE, TipoDelimiterConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoDelimiter() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoDelimiterConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDelimiterConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDelimiterConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDelimiterConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDelimiter() throws Exception  {
		return TipoDelimiterConstantesFunciones.getTiposSeleccionarTipoDelimiter(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDelimiter(Boolean conFk) throws Exception  {
		return TipoDelimiterConstantesFunciones.getTiposSeleccionarTipoDelimiter(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDelimiter(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDelimiterConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoDelimiterConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDelimiterConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoDelimiterConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoDelimiter(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDelimiter(TipoDelimiter tipodelimiterAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDelimiter(List<TipoDelimiter> tipodelimitersTemp) throws Exception {
		for(TipoDelimiter tipodelimiterAux:tipodelimitersTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDelimiter(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoDelimiter(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDelimiter(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDelimiterConstantesFunciones.getClassesRelationshipsOfTipoDelimiter(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDelimiter(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDelimiter(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDelimiterConstantesFunciones.getClassesRelationshipsFromStringsOfTipoDelimiter(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDelimiter(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoDelimiter tipodelimiter,List<TipoDelimiter> tipodelimiters,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoDelimiter tipodelimiterEncontrado=null;
			
			for(TipoDelimiter tipodelimiterLocal:tipodelimiters) {
				if(tipodelimiterLocal.getId().equals(tipodelimiter.getId())) {
					tipodelimiterEncontrado=tipodelimiterLocal;
					
					tipodelimiterLocal.setIsChanged(tipodelimiter.getIsChanged());
					tipodelimiterLocal.setIsNew(tipodelimiter.getIsNew());
					tipodelimiterLocal.setIsDeleted(tipodelimiter.getIsDeleted());
					
					tipodelimiterLocal.setGeneralEntityOriginal(tipodelimiter.getGeneralEntityOriginal());
					
					tipodelimiterLocal.setId(tipodelimiter.getId());	
					tipodelimiterLocal.setVersionRow(tipodelimiter.getVersionRow());	
					tipodelimiterLocal.setcodigo(tipodelimiter.getcodigo());	
					tipodelimiterLocal.setnombre(tipodelimiter.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipodelimiter.getIsDeleted()) {
				if(!existe) {
					tipodelimiters.add(tipodelimiter);
				}
			} else {
				if(tipodelimiterEncontrado!=null && permiteQuitar)  {
					tipodelimiters.remove(tipodelimiterEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoDelimiter tipodelimiter,List<TipoDelimiter> tipodelimiters) throws Exception {
		try	{			
			for(TipoDelimiter tipodelimiterLocal:tipodelimiters) {
				if(tipodelimiterLocal.getId().equals(tipodelimiter.getId())) {
					tipodelimiterLocal.setIsSelected(tipodelimiter.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoDelimiter(List<TipoDelimiter> tipodelimitersAux) throws Exception {
		//this.tipodelimitersAux=tipodelimitersAux;
		
		for(TipoDelimiter tipodelimiterAux:tipodelimitersAux) {
			if(tipodelimiterAux.getIsChanged()) {
				tipodelimiterAux.setIsChanged(false);
			}		
			
			if(tipodelimiterAux.getIsNew()) {
				tipodelimiterAux.setIsNew(false);
			}	
			
			if(tipodelimiterAux.getIsDeleted()) {
				tipodelimiterAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoDelimiter(TipoDelimiter tipodelimiterAux) throws Exception {
		//this.tipodelimiterAux=tipodelimiterAux;
		
			if(tipodelimiterAux.getIsChanged()) {
				tipodelimiterAux.setIsChanged(false);
			}		
			
			if(tipodelimiterAux.getIsNew()) {
				tipodelimiterAux.setIsNew(false);
			}	
			
			if(tipodelimiterAux.getIsDeleted()) {
				tipodelimiterAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoDelimiter tipodelimiterAsignar,TipoDelimiter tipodelimiter) throws Exception {
		tipodelimiterAsignar.setId(tipodelimiter.getId());	
		tipodelimiterAsignar.setVersionRow(tipodelimiter.getVersionRow());	
		tipodelimiterAsignar.setcodigo(tipodelimiter.getcodigo());	
		tipodelimiterAsignar.setnombre(tipodelimiter.getnombre());	
	}
	
	public static void inicializarTipoDelimiter(TipoDelimiter tipodelimiter) throws Exception {
		try {
				tipodelimiter.setId(0L);	
					
				tipodelimiter.setcodigo("");	
				tipodelimiter.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoDelimiter(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDelimiterConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDelimiterConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoDelimiter(String sTipo,Row row,Workbook workbook,TipoDelimiter tipodelimiter,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodelimiter.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodelimiter.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoDelimiter=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoDelimiter() {
		return this.sFinalQueryTipoDelimiter;
	}
	
	public void setsFinalQueryTipoDelimiter(String sFinalQueryTipoDelimiter) {
		this.sFinalQueryTipoDelimiter= sFinalQueryTipoDelimiter;
	}
	
	public Border resaltarSeleccionarTipoDelimiter=null;
	
	public Border setResaltarSeleccionarTipoDelimiter(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDelimiterBeanSwingJInternalFrame tipodelimiterBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipodelimiterBeanSwingJInternalFrame.jTtoolBarTipoDelimiter.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoDelimiter= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoDelimiter() {
		return this.resaltarSeleccionarTipoDelimiter;
	}
	
	public void setResaltarSeleccionarTipoDelimiter(Border borderResaltarSeleccionarTipoDelimiter) {
		this.resaltarSeleccionarTipoDelimiter= borderResaltarSeleccionarTipoDelimiter;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoDelimiter=null;
	public Boolean mostraridTipoDelimiter=true;
	public Boolean activaridTipoDelimiter=true;

	public Border resaltarcodigoTipoDelimiter=null;
	public Boolean mostrarcodigoTipoDelimiter=true;
	public Boolean activarcodigoTipoDelimiter=true;

	public Border resaltarnombreTipoDelimiter=null;
	public Boolean mostrarnombreTipoDelimiter=true;
	public Boolean activarnombreTipoDelimiter=true;

	
	

	public Border setResaltaridTipoDelimiter(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDelimiterBeanSwingJInternalFrame tipodelimiterBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodelimiterBeanSwingJInternalFrame.jTtoolBarTipoDelimiter.setBorder(borderResaltar);
		
		this.resaltaridTipoDelimiter= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoDelimiter() {
		return this.resaltaridTipoDelimiter;
	}

	public void setResaltaridTipoDelimiter(Border borderResaltar) {
		this.resaltaridTipoDelimiter= borderResaltar;
	}

	public Boolean getMostraridTipoDelimiter() {
		return this.mostraridTipoDelimiter;
	}

	public void setMostraridTipoDelimiter(Boolean mostraridTipoDelimiter) {
		this.mostraridTipoDelimiter= mostraridTipoDelimiter;
	}

	public Boolean getActivaridTipoDelimiter() {
		return this.activaridTipoDelimiter;
	}

	public void setActivaridTipoDelimiter(Boolean activaridTipoDelimiter) {
		this.activaridTipoDelimiter= activaridTipoDelimiter;
	}

	public Border setResaltarcodigoTipoDelimiter(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDelimiterBeanSwingJInternalFrame tipodelimiterBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodelimiterBeanSwingJInternalFrame.jTtoolBarTipoDelimiter.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoDelimiter= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoDelimiter() {
		return this.resaltarcodigoTipoDelimiter;
	}

	public void setResaltarcodigoTipoDelimiter(Border borderResaltar) {
		this.resaltarcodigoTipoDelimiter= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoDelimiter() {
		return this.mostrarcodigoTipoDelimiter;
	}

	public void setMostrarcodigoTipoDelimiter(Boolean mostrarcodigoTipoDelimiter) {
		this.mostrarcodigoTipoDelimiter= mostrarcodigoTipoDelimiter;
	}

	public Boolean getActivarcodigoTipoDelimiter() {
		return this.activarcodigoTipoDelimiter;
	}

	public void setActivarcodigoTipoDelimiter(Boolean activarcodigoTipoDelimiter) {
		this.activarcodigoTipoDelimiter= activarcodigoTipoDelimiter;
	}

	public Border setResaltarnombreTipoDelimiter(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDelimiterBeanSwingJInternalFrame tipodelimiterBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodelimiterBeanSwingJInternalFrame.jTtoolBarTipoDelimiter.setBorder(borderResaltar);
		
		this.resaltarnombreTipoDelimiter= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoDelimiter() {
		return this.resaltarnombreTipoDelimiter;
	}

	public void setResaltarnombreTipoDelimiter(Border borderResaltar) {
		this.resaltarnombreTipoDelimiter= borderResaltar;
	}

	public Boolean getMostrarnombreTipoDelimiter() {
		return this.mostrarnombreTipoDelimiter;
	}

	public void setMostrarnombreTipoDelimiter(Boolean mostrarnombreTipoDelimiter) {
		this.mostrarnombreTipoDelimiter= mostrarnombreTipoDelimiter;
	}

	public Boolean getActivarnombreTipoDelimiter() {
		return this.activarnombreTipoDelimiter;
	}

	public void setActivarnombreTipoDelimiter(Boolean activarnombreTipoDelimiter) {
		this.activarnombreTipoDelimiter= activarnombreTipoDelimiter;
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
		
		
		this.setMostraridTipoDelimiter(esInicial);
		this.setMostrarcodigoTipoDelimiter(esInicial);
		this.setMostrarnombreTipoDelimiter(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDelimiterConstantesFunciones.ID)) {
				this.setMostraridTipoDelimiter(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDelimiterConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoDelimiter(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDelimiterConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoDelimiter(esAsigna);
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
		
		
		this.setActivaridTipoDelimiter(esInicial);
		this.setActivarcodigoTipoDelimiter(esInicial);
		this.setActivarnombreTipoDelimiter(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDelimiterConstantesFunciones.ID)) {
				this.setActivaridTipoDelimiter(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDelimiterConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoDelimiter(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDelimiterConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoDelimiter(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDelimiterBeanSwingJInternalFrame tipodelimiterBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoDelimiter(esInicial);
		this.setResaltarcodigoTipoDelimiter(esInicial);
		this.setResaltarnombreTipoDelimiter(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDelimiterConstantesFunciones.ID)) {
				this.setResaltaridTipoDelimiter(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDelimiterConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoDelimiter(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDelimiterConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoDelimiter(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDelimiterBeanSwingJInternalFrame tipodelimiterBeanSwingJInternalFrame*/)throws Exception {	
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