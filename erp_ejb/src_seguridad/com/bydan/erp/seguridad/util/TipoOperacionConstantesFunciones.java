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


import com.bydan.erp.seguridad.util.TipoOperacionConstantesFunciones;
import com.bydan.erp.seguridad.util.TipoOperacionParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.TipoOperacionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;



import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoOperacionConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoOperacion";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoOperacion"+TipoOperacionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoOperacionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoOperacionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoOperacionConstantesFunciones.SCHEMA+"_"+TipoOperacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoOperacionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoOperacionConstantesFunciones.SCHEMA+"_"+TipoOperacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoOperacionConstantesFunciones.SCHEMA+"_"+TipoOperacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoOperacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoOperacionConstantesFunciones.SCHEMA+"_"+TipoOperacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoOperacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoOperacionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoOperacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoOperacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoOperacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoOperacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoOperacionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoOperacionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoOperacionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoOperacionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Operacions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Operacion";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Operacion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoOperacion";
	public static final String OBJECTNAME="tipooperacion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="tipo_operacion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipooperacion from "+TipoOperacionConstantesFunciones.SPERSISTENCENAME+" tipooperacion";
	public static String QUERYSELECTNATIVE="select "+TipoOperacionConstantesFunciones.SCHEMA+"."+TipoOperacionConstantesFunciones.TABLENAME+".id,"+TipoOperacionConstantesFunciones.SCHEMA+"."+TipoOperacionConstantesFunciones.TABLENAME+".version_row,"+TipoOperacionConstantesFunciones.SCHEMA+"."+TipoOperacionConstantesFunciones.TABLENAME+".codigo,"+TipoOperacionConstantesFunciones.SCHEMA+"."+TipoOperacionConstantesFunciones.TABLENAME+".nombre from "+TipoOperacionConstantesFunciones.SCHEMA+"."+TipoOperacionConstantesFunciones.TABLENAME;//+" as "+TipoOperacionConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoOperacionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoOperacionConstantesFunciones.CODIGO)) {sLabelColumna=TipoOperacionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoOperacionConstantesFunciones.NOMBRE)) {sLabelColumna=TipoOperacionConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoOperacionDescripcion(TipoOperacion tipooperacion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipooperacion !=null/* && tipooperacion.getId()!=0*/) {
			sDescripcion=tipooperacion.getcodigo();//tipooperaciontipooperacion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoOperacionDescripcionDetallado(TipoOperacion tipooperacion) {
		String sDescripcion="";
			
		sDescripcion+=TipoOperacionConstantesFunciones.ID+"=";
		sDescripcion+=tipooperacion.getId().toString()+",";
		sDescripcion+=TipoOperacionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipooperacion.getVersionRow().toString()+",";
		sDescripcion+=TipoOperacionConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipooperacion.getcodigo()+",";
		sDescripcion+=TipoOperacionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipooperacion.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoOperacionDescripcion(TipoOperacion tipooperacion,String sValor) throws Exception {			
		if(tipooperacion !=null) {
			tipooperacion.setcodigo(sValor);;//tipooperaciontipooperacion.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoOperacion(TipoOperacion tipooperacion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipooperacion.setcodigo(tipooperacion.getcodigo().trim());
		tipooperacion.setnombre(tipooperacion.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoOperacions(List<TipoOperacion> tipooperacions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoOperacion tipooperacion: tipooperacions) {
			tipooperacion.setcodigo(tipooperacion.getcodigo().trim());
			tipooperacion.setnombre(tipooperacion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoOperacion(TipoOperacion tipooperacion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipooperacion.getConCambioAuxiliar()) {
			tipooperacion.setIsDeleted(tipooperacion.getIsDeletedAuxiliar());	
			tipooperacion.setIsNew(tipooperacion.getIsNewAuxiliar());	
			tipooperacion.setIsChanged(tipooperacion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipooperacion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipooperacion.setIsDeletedAuxiliar(false);	
			tipooperacion.setIsNewAuxiliar(false);	
			tipooperacion.setIsChangedAuxiliar(false);
			
			tipooperacion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoOperacions(List<TipoOperacion> tipooperacions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoOperacion tipooperacion : tipooperacions) {
			if(conAsignarBase && tipooperacion.getConCambioAuxiliar()) {
				tipooperacion.setIsDeleted(tipooperacion.getIsDeletedAuxiliar());	
				tipooperacion.setIsNew(tipooperacion.getIsNewAuxiliar());	
				tipooperacion.setIsChanged(tipooperacion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipooperacion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipooperacion.setIsDeletedAuxiliar(false);	
				tipooperacion.setIsNewAuxiliar(false);	
				tipooperacion.setIsChangedAuxiliar(false);
				
				tipooperacion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoOperacion(TipoOperacion tipooperacion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoOperacions(List<TipoOperacion> tipooperacions,Boolean conEnteros) throws Exception  {
		
		for(TipoOperacion tipooperacion: tipooperacions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoOperacion(List<TipoOperacion> tipooperacions,TipoOperacion tipooperacionAux) throws Exception  {
		TipoOperacionConstantesFunciones.InicializarValoresTipoOperacion(tipooperacionAux,true);
		
		for(TipoOperacion tipooperacion: tipooperacions) {
			if(tipooperacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoOperacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoOperacionConstantesFunciones.getArrayColumnasGlobalesTipoOperacion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoOperacion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoOperacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoOperacion> tipooperacions,TipoOperacion tipooperacion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoOperacion tipooperacionAux: tipooperacions) {
			if(tipooperacionAux!=null && tipooperacion!=null) {
				if((tipooperacionAux.getId()==null && tipooperacion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipooperacionAux.getId()!=null && tipooperacion.getId()!=null){
					if(tipooperacionAux.getId().equals(tipooperacion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoOperacion(List<TipoOperacion> tipooperacions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoOperacion tipooperacion: tipooperacions) {			
			if(tipooperacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoOperacion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoOperacionConstantesFunciones.LABEL_ID, TipoOperacionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoOperacionConstantesFunciones.LABEL_VERSIONROW, TipoOperacionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoOperacionConstantesFunciones.LABEL_CODIGO, TipoOperacionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoOperacionConstantesFunciones.LABEL_NOMBRE, TipoOperacionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoOperacion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoOperacionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoOperacionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoOperacionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoOperacionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoOperacion() throws Exception  {
		return TipoOperacionConstantesFunciones.getTiposSeleccionarTipoOperacion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoOperacion(Boolean conFk) throws Exception  {
		return TipoOperacionConstantesFunciones.getTiposSeleccionarTipoOperacion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoOperacion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoOperacionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoOperacionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoOperacionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoOperacionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoOperacion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoOperacion(TipoOperacion tipooperacionAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoOperacion(List<TipoOperacion> tipooperacionsTemp) throws Exception {
		for(TipoOperacion tipooperacionAux:tipooperacionsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoOperacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoOperacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoOperacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoOperacionConstantesFunciones.getClassesRelationshipsOfTipoOperacion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoOperacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoOperacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoOperacionConstantesFunciones.getClassesRelationshipsFromStringsOfTipoOperacion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoOperacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoOperacion tipooperacion,List<TipoOperacion> tipooperacions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoOperacion tipooperacionEncontrado=null;
			
			for(TipoOperacion tipooperacionLocal:tipooperacions) {
				if(tipooperacionLocal.getId().equals(tipooperacion.getId())) {
					tipooperacionEncontrado=tipooperacionLocal;
					
					tipooperacionLocal.setIsChanged(tipooperacion.getIsChanged());
					tipooperacionLocal.setIsNew(tipooperacion.getIsNew());
					tipooperacionLocal.setIsDeleted(tipooperacion.getIsDeleted());
					
					tipooperacionLocal.setGeneralEntityOriginal(tipooperacion.getGeneralEntityOriginal());
					
					tipooperacionLocal.setId(tipooperacion.getId());	
					tipooperacionLocal.setVersionRow(tipooperacion.getVersionRow());	
					tipooperacionLocal.setcodigo(tipooperacion.getcodigo());	
					tipooperacionLocal.setnombre(tipooperacion.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipooperacion.getIsDeleted()) {
				if(!existe) {
					tipooperacions.add(tipooperacion);
				}
			} else {
				if(tipooperacionEncontrado!=null && permiteQuitar)  {
					tipooperacions.remove(tipooperacionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoOperacion tipooperacion,List<TipoOperacion> tipooperacions) throws Exception {
		try	{			
			for(TipoOperacion tipooperacionLocal:tipooperacions) {
				if(tipooperacionLocal.getId().equals(tipooperacion.getId())) {
					tipooperacionLocal.setIsSelected(tipooperacion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoOperacion(List<TipoOperacion> tipooperacionsAux) throws Exception {
		//this.tipooperacionsAux=tipooperacionsAux;
		
		for(TipoOperacion tipooperacionAux:tipooperacionsAux) {
			if(tipooperacionAux.getIsChanged()) {
				tipooperacionAux.setIsChanged(false);
			}		
			
			if(tipooperacionAux.getIsNew()) {
				tipooperacionAux.setIsNew(false);
			}	
			
			if(tipooperacionAux.getIsDeleted()) {
				tipooperacionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoOperacion(TipoOperacion tipooperacionAux) throws Exception {
		//this.tipooperacionAux=tipooperacionAux;
		
			if(tipooperacionAux.getIsChanged()) {
				tipooperacionAux.setIsChanged(false);
			}		
			
			if(tipooperacionAux.getIsNew()) {
				tipooperacionAux.setIsNew(false);
			}	
			
			if(tipooperacionAux.getIsDeleted()) {
				tipooperacionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoOperacion tipooperacionAsignar,TipoOperacion tipooperacion) throws Exception {
		tipooperacionAsignar.setId(tipooperacion.getId());	
		tipooperacionAsignar.setVersionRow(tipooperacion.getVersionRow());	
		tipooperacionAsignar.setcodigo(tipooperacion.getcodigo());	
		tipooperacionAsignar.setnombre(tipooperacion.getnombre());	
	}
	
	public static void inicializarTipoOperacion(TipoOperacion tipooperacion) throws Exception {
		try {
				tipooperacion.setId(0L);	
					
				tipooperacion.setcodigo("");	
				tipooperacion.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoOperacion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoOperacionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoOperacionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoOperacion(String sTipo,Row row,Workbook workbook,TipoOperacion tipooperacion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipooperacion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipooperacion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoOperacion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoOperacion() {
		return this.sFinalQueryTipoOperacion;
	}
	
	public void setsFinalQueryTipoOperacion(String sFinalQueryTipoOperacion) {
		this.sFinalQueryTipoOperacion= sFinalQueryTipoOperacion;
	}
	
	public Border resaltarSeleccionarTipoOperacion=null;
	
	public Border setResaltarSeleccionarTipoOperacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoOperacionBeanSwingJInternalFrame tipooperacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipooperacionBeanSwingJInternalFrame.jTtoolBarTipoOperacion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoOperacion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoOperacion() {
		return this.resaltarSeleccionarTipoOperacion;
	}
	
	public void setResaltarSeleccionarTipoOperacion(Border borderResaltarSeleccionarTipoOperacion) {
		this.resaltarSeleccionarTipoOperacion= borderResaltarSeleccionarTipoOperacion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoOperacion=null;
	public Boolean mostraridTipoOperacion=true;
	public Boolean activaridTipoOperacion=true;

	public Border resaltarcodigoTipoOperacion=null;
	public Boolean mostrarcodigoTipoOperacion=true;
	public Boolean activarcodigoTipoOperacion=true;

	public Border resaltarnombreTipoOperacion=null;
	public Boolean mostrarnombreTipoOperacion=true;
	public Boolean activarnombreTipoOperacion=true;

	
	

	public Border setResaltaridTipoOperacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoOperacionBeanSwingJInternalFrame tipooperacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipooperacionBeanSwingJInternalFrame.jTtoolBarTipoOperacion.setBorder(borderResaltar);
		
		this.resaltaridTipoOperacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoOperacion() {
		return this.resaltaridTipoOperacion;
	}

	public void setResaltaridTipoOperacion(Border borderResaltar) {
		this.resaltaridTipoOperacion= borderResaltar;
	}

	public Boolean getMostraridTipoOperacion() {
		return this.mostraridTipoOperacion;
	}

	public void setMostraridTipoOperacion(Boolean mostraridTipoOperacion) {
		this.mostraridTipoOperacion= mostraridTipoOperacion;
	}

	public Boolean getActivaridTipoOperacion() {
		return this.activaridTipoOperacion;
	}

	public void setActivaridTipoOperacion(Boolean activaridTipoOperacion) {
		this.activaridTipoOperacion= activaridTipoOperacion;
	}

	public Border setResaltarcodigoTipoOperacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoOperacionBeanSwingJInternalFrame tipooperacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipooperacionBeanSwingJInternalFrame.jTtoolBarTipoOperacion.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoOperacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoOperacion() {
		return this.resaltarcodigoTipoOperacion;
	}

	public void setResaltarcodigoTipoOperacion(Border borderResaltar) {
		this.resaltarcodigoTipoOperacion= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoOperacion() {
		return this.mostrarcodigoTipoOperacion;
	}

	public void setMostrarcodigoTipoOperacion(Boolean mostrarcodigoTipoOperacion) {
		this.mostrarcodigoTipoOperacion= mostrarcodigoTipoOperacion;
	}

	public Boolean getActivarcodigoTipoOperacion() {
		return this.activarcodigoTipoOperacion;
	}

	public void setActivarcodigoTipoOperacion(Boolean activarcodigoTipoOperacion) {
		this.activarcodigoTipoOperacion= activarcodigoTipoOperacion;
	}

	public Border setResaltarnombreTipoOperacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoOperacionBeanSwingJInternalFrame tipooperacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipooperacionBeanSwingJInternalFrame.jTtoolBarTipoOperacion.setBorder(borderResaltar);
		
		this.resaltarnombreTipoOperacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoOperacion() {
		return this.resaltarnombreTipoOperacion;
	}

	public void setResaltarnombreTipoOperacion(Border borderResaltar) {
		this.resaltarnombreTipoOperacion= borderResaltar;
	}

	public Boolean getMostrarnombreTipoOperacion() {
		return this.mostrarnombreTipoOperacion;
	}

	public void setMostrarnombreTipoOperacion(Boolean mostrarnombreTipoOperacion) {
		this.mostrarnombreTipoOperacion= mostrarnombreTipoOperacion;
	}

	public Boolean getActivarnombreTipoOperacion() {
		return this.activarnombreTipoOperacion;
	}

	public void setActivarnombreTipoOperacion(Boolean activarnombreTipoOperacion) {
		this.activarnombreTipoOperacion= activarnombreTipoOperacion;
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
		
		
		this.setMostraridTipoOperacion(esInicial);
		this.setMostrarcodigoTipoOperacion(esInicial);
		this.setMostrarnombreTipoOperacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoOperacionConstantesFunciones.ID)) {
				this.setMostraridTipoOperacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoOperacionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoOperacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoOperacionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoOperacion(esAsigna);
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
		
		
		this.setActivaridTipoOperacion(esInicial);
		this.setActivarcodigoTipoOperacion(esInicial);
		this.setActivarnombreTipoOperacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoOperacionConstantesFunciones.ID)) {
				this.setActivaridTipoOperacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoOperacionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoOperacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoOperacionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoOperacion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoOperacionBeanSwingJInternalFrame tipooperacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoOperacion(esInicial);
		this.setResaltarcodigoTipoOperacion(esInicial);
		this.setResaltarnombreTipoOperacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoOperacionConstantesFunciones.ID)) {
				this.setResaltaridTipoOperacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoOperacionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoOperacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoOperacionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoOperacion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoOperacionBeanSwingJInternalFrame tipooperacionBeanSwingJInternalFrame*/)throws Exception {	
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