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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.TipoIceConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoIceParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoIceParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoIceConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoIce";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoIce"+TipoIceConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoIceHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoIceHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoIceConstantesFunciones.SCHEMA+"_"+TipoIceConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoIceHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoIceConstantesFunciones.SCHEMA+"_"+TipoIceConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoIceConstantesFunciones.SCHEMA+"_"+TipoIceConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoIceHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoIceConstantesFunciones.SCHEMA+"_"+TipoIceConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoIceConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoIceHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoIceConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoIceConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoIceHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoIceConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoIceConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoIceConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoIceConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoIceConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Ices";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Ice";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Ice";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoIce";
	public static final String OBJECTNAME="tipoice";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_ice";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoice from "+TipoIceConstantesFunciones.SPERSISTENCENAME+" tipoice";
	public static String QUERYSELECTNATIVE="select "+TipoIceConstantesFunciones.SCHEMA+"."+TipoIceConstantesFunciones.TABLENAME+".id,"+TipoIceConstantesFunciones.SCHEMA+"."+TipoIceConstantesFunciones.TABLENAME+".version_row,"+TipoIceConstantesFunciones.SCHEMA+"."+TipoIceConstantesFunciones.TABLENAME+".nombre,"+TipoIceConstantesFunciones.SCHEMA+"."+TipoIceConstantesFunciones.TABLENAME+".porcentaje from "+TipoIceConstantesFunciones.SCHEMA+"."+TipoIceConstantesFunciones.TABLENAME;//+" as "+TipoIceConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRE= "nombre";
    public static final String PORCENTAJE= "porcentaje";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getTipoIceLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoIceConstantesFunciones.NOMBRE)) {sLabelColumna=TipoIceConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoIceConstantesFunciones.PORCENTAJE)) {sLabelColumna=TipoIceConstantesFunciones.LABEL_PORCENTAJE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoIceDescripcion(TipoIce tipoice) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoice !=null/* && tipoice.getId()!=0*/) {
			sDescripcion=tipoice.getnombre();//tipoicetipoice.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoIceDescripcionDetallado(TipoIce tipoice) {
		String sDescripcion="";
			
		sDescripcion+=TipoIceConstantesFunciones.ID+"=";
		sDescripcion+=tipoice.getId().toString()+",";
		sDescripcion+=TipoIceConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoice.getVersionRow().toString()+",";
		sDescripcion+=TipoIceConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoice.getnombre()+",";
		sDescripcion+=TipoIceConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=tipoice.getporcentaje().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoIceDescripcion(TipoIce tipoice,String sValor) throws Exception {			
		if(tipoice !=null) {
			tipoice.setnombre(sValor);//tipoicetipoice.getId().toString();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("PorNombre")) {
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

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoIce(TipoIce tipoice,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoice.setnombre(tipoice.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoIces(List<TipoIce> tipoices,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoIce tipoice: tipoices) {
			tipoice.setnombre(tipoice.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoIce(TipoIce tipoice,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoice.getConCambioAuxiliar()) {
			tipoice.setIsDeleted(tipoice.getIsDeletedAuxiliar());	
			tipoice.setIsNew(tipoice.getIsNewAuxiliar());	
			tipoice.setIsChanged(tipoice.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoice.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoice.setIsDeletedAuxiliar(false);	
			tipoice.setIsNewAuxiliar(false);	
			tipoice.setIsChangedAuxiliar(false);
			
			tipoice.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoIces(List<TipoIce> tipoices,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoIce tipoice : tipoices) {
			if(conAsignarBase && tipoice.getConCambioAuxiliar()) {
				tipoice.setIsDeleted(tipoice.getIsDeletedAuxiliar());	
				tipoice.setIsNew(tipoice.getIsNewAuxiliar());	
				tipoice.setIsChanged(tipoice.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoice.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoice.setIsDeletedAuxiliar(false);	
				tipoice.setIsNewAuxiliar(false);	
				tipoice.setIsChangedAuxiliar(false);
				
				tipoice.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoIce(TipoIce tipoice,Boolean conEnteros) throws Exception  {
		tipoice.setporcentaje(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoIces(List<TipoIce> tipoices,Boolean conEnteros) throws Exception  {
		
		for(TipoIce tipoice: tipoices) {
			tipoice.setporcentaje(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoIce(List<TipoIce> tipoices,TipoIce tipoiceAux) throws Exception  {
		TipoIceConstantesFunciones.InicializarValoresTipoIce(tipoiceAux,true);
		
		for(TipoIce tipoice: tipoices) {
			if(tipoice.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			tipoiceAux.setporcentaje(tipoiceAux.getporcentaje()+tipoice.getporcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoIce(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoIceConstantesFunciones.getArrayColumnasGlobalesTipoIce(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoIce(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoIce(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoIce> tipoices,TipoIce tipoice,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoIce tipoiceAux: tipoices) {
			if(tipoiceAux!=null && tipoice!=null) {
				if((tipoiceAux.getId()==null && tipoice.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoiceAux.getId()!=null && tipoice.getId()!=null){
					if(tipoiceAux.getId().equals(tipoice.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoIce(List<TipoIce> tipoices) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
	
		for(TipoIce tipoice: tipoices) {			
			if(tipoice.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=tipoice.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TipoIceConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(TipoIceConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoIce() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoIceConstantesFunciones.LABEL_ID, TipoIceConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoIceConstantesFunciones.LABEL_VERSIONROW, TipoIceConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoIceConstantesFunciones.LABEL_NOMBRE, TipoIceConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoIceConstantesFunciones.LABEL_PORCENTAJE, TipoIceConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoIce() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoIceConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoIceConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoIceConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoIceConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoIce() throws Exception  {
		return TipoIceConstantesFunciones.getTiposSeleccionarTipoIce(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoIce(Boolean conFk) throws Exception  {
		return TipoIceConstantesFunciones.getTiposSeleccionarTipoIce(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoIce(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoIceConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoIceConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoIceConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(TipoIceConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoIce(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoIce(TipoIce tipoiceAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoIce(List<TipoIce> tipoicesTemp) throws Exception {
		for(TipoIce tipoiceAux:tipoicesTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoIce(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoIce(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoIce(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoIceConstantesFunciones.getClassesRelationshipsOfTipoIce(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoIce(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ImportarExportar.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ImportarExportar.class)) {
						classes.add(new Classe(ImportarExportar.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoIce(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoIceConstantesFunciones.getClassesRelationshipsFromStringsOfTipoIce(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoIce(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ImportarExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImportarExportar.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ImportarExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImportarExportar.class)); continue;
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
	public static void actualizarLista(TipoIce tipoice,List<TipoIce> tipoices,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoIce tipoiceEncontrado=null;
			
			for(TipoIce tipoiceLocal:tipoices) {
				if(tipoiceLocal.getId().equals(tipoice.getId())) {
					tipoiceEncontrado=tipoiceLocal;
					
					tipoiceLocal.setIsChanged(tipoice.getIsChanged());
					tipoiceLocal.setIsNew(tipoice.getIsNew());
					tipoiceLocal.setIsDeleted(tipoice.getIsDeleted());
					
					tipoiceLocal.setGeneralEntityOriginal(tipoice.getGeneralEntityOriginal());
					
					tipoiceLocal.setId(tipoice.getId());	
					tipoiceLocal.setVersionRow(tipoice.getVersionRow());	
					tipoiceLocal.setnombre(tipoice.getnombre());	
					tipoiceLocal.setporcentaje(tipoice.getporcentaje());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoice.getIsDeleted()) {
				if(!existe) {
					tipoices.add(tipoice);
				}
			} else {
				if(tipoiceEncontrado!=null && permiteQuitar)  {
					tipoices.remove(tipoiceEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoIce tipoice,List<TipoIce> tipoices) throws Exception {
		try	{			
			for(TipoIce tipoiceLocal:tipoices) {
				if(tipoiceLocal.getId().equals(tipoice.getId())) {
					tipoiceLocal.setIsSelected(tipoice.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoIce(List<TipoIce> tipoicesAux) throws Exception {
		//this.tipoicesAux=tipoicesAux;
		
		for(TipoIce tipoiceAux:tipoicesAux) {
			if(tipoiceAux.getIsChanged()) {
				tipoiceAux.setIsChanged(false);
			}		
			
			if(tipoiceAux.getIsNew()) {
				tipoiceAux.setIsNew(false);
			}	
			
			if(tipoiceAux.getIsDeleted()) {
				tipoiceAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoIce(TipoIce tipoiceAux) throws Exception {
		//this.tipoiceAux=tipoiceAux;
		
			if(tipoiceAux.getIsChanged()) {
				tipoiceAux.setIsChanged(false);
			}		
			
			if(tipoiceAux.getIsNew()) {
				tipoiceAux.setIsNew(false);
			}	
			
			if(tipoiceAux.getIsDeleted()) {
				tipoiceAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoIce tipoiceAsignar,TipoIce tipoice) throws Exception {
		tipoiceAsignar.setId(tipoice.getId());	
		tipoiceAsignar.setVersionRow(tipoice.getVersionRow());	
		tipoiceAsignar.setnombre(tipoice.getnombre());	
		tipoiceAsignar.setporcentaje(tipoice.getporcentaje());	
	}
	
	public static void inicializarTipoIce(TipoIce tipoice) throws Exception {
		try {
				tipoice.setId(0L);	
					
				tipoice.setnombre("");	
				tipoice.setporcentaje(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoIce(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoIceConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoIceConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoIce(String sTipo,Row row,Workbook workbook,TipoIce tipoice,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoice.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoice.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoIce=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoIce() {
		return this.sFinalQueryTipoIce;
	}
	
	public void setsFinalQueryTipoIce(String sFinalQueryTipoIce) {
		this.sFinalQueryTipoIce= sFinalQueryTipoIce;
	}
	
	public Border resaltarSeleccionarTipoIce=null;
	
	public Border setResaltarSeleccionarTipoIce(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIceBeanSwingJInternalFrame tipoiceBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoiceBeanSwingJInternalFrame.jTtoolBarTipoIce.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoIce= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoIce() {
		return this.resaltarSeleccionarTipoIce;
	}
	
	public void setResaltarSeleccionarTipoIce(Border borderResaltarSeleccionarTipoIce) {
		this.resaltarSeleccionarTipoIce= borderResaltarSeleccionarTipoIce;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoIce=null;
	public Boolean mostraridTipoIce=true;
	public Boolean activaridTipoIce=true;

	public Border resaltarnombreTipoIce=null;
	public Boolean mostrarnombreTipoIce=true;
	public Boolean activarnombreTipoIce=true;

	public Border resaltarporcentajeTipoIce=null;
	public Boolean mostrarporcentajeTipoIce=true;
	public Boolean activarporcentajeTipoIce=true;

	
	

	public Border setResaltaridTipoIce(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIceBeanSwingJInternalFrame tipoiceBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoiceBeanSwingJInternalFrame.jTtoolBarTipoIce.setBorder(borderResaltar);
		
		this.resaltaridTipoIce= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoIce() {
		return this.resaltaridTipoIce;
	}

	public void setResaltaridTipoIce(Border borderResaltar) {
		this.resaltaridTipoIce= borderResaltar;
	}

	public Boolean getMostraridTipoIce() {
		return this.mostraridTipoIce;
	}

	public void setMostraridTipoIce(Boolean mostraridTipoIce) {
		this.mostraridTipoIce= mostraridTipoIce;
	}

	public Boolean getActivaridTipoIce() {
		return this.activaridTipoIce;
	}

	public void setActivaridTipoIce(Boolean activaridTipoIce) {
		this.activaridTipoIce= activaridTipoIce;
	}

	public Border setResaltarnombreTipoIce(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIceBeanSwingJInternalFrame tipoiceBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoiceBeanSwingJInternalFrame.jTtoolBarTipoIce.setBorder(borderResaltar);
		
		this.resaltarnombreTipoIce= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoIce() {
		return this.resaltarnombreTipoIce;
	}

	public void setResaltarnombreTipoIce(Border borderResaltar) {
		this.resaltarnombreTipoIce= borderResaltar;
	}

	public Boolean getMostrarnombreTipoIce() {
		return this.mostrarnombreTipoIce;
	}

	public void setMostrarnombreTipoIce(Boolean mostrarnombreTipoIce) {
		this.mostrarnombreTipoIce= mostrarnombreTipoIce;
	}

	public Boolean getActivarnombreTipoIce() {
		return this.activarnombreTipoIce;
	}

	public void setActivarnombreTipoIce(Boolean activarnombreTipoIce) {
		this.activarnombreTipoIce= activarnombreTipoIce;
	}

	public Border setResaltarporcentajeTipoIce(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIceBeanSwingJInternalFrame tipoiceBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoiceBeanSwingJInternalFrame.jTtoolBarTipoIce.setBorder(borderResaltar);
		
		this.resaltarporcentajeTipoIce= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeTipoIce() {
		return this.resaltarporcentajeTipoIce;
	}

	public void setResaltarporcentajeTipoIce(Border borderResaltar) {
		this.resaltarporcentajeTipoIce= borderResaltar;
	}

	public Boolean getMostrarporcentajeTipoIce() {
		return this.mostrarporcentajeTipoIce;
	}

	public void setMostrarporcentajeTipoIce(Boolean mostrarporcentajeTipoIce) {
		this.mostrarporcentajeTipoIce= mostrarporcentajeTipoIce;
	}

	public Boolean getActivarporcentajeTipoIce() {
		return this.activarporcentajeTipoIce;
	}

	public void setActivarporcentajeTipoIce(Boolean activarporcentajeTipoIce) {
		this.activarporcentajeTipoIce= activarporcentajeTipoIce;
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
		
		
		this.setMostraridTipoIce(esInicial);
		this.setMostrarnombreTipoIce(esInicial);
		this.setMostrarporcentajeTipoIce(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoIceConstantesFunciones.ID)) {
				this.setMostraridTipoIce(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIceConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoIce(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIceConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeTipoIce(esAsigna);
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
		
		
		this.setActivaridTipoIce(esInicial);
		this.setActivarnombreTipoIce(esInicial);
		this.setActivarporcentajeTipoIce(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoIceConstantesFunciones.ID)) {
				this.setActivaridTipoIce(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIceConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoIce(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIceConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeTipoIce(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoIceBeanSwingJInternalFrame tipoiceBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoIce(esInicial);
		this.setResaltarnombreTipoIce(esInicial);
		this.setResaltarporcentajeTipoIce(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoIceConstantesFunciones.ID)) {
				this.setResaltaridTipoIce(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIceConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoIce(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIceConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeTipoIce(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoIceBeanSwingJInternalFrame tipoiceBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorNombreTipoIce=true;

	public Boolean getMostrarBusquedaPorNombreTipoIce() {
		return this.mostrarBusquedaPorNombreTipoIce;
	}

	public void setMostrarBusquedaPorNombreTipoIce(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoIce= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreTipoIce=true;

	public Boolean getActivarBusquedaPorNombreTipoIce() {
		return this.activarBusquedaPorNombreTipoIce;
	}

	public void setActivarBusquedaPorNombreTipoIce(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoIce= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreTipoIce=null;

	public Border getResaltarBusquedaPorNombreTipoIce() {
		return this.resaltarBusquedaPorNombreTipoIce;
	}

	public void setResaltarBusquedaPorNombreTipoIce(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoIce= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoIce(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIceBeanSwingJInternalFrame tipoiceBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoIce= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}