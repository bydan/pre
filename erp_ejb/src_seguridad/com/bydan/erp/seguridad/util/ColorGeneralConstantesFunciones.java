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


import com.bydan.erp.seguridad.util.ColorGeneralConstantesFunciones;
import com.bydan.erp.seguridad.util.ColorGeneralParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.ColorGeneralParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;



import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ColorGeneralConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ColorGeneral";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ColorGeneral"+ColorGeneralConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ColorGeneralHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ColorGeneralHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ColorGeneralConstantesFunciones.SCHEMA+"_"+ColorGeneralConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ColorGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ColorGeneralConstantesFunciones.SCHEMA+"_"+ColorGeneralConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ColorGeneralConstantesFunciones.SCHEMA+"_"+ColorGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ColorGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ColorGeneralConstantesFunciones.SCHEMA+"_"+ColorGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ColorGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ColorGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ColorGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ColorGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ColorGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ColorGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ColorGeneralConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ColorGeneralConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ColorGeneralConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ColorGeneralConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Colores";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Color";
	public static final String SCLASSWEBTITULO_LOWER="Color General";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ColorGeneral";
	public static final String OBJECTNAME="colorgeneral";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="color_general";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select colorgeneral from "+ColorGeneralConstantesFunciones.SPERSISTENCENAME+" colorgeneral";
	public static String QUERYSELECTNATIVE="select "+ColorGeneralConstantesFunciones.SCHEMA+"."+ColorGeneralConstantesFunciones.TABLENAME+".id,"+ColorGeneralConstantesFunciones.SCHEMA+"."+ColorGeneralConstantesFunciones.TABLENAME+".version_row,"+ColorGeneralConstantesFunciones.SCHEMA+"."+ColorGeneralConstantesFunciones.TABLENAME+".nombre from "+ColorGeneralConstantesFunciones.SCHEMA+"."+ColorGeneralConstantesFunciones.TABLENAME;//+" as "+ColorGeneralConstantesFunciones.TABLENAME;
	
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
	
	public static String getColorGeneralLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ColorGeneralConstantesFunciones.NOMBRE)) {sLabelColumna=ColorGeneralConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getColorGeneralDescripcion(ColorGeneral colorgeneral) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(colorgeneral !=null/* && colorgeneral.getId()!=0*/) {
			sDescripcion=colorgeneral.getnombre();//colorgeneralcolorgeneral.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getColorGeneralDescripcionDetallado(ColorGeneral colorgeneral) {
		String sDescripcion="";
			
		sDescripcion+=ColorGeneralConstantesFunciones.ID+"=";
		sDescripcion+=colorgeneral.getId().toString()+",";
		sDescripcion+=ColorGeneralConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=colorgeneral.getVersionRow().toString()+",";
		sDescripcion+=ColorGeneralConstantesFunciones.NOMBRE+"=";
		sDescripcion+=colorgeneral.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setColorGeneralDescripcion(ColorGeneral colorgeneral,String sValor) throws Exception {			
		if(colorgeneral !=null) {
			colorgeneral.setnombre(sValor);;//colorgeneralcolorgeneral.getnombre().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
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
	
	
	
	
	
	
	public static void quitarEspaciosColorGeneral(ColorGeneral colorgeneral,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		colorgeneral.setnombre(colorgeneral.getnombre().trim());
	}
	
	public static void quitarEspaciosColorGenerals(List<ColorGeneral> colorgenerals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ColorGeneral colorgeneral: colorgenerals) {
			colorgeneral.setnombre(colorgeneral.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresColorGeneral(ColorGeneral colorgeneral,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && colorgeneral.getConCambioAuxiliar()) {
			colorgeneral.setIsDeleted(colorgeneral.getIsDeletedAuxiliar());	
			colorgeneral.setIsNew(colorgeneral.getIsNewAuxiliar());	
			colorgeneral.setIsChanged(colorgeneral.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			colorgeneral.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			colorgeneral.setIsDeletedAuxiliar(false);	
			colorgeneral.setIsNewAuxiliar(false);	
			colorgeneral.setIsChangedAuxiliar(false);
			
			colorgeneral.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresColorGenerals(List<ColorGeneral> colorgenerals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ColorGeneral colorgeneral : colorgenerals) {
			if(conAsignarBase && colorgeneral.getConCambioAuxiliar()) {
				colorgeneral.setIsDeleted(colorgeneral.getIsDeletedAuxiliar());	
				colorgeneral.setIsNew(colorgeneral.getIsNewAuxiliar());	
				colorgeneral.setIsChanged(colorgeneral.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				colorgeneral.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				colorgeneral.setIsDeletedAuxiliar(false);	
				colorgeneral.setIsNewAuxiliar(false);	
				colorgeneral.setIsChangedAuxiliar(false);
				
				colorgeneral.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresColorGeneral(ColorGeneral colorgeneral,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresColorGenerals(List<ColorGeneral> colorgenerals,Boolean conEnteros) throws Exception  {
		
		for(ColorGeneral colorgeneral: colorgenerals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaColorGeneral(List<ColorGeneral> colorgenerals,ColorGeneral colorgeneralAux) throws Exception  {
		ColorGeneralConstantesFunciones.InicializarValoresColorGeneral(colorgeneralAux,true);
		
		for(ColorGeneral colorgeneral: colorgenerals) {
			if(colorgeneral.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesColorGeneral(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ColorGeneralConstantesFunciones.getArrayColumnasGlobalesColorGeneral(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesColorGeneral(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoColorGeneral(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ColorGeneral> colorgenerals,ColorGeneral colorgeneral,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ColorGeneral colorgeneralAux: colorgenerals) {
			if(colorgeneralAux!=null && colorgeneral!=null) {
				if((colorgeneralAux.getId()==null && colorgeneral.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(colorgeneralAux.getId()!=null && colorgeneral.getId()!=null){
					if(colorgeneralAux.getId().equals(colorgeneral.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaColorGeneral(List<ColorGeneral> colorgenerals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ColorGeneral colorgeneral: colorgenerals) {			
			if(colorgeneral.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaColorGeneral() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ColorGeneralConstantesFunciones.LABEL_ID, ColorGeneralConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ColorGeneralConstantesFunciones.LABEL_VERSIONROW, ColorGeneralConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ColorGeneralConstantesFunciones.LABEL_NOMBRE, ColorGeneralConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasColorGeneral() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ColorGeneralConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ColorGeneralConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ColorGeneralConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarColorGeneral() throws Exception  {
		return ColorGeneralConstantesFunciones.getTiposSeleccionarColorGeneral(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarColorGeneral(Boolean conFk) throws Exception  {
		return ColorGeneralConstantesFunciones.getTiposSeleccionarColorGeneral(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarColorGeneral(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ColorGeneralConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ColorGeneralConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesColorGeneral(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesColorGeneral(ColorGeneral colorgeneralAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesColorGeneral(List<ColorGeneral> colorgeneralsTemp) throws Exception {
		for(ColorGeneral colorgeneralAux:colorgeneralsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfColorGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfColorGeneral(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfColorGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ColorGeneralConstantesFunciones.getClassesRelationshipsOfColorGeneral(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfColorGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfColorGeneral(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ColorGeneralConstantesFunciones.getClassesRelationshipsFromStringsOfColorGeneral(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfColorGeneral(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ColorGeneral colorgeneral,List<ColorGeneral> colorgenerals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ColorGeneral colorgeneralEncontrado=null;
			
			for(ColorGeneral colorgeneralLocal:colorgenerals) {
				if(colorgeneralLocal.getId().equals(colorgeneral.getId())) {
					colorgeneralEncontrado=colorgeneralLocal;
					
					colorgeneralLocal.setIsChanged(colorgeneral.getIsChanged());
					colorgeneralLocal.setIsNew(colorgeneral.getIsNew());
					colorgeneralLocal.setIsDeleted(colorgeneral.getIsDeleted());
					
					colorgeneralLocal.setGeneralEntityOriginal(colorgeneral.getGeneralEntityOriginal());
					
					colorgeneralLocal.setId(colorgeneral.getId());	
					colorgeneralLocal.setVersionRow(colorgeneral.getVersionRow());	
					colorgeneralLocal.setnombre(colorgeneral.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!colorgeneral.getIsDeleted()) {
				if(!existe) {
					colorgenerals.add(colorgeneral);
				}
			} else {
				if(colorgeneralEncontrado!=null && permiteQuitar)  {
					colorgenerals.remove(colorgeneralEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ColorGeneral colorgeneral,List<ColorGeneral> colorgenerals) throws Exception {
		try	{			
			for(ColorGeneral colorgeneralLocal:colorgenerals) {
				if(colorgeneralLocal.getId().equals(colorgeneral.getId())) {
					colorgeneralLocal.setIsSelected(colorgeneral.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesColorGeneral(List<ColorGeneral> colorgeneralsAux) throws Exception {
		//this.colorgeneralsAux=colorgeneralsAux;
		
		for(ColorGeneral colorgeneralAux:colorgeneralsAux) {
			if(colorgeneralAux.getIsChanged()) {
				colorgeneralAux.setIsChanged(false);
			}		
			
			if(colorgeneralAux.getIsNew()) {
				colorgeneralAux.setIsNew(false);
			}	
			
			if(colorgeneralAux.getIsDeleted()) {
				colorgeneralAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesColorGeneral(ColorGeneral colorgeneralAux) throws Exception {
		//this.colorgeneralAux=colorgeneralAux;
		
			if(colorgeneralAux.getIsChanged()) {
				colorgeneralAux.setIsChanged(false);
			}		
			
			if(colorgeneralAux.getIsNew()) {
				colorgeneralAux.setIsNew(false);
			}	
			
			if(colorgeneralAux.getIsDeleted()) {
				colorgeneralAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ColorGeneral colorgeneralAsignar,ColorGeneral colorgeneral) throws Exception {
		colorgeneralAsignar.setId(colorgeneral.getId());	
		colorgeneralAsignar.setVersionRow(colorgeneral.getVersionRow());	
		colorgeneralAsignar.setnombre(colorgeneral.getnombre());	
	}
	
	public static void inicializarColorGeneral(ColorGeneral colorgeneral) throws Exception {
		try {
				colorgeneral.setId(0L);	
					
				colorgeneral.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderColorGeneral(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ColorGeneralConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataColorGeneral(String sTipo,Row row,Workbook workbook,ColorGeneral colorgeneral,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(colorgeneral.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryColorGeneral=Constantes.SFINALQUERY;
	
	public String getsFinalQueryColorGeneral() {
		return this.sFinalQueryColorGeneral;
	}
	
	public void setsFinalQueryColorGeneral(String sFinalQueryColorGeneral) {
		this.sFinalQueryColorGeneral= sFinalQueryColorGeneral;
	}
	
	public Border resaltarSeleccionarColorGeneral=null;
	
	public Border setResaltarSeleccionarColorGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ColorGeneralBeanSwingJInternalFrame colorgeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//colorgeneralBeanSwingJInternalFrame.jTtoolBarColorGeneral.setBorder(borderResaltar);
		
		this.resaltarSeleccionarColorGeneral= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarColorGeneral() {
		return this.resaltarSeleccionarColorGeneral;
	}
	
	public void setResaltarSeleccionarColorGeneral(Border borderResaltarSeleccionarColorGeneral) {
		this.resaltarSeleccionarColorGeneral= borderResaltarSeleccionarColorGeneral;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridColorGeneral=null;
	public Boolean mostraridColorGeneral=true;
	public Boolean activaridColorGeneral=true;

	public Border resaltarnombreColorGeneral=null;
	public Boolean mostrarnombreColorGeneral=true;
	public Boolean activarnombreColorGeneral=true;

	
	

	public Border setResaltaridColorGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ColorGeneralBeanSwingJInternalFrame colorgeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//colorgeneralBeanSwingJInternalFrame.jTtoolBarColorGeneral.setBorder(borderResaltar);
		
		this.resaltaridColorGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridColorGeneral() {
		return this.resaltaridColorGeneral;
	}

	public void setResaltaridColorGeneral(Border borderResaltar) {
		this.resaltaridColorGeneral= borderResaltar;
	}

	public Boolean getMostraridColorGeneral() {
		return this.mostraridColorGeneral;
	}

	public void setMostraridColorGeneral(Boolean mostraridColorGeneral) {
		this.mostraridColorGeneral= mostraridColorGeneral;
	}

	public Boolean getActivaridColorGeneral() {
		return this.activaridColorGeneral;
	}

	public void setActivaridColorGeneral(Boolean activaridColorGeneral) {
		this.activaridColorGeneral= activaridColorGeneral;
	}

	public Border setResaltarnombreColorGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ColorGeneralBeanSwingJInternalFrame colorgeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//colorgeneralBeanSwingJInternalFrame.jTtoolBarColorGeneral.setBorder(borderResaltar);
		
		this.resaltarnombreColorGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreColorGeneral() {
		return this.resaltarnombreColorGeneral;
	}

	public void setResaltarnombreColorGeneral(Border borderResaltar) {
		this.resaltarnombreColorGeneral= borderResaltar;
	}

	public Boolean getMostrarnombreColorGeneral() {
		return this.mostrarnombreColorGeneral;
	}

	public void setMostrarnombreColorGeneral(Boolean mostrarnombreColorGeneral) {
		this.mostrarnombreColorGeneral= mostrarnombreColorGeneral;
	}

	public Boolean getActivarnombreColorGeneral() {
		return this.activarnombreColorGeneral;
	}

	public void setActivarnombreColorGeneral(Boolean activarnombreColorGeneral) {
		this.activarnombreColorGeneral= activarnombreColorGeneral;
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
		
		
		this.setMostraridColorGeneral(esInicial);
		this.setMostrarnombreColorGeneral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ColorGeneralConstantesFunciones.ID)) {
				this.setMostraridColorGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ColorGeneralConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreColorGeneral(esAsigna);
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
		
		
		this.setActivaridColorGeneral(esInicial);
		this.setActivarnombreColorGeneral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ColorGeneralConstantesFunciones.ID)) {
				this.setActivaridColorGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ColorGeneralConstantesFunciones.NOMBRE)) {
				this.setActivarnombreColorGeneral(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ColorGeneralBeanSwingJInternalFrame colorgeneralBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridColorGeneral(esInicial);
		this.setResaltarnombreColorGeneral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ColorGeneralConstantesFunciones.ID)) {
				this.setResaltaridColorGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ColorGeneralConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreColorGeneral(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ColorGeneralBeanSwingJInternalFrame colorgeneralBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorNombreColorGeneral=true;

	public Boolean getMostrarBusquedaPorNombreColorGeneral() {
		return this.mostrarBusquedaPorNombreColorGeneral;
	}

	public void setMostrarBusquedaPorNombreColorGeneral(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreColorGeneral= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreColorGeneral=true;

	public Boolean getActivarBusquedaPorNombreColorGeneral() {
		return this.activarBusquedaPorNombreColorGeneral;
	}

	public void setActivarBusquedaPorNombreColorGeneral(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreColorGeneral= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreColorGeneral=null;

	public Border getResaltarBusquedaPorNombreColorGeneral() {
		return this.resaltarBusquedaPorNombreColorGeneral;
	}

	public void setResaltarBusquedaPorNombreColorGeneral(Border borderResaltar) {
		this.resaltarBusquedaPorNombreColorGeneral= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreColorGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ColorGeneralBeanSwingJInternalFrame colorgeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreColorGeneral= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}