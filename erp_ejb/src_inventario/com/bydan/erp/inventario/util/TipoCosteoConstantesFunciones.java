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


import com.bydan.erp.inventario.util.TipoCosteoConstantesFunciones;
import com.bydan.erp.inventario.util.TipoCosteoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoCosteoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoCosteoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoCosteo";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoCosteo"+TipoCosteoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoCosteoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoCosteoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoCosteoConstantesFunciones.SCHEMA+"_"+TipoCosteoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoCosteoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoCosteoConstantesFunciones.SCHEMA+"_"+TipoCosteoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoCosteoConstantesFunciones.SCHEMA+"_"+TipoCosteoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoCosteoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoCosteoConstantesFunciones.SCHEMA+"_"+TipoCosteoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCosteoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCosteoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCosteoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCosteoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCosteoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCosteoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoCosteoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoCosteoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoCosteoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoCosteoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Costeos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Costeo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Costeo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoCosteo";
	public static final String OBJECTNAME="tipocosteo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="tipo_costeo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocosteo from "+TipoCosteoConstantesFunciones.SPERSISTENCENAME+" tipocosteo";
	public static String QUERYSELECTNATIVE="select "+TipoCosteoConstantesFunciones.SCHEMA+"."+TipoCosteoConstantesFunciones.TABLENAME+".id,"+TipoCosteoConstantesFunciones.SCHEMA+"."+TipoCosteoConstantesFunciones.TABLENAME+".version_row,"+TipoCosteoConstantesFunciones.SCHEMA+"."+TipoCosteoConstantesFunciones.TABLENAME+".nombre from "+TipoCosteoConstantesFunciones.SCHEMA+"."+TipoCosteoConstantesFunciones.TABLENAME;//+" as "+TipoCosteoConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoCosteoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoCosteoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoCosteoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getTipoCosteoDescripcion(TipoCosteo tipocosteo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocosteo !=null/* && tipocosteo.getId()!=0*/) {
			sDescripcion=tipocosteo.getnombre();//tipocosteotipocosteo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoCosteoDescripcionDetallado(TipoCosteo tipocosteo) {
		String sDescripcion="";
			
		sDescripcion+=TipoCosteoConstantesFunciones.ID+"=";
		sDescripcion+=tipocosteo.getId().toString()+",";
		sDescripcion+=TipoCosteoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocosteo.getVersionRow().toString()+",";
		sDescripcion+=TipoCosteoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocosteo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoCosteoDescripcion(TipoCosteo tipocosteo,String sValor) throws Exception {			
		if(tipocosteo !=null) {
			tipocosteo.setnombre(sValor);//tipocosteotipocosteo.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoCosteo(TipoCosteo tipocosteo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocosteo.setnombre(tipocosteo.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoCosteos(List<TipoCosteo> tipocosteos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoCosteo tipocosteo: tipocosteos) {
			tipocosteo.setnombre(tipocosteo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCosteo(TipoCosteo tipocosteo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocosteo.getConCambioAuxiliar()) {
			tipocosteo.setIsDeleted(tipocosteo.getIsDeletedAuxiliar());	
			tipocosteo.setIsNew(tipocosteo.getIsNewAuxiliar());	
			tipocosteo.setIsChanged(tipocosteo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocosteo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocosteo.setIsDeletedAuxiliar(false);	
			tipocosteo.setIsNewAuxiliar(false);	
			tipocosteo.setIsChangedAuxiliar(false);
			
			tipocosteo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCosteos(List<TipoCosteo> tipocosteos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoCosteo tipocosteo : tipocosteos) {
			if(conAsignarBase && tipocosteo.getConCambioAuxiliar()) {
				tipocosteo.setIsDeleted(tipocosteo.getIsDeletedAuxiliar());	
				tipocosteo.setIsNew(tipocosteo.getIsNewAuxiliar());	
				tipocosteo.setIsChanged(tipocosteo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocosteo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocosteo.setIsDeletedAuxiliar(false);	
				tipocosteo.setIsNewAuxiliar(false);	
				tipocosteo.setIsChangedAuxiliar(false);
				
				tipocosteo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoCosteo(TipoCosteo tipocosteo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoCosteos(List<TipoCosteo> tipocosteos,Boolean conEnteros) throws Exception  {
		
		for(TipoCosteo tipocosteo: tipocosteos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoCosteo(List<TipoCosteo> tipocosteos,TipoCosteo tipocosteoAux) throws Exception  {
		TipoCosteoConstantesFunciones.InicializarValoresTipoCosteo(tipocosteoAux,true);
		
		for(TipoCosteo tipocosteo: tipocosteos) {
			if(tipocosteo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCosteo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoCosteoConstantesFunciones.getArrayColumnasGlobalesTipoCosteo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCosteo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoCosteo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoCosteo> tipocosteos,TipoCosteo tipocosteo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoCosteo tipocosteoAux: tipocosteos) {
			if(tipocosteoAux!=null && tipocosteo!=null) {
				if((tipocosteoAux.getId()==null && tipocosteo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocosteoAux.getId()!=null && tipocosteo.getId()!=null){
					if(tipocosteoAux.getId().equals(tipocosteo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoCosteo(List<TipoCosteo> tipocosteos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoCosteo tipocosteo: tipocosteos) {			
			if(tipocosteo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoCosteo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoCosteoConstantesFunciones.LABEL_ID, TipoCosteoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCosteoConstantesFunciones.LABEL_VERSIONROW, TipoCosteoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCosteoConstantesFunciones.LABEL_NOMBRE, TipoCosteoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoCosteo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoCosteoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCosteoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCosteoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCosteo() throws Exception  {
		return TipoCosteoConstantesFunciones.getTiposSeleccionarTipoCosteo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCosteo(Boolean conFk) throws Exception  {
		return TipoCosteoConstantesFunciones.getTiposSeleccionarTipoCosteo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCosteo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCosteoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoCosteoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoCosteo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCosteo(TipoCosteo tipocosteoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCosteo(List<TipoCosteo> tipocosteosTemp) throws Exception {
		for(TipoCosteo tipocosteoAux:tipocosteosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCosteo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoCosteo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCosteo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCosteoConstantesFunciones.getClassesRelationshipsOfTipoCosteo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCosteo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(ParametroInventarioDefecto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCosteo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCosteoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoCosteo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCosteo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
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
	public static void actualizarLista(TipoCosteo tipocosteo,List<TipoCosteo> tipocosteos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoCosteo tipocosteoEncontrado=null;
			
			for(TipoCosteo tipocosteoLocal:tipocosteos) {
				if(tipocosteoLocal.getId().equals(tipocosteo.getId())) {
					tipocosteoEncontrado=tipocosteoLocal;
					
					tipocosteoLocal.setIsChanged(tipocosteo.getIsChanged());
					tipocosteoLocal.setIsNew(tipocosteo.getIsNew());
					tipocosteoLocal.setIsDeleted(tipocosteo.getIsDeleted());
					
					tipocosteoLocal.setGeneralEntityOriginal(tipocosteo.getGeneralEntityOriginal());
					
					tipocosteoLocal.setId(tipocosteo.getId());	
					tipocosteoLocal.setVersionRow(tipocosteo.getVersionRow());	
					tipocosteoLocal.setnombre(tipocosteo.getnombre());	
					
					
					tipocosteoLocal.setParametroInventarioDefectos(tipocosteo.getParametroInventarioDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!tipocosteo.getIsDeleted()) {
				if(!existe) {
					tipocosteos.add(tipocosteo);
				}
			} else {
				if(tipocosteoEncontrado!=null && permiteQuitar)  {
					tipocosteos.remove(tipocosteoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoCosteo tipocosteo,List<TipoCosteo> tipocosteos) throws Exception {
		try	{			
			for(TipoCosteo tipocosteoLocal:tipocosteos) {
				if(tipocosteoLocal.getId().equals(tipocosteo.getId())) {
					tipocosteoLocal.setIsSelected(tipocosteo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoCosteo(List<TipoCosteo> tipocosteosAux) throws Exception {
		//this.tipocosteosAux=tipocosteosAux;
		
		for(TipoCosteo tipocosteoAux:tipocosteosAux) {
			if(tipocosteoAux.getIsChanged()) {
				tipocosteoAux.setIsChanged(false);
			}		
			
			if(tipocosteoAux.getIsNew()) {
				tipocosteoAux.setIsNew(false);
			}	
			
			if(tipocosteoAux.getIsDeleted()) {
				tipocosteoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoCosteo(TipoCosteo tipocosteoAux) throws Exception {
		//this.tipocosteoAux=tipocosteoAux;
		
			if(tipocosteoAux.getIsChanged()) {
				tipocosteoAux.setIsChanged(false);
			}		
			
			if(tipocosteoAux.getIsNew()) {
				tipocosteoAux.setIsNew(false);
			}	
			
			if(tipocosteoAux.getIsDeleted()) {
				tipocosteoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoCosteo tipocosteoAsignar,TipoCosteo tipocosteo) throws Exception {
		tipocosteoAsignar.setId(tipocosteo.getId());	
		tipocosteoAsignar.setVersionRow(tipocosteo.getVersionRow());	
		tipocosteoAsignar.setnombre(tipocosteo.getnombre());	
	}
	
	public static void inicializarTipoCosteo(TipoCosteo tipocosteo) throws Exception {
		try {
				tipocosteo.setId(0L);	
					
				tipocosteo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoCosteo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCosteoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoCosteo(String sTipo,Row row,Workbook workbook,TipoCosteo tipocosteo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocosteo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoCosteo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoCosteo() {
		return this.sFinalQueryTipoCosteo;
	}
	
	public void setsFinalQueryTipoCosteo(String sFinalQueryTipoCosteo) {
		this.sFinalQueryTipoCosteo= sFinalQueryTipoCosteo;
	}
	
	public Border resaltarSeleccionarTipoCosteo=null;
	
	public Border setResaltarSeleccionarTipoCosteo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCosteoBeanSwingJInternalFrame tipocosteoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocosteoBeanSwingJInternalFrame.jTtoolBarTipoCosteo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoCosteo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoCosteo() {
		return this.resaltarSeleccionarTipoCosteo;
	}
	
	public void setResaltarSeleccionarTipoCosteo(Border borderResaltarSeleccionarTipoCosteo) {
		this.resaltarSeleccionarTipoCosteo= borderResaltarSeleccionarTipoCosteo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoCosteo=null;
	public Boolean mostraridTipoCosteo=true;
	public Boolean activaridTipoCosteo=true;

	public Border resaltarnombreTipoCosteo=null;
	public Boolean mostrarnombreTipoCosteo=true;
	public Boolean activarnombreTipoCosteo=true;

	
	

	public Border setResaltaridTipoCosteo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCosteoBeanSwingJInternalFrame tipocosteoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocosteoBeanSwingJInternalFrame.jTtoolBarTipoCosteo.setBorder(borderResaltar);
		
		this.resaltaridTipoCosteo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoCosteo() {
		return this.resaltaridTipoCosteo;
	}

	public void setResaltaridTipoCosteo(Border borderResaltar) {
		this.resaltaridTipoCosteo= borderResaltar;
	}

	public Boolean getMostraridTipoCosteo() {
		return this.mostraridTipoCosteo;
	}

	public void setMostraridTipoCosteo(Boolean mostraridTipoCosteo) {
		this.mostraridTipoCosteo= mostraridTipoCosteo;
	}

	public Boolean getActivaridTipoCosteo() {
		return this.activaridTipoCosteo;
	}

	public void setActivaridTipoCosteo(Boolean activaridTipoCosteo) {
		this.activaridTipoCosteo= activaridTipoCosteo;
	}

	public Border setResaltarnombreTipoCosteo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCosteoBeanSwingJInternalFrame tipocosteoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocosteoBeanSwingJInternalFrame.jTtoolBarTipoCosteo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoCosteo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoCosteo() {
		return this.resaltarnombreTipoCosteo;
	}

	public void setResaltarnombreTipoCosteo(Border borderResaltar) {
		this.resaltarnombreTipoCosteo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoCosteo() {
		return this.mostrarnombreTipoCosteo;
	}

	public void setMostrarnombreTipoCosteo(Boolean mostrarnombreTipoCosteo) {
		this.mostrarnombreTipoCosteo= mostrarnombreTipoCosteo;
	}

	public Boolean getActivarnombreTipoCosteo() {
		return this.activarnombreTipoCosteo;
	}

	public void setActivarnombreTipoCosteo(Boolean activarnombreTipoCosteo) {
		this.activarnombreTipoCosteo= activarnombreTipoCosteo;
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
		
		
		this.setMostraridTipoCosteo(esInicial);
		this.setMostrarnombreTipoCosteo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCosteoConstantesFunciones.ID)) {
				this.setMostraridTipoCosteo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCosteoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoCosteo(esAsigna);
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
		
		
		this.setActivaridTipoCosteo(esInicial);
		this.setActivarnombreTipoCosteo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCosteoConstantesFunciones.ID)) {
				this.setActivaridTipoCosteo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCosteoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoCosteo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCosteoBeanSwingJInternalFrame tipocosteoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoCosteo(esInicial);
		this.setResaltarnombreTipoCosteo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCosteoConstantesFunciones.ID)) {
				this.setResaltaridTipoCosteo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCosteoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoCosteo(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarParametroInventarioDefectoTipoCosteo=null;

	public Border getResaltarParametroInventarioDefectoTipoCosteo() {
		return this.resaltarParametroInventarioDefectoTipoCosteo;
	}

	public void setResaltarParametroInventarioDefectoTipoCosteo(Border borderResaltarParametroInventarioDefecto) {
		if(borderResaltarParametroInventarioDefecto!=null) {
			this.resaltarParametroInventarioDefectoTipoCosteo= borderResaltarParametroInventarioDefecto;
		}
	}

	public Border setResaltarParametroInventarioDefectoTipoCosteo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCosteoBeanSwingJInternalFrame tipocosteoBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroInventarioDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocosteoBeanSwingJInternalFrame.jTtoolBarTipoCosteo.setBorder(borderResaltarParametroInventarioDefecto);
			
		this.resaltarParametroInventarioDefectoTipoCosteo= borderResaltarParametroInventarioDefecto;

		 return borderResaltarParametroInventarioDefecto;
	}



	public Boolean mostrarParametroInventarioDefectoTipoCosteo=true;

	public Boolean getMostrarParametroInventarioDefectoTipoCosteo() {
		return this.mostrarParametroInventarioDefectoTipoCosteo;
	}

	public void setMostrarParametroInventarioDefectoTipoCosteo(Boolean visibilidadResaltarParametroInventarioDefecto) {
		this.mostrarParametroInventarioDefectoTipoCosteo= visibilidadResaltarParametroInventarioDefecto;
	}



	public Boolean activarParametroInventarioDefectoTipoCosteo=true;

	public Boolean gethabilitarResaltarParametroInventarioDefectoTipoCosteo() {
		return this.activarParametroInventarioDefectoTipoCosteo;
	}

	public void setActivarParametroInventarioDefectoTipoCosteo(Boolean habilitarResaltarParametroInventarioDefecto) {
		this.activarParametroInventarioDefectoTipoCosteo= habilitarResaltarParametroInventarioDefecto;
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

		this.setMostrarParametroInventarioDefectoTipoCosteo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setMostrarParametroInventarioDefectoTipoCosteo(esAsigna);
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

		this.setActivarParametroInventarioDefectoTipoCosteo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setActivarParametroInventarioDefectoTipoCosteo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCosteoBeanSwingJInternalFrame tipocosteoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarParametroInventarioDefectoTipoCosteo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setResaltarParametroInventarioDefectoTipoCosteo(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorNombreTipoCosteo=true;

	public Boolean getMostrarBusquedaPorNombreTipoCosteo() {
		return this.mostrarBusquedaPorNombreTipoCosteo;
	}

	public void setMostrarBusquedaPorNombreTipoCosteo(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoCosteo= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreTipoCosteo=true;

	public Boolean getActivarBusquedaPorNombreTipoCosteo() {
		return this.activarBusquedaPorNombreTipoCosteo;
	}

	public void setActivarBusquedaPorNombreTipoCosteo(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoCosteo= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreTipoCosteo=null;

	public Border getResaltarBusquedaPorNombreTipoCosteo() {
		return this.resaltarBusquedaPorNombreTipoCosteo;
	}

	public void setResaltarBusquedaPorNombreTipoCosteo(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoCosteo= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoCosteo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCosteoBeanSwingJInternalFrame tipocosteoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoCosteo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}