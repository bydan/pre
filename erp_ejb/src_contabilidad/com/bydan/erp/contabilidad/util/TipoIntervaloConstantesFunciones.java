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


import com.bydan.erp.contabilidad.util.TipoIntervaloConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoIntervaloParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoIntervaloParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoIntervaloConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoIntervalo";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoIntervalo"+TipoIntervaloConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoIntervaloHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoIntervaloHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoIntervaloConstantesFunciones.SCHEMA+"_"+TipoIntervaloConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoIntervaloHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoIntervaloConstantesFunciones.SCHEMA+"_"+TipoIntervaloConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoIntervaloConstantesFunciones.SCHEMA+"_"+TipoIntervaloConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoIntervaloHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoIntervaloConstantesFunciones.SCHEMA+"_"+TipoIntervaloConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoIntervaloConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoIntervaloHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoIntervaloConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoIntervaloConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoIntervaloHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoIntervaloConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoIntervaloConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoIntervaloConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoIntervaloConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoIntervaloConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Intervalo s";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Intervalo ";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Intervalo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoIntervalo";
	public static final String OBJECTNAME="tipointervalo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_intervalo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipointervalo from "+TipoIntervaloConstantesFunciones.SPERSISTENCENAME+" tipointervalo";
	public static String QUERYSELECTNATIVE="select "+TipoIntervaloConstantesFunciones.SCHEMA+"."+TipoIntervaloConstantesFunciones.TABLENAME+".id,"+TipoIntervaloConstantesFunciones.SCHEMA+"."+TipoIntervaloConstantesFunciones.TABLENAME+".version_row,"+TipoIntervaloConstantesFunciones.SCHEMA+"."+TipoIntervaloConstantesFunciones.TABLENAME+".nombre from "+TipoIntervaloConstantesFunciones.SCHEMA+"."+TipoIntervaloConstantesFunciones.TABLENAME;//+" as "+TipoIntervaloConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoIntervaloLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoIntervaloConstantesFunciones.NOMBRE)) {sLabelColumna=TipoIntervaloConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getTipoIntervaloDescripcion(TipoIntervalo tipointervalo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipointervalo !=null/* && tipointervalo.getId()!=0*/) {
			sDescripcion=tipointervalo.getnombre();//tipointervalotipointervalo.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoIntervaloDescripcionDetallado(TipoIntervalo tipointervalo) {
		String sDescripcion="";
			
		sDescripcion+=TipoIntervaloConstantesFunciones.ID+"=";
		sDescripcion+=tipointervalo.getId().toString()+",";
		sDescripcion+=TipoIntervaloConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipointervalo.getVersionRow().toString()+",";
		sDescripcion+=TipoIntervaloConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipointervalo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoIntervaloDescripcion(TipoIntervalo tipointervalo,String sValor) throws Exception {			
		if(tipointervalo !=null) {
			tipointervalo.setnombre(sValor);;//tipointervalotipointervalo.getnombre().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("PorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoIntervalo(TipoIntervalo tipointervalo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipointervalo.setnombre(tipointervalo.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoIntervalos(List<TipoIntervalo> tipointervalos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoIntervalo tipointervalo: tipointervalos) {
			tipointervalo.setnombre(tipointervalo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoIntervalo(TipoIntervalo tipointervalo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipointervalo.getConCambioAuxiliar()) {
			tipointervalo.setIsDeleted(tipointervalo.getIsDeletedAuxiliar());	
			tipointervalo.setIsNew(tipointervalo.getIsNewAuxiliar());	
			tipointervalo.setIsChanged(tipointervalo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipointervalo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipointervalo.setIsDeletedAuxiliar(false);	
			tipointervalo.setIsNewAuxiliar(false);	
			tipointervalo.setIsChangedAuxiliar(false);
			
			tipointervalo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoIntervalos(List<TipoIntervalo> tipointervalos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoIntervalo tipointervalo : tipointervalos) {
			if(conAsignarBase && tipointervalo.getConCambioAuxiliar()) {
				tipointervalo.setIsDeleted(tipointervalo.getIsDeletedAuxiliar());	
				tipointervalo.setIsNew(tipointervalo.getIsNewAuxiliar());	
				tipointervalo.setIsChanged(tipointervalo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipointervalo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipointervalo.setIsDeletedAuxiliar(false);	
				tipointervalo.setIsNewAuxiliar(false);	
				tipointervalo.setIsChangedAuxiliar(false);
				
				tipointervalo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoIntervalo(TipoIntervalo tipointervalo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoIntervalos(List<TipoIntervalo> tipointervalos,Boolean conEnteros) throws Exception  {
		
		for(TipoIntervalo tipointervalo: tipointervalos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoIntervalo(List<TipoIntervalo> tipointervalos,TipoIntervalo tipointervaloAux) throws Exception  {
		TipoIntervaloConstantesFunciones.InicializarValoresTipoIntervalo(tipointervaloAux,true);
		
		for(TipoIntervalo tipointervalo: tipointervalos) {
			if(tipointervalo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoIntervalo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoIntervaloConstantesFunciones.getArrayColumnasGlobalesTipoIntervalo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoIntervalo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoIntervalo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoIntervalo> tipointervalos,TipoIntervalo tipointervalo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoIntervalo tipointervaloAux: tipointervalos) {
			if(tipointervaloAux!=null && tipointervalo!=null) {
				if((tipointervaloAux.getId()==null && tipointervalo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipointervaloAux.getId()!=null && tipointervalo.getId()!=null){
					if(tipointervaloAux.getId().equals(tipointervalo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoIntervalo(List<TipoIntervalo> tipointervalos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoIntervalo tipointervalo: tipointervalos) {			
			if(tipointervalo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoIntervalo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoIntervaloConstantesFunciones.LABEL_ID, TipoIntervaloConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoIntervaloConstantesFunciones.LABEL_VERSIONROW, TipoIntervaloConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoIntervaloConstantesFunciones.LABEL_NOMBRE, TipoIntervaloConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoIntervalo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoIntervaloConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoIntervaloConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoIntervaloConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoIntervalo() throws Exception  {
		return TipoIntervaloConstantesFunciones.getTiposSeleccionarTipoIntervalo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoIntervalo(Boolean conFk) throws Exception  {
		return TipoIntervaloConstantesFunciones.getTiposSeleccionarTipoIntervalo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoIntervalo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoIntervaloConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoIntervaloConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoIntervalo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoIntervalo(TipoIntervalo tipointervaloAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoIntervalo(List<TipoIntervalo> tipointervalosTemp) throws Exception {
		for(TipoIntervalo tipointervaloAux:tipointervalosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoIntervalo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoIntervalo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoIntervalo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoIntervaloConstantesFunciones.getClassesRelationshipsOfTipoIntervalo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoIntervalo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(ParametroContabilidadDefecto.class));
				classes.add(new Classe(TablaAmortiDetalle.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroContabilidadDefecto.class)) {
						classes.add(new Classe(ParametroContabilidadDefecto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TablaAmortiDetalle.class)) {
						classes.add(new Classe(TablaAmortiDetalle.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoIntervalo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoIntervaloConstantesFunciones.getClassesRelationshipsFromStringsOfTipoIntervalo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoIntervalo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(ParametroContabilidadDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroContabilidadDefecto.class)); continue;
					}

					if(TablaAmortiDetalle.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TablaAmortiDetalle.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(ParametroContabilidadDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroContabilidadDefecto.class)); continue;
					}

					if(TablaAmortiDetalle.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TablaAmortiDetalle.class)); continue;
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
	public static void actualizarLista(TipoIntervalo tipointervalo,List<TipoIntervalo> tipointervalos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoIntervalo tipointervaloEncontrado=null;
			
			for(TipoIntervalo tipointervaloLocal:tipointervalos) {
				if(tipointervaloLocal.getId().equals(tipointervalo.getId())) {
					tipointervaloEncontrado=tipointervaloLocal;
					
					tipointervaloLocal.setIsChanged(tipointervalo.getIsChanged());
					tipointervaloLocal.setIsNew(tipointervalo.getIsNew());
					tipointervaloLocal.setIsDeleted(tipointervalo.getIsDeleted());
					
					tipointervaloLocal.setGeneralEntityOriginal(tipointervalo.getGeneralEntityOriginal());
					
					tipointervaloLocal.setId(tipointervalo.getId());	
					tipointervaloLocal.setVersionRow(tipointervalo.getVersionRow());	
					tipointervaloLocal.setnombre(tipointervalo.getnombre());	
					
					
					tipointervaloLocal.setParametroContabilidadDefectos(tipointervalo.getParametroContabilidadDefectos());
					tipointervaloLocal.setTablaAmortiDetalles(tipointervalo.getTablaAmortiDetalles());
					
					existe=true;
					break;
				}
			}
			
			if(!tipointervalo.getIsDeleted()) {
				if(!existe) {
					tipointervalos.add(tipointervalo);
				}
			} else {
				if(tipointervaloEncontrado!=null && permiteQuitar)  {
					tipointervalos.remove(tipointervaloEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoIntervalo tipointervalo,List<TipoIntervalo> tipointervalos) throws Exception {
		try	{			
			for(TipoIntervalo tipointervaloLocal:tipointervalos) {
				if(tipointervaloLocal.getId().equals(tipointervalo.getId())) {
					tipointervaloLocal.setIsSelected(tipointervalo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoIntervalo(List<TipoIntervalo> tipointervalosAux) throws Exception {
		//this.tipointervalosAux=tipointervalosAux;
		
		for(TipoIntervalo tipointervaloAux:tipointervalosAux) {
			if(tipointervaloAux.getIsChanged()) {
				tipointervaloAux.setIsChanged(false);
			}		
			
			if(tipointervaloAux.getIsNew()) {
				tipointervaloAux.setIsNew(false);
			}	
			
			if(tipointervaloAux.getIsDeleted()) {
				tipointervaloAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoIntervalo(TipoIntervalo tipointervaloAux) throws Exception {
		//this.tipointervaloAux=tipointervaloAux;
		
			if(tipointervaloAux.getIsChanged()) {
				tipointervaloAux.setIsChanged(false);
			}		
			
			if(tipointervaloAux.getIsNew()) {
				tipointervaloAux.setIsNew(false);
			}	
			
			if(tipointervaloAux.getIsDeleted()) {
				tipointervaloAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoIntervalo tipointervaloAsignar,TipoIntervalo tipointervalo) throws Exception {
		tipointervaloAsignar.setId(tipointervalo.getId());	
		tipointervaloAsignar.setVersionRow(tipointervalo.getVersionRow());	
		tipointervaloAsignar.setnombre(tipointervalo.getnombre());	
	}
	
	public static void inicializarTipoIntervalo(TipoIntervalo tipointervalo) throws Exception {
		try {
				tipointervalo.setId(0L);	
					
				tipointervalo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoIntervalo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoIntervaloConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoIntervalo(String sTipo,Row row,Workbook workbook,TipoIntervalo tipointervalo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipointervalo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoIntervalo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoIntervalo() {
		return this.sFinalQueryTipoIntervalo;
	}
	
	public void setsFinalQueryTipoIntervalo(String sFinalQueryTipoIntervalo) {
		this.sFinalQueryTipoIntervalo= sFinalQueryTipoIntervalo;
	}
	
	public Border resaltarSeleccionarTipoIntervalo=null;
	
	public Border setResaltarSeleccionarTipoIntervalo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIntervaloBeanSwingJInternalFrame tipointervaloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipointervaloBeanSwingJInternalFrame.jTtoolBarTipoIntervalo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoIntervalo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoIntervalo() {
		return this.resaltarSeleccionarTipoIntervalo;
	}
	
	public void setResaltarSeleccionarTipoIntervalo(Border borderResaltarSeleccionarTipoIntervalo) {
		this.resaltarSeleccionarTipoIntervalo= borderResaltarSeleccionarTipoIntervalo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoIntervalo=null;
	public Boolean mostraridTipoIntervalo=true;
	public Boolean activaridTipoIntervalo=true;

	public Border resaltarnombreTipoIntervalo=null;
	public Boolean mostrarnombreTipoIntervalo=true;
	public Boolean activarnombreTipoIntervalo=true;

	
	

	public Border setResaltaridTipoIntervalo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIntervaloBeanSwingJInternalFrame tipointervaloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipointervaloBeanSwingJInternalFrame.jTtoolBarTipoIntervalo.setBorder(borderResaltar);
		
		this.resaltaridTipoIntervalo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoIntervalo() {
		return this.resaltaridTipoIntervalo;
	}

	public void setResaltaridTipoIntervalo(Border borderResaltar) {
		this.resaltaridTipoIntervalo= borderResaltar;
	}

	public Boolean getMostraridTipoIntervalo() {
		return this.mostraridTipoIntervalo;
	}

	public void setMostraridTipoIntervalo(Boolean mostraridTipoIntervalo) {
		this.mostraridTipoIntervalo= mostraridTipoIntervalo;
	}

	public Boolean getActivaridTipoIntervalo() {
		return this.activaridTipoIntervalo;
	}

	public void setActivaridTipoIntervalo(Boolean activaridTipoIntervalo) {
		this.activaridTipoIntervalo= activaridTipoIntervalo;
	}

	public Border setResaltarnombreTipoIntervalo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIntervaloBeanSwingJInternalFrame tipointervaloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipointervaloBeanSwingJInternalFrame.jTtoolBarTipoIntervalo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoIntervalo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoIntervalo() {
		return this.resaltarnombreTipoIntervalo;
	}

	public void setResaltarnombreTipoIntervalo(Border borderResaltar) {
		this.resaltarnombreTipoIntervalo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoIntervalo() {
		return this.mostrarnombreTipoIntervalo;
	}

	public void setMostrarnombreTipoIntervalo(Boolean mostrarnombreTipoIntervalo) {
		this.mostrarnombreTipoIntervalo= mostrarnombreTipoIntervalo;
	}

	public Boolean getActivarnombreTipoIntervalo() {
		return this.activarnombreTipoIntervalo;
	}

	public void setActivarnombreTipoIntervalo(Boolean activarnombreTipoIntervalo) {
		this.activarnombreTipoIntervalo= activarnombreTipoIntervalo;
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
		
		
		this.setMostraridTipoIntervalo(esInicial);
		this.setMostrarnombreTipoIntervalo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoIntervaloConstantesFunciones.ID)) {
				this.setMostraridTipoIntervalo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIntervaloConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoIntervalo(esAsigna);
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
		
		
		this.setActivaridTipoIntervalo(esInicial);
		this.setActivarnombreTipoIntervalo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoIntervaloConstantesFunciones.ID)) {
				this.setActivaridTipoIntervalo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIntervaloConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoIntervalo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoIntervaloBeanSwingJInternalFrame tipointervaloBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoIntervalo(esInicial);
		this.setResaltarnombreTipoIntervalo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoIntervaloConstantesFunciones.ID)) {
				this.setResaltaridTipoIntervalo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoIntervaloConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoIntervalo(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarParametroContabilidadDefectoTipoIntervalo=null;

	public Border getResaltarParametroContabilidadDefectoTipoIntervalo() {
		return this.resaltarParametroContabilidadDefectoTipoIntervalo;
	}

	public void setResaltarParametroContabilidadDefectoTipoIntervalo(Border borderResaltarParametroContabilidadDefecto) {
		if(borderResaltarParametroContabilidadDefecto!=null) {
			this.resaltarParametroContabilidadDefectoTipoIntervalo= borderResaltarParametroContabilidadDefecto;
		}
	}

	public Border setResaltarParametroContabilidadDefectoTipoIntervalo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIntervaloBeanSwingJInternalFrame tipointervaloBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroContabilidadDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipointervaloBeanSwingJInternalFrame.jTtoolBarTipoIntervalo.setBorder(borderResaltarParametroContabilidadDefecto);
			
		this.resaltarParametroContabilidadDefectoTipoIntervalo= borderResaltarParametroContabilidadDefecto;

		 return borderResaltarParametroContabilidadDefecto;
	}



	public Boolean mostrarParametroContabilidadDefectoTipoIntervalo=true;

	public Boolean getMostrarParametroContabilidadDefectoTipoIntervalo() {
		return this.mostrarParametroContabilidadDefectoTipoIntervalo;
	}

	public void setMostrarParametroContabilidadDefectoTipoIntervalo(Boolean visibilidadResaltarParametroContabilidadDefecto) {
		this.mostrarParametroContabilidadDefectoTipoIntervalo= visibilidadResaltarParametroContabilidadDefecto;
	}



	public Boolean activarParametroContabilidadDefectoTipoIntervalo=true;

	public Boolean gethabilitarResaltarParametroContabilidadDefectoTipoIntervalo() {
		return this.activarParametroContabilidadDefectoTipoIntervalo;
	}

	public void setActivarParametroContabilidadDefectoTipoIntervalo(Boolean habilitarResaltarParametroContabilidadDefecto) {
		this.activarParametroContabilidadDefectoTipoIntervalo= habilitarResaltarParametroContabilidadDefecto;
	}


	public Border resaltarTablaAmortiDetalleTipoIntervalo=null;

	public Border getResaltarTablaAmortiDetalleTipoIntervalo() {
		return this.resaltarTablaAmortiDetalleTipoIntervalo;
	}

	public void setResaltarTablaAmortiDetalleTipoIntervalo(Border borderResaltarTablaAmortiDetalle) {
		if(borderResaltarTablaAmortiDetalle!=null) {
			this.resaltarTablaAmortiDetalleTipoIntervalo= borderResaltarTablaAmortiDetalle;
		}
	}

	public Border setResaltarTablaAmortiDetalleTipoIntervalo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoIntervaloBeanSwingJInternalFrame tipointervaloBeanSwingJInternalFrame*/) {
		Border borderResaltarTablaAmortiDetalle=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipointervaloBeanSwingJInternalFrame.jTtoolBarTipoIntervalo.setBorder(borderResaltarTablaAmortiDetalle);
			
		this.resaltarTablaAmortiDetalleTipoIntervalo= borderResaltarTablaAmortiDetalle;

		 return borderResaltarTablaAmortiDetalle;
	}



	public Boolean mostrarTablaAmortiDetalleTipoIntervalo=true;

	public Boolean getMostrarTablaAmortiDetalleTipoIntervalo() {
		return this.mostrarTablaAmortiDetalleTipoIntervalo;
	}

	public void setMostrarTablaAmortiDetalleTipoIntervalo(Boolean visibilidadResaltarTablaAmortiDetalle) {
		this.mostrarTablaAmortiDetalleTipoIntervalo= visibilidadResaltarTablaAmortiDetalle;
	}



	public Boolean activarTablaAmortiDetalleTipoIntervalo=true;

	public Boolean gethabilitarResaltarTablaAmortiDetalleTipoIntervalo() {
		return this.activarTablaAmortiDetalleTipoIntervalo;
	}

	public void setActivarTablaAmortiDetalleTipoIntervalo(Boolean habilitarResaltarTablaAmortiDetalle) {
		this.activarTablaAmortiDetalleTipoIntervalo= habilitarResaltarTablaAmortiDetalle;
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

		this.setMostrarParametroContabilidadDefectoTipoIntervalo(esInicial);
		this.setMostrarTablaAmortiDetalleTipoIntervalo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroContabilidadDefecto.class)) {
				this.setMostrarParametroContabilidadDefectoTipoIntervalo(esAsigna);
				continue;
			}

			if(clase.clas.equals(TablaAmortiDetalle.class)) {
				this.setMostrarTablaAmortiDetalleTipoIntervalo(esAsigna);
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

		this.setActivarParametroContabilidadDefectoTipoIntervalo(esInicial);
		this.setActivarTablaAmortiDetalleTipoIntervalo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroContabilidadDefecto.class)) {
				this.setActivarParametroContabilidadDefectoTipoIntervalo(esAsigna);
				continue;
			}

			if(clase.clas.equals(TablaAmortiDetalle.class)) {
				this.setActivarTablaAmortiDetalleTipoIntervalo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoIntervaloBeanSwingJInternalFrame tipointervaloBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarParametroContabilidadDefectoTipoIntervalo(esInicial);
		this.setResaltarTablaAmortiDetalleTipoIntervalo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroContabilidadDefecto.class)) {
				this.setResaltarParametroContabilidadDefectoTipoIntervalo(esAsigna);
				continue;
			}

			if(clase.clas.equals(TablaAmortiDetalle.class)) {
				this.setResaltarTablaAmortiDetalleTipoIntervalo(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}