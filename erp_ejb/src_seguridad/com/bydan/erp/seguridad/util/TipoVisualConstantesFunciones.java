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


import com.bydan.erp.seguridad.util.TipoVisualConstantesFunciones;
import com.bydan.erp.seguridad.util.TipoVisualParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.TipoVisualParameterGeneral;

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
final public class TipoVisualConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoVisual";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoVisual"+TipoVisualConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoVisualHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoVisualHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoVisualConstantesFunciones.SCHEMA+"_"+TipoVisualConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoVisualHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoVisualConstantesFunciones.SCHEMA+"_"+TipoVisualConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoVisualConstantesFunciones.SCHEMA+"_"+TipoVisualConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoVisualHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoVisualConstantesFunciones.SCHEMA+"_"+TipoVisualConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoVisualConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoVisualHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoVisualConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoVisualConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoVisualHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoVisualConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoVisualConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoVisualConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoVisualConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoVisualConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Visuals";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Visual";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Visual";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoVisual";
	public static final String OBJECTNAME="tipovisual";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="tipo_visual";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipovisual from "+TipoVisualConstantesFunciones.SPERSISTENCENAME+" tipovisual";
	public static String QUERYSELECTNATIVE="select "+TipoVisualConstantesFunciones.SCHEMA+"."+TipoVisualConstantesFunciones.TABLENAME+".id,"+TipoVisualConstantesFunciones.SCHEMA+"."+TipoVisualConstantesFunciones.TABLENAME+".version_row,"+TipoVisualConstantesFunciones.SCHEMA+"."+TipoVisualConstantesFunciones.TABLENAME+".codigo,"+TipoVisualConstantesFunciones.SCHEMA+"."+TipoVisualConstantesFunciones.TABLENAME+".nombre from "+TipoVisualConstantesFunciones.SCHEMA+"."+TipoVisualConstantesFunciones.TABLENAME;//+" as "+TipoVisualConstantesFunciones.TABLENAME;
	
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
    	public static final String LABEL_CODIGO= "Código";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoVisualLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoVisualConstantesFunciones.CODIGO)) {sLabelColumna=TipoVisualConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoVisualConstantesFunciones.NOMBRE)) {sLabelColumna=TipoVisualConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoVisualDescripcion(TipoVisual tipovisual) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipovisual !=null/* && tipovisual.getId()!=0*/) {
			sDescripcion=tipovisual.getcodigo();//tipovisualtipovisual.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoVisualDescripcionDetallado(TipoVisual tipovisual) {
		String sDescripcion="";
			
		sDescripcion+=TipoVisualConstantesFunciones.ID+"=";
		sDescripcion+=tipovisual.getId().toString()+",";
		sDescripcion+=TipoVisualConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipovisual.getVersionRow().toString()+",";
		sDescripcion+=TipoVisualConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipovisual.getcodigo()+",";
		sDescripcion+=TipoVisualConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipovisual.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoVisualDescripcion(TipoVisual tipovisual,String sValor) throws Exception {			
		if(tipovisual !=null) {
			tipovisual.setcodigo(sValor);;//tipovisualtipovisual.getcodigo().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoVisual(TipoVisual tipovisual,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipovisual.setcodigo(tipovisual.getcodigo().trim());
		tipovisual.setnombre(tipovisual.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoVisuals(List<TipoVisual> tipovisuals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoVisual tipovisual: tipovisuals) {
			tipovisual.setcodigo(tipovisual.getcodigo().trim());
			tipovisual.setnombre(tipovisual.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoVisual(TipoVisual tipovisual,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipovisual.getConCambioAuxiliar()) {
			tipovisual.setIsDeleted(tipovisual.getIsDeletedAuxiliar());	
			tipovisual.setIsNew(tipovisual.getIsNewAuxiliar());	
			tipovisual.setIsChanged(tipovisual.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipovisual.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipovisual.setIsDeletedAuxiliar(false);	
			tipovisual.setIsNewAuxiliar(false);	
			tipovisual.setIsChangedAuxiliar(false);
			
			tipovisual.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoVisuals(List<TipoVisual> tipovisuals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoVisual tipovisual : tipovisuals) {
			if(conAsignarBase && tipovisual.getConCambioAuxiliar()) {
				tipovisual.setIsDeleted(tipovisual.getIsDeletedAuxiliar());	
				tipovisual.setIsNew(tipovisual.getIsNewAuxiliar());	
				tipovisual.setIsChanged(tipovisual.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipovisual.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipovisual.setIsDeletedAuxiliar(false);	
				tipovisual.setIsNewAuxiliar(false);	
				tipovisual.setIsChangedAuxiliar(false);
				
				tipovisual.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoVisual(TipoVisual tipovisual,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoVisuals(List<TipoVisual> tipovisuals,Boolean conEnteros) throws Exception  {
		
		for(TipoVisual tipovisual: tipovisuals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoVisual(List<TipoVisual> tipovisuals,TipoVisual tipovisualAux) throws Exception  {
		TipoVisualConstantesFunciones.InicializarValoresTipoVisual(tipovisualAux,true);
		
		for(TipoVisual tipovisual: tipovisuals) {
			if(tipovisual.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoVisual(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoVisualConstantesFunciones.getArrayColumnasGlobalesTipoVisual(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoVisual(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoVisual(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoVisual> tipovisuals,TipoVisual tipovisual,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoVisual tipovisualAux: tipovisuals) {
			if(tipovisualAux!=null && tipovisual!=null) {
				if((tipovisualAux.getId()==null && tipovisual.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipovisualAux.getId()!=null && tipovisual.getId()!=null){
					if(tipovisualAux.getId().equals(tipovisual.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoVisual(List<TipoVisual> tipovisuals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoVisual tipovisual: tipovisuals) {			
			if(tipovisual.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoVisual() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoVisualConstantesFunciones.LABEL_ID, TipoVisualConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoVisualConstantesFunciones.LABEL_VERSIONROW, TipoVisualConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoVisualConstantesFunciones.LABEL_CODIGO, TipoVisualConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoVisualConstantesFunciones.LABEL_NOMBRE, TipoVisualConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoVisual() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoVisualConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoVisualConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoVisualConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoVisualConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoVisual() throws Exception  {
		return TipoVisualConstantesFunciones.getTiposSeleccionarTipoVisual(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoVisual(Boolean conFk) throws Exception  {
		return TipoVisualConstantesFunciones.getTiposSeleccionarTipoVisual(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoVisual(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoVisualConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoVisualConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoVisualConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoVisualConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoVisual(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoVisual(TipoVisual tipovisualAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoVisual(List<TipoVisual> tipovisualsTemp) throws Exception {
		for(TipoVisual tipovisualAux:tipovisualsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoVisual(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoVisual(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoVisual(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoVisualConstantesFunciones.getClassesRelationshipsOfTipoVisual(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoVisual(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoVisual(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoVisualConstantesFunciones.getClassesRelationshipsFromStringsOfTipoVisual(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoVisual(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoVisual tipovisual,List<TipoVisual> tipovisuals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoVisual tipovisualEncontrado=null;
			
			for(TipoVisual tipovisualLocal:tipovisuals) {
				if(tipovisualLocal.getId().equals(tipovisual.getId())) {
					tipovisualEncontrado=tipovisualLocal;
					
					tipovisualLocal.setIsChanged(tipovisual.getIsChanged());
					tipovisualLocal.setIsNew(tipovisual.getIsNew());
					tipovisualLocal.setIsDeleted(tipovisual.getIsDeleted());
					
					tipovisualLocal.setGeneralEntityOriginal(tipovisual.getGeneralEntityOriginal());
					
					tipovisualLocal.setId(tipovisual.getId());	
					tipovisualLocal.setVersionRow(tipovisual.getVersionRow());	
					tipovisualLocal.setcodigo(tipovisual.getcodigo());	
					tipovisualLocal.setnombre(tipovisual.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipovisual.getIsDeleted()) {
				if(!existe) {
					tipovisuals.add(tipovisual);
				}
			} else {
				if(tipovisualEncontrado!=null && permiteQuitar)  {
					tipovisuals.remove(tipovisualEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoVisual tipovisual,List<TipoVisual> tipovisuals) throws Exception {
		try	{			
			for(TipoVisual tipovisualLocal:tipovisuals) {
				if(tipovisualLocal.getId().equals(tipovisual.getId())) {
					tipovisualLocal.setIsSelected(tipovisual.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoVisual(List<TipoVisual> tipovisualsAux) throws Exception {
		//this.tipovisualsAux=tipovisualsAux;
		
		for(TipoVisual tipovisualAux:tipovisualsAux) {
			if(tipovisualAux.getIsChanged()) {
				tipovisualAux.setIsChanged(false);
			}		
			
			if(tipovisualAux.getIsNew()) {
				tipovisualAux.setIsNew(false);
			}	
			
			if(tipovisualAux.getIsDeleted()) {
				tipovisualAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoVisual(TipoVisual tipovisualAux) throws Exception {
		//this.tipovisualAux=tipovisualAux;
		
			if(tipovisualAux.getIsChanged()) {
				tipovisualAux.setIsChanged(false);
			}		
			
			if(tipovisualAux.getIsNew()) {
				tipovisualAux.setIsNew(false);
			}	
			
			if(tipovisualAux.getIsDeleted()) {
				tipovisualAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoVisual tipovisualAsignar,TipoVisual tipovisual) throws Exception {
		tipovisualAsignar.setId(tipovisual.getId());	
		tipovisualAsignar.setVersionRow(tipovisual.getVersionRow());	
		tipovisualAsignar.setcodigo(tipovisual.getcodigo());	
		tipovisualAsignar.setnombre(tipovisual.getnombre());	
	}
	
	public static void inicializarTipoVisual(TipoVisual tipovisual) throws Exception {
		try {
				tipovisual.setId(0L);	
					
				tipovisual.setcodigo("");	
				tipovisual.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoVisual(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoVisualConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoVisualConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoVisual(String sTipo,Row row,Workbook workbook,TipoVisual tipovisual,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipovisual.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipovisual.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoVisual=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoVisual() {
		return this.sFinalQueryTipoVisual;
	}
	
	public void setsFinalQueryTipoVisual(String sFinalQueryTipoVisual) {
		this.sFinalQueryTipoVisual= sFinalQueryTipoVisual;
	}
	
	public Border resaltarSeleccionarTipoVisual=null;
	
	public Border setResaltarSeleccionarTipoVisual(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVisualBeanSwingJInternalFrame tipovisualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipovisualBeanSwingJInternalFrame.jTtoolBarTipoVisual.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoVisual= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoVisual() {
		return this.resaltarSeleccionarTipoVisual;
	}
	
	public void setResaltarSeleccionarTipoVisual(Border borderResaltarSeleccionarTipoVisual) {
		this.resaltarSeleccionarTipoVisual= borderResaltarSeleccionarTipoVisual;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoVisual=null;
	public Boolean mostraridTipoVisual=true;
	public Boolean activaridTipoVisual=true;

	public Border resaltarcodigoTipoVisual=null;
	public Boolean mostrarcodigoTipoVisual=true;
	public Boolean activarcodigoTipoVisual=true;

	public Border resaltarnombreTipoVisual=null;
	public Boolean mostrarnombreTipoVisual=true;
	public Boolean activarnombreTipoVisual=true;

	
	

	public Border setResaltaridTipoVisual(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVisualBeanSwingJInternalFrame tipovisualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipovisualBeanSwingJInternalFrame.jTtoolBarTipoVisual.setBorder(borderResaltar);
		
		this.resaltaridTipoVisual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoVisual() {
		return this.resaltaridTipoVisual;
	}

	public void setResaltaridTipoVisual(Border borderResaltar) {
		this.resaltaridTipoVisual= borderResaltar;
	}

	public Boolean getMostraridTipoVisual() {
		return this.mostraridTipoVisual;
	}

	public void setMostraridTipoVisual(Boolean mostraridTipoVisual) {
		this.mostraridTipoVisual= mostraridTipoVisual;
	}

	public Boolean getActivaridTipoVisual() {
		return this.activaridTipoVisual;
	}

	public void setActivaridTipoVisual(Boolean activaridTipoVisual) {
		this.activaridTipoVisual= activaridTipoVisual;
	}

	public Border setResaltarcodigoTipoVisual(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVisualBeanSwingJInternalFrame tipovisualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipovisualBeanSwingJInternalFrame.jTtoolBarTipoVisual.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoVisual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoVisual() {
		return this.resaltarcodigoTipoVisual;
	}

	public void setResaltarcodigoTipoVisual(Border borderResaltar) {
		this.resaltarcodigoTipoVisual= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoVisual() {
		return this.mostrarcodigoTipoVisual;
	}

	public void setMostrarcodigoTipoVisual(Boolean mostrarcodigoTipoVisual) {
		this.mostrarcodigoTipoVisual= mostrarcodigoTipoVisual;
	}

	public Boolean getActivarcodigoTipoVisual() {
		return this.activarcodigoTipoVisual;
	}

	public void setActivarcodigoTipoVisual(Boolean activarcodigoTipoVisual) {
		this.activarcodigoTipoVisual= activarcodigoTipoVisual;
	}

	public Border setResaltarnombreTipoVisual(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVisualBeanSwingJInternalFrame tipovisualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipovisualBeanSwingJInternalFrame.jTtoolBarTipoVisual.setBorder(borderResaltar);
		
		this.resaltarnombreTipoVisual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoVisual() {
		return this.resaltarnombreTipoVisual;
	}

	public void setResaltarnombreTipoVisual(Border borderResaltar) {
		this.resaltarnombreTipoVisual= borderResaltar;
	}

	public Boolean getMostrarnombreTipoVisual() {
		return this.mostrarnombreTipoVisual;
	}

	public void setMostrarnombreTipoVisual(Boolean mostrarnombreTipoVisual) {
		this.mostrarnombreTipoVisual= mostrarnombreTipoVisual;
	}

	public Boolean getActivarnombreTipoVisual() {
		return this.activarnombreTipoVisual;
	}

	public void setActivarnombreTipoVisual(Boolean activarnombreTipoVisual) {
		this.activarnombreTipoVisual= activarnombreTipoVisual;
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
		
		
		this.setMostraridTipoVisual(esInicial);
		this.setMostrarcodigoTipoVisual(esInicial);
		this.setMostrarnombreTipoVisual(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoVisualConstantesFunciones.ID)) {
				this.setMostraridTipoVisual(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVisualConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoVisual(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVisualConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoVisual(esAsigna);
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
		
		
		this.setActivaridTipoVisual(esInicial);
		this.setActivarcodigoTipoVisual(esInicial);
		this.setActivarnombreTipoVisual(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoVisualConstantesFunciones.ID)) {
				this.setActivaridTipoVisual(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVisualConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoVisual(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVisualConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoVisual(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoVisualBeanSwingJInternalFrame tipovisualBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoVisual(esInicial);
		this.setResaltarcodigoTipoVisual(esInicial);
		this.setResaltarnombreTipoVisual(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoVisualConstantesFunciones.ID)) {
				this.setResaltaridTipoVisual(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVisualConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoVisual(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVisualConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoVisual(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoVisualBeanSwingJInternalFrame tipovisualBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorNombreTipoVisual=true;

	public Boolean getMostrarBusquedaPorNombreTipoVisual() {
		return this.mostrarBusquedaPorNombreTipoVisual;
	}

	public void setMostrarBusquedaPorNombreTipoVisual(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoVisual= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreTipoVisual=true;

	public Boolean getActivarBusquedaPorNombreTipoVisual() {
		return this.activarBusquedaPorNombreTipoVisual;
	}

	public void setActivarBusquedaPorNombreTipoVisual(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoVisual= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreTipoVisual=null;

	public Border getResaltarBusquedaPorNombreTipoVisual() {
		return this.resaltarBusquedaPorNombreTipoVisual;
	}

	public void setResaltarBusquedaPorNombreTipoVisual(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoVisual= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoVisual(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVisualBeanSwingJInternalFrame tipovisualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoVisual= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}