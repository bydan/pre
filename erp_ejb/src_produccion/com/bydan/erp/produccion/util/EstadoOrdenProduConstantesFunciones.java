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
package com.bydan.erp.produccion.util;

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


import com.bydan.erp.produccion.util.EstadoOrdenProduConstantesFunciones;
import com.bydan.erp.produccion.util.EstadoOrdenProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.EstadoOrdenProduParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoOrdenProduConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoOrdenProdu";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoOrdenProdu"+EstadoOrdenProduConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoOrdenProduHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoOrdenProduHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoOrdenProduConstantesFunciones.SCHEMA+"_"+EstadoOrdenProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoOrdenProduHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoOrdenProduConstantesFunciones.SCHEMA+"_"+EstadoOrdenProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoOrdenProduConstantesFunciones.SCHEMA+"_"+EstadoOrdenProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoOrdenProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoOrdenProduConstantesFunciones.SCHEMA+"_"+EstadoOrdenProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoOrdenProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoOrdenProduHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoOrdenProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoOrdenProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoOrdenProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoOrdenProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoOrdenProduConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoOrdenProduConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoOrdenProduConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoOrdenProduConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Orden Produccions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Orden Produccion";
	public static final String SCLASSWEBTITULO_LOWER="Estado Orden Produ";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoOrdenProdu";
	public static final String OBJECTNAME="estadoordenprodu";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="estado_orden_produ";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadoordenprodu from "+EstadoOrdenProduConstantesFunciones.SPERSISTENCENAME+" estadoordenprodu";
	public static String QUERYSELECTNATIVE="select "+EstadoOrdenProduConstantesFunciones.SCHEMA+"."+EstadoOrdenProduConstantesFunciones.TABLENAME+".id,"+EstadoOrdenProduConstantesFunciones.SCHEMA+"."+EstadoOrdenProduConstantesFunciones.TABLENAME+".version_row,"+EstadoOrdenProduConstantesFunciones.SCHEMA+"."+EstadoOrdenProduConstantesFunciones.TABLENAME+".nombre from "+EstadoOrdenProduConstantesFunciones.SCHEMA+"."+EstadoOrdenProduConstantesFunciones.TABLENAME;//+" as "+EstadoOrdenProduConstantesFunciones.TABLENAME;
	
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
	
	public static String getEstadoOrdenProduLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoOrdenProduConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoOrdenProduConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getEstadoOrdenProduDescripcion(EstadoOrdenProdu estadoordenprodu) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadoordenprodu !=null/* && estadoordenprodu.getId()!=0*/) {
			sDescripcion=estadoordenprodu.getnombre();//estadoordenproduestadoordenprodu.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoOrdenProduDescripcionDetallado(EstadoOrdenProdu estadoordenprodu) {
		String sDescripcion="";
			
		sDescripcion+=EstadoOrdenProduConstantesFunciones.ID+"=";
		sDescripcion+=estadoordenprodu.getId().toString()+",";
		sDescripcion+=EstadoOrdenProduConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadoordenprodu.getVersionRow().toString()+",";
		sDescripcion+=EstadoOrdenProduConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadoordenprodu.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoOrdenProduDescripcion(EstadoOrdenProdu estadoordenprodu,String sValor) throws Exception {			
		if(estadoordenprodu !=null) {
			estadoordenprodu.setnombre(sValor);;//estadoordenproduestadoordenprodu.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoOrdenProdu(EstadoOrdenProdu estadoordenprodu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadoordenprodu.setnombre(estadoordenprodu.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoOrdenProdus(List<EstadoOrdenProdu> estadoordenprodus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoOrdenProdu estadoordenprodu: estadoordenprodus) {
			estadoordenprodu.setnombre(estadoordenprodu.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoOrdenProdu(EstadoOrdenProdu estadoordenprodu,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadoordenprodu.getConCambioAuxiliar()) {
			estadoordenprodu.setIsDeleted(estadoordenprodu.getIsDeletedAuxiliar());	
			estadoordenprodu.setIsNew(estadoordenprodu.getIsNewAuxiliar());	
			estadoordenprodu.setIsChanged(estadoordenprodu.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadoordenprodu.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadoordenprodu.setIsDeletedAuxiliar(false);	
			estadoordenprodu.setIsNewAuxiliar(false);	
			estadoordenprodu.setIsChangedAuxiliar(false);
			
			estadoordenprodu.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoOrdenProdus(List<EstadoOrdenProdu> estadoordenprodus,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoOrdenProdu estadoordenprodu : estadoordenprodus) {
			if(conAsignarBase && estadoordenprodu.getConCambioAuxiliar()) {
				estadoordenprodu.setIsDeleted(estadoordenprodu.getIsDeletedAuxiliar());	
				estadoordenprodu.setIsNew(estadoordenprodu.getIsNewAuxiliar());	
				estadoordenprodu.setIsChanged(estadoordenprodu.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadoordenprodu.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadoordenprodu.setIsDeletedAuxiliar(false);	
				estadoordenprodu.setIsNewAuxiliar(false);	
				estadoordenprodu.setIsChangedAuxiliar(false);
				
				estadoordenprodu.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoOrdenProdu(EstadoOrdenProdu estadoordenprodu,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoOrdenProdus(List<EstadoOrdenProdu> estadoordenprodus,Boolean conEnteros) throws Exception  {
		
		for(EstadoOrdenProdu estadoordenprodu: estadoordenprodus) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoOrdenProdu(List<EstadoOrdenProdu> estadoordenprodus,EstadoOrdenProdu estadoordenproduAux) throws Exception  {
		EstadoOrdenProduConstantesFunciones.InicializarValoresEstadoOrdenProdu(estadoordenproduAux,true);
		
		for(EstadoOrdenProdu estadoordenprodu: estadoordenprodus) {
			if(estadoordenprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoOrdenProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoOrdenProduConstantesFunciones.getArrayColumnasGlobalesEstadoOrdenProdu(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoOrdenProdu(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoOrdenProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoOrdenProdu> estadoordenprodus,EstadoOrdenProdu estadoordenprodu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoOrdenProdu estadoordenproduAux: estadoordenprodus) {
			if(estadoordenproduAux!=null && estadoordenprodu!=null) {
				if((estadoordenproduAux.getId()==null && estadoordenprodu.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadoordenproduAux.getId()!=null && estadoordenprodu.getId()!=null){
					if(estadoordenproduAux.getId().equals(estadoordenprodu.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoOrdenProdu(List<EstadoOrdenProdu> estadoordenprodus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoOrdenProdu estadoordenprodu: estadoordenprodus) {			
			if(estadoordenprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoOrdenProdu() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoOrdenProduConstantesFunciones.LABEL_ID, EstadoOrdenProduConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoOrdenProduConstantesFunciones.LABEL_VERSIONROW, EstadoOrdenProduConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoOrdenProduConstantesFunciones.LABEL_NOMBRE, EstadoOrdenProduConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoOrdenProdu() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoOrdenProduConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoOrdenProduConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoOrdenProduConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoOrdenProdu() throws Exception  {
		return EstadoOrdenProduConstantesFunciones.getTiposSeleccionarEstadoOrdenProdu(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoOrdenProdu(Boolean conFk) throws Exception  {
		return EstadoOrdenProduConstantesFunciones.getTiposSeleccionarEstadoOrdenProdu(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoOrdenProdu(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoOrdenProduConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoOrdenProduConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoOrdenProdu(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoOrdenProdu(EstadoOrdenProdu estadoordenproduAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoOrdenProdu(List<EstadoOrdenProdu> estadoordenprodusTemp) throws Exception {
		for(EstadoOrdenProdu estadoordenproduAux:estadoordenprodusTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoOrdenProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoOrdenProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoOrdenProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoOrdenProduConstantesFunciones.getClassesRelationshipsOfEstadoOrdenProdu(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoOrdenProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(OrdenProdu.class));
				classes.add(new Classe(PedidoProdu.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(OrdenProdu.class)) {
						classes.add(new Classe(OrdenProdu.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoProdu.class)) {
						classes.add(new Classe(PedidoProdu.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoOrdenProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoOrdenProduConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoOrdenProdu(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoOrdenProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(OrdenProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenProdu.class)); continue;
					}

					if(PedidoProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoProdu.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(OrdenProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenProdu.class)); continue;
					}

					if(PedidoProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoProdu.class)); continue;
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
	public static void actualizarLista(EstadoOrdenProdu estadoordenprodu,List<EstadoOrdenProdu> estadoordenprodus,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoOrdenProdu estadoordenproduEncontrado=null;
			
			for(EstadoOrdenProdu estadoordenproduLocal:estadoordenprodus) {
				if(estadoordenproduLocal.getId().equals(estadoordenprodu.getId())) {
					estadoordenproduEncontrado=estadoordenproduLocal;
					
					estadoordenproduLocal.setIsChanged(estadoordenprodu.getIsChanged());
					estadoordenproduLocal.setIsNew(estadoordenprodu.getIsNew());
					estadoordenproduLocal.setIsDeleted(estadoordenprodu.getIsDeleted());
					
					estadoordenproduLocal.setGeneralEntityOriginal(estadoordenprodu.getGeneralEntityOriginal());
					
					estadoordenproduLocal.setId(estadoordenprodu.getId());	
					estadoordenproduLocal.setVersionRow(estadoordenprodu.getVersionRow());	
					estadoordenproduLocal.setnombre(estadoordenprodu.getnombre());	
					
					
					estadoordenproduLocal.setPedidoProdus(estadoordenprodu.getPedidoProdus());
					
					existe=true;
					break;
				}
			}
			
			if(!estadoordenprodu.getIsDeleted()) {
				if(!existe) {
					estadoordenprodus.add(estadoordenprodu);
				}
			} else {
				if(estadoordenproduEncontrado!=null && permiteQuitar)  {
					estadoordenprodus.remove(estadoordenproduEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoOrdenProdu estadoordenprodu,List<EstadoOrdenProdu> estadoordenprodus) throws Exception {
		try	{			
			for(EstadoOrdenProdu estadoordenproduLocal:estadoordenprodus) {
				if(estadoordenproduLocal.getId().equals(estadoordenprodu.getId())) {
					estadoordenproduLocal.setIsSelected(estadoordenprodu.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoOrdenProdu(List<EstadoOrdenProdu> estadoordenprodusAux) throws Exception {
		//this.estadoordenprodusAux=estadoordenprodusAux;
		
		for(EstadoOrdenProdu estadoordenproduAux:estadoordenprodusAux) {
			if(estadoordenproduAux.getIsChanged()) {
				estadoordenproduAux.setIsChanged(false);
			}		
			
			if(estadoordenproduAux.getIsNew()) {
				estadoordenproduAux.setIsNew(false);
			}	
			
			if(estadoordenproduAux.getIsDeleted()) {
				estadoordenproduAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoOrdenProdu(EstadoOrdenProdu estadoordenproduAux) throws Exception {
		//this.estadoordenproduAux=estadoordenproduAux;
		
			if(estadoordenproduAux.getIsChanged()) {
				estadoordenproduAux.setIsChanged(false);
			}		
			
			if(estadoordenproduAux.getIsNew()) {
				estadoordenproduAux.setIsNew(false);
			}	
			
			if(estadoordenproduAux.getIsDeleted()) {
				estadoordenproduAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoOrdenProdu estadoordenproduAsignar,EstadoOrdenProdu estadoordenprodu) throws Exception {
		estadoordenproduAsignar.setId(estadoordenprodu.getId());	
		estadoordenproduAsignar.setVersionRow(estadoordenprodu.getVersionRow());	
		estadoordenproduAsignar.setnombre(estadoordenprodu.getnombre());	
	}
	
	public static void inicializarEstadoOrdenProdu(EstadoOrdenProdu estadoordenprodu) throws Exception {
		try {
				estadoordenprodu.setId(0L);	
					
				estadoordenprodu.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoOrdenProdu(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoOrdenProduConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoOrdenProdu(String sTipo,Row row,Workbook workbook,EstadoOrdenProdu estadoordenprodu,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoordenprodu.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoOrdenProdu=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoOrdenProdu() {
		return this.sFinalQueryEstadoOrdenProdu;
	}
	
	public void setsFinalQueryEstadoOrdenProdu(String sFinalQueryEstadoOrdenProdu) {
		this.sFinalQueryEstadoOrdenProdu= sFinalQueryEstadoOrdenProdu;
	}
	
	public Border resaltarSeleccionarEstadoOrdenProdu=null;
	
	public Border setResaltarSeleccionarEstadoOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoOrdenProduBeanSwingJInternalFrame estadoordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadoordenproduBeanSwingJInternalFrame.jTtoolBarEstadoOrdenProdu.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoOrdenProdu= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoOrdenProdu() {
		return this.resaltarSeleccionarEstadoOrdenProdu;
	}
	
	public void setResaltarSeleccionarEstadoOrdenProdu(Border borderResaltarSeleccionarEstadoOrdenProdu) {
		this.resaltarSeleccionarEstadoOrdenProdu= borderResaltarSeleccionarEstadoOrdenProdu;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoOrdenProdu=null;
	public Boolean mostraridEstadoOrdenProdu=true;
	public Boolean activaridEstadoOrdenProdu=true;

	public Border resaltarnombreEstadoOrdenProdu=null;
	public Boolean mostrarnombreEstadoOrdenProdu=true;
	public Boolean activarnombreEstadoOrdenProdu=true;

	
	

	public Border setResaltaridEstadoOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoOrdenProduBeanSwingJInternalFrame estadoordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoordenproduBeanSwingJInternalFrame.jTtoolBarEstadoOrdenProdu.setBorder(borderResaltar);
		
		this.resaltaridEstadoOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoOrdenProdu() {
		return this.resaltaridEstadoOrdenProdu;
	}

	public void setResaltaridEstadoOrdenProdu(Border borderResaltar) {
		this.resaltaridEstadoOrdenProdu= borderResaltar;
	}

	public Boolean getMostraridEstadoOrdenProdu() {
		return this.mostraridEstadoOrdenProdu;
	}

	public void setMostraridEstadoOrdenProdu(Boolean mostraridEstadoOrdenProdu) {
		this.mostraridEstadoOrdenProdu= mostraridEstadoOrdenProdu;
	}

	public Boolean getActivaridEstadoOrdenProdu() {
		return this.activaridEstadoOrdenProdu;
	}

	public void setActivaridEstadoOrdenProdu(Boolean activaridEstadoOrdenProdu) {
		this.activaridEstadoOrdenProdu= activaridEstadoOrdenProdu;
	}

	public Border setResaltarnombreEstadoOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoOrdenProduBeanSwingJInternalFrame estadoordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoordenproduBeanSwingJInternalFrame.jTtoolBarEstadoOrdenProdu.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoOrdenProdu() {
		return this.resaltarnombreEstadoOrdenProdu;
	}

	public void setResaltarnombreEstadoOrdenProdu(Border borderResaltar) {
		this.resaltarnombreEstadoOrdenProdu= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoOrdenProdu() {
		return this.mostrarnombreEstadoOrdenProdu;
	}

	public void setMostrarnombreEstadoOrdenProdu(Boolean mostrarnombreEstadoOrdenProdu) {
		this.mostrarnombreEstadoOrdenProdu= mostrarnombreEstadoOrdenProdu;
	}

	public Boolean getActivarnombreEstadoOrdenProdu() {
		return this.activarnombreEstadoOrdenProdu;
	}

	public void setActivarnombreEstadoOrdenProdu(Boolean activarnombreEstadoOrdenProdu) {
		this.activarnombreEstadoOrdenProdu= activarnombreEstadoOrdenProdu;
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
		
		
		this.setMostraridEstadoOrdenProdu(esInicial);
		this.setMostrarnombreEstadoOrdenProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoOrdenProduConstantesFunciones.ID)) {
				this.setMostraridEstadoOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoOrdenProduConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoOrdenProdu(esAsigna);
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
		
		
		this.setActivaridEstadoOrdenProdu(esInicial);
		this.setActivarnombreEstadoOrdenProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoOrdenProduConstantesFunciones.ID)) {
				this.setActivaridEstadoOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoOrdenProduConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoOrdenProdu(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoOrdenProduBeanSwingJInternalFrame estadoordenproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoOrdenProdu(esInicial);
		this.setResaltarnombreEstadoOrdenProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoOrdenProduConstantesFunciones.ID)) {
				this.setResaltaridEstadoOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoOrdenProduConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoOrdenProdu(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPedidoProduEstadoOrdenProdu=null;

	public Border getResaltarPedidoProduEstadoOrdenProdu() {
		return this.resaltarPedidoProduEstadoOrdenProdu;
	}

	public void setResaltarPedidoProduEstadoOrdenProdu(Border borderResaltarPedidoProdu) {
		if(borderResaltarPedidoProdu!=null) {
			this.resaltarPedidoProduEstadoOrdenProdu= borderResaltarPedidoProdu;
		}
	}

	public Border setResaltarPedidoProduEstadoOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoOrdenProduBeanSwingJInternalFrame estadoordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltarPedidoProdu=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadoordenproduBeanSwingJInternalFrame.jTtoolBarEstadoOrdenProdu.setBorder(borderResaltarPedidoProdu);
			
		this.resaltarPedidoProduEstadoOrdenProdu= borderResaltarPedidoProdu;

		 return borderResaltarPedidoProdu;
	}



	public Boolean mostrarPedidoProduEstadoOrdenProdu=true;

	public Boolean getMostrarPedidoProduEstadoOrdenProdu() {
		return this.mostrarPedidoProduEstadoOrdenProdu;
	}

	public void setMostrarPedidoProduEstadoOrdenProdu(Boolean visibilidadResaltarPedidoProdu) {
		this.mostrarPedidoProduEstadoOrdenProdu= visibilidadResaltarPedidoProdu;
	}



	public Boolean activarPedidoProduEstadoOrdenProdu=true;

	public Boolean gethabilitarResaltarPedidoProduEstadoOrdenProdu() {
		return this.activarPedidoProduEstadoOrdenProdu;
	}

	public void setActivarPedidoProduEstadoOrdenProdu(Boolean habilitarResaltarPedidoProdu) {
		this.activarPedidoProduEstadoOrdenProdu= habilitarResaltarPedidoProdu;
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

		this.setMostrarPedidoProduEstadoOrdenProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PedidoProdu.class)) {
				this.setMostrarPedidoProduEstadoOrdenProdu(esAsigna);
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

		this.setActivarPedidoProduEstadoOrdenProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PedidoProdu.class)) {
				this.setActivarPedidoProduEstadoOrdenProdu(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoOrdenProduBeanSwingJInternalFrame estadoordenproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPedidoProduEstadoOrdenProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PedidoProdu.class)) {
				this.setResaltarPedidoProduEstadoOrdenProdu(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}