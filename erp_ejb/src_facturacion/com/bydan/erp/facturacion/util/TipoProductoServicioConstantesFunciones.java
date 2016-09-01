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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.TipoProductoServicioConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoProductoServicioParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoProductoServicioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoProductoServicioConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoProductoServicio";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoProductoServicio"+TipoProductoServicioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoProductoServicioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoProductoServicioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoProductoServicioConstantesFunciones.SCHEMA+"_"+TipoProductoServicioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoProductoServicioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoProductoServicioConstantesFunciones.SCHEMA+"_"+TipoProductoServicioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoProductoServicioConstantesFunciones.SCHEMA+"_"+TipoProductoServicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoProductoServicioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoProductoServicioConstantesFunciones.SCHEMA+"_"+TipoProductoServicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProductoServicioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoProductoServicioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProductoServicioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProductoServicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoProductoServicioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProductoServicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoProductoServicioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoProductoServicioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoProductoServicioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoProductoServicioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Producto Servicios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Producto Servicio";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Producto Servicio";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoProductoServicio";
	public static final String OBJECTNAME="tipoproductoservicio";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tipo_producto_servicio";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoproductoservicio from "+TipoProductoServicioConstantesFunciones.SPERSISTENCENAME+" tipoproductoservicio";
	public static String QUERYSELECTNATIVE="select "+TipoProductoServicioConstantesFunciones.SCHEMA+"."+TipoProductoServicioConstantesFunciones.TABLENAME+".id,"+TipoProductoServicioConstantesFunciones.SCHEMA+"."+TipoProductoServicioConstantesFunciones.TABLENAME+".version_row,"+TipoProductoServicioConstantesFunciones.SCHEMA+"."+TipoProductoServicioConstantesFunciones.TABLENAME+".nombre from "+TipoProductoServicioConstantesFunciones.SCHEMA+"."+TipoProductoServicioConstantesFunciones.TABLENAME;//+" as "+TipoProductoServicioConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoProductoServicioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoProductoServicioConstantesFunciones.NOMBRE)) {sLabelColumna=TipoProductoServicioConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getTipoProductoServicioDescripcion(TipoProductoServicio tipoproductoservicio) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoproductoservicio !=null/* && tipoproductoservicio.getId()!=0*/) {
			sDescripcion=tipoproductoservicio.getnombre();//tipoproductoserviciotipoproductoservicio.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoProductoServicioDescripcionDetallado(TipoProductoServicio tipoproductoservicio) {
		String sDescripcion="";
			
		sDescripcion+=TipoProductoServicioConstantesFunciones.ID+"=";
		sDescripcion+=tipoproductoservicio.getId().toString()+",";
		sDescripcion+=TipoProductoServicioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoproductoservicio.getVersionRow().toString()+",";
		sDescripcion+=TipoProductoServicioConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoproductoservicio.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoProductoServicioDescripcion(TipoProductoServicio tipoproductoservicio,String sValor) throws Exception {			
		if(tipoproductoservicio !=null) {
			tipoproductoservicio.setnombre(sValor);;//tipoproductoserviciotipoproductoservicio.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoProductoServicio(TipoProductoServicio tipoproductoservicio,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoproductoservicio.setnombre(tipoproductoservicio.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoProductoServicios(List<TipoProductoServicio> tipoproductoservicios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoProductoServicio tipoproductoservicio: tipoproductoservicios) {
			tipoproductoservicio.setnombre(tipoproductoservicio.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoProductoServicio(TipoProductoServicio tipoproductoservicio,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoproductoservicio.getConCambioAuxiliar()) {
			tipoproductoservicio.setIsDeleted(tipoproductoservicio.getIsDeletedAuxiliar());	
			tipoproductoservicio.setIsNew(tipoproductoservicio.getIsNewAuxiliar());	
			tipoproductoservicio.setIsChanged(tipoproductoservicio.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoproductoservicio.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoproductoservicio.setIsDeletedAuxiliar(false);	
			tipoproductoservicio.setIsNewAuxiliar(false);	
			tipoproductoservicio.setIsChangedAuxiliar(false);
			
			tipoproductoservicio.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoProductoServicios(List<TipoProductoServicio> tipoproductoservicios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoProductoServicio tipoproductoservicio : tipoproductoservicios) {
			if(conAsignarBase && tipoproductoservicio.getConCambioAuxiliar()) {
				tipoproductoservicio.setIsDeleted(tipoproductoservicio.getIsDeletedAuxiliar());	
				tipoproductoservicio.setIsNew(tipoproductoservicio.getIsNewAuxiliar());	
				tipoproductoservicio.setIsChanged(tipoproductoservicio.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoproductoservicio.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoproductoservicio.setIsDeletedAuxiliar(false);	
				tipoproductoservicio.setIsNewAuxiliar(false);	
				tipoproductoservicio.setIsChangedAuxiliar(false);
				
				tipoproductoservicio.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoProductoServicio(TipoProductoServicio tipoproductoservicio,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoProductoServicios(List<TipoProductoServicio> tipoproductoservicios,Boolean conEnteros) throws Exception  {
		
		for(TipoProductoServicio tipoproductoservicio: tipoproductoservicios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoProductoServicio(List<TipoProductoServicio> tipoproductoservicios,TipoProductoServicio tipoproductoservicioAux) throws Exception  {
		TipoProductoServicioConstantesFunciones.InicializarValoresTipoProductoServicio(tipoproductoservicioAux,true);
		
		for(TipoProductoServicio tipoproductoservicio: tipoproductoservicios) {
			if(tipoproductoservicio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoProductoServicio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoProductoServicioConstantesFunciones.getArrayColumnasGlobalesTipoProductoServicio(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoProductoServicio(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoProductoServicio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoProductoServicio> tipoproductoservicios,TipoProductoServicio tipoproductoservicio,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoProductoServicio tipoproductoservicioAux: tipoproductoservicios) {
			if(tipoproductoservicioAux!=null && tipoproductoservicio!=null) {
				if((tipoproductoservicioAux.getId()==null && tipoproductoservicio.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoproductoservicioAux.getId()!=null && tipoproductoservicio.getId()!=null){
					if(tipoproductoservicioAux.getId().equals(tipoproductoservicio.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoProductoServicio(List<TipoProductoServicio> tipoproductoservicios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoProductoServicio tipoproductoservicio: tipoproductoservicios) {			
			if(tipoproductoservicio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoProductoServicio() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoProductoServicioConstantesFunciones.LABEL_ID, TipoProductoServicioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProductoServicioConstantesFunciones.LABEL_VERSIONROW, TipoProductoServicioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProductoServicioConstantesFunciones.LABEL_NOMBRE, TipoProductoServicioConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoProductoServicio() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoProductoServicioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProductoServicioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProductoServicioConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProductoServicio() throws Exception  {
		return TipoProductoServicioConstantesFunciones.getTiposSeleccionarTipoProductoServicio(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProductoServicio(Boolean conFk) throws Exception  {
		return TipoProductoServicioConstantesFunciones.getTiposSeleccionarTipoProductoServicio(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProductoServicio(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProductoServicioConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoProductoServicioConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoProductoServicio(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoProductoServicio(TipoProductoServicio tipoproductoservicioAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoProductoServicio(List<TipoProductoServicio> tipoproductoserviciosTemp) throws Exception {
		for(TipoProductoServicio tipoproductoservicioAux:tipoproductoserviciosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoProductoServicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoProductoServicio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProductoServicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoProductoServicioConstantesFunciones.getClassesRelationshipsOfTipoProductoServicio(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProductoServicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(CuentaContableTipo.class));
				classes.add(new Classe(ParametroInventarioDefecto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContableTipo.class)) {
						classes.add(new Classe(CuentaContableTipo.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroInventarioDefecto.class)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoProductoServicio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoProductoServicioConstantesFunciones.getClassesRelationshipsFromStringsOfTipoProductoServicio(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoProductoServicio(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(CuentaContableTipo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContableTipo.class)); continue;
					}

					if(ParametroInventarioDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(CuentaContableTipo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContableTipo.class)); continue;
					}

					if(ParametroInventarioDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); continue;
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
	public static void actualizarLista(TipoProductoServicio tipoproductoservicio,List<TipoProductoServicio> tipoproductoservicios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoProductoServicio tipoproductoservicioEncontrado=null;
			
			for(TipoProductoServicio tipoproductoservicioLocal:tipoproductoservicios) {
				if(tipoproductoservicioLocal.getId().equals(tipoproductoservicio.getId())) {
					tipoproductoservicioEncontrado=tipoproductoservicioLocal;
					
					tipoproductoservicioLocal.setIsChanged(tipoproductoservicio.getIsChanged());
					tipoproductoservicioLocal.setIsNew(tipoproductoservicio.getIsNew());
					tipoproductoservicioLocal.setIsDeleted(tipoproductoservicio.getIsDeleted());
					
					tipoproductoservicioLocal.setGeneralEntityOriginal(tipoproductoservicio.getGeneralEntityOriginal());
					
					tipoproductoservicioLocal.setId(tipoproductoservicio.getId());	
					tipoproductoservicioLocal.setVersionRow(tipoproductoservicio.getVersionRow());	
					tipoproductoservicioLocal.setnombre(tipoproductoservicio.getnombre());	
					
					
					tipoproductoservicioLocal.setCuentaContableTipos(tipoproductoservicio.getCuentaContableTipos());
					tipoproductoservicioLocal.setParametroInventarioDefectos(tipoproductoservicio.getParametroInventarioDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoproductoservicio.getIsDeleted()) {
				if(!existe) {
					tipoproductoservicios.add(tipoproductoservicio);
				}
			} else {
				if(tipoproductoservicioEncontrado!=null && permiteQuitar)  {
					tipoproductoservicios.remove(tipoproductoservicioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoProductoServicio tipoproductoservicio,List<TipoProductoServicio> tipoproductoservicios) throws Exception {
		try	{			
			for(TipoProductoServicio tipoproductoservicioLocal:tipoproductoservicios) {
				if(tipoproductoservicioLocal.getId().equals(tipoproductoservicio.getId())) {
					tipoproductoservicioLocal.setIsSelected(tipoproductoservicio.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoProductoServicio(List<TipoProductoServicio> tipoproductoserviciosAux) throws Exception {
		//this.tipoproductoserviciosAux=tipoproductoserviciosAux;
		
		for(TipoProductoServicio tipoproductoservicioAux:tipoproductoserviciosAux) {
			if(tipoproductoservicioAux.getIsChanged()) {
				tipoproductoservicioAux.setIsChanged(false);
			}		
			
			if(tipoproductoservicioAux.getIsNew()) {
				tipoproductoservicioAux.setIsNew(false);
			}	
			
			if(tipoproductoservicioAux.getIsDeleted()) {
				tipoproductoservicioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoProductoServicio(TipoProductoServicio tipoproductoservicioAux) throws Exception {
		//this.tipoproductoservicioAux=tipoproductoservicioAux;
		
			if(tipoproductoservicioAux.getIsChanged()) {
				tipoproductoservicioAux.setIsChanged(false);
			}		
			
			if(tipoproductoservicioAux.getIsNew()) {
				tipoproductoservicioAux.setIsNew(false);
			}	
			
			if(tipoproductoservicioAux.getIsDeleted()) {
				tipoproductoservicioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoProductoServicio tipoproductoservicioAsignar,TipoProductoServicio tipoproductoservicio) throws Exception {
		tipoproductoservicioAsignar.setId(tipoproductoservicio.getId());	
		tipoproductoservicioAsignar.setVersionRow(tipoproductoservicio.getVersionRow());	
		tipoproductoservicioAsignar.setnombre(tipoproductoservicio.getnombre());	
	}
	
	public static void inicializarTipoProductoServicio(TipoProductoServicio tipoproductoservicio) throws Exception {
		try {
				tipoproductoservicio.setId(0L);	
					
				tipoproductoservicio.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoProductoServicio(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProductoServicioConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoProductoServicio(String sTipo,Row row,Workbook workbook,TipoProductoServicio tipoproductoservicio,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoproductoservicio.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoProductoServicio=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoProductoServicio() {
		return this.sFinalQueryTipoProductoServicio;
	}
	
	public void setsFinalQueryTipoProductoServicio(String sFinalQueryTipoProductoServicio) {
		this.sFinalQueryTipoProductoServicio= sFinalQueryTipoProductoServicio;
	}
	
	public Border resaltarSeleccionarTipoProductoServicio=null;
	
	public Border setResaltarSeleccionarTipoProductoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoServicioBeanSwingJInternalFrame tipoproductoservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoproductoservicioBeanSwingJInternalFrame.jTtoolBarTipoProductoServicio.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoProductoServicio= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoProductoServicio() {
		return this.resaltarSeleccionarTipoProductoServicio;
	}
	
	public void setResaltarSeleccionarTipoProductoServicio(Border borderResaltarSeleccionarTipoProductoServicio) {
		this.resaltarSeleccionarTipoProductoServicio= borderResaltarSeleccionarTipoProductoServicio;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoProductoServicio=null;
	public Boolean mostraridTipoProductoServicio=true;
	public Boolean activaridTipoProductoServicio=true;

	public Border resaltarnombreTipoProductoServicio=null;
	public Boolean mostrarnombreTipoProductoServicio=true;
	public Boolean activarnombreTipoProductoServicio=true;

	
	

	public Border setResaltaridTipoProductoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoServicioBeanSwingJInternalFrame tipoproductoservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoproductoservicioBeanSwingJInternalFrame.jTtoolBarTipoProductoServicio.setBorder(borderResaltar);
		
		this.resaltaridTipoProductoServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoProductoServicio() {
		return this.resaltaridTipoProductoServicio;
	}

	public void setResaltaridTipoProductoServicio(Border borderResaltar) {
		this.resaltaridTipoProductoServicio= borderResaltar;
	}

	public Boolean getMostraridTipoProductoServicio() {
		return this.mostraridTipoProductoServicio;
	}

	public void setMostraridTipoProductoServicio(Boolean mostraridTipoProductoServicio) {
		this.mostraridTipoProductoServicio= mostraridTipoProductoServicio;
	}

	public Boolean getActivaridTipoProductoServicio() {
		return this.activaridTipoProductoServicio;
	}

	public void setActivaridTipoProductoServicio(Boolean activaridTipoProductoServicio) {
		this.activaridTipoProductoServicio= activaridTipoProductoServicio;
	}

	public Border setResaltarnombreTipoProductoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoServicioBeanSwingJInternalFrame tipoproductoservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoproductoservicioBeanSwingJInternalFrame.jTtoolBarTipoProductoServicio.setBorder(borderResaltar);
		
		this.resaltarnombreTipoProductoServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoProductoServicio() {
		return this.resaltarnombreTipoProductoServicio;
	}

	public void setResaltarnombreTipoProductoServicio(Border borderResaltar) {
		this.resaltarnombreTipoProductoServicio= borderResaltar;
	}

	public Boolean getMostrarnombreTipoProductoServicio() {
		return this.mostrarnombreTipoProductoServicio;
	}

	public void setMostrarnombreTipoProductoServicio(Boolean mostrarnombreTipoProductoServicio) {
		this.mostrarnombreTipoProductoServicio= mostrarnombreTipoProductoServicio;
	}

	public Boolean getActivarnombreTipoProductoServicio() {
		return this.activarnombreTipoProductoServicio;
	}

	public void setActivarnombreTipoProductoServicio(Boolean activarnombreTipoProductoServicio) {
		this.activarnombreTipoProductoServicio= activarnombreTipoProductoServicio;
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
		
		
		this.setMostraridTipoProductoServicio(esInicial);
		this.setMostrarnombreTipoProductoServicio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProductoServicioConstantesFunciones.ID)) {
				this.setMostraridTipoProductoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProductoServicioConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoProductoServicio(esAsigna);
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
		
		
		this.setActivaridTipoProductoServicio(esInicial);
		this.setActivarnombreTipoProductoServicio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProductoServicioConstantesFunciones.ID)) {
				this.setActivaridTipoProductoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProductoServicioConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoProductoServicio(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoProductoServicioBeanSwingJInternalFrame tipoproductoservicioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoProductoServicio(esInicial);
		this.setResaltarnombreTipoProductoServicio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProductoServicioConstantesFunciones.ID)) {
				this.setResaltaridTipoProductoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProductoServicioConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoProductoServicio(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCuentaContableTipoTipoProductoServicio=null;

	public Border getResaltarCuentaContableTipoTipoProductoServicio() {
		return this.resaltarCuentaContableTipoTipoProductoServicio;
	}

	public void setResaltarCuentaContableTipoTipoProductoServicio(Border borderResaltarCuentaContableTipo) {
		if(borderResaltarCuentaContableTipo!=null) {
			this.resaltarCuentaContableTipoTipoProductoServicio= borderResaltarCuentaContableTipo;
		}
	}

	public Border setResaltarCuentaContableTipoTipoProductoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoServicioBeanSwingJInternalFrame tipoproductoservicioBeanSwingJInternalFrame*/) {
		Border borderResaltarCuentaContableTipo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoproductoservicioBeanSwingJInternalFrame.jTtoolBarTipoProductoServicio.setBorder(borderResaltarCuentaContableTipo);
			
		this.resaltarCuentaContableTipoTipoProductoServicio= borderResaltarCuentaContableTipo;

		 return borderResaltarCuentaContableTipo;
	}



	public Boolean mostrarCuentaContableTipoTipoProductoServicio=true;

	public Boolean getMostrarCuentaContableTipoTipoProductoServicio() {
		return this.mostrarCuentaContableTipoTipoProductoServicio;
	}

	public void setMostrarCuentaContableTipoTipoProductoServicio(Boolean visibilidadResaltarCuentaContableTipo) {
		this.mostrarCuentaContableTipoTipoProductoServicio= visibilidadResaltarCuentaContableTipo;
	}



	public Boolean activarCuentaContableTipoTipoProductoServicio=true;

	public Boolean gethabilitarResaltarCuentaContableTipoTipoProductoServicio() {
		return this.activarCuentaContableTipoTipoProductoServicio;
	}

	public void setActivarCuentaContableTipoTipoProductoServicio(Boolean habilitarResaltarCuentaContableTipo) {
		this.activarCuentaContableTipoTipoProductoServicio= habilitarResaltarCuentaContableTipo;
	}


	public Border resaltarParametroInventarioDefectoTipoProductoServicio=null;

	public Border getResaltarParametroInventarioDefectoTipoProductoServicio() {
		return this.resaltarParametroInventarioDefectoTipoProductoServicio;
	}

	public void setResaltarParametroInventarioDefectoTipoProductoServicio(Border borderResaltarParametroInventarioDefecto) {
		if(borderResaltarParametroInventarioDefecto!=null) {
			this.resaltarParametroInventarioDefectoTipoProductoServicio= borderResaltarParametroInventarioDefecto;
		}
	}

	public Border setResaltarParametroInventarioDefectoTipoProductoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoServicioBeanSwingJInternalFrame tipoproductoservicioBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroInventarioDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoproductoservicioBeanSwingJInternalFrame.jTtoolBarTipoProductoServicio.setBorder(borderResaltarParametroInventarioDefecto);
			
		this.resaltarParametroInventarioDefectoTipoProductoServicio= borderResaltarParametroInventarioDefecto;

		 return borderResaltarParametroInventarioDefecto;
	}



	public Boolean mostrarParametroInventarioDefectoTipoProductoServicio=true;

	public Boolean getMostrarParametroInventarioDefectoTipoProductoServicio() {
		return this.mostrarParametroInventarioDefectoTipoProductoServicio;
	}

	public void setMostrarParametroInventarioDefectoTipoProductoServicio(Boolean visibilidadResaltarParametroInventarioDefecto) {
		this.mostrarParametroInventarioDefectoTipoProductoServicio= visibilidadResaltarParametroInventarioDefecto;
	}



	public Boolean activarParametroInventarioDefectoTipoProductoServicio=true;

	public Boolean gethabilitarResaltarParametroInventarioDefectoTipoProductoServicio() {
		return this.activarParametroInventarioDefectoTipoProductoServicio;
	}

	public void setActivarParametroInventarioDefectoTipoProductoServicio(Boolean habilitarResaltarParametroInventarioDefecto) {
		this.activarParametroInventarioDefectoTipoProductoServicio= habilitarResaltarParametroInventarioDefecto;
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

		this.setMostrarCuentaContableTipoTipoProductoServicio(esInicial);
		this.setMostrarParametroInventarioDefectoTipoProductoServicio(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CuentaContableTipo.class)) {
				this.setMostrarCuentaContableTipoTipoProductoServicio(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setMostrarParametroInventarioDefectoTipoProductoServicio(esAsigna);
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

		this.setActivarCuentaContableTipoTipoProductoServicio(esInicial);
		this.setActivarParametroInventarioDefectoTipoProductoServicio(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CuentaContableTipo.class)) {
				this.setActivarCuentaContableTipoTipoProductoServicio(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setActivarParametroInventarioDefectoTipoProductoServicio(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoProductoServicioBeanSwingJInternalFrame tipoproductoservicioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCuentaContableTipoTipoProductoServicio(esInicial);
		this.setResaltarParametroInventarioDefectoTipoProductoServicio(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CuentaContableTipo.class)) {
				this.setResaltarCuentaContableTipoTipoProductoServicio(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setResaltarParametroInventarioDefectoTipoProductoServicio(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorNombreTipoProductoServicio=true;

	public Boolean getMostrarBusquedaPorNombreTipoProductoServicio() {
		return this.mostrarBusquedaPorNombreTipoProductoServicio;
	}

	public void setMostrarBusquedaPorNombreTipoProductoServicio(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoProductoServicio= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreTipoProductoServicio=true;

	public Boolean getActivarBusquedaPorNombreTipoProductoServicio() {
		return this.activarBusquedaPorNombreTipoProductoServicio;
	}

	public void setActivarBusquedaPorNombreTipoProductoServicio(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoProductoServicio= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreTipoProductoServicio=null;

	public Border getResaltarBusquedaPorNombreTipoProductoServicio() {
		return this.resaltarBusquedaPorNombreTipoProductoServicio;
	}

	public void setResaltarBusquedaPorNombreTipoProductoServicio(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoProductoServicio= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoProductoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProductoServicioBeanSwingJInternalFrame tipoproductoservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoProductoServicio= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}