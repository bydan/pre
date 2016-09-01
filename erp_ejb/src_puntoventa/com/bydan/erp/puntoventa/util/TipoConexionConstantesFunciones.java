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
package com.bydan.erp.puntoventa.util;

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


import com.bydan.erp.puntoventa.util.TipoConexionConstantesFunciones;
import com.bydan.erp.puntoventa.util.TipoConexionParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.TipoConexionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoConexionConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoConexion";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoConexion"+TipoConexionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoConexionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoConexionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoConexionConstantesFunciones.SCHEMA+"_"+TipoConexionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoConexionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoConexionConstantesFunciones.SCHEMA+"_"+TipoConexionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoConexionConstantesFunciones.SCHEMA+"_"+TipoConexionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoConexionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoConexionConstantesFunciones.SCHEMA+"_"+TipoConexionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoConexionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoConexionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoConexionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoConexionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoConexionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoConexionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoConexionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoConexionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoConexionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoConexionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Conexions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Conexion";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Conexion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoConexion";
	public static final String OBJECTNAME="tipoconexion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="tipo_conexion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoconexion from "+TipoConexionConstantesFunciones.SPERSISTENCENAME+" tipoconexion";
	public static String QUERYSELECTNATIVE="select "+TipoConexionConstantesFunciones.SCHEMA+"."+TipoConexionConstantesFunciones.TABLENAME+".id,"+TipoConexionConstantesFunciones.SCHEMA+"."+TipoConexionConstantesFunciones.TABLENAME+".version_row,"+TipoConexionConstantesFunciones.SCHEMA+"."+TipoConexionConstantesFunciones.TABLENAME+".nombre,"+TipoConexionConstantesFunciones.SCHEMA+"."+TipoConexionConstantesFunciones.TABLENAME+".descripcion from "+TipoConexionConstantesFunciones.SCHEMA+"."+TipoConexionConstantesFunciones.TABLENAME;//+" as "+TipoConexionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoConexionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoConexionConstantesFunciones.NOMBRE)) {sLabelColumna=TipoConexionConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoConexionConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoConexionConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoConexionDescripcion(TipoConexion tipoconexion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoconexion !=null/* && tipoconexion.getId()!=0*/) {
			sDescripcion=tipoconexion.getnombre();//tipoconexiontipoconexion.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoConexionDescripcionDetallado(TipoConexion tipoconexion) {
		String sDescripcion="";
			
		sDescripcion+=TipoConexionConstantesFunciones.ID+"=";
		sDescripcion+=tipoconexion.getId().toString()+",";
		sDescripcion+=TipoConexionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoconexion.getVersionRow().toString()+",";
		sDescripcion+=TipoConexionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoconexion.getnombre()+",";
		sDescripcion+=TipoConexionConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tipoconexion.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoConexionDescripcion(TipoConexion tipoconexion,String sValor) throws Exception {			
		if(tipoconexion !=null) {
			tipoconexion.setnombre(sValor);;//tipoconexiontipoconexion.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoConexion(TipoConexion tipoconexion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoconexion.setnombre(tipoconexion.getnombre().trim());
		tipoconexion.setdescripcion(tipoconexion.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoConexions(List<TipoConexion> tipoconexions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoConexion tipoconexion: tipoconexions) {
			tipoconexion.setnombre(tipoconexion.getnombre().trim());
			tipoconexion.setdescripcion(tipoconexion.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoConexion(TipoConexion tipoconexion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoconexion.getConCambioAuxiliar()) {
			tipoconexion.setIsDeleted(tipoconexion.getIsDeletedAuxiliar());	
			tipoconexion.setIsNew(tipoconexion.getIsNewAuxiliar());	
			tipoconexion.setIsChanged(tipoconexion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoconexion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoconexion.setIsDeletedAuxiliar(false);	
			tipoconexion.setIsNewAuxiliar(false);	
			tipoconexion.setIsChangedAuxiliar(false);
			
			tipoconexion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoConexions(List<TipoConexion> tipoconexions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoConexion tipoconexion : tipoconexions) {
			if(conAsignarBase && tipoconexion.getConCambioAuxiliar()) {
				tipoconexion.setIsDeleted(tipoconexion.getIsDeletedAuxiliar());	
				tipoconexion.setIsNew(tipoconexion.getIsNewAuxiliar());	
				tipoconexion.setIsChanged(tipoconexion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoconexion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoconexion.setIsDeletedAuxiliar(false);	
				tipoconexion.setIsNewAuxiliar(false);	
				tipoconexion.setIsChangedAuxiliar(false);
				
				tipoconexion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoConexion(TipoConexion tipoconexion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoConexions(List<TipoConexion> tipoconexions,Boolean conEnteros) throws Exception  {
		
		for(TipoConexion tipoconexion: tipoconexions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoConexion(List<TipoConexion> tipoconexions,TipoConexion tipoconexionAux) throws Exception  {
		TipoConexionConstantesFunciones.InicializarValoresTipoConexion(tipoconexionAux,true);
		
		for(TipoConexion tipoconexion: tipoconexions) {
			if(tipoconexion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoConexion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoConexionConstantesFunciones.getArrayColumnasGlobalesTipoConexion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoConexion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoConexion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoConexion> tipoconexions,TipoConexion tipoconexion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoConexion tipoconexionAux: tipoconexions) {
			if(tipoconexionAux!=null && tipoconexion!=null) {
				if((tipoconexionAux.getId()==null && tipoconexion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoconexionAux.getId()!=null && tipoconexion.getId()!=null){
					if(tipoconexionAux.getId().equals(tipoconexion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoConexion(List<TipoConexion> tipoconexions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoConexion tipoconexion: tipoconexions) {			
			if(tipoconexion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoConexion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoConexionConstantesFunciones.LABEL_ID, TipoConexionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoConexionConstantesFunciones.LABEL_VERSIONROW, TipoConexionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoConexionConstantesFunciones.LABEL_NOMBRE, TipoConexionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoConexionConstantesFunciones.LABEL_DESCRIPCION, TipoConexionConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoConexion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoConexionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoConexionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoConexionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoConexionConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoConexion() throws Exception  {
		return TipoConexionConstantesFunciones.getTiposSeleccionarTipoConexion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoConexion(Boolean conFk) throws Exception  {
		return TipoConexionConstantesFunciones.getTiposSeleccionarTipoConexion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoConexion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoConexionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoConexionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoConexionConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoConexionConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoConexion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoConexion(TipoConexion tipoconexionAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoConexion(List<TipoConexion> tipoconexionsTemp) throws Exception {
		for(TipoConexion tipoconexionAux:tipoconexionsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoConexion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoConexion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoConexion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoConexionConstantesFunciones.getClassesRelationshipsOfTipoConexion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoConexion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Conexion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Conexion.class)) {
						classes.add(new Classe(Conexion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoConexion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoConexionConstantesFunciones.getClassesRelationshipsFromStringsOfTipoConexion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoConexion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Conexion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Conexion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Conexion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Conexion.class)); continue;
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
	public static void actualizarLista(TipoConexion tipoconexion,List<TipoConexion> tipoconexions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoConexion tipoconexionEncontrado=null;
			
			for(TipoConexion tipoconexionLocal:tipoconexions) {
				if(tipoconexionLocal.getId().equals(tipoconexion.getId())) {
					tipoconexionEncontrado=tipoconexionLocal;
					
					tipoconexionLocal.setIsChanged(tipoconexion.getIsChanged());
					tipoconexionLocal.setIsNew(tipoconexion.getIsNew());
					tipoconexionLocal.setIsDeleted(tipoconexion.getIsDeleted());
					
					tipoconexionLocal.setGeneralEntityOriginal(tipoconexion.getGeneralEntityOriginal());
					
					tipoconexionLocal.setId(tipoconexion.getId());	
					tipoconexionLocal.setVersionRow(tipoconexion.getVersionRow());	
					tipoconexionLocal.setnombre(tipoconexion.getnombre());	
					tipoconexionLocal.setdescripcion(tipoconexion.getdescripcion());	
					
					
					tipoconexionLocal.setConexions(tipoconexion.getConexions());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoconexion.getIsDeleted()) {
				if(!existe) {
					tipoconexions.add(tipoconexion);
				}
			} else {
				if(tipoconexionEncontrado!=null && permiteQuitar)  {
					tipoconexions.remove(tipoconexionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoConexion tipoconexion,List<TipoConexion> tipoconexions) throws Exception {
		try	{			
			for(TipoConexion tipoconexionLocal:tipoconexions) {
				if(tipoconexionLocal.getId().equals(tipoconexion.getId())) {
					tipoconexionLocal.setIsSelected(tipoconexion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoConexion(List<TipoConexion> tipoconexionsAux) throws Exception {
		//this.tipoconexionsAux=tipoconexionsAux;
		
		for(TipoConexion tipoconexionAux:tipoconexionsAux) {
			if(tipoconexionAux.getIsChanged()) {
				tipoconexionAux.setIsChanged(false);
			}		
			
			if(tipoconexionAux.getIsNew()) {
				tipoconexionAux.setIsNew(false);
			}	
			
			if(tipoconexionAux.getIsDeleted()) {
				tipoconexionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoConexion(TipoConexion tipoconexionAux) throws Exception {
		//this.tipoconexionAux=tipoconexionAux;
		
			if(tipoconexionAux.getIsChanged()) {
				tipoconexionAux.setIsChanged(false);
			}		
			
			if(tipoconexionAux.getIsNew()) {
				tipoconexionAux.setIsNew(false);
			}	
			
			if(tipoconexionAux.getIsDeleted()) {
				tipoconexionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoConexion tipoconexionAsignar,TipoConexion tipoconexion) throws Exception {
		tipoconexionAsignar.setId(tipoconexion.getId());	
		tipoconexionAsignar.setVersionRow(tipoconexion.getVersionRow());	
		tipoconexionAsignar.setnombre(tipoconexion.getnombre());	
		tipoconexionAsignar.setdescripcion(tipoconexion.getdescripcion());	
	}
	
	public static void inicializarTipoConexion(TipoConexion tipoconexion) throws Exception {
		try {
				tipoconexion.setId(0L);	
					
				tipoconexion.setnombre("");	
				tipoconexion.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoConexion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoConexionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoConexionConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoConexion(String sTipo,Row row,Workbook workbook,TipoConexion tipoconexion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoconexion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoconexion.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoConexion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoConexion() {
		return this.sFinalQueryTipoConexion;
	}
	
	public void setsFinalQueryTipoConexion(String sFinalQueryTipoConexion) {
		this.sFinalQueryTipoConexion= sFinalQueryTipoConexion;
	}
	
	public Border resaltarSeleccionarTipoConexion=null;
	
	public Border setResaltarSeleccionarTipoConexion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConexionBeanSwingJInternalFrame tipoconexionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoconexionBeanSwingJInternalFrame.jTtoolBarTipoConexion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoConexion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoConexion() {
		return this.resaltarSeleccionarTipoConexion;
	}
	
	public void setResaltarSeleccionarTipoConexion(Border borderResaltarSeleccionarTipoConexion) {
		this.resaltarSeleccionarTipoConexion= borderResaltarSeleccionarTipoConexion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoConexion=null;
	public Boolean mostraridTipoConexion=true;
	public Boolean activaridTipoConexion=true;

	public Border resaltarnombreTipoConexion=null;
	public Boolean mostrarnombreTipoConexion=true;
	public Boolean activarnombreTipoConexion=true;

	public Border resaltardescripcionTipoConexion=null;
	public Boolean mostrardescripcionTipoConexion=true;
	public Boolean activardescripcionTipoConexion=true;

	
	

	public Border setResaltaridTipoConexion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConexionBeanSwingJInternalFrame tipoconexionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoconexionBeanSwingJInternalFrame.jTtoolBarTipoConexion.setBorder(borderResaltar);
		
		this.resaltaridTipoConexion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoConexion() {
		return this.resaltaridTipoConexion;
	}

	public void setResaltaridTipoConexion(Border borderResaltar) {
		this.resaltaridTipoConexion= borderResaltar;
	}

	public Boolean getMostraridTipoConexion() {
		return this.mostraridTipoConexion;
	}

	public void setMostraridTipoConexion(Boolean mostraridTipoConexion) {
		this.mostraridTipoConexion= mostraridTipoConexion;
	}

	public Boolean getActivaridTipoConexion() {
		return this.activaridTipoConexion;
	}

	public void setActivaridTipoConexion(Boolean activaridTipoConexion) {
		this.activaridTipoConexion= activaridTipoConexion;
	}

	public Border setResaltarnombreTipoConexion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConexionBeanSwingJInternalFrame tipoconexionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoconexionBeanSwingJInternalFrame.jTtoolBarTipoConexion.setBorder(borderResaltar);
		
		this.resaltarnombreTipoConexion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoConexion() {
		return this.resaltarnombreTipoConexion;
	}

	public void setResaltarnombreTipoConexion(Border borderResaltar) {
		this.resaltarnombreTipoConexion= borderResaltar;
	}

	public Boolean getMostrarnombreTipoConexion() {
		return this.mostrarnombreTipoConexion;
	}

	public void setMostrarnombreTipoConexion(Boolean mostrarnombreTipoConexion) {
		this.mostrarnombreTipoConexion= mostrarnombreTipoConexion;
	}

	public Boolean getActivarnombreTipoConexion() {
		return this.activarnombreTipoConexion;
	}

	public void setActivarnombreTipoConexion(Boolean activarnombreTipoConexion) {
		this.activarnombreTipoConexion= activarnombreTipoConexion;
	}

	public Border setResaltardescripcionTipoConexion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConexionBeanSwingJInternalFrame tipoconexionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoconexionBeanSwingJInternalFrame.jTtoolBarTipoConexion.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoConexion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoConexion() {
		return this.resaltardescripcionTipoConexion;
	}

	public void setResaltardescripcionTipoConexion(Border borderResaltar) {
		this.resaltardescripcionTipoConexion= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoConexion() {
		return this.mostrardescripcionTipoConexion;
	}

	public void setMostrardescripcionTipoConexion(Boolean mostrardescripcionTipoConexion) {
		this.mostrardescripcionTipoConexion= mostrardescripcionTipoConexion;
	}

	public Boolean getActivardescripcionTipoConexion() {
		return this.activardescripcionTipoConexion;
	}

	public void setActivardescripcionTipoConexion(Boolean activardescripcionTipoConexion) {
		this.activardescripcionTipoConexion= activardescripcionTipoConexion;
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
		
		
		this.setMostraridTipoConexion(esInicial);
		this.setMostrarnombreTipoConexion(esInicial);
		this.setMostrardescripcionTipoConexion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoConexionConstantesFunciones.ID)) {
				this.setMostraridTipoConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConexionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConexionConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoConexion(esAsigna);
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
		
		
		this.setActivaridTipoConexion(esInicial);
		this.setActivarnombreTipoConexion(esInicial);
		this.setActivardescripcionTipoConexion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoConexionConstantesFunciones.ID)) {
				this.setActivaridTipoConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConexionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConexionConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoConexion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoConexionBeanSwingJInternalFrame tipoconexionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoConexion(esInicial);
		this.setResaltarnombreTipoConexion(esInicial);
		this.setResaltardescripcionTipoConexion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoConexionConstantesFunciones.ID)) {
				this.setResaltaridTipoConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConexionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoConexion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConexionConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoConexion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarConexionTipoConexion=null;

	public Border getResaltarConexionTipoConexion() {
		return this.resaltarConexionTipoConexion;
	}

	public void setResaltarConexionTipoConexion(Border borderResaltarConexion) {
		if(borderResaltarConexion!=null) {
			this.resaltarConexionTipoConexion= borderResaltarConexion;
		}
	}

	public Border setResaltarConexionTipoConexion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConexionBeanSwingJInternalFrame tipoconexionBeanSwingJInternalFrame*/) {
		Border borderResaltarConexion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoconexionBeanSwingJInternalFrame.jTtoolBarTipoConexion.setBorder(borderResaltarConexion);
			
		this.resaltarConexionTipoConexion= borderResaltarConexion;

		 return borderResaltarConexion;
	}



	public Boolean mostrarConexionTipoConexion=true;

	public Boolean getMostrarConexionTipoConexion() {
		return this.mostrarConexionTipoConexion;
	}

	public void setMostrarConexionTipoConexion(Boolean visibilidadResaltarConexion) {
		this.mostrarConexionTipoConexion= visibilidadResaltarConexion;
	}



	public Boolean activarConexionTipoConexion=true;

	public Boolean gethabilitarResaltarConexionTipoConexion() {
		return this.activarConexionTipoConexion;
	}

	public void setActivarConexionTipoConexion(Boolean habilitarResaltarConexion) {
		this.activarConexionTipoConexion= habilitarResaltarConexion;
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

		this.setMostrarConexionTipoConexion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Conexion.class)) {
				this.setMostrarConexionTipoConexion(esAsigna);
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

		this.setActivarConexionTipoConexion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Conexion.class)) {
				this.setActivarConexionTipoConexion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoConexionBeanSwingJInternalFrame tipoconexionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarConexionTipoConexion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Conexion.class)) {
				this.setResaltarConexionTipoConexion(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}