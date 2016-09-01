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
package com.bydan.erp.nomina.util.report;

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

import com.bydan.erp.nomina.resources.general.AuxiliarGeneral;

import com.bydan.erp.nomina.util.report.ProcesoLiquidacionConstantesFunciones;
import com.bydan.erp.nomina.util.report.ProcesoLiquidacionParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoLiquidacionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.business.entity.report.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesoLiquidacionConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="ProcesoLiquidacion";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoLiquidacion"+ProcesoLiquidacionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoLiquidacionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoLiquidacionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoLiquidacionConstantesFunciones.SCHEMA+"_"+ProcesoLiquidacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoLiquidacionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoLiquidacionConstantesFunciones.SCHEMA+"_"+ProcesoLiquidacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoLiquidacionConstantesFunciones.SCHEMA+"_"+ProcesoLiquidacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoLiquidacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoLiquidacionConstantesFunciones.SCHEMA+"_"+ProcesoLiquidacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoLiquidacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoLiquidacionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoLiquidacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoLiquidacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoLiquidacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoLiquidacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoLiquidacionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoLiquidacionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoLiquidacionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoLiquidacionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Liquidaciones";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Liquidacion";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Liquidacion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoLiquidacion";
	public static final String OBJECTNAME="procesoliquidacion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="proceso_liquidacion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesoliquidacion from "+ProcesoLiquidacionConstantesFunciones.SPERSISTENCENAME+" procesoliquidacion";
	public static String QUERYSELECTNATIVE="select "+ProcesoLiquidacionConstantesFunciones.SCHEMA+"."+ProcesoLiquidacionConstantesFunciones.TABLENAME+".id,"+ProcesoLiquidacionConstantesFunciones.SCHEMA+"."+ProcesoLiquidacionConstantesFunciones.TABLENAME+".version_row,"+ProcesoLiquidacionConstantesFunciones.SCHEMA+"."+ProcesoLiquidacionConstantesFunciones.TABLENAME+".fecha,"+ProcesoLiquidacionConstantesFunciones.SCHEMA+"."+ProcesoLiquidacionConstantesFunciones.TABLENAME+".es_reversar from "+ProcesoLiquidacionConstantesFunciones.SCHEMA+"."+ProcesoLiquidacionConstantesFunciones.TABLENAME;//+" as "+ProcesoLiquidacionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String FECHA= "fecha";
    public static final String ESREVERSAR= "es_reversar";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_ESREVERSAR= "Es Reversar";
		public static final String LABEL_ESREVERSAR_LOWER= "Es Reversar";
	
		
		
		
		
	
	public static String getProcesoLiquidacionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoLiquidacionConstantesFunciones.FECHA)) {sLabelColumna=ProcesoLiquidacionConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ProcesoLiquidacionConstantesFunciones.ESREVERSAR)) {sLabelColumna=ProcesoLiquidacionConstantesFunciones.LABEL_ESREVERSAR;}
		
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
	
	
	
			
			
			
		
	public static String getes_reversarDescripcion(ProcesoLiquidacion procesoliquidacion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!procesoliquidacion.getes_reversar()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_reversarHtmlDescripcion(ProcesoLiquidacion procesoliquidacion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(procesoliquidacion.getId(),procesoliquidacion.getes_reversar());

		return sDescripcion;
	}	
	
	public static String getProcesoLiquidacionDescripcion(ProcesoLiquidacion procesoliquidacion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesoliquidacion !=null/* && procesoliquidacion.getId()!=0*/) {
			sDescripcion=procesoliquidacion.getfecha().toString();//procesoliquidacionprocesoliquidacion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoLiquidacionDescripcionDetallado(ProcesoLiquidacion procesoliquidacion) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoLiquidacionConstantesFunciones.ID+"=";
		sDescripcion+=procesoliquidacion.getId().toString()+",";
		sDescripcion+=ProcesoLiquidacionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesoliquidacion.getVersionRow().toString()+",";
		sDescripcion+=ProcesoLiquidacionConstantesFunciones.FECHA+"=";
		sDescripcion+=procesoliquidacion.getfecha().toString()+",";
		sDescripcion+=ProcesoLiquidacionConstantesFunciones.ESREVERSAR+"=";
		sDescripcion+=procesoliquidacion.getes_reversar().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoLiquidacionDescripcion(ProcesoLiquidacion procesoliquidacion,String sValor) throws Exception {			
		if(procesoliquidacion !=null) {
			//procesoliquidacionprocesoliquidacion.getId().toString();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesoLiquidacion")) {
			sNombreIndice="Tipo=  Por Fecha Por Es Reversar";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesoLiquidacion(Date fecha,Boolean es_reversar) {
		String sDetalleIndice=" Parametros->";
		if(fecha!=null) {sDetalleIndice+=" Fecha="+fecha.toString();}
		if(es_reversar!=null) {sDetalleIndice+=" Es Reversar="+es_reversar.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoLiquidacion(ProcesoLiquidacion procesoliquidacion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoLiquidacions(List<ProcesoLiquidacion> procesoliquidacions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoLiquidacion procesoliquidacion: procesoliquidacions) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoLiquidacion(ProcesoLiquidacion procesoliquidacion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesoliquidacion.getConCambioAuxiliar()) {
			procesoliquidacion.setIsDeleted(procesoliquidacion.getIsDeletedAuxiliar());	
			procesoliquidacion.setIsNew(procesoliquidacion.getIsNewAuxiliar());	
			procesoliquidacion.setIsChanged(procesoliquidacion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesoliquidacion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesoliquidacion.setIsDeletedAuxiliar(false);	
			procesoliquidacion.setIsNewAuxiliar(false);	
			procesoliquidacion.setIsChangedAuxiliar(false);
			
			procesoliquidacion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoLiquidacions(List<ProcesoLiquidacion> procesoliquidacions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoLiquidacion procesoliquidacion : procesoliquidacions) {
			if(conAsignarBase && procesoliquidacion.getConCambioAuxiliar()) {
				procesoliquidacion.setIsDeleted(procesoliquidacion.getIsDeletedAuxiliar());	
				procesoliquidacion.setIsNew(procesoliquidacion.getIsNewAuxiliar());	
				procesoliquidacion.setIsChanged(procesoliquidacion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesoliquidacion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesoliquidacion.setIsDeletedAuxiliar(false);	
				procesoliquidacion.setIsNewAuxiliar(false);	
				procesoliquidacion.setIsChangedAuxiliar(false);
				
				procesoliquidacion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoLiquidacion(ProcesoLiquidacion procesoliquidacion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoLiquidacions(List<ProcesoLiquidacion> procesoliquidacions,Boolean conEnteros) throws Exception  {
		
		for(ProcesoLiquidacion procesoliquidacion: procesoliquidacions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoLiquidacion(List<ProcesoLiquidacion> procesoliquidacions,ProcesoLiquidacion procesoliquidacionAux) throws Exception  {
		ProcesoLiquidacionConstantesFunciones.InicializarValoresProcesoLiquidacion(procesoliquidacionAux,true);
		
		for(ProcesoLiquidacion procesoliquidacion: procesoliquidacions) {
			if(procesoliquidacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoLiquidacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoLiquidacionConstantesFunciones.getArrayColumnasGlobalesProcesoLiquidacion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoLiquidacion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoLiquidacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoLiquidacion> procesoliquidacions,ProcesoLiquidacion procesoliquidacion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoLiquidacion procesoliquidacionAux: procesoliquidacions) {
			if(procesoliquidacionAux!=null && procesoliquidacion!=null) {
				if((procesoliquidacionAux.getId()==null && procesoliquidacion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesoliquidacionAux.getId()!=null && procesoliquidacion.getId()!=null){
					if(procesoliquidacionAux.getId().equals(procesoliquidacion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoLiquidacion(List<ProcesoLiquidacion> procesoliquidacions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoLiquidacion procesoliquidacion: procesoliquidacions) {			
			if(procesoliquidacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoLiquidacion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoLiquidacion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoLiquidacion() throws Exception  {
		return ProcesoLiquidacionConstantesFunciones.getTiposSeleccionarProcesoLiquidacion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoLiquidacion(Boolean conFk) throws Exception  {
		return ProcesoLiquidacionConstantesFunciones.getTiposSeleccionarProcesoLiquidacion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoLiquidacion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoLiquidacionConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ProcesoLiquidacionConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoLiquidacionConstantesFunciones.LABEL_ESREVERSAR);
			reporte.setsDescripcion(ProcesoLiquidacionConstantesFunciones.LABEL_ESREVERSAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoLiquidacion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoLiquidacion(ProcesoLiquidacion procesoliquidacionAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoLiquidacion(List<ProcesoLiquidacion> procesoliquidacionsTemp) throws Exception {
		for(ProcesoLiquidacion procesoliquidacionAux:procesoliquidacionsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoLiquidacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoLiquidacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoLiquidacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoLiquidacionConstantesFunciones.getClassesRelationshipsOfProcesoLiquidacion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoLiquidacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoLiquidacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoLiquidacionConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoLiquidacion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoLiquidacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(ProcesoLiquidacion procesoliquidacion,List<ProcesoLiquidacion> procesoliquidacions,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoLiquidacion procesoliquidacion,List<ProcesoLiquidacion> procesoliquidacions) throws Exception {
		try	{			
			for(ProcesoLiquidacion procesoliquidacionLocal:procesoliquidacions) {
				if(procesoliquidacionLocal.getId().equals(procesoliquidacion.getId())) {
					procesoliquidacionLocal.setIsSelected(procesoliquidacion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoLiquidacion(List<ProcesoLiquidacion> procesoliquidacionsAux) throws Exception {
		//this.procesoliquidacionsAux=procesoliquidacionsAux;
		
		for(ProcesoLiquidacion procesoliquidacionAux:procesoliquidacionsAux) {
			if(procesoliquidacionAux.getIsChanged()) {
				procesoliquidacionAux.setIsChanged(false);
			}		
			
			if(procesoliquidacionAux.getIsNew()) {
				procesoliquidacionAux.setIsNew(false);
			}	
			
			if(procesoliquidacionAux.getIsDeleted()) {
				procesoliquidacionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoLiquidacion(ProcesoLiquidacion procesoliquidacionAux) throws Exception {
		//this.procesoliquidacionAux=procesoliquidacionAux;
		
			if(procesoliquidacionAux.getIsChanged()) {
				procesoliquidacionAux.setIsChanged(false);
			}		
			
			if(procesoliquidacionAux.getIsNew()) {
				procesoliquidacionAux.setIsNew(false);
			}	
			
			if(procesoliquidacionAux.getIsDeleted()) {
				procesoliquidacionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoLiquidacion procesoliquidacionAsignar,ProcesoLiquidacion procesoliquidacion) throws Exception {
		procesoliquidacionAsignar.setId(procesoliquidacion.getId());	
		procesoliquidacionAsignar.setVersionRow(procesoliquidacion.getVersionRow());	
		procesoliquidacionAsignar.setfecha(procesoliquidacion.getfecha());	
		procesoliquidacionAsignar.setes_reversar(procesoliquidacion.getes_reversar());	
	}
	
	public static void inicializarProcesoLiquidacion(ProcesoLiquidacion procesoliquidacion) throws Exception {
		try {
				procesoliquidacion.setId(0L);	
					
				procesoliquidacion.setfecha(new Date());	
				procesoliquidacion.setes_reversar(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoLiquidacion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoLiquidacionConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoLiquidacionConstantesFunciones.LABEL_ESREVERSAR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoLiquidacion(String sTipo,Row row,Workbook workbook,ProcesoLiquidacion procesoliquidacion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesoliquidacion.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(procesoliquidacion.getes_reversar()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoLiquidacion="";
	
	public String getsFinalQueryProcesoLiquidacion() {
		return this.sFinalQueryProcesoLiquidacion;
	}
	
	public void setsFinalQueryProcesoLiquidacion(String sFinalQueryProcesoLiquidacion) {
		this.sFinalQueryProcesoLiquidacion= sFinalQueryProcesoLiquidacion;
	}
	
	public Border resaltarSeleccionarProcesoLiquidacion=null;
	
	public Border setResaltarSeleccionarProcesoLiquidacion(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoLiquidacionBeanSwingJInternalFrame procesoliquidacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesoliquidacionBeanSwingJInternalFrame.jTtoolBarProcesoLiquidacion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoLiquidacion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoLiquidacion() {
		return this.resaltarSeleccionarProcesoLiquidacion;
	}
	
	public void setResaltarSeleccionarProcesoLiquidacion(Border borderResaltarSeleccionarProcesoLiquidacion) {
		this.resaltarSeleccionarProcesoLiquidacion= borderResaltarSeleccionarProcesoLiquidacion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoLiquidacion=null;
	public Boolean mostraridProcesoLiquidacion=true;
	public Boolean activaridProcesoLiquidacion=true;

	public Border resaltarfechaProcesoLiquidacion=null;
	public Boolean mostrarfechaProcesoLiquidacion=true;
	public Boolean activarfechaProcesoLiquidacion=true;

	public Border resaltares_reversarProcesoLiquidacion=null;
	public Boolean mostrares_reversarProcesoLiquidacion=true;
	public Boolean activares_reversarProcesoLiquidacion=true;

	
	

	public Border setResaltaridProcesoLiquidacion(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoLiquidacionBeanSwingJInternalFrame procesoliquidacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoliquidacionBeanSwingJInternalFrame.jTtoolBarProcesoLiquidacion.setBorder(borderResaltar);
		
		this.resaltaridProcesoLiquidacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoLiquidacion() {
		return this.resaltaridProcesoLiquidacion;
	}

	public void setResaltaridProcesoLiquidacion(Border borderResaltar) {
		this.resaltaridProcesoLiquidacion= borderResaltar;
	}

	public Boolean getMostraridProcesoLiquidacion() {
		return this.mostraridProcesoLiquidacion;
	}

	public void setMostraridProcesoLiquidacion(Boolean mostraridProcesoLiquidacion) {
		this.mostraridProcesoLiquidacion= mostraridProcesoLiquidacion;
	}

	public Boolean getActivaridProcesoLiquidacion() {
		return this.activaridProcesoLiquidacion;
	}

	public void setActivaridProcesoLiquidacion(Boolean activaridProcesoLiquidacion) {
		this.activaridProcesoLiquidacion= activaridProcesoLiquidacion;
	}

	public Border setResaltarfechaProcesoLiquidacion(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoLiquidacionBeanSwingJInternalFrame procesoliquidacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoliquidacionBeanSwingJInternalFrame.jTtoolBarProcesoLiquidacion.setBorder(borderResaltar);
		
		this.resaltarfechaProcesoLiquidacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaProcesoLiquidacion() {
		return this.resaltarfechaProcesoLiquidacion;
	}

	public void setResaltarfechaProcesoLiquidacion(Border borderResaltar) {
		this.resaltarfechaProcesoLiquidacion= borderResaltar;
	}

	public Boolean getMostrarfechaProcesoLiquidacion() {
		return this.mostrarfechaProcesoLiquidacion;
	}

	public void setMostrarfechaProcesoLiquidacion(Boolean mostrarfechaProcesoLiquidacion) {
		this.mostrarfechaProcesoLiquidacion= mostrarfechaProcesoLiquidacion;
	}

	public Boolean getActivarfechaProcesoLiquidacion() {
		return this.activarfechaProcesoLiquidacion;
	}

	public void setActivarfechaProcesoLiquidacion(Boolean activarfechaProcesoLiquidacion) {
		this.activarfechaProcesoLiquidacion= activarfechaProcesoLiquidacion;
	}

	public Border setResaltares_reversarProcesoLiquidacion(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoLiquidacionBeanSwingJInternalFrame procesoliquidacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoliquidacionBeanSwingJInternalFrame.jTtoolBarProcesoLiquidacion.setBorder(borderResaltar);
		
		this.resaltares_reversarProcesoLiquidacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_reversarProcesoLiquidacion() {
		return this.resaltares_reversarProcesoLiquidacion;
	}

	public void setResaltares_reversarProcesoLiquidacion(Border borderResaltar) {
		this.resaltares_reversarProcesoLiquidacion= borderResaltar;
	}

	public Boolean getMostrares_reversarProcesoLiquidacion() {
		return this.mostrares_reversarProcesoLiquidacion;
	}

	public void setMostrares_reversarProcesoLiquidacion(Boolean mostrares_reversarProcesoLiquidacion) {
		this.mostrares_reversarProcesoLiquidacion= mostrares_reversarProcesoLiquidacion;
	}

	public Boolean getActivares_reversarProcesoLiquidacion() {
		return this.activares_reversarProcesoLiquidacion;
	}

	public void setActivares_reversarProcesoLiquidacion(Boolean activares_reversarProcesoLiquidacion) {
		this.activares_reversarProcesoLiquidacion= activares_reversarProcesoLiquidacion;
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
		
		
		this.setMostraridProcesoLiquidacion(esInicial);
		this.setMostrarfechaProcesoLiquidacion(esInicial);
		this.setMostrares_reversarProcesoLiquidacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoLiquidacionConstantesFunciones.ID)) {
				this.setMostraridProcesoLiquidacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoLiquidacionConstantesFunciones.FECHA)) {
				this.setMostrarfechaProcesoLiquidacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoLiquidacionConstantesFunciones.ESREVERSAR)) {
				this.setMostrares_reversarProcesoLiquidacion(esAsigna);
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
		
		
		this.setActivaridProcesoLiquidacion(esInicial);
		this.setActivarfechaProcesoLiquidacion(esInicial);
		this.setActivares_reversarProcesoLiquidacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoLiquidacionConstantesFunciones.ID)) {
				this.setActivaridProcesoLiquidacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoLiquidacionConstantesFunciones.FECHA)) {
				this.setActivarfechaProcesoLiquidacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoLiquidacionConstantesFunciones.ESREVERSAR)) {
				this.setActivares_reversarProcesoLiquidacion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoLiquidacionBeanSwingJInternalFrame procesoliquidacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoLiquidacion(esInicial);
		this.setResaltarfechaProcesoLiquidacion(esInicial);
		this.setResaltares_reversarProcesoLiquidacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoLiquidacionConstantesFunciones.ID)) {
				this.setResaltaridProcesoLiquidacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoLiquidacionConstantesFunciones.FECHA)) {
				this.setResaltarfechaProcesoLiquidacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoLiquidacionConstantesFunciones.ESREVERSAR)) {
				this.setResaltares_reversarProcesoLiquidacion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoLiquidacionBeanSwingJInternalFrame procesoliquidacionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoLiquidacionProcesoLiquidacion=true;

	public Boolean getMostrarBusquedaProcesoLiquidacionProcesoLiquidacion() {
		return this.mostrarBusquedaProcesoLiquidacionProcesoLiquidacion;
	}

	public void setMostrarBusquedaProcesoLiquidacionProcesoLiquidacion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoLiquidacionProcesoLiquidacion= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoLiquidacionProcesoLiquidacion=true;

	public Boolean getActivarBusquedaProcesoLiquidacionProcesoLiquidacion() {
		return this.activarBusquedaProcesoLiquidacionProcesoLiquidacion;
	}

	public void setActivarBusquedaProcesoLiquidacionProcesoLiquidacion(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoLiquidacionProcesoLiquidacion= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoLiquidacionProcesoLiquidacion=null;

	public Border getResaltarBusquedaProcesoLiquidacionProcesoLiquidacion() {
		return this.resaltarBusquedaProcesoLiquidacionProcesoLiquidacion;
	}

	public void setResaltarBusquedaProcesoLiquidacionProcesoLiquidacion(Border borderResaltar) {
		this.resaltarBusquedaProcesoLiquidacionProcesoLiquidacion= borderResaltar;
	}

	public void setResaltarBusquedaProcesoLiquidacionProcesoLiquidacion(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoLiquidacionBeanSwingJInternalFrame procesoliquidacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoLiquidacionProcesoLiquidacion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}