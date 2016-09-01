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


import com.bydan.erp.facturacion.util.EstadoRetencionConstantesFunciones;
import com.bydan.erp.facturacion.util.EstadoRetencionParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.EstadoRetencionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoRetencionConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoRetencion";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoRetencion"+EstadoRetencionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoRetencionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoRetencionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoRetencionConstantesFunciones.SCHEMA+"_"+EstadoRetencionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoRetencionConstantesFunciones.SCHEMA+"_"+EstadoRetencionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoRetencionConstantesFunciones.SCHEMA+"_"+EstadoRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoRetencionConstantesFunciones.SCHEMA+"_"+EstadoRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoRetencionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoRetencionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoRetencionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoRetencionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Retencions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Retencion";
	public static final String SCLASSWEBTITULO_LOWER="Estado Retencion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoRetencion";
	public static final String OBJECTNAME="estadoretencion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="estado_retencion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadoretencion from "+EstadoRetencionConstantesFunciones.SPERSISTENCENAME+" estadoretencion";
	public static String QUERYSELECTNATIVE="select "+EstadoRetencionConstantesFunciones.SCHEMA+"."+EstadoRetencionConstantesFunciones.TABLENAME+".id,"+EstadoRetencionConstantesFunciones.SCHEMA+"."+EstadoRetencionConstantesFunciones.TABLENAME+".version_row,"+EstadoRetencionConstantesFunciones.SCHEMA+"."+EstadoRetencionConstantesFunciones.TABLENAME+".codigo,"+EstadoRetencionConstantesFunciones.SCHEMA+"."+EstadoRetencionConstantesFunciones.TABLENAME+".nombre from "+EstadoRetencionConstantesFunciones.SCHEMA+"."+EstadoRetencionConstantesFunciones.TABLENAME;//+" as "+EstadoRetencionConstantesFunciones.TABLENAME;
	
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
	
	public static String getEstadoRetencionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoRetencionConstantesFunciones.CODIGO)) {sLabelColumna=EstadoRetencionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoRetencionConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoRetencionConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoRetencionDescripcion(EstadoRetencion estadoretencion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadoretencion !=null/* && estadoretencion.getId()!=0*/) {
			sDescripcion=estadoretencion.getnombre();//estadoretencionestadoretencion.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoRetencionDescripcionDetallado(EstadoRetencion estadoretencion) {
		String sDescripcion="";
			
		sDescripcion+=EstadoRetencionConstantesFunciones.ID+"=";
		sDescripcion+=estadoretencion.getId().toString()+",";
		sDescripcion+=EstadoRetencionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadoretencion.getVersionRow().toString()+",";
		sDescripcion+=EstadoRetencionConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadoretencion.getcodigo()+",";
		sDescripcion+=EstadoRetencionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadoretencion.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoRetencionDescripcion(EstadoRetencion estadoretencion,String sValor) throws Exception {			
		if(estadoretencion !=null) {
			estadoretencion.setnombre(sValor);;//estadoretencionestadoretencion.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoRetencion(EstadoRetencion estadoretencion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadoretencion.setcodigo(estadoretencion.getcodigo().trim());
		estadoretencion.setnombre(estadoretencion.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoRetencions(List<EstadoRetencion> estadoretencions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoRetencion estadoretencion: estadoretencions) {
			estadoretencion.setcodigo(estadoretencion.getcodigo().trim());
			estadoretencion.setnombre(estadoretencion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoRetencion(EstadoRetencion estadoretencion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadoretencion.getConCambioAuxiliar()) {
			estadoretencion.setIsDeleted(estadoretencion.getIsDeletedAuxiliar());	
			estadoretencion.setIsNew(estadoretencion.getIsNewAuxiliar());	
			estadoretencion.setIsChanged(estadoretencion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadoretencion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadoretencion.setIsDeletedAuxiliar(false);	
			estadoretencion.setIsNewAuxiliar(false);	
			estadoretencion.setIsChangedAuxiliar(false);
			
			estadoretencion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoRetencions(List<EstadoRetencion> estadoretencions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoRetencion estadoretencion : estadoretencions) {
			if(conAsignarBase && estadoretencion.getConCambioAuxiliar()) {
				estadoretencion.setIsDeleted(estadoretencion.getIsDeletedAuxiliar());	
				estadoretencion.setIsNew(estadoretencion.getIsNewAuxiliar());	
				estadoretencion.setIsChanged(estadoretencion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadoretencion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadoretencion.setIsDeletedAuxiliar(false);	
				estadoretencion.setIsNewAuxiliar(false);	
				estadoretencion.setIsChangedAuxiliar(false);
				
				estadoretencion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoRetencion(EstadoRetencion estadoretencion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoRetencions(List<EstadoRetencion> estadoretencions,Boolean conEnteros) throws Exception  {
		
		for(EstadoRetencion estadoretencion: estadoretencions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoRetencion(List<EstadoRetencion> estadoretencions,EstadoRetencion estadoretencionAux) throws Exception  {
		EstadoRetencionConstantesFunciones.InicializarValoresEstadoRetencion(estadoretencionAux,true);
		
		for(EstadoRetencion estadoretencion: estadoretencions) {
			if(estadoretencion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoRetencion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoRetencionConstantesFunciones.getArrayColumnasGlobalesEstadoRetencion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoRetencion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoRetencion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoRetencion> estadoretencions,EstadoRetencion estadoretencion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoRetencion estadoretencionAux: estadoretencions) {
			if(estadoretencionAux!=null && estadoretencion!=null) {
				if((estadoretencionAux.getId()==null && estadoretencion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadoretencionAux.getId()!=null && estadoretencion.getId()!=null){
					if(estadoretencionAux.getId().equals(estadoretencion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoRetencion(List<EstadoRetencion> estadoretencions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoRetencion estadoretencion: estadoretencions) {			
			if(estadoretencion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoRetencion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoRetencionConstantesFunciones.LABEL_ID, EstadoRetencionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoRetencionConstantesFunciones.LABEL_VERSIONROW, EstadoRetencionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoRetencionConstantesFunciones.LABEL_CODIGO, EstadoRetencionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoRetencionConstantesFunciones.LABEL_NOMBRE, EstadoRetencionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoRetencion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoRetencionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoRetencionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoRetencionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoRetencionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoRetencion() throws Exception  {
		return EstadoRetencionConstantesFunciones.getTiposSeleccionarEstadoRetencion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoRetencion(Boolean conFk) throws Exception  {
		return EstadoRetencionConstantesFunciones.getTiposSeleccionarEstadoRetencion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoRetencion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoRetencionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoRetencionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoRetencionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoRetencionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoRetencion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoRetencion(EstadoRetencion estadoretencionAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoRetencion(List<EstadoRetencion> estadoretencionsTemp) throws Exception {
		for(EstadoRetencion estadoretencionAux:estadoretencionsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoRetencionConstantesFunciones.getClassesRelationshipsOfEstadoRetencion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ClienteRetencion.class));
				classes.add(new Classe(Retencion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ClienteRetencion.class)) {
						classes.add(new Classe(ClienteRetencion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Retencion.class)) {
						classes.add(new Classe(Retencion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoRetencionConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoRetencion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ClienteRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ClienteRetencion.class)); continue;
					}

					if(Retencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Retencion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ClienteRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ClienteRetencion.class)); continue;
					}

					if(Retencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Retencion.class)); continue;
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
	public static void actualizarLista(EstadoRetencion estadoretencion,List<EstadoRetencion> estadoretencions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoRetencion estadoretencionEncontrado=null;
			
			for(EstadoRetencion estadoretencionLocal:estadoretencions) {
				if(estadoretencionLocal.getId().equals(estadoretencion.getId())) {
					estadoretencionEncontrado=estadoretencionLocal;
					
					estadoretencionLocal.setIsChanged(estadoretencion.getIsChanged());
					estadoretencionLocal.setIsNew(estadoretencion.getIsNew());
					estadoretencionLocal.setIsDeleted(estadoretencion.getIsDeleted());
					
					estadoretencionLocal.setGeneralEntityOriginal(estadoretencion.getGeneralEntityOriginal());
					
					estadoretencionLocal.setId(estadoretencion.getId());	
					estadoretencionLocal.setVersionRow(estadoretencion.getVersionRow());	
					estadoretencionLocal.setcodigo(estadoretencion.getcodigo());	
					estadoretencionLocal.setnombre(estadoretencion.getnombre());	
					
					
					estadoretencionLocal.setClienteRetencions(estadoretencion.getClienteRetencions());
					estadoretencionLocal.setRetencions(estadoretencion.getRetencions());
					
					existe=true;
					break;
				}
			}
			
			if(!estadoretencion.getIsDeleted()) {
				if(!existe) {
					estadoretencions.add(estadoretencion);
				}
			} else {
				if(estadoretencionEncontrado!=null && permiteQuitar)  {
					estadoretencions.remove(estadoretencionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoRetencion estadoretencion,List<EstadoRetencion> estadoretencions) throws Exception {
		try	{			
			for(EstadoRetencion estadoretencionLocal:estadoretencions) {
				if(estadoretencionLocal.getId().equals(estadoretencion.getId())) {
					estadoretencionLocal.setIsSelected(estadoretencion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoRetencion(List<EstadoRetencion> estadoretencionsAux) throws Exception {
		//this.estadoretencionsAux=estadoretencionsAux;
		
		for(EstadoRetencion estadoretencionAux:estadoretencionsAux) {
			if(estadoretencionAux.getIsChanged()) {
				estadoretencionAux.setIsChanged(false);
			}		
			
			if(estadoretencionAux.getIsNew()) {
				estadoretencionAux.setIsNew(false);
			}	
			
			if(estadoretencionAux.getIsDeleted()) {
				estadoretencionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoRetencion(EstadoRetencion estadoretencionAux) throws Exception {
		//this.estadoretencionAux=estadoretencionAux;
		
			if(estadoretencionAux.getIsChanged()) {
				estadoretencionAux.setIsChanged(false);
			}		
			
			if(estadoretencionAux.getIsNew()) {
				estadoretencionAux.setIsNew(false);
			}	
			
			if(estadoretencionAux.getIsDeleted()) {
				estadoretencionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoRetencion estadoretencionAsignar,EstadoRetencion estadoretencion) throws Exception {
		estadoretencionAsignar.setId(estadoretencion.getId());	
		estadoretencionAsignar.setVersionRow(estadoretencion.getVersionRow());	
		estadoretencionAsignar.setcodigo(estadoretencion.getcodigo());	
		estadoretencionAsignar.setnombre(estadoretencion.getnombre());	
	}
	
	public static void inicializarEstadoRetencion(EstadoRetencion estadoretencion) throws Exception {
		try {
				estadoretencion.setId(0L);	
					
				estadoretencion.setcodigo("");	
				estadoretencion.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoRetencion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoRetencionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoRetencionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoRetencion(String sTipo,Row row,Workbook workbook,EstadoRetencion estadoretencion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoretencion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoretencion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoRetencion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoRetencion() {
		return this.sFinalQueryEstadoRetencion;
	}
	
	public void setsFinalQueryEstadoRetencion(String sFinalQueryEstadoRetencion) {
		this.sFinalQueryEstadoRetencion= sFinalQueryEstadoRetencion;
	}
	
	public Border resaltarSeleccionarEstadoRetencion=null;
	
	public Border setResaltarSeleccionarEstadoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoRetencionBeanSwingJInternalFrame estadoretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadoretencionBeanSwingJInternalFrame.jTtoolBarEstadoRetencion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoRetencion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoRetencion() {
		return this.resaltarSeleccionarEstadoRetencion;
	}
	
	public void setResaltarSeleccionarEstadoRetencion(Border borderResaltarSeleccionarEstadoRetencion) {
		this.resaltarSeleccionarEstadoRetencion= borderResaltarSeleccionarEstadoRetencion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoRetencion=null;
	public Boolean mostraridEstadoRetencion=true;
	public Boolean activaridEstadoRetencion=true;

	public Border resaltarcodigoEstadoRetencion=null;
	public Boolean mostrarcodigoEstadoRetencion=true;
	public Boolean activarcodigoEstadoRetencion=true;

	public Border resaltarnombreEstadoRetencion=null;
	public Boolean mostrarnombreEstadoRetencion=true;
	public Boolean activarnombreEstadoRetencion=true;

	
	

	public Border setResaltaridEstadoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoRetencionBeanSwingJInternalFrame estadoretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoretencionBeanSwingJInternalFrame.jTtoolBarEstadoRetencion.setBorder(borderResaltar);
		
		this.resaltaridEstadoRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoRetencion() {
		return this.resaltaridEstadoRetencion;
	}

	public void setResaltaridEstadoRetencion(Border borderResaltar) {
		this.resaltaridEstadoRetencion= borderResaltar;
	}

	public Boolean getMostraridEstadoRetencion() {
		return this.mostraridEstadoRetencion;
	}

	public void setMostraridEstadoRetencion(Boolean mostraridEstadoRetencion) {
		this.mostraridEstadoRetencion= mostraridEstadoRetencion;
	}

	public Boolean getActivaridEstadoRetencion() {
		return this.activaridEstadoRetencion;
	}

	public void setActivaridEstadoRetencion(Boolean activaridEstadoRetencion) {
		this.activaridEstadoRetencion= activaridEstadoRetencion;
	}

	public Border setResaltarcodigoEstadoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoRetencionBeanSwingJInternalFrame estadoretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoretencionBeanSwingJInternalFrame.jTtoolBarEstadoRetencion.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoRetencion() {
		return this.resaltarcodigoEstadoRetencion;
	}

	public void setResaltarcodigoEstadoRetencion(Border borderResaltar) {
		this.resaltarcodigoEstadoRetencion= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoRetencion() {
		return this.mostrarcodigoEstadoRetencion;
	}

	public void setMostrarcodigoEstadoRetencion(Boolean mostrarcodigoEstadoRetencion) {
		this.mostrarcodigoEstadoRetencion= mostrarcodigoEstadoRetencion;
	}

	public Boolean getActivarcodigoEstadoRetencion() {
		return this.activarcodigoEstadoRetencion;
	}

	public void setActivarcodigoEstadoRetencion(Boolean activarcodigoEstadoRetencion) {
		this.activarcodigoEstadoRetencion= activarcodigoEstadoRetencion;
	}

	public Border setResaltarnombreEstadoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoRetencionBeanSwingJInternalFrame estadoretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoretencionBeanSwingJInternalFrame.jTtoolBarEstadoRetencion.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoRetencion() {
		return this.resaltarnombreEstadoRetencion;
	}

	public void setResaltarnombreEstadoRetencion(Border borderResaltar) {
		this.resaltarnombreEstadoRetencion= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoRetencion() {
		return this.mostrarnombreEstadoRetencion;
	}

	public void setMostrarnombreEstadoRetencion(Boolean mostrarnombreEstadoRetencion) {
		this.mostrarnombreEstadoRetencion= mostrarnombreEstadoRetencion;
	}

	public Boolean getActivarnombreEstadoRetencion() {
		return this.activarnombreEstadoRetencion;
	}

	public void setActivarnombreEstadoRetencion(Boolean activarnombreEstadoRetencion) {
		this.activarnombreEstadoRetencion= activarnombreEstadoRetencion;
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
		
		
		this.setMostraridEstadoRetencion(esInicial);
		this.setMostrarcodigoEstadoRetencion(esInicial);
		this.setMostrarnombreEstadoRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoRetencionConstantesFunciones.ID)) {
				this.setMostraridEstadoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRetencionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRetencionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoRetencion(esAsigna);
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
		
		
		this.setActivaridEstadoRetencion(esInicial);
		this.setActivarcodigoEstadoRetencion(esInicial);
		this.setActivarnombreEstadoRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoRetencionConstantesFunciones.ID)) {
				this.setActivaridEstadoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRetencionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRetencionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoRetencion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoRetencionBeanSwingJInternalFrame estadoretencionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoRetencion(esInicial);
		this.setResaltarcodigoEstadoRetencion(esInicial);
		this.setResaltarnombreEstadoRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoRetencionConstantesFunciones.ID)) {
				this.setResaltaridEstadoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRetencionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRetencionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoRetencion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarClienteRetencionEstadoRetencion=null;

	public Border getResaltarClienteRetencionEstadoRetencion() {
		return this.resaltarClienteRetencionEstadoRetencion;
	}

	public void setResaltarClienteRetencionEstadoRetencion(Border borderResaltarClienteRetencion) {
		if(borderResaltarClienteRetencion!=null) {
			this.resaltarClienteRetencionEstadoRetencion= borderResaltarClienteRetencion;
		}
	}

	public Border setResaltarClienteRetencionEstadoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoRetencionBeanSwingJInternalFrame estadoretencionBeanSwingJInternalFrame*/) {
		Border borderResaltarClienteRetencion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadoretencionBeanSwingJInternalFrame.jTtoolBarEstadoRetencion.setBorder(borderResaltarClienteRetencion);
			
		this.resaltarClienteRetencionEstadoRetencion= borderResaltarClienteRetencion;

		 return borderResaltarClienteRetencion;
	}



	public Boolean mostrarClienteRetencionEstadoRetencion=true;

	public Boolean getMostrarClienteRetencionEstadoRetencion() {
		return this.mostrarClienteRetencionEstadoRetencion;
	}

	public void setMostrarClienteRetencionEstadoRetencion(Boolean visibilidadResaltarClienteRetencion) {
		this.mostrarClienteRetencionEstadoRetencion= visibilidadResaltarClienteRetencion;
	}



	public Boolean activarClienteRetencionEstadoRetencion=true;

	public Boolean gethabilitarResaltarClienteRetencionEstadoRetencion() {
		return this.activarClienteRetencionEstadoRetencion;
	}

	public void setActivarClienteRetencionEstadoRetencion(Boolean habilitarResaltarClienteRetencion) {
		this.activarClienteRetencionEstadoRetencion= habilitarResaltarClienteRetencion;
	}


	public Border resaltarRetencionEstadoRetencion=null;

	public Border getResaltarRetencionEstadoRetencion() {
		return this.resaltarRetencionEstadoRetencion;
	}

	public void setResaltarRetencionEstadoRetencion(Border borderResaltarRetencion) {
		if(borderResaltarRetencion!=null) {
			this.resaltarRetencionEstadoRetencion= borderResaltarRetencion;
		}
	}

	public Border setResaltarRetencionEstadoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoRetencionBeanSwingJInternalFrame estadoretencionBeanSwingJInternalFrame*/) {
		Border borderResaltarRetencion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadoretencionBeanSwingJInternalFrame.jTtoolBarEstadoRetencion.setBorder(borderResaltarRetencion);
			
		this.resaltarRetencionEstadoRetencion= borderResaltarRetencion;

		 return borderResaltarRetencion;
	}



	public Boolean mostrarRetencionEstadoRetencion=true;

	public Boolean getMostrarRetencionEstadoRetencion() {
		return this.mostrarRetencionEstadoRetencion;
	}

	public void setMostrarRetencionEstadoRetencion(Boolean visibilidadResaltarRetencion) {
		this.mostrarRetencionEstadoRetencion= visibilidadResaltarRetencion;
	}



	public Boolean activarRetencionEstadoRetencion=true;

	public Boolean gethabilitarResaltarRetencionEstadoRetencion() {
		return this.activarRetencionEstadoRetencion;
	}

	public void setActivarRetencionEstadoRetencion(Boolean habilitarResaltarRetencion) {
		this.activarRetencionEstadoRetencion= habilitarResaltarRetencion;
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

		this.setMostrarClienteRetencionEstadoRetencion(esInicial);
		this.setMostrarRetencionEstadoRetencion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ClienteRetencion.class)) {
				this.setMostrarClienteRetencionEstadoRetencion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Retencion.class)) {
				this.setMostrarRetencionEstadoRetencion(esAsigna);
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

		this.setActivarClienteRetencionEstadoRetencion(esInicial);
		this.setActivarRetencionEstadoRetencion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ClienteRetencion.class)) {
				this.setActivarClienteRetencionEstadoRetencion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Retencion.class)) {
				this.setActivarRetencionEstadoRetencion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoRetencionBeanSwingJInternalFrame estadoretencionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarClienteRetencionEstadoRetencion(esInicial);
		this.setResaltarRetencionEstadoRetencion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ClienteRetencion.class)) {
				this.setResaltarClienteRetencionEstadoRetencion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Retencion.class)) {
				this.setResaltarRetencionEstadoRetencion(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}