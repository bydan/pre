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


import com.bydan.erp.inventario.util.EstadoServicioConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoServicioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoServicioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoServicioConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoServicio";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoServicio"+EstadoServicioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoServicioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoServicioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoServicioConstantesFunciones.SCHEMA+"_"+EstadoServicioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoServicioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoServicioConstantesFunciones.SCHEMA+"_"+EstadoServicioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoServicioConstantesFunciones.SCHEMA+"_"+EstadoServicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoServicioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoServicioConstantesFunciones.SCHEMA+"_"+EstadoServicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoServicioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoServicioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoServicioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoServicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoServicioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoServicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoServicioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoServicioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoServicioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoServicioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Servicioes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Estado Servicio";
	public static final String SCLASSWEBTITULO_LOWER="Estado Servicio";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoServicio";
	public static final String OBJECTNAME="estadoservicio";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="estado_servicio";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadoservicio from "+EstadoServicioConstantesFunciones.SPERSISTENCENAME+" estadoservicio";
	public static String QUERYSELECTNATIVE="select "+EstadoServicioConstantesFunciones.SCHEMA+"."+EstadoServicioConstantesFunciones.TABLENAME+".id,"+EstadoServicioConstantesFunciones.SCHEMA+"."+EstadoServicioConstantesFunciones.TABLENAME+".version_row,"+EstadoServicioConstantesFunciones.SCHEMA+"."+EstadoServicioConstantesFunciones.TABLENAME+".codigo,"+EstadoServicioConstantesFunciones.SCHEMA+"."+EstadoServicioConstantesFunciones.TABLENAME+".nombre,"+EstadoServicioConstantesFunciones.SCHEMA+"."+EstadoServicioConstantesFunciones.TABLENAME+".es_defecto from "+EstadoServicioConstantesFunciones.SCHEMA+"."+EstadoServicioConstantesFunciones.TABLENAME;//+" as "+EstadoServicioConstantesFunciones.TABLENAME;
	
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
		
	
	public static String getEstadoServicioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoServicioConstantesFunciones.CODIGO)) {sLabelColumna=EstadoServicioConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoServicioConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoServicioConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(EstadoServicioConstantesFunciones.ESDEFECTO)) {sLabelColumna=EstadoServicioConstantesFunciones.LABEL_ESDEFECTO;}
		
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
	
	
	
			
			
			
			
		
	public static String getes_defectoDescripcion(EstadoServicio estadoservicio) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!estadoservicio.getes_defecto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_defectoHtmlDescripcion(EstadoServicio estadoservicio) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(estadoservicio.getId(),estadoservicio.getes_defecto());

		return sDescripcion;
	}	
	
	public static String getEstadoServicioDescripcion(EstadoServicio estadoservicio) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadoservicio !=null/* && estadoservicio.getId()!=0*/) {
			sDescripcion=estadoservicio.getcodigo();//estadoservicioestadoservicio.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoServicioDescripcionDetallado(EstadoServicio estadoservicio) {
		String sDescripcion="";
			
		sDescripcion+=EstadoServicioConstantesFunciones.ID+"=";
		sDescripcion+=estadoservicio.getId().toString()+",";
		sDescripcion+=EstadoServicioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadoservicio.getVersionRow().toString()+",";
		sDescripcion+=EstadoServicioConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadoservicio.getcodigo()+",";
		sDescripcion+=EstadoServicioConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadoservicio.getnombre()+",";
		sDescripcion+=EstadoServicioConstantesFunciones.ESDEFECTO+"=";
		sDescripcion+=estadoservicio.getes_defecto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoServicioDescripcion(EstadoServicio estadoservicio,String sValor) throws Exception {			
		if(estadoservicio !=null) {
			estadoservicio.setcodigo(sValor);;//estadoservicioestadoservicio.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoServicio(EstadoServicio estadoservicio,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadoservicio.setcodigo(estadoservicio.getcodigo().trim());
		estadoservicio.setnombre(estadoservicio.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoServicios(List<EstadoServicio> estadoservicios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoServicio estadoservicio: estadoservicios) {
			estadoservicio.setcodigo(estadoservicio.getcodigo().trim());
			estadoservicio.setnombre(estadoservicio.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoServicio(EstadoServicio estadoservicio,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadoservicio.getConCambioAuxiliar()) {
			estadoservicio.setIsDeleted(estadoservicio.getIsDeletedAuxiliar());	
			estadoservicio.setIsNew(estadoservicio.getIsNewAuxiliar());	
			estadoservicio.setIsChanged(estadoservicio.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadoservicio.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadoservicio.setIsDeletedAuxiliar(false);	
			estadoservicio.setIsNewAuxiliar(false);	
			estadoservicio.setIsChangedAuxiliar(false);
			
			estadoservicio.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoServicios(List<EstadoServicio> estadoservicios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoServicio estadoservicio : estadoservicios) {
			if(conAsignarBase && estadoservicio.getConCambioAuxiliar()) {
				estadoservicio.setIsDeleted(estadoservicio.getIsDeletedAuxiliar());	
				estadoservicio.setIsNew(estadoservicio.getIsNewAuxiliar());	
				estadoservicio.setIsChanged(estadoservicio.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadoservicio.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadoservicio.setIsDeletedAuxiliar(false);	
				estadoservicio.setIsNewAuxiliar(false);	
				estadoservicio.setIsChangedAuxiliar(false);
				
				estadoservicio.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoServicio(EstadoServicio estadoservicio,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoServicios(List<EstadoServicio> estadoservicios,Boolean conEnteros) throws Exception  {
		
		for(EstadoServicio estadoservicio: estadoservicios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoServicio(List<EstadoServicio> estadoservicios,EstadoServicio estadoservicioAux) throws Exception  {
		EstadoServicioConstantesFunciones.InicializarValoresEstadoServicio(estadoservicioAux,true);
		
		for(EstadoServicio estadoservicio: estadoservicios) {
			if(estadoservicio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoServicio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoServicioConstantesFunciones.getArrayColumnasGlobalesEstadoServicio(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoServicio(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoServicio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoServicio> estadoservicios,EstadoServicio estadoservicio,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoServicio estadoservicioAux: estadoservicios) {
			if(estadoservicioAux!=null && estadoservicio!=null) {
				if((estadoservicioAux.getId()==null && estadoservicio.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadoservicioAux.getId()!=null && estadoservicio.getId()!=null){
					if(estadoservicioAux.getId().equals(estadoservicio.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoServicio(List<EstadoServicio> estadoservicios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoServicio estadoservicio: estadoservicios) {			
			if(estadoservicio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoServicio() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoServicioConstantesFunciones.LABEL_ID, EstadoServicioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoServicioConstantesFunciones.LABEL_VERSIONROW, EstadoServicioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoServicioConstantesFunciones.LABEL_CODIGO, EstadoServicioConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoServicioConstantesFunciones.LABEL_NOMBRE, EstadoServicioConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoServicioConstantesFunciones.LABEL_ESDEFECTO, EstadoServicioConstantesFunciones.ESDEFECTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoServicio() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoServicioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoServicioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoServicioConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoServicioConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoServicioConstantesFunciones.ESDEFECTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoServicio() throws Exception  {
		return EstadoServicioConstantesFunciones.getTiposSeleccionarEstadoServicio(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoServicio(Boolean conFk) throws Exception  {
		return EstadoServicioConstantesFunciones.getTiposSeleccionarEstadoServicio(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoServicio(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoServicioConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoServicioConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoServicioConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoServicioConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoServicioConstantesFunciones.LABEL_ESDEFECTO);
			reporte.setsDescripcion(EstadoServicioConstantesFunciones.LABEL_ESDEFECTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoServicio(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoServicio(EstadoServicio estadoservicioAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoServicio(List<EstadoServicio> estadoserviciosTemp) throws Exception {
		for(EstadoServicio estadoservicioAux:estadoserviciosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoServicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoServicio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoServicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoServicioConstantesFunciones.getClassesRelationshipsOfEstadoServicio(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoServicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Servicio.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Servicio.class)) {
						classes.add(new Classe(Servicio.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoServicio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoServicioConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoServicio(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoServicio(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Servicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Servicio.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Servicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Servicio.class)); continue;
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
	public static void actualizarLista(EstadoServicio estadoservicio,List<EstadoServicio> estadoservicios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoServicio estadoservicioEncontrado=null;
			
			for(EstadoServicio estadoservicioLocal:estadoservicios) {
				if(estadoservicioLocal.getId().equals(estadoservicio.getId())) {
					estadoservicioEncontrado=estadoservicioLocal;
					
					estadoservicioLocal.setIsChanged(estadoservicio.getIsChanged());
					estadoservicioLocal.setIsNew(estadoservicio.getIsNew());
					estadoservicioLocal.setIsDeleted(estadoservicio.getIsDeleted());
					
					estadoservicioLocal.setGeneralEntityOriginal(estadoservicio.getGeneralEntityOriginal());
					
					estadoservicioLocal.setId(estadoservicio.getId());	
					estadoservicioLocal.setVersionRow(estadoservicio.getVersionRow());	
					estadoservicioLocal.setcodigo(estadoservicio.getcodigo());	
					estadoservicioLocal.setnombre(estadoservicio.getnombre());	
					estadoservicioLocal.setes_defecto(estadoservicio.getes_defecto());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!estadoservicio.getIsDeleted()) {
				if(!existe) {
					estadoservicios.add(estadoservicio);
				}
			} else {
				if(estadoservicioEncontrado!=null && permiteQuitar)  {
					estadoservicios.remove(estadoservicioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoServicio estadoservicio,List<EstadoServicio> estadoservicios) throws Exception {
		try	{			
			for(EstadoServicio estadoservicioLocal:estadoservicios) {
				if(estadoservicioLocal.getId().equals(estadoservicio.getId())) {
					estadoservicioLocal.setIsSelected(estadoservicio.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoServicio(List<EstadoServicio> estadoserviciosAux) throws Exception {
		//this.estadoserviciosAux=estadoserviciosAux;
		
		for(EstadoServicio estadoservicioAux:estadoserviciosAux) {
			if(estadoservicioAux.getIsChanged()) {
				estadoservicioAux.setIsChanged(false);
			}		
			
			if(estadoservicioAux.getIsNew()) {
				estadoservicioAux.setIsNew(false);
			}	
			
			if(estadoservicioAux.getIsDeleted()) {
				estadoservicioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoServicio(EstadoServicio estadoservicioAux) throws Exception {
		//this.estadoservicioAux=estadoservicioAux;
		
			if(estadoservicioAux.getIsChanged()) {
				estadoservicioAux.setIsChanged(false);
			}		
			
			if(estadoservicioAux.getIsNew()) {
				estadoservicioAux.setIsNew(false);
			}	
			
			if(estadoservicioAux.getIsDeleted()) {
				estadoservicioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoServicio estadoservicioAsignar,EstadoServicio estadoservicio) throws Exception {
		estadoservicioAsignar.setId(estadoservicio.getId());	
		estadoservicioAsignar.setVersionRow(estadoservicio.getVersionRow());	
		estadoservicioAsignar.setcodigo(estadoservicio.getcodigo());	
		estadoservicioAsignar.setnombre(estadoservicio.getnombre());	
		estadoservicioAsignar.setes_defecto(estadoservicio.getes_defecto());	
	}
	
	public static void inicializarEstadoServicio(EstadoServicio estadoservicio) throws Exception {
		try {
				estadoservicio.setId(0L);	
					
				estadoservicio.setcodigo("");	
				estadoservicio.setnombre("");	
				estadoservicio.setes_defecto(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoServicio(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoServicioConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoServicioConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoServicioConstantesFunciones.LABEL_ESDEFECTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoServicio(String sTipo,Row row,Workbook workbook,EstadoServicio estadoservicio,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoservicio.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoservicio.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(estadoservicio.getes_defecto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoServicio=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoServicio() {
		return this.sFinalQueryEstadoServicio;
	}
	
	public void setsFinalQueryEstadoServicio(String sFinalQueryEstadoServicio) {
		this.sFinalQueryEstadoServicio= sFinalQueryEstadoServicio;
	}
	
	public Border resaltarSeleccionarEstadoServicio=null;
	
	public Border setResaltarSeleccionarEstadoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoServicioBeanSwingJInternalFrame estadoservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadoservicioBeanSwingJInternalFrame.jTtoolBarEstadoServicio.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoServicio= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoServicio() {
		return this.resaltarSeleccionarEstadoServicio;
	}
	
	public void setResaltarSeleccionarEstadoServicio(Border borderResaltarSeleccionarEstadoServicio) {
		this.resaltarSeleccionarEstadoServicio= borderResaltarSeleccionarEstadoServicio;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoServicio=null;
	public Boolean mostraridEstadoServicio=true;
	public Boolean activaridEstadoServicio=true;

	public Border resaltarcodigoEstadoServicio=null;
	public Boolean mostrarcodigoEstadoServicio=true;
	public Boolean activarcodigoEstadoServicio=true;

	public Border resaltarnombreEstadoServicio=null;
	public Boolean mostrarnombreEstadoServicio=true;
	public Boolean activarnombreEstadoServicio=true;

	public Border resaltares_defectoEstadoServicio=null;
	public Boolean mostrares_defectoEstadoServicio=true;
	public Boolean activares_defectoEstadoServicio=true;

	
	

	public Border setResaltaridEstadoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoServicioBeanSwingJInternalFrame estadoservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoservicioBeanSwingJInternalFrame.jTtoolBarEstadoServicio.setBorder(borderResaltar);
		
		this.resaltaridEstadoServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoServicio() {
		return this.resaltaridEstadoServicio;
	}

	public void setResaltaridEstadoServicio(Border borderResaltar) {
		this.resaltaridEstadoServicio= borderResaltar;
	}

	public Boolean getMostraridEstadoServicio() {
		return this.mostraridEstadoServicio;
	}

	public void setMostraridEstadoServicio(Boolean mostraridEstadoServicio) {
		this.mostraridEstadoServicio= mostraridEstadoServicio;
	}

	public Boolean getActivaridEstadoServicio() {
		return this.activaridEstadoServicio;
	}

	public void setActivaridEstadoServicio(Boolean activaridEstadoServicio) {
		this.activaridEstadoServicio= activaridEstadoServicio;
	}

	public Border setResaltarcodigoEstadoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoServicioBeanSwingJInternalFrame estadoservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoservicioBeanSwingJInternalFrame.jTtoolBarEstadoServicio.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoServicio() {
		return this.resaltarcodigoEstadoServicio;
	}

	public void setResaltarcodigoEstadoServicio(Border borderResaltar) {
		this.resaltarcodigoEstadoServicio= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoServicio() {
		return this.mostrarcodigoEstadoServicio;
	}

	public void setMostrarcodigoEstadoServicio(Boolean mostrarcodigoEstadoServicio) {
		this.mostrarcodigoEstadoServicio= mostrarcodigoEstadoServicio;
	}

	public Boolean getActivarcodigoEstadoServicio() {
		return this.activarcodigoEstadoServicio;
	}

	public void setActivarcodigoEstadoServicio(Boolean activarcodigoEstadoServicio) {
		this.activarcodigoEstadoServicio= activarcodigoEstadoServicio;
	}

	public Border setResaltarnombreEstadoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoServicioBeanSwingJInternalFrame estadoservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoservicioBeanSwingJInternalFrame.jTtoolBarEstadoServicio.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoServicio() {
		return this.resaltarnombreEstadoServicio;
	}

	public void setResaltarnombreEstadoServicio(Border borderResaltar) {
		this.resaltarnombreEstadoServicio= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoServicio() {
		return this.mostrarnombreEstadoServicio;
	}

	public void setMostrarnombreEstadoServicio(Boolean mostrarnombreEstadoServicio) {
		this.mostrarnombreEstadoServicio= mostrarnombreEstadoServicio;
	}

	public Boolean getActivarnombreEstadoServicio() {
		return this.activarnombreEstadoServicio;
	}

	public void setActivarnombreEstadoServicio(Boolean activarnombreEstadoServicio) {
		this.activarnombreEstadoServicio= activarnombreEstadoServicio;
	}

	public Border setResaltares_defectoEstadoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoServicioBeanSwingJInternalFrame estadoservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoservicioBeanSwingJInternalFrame.jTtoolBarEstadoServicio.setBorder(borderResaltar);
		
		this.resaltares_defectoEstadoServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_defectoEstadoServicio() {
		return this.resaltares_defectoEstadoServicio;
	}

	public void setResaltares_defectoEstadoServicio(Border borderResaltar) {
		this.resaltares_defectoEstadoServicio= borderResaltar;
	}

	public Boolean getMostrares_defectoEstadoServicio() {
		return this.mostrares_defectoEstadoServicio;
	}

	public void setMostrares_defectoEstadoServicio(Boolean mostrares_defectoEstadoServicio) {
		this.mostrares_defectoEstadoServicio= mostrares_defectoEstadoServicio;
	}

	public Boolean getActivares_defectoEstadoServicio() {
		return this.activares_defectoEstadoServicio;
	}

	public void setActivares_defectoEstadoServicio(Boolean activares_defectoEstadoServicio) {
		this.activares_defectoEstadoServicio= activares_defectoEstadoServicio;
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
		
		
		this.setMostraridEstadoServicio(esInicial);
		this.setMostrarcodigoEstadoServicio(esInicial);
		this.setMostrarnombreEstadoServicio(esInicial);
		this.setMostrares_defectoEstadoServicio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoServicioConstantesFunciones.ID)) {
				this.setMostraridEstadoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoServicioConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoServicioConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoServicioConstantesFunciones.ESDEFECTO)) {
				this.setMostrares_defectoEstadoServicio(esAsigna);
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
		
		
		this.setActivaridEstadoServicio(esInicial);
		this.setActivarcodigoEstadoServicio(esInicial);
		this.setActivarnombreEstadoServicio(esInicial);
		this.setActivares_defectoEstadoServicio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoServicioConstantesFunciones.ID)) {
				this.setActivaridEstadoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoServicioConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoServicioConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoServicioConstantesFunciones.ESDEFECTO)) {
				this.setActivares_defectoEstadoServicio(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoServicioBeanSwingJInternalFrame estadoservicioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoServicio(esInicial);
		this.setResaltarcodigoEstadoServicio(esInicial);
		this.setResaltarnombreEstadoServicio(esInicial);
		this.setResaltares_defectoEstadoServicio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoServicioConstantesFunciones.ID)) {
				this.setResaltaridEstadoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoServicioConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoServicioConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoServicioConstantesFunciones.ESDEFECTO)) {
				this.setResaltares_defectoEstadoServicio(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoServicioBeanSwingJInternalFrame estadoservicioBeanSwingJInternalFrame*/)throws Exception {	
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