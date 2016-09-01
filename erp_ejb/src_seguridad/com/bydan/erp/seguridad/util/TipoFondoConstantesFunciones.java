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


import com.bydan.erp.seguridad.util.TipoFondoConstantesFunciones;
import com.bydan.erp.seguridad.util.TipoFondoParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.TipoFondoParameterGeneral;

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
final public class TipoFondoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoFondo";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoFondo"+TipoFondoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoFondoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoFondoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoFondoConstantesFunciones.SCHEMA+"_"+TipoFondoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoFondoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoFondoConstantesFunciones.SCHEMA+"_"+TipoFondoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoFondoConstantesFunciones.SCHEMA+"_"+TipoFondoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoFondoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoFondoConstantesFunciones.SCHEMA+"_"+TipoFondoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFondoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoFondoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFondoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFondoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoFondoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFondoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoFondoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoFondoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoFondoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoFondoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Fondos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Fondo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Fondo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoFondo";
	public static final String OBJECTNAME="tipofondo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="tipo_fondo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipofondo from "+TipoFondoConstantesFunciones.SPERSISTENCENAME+" tipofondo";
	public static String QUERYSELECTNATIVE="select "+TipoFondoConstantesFunciones.SCHEMA+"."+TipoFondoConstantesFunciones.TABLENAME+".id,"+TipoFondoConstantesFunciones.SCHEMA+"."+TipoFondoConstantesFunciones.TABLENAME+".version_row,"+TipoFondoConstantesFunciones.SCHEMA+"."+TipoFondoConstantesFunciones.TABLENAME+".codigo,"+TipoFondoConstantesFunciones.SCHEMA+"."+TipoFondoConstantesFunciones.TABLENAME+".nombre from "+TipoFondoConstantesFunciones.SCHEMA+"."+TipoFondoConstantesFunciones.TABLENAME;//+" as "+TipoFondoConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoFondoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoFondoConstantesFunciones.CODIGO)) {sLabelColumna=TipoFondoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoFondoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoFondoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoFondoDescripcion(TipoFondo tipofondo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipofondo !=null/* && tipofondo.getId()!=0*/) {
			sDescripcion=tipofondo.getcodigo();//tipofondotipofondo.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoFondoDescripcionDetallado(TipoFondo tipofondo) {
		String sDescripcion="";
			
		sDescripcion+=TipoFondoConstantesFunciones.ID+"=";
		sDescripcion+=tipofondo.getId().toString()+",";
		sDescripcion+=TipoFondoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipofondo.getVersionRow().toString()+",";
		sDescripcion+=TipoFondoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipofondo.getcodigo()+",";
		sDescripcion+=TipoFondoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipofondo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoFondoDescripcion(TipoFondo tipofondo,String sValor) throws Exception {			
		if(tipofondo !=null) {
			tipofondo.setcodigo(sValor);;//tipofondotipofondo.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoFondo(TipoFondo tipofondo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipofondo.setcodigo(tipofondo.getcodigo().trim());
		tipofondo.setnombre(tipofondo.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoFondos(List<TipoFondo> tipofondos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoFondo tipofondo: tipofondos) {
			tipofondo.setcodigo(tipofondo.getcodigo().trim());
			tipofondo.setnombre(tipofondo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoFondo(TipoFondo tipofondo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipofondo.getConCambioAuxiliar()) {
			tipofondo.setIsDeleted(tipofondo.getIsDeletedAuxiliar());	
			tipofondo.setIsNew(tipofondo.getIsNewAuxiliar());	
			tipofondo.setIsChanged(tipofondo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipofondo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipofondo.setIsDeletedAuxiliar(false);	
			tipofondo.setIsNewAuxiliar(false);	
			tipofondo.setIsChangedAuxiliar(false);
			
			tipofondo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoFondos(List<TipoFondo> tipofondos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoFondo tipofondo : tipofondos) {
			if(conAsignarBase && tipofondo.getConCambioAuxiliar()) {
				tipofondo.setIsDeleted(tipofondo.getIsDeletedAuxiliar());	
				tipofondo.setIsNew(tipofondo.getIsNewAuxiliar());	
				tipofondo.setIsChanged(tipofondo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipofondo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipofondo.setIsDeletedAuxiliar(false);	
				tipofondo.setIsNewAuxiliar(false);	
				tipofondo.setIsChangedAuxiliar(false);
				
				tipofondo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoFondo(TipoFondo tipofondo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoFondos(List<TipoFondo> tipofondos,Boolean conEnteros) throws Exception  {
		
		for(TipoFondo tipofondo: tipofondos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoFondo(List<TipoFondo> tipofondos,TipoFondo tipofondoAux) throws Exception  {
		TipoFondoConstantesFunciones.InicializarValoresTipoFondo(tipofondoAux,true);
		
		for(TipoFondo tipofondo: tipofondos) {
			if(tipofondo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoFondo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoFondoConstantesFunciones.getArrayColumnasGlobalesTipoFondo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoFondo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoFondo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoFondo> tipofondos,TipoFondo tipofondo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoFondo tipofondoAux: tipofondos) {
			if(tipofondoAux!=null && tipofondo!=null) {
				if((tipofondoAux.getId()==null && tipofondo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipofondoAux.getId()!=null && tipofondo.getId()!=null){
					if(tipofondoAux.getId().equals(tipofondo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoFondo(List<TipoFondo> tipofondos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoFondo tipofondo: tipofondos) {			
			if(tipofondo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoFondo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoFondoConstantesFunciones.LABEL_ID, TipoFondoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFondoConstantesFunciones.LABEL_VERSIONROW, TipoFondoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFondoConstantesFunciones.LABEL_CODIGO, TipoFondoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFondoConstantesFunciones.LABEL_NOMBRE, TipoFondoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoFondo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoFondoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFondoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFondoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFondoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFondo() throws Exception  {
		return TipoFondoConstantesFunciones.getTiposSeleccionarTipoFondo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFondo(Boolean conFk) throws Exception  {
		return TipoFondoConstantesFunciones.getTiposSeleccionarTipoFondo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFondo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFondoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoFondoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFondoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoFondoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoFondo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoFondo(TipoFondo tipofondoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoFondo(List<TipoFondo> tipofondosTemp) throws Exception {
		for(TipoFondo tipofondoAux:tipofondosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoFondo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoFondo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFondo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoFondoConstantesFunciones.getClassesRelationshipsOfTipoFondo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFondo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoFondo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoFondoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoFondo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoFondo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoFondo tipofondo,List<TipoFondo> tipofondos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoFondo tipofondoEncontrado=null;
			
			for(TipoFondo tipofondoLocal:tipofondos) {
				if(tipofondoLocal.getId().equals(tipofondo.getId())) {
					tipofondoEncontrado=tipofondoLocal;
					
					tipofondoLocal.setIsChanged(tipofondo.getIsChanged());
					tipofondoLocal.setIsNew(tipofondo.getIsNew());
					tipofondoLocal.setIsDeleted(tipofondo.getIsDeleted());
					
					tipofondoLocal.setGeneralEntityOriginal(tipofondo.getGeneralEntityOriginal());
					
					tipofondoLocal.setId(tipofondo.getId());	
					tipofondoLocal.setVersionRow(tipofondo.getVersionRow());	
					tipofondoLocal.setcodigo(tipofondo.getcodigo());	
					tipofondoLocal.setnombre(tipofondo.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipofondo.getIsDeleted()) {
				if(!existe) {
					tipofondos.add(tipofondo);
				}
			} else {
				if(tipofondoEncontrado!=null && permiteQuitar)  {
					tipofondos.remove(tipofondoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoFondo tipofondo,List<TipoFondo> tipofondos) throws Exception {
		try	{			
			for(TipoFondo tipofondoLocal:tipofondos) {
				if(tipofondoLocal.getId().equals(tipofondo.getId())) {
					tipofondoLocal.setIsSelected(tipofondo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoFondo(List<TipoFondo> tipofondosAux) throws Exception {
		//this.tipofondosAux=tipofondosAux;
		
		for(TipoFondo tipofondoAux:tipofondosAux) {
			if(tipofondoAux.getIsChanged()) {
				tipofondoAux.setIsChanged(false);
			}		
			
			if(tipofondoAux.getIsNew()) {
				tipofondoAux.setIsNew(false);
			}	
			
			if(tipofondoAux.getIsDeleted()) {
				tipofondoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoFondo(TipoFondo tipofondoAux) throws Exception {
		//this.tipofondoAux=tipofondoAux;
		
			if(tipofondoAux.getIsChanged()) {
				tipofondoAux.setIsChanged(false);
			}		
			
			if(tipofondoAux.getIsNew()) {
				tipofondoAux.setIsNew(false);
			}	
			
			if(tipofondoAux.getIsDeleted()) {
				tipofondoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoFondo tipofondoAsignar,TipoFondo tipofondo) throws Exception {
		tipofondoAsignar.setId(tipofondo.getId());	
		tipofondoAsignar.setVersionRow(tipofondo.getVersionRow());	
		tipofondoAsignar.setcodigo(tipofondo.getcodigo());	
		tipofondoAsignar.setnombre(tipofondo.getnombre());	
	}
	
	public static void inicializarTipoFondo(TipoFondo tipofondo) throws Exception {
		try {
				tipofondo.setId(0L);	
					
				tipofondo.setcodigo("");	
				tipofondo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoFondo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFondoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFondoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoFondo(String sTipo,Row row,Workbook workbook,TipoFondo tipofondo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipofondo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipofondo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoFondo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoFondo() {
		return this.sFinalQueryTipoFondo;
	}
	
	public void setsFinalQueryTipoFondo(String sFinalQueryTipoFondo) {
		this.sFinalQueryTipoFondo= sFinalQueryTipoFondo;
	}
	
	public Border resaltarSeleccionarTipoFondo=null;
	
	public Border setResaltarSeleccionarTipoFondo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFondoBeanSwingJInternalFrame tipofondoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipofondoBeanSwingJInternalFrame.jTtoolBarTipoFondo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoFondo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoFondo() {
		return this.resaltarSeleccionarTipoFondo;
	}
	
	public void setResaltarSeleccionarTipoFondo(Border borderResaltarSeleccionarTipoFondo) {
		this.resaltarSeleccionarTipoFondo= borderResaltarSeleccionarTipoFondo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoFondo=null;
	public Boolean mostraridTipoFondo=true;
	public Boolean activaridTipoFondo=true;

	public Border resaltarcodigoTipoFondo=null;
	public Boolean mostrarcodigoTipoFondo=true;
	public Boolean activarcodigoTipoFondo=true;

	public Border resaltarnombreTipoFondo=null;
	public Boolean mostrarnombreTipoFondo=true;
	public Boolean activarnombreTipoFondo=true;

	
	

	public Border setResaltaridTipoFondo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFondoBeanSwingJInternalFrame tipofondoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipofondoBeanSwingJInternalFrame.jTtoolBarTipoFondo.setBorder(borderResaltar);
		
		this.resaltaridTipoFondo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoFondo() {
		return this.resaltaridTipoFondo;
	}

	public void setResaltaridTipoFondo(Border borderResaltar) {
		this.resaltaridTipoFondo= borderResaltar;
	}

	public Boolean getMostraridTipoFondo() {
		return this.mostraridTipoFondo;
	}

	public void setMostraridTipoFondo(Boolean mostraridTipoFondo) {
		this.mostraridTipoFondo= mostraridTipoFondo;
	}

	public Boolean getActivaridTipoFondo() {
		return this.activaridTipoFondo;
	}

	public void setActivaridTipoFondo(Boolean activaridTipoFondo) {
		this.activaridTipoFondo= activaridTipoFondo;
	}

	public Border setResaltarcodigoTipoFondo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFondoBeanSwingJInternalFrame tipofondoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipofondoBeanSwingJInternalFrame.jTtoolBarTipoFondo.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoFondo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoFondo() {
		return this.resaltarcodigoTipoFondo;
	}

	public void setResaltarcodigoTipoFondo(Border borderResaltar) {
		this.resaltarcodigoTipoFondo= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoFondo() {
		return this.mostrarcodigoTipoFondo;
	}

	public void setMostrarcodigoTipoFondo(Boolean mostrarcodigoTipoFondo) {
		this.mostrarcodigoTipoFondo= mostrarcodigoTipoFondo;
	}

	public Boolean getActivarcodigoTipoFondo() {
		return this.activarcodigoTipoFondo;
	}

	public void setActivarcodigoTipoFondo(Boolean activarcodigoTipoFondo) {
		this.activarcodigoTipoFondo= activarcodigoTipoFondo;
	}

	public Border setResaltarnombreTipoFondo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFondoBeanSwingJInternalFrame tipofondoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipofondoBeanSwingJInternalFrame.jTtoolBarTipoFondo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoFondo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoFondo() {
		return this.resaltarnombreTipoFondo;
	}

	public void setResaltarnombreTipoFondo(Border borderResaltar) {
		this.resaltarnombreTipoFondo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoFondo() {
		return this.mostrarnombreTipoFondo;
	}

	public void setMostrarnombreTipoFondo(Boolean mostrarnombreTipoFondo) {
		this.mostrarnombreTipoFondo= mostrarnombreTipoFondo;
	}

	public Boolean getActivarnombreTipoFondo() {
		return this.activarnombreTipoFondo;
	}

	public void setActivarnombreTipoFondo(Boolean activarnombreTipoFondo) {
		this.activarnombreTipoFondo= activarnombreTipoFondo;
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
		
		
		this.setMostraridTipoFondo(esInicial);
		this.setMostrarcodigoTipoFondo(esInicial);
		this.setMostrarnombreTipoFondo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFondoConstantesFunciones.ID)) {
				this.setMostraridTipoFondo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFondoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoFondo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFondoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoFondo(esAsigna);
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
		
		
		this.setActivaridTipoFondo(esInicial);
		this.setActivarcodigoTipoFondo(esInicial);
		this.setActivarnombreTipoFondo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFondoConstantesFunciones.ID)) {
				this.setActivaridTipoFondo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFondoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoFondo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFondoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoFondo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoFondoBeanSwingJInternalFrame tipofondoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoFondo(esInicial);
		this.setResaltarcodigoTipoFondo(esInicial);
		this.setResaltarnombreTipoFondo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFondoConstantesFunciones.ID)) {
				this.setResaltaridTipoFondo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFondoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoFondo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFondoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoFondo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoFondoBeanSwingJInternalFrame tipofondoBeanSwingJInternalFrame*/)throws Exception {	
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