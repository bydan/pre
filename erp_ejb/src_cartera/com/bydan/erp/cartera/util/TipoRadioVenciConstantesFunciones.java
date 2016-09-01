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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.TipoRadioVenciConstantesFunciones;
import com.bydan.erp.cartera.util.TipoRadioVenciParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoRadioVenciParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoRadioVenciConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoRadioVenci";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoRadioVenci"+TipoRadioVenciConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoRadioVenciHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoRadioVenciHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoRadioVenciConstantesFunciones.SCHEMA+"_"+TipoRadioVenciConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoRadioVenciHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoRadioVenciConstantesFunciones.SCHEMA+"_"+TipoRadioVenciConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoRadioVenciConstantesFunciones.SCHEMA+"_"+TipoRadioVenciConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoRadioVenciHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoRadioVenciConstantesFunciones.SCHEMA+"_"+TipoRadioVenciConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRadioVenciConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRadioVenciHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRadioVenciConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRadioVenciConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRadioVenciHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRadioVenciConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoRadioVenciConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoRadioVenciConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoRadioVenciConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoRadioVenciConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Radio Vencis";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Radio Venci";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Radio Venci";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoRadioVenci";
	public static final String OBJECTNAME="tiporadiovenci";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_radio_venci";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiporadiovenci from "+TipoRadioVenciConstantesFunciones.SPERSISTENCENAME+" tiporadiovenci";
	public static String QUERYSELECTNATIVE="select "+TipoRadioVenciConstantesFunciones.SCHEMA+"."+TipoRadioVenciConstantesFunciones.TABLENAME+".id,"+TipoRadioVenciConstantesFunciones.SCHEMA+"."+TipoRadioVenciConstantesFunciones.TABLENAME+".version_row,"+TipoRadioVenciConstantesFunciones.SCHEMA+"."+TipoRadioVenciConstantesFunciones.TABLENAME+".nombre from "+TipoRadioVenciConstantesFunciones.SCHEMA+"."+TipoRadioVenciConstantesFunciones.TABLENAME;//+" as "+TipoRadioVenciConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoRadioVenciLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoRadioVenciConstantesFunciones.NOMBRE)) {sLabelColumna=TipoRadioVenciConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getTipoRadioVenciDescripcion(TipoRadioVenci tiporadiovenci) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiporadiovenci !=null/* && tiporadiovenci.getId()!=0*/) {
			sDescripcion=tiporadiovenci.getnombre();//tiporadiovencitiporadiovenci.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoRadioVenciDescripcionDetallado(TipoRadioVenci tiporadiovenci) {
		String sDescripcion="";
			
		sDescripcion+=TipoRadioVenciConstantesFunciones.ID+"=";
		sDescripcion+=tiporadiovenci.getId().toString()+",";
		sDescripcion+=TipoRadioVenciConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiporadiovenci.getVersionRow().toString()+",";
		sDescripcion+=TipoRadioVenciConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiporadiovenci.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoRadioVenciDescripcion(TipoRadioVenci tiporadiovenci,String sValor) throws Exception {			
		if(tiporadiovenci !=null) {
			tiporadiovenci.setnombre(sValor);;//tiporadiovencitiporadiovenci.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoRadioVenci(TipoRadioVenci tiporadiovenci,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiporadiovenci.setnombre(tiporadiovenci.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoRadioVencis(List<TipoRadioVenci> tiporadiovencis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoRadioVenci tiporadiovenci: tiporadiovencis) {
			tiporadiovenci.setnombre(tiporadiovenci.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRadioVenci(TipoRadioVenci tiporadiovenci,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiporadiovenci.getConCambioAuxiliar()) {
			tiporadiovenci.setIsDeleted(tiporadiovenci.getIsDeletedAuxiliar());	
			tiporadiovenci.setIsNew(tiporadiovenci.getIsNewAuxiliar());	
			tiporadiovenci.setIsChanged(tiporadiovenci.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiporadiovenci.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiporadiovenci.setIsDeletedAuxiliar(false);	
			tiporadiovenci.setIsNewAuxiliar(false);	
			tiporadiovenci.setIsChangedAuxiliar(false);
			
			tiporadiovenci.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRadioVencis(List<TipoRadioVenci> tiporadiovencis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoRadioVenci tiporadiovenci : tiporadiovencis) {
			if(conAsignarBase && tiporadiovenci.getConCambioAuxiliar()) {
				tiporadiovenci.setIsDeleted(tiporadiovenci.getIsDeletedAuxiliar());	
				tiporadiovenci.setIsNew(tiporadiovenci.getIsNewAuxiliar());	
				tiporadiovenci.setIsChanged(tiporadiovenci.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiporadiovenci.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiporadiovenci.setIsDeletedAuxiliar(false);	
				tiporadiovenci.setIsNewAuxiliar(false);	
				tiporadiovenci.setIsChangedAuxiliar(false);
				
				tiporadiovenci.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoRadioVenci(TipoRadioVenci tiporadiovenci,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoRadioVencis(List<TipoRadioVenci> tiporadiovencis,Boolean conEnteros) throws Exception  {
		
		for(TipoRadioVenci tiporadiovenci: tiporadiovencis) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoRadioVenci(List<TipoRadioVenci> tiporadiovencis,TipoRadioVenci tiporadiovenciAux) throws Exception  {
		TipoRadioVenciConstantesFunciones.InicializarValoresTipoRadioVenci(tiporadiovenciAux,true);
		
		for(TipoRadioVenci tiporadiovenci: tiporadiovencis) {
			if(tiporadiovenci.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRadioVenci(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoRadioVenciConstantesFunciones.getArrayColumnasGlobalesTipoRadioVenci(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRadioVenci(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoRadioVenci(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoRadioVenci> tiporadiovencis,TipoRadioVenci tiporadiovenci,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoRadioVenci tiporadiovenciAux: tiporadiovencis) {
			if(tiporadiovenciAux!=null && tiporadiovenci!=null) {
				if((tiporadiovenciAux.getId()==null && tiporadiovenci.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiporadiovenciAux.getId()!=null && tiporadiovenci.getId()!=null){
					if(tiporadiovenciAux.getId().equals(tiporadiovenci.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoRadioVenci(List<TipoRadioVenci> tiporadiovencis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoRadioVenci tiporadiovenci: tiporadiovencis) {			
			if(tiporadiovenci.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoRadioVenci() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoRadioVenciConstantesFunciones.LABEL_ID, TipoRadioVenciConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRadioVenciConstantesFunciones.LABEL_VERSIONROW, TipoRadioVenciConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRadioVenciConstantesFunciones.LABEL_NOMBRE, TipoRadioVenciConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoRadioVenci() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoRadioVenciConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRadioVenciConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRadioVenciConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRadioVenci() throws Exception  {
		return TipoRadioVenciConstantesFunciones.getTiposSeleccionarTipoRadioVenci(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRadioVenci(Boolean conFk) throws Exception  {
		return TipoRadioVenciConstantesFunciones.getTiposSeleccionarTipoRadioVenci(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRadioVenci(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRadioVenciConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoRadioVenciConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoRadioVenci(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRadioVenci(TipoRadioVenci tiporadiovenciAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRadioVenci(List<TipoRadioVenci> tiporadiovencisTemp) throws Exception {
		for(TipoRadioVenci tiporadiovenciAux:tiporadiovencisTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRadioVenci(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoRadioVenci(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRadioVenci(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRadioVenciConstantesFunciones.getClassesRelationshipsOfTipoRadioVenci(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRadioVenci(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(RadioVenciProve.class));
				classes.add(new Classe(RadioVenciClienteProve.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(RadioVenciProve.class)) {
						classes.add(new Classe(RadioVenciProve.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RadioVenciClienteProve.class)) {
						classes.add(new Classe(RadioVenciClienteProve.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRadioVenci(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRadioVenciConstantesFunciones.getClassesRelationshipsFromStringsOfTipoRadioVenci(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRadioVenci(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(RadioVenciProve.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RadioVenciProve.class)); continue;
					}

					if(RadioVenciClienteProve.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RadioVenciClienteProve.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(RadioVenciProve.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RadioVenciProve.class)); continue;
					}

					if(RadioVenciClienteProve.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RadioVenciClienteProve.class)); continue;
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
	public static void actualizarLista(TipoRadioVenci tiporadiovenci,List<TipoRadioVenci> tiporadiovencis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoRadioVenci tiporadiovenciEncontrado=null;
			
			for(TipoRadioVenci tiporadiovenciLocal:tiporadiovencis) {
				if(tiporadiovenciLocal.getId().equals(tiporadiovenci.getId())) {
					tiporadiovenciEncontrado=tiporadiovenciLocal;
					
					tiporadiovenciLocal.setIsChanged(tiporadiovenci.getIsChanged());
					tiporadiovenciLocal.setIsNew(tiporadiovenci.getIsNew());
					tiporadiovenciLocal.setIsDeleted(tiporadiovenci.getIsDeleted());
					
					tiporadiovenciLocal.setGeneralEntityOriginal(tiporadiovenci.getGeneralEntityOriginal());
					
					tiporadiovenciLocal.setId(tiporadiovenci.getId());	
					tiporadiovenciLocal.setVersionRow(tiporadiovenci.getVersionRow());	
					tiporadiovenciLocal.setnombre(tiporadiovenci.getnombre());	
					
					
					tiporadiovenciLocal.setRadioVenciProves(tiporadiovenci.getRadioVenciProves());
					tiporadiovenciLocal.setRadioVenciClienteProves(tiporadiovenci.getRadioVenciClienteProves());
					
					existe=true;
					break;
				}
			}
			
			if(!tiporadiovenci.getIsDeleted()) {
				if(!existe) {
					tiporadiovencis.add(tiporadiovenci);
				}
			} else {
				if(tiporadiovenciEncontrado!=null && permiteQuitar)  {
					tiporadiovencis.remove(tiporadiovenciEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoRadioVenci tiporadiovenci,List<TipoRadioVenci> tiporadiovencis) throws Exception {
		try	{			
			for(TipoRadioVenci tiporadiovenciLocal:tiporadiovencis) {
				if(tiporadiovenciLocal.getId().equals(tiporadiovenci.getId())) {
					tiporadiovenciLocal.setIsSelected(tiporadiovenci.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoRadioVenci(List<TipoRadioVenci> tiporadiovencisAux) throws Exception {
		//this.tiporadiovencisAux=tiporadiovencisAux;
		
		for(TipoRadioVenci tiporadiovenciAux:tiporadiovencisAux) {
			if(tiporadiovenciAux.getIsChanged()) {
				tiporadiovenciAux.setIsChanged(false);
			}		
			
			if(tiporadiovenciAux.getIsNew()) {
				tiporadiovenciAux.setIsNew(false);
			}	
			
			if(tiporadiovenciAux.getIsDeleted()) {
				tiporadiovenciAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoRadioVenci(TipoRadioVenci tiporadiovenciAux) throws Exception {
		//this.tiporadiovenciAux=tiporadiovenciAux;
		
			if(tiporadiovenciAux.getIsChanged()) {
				tiporadiovenciAux.setIsChanged(false);
			}		
			
			if(tiporadiovenciAux.getIsNew()) {
				tiporadiovenciAux.setIsNew(false);
			}	
			
			if(tiporadiovenciAux.getIsDeleted()) {
				tiporadiovenciAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoRadioVenci tiporadiovenciAsignar,TipoRadioVenci tiporadiovenci) throws Exception {
		tiporadiovenciAsignar.setId(tiporadiovenci.getId());	
		tiporadiovenciAsignar.setVersionRow(tiporadiovenci.getVersionRow());	
		tiporadiovenciAsignar.setnombre(tiporadiovenci.getnombre());	
	}
	
	public static void inicializarTipoRadioVenci(TipoRadioVenci tiporadiovenci) throws Exception {
		try {
				tiporadiovenci.setId(0L);	
					
				tiporadiovenci.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoRadioVenci(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRadioVenciConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoRadioVenci(String sTipo,Row row,Workbook workbook,TipoRadioVenci tiporadiovenci,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporadiovenci.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoRadioVenci=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoRadioVenci() {
		return this.sFinalQueryTipoRadioVenci;
	}
	
	public void setsFinalQueryTipoRadioVenci(String sFinalQueryTipoRadioVenci) {
		this.sFinalQueryTipoRadioVenci= sFinalQueryTipoRadioVenci;
	}
	
	public Border resaltarSeleccionarTipoRadioVenci=null;
	
	public Border setResaltarSeleccionarTipoRadioVenci(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRadioVenciBeanSwingJInternalFrame tiporadiovenciBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiporadiovenciBeanSwingJInternalFrame.jTtoolBarTipoRadioVenci.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoRadioVenci= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoRadioVenci() {
		return this.resaltarSeleccionarTipoRadioVenci;
	}
	
	public void setResaltarSeleccionarTipoRadioVenci(Border borderResaltarSeleccionarTipoRadioVenci) {
		this.resaltarSeleccionarTipoRadioVenci= borderResaltarSeleccionarTipoRadioVenci;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoRadioVenci=null;
	public Boolean mostraridTipoRadioVenci=true;
	public Boolean activaridTipoRadioVenci=true;

	public Border resaltarnombreTipoRadioVenci=null;
	public Boolean mostrarnombreTipoRadioVenci=true;
	public Boolean activarnombreTipoRadioVenci=true;

	
	

	public Border setResaltaridTipoRadioVenci(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRadioVenciBeanSwingJInternalFrame tiporadiovenciBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporadiovenciBeanSwingJInternalFrame.jTtoolBarTipoRadioVenci.setBorder(borderResaltar);
		
		this.resaltaridTipoRadioVenci= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoRadioVenci() {
		return this.resaltaridTipoRadioVenci;
	}

	public void setResaltaridTipoRadioVenci(Border borderResaltar) {
		this.resaltaridTipoRadioVenci= borderResaltar;
	}

	public Boolean getMostraridTipoRadioVenci() {
		return this.mostraridTipoRadioVenci;
	}

	public void setMostraridTipoRadioVenci(Boolean mostraridTipoRadioVenci) {
		this.mostraridTipoRadioVenci= mostraridTipoRadioVenci;
	}

	public Boolean getActivaridTipoRadioVenci() {
		return this.activaridTipoRadioVenci;
	}

	public void setActivaridTipoRadioVenci(Boolean activaridTipoRadioVenci) {
		this.activaridTipoRadioVenci= activaridTipoRadioVenci;
	}

	public Border setResaltarnombreTipoRadioVenci(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRadioVenciBeanSwingJInternalFrame tiporadiovenciBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporadiovenciBeanSwingJInternalFrame.jTtoolBarTipoRadioVenci.setBorder(borderResaltar);
		
		this.resaltarnombreTipoRadioVenci= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoRadioVenci() {
		return this.resaltarnombreTipoRadioVenci;
	}

	public void setResaltarnombreTipoRadioVenci(Border borderResaltar) {
		this.resaltarnombreTipoRadioVenci= borderResaltar;
	}

	public Boolean getMostrarnombreTipoRadioVenci() {
		return this.mostrarnombreTipoRadioVenci;
	}

	public void setMostrarnombreTipoRadioVenci(Boolean mostrarnombreTipoRadioVenci) {
		this.mostrarnombreTipoRadioVenci= mostrarnombreTipoRadioVenci;
	}

	public Boolean getActivarnombreTipoRadioVenci() {
		return this.activarnombreTipoRadioVenci;
	}

	public void setActivarnombreTipoRadioVenci(Boolean activarnombreTipoRadioVenci) {
		this.activarnombreTipoRadioVenci= activarnombreTipoRadioVenci;
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
		
		
		this.setMostraridTipoRadioVenci(esInicial);
		this.setMostrarnombreTipoRadioVenci(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRadioVenciConstantesFunciones.ID)) {
				this.setMostraridTipoRadioVenci(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRadioVenciConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoRadioVenci(esAsigna);
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
		
		
		this.setActivaridTipoRadioVenci(esInicial);
		this.setActivarnombreTipoRadioVenci(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRadioVenciConstantesFunciones.ID)) {
				this.setActivaridTipoRadioVenci(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRadioVenciConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoRadioVenci(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRadioVenciBeanSwingJInternalFrame tiporadiovenciBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoRadioVenci(esInicial);
		this.setResaltarnombreTipoRadioVenci(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRadioVenciConstantesFunciones.ID)) {
				this.setResaltaridTipoRadioVenci(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRadioVenciConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoRadioVenci(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarRadioVenciProveTipoRadioVenci=null;

	public Border getResaltarRadioVenciProveTipoRadioVenci() {
		return this.resaltarRadioVenciProveTipoRadioVenci;
	}

	public void setResaltarRadioVenciProveTipoRadioVenci(Border borderResaltarRadioVenciProve) {
		if(borderResaltarRadioVenciProve!=null) {
			this.resaltarRadioVenciProveTipoRadioVenci= borderResaltarRadioVenciProve;
		}
	}

	public Border setResaltarRadioVenciProveTipoRadioVenci(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRadioVenciBeanSwingJInternalFrame tiporadiovenciBeanSwingJInternalFrame*/) {
		Border borderResaltarRadioVenciProve=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tiporadiovenciBeanSwingJInternalFrame.jTtoolBarTipoRadioVenci.setBorder(borderResaltarRadioVenciProve);
			
		this.resaltarRadioVenciProveTipoRadioVenci= borderResaltarRadioVenciProve;

		 return borderResaltarRadioVenciProve;
	}



	public Boolean mostrarRadioVenciProveTipoRadioVenci=true;

	public Boolean getMostrarRadioVenciProveTipoRadioVenci() {
		return this.mostrarRadioVenciProveTipoRadioVenci;
	}

	public void setMostrarRadioVenciProveTipoRadioVenci(Boolean visibilidadResaltarRadioVenciProve) {
		this.mostrarRadioVenciProveTipoRadioVenci= visibilidadResaltarRadioVenciProve;
	}



	public Boolean activarRadioVenciProveTipoRadioVenci=true;

	public Boolean gethabilitarResaltarRadioVenciProveTipoRadioVenci() {
		return this.activarRadioVenciProveTipoRadioVenci;
	}

	public void setActivarRadioVenciProveTipoRadioVenci(Boolean habilitarResaltarRadioVenciProve) {
		this.activarRadioVenciProveTipoRadioVenci= habilitarResaltarRadioVenciProve;
	}


	public Border resaltarRadioVenciClienteProveTipoRadioVenci=null;

	public Border getResaltarRadioVenciClienteProveTipoRadioVenci() {
		return this.resaltarRadioVenciClienteProveTipoRadioVenci;
	}

	public void setResaltarRadioVenciClienteProveTipoRadioVenci(Border borderResaltarRadioVenciClienteProve) {
		if(borderResaltarRadioVenciClienteProve!=null) {
			this.resaltarRadioVenciClienteProveTipoRadioVenci= borderResaltarRadioVenciClienteProve;
		}
	}

	public Border setResaltarRadioVenciClienteProveTipoRadioVenci(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRadioVenciBeanSwingJInternalFrame tiporadiovenciBeanSwingJInternalFrame*/) {
		Border borderResaltarRadioVenciClienteProve=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tiporadiovenciBeanSwingJInternalFrame.jTtoolBarTipoRadioVenci.setBorder(borderResaltarRadioVenciClienteProve);
			
		this.resaltarRadioVenciClienteProveTipoRadioVenci= borderResaltarRadioVenciClienteProve;

		 return borderResaltarRadioVenciClienteProve;
	}



	public Boolean mostrarRadioVenciClienteProveTipoRadioVenci=true;

	public Boolean getMostrarRadioVenciClienteProveTipoRadioVenci() {
		return this.mostrarRadioVenciClienteProveTipoRadioVenci;
	}

	public void setMostrarRadioVenciClienteProveTipoRadioVenci(Boolean visibilidadResaltarRadioVenciClienteProve) {
		this.mostrarRadioVenciClienteProveTipoRadioVenci= visibilidadResaltarRadioVenciClienteProve;
	}



	public Boolean activarRadioVenciClienteProveTipoRadioVenci=true;

	public Boolean gethabilitarResaltarRadioVenciClienteProveTipoRadioVenci() {
		return this.activarRadioVenciClienteProveTipoRadioVenci;
	}

	public void setActivarRadioVenciClienteProveTipoRadioVenci(Boolean habilitarResaltarRadioVenciClienteProve) {
		this.activarRadioVenciClienteProveTipoRadioVenci= habilitarResaltarRadioVenciClienteProve;
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

		this.setMostrarRadioVenciProveTipoRadioVenci(esInicial);
		this.setMostrarRadioVenciClienteProveTipoRadioVenci(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RadioVenciProve.class)) {
				this.setMostrarRadioVenciProveTipoRadioVenci(esAsigna);
				continue;
			}

			if(clase.clas.equals(RadioVenciClienteProve.class)) {
				this.setMostrarRadioVenciClienteProveTipoRadioVenci(esAsigna);
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

		this.setActivarRadioVenciProveTipoRadioVenci(esInicial);
		this.setActivarRadioVenciClienteProveTipoRadioVenci(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RadioVenciProve.class)) {
				this.setActivarRadioVenciProveTipoRadioVenci(esAsigna);
				continue;
			}

			if(clase.clas.equals(RadioVenciClienteProve.class)) {
				this.setActivarRadioVenciClienteProveTipoRadioVenci(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRadioVenciBeanSwingJInternalFrame tiporadiovenciBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarRadioVenciProveTipoRadioVenci(esInicial);
		this.setResaltarRadioVenciClienteProveTipoRadioVenci(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RadioVenciProve.class)) {
				this.setResaltarRadioVenciProveTipoRadioVenci(esAsigna);
				continue;
			}

			if(clase.clas.equals(RadioVenciClienteProve.class)) {
				this.setResaltarRadioVenciClienteProveTipoRadioVenci(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}