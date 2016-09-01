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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.TipoCalculoConstantesFunciones;
import com.bydan.erp.nomina.util.TipoCalculoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoCalculoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoCalculoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoCalculo";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoCalculo"+TipoCalculoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoCalculoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoCalculoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoCalculoConstantesFunciones.SCHEMA+"_"+TipoCalculoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoCalculoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoCalculoConstantesFunciones.SCHEMA+"_"+TipoCalculoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoCalculoConstantesFunciones.SCHEMA+"_"+TipoCalculoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoCalculoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoCalculoConstantesFunciones.SCHEMA+"_"+TipoCalculoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCalculoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCalculoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCalculoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCalculoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCalculoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCalculoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoCalculoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoCalculoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoCalculoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoCalculoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Calculos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Calculo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Calculo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoCalculo";
	public static final String OBJECTNAME="tipocalculo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_calculo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocalculo from "+TipoCalculoConstantesFunciones.SPERSISTENCENAME+" tipocalculo";
	public static String QUERYSELECTNATIVE="select "+TipoCalculoConstantesFunciones.SCHEMA+"."+TipoCalculoConstantesFunciones.TABLENAME+".id,"+TipoCalculoConstantesFunciones.SCHEMA+"."+TipoCalculoConstantesFunciones.TABLENAME+".version_row,"+TipoCalculoConstantesFunciones.SCHEMA+"."+TipoCalculoConstantesFunciones.TABLENAME+".codigo,"+TipoCalculoConstantesFunciones.SCHEMA+"."+TipoCalculoConstantesFunciones.TABLENAME+".nombre from "+TipoCalculoConstantesFunciones.SCHEMA+"."+TipoCalculoConstantesFunciones.TABLENAME;//+" as "+TipoCalculoConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoCalculoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoCalculoConstantesFunciones.CODIGO)) {sLabelColumna=TipoCalculoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoCalculoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoCalculoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoCalculoDescripcion(TipoCalculo tipocalculo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocalculo !=null/* && tipocalculo.getId()!=0*/) {
			sDescripcion=tipocalculo.getcodigo();//tipocalculotipocalculo.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoCalculoDescripcionDetallado(TipoCalculo tipocalculo) {
		String sDescripcion="";
			
		sDescripcion+=TipoCalculoConstantesFunciones.ID+"=";
		sDescripcion+=tipocalculo.getId().toString()+",";
		sDescripcion+=TipoCalculoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocalculo.getVersionRow().toString()+",";
		sDescripcion+=TipoCalculoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipocalculo.getcodigo()+",";
		sDescripcion+=TipoCalculoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocalculo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoCalculoDescripcion(TipoCalculo tipocalculo,String sValor) throws Exception {			
		if(tipocalculo !=null) {
			tipocalculo.setcodigo(sValor);;//tipocalculotipocalculo.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoCalculo(TipoCalculo tipocalculo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocalculo.setcodigo(tipocalculo.getcodigo().trim());
		tipocalculo.setnombre(tipocalculo.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoCalculos(List<TipoCalculo> tipocalculos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoCalculo tipocalculo: tipocalculos) {
			tipocalculo.setcodigo(tipocalculo.getcodigo().trim());
			tipocalculo.setnombre(tipocalculo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCalculo(TipoCalculo tipocalculo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocalculo.getConCambioAuxiliar()) {
			tipocalculo.setIsDeleted(tipocalculo.getIsDeletedAuxiliar());	
			tipocalculo.setIsNew(tipocalculo.getIsNewAuxiliar());	
			tipocalculo.setIsChanged(tipocalculo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocalculo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocalculo.setIsDeletedAuxiliar(false);	
			tipocalculo.setIsNewAuxiliar(false);	
			tipocalculo.setIsChangedAuxiliar(false);
			
			tipocalculo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCalculos(List<TipoCalculo> tipocalculos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoCalculo tipocalculo : tipocalculos) {
			if(conAsignarBase && tipocalculo.getConCambioAuxiliar()) {
				tipocalculo.setIsDeleted(tipocalculo.getIsDeletedAuxiliar());	
				tipocalculo.setIsNew(tipocalculo.getIsNewAuxiliar());	
				tipocalculo.setIsChanged(tipocalculo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocalculo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocalculo.setIsDeletedAuxiliar(false);	
				tipocalculo.setIsNewAuxiliar(false);	
				tipocalculo.setIsChangedAuxiliar(false);
				
				tipocalculo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoCalculo(TipoCalculo tipocalculo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoCalculos(List<TipoCalculo> tipocalculos,Boolean conEnteros) throws Exception  {
		
		for(TipoCalculo tipocalculo: tipocalculos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoCalculo(List<TipoCalculo> tipocalculos,TipoCalculo tipocalculoAux) throws Exception  {
		TipoCalculoConstantesFunciones.InicializarValoresTipoCalculo(tipocalculoAux,true);
		
		for(TipoCalculo tipocalculo: tipocalculos) {
			if(tipocalculo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCalculo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoCalculoConstantesFunciones.getArrayColumnasGlobalesTipoCalculo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCalculo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoCalculo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoCalculo> tipocalculos,TipoCalculo tipocalculo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoCalculo tipocalculoAux: tipocalculos) {
			if(tipocalculoAux!=null && tipocalculo!=null) {
				if((tipocalculoAux.getId()==null && tipocalculo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocalculoAux.getId()!=null && tipocalculo.getId()!=null){
					if(tipocalculoAux.getId().equals(tipocalculo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoCalculo(List<TipoCalculo> tipocalculos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoCalculo tipocalculo: tipocalculos) {			
			if(tipocalculo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoCalculo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoCalculoConstantesFunciones.LABEL_ID, TipoCalculoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCalculoConstantesFunciones.LABEL_VERSIONROW, TipoCalculoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCalculoConstantesFunciones.LABEL_CODIGO, TipoCalculoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCalculoConstantesFunciones.LABEL_NOMBRE, TipoCalculoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoCalculo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoCalculoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCalculoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCalculoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCalculoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCalculo() throws Exception  {
		return TipoCalculoConstantesFunciones.getTiposSeleccionarTipoCalculo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCalculo(Boolean conFk) throws Exception  {
		return TipoCalculoConstantesFunciones.getTiposSeleccionarTipoCalculo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCalculo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCalculoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoCalculoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCalculoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoCalculoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoCalculo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCalculo(TipoCalculo tipocalculoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCalculo(List<TipoCalculo> tipocalculosTemp) throws Exception {
		for(TipoCalculo tipocalculoAux:tipocalculosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCalculo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoCalculo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCalculo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCalculoConstantesFunciones.getClassesRelationshipsOfTipoCalculo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCalculo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCalculo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCalculoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoCalculo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCalculo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoCalculo tipocalculo,List<TipoCalculo> tipocalculos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoCalculo tipocalculoEncontrado=null;
			
			for(TipoCalculo tipocalculoLocal:tipocalculos) {
				if(tipocalculoLocal.getId().equals(tipocalculo.getId())) {
					tipocalculoEncontrado=tipocalculoLocal;
					
					tipocalculoLocal.setIsChanged(tipocalculo.getIsChanged());
					tipocalculoLocal.setIsNew(tipocalculo.getIsNew());
					tipocalculoLocal.setIsDeleted(tipocalculo.getIsDeleted());
					
					tipocalculoLocal.setGeneralEntityOriginal(tipocalculo.getGeneralEntityOriginal());
					
					tipocalculoLocal.setId(tipocalculo.getId());	
					tipocalculoLocal.setVersionRow(tipocalculo.getVersionRow());	
					tipocalculoLocal.setcodigo(tipocalculo.getcodigo());	
					tipocalculoLocal.setnombre(tipocalculo.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipocalculo.getIsDeleted()) {
				if(!existe) {
					tipocalculos.add(tipocalculo);
				}
			} else {
				if(tipocalculoEncontrado!=null && permiteQuitar)  {
					tipocalculos.remove(tipocalculoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoCalculo tipocalculo,List<TipoCalculo> tipocalculos) throws Exception {
		try	{			
			for(TipoCalculo tipocalculoLocal:tipocalculos) {
				if(tipocalculoLocal.getId().equals(tipocalculo.getId())) {
					tipocalculoLocal.setIsSelected(tipocalculo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoCalculo(List<TipoCalculo> tipocalculosAux) throws Exception {
		//this.tipocalculosAux=tipocalculosAux;
		
		for(TipoCalculo tipocalculoAux:tipocalculosAux) {
			if(tipocalculoAux.getIsChanged()) {
				tipocalculoAux.setIsChanged(false);
			}		
			
			if(tipocalculoAux.getIsNew()) {
				tipocalculoAux.setIsNew(false);
			}	
			
			if(tipocalculoAux.getIsDeleted()) {
				tipocalculoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoCalculo(TipoCalculo tipocalculoAux) throws Exception {
		//this.tipocalculoAux=tipocalculoAux;
		
			if(tipocalculoAux.getIsChanged()) {
				tipocalculoAux.setIsChanged(false);
			}		
			
			if(tipocalculoAux.getIsNew()) {
				tipocalculoAux.setIsNew(false);
			}	
			
			if(tipocalculoAux.getIsDeleted()) {
				tipocalculoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoCalculo tipocalculoAsignar,TipoCalculo tipocalculo) throws Exception {
		tipocalculoAsignar.setId(tipocalculo.getId());	
		tipocalculoAsignar.setVersionRow(tipocalculo.getVersionRow());	
		tipocalculoAsignar.setcodigo(tipocalculo.getcodigo());	
		tipocalculoAsignar.setnombre(tipocalculo.getnombre());	
	}
	
	public static void inicializarTipoCalculo(TipoCalculo tipocalculo) throws Exception {
		try {
				tipocalculo.setId(0L);	
					
				tipocalculo.setcodigo("");	
				tipocalculo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoCalculo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCalculoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCalculoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoCalculo(String sTipo,Row row,Workbook workbook,TipoCalculo tipocalculo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocalculo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocalculo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoCalculo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoCalculo() {
		return this.sFinalQueryTipoCalculo;
	}
	
	public void setsFinalQueryTipoCalculo(String sFinalQueryTipoCalculo) {
		this.sFinalQueryTipoCalculo= sFinalQueryTipoCalculo;
	}
	
	public Border resaltarSeleccionarTipoCalculo=null;
	
	public Border setResaltarSeleccionarTipoCalculo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCalculoBeanSwingJInternalFrame tipocalculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocalculoBeanSwingJInternalFrame.jTtoolBarTipoCalculo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoCalculo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoCalculo() {
		return this.resaltarSeleccionarTipoCalculo;
	}
	
	public void setResaltarSeleccionarTipoCalculo(Border borderResaltarSeleccionarTipoCalculo) {
		this.resaltarSeleccionarTipoCalculo= borderResaltarSeleccionarTipoCalculo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoCalculo=null;
	public Boolean mostraridTipoCalculo=true;
	public Boolean activaridTipoCalculo=true;

	public Border resaltarcodigoTipoCalculo=null;
	public Boolean mostrarcodigoTipoCalculo=true;
	public Boolean activarcodigoTipoCalculo=true;

	public Border resaltarnombreTipoCalculo=null;
	public Boolean mostrarnombreTipoCalculo=true;
	public Boolean activarnombreTipoCalculo=true;

	
	

	public Border setResaltaridTipoCalculo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCalculoBeanSwingJInternalFrame tipocalculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocalculoBeanSwingJInternalFrame.jTtoolBarTipoCalculo.setBorder(borderResaltar);
		
		this.resaltaridTipoCalculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoCalculo() {
		return this.resaltaridTipoCalculo;
	}

	public void setResaltaridTipoCalculo(Border borderResaltar) {
		this.resaltaridTipoCalculo= borderResaltar;
	}

	public Boolean getMostraridTipoCalculo() {
		return this.mostraridTipoCalculo;
	}

	public void setMostraridTipoCalculo(Boolean mostraridTipoCalculo) {
		this.mostraridTipoCalculo= mostraridTipoCalculo;
	}

	public Boolean getActivaridTipoCalculo() {
		return this.activaridTipoCalculo;
	}

	public void setActivaridTipoCalculo(Boolean activaridTipoCalculo) {
		this.activaridTipoCalculo= activaridTipoCalculo;
	}

	public Border setResaltarcodigoTipoCalculo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCalculoBeanSwingJInternalFrame tipocalculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocalculoBeanSwingJInternalFrame.jTtoolBarTipoCalculo.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoCalculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoCalculo() {
		return this.resaltarcodigoTipoCalculo;
	}

	public void setResaltarcodigoTipoCalculo(Border borderResaltar) {
		this.resaltarcodigoTipoCalculo= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoCalculo() {
		return this.mostrarcodigoTipoCalculo;
	}

	public void setMostrarcodigoTipoCalculo(Boolean mostrarcodigoTipoCalculo) {
		this.mostrarcodigoTipoCalculo= mostrarcodigoTipoCalculo;
	}

	public Boolean getActivarcodigoTipoCalculo() {
		return this.activarcodigoTipoCalculo;
	}

	public void setActivarcodigoTipoCalculo(Boolean activarcodigoTipoCalculo) {
		this.activarcodigoTipoCalculo= activarcodigoTipoCalculo;
	}

	public Border setResaltarnombreTipoCalculo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCalculoBeanSwingJInternalFrame tipocalculoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocalculoBeanSwingJInternalFrame.jTtoolBarTipoCalculo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoCalculo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoCalculo() {
		return this.resaltarnombreTipoCalculo;
	}

	public void setResaltarnombreTipoCalculo(Border borderResaltar) {
		this.resaltarnombreTipoCalculo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoCalculo() {
		return this.mostrarnombreTipoCalculo;
	}

	public void setMostrarnombreTipoCalculo(Boolean mostrarnombreTipoCalculo) {
		this.mostrarnombreTipoCalculo= mostrarnombreTipoCalculo;
	}

	public Boolean getActivarnombreTipoCalculo() {
		return this.activarnombreTipoCalculo;
	}

	public void setActivarnombreTipoCalculo(Boolean activarnombreTipoCalculo) {
		this.activarnombreTipoCalculo= activarnombreTipoCalculo;
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
		
		
		this.setMostraridTipoCalculo(esInicial);
		this.setMostrarcodigoTipoCalculo(esInicial);
		this.setMostrarnombreTipoCalculo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCalculoConstantesFunciones.ID)) {
				this.setMostraridTipoCalculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCalculoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoCalculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCalculoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoCalculo(esAsigna);
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
		
		
		this.setActivaridTipoCalculo(esInicial);
		this.setActivarcodigoTipoCalculo(esInicial);
		this.setActivarnombreTipoCalculo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCalculoConstantesFunciones.ID)) {
				this.setActivaridTipoCalculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCalculoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoCalculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCalculoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoCalculo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCalculoBeanSwingJInternalFrame tipocalculoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoCalculo(esInicial);
		this.setResaltarcodigoTipoCalculo(esInicial);
		this.setResaltarnombreTipoCalculo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCalculoConstantesFunciones.ID)) {
				this.setResaltaridTipoCalculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCalculoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoCalculo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCalculoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoCalculo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCalculoBeanSwingJInternalFrame tipocalculoBeanSwingJInternalFrame*/)throws Exception {	
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