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


import com.bydan.erp.inventario.util.TipoServicioConstantesFunciones;
import com.bydan.erp.inventario.util.TipoServicioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoServicioParameterGeneral;

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
final public class TipoServicioConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoServicio";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoServicio"+TipoServicioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoServicioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoServicioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoServicioConstantesFunciones.SCHEMA+"_"+TipoServicioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoServicioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoServicioConstantesFunciones.SCHEMA+"_"+TipoServicioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoServicioConstantesFunciones.SCHEMA+"_"+TipoServicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoServicioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoServicioConstantesFunciones.SCHEMA+"_"+TipoServicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoServicioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoServicioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoServicioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoServicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoServicioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoServicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoServicioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoServicioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoServicioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoServicioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Servicioes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Servicio";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Servicio";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoServicio";
	public static final String OBJECTNAME="tiposervicio";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="tipo_servicio";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiposervicio from "+TipoServicioConstantesFunciones.SPERSISTENCENAME+" tiposervicio";
	public static String QUERYSELECTNATIVE="select "+TipoServicioConstantesFunciones.SCHEMA+"."+TipoServicioConstantesFunciones.TABLENAME+".id,"+TipoServicioConstantesFunciones.SCHEMA+"."+TipoServicioConstantesFunciones.TABLENAME+".version_row,"+TipoServicioConstantesFunciones.SCHEMA+"."+TipoServicioConstantesFunciones.TABLENAME+".codigo,"+TipoServicioConstantesFunciones.SCHEMA+"."+TipoServicioConstantesFunciones.TABLENAME+".nombre from "+TipoServicioConstantesFunciones.SCHEMA+"."+TipoServicioConstantesFunciones.TABLENAME;//+" as "+TipoServicioConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoServicioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoServicioConstantesFunciones.CODIGO)) {sLabelColumna=TipoServicioConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoServicioConstantesFunciones.NOMBRE)) {sLabelColumna=TipoServicioConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoServicioDescripcion(TipoServicio tiposervicio) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiposervicio !=null/* && tiposervicio.getId()!=0*/) {
			sDescripcion=tiposervicio.getcodigo();//tiposerviciotiposervicio.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoServicioDescripcionDetallado(TipoServicio tiposervicio) {
		String sDescripcion="";
			
		sDescripcion+=TipoServicioConstantesFunciones.ID+"=";
		sDescripcion+=tiposervicio.getId().toString()+",";
		sDescripcion+=TipoServicioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiposervicio.getVersionRow().toString()+",";
		sDescripcion+=TipoServicioConstantesFunciones.CODIGO+"=";
		sDescripcion+=tiposervicio.getcodigo()+",";
		sDescripcion+=TipoServicioConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiposervicio.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoServicioDescripcion(TipoServicio tiposervicio,String sValor) throws Exception {			
		if(tiposervicio !=null) {
			tiposervicio.setcodigo(sValor);;//tiposerviciotiposervicio.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoServicio(TipoServicio tiposervicio,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiposervicio.setcodigo(tiposervicio.getcodigo().trim());
		tiposervicio.setnombre(tiposervicio.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoServicios(List<TipoServicio> tiposervicios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoServicio tiposervicio: tiposervicios) {
			tiposervicio.setcodigo(tiposervicio.getcodigo().trim());
			tiposervicio.setnombre(tiposervicio.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoServicio(TipoServicio tiposervicio,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiposervicio.getConCambioAuxiliar()) {
			tiposervicio.setIsDeleted(tiposervicio.getIsDeletedAuxiliar());	
			tiposervicio.setIsNew(tiposervicio.getIsNewAuxiliar());	
			tiposervicio.setIsChanged(tiposervicio.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiposervicio.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiposervicio.setIsDeletedAuxiliar(false);	
			tiposervicio.setIsNewAuxiliar(false);	
			tiposervicio.setIsChangedAuxiliar(false);
			
			tiposervicio.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoServicios(List<TipoServicio> tiposervicios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoServicio tiposervicio : tiposervicios) {
			if(conAsignarBase && tiposervicio.getConCambioAuxiliar()) {
				tiposervicio.setIsDeleted(tiposervicio.getIsDeletedAuxiliar());	
				tiposervicio.setIsNew(tiposervicio.getIsNewAuxiliar());	
				tiposervicio.setIsChanged(tiposervicio.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiposervicio.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiposervicio.setIsDeletedAuxiliar(false);	
				tiposervicio.setIsNewAuxiliar(false);	
				tiposervicio.setIsChangedAuxiliar(false);
				
				tiposervicio.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoServicio(TipoServicio tiposervicio,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoServicios(List<TipoServicio> tiposervicios,Boolean conEnteros) throws Exception  {
		
		for(TipoServicio tiposervicio: tiposervicios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoServicio(List<TipoServicio> tiposervicios,TipoServicio tiposervicioAux) throws Exception  {
		TipoServicioConstantesFunciones.InicializarValoresTipoServicio(tiposervicioAux,true);
		
		for(TipoServicio tiposervicio: tiposervicios) {
			if(tiposervicio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoServicio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoServicioConstantesFunciones.getArrayColumnasGlobalesTipoServicio(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoServicio(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoServicio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoServicio> tiposervicios,TipoServicio tiposervicio,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoServicio tiposervicioAux: tiposervicios) {
			if(tiposervicioAux!=null && tiposervicio!=null) {
				if((tiposervicioAux.getId()==null && tiposervicio.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiposervicioAux.getId()!=null && tiposervicio.getId()!=null){
					if(tiposervicioAux.getId().equals(tiposervicio.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoServicio(List<TipoServicio> tiposervicios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoServicio tiposervicio: tiposervicios) {			
			if(tiposervicio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoServicio() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoServicioConstantesFunciones.LABEL_ID, TipoServicioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoServicioConstantesFunciones.LABEL_VERSIONROW, TipoServicioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoServicioConstantesFunciones.LABEL_CODIGO, TipoServicioConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoServicioConstantesFunciones.LABEL_NOMBRE, TipoServicioConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoServicio() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoServicioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoServicioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoServicioConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoServicioConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoServicio() throws Exception  {
		return TipoServicioConstantesFunciones.getTiposSeleccionarTipoServicio(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoServicio(Boolean conFk) throws Exception  {
		return TipoServicioConstantesFunciones.getTiposSeleccionarTipoServicio(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoServicio(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoServicioConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoServicioConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoServicioConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoServicioConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoServicio(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoServicio(TipoServicio tiposervicioAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoServicio(List<TipoServicio> tiposerviciosTemp) throws Exception {
		for(TipoServicio tiposervicioAux:tiposerviciosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoServicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoServicio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoServicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoServicioConstantesFunciones.getClassesRelationshipsOfTipoServicio(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoServicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Servicio.class));
				classes.add(new Classe(ParametroInventarioDefecto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Servicio.class)) {
						classes.add(new Classe(Servicio.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoServicio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoServicioConstantesFunciones.getClassesRelationshipsFromStringsOfTipoServicio(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoServicio(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Servicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Servicio.class)); continue;
					}

					if(ParametroInventarioDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Servicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Servicio.class)); continue;
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
	public static void actualizarLista(TipoServicio tiposervicio,List<TipoServicio> tiposervicios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoServicio tiposervicioEncontrado=null;
			
			for(TipoServicio tiposervicioLocal:tiposervicios) {
				if(tiposervicioLocal.getId().equals(tiposervicio.getId())) {
					tiposervicioEncontrado=tiposervicioLocal;
					
					tiposervicioLocal.setIsChanged(tiposervicio.getIsChanged());
					tiposervicioLocal.setIsNew(tiposervicio.getIsNew());
					tiposervicioLocal.setIsDeleted(tiposervicio.getIsDeleted());
					
					tiposervicioLocal.setGeneralEntityOriginal(tiposervicio.getGeneralEntityOriginal());
					
					tiposervicioLocal.setId(tiposervicio.getId());	
					tiposervicioLocal.setVersionRow(tiposervicio.getVersionRow());	
					tiposervicioLocal.setcodigo(tiposervicio.getcodigo());	
					tiposervicioLocal.setnombre(tiposervicio.getnombre());	
					
					
					tiposervicioLocal.setParametroInventarioDefectos(tiposervicio.getParametroInventarioDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!tiposervicio.getIsDeleted()) {
				if(!existe) {
					tiposervicios.add(tiposervicio);
				}
			} else {
				if(tiposervicioEncontrado!=null && permiteQuitar)  {
					tiposervicios.remove(tiposervicioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoServicio tiposervicio,List<TipoServicio> tiposervicios) throws Exception {
		try	{			
			for(TipoServicio tiposervicioLocal:tiposervicios) {
				if(tiposervicioLocal.getId().equals(tiposervicio.getId())) {
					tiposervicioLocal.setIsSelected(tiposervicio.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoServicio(List<TipoServicio> tiposerviciosAux) throws Exception {
		//this.tiposerviciosAux=tiposerviciosAux;
		
		for(TipoServicio tiposervicioAux:tiposerviciosAux) {
			if(tiposervicioAux.getIsChanged()) {
				tiposervicioAux.setIsChanged(false);
			}		
			
			if(tiposervicioAux.getIsNew()) {
				tiposervicioAux.setIsNew(false);
			}	
			
			if(tiposervicioAux.getIsDeleted()) {
				tiposervicioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoServicio(TipoServicio tiposervicioAux) throws Exception {
		//this.tiposervicioAux=tiposervicioAux;
		
			if(tiposervicioAux.getIsChanged()) {
				tiposervicioAux.setIsChanged(false);
			}		
			
			if(tiposervicioAux.getIsNew()) {
				tiposervicioAux.setIsNew(false);
			}	
			
			if(tiposervicioAux.getIsDeleted()) {
				tiposervicioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoServicio tiposervicioAsignar,TipoServicio tiposervicio) throws Exception {
		tiposervicioAsignar.setId(tiposervicio.getId());	
		tiposervicioAsignar.setVersionRow(tiposervicio.getVersionRow());	
		tiposervicioAsignar.setcodigo(tiposervicio.getcodigo());	
		tiposervicioAsignar.setnombre(tiposervicio.getnombre());	
	}
	
	public static void inicializarTipoServicio(TipoServicio tiposervicio) throws Exception {
		try {
				tiposervicio.setId(0L);	
					
				tiposervicio.setcodigo("");	
				tiposervicio.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoServicio(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoServicioConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoServicioConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoServicio(String sTipo,Row row,Workbook workbook,TipoServicio tiposervicio,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiposervicio.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiposervicio.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoServicio=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoServicio() {
		return this.sFinalQueryTipoServicio;
	}
	
	public void setsFinalQueryTipoServicio(String sFinalQueryTipoServicio) {
		this.sFinalQueryTipoServicio= sFinalQueryTipoServicio;
	}
	
	public Border resaltarSeleccionarTipoServicio=null;
	
	public Border setResaltarSeleccionarTipoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoServicioBeanSwingJInternalFrame tiposervicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiposervicioBeanSwingJInternalFrame.jTtoolBarTipoServicio.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoServicio= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoServicio() {
		return this.resaltarSeleccionarTipoServicio;
	}
	
	public void setResaltarSeleccionarTipoServicio(Border borderResaltarSeleccionarTipoServicio) {
		this.resaltarSeleccionarTipoServicio= borderResaltarSeleccionarTipoServicio;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoServicio=null;
	public Boolean mostraridTipoServicio=true;
	public Boolean activaridTipoServicio=true;

	public Border resaltarcodigoTipoServicio=null;
	public Boolean mostrarcodigoTipoServicio=true;
	public Boolean activarcodigoTipoServicio=true;

	public Border resaltarnombreTipoServicio=null;
	public Boolean mostrarnombreTipoServicio=true;
	public Boolean activarnombreTipoServicio=true;

	
	

	public Border setResaltaridTipoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoServicioBeanSwingJInternalFrame tiposervicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposervicioBeanSwingJInternalFrame.jTtoolBarTipoServicio.setBorder(borderResaltar);
		
		this.resaltaridTipoServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoServicio() {
		return this.resaltaridTipoServicio;
	}

	public void setResaltaridTipoServicio(Border borderResaltar) {
		this.resaltaridTipoServicio= borderResaltar;
	}

	public Boolean getMostraridTipoServicio() {
		return this.mostraridTipoServicio;
	}

	public void setMostraridTipoServicio(Boolean mostraridTipoServicio) {
		this.mostraridTipoServicio= mostraridTipoServicio;
	}

	public Boolean getActivaridTipoServicio() {
		return this.activaridTipoServicio;
	}

	public void setActivaridTipoServicio(Boolean activaridTipoServicio) {
		this.activaridTipoServicio= activaridTipoServicio;
	}

	public Border setResaltarcodigoTipoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoServicioBeanSwingJInternalFrame tiposervicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposervicioBeanSwingJInternalFrame.jTtoolBarTipoServicio.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoServicio() {
		return this.resaltarcodigoTipoServicio;
	}

	public void setResaltarcodigoTipoServicio(Border borderResaltar) {
		this.resaltarcodigoTipoServicio= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoServicio() {
		return this.mostrarcodigoTipoServicio;
	}

	public void setMostrarcodigoTipoServicio(Boolean mostrarcodigoTipoServicio) {
		this.mostrarcodigoTipoServicio= mostrarcodigoTipoServicio;
	}

	public Boolean getActivarcodigoTipoServicio() {
		return this.activarcodigoTipoServicio;
	}

	public void setActivarcodigoTipoServicio(Boolean activarcodigoTipoServicio) {
		this.activarcodigoTipoServicio= activarcodigoTipoServicio;
	}

	public Border setResaltarnombreTipoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoServicioBeanSwingJInternalFrame tiposervicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposervicioBeanSwingJInternalFrame.jTtoolBarTipoServicio.setBorder(borderResaltar);
		
		this.resaltarnombreTipoServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoServicio() {
		return this.resaltarnombreTipoServicio;
	}

	public void setResaltarnombreTipoServicio(Border borderResaltar) {
		this.resaltarnombreTipoServicio= borderResaltar;
	}

	public Boolean getMostrarnombreTipoServicio() {
		return this.mostrarnombreTipoServicio;
	}

	public void setMostrarnombreTipoServicio(Boolean mostrarnombreTipoServicio) {
		this.mostrarnombreTipoServicio= mostrarnombreTipoServicio;
	}

	public Boolean getActivarnombreTipoServicio() {
		return this.activarnombreTipoServicio;
	}

	public void setActivarnombreTipoServicio(Boolean activarnombreTipoServicio) {
		this.activarnombreTipoServicio= activarnombreTipoServicio;
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
		
		
		this.setMostraridTipoServicio(esInicial);
		this.setMostrarcodigoTipoServicio(esInicial);
		this.setMostrarnombreTipoServicio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoServicioConstantesFunciones.ID)) {
				this.setMostraridTipoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoServicioConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoServicioConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoServicio(esAsigna);
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
		
		
		this.setActivaridTipoServicio(esInicial);
		this.setActivarcodigoTipoServicio(esInicial);
		this.setActivarnombreTipoServicio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoServicioConstantesFunciones.ID)) {
				this.setActivaridTipoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoServicioConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoServicioConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoServicio(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoServicioBeanSwingJInternalFrame tiposervicioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoServicio(esInicial);
		this.setResaltarcodigoTipoServicio(esInicial);
		this.setResaltarnombreTipoServicio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoServicioConstantesFunciones.ID)) {
				this.setResaltaridTipoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoServicioConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoServicioConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoServicio(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarParametroInventarioDefectoTipoServicio=null;

	public Border getResaltarParametroInventarioDefectoTipoServicio() {
		return this.resaltarParametroInventarioDefectoTipoServicio;
	}

	public void setResaltarParametroInventarioDefectoTipoServicio(Border borderResaltarParametroInventarioDefecto) {
		if(borderResaltarParametroInventarioDefecto!=null) {
			this.resaltarParametroInventarioDefectoTipoServicio= borderResaltarParametroInventarioDefecto;
		}
	}

	public Border setResaltarParametroInventarioDefectoTipoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoServicioBeanSwingJInternalFrame tiposervicioBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroInventarioDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tiposervicioBeanSwingJInternalFrame.jTtoolBarTipoServicio.setBorder(borderResaltarParametroInventarioDefecto);
			
		this.resaltarParametroInventarioDefectoTipoServicio= borderResaltarParametroInventarioDefecto;

		 return borderResaltarParametroInventarioDefecto;
	}



	public Boolean mostrarParametroInventarioDefectoTipoServicio=true;

	public Boolean getMostrarParametroInventarioDefectoTipoServicio() {
		return this.mostrarParametroInventarioDefectoTipoServicio;
	}

	public void setMostrarParametroInventarioDefectoTipoServicio(Boolean visibilidadResaltarParametroInventarioDefecto) {
		this.mostrarParametroInventarioDefectoTipoServicio= visibilidadResaltarParametroInventarioDefecto;
	}



	public Boolean activarParametroInventarioDefectoTipoServicio=true;

	public Boolean gethabilitarResaltarParametroInventarioDefectoTipoServicio() {
		return this.activarParametroInventarioDefectoTipoServicio;
	}

	public void setActivarParametroInventarioDefectoTipoServicio(Boolean habilitarResaltarParametroInventarioDefecto) {
		this.activarParametroInventarioDefectoTipoServicio= habilitarResaltarParametroInventarioDefecto;
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

		this.setMostrarParametroInventarioDefectoTipoServicio(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setMostrarParametroInventarioDefectoTipoServicio(esAsigna);
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

		this.setActivarParametroInventarioDefectoTipoServicio(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setActivarParametroInventarioDefectoTipoServicio(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoServicioBeanSwingJInternalFrame tiposervicioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarParametroInventarioDefectoTipoServicio(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setResaltarParametroInventarioDefectoTipoServicio(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoTipoServicio=true;

	public Boolean getMostrarBusquedaPorCodigoTipoServicio() {
		return this.mostrarBusquedaPorCodigoTipoServicio;
	}

	public void setMostrarBusquedaPorCodigoTipoServicio(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoServicio= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoServicio=true;

	public Boolean getMostrarBusquedaPorNombreTipoServicio() {
		return this.mostrarBusquedaPorNombreTipoServicio;
	}

	public void setMostrarBusquedaPorNombreTipoServicio(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoServicio= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoServicio=true;

	public Boolean getActivarBusquedaPorCodigoTipoServicio() {
		return this.activarBusquedaPorCodigoTipoServicio;
	}

	public void setActivarBusquedaPorCodigoTipoServicio(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoServicio= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoServicio=true;

	public Boolean getActivarBusquedaPorNombreTipoServicio() {
		return this.activarBusquedaPorNombreTipoServicio;
	}

	public void setActivarBusquedaPorNombreTipoServicio(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoServicio= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoServicio=null;

	public Border getResaltarBusquedaPorCodigoTipoServicio() {
		return this.resaltarBusquedaPorCodigoTipoServicio;
	}

	public void setResaltarBusquedaPorCodigoTipoServicio(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoServicio= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoServicioBeanSwingJInternalFrame tiposervicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoServicio= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoServicio=null;

	public Border getResaltarBusquedaPorNombreTipoServicio() {
		return this.resaltarBusquedaPorNombreTipoServicio;
	}

	public void setResaltarBusquedaPorNombreTipoServicio(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoServicio= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoServicio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoServicioBeanSwingJInternalFrame tiposervicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoServicio= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}