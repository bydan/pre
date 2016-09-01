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


import com.bydan.erp.inventario.util.TipoCosteoDefinicionConstantesFunciones;
import com.bydan.erp.inventario.util.TipoCosteoDefinicionParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoCosteoDefinicionParameterGeneral;

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
final public class TipoCosteoDefinicionConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoCosteoDefinicion";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoCosteoDefinicion"+TipoCosteoDefinicionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoCosteoDefinicionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoCosteoDefinicionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoCosteoDefinicionConstantesFunciones.SCHEMA+"_"+TipoCosteoDefinicionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoCosteoDefinicionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoCosteoDefinicionConstantesFunciones.SCHEMA+"_"+TipoCosteoDefinicionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoCosteoDefinicionConstantesFunciones.SCHEMA+"_"+TipoCosteoDefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoCosteoDefinicionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoCosteoDefinicionConstantesFunciones.SCHEMA+"_"+TipoCosteoDefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCosteoDefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCosteoDefinicionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCosteoDefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCosteoDefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCosteoDefinicionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCosteoDefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoCosteoDefinicionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoCosteoDefinicionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoCosteoDefinicionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoCosteoDefinicionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Costeo Definiciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Costeo Definicion";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Costeo Definicion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoCosteoDefinicion";
	public static final String OBJECTNAME="tipocosteodefinicion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="tipo_costeo_definicion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocosteodefinicion from "+TipoCosteoDefinicionConstantesFunciones.SPERSISTENCENAME+" tipocosteodefinicion";
	public static String QUERYSELECTNATIVE="select "+TipoCosteoDefinicionConstantesFunciones.SCHEMA+"."+TipoCosteoDefinicionConstantesFunciones.TABLENAME+".id,"+TipoCosteoDefinicionConstantesFunciones.SCHEMA+"."+TipoCosteoDefinicionConstantesFunciones.TABLENAME+".version_row,"+TipoCosteoDefinicionConstantesFunciones.SCHEMA+"."+TipoCosteoDefinicionConstantesFunciones.TABLENAME+".codigo,"+TipoCosteoDefinicionConstantesFunciones.SCHEMA+"."+TipoCosteoDefinicionConstantesFunciones.TABLENAME+".nombre from "+TipoCosteoDefinicionConstantesFunciones.SCHEMA+"."+TipoCosteoDefinicionConstantesFunciones.TABLENAME;//+" as "+TipoCosteoDefinicionConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoCosteoDefinicionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoCosteoDefinicionConstantesFunciones.CODIGO)) {sLabelColumna=TipoCosteoDefinicionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoCosteoDefinicionConstantesFunciones.NOMBRE)) {sLabelColumna=TipoCosteoDefinicionConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoCosteoDefinicionDescripcion(TipoCosteoDefinicion tipocosteodefinicion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocosteodefinicion !=null/* && tipocosteodefinicion.getId()!=0*/) {
			sDescripcion=tipocosteodefinicion.getcodigo();//tipocosteodefiniciontipocosteodefinicion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoCosteoDefinicionDescripcionDetallado(TipoCosteoDefinicion tipocosteodefinicion) {
		String sDescripcion="";
			
		sDescripcion+=TipoCosteoDefinicionConstantesFunciones.ID+"=";
		sDescripcion+=tipocosteodefinicion.getId().toString()+",";
		sDescripcion+=TipoCosteoDefinicionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocosteodefinicion.getVersionRow().toString()+",";
		sDescripcion+=TipoCosteoDefinicionConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipocosteodefinicion.getcodigo()+",";
		sDescripcion+=TipoCosteoDefinicionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocosteodefinicion.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoCosteoDefinicionDescripcion(TipoCosteoDefinicion tipocosteodefinicion,String sValor) throws Exception {			
		if(tipocosteodefinicion !=null) {
			tipocosteodefinicion.setcodigo(sValor);;//tipocosteodefiniciontipocosteodefinicion.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoCosteoDefinicion(TipoCosteoDefinicion tipocosteodefinicion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocosteodefinicion.setcodigo(tipocosteodefinicion.getcodigo().trim());
		tipocosteodefinicion.setnombre(tipocosteodefinicion.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoCosteoDefinicions(List<TipoCosteoDefinicion> tipocosteodefinicions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoCosteoDefinicion tipocosteodefinicion: tipocosteodefinicions) {
			tipocosteodefinicion.setcodigo(tipocosteodefinicion.getcodigo().trim());
			tipocosteodefinicion.setnombre(tipocosteodefinicion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCosteoDefinicion(TipoCosteoDefinicion tipocosteodefinicion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocosteodefinicion.getConCambioAuxiliar()) {
			tipocosteodefinicion.setIsDeleted(tipocosteodefinicion.getIsDeletedAuxiliar());	
			tipocosteodefinicion.setIsNew(tipocosteodefinicion.getIsNewAuxiliar());	
			tipocosteodefinicion.setIsChanged(tipocosteodefinicion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocosteodefinicion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocosteodefinicion.setIsDeletedAuxiliar(false);	
			tipocosteodefinicion.setIsNewAuxiliar(false);	
			tipocosteodefinicion.setIsChangedAuxiliar(false);
			
			tipocosteodefinicion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCosteoDefinicions(List<TipoCosteoDefinicion> tipocosteodefinicions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoCosteoDefinicion tipocosteodefinicion : tipocosteodefinicions) {
			if(conAsignarBase && tipocosteodefinicion.getConCambioAuxiliar()) {
				tipocosteodefinicion.setIsDeleted(tipocosteodefinicion.getIsDeletedAuxiliar());	
				tipocosteodefinicion.setIsNew(tipocosteodefinicion.getIsNewAuxiliar());	
				tipocosteodefinicion.setIsChanged(tipocosteodefinicion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocosteodefinicion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocosteodefinicion.setIsDeletedAuxiliar(false);	
				tipocosteodefinicion.setIsNewAuxiliar(false);	
				tipocosteodefinicion.setIsChangedAuxiliar(false);
				
				tipocosteodefinicion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoCosteoDefinicion(TipoCosteoDefinicion tipocosteodefinicion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoCosteoDefinicions(List<TipoCosteoDefinicion> tipocosteodefinicions,Boolean conEnteros) throws Exception  {
		
		for(TipoCosteoDefinicion tipocosteodefinicion: tipocosteodefinicions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoCosteoDefinicion(List<TipoCosteoDefinicion> tipocosteodefinicions,TipoCosteoDefinicion tipocosteodefinicionAux) throws Exception  {
		TipoCosteoDefinicionConstantesFunciones.InicializarValoresTipoCosteoDefinicion(tipocosteodefinicionAux,true);
		
		for(TipoCosteoDefinicion tipocosteodefinicion: tipocosteodefinicions) {
			if(tipocosteodefinicion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCosteoDefinicion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoCosteoDefinicionConstantesFunciones.getArrayColumnasGlobalesTipoCosteoDefinicion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCosteoDefinicion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoCosteoDefinicion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoCosteoDefinicion> tipocosteodefinicions,TipoCosteoDefinicion tipocosteodefinicion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoCosteoDefinicion tipocosteodefinicionAux: tipocosteodefinicions) {
			if(tipocosteodefinicionAux!=null && tipocosteodefinicion!=null) {
				if((tipocosteodefinicionAux.getId()==null && tipocosteodefinicion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocosteodefinicionAux.getId()!=null && tipocosteodefinicion.getId()!=null){
					if(tipocosteodefinicionAux.getId().equals(tipocosteodefinicion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoCosteoDefinicion(List<TipoCosteoDefinicion> tipocosteodefinicions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoCosteoDefinicion tipocosteodefinicion: tipocosteodefinicions) {			
			if(tipocosteodefinicion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoCosteoDefinicion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoCosteoDefinicionConstantesFunciones.LABEL_ID, TipoCosteoDefinicionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCosteoDefinicionConstantesFunciones.LABEL_VERSIONROW, TipoCosteoDefinicionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCosteoDefinicionConstantesFunciones.LABEL_CODIGO, TipoCosteoDefinicionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCosteoDefinicionConstantesFunciones.LABEL_NOMBRE, TipoCosteoDefinicionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoCosteoDefinicion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoCosteoDefinicionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCosteoDefinicionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCosteoDefinicionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCosteoDefinicionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCosteoDefinicion() throws Exception  {
		return TipoCosteoDefinicionConstantesFunciones.getTiposSeleccionarTipoCosteoDefinicion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCosteoDefinicion(Boolean conFk) throws Exception  {
		return TipoCosteoDefinicionConstantesFunciones.getTiposSeleccionarTipoCosteoDefinicion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCosteoDefinicion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCosteoDefinicionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoCosteoDefinicionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCosteoDefinicionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoCosteoDefinicionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoCosteoDefinicion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCosteoDefinicion(TipoCosteoDefinicion tipocosteodefinicionAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCosteoDefinicion(List<TipoCosteoDefinicion> tipocosteodefinicionsTemp) throws Exception {
		for(TipoCosteoDefinicion tipocosteodefinicionAux:tipocosteodefinicionsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCosteoDefinicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoCosteoDefinicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCosteoDefinicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCosteoDefinicionConstantesFunciones.getClassesRelationshipsOfTipoCosteoDefinicion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCosteoDefinicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCosteoDefinicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCosteoDefinicionConstantesFunciones.getClassesRelationshipsFromStringsOfTipoCosteoDefinicion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCosteoDefinicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoCosteoDefinicion tipocosteodefinicion,List<TipoCosteoDefinicion> tipocosteodefinicions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoCosteoDefinicion tipocosteodefinicionEncontrado=null;
			
			for(TipoCosteoDefinicion tipocosteodefinicionLocal:tipocosteodefinicions) {
				if(tipocosteodefinicionLocal.getId().equals(tipocosteodefinicion.getId())) {
					tipocosteodefinicionEncontrado=tipocosteodefinicionLocal;
					
					tipocosteodefinicionLocal.setIsChanged(tipocosteodefinicion.getIsChanged());
					tipocosteodefinicionLocal.setIsNew(tipocosteodefinicion.getIsNew());
					tipocosteodefinicionLocal.setIsDeleted(tipocosteodefinicion.getIsDeleted());
					
					tipocosteodefinicionLocal.setGeneralEntityOriginal(tipocosteodefinicion.getGeneralEntityOriginal());
					
					tipocosteodefinicionLocal.setId(tipocosteodefinicion.getId());	
					tipocosteodefinicionLocal.setVersionRow(tipocosteodefinicion.getVersionRow());	
					tipocosteodefinicionLocal.setcodigo(tipocosteodefinicion.getcodigo());	
					tipocosteodefinicionLocal.setnombre(tipocosteodefinicion.getnombre());	
					
					
					tipocosteodefinicionLocal.setDefinicions(tipocosteodefinicion.getDefinicions());
					
					existe=true;
					break;
				}
			}
			
			if(!tipocosteodefinicion.getIsDeleted()) {
				if(!existe) {
					tipocosteodefinicions.add(tipocosteodefinicion);
				}
			} else {
				if(tipocosteodefinicionEncontrado!=null && permiteQuitar)  {
					tipocosteodefinicions.remove(tipocosteodefinicionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoCosteoDefinicion tipocosteodefinicion,List<TipoCosteoDefinicion> tipocosteodefinicions) throws Exception {
		try	{			
			for(TipoCosteoDefinicion tipocosteodefinicionLocal:tipocosteodefinicions) {
				if(tipocosteodefinicionLocal.getId().equals(tipocosteodefinicion.getId())) {
					tipocosteodefinicionLocal.setIsSelected(tipocosteodefinicion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoCosteoDefinicion(List<TipoCosteoDefinicion> tipocosteodefinicionsAux) throws Exception {
		//this.tipocosteodefinicionsAux=tipocosteodefinicionsAux;
		
		for(TipoCosteoDefinicion tipocosteodefinicionAux:tipocosteodefinicionsAux) {
			if(tipocosteodefinicionAux.getIsChanged()) {
				tipocosteodefinicionAux.setIsChanged(false);
			}		
			
			if(tipocosteodefinicionAux.getIsNew()) {
				tipocosteodefinicionAux.setIsNew(false);
			}	
			
			if(tipocosteodefinicionAux.getIsDeleted()) {
				tipocosteodefinicionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoCosteoDefinicion(TipoCosteoDefinicion tipocosteodefinicionAux) throws Exception {
		//this.tipocosteodefinicionAux=tipocosteodefinicionAux;
		
			if(tipocosteodefinicionAux.getIsChanged()) {
				tipocosteodefinicionAux.setIsChanged(false);
			}		
			
			if(tipocosteodefinicionAux.getIsNew()) {
				tipocosteodefinicionAux.setIsNew(false);
			}	
			
			if(tipocosteodefinicionAux.getIsDeleted()) {
				tipocosteodefinicionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoCosteoDefinicion tipocosteodefinicionAsignar,TipoCosteoDefinicion tipocosteodefinicion) throws Exception {
		tipocosteodefinicionAsignar.setId(tipocosteodefinicion.getId());	
		tipocosteodefinicionAsignar.setVersionRow(tipocosteodefinicion.getVersionRow());	
		tipocosteodefinicionAsignar.setcodigo(tipocosteodefinicion.getcodigo());	
		tipocosteodefinicionAsignar.setnombre(tipocosteodefinicion.getnombre());	
	}
	
	public static void inicializarTipoCosteoDefinicion(TipoCosteoDefinicion tipocosteodefinicion) throws Exception {
		try {
				tipocosteodefinicion.setId(0L);	
					
				tipocosteodefinicion.setcodigo("");	
				tipocosteodefinicion.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoCosteoDefinicion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCosteoDefinicionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCosteoDefinicionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoCosteoDefinicion(String sTipo,Row row,Workbook workbook,TipoCosteoDefinicion tipocosteodefinicion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocosteodefinicion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocosteodefinicion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoCosteoDefinicion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoCosteoDefinicion() {
		return this.sFinalQueryTipoCosteoDefinicion;
	}
	
	public void setsFinalQueryTipoCosteoDefinicion(String sFinalQueryTipoCosteoDefinicion) {
		this.sFinalQueryTipoCosteoDefinicion= sFinalQueryTipoCosteoDefinicion;
	}
	
	public Border resaltarSeleccionarTipoCosteoDefinicion=null;
	
	public Border setResaltarSeleccionarTipoCosteoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCosteoDefinicionBeanSwingJInternalFrame tipocosteodefinicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocosteodefinicionBeanSwingJInternalFrame.jTtoolBarTipoCosteoDefinicion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoCosteoDefinicion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoCosteoDefinicion() {
		return this.resaltarSeleccionarTipoCosteoDefinicion;
	}
	
	public void setResaltarSeleccionarTipoCosteoDefinicion(Border borderResaltarSeleccionarTipoCosteoDefinicion) {
		this.resaltarSeleccionarTipoCosteoDefinicion= borderResaltarSeleccionarTipoCosteoDefinicion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoCosteoDefinicion=null;
	public Boolean mostraridTipoCosteoDefinicion=true;
	public Boolean activaridTipoCosteoDefinicion=true;

	public Border resaltarcodigoTipoCosteoDefinicion=null;
	public Boolean mostrarcodigoTipoCosteoDefinicion=true;
	public Boolean activarcodigoTipoCosteoDefinicion=true;

	public Border resaltarnombreTipoCosteoDefinicion=null;
	public Boolean mostrarnombreTipoCosteoDefinicion=true;
	public Boolean activarnombreTipoCosteoDefinicion=true;

	
	

	public Border setResaltaridTipoCosteoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCosteoDefinicionBeanSwingJInternalFrame tipocosteodefinicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocosteodefinicionBeanSwingJInternalFrame.jTtoolBarTipoCosteoDefinicion.setBorder(borderResaltar);
		
		this.resaltaridTipoCosteoDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoCosteoDefinicion() {
		return this.resaltaridTipoCosteoDefinicion;
	}

	public void setResaltaridTipoCosteoDefinicion(Border borderResaltar) {
		this.resaltaridTipoCosteoDefinicion= borderResaltar;
	}

	public Boolean getMostraridTipoCosteoDefinicion() {
		return this.mostraridTipoCosteoDefinicion;
	}

	public void setMostraridTipoCosteoDefinicion(Boolean mostraridTipoCosteoDefinicion) {
		this.mostraridTipoCosteoDefinicion= mostraridTipoCosteoDefinicion;
	}

	public Boolean getActivaridTipoCosteoDefinicion() {
		return this.activaridTipoCosteoDefinicion;
	}

	public void setActivaridTipoCosteoDefinicion(Boolean activaridTipoCosteoDefinicion) {
		this.activaridTipoCosteoDefinicion= activaridTipoCosteoDefinicion;
	}

	public Border setResaltarcodigoTipoCosteoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCosteoDefinicionBeanSwingJInternalFrame tipocosteodefinicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocosteodefinicionBeanSwingJInternalFrame.jTtoolBarTipoCosteoDefinicion.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoCosteoDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoCosteoDefinicion() {
		return this.resaltarcodigoTipoCosteoDefinicion;
	}

	public void setResaltarcodigoTipoCosteoDefinicion(Border borderResaltar) {
		this.resaltarcodigoTipoCosteoDefinicion= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoCosteoDefinicion() {
		return this.mostrarcodigoTipoCosteoDefinicion;
	}

	public void setMostrarcodigoTipoCosteoDefinicion(Boolean mostrarcodigoTipoCosteoDefinicion) {
		this.mostrarcodigoTipoCosteoDefinicion= mostrarcodigoTipoCosteoDefinicion;
	}

	public Boolean getActivarcodigoTipoCosteoDefinicion() {
		return this.activarcodigoTipoCosteoDefinicion;
	}

	public void setActivarcodigoTipoCosteoDefinicion(Boolean activarcodigoTipoCosteoDefinicion) {
		this.activarcodigoTipoCosteoDefinicion= activarcodigoTipoCosteoDefinicion;
	}

	public Border setResaltarnombreTipoCosteoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCosteoDefinicionBeanSwingJInternalFrame tipocosteodefinicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocosteodefinicionBeanSwingJInternalFrame.jTtoolBarTipoCosteoDefinicion.setBorder(borderResaltar);
		
		this.resaltarnombreTipoCosteoDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoCosteoDefinicion() {
		return this.resaltarnombreTipoCosteoDefinicion;
	}

	public void setResaltarnombreTipoCosteoDefinicion(Border borderResaltar) {
		this.resaltarnombreTipoCosteoDefinicion= borderResaltar;
	}

	public Boolean getMostrarnombreTipoCosteoDefinicion() {
		return this.mostrarnombreTipoCosteoDefinicion;
	}

	public void setMostrarnombreTipoCosteoDefinicion(Boolean mostrarnombreTipoCosteoDefinicion) {
		this.mostrarnombreTipoCosteoDefinicion= mostrarnombreTipoCosteoDefinicion;
	}

	public Boolean getActivarnombreTipoCosteoDefinicion() {
		return this.activarnombreTipoCosteoDefinicion;
	}

	public void setActivarnombreTipoCosteoDefinicion(Boolean activarnombreTipoCosteoDefinicion) {
		this.activarnombreTipoCosteoDefinicion= activarnombreTipoCosteoDefinicion;
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
		
		
		this.setMostraridTipoCosteoDefinicion(esInicial);
		this.setMostrarcodigoTipoCosteoDefinicion(esInicial);
		this.setMostrarnombreTipoCosteoDefinicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCosteoDefinicionConstantesFunciones.ID)) {
				this.setMostraridTipoCosteoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCosteoDefinicionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoCosteoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCosteoDefinicionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoCosteoDefinicion(esAsigna);
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
		
		
		this.setActivaridTipoCosteoDefinicion(esInicial);
		this.setActivarcodigoTipoCosteoDefinicion(esInicial);
		this.setActivarnombreTipoCosteoDefinicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCosteoDefinicionConstantesFunciones.ID)) {
				this.setActivaridTipoCosteoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCosteoDefinicionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoCosteoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCosteoDefinicionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoCosteoDefinicion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCosteoDefinicionBeanSwingJInternalFrame tipocosteodefinicionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoCosteoDefinicion(esInicial);
		this.setResaltarcodigoTipoCosteoDefinicion(esInicial);
		this.setResaltarnombreTipoCosteoDefinicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCosteoDefinicionConstantesFunciones.ID)) {
				this.setResaltaridTipoCosteoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCosteoDefinicionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoCosteoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCosteoDefinicionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoCosteoDefinicion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDefinicionTipoCosteoDefinicion=null;

	public Border getResaltarDefinicionTipoCosteoDefinicion() {
		return this.resaltarDefinicionTipoCosteoDefinicion;
	}

	public void setResaltarDefinicionTipoCosteoDefinicion(Border borderResaltarDefinicion) {
		if(borderResaltarDefinicion!=null) {
			this.resaltarDefinicionTipoCosteoDefinicion= borderResaltarDefinicion;
		}
	}

	public Border setResaltarDefinicionTipoCosteoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCosteoDefinicionBeanSwingJInternalFrame tipocosteodefinicionBeanSwingJInternalFrame*/) {
		Border borderResaltarDefinicion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocosteodefinicionBeanSwingJInternalFrame.jTtoolBarTipoCosteoDefinicion.setBorder(borderResaltarDefinicion);
			
		this.resaltarDefinicionTipoCosteoDefinicion= borderResaltarDefinicion;

		 return borderResaltarDefinicion;
	}



	public Boolean mostrarDefinicionTipoCosteoDefinicion=true;

	public Boolean getMostrarDefinicionTipoCosteoDefinicion() {
		return this.mostrarDefinicionTipoCosteoDefinicion;
	}

	public void setMostrarDefinicionTipoCosteoDefinicion(Boolean visibilidadResaltarDefinicion) {
		this.mostrarDefinicionTipoCosteoDefinicion= visibilidadResaltarDefinicion;
	}



	public Boolean activarDefinicionTipoCosteoDefinicion=true;

	public Boolean gethabilitarResaltarDefinicionTipoCosteoDefinicion() {
		return this.activarDefinicionTipoCosteoDefinicion;
	}

	public void setActivarDefinicionTipoCosteoDefinicion(Boolean habilitarResaltarDefinicion) {
		this.activarDefinicionTipoCosteoDefinicion= habilitarResaltarDefinicion;
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

		this.setMostrarDefinicionTipoCosteoDefinicion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Definicion.class)) {
				this.setMostrarDefinicionTipoCosteoDefinicion(esAsigna);
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

		this.setActivarDefinicionTipoCosteoDefinicion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Definicion.class)) {
				this.setActivarDefinicionTipoCosteoDefinicion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCosteoDefinicionBeanSwingJInternalFrame tipocosteodefinicionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDefinicionTipoCosteoDefinicion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Definicion.class)) {
				this.setResaltarDefinicionTipoCosteoDefinicion(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}