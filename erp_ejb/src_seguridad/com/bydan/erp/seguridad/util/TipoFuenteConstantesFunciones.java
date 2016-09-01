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
package com.bydan.erp.seguridad.util;

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


import com.bydan.erp.seguridad.util.TipoFuenteConstantesFunciones;
import com.bydan.erp.seguridad.util.TipoFuenteParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.TipoFuenteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoFuenteConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoFuente";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoFuente"+TipoFuenteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoFuenteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoFuenteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoFuenteConstantesFunciones.SCHEMA+"_"+TipoFuenteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoFuenteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoFuenteConstantesFunciones.SCHEMA+"_"+TipoFuenteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoFuenteConstantesFunciones.SCHEMA+"_"+TipoFuenteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoFuenteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoFuenteConstantesFunciones.SCHEMA+"_"+TipoFuenteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFuenteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoFuenteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFuenteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFuenteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoFuenteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFuenteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoFuenteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoFuenteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoFuenteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoFuenteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Fuentes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Fuente";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Fuente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoFuente";
	public static final String OBJECTNAME="tipofuente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="tipo_fuente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipofuente from "+TipoFuenteConstantesFunciones.SPERSISTENCENAME+" tipofuente";
	public static String QUERYSELECTNATIVE="select "+TipoFuenteConstantesFunciones.SCHEMA+"."+TipoFuenteConstantesFunciones.TABLENAME+".id,"+TipoFuenteConstantesFunciones.SCHEMA+"."+TipoFuenteConstantesFunciones.TABLENAME+".version_row,"+TipoFuenteConstantesFunciones.SCHEMA+"."+TipoFuenteConstantesFunciones.TABLENAME+".codigo,"+TipoFuenteConstantesFunciones.SCHEMA+"."+TipoFuenteConstantesFunciones.TABLENAME+".nombre from "+TipoFuenteConstantesFunciones.SCHEMA+"."+TipoFuenteConstantesFunciones.TABLENAME;//+" as "+TipoFuenteConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoFuenteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoFuenteConstantesFunciones.CODIGO)) {sLabelColumna=TipoFuenteConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoFuenteConstantesFunciones.NOMBRE)) {sLabelColumna=TipoFuenteConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoFuenteDescripcion(TipoFuente tipofuente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipofuente !=null/* && tipofuente.getId()!=0*/) {
			sDescripcion=tipofuente.getcodigo();//tipofuentetipofuente.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoFuenteDescripcionDetallado(TipoFuente tipofuente) {
		String sDescripcion="";
			
		sDescripcion+=TipoFuenteConstantesFunciones.ID+"=";
		sDescripcion+=tipofuente.getId().toString()+",";
		sDescripcion+=TipoFuenteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipofuente.getVersionRow().toString()+",";
		sDescripcion+=TipoFuenteConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipofuente.getcodigo()+",";
		sDescripcion+=TipoFuenteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipofuente.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoFuenteDescripcion(TipoFuente tipofuente,String sValor) throws Exception {			
		if(tipofuente !=null) {
			tipofuente.setcodigo(sValor);;//tipofuentetipofuente.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoFuente(TipoFuente tipofuente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipofuente.setcodigo(tipofuente.getcodigo().trim());
		tipofuente.setnombre(tipofuente.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoFuentes(List<TipoFuente> tipofuentes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoFuente tipofuente: tipofuentes) {
			tipofuente.setcodigo(tipofuente.getcodigo().trim());
			tipofuente.setnombre(tipofuente.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoFuente(TipoFuente tipofuente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipofuente.getConCambioAuxiliar()) {
			tipofuente.setIsDeleted(tipofuente.getIsDeletedAuxiliar());	
			tipofuente.setIsNew(tipofuente.getIsNewAuxiliar());	
			tipofuente.setIsChanged(tipofuente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipofuente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipofuente.setIsDeletedAuxiliar(false);	
			tipofuente.setIsNewAuxiliar(false);	
			tipofuente.setIsChangedAuxiliar(false);
			
			tipofuente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoFuentes(List<TipoFuente> tipofuentes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoFuente tipofuente : tipofuentes) {
			if(conAsignarBase && tipofuente.getConCambioAuxiliar()) {
				tipofuente.setIsDeleted(tipofuente.getIsDeletedAuxiliar());	
				tipofuente.setIsNew(tipofuente.getIsNewAuxiliar());	
				tipofuente.setIsChanged(tipofuente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipofuente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipofuente.setIsDeletedAuxiliar(false);	
				tipofuente.setIsNewAuxiliar(false);	
				tipofuente.setIsChangedAuxiliar(false);
				
				tipofuente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoFuente(TipoFuente tipofuente,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoFuentes(List<TipoFuente> tipofuentes,Boolean conEnteros) throws Exception  {
		
		for(TipoFuente tipofuente: tipofuentes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoFuente(List<TipoFuente> tipofuentes,TipoFuente tipofuenteAux) throws Exception  {
		TipoFuenteConstantesFunciones.InicializarValoresTipoFuente(tipofuenteAux,true);
		
		for(TipoFuente tipofuente: tipofuentes) {
			if(tipofuente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoFuente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoFuenteConstantesFunciones.getArrayColumnasGlobalesTipoFuente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoFuente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoFuente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoFuente> tipofuentes,TipoFuente tipofuente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoFuente tipofuenteAux: tipofuentes) {
			if(tipofuenteAux!=null && tipofuente!=null) {
				if((tipofuenteAux.getId()==null && tipofuente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipofuenteAux.getId()!=null && tipofuente.getId()!=null){
					if(tipofuenteAux.getId().equals(tipofuente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoFuente(List<TipoFuente> tipofuentes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoFuente tipofuente: tipofuentes) {			
			if(tipofuente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoFuente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoFuenteConstantesFunciones.LABEL_ID, TipoFuenteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFuenteConstantesFunciones.LABEL_VERSIONROW, TipoFuenteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFuenteConstantesFunciones.LABEL_CODIGO, TipoFuenteConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFuenteConstantesFunciones.LABEL_NOMBRE, TipoFuenteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoFuente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoFuenteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFuenteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFuenteConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFuenteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFuente() throws Exception  {
		return TipoFuenteConstantesFunciones.getTiposSeleccionarTipoFuente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFuente(Boolean conFk) throws Exception  {
		return TipoFuenteConstantesFunciones.getTiposSeleccionarTipoFuente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFuente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFuenteConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoFuenteConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFuenteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoFuenteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoFuente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoFuente(TipoFuente tipofuenteAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoFuente(List<TipoFuente> tipofuentesTemp) throws Exception {
		for(TipoFuente tipofuenteAux:tipofuentesTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoFuente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoFuente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFuente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoFuenteConstantesFunciones.getClassesRelationshipsOfTipoFuente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFuente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoFuente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoFuenteConstantesFunciones.getClassesRelationshipsFromStringsOfTipoFuente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoFuente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoFuente tipofuente,List<TipoFuente> tipofuentes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoFuente tipofuenteEncontrado=null;
			
			for(TipoFuente tipofuenteLocal:tipofuentes) {
				if(tipofuenteLocal.getId().equals(tipofuente.getId())) {
					tipofuenteEncontrado=tipofuenteLocal;
					
					tipofuenteLocal.setIsChanged(tipofuente.getIsChanged());
					tipofuenteLocal.setIsNew(tipofuente.getIsNew());
					tipofuenteLocal.setIsDeleted(tipofuente.getIsDeleted());
					
					tipofuenteLocal.setGeneralEntityOriginal(tipofuente.getGeneralEntityOriginal());
					
					tipofuenteLocal.setId(tipofuente.getId());	
					tipofuenteLocal.setVersionRow(tipofuente.getVersionRow());	
					tipofuenteLocal.setcodigo(tipofuente.getcodigo());	
					tipofuenteLocal.setnombre(tipofuente.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipofuente.getIsDeleted()) {
				if(!existe) {
					tipofuentes.add(tipofuente);
				}
			} else {
				if(tipofuenteEncontrado!=null && permiteQuitar)  {
					tipofuentes.remove(tipofuenteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoFuente tipofuente,List<TipoFuente> tipofuentes) throws Exception {
		try	{			
			for(TipoFuente tipofuenteLocal:tipofuentes) {
				if(tipofuenteLocal.getId().equals(tipofuente.getId())) {
					tipofuenteLocal.setIsSelected(tipofuente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoFuente(List<TipoFuente> tipofuentesAux) throws Exception {
		//this.tipofuentesAux=tipofuentesAux;
		
		for(TipoFuente tipofuenteAux:tipofuentesAux) {
			if(tipofuenteAux.getIsChanged()) {
				tipofuenteAux.setIsChanged(false);
			}		
			
			if(tipofuenteAux.getIsNew()) {
				tipofuenteAux.setIsNew(false);
			}	
			
			if(tipofuenteAux.getIsDeleted()) {
				tipofuenteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoFuente(TipoFuente tipofuenteAux) throws Exception {
		//this.tipofuenteAux=tipofuenteAux;
		
			if(tipofuenteAux.getIsChanged()) {
				tipofuenteAux.setIsChanged(false);
			}		
			
			if(tipofuenteAux.getIsNew()) {
				tipofuenteAux.setIsNew(false);
			}	
			
			if(tipofuenteAux.getIsDeleted()) {
				tipofuenteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoFuente tipofuenteAsignar,TipoFuente tipofuente) throws Exception {
		tipofuenteAsignar.setId(tipofuente.getId());	
		tipofuenteAsignar.setVersionRow(tipofuente.getVersionRow());	
		tipofuenteAsignar.setcodigo(tipofuente.getcodigo());	
		tipofuenteAsignar.setnombre(tipofuente.getnombre());	
	}
	
	public static void inicializarTipoFuente(TipoFuente tipofuente) throws Exception {
		try {
				tipofuente.setId(0L);	
					
				tipofuente.setcodigo("");	
				tipofuente.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoFuente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFuenteConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFuenteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoFuente(String sTipo,Row row,Workbook workbook,TipoFuente tipofuente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipofuente.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipofuente.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoFuente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoFuente() {
		return this.sFinalQueryTipoFuente;
	}
	
	public void setsFinalQueryTipoFuente(String sFinalQueryTipoFuente) {
		this.sFinalQueryTipoFuente= sFinalQueryTipoFuente;
	}
	
	public Border resaltarSeleccionarTipoFuente=null;
	
	public Border setResaltarSeleccionarTipoFuente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFuenteBeanSwingJInternalFrame tipofuenteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipofuenteBeanSwingJInternalFrame.jTtoolBarTipoFuente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoFuente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoFuente() {
		return this.resaltarSeleccionarTipoFuente;
	}
	
	public void setResaltarSeleccionarTipoFuente(Border borderResaltarSeleccionarTipoFuente) {
		this.resaltarSeleccionarTipoFuente= borderResaltarSeleccionarTipoFuente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoFuente=null;
	public Boolean mostraridTipoFuente=true;
	public Boolean activaridTipoFuente=true;

	public Border resaltarcodigoTipoFuente=null;
	public Boolean mostrarcodigoTipoFuente=true;
	public Boolean activarcodigoTipoFuente=true;

	public Border resaltarnombreTipoFuente=null;
	public Boolean mostrarnombreTipoFuente=true;
	public Boolean activarnombreTipoFuente=true;

	
	

	public Border setResaltaridTipoFuente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFuenteBeanSwingJInternalFrame tipofuenteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipofuenteBeanSwingJInternalFrame.jTtoolBarTipoFuente.setBorder(borderResaltar);
		
		this.resaltaridTipoFuente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoFuente() {
		return this.resaltaridTipoFuente;
	}

	public void setResaltaridTipoFuente(Border borderResaltar) {
		this.resaltaridTipoFuente= borderResaltar;
	}

	public Boolean getMostraridTipoFuente() {
		return this.mostraridTipoFuente;
	}

	public void setMostraridTipoFuente(Boolean mostraridTipoFuente) {
		this.mostraridTipoFuente= mostraridTipoFuente;
	}

	public Boolean getActivaridTipoFuente() {
		return this.activaridTipoFuente;
	}

	public void setActivaridTipoFuente(Boolean activaridTipoFuente) {
		this.activaridTipoFuente= activaridTipoFuente;
	}

	public Border setResaltarcodigoTipoFuente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFuenteBeanSwingJInternalFrame tipofuenteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipofuenteBeanSwingJInternalFrame.jTtoolBarTipoFuente.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoFuente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoFuente() {
		return this.resaltarcodigoTipoFuente;
	}

	public void setResaltarcodigoTipoFuente(Border borderResaltar) {
		this.resaltarcodigoTipoFuente= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoFuente() {
		return this.mostrarcodigoTipoFuente;
	}

	public void setMostrarcodigoTipoFuente(Boolean mostrarcodigoTipoFuente) {
		this.mostrarcodigoTipoFuente= mostrarcodigoTipoFuente;
	}

	public Boolean getActivarcodigoTipoFuente() {
		return this.activarcodigoTipoFuente;
	}

	public void setActivarcodigoTipoFuente(Boolean activarcodigoTipoFuente) {
		this.activarcodigoTipoFuente= activarcodigoTipoFuente;
	}

	public Border setResaltarnombreTipoFuente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFuenteBeanSwingJInternalFrame tipofuenteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipofuenteBeanSwingJInternalFrame.jTtoolBarTipoFuente.setBorder(borderResaltar);
		
		this.resaltarnombreTipoFuente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoFuente() {
		return this.resaltarnombreTipoFuente;
	}

	public void setResaltarnombreTipoFuente(Border borderResaltar) {
		this.resaltarnombreTipoFuente= borderResaltar;
	}

	public Boolean getMostrarnombreTipoFuente() {
		return this.mostrarnombreTipoFuente;
	}

	public void setMostrarnombreTipoFuente(Boolean mostrarnombreTipoFuente) {
		this.mostrarnombreTipoFuente= mostrarnombreTipoFuente;
	}

	public Boolean getActivarnombreTipoFuente() {
		return this.activarnombreTipoFuente;
	}

	public void setActivarnombreTipoFuente(Boolean activarnombreTipoFuente) {
		this.activarnombreTipoFuente= activarnombreTipoFuente;
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
		
		
		this.setMostraridTipoFuente(esInicial);
		this.setMostrarcodigoTipoFuente(esInicial);
		this.setMostrarnombreTipoFuente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFuenteConstantesFunciones.ID)) {
				this.setMostraridTipoFuente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFuenteConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoFuente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFuenteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoFuente(esAsigna);
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
		
		
		this.setActivaridTipoFuente(esInicial);
		this.setActivarcodigoTipoFuente(esInicial);
		this.setActivarnombreTipoFuente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFuenteConstantesFunciones.ID)) {
				this.setActivaridTipoFuente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFuenteConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoFuente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFuenteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoFuente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoFuenteBeanSwingJInternalFrame tipofuenteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoFuente(esInicial);
		this.setResaltarcodigoTipoFuente(esInicial);
		this.setResaltarnombreTipoFuente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFuenteConstantesFunciones.ID)) {
				this.setResaltaridTipoFuente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFuenteConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoFuente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFuenteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoFuente(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoFuenteBeanSwingJInternalFrame tipofuenteBeanSwingJInternalFrame*/)throws Exception {	
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