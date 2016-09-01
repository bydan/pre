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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.TipoDefinicionConstantesFunciones;
import com.bydan.erp.inventario.util.TipoDefinicionParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoDefinicionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoDefinicionConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoDefinicion";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoDefinicion"+TipoDefinicionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoDefinicionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoDefinicionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoDefinicionConstantesFunciones.SCHEMA+"_"+TipoDefinicionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoDefinicionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoDefinicionConstantesFunciones.SCHEMA+"_"+TipoDefinicionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoDefinicionConstantesFunciones.SCHEMA+"_"+TipoDefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoDefinicionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoDefinicionConstantesFunciones.SCHEMA+"_"+TipoDefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDefinicionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDefinicionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoDefinicionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoDefinicionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoDefinicionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoDefinicionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Definiciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Definicion";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Definicion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoDefinicion";
	public static final String OBJECTNAME="tipodefinicion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="tipo_definicion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipodefinicion from "+TipoDefinicionConstantesFunciones.SPERSISTENCENAME+" tipodefinicion";
	public static String QUERYSELECTNATIVE="select "+TipoDefinicionConstantesFunciones.SCHEMA+"."+TipoDefinicionConstantesFunciones.TABLENAME+".id,"+TipoDefinicionConstantesFunciones.SCHEMA+"."+TipoDefinicionConstantesFunciones.TABLENAME+".version_row,"+TipoDefinicionConstantesFunciones.SCHEMA+"."+TipoDefinicionConstantesFunciones.TABLENAME+".codigo,"+TipoDefinicionConstantesFunciones.SCHEMA+"."+TipoDefinicionConstantesFunciones.TABLENAME+".nombre from "+TipoDefinicionConstantesFunciones.SCHEMA+"."+TipoDefinicionConstantesFunciones.TABLENAME;//+" as "+TipoDefinicionConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoDefinicionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoDefinicionConstantesFunciones.CODIGO)) {sLabelColumna=TipoDefinicionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoDefinicionConstantesFunciones.NOMBRE)) {sLabelColumna=TipoDefinicionConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoDefinicionDescripcion(TipoDefinicion tipodefinicion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipodefinicion !=null/* && tipodefinicion.getId()!=0*/) {
			sDescripcion=tipodefinicion.getcodigo();//tipodefiniciontipodefinicion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoDefinicionDescripcionDetallado(TipoDefinicion tipodefinicion) {
		String sDescripcion="";
			
		sDescripcion+=TipoDefinicionConstantesFunciones.ID+"=";
		sDescripcion+=tipodefinicion.getId().toString()+",";
		sDescripcion+=TipoDefinicionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipodefinicion.getVersionRow().toString()+",";
		sDescripcion+=TipoDefinicionConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipodefinicion.getcodigo()+",";
		sDescripcion+=TipoDefinicionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipodefinicion.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoDefinicionDescripcion(TipoDefinicion tipodefinicion,String sValor) throws Exception {			
		if(tipodefinicion !=null) {
			tipodefinicion.setcodigo(sValor);;//tipodefiniciontipodefinicion.getcodigo().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoDefinicion(TipoDefinicion tipodefinicion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipodefinicion.setcodigo(tipodefinicion.getcodigo().trim());
		tipodefinicion.setnombre(tipodefinicion.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoDefinicions(List<TipoDefinicion> tipodefinicions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoDefinicion tipodefinicion: tipodefinicions) {
			tipodefinicion.setcodigo(tipodefinicion.getcodigo().trim());
			tipodefinicion.setnombre(tipodefinicion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDefinicion(TipoDefinicion tipodefinicion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipodefinicion.getConCambioAuxiliar()) {
			tipodefinicion.setIsDeleted(tipodefinicion.getIsDeletedAuxiliar());	
			tipodefinicion.setIsNew(tipodefinicion.getIsNewAuxiliar());	
			tipodefinicion.setIsChanged(tipodefinicion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipodefinicion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipodefinicion.setIsDeletedAuxiliar(false);	
			tipodefinicion.setIsNewAuxiliar(false);	
			tipodefinicion.setIsChangedAuxiliar(false);
			
			tipodefinicion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDefinicions(List<TipoDefinicion> tipodefinicions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoDefinicion tipodefinicion : tipodefinicions) {
			if(conAsignarBase && tipodefinicion.getConCambioAuxiliar()) {
				tipodefinicion.setIsDeleted(tipodefinicion.getIsDeletedAuxiliar());	
				tipodefinicion.setIsNew(tipodefinicion.getIsNewAuxiliar());	
				tipodefinicion.setIsChanged(tipodefinicion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipodefinicion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipodefinicion.setIsDeletedAuxiliar(false);	
				tipodefinicion.setIsNewAuxiliar(false);	
				tipodefinicion.setIsChangedAuxiliar(false);
				
				tipodefinicion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoDefinicion(TipoDefinicion tipodefinicion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoDefinicions(List<TipoDefinicion> tipodefinicions,Boolean conEnteros) throws Exception  {
		
		for(TipoDefinicion tipodefinicion: tipodefinicions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoDefinicion(List<TipoDefinicion> tipodefinicions,TipoDefinicion tipodefinicionAux) throws Exception  {
		TipoDefinicionConstantesFunciones.InicializarValoresTipoDefinicion(tipodefinicionAux,true);
		
		for(TipoDefinicion tipodefinicion: tipodefinicions) {
			if(tipodefinicion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDefinicion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoDefinicionConstantesFunciones.getArrayColumnasGlobalesTipoDefinicion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDefinicion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoDefinicion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoDefinicion> tipodefinicions,TipoDefinicion tipodefinicion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoDefinicion tipodefinicionAux: tipodefinicions) {
			if(tipodefinicionAux!=null && tipodefinicion!=null) {
				if((tipodefinicionAux.getId()==null && tipodefinicion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipodefinicionAux.getId()!=null && tipodefinicion.getId()!=null){
					if(tipodefinicionAux.getId().equals(tipodefinicion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoDefinicion(List<TipoDefinicion> tipodefinicions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoDefinicion tipodefinicion: tipodefinicions) {			
			if(tipodefinicion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoDefinicion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoDefinicionConstantesFunciones.LABEL_ID, TipoDefinicionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDefinicionConstantesFunciones.LABEL_VERSIONROW, TipoDefinicionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDefinicionConstantesFunciones.LABEL_CODIGO, TipoDefinicionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDefinicionConstantesFunciones.LABEL_NOMBRE, TipoDefinicionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoDefinicion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoDefinicionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDefinicionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDefinicionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDefinicionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDefinicion() throws Exception  {
		return TipoDefinicionConstantesFunciones.getTiposSeleccionarTipoDefinicion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDefinicion(Boolean conFk) throws Exception  {
		return TipoDefinicionConstantesFunciones.getTiposSeleccionarTipoDefinicion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDefinicion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDefinicionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoDefinicionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDefinicionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoDefinicionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoDefinicion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDefinicion(TipoDefinicion tipodefinicionAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDefinicion(List<TipoDefinicion> tipodefinicionsTemp) throws Exception {
		for(TipoDefinicion tipodefinicionAux:tipodefinicionsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDefinicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoDefinicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDefinicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDefinicionConstantesFunciones.getClassesRelationshipsOfTipoDefinicion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDefinicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Definicion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Definicion.class)) {
						classes.add(new Classe(Definicion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDefinicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDefinicionConstantesFunciones.getClassesRelationshipsFromStringsOfTipoDefinicion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDefinicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Definicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Definicion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Definicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Definicion.class)); continue;
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
	public static void actualizarLista(TipoDefinicion tipodefinicion,List<TipoDefinicion> tipodefinicions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoDefinicion tipodefinicionEncontrado=null;
			
			for(TipoDefinicion tipodefinicionLocal:tipodefinicions) {
				if(tipodefinicionLocal.getId().equals(tipodefinicion.getId())) {
					tipodefinicionEncontrado=tipodefinicionLocal;
					
					tipodefinicionLocal.setIsChanged(tipodefinicion.getIsChanged());
					tipodefinicionLocal.setIsNew(tipodefinicion.getIsNew());
					tipodefinicionLocal.setIsDeleted(tipodefinicion.getIsDeleted());
					
					tipodefinicionLocal.setGeneralEntityOriginal(tipodefinicion.getGeneralEntityOriginal());
					
					tipodefinicionLocal.setId(tipodefinicion.getId());	
					tipodefinicionLocal.setVersionRow(tipodefinicion.getVersionRow());	
					tipodefinicionLocal.setcodigo(tipodefinicion.getcodigo());	
					tipodefinicionLocal.setnombre(tipodefinicion.getnombre());	
					
					
					tipodefinicionLocal.setDefinicions(tipodefinicion.getDefinicions());
					
					existe=true;
					break;
				}
			}
			
			if(!tipodefinicion.getIsDeleted()) {
				if(!existe) {
					tipodefinicions.add(tipodefinicion);
				}
			} else {
				if(tipodefinicionEncontrado!=null && permiteQuitar)  {
					tipodefinicions.remove(tipodefinicionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoDefinicion tipodefinicion,List<TipoDefinicion> tipodefinicions) throws Exception {
		try	{			
			for(TipoDefinicion tipodefinicionLocal:tipodefinicions) {
				if(tipodefinicionLocal.getId().equals(tipodefinicion.getId())) {
					tipodefinicionLocal.setIsSelected(tipodefinicion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoDefinicion(List<TipoDefinicion> tipodefinicionsAux) throws Exception {
		//this.tipodefinicionsAux=tipodefinicionsAux;
		
		for(TipoDefinicion tipodefinicionAux:tipodefinicionsAux) {
			if(tipodefinicionAux.getIsChanged()) {
				tipodefinicionAux.setIsChanged(false);
			}		
			
			if(tipodefinicionAux.getIsNew()) {
				tipodefinicionAux.setIsNew(false);
			}	
			
			if(tipodefinicionAux.getIsDeleted()) {
				tipodefinicionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoDefinicion(TipoDefinicion tipodefinicionAux) throws Exception {
		//this.tipodefinicionAux=tipodefinicionAux;
		
			if(tipodefinicionAux.getIsChanged()) {
				tipodefinicionAux.setIsChanged(false);
			}		
			
			if(tipodefinicionAux.getIsNew()) {
				tipodefinicionAux.setIsNew(false);
			}	
			
			if(tipodefinicionAux.getIsDeleted()) {
				tipodefinicionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoDefinicion tipodefinicionAsignar,TipoDefinicion tipodefinicion) throws Exception {
		tipodefinicionAsignar.setId(tipodefinicion.getId());	
		tipodefinicionAsignar.setVersionRow(tipodefinicion.getVersionRow());	
		tipodefinicionAsignar.setcodigo(tipodefinicion.getcodigo());	
		tipodefinicionAsignar.setnombre(tipodefinicion.getnombre());	
	}
	
	public static void inicializarTipoDefinicion(TipoDefinicion tipodefinicion) throws Exception {
		try {
				tipodefinicion.setId(0L);	
					
				tipodefinicion.setcodigo("");	
				tipodefinicion.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoDefinicion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDefinicionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDefinicionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoDefinicion(String sTipo,Row row,Workbook workbook,TipoDefinicion tipodefinicion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodefinicion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodefinicion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoDefinicion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoDefinicion() {
		return this.sFinalQueryTipoDefinicion;
	}
	
	public void setsFinalQueryTipoDefinicion(String sFinalQueryTipoDefinicion) {
		this.sFinalQueryTipoDefinicion= sFinalQueryTipoDefinicion;
	}
	
	public Border resaltarSeleccionarTipoDefinicion=null;
	
	public Border setResaltarSeleccionarTipoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDefinicionBeanSwingJInternalFrame tipodefinicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipodefinicionBeanSwingJInternalFrame.jTtoolBarTipoDefinicion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoDefinicion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoDefinicion() {
		return this.resaltarSeleccionarTipoDefinicion;
	}
	
	public void setResaltarSeleccionarTipoDefinicion(Border borderResaltarSeleccionarTipoDefinicion) {
		this.resaltarSeleccionarTipoDefinicion= borderResaltarSeleccionarTipoDefinicion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoDefinicion=null;
	public Boolean mostraridTipoDefinicion=true;
	public Boolean activaridTipoDefinicion=true;

	public Border resaltarcodigoTipoDefinicion=null;
	public Boolean mostrarcodigoTipoDefinicion=true;
	public Boolean activarcodigoTipoDefinicion=true;

	public Border resaltarnombreTipoDefinicion=null;
	public Boolean mostrarnombreTipoDefinicion=true;
	public Boolean activarnombreTipoDefinicion=true;

	
	

	public Border setResaltaridTipoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDefinicionBeanSwingJInternalFrame tipodefinicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodefinicionBeanSwingJInternalFrame.jTtoolBarTipoDefinicion.setBorder(borderResaltar);
		
		this.resaltaridTipoDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoDefinicion() {
		return this.resaltaridTipoDefinicion;
	}

	public void setResaltaridTipoDefinicion(Border borderResaltar) {
		this.resaltaridTipoDefinicion= borderResaltar;
	}

	public Boolean getMostraridTipoDefinicion() {
		return this.mostraridTipoDefinicion;
	}

	public void setMostraridTipoDefinicion(Boolean mostraridTipoDefinicion) {
		this.mostraridTipoDefinicion= mostraridTipoDefinicion;
	}

	public Boolean getActivaridTipoDefinicion() {
		return this.activaridTipoDefinicion;
	}

	public void setActivaridTipoDefinicion(Boolean activaridTipoDefinicion) {
		this.activaridTipoDefinicion= activaridTipoDefinicion;
	}

	public Border setResaltarcodigoTipoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDefinicionBeanSwingJInternalFrame tipodefinicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodefinicionBeanSwingJInternalFrame.jTtoolBarTipoDefinicion.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoDefinicion() {
		return this.resaltarcodigoTipoDefinicion;
	}

	public void setResaltarcodigoTipoDefinicion(Border borderResaltar) {
		this.resaltarcodigoTipoDefinicion= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoDefinicion() {
		return this.mostrarcodigoTipoDefinicion;
	}

	public void setMostrarcodigoTipoDefinicion(Boolean mostrarcodigoTipoDefinicion) {
		this.mostrarcodigoTipoDefinicion= mostrarcodigoTipoDefinicion;
	}

	public Boolean getActivarcodigoTipoDefinicion() {
		return this.activarcodigoTipoDefinicion;
	}

	public void setActivarcodigoTipoDefinicion(Boolean activarcodigoTipoDefinicion) {
		this.activarcodigoTipoDefinicion= activarcodigoTipoDefinicion;
	}

	public Border setResaltarnombreTipoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDefinicionBeanSwingJInternalFrame tipodefinicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodefinicionBeanSwingJInternalFrame.jTtoolBarTipoDefinicion.setBorder(borderResaltar);
		
		this.resaltarnombreTipoDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoDefinicion() {
		return this.resaltarnombreTipoDefinicion;
	}

	public void setResaltarnombreTipoDefinicion(Border borderResaltar) {
		this.resaltarnombreTipoDefinicion= borderResaltar;
	}

	public Boolean getMostrarnombreTipoDefinicion() {
		return this.mostrarnombreTipoDefinicion;
	}

	public void setMostrarnombreTipoDefinicion(Boolean mostrarnombreTipoDefinicion) {
		this.mostrarnombreTipoDefinicion= mostrarnombreTipoDefinicion;
	}

	public Boolean getActivarnombreTipoDefinicion() {
		return this.activarnombreTipoDefinicion;
	}

	public void setActivarnombreTipoDefinicion(Boolean activarnombreTipoDefinicion) {
		this.activarnombreTipoDefinicion= activarnombreTipoDefinicion;
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
		
		
		this.setMostraridTipoDefinicion(esInicial);
		this.setMostrarcodigoTipoDefinicion(esInicial);
		this.setMostrarnombreTipoDefinicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDefinicionConstantesFunciones.ID)) {
				this.setMostraridTipoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDefinicionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDefinicionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoDefinicion(esAsigna);
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
		
		
		this.setActivaridTipoDefinicion(esInicial);
		this.setActivarcodigoTipoDefinicion(esInicial);
		this.setActivarnombreTipoDefinicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDefinicionConstantesFunciones.ID)) {
				this.setActivaridTipoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDefinicionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDefinicionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoDefinicion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDefinicionBeanSwingJInternalFrame tipodefinicionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoDefinicion(esInicial);
		this.setResaltarcodigoTipoDefinicion(esInicial);
		this.setResaltarnombreTipoDefinicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDefinicionConstantesFunciones.ID)) {
				this.setResaltaridTipoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDefinicionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDefinicionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoDefinicion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDefinicionTipoDefinicion=null;

	public Border getResaltarDefinicionTipoDefinicion() {
		return this.resaltarDefinicionTipoDefinicion;
	}

	public void setResaltarDefinicionTipoDefinicion(Border borderResaltarDefinicion) {
		if(borderResaltarDefinicion!=null) {
			this.resaltarDefinicionTipoDefinicion= borderResaltarDefinicion;
		}
	}

	public Border setResaltarDefinicionTipoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDefinicionBeanSwingJInternalFrame tipodefinicionBeanSwingJInternalFrame*/) {
		Border borderResaltarDefinicion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipodefinicionBeanSwingJInternalFrame.jTtoolBarTipoDefinicion.setBorder(borderResaltarDefinicion);
			
		this.resaltarDefinicionTipoDefinicion= borderResaltarDefinicion;

		 return borderResaltarDefinicion;
	}



	public Boolean mostrarDefinicionTipoDefinicion=true;

	public Boolean getMostrarDefinicionTipoDefinicion() {
		return this.mostrarDefinicionTipoDefinicion;
	}

	public void setMostrarDefinicionTipoDefinicion(Boolean visibilidadResaltarDefinicion) {
		this.mostrarDefinicionTipoDefinicion= visibilidadResaltarDefinicion;
	}



	public Boolean activarDefinicionTipoDefinicion=true;

	public Boolean gethabilitarResaltarDefinicionTipoDefinicion() {
		return this.activarDefinicionTipoDefinicion;
	}

	public void setActivarDefinicionTipoDefinicion(Boolean habilitarResaltarDefinicion) {
		this.activarDefinicionTipoDefinicion= habilitarResaltarDefinicion;
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

		this.setMostrarDefinicionTipoDefinicion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Definicion.class)) {
				this.setMostrarDefinicionTipoDefinicion(esAsigna);
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

		this.setActivarDefinicionTipoDefinicion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Definicion.class)) {
				this.setActivarDefinicionTipoDefinicion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDefinicionBeanSwingJInternalFrame tipodefinicionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDefinicionTipoDefinicion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Definicion.class)) {
				this.setResaltarDefinicionTipoDefinicion(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoTipoDefinicion=true;

	public Boolean getMostrarBusquedaPorCodigoTipoDefinicion() {
		return this.mostrarBusquedaPorCodigoTipoDefinicion;
	}

	public void setMostrarBusquedaPorCodigoTipoDefinicion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoDefinicion= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoDefinicion=true;

	public Boolean getMostrarBusquedaPorNombreTipoDefinicion() {
		return this.mostrarBusquedaPorNombreTipoDefinicion;
	}

	public void setMostrarBusquedaPorNombreTipoDefinicion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoDefinicion= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoDefinicion=true;

	public Boolean getActivarBusquedaPorCodigoTipoDefinicion() {
		return this.activarBusquedaPorCodigoTipoDefinicion;
	}

	public void setActivarBusquedaPorCodigoTipoDefinicion(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoDefinicion= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoDefinicion=true;

	public Boolean getActivarBusquedaPorNombreTipoDefinicion() {
		return this.activarBusquedaPorNombreTipoDefinicion;
	}

	public void setActivarBusquedaPorNombreTipoDefinicion(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoDefinicion= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoDefinicion=null;

	public Border getResaltarBusquedaPorCodigoTipoDefinicion() {
		return this.resaltarBusquedaPorCodigoTipoDefinicion;
	}

	public void setResaltarBusquedaPorCodigoTipoDefinicion(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoDefinicion= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDefinicionBeanSwingJInternalFrame tipodefinicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoDefinicion= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoDefinicion=null;

	public Border getResaltarBusquedaPorNombreTipoDefinicion() {
		return this.resaltarBusquedaPorNombreTipoDefinicion;
	}

	public void setResaltarBusquedaPorNombreTipoDefinicion(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoDefinicion= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDefinicionBeanSwingJInternalFrame tipodefinicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoDefinicion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}