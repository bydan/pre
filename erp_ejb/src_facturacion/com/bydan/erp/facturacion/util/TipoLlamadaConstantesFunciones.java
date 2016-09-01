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


import com.bydan.erp.facturacion.util.TipoLlamadaConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoLlamadaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoLlamadaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoLlamadaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoLlamada";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoLlamada"+TipoLlamadaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoLlamadaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoLlamadaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoLlamadaConstantesFunciones.SCHEMA+"_"+TipoLlamadaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoLlamadaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoLlamadaConstantesFunciones.SCHEMA+"_"+TipoLlamadaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoLlamadaConstantesFunciones.SCHEMA+"_"+TipoLlamadaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoLlamadaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoLlamadaConstantesFunciones.SCHEMA+"_"+TipoLlamadaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoLlamadaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoLlamadaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoLlamadaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoLlamadaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoLlamadaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoLlamadaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoLlamadaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoLlamadaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoLlamadaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoLlamadaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Llamadas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Llamada";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Llamada";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoLlamada";
	public static final String OBJECTNAME="tipollamada";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tipo_llamada";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipollamada from "+TipoLlamadaConstantesFunciones.SPERSISTENCENAME+" tipollamada";
	public static String QUERYSELECTNATIVE="select "+TipoLlamadaConstantesFunciones.SCHEMA+"."+TipoLlamadaConstantesFunciones.TABLENAME+".id,"+TipoLlamadaConstantesFunciones.SCHEMA+"."+TipoLlamadaConstantesFunciones.TABLENAME+".version_row,"+TipoLlamadaConstantesFunciones.SCHEMA+"."+TipoLlamadaConstantesFunciones.TABLENAME+".codigo,"+TipoLlamadaConstantesFunciones.SCHEMA+"."+TipoLlamadaConstantesFunciones.TABLENAME+".nombre from "+TipoLlamadaConstantesFunciones.SCHEMA+"."+TipoLlamadaConstantesFunciones.TABLENAME;//+" as "+TipoLlamadaConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoLlamadaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoLlamadaConstantesFunciones.CODIGO)) {sLabelColumna=TipoLlamadaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoLlamadaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoLlamadaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoLlamadaDescripcion(TipoLlamada tipollamada) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipollamada !=null/* && tipollamada.getId()!=0*/) {
			sDescripcion=tipollamada.getcodigo();//tipollamadatipollamada.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoLlamadaDescripcionDetallado(TipoLlamada tipollamada) {
		String sDescripcion="";
			
		sDescripcion+=TipoLlamadaConstantesFunciones.ID+"=";
		sDescripcion+=tipollamada.getId().toString()+",";
		sDescripcion+=TipoLlamadaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipollamada.getVersionRow().toString()+",";
		sDescripcion+=TipoLlamadaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipollamada.getcodigo()+",";
		sDescripcion+=TipoLlamadaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipollamada.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoLlamadaDescripcion(TipoLlamada tipollamada,String sValor) throws Exception {			
		if(tipollamada !=null) {
			tipollamada.setcodigo(sValor);;//tipollamadatipollamada.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoLlamada(TipoLlamada tipollamada,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipollamada.setcodigo(tipollamada.getcodigo().trim());
		tipollamada.setnombre(tipollamada.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoLlamadas(List<TipoLlamada> tipollamadas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoLlamada tipollamada: tipollamadas) {
			tipollamada.setcodigo(tipollamada.getcodigo().trim());
			tipollamada.setnombre(tipollamada.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoLlamada(TipoLlamada tipollamada,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipollamada.getConCambioAuxiliar()) {
			tipollamada.setIsDeleted(tipollamada.getIsDeletedAuxiliar());	
			tipollamada.setIsNew(tipollamada.getIsNewAuxiliar());	
			tipollamada.setIsChanged(tipollamada.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipollamada.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipollamada.setIsDeletedAuxiliar(false);	
			tipollamada.setIsNewAuxiliar(false);	
			tipollamada.setIsChangedAuxiliar(false);
			
			tipollamada.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoLlamadas(List<TipoLlamada> tipollamadas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoLlamada tipollamada : tipollamadas) {
			if(conAsignarBase && tipollamada.getConCambioAuxiliar()) {
				tipollamada.setIsDeleted(tipollamada.getIsDeletedAuxiliar());	
				tipollamada.setIsNew(tipollamada.getIsNewAuxiliar());	
				tipollamada.setIsChanged(tipollamada.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipollamada.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipollamada.setIsDeletedAuxiliar(false);	
				tipollamada.setIsNewAuxiliar(false);	
				tipollamada.setIsChangedAuxiliar(false);
				
				tipollamada.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoLlamada(TipoLlamada tipollamada,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoLlamadas(List<TipoLlamada> tipollamadas,Boolean conEnteros) throws Exception  {
		
		for(TipoLlamada tipollamada: tipollamadas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoLlamada(List<TipoLlamada> tipollamadas,TipoLlamada tipollamadaAux) throws Exception  {
		TipoLlamadaConstantesFunciones.InicializarValoresTipoLlamada(tipollamadaAux,true);
		
		for(TipoLlamada tipollamada: tipollamadas) {
			if(tipollamada.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoLlamada(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoLlamadaConstantesFunciones.getArrayColumnasGlobalesTipoLlamada(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoLlamada(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoLlamada(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoLlamada> tipollamadas,TipoLlamada tipollamada,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoLlamada tipollamadaAux: tipollamadas) {
			if(tipollamadaAux!=null && tipollamada!=null) {
				if((tipollamadaAux.getId()==null && tipollamada.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipollamadaAux.getId()!=null && tipollamada.getId()!=null){
					if(tipollamadaAux.getId().equals(tipollamada.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoLlamada(List<TipoLlamada> tipollamadas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoLlamada tipollamada: tipollamadas) {			
			if(tipollamada.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoLlamada() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoLlamadaConstantesFunciones.LABEL_ID, TipoLlamadaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoLlamadaConstantesFunciones.LABEL_VERSIONROW, TipoLlamadaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoLlamadaConstantesFunciones.LABEL_CODIGO, TipoLlamadaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoLlamadaConstantesFunciones.LABEL_NOMBRE, TipoLlamadaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoLlamada() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoLlamadaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoLlamadaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoLlamadaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoLlamadaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoLlamada() throws Exception  {
		return TipoLlamadaConstantesFunciones.getTiposSeleccionarTipoLlamada(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoLlamada(Boolean conFk) throws Exception  {
		return TipoLlamadaConstantesFunciones.getTiposSeleccionarTipoLlamada(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoLlamada(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoLlamadaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoLlamadaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoLlamadaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoLlamadaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoLlamada(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoLlamada(TipoLlamada tipollamadaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoLlamada(List<TipoLlamada> tipollamadasTemp) throws Exception {
		for(TipoLlamada tipollamadaAux:tipollamadasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoLlamada(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoLlamada(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoLlamada(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoLlamadaConstantesFunciones.getClassesRelationshipsOfTipoLlamada(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoLlamada(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoLlamada(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoLlamadaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoLlamada(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoLlamada(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(TipoLlamada tipollamada,List<TipoLlamada> tipollamadas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoLlamada tipollamadaEncontrado=null;
			
			for(TipoLlamada tipollamadaLocal:tipollamadas) {
				if(tipollamadaLocal.getId().equals(tipollamada.getId())) {
					tipollamadaEncontrado=tipollamadaLocal;
					
					tipollamadaLocal.setIsChanged(tipollamada.getIsChanged());
					tipollamadaLocal.setIsNew(tipollamada.getIsNew());
					tipollamadaLocal.setIsDeleted(tipollamada.getIsDeleted());
					
					tipollamadaLocal.setGeneralEntityOriginal(tipollamada.getGeneralEntityOriginal());
					
					tipollamadaLocal.setId(tipollamada.getId());	
					tipollamadaLocal.setVersionRow(tipollamada.getVersionRow());	
					tipollamadaLocal.setcodigo(tipollamada.getcodigo());	
					tipollamadaLocal.setnombre(tipollamada.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipollamada.getIsDeleted()) {
				if(!existe) {
					tipollamadas.add(tipollamada);
				}
			} else {
				if(tipollamadaEncontrado!=null && permiteQuitar)  {
					tipollamadas.remove(tipollamadaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoLlamada tipollamada,List<TipoLlamada> tipollamadas) throws Exception {
		try	{			
			for(TipoLlamada tipollamadaLocal:tipollamadas) {
				if(tipollamadaLocal.getId().equals(tipollamada.getId())) {
					tipollamadaLocal.setIsSelected(tipollamada.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoLlamada(List<TipoLlamada> tipollamadasAux) throws Exception {
		//this.tipollamadasAux=tipollamadasAux;
		
		for(TipoLlamada tipollamadaAux:tipollamadasAux) {
			if(tipollamadaAux.getIsChanged()) {
				tipollamadaAux.setIsChanged(false);
			}		
			
			if(tipollamadaAux.getIsNew()) {
				tipollamadaAux.setIsNew(false);
			}	
			
			if(tipollamadaAux.getIsDeleted()) {
				tipollamadaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoLlamada(TipoLlamada tipollamadaAux) throws Exception {
		//this.tipollamadaAux=tipollamadaAux;
		
			if(tipollamadaAux.getIsChanged()) {
				tipollamadaAux.setIsChanged(false);
			}		
			
			if(tipollamadaAux.getIsNew()) {
				tipollamadaAux.setIsNew(false);
			}	
			
			if(tipollamadaAux.getIsDeleted()) {
				tipollamadaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoLlamada tipollamadaAsignar,TipoLlamada tipollamada) throws Exception {
		tipollamadaAsignar.setId(tipollamada.getId());	
		tipollamadaAsignar.setVersionRow(tipollamada.getVersionRow());	
		tipollamadaAsignar.setcodigo(tipollamada.getcodigo());	
		tipollamadaAsignar.setnombre(tipollamada.getnombre());	
	}
	
	public static void inicializarTipoLlamada(TipoLlamada tipollamada) throws Exception {
		try {
				tipollamada.setId(0L);	
					
				tipollamada.setcodigo("");	
				tipollamada.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoLlamada(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoLlamadaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoLlamadaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoLlamada(String sTipo,Row row,Workbook workbook,TipoLlamada tipollamada,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipollamada.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipollamada.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoLlamada=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoLlamada() {
		return this.sFinalQueryTipoLlamada;
	}
	
	public void setsFinalQueryTipoLlamada(String sFinalQueryTipoLlamada) {
		this.sFinalQueryTipoLlamada= sFinalQueryTipoLlamada;
	}
	
	public Border resaltarSeleccionarTipoLlamada=null;
	
	public Border setResaltarSeleccionarTipoLlamada(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLlamadaBeanSwingJInternalFrame tipollamadaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipollamadaBeanSwingJInternalFrame.jTtoolBarTipoLlamada.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoLlamada= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoLlamada() {
		return this.resaltarSeleccionarTipoLlamada;
	}
	
	public void setResaltarSeleccionarTipoLlamada(Border borderResaltarSeleccionarTipoLlamada) {
		this.resaltarSeleccionarTipoLlamada= borderResaltarSeleccionarTipoLlamada;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoLlamada=null;
	public Boolean mostraridTipoLlamada=true;
	public Boolean activaridTipoLlamada=true;

	public Border resaltarcodigoTipoLlamada=null;
	public Boolean mostrarcodigoTipoLlamada=true;
	public Boolean activarcodigoTipoLlamada=true;

	public Border resaltarnombreTipoLlamada=null;
	public Boolean mostrarnombreTipoLlamada=true;
	public Boolean activarnombreTipoLlamada=true;

	
	

	public Border setResaltaridTipoLlamada(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLlamadaBeanSwingJInternalFrame tipollamadaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipollamadaBeanSwingJInternalFrame.jTtoolBarTipoLlamada.setBorder(borderResaltar);
		
		this.resaltaridTipoLlamada= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoLlamada() {
		return this.resaltaridTipoLlamada;
	}

	public void setResaltaridTipoLlamada(Border borderResaltar) {
		this.resaltaridTipoLlamada= borderResaltar;
	}

	public Boolean getMostraridTipoLlamada() {
		return this.mostraridTipoLlamada;
	}

	public void setMostraridTipoLlamada(Boolean mostraridTipoLlamada) {
		this.mostraridTipoLlamada= mostraridTipoLlamada;
	}

	public Boolean getActivaridTipoLlamada() {
		return this.activaridTipoLlamada;
	}

	public void setActivaridTipoLlamada(Boolean activaridTipoLlamada) {
		this.activaridTipoLlamada= activaridTipoLlamada;
	}

	public Border setResaltarcodigoTipoLlamada(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLlamadaBeanSwingJInternalFrame tipollamadaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipollamadaBeanSwingJInternalFrame.jTtoolBarTipoLlamada.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoLlamada= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoLlamada() {
		return this.resaltarcodigoTipoLlamada;
	}

	public void setResaltarcodigoTipoLlamada(Border borderResaltar) {
		this.resaltarcodigoTipoLlamada= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoLlamada() {
		return this.mostrarcodigoTipoLlamada;
	}

	public void setMostrarcodigoTipoLlamada(Boolean mostrarcodigoTipoLlamada) {
		this.mostrarcodigoTipoLlamada= mostrarcodigoTipoLlamada;
	}

	public Boolean getActivarcodigoTipoLlamada() {
		return this.activarcodigoTipoLlamada;
	}

	public void setActivarcodigoTipoLlamada(Boolean activarcodigoTipoLlamada) {
		this.activarcodigoTipoLlamada= activarcodigoTipoLlamada;
	}

	public Border setResaltarnombreTipoLlamada(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLlamadaBeanSwingJInternalFrame tipollamadaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipollamadaBeanSwingJInternalFrame.jTtoolBarTipoLlamada.setBorder(borderResaltar);
		
		this.resaltarnombreTipoLlamada= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoLlamada() {
		return this.resaltarnombreTipoLlamada;
	}

	public void setResaltarnombreTipoLlamada(Border borderResaltar) {
		this.resaltarnombreTipoLlamada= borderResaltar;
	}

	public Boolean getMostrarnombreTipoLlamada() {
		return this.mostrarnombreTipoLlamada;
	}

	public void setMostrarnombreTipoLlamada(Boolean mostrarnombreTipoLlamada) {
		this.mostrarnombreTipoLlamada= mostrarnombreTipoLlamada;
	}

	public Boolean getActivarnombreTipoLlamada() {
		return this.activarnombreTipoLlamada;
	}

	public void setActivarnombreTipoLlamada(Boolean activarnombreTipoLlamada) {
		this.activarnombreTipoLlamada= activarnombreTipoLlamada;
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
		
		
		this.setMostraridTipoLlamada(esInicial);
		this.setMostrarcodigoTipoLlamada(esInicial);
		this.setMostrarnombreTipoLlamada(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoLlamadaConstantesFunciones.ID)) {
				this.setMostraridTipoLlamada(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLlamadaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoLlamada(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLlamadaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoLlamada(esAsigna);
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
		
		
		this.setActivaridTipoLlamada(esInicial);
		this.setActivarcodigoTipoLlamada(esInicial);
		this.setActivarnombreTipoLlamada(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoLlamadaConstantesFunciones.ID)) {
				this.setActivaridTipoLlamada(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLlamadaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoLlamada(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLlamadaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoLlamada(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoLlamadaBeanSwingJInternalFrame tipollamadaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoLlamada(esInicial);
		this.setResaltarcodigoTipoLlamada(esInicial);
		this.setResaltarnombreTipoLlamada(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoLlamadaConstantesFunciones.ID)) {
				this.setResaltaridTipoLlamada(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLlamadaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoLlamada(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLlamadaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoLlamada(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoLlamadaBeanSwingJInternalFrame tipollamadaBeanSwingJInternalFrame*/)throws Exception {	
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