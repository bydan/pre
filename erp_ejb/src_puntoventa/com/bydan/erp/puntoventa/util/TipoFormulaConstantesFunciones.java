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
package com.bydan.erp.puntoventa.util;

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


import com.bydan.erp.puntoventa.util.TipoFormulaConstantesFunciones;
import com.bydan.erp.puntoventa.util.TipoFormulaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.TipoFormulaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoFormulaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoFormula";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoFormula"+TipoFormulaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoFormulaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoFormulaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoFormulaConstantesFunciones.SCHEMA+"_"+TipoFormulaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoFormulaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoFormulaConstantesFunciones.SCHEMA+"_"+TipoFormulaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoFormulaConstantesFunciones.SCHEMA+"_"+TipoFormulaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoFormulaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoFormulaConstantesFunciones.SCHEMA+"_"+TipoFormulaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFormulaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoFormulaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFormulaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFormulaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoFormulaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFormulaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoFormulaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoFormulaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoFormulaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoFormulaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Formulas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Formula";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Formula";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoFormula";
	public static final String OBJECTNAME="tipoformula";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="tipo_formula";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoformula from "+TipoFormulaConstantesFunciones.SPERSISTENCENAME+" tipoformula";
	public static String QUERYSELECTNATIVE="select "+TipoFormulaConstantesFunciones.SCHEMA+"."+TipoFormulaConstantesFunciones.TABLENAME+".id,"+TipoFormulaConstantesFunciones.SCHEMA+"."+TipoFormulaConstantesFunciones.TABLENAME+".version_row,"+TipoFormulaConstantesFunciones.SCHEMA+"."+TipoFormulaConstantesFunciones.TABLENAME+".nombre,"+TipoFormulaConstantesFunciones.SCHEMA+"."+TipoFormulaConstantesFunciones.TABLENAME+".descripcion from "+TipoFormulaConstantesFunciones.SCHEMA+"."+TipoFormulaConstantesFunciones.TABLENAME;//+" as "+TipoFormulaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoFormulaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoFormulaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoFormulaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoFormulaConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoFormulaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoFormulaDescripcion(TipoFormula tipoformula) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoformula !=null/* && tipoformula.getId()!=0*/) {
			sDescripcion=tipoformula.getnombre();//tipoformulatipoformula.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoFormulaDescripcionDetallado(TipoFormula tipoformula) {
		String sDescripcion="";
			
		sDescripcion+=TipoFormulaConstantesFunciones.ID+"=";
		sDescripcion+=tipoformula.getId().toString()+",";
		sDescripcion+=TipoFormulaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoformula.getVersionRow().toString()+",";
		sDescripcion+=TipoFormulaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoformula.getnombre()+",";
		sDescripcion+=TipoFormulaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tipoformula.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoFormulaDescripcion(TipoFormula tipoformula,String sValor) throws Exception {			
		if(tipoformula !=null) {
			tipoformula.setnombre(sValor);;//tipoformulatipoformula.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoFormula(TipoFormula tipoformula,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoformula.setnombre(tipoformula.getnombre().trim());
		tipoformula.setdescripcion(tipoformula.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoFormulas(List<TipoFormula> tipoformulas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoFormula tipoformula: tipoformulas) {
			tipoformula.setnombre(tipoformula.getnombre().trim());
			tipoformula.setdescripcion(tipoformula.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoFormula(TipoFormula tipoformula,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoformula.getConCambioAuxiliar()) {
			tipoformula.setIsDeleted(tipoformula.getIsDeletedAuxiliar());	
			tipoformula.setIsNew(tipoformula.getIsNewAuxiliar());	
			tipoformula.setIsChanged(tipoformula.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoformula.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoformula.setIsDeletedAuxiliar(false);	
			tipoformula.setIsNewAuxiliar(false);	
			tipoformula.setIsChangedAuxiliar(false);
			
			tipoformula.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoFormulas(List<TipoFormula> tipoformulas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoFormula tipoformula : tipoformulas) {
			if(conAsignarBase && tipoformula.getConCambioAuxiliar()) {
				tipoformula.setIsDeleted(tipoformula.getIsDeletedAuxiliar());	
				tipoformula.setIsNew(tipoformula.getIsNewAuxiliar());	
				tipoformula.setIsChanged(tipoformula.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoformula.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoformula.setIsDeletedAuxiliar(false);	
				tipoformula.setIsNewAuxiliar(false);	
				tipoformula.setIsChangedAuxiliar(false);
				
				tipoformula.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoFormula(TipoFormula tipoformula,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoFormulas(List<TipoFormula> tipoformulas,Boolean conEnteros) throws Exception  {
		
		for(TipoFormula tipoformula: tipoformulas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoFormula(List<TipoFormula> tipoformulas,TipoFormula tipoformulaAux) throws Exception  {
		TipoFormulaConstantesFunciones.InicializarValoresTipoFormula(tipoformulaAux,true);
		
		for(TipoFormula tipoformula: tipoformulas) {
			if(tipoformula.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoFormula(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoFormulaConstantesFunciones.getArrayColumnasGlobalesTipoFormula(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoFormula(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoFormula(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoFormula> tipoformulas,TipoFormula tipoformula,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoFormula tipoformulaAux: tipoformulas) {
			if(tipoformulaAux!=null && tipoformula!=null) {
				if((tipoformulaAux.getId()==null && tipoformula.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoformulaAux.getId()!=null && tipoformula.getId()!=null){
					if(tipoformulaAux.getId().equals(tipoformula.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoFormula(List<TipoFormula> tipoformulas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoFormula tipoformula: tipoformulas) {			
			if(tipoformula.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoFormula() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoFormulaConstantesFunciones.LABEL_ID, TipoFormulaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormulaConstantesFunciones.LABEL_VERSIONROW, TipoFormulaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormulaConstantesFunciones.LABEL_NOMBRE, TipoFormulaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormulaConstantesFunciones.LABEL_DESCRIPCION, TipoFormulaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoFormula() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoFormulaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormulaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormulaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormulaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFormula() throws Exception  {
		return TipoFormulaConstantesFunciones.getTiposSeleccionarTipoFormula(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFormula(Boolean conFk) throws Exception  {
		return TipoFormulaConstantesFunciones.getTiposSeleccionarTipoFormula(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFormula(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFormulaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoFormulaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFormulaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoFormulaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoFormula(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoFormula(TipoFormula tipoformulaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoFormula(List<TipoFormula> tipoformulasTemp) throws Exception {
		for(TipoFormula tipoformulaAux:tipoformulasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoFormula(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoFormula(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFormula(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoFormulaConstantesFunciones.getClassesRelationshipsOfTipoFormula(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFormula(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Formula.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Formula.class)) {
						classes.add(new Classe(Formula.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoFormula(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoFormulaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoFormula(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoFormula(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Formula.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formula.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Formula.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formula.class)); continue;
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
	public static void actualizarLista(TipoFormula tipoformula,List<TipoFormula> tipoformulas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoFormula tipoformulaEncontrado=null;
			
			for(TipoFormula tipoformulaLocal:tipoformulas) {
				if(tipoformulaLocal.getId().equals(tipoformula.getId())) {
					tipoformulaEncontrado=tipoformulaLocal;
					
					tipoformulaLocal.setIsChanged(tipoformula.getIsChanged());
					tipoformulaLocal.setIsNew(tipoformula.getIsNew());
					tipoformulaLocal.setIsDeleted(tipoformula.getIsDeleted());
					
					tipoformulaLocal.setGeneralEntityOriginal(tipoformula.getGeneralEntityOriginal());
					
					tipoformulaLocal.setId(tipoformula.getId());	
					tipoformulaLocal.setVersionRow(tipoformula.getVersionRow());	
					tipoformulaLocal.setnombre(tipoformula.getnombre());	
					tipoformulaLocal.setdescripcion(tipoformula.getdescripcion());	
					
					
					tipoformulaLocal.setFormulas(tipoformula.getFormulas());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoformula.getIsDeleted()) {
				if(!existe) {
					tipoformulas.add(tipoformula);
				}
			} else {
				if(tipoformulaEncontrado!=null && permiteQuitar)  {
					tipoformulas.remove(tipoformulaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoFormula tipoformula,List<TipoFormula> tipoformulas) throws Exception {
		try	{			
			for(TipoFormula tipoformulaLocal:tipoformulas) {
				if(tipoformulaLocal.getId().equals(tipoformula.getId())) {
					tipoformulaLocal.setIsSelected(tipoformula.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoFormula(List<TipoFormula> tipoformulasAux) throws Exception {
		//this.tipoformulasAux=tipoformulasAux;
		
		for(TipoFormula tipoformulaAux:tipoformulasAux) {
			if(tipoformulaAux.getIsChanged()) {
				tipoformulaAux.setIsChanged(false);
			}		
			
			if(tipoformulaAux.getIsNew()) {
				tipoformulaAux.setIsNew(false);
			}	
			
			if(tipoformulaAux.getIsDeleted()) {
				tipoformulaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoFormula(TipoFormula tipoformulaAux) throws Exception {
		//this.tipoformulaAux=tipoformulaAux;
		
			if(tipoformulaAux.getIsChanged()) {
				tipoformulaAux.setIsChanged(false);
			}		
			
			if(tipoformulaAux.getIsNew()) {
				tipoformulaAux.setIsNew(false);
			}	
			
			if(tipoformulaAux.getIsDeleted()) {
				tipoformulaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoFormula tipoformulaAsignar,TipoFormula tipoformula) throws Exception {
		tipoformulaAsignar.setId(tipoformula.getId());	
		tipoformulaAsignar.setVersionRow(tipoformula.getVersionRow());	
		tipoformulaAsignar.setnombre(tipoformula.getnombre());	
		tipoformulaAsignar.setdescripcion(tipoformula.getdescripcion());	
	}
	
	public static void inicializarTipoFormula(TipoFormula tipoformula) throws Exception {
		try {
				tipoformula.setId(0L);	
					
				tipoformula.setnombre("");	
				tipoformula.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoFormula(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFormulaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFormulaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoFormula(String sTipo,Row row,Workbook workbook,TipoFormula tipoformula,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoformula.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoformula.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoFormula=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoFormula() {
		return this.sFinalQueryTipoFormula;
	}
	
	public void setsFinalQueryTipoFormula(String sFinalQueryTipoFormula) {
		this.sFinalQueryTipoFormula= sFinalQueryTipoFormula;
	}
	
	public Border resaltarSeleccionarTipoFormula=null;
	
	public Border setResaltarSeleccionarTipoFormula(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormulaBeanSwingJInternalFrame tipoformulaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoformulaBeanSwingJInternalFrame.jTtoolBarTipoFormula.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoFormula= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoFormula() {
		return this.resaltarSeleccionarTipoFormula;
	}
	
	public void setResaltarSeleccionarTipoFormula(Border borderResaltarSeleccionarTipoFormula) {
		this.resaltarSeleccionarTipoFormula= borderResaltarSeleccionarTipoFormula;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoFormula=null;
	public Boolean mostraridTipoFormula=true;
	public Boolean activaridTipoFormula=true;

	public Border resaltarnombreTipoFormula=null;
	public Boolean mostrarnombreTipoFormula=true;
	public Boolean activarnombreTipoFormula=true;

	public Border resaltardescripcionTipoFormula=null;
	public Boolean mostrardescripcionTipoFormula=true;
	public Boolean activardescripcionTipoFormula=true;

	
	

	public Border setResaltaridTipoFormula(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormulaBeanSwingJInternalFrame tipoformulaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformulaBeanSwingJInternalFrame.jTtoolBarTipoFormula.setBorder(borderResaltar);
		
		this.resaltaridTipoFormula= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoFormula() {
		return this.resaltaridTipoFormula;
	}

	public void setResaltaridTipoFormula(Border borderResaltar) {
		this.resaltaridTipoFormula= borderResaltar;
	}

	public Boolean getMostraridTipoFormula() {
		return this.mostraridTipoFormula;
	}

	public void setMostraridTipoFormula(Boolean mostraridTipoFormula) {
		this.mostraridTipoFormula= mostraridTipoFormula;
	}

	public Boolean getActivaridTipoFormula() {
		return this.activaridTipoFormula;
	}

	public void setActivaridTipoFormula(Boolean activaridTipoFormula) {
		this.activaridTipoFormula= activaridTipoFormula;
	}

	public Border setResaltarnombreTipoFormula(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormulaBeanSwingJInternalFrame tipoformulaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformulaBeanSwingJInternalFrame.jTtoolBarTipoFormula.setBorder(borderResaltar);
		
		this.resaltarnombreTipoFormula= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoFormula() {
		return this.resaltarnombreTipoFormula;
	}

	public void setResaltarnombreTipoFormula(Border borderResaltar) {
		this.resaltarnombreTipoFormula= borderResaltar;
	}

	public Boolean getMostrarnombreTipoFormula() {
		return this.mostrarnombreTipoFormula;
	}

	public void setMostrarnombreTipoFormula(Boolean mostrarnombreTipoFormula) {
		this.mostrarnombreTipoFormula= mostrarnombreTipoFormula;
	}

	public Boolean getActivarnombreTipoFormula() {
		return this.activarnombreTipoFormula;
	}

	public void setActivarnombreTipoFormula(Boolean activarnombreTipoFormula) {
		this.activarnombreTipoFormula= activarnombreTipoFormula;
	}

	public Border setResaltardescripcionTipoFormula(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormulaBeanSwingJInternalFrame tipoformulaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformulaBeanSwingJInternalFrame.jTtoolBarTipoFormula.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoFormula= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoFormula() {
		return this.resaltardescripcionTipoFormula;
	}

	public void setResaltardescripcionTipoFormula(Border borderResaltar) {
		this.resaltardescripcionTipoFormula= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoFormula() {
		return this.mostrardescripcionTipoFormula;
	}

	public void setMostrardescripcionTipoFormula(Boolean mostrardescripcionTipoFormula) {
		this.mostrardescripcionTipoFormula= mostrardescripcionTipoFormula;
	}

	public Boolean getActivardescripcionTipoFormula() {
		return this.activardescripcionTipoFormula;
	}

	public void setActivardescripcionTipoFormula(Boolean activardescripcionTipoFormula) {
		this.activardescripcionTipoFormula= activardescripcionTipoFormula;
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
		
		
		this.setMostraridTipoFormula(esInicial);
		this.setMostrarnombreTipoFormula(esInicial);
		this.setMostrardescripcionTipoFormula(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFormulaConstantesFunciones.ID)) {
				this.setMostraridTipoFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormulaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormulaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoFormula(esAsigna);
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
		
		
		this.setActivaridTipoFormula(esInicial);
		this.setActivarnombreTipoFormula(esInicial);
		this.setActivardescripcionTipoFormula(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFormulaConstantesFunciones.ID)) {
				this.setActivaridTipoFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormulaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormulaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoFormula(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoFormulaBeanSwingJInternalFrame tipoformulaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoFormula(esInicial);
		this.setResaltarnombreTipoFormula(esInicial);
		this.setResaltardescripcionTipoFormula(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFormulaConstantesFunciones.ID)) {
				this.setResaltaridTipoFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormulaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoFormula(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormulaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoFormula(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFormulaTipoFormula=null;

	public Border getResaltarFormulaTipoFormula() {
		return this.resaltarFormulaTipoFormula;
	}

	public void setResaltarFormulaTipoFormula(Border borderResaltarFormula) {
		if(borderResaltarFormula!=null) {
			this.resaltarFormulaTipoFormula= borderResaltarFormula;
		}
	}

	public Border setResaltarFormulaTipoFormula(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormulaBeanSwingJInternalFrame tipoformulaBeanSwingJInternalFrame*/) {
		Border borderResaltarFormula=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoformulaBeanSwingJInternalFrame.jTtoolBarTipoFormula.setBorder(borderResaltarFormula);
			
		this.resaltarFormulaTipoFormula= borderResaltarFormula;

		 return borderResaltarFormula;
	}



	public Boolean mostrarFormulaTipoFormula=true;

	public Boolean getMostrarFormulaTipoFormula() {
		return this.mostrarFormulaTipoFormula;
	}

	public void setMostrarFormulaTipoFormula(Boolean visibilidadResaltarFormula) {
		this.mostrarFormulaTipoFormula= visibilidadResaltarFormula;
	}



	public Boolean activarFormulaTipoFormula=true;

	public Boolean gethabilitarResaltarFormulaTipoFormula() {
		return this.activarFormulaTipoFormula;
	}

	public void setActivarFormulaTipoFormula(Boolean habilitarResaltarFormula) {
		this.activarFormulaTipoFormula= habilitarResaltarFormula;
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

		this.setMostrarFormulaTipoFormula(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Formula.class)) {
				this.setMostrarFormulaTipoFormula(esAsigna);
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

		this.setActivarFormulaTipoFormula(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Formula.class)) {
				this.setActivarFormulaTipoFormula(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoFormulaBeanSwingJInternalFrame tipoformulaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFormulaTipoFormula(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Formula.class)) {
				this.setResaltarFormulaTipoFormula(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}