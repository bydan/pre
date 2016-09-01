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


import com.bydan.erp.contabilidad.util.PresuEstadoConstantesFunciones;
import com.bydan.erp.contabilidad.util.PresuEstadoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.PresuEstadoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PresuEstadoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="PresuEstado";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PresuEstado"+PresuEstadoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PresuEstadoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PresuEstadoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PresuEstadoConstantesFunciones.SCHEMA+"_"+PresuEstadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PresuEstadoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PresuEstadoConstantesFunciones.SCHEMA+"_"+PresuEstadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PresuEstadoConstantesFunciones.SCHEMA+"_"+PresuEstadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PresuEstadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PresuEstadoConstantesFunciones.SCHEMA+"_"+PresuEstadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuEstadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresuEstadoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuEstadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuEstadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresuEstadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuEstadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PresuEstadoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PresuEstadoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PresuEstadoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PresuEstadoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado";
	public static final String SCLASSWEBTITULO_LOWER="Presu Estado";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PresuEstado";
	public static final String OBJECTNAME="presuestado";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="presu_estado";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select presuestado from "+PresuEstadoConstantesFunciones.SPERSISTENCENAME+" presuestado";
	public static String QUERYSELECTNATIVE="select "+PresuEstadoConstantesFunciones.SCHEMA+"."+PresuEstadoConstantesFunciones.TABLENAME+".id,"+PresuEstadoConstantesFunciones.SCHEMA+"."+PresuEstadoConstantesFunciones.TABLENAME+".version_row,"+PresuEstadoConstantesFunciones.SCHEMA+"."+PresuEstadoConstantesFunciones.TABLENAME+".nombre from "+PresuEstadoConstantesFunciones.SCHEMA+"."+PresuEstadoConstantesFunciones.TABLENAME;//+" as "+PresuEstadoConstantesFunciones.TABLENAME;
	
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
	
	public static String getPresuEstadoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PresuEstadoConstantesFunciones.NOMBRE)) {sLabelColumna=PresuEstadoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getPresuEstadoDescripcion(PresuEstado presuestado) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(presuestado !=null/* && presuestado.getId()!=0*/) {
			sDescripcion=presuestado.getnombre();//presuestadopresuestado.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPresuEstadoDescripcionDetallado(PresuEstado presuestado) {
		String sDescripcion="";
			
		sDescripcion+=PresuEstadoConstantesFunciones.ID+"=";
		sDescripcion+=presuestado.getId().toString()+",";
		sDescripcion+=PresuEstadoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=presuestado.getVersionRow().toString()+",";
		sDescripcion+=PresuEstadoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=presuestado.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setPresuEstadoDescripcion(PresuEstado presuestado,String sValor) throws Exception {			
		if(presuestado !=null) {
			presuestado.setnombre(sValor);//presuestadopresuestado.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosPresuEstado(PresuEstado presuestado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		presuestado.setnombre(presuestado.getnombre().trim());
	}
	
	public static void quitarEspaciosPresuEstados(List<PresuEstado> presuestados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PresuEstado presuestado: presuestados) {
			presuestado.setnombre(presuestado.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresuEstado(PresuEstado presuestado,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && presuestado.getConCambioAuxiliar()) {
			presuestado.setIsDeleted(presuestado.getIsDeletedAuxiliar());	
			presuestado.setIsNew(presuestado.getIsNewAuxiliar());	
			presuestado.setIsChanged(presuestado.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			presuestado.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			presuestado.setIsDeletedAuxiliar(false);	
			presuestado.setIsNewAuxiliar(false);	
			presuestado.setIsChangedAuxiliar(false);
			
			presuestado.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresuEstados(List<PresuEstado> presuestados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PresuEstado presuestado : presuestados) {
			if(conAsignarBase && presuestado.getConCambioAuxiliar()) {
				presuestado.setIsDeleted(presuestado.getIsDeletedAuxiliar());	
				presuestado.setIsNew(presuestado.getIsNewAuxiliar());	
				presuestado.setIsChanged(presuestado.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				presuestado.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				presuestado.setIsDeletedAuxiliar(false);	
				presuestado.setIsNewAuxiliar(false);	
				presuestado.setIsChangedAuxiliar(false);
				
				presuestado.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPresuEstado(PresuEstado presuestado,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPresuEstados(List<PresuEstado> presuestados,Boolean conEnteros) throws Exception  {
		
		for(PresuEstado presuestado: presuestados) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPresuEstado(List<PresuEstado> presuestados,PresuEstado presuestadoAux) throws Exception  {
		PresuEstadoConstantesFunciones.InicializarValoresPresuEstado(presuestadoAux,true);
		
		for(PresuEstado presuestado: presuestados) {
			if(presuestado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPresuEstado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PresuEstadoConstantesFunciones.getArrayColumnasGlobalesPresuEstado(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPresuEstado(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPresuEstado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PresuEstado> presuestados,PresuEstado presuestado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PresuEstado presuestadoAux: presuestados) {
			if(presuestadoAux!=null && presuestado!=null) {
				if((presuestadoAux.getId()==null && presuestado.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(presuestadoAux.getId()!=null && presuestado.getId()!=null){
					if(presuestadoAux.getId().equals(presuestado.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPresuEstado(List<PresuEstado> presuestados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PresuEstado presuestado: presuestados) {			
			if(presuestado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPresuEstado() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PresuEstadoConstantesFunciones.LABEL_ID, PresuEstadoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuEstadoConstantesFunciones.LABEL_VERSIONROW, PresuEstadoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuEstadoConstantesFunciones.LABEL_NOMBRE, PresuEstadoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPresuEstado() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PresuEstadoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuEstadoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuEstadoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresuEstado() throws Exception  {
		return PresuEstadoConstantesFunciones.getTiposSeleccionarPresuEstado(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresuEstado(Boolean conFk) throws Exception  {
		return PresuEstadoConstantesFunciones.getTiposSeleccionarPresuEstado(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresuEstado(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuEstadoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(PresuEstadoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPresuEstado(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPresuEstado(PresuEstado presuestadoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesPresuEstado(List<PresuEstado> presuestadosTemp) throws Exception {
		for(PresuEstado presuestadoAux:presuestadosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPresuEstado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPresuEstado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresuEstado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresuEstadoConstantesFunciones.getClassesRelationshipsOfPresuEstado(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresuEstado(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresuEstado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresuEstadoConstantesFunciones.getClassesRelationshipsFromStringsOfPresuEstado(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresuEstado(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PresuEstado presuestado,List<PresuEstado> presuestados,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PresuEstado presuestadoEncontrado=null;
			
			for(PresuEstado presuestadoLocal:presuestados) {
				if(presuestadoLocal.getId().equals(presuestado.getId())) {
					presuestadoEncontrado=presuestadoLocal;
					
					presuestadoLocal.setIsChanged(presuestado.getIsChanged());
					presuestadoLocal.setIsNew(presuestado.getIsNew());
					presuestadoLocal.setIsDeleted(presuestado.getIsDeleted());
					
					presuestadoLocal.setGeneralEntityOriginal(presuestado.getGeneralEntityOriginal());
					
					presuestadoLocal.setId(presuestado.getId());	
					presuestadoLocal.setVersionRow(presuestado.getVersionRow());	
					presuestadoLocal.setnombre(presuestado.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!presuestado.getIsDeleted()) {
				if(!existe) {
					presuestados.add(presuestado);
				}
			} else {
				if(presuestadoEncontrado!=null && permiteQuitar)  {
					presuestados.remove(presuestadoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PresuEstado presuestado,List<PresuEstado> presuestados) throws Exception {
		try	{			
			for(PresuEstado presuestadoLocal:presuestados) {
				if(presuestadoLocal.getId().equals(presuestado.getId())) {
					presuestadoLocal.setIsSelected(presuestado.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPresuEstado(List<PresuEstado> presuestadosAux) throws Exception {
		//this.presuestadosAux=presuestadosAux;
		
		for(PresuEstado presuestadoAux:presuestadosAux) {
			if(presuestadoAux.getIsChanged()) {
				presuestadoAux.setIsChanged(false);
			}		
			
			if(presuestadoAux.getIsNew()) {
				presuestadoAux.setIsNew(false);
			}	
			
			if(presuestadoAux.getIsDeleted()) {
				presuestadoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPresuEstado(PresuEstado presuestadoAux) throws Exception {
		//this.presuestadoAux=presuestadoAux;
		
			if(presuestadoAux.getIsChanged()) {
				presuestadoAux.setIsChanged(false);
			}		
			
			if(presuestadoAux.getIsNew()) {
				presuestadoAux.setIsNew(false);
			}	
			
			if(presuestadoAux.getIsDeleted()) {
				presuestadoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PresuEstado presuestadoAsignar,PresuEstado presuestado) throws Exception {
		presuestadoAsignar.setId(presuestado.getId());	
		presuestadoAsignar.setVersionRow(presuestado.getVersionRow());	
		presuestadoAsignar.setnombre(presuestado.getnombre());	
	}
	
	public static void inicializarPresuEstado(PresuEstado presuestado) throws Exception {
		try {
				presuestado.setId(0L);	
					
				presuestado.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPresuEstado(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuEstadoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPresuEstado(String sTipo,Row row,Workbook workbook,PresuEstado presuestado,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(presuestado.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPresuEstado=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPresuEstado() {
		return this.sFinalQueryPresuEstado;
	}
	
	public void setsFinalQueryPresuEstado(String sFinalQueryPresuEstado) {
		this.sFinalQueryPresuEstado= sFinalQueryPresuEstado;
	}
	
	public Border resaltarSeleccionarPresuEstado=null;
	
	public Border setResaltarSeleccionarPresuEstado(ParametroGeneralUsuario parametroGeneralUsuario/*PresuEstadoBeanSwingJInternalFrame presuestadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//presuestadoBeanSwingJInternalFrame.jTtoolBarPresuEstado.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPresuEstado= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPresuEstado() {
		return this.resaltarSeleccionarPresuEstado;
	}
	
	public void setResaltarSeleccionarPresuEstado(Border borderResaltarSeleccionarPresuEstado) {
		this.resaltarSeleccionarPresuEstado= borderResaltarSeleccionarPresuEstado;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPresuEstado=null;
	public Boolean mostraridPresuEstado=true;
	public Boolean activaridPresuEstado=true;

	public Border resaltarnombrePresuEstado=null;
	public Boolean mostrarnombrePresuEstado=true;
	public Boolean activarnombrePresuEstado=true;

	
	

	public Border setResaltaridPresuEstado(ParametroGeneralUsuario parametroGeneralUsuario/*PresuEstadoBeanSwingJInternalFrame presuestadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuestadoBeanSwingJInternalFrame.jTtoolBarPresuEstado.setBorder(borderResaltar);
		
		this.resaltaridPresuEstado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPresuEstado() {
		return this.resaltaridPresuEstado;
	}

	public void setResaltaridPresuEstado(Border borderResaltar) {
		this.resaltaridPresuEstado= borderResaltar;
	}

	public Boolean getMostraridPresuEstado() {
		return this.mostraridPresuEstado;
	}

	public void setMostraridPresuEstado(Boolean mostraridPresuEstado) {
		this.mostraridPresuEstado= mostraridPresuEstado;
	}

	public Boolean getActivaridPresuEstado() {
		return this.activaridPresuEstado;
	}

	public void setActivaridPresuEstado(Boolean activaridPresuEstado) {
		this.activaridPresuEstado= activaridPresuEstado;
	}

	public Border setResaltarnombrePresuEstado(ParametroGeneralUsuario parametroGeneralUsuario/*PresuEstadoBeanSwingJInternalFrame presuestadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuestadoBeanSwingJInternalFrame.jTtoolBarPresuEstado.setBorder(borderResaltar);
		
		this.resaltarnombrePresuEstado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombrePresuEstado() {
		return this.resaltarnombrePresuEstado;
	}

	public void setResaltarnombrePresuEstado(Border borderResaltar) {
		this.resaltarnombrePresuEstado= borderResaltar;
	}

	public Boolean getMostrarnombrePresuEstado() {
		return this.mostrarnombrePresuEstado;
	}

	public void setMostrarnombrePresuEstado(Boolean mostrarnombrePresuEstado) {
		this.mostrarnombrePresuEstado= mostrarnombrePresuEstado;
	}

	public Boolean getActivarnombrePresuEstado() {
		return this.activarnombrePresuEstado;
	}

	public void setActivarnombrePresuEstado(Boolean activarnombrePresuEstado) {
		this.activarnombrePresuEstado= activarnombrePresuEstado;
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
		
		
		this.setMostraridPresuEstado(esInicial);
		this.setMostrarnombrePresuEstado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresuEstadoConstantesFunciones.ID)) {
				this.setMostraridPresuEstado(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuEstadoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombrePresuEstado(esAsigna);
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
		
		
		this.setActivaridPresuEstado(esInicial);
		this.setActivarnombrePresuEstado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresuEstadoConstantesFunciones.ID)) {
				this.setActivaridPresuEstado(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuEstadoConstantesFunciones.NOMBRE)) {
				this.setActivarnombrePresuEstado(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PresuEstadoBeanSwingJInternalFrame presuestadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPresuEstado(esInicial);
		this.setResaltarnombrePresuEstado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresuEstadoConstantesFunciones.ID)) {
				this.setResaltaridPresuEstado(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuEstadoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombrePresuEstado(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PresuEstadoBeanSwingJInternalFrame presuestadoBeanSwingJInternalFrame*/)throws Exception {	
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