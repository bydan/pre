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


import com.bydan.erp.contabilidad.util.EstadoPeriodoConstantesFunciones;
import com.bydan.erp.contabilidad.util.EstadoPeriodoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.EstadoPeriodoParameterGeneral;

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
final public class EstadoPeriodoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoPeriodo";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoPeriodo"+EstadoPeriodoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoPeriodoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoPeriodoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoPeriodoConstantesFunciones.SCHEMA+"_"+EstadoPeriodoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoPeriodoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoPeriodoConstantesFunciones.SCHEMA+"_"+EstadoPeriodoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoPeriodoConstantesFunciones.SCHEMA+"_"+EstadoPeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoPeriodoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoPeriodoConstantesFunciones.SCHEMA+"_"+EstadoPeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoPeriodoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoPeriodoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoPeriodoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoPeriodoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoPeriodoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoPeriodoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Periodos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Periodo";
	public static final String SCLASSWEBTITULO_LOWER="Estado Periodo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoPeriodo";
	public static final String OBJECTNAME="estadoperiodo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="estado_periodo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadoperiodo from "+EstadoPeriodoConstantesFunciones.SPERSISTENCENAME+" estadoperiodo";
	public static String QUERYSELECTNATIVE="select "+EstadoPeriodoConstantesFunciones.SCHEMA+"."+EstadoPeriodoConstantesFunciones.TABLENAME+".id,"+EstadoPeriodoConstantesFunciones.SCHEMA+"."+EstadoPeriodoConstantesFunciones.TABLENAME+".version_row,"+EstadoPeriodoConstantesFunciones.SCHEMA+"."+EstadoPeriodoConstantesFunciones.TABLENAME+".codigo,"+EstadoPeriodoConstantesFunciones.SCHEMA+"."+EstadoPeriodoConstantesFunciones.TABLENAME+".nombre,"+EstadoPeriodoConstantesFunciones.SCHEMA+"."+EstadoPeriodoConstantesFunciones.TABLENAME+".es_defecto from "+EstadoPeriodoConstantesFunciones.SCHEMA+"."+EstadoPeriodoConstantesFunciones.TABLENAME;//+" as "+EstadoPeriodoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String ESDEFECTO= "es_defecto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_ESDEFECTO= "Es Defecto";
		public static final String LABEL_ESDEFECTO_LOWER= "Es Defecto";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getEstadoPeriodoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoPeriodoConstantesFunciones.CODIGO)) {sLabelColumna=EstadoPeriodoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoPeriodoConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoPeriodoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(EstadoPeriodoConstantesFunciones.ESDEFECTO)) {sLabelColumna=EstadoPeriodoConstantesFunciones.LABEL_ESDEFECTO;}
		
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
	
	
	
			
			
			
			
		
	public static String getes_defectoDescripcion(EstadoPeriodo estadoperiodo) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!estadoperiodo.getes_defecto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_defectoHtmlDescripcion(EstadoPeriodo estadoperiodo) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(estadoperiodo.getId(),estadoperiodo.getes_defecto());

		return sDescripcion;
	}	
	
	public static String getEstadoPeriodoDescripcion(EstadoPeriodo estadoperiodo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadoperiodo !=null/* && estadoperiodo.getId()!=0*/) {
			sDescripcion=estadoperiodo.getcodigo();//estadoperiodoestadoperiodo.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoPeriodoDescripcionDetallado(EstadoPeriodo estadoperiodo) {
		String sDescripcion="";
			
		sDescripcion+=EstadoPeriodoConstantesFunciones.ID+"=";
		sDescripcion+=estadoperiodo.getId().toString()+",";
		sDescripcion+=EstadoPeriodoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadoperiodo.getVersionRow().toString()+",";
		sDescripcion+=EstadoPeriodoConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadoperiodo.getcodigo()+",";
		sDescripcion+=EstadoPeriodoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadoperiodo.getnombre()+",";
		sDescripcion+=EstadoPeriodoConstantesFunciones.ESDEFECTO+"=";
		sDescripcion+=estadoperiodo.getes_defecto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoPeriodoDescripcion(EstadoPeriodo estadoperiodo,String sValor) throws Exception {			
		if(estadoperiodo !=null) {
			estadoperiodo.setcodigo(sValor);;//estadoperiodoestadoperiodo.getcodigo().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("PorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndicePorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEstadoPeriodo(EstadoPeriodo estadoperiodo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadoperiodo.setcodigo(estadoperiodo.getcodigo().trim());
		estadoperiodo.setnombre(estadoperiodo.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoPeriodos(List<EstadoPeriodo> estadoperiodos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoPeriodo estadoperiodo: estadoperiodos) {
			estadoperiodo.setcodigo(estadoperiodo.getcodigo().trim());
			estadoperiodo.setnombre(estadoperiodo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoPeriodo(EstadoPeriodo estadoperiodo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadoperiodo.getConCambioAuxiliar()) {
			estadoperiodo.setIsDeleted(estadoperiodo.getIsDeletedAuxiliar());	
			estadoperiodo.setIsNew(estadoperiodo.getIsNewAuxiliar());	
			estadoperiodo.setIsChanged(estadoperiodo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadoperiodo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadoperiodo.setIsDeletedAuxiliar(false);	
			estadoperiodo.setIsNewAuxiliar(false);	
			estadoperiodo.setIsChangedAuxiliar(false);
			
			estadoperiodo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoPeriodos(List<EstadoPeriodo> estadoperiodos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoPeriodo estadoperiodo : estadoperiodos) {
			if(conAsignarBase && estadoperiodo.getConCambioAuxiliar()) {
				estadoperiodo.setIsDeleted(estadoperiodo.getIsDeletedAuxiliar());	
				estadoperiodo.setIsNew(estadoperiodo.getIsNewAuxiliar());	
				estadoperiodo.setIsChanged(estadoperiodo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadoperiodo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadoperiodo.setIsDeletedAuxiliar(false);	
				estadoperiodo.setIsNewAuxiliar(false);	
				estadoperiodo.setIsChangedAuxiliar(false);
				
				estadoperiodo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoPeriodo(EstadoPeriodo estadoperiodo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoPeriodos(List<EstadoPeriodo> estadoperiodos,Boolean conEnteros) throws Exception  {
		
		for(EstadoPeriodo estadoperiodo: estadoperiodos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoPeriodo(List<EstadoPeriodo> estadoperiodos,EstadoPeriodo estadoperiodoAux) throws Exception  {
		EstadoPeriodoConstantesFunciones.InicializarValoresEstadoPeriodo(estadoperiodoAux,true);
		
		for(EstadoPeriodo estadoperiodo: estadoperiodos) {
			if(estadoperiodo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoPeriodo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoPeriodoConstantesFunciones.getArrayColumnasGlobalesEstadoPeriodo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoPeriodo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoPeriodo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoPeriodo> estadoperiodos,EstadoPeriodo estadoperiodo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoPeriodo estadoperiodoAux: estadoperiodos) {
			if(estadoperiodoAux!=null && estadoperiodo!=null) {
				if((estadoperiodoAux.getId()==null && estadoperiodo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadoperiodoAux.getId()!=null && estadoperiodo.getId()!=null){
					if(estadoperiodoAux.getId().equals(estadoperiodo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoPeriodo(List<EstadoPeriodo> estadoperiodos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoPeriodo estadoperiodo: estadoperiodos) {			
			if(estadoperiodo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoPeriodo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoPeriodoConstantesFunciones.LABEL_ID, EstadoPeriodoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoPeriodoConstantesFunciones.LABEL_VERSIONROW, EstadoPeriodoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoPeriodoConstantesFunciones.LABEL_CODIGO, EstadoPeriodoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoPeriodoConstantesFunciones.LABEL_NOMBRE, EstadoPeriodoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoPeriodoConstantesFunciones.LABEL_ESDEFECTO, EstadoPeriodoConstantesFunciones.ESDEFECTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoPeriodo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoPeriodoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoPeriodoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoPeriodoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoPeriodoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoPeriodoConstantesFunciones.ESDEFECTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoPeriodo() throws Exception  {
		return EstadoPeriodoConstantesFunciones.getTiposSeleccionarEstadoPeriodo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoPeriodo(Boolean conFk) throws Exception  {
		return EstadoPeriodoConstantesFunciones.getTiposSeleccionarEstadoPeriodo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoPeriodo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoPeriodoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoPeriodoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoPeriodoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoPeriodoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoPeriodoConstantesFunciones.LABEL_ESDEFECTO);
			reporte.setsDescripcion(EstadoPeriodoConstantesFunciones.LABEL_ESDEFECTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoPeriodo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoPeriodo(EstadoPeriodo estadoperiodoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoPeriodo(List<EstadoPeriodo> estadoperiodosTemp) throws Exception {
		for(EstadoPeriodo estadoperiodoAux:estadoperiodosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoPeriodo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoPeriodo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoPeriodo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoPeriodoConstantesFunciones.getClassesRelationshipsOfEstadoPeriodo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoPeriodo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Periodo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoPeriodo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoPeriodoConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoPeriodo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoPeriodo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
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
	public static void actualizarLista(EstadoPeriodo estadoperiodo,List<EstadoPeriodo> estadoperiodos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoPeriodo estadoperiodoEncontrado=null;
			
			for(EstadoPeriodo estadoperiodoLocal:estadoperiodos) {
				if(estadoperiodoLocal.getId().equals(estadoperiodo.getId())) {
					estadoperiodoEncontrado=estadoperiodoLocal;
					
					estadoperiodoLocal.setIsChanged(estadoperiodo.getIsChanged());
					estadoperiodoLocal.setIsNew(estadoperiodo.getIsNew());
					estadoperiodoLocal.setIsDeleted(estadoperiodo.getIsDeleted());
					
					estadoperiodoLocal.setGeneralEntityOriginal(estadoperiodo.getGeneralEntityOriginal());
					
					estadoperiodoLocal.setId(estadoperiodo.getId());	
					estadoperiodoLocal.setVersionRow(estadoperiodo.getVersionRow());	
					estadoperiodoLocal.setcodigo(estadoperiodo.getcodigo());	
					estadoperiodoLocal.setnombre(estadoperiodo.getnombre());	
					estadoperiodoLocal.setes_defecto(estadoperiodo.getes_defecto());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!estadoperiodo.getIsDeleted()) {
				if(!existe) {
					estadoperiodos.add(estadoperiodo);
				}
			} else {
				if(estadoperiodoEncontrado!=null && permiteQuitar)  {
					estadoperiodos.remove(estadoperiodoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoPeriodo estadoperiodo,List<EstadoPeriodo> estadoperiodos) throws Exception {
		try	{			
			for(EstadoPeriodo estadoperiodoLocal:estadoperiodos) {
				if(estadoperiodoLocal.getId().equals(estadoperiodo.getId())) {
					estadoperiodoLocal.setIsSelected(estadoperiodo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoPeriodo(List<EstadoPeriodo> estadoperiodosAux) throws Exception {
		//this.estadoperiodosAux=estadoperiodosAux;
		
		for(EstadoPeriodo estadoperiodoAux:estadoperiodosAux) {
			if(estadoperiodoAux.getIsChanged()) {
				estadoperiodoAux.setIsChanged(false);
			}		
			
			if(estadoperiodoAux.getIsNew()) {
				estadoperiodoAux.setIsNew(false);
			}	
			
			if(estadoperiodoAux.getIsDeleted()) {
				estadoperiodoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoPeriodo(EstadoPeriodo estadoperiodoAux) throws Exception {
		//this.estadoperiodoAux=estadoperiodoAux;
		
			if(estadoperiodoAux.getIsChanged()) {
				estadoperiodoAux.setIsChanged(false);
			}		
			
			if(estadoperiodoAux.getIsNew()) {
				estadoperiodoAux.setIsNew(false);
			}	
			
			if(estadoperiodoAux.getIsDeleted()) {
				estadoperiodoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoPeriodo estadoperiodoAsignar,EstadoPeriodo estadoperiodo) throws Exception {
		estadoperiodoAsignar.setId(estadoperiodo.getId());	
		estadoperiodoAsignar.setVersionRow(estadoperiodo.getVersionRow());	
		estadoperiodoAsignar.setcodigo(estadoperiodo.getcodigo());	
		estadoperiodoAsignar.setnombre(estadoperiodo.getnombre());	
		estadoperiodoAsignar.setes_defecto(estadoperiodo.getes_defecto());	
	}
	
	public static void inicializarEstadoPeriodo(EstadoPeriodo estadoperiodo) throws Exception {
		try {
				estadoperiodo.setId(0L);	
					
				estadoperiodo.setcodigo("");	
				estadoperiodo.setnombre("");	
				estadoperiodo.setes_defecto(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoPeriodo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoPeriodoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoPeriodoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoPeriodoConstantesFunciones.LABEL_ESDEFECTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoPeriodo(String sTipo,Row row,Workbook workbook,EstadoPeriodo estadoperiodo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoperiodo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoperiodo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(estadoperiodo.getes_defecto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoPeriodo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoPeriodo() {
		return this.sFinalQueryEstadoPeriodo;
	}
	
	public void setsFinalQueryEstadoPeriodo(String sFinalQueryEstadoPeriodo) {
		this.sFinalQueryEstadoPeriodo= sFinalQueryEstadoPeriodo;
	}
	
	public Border resaltarSeleccionarEstadoPeriodo=null;
	
	public Border setResaltarSeleccionarEstadoPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPeriodoBeanSwingJInternalFrame estadoperiodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadoperiodoBeanSwingJInternalFrame.jTtoolBarEstadoPeriodo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoPeriodo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoPeriodo() {
		return this.resaltarSeleccionarEstadoPeriodo;
	}
	
	public void setResaltarSeleccionarEstadoPeriodo(Border borderResaltarSeleccionarEstadoPeriodo) {
		this.resaltarSeleccionarEstadoPeriodo= borderResaltarSeleccionarEstadoPeriodo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoPeriodo=null;
	public Boolean mostraridEstadoPeriodo=true;
	public Boolean activaridEstadoPeriodo=true;

	public Border resaltarcodigoEstadoPeriodo=null;
	public Boolean mostrarcodigoEstadoPeriodo=true;
	public Boolean activarcodigoEstadoPeriodo=true;

	public Border resaltarnombreEstadoPeriodo=null;
	public Boolean mostrarnombreEstadoPeriodo=true;
	public Boolean activarnombreEstadoPeriodo=true;

	public Border resaltares_defectoEstadoPeriodo=null;
	public Boolean mostrares_defectoEstadoPeriodo=true;
	public Boolean activares_defectoEstadoPeriodo=true;

	
	

	public Border setResaltaridEstadoPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPeriodoBeanSwingJInternalFrame estadoperiodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoperiodoBeanSwingJInternalFrame.jTtoolBarEstadoPeriodo.setBorder(borderResaltar);
		
		this.resaltaridEstadoPeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoPeriodo() {
		return this.resaltaridEstadoPeriodo;
	}

	public void setResaltaridEstadoPeriodo(Border borderResaltar) {
		this.resaltaridEstadoPeriodo= borderResaltar;
	}

	public Boolean getMostraridEstadoPeriodo() {
		return this.mostraridEstadoPeriodo;
	}

	public void setMostraridEstadoPeriodo(Boolean mostraridEstadoPeriodo) {
		this.mostraridEstadoPeriodo= mostraridEstadoPeriodo;
	}

	public Boolean getActivaridEstadoPeriodo() {
		return this.activaridEstadoPeriodo;
	}

	public void setActivaridEstadoPeriodo(Boolean activaridEstadoPeriodo) {
		this.activaridEstadoPeriodo= activaridEstadoPeriodo;
	}

	public Border setResaltarcodigoEstadoPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPeriodoBeanSwingJInternalFrame estadoperiodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoperiodoBeanSwingJInternalFrame.jTtoolBarEstadoPeriodo.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoPeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoPeriodo() {
		return this.resaltarcodigoEstadoPeriodo;
	}

	public void setResaltarcodigoEstadoPeriodo(Border borderResaltar) {
		this.resaltarcodigoEstadoPeriodo= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoPeriodo() {
		return this.mostrarcodigoEstadoPeriodo;
	}

	public void setMostrarcodigoEstadoPeriodo(Boolean mostrarcodigoEstadoPeriodo) {
		this.mostrarcodigoEstadoPeriodo= mostrarcodigoEstadoPeriodo;
	}

	public Boolean getActivarcodigoEstadoPeriodo() {
		return this.activarcodigoEstadoPeriodo;
	}

	public void setActivarcodigoEstadoPeriodo(Boolean activarcodigoEstadoPeriodo) {
		this.activarcodigoEstadoPeriodo= activarcodigoEstadoPeriodo;
	}

	public Border setResaltarnombreEstadoPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPeriodoBeanSwingJInternalFrame estadoperiodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoperiodoBeanSwingJInternalFrame.jTtoolBarEstadoPeriodo.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoPeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoPeriodo() {
		return this.resaltarnombreEstadoPeriodo;
	}

	public void setResaltarnombreEstadoPeriodo(Border borderResaltar) {
		this.resaltarnombreEstadoPeriodo= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoPeriodo() {
		return this.mostrarnombreEstadoPeriodo;
	}

	public void setMostrarnombreEstadoPeriodo(Boolean mostrarnombreEstadoPeriodo) {
		this.mostrarnombreEstadoPeriodo= mostrarnombreEstadoPeriodo;
	}

	public Boolean getActivarnombreEstadoPeriodo() {
		return this.activarnombreEstadoPeriodo;
	}

	public void setActivarnombreEstadoPeriodo(Boolean activarnombreEstadoPeriodo) {
		this.activarnombreEstadoPeriodo= activarnombreEstadoPeriodo;
	}

	public Border setResaltares_defectoEstadoPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPeriodoBeanSwingJInternalFrame estadoperiodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoperiodoBeanSwingJInternalFrame.jTtoolBarEstadoPeriodo.setBorder(borderResaltar);
		
		this.resaltares_defectoEstadoPeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_defectoEstadoPeriodo() {
		return this.resaltares_defectoEstadoPeriodo;
	}

	public void setResaltares_defectoEstadoPeriodo(Border borderResaltar) {
		this.resaltares_defectoEstadoPeriodo= borderResaltar;
	}

	public Boolean getMostrares_defectoEstadoPeriodo() {
		return this.mostrares_defectoEstadoPeriodo;
	}

	public void setMostrares_defectoEstadoPeriodo(Boolean mostrares_defectoEstadoPeriodo) {
		this.mostrares_defectoEstadoPeriodo= mostrares_defectoEstadoPeriodo;
	}

	public Boolean getActivares_defectoEstadoPeriodo() {
		return this.activares_defectoEstadoPeriodo;
	}

	public void setActivares_defectoEstadoPeriodo(Boolean activares_defectoEstadoPeriodo) {
		this.activares_defectoEstadoPeriodo= activares_defectoEstadoPeriodo;
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
		
		
		this.setMostraridEstadoPeriodo(esInicial);
		this.setMostrarcodigoEstadoPeriodo(esInicial);
		this.setMostrarnombreEstadoPeriodo(esInicial);
		this.setMostrares_defectoEstadoPeriodo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoPeriodoConstantesFunciones.ID)) {
				this.setMostraridEstadoPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPeriodoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPeriodoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPeriodoConstantesFunciones.ESDEFECTO)) {
				this.setMostrares_defectoEstadoPeriodo(esAsigna);
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
		
		
		this.setActivaridEstadoPeriodo(esInicial);
		this.setActivarcodigoEstadoPeriodo(esInicial);
		this.setActivarnombreEstadoPeriodo(esInicial);
		this.setActivares_defectoEstadoPeriodo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoPeriodoConstantesFunciones.ID)) {
				this.setActivaridEstadoPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPeriodoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPeriodoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPeriodoConstantesFunciones.ESDEFECTO)) {
				this.setActivares_defectoEstadoPeriodo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoPeriodoBeanSwingJInternalFrame estadoperiodoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoPeriodo(esInicial);
		this.setResaltarcodigoEstadoPeriodo(esInicial);
		this.setResaltarnombreEstadoPeriodo(esInicial);
		this.setResaltares_defectoEstadoPeriodo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoPeriodoConstantesFunciones.ID)) {
				this.setResaltaridEstadoPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPeriodoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPeriodoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPeriodoConstantesFunciones.ESDEFECTO)) {
				this.setResaltares_defectoEstadoPeriodo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoPeriodoBeanSwingJInternalFrame estadoperiodoBeanSwingJInternalFrame*/)throws Exception {	
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