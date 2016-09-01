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


import com.bydan.erp.seguridad.util.TipoImagenConstantesFunciones;
import com.bydan.erp.seguridad.util.TipoImagenParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.TipoImagenParameterGeneral;

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
final public class TipoImagenConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoImagen";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoImagen"+TipoImagenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoImagenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoImagenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoImagenConstantesFunciones.SCHEMA+"_"+TipoImagenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoImagenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoImagenConstantesFunciones.SCHEMA+"_"+TipoImagenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoImagenConstantesFunciones.SCHEMA+"_"+TipoImagenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoImagenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoImagenConstantesFunciones.SCHEMA+"_"+TipoImagenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoImagenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoImagenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoImagenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoImagenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoImagenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoImagenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoImagenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoImagenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoImagenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoImagenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Imagens";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Imagen";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Imagen";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoImagen";
	public static final String OBJECTNAME="tipoimagen";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="tipo_imagen";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoimagen from "+TipoImagenConstantesFunciones.SPERSISTENCENAME+" tipoimagen";
	public static String QUERYSELECTNATIVE="select "+TipoImagenConstantesFunciones.SCHEMA+"."+TipoImagenConstantesFunciones.TABLENAME+".id,"+TipoImagenConstantesFunciones.SCHEMA+"."+TipoImagenConstantesFunciones.TABLENAME+".version_row,"+TipoImagenConstantesFunciones.SCHEMA+"."+TipoImagenConstantesFunciones.TABLENAME+".codigo,"+TipoImagenConstantesFunciones.SCHEMA+"."+TipoImagenConstantesFunciones.TABLENAME+".nombre from "+TipoImagenConstantesFunciones.SCHEMA+"."+TipoImagenConstantesFunciones.TABLENAME;//+" as "+TipoImagenConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoImagenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoImagenConstantesFunciones.CODIGO)) {sLabelColumna=TipoImagenConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoImagenConstantesFunciones.NOMBRE)) {sLabelColumna=TipoImagenConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoImagenDescripcion(TipoImagen tipoimagen) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoimagen !=null/* && tipoimagen.getId()!=0*/) {
			sDescripcion=tipoimagen.getcodigo();//tipoimagentipoimagen.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoImagenDescripcionDetallado(TipoImagen tipoimagen) {
		String sDescripcion="";
			
		sDescripcion+=TipoImagenConstantesFunciones.ID+"=";
		sDescripcion+=tipoimagen.getId().toString()+",";
		sDescripcion+=TipoImagenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoimagen.getVersionRow().toString()+",";
		sDescripcion+=TipoImagenConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoimagen.getcodigo()+",";
		sDescripcion+=TipoImagenConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoimagen.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoImagenDescripcion(TipoImagen tipoimagen,String sValor) throws Exception {			
		if(tipoimagen !=null) {
			tipoimagen.setcodigo(sValor);;//tipoimagentipoimagen.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoImagen(TipoImagen tipoimagen,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoimagen.setcodigo(tipoimagen.getcodigo().trim());
		tipoimagen.setnombre(tipoimagen.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoImagens(List<TipoImagen> tipoimagens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoImagen tipoimagen: tipoimagens) {
			tipoimagen.setcodigo(tipoimagen.getcodigo().trim());
			tipoimagen.setnombre(tipoimagen.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoImagen(TipoImagen tipoimagen,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoimagen.getConCambioAuxiliar()) {
			tipoimagen.setIsDeleted(tipoimagen.getIsDeletedAuxiliar());	
			tipoimagen.setIsNew(tipoimagen.getIsNewAuxiliar());	
			tipoimagen.setIsChanged(tipoimagen.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoimagen.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoimagen.setIsDeletedAuxiliar(false);	
			tipoimagen.setIsNewAuxiliar(false);	
			tipoimagen.setIsChangedAuxiliar(false);
			
			tipoimagen.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoImagens(List<TipoImagen> tipoimagens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoImagen tipoimagen : tipoimagens) {
			if(conAsignarBase && tipoimagen.getConCambioAuxiliar()) {
				tipoimagen.setIsDeleted(tipoimagen.getIsDeletedAuxiliar());	
				tipoimagen.setIsNew(tipoimagen.getIsNewAuxiliar());	
				tipoimagen.setIsChanged(tipoimagen.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoimagen.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoimagen.setIsDeletedAuxiliar(false);	
				tipoimagen.setIsNewAuxiliar(false);	
				tipoimagen.setIsChangedAuxiliar(false);
				
				tipoimagen.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoImagen(TipoImagen tipoimagen,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoImagens(List<TipoImagen> tipoimagens,Boolean conEnteros) throws Exception  {
		
		for(TipoImagen tipoimagen: tipoimagens) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoImagen(List<TipoImagen> tipoimagens,TipoImagen tipoimagenAux) throws Exception  {
		TipoImagenConstantesFunciones.InicializarValoresTipoImagen(tipoimagenAux,true);
		
		for(TipoImagen tipoimagen: tipoimagens) {
			if(tipoimagen.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoImagen(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoImagenConstantesFunciones.getArrayColumnasGlobalesTipoImagen(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoImagen(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoImagen(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoImagen> tipoimagens,TipoImagen tipoimagen,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoImagen tipoimagenAux: tipoimagens) {
			if(tipoimagenAux!=null && tipoimagen!=null) {
				if((tipoimagenAux.getId()==null && tipoimagen.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoimagenAux.getId()!=null && tipoimagen.getId()!=null){
					if(tipoimagenAux.getId().equals(tipoimagen.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoImagen(List<TipoImagen> tipoimagens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoImagen tipoimagen: tipoimagens) {			
			if(tipoimagen.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoImagen() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoImagenConstantesFunciones.LABEL_ID, TipoImagenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoImagenConstantesFunciones.LABEL_VERSIONROW, TipoImagenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoImagenConstantesFunciones.LABEL_CODIGO, TipoImagenConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoImagenConstantesFunciones.LABEL_NOMBRE, TipoImagenConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoImagen() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoImagenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoImagenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoImagenConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoImagenConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoImagen() throws Exception  {
		return TipoImagenConstantesFunciones.getTiposSeleccionarTipoImagen(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoImagen(Boolean conFk) throws Exception  {
		return TipoImagenConstantesFunciones.getTiposSeleccionarTipoImagen(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoImagen(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoImagenConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoImagenConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoImagenConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoImagenConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoImagen(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoImagen(TipoImagen tipoimagenAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoImagen(List<TipoImagen> tipoimagensTemp) throws Exception {
		for(TipoImagen tipoimagenAux:tipoimagensTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoImagen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoImagen(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoImagen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoImagenConstantesFunciones.getClassesRelationshipsOfTipoImagen(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoImagen(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoImagen(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoImagenConstantesFunciones.getClassesRelationshipsFromStringsOfTipoImagen(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoImagen(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoImagen tipoimagen,List<TipoImagen> tipoimagens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoImagen tipoimagenEncontrado=null;
			
			for(TipoImagen tipoimagenLocal:tipoimagens) {
				if(tipoimagenLocal.getId().equals(tipoimagen.getId())) {
					tipoimagenEncontrado=tipoimagenLocal;
					
					tipoimagenLocal.setIsChanged(tipoimagen.getIsChanged());
					tipoimagenLocal.setIsNew(tipoimagen.getIsNew());
					tipoimagenLocal.setIsDeleted(tipoimagen.getIsDeleted());
					
					tipoimagenLocal.setGeneralEntityOriginal(tipoimagen.getGeneralEntityOriginal());
					
					tipoimagenLocal.setId(tipoimagen.getId());	
					tipoimagenLocal.setVersionRow(tipoimagen.getVersionRow());	
					tipoimagenLocal.setcodigo(tipoimagen.getcodigo());	
					tipoimagenLocal.setnombre(tipoimagen.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoimagen.getIsDeleted()) {
				if(!existe) {
					tipoimagens.add(tipoimagen);
				}
			} else {
				if(tipoimagenEncontrado!=null && permiteQuitar)  {
					tipoimagens.remove(tipoimagenEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoImagen tipoimagen,List<TipoImagen> tipoimagens) throws Exception {
		try	{			
			for(TipoImagen tipoimagenLocal:tipoimagens) {
				if(tipoimagenLocal.getId().equals(tipoimagen.getId())) {
					tipoimagenLocal.setIsSelected(tipoimagen.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoImagen(List<TipoImagen> tipoimagensAux) throws Exception {
		//this.tipoimagensAux=tipoimagensAux;
		
		for(TipoImagen tipoimagenAux:tipoimagensAux) {
			if(tipoimagenAux.getIsChanged()) {
				tipoimagenAux.setIsChanged(false);
			}		
			
			if(tipoimagenAux.getIsNew()) {
				tipoimagenAux.setIsNew(false);
			}	
			
			if(tipoimagenAux.getIsDeleted()) {
				tipoimagenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoImagen(TipoImagen tipoimagenAux) throws Exception {
		//this.tipoimagenAux=tipoimagenAux;
		
			if(tipoimagenAux.getIsChanged()) {
				tipoimagenAux.setIsChanged(false);
			}		
			
			if(tipoimagenAux.getIsNew()) {
				tipoimagenAux.setIsNew(false);
			}	
			
			if(tipoimagenAux.getIsDeleted()) {
				tipoimagenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoImagen tipoimagenAsignar,TipoImagen tipoimagen) throws Exception {
		tipoimagenAsignar.setId(tipoimagen.getId());	
		tipoimagenAsignar.setVersionRow(tipoimagen.getVersionRow());	
		tipoimagenAsignar.setcodigo(tipoimagen.getcodigo());	
		tipoimagenAsignar.setnombre(tipoimagen.getnombre());	
	}
	
	public static void inicializarTipoImagen(TipoImagen tipoimagen) throws Exception {
		try {
				tipoimagen.setId(0L);	
					
				tipoimagen.setcodigo("");	
				tipoimagen.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoImagen(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoImagenConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoImagenConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoImagen(String sTipo,Row row,Workbook workbook,TipoImagen tipoimagen,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoimagen.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoimagen.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoImagen=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoImagen() {
		return this.sFinalQueryTipoImagen;
	}
	
	public void setsFinalQueryTipoImagen(String sFinalQueryTipoImagen) {
		this.sFinalQueryTipoImagen= sFinalQueryTipoImagen;
	}
	
	public Border resaltarSeleccionarTipoImagen=null;
	
	public Border setResaltarSeleccionarTipoImagen(ParametroGeneralUsuario parametroGeneralUsuario/*TipoImagenBeanSwingJInternalFrame tipoimagenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoimagenBeanSwingJInternalFrame.jTtoolBarTipoImagen.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoImagen= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoImagen() {
		return this.resaltarSeleccionarTipoImagen;
	}
	
	public void setResaltarSeleccionarTipoImagen(Border borderResaltarSeleccionarTipoImagen) {
		this.resaltarSeleccionarTipoImagen= borderResaltarSeleccionarTipoImagen;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoImagen=null;
	public Boolean mostraridTipoImagen=true;
	public Boolean activaridTipoImagen=true;

	public Border resaltarcodigoTipoImagen=null;
	public Boolean mostrarcodigoTipoImagen=true;
	public Boolean activarcodigoTipoImagen=true;

	public Border resaltarnombreTipoImagen=null;
	public Boolean mostrarnombreTipoImagen=true;
	public Boolean activarnombreTipoImagen=true;

	
	

	public Border setResaltaridTipoImagen(ParametroGeneralUsuario parametroGeneralUsuario/*TipoImagenBeanSwingJInternalFrame tipoimagenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoimagenBeanSwingJInternalFrame.jTtoolBarTipoImagen.setBorder(borderResaltar);
		
		this.resaltaridTipoImagen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoImagen() {
		return this.resaltaridTipoImagen;
	}

	public void setResaltaridTipoImagen(Border borderResaltar) {
		this.resaltaridTipoImagen= borderResaltar;
	}

	public Boolean getMostraridTipoImagen() {
		return this.mostraridTipoImagen;
	}

	public void setMostraridTipoImagen(Boolean mostraridTipoImagen) {
		this.mostraridTipoImagen= mostraridTipoImagen;
	}

	public Boolean getActivaridTipoImagen() {
		return this.activaridTipoImagen;
	}

	public void setActivaridTipoImagen(Boolean activaridTipoImagen) {
		this.activaridTipoImagen= activaridTipoImagen;
	}

	public Border setResaltarcodigoTipoImagen(ParametroGeneralUsuario parametroGeneralUsuario/*TipoImagenBeanSwingJInternalFrame tipoimagenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoimagenBeanSwingJInternalFrame.jTtoolBarTipoImagen.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoImagen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoImagen() {
		return this.resaltarcodigoTipoImagen;
	}

	public void setResaltarcodigoTipoImagen(Border borderResaltar) {
		this.resaltarcodigoTipoImagen= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoImagen() {
		return this.mostrarcodigoTipoImagen;
	}

	public void setMostrarcodigoTipoImagen(Boolean mostrarcodigoTipoImagen) {
		this.mostrarcodigoTipoImagen= mostrarcodigoTipoImagen;
	}

	public Boolean getActivarcodigoTipoImagen() {
		return this.activarcodigoTipoImagen;
	}

	public void setActivarcodigoTipoImagen(Boolean activarcodigoTipoImagen) {
		this.activarcodigoTipoImagen= activarcodigoTipoImagen;
	}

	public Border setResaltarnombreTipoImagen(ParametroGeneralUsuario parametroGeneralUsuario/*TipoImagenBeanSwingJInternalFrame tipoimagenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoimagenBeanSwingJInternalFrame.jTtoolBarTipoImagen.setBorder(borderResaltar);
		
		this.resaltarnombreTipoImagen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoImagen() {
		return this.resaltarnombreTipoImagen;
	}

	public void setResaltarnombreTipoImagen(Border borderResaltar) {
		this.resaltarnombreTipoImagen= borderResaltar;
	}

	public Boolean getMostrarnombreTipoImagen() {
		return this.mostrarnombreTipoImagen;
	}

	public void setMostrarnombreTipoImagen(Boolean mostrarnombreTipoImagen) {
		this.mostrarnombreTipoImagen= mostrarnombreTipoImagen;
	}

	public Boolean getActivarnombreTipoImagen() {
		return this.activarnombreTipoImagen;
	}

	public void setActivarnombreTipoImagen(Boolean activarnombreTipoImagen) {
		this.activarnombreTipoImagen= activarnombreTipoImagen;
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
		
		
		this.setMostraridTipoImagen(esInicial);
		this.setMostrarcodigoTipoImagen(esInicial);
		this.setMostrarnombreTipoImagen(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoImagenConstantesFunciones.ID)) {
				this.setMostraridTipoImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoImagenConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoImagenConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoImagen(esAsigna);
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
		
		
		this.setActivaridTipoImagen(esInicial);
		this.setActivarcodigoTipoImagen(esInicial);
		this.setActivarnombreTipoImagen(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoImagenConstantesFunciones.ID)) {
				this.setActivaridTipoImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoImagenConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoImagenConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoImagen(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoImagenBeanSwingJInternalFrame tipoimagenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoImagen(esInicial);
		this.setResaltarcodigoTipoImagen(esInicial);
		this.setResaltarnombreTipoImagen(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoImagenConstantesFunciones.ID)) {
				this.setResaltaridTipoImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoImagenConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoImagenConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoImagen(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoImagenBeanSwingJInternalFrame tipoimagenBeanSwingJInternalFrame*/)throws Exception {	
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