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
package com.bydan.erp.importaciones.util;

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


import com.bydan.erp.importaciones.util.TipoPuertoConstantesFunciones;
import com.bydan.erp.importaciones.util.TipoPuertoParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.TipoPuertoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;



import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoPuertoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoPuerto";
	public static final String SPATHOPCION="Importaciones";	
	public static final String SPATHMODULO="importaciones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoPuerto"+TipoPuertoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoPuertoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoPuertoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoPuertoConstantesFunciones.SCHEMA+"_"+TipoPuertoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoPuertoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoPuertoConstantesFunciones.SCHEMA+"_"+TipoPuertoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoPuertoConstantesFunciones.SCHEMA+"_"+TipoPuertoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoPuertoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoPuertoConstantesFunciones.SCHEMA+"_"+TipoPuertoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPuertoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPuertoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPuertoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPuertoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPuertoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPuertoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoPuertoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoPuertoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoPuertoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoPuertoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Puertos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Puerto";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Puerto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoPuerto";
	public static final String OBJECTNAME="tipopuerto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_IMPORTACIONES;	
	public static final String TABLENAME="tipo_puerto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipopuerto from "+TipoPuertoConstantesFunciones.SPERSISTENCENAME+" tipopuerto";
	public static String QUERYSELECTNATIVE="select "+TipoPuertoConstantesFunciones.SCHEMA+"."+TipoPuertoConstantesFunciones.TABLENAME+".id,"+TipoPuertoConstantesFunciones.SCHEMA+"."+TipoPuertoConstantesFunciones.TABLENAME+".version_row,"+TipoPuertoConstantesFunciones.SCHEMA+"."+TipoPuertoConstantesFunciones.TABLENAME+".codigo,"+TipoPuertoConstantesFunciones.SCHEMA+"."+TipoPuertoConstantesFunciones.TABLENAME+".nombre from "+TipoPuertoConstantesFunciones.SCHEMA+"."+TipoPuertoConstantesFunciones.TABLENAME;//+" as "+TipoPuertoConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoPuertoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoPuertoConstantesFunciones.CODIGO)) {sLabelColumna=TipoPuertoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoPuertoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoPuertoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoPuertoDescripcion(TipoPuerto tipopuerto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipopuerto !=null/* && tipopuerto.getId()!=0*/) {
			sDescripcion=tipopuerto.getcodigo();//tipopuertotipopuerto.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoPuertoDescripcionDetallado(TipoPuerto tipopuerto) {
		String sDescripcion="";
			
		sDescripcion+=TipoPuertoConstantesFunciones.ID+"=";
		sDescripcion+=tipopuerto.getId().toString()+",";
		sDescripcion+=TipoPuertoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipopuerto.getVersionRow().toString()+",";
		sDescripcion+=TipoPuertoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipopuerto.getcodigo()+",";
		sDescripcion+=TipoPuertoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipopuerto.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoPuertoDescripcion(TipoPuerto tipopuerto,String sValor) throws Exception {			
		if(tipopuerto !=null) {
			tipopuerto.setcodigo(sValor);;//tipopuertotipopuerto.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoPuerto(TipoPuerto tipopuerto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipopuerto.setcodigo(tipopuerto.getcodigo().trim());
		tipopuerto.setnombre(tipopuerto.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoPuertos(List<TipoPuerto> tipopuertos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoPuerto tipopuerto: tipopuertos) {
			tipopuerto.setcodigo(tipopuerto.getcodigo().trim());
			tipopuerto.setnombre(tipopuerto.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPuerto(TipoPuerto tipopuerto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipopuerto.getConCambioAuxiliar()) {
			tipopuerto.setIsDeleted(tipopuerto.getIsDeletedAuxiliar());	
			tipopuerto.setIsNew(tipopuerto.getIsNewAuxiliar());	
			tipopuerto.setIsChanged(tipopuerto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipopuerto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipopuerto.setIsDeletedAuxiliar(false);	
			tipopuerto.setIsNewAuxiliar(false);	
			tipopuerto.setIsChangedAuxiliar(false);
			
			tipopuerto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPuertos(List<TipoPuerto> tipopuertos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoPuerto tipopuerto : tipopuertos) {
			if(conAsignarBase && tipopuerto.getConCambioAuxiliar()) {
				tipopuerto.setIsDeleted(tipopuerto.getIsDeletedAuxiliar());	
				tipopuerto.setIsNew(tipopuerto.getIsNewAuxiliar());	
				tipopuerto.setIsChanged(tipopuerto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipopuerto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipopuerto.setIsDeletedAuxiliar(false);	
				tipopuerto.setIsNewAuxiliar(false);	
				tipopuerto.setIsChangedAuxiliar(false);
				
				tipopuerto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoPuerto(TipoPuerto tipopuerto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoPuertos(List<TipoPuerto> tipopuertos,Boolean conEnteros) throws Exception  {
		
		for(TipoPuerto tipopuerto: tipopuertos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoPuerto(List<TipoPuerto> tipopuertos,TipoPuerto tipopuertoAux) throws Exception  {
		TipoPuertoConstantesFunciones.InicializarValoresTipoPuerto(tipopuertoAux,true);
		
		for(TipoPuerto tipopuerto: tipopuertos) {
			if(tipopuerto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPuerto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoPuertoConstantesFunciones.getArrayColumnasGlobalesTipoPuerto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPuerto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoPuerto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoPuerto> tipopuertos,TipoPuerto tipopuerto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoPuerto tipopuertoAux: tipopuertos) {
			if(tipopuertoAux!=null && tipopuerto!=null) {
				if((tipopuertoAux.getId()==null && tipopuerto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipopuertoAux.getId()!=null && tipopuerto.getId()!=null){
					if(tipopuertoAux.getId().equals(tipopuerto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoPuerto(List<TipoPuerto> tipopuertos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoPuerto tipopuerto: tipopuertos) {			
			if(tipopuerto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoPuerto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoPuertoConstantesFunciones.LABEL_ID, TipoPuertoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPuertoConstantesFunciones.LABEL_VERSIONROW, TipoPuertoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPuertoConstantesFunciones.LABEL_CODIGO, TipoPuertoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPuertoConstantesFunciones.LABEL_NOMBRE, TipoPuertoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoPuerto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoPuertoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPuertoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPuertoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPuertoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPuerto() throws Exception  {
		return TipoPuertoConstantesFunciones.getTiposSeleccionarTipoPuerto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPuerto(Boolean conFk) throws Exception  {
		return TipoPuertoConstantesFunciones.getTiposSeleccionarTipoPuerto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPuerto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPuertoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoPuertoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPuertoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoPuertoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoPuerto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPuerto(TipoPuerto tipopuertoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPuerto(List<TipoPuerto> tipopuertosTemp) throws Exception {
		for(TipoPuerto tipopuertoAux:tipopuertosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoPuerto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoPuerto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPuerto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPuertoConstantesFunciones.getClassesRelationshipsOfTipoPuerto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPuerto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPuerto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPuertoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoPuerto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPuerto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoPuerto tipopuerto,List<TipoPuerto> tipopuertos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoPuerto tipopuertoEncontrado=null;
			
			for(TipoPuerto tipopuertoLocal:tipopuertos) {
				if(tipopuertoLocal.getId().equals(tipopuerto.getId())) {
					tipopuertoEncontrado=tipopuertoLocal;
					
					tipopuertoLocal.setIsChanged(tipopuerto.getIsChanged());
					tipopuertoLocal.setIsNew(tipopuerto.getIsNew());
					tipopuertoLocal.setIsDeleted(tipopuerto.getIsDeleted());
					
					tipopuertoLocal.setGeneralEntityOriginal(tipopuerto.getGeneralEntityOriginal());
					
					tipopuertoLocal.setId(tipopuerto.getId());	
					tipopuertoLocal.setVersionRow(tipopuerto.getVersionRow());	
					tipopuertoLocal.setcodigo(tipopuerto.getcodigo());	
					tipopuertoLocal.setnombre(tipopuerto.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipopuerto.getIsDeleted()) {
				if(!existe) {
					tipopuertos.add(tipopuerto);
				}
			} else {
				if(tipopuertoEncontrado!=null && permiteQuitar)  {
					tipopuertos.remove(tipopuertoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoPuerto tipopuerto,List<TipoPuerto> tipopuertos) throws Exception {
		try	{			
			for(TipoPuerto tipopuertoLocal:tipopuertos) {
				if(tipopuertoLocal.getId().equals(tipopuerto.getId())) {
					tipopuertoLocal.setIsSelected(tipopuerto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoPuerto(List<TipoPuerto> tipopuertosAux) throws Exception {
		//this.tipopuertosAux=tipopuertosAux;
		
		for(TipoPuerto tipopuertoAux:tipopuertosAux) {
			if(tipopuertoAux.getIsChanged()) {
				tipopuertoAux.setIsChanged(false);
			}		
			
			if(tipopuertoAux.getIsNew()) {
				tipopuertoAux.setIsNew(false);
			}	
			
			if(tipopuertoAux.getIsDeleted()) {
				tipopuertoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoPuerto(TipoPuerto tipopuertoAux) throws Exception {
		//this.tipopuertoAux=tipopuertoAux;
		
			if(tipopuertoAux.getIsChanged()) {
				tipopuertoAux.setIsChanged(false);
			}		
			
			if(tipopuertoAux.getIsNew()) {
				tipopuertoAux.setIsNew(false);
			}	
			
			if(tipopuertoAux.getIsDeleted()) {
				tipopuertoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoPuerto tipopuertoAsignar,TipoPuerto tipopuerto) throws Exception {
		tipopuertoAsignar.setId(tipopuerto.getId());	
		tipopuertoAsignar.setVersionRow(tipopuerto.getVersionRow());	
		tipopuertoAsignar.setcodigo(tipopuerto.getcodigo());	
		tipopuertoAsignar.setnombre(tipopuerto.getnombre());	
	}
	
	public static void inicializarTipoPuerto(TipoPuerto tipopuerto) throws Exception {
		try {
				tipopuerto.setId(0L);	
					
				tipopuerto.setcodigo("");	
				tipopuerto.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoPuerto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPuertoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPuertoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoPuerto(String sTipo,Row row,Workbook workbook,TipoPuerto tipopuerto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipopuerto.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipopuerto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoPuerto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoPuerto() {
		return this.sFinalQueryTipoPuerto;
	}
	
	public void setsFinalQueryTipoPuerto(String sFinalQueryTipoPuerto) {
		this.sFinalQueryTipoPuerto= sFinalQueryTipoPuerto;
	}
	
	public Border resaltarSeleccionarTipoPuerto=null;
	
	public Border setResaltarSeleccionarTipoPuerto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPuertoBeanSwingJInternalFrame tipopuertoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipopuertoBeanSwingJInternalFrame.jTtoolBarTipoPuerto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoPuerto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoPuerto() {
		return this.resaltarSeleccionarTipoPuerto;
	}
	
	public void setResaltarSeleccionarTipoPuerto(Border borderResaltarSeleccionarTipoPuerto) {
		this.resaltarSeleccionarTipoPuerto= borderResaltarSeleccionarTipoPuerto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoPuerto=null;
	public Boolean mostraridTipoPuerto=true;
	public Boolean activaridTipoPuerto=true;

	public Border resaltarcodigoTipoPuerto=null;
	public Boolean mostrarcodigoTipoPuerto=true;
	public Boolean activarcodigoTipoPuerto=true;

	public Border resaltarnombreTipoPuerto=null;
	public Boolean mostrarnombreTipoPuerto=true;
	public Boolean activarnombreTipoPuerto=true;

	
	

	public Border setResaltaridTipoPuerto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPuertoBeanSwingJInternalFrame tipopuertoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipopuertoBeanSwingJInternalFrame.jTtoolBarTipoPuerto.setBorder(borderResaltar);
		
		this.resaltaridTipoPuerto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoPuerto() {
		return this.resaltaridTipoPuerto;
	}

	public void setResaltaridTipoPuerto(Border borderResaltar) {
		this.resaltaridTipoPuerto= borderResaltar;
	}

	public Boolean getMostraridTipoPuerto() {
		return this.mostraridTipoPuerto;
	}

	public void setMostraridTipoPuerto(Boolean mostraridTipoPuerto) {
		this.mostraridTipoPuerto= mostraridTipoPuerto;
	}

	public Boolean getActivaridTipoPuerto() {
		return this.activaridTipoPuerto;
	}

	public void setActivaridTipoPuerto(Boolean activaridTipoPuerto) {
		this.activaridTipoPuerto= activaridTipoPuerto;
	}

	public Border setResaltarcodigoTipoPuerto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPuertoBeanSwingJInternalFrame tipopuertoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipopuertoBeanSwingJInternalFrame.jTtoolBarTipoPuerto.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoPuerto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoPuerto() {
		return this.resaltarcodigoTipoPuerto;
	}

	public void setResaltarcodigoTipoPuerto(Border borderResaltar) {
		this.resaltarcodigoTipoPuerto= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoPuerto() {
		return this.mostrarcodigoTipoPuerto;
	}

	public void setMostrarcodigoTipoPuerto(Boolean mostrarcodigoTipoPuerto) {
		this.mostrarcodigoTipoPuerto= mostrarcodigoTipoPuerto;
	}

	public Boolean getActivarcodigoTipoPuerto() {
		return this.activarcodigoTipoPuerto;
	}

	public void setActivarcodigoTipoPuerto(Boolean activarcodigoTipoPuerto) {
		this.activarcodigoTipoPuerto= activarcodigoTipoPuerto;
	}

	public Border setResaltarnombreTipoPuerto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPuertoBeanSwingJInternalFrame tipopuertoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipopuertoBeanSwingJInternalFrame.jTtoolBarTipoPuerto.setBorder(borderResaltar);
		
		this.resaltarnombreTipoPuerto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoPuerto() {
		return this.resaltarnombreTipoPuerto;
	}

	public void setResaltarnombreTipoPuerto(Border borderResaltar) {
		this.resaltarnombreTipoPuerto= borderResaltar;
	}

	public Boolean getMostrarnombreTipoPuerto() {
		return this.mostrarnombreTipoPuerto;
	}

	public void setMostrarnombreTipoPuerto(Boolean mostrarnombreTipoPuerto) {
		this.mostrarnombreTipoPuerto= mostrarnombreTipoPuerto;
	}

	public Boolean getActivarnombreTipoPuerto() {
		return this.activarnombreTipoPuerto;
	}

	public void setActivarnombreTipoPuerto(Boolean activarnombreTipoPuerto) {
		this.activarnombreTipoPuerto= activarnombreTipoPuerto;
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
		
		
		this.setMostraridTipoPuerto(esInicial);
		this.setMostrarcodigoTipoPuerto(esInicial);
		this.setMostrarnombreTipoPuerto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPuertoConstantesFunciones.ID)) {
				this.setMostraridTipoPuerto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPuertoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoPuerto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPuertoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoPuerto(esAsigna);
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
		
		
		this.setActivaridTipoPuerto(esInicial);
		this.setActivarcodigoTipoPuerto(esInicial);
		this.setActivarnombreTipoPuerto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPuertoConstantesFunciones.ID)) {
				this.setActivaridTipoPuerto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPuertoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoPuerto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPuertoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoPuerto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPuertoBeanSwingJInternalFrame tipopuertoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoPuerto(esInicial);
		this.setResaltarcodigoTipoPuerto(esInicial);
		this.setResaltarnombreTipoPuerto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPuertoConstantesFunciones.ID)) {
				this.setResaltaridTipoPuerto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPuertoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoPuerto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPuertoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoPuerto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPuertoBeanSwingJInternalFrame tipopuertoBeanSwingJInternalFrame*/)throws Exception {	
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