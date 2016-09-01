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
package com.bydan.erp.tesoreria.util;

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


import com.bydan.erp.tesoreria.util.EstadoPagoAutoConstantesFunciones;
import com.bydan.erp.tesoreria.util.EstadoPagoAutoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.EstadoPagoAutoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoPagoAutoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoPagoAuto";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoPagoAuto"+EstadoPagoAutoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoPagoAutoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoPagoAutoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoPagoAutoConstantesFunciones.SCHEMA+"_"+EstadoPagoAutoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoPagoAutoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoPagoAutoConstantesFunciones.SCHEMA+"_"+EstadoPagoAutoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoPagoAutoConstantesFunciones.SCHEMA+"_"+EstadoPagoAutoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoPagoAutoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoPagoAutoConstantesFunciones.SCHEMA+"_"+EstadoPagoAutoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPagoAutoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoPagoAutoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPagoAutoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPagoAutoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoPagoAutoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPagoAutoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoPagoAutoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoPagoAutoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoPagoAutoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoPagoAutoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Pago Automaticos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Pago Automatico";
	public static final String SCLASSWEBTITULO_LOWER="Estado Pago Auto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoPagoAuto";
	public static final String OBJECTNAME="estadopagoauto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="estado_pago_auto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadopagoauto from "+EstadoPagoAutoConstantesFunciones.SPERSISTENCENAME+" estadopagoauto";
	public static String QUERYSELECTNATIVE="select "+EstadoPagoAutoConstantesFunciones.SCHEMA+"."+EstadoPagoAutoConstantesFunciones.TABLENAME+".id,"+EstadoPagoAutoConstantesFunciones.SCHEMA+"."+EstadoPagoAutoConstantesFunciones.TABLENAME+".version_row,"+EstadoPagoAutoConstantesFunciones.SCHEMA+"."+EstadoPagoAutoConstantesFunciones.TABLENAME+".nombre from "+EstadoPagoAutoConstantesFunciones.SCHEMA+"."+EstadoPagoAutoConstantesFunciones.TABLENAME;//+" as "+EstadoPagoAutoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getEstadoPagoAutoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoPagoAutoConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoPagoAutoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getEstadoPagoAutoDescripcion(EstadoPagoAuto estadopagoauto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadopagoauto !=null/* && estadopagoauto.getId()!=0*/) {
			sDescripcion=estadopagoauto.getnombre();//estadopagoautoestadopagoauto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoPagoAutoDescripcionDetallado(EstadoPagoAuto estadopagoauto) {
		String sDescripcion="";
			
		sDescripcion+=EstadoPagoAutoConstantesFunciones.ID+"=";
		sDescripcion+=estadopagoauto.getId().toString()+",";
		sDescripcion+=EstadoPagoAutoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadopagoauto.getVersionRow().toString()+",";
		sDescripcion+=EstadoPagoAutoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadopagoauto.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoPagoAutoDescripcion(EstadoPagoAuto estadopagoauto,String sValor) throws Exception {			
		if(estadopagoauto !=null) {
			estadopagoauto.setnombre(sValor);//estadopagoautoestadopagoauto.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoPagoAuto(EstadoPagoAuto estadopagoauto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadopagoauto.setnombre(estadopagoauto.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoPagoAutos(List<EstadoPagoAuto> estadopagoautos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoPagoAuto estadopagoauto: estadopagoautos) {
			estadopagoauto.setnombre(estadopagoauto.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoPagoAuto(EstadoPagoAuto estadopagoauto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadopagoauto.getConCambioAuxiliar()) {
			estadopagoauto.setIsDeleted(estadopagoauto.getIsDeletedAuxiliar());	
			estadopagoauto.setIsNew(estadopagoauto.getIsNewAuxiliar());	
			estadopagoauto.setIsChanged(estadopagoauto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadopagoauto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadopagoauto.setIsDeletedAuxiliar(false);	
			estadopagoauto.setIsNewAuxiliar(false);	
			estadopagoauto.setIsChangedAuxiliar(false);
			
			estadopagoauto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoPagoAutos(List<EstadoPagoAuto> estadopagoautos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoPagoAuto estadopagoauto : estadopagoautos) {
			if(conAsignarBase && estadopagoauto.getConCambioAuxiliar()) {
				estadopagoauto.setIsDeleted(estadopagoauto.getIsDeletedAuxiliar());	
				estadopagoauto.setIsNew(estadopagoauto.getIsNewAuxiliar());	
				estadopagoauto.setIsChanged(estadopagoauto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadopagoauto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadopagoauto.setIsDeletedAuxiliar(false);	
				estadopagoauto.setIsNewAuxiliar(false);	
				estadopagoauto.setIsChangedAuxiliar(false);
				
				estadopagoauto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoPagoAuto(EstadoPagoAuto estadopagoauto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoPagoAutos(List<EstadoPagoAuto> estadopagoautos,Boolean conEnteros) throws Exception  {
		
		for(EstadoPagoAuto estadopagoauto: estadopagoautos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoPagoAuto(List<EstadoPagoAuto> estadopagoautos,EstadoPagoAuto estadopagoautoAux) throws Exception  {
		EstadoPagoAutoConstantesFunciones.InicializarValoresEstadoPagoAuto(estadopagoautoAux,true);
		
		for(EstadoPagoAuto estadopagoauto: estadopagoautos) {
			if(estadopagoauto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoPagoAuto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoPagoAutoConstantesFunciones.getArrayColumnasGlobalesEstadoPagoAuto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoPagoAuto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoPagoAuto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoPagoAuto> estadopagoautos,EstadoPagoAuto estadopagoauto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoPagoAuto estadopagoautoAux: estadopagoautos) {
			if(estadopagoautoAux!=null && estadopagoauto!=null) {
				if((estadopagoautoAux.getId()==null && estadopagoauto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadopagoautoAux.getId()!=null && estadopagoauto.getId()!=null){
					if(estadopagoautoAux.getId().equals(estadopagoauto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoPagoAuto(List<EstadoPagoAuto> estadopagoautos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoPagoAuto estadopagoauto: estadopagoautos) {			
			if(estadopagoauto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoPagoAuto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoPagoAutoConstantesFunciones.LABEL_ID, EstadoPagoAutoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoPagoAutoConstantesFunciones.LABEL_VERSIONROW, EstadoPagoAutoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoPagoAutoConstantesFunciones.LABEL_NOMBRE, EstadoPagoAutoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoPagoAuto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoPagoAutoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoPagoAutoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoPagoAutoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoPagoAuto() throws Exception  {
		return EstadoPagoAutoConstantesFunciones.getTiposSeleccionarEstadoPagoAuto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoPagoAuto(Boolean conFk) throws Exception  {
		return EstadoPagoAutoConstantesFunciones.getTiposSeleccionarEstadoPagoAuto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoPagoAuto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoPagoAutoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoPagoAutoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoPagoAuto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoPagoAuto(EstadoPagoAuto estadopagoautoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoPagoAuto(List<EstadoPagoAuto> estadopagoautosTemp) throws Exception {
		for(EstadoPagoAuto estadopagoautoAux:estadopagoautosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoPagoAuto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoPagoAuto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoPagoAuto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoPagoAutoConstantesFunciones.getClassesRelationshipsOfEstadoPagoAuto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoPagoAuto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PagoAuto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PagoAuto.class)) {
						classes.add(new Classe(PagoAuto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoPagoAuto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoPagoAutoConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoPagoAuto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoPagoAuto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PagoAuto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PagoAuto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PagoAuto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PagoAuto.class)); continue;
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
	public static void actualizarLista(EstadoPagoAuto estadopagoauto,List<EstadoPagoAuto> estadopagoautos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoPagoAuto estadopagoautoEncontrado=null;
			
			for(EstadoPagoAuto estadopagoautoLocal:estadopagoautos) {
				if(estadopagoautoLocal.getId().equals(estadopagoauto.getId())) {
					estadopagoautoEncontrado=estadopagoautoLocal;
					
					estadopagoautoLocal.setIsChanged(estadopagoauto.getIsChanged());
					estadopagoautoLocal.setIsNew(estadopagoauto.getIsNew());
					estadopagoautoLocal.setIsDeleted(estadopagoauto.getIsDeleted());
					
					estadopagoautoLocal.setGeneralEntityOriginal(estadopagoauto.getGeneralEntityOriginal());
					
					estadopagoautoLocal.setId(estadopagoauto.getId());	
					estadopagoautoLocal.setVersionRow(estadopagoauto.getVersionRow());	
					estadopagoautoLocal.setnombre(estadopagoauto.getnombre());	
					
					
					estadopagoautoLocal.setPagoAutos(estadopagoauto.getPagoAutos());
					
					existe=true;
					break;
				}
			}
			
			if(!estadopagoauto.getIsDeleted()) {
				if(!existe) {
					estadopagoautos.add(estadopagoauto);
				}
			} else {
				if(estadopagoautoEncontrado!=null && permiteQuitar)  {
					estadopagoautos.remove(estadopagoautoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoPagoAuto estadopagoauto,List<EstadoPagoAuto> estadopagoautos) throws Exception {
		try	{			
			for(EstadoPagoAuto estadopagoautoLocal:estadopagoautos) {
				if(estadopagoautoLocal.getId().equals(estadopagoauto.getId())) {
					estadopagoautoLocal.setIsSelected(estadopagoauto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoPagoAuto(List<EstadoPagoAuto> estadopagoautosAux) throws Exception {
		//this.estadopagoautosAux=estadopagoautosAux;
		
		for(EstadoPagoAuto estadopagoautoAux:estadopagoautosAux) {
			if(estadopagoautoAux.getIsChanged()) {
				estadopagoautoAux.setIsChanged(false);
			}		
			
			if(estadopagoautoAux.getIsNew()) {
				estadopagoautoAux.setIsNew(false);
			}	
			
			if(estadopagoautoAux.getIsDeleted()) {
				estadopagoautoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoPagoAuto(EstadoPagoAuto estadopagoautoAux) throws Exception {
		//this.estadopagoautoAux=estadopagoautoAux;
		
			if(estadopagoautoAux.getIsChanged()) {
				estadopagoautoAux.setIsChanged(false);
			}		
			
			if(estadopagoautoAux.getIsNew()) {
				estadopagoautoAux.setIsNew(false);
			}	
			
			if(estadopagoautoAux.getIsDeleted()) {
				estadopagoautoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoPagoAuto estadopagoautoAsignar,EstadoPagoAuto estadopagoauto) throws Exception {
		estadopagoautoAsignar.setId(estadopagoauto.getId());	
		estadopagoautoAsignar.setVersionRow(estadopagoauto.getVersionRow());	
		estadopagoautoAsignar.setnombre(estadopagoauto.getnombre());	
	}
	
	public static void inicializarEstadoPagoAuto(EstadoPagoAuto estadopagoauto) throws Exception {
		try {
				estadopagoauto.setId(0L);	
					
				estadopagoauto.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoPagoAuto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoPagoAutoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoPagoAuto(String sTipo,Row row,Workbook workbook,EstadoPagoAuto estadopagoauto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadopagoauto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoPagoAuto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoPagoAuto() {
		return this.sFinalQueryEstadoPagoAuto;
	}
	
	public void setsFinalQueryEstadoPagoAuto(String sFinalQueryEstadoPagoAuto) {
		this.sFinalQueryEstadoPagoAuto= sFinalQueryEstadoPagoAuto;
	}
	
	public Border resaltarSeleccionarEstadoPagoAuto=null;
	
	public Border setResaltarSeleccionarEstadoPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPagoAutoBeanSwingJInternalFrame estadopagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadopagoautoBeanSwingJInternalFrame.jTtoolBarEstadoPagoAuto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoPagoAuto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoPagoAuto() {
		return this.resaltarSeleccionarEstadoPagoAuto;
	}
	
	public void setResaltarSeleccionarEstadoPagoAuto(Border borderResaltarSeleccionarEstadoPagoAuto) {
		this.resaltarSeleccionarEstadoPagoAuto= borderResaltarSeleccionarEstadoPagoAuto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoPagoAuto=null;
	public Boolean mostraridEstadoPagoAuto=true;
	public Boolean activaridEstadoPagoAuto=true;

	public Border resaltarnombreEstadoPagoAuto=null;
	public Boolean mostrarnombreEstadoPagoAuto=true;
	public Boolean activarnombreEstadoPagoAuto=true;

	
	

	public Border setResaltaridEstadoPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPagoAutoBeanSwingJInternalFrame estadopagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadopagoautoBeanSwingJInternalFrame.jTtoolBarEstadoPagoAuto.setBorder(borderResaltar);
		
		this.resaltaridEstadoPagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoPagoAuto() {
		return this.resaltaridEstadoPagoAuto;
	}

	public void setResaltaridEstadoPagoAuto(Border borderResaltar) {
		this.resaltaridEstadoPagoAuto= borderResaltar;
	}

	public Boolean getMostraridEstadoPagoAuto() {
		return this.mostraridEstadoPagoAuto;
	}

	public void setMostraridEstadoPagoAuto(Boolean mostraridEstadoPagoAuto) {
		this.mostraridEstadoPagoAuto= mostraridEstadoPagoAuto;
	}

	public Boolean getActivaridEstadoPagoAuto() {
		return this.activaridEstadoPagoAuto;
	}

	public void setActivaridEstadoPagoAuto(Boolean activaridEstadoPagoAuto) {
		this.activaridEstadoPagoAuto= activaridEstadoPagoAuto;
	}

	public Border setResaltarnombreEstadoPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPagoAutoBeanSwingJInternalFrame estadopagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadopagoautoBeanSwingJInternalFrame.jTtoolBarEstadoPagoAuto.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoPagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoPagoAuto() {
		return this.resaltarnombreEstadoPagoAuto;
	}

	public void setResaltarnombreEstadoPagoAuto(Border borderResaltar) {
		this.resaltarnombreEstadoPagoAuto= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoPagoAuto() {
		return this.mostrarnombreEstadoPagoAuto;
	}

	public void setMostrarnombreEstadoPagoAuto(Boolean mostrarnombreEstadoPagoAuto) {
		this.mostrarnombreEstadoPagoAuto= mostrarnombreEstadoPagoAuto;
	}

	public Boolean getActivarnombreEstadoPagoAuto() {
		return this.activarnombreEstadoPagoAuto;
	}

	public void setActivarnombreEstadoPagoAuto(Boolean activarnombreEstadoPagoAuto) {
		this.activarnombreEstadoPagoAuto= activarnombreEstadoPagoAuto;
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
		
		
		this.setMostraridEstadoPagoAuto(esInicial);
		this.setMostrarnombreEstadoPagoAuto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoPagoAutoConstantesFunciones.ID)) {
				this.setMostraridEstadoPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPagoAutoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoPagoAuto(esAsigna);
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
		
		
		this.setActivaridEstadoPagoAuto(esInicial);
		this.setActivarnombreEstadoPagoAuto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoPagoAutoConstantesFunciones.ID)) {
				this.setActivaridEstadoPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPagoAutoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoPagoAuto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoPagoAutoBeanSwingJInternalFrame estadopagoautoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoPagoAuto(esInicial);
		this.setResaltarnombreEstadoPagoAuto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoPagoAutoConstantesFunciones.ID)) {
				this.setResaltaridEstadoPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPagoAutoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoPagoAuto(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPagoAutoEstadoPagoAuto=null;

	public Border getResaltarPagoAutoEstadoPagoAuto() {
		return this.resaltarPagoAutoEstadoPagoAuto;
	}

	public void setResaltarPagoAutoEstadoPagoAuto(Border borderResaltarPagoAuto) {
		if(borderResaltarPagoAuto!=null) {
			this.resaltarPagoAutoEstadoPagoAuto= borderResaltarPagoAuto;
		}
	}

	public Border setResaltarPagoAutoEstadoPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPagoAutoBeanSwingJInternalFrame estadopagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltarPagoAuto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadopagoautoBeanSwingJInternalFrame.jTtoolBarEstadoPagoAuto.setBorder(borderResaltarPagoAuto);
			
		this.resaltarPagoAutoEstadoPagoAuto= borderResaltarPagoAuto;

		 return borderResaltarPagoAuto;
	}



	public Boolean mostrarPagoAutoEstadoPagoAuto=true;

	public Boolean getMostrarPagoAutoEstadoPagoAuto() {
		return this.mostrarPagoAutoEstadoPagoAuto;
	}

	public void setMostrarPagoAutoEstadoPagoAuto(Boolean visibilidadResaltarPagoAuto) {
		this.mostrarPagoAutoEstadoPagoAuto= visibilidadResaltarPagoAuto;
	}



	public Boolean activarPagoAutoEstadoPagoAuto=true;

	public Boolean gethabilitarResaltarPagoAutoEstadoPagoAuto() {
		return this.activarPagoAutoEstadoPagoAuto;
	}

	public void setActivarPagoAutoEstadoPagoAuto(Boolean habilitarResaltarPagoAuto) {
		this.activarPagoAutoEstadoPagoAuto= habilitarResaltarPagoAuto;
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

		this.setMostrarPagoAutoEstadoPagoAuto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PagoAuto.class)) {
				this.setMostrarPagoAutoEstadoPagoAuto(esAsigna);
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

		this.setActivarPagoAutoEstadoPagoAuto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PagoAuto.class)) {
				this.setActivarPagoAutoEstadoPagoAuto(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoPagoAutoBeanSwingJInternalFrame estadopagoautoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPagoAutoEstadoPagoAuto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PagoAuto.class)) {
				this.setResaltarPagoAutoEstadoPagoAuto(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}